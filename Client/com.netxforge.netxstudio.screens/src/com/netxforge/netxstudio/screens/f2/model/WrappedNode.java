package com.netxforge.netxstudio.screens.f2.model;

import com.netxforge.netxstudio.operators.Node;

public class WrappedNode {

	private Node n;

	public WrappedNode(Node n) {
		this.n = n;
	}
	
	public Node getNode(){
		return n;
	}
	
}
