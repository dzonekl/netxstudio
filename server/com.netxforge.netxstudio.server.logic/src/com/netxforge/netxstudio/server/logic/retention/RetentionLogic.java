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
import java.util.Date;
import java.util.List;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.ecore.resource.Resource;

import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.scheduling.ComponentFailure;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.server.logic.BaseComponentEngine;
import com.netxforge.netxstudio.server.logic.BaseComponentLogic;
import com.netxforge.netxstudio.server.logic.BaseExpressionEngine;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;
import com.netxforge.netxstudio.services.RFSService;

/**
 * Performs the retention logic for a RFSService, node type or component.
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public class RetentionLogic extends BaseComponentLogic {

	/**
	 * The number of years to consider in the aggregation and retention of
	 * values. It could be requested to i.e. keep one month of data evaluation a
	 * period of n years.
	 */
	private static final int YEARS_TO_EVALUATE = 2;

	private RFSService rfsService;

	private NodeType nodeType;

	private MetricRetentionRules rules;

	public void setRules(MetricRetentionRules rules) {
		this.rules = rules;
	}

	private BaseExpressionEngine engine;

	private Resource operatorResources;

	private boolean re_initialize;

	
	protected void doRun() {
		
		re_initialize =  true;
		
		this.getData().getTransaction();

		final List<NodeType> nodeTypes = getNodeTypesToExecuteFor();

		// Note: The total work is not linear to the number of components,
		// components which have expressions will take more time.
		this.getJobMonitor().setWorkDone(0); // Reset the work
		this.getJobMonitor().setTotalWork(countComponents(nodeTypes));
		this.getJobMonitor().setTask("Performing Retention Logic");

		for (final NodeType nodeType : nodeTypes) {

			getJobMonitor().appendToLog(
					"processing node (type) "
							+ ((Node) nodeType.eContainer()).getNodeID());

			getJobMonitor().setTask("Processing for nodeType");
			processNode(nodeType);
		}
		this.getJobMonitor().updateFailures(this.getFailures());

		this.getData().commitTransaction();
	}
	
	@Override
	protected List<NodeType> getNodeTypesToExecuteFor() {

		if (rfsService != null) {
			// first go through the leave nodes
			final List<NodeType> nodeTypes = new ArrayList<NodeType>();
			for (final Node node : rfsService.getNodes()) {
				if (StudioUtils.isInService(node)) {
					nodeTypes.add(node.getNodeType());
				}
			}
			return nodeTypes;
		} else {
			return this.allNodes();
		}
	}

	private List<NodeType> allNodes() {
		operatorResources = this.getData().getResource(
				OperatorsPackage.Literals.OPERATOR);
		return StudioUtils.nodeTypesForResource(operatorResources);
	}

	@Override
	protected BaseExpressionEngine getEngine() {
		if (engine == null) {
			engine = LogicActivator.getInstance().getInjector()
					.getInstance(RetentionEngine.class);
			engine.setDataProvider(this.getData());
			if (engine instanceof RetentionEngine) {
				((RetentionEngine) engine).setRetentionRules(rules);
				((RetentionEngine) engine).initialize(re_initialize);
				
			}
			
		}
		if(re_initialize){
			((RetentionEngine)engine).initialize(re_initialize);
			re_initialize = false;
		}
		return engine;
	}

	@Override
	protected void processNode(NodeType nodeType) {
		int cnt = 0;
		for (final Component component : getComponents(nodeType)) {
			executeFor(component);
			this.getJobMonitor().setTask("Retention");
			this.getJobMonitor().setMsg(
					StudioUtils.printModelObject(component));
			getJobMonitor().incrementProgress(0, (cnt++ % 10) == 0);
		}
	}

	protected void executeFor(Component component) {

		this.getJobMonitor().incrementProgress(1, false);

		final BaseComponentEngine engine = (BaseComponentEngine) getEngine();
		engine.setJobMonitor(getJobMonitor());
		engine.setComponent(component);
		engine.setPeriod(this.getPeriod());
		engine.execute();
		
		if (engine.getFailures().size() > 0) {
			for (final Failure failure : engine.getFailures()) {
				if (failure instanceof ComponentFailure) {
					((ComponentFailure) failure).setComponentRef(component);
				}
				this.getFailures().add(failure);
			}
			// CDOView cdoView = ((CDOResource)operatorResources).cdoView();
			//
			// if(cdoView instanceof CDOTransaction){
			// try {
			// ((CDOTransaction) cdoView).commit();
			// } catch (CommitException e) {
			// e.printStackTrace();
			// }
			// }
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
		this.rfsService = (RFSService) getData().getTransaction()
				.getObject(cdoId);
	}

	public void setNode(CDOID cdoId) {
		this.nodeType = ((Node) getData().getTransaction().getObject(
				cdoId)).getNodeType();
	}

	public void setNodeType(CDOID cdoId) {
		this.nodeType = (NodeType) getData().getTransaction()
				.getObject(cdoId);
	}

	/**
	 * Initialized the static part of the logic. This is the evaluation period
	 * of the logic.
	 */
	public void intializeRentionLogic() {

		Date end = NonModelUtils.todayAtDayEnd();
		Date begin = NonModelUtils.yearsAgo(YEARS_TO_EVALUATE);
		setPeriod(StudioUtils.period(begin, end));

	}

}
