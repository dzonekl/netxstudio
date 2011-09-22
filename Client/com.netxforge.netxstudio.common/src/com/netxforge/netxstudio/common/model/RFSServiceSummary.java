package com.netxforge.netxstudio.common.model;

import java.util.List;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

public class RFSServiceSummary {

	// Generated values.
	int subServices = 0;
	
	int[] ragCountNodes = new int[] { 0, 0, 0 };
	int[] ragCountResources = new int[] { 0, 0, 0 };
	
	boolean[] ragStatus = new boolean[] { false, false, false };

	String periodFormattedString = "";

	private List<NodeTypeSummary> nodeSummaries = Lists.newArrayList();

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
	
	public int getResourcesCount() {
		int resourceCount = 0;
		for(NodeTypeSummary ns : nodeSummaries){
			resourceCount += ns.getResourCount();
		}
		return resourceCount;
	}

	public int getSubServicesCount() {
		return subServices;
	}

	public RFSServiceSummary(RFSService service) {
		this.countServices(service);
	}
	
	private void countServices(Service service){
		this.countNodes(service);
		for(Service s : service.getServices()){
			subServices += 1;
			if(s.getServices().size() > 0 ){
				countServices(s);
			}
		}
		
	}

	private void countNodes(Service service) {
		if(service instanceof RFSService){
			for(Node n : ((RFSService) service).getNodes()){
				nodeSummaries.add(new NodeTypeSummary(n.getNodeType()));
			}
		}
	}
	
}