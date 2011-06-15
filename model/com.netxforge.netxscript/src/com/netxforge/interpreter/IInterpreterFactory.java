package com.netxforge.interpreter;

public interface IInterpreterFactory {
	
	/**
	 * Create an Interpreter with a single context. 
	 * @param context
	 * @return
	 */
	public abstract IInterpreter create(IInterpreterContext context);
	
	
	/**
	 * Create an Interpreter with multiple context. 
	 * @param context
	 * @return
	 */
	
	public abstract IInterpreter create(IInterpreterContext... context);

}