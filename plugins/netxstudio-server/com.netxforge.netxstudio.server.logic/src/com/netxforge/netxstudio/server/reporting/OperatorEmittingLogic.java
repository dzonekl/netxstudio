/*******************************************************************************
 * Copyright (c) Oct 30, 2013 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.reporting;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

/**
 * 
 * @author Christophe Bouhier
 */
public class OperatorEmittingLogic extends EmittingLogic {

	private List<Service> services;

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@Override
	protected List<Service> getServicesToExecuteFor() {
		return services;
	}

	@Override
	protected List<NodeType> getNodeTypesToExecuteFor(RFSService service) {

		final List<NodeType> nodeTypes = new ArrayList<NodeType>();

		// Filter the nodes.
		List<Node> acceptedNodes = Lists.newArrayList();
		if (this.getNodeTypeAcceptor() != null) {
			for (NodeType nt : this.getNodeTypeAcceptor()) {
				acceptedNodes.addAll(StudioUtils.nodesForNodeType(
						service.getNodes(), nt));
			}
		} else {
			// All from the service.
			acceptedNodes = service.getNodes();
		}

		// first go through the leave nodes
		for (final Node node : acceptedNodes) {
			if (StudioUtils.isInService(node)
					&& node.getNodeType().isLeafNode()) {
				nodeTypes.add(node.getNodeType());
			}
		}
		// and then the other nodes
		for (final Node node : acceptedNodes) {
			if (StudioUtils.isInService(node)
					&& !node.getNodeType().isLeafNode()) {
				nodeTypes.add(node.getNodeType());
			}
		}
		return nodeTypes;
	}
}