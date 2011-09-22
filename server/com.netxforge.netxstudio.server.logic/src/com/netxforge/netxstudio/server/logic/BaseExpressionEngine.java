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

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.scheduling.ExpressionFailure;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.server.logic.expression.IExpressionEngine;

/**
 * Common code for the engine implementations.
 * 
 * @author Martin Taal
 */
public abstract class BaseExpressionEngine extends BasePeriodEngine {

	// private ServerWorkFlowRunMonitor jobMonitor;

	// contains context information to use when adding an error message to the
	// log
	// private String engineContextInfo = "";

	// on purpose no @Inject as we need the same instance
	// as used in the job implementation
	// private IDataProvider dataProvider;

	// private Component component;

	@Inject
	private IExpressionEngine expressionEngine;

	// @Inject
	// private CommonLogic commonLogic;

	// @Inject
	// private ModelUtils modelUtils;

	// private DateTimeRange range;
	// private Date start;
	// private Date end;

	// private List<ExpressionFailure> failures = new
	// ArrayList<ExpressionFailure>();

	public void execute() {
		this.getFailures().clear();
		doExecute();
	}

	// public abstract void doExecute();

	protected abstract void processResult(List<Object> currentContext,
			List<BaseExpressionResult> expressionResults, Date start, Date end);

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

				processResult(currentContext, result, this.getStart(),
						this.getEnd());
			}
		} catch (final Throwable t) {

			// TODO, Perhaps hide this stack trace....
			t.printStackTrace(System.err);
			
			// TODO, We need some smarter interpretation of the throwables, 
			// to give instant feedback on the expression failures. 

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

	// public IDataProvider getDataProvider() {
	// return dataProvider;
	// }

	// public void setDataProvider(IDataProvider dataProvider) {
	// this.dataProvider = dataProvider;
	// commonLogic.setDataProvider(dataProvider);
	// }

	// public DateTimeRange getRange() {
	// return range;
	// }

	// public void setRange(DateTimeRange range) {
	// this.range = range;
	// start = modelUtils.fromXMLDate(range.getBegin());
	// end = modelUtils.fromXMLDate(range.getEnd());
	// commonLogic.setStart(start);
	// commonLogic.setEnd(end);
	// }

	// public Component getComponent() {
	// return component;
	// }

	// public void setComponent(Component component) {
	// this.component = component;
	// }

	// public List<ExpressionFailure> getFailures() {
	// return failures;
	// }

	public IExpressionEngine getExpressionEngine() {
		return expressionEngine;
	}

	// public CommonLogic getCommonLogic() {
	// return commonLogic;
	// }

	// public ModelUtils getModelUtils() {
	// return modelUtils;
	// }

	// public Date getStart() {
	// return start;
	// }

	// public Date getEnd() {
	// return end;
	// }
	//
	// public ServerWorkFlowRunMonitor getJobMonitor() {
	// return jobMonitor;
	// }
	//
	// public void setJobMonitor(ServerWorkFlowRunMonitor jobMonitor) {
	// this.jobMonitor = jobMonitor;
	// }
	//
	// public String getEngineContextInfo() {
	// return engineContextInfo;
	// }
	//
	// public void setEngineContextInfo(String engineContextInfo) {
	// this.engineContextInfo = engineContextInfo;
	// }

}
