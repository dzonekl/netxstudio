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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.ExpressionResult;
import com.netxforge.netxstudio.scheduling.ExpressionFailure;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.server.CommonLogic;
import com.netxforge.netxstudio.server.job.WorkFlowRunMonitor;
import com.netxforge.netxstudio.server.logic.expression.IExpressionEngine;

/**
 * Common code for the engine implementations.
 * 
 * @author Martin Taal
 */
public abstract class BaseEngine {

	private WorkFlowRunMonitor jobMonitor;
		
	// contains context information to use when adding an error message to the
	// log
	private String engineContextInfo = "";

	// on purpose no @Inject as we need the same instance
	// as used in the job implementation
	private IDataProvider dataProvider;

	private Component component;

	@Inject
	private IExpressionEngine expressionEngine;

	@Inject
	private CommonLogic commonLogic;

	@Inject
	private ModelUtils modelUtils;

	private DateTimeRange range;
	private Date start;
	private Date end;

	private List<ExpressionFailure> failures = new ArrayList<ExpressionFailure>();
	
	public void execute() {
		failures.clear();
		doExecute();
	}
	
	public abstract void doExecute();

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
			final List<ExpressionResult> result = expressionEngine
					.getExpressionResult();
			
			if (result.isEmpty() && jobMonitor != null) {
				throw new IllegalStateException(engineContextInfo
						+ " expression returns no results for expression " + expression.getName());
			} else {
				final List<Object> currentContext = expressionEngine
						.getContext();

				// process the result
				commonLogic.processResult(currentContext, result, start, end);
			}
		} catch (final Throwable t) {
			t.printStackTrace(System.err);
			final ExpressionFailure failure = SchedulingFactory.eINSTANCE.createExpressionFailure();
			failure.setExpressionRef(expression);
			failure.setMessage(t.getMessage());
			failure.setComponentRef(component);
			failures.add(failure);
		}
	}

	public IDataProvider getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
		commonLogic.setDataProvider(dataProvider);
	}

	public DateTimeRange getRange() {
		return range;
	}

	public void setRange(DateTimeRange range) {
		this.range = range;
		start = modelUtils.fromXMLDate(range.getBegin());
		end = modelUtils.fromXMLDate(range.getEnd());
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public List<ExpressionFailure> getFailures() {
		return failures;
	}

	public IExpressionEngine getExpressionEngine() {
		return expressionEngine;
	}

	public CommonLogic getCommonLogic() {
		return commonLogic;
	}

	public ModelUtils getModelUtils() {
		return modelUtils;
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	public WorkFlowRunMonitor getJobMonitor() {
		return jobMonitor;
	}

	public void setJobMonitor(WorkFlowRunMonitor jobMonitor) {
		this.jobMonitor = jobMonitor;
	}

	public String getEngineContextInfo() {
		return engineContextInfo;
	}

	public void setEngineContextInfo(String engineContextInfo) {
		this.engineContextInfo = engineContextInfo;
	}

}
