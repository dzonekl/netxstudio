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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NetXResource;

/**
 * An adapted NetXResource, adds computed information to the resource.
 * 
 * @author Christophe Bouhier
 */
public class ComponentSummary extends MonitoringAdapter {

	int resources = 0;

	public ComponentSummary() {
	}

	@Override
	protected synchronized void computeForTarget(IProgressMonitor monitor) {

		final DateTimeRange periodInContext = periodInContext();
		if (periodInContext != null) {
			this.setPeriod(periodInContext);
		}

		final Component target = getComponent();

		final SubMonitor subMonitor = SubMonitor.convert(monitor,
				totalResources());
		subMonitor.setTaskName("Computing summary for "
				+ modelUtils.printModelObject(getComponent()));

		for (NetXResource netxresource : target.getResourceRefs()) {

			// The child is likely self-adapted. Also compute the child when
			// the adaption has worked.

			// Call compute child on the adapter...
			IMonitoringSummary childAdapter = this
					.getChildAdapter(netxresource);

			// Guard for potentially non-adapted children.
			if (childAdapter != null) {
				childAdapter.addContextObjects(this.getContextObjects());
				childAdapter.compute(monitor);

				// Base our RAG status, on the child's status
				this.incrementRag(childAdapter.rag());
			}
			subMonitor.worked(1);
		}
	}

	public int[] rag() {
		return ragCount;
	}

	/**
	 * The count for the {@link NetXResource} objects referenced by this
	 * {@link Component}.
	 * 
	 * @return
	 */
	public int totalResources() {
		return this.getComponent().getResourceRefs().size();
	}

	public Component getComponent() {
		final Component target = (Component) super.getTarget();
		return target;
	}
}
