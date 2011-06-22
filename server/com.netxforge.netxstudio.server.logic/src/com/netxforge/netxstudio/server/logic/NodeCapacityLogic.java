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

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.cdo.common.id.CDOID;

import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;

/**
 * Performs the capacity logic execution for a Node.
 * 
 * @author Martin Taal
 */
public class NodeCapacityLogic extends BaseCapacityLogic {
	
	private Node node;

	@Override
	protected List<NodeType> getNodeTypesToExecuteFor() {
		return Collections.singletonList(node.getNodeType());
	}

	public Node getNode() {
		return node;
	}

	public void setNode(CDOID cdoId) {
		this.node = (Node)getDataProvider().getTransaction().getObject(cdoId);
	}
	
	public void setNodeType(CDOID cdoId) {
		final NodeType nodeType = (NodeType)getDataProvider().getTransaction().getObject(cdoId);
		node = (Node)nodeType.eContainer();
	}
}