package com.netxforge.netxstudio.common.model;

import java.util.List;

import com.google.common.collect.Lists;

public class OperatorSummary {

	List<RFSServiceSummary> summaries = Lists.newArrayList();

	public void addSummary(RFSServiceSummary summary) {
		if (!summaries.contains(summary)) {
			summaries.add(summary);
		}
	}

	public int totalServices() {
		return summaries.size();
	}

	public int totalNodes() {
		int nodes = 0;
		for (RFSServiceSummary summary : summaries) {
			nodes += summary.getNodeCount();
		}
		return nodes;
	}

	public int totalRedServices() {
		int red = 0;
		for (RFSServiceSummary summary : summaries) {
			red += summary.getRagStatus()[0] ? 1 : 0;
		}
		return red;
	}

	public int totalAmberServices() {
		int amber = 0;
		for (RFSServiceSummary summary : summaries) {
			amber += summary.getRagStatus()[1] ? 1 : 0;
		}
		return amber;
	}

	public int totalGreenServices() {
		int green = 0;
		for (RFSServiceSummary summary : summaries) {
			green += summary.getRagStatus()[2] ? 1 : 0;
		}
		return green;
	}

	public int totalRedNodes() {
		int red = 0;
		for (RFSServiceSummary summary : summaries) {
			red += summary.getRedCountNodes();
		}
		return red;
	}

	public int totalAmberNodes() {
		int amber = 0;
		for (RFSServiceSummary summary : summaries) {
			amber += summary.getAmberCountNodes();
		}
		return amber;
	}

	public int totalGreenNodes() {
		int green = 0;
		for (RFSServiceSummary summary : summaries) {
			green += summary.getGreenCountNodes();
		}
		return green;
	}

	public int totalRedResources() {
		int resources = 0;
		for (RFSServiceSummary summary : summaries) {
			resources += summary.getRedCountResources();
		}
		return resources;
	}

	public int totalAmberResources() {
		int resources = 0;
		for (RFSServiceSummary summary : summaries) {
			resources += summary.getAmberCountResources();
		}
		return resources;
	}

	public int totalGreenResources() {
		int resources = 0;
		for (RFSServiceSummary summary : summaries) {
			resources += summary.getGreenCountResources();
		}
		return resources;
	}

	public int totalResources() {
		int resources = 0;
		for (RFSServiceSummary summary : summaries) {
			resources += summary.getResourcesCount();
		}
		return resources;
	}

}
