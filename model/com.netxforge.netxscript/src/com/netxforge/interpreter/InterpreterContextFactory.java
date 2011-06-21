package com.netxforge.interpreter;

import com.netxforge.netxstudio.generics.DateTimeRange;

public class InterpreterContextFactory implements IInterpreterContextFactory {
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.IInterpreterContextFactory#createContext(T)
	 */
	@Override
	public IInterpreterContext createContext(Object type ){
		return new ObjectContext<Object>(type);
	}

	@Override
	public IInterpreterContext createPeriodContext(DateTimeRange dtr) {
		return new ObjectContext<DateTimeRange>(dtr);
	}
	
	
}
