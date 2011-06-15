package com.netxforge.interpreter;

import com.netxforge.netxstudio.generics.DateTimeRange;

public class InterpreterContextFactory<T extends Object> implements IInterpreterContextFactory<T> {
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.IInterpreterContextFactory#createContext(T)
	 */
	@Override
	public IInterpreterContext createContext(T type ){
		return new ObjectContext<T>(type);
	}

	@Override
	public IInterpreterContext createPeriodContext(DateTimeRange dtr) {
		return new ObjectContext<DateTimeRange>(dtr);
	}
	
	
}
