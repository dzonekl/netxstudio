package com.netxforge.netxstudio.screens.editing;

import java.util.Set;

import org.eclipse.emf.cdo.CDOObject;

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
	
	
	/**
	 * Screens can implement, to have injection occur automatically, 
	 * when a server invalidation occurs.
	 * 
	 * @return
	 */
	public abstract boolean shouldInjectForObject(Set<CDOObject> injectionSet);
	
}
