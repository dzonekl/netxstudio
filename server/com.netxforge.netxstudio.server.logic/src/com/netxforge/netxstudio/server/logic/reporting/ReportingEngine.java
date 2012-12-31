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
package com.netxforge.netxstudio.server.logic.reporting;

import java.util.List;
import java.util.Map;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.LastEvaluationExpressionResult;
import com.netxforge.netxstudio.library.LevelKind;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.scheduling.ExpressionFailure;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.services.RFSService;

/**
 * Performs the resource reporting execution for service tolerance expressions,
 * writes directly in the target excel sheet.
 * 
 * @author Martin Taal
 * @author Christophe Bouhier.
 */

public class ReportingEngine extends BaseServiceEngine {

	Tolerance tolerance;

	@Override
	public void doExecute() {

		System.err.println("Run reporting for Service: "
				+ this.getService().getServiceName());

		if (this.getService() instanceof RFSService) {

			RFSService service = (RFSService) this.getService();

			getExpressionEngine().getContext().clear();
			getExpressionEngine().getContext().add(getPeriod());
			getExpressionEngine().getContext().add(service);
			getExpressionEngine().getContext().add(getServiceSummary());

			for (final Tolerance tolerance : service.getToleranceRefs()) {
				this.tolerance = tolerance;
				setEngineContextInfo("Service: " + service.getServiceName()
						+ " - tolerance expression -");
				runForExpression(tolerance.getExpressionRef());
				if (getFailures().size() > 0) {
					return;
				}
			}
		}
	}

	@Override
	public Failure getFailure() {
		final ExpressionFailure failure = SchedulingFactory.eINSTANCE
				.createExpressionFailure();
		return failure;
	}

	@Override
	protected void processResult(List<Object> currentContext,
			List<BaseExpressionResult> expressionResults, DateTimeRange period) {

		for (final BaseExpressionResult expressionResult : expressionResults) {

			if (expressionResult instanceof LastEvaluationExpressionResult) {
				Object result = ((LastEvaluationExpressionResult) expressionResult)
						.getLastEvalResult();

				// Will always return a HashMap<String, Object>
				// Iterate over the results, and look for an entry returning a
				// boolean.
				if (result instanceof Map<?, ?>) {
					@SuppressWarnings("unchecked")
					Map<String, Object> resultMap = (Map<String, Object>) result;
					for (String s : resultMap.keySet()) {
						Object entry = resultMap.get(s);
						// For this we expect a boolean....
						if (entry instanceof Boolean) {
							if (tolerance != null) {
								switch (tolerance.getLevel().getValue()) {
								case LevelKind.RED_VALUE: {
									getServiceSummary().setRedStatus(
											((Boolean) entry).booleanValue());
								}
									break;
								case LevelKind.AMBER_VALUE: {
									if (!getServiceSummary().getRedStatus()) {
										getServiceSummary().setAmberStatus(
												((Boolean) entry)
														.booleanValue());
									}
								}
									break;
								case LevelKind.GREEN_VALUE: {
									if (!getServiceSummary().getRedStatus()
											&& !getServiceSummary()
													.getAmberStatus()) {
										getServiceSummary().setGreenStatus(
												((Boolean) entry)
														.booleanValue());
									}
								}
									break;
								}
							}
						}
					}
				}
			}
		}
	}
}
