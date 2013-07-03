/*******************************************************************************
 * Copyright (c) 29 jan. 2013 NetXForge.
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
import org.eclipse.emf.cdo.CDOObject;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

/**
 * Summarizes the state of an {@link Operator operator}
 * 
 * @author Christophe Bouhier
 */
public class OperatorSummary extends RFSServiceSummary {

	@Override
	protected void computeForTarget(IProgressMonitor monitor) {

		final DateTimeRange periodInContext = getPeriod();
		if (periodInContext == null) {
			return;
		}

		// Safely case, checked by our factory.
		final Operator target = getTarget();

		if (this.getRFSService() == null) {
			this.addAdapter(target);
		}
		for (Service s : target.getServices()) {
			if (s instanceof RFSService) {
				computeForRFService((RFSService) s, monitor);
			}
		}
	}

	public Operator getTarget() {
		return (Operator) super.getTarget();
	}

	@Override
	protected boolean isRelated(CDOObject object) {
		// Not relevant for Operator object,
		// as it will be loaded as a sibbling.
		return true;
	}

}
