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

import com.netxforge.netxstudio.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.internal.ServerActivator;
import com.netxforge.netxstudio.server.job.JobImplementation;

/**
 * Implements a job runner for retention logic. 
 * Although the logic, supports setting a period, we set it dynamically. 
 * 
 * 
 * @author Martin Taal
 */
public class RetentionJobImplementation extends JobImplementation {

	private ComponentWorkFlowRun workFlowRun;

	@Override
	public void run() {
		Resource res = this.getDataProvider().getResource(
				MetricsPackage.Literals.METRIC_RETENTION_RULES);
		if (res.getContents().size() == 1) {
			final RetentionLogic retentionLogic = ServerActivator.getInstance()
					.getInjector().getInstance(RetentionLogic.class);
			retentionLogic.setJobMonitor(getRunMonitor());
			MetricRetentionRules rules = (MetricRetentionRules) res
					.getContents().get(0);
			retentionLogic.setRules(rules);
			retentionLogic.intializeRentionLogic(); // Set an evaluation period. 
			retentionLogic.runWithoutClosing();
			retentionLogic.close();
			getDataProvider().commitTransaction();
		} else {
			// No rules, data corruption...?
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
