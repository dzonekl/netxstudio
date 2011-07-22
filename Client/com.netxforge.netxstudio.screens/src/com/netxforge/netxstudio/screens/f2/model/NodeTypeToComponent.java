package com.netxforge.netxstudio.screens.f2.model;

import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NodeType;

public class NodeTypeToComponent {
	
	private final NodeType source;
	private final Component target;
	public NodeTypeToComponent(NodeType source, Component target) {
		super();
		this.source = source;
		this.target = target;
	}
	public NodeType getSource() {
		return source;
	}
	public Component getTarget() {
		return target;
	}
}
