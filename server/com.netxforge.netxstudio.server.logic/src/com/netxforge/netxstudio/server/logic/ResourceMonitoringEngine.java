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

import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.Tolerance;

/**
 * Performs the resource monitoring execution for an equipment or function.
 * 
 * @author Martin Taal
 */
public class ResourceMonitoringEngine extends BaseEngine {

	@Override
	public void execute() {
		getExpressionEngine().getContext().add(getRange());
		getExpressionEngine().getContext().add(
				getCommonLogic().getNode(getComponent()));

		System.err.println("Run capacity expression for Node: "
				+ this.getCommonLogic().getNode(getComponent()).getNodeID()
				+ " with component " + this.getComponent().getName());
		runForExpression(getComponent().getCapacityExpressionRef());
		System.err.println("Done capacity expression for Node: "
				+ this.getCommonLogic().getNode(getComponent()).getNodeID());
		if (getFailure() != null) {
			return;
		}

		for (final NetXResource netXResource : getComponent().getResources()) {
			// remove the last entry
			if (getExpressionEngine().getContext().get(
					getExpressionEngine().getContext().size() - 1) instanceof NetXResource) {
				getExpressionEngine().getContext().remove(
						getExpressionEngine().getContext().size() - 1);
			}
			getExpressionEngine().getContext().add(netXResource);
			System.err.println("Run util expression for resource: "
					+ netXResource.getShortName());
			runForExpression(getComponent().getUtilizationExpressionRef());
			System.err.println("Done util expression for resource: "
					+ netXResource.getShortName());
			if (getFailure() != null) {
				return;
			}
			System.err.println("Run tolerance expression(s) for resource: "
					+ netXResource.getShortName());
			for (final Tolerance tolerance : getComponent().getToleranceRefs()) {
				// resultaat van de tolerance is een percentage
				// loop door de capacity/utilization heen
				// genereer markers per nieuwe overschrijding
				runForExpression(tolerance.getExpressionRef());
				if (getFailure() != null) {
					return;
				}
			}
			System.err.println("Done tolerance expression(s) for resource: "
					+ netXResource.getShortName());
		}
	}
}
