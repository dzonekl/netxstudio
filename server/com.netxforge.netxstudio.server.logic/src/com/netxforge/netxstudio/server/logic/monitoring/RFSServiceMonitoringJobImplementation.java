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
package com.netxforge.netxstudio.server.logic.monitoring;

import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.internal.ServerActivator;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.logic.profile.RFSServiceProfileLogic;
import com.netxforge.netxstudio.services.RFSService;

/**
 * Implements a job runner for an RFSService. 
 * It first runs monitoring over all elements of the service, then it runs 
 * the logic over the service users. 
 * 
 * 
 * @author Martin Taal
 */
public class RFSServiceMonitoringJobImplementation extends JobImplementation {

	private ComponentWorkFlowRun workFlowRun;

	@Override
	public void run() {
		final RFSServiceMonitoringJob serviceJob = (RFSServiceMonitoringJob) getJob();
		RFSService rfsService = serviceJob.getRFSService();
		if(rfsService == null){
			return; // return silently. 
		}
		
		// Iterates over Nodes (By NodeType).
		// Chop the period on monthly chunks. 
		
		
		final RFSServiceMonitoringLogic resourceMonitoringLogic = ServerActivator.getInstance()
				.getInjector().getInstance(RFSServiceMonitoringLogic.class);
		resourceMonitoringLogic.setRfsService(serviceJob.getRFSService().cdoID());
		resourceMonitoringLogic.setJobMonitor(getRunMonitor());
		resourceMonitoringLogic.initializeMonitoringLogic();
		resourceMonitoringLogic.run();
		
		// Iterates over Service Users 
		final RFSServiceProfileLogic resourceProfileLogic = ServerActivator.getInstance()
				.getInjector().getInstance(RFSServiceProfileLogic.class);
		resourceProfileLogic.setRfsService(rfsService.cdoID());
		resourceProfileLogic.setJobMonitor(getRunMonitor());
		resourceProfileLogic.initializeProfileLogic();
		
		// Profile Logic Period not set. 
		// Disable resourceProfileLogic.run();
		
		getDataProvider().commitTransaction();
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
