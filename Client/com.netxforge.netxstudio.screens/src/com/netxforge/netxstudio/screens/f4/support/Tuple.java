package com.netxforge.netxstudio.screens.f4.support;

public class Tuple {

	public Tuple(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	protected Object key;
	protected Object value;
	
	
}
