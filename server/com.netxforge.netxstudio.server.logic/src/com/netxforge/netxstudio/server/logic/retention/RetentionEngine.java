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
package com.netxforge.netxstudio.server.logic.retention;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.data.importer.ResultProcessor;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.scheduling.ComponentFailure;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;
import com.netxforge.netxstudio.server.logic.monitoring.BaseComponentEngine;

/**
 * Performs the retention action for a component.
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public class RetentionEngine extends BaseComponentEngine {

	private MetricRetentionRules rules;

	private List<MetricRetentionRule> metricRulesSortedList = null;

	/**
	 * In this mode we clear the complete contents of a resource, without
	 * aggregation.
	 */
	private static final int MODE_CLEAR = 100;

	/**
	 * In this mode we aggregate data as specified by the
	 * {@link MetricRetentionRule retention rules} prior to clearing the content
	 * of a resource. The clearing respects the retention period defined per
	 * measuring interval.
	 */
	private static final int MODE_AGGREGATE_THEN_CLEAR = 200;

	private int operations_mode = MODE_CLEAR;

	@Inject
	private ResultProcessor resultProcessor;

	@Inject
	private IQueryService queryService;

	@Override
	public void doExecute() {

		if (LogicActivator.DEBUG) {
			LogicActivator.TRACE.trace(
					LogicActivator.TRACE_RETENTION_OPTION,
					"data retention for : "
							+ this.getModelUtils().printModelObject(
									getComponent()) + " # resources: "
							+ this.getComponent().getResourceRefs().size());
		}

		// Order the rules by smallest interval.
		if (metricRulesSortedList == null) {
			metricRulesSortedList = Ordering.from(
					getModelUtils().retentionRuleCompare()).sortedCopy(
					rules.getMetricRetentionRules());
			if (LogicActivator.DEBUG) {
				LogicActivator.TRACE.trace(
						LogicActivator.TRACE_RETENTION_OPTION,
						"Processing retention rule in order: ");
				for (MetricRetentionRule rule : metricRulesSortedList) {
					StringBuilder sb = new StringBuilder();
					sb.append(rule.getName());
					sb.append(" interval:" + rule.getIntervalHint());
					sb.append(" rule: " + rule.getPeriod());
					// sb.append(rule.getRetentionExpression() + " ");
					LogicActivator.TRACE.trace(
							LogicActivator.TRACE_RETENTION_OPTION,
							sb.toString());
				}
			}
		}

		// Run for each resource, each retention rule.
		for (final NetXResource netXResource : getComponent().getResourceRefs()) {

			// Rules should execute considering the order of the smallest
			// interval first,
			// as to allow aggregation.

			// Two pass run.
			// Pass 1. Aggregate data using the defined expressions for each of
			// the mr rules. Optional depending on the model.

			if (operations_mode == MODE_AGGREGATE_THEN_CLEAR) {
				for (MetricRetentionRule rule : metricRulesSortedList) {

					Expression expression = rule.getRetentionExpression();

					if (expression != null) {

						// Data will be aggregated for the period specified by
						// the
						// logic period.
						// For clearing data however, we need to set the
						// MetricRetentionRule in the Interpreter.

						getExpressionEngine().getContext().clear();

						getExpressionEngine().getContext().add(getPeriod());
						getExpressionEngine().getContext().add(
								this.getModelUtils().nodeFor(getComponent()));
						getExpressionEngine().getContext().add(netXResource);
						getExpressionEngine().getContext().add(rule);

						runForExpression(expression);
					}
				}
			} else if (operations_mode == MODE_CLEAR) {

				List<MetricValueRange> mvrs = Lists.newArrayList();
				
				for (MetricValueRange mvr : netXResource.getMetricValueRanges()) {
						mvrs.add(mvr);
						// The total amount of work....
						int metricValues = mvr.getMetricValues().size();
						resultProcessor.removeValues(mvr.getMetricValues());

						if (LogicActivator.DEBUG) {
							LogicActivator.TRACE.trace(
									LogicActivator.TRACE_RETENTION_OPTION,
									"Cleared metric values total= "
											+ metricValues
											+ ", from resource "
											+ this.getModelUtils()
													.printModelObject(
															netXResource)
											+ " interval= "
											+ mvr.getIntervalHint());

						}
				}
				
				netXResource.getMetricValueRanges().removeAll(mvrs);
				
				int totalValues = netXResource.getUtilizationValues().size()
						+ netXResource.getCapacityValues().size();

				resultProcessor.removeValues(netXResource
						.getUtilizationValues());
				resultProcessor.removeValues(netXResource.getCapacityValues());

				if (LogicActivator.DEBUG) {
					LogicActivator.TRACE.trace(
							LogicActivator.TRACE_RETENTION_OPTION,
							"Cleared cap & util values total= "
									+ totalValues
									+ ", from resource "
									+ this.getModelUtils().printModelObject(
											netXResource));

				}

			} else if (operations_mode == MODE_AGGREGATE_THEN_CLEAR) {

				// Pass 2. Clean. determine the aggregation period.
				for (MetricRetentionRule rule : metricRulesSortedList) {

					@SuppressWarnings("unused")
					DateTimeRange dtr = null;
					// If DTR is null, we keep all values.
					dtr = this.getModelUtils().getDTRForRetentionRule(
							rule,
							this.getModelUtils().fromXMLDate(
									this.getPeriod().getEnd()));
					// TODO Use a query to remove all the values in DTR.

					// // NOTE Expression based clearing is only possible in
					// combination with aggregation, as
					// we can't execute a combined expression multiple times.

					// Expression expression = rule.getRetentionExpression();
					// if (expression != null) {
					//
					// // Data will be aggregated for the period specified by
					// the
					// // logic period.
					// // For clearing data however, we need to set the
					// // MetricRetentionRule in the Interpreter.
					//
					// getExpressionEngine().getContext().clear();
					//
					// getExpressionEngine().getContext().add(dtr);
					// getExpressionEngine().getContext().add(
					// this.getModelUtils().nodeFor(getComponent()));
					// getExpressionEngine().getContext().add(netXResource);
					// getExpressionEngine().getContext().add(rule);
					//
					// runForExpression(expression);
					// }
				}
			}

		}

	}

	@Override
	public Failure getFailure() {
		ComponentFailure f = SchedulingFactory.eINSTANCE
				.createComponentFailure();
		f.setComponentRef(this.getComponent());
		return f;
	}

	@Override
	protected void processResult(List<Object> currentContext,
			List<BaseExpressionResult> expressionResults, DateTimeRange period) {

		// Note: For retention expressions, the order for which the expression
		// result is processed,
		// is relevant, as data is deleted after a while.

		resultProcessor.processMonitoringResult(currentContext,
				expressionResults, period);

	}

	public void setRetentionRules(MetricRetentionRules rules) {
		this.rules = rules;

	}
}
