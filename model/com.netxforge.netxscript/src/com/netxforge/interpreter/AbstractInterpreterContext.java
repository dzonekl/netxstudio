package com.netxforge.interpreter;

public abstract class AbstractInterpreterContext implements IInterpreterContext {
	
	protected int contextKind = UNSET;
	
	@Override
	public abstract Object getContext();
	
	@Override
	public int getKind(){
		return contextKind;
	}
	
	public boolean isModelObject(){
		return contextKind == MODEL_OBJECT;
	}
	
	public boolean isModelPeriod(){
		return contextKind == MODEL_PERIOD;
	}

}
