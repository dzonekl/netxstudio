package com.netxforge.interpreter;

import com.netxforge.netxstudio.generics.DateTimeRange;

public class InterpreterContextFactory implements IInterpreterContextFactory {
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.IInterpreterContextFactory#createContext(T)
	 */
	public IInterpreterContext createContext(Object type ){
		return new ObjectContext<Object>(type);
	}

	public IInterpreterContext createPeriodContext(DateTimeRange dtr) {
		return new ObjectContext<DateTimeRange>(dtr);
	}
	
	
}
