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

import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOInvalidationPolicy;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.net4j.util.container.IElementProcessor;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
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
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.ServerModule;

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
		instance.activate();
		instance.initialize();
	}

	static void deActivate() {
		instance.deActivateInstance();
		instance = null;
	}

	@Inject
	@Server
	private IDataProvider dataProvider;
	private Scheduler scheduler;

	public synchronized void initialize() {
		dataProvider.openSession();
		final CDOTransaction transaction = dataProvider.getTransaction();
		final Resource jobResource = dataProvider
				.getResource(SchedulingPackage.eINSTANCE.getJob());
		transaction.options().setInvalidationNotificationEnabled(true);
		transaction.options().setInvalidationPolicy(
				CDOInvalidationPolicy.DEFAULT);
		jobResource.eAdapters().add(new JobChangeListener());
		for (final EObject eObject : jobResource.getContents()) {
			eObject.eAdapters().add(new JobChangeListener());
		}
		try {
			scheduler.clear();
		} catch (final Exception e) {
			// TODO: do some form of logging but don't stop
			e.printStackTrace(System.err);
		}

		// now initialize quartz
		for (final EObject eObject : jobResource.getContents()) {
			final Job job = (Job) eObject;

			if (job.getJobState() == JobState.IN_ACTIVE) {
				continue;
			}

			final JobDataMap map = new JobDataMap();
			map.put(NetxForgeJob.JOB_PARAMETER, job);

			final String jobIdentity = job.cdoID().toString();

			final JobDetail jobDetail = JobBuilder.newJob(NetxForgeJob.class)
					.withIdentity(jobIdentity).withDescription(job.getName())
					.usingJobData(map).build();
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder
					.newTrigger()
					.withIdentity(jobIdentity);
			if (job.getStartTime() != null) {
				triggerBuilder = triggerBuilder.startAt(job.getStartTime().toGregorianCalendar().getTime());
			} else {
				triggerBuilder = triggerBuilder.startNow();
			}
			final SimpleScheduleBuilder scheduleBuilder;
			if (job.getEndTime() != null) {
				triggerBuilder.endAt(job.getEndTime().toGregorianCalendar().getTime());				
				scheduleBuilder = SimpleScheduleBuilder.simpleSchedule();				
			} else if (job.getRepeat() > 0){
				scheduleBuilder = SimpleScheduleBuilder.repeatSecondlyForTotalCount(job.getRepeat(), job.getInterval() > 10 ? job.getInterval() : 10);
			} else if (job.getInterval() > 10) {
				scheduleBuilder = SimpleScheduleBuilder.repeatSecondlyForever(job.getInterval());				
			} else {
				scheduleBuilder = SimpleScheduleBuilder.repeatSecondlyForever(10);				
			}
			final Trigger trigger = triggerBuilder.withSchedule(scheduleBuilder).build();
			try {
				scheduler.scheduleJob(jobDetail, trigger);
			} catch (final Exception e) {
				// TODO do some form of logging but don't stop everything
				e.printStackTrace(System.err);
			}
		}
	}

	private void activate() {
		try {
			ServerModule.getInjector().injectMembers(this);

			scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		}
	}

	private void deActivateInstance() {
		try {
			scheduler.shutdown();

			dataProvider.rollbackTransaction();
			dataProvider.closeSession();

		} catch (final Exception e) {
			throw new IllegalStateException(e);
		}
	}

	private synchronized void reinitialize() {
		dataProvider.rollbackTransaction();
		dataProvider.closeSession();
		initialize();
	}

	private class JobChangeListener implements Adapter {
		private Notifier target;

		@Override
		public void notifyChanged(Notification notification) {
			JobHandler.this.reinitialize();
		}

		@Override
		public Notifier getTarget() {
			return target;
		}

		@Override
		public void setTarget(Notifier newTarget) {
			target = newTarget;
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type instanceof Job || type instanceof Resource;
		}

	}

	public static class Initializer implements IElementProcessor {

		@Override
		public Object process(IManagedContainer container, String productGroup,
				String factoryType, String description, Object element) {
			if (element instanceof IRepository) {
				final IRepository repository = (IRepository) element;
				container.addListener(new IListener() {
					@Override
					public void notifyEvent(IEvent arg0) {
//						System.err.println(arg0.getSource());
//						System.err.println(arg0.toString());
//						JobHandler.createAndInitialize();
					}
				});
			}
//			System.err.println(element.toString());
			return element;
		}
	}

}
