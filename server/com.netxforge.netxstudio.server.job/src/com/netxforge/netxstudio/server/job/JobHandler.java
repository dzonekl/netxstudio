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
import java.util.List;

import org.eclipse.emf.cdo.CDOObject;
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
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunContainer;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.ServerUtils;

/**
 * Handles jobs, reads the jobs from the database, initializes quartz and
 * re-initializes if anything changes in the database.
 * 
 * @author Martin Taal
 */
public class JobHandler {

	private static JobHandler instance;

	static void createAndInitialize() {
		instance = new JobHandler();
		Activator.getInstance().createInjector();
		instance.activate();
		instance.initialize();
	}

	static void deActivate() {
		if (instance != null) {
			instance.deActivateInstance();
		}
		instance = null;
	}

	@Inject
	@Server
	private IDataProvider dataProvider;
	private Scheduler scheduler;

	private boolean initializing = false;

	// contains all the ids which are relevant to know when creating
	// removing or updating jobs
	private List<CDOID> relevantIds = new ArrayList<CDOID>();
	private boolean addedListener = false;

	public synchronized void initialize() {
		initializing = true;
		dataProvider.getSession();
		final CDOTransaction transaction = dataProvider.getTransaction();
		final Resource jobResource = dataProvider
				.getResource(SchedulingPackage.eINSTANCE.getJob());
		relevantIds.clear();
		relevantIds.add(((CDOResource) jobResource).cdoID());
		transaction.options().setInvalidationNotificationEnabled(true);
		transaction.options().setInvalidationPolicy(
				CDOInvalidationPolicy.DEFAULT);

		try {
			if (scheduler != null && !scheduler.isShutdown()) {
				scheduler.shutdown(true);
			}
			scheduler = StdSchedulerFactory.getDefaultScheduler();
		} catch (final Exception e) {
			// TODO: do some form of logging but don't stop
			e.printStackTrace(System.err);
		}

		// now initialize quartz
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

				final JobDetail jobDetail = JobBuilder
						.newJob(NetxForgeJob.class).withIdentity(jobIdentity)
						.withDescription(job.getName()).usingJobData(map)
						.build();
				TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder
						.newTrigger().withIdentity(jobIdentity);
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
					scheduleBuilder = SimpleScheduleBuilder
							.repeatSecondlyForever(
									job.getInterval() > 10 ? job.getInterval()
											: 10);
				} else if (job.getRepeat() > 0) {
					scheduleBuilder = SimpleScheduleBuilder
							.repeatSecondlyForTotalCount(job.getRepeat()
									- countJobRuns,
									job.getInterval() > 10 ? job.getInterval()
											: 10);
				} else if (job.getInterval() > 10) {
					scheduleBuilder = SimpleScheduleBuilder
							.repeatSecondlyForever(job.getInterval());
				} else {
					scheduleBuilder = SimpleScheduleBuilder
							.repeatSecondlyForever(10);
				}
				final Trigger trigger = triggerBuilder.withSchedule(
						scheduleBuilder).build();
				scheduler.scheduleJob(jobDetail, trigger);
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
		dataProvider.commitTransaction();

		// do after commit
		if (!addedListener) {
			addedListener = true;
			dataProvider.getSession().addListener(new IListener() {
				public void notifyEvent(org.eclipse.net4j.util.event.IEvent arg0) {
					if (arg0 instanceof CDOSessionInvalidationEvent
							&& !JobHandler.this.initializing) {
						final CDOSessionInvalidationEvent event = (CDOSessionInvalidationEvent) arg0;
						// only check changed objects, in case of:
						// removal: the resource is updated
						// insert: the resource is update
						// update: the job itself is updated
						for (final Object o : event.getChangedObjects()) {
							if (o instanceof CDORevisionKey) {
								final CDORevisionKey key = (CDORevisionKey)o;
								final CDOID cdoId = key.getID();
								if (relevantIds.contains(cdoId)) {
									JobHandler.this.initialize();
									return;
								}
							}
						}
					}
				}
			});
		}
		initializing = false;
	}

	private void activate() {
		Activator.getInstance().getInjector().injectMembers(this);
	}

	private int countJobRuns(Job job) {
		final CDOID cdoId = job.cdoID();
		final Resource resource = dataProvider
				.getResource(SchedulingPackage.eINSTANCE.getJobRunContainer());
		for (final EObject eObject : resource.getContents()) {
			final JobRunContainer container = (JobRunContainer) eObject;
			final Job containerJob = container.getJob();
			final CDOID containerJobId = ((CDOObject) containerJob).cdoID();
			if (cdoId.equals(containerJobId)) {
				return container.getWorkFlowRuns().size();
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
