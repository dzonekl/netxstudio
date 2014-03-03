package com.netxforge.base.context;

import java.util.List;

public interface IComputationContextProvider {

	public abstract void addContextObject(IComputationContext object);

	public abstract void addContextObjects(IComputationContext... objects);

	public abstract void clearContextObjects();

	public abstract IComputationContext[] getContextObjects();

	public abstract List<IComputationContext> getContextObjectsAsList();

}