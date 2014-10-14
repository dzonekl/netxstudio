/*******************************************************************************
 * Copyright (c) 14 okt. 2014 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.oss2.jobs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.Trigger.TriggerState;
import org.quartz.impl.StdSchedulerFactory;

//import com.netxforge.netxstudio.scheduling.Job;
//import com.netxforge.netxstudio.scheduling.JobState;
//import com.netxforge.netxstudio.scheduling.MetricSourceJob;
//import com.netxforge.netxstudio.scheduling.SchedulingPackage;
//import com.netxforge.netxstudio.server.job.NetxForgeJob;
//import com.netxforge.netxstudio.server.job.JobHandler.SCHEDULE;
//import com.netxforge.netxstudio.server.job.internal.JobActivator;

public class QuartzImplementation {

	/* Our quartz scheduler. */
	private Scheduler scheduler;

	/*
	 * A state flag, if we are currently initializing.
	 */
	private boolean initializing = false;

	/*
	 * contains all the UUID which are relevant to know when creating removing
	 * or updating jobs.
	 */
	private List<UUID> relevantIds = new ArrayList<UUID>();

	/*
	 * Map of TriggerKeys for our UUID.
	 */
	private Map<UUID, TriggerKey> triggerKeysMap = new HashMap<UUID, TriggerKey>();

	/**
	 * @return the initializing
	 */
	public boolean isInitializing() {
		return initializing;
	}

	/**
	 * Called with the repository starts and when an invalidation occurs on
	 */
	public synchronized void initialize() {

		// monitor, dis-allowing re-entry.
		initializing = true;

		// TODO Event notifications...
		// Our session, view might not be available....
		// if (view == null || (view != null && !LifecycleUtil.isActive(view)))
		// {
		// // Re-activate.
		// activate();
		// }

		// if (JobActivator.DEBUG) {
		// JobActivator.TRACE.trace(JobActivator.TRACE_JOBS_OPTION,
		// "(Re) Initializing jobs");
		//
		// }

		try {

			// final Resource jobResource = dataProvider.getResource(view,
			// SchedulingPackage.eINSTANCE.getJob());
			//
			// if (jobResource == null) {
			// throw new IllegalStateException(
			// "The Job model data is not available... exiting");
			// }

			relevantIds.clear();
			triggerKeysMap.clear();

			// relevantIds.add(((CDOResource) jobResource).cdoID());

			if (scheduler == null) {
				// Instantiate only once.
				scheduler = StdSchedulerFactory.getDefaultScheduler();
				scheduler.standby();

			} else {
				scheduler.clear();
			}

		} catch (final Exception e) {
			// if (JobActivator.DEBUG) {
			// JobActivator.TRACE.trace(JobActivator.TRACE_JOBS_OPTION,
			// "Error initializing", e);
			// }
		} finally {
			initializing = false;
		}
	}

	public synchronized String statusScheduler() {
		if (isInitializing()) {
			return "Scheduler initializing";
		} else {
			try {
				if (scheduler != null) {
					if (scheduler.isStarted()) {
						if (scheduler.isInStandbyMode()) {
							return "Scheduler is on standby";
						} else {
							return "Scheduler started";
						}
					} else if (scheduler.isShutdown()) {
						return "Scheduler is stopped";
					}
				} else {
					return "Scheduler is not initialized";
				}
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
		return "Scheduler never started";
	}

	public synchronized String startScheduler() {
		if (isInitializing()) {
			return "Currently initializing, sorry";
		}

		StringBuffer sb = new StringBuffer();
		try {
			if (scheduler != null) {
				if (scheduler.isStarted()) {
					if (scheduler.isInStandbyMode()) {
						scheduler.start();
						sb.append("Scheduler started...");
					} else {
						sb.append("Scheduler is started already...");
					}
				} else {
					scheduler.start();
					sb.append("Scheduler started...");
				}
			} else {
				initialize();
				return "The scheduler is now initializing, but this could fail, check with command: job status";
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public synchronized String stopScheduler() {
		if (isInitializing()) {
			return "Currently initializing, sorry";
		}

		StringBuffer sb = new StringBuffer();
		try {
			if (scheduler != null && scheduler.isStarted()) {

				// Interrupt running job.
				// Note: Needs support in a running logic. See AggregationLogic,
				// which supports this now.
				for (JobExecutionContext context : scheduler
						.getCurrentlyExecutingJobs()) {
					JobKey key = context.getJobDetail().getKey();
					scheduler.interrupt(key);
				}

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

	public synchronized String listScheduler() {
		if (isInitializing()) {
			return "Currently initializing, sorry";
		}

		StringBuffer sb = new StringBuffer();
		try {
			if (scheduler != null) {

				// print the scheduler status first.
				sb.append("Current scheduler status=" + statusScheduler()
						+ "\n");

				// currently executing jobs.
				sb.append("Current running scheduled jobs = "
						+ scheduler.getCurrentlyExecutingJobs().size() + "\n");

				for (JobExecutionContext context : scheduler
						.getCurrentlyExecutingJobs()) {
					sb.append("=> Job with ID:"
							+ context.getJobDetail().getDescription() + "\n");
				}

				// current triggers, if the scheduler is stopped, we still have
				// triggers
				// but the date will be wrong.
				sb.append("Current triggers for jobs\n");

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
			} else {
				return "The scheduler is not initialized, try to initialize it with : job start";
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

		StringBuffer sb = new StringBuffer();
		Date nextFireTime = trigger.getNextFireTime();

		try {
			JobDetail detail = scheduler.getJobDetail(trigger.getJobKey());

			sb.append("=> Job with ID: " + detail.getDescription()
					+ " will fire next time " + nextFireTime);
			TriggerState triggerState = scheduler.getTriggerState(tKey);
			sb.append(", state=" + triggerState.name() + "\n");
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}
}
