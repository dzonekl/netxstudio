/*******************************************************************************
 * Copyright (c) 24 apr. 2013 NetXForge.
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
package com.netxforge.netxstudio.callflow.screens.callflows.model;

import java.util.List;

import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.ReferenceRelationship;
import com.netxforge.netxstudio.services.ServiceFlow;
import com.netxforge.netxstudio.services.ServiceFlowDirection;
import com.netxforge.netxstudio.services.ServiceFlowRelationship;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * A model from a {@link NodeType Node type} to a {@link Component}
 * 
 * @author Christophe Bouhier
 */
public class NodeTypeToServiceRelationships {

	private final NodeType source;
	private final List<ServiceFlowRelationship> target;
	private ServiceFlow parent;

	public void setParent(ServiceFlow parent) {
		this.parent = parent;
	}

	public NodeTypeToServiceRelationships(ServiceFlow parent, NodeType source,
			List<ServiceFlowRelationship> target) {
		super();
		this.source = source;
		this.target = target;
		this.parent = parent;
	}

	public NodeType getSource() {
		return source;
	}

	public List<ServiceFlowRelationship> getTarget() {
		return target;
	}

	public ServiceFlow getParent() {
		return parent;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("NodeType: " + source.getName());
		for (ServiceFlowRelationship sfr : target) {
			printSFR(sb, sfr);
		}
		return sb.toString();
	}

	/**
	 * @param sb
	 * @param sfr
	 */
	private void printSFR(StringBuffer sb, ServiceFlowRelationship sfr) {
		if (sfr.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP)) {
			ReferenceRelationship rr = sfr.getReferenceRelationship();

			sb.append("\n( "
					+ rr.getRefInterface1Ref().getName()
					+ (sfr.getDirection() == ServiceFlowDirection.RIGHTTOLEFT ? "<--"
							: "-->") + rr.getRefInterface2Ref().getName() + ")");
		}else{
			if( sfr.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__SERVICE_FLOW)){
				ServiceFlow serviceFlow = sfr.getServiceFlow();
				sb.append(" Service flow: " + serviceFlow.getName());
			}
		}
	}
}
