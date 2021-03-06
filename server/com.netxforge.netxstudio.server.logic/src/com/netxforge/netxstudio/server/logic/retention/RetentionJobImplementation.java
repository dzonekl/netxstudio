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
 * Contributors: 
 * 	Martin Taal - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.logic.retention;

import org.eclipse.emf.ecore.resource.Resource;

import com.netxforge.netxstudio.common.context.FixedPeriodStrategy;
import com.netxforge.netxstudio.common.context.IPeriodStrategy;
import com.netxforge.netxstudio.common.context.LatestTimestampForRangeStrategy;
import com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule;
import com.netxforge.netxstudio.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.job.NetxForgeJob;
import com.netxforge.netxstudio.server.logic.QuartzInterruptableLogic;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;

/**
 * Implements a job runner for retention logic. Although the logic, supports
 * setting a period, we set it dynamically. Initializes the logic to the default
 * period (2 years). The Add-on model can be configured to have finer control on
 * the aggregation period. See {@link MetricAggregationRule#setPeriod(int)
 * period } setting
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public class RetentionJobImplementation extends JobImplementation {

	private ComponentWorkFlowRun workFlowRun;

	@Override
	public void run() {

		// An abstraction so our logic can be notified of interruptions.
		NetxForgeJob quartzJob = this.getNetxForgeJob();
		QuartzInterruptableLogic quartzInterruptableLogic = new QuartzInterruptableLogic();
		quartzInterruptableLogic.setQuartzInterruptableJob(quartzJob);

		// FIXME We should really set the ID of the rules object, and let the
		// logic
		// DataProvider create it's own.
		// Here, it's read only, so should be Ok.

		Resource res = this.getDataProvider().getResource(
				MetricsPackage.Literals.METRIC_RETENTION_RULES);

		if (res.getContents().size() == 1) {

			final MetricRetentionRules rules = (MetricRetentionRules) res
					.getContents().get(0);

			// Aggregation
			final AddonAggregationLogic aggregationLogic = LogicActivator
					.getInstance().getInjector()
					.getInstance(AddonAggregationLogic.class);
			
			aggregationLogic.setPeriodStrategy(this.getAggregationStrategy());

			aggregationLogic.setJobMonitor(getRunMonitor());
			aggregationLogic.setInterruptable(quartzInterruptableLogic);
			{
				aggregationLogic.setRules(rules);
				aggregationLogic.intializeLogic();
				aggregationLogic.runWithoutClosing();
				aggregationLogic.closeLogic();
			}

			// Check for interruption.
			if (quartzJob.isInterruptRequested()) {
				return;
			}

			// Reset it's a hack, we need sub monitors for sub tasks!

			this.getRunMonitor().setWorkDone(0);

			// Retention.
			final AddonRetentionLogic retentionLogic = LogicActivator.getInstance()
					.getInjector().getInstance(AddonRetentionLogic.class);

			retentionLogic.setJobMonitor(getRunMonitor());
			retentionLogic.setInterruptable(quartzInterruptableLogic);

			{
				retentionLogic.setRules(rules);
				retentionLogic.intializeRentionLogic(); // Set an evaluation
														// period.
				retentionLogic.runWithoutClosing();

				// This will change the status, FIXME, Allow the monitor to
				// restart.
				retentionLogic.close();

			}

		} else {
			// No rules or more rules..., data corruption...?
		}
	}

	@Override
	public WorkFlowRun createWorkFlowRunInstance() {
		if (workFlowRun == null) {
			workFlowRun = SchedulingFactory.eINSTANCE
					.createComponentWorkFlowRun();
		}
		return workFlowRun;
	}

	/**
	 * An aggregation strategy which winds back a period and re-writes all
	 * aggregation values for this period, checking all existing values for this
	 * period.
	 */
	static final int FIXED_PERIOD_WRITE_ALL_AGGREGATION = 100;

	/**
	 * An aggregation strategy which looks for the latest aggregated value, find
	 * the begin of the period for the target range for this last value.
	 */
	static final int LAST_VALUE_NOCHECK_AGGREGATION = 200;

	private int aggregationStrategy = LAST_VALUE_NOCHECK_AGGREGATION;

	private IPeriodStrategy getAggregationStrategy() {

		switch (aggregationStrategy) {
		case FIXED_PERIOD_WRITE_ALL_AGGREGATION: {
			return new FixedPeriodStrategy();
		}
		case LAST_VALUE_NOCHECK_AGGREGATION: {
			return new LatestTimestampForRangeStrategy();
		}
		}
		return null;

	}
}
