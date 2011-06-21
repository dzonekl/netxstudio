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

import com.netxforge.netxstudio.scheduling.ExpressionWorkFlowRun;
import com.netxforge.netxstudio.scheduling.RFSServiceJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.Activator;
import com.netxforge.netxstudio.server.job.JobImplementation;

/**
 * Implements a job runner for a metric source.
 * 
 * @author Martin Taal
 */
public class RFSServiceJobImplementation extends JobImplementation {

	private ExpressionWorkFlowRun workFlowRun;
	
	@Override
	public void run() {
		getDataProvider().openSession();
		getDataProvider().getTransaction();

		workFlowRun = SchedulingFactory.eINSTANCE.createExpressionWorkFlowRun();
		
		final RFSServiceJob serviceJob = (RFSServiceJob) getJob();

		final RFSServiceCapacityLogic capacityLogic = Activator.getInstance()
				.getInjector().getInstance(RFSServiceCapacityLogic.class);
		capacityLogic.setDataProvider(getDataProvider());
		capacityLogic.setRfsService(serviceJob.getRFSService());
		capacityLogic.setJobMonitor(getJobMonitor());
		capacityLogic.run();
		if (!capacityLogic.getFailures().isEmpty()) {
			workFlowRun.getFailureRefs().addAll(capacityLogic.getFailures());
		}
		getDataProvider().commitTransaction();
	}
	
	@Override
	public WorkFlowRun createWorkFlowRunInstance() {
		return workFlowRun;
	}

}
