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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.data.importer.ResultProcessor;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.scheduling.ComponentFailure;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;
import com.netxforge.netxstudio.services.ServiceMonitor;

/**
 * Performs the resource monitoring execution for an equipment or function.
 * 
 * @author Martin Taal
 */
public class MonitoringEngine extends BaseComponentEngine {

	private ServiceMonitor serviceMonitor;
	
	@Inject 
	private ResultProcessor resultProcessor;
	
	@Override
	public void doExecute() {

		if (this.getComponent() instanceof Equipment) {

			if (LogicActivator.DEBUG) {
				System.out
						.println("MONITORING ENGINE: Start Monitoring for Equipment: "
								+ ((Equipment) this.getComponent())
										.getEquipmentCode()
								+ " Name="
								+ this.getComponent().getName());
			}
		} else if (this.getComponent() instanceof Function) {
			if (LogicActivator.DEBUG) {
				System.out
						.println("MONITORING ENGINE: Start Monitoring for Function: "
								+ " Name=" + this.getComponent().getName());
			}
		}

		// Clear the context first.
		getExpressionEngine().getContext().clear();
		getExpressionEngine().getContext().add(getPeriod());
		getExpressionEngine().getContext().add(getComponent());
		final Node node = getModelUtils().nodeFor(getComponent());
		getExpressionEngine().getContext().add(node);

		// CB 16-12-2011, moved capacity expression content, to be the resource.
		// use capacity expressions, with NODE.

		// setEngineContextInfo("Node: " + node.getNodeID() + ", Comp: "
		// + getComponent().getName() + " - capacity expression -");

		// Expression runCapExpression =
		// getExpression(LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF);
		// runForExpression(runCapExpression);

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

			if (LogicActivator.DEBUG) {
				System.err
						.println("MONITORING ENGINE: Run capacity expression for resource: "
								+ netXResource.getShortName());
			}

			setEngineContextInfo("NetXResource: " + netXResource.getShortName()
					+ " - capacity expression -");

			Expression runCapExpression = getExpression(LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF);
			runForExpression(runCapExpression);

			if (LogicActivator.DEBUG) {
				System.err
						.println("MONITORING ENGINE: Run util expression for resource: "
								+ netXResource.getShortName());
			}

			setEngineContextInfo("NetXResource: " + netXResource.getShortName()
					+ " - utilization expression -");

			Expression runUtilExpression = this
					.getExpression(LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF);
			runForExpression(runUtilExpression);

			if (LogicActivator.DEBUG) {
				System.err
						.println("MONITORING ENGINE: Done util expression for resource: "
								+ netXResource.getShortName());
			}

			if (getFailures().size() > 0) {
				return;
			}

			if (LogicActivator.DEBUG) {
				System.err
						.println("MONITORING ENGINE: Run tolerance expression(s) for resource: "
								+ netXResource.getShortName());
			}

			// RESOURCE MONITOR CREATION
			final ResourceMonitor resourceMonitor = OperatorsFactory.eINSTANCE
					.createResourceMonitor();
			resourceMonitor.setNodeRef(node);
			resourceMonitor.setResourceRef(netXResource);
			// CB 21-09 make a copy of the DTR, as it ic contained in the
			// Service Monitor.
			DateTimeRange dtr = EcoreUtil.copy(getPeriod());
			resourceMonitor.setPeriod(dtr);

			if (LogicActivator.DEBUG) {
				System.err
						.println("MONITORING ENGINE: Creating a new resource monitor for: "
								+ netXResource.getShortName());
			}

			resultProcessor.setResourceMonitor(resourceMonitor);

			for (final Tolerance tolerance : getTolerances()) {
				resultProcessor.setTolerance(tolerance);

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

			if (LogicActivator.DEBUG) {
				System.err
						.println("Done tolerance expression(s) for resource: "
								+ netXResource.getShortName());
			}

			// Only store for resource monitors which actually have something
			if (resourceMonitor.getMarkers().size() > 0) {
				if (getServiceMonitor() == null) {
					final Resource emfResource = getDataProvider().getResource(
							OperatorsPackage.eINSTANCE.getResourceMonitor());
					emfResource.getContents().add(resourceMonitor);

				} else {
					serviceMonitor.getResourceMonitors().add(resourceMonitor);
				}
			}

		}
		
		// Print info on which component was processed. 
		if (LogicActivator.DEBUG) {
			if (this.getComponent() instanceof Equipment) {
				System.out.println("Done Monitoring for Equipment: "
						+ ((Equipment) this.getComponent()).getEquipmentCode()
						+ " Name=" + this.getComponent().getName());
			} else if (this.getComponent() instanceof Function) {
				System.out.println("Done Monitoring for Function: " + " Name="
						+ this.getComponent().getName());
			}
		}
	}

	private Expression getExpression(EReference ref) {
		Expression runCapExpression = null;
		if (getComponent().eIsSet(ref)) {
			runCapExpression = (Expression) getComponent().eGet(ref);
		} else {
			if (LogicActivator.DEBUG) {
				System.out
						.println("MONITORING ENGINE: Expression not set for component"
								+ getComponent().getName()
								+ " try expression from parent Component");
			}
			// walk up the parent cap expression, just one level.
			EObject parent = getComponent().eContainer();
			if (parent != null && parent instanceof Component) {
				Component parentComponent = (Component) parent;
				if (parentComponent.eIsSet(ref)) {
					runCapExpression = (Expression) parentComponent.eGet(ref);
				} else {
					if (LogicActivator.DEBUG) {
						System.out
								.println("MONITORING ENGINE: Expression not set for parent component :-("
										+ getComponent().getName());
					}
				}
			}
		}
		return runCapExpression;
	}

	private List<Tolerance> getTolerances() {
		if (getComponent().getToleranceRefs().size() > 0) {
			return getComponent().getToleranceRefs();
		} else {
			// walk up the parent cap expression, just one level.
			EObject parent = getComponent().eContainer();
			if (parent != null && parent instanceof Component) {
				Component parentComponent = (Component) parent;
				if (parentComponent.getToleranceRefs().size() > 0) {
					return parentComponent.getToleranceRefs();
				}
			}
		}
		return Lists.newArrayList();
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
		resultProcessor.processMonitoringResult(currentContext,
				expressionResults, start, end);

	}
}
