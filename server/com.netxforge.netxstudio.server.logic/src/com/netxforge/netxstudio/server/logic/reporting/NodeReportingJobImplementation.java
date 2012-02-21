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

import java.util.List;

import org.eclipse.emf.common.util.URI;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.generics.ExpansionDuration;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.NodeReporterJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.job.JobImplementation;
import com.netxforge.netxstudio.server.logic.BasePeriodLogic;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;

/**
 * Implements a job runner for a metric source.
 * 
 * @author Martin Taal
 */
public class NodeReportingJobImplementation extends JobImplementation {

	private ComponentWorkFlowRun workFlowRun;

	@Override
	public void run() {

		final NodeReporterJob reporterJob = (NodeReporterJob) getJob();
		Node node = reporterJob.getNode();
		if(node == null){
			return; // silent return. 
		}
		NodeResourceReportingLogic reportingLogic = LogicActivator
				.getInstance().getInjector()
				.getInstance(NodeResourceReportingLogic.class);

		URI path = null;

		reportingLogic.setJobMonitor(getRunMonitor());

		// For automatic reports, we use a medium period.
		if (reportingLogic instanceof BasePeriodLogic) {
			reportingLogic.setPeriod(ExpansionDuration.MEDIUM);
		}

		List<Node> nodes = Lists.newArrayList(node);
		reportingLogic.setNodes(nodes);

		// Set Operator specific.
		if (path == null) {
			path = reportingLogic.folderURI();
		}
		reportingLogic.initializeStream(path);
		reportingLogic.run();
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
