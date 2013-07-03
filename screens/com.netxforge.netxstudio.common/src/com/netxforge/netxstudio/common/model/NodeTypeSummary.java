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
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Iterables;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Marker;

/**
 * 
 * @author Christophe Bouhier
 */
public class NodeTypeSummary extends MonitoringAdapter {

	int functions = 0;
	int equipments = 0;
	int resources = 0;

	public NodeTypeSummary() {
	}

	@Override
	protected void computeForTarget(IProgressMonitor monitor) {

		// Safely case, checked by our factory.
		final NodeType target = getNodeType();

		// This is potentially expensive. 
		final TreeIterator<EObject> iterator = target.eAllContents();

		// Might throw an Exception.
		int work = Iterables.size((Iterable<?>) iterator);

		final SubMonitor subMonitor = SubMonitor.convert(monitor, work);
		subMonitor.setTaskName("Computing summary for "
				+ modelUtils.printModelObject(target));

		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (next instanceof Function) {
				functions += 1;
			} else if (next instanceof Equipment) {
				equipments += 1;
			}

			if (next instanceof Component) {

				IMonitoringSummary childAdapter = this.getChildAdapter(next);

				// Guard for potentially non-adapted children.
				if (childAdapter != null) {
					childAdapter.addContextObjects(this.getContextObjects());
					childAdapter.compute(monitor);

					// Base our RAG status, on the child's status
					this.incrementRag(childAdapter.rag());
					if (childAdapter instanceof ComponentSummary) {
						resources += ((ComponentSummary) childAdapter)
								.totalResources();

					}
				}
			}
			subMonitor.worked(1);
		}

	}

	@Override
	protected boolean isSameAdapterFor(EObject object) {
		return false; // Always produce new adapters.
	}

	@Override
	protected boolean isNotFiltered(EObject object) {
		// Self-adapt for contained hierarchy. (Note NetXResource is not
		// contained!).
		return object.eClass() == LibraryPackage.Literals.FUNCTION
				|| object.eClass() == LibraryPackage.Literals.EQUIPMENT;
	}

	public String getFunctionCountAsString() {
		return new Integer(functions).toString();
	}

	public String getEquipmentCountAsString() {
		return new Integer(equipments).toString();
	}

	public String getResourCountAsString() {
		return new Integer(resources).toString();
	}

	public int totalFunctions() {
		return functions;
	}

	public int totalEquipments() {
		return equipments;
	}

	public int totalResources() {
		return resources;
	}

	public NodeType getNodeType() {
		final NodeType target = (NodeType) super.getTarget();
		return target;
	}

	/**
	 * The markers for all resources in the target {@link Node}
	 * 
	 * @return
	 */
	public Map<NetXResource, List<Marker>> markers() {
		throw new UnsupportedOperationException("TODO");
	}

}