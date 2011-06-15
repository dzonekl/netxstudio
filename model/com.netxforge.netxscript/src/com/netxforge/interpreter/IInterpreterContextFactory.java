package com.netxforge.interpreter;

import com.netxforge.netxstudio.generics.DateTimeRange;

public interface IInterpreterContextFactory<T extends Object> {

	public abstract IInterpreterContext createContext(T type);

	public abstract IInterpreterContext createPeriodContext(DateTimeRange dtr);
	
}