/*******************************************************************************
 * Copyright (c) May 12, 2011 NetXForge.
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
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.data.services;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netxforge.base.NonModelUtils;
import com.netxforge.base.context.ObjectContext;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.data.internal.DataActivator;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.library.ExpressionResult;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.RangeKind;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.services.DerivedResource;

/**
 * This class is a supporting class for processing results from Expression
 * Evaluations {@link ExpressionResult } and also directly processing Value
 * results from imports. </p> When an Expression Result involves a tolerance
 * {@link ValueRange range}, the {@link ToleranceProcessor} is invoked. It needs
 * to be configured with a {@link ResourceMonitor} and a {@link Tolerance}
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
@Singleton
public class ResultProcessor {

	@Inject
	private ToleranceProcessor tolProcessor;

	@Inject
	private ValueProcessor valueProcessor;

	/**
	 * Process a Service Profile calculation result.
	 * 
	 * @param currentContext
	 * @param expressionResults
	 * @param start
	 * @param end
	 */
	@SuppressWarnings("deprecation")
	public void processServiceProfileResult(List<Object> currentContext,
			List<BaseExpressionResult> expressionResults, Date start, Date end) {
		for (final BaseExpressionResult baseExpressionResult : expressionResults) {

			if (baseExpressionResult instanceof ExpressionResult) {
				ExpressionResult expressionResult = (ExpressionResult) baseExpressionResult;

				if (DataActivator.DEBUG) {
					DataActivator.TRACE
							.trace(DataActivator.TRACE_RESULT_EXPRESSION_OPTION,
									"writing expression result: resource="
											+ expressionResult
													.getTargetResource()
													.getShortName()
											+ " target="
											+ expressionResult.getTargetRange()
													.getName()
											+ " values="
											+ expressionResult
													.getTargetValues().size());
				}

				// FIXME: We could want to write to a resource, where the node
				// doesn't match the context.
				final BaseResource baseResource = expressionResult
						.getTargetResource();

				// Process a DerivedResource

				if (baseResource instanceof DerivedResource) {
					DerivedResource resource = (DerivedResource) baseResource;
					if (expressionResult.getTargetRange().getValue() == RangeKind.DERIVED_VALUE) {

						// TODO Decide, what to do with the existing values.
						valueProcessor.addToValues(resource.getValues(),
								expressionResult.getTargetValues(),
								expressionResult.getTargetIntervalHint());
					} else {
						throw new IllegalStateException("Range kind "
								+ expressionResult.getTargetRange()
								+ " not supported");
					}
				}
			}
		}
	}

	public ToleranceProcessor getToleranceProcessor() {
		return tolProcessor;
	}

	/**
	 * Write an {@link ExpressionResult} for a give collection of
	 * {@link ObjectContext} with a give {@link DateTimeRange period}.
	 * 
	 * The write mode is forced to
	 * {@link ValueProcessor#INDIFFERENT_VALUES_IN_INTERVAL_MODE}.
	 * 
	 * 
	 * @param currentContext
	 * @param expressionResults
	 * @param period
	 */
	public void processMonitoringResult(List<Object> currentContext,
			List<BaseExpressionResult> expressionResults, DateTimeRange period) {
		this.processMonitoringResult(currentContext, expressionResults, period,
				ValueProcessor.INDIFFERENT_VALUES_IN_INTERVAL_MODE);
	}

	/**
	 * Write an {@link ExpressionResult} for a give collection of
	 * {@link ObjectContext} with a give {@link DateTimeRange period}.
	 * 
	 * @param currentContext
	 * @param expressionResults
	 * @param period
	 * @param writeMode
	 */
	public void processMonitoringResult(List<Object> currentContext,
			List<BaseExpressionResult> expressionResults, DateTimeRange period,
			int writeMode) {
		for (final BaseExpressionResult baseExpressionResult : expressionResults) {
			if (baseExpressionResult instanceof ExpressionResult) {
				ExpressionResult expressionResult = (ExpressionResult) baseExpressionResult;
				// processMonitoringExpressionResult(start, end,
				// expressionResult);
				processMonitoringExpressionResult(period, expressionResult,
						writeMode);
			}
		}
	}

	/**
	 * Do the actual processing of the {@link ExpressionResult result}
	 * 
	 * @param period
	 * @param expressionResult
	 * @param writeMode
	 */
	@SuppressWarnings("deprecation")
	private void processMonitoringExpressionResult(DateTimeRange period,
			ExpressionResult expressionResult, int writeMode) {

		// FIXME: We could want to write to a resource, where the node
		// doesn't match the context. The original context Node is not known
		// here.
		final BaseResource baseResource = expressionResult.getTargetResource();

		// Process a NetXResource
		if (baseResource instanceof NetXResource) {

			NetXResource resource = (NetXResource) baseResource;

			final Node n = StudioUtils.nodeFor(resource.getComponentRef());

			final Date start = NonModelUtils.fromXMLDate(period.getBegin());
			final Date end = NonModelUtils.fromXMLDate(period.getEnd());

			// Bail when we have no values in the result!
			if (expressionResult.getTargetValues() == null
					|| expressionResult.getTargetValues().isEmpty()) {

				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_RESULT_EXPRESSION_OPTION,
							"skip expression result: resource="
									+ expressionResult.getTargetResource()
											.getShortName()
									+ " target="
									+ expressionResult.getTargetRange()
											.getName()
									+ " interval="
									+ expressionResult.getTargetIntervalHint()
									+ " kind = "
									+ expressionResult.getTargetKindHint()
											.getName()
									+ " values="
									+ expressionResult.getTargetValues().size()
									+ " from="
									+ start
									+ " to="
									+ end
									+ " node="
									+ n.getNodeID()
									+ " comp="
									+ StudioUtils.componentName(resource
											.getComponentRef()));
				}
				return;

			}

			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_RESULT_EXPRESSION_OPTION,
						"writing expression result: resource="
								+ expressionResult.getTargetResource()
										.getShortName()
								+ " target="
								+ expressionResult.getTargetRange().getName()
								+ " interval="
								+ expressionResult.getTargetIntervalHint()
								+ " kind = "
								+ expressionResult.getTargetKindHint()
										.getName()
								+ " values="
								+ expressionResult.getTargetValues().size()
								+ " from="
								+ start
								+ " to="
								+ end
								+ " node="
								+ n.getNodeID()
								+ " comp="
								+ StudioUtils.componentName(resource
										.getComponentRef()));
			}

			switch (expressionResult.getTargetRange().getValue()) {
			case RangeKind.CAP_VALUE:
				// Remove previous values within the range.
				valueProcessor.removeValues(resource.getCapacityValues(),
						start, end);
				valueProcessor.addToValues(resource.getCapacityValues(),
						expressionResult.getTargetValues(),
						expressionResult.getTargetIntervalHint());
				break;
			case RangeKind.METRIC_VALUE:

				// Explictly set the write mode.
				valueProcessor.addToValueRange(resource,
						expressionResult.getTargetIntervalHint(),
						expressionResult.getTargetKindHint(),
						expressionResult.getTargetValues(), start, end,
						writeMode);

				break;
			case RangeKind.TOLERANCE_VALUE: {
				if (tolProcessor != null && tolProcessor.ready()) {
					tolProcessor.markersForExpressionResult(expressionResult,
							period);
				} else {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_RESULT_EXPRESSION_OPTION,
							"Can't process tolerance, processor not ready");
				}
			}
				break;
			case RangeKind.UTILIZATION_VALUE:
				valueProcessor.removeValues(resource.getUtilizationValues(),
						start, end);
				valueProcessor.addToValues(resource.getUtilizationValues(),
						expressionResult.getTargetValues(),
						expressionResult.getTargetIntervalHint());
				break;
			case RangeKind.METRICREMOVE_VALUE:
				valueProcessor.removeValues(expressionResult.getTargetValues());
				break;
			default:
				throw new IllegalStateException("Range kind "
						+ expressionResult.getTargetRange() + " not supported");
			}
		}

		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(
					DataActivator.TRACE_RESULT_EXPRESSION_OPTION,
					"done processing monitoring result");
		}
	}
}