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

import org.eclipse.emf.cdo.common.id.CDOID;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.ServiceMonitor;
import com.netxforge.netxstudio.services.ServicesFactory;

/**
 * Performs the capacity logic execution for a RFSService.
 * 
 * @author Martin Taal
 */
public class RFSServiceMonitoringLogic extends BaseMonitoringLogic {

	private RFSService rfsService;

	private ServiceMonitor serviceMonitor;

	void initializeMonitoringLogic() {
		this.calculatePeriod(rfsService);
		this.initServiceMonitor(this.getPeriod());
	}
	
	public void initServiceMonitor(DateTimeRange dtr){
		serviceMonitor = ServicesFactory.eINSTANCE.createServiceMonitor();
		// what name should a servicemonitor have?
		serviceMonitor.setName(rfsService.getServiceName());
		serviceMonitor.setPeriod(dtr);
		rfsService.getServiceMonitors().add(serviceMonitor);
		getEngine().setServiceMonitor(serviceMonitor);
	}
	

	public RFSService getRfsService() {
		return rfsService;
	}

	public void setRfsService(CDOID cdoId) {
		// read the rfsservice in the transaction of the run
		this.rfsService = (RFSService) getDataProvider().getTransaction()
				.getObject(cdoId);
	}

	@Override
	protected List<NodeType> getNodeTypesToExecuteFor() {
		final List<NodeType> nodeTypes = new ArrayList<NodeType>();
		// first go through the leave nodes
		for (final Node node : rfsService.getNodes()) {
			if (getModelUtils().isInService(node)
					&& node.getNodeType().isLeafNode()) {
				nodeTypes.add(node.getNodeType());
			}
		}
		// and then the other nodes
		for (final Node node : rfsService.getNodes()) {
			if (getModelUtils().isInService(node)
					&& !node.getNodeType().isLeafNode()) {
				nodeTypes.add(node.getNodeType());
			}
		}
		return nodeTypes;
	}

}
