package com.netxforge.netxstudio.screens.editing.selector;

public interface IDataInjection {
	
	/**
	 * Screens for which data is injected from the editing service. 
	 */
	public abstract void injectData();
	
	
	/**
	 * Screens for which data is injected with two parameters. 
	 */
	public abstract void injectData(Object owner, Object object);
	
	
	/**
	 * Arbitrary number of params for injection. 
	 * @param params
	 */
	public abstract void injectData(Object... params);
}
