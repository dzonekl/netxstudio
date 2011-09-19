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
import com.netxforge.netxstudio.scheduling.RFSServiceRetentionJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.Activator;
import com.netxforge.netxstudio.server.job.JobImplementation;

/**
 * Implements a job runner for a metric source.
 * 
 * @author Martin Taal
 */
public class RetentionJobImplementation extends JobImplementation {

	private ComponentWorkFlowRun workFlowRun;

	@Override
	public void run() {
		Resource res = this.getDataProvider().getResource(MetricsPackage.Literals.METRIC_RETENTION_RULES);
		if(res.getContents().size() == 1){
			final RFSServiceRetentionJob retentionJob = (RFSServiceRetentionJob) getJob();
			final RetentionLogic retentionLogic = Activator.getInstance()
					.getInjector().getInstance(RetentionLogic.class);
			retentionLogic.setRfsService(retentionJob.getRFSService().cdoID());
			retentionLogic.setJobMonitor(getRunMonitor());
			MetricRetentionRules rules = (MetricRetentionRules) res.getContents().get(0);
			retentionLogic.setRules(rules);
			retentionLogic.run();
			getDataProvider().commitTransaction();
		}else{
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
