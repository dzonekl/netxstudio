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
package com.netxforge.netxstudio.server.logic.reporting;

import com.netxforge.netxstudio.server.logic.BaseEngine;


/**
 * Performs the resource reporting execution for an equipment or function.
 * 
 * @author Martin Taal
 * @author Christophe Bouhier. 
 */


public class ResourceReportingEngine extends BaseEngine {

//	private ServiceMonitor serviceMonitor;
	
	@Override
	public void doExecute() {
		
		System.err.println("Run reporting for Node: "
				+ this.getCommonLogic().getNode(getComponent()).getNodeID()
				+ " with component " + this.getComponent().getName());
		
//		getExpressionEngine().getContext().add(getRange());
//		final Node node = getCommonLogic().getNode(getComponent());
//		getExpressionEngine().getContext().add(node);
//		setEngineContextInfo("Node: " + node.getNodeID()
//				+ " - capacity expression -");
//
//		System.err.println("Run capacity expression for Node: "
//				+ this.getCommonLogic().getNode(getComponent()).getNodeID()
//				+ " with component " + this.getComponent().getName());
//		runForExpression(getComponent().getCapacityExpressionRef());
//		System.err.println("Done capacity expression for Node: "
//				+ this.getCommonLogic().getNode(getComponent()).getNodeID());
//		if (getFailures().size() > 0) {
//			return;
//		}
//
//		for (final NetXResource netXResource : getComponent().getResourceRefs()) {
//			// remove the last entry
//			if (getExpressionEngine().getContext().get(
//					getExpressionEngine().getContext().size() - 1) instanceof NetXResource) {
//				getExpressionEngine().getContext().remove(
//						getExpressionEngine().getContext().size() - 1);
//			}
//			getExpressionEngine().getContext().add(netXResource);
//			setEngineContextInfo("NetXResource: " + netXResource.getShortName()
//					+ " - utilization expression -");
//			System.err.println("Run util expression for resource: "
//					+ netXResource.getShortName());
//			runForExpression(getComponent().getUtilizationExpressionRef());
//			System.err.println("Done util expression for resource: "
//					+ netXResource.getShortName());
//			if (getFailures().size() > 0) {
//				return;
//			}
//			System.err.println("Run tolerance expression(s) for resource: "
//					+ netXResource.getShortName());
//
//			final ResourceMonitor resourceMonitor = OperatorsFactory.eINSTANCE
//					.createResourceMonitor();
//			resourceMonitor.setNodeRef(node);
//			resourceMonitor.setResourceRef(netXResource);
//			resourceMonitor.setStart(getModelUtils().toXMLDate(getStart()));
//			resourceMonitor.setEnd(getModelUtils().toXMLDate(getEnd()));
//			if (getServiceMonitor() == null) {
//				final Resource emfResource = getDataProvider()
//						.getResource(OperatorsPackage.eINSTANCE
//								.getResourceMonitor());
//				emfResource.getContents().add(resourceMonitor);
//			} else {
//				serviceMonitor.getResourceMonitors().add(resourceMonitor);
//			}
//			getCommonLogic().setResourceMonitor(resourceMonitor);
//			
//			for (final Tolerance tolerance : getComponent().getToleranceRefs()) {
//				getCommonLogic().setTolerance(tolerance);
//				
//				// resultaat van de tolerance is een percentage
//				// loop door de capacity/utilization heen
//				// genereer markers per nieuwe overschrijding
//				setEngineContextInfo("NetXResource: " + netXResource.getShortName()
//						+ " - tolerance expression -");
//				runForExpression(tolerance.getExpressionRef());
//				if (getFailures().size() > 0) {
//					return;
//				}
//			}
//			System.err.println("Done tolerance expression(s) for resource: "
//					+ netXResource.getShortName());
//		}
	}

//	public ServiceMonitor getServiceMonitor() {
//		return serviceMonitor;
//	}
//
//	public void setServiceMonitor(ServiceMonitor serviceMonitor) {
//		this.serviceMonitor = serviceMonitor;
//	}
}
