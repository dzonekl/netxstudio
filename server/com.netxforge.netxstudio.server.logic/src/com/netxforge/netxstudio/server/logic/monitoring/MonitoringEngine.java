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

import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.scheduling.ComponentFailure;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.services.ServiceMonitor;

/**
 * Performs the resource monitoring execution for an equipment or function.
 * 
 * @author Martin Taal
 */
public class MonitoringEngine extends BaseComponentEngine {

	private ServiceMonitor serviceMonitor;

	@Override
	public void doExecute() {
		
		// Clear the context first. 
		getExpressionEngine().getContext().clear();
		getExpressionEngine().getContext().add(getPeriod());
		final Node node = getCommonLogic().getNode(getComponent());
		getExpressionEngine().getContext().add(node);
		setEngineContextInfo("Node: " + node.getNodeID() + ", Comp: "
				+ getComponent().getName() + " - capacity expression -");

		// System.err.println("Run capacity expression for Node: "
		// + this.getCommonLogic().getNode(getComponent()).getNodeID()
		// + " with component " + this.getComponent().getName());
		runForExpression(getComponent().getCapacityExpressionRef());
		// System.err.println("Done capacity expression for Node: "
		// + this.getCommonLogic().getNode(getComponent()).getNodeID());
		if (getFailures().size() > 0) {
			return;
		}

		for (final NetXResource netXResource : getComponent().getResourceRefs()) {
			// remove the last entry, (Keep the date time and node context).

			// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			// NOTE: We only have one single Identifier context in the
			// interpreter, so why keep the Node context!!!!!!!

			if (getExpressionEngine().getContext().get(
					getExpressionEngine().getContext().size() - 1) instanceof NetXResource) {
				getExpressionEngine().getContext().remove(
						getExpressionEngine().getContext().size() - 1);
			}
			getExpressionEngine().getContext().add(netXResource);
			setEngineContextInfo("NetXResource: " + netXResource.getShortName()
					+ " - utilization expression -");
			System.err.println("Run util expression for resource: "
					+ netXResource.getShortName());
			runForExpression(getComponent().getUtilizationExpressionRef());
			System.err.println("Done util expression for resource: "
					+ netXResource.getShortName());
			if (getFailures().size() > 0) {
				return;
			}
			System.err.println("Run tolerance expression(s) for resource: "
					+ netXResource.getShortName());

			final ResourceMonitor resourceMonitor = OperatorsFactory.eINSTANCE
					.createResourceMonitor();
			resourceMonitor.setNodeRef(node);
			resourceMonitor.setResourceRef(netXResource);
			// CB 21-09 make a copy of the DTR. 
			DateTimeRange dtr = EcoreUtil.copy(getPeriod());
			resourceMonitor.setPeriod(dtr);
			if (getServiceMonitor() == null) {
				final Resource emfResource = getDataProvider().getResource(
						OperatorsPackage.eINSTANCE.getResourceMonitor());
				emfResource.getContents().add(resourceMonitor);
			} else {
				serviceMonitor.getResourceMonitors().add(resourceMonitor);
			}
			getCommonLogic().setResourceMonitor(resourceMonitor);

			for (final Tolerance tolerance : getComponent().getToleranceRefs()) {
				getCommonLogic().setTolerance(tolerance);

				// resultaat van de tolerance is een percentage
				// loop door de capacity/utilization heen
				// genereer markers per nieuwe overschrijding
				setEngineContextInfo("NetXResource: "
						+ netXResource.getShortName()
						+ " - tolerance expression -");
				runForExpression(tolerance.getExpressionRef());
				if (getFailures().size() > 0) {
					return;
				}
			}
			System.err.println("Done tolerance expression(s) for resource: "
					+ netXResource.getShortName());

			// TODO Service distribution and service profile expressions.
			// The profile information is in ServiceUsers/ Service Profile.

		}
	}

	public ServiceMonitor getServiceMonitor() {
		return serviceMonitor;
	}

	public void setServiceMonitor(ServiceMonitor serviceMonitor) {
		this.serviceMonitor = serviceMonitor;
	}

	@Override
	public Failure getFailure() {
		final ComponentFailure failure = SchedulingFactory.eINSTANCE
				.createComponentFailure();
		failure.setComponentRef(getComponent());
		return failure;
	}

	@Override
	protected void processResult(List<Object> currentContext,
			List<BaseExpressionResult> expressionResults, Date start, Date end) {
		this.getCommonLogic().processMonitoringResult(currentContext, expressionResults,
				start, end);

	}
}
