/*******************************************************************************
 * Copyright (c) 31 jan. 2013 NetXForge.
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
package com.netxforge.netxstudio.common.model;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EObject;

import com.netxforge.base.context.IComputationContext;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.operators.Marker;

/**
 * An adapted {@link Component}, adds computed and aggregated information to the
 * component.
 * 
 * @author Christophe Bouhier
 */
public class ComponentSummary extends MonitoringAdapter {

	private int functions;
	private int equipments;
	private int resources;

	@Override
	protected synchronized void computeForTarget(IProgressMonitor monitor) {

		final Component target = getComponent();

		// Clear previous computations.
		clearComputation();

		computeForComponent(monitor, target);
	}

	/**
	 * @param monitor
	 * @param component
	 */
	private void computeForComponent(IProgressMonitor monitor,
			final Component component) {

		if (component instanceof Function) {
			functions += 1;
		} else if (component instanceof Equipment) {
			equipments += 1;
		}
		boolean childComponentComputed = false;

		List<Component> componentsForComponent = StudioUtils
				.childComponentsForComponent(component, false);

		// Might throw an Exception.
		int work = componentsForComponent.size();

		final SubMonitor subMonitor = SubMonitor.convert(monitor, work);
		subMonitor.setTaskName("Computing summary for "
				+ StudioUtils.printModelObject(component));

		for (Component c : componentsForComponent) {

			ComponentSummary componentSummary = adaptAndCompute(subMonitor, c,
					this.getContextObjects());
			if (componentSummary != null) {
				resources += componentSummary.totalResources();
//				System.out.println("adding" + componentSummary.totalResources()
//						+ " for comp:" + modelUtils.printModelObject(c));

				functions += componentSummary.totalFunctions();
				equipments += componentSummary.totalEquipments();
				if (componentSummary.isComputed()) {
					// Base our RAG status, on the child's status
					this.incrementRag(componentSummary.rag());
					childComponentComputed = true;
				}
			}
		}
		// count for computed resources.
		int computedResources = 0;

		if (!component.getResourceRefs().isEmpty()) {

			final SubMonitor resourcesMonitor = SubMonitor.convert(monitor,
					totalResources());

			resourcesMonitor.setTaskName("Computing summary for "
					+ StudioUtils.printModelObject(getComponent()));

			for (NetXResource netxresource : component.getResourceRefs()) {

				resources++;

				if (monitor != null && monitor.isCanceled()) {
					System.out.println("Computation cancelled...");
					break;
				}
				IMonitoringSummary childAdapter = adaptAndCompute(
						resourcesMonitor, netxresource,
						this.getContextObjects());
				// Guard for potentially non-adapted children.
				if (childAdapter != null) {
					if (childAdapter.isComputed()) {
						computedResources++;
						// Base our RAG status, on the child's status
						this.incrementRag(childAdapter.rag());
					}
				} else {
					System.out.println("SHOULD NOT OCCUR: child not adapted! "
							+ StudioUtils.printModelObject(netxresource));
				}
				resourcesMonitor.worked(1);
			}
		}
		if (computedResources == component.getResourceRefs().size()
				|| childComponentComputed) {
			computationState = ComputationState.COMPUTED;
		}
	}

	@Override
	protected boolean isSameAdapterFor(EObject object) {
		return false; // Always produce new adapters.
	}

	@Override
	protected boolean isNotFiltered(EObject object) {
		// Self-adapt for contained hierarchy. (Not NetXResource is not
		// contained!).
		return object.eClass() == LibraryPackage.Literals.FUNCTION
				|| object.eClass() == LibraryPackage.Literals.EQUIPMENT
				|| object.eClass() == LibraryPackage.Literals.NET_XRESOURCE;
	}

	@Override
	protected boolean isRelated(CDOObject object) {
		// We have a relation for NetXResaource objects which are referenced by
		// this target.
		return getComponent().getResourceRefs().contains(object);
	}

	public Component getComponent() {
		final Component target = (Component) super.getTarget();
		return target;
	}

	public String getComponentName() {
		return StudioUtils.componentName(getComponent());
	}

	public Map<NetXResource, List<Marker>> markers() {
		throw new UnsupportedOperationException("TODO");
	}

	public static ComponentSummary adaptAndCompute(IProgressMonitor monitor,
			Component component, IComputationContext... contextObjects) {

		IMonitoringSummary adaptAndCompute = MonitoringAdapter.adaptAndCompute(
				monitor, component, contextObjects);

		if (adaptAndCompute instanceof ComponentSummary) {
			ComponentSummary componentSummary = (ComponentSummary) adaptAndCompute;
			return componentSummary;
		}
		return null;
	}

	public static NetxresourceSummary adaptAndCompute(IProgressMonitor monitor,
			NetXResource component, IComputationContext... contextObjects) {

		IMonitoringSummary adaptAndCompute = MonitoringAdapter.adaptAndCompute(
				monitor, component, contextObjects);

		if (adaptAndCompute instanceof NetxresourceSummary) {
			NetxresourceSummary netxSummary = (NetxresourceSummary) adaptAndCompute;
			return netxSummary;
		}
		return null;
	}

	/**
	 * The count for the {@link NetXResource} objects referenced by this
	 * {@link Component} and it's children components.
	 * 
	 * @return
	 */
	public int totalResources() {
		return resources;
	}

	public int totalFunctions() {
		return functions;
	}

	public int totalEquipments() {
		return equipments;
	}

	@Override
	public void clearComputation() {
		super.clearComputation();
		resources = 0;
		functions = 0;
		equipments = 0;
	}

}
