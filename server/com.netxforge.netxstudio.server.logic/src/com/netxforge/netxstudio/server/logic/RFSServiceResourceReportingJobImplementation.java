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
package com.netxforge.netxstudio.server.logic;

import com.netxforge.netxstudio.scheduling.RFSServiceJob;
import com.netxforge.netxstudio.scheduling.ReporterJob;
import com.netxforge.netxstudio.server.Activator;
import com.netxforge.netxstudio.server.job.JobImplementation;

/**
 * Implements a job runner for a metric source.
 * 
 * @author Martin Taal
 */
public class RFSServiceResourceReportingJobImplementation extends JobImplementation {

//	private ExpressionWorkFlowRun workFlowRun;

	@Override
	public void run() {
		final ReporterJob reporterJob = (ReporterJob) getJob();
		
		
		final RFSServiceResourceReportingLogic resourceReportingLogic = Activator.getInstance()
				.getInjector().getInstance(RFSServiceResourceReportingLogic.class);
		
		resourceReportingLogic.setRfsService(reporterJob.getRFSService().cdoID());
		resourceReportingLogic.setJobMonitor(getRunMonitor());
		resourceReportingLogic.initializeServiceMonitor();
		resourceReportingLogic.run();
		
		
		getDataProvider().commitTransaction();
	}
	
	
	// TODO, We likely don't need a specific run implementation. 
	
//	@Override
//	public WorkFlowRun createWorkFlowRunInstance() {
//		if (workFlowRun == null) {
//			workFlowRun = SchedulingFactory.eINSTANCE
//					.createExpressionWorkFlowRun();
//		}
//		return workFlowRun;
//	}

}
