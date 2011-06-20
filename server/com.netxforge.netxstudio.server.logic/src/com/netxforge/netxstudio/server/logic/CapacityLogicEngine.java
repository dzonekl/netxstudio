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
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.ExpressionResult;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.server.logic.expression.IExpressionEngine;

/**
 * Performs the capacity logic execution for an equipment or function.
 * 
 * @author Martin Taal
 */
public abstract class CapacityLogicEngine {

	// on purpose no @Inject as we need the same instance
	// as used in the job implementation
	private IDataProvider dataProvider;

	@Inject
	private IExpressionEngine expressionEngine;
	
	private DateTimeRange range;
	
	public void execute() {
		expressionEngine.getContext().add(range);
		expressionEngine.getContext().add(getTarget());
		runForExpression(getCapacityExpression());
		runForExpression(getUtilizationExpression());
		for (final Tolerance tolerance : getTolerances()) {
			runForExpression(tolerance.getExpressionRef());
		}
	}
	
	private void runForExpression(Expression expression) {
		if (expression == null) {
			return;
		}
		expressionEngine.setExpression(expression);
		expressionEngine.run();
		if (expressionEngine.errorOccurred()) {
			// stop here will be logged
			throw new IllegalStateException(expressionEngine.getThrowable());
		}
		final List<ExpressionResult> result = expressionEngine.getExpressionResult();
		// process the result
	}
	
	public IDataProvider getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}
	
	protected abstract Object getTarget();

	protected abstract Expression getCapacityExpression();
	
	protected abstract Expression getUtilizationExpression();
	
	protected abstract List<Tolerance> getTolerances();

	public static class CapacityLogicEquipment extends CapacityLogicEngine {
		private Equipment equipment;
		
		@Override
		protected Object getTarget() {
			return equipment;
		}

		@Override
		protected Expression getCapacityExpression() {
			return equipment.getCapacityExpressionRef();
		}
		
		@Override
		protected Expression getUtilizationExpression() {
			return equipment.getUtilizationExpressionRef();
		}
		
		@Override
		protected List<Tolerance> getTolerances() {
			return equipment.getToleranceRefs();
		}

		public Equipment getEquipment() {
			return equipment;
		}

		public void setEquipment(Equipment equipment) {
			this.equipment = equipment;
		}		
	}

	public static class CapacityLogicFunction extends CapacityLogicEngine {
		private Function function;
		
		@Override
		protected Object getTarget() {
			return function;
		}

		@Override
		protected Expression getCapacityExpression() {
			return function.getCapacityExpressionRef();
		}
		
		@Override
		protected Expression getUtilizationExpression() {
			return function.getUtilizationExpressionRef();
		}
		
		@Override
		protected List<Tolerance> getTolerances() {
			return function.getToleranceRefs();
		}

		public Function getFunction() {
			return function;
		}

		public void setFunction(Function function) {
			this.function = function;
		}		
	}

	public DateTimeRange getRange() {
		return range;
	}

	public void setRange(DateTimeRange range) {
		this.range = range;
	}

}
