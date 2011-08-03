package com.netxforge.netxstudio.models.export.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.xtend.expression.Variable;

import com.netxforge.netxstudio.models.export.XpandTemplate;

public abstract class XpandTemplateImpl implements XpandTemplate {
	

	public void xpand(IResource outRes) {
		assert target != null;
		assert outRes != null;
	}

	protected Map<String, Variable> map = new HashMap<String, Variable>();
	protected Object target;	
	
	public void setGlobalVarsMap(Map<String, Variable> map) {
		this.map = map;
	}
	
	public Map<String, Variable> getGlobalVarsMap() {
		return map;
	}

	public void setTargetObject(Object target) {
		this.target = target;
	}
	
	
	
}

