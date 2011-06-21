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

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.server.job.JobMonitor;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.ServiceMonitor;
import com.netxforge.netxstudio.services.ServicesFactory;

/**
 * Performs the capacity logic execution for a RFSService.
 * 
 * @author Martin Taal
 */
public class RFSServiceCapacityLogic {

	private JobMonitor jobMonitor;

	private RFSService rfsService;

	// on purpose no @Inject as we need the same instance
	// as used in the job implementation
	private IDataProvider dataProvider;

	private Date startTime;
	private Date endTime;

	@Inject
	private ModelUtils modelUtils;
	
	private ServiceMonitor serviceMonitor;

	public void run() {
		setServiceMonitor();
		
		int count = 0;
		// first go through the leave nodes
		for (final Node node : rfsService.getNodes()) {
			if (isActiveNode(node)) {
				count++;
				processNode(node.getNodeType());
			}
		}

		jobMonitor.setTotalWork(count);
		jobMonitor.setTask("Computing Capacity Data");

		// first go through the leave nodes
		for (final Node node : rfsService.getNodes()) {
			if (isActiveNode(node) && node.getNodeType().isLeafNode()) {
				jobMonitor.setTask("Computing Capacity Data for node "
						+ node.getNodeID());
				processNode(node.getNodeType());
			}
		}
		// and then the other nodes
		for (final Node node : rfsService.getNodes()) {
			if (isActiveNode(node) && !node.getNodeType().isLeafNode()) {
				jobMonitor.setTask("Computing Capacity Data for node "
						+ node.getNodeID());
				processNode(node.getNodeType());
			}
		}
	}

	private void setServiceMonitor() {
		startTime = new Date(0);
		if (!rfsService.getServiceMonitors().isEmpty()) {
			final Date previousEndTime = rfsService.getServiceMonitors()
					.get(rfsService.getServiceMonitors().size() - 1)
					.getPeriod().getEnd().toGregorianCalendar().getTime();
			startTime = new Date(previousEndTime.getTime() + 1);
		}
		endTime = new Date(System.currentTimeMillis());
		
		final DateTimeRange timeRange = GenericsFactory.eINSTANCE.createDateTimeRange();
		timeRange.setBegin(modelUtils.toXMLDate(startTime));
		timeRange.setEnd(modelUtils.toXMLDate(endTime));
		
		serviceMonitor = ServicesFactory.eINSTANCE.createServiceMonitor();
		// what name should a servicemonitor have?
		serviceMonitor.setName(rfsService.getServiceName());
		serviceMonitor.setPeriod(timeRange);
		rfsService.getServiceMonitors().add(serviceMonitor);
	}

	protected void executeForEquipment(Equipment equipment) {
		final CapacityLogicEngine.CapacityLogicEquipment capacityLogic = new CapacityLogicEngine.CapacityLogicEquipment();
		capacityLogic.setEquipment(equipment);
		capacityLogic.setDataProvider(dataProvider);
		capacityLogic.setRange(serviceMonitor.getPeriod());
		capacityLogic.execute();
	}

	protected void executeForFunction(Function function) {
		final CapacityLogicEngine.CapacityLogicFunction capacityLogic = new CapacityLogicEngine.CapacityLogicFunction();
		capacityLogic.setFunction(function);
		capacityLogic.setDataProvider(dataProvider);
		capacityLogic.setRange(serviceMonitor.getPeriod());
		capacityLogic.execute();
	}

	protected void processNode(NodeType nodeType) {
		{
			final Set<Equipment> leafEquipments = new HashSet<Equipment>();
			getLeafEquipments(nodeType.getEquipments(), leafEquipments);
			Set<Equipment> executeFor = leafEquipments;
			while (!executeFor.isEmpty()) {
				final Set<Equipment> newExecuteFor = new HashSet<Equipment>();
				for (final Equipment equipment : executeFor) {
					executeForEquipment(equipment);
					if (equipment.eContainer() instanceof Equipment
							&& !newExecuteFor.contains(equipment.eContainer())) {
						newExecuteFor.add((Equipment) equipment.eContainer());
					}
					executeFor = newExecuteFor;
				}
			}
		}
		{
			final Set<Function> leafFunctions = new HashSet<Function>();
			getLeafFunctions(nodeType.getFunctions(), leafFunctions);
			Set<Function> executeFor = leafFunctions;
			while (!executeFor.isEmpty()) {
				final Set<Function> newExecuteFor = new HashSet<Function>();
				for (final Function function : executeFor) {
					executeForFunction(function);
					if (function.eContainer() instanceof Function
							&& !newExecuteFor.contains(function.eContainer())) {
						newExecuteFor.add((Function) function.eContainer());
					}
					executeFor = newExecuteFor;
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

	private boolean isActiveNode(Node node) {
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

	public JobMonitor getJobMonitor() {
		return jobMonitor;
	}

	public void setJobMonitor(JobMonitor jobMonitor) {
		this.jobMonitor = jobMonitor;
	}

	public RFSService getRfsService() {
		return rfsService;
	}

	public void setRfsService(RFSService rfsService) {
		this.rfsService = rfsService;
	}

	public IDataProvider getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

}
