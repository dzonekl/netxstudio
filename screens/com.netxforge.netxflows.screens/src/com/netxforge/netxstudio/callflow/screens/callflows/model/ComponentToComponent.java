package com.netxforge.netxstudio.callflow.screens.callflows.model;

import com.netxforge.netxstudio.library.Component;

public class ComponentToComponent {
	
	private final Component source;
	private final Component target;
	public ComponentToComponent(Component source, Component target) {
		super();
		this.source = source;
		this.target = target;
	}
	public Component getSource() {
		return source;
	}
	public Component getTarget() {
		return target;
	}
}
