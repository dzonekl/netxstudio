package com.netxforge.netxstudio.screens.f1.model;

import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.services.RFSService;

public class RFServiceToNode {
	
	private final RFSService source;
	private final Node target;
	public RFServiceToNode(RFSService source, Node target) {
		super();
		this.source = source;
		this.target = target;
	}
	public RFSService getSource() {
		return source;
	}
	public Node getTarget() {
		return target;
	}
}
