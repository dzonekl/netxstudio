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

import java.util.ArrayList;
import java.util.List;

import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.scheduling.ComponentFailure;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.server.logic.BasePeriodLogic;

/**
 * Common code for all logic implementations.
 * 
 * @author Martin Taal
 */
public abstract class BaseComponentLogic extends BasePeriodLogic {

	protected void doRun() {
		// get a transaction, if we didn't create it, we shouldn't close t. 
//		this.getDataProvider().getTransaction();
		final List<NodeType> nodeTypes = getNodeTypesToExecuteFor();
		
		
		// Note: The total work is not linear to the number of components, 
		// components which have expressions will take more time. 
		this.getJobMonitor().setTotalWork(countComponents(nodeTypes));
		this.getJobMonitor().setTask("Performing resource monitoring");

		for (final NodeType nodeType : nodeTypes) {

			getJobMonitor().appendToLog(
					"processing node (type) "
							+ ((Node) nodeType.eContainer()).getNodeID());

			getJobMonitor().setTask("Processing for nodeType");
			processNode(nodeType);
		}
		if (!getFailures().isEmpty()) {
			final ComponentWorkFlowRun run = (ComponentWorkFlowRun) this
					.getDataProvider().getTransaction()
					.getObject(this.getJobMonitor().getWorkFlowRunId());
			for (Failure f : getFailures()) {
				run.getFailureRefs().add(f);
			}

		}
		// Commit and close. 
		
//		this.getDataProvider().cocommitTransaction();
//		this.getDataProvider().closeSession();
	}

	protected abstract List<NodeType> getNodeTypesToExecuteFor();


	protected int countComponents(List<NodeType> nodeTypes) {
		int cnt = 0;
		for (final NodeType nodeType : nodeTypes) {
			cnt += getComponents(nodeType).size();
		}
		return cnt;
	}

	protected void executeFor(Component component) {
		
		this.getJobMonitor().setTask("Computing for " + component.getName());
		
		this.getJobMonitor().incrementProgress(1, ( this.getJobMonitor().getProgress() & 5 ) == 0);
		
		final BaseComponentEngine engine = (BaseComponentEngine) getEngine();
		engine.setJobMonitor(getJobMonitor());
		engine.setComponent(component);
		engine.setDataProvider(this.getDataProvider());
		engine.setPeriod(getPeriod());
		engine.execute();
		if (engine.getFailures().size() > 0) {
			for (final Failure failure : engine.getFailures()) {
				if (failure instanceof ComponentFailure) {
					((ComponentFailure) failure).setComponentRef(component);
				}
				this.getFailures().add(failure);
			}
		}
	}

	protected abstract void processNode(NodeType nodeType);

	
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
