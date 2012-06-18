/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Martin Taal - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfo;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.revision.CDORevisionKey;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.session.CDOSessionInvalidationEvent;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOInvalidationPolicy;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.net4j.util.container.IElementProcessor;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent.Kind;
import org.eclipse.net4j.util.lifecycle.LifecycleEventAdapter;
import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunContainer;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.ServerUtils;
import com.netxforge.netxstudio.server.job.internal.JobActivator;

/**
 * Handles jobs, reads the jobs from the database, initializes quartz and
 * re-initializes if anything changes in the database.
 * 
 * Provides external API for the OSGI command interpreter.
 * 
 * @author Martin Taal
 */
public class JobHandler {

	private static JobHandler INSTANCE;

	static void createAndInitialize() {
		INSTANCE = new JobHandler();
		JobActivator.getInstance().createInjector();
		INSTANCE.activate();
		INSTANCE.initialize();
	}

	public static void deActivate() {
		if (INSTANCE != null) {
			INSTANCE.deActivateInstance();
		}
		INSTANCE = null;
	}

	/**
	 * Start the scheduler.
	 */
	public static void status() {
		status(null);
	}

	public static void status(CommandInterpreter interpreter) {
		if (INSTANCE != null) {
			if (interpreter != null) {
				interpreter.println(INSTANCE.statusScheduler());
			} else {
				System.out.println(INSTANCE.statusScheduler());
			}
		}
	}

	/**
	 * Start the scheduler.
	 */
	public static void start() {
		start(null);
	}

	public static void start(CommandInterpreter interpreter) {
		if (INSTANCE != null) {
			if (interpreter != null) {
				interpreter.println(INSTANCE.startScheduler());
			} else {
				System.out.println(INSTANCE.startScheduler());
			}
		}
	}

	/**
	 * Stop the scheduler.
	 */
	public static void stop() {
		stop(null);
	}

	public static void stop(CommandInterpreter interpreter) {
		if (INSTANCE != null) {
			if (interpreter != null) {
				interpreter.println(INSTANCE.stopScheduler());
			} else {
				System.out.println(INSTANCE.stopScheduler());
			}
		}
	}

	/**
	 * Clean job data
	 */
	public static void clean() {
		// TODO Implement, should clean the WorkFlowMonitor data.
	}

	/**
	 * list the scheduled jobs to System.out
	 */
	public static void list() {
		list(null);
	}

	public static void list(CommandInterpreter interpreter) {
		if (interpreter != null && INSTANCE != null) {
			interpreter.println(INSTANCE.listScheduler());
		} else {
			System.out.println(INSTANCE.listScheduler());
		}
	}

	/**
	 * Pause all jobs.
	 */
	public static void pauseAll() {
		pauseAll(null);
	}

	public static void pauseAll(CommandInterpreter interpreter) {
		if (interpreter != null && INSTANCE != null) {
			interpreter.println(INSTANCE.pauseAllScheduler());
		}
	}

	/**
	 * Resume all jobs
	 */
	public static void resumeAll() {
		resumeAll(null);
	}

	public static void resumeAll(CommandInterpreter interpreter) {
		if (interpreter != null && INSTANCE != null) {
			interpreter.println(INSTANCE.resumeAllScheduler());
		}
	}

	@Inject
	@Server
	private IDataProvider dataProvider;

	// Our quartz scheduler.
	private Scheduler scheduler;

	private boolean initializing = false;

	// contains all the ids which are relevant to know when creating
	// removing or updating jobs
	private List<CDOID> relevantIds = new ArrayList<CDOID>();

	// Map of JobKeys for our CDO Object ID's.
	// private Map<CDOID, JobKey> jobKeysMap = new HashMap<CDOID, JobKey>();

	// Map of TriggerKeys for our CDO Object ID's.
	private Map<CDOID, TriggerKey> triggerKeysMap = new HashMap<CDOID, TriggerKey>();

	private boolean addedListener = false;

	/**
	 * @return the initializing
	 */
	public boolean isInitializing() {
		return initializing;
	}

	private synchronized String statusScheduler() {
		if (isInitializing()) {
			return "Scheduler initializing";
		} else {

			try {
				if (scheduler.isStarted()) {
					if (scheduler.isInStandbyMode()) {
						return "Scheduler is on standby";
					} else {
						return "Scheduler started";
					}
				} else if (scheduler.isShutdown()) {
					return "Scheduler is stopped";
				}
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
		return "Scheduler status unknown";
	}

	private synchronized String startScheduler() {
		waitWhileInitializing();

		StringBuffer sb = new StringBuffer();
		try {
			if (scheduler != null) {
				if (scheduler.isStarted()) {
					if (scheduler.isInStandbyMode()) {
						scheduler.start();
						sb.append("Scheduler started...");
					}else{
						sb.append("Scheduler is started already...");
					}
				}
			} else {
				
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	private synchronized String stopScheduler() {
		waitWhileInitializing();

		StringBuffer sb = new StringBuffer();
		try {
			if (scheduler != null && scheduler.isStarted()) {
				scheduler.standby();
				sb.append("Scheduler stopped (on standby)");
			} else {
				sb.append("Scheduler is stopped already...");
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	private synchronized String listScheduler() {
		waitWhileInitializing();

		StringBuffer sb = new StringBuffer();
		try {
			if (scheduler != null && scheduler.isStarted()) {
				// currently executing jobs.
				sb.append("Current running scheduled jobs = "
						+ scheduler.getCurrentlyExecutingJobs().size());
				for (JobExecutionContext context : scheduler
						.getCurrentlyExecutingJobs()) {
					sb.append(context.toString() + "\n");
				}
				// current triggers.
				sb.append("\nTriggers:");
				List<TriggerKey> keysToRemove = new ArrayList<TriggerKey>();
				for (TriggerKey tKey : triggerKeysMap.values()) {
					if (!scheduler.checkExists(tKey)) {
						keysToRemove.add(tKey);
						continue;
					}
					Trigger trigger = scheduler.getTrigger(tKey);
					sb.append(printTrigger(tKey, trigger));

				}
				for (TriggerKey tKey : keysToRemove) {
					triggerKeysMap.remove(tKey);
				}
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * @param trigger
	 */
	private String printTrigger(TriggerKey tKey, Trigger trigger) {

		// System.out.println(tKey.getName() + " has fired already  " +
		// trigger.get);
		Date nextFireTime = trigger.getNextFireTime();
		return tKey.getName() + " will fire next time " + nextFireTime + "\n";

	}

	/**
	 * Pauzes the scheduler. Any notifications will not be processed while
	 * pauzed.
	 */
	private synchronized String pauseAllScheduler() {
		waitWhileInitializing();

		StringBuffer sb = new StringBuffer();
		if (scheduler != null) {
			try {
				if (scheduler.isStarted()) {
					scheduler.pauseAll();
				} else {
					sb.append("Scheduler is not started");
				}
			} catch (SchedulerException e) {
				e.printStackTrace();

			}
		}
		return sb.toString();
	}

	/**
	 * 
	 */
	private void waitWhileInitializing() {
		while (initializing) {
			try {
				this.wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	private synchronized String resumeAllScheduler() {
		waitWhileInitializing();

		StringBuffer sb = new StringBuffer();
		try {
			scheduler.resumeAll();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return sb.toString();
	};

	public synchronized void initialize() {
		this.initialize(null);
	};

	/**
	 * Called with the repository starts and when an invalidation occurs on
	 */
	public synchronized void initialize(CDOObject change) {

		// monitor, dis-allowing re-entry.
		initializing = true;

		if (JobActivator.DEBUG) {
			JobActivator.TRACE.trace(null,
					"(Re) Initializing jobs, getting a data session");

		}
		dataProvider.getSession();
		final CDOTransaction transaction = dataProvider.getTransaction();
		final Resource jobResource = dataProvider
				.getResource(SchedulingPackage.eINSTANCE.getJob());

		relevantIds.clear();
		triggerKeysMap.clear();

		relevantIds.add(((CDOResource) jobResource).cdoID());
		transaction.options().setInvalidationNotificationEnabled(true);
		transaction.options().setInvalidationPolicy(
				CDOInvalidationPolicy.DEFAULT);

		try {
			if (scheduler != null && !scheduler.isShutdown()) {
				// We force a shutdown of the scheduler when initializing.
				// report any ongoing jobs.
				scheduler.shutdown(true);
			}

			// instantiating the scheduler.
			scheduler = StdSchedulerFactory.getDefaultScheduler();
		} catch (final Exception e) {
			e.printStackTrace(System.err);
		}

		// now initialize quartz jobs, iterating through all available jobs.
		for (final EObject eObject : jobResource.getContents()) {
			try {
				final Job job = (Job) eObject;

				relevantIds.add(job.cdoID());

				if (job.getJobState() == JobState.IN_ACTIVE) {
					continue;
				}
				if (job.isDeleted()) {
					continue;
				}
				final int countJobRuns = countJobRuns(job);
				if (job.getRepeat() > 0 && job.getRepeat() <= countJobRuns) {
					continue;
				}

				final JobDataMap map = new JobDataMap();
				map.put(NetxForgeJob.JOB_PARAMETER, job);

				final String jobIdentity = job.cdoID().toString();

				// Should possible group the jobs byt the type of job it is.
				String jobGroupName = "NetXStudio job";
				if (job instanceof MetricSourceJob) {
					jobGroupName = " Metric source job";
				}

				// The job detail.
				final JobDetail jobDetail = JobBuilder
						.newJob(NetxForgeJob.class)
						.withIdentity(jobIdentity, jobGroupName)
						.withDescription(job.getName()).usingJobData(map)
						.build();

				// Keep a map of CDO job objects and the corresponding quartz
				// job key.
				// jobKeysMap.put(job.cdoID(), jobDetail.getKey());

				Trigger newTrigger = this.createNewTrigger(job, jobIdentity,
						jobGroupName, countJobRuns);

				// Keep a map of CDO job objects and the corresponding quartz
				// trigger key.
				triggerKeysMap.put(job.cdoID(), newTrigger.getKey());

				scheduler.scheduleJob(jobDetail, newTrigger);
			} catch (final Exception e) {
				// TODO do some form of logging but don't stop everything
				e.printStackTrace(System.err);
			}
		}
		try {
			scheduler.start();
		} catch (final Exception e) {
			// TODO do some form of logging but don't stop everything
			e.printStackTrace(System.err);
		}

		// Although we do not commit, force the closing of our transaction here.
		dataProvider.commitTransaction();

		// do after commit
		if (!addedListener) {
			addedListener = true;
			dataProvider.getSession().addListener(new IListener() {
				public void notifyEvent(org.eclipse.net4j.util.event.IEvent arg0) {

					CDOCommitInfo info = null;
					if (arg0 instanceof CDOCommitInfo) {
						info = (CDOCommitInfo) arg0;

						// ignore non client commits, like log commits or server
						// commits.
						if (!info.getComment().equals(
								IDataProvider.CLIENT_COMMIT_COMMENT)) {
							return;
						}

						if (JobActivator.DEBUG) {
							JobActivator.TRACE.trace(null,
									"Session event session="
											+ dataProvider.getSession()
													.getSessionID());
							JobActivator.TRACE.trace(null,
									"Event=" + info.toString());
						}
					}

					// Don't bother if we are pauzed.
					try {
						if (scheduler != null && !scheduler.isStarted()) {
							return;
						}
					} catch (SchedulerException e) {
						e.printStackTrace();
					}

					if (arg0 instanceof CDOSessionInvalidationEvent
							&& !JobHandler.this.initializing) {
						final CDOSessionInvalidationEvent event = (CDOSessionInvalidationEvent) arg0;
						// only check changed objects, in case of:
						// removal: the CDO resource is updated
						// insert: the CDO resource is update
						// update: the job object itself is updated
						for (final Object o : event.getChangedObjects()) {
							if (o instanceof CDORevisionKey) {
								final CDORevisionKey key = (CDORevisionKey) o;
								final CDOID cdoId = key.getID();
								if (relevantIds.contains(cdoId)) {
									JobHandler.this.initialize();
									return;
								}
							}
						}
					} else {
						// When initializing we should wait.
					}
				}
			});
		}
		initializing = false;
	}

	/*
	 * Create a trigger. Set the start time. Set the end time, if any specified.
	 * Set the interval, no smaller then 10 seconds. Set the repeat, considering
	 * the current job runs.
	 */
	private Trigger createNewTrigger(Job job, String jobIdentity,
			String jobGroupName, int countJobRuns) {
		// The trigger for this job.
		TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger()
				.withIdentity(jobIdentity, jobGroupName);

		if (job.getStartTime() != null) {
			triggerBuilder = triggerBuilder.startAt(job.getStartTime()
					.toGregorianCalendar().getTime());
		} else {
			triggerBuilder = triggerBuilder.startNow();
		}
		final SimpleScheduleBuilder scheduleBuilder;
		if (job.getEndTime() != null) {
			triggerBuilder.endAt(job.getEndTime().toGregorianCalendar()
					.getTime());
			scheduleBuilder = SimpleScheduleBuilder.repeatSecondlyForever(job
					.getInterval() > 10 ? job.getInterval() : 10);
		} else if (job.getRepeat() > 0) {
			scheduleBuilder = SimpleScheduleBuilder
					.repeatSecondlyForTotalCount(
							job.getRepeat() - countJobRuns,
							job.getInterval() > 10 ? job.getInterval() : 10);
		} else if (job.getInterval() > 10) {
			scheduleBuilder = SimpleScheduleBuilder.repeatSecondlyForever(job
					.getInterval());
		} else {
			scheduleBuilder = SimpleScheduleBuilder.repeatSecondlyForever(10);
		}
		final Trigger trigger = triggerBuilder.withSchedule(scheduleBuilder)
				.build();
		return trigger;
	}

	/*
	 * Create a trigger. Set the start time. Set the end time, if any specified.
	 * Set the interval, no smaller then 10 seconds. Set the repeat, considering
	 * the current job runs.
	 */
	@SuppressWarnings("unused")
	private Trigger updateTrigger(TriggerBuilder<Trigger> tb, Job job,
			int countJobRuns) {

		// don't manipulate the start time.
		// if (job.getStartTime() != null) {
		// triggerBuilder = triggerBuilder.startAt(job.getStartTime()
		// .toGregorianCalendar().getTime());
		// } else {
		// triggerBuilder = triggerBuilder.startNow();
		// }

		final SimpleScheduleBuilder scheduleBuilder;
		if (job.getEndTime() != null) {
			tb.endAt(job.getEndTime().toGregorianCalendar().getTime());
			scheduleBuilder = SimpleScheduleBuilder.repeatSecondlyForever(job
					.getInterval() > 10 ? job.getInterval() : 10);
		} else if (job.getRepeat() > 0) {
			scheduleBuilder = SimpleScheduleBuilder
					.repeatSecondlyForTotalCount(
							job.getRepeat() - countJobRuns,
							job.getInterval() > 10 ? job.getInterval() : 10);
		} else if (job.getInterval() > 10) {
			scheduleBuilder = SimpleScheduleBuilder.repeatSecondlyForever(job
					.getInterval());
		} else {
			scheduleBuilder = SimpleScheduleBuilder.repeatSecondlyForever(10);
		}
		final Trigger trigger = tb.withSchedule(scheduleBuilder).build();
		return trigger;
	}

	/*
	 * Call when any of the features of the job which affect the trigger is
	 * updated by notification. uses an existing TriggerBuilder to reschedule
	 * the job.
	 */
	@SuppressWarnings("unused")
	private void updateTrigger(Job job) {

		TriggerKey triggerKey = triggerKeysMap.get(job.cdoID());
		if (triggerKey == null) {
			return;
		}

		try {
			if (scheduler != null && !scheduler.isShutdown()) {
				Trigger trigger = scheduler.getTrigger(triggerKey);
				// get the job key.
				JobKey jobKey = trigger.getJobKey();

				// TriggerBuilder<? extends Trigger> triggerBuilder =
				// trigger.getTriggerBuilder();
				// this.updateTrigger(triggerBuilder, job, countJobRuns);
				//
				// scheduler.rescheduleJob(triggerKey, null /* TODO our new
				// trigger */);

			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	private void activate() {
		JobActivator.getInstance().getInjector().injectMembers(this);
	}

	/**
	 * Determine how many times a job has run, based on the entries in the job
	 * runs.
	 * 
	 * @param job
	 * @return
	 */
	private int countJobRuns(Job job) {
		final CDOID cdoId = job.cdoID();
		final Resource resource = dataProvider
				.getResource(SchedulingPackage.eINSTANCE.getJobRunContainer());
		for (final EObject eObject : resource.getContents()) {
			final JobRunContainer container = (JobRunContainer) eObject;
			final Job containerJob = container.getJob();
			// sometimes container doesn't have a job??
			if (containerJob != null) {
				final CDOID containerJobId = ((CDOObject) containerJob).cdoID();
				if (cdoId.equals(containerJobId)) {
					return container.getWorkFlowRuns().size();
				}
			}
		}
		return 0;
	}

	private void deActivateInstance() {
		try {
			scheduler.shutdown();
			dataProvider.closeSession();

		} catch (final Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public static class Initializer implements IElementProcessor {

		public Object process(IManagedContainer container, String productGroup,
				String factoryType, String description, Object element) {
			if (element instanceof IRepository) {
				final IRepository repository = (IRepository) element;
				repository.addListener(new LifecycleEventAdapter() {
					@Override
					public void notifyLifecycleEvent(ILifecycleEvent event) {
						if (event.getKind() == Kind.ACTIVATED) {
							ServerUtils.getInstance().initializeServer(
									repository);
							JobHandler.createAndInitialize();
						}
					}
				});
			}
			return element;
		}
	}

}