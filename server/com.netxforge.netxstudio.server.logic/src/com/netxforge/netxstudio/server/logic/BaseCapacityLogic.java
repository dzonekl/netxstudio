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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

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
import com.netxforge.netxstudio.server.job.WorkFlowRunMonitor;

/**
 * Performs the capacity logic execution for a RFSService.
 * 
 * @author Martin Taal
 */
public abstract class BaseCapacityLogic {

	private WorkFlowRunMonitor jobMonitor;

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
		jobMonitor.setTask("Computing Capacity Data");
		
		for (final NodeType nodeType : nodeTypes) {

			jobMonitor.appendToLog("Computing for node (type) " + ((Node)nodeType.eContainer()).getNodeID());

			jobMonitor.setTask("Computing Capacity Data for nodeType");
			processNode(nodeType);
		}
		if (!getFailures().isEmpty()) {
			final ExpressionWorkFlowRun run = (ExpressionWorkFlowRun) dataProvider
					.getTransaction().getObject(
							jobMonitor.getWorkFlowRunId());
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
			cnt += countChildEquipments(nodeType.getEquipments());
			cnt += countChildFunctions(nodeType.getFunctions());
		}
		return cnt;
	}

	protected int countChildEquipments(EList<Equipment> equipments) {
		int cnt = 0;
		for (final Equipment equipment : equipments) {
			cnt++;
			cnt += countChildEquipments(equipment.getEquipments());
		}
		return cnt;
	}

	protected int countChildFunctions(EList<Function> functions) {
		int cnt = 0;
		for (final Function function : functions) {
			cnt++;
			cnt += countChildFunctions(function.getFunctions());
		}
		return cnt;
	}

	protected void executeFor(Component component) {
		jobMonitor
				.setTask("Computing Capacity Data for " + component.getName());
		jobMonitor.incrementProgress(1, false);
		final CapacityLogicEngine capacityLogic = LogicActivator.getInstance()
				.getInjector().getInstance(CapacityLogicEngine.class);
		capacityLogic.setComponent(component);
		capacityLogic.setDataProvider(dataProvider);
		capacityLogic.setRange(getTimeRange());
		capacityLogic.execute();
		if (capacityLogic.getFailure() != null) {
			failures.add(capacityLogic.getFailure());
		}
	}

	protected void processNode(NodeType nodeType) {
		int cnt = 0;
		{
			final Set<Equipment> leafEquipments = new HashSet<Equipment>();
			getLeafEquipments(nodeType.getEquipments(), leafEquipments);
			Set<Equipment> executeFor = leafEquipments;
			while (!executeFor.isEmpty()) {
				final Set<Equipment> newExecuteFor = new HashSet<Equipment>();
				for (final Equipment equipment : executeFor) {
					executeFor(equipment);
					if (equipment.eContainer() instanceof Equipment
							&& !newExecuteFor.contains(equipment.eContainer())) {
						newExecuteFor.add((Equipment) equipment.eContainer());
					}
					executeFor = newExecuteFor;
				}
				jobMonitor.incrementProgress(0, (cnt++ % 10) == 0);
			}
		}
		{
			final Set<Function> leafFunctions = new HashSet<Function>();
			getLeafFunctions(nodeType.getFunctions(), leafFunctions);
			Set<Function> executeFor = leafFunctions;
			while (!executeFor.isEmpty()) {
				final Set<Function> newExecuteFor = new HashSet<Function>();
				for (final Function function : executeFor) {
					executeFor(function);
					if (function.eContainer() instanceof Function
							&& !newExecuteFor.contains(function.eContainer())) {
						newExecuteFor.add((Function) function.eContainer());
					}
					executeFor = newExecuteFor;
					jobMonitor.incrementProgress(0, (cnt++ % 10) == 0);
				}
			}
		}
	}

	private void getLeafEquipments(List<Equipment> equipments,
			Set<Equipment> leafEquipments) {
		for (final Equipment equipment : equipments) {
			if (equipment.getEquipments().isEmpty()) {
				leafEquipments.add(equipment);
			} else {
				getLeafEquipments(equipment.getEquipments(), leafEquipments);
			}
		}
	}

	private void getLeafFunctions(List<Function> functions,
			Set<Function> leafFunctions) {
		for (final Function function : functions) {
			if (function.getFunctions().isEmpty()) {
				leafFunctions.add(function);
			} else {
				getLeafFunctions(function.getFunctions(), leafFunctions);
			}
		}
	}

	public WorkFlowRunMonitor getJobMonitor() {
		return jobMonitor;
	}

	public void setJobMonitor(WorkFlowRunMonitor jobMonitor) {
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

}
