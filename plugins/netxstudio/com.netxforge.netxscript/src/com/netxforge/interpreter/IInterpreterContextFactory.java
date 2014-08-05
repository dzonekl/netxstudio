package com.netxforge.interpreter;

import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.google.common.collect.Lists;
import com.netxforge.base.context.IComputationContext;
import com.netxforge.netxstudio.generics.DateTimeRange;

public interface IInterpreterContextFactory {
	
	// Typical expressions, and the expected contexts for these. 
	public static final String EXPRESSION_COMPONENT_FREE = "Free";
	public static final String EXPRESSION_COMPONENT_CAPACITY = "Capacity";
	public static final String EXPRESSION_COMPONENT_UTILIZATION = "Utilization";
	public static final String EXPRESSION_TOLERANCE = "Tolerance";
	public static final String EXPRESSION_SERVICE_USER = "Service User";
	public static final String EXPRESSION_DATA_RETENTION = "Data Retention";
	public static final String EXPRESSION_SERVIE_TOLERANCE = "Service Tolerance";
	
	public static final List<EClass> CAPACITY_CONTEXT_CLASSES = Lists.newArrayList();
	public static final List<EClass> RESOURCE_CONTEXT_CLASSES = Lists.newArrayList();
	public static final List<EClass> SERVICE_USER_CONTEXT_CLASSES = Lists.newArrayList();
	
	/**
	 * Create a Context object holding the type. 
	 * @param type
	 * @return
	 */
	public abstract IComputationContext createContext(Object type);

	/**
	 * 
	 * @param dtr
	 * @return
	 */
	public abstract IComputationContext createPeriodContext(DateTimeRange dtr);
	
}