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
package com.netxforge.netxstudio.server.logic.monitoring;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;
import com.netxforge.netxstudio.services.ServiceMonitor;

/**
 * Performs the resource monitoring logic execution for a RFSService.
 * 
 * @author Martin Taal
 */
public abstract class BaseMonitoringLogic extends BaseComponentLogic {

	private ServiceMonitor serviceMonitor;

	@Override
	protected abstract List<NodeType> getNodeTypesToExecuteFor();

	private MonitoringEngine engine;

	@Override
	protected MonitoringEngine getEngine() {
		if (engine == null) {
			engine = LogicActivator.getInstance().getInjector()
					.getInstance(MonitoringEngine.class);
		}
		return engine;
	}

	@Override
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
				getJobMonitor().incrementProgress(0, (cnt++ % 10) == 0);
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
					getJobMonitor().incrementProgress(0, (cnt++ % 10) == 0);
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

	public ServiceMonitor getServiceMonitor() {
		return serviceMonitor;
	}

	public void setServiceMonitor(ServiceMonitor serviceMonitor) {
		this.serviceMonitor = serviceMonitor;
	}
}
