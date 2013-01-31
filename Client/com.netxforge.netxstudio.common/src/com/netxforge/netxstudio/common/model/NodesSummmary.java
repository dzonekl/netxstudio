/*******************************************************************************
 * Copyright (c) 5 dec. 2012 NetXForge.
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
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

/**
 * A model object, showing the summary of the Service.
 * 
 * @author Christophe Bouhier
 * 
 */
public class NodesSummmary implements IMonitoringSummary {

	// Generated values.
	int subServices = 0;

	int[] ragCountNodes = new int[] { 0, 0, 0 };
	int[] ragCountResources = new int[] { 0, 0, 0 };

	/** The Red Amber Green Status for this service **/
	boolean[] ragStatus = new boolean[] { false, false, false };

	/** The period for this summary */
	private DateTimeRange period;

	/** The period formated as String for this summary */
	private String periodFormattedString = "";

	/** The summary of all nodes. */
	private List<NodeTypeSummary> nodeSummaries = Lists.newArrayList();

	public void addSummary(NodeTypeSummary summary) {
		if (!nodeSummaries.contains(summary)) {
			nodeSummaries.add(summary);
		}
	}

	public NodesSummmary(RFSService service) {
		this.countServices(service);
	}

	public void setPeriodFormattedString(String periodFormattedString) {
		this.periodFormattedString = periodFormattedString;
	}

	public String getPeriodFormattedString() {
		return periodFormattedString;
	}

	public boolean[] getRagStatus() {
		return ragStatus;
	}

	public void setRagStatus(boolean[] ragStatus) {
		this.ragStatus = ragStatus;
	}

	public void setRedStatus(boolean status) {
		ragStatus[0] = status;
	}

	public void setAmberStatus(boolean status) {
		ragStatus[1] = status;
	}

	public void setGreenStatus(boolean status) {
		ragStatus[2] = status;
	}

	public boolean getRedStatus() {
		return ragStatus[0];
	}

	public boolean getAmberStatus() {
		return ragStatus[1];
	}

	public boolean getGreenStatus() {
		return ragStatus[2];
	}

	public int[] getRagCountNodes() {
		return ragCountNodes;
	}

	public void setRagCountNodes(int[] rag) {
		this.ragCountNodes = rag;
	}

	public int[] getRagCountResources() {
		return ragCountResources;
	}

	public void setRagCountResources(int[] rag) {
		this.ragCountResources = rag;
	}

	public int getRedCountNodes() {
		return ragCountNodes[0];
	}

	public int getGreenCountNodes() {
		return ragCountNodes[2];
	}

	public int getAmberCountNodes() {
		return ragCountNodes[1];
	}

	public int getNodeCount() {
		return nodeSummaries.size();
	}

	public int getRedCountResources() {
		return ragCountResources[0];
	}

	public int getAmberCountResources() {
		return ragCountResources[1];
	}

	public int getGreenCountResources() {
		return ragCountResources[2];
	}

	public DateTimeRange getPeriod() {
		return period;
	}

	public void setPeriod(DateTimeRange period) {
		this.period = period;
	}

	public int getResourcesCount() {
		int resourceCount = 0;
		for (NodeTypeSummary ns : nodeSummaries) {
			resourceCount += ns.totalResources();
		}
		return resourceCount;
	}

	public int getSubServicesCount() {
		return subServices;
	}

	private void countServices(Service service) {
		this.countNodes(service);
		for (Service s : service.getServices()) {
			subServices += 1;
			if (s.getServices().size() > 0) {
				countServices(s);
			}
		}

	}

	private void countNodes(Service service) {
		if (service instanceof RFSService) {
			for (Node n : ((RFSService) service).getNodes()) {

				if (n.getNodeType() != null) {
					nodeSummaries.add(new NodeTypeSummary(n.getNodeType()));
				}
			}
		}
	}

}