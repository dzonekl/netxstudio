/*******************************************************************************
 * Copyright (c) Jun 15, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.interpreter;

import java.util.List;

import com.google.common.collect.ImmutableMap;
import com.netxforge.netxscript.Expression;
import com.netxforge.netxscript.Function;
import com.netxforge.netxscript.Mod;
import com.netxforge.netxstudio.library.ExpressionResult;

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

	/**
	 * Evaluate a single expression.
	 * 
	 * @param obj
	 * @return
	 */
	public abstract Object evaluate(Expression obj);

	/**
	 * Evaluate a single expression, with parameters.
	 * 
	 * @param obj
	 * @param values
	 * @return
	 */
	public abstract Object evaluate(Expression obj,
			ImmutableMap<String, Object> values);

	/**
	 * Get the expression result. 
	 * @return
	 */
	public abstract List<ExpressionResult> getResult();

}