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
package com.netxforge.netxstudio.server.logic.retention;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.ecore.resource.Resource;

import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.scheduling.ComponentFailure;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.server.logic.BaseExpressionEngine;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;
import com.netxforge.netxstudio.server.logic.monitoring.BaseComponentEngine;
import com.netxforge.netxstudio.server.logic.monitoring.BaseComponentLogic;
import com.netxforge.netxstudio.services.RFSService;

/**
 * Performs the retention logic for a RFSService, node type or component.
 * 
 * @author Martin Taal
 */
public class RetentionLogic extends BaseComponentLogic {

	private RFSService rfsService;
	private NodeType nodeType;
	private MetricRetentionRules rules;
	
	public void setRules(MetricRetentionRules rules) {
		this.rules = rules;
	}

	private BaseExpressionEngine engine;
	

	@Override
	protected List<NodeType> getNodeTypesToExecuteFor() {
		
		if (rfsService != null) {
			// first go through the leave nodes
			final List<NodeType> nodeTypes = new ArrayList<NodeType>();
			for (final Node node : rfsService.getNodes()) {
				if (getModelUtils().isInService(node)) {
					nodeTypes.add(node.getNodeType());
				}
			}
			return nodeTypes;
		}else{
			return this.allNodes();
		}
	}
	
	
	private List<NodeType> allNodes(){
		Resource operatorResources = this.getDataProvider().getResource(OperatorsPackage.Literals.OPERATOR);
		return this.getModelUtils().nodeTypesForResource(operatorResources);
	}
	
	
	@Override
	protected BaseExpressionEngine getEngine() {
		if (engine == null) {
			engine = LogicActivator.getInstance().getInjector()
					.getInstance(RetentionEngine.class);
		}
		return engine;
	}

	@Override
	protected void processNode(NodeType nodeType) {
		int cnt = 0;
		for (final Component component : getComponents(nodeType)) {
			executeFor(component);
			getJobMonitor().incrementProgress(0, (cnt++ % 10) == 0);
		}
	}
	
	protected void executeFor(Component component) {
		this.getJobMonitor().setTask("Cleaning for " + component.getName());
		this.getJobMonitor().incrementProgress(1, false);
		final BaseComponentEngine engine = (BaseComponentEngine) getEngine();
		engine.setJobMonitor(getJobMonitor());
		engine.setComponent(component);
		engine.setDataProvider(this.getDataProvider());
		if(engine instanceof RetentionEngine){
			((RetentionEngine) engine).setRetentionRules(rules);
		}
		
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

	public RFSService getRfsService() {
		return rfsService;
	}

	public void setRfsService(RFSService rfsService) {
		this.rfsService = rfsService;
	}

	public NodeType getNodeType() {
		return nodeType;
	}

	public void setNodeType(NodeType nodeType) {
		this.nodeType = nodeType;
	}

	public void setRfsService(CDOID cdoId) {
		// read the rfsservice in the transaction of the run
		this.rfsService = (RFSService) getDataProvider().getTransaction()
				.getObject(cdoId);
	}

	public void setNode(CDOID cdoId) {
		this.nodeType = ((Node) getDataProvider().getTransaction().getObject(
				cdoId)).getNodeType();
	}

	public void setNodeType(CDOID cdoId) {
		this.nodeType = (NodeType) getDataProvider().getTransaction()
				.getObject(cdoId);
	}
}
