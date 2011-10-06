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

import org.eclipse.emf.common.util.URI;

import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.OperatorReporterJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.logic.BaseLogic;
import com.netxforge.netxstudio.server.logic.BasePeriodLogic;

/**
 * Implements a job runner for a metric source.
 * 
 * @author Martin Taal
 */
public class OperatorReportingJobImplementation extends JobImplementation {

	private ComponentWorkFlowRun workFlowRun;

	@Override
	public void run() {

		URI folderURI = null;
		final OperatorReporterJob reporterJob = (OperatorReporterJob) getJob();
		for (final BaseLogic reportingLogic : ReportingService
				.getOperatorReportingLogos()) {

			reportingLogic.setJobMonitor(getRunMonitor());

			if (reportingLogic instanceof BasePeriodLogic) {

				// The period should be calculated, but which service to use as
				// the service monitor will vary for different periods.
				// FIXME, We use the first service, there is no additional
				// criteria to use here..
				// SHOULD BE SETTING SOMEWHERE.
				
				// Based on discussion with Willem, we should use the expansion time 
				// of the resources to determine the period. 
				
				if (reporterJob.getOperator().getServices().size() > 0) {
					((BasePeriodLogic) reportingLogic)
							.calculatePeriod(reporterJob.getOperator()
									.getServices().get(0));
				}
			}

			// Set Operator specific.
			if (reportingLogic instanceof OperatorReportingLogic) {
				if (folderURI == null) {
					folderURI = ((OperatorReportingLogic) reportingLogic)
							.folderURI();
				}
				((OperatorReportingLogic) reportingLogic)
						.setServices(reporterJob.getOperator().getServices());
				((OperatorReportingLogic) reportingLogic)
						.initializeStream(folderURI);
			}

			reportingLogic.run();

		}
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
