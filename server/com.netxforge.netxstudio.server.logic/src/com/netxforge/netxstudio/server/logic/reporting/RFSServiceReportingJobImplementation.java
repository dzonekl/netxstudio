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
package com.netxforge.netxstudio.server.logic.reporting;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.RFSServiceReporterJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.logic.LogicActivator;
import com.netxforge.netxstudio.services.Service;

/**
 * Implements a job runner for a metric source.
 * 
 * @author Martin Taal
 */
public class RFSServiceReportingJobImplementation extends JobImplementation {

	private ComponentWorkFlowRun workFlowRun;

	@Override
	public void run() {
		final RFSServiceReporterJob reporterJob = (RFSServiceReporterJob) getJob();

		{
			final OperatorReportingLogic logic = LogicActivator.getInstance()
					.getInjector()
					.getInstance(RFSServiceSummaryReportingLogic.class);

			logic.setServices(Lists.newArrayList((Service)reporterJob.getRFSService()));
			logic.setJobMonitor(getRunMonitor());
			logic.initializeReportingLogic();
			logic.run();
		}

		{
			final OperatorReportingLogic logic = LogicActivator.getInstance()
					.getInjector()
					.getInstance(RFSServiceDashboardReportingLogic.class);

			logic.setServices(Lists.newArrayList((Service)reporterJob.getRFSService()));
			logic.setJobMonitor(getRunMonitor());
			logic.initializeReportingLogic();
			logic.run();
		}
		// generateContent(resourceReportingLogic.getSettings().getExportPath());

		// getDataProvider().commitTransaction();
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
