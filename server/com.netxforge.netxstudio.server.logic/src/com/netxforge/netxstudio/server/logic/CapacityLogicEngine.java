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
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.ExpressionResult;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.scheduling.ExpressionFailure;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.server.logic.expression.IExpressionEngine;

/**
 * Performs the capacity logic execution for an equipment or function.
 * 
 * @author Martin Taal
 */
public class CapacityLogicEngine {

	// on purpose no @Inject as we need the same instance
	// as used in the job implementation
	private IDataProvider dataProvider;

	private Component component;

	@Inject
	private IExpressionEngine expressionEngine;

	private DateTimeRange range;

	private ExpressionFailure failure;

	public void execute() {
		expressionEngine.getContext().add(range);
		expressionEngine.getContext().add(getComponent());
		runForExpression(getCapacityExpression());
		if (failure != null) {
			return;
		}
		runForExpression(getUtilizationExpression());
		if (failure != null) {
			return;
		}
		for (final Tolerance tolerance : getTolerances()) {
			runForExpression(tolerance.getExpressionRef());
			if (failure != null) {
				return;
			}
		}
	}

	private void runForExpression(Expression expression) {
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
			final List<ExpressionResult> result = expressionEngine
					.getExpressionResult();
			// process the result
		} catch (final Throwable t) {
			failure = SchedulingFactory.eINSTANCE.createExpressionFailure();
			failure.setExpressionRef(expression);
			failure.setMessage(t.getMessage());
			failure.setComponentRef(component);
		}
	}

	public IDataProvider getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	protected Expression getCapacityExpression() {
		return component.getCapacityExpressionRef();
	}

	protected Expression getUtilizationExpression() {
		return component.getUtilizationExpressionRef();
	}

	protected List<Tolerance> getTolerances() {
		return component.getToleranceRefs();
	}

	public DateTimeRange getRange() {
		return range;
	}

	public void setRange(DateTimeRange range) {
		this.range = range;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public ExpressionFailure getFailure() {
		return failure;
	}

	public void setFailure(ExpressionFailure failure) {
		this.failure = failure;
	}

}
