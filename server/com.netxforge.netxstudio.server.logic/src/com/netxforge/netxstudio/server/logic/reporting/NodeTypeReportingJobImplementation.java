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

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.NodeTypeReporterJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.logic.BaseLogic;
import com.netxforge.netxstudio.server.logic.BasePeriodLogic;
import com.netxforge.netxstudio.services.Service;

/**
 * Implements a job runner for a metric source.
 * 
 * @author Martin Taal
 */
public class NodeTypeReportingJobImplementation extends JobImplementation {

	private ComponentWorkFlowRun workFlowRun;

	@Override
	public void run() {

		URI folderURI = null;
		final NodeTypeReporterJob reporterJob = (NodeTypeReporterJob) getJob();

		for (final BaseLogic reportingLogic : ReportingService
				.getOperatorReportingLogos()) {

			reportingLogic.setJobMonitor(getRunMonitor());

			if (reportingLogic instanceof BasePeriodLogic) {

				// The period should be calculated, but which service to use as
				// the service monitor will vary for different periods.
				// FIXME, We use the first service, there is no additional
				// criteria to use here..
				// SHOULD BE SETTING SOMEWHERE.

				// Based on discussion with Willem, we should use the expansion
				// time
				// of the resources to determine the period.

				if (reporterJob.getScopeObject() instanceof Operator) {
					Operator op = (Operator) reporterJob.getScopeObject();
					((BasePeriodLogic) reportingLogic).calculatePeriod(op
							.getServices().get(0));
				} else if (reporterJob.getScopeObject() instanceof Service) {
					Service service = (Service) reporterJob.getScopeObject();
					((BasePeriodLogic) reportingLogic).calculatePeriod(service);
				}

			}

			// Set Operator specific.
			if (reportingLogic instanceof OperatorReportingLogic) {
				if (folderURI == null) {
					folderURI = ((OperatorReportingLogic) reportingLogic)
							.folderURI();
				}

				// Set the services scope depending on... the scope object type.
				if (reporterJob.getScopeObject() instanceof Operator) {
					Operator op = (Operator) reporterJob.getScopeObject();
					((OperatorReportingLogic) reportingLogic).setServices(op
							.getServices());
				} else if (reporterJob.getScopeObject() instanceof Service) {
					Service service = (Service) reporterJob.getScopeObject();
					((OperatorReportingLogic) reportingLogic).setServices(Lists
							.newArrayList(service));
				}
				((OperatorReportingLogic) reportingLogic)
						.setNodeTypeAcceptor(Lists.newArrayList(reporterJob
								.getNodeType()));

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
