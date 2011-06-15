package com.netxforge.interpreter;

import com.google.inject.Provider;

public class InterpreterProvider implements Provider<IInterpreter>{
	
	IInterpreterContext context; 
	
	public InterpreterProvider(IInterpreterContext context){
		this.context = context;
	}
	
	@Override
	public IInterpreter get() {
		return new InterpreterTypeless(context);
	}

}
