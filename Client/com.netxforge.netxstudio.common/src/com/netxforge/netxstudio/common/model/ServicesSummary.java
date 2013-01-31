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

import java.util.List;

import com.google.common.collect.Lists;

/**
 * Summarizes the state of an {@link Operator operator}
 * 
 * @author Christophe Bouhier
 */
public class ServicesSummary implements IMonitoringSummary {
	
	
	/** The summary of all services */
	final List<NodesSummmary> servicesSummaries = Lists.newArrayList();

	public void addSummary(NodesSummmary summary) {
		if (!servicesSummaries.contains(summary)) {
			servicesSummaries.add(summary);
		}
	}

	public int totalServices() {
		return servicesSummaries.size();
	}

	public int totalNodes() {
		int nodes = 0;
		for (NodesSummmary summary : servicesSummaries) {
			nodes += summary.getNodeCount();
		}
		return nodes;
	}

	public int totalRedServices() {
		int red = 0;
		for (NodesSummmary summary : servicesSummaries) {
			red += summary.getRagStatus()[0] ? 1 : 0;
		}
		return red;
	}

	public int totalAmberServices() {
		int amber = 0;
		for (NodesSummmary summary : servicesSummaries) {
			amber += summary.getRagStatus()[1] ? 1 : 0;
		}
		return amber;
	}

	public int totalGreenServices() {
		int green = 0;
		for (NodesSummmary summary : servicesSummaries) {
			green += summary.getRagStatus()[2] ? 1 : 0;
		}
		return green;
	}

	public int totalRedNodes() {
		int red = 0;
		for (NodesSummmary summary : servicesSummaries) {
			red += summary.getRedCountNodes();
		}
		return red;
	}

	public int totalAmberNodes() {
		int amber = 0;
		for (NodesSummmary summary : servicesSummaries) {
			amber += summary.getAmberCountNodes();
		}
		return amber;
	}

	public int totalGreenNodes() {
		int green = 0;
		for (NodesSummmary summary : servicesSummaries) {
			green += summary.getGreenCountNodes();
		}
		return green;
	}

	public int totalRedResources() {
		int resources = 0;
		for (NodesSummmary summary : servicesSummaries) {
			resources += summary.getRedCountResources();
		}
		return resources;
	}

	public int totalAmberResources() {
		int resources = 0;
		for (NodesSummmary summary : servicesSummaries) {
			resources += summary.getAmberCountResources();
		}
		return resources;
	}

	public int totalGreenResources() {
		int resources = 0;
		for (NodesSummmary summary : servicesSummaries) {
			resources += summary.getGreenCountResources();
		}
		return resources;
	}

	public int totalResources() {
		int resources = 0;
		for (NodesSummmary summary : servicesSummaries) {
			resources += summary.getResourcesCount();
		}
		return resources;
	}

}
