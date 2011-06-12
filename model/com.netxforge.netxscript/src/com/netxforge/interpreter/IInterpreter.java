package com.netxforge.interpreter;

import com.google.common.collect.ImmutableMap;
import com.netxforge.netxscript.Expression;
import com.netxforge.netxscript.Function;
import com.netxforge.netxscript.Mod;

public interface IInterpreter {

	/**
	 * We execute the first function in the module. The subsequent functions,
	 * are considered internal and can be called from within the first function.
	 * Alternatively we execute the individual statements.
	 */
	public abstract Object evaluate(Mod module);

	/**
	 * The last statement of the function is returned.
	 * 
	 * @param function
	 * @return
	 */
	public abstract Object evaluate(Function function);

	// Dispatch methods, main entry class.
	public abstract Object evaluate(Expression obj);

	public abstract Object evaluate(Expression obj,
			ImmutableMap<String, Object> values);

}