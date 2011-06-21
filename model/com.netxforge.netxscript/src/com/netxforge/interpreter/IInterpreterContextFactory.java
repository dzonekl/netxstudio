package com.netxforge.interpreter;

import com.netxforge.netxstudio.generics.DateTimeRange;

public interface IInterpreterContextFactory {

	public abstract IInterpreterContext createContext(Object type);

	public abstract IInterpreterContext createPeriodContext(DateTimeRange dtr);
	
}