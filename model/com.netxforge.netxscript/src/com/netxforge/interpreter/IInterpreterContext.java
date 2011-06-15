package com.netxforge.interpreter;

public interface IInterpreterContext {
	
	
	public static final int UNSET = 0;
	public static final int MODEL_OBJECT = 1;
	public static final int MODEL_PERIOD = 2;
	
	public abstract Object getContext();
	
	public abstract int getKind();
	
	
}
