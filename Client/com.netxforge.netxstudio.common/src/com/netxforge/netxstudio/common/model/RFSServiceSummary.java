package com.netxforge.netxstudio.common.model;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

public class RFSServiceSummary {

	// Generated values.
	int subServices = 0;
	
	int nodes = 0;
	int resources = 0;

	int[] ragCountNodes = new int[] { 0, 0, 0 };
	int[] ragCountResources = new int[] { 0, 0, 0 };
	
	boolean[] ragStatus = new boolean[] { false, false, false };

	String periodFormattedString = "";

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
		return nodes;
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
	
	public int getResourcesCount() {
		return resources;
	}

	public int getSubServicesCount() {
		return subServices;
	}

	public RFSServiceSummary(ModelUtils modelUtils, RFSService service) {
		TreeIterator<EObject> iterator = service.eAllContents();
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (next instanceof Service) {
				subServices += 1;
				nodes += service.getNodes().size();
				for (Node node : service.getNodes()) {
					resources += modelUtils.allResources(node).size();
				}
			}
		}
	}
}