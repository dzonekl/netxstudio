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
package com.netxforge.netxstudio.server.logic;

import java.util.List;

import com.google.inject.Inject;
import com.netxforge.engine.IExpressionEngine;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.scheduling.ExpressionFailure;
import com.netxforge.netxstudio.scheduling.Failure;

/**
 * Common code for the engine implementations.
 * 
 * @author Martin Taal
 */
public abstract class BaseExpressionEngine extends BaseEngine {

	@Inject
	private IExpressionEngine expressionEngine;

	public void execute() {
		this.getFailures().clear();
		doExecute();
	}

//	protected abstract void processResult(List<Object> currentContext,
//			List<BaseExpressionResult> expressionResults, Date start, Date end);
	
	protected abstract void processResult(List<Object> currentContext,
			List<BaseExpressionResult> result, DateTimeRange period);
	
	protected void runForExpression(Expression expression) {
		try {
			if (expression == null) {
				return;
			}
			expressionEngine.setExpression(expression);

			expressionEngine.run();
			if (expressionEngine.errorOccurred()) {
				// stop here will be logged
				throw new IllegalStateException(expressionEngine.getThrowable());
			}
			final List<BaseExpressionResult> result = expressionEngine
					.getExpressionResult();

			if (result.isEmpty() && this.getJobMonitor() != null) {
				throw new IllegalStateException(this.getEngineContextInfo()
						+ " expression returns no results for expression "
						+ expression.getName());
			} else {
				final List<Object> currentContext = expressionEngine
						.getContext();
				// Move to DTR. 
//				processResult(currentContext, result, this.getStart(),
//						this.getEnd());
				processResult(currentContext, result, this.getPeriod());
				
			}
		} catch (final Throwable t) {

			StringBuilder sb = new StringBuilder();
			sb.append(t.getMessage());

			if (t.getCause() != null) {
				sb.append(t.getCause().getMessage());
			}

			ExpressionFailure failure = (ExpressionFailure) getFailure();
			failure.setExpressionRef(expression);
			failure.setMessage(sb.toString());
			getFailures().add(failure);
		}
	}

	public abstract Failure getFailure();

	public IExpressionEngine getExpressionEngine() {
		return expressionEngine;
	}
}
