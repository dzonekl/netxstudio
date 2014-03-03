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

import com.google.common.collect.Iterables;
import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.ServiceMonitor;
import com.netxforge.netxstudio.services.ServicesFactory;

/**
 * Performs the capacity logic execution for a RFSService.
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public class RFSServiceMonitoringLogic extends BaseMonitoringLogic {

	private RFSService rfsService;

	private ServiceMonitor serviceMonitor;

	/**
	 * @deprecated
	 */
	void initializeMonitoringLogic() {
		this.calculatePeriod(rfsService);
		this.initServiceMonitor(this.getPeriod());
	}

	/**
	 * Initialize a new Monitor, clean monitors which match the same period.
	 * Overlapping periods are also discarded.
	 * 
	 * @param dtr
	 */
	public void initServiceMonitor(DateTimeRange dtr) {

		serviceMonitor = ServicesFactory.eINSTANCE.createServiceMonitor();
		// what name should a servicemonitor have?
		serviceMonitor.setName(rfsService.getServiceName());
		serviceMonitor.setPeriod(dtr);
		// The revision will hold the Object ID and creation time.
		serviceMonitor.setRevision(NonModelUtils.dateAndTime(
				NonModelUtils.todayAndNow()));
		
		
		// Do the ONFE thing, disable for now as we catch ONFEs in own policy.  
//		this.getModelUtils().findAndCleanONFE(rfsService,
//				ServicesPackage.Literals.SERVICE__SERVICE_MONITORS);

		rfsService.getServiceMonitors().add(0, serviceMonitor); // Add at
																// beginning.

		List<ServiceMonitor> serviceMonitorDuplicates = StudioUtils
				.serviceMonitorDuplicates(rfsService, dtr);

		if (LogicActivator.DEBUG) {
			LogicActivator.TRACE.trace(LogicActivator.TRACE_LOGIC_OPTION,
					"Creating Service Monitor for period"
							+ StudioUtils.periodToString(dtr));
			if (serviceMonitorDuplicates.size() > 0) {
				LogicActivator.TRACE.trace(LogicActivator.TRACE_LOGIC_OPTION,
						"Removing " + serviceMonitorDuplicates.size()
								+ " entries for the same period");
			}
		}

		// remove them with
		Iterables.removeAll(rfsService.getServiceMonitors(),
				serviceMonitorDuplicates);

		getEngine().setServiceMonitor(serviceMonitor);
	}

	public RFSService getRfsService() {
		return rfsService;
	}

	public void setRfsService(CDOID cdoId) {
		// read the rfsservice in the transaction of the run
		this.rfsService = (RFSService) getData().getTransaction().getObject(
				cdoId);
	}

	@Override
	protected List<NodeType> getNodeTypesToExecuteFor() {
		final List<NodeType> nodeTypes = new ArrayList<NodeType>();
		// first go through the leave nodes
		for (final Node node : rfsService.getNodes()) {
			if (StudioUtils.isInService(node)
					&& node.getNodeType().isLeafNode()) {
				nodeTypes.add(node.getNodeType());
			}
		}
		// and then the other nodes
		for (final Node node : rfsService.getNodes()) {
			if (StudioUtils.isInService(node)
					&& !node.getNodeType().isLeafNode()) {
				nodeTypes.add(node.getNodeType());
			}
		}
		return nodeTypes;
	}

}
