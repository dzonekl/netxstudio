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

import java.util.Calendar;
import java.util.List;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;
import com.netxforge.netxstudio.services.RFSService;

/**
 * Implements a job runner for an RFSService. It first runs monitoring over all
 * elements of the service, then it runs the logic over the service users.
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
		if (rfsService == null) {
			return; // return silently.
		}

		// Iterates over Nodes (By NodeType).

		// FIXME ! Rework so we inject from own plugin injector.
		final RFSServiceMonitoringLogic resourceMonitoringLogic = LogicActivator
				.getInstance().getInjector()
				.getInstance(RFSServiceMonitoringLogic.class);

		resourceMonitoringLogic.setRfsService(serviceJob.getRFSService()
				.cdoID());
		resourceMonitoringLogic.setJobMonitor(getRunMonitor());

		// Run the monitor for different periods.
		final DateTimeRange defaultLogicPeriod = resourceMonitoringLogic
				.getDefaultLogicPeriod();
		final List<DateTimeRange> periods = resourceMonitoringLogic
				.getModelUtils().periods(defaultLogicPeriod, Calendar.MONTH);

		for (DateTimeRange period : periods) {
			resourceMonitoringLogic.setPeriod(period);
			// Should delete any monitor with the same period.
			resourceMonitoringLogic.initServiceMonitor(period);
			resourceMonitoringLogic.runWithoutClosing();
		}
		resourceMonitoringLogic.close();

		// Iterates over Service Users
		// final RFSServiceProfileLogic resourceProfileLogic = ServerActivator
		// .getInstance().getInjector()
		// .getInstance(RFSServiceProfileLogic.class);
		// resourceProfileLogic.setRfsService(rfsService.cdoID());
		// resourceProfileLogic.setJobMonitor(getRunMonitor());
		// resourceProfileLogic.initializeProfileLogic();
		// Profile Logic Period not set.
		// Disable resourceProfileLogic.run();

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
