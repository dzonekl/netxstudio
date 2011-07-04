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
import java.util.List;

import org.eclipse.emf.cdo.common.id.CDOID;

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
public class RFSServiceResourceMonitoringLogic extends BaseResourceMonitoringLogic {

	private RFSService rfsService;

	private ServiceMonitor serviceMonitor;
	
	void initializeServiceMonitor() {
		Date startTime = getStartTime();
		if (startTime == null) {
			// as a default start 30 days in the past
			startTime = new Date(System.currentTimeMillis() - 30 * 24 * 60 * 60 * 1000);
			if (!rfsService.getServiceMonitors().isEmpty()) {
				final Date previousEndTime = rfsService.getServiceMonitors()
						.get(rfsService.getServiceMonitors().size() - 1)
						.getPeriod().getEnd().toGregorianCalendar().getTime();
				startTime = new Date(previousEndTime.getTime() + 1);
			}
			setStartTime(startTime);
		}
		Date endTime = getEndTime();
		if (endTime == null) {
			endTime = new Date(System.currentTimeMillis());
			setEndTime(endTime);
		}

		serviceMonitor = ServicesFactory.eINSTANCE.createServiceMonitor();
		// what name should a servicemonitor have?
		serviceMonitor.setName(rfsService.getServiceName());
		serviceMonitor.setPeriod(getTimeRange());
		rfsService.getServiceMonitors().add(serviceMonitor);
	}

	public RFSService getRfsService() {
		return rfsService;
	}

	public void setRfsService(CDOID cdoId) {
		// read the rfsservice in the transaction of the run
		this.rfsService = (RFSService)getDataProvider().getTransaction().getObject(cdoId);
	}

	@Override
	protected List<NodeType> getNodeTypesToExecuteFor() {
		final List<NodeType> nodeTypes = new ArrayList<NodeType>();
		// first go through the leave nodes
		for (final Node node : rfsService.getNodes()) {
			if (isValidNode(node) && node.getNodeType().isLeafNode()) {
				nodeTypes.add(node.getNodeType());
			}
		}
		// and then the other nodes
		for (final Node node : rfsService.getNodes()) {
			if (isValidNode(node) && !node.getNodeType().isLeafNode()) {
				nodeTypes.add(node.getNodeType());
			}
		}
		return nodeTypes;
	}

	private boolean isValidNode(Node node) {
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
}
