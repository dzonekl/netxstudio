package com.netxforge.netxstudio.callflow.screens.callflows.model;

import com.netxforge.netxstudio.library.NodeType;

public class WrappedNodeType {

	private NodeType nt;

	public WrappedNodeType(NodeType nt) {
		this.nt = nt;
	}
	
	public NodeType getNodeType(){
		return nt;
	}
	
}
