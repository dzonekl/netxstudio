/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Martin Taal - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.logic.workflow;

import com.google.inject.Inject;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.server.logic.expression.IExpressionEngine;


/**
 * Models a work flow step which executes an expression.
 * 
 * @author Martin Taal
 */
public class ExpressionWorkFlowStep {
	
	private Expression expression;
	
	@Inject
	private IExpressionEngine expressionEngine;
	
	
	public void run() {
		expressionEngine.run();		
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
}
