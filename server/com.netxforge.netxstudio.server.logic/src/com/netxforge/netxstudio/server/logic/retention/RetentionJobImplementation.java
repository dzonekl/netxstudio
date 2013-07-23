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

import com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule;
import com.netxforge.netxstudio.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;

/**
 * Implements a job runner for retention logic. Although the logic, supports
 * setting a period, we set it dynamically. Initializes the logic to the default
 * period (2 years). The Add-on model can be configured to have finer control on
 * the aggregation period. See {@link MetricAggregationRule#setPeriod(int) period } setting
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public class RetentionJobImplementation extends JobImplementation {

	private ComponentWorkFlowRun workFlowRun;

	@Override
	public void run() {

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
			final AggregationLogic aggregationLogic = LogicActivator
					.getInstance().getInjector()
					.getInstance(AggregationLogic.class);

			aggregationLogic.setJobMonitor(getRunMonitor());
			{
				aggregationLogic.setRules(rules);
				aggregationLogic.intializeLogic();
				aggregationLogic.runWithoutClosing();
				aggregationLogic.closeLogic();
			}

			this.getRunMonitor().setWorkDone(0); // Reset it's a hack, we need
													// sub monitors for sub
													// tasks!

			// Retention.
			final RetentionLogic retentionLogic = LogicActivator.getInstance()
					.getInjector().getInstance(RetentionLogic.class);

			retentionLogic.setJobMonitor(getRunMonitor());

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

}
