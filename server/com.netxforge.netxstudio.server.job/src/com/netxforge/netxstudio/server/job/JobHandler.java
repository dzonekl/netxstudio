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

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOInvalidationPolicy;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
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
		}

		// TODO: handle start time
		
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
			final SimpleTrigger trigger = TriggerBuilder
					.newTrigger()
					.withIdentity(jobIdentity)
					.startNow()
					.withSchedule(
							SimpleScheduleBuilder
									.simpleSchedule()
									.withIntervalInMinutes(
											(int) job.getInterval())
									.repeatForever()).build();
			try {
				scheduler.scheduleJob(jobDetail, trigger);
			} catch (final Exception e) {
				// TODO do some form of logging but don't stop everything
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
}
