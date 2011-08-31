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
 * Contributors: Martin Taal - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.scheduling.ExpressionFailure;
import com.netxforge.netxstudio.scheduling.ExpressionWorkFlowRun;
import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.job.ServerWorkFlowRunMonitor;

/**
 * Common code for all logic implementations.
 * 
 * @author Martin Taal
 */
public abstract class BaseLogic {

	private ServerWorkFlowRunMonitor jobMonitor;

	@Inject
	@Server
	private IDataProvider dataProvider;

	private Date startTime;
	private Date endTime;

	@Inject
	private ModelUtils modelUtils;

	private DateTimeRange timeRange;

	private List<ExpressionFailure> failures = new ArrayList<ExpressionFailure>();

	public void run() {
		try {
			doRun();
			if (getFailures().isEmpty()) {
				jobMonitor.setFinished(JobRunState.FINISHED_SUCCESSFULLY, null);
			} else {
				jobMonitor.setFinished(JobRunState.FINISHED_WITH_ERROR, null);
			}
		} catch (final Throwable t) {
			jobMonitor.setFinished(JobRunState.FINISHED_WITH_ERROR, t);
		}
	}

	protected void doRun() {
		// start a transaction
		dataProvider.getTransaction();
		final List<NodeType> nodeTypes = getNodeTypesToExecuteFor();

		jobMonitor.setTotalWork(countComponents(nodeTypes));
		jobMonitor.setTask("Performing resource monitoring");

		for (final NodeType nodeType : nodeTypes) {

			jobMonitor.appendToLog("Computing for node (type) "
					+ ((Node) nodeType.eContainer()).getNodeID());

			jobMonitor.setTask("Resource monitoring Data for nodeType");
			processNode(nodeType);
		}
		if (!getFailures().isEmpty()) {
			final ExpressionWorkFlowRun run = (ExpressionWorkFlowRun) dataProvider
					.getTransaction().getObject(jobMonitor.getWorkFlowRunId());
			run.getFailureRefs().addAll(getFailures());
		}
		dataProvider.commitTransaction();
	}

	protected abstract List<NodeType> getNodeTypesToExecuteFor();

	protected DateTimeRange getTimeRange() {
		if (timeRange != null) {
			return timeRange;
		}
		timeRange = GenericsFactory.eINSTANCE.createDateTimeRange();
		timeRange.setBegin(getModelUtils().toXMLDate(getStartTime()));
		timeRange.setEnd(getModelUtils().toXMLDate(getEndTime()));
		return timeRange;
	}

	protected int countComponents(List<NodeType> nodeTypes) {
		int cnt = 0;
		for (final NodeType nodeType : nodeTypes) {
			cnt += getComponents(nodeType).size();
		}
		return cnt;
	}

	protected void executeFor(Component component) {
		jobMonitor.setTask("Computing for " + component.getName());
		jobMonitor.incrementProgress(1, false);
		final BaseEngine engine = getEngine();
		engine.setJobMonitor(getJobMonitor());
		engine.setComponent(component);
		engine.setDataProvider(dataProvider);
		engine.setRange(getTimeRange());
		engine.execute();
		if (engine.getFailures().size() > 0) {
			for (final ExpressionFailure failure : engine.getFailures()) {
				failure.setComponentRef(component);
				failures.add(failure);
			}
		}
	}

	protected abstract BaseEngine getEngine();

	protected abstract void processNode(NodeType nodeType);

	public ServerWorkFlowRunMonitor getJobMonitor() {
		return jobMonitor;
	}

	public void setJobMonitor(ServerWorkFlowRunMonitor jobMonitor) {
		this.jobMonitor = jobMonitor;
	}

	public IDataProvider getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public List<ExpressionFailure> getFailures() {
		return failures;
	}

	public ModelUtils getModelUtils() {
		return modelUtils;
	}

	public void setModelUtils(ModelUtils modelUtils) {
		this.modelUtils = modelUtils;
	}

	protected boolean isValidNode(Node node) {
		if (node.getLifecycle() == null) {
			return true;
		}
		final long time = System.currentTimeMillis();
		if (node.getLifecycle().getInServiceDate() != null
				&& node.getLifecycle().getInServiceDate().toGregorianCalendar()
						.getTimeInMillis() > time) {
			return false;
		}
		if (node.getLifecycle().getOutOfServiceDate() != null
				&& node.getLifecycle().getOutOfServiceDate()
						.toGregorianCalendar().getTimeInMillis() < time) {
			return false;
		}
		return true;
	}

	protected List<Component> getComponents(NodeType nodeType) {
		final List<Component> result = new ArrayList<Component>();
		for (final Equipment equipment : nodeType.getEquipments()) {
			getComponents(equipment, result);
		}
		for (final Function function : nodeType.getFunctions()) {
			getComponents(function, result);
		}
		return result;
	}

	private void getComponents(Equipment equipment, List<Component> result) {
		result.add(equipment);
		for (final Equipment childEquipment : equipment.getEquipments()) {
			getComponents(childEquipment, result);
		}
	}

	private void getComponents(Function function, List<Component> result) {
		result.add(function);
		for (final Function childFunction : function.getFunctions()) {
			getComponents(childFunction, result);
		}
	}

}
