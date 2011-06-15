package com.netxforge.interpreter;

public class InterpreterFactory implements IInterpreterFactory {
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.IInterpreterFactory#create(com.netxforge.interpreter.IInterpreterContext)
	 */
	@Override
	public IInterpreter create(IInterpreterContext context){
		return new InterpreterTypeless(context);
	}

	@Override
	public IInterpreter create(IInterpreterContext... context) {
		return new InterpreterTypeless(context);
	};
	
}
