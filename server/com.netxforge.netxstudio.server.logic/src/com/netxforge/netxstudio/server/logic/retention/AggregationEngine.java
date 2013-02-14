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

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;

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
import com.netxforge.netxstudio.scheduling.ComponentFailure;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;
import com.netxforge.netxstudio.server.logic.monitoring.BaseComponentEngine;

/**
 * Performs the aggregation action for a component.
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public class AggregationEngine extends BaseComponentEngine {

	private MetricRetentionRules rules;

	private List<MetricRetentionRule> metricRulesSortedList = null;

	@Inject
	private ResultProcessor resultProcessor;

	@Inject
	private IQueryService queryService;

	@Override
	public void doExecute() {

		if (LogicActivator.DEBUG) {
			LogicActivator.TRACE.trace(
					LogicActivator.TRACE_RETENTION_OPTION,
					"data aggregation for : "
							+ this.getModelUtils().printModelObject(
									getComponent()) + " # resources: "
							+ this.getComponent().getResourceRefs().size());
		}

		// Rules should execute considering the order of the smallest
		// interval first,
		// as to allow aggregation.
		// Order the rules by smallest interval.
		if (metricRulesSortedList == null) {
			metricRulesSortedList = Ordering.from(
					getModelUtils().retentionRuleCompare()).sortedCopy(
					rules.getMetricRetentionRules());
			if (LogicActivator.DEBUG) {
				LogicActivator.TRACE.trace(
						LogicActivator.TRACE_RETENTION_OPTION,
						"Processing aggreagation rule in order: ");
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

			// Aggregate data using the defined expressions for each of
			// the mr rules. Optional depending on the model.

			// Bail aggregation when the resource has no values.
			if (this.getModelUtils().resourceHasValues(netXResource)) {

				this.getJobMonitor().setMsg("Aggregating");

				for (MetricRetentionRule rule : metricRulesSortedList) {

					Expression expression = rule.getRetentionExpression();

					if (expression != null) {

						// Data will be aggregated for the period specified
						// by
						// the
						// logic period.
						// For clearing data however, we need to set the
						// MetricRetentionRule in the Interpreter.

						getExpressionEngine().getContext().clear();
						getExpressionEngine().getContext().add(getPeriod());
						getExpressionEngine().getContext().add(
								this.getModelUtils().nodeFor(getComponent()));
						getExpressionEngine().getContext().add(netXResource);

						// As the data is not committed in between,
						// subsequent
						// expressions will not be able
						// get data until commit, so it needs to run n times
						// (n
						// = number of rules) before all aggregation is
						// done.
						runForExpression(expression);

						commitInbetween(netXResource.cdoView());
					}
				}
			}
		}
	}

	@Override
	public Failure getFailure() {
		final ComponentFailure f = SchedulingFactory.eINSTANCE
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

	private void commitInbetween(CDOView cdoView) {
		if (cdoView instanceof CDOTransaction) {
			CDOTransaction transaction = (CDOTransaction) cdoView;
			try {
				transaction.commit();
			} catch (Throwable t) {
				// Process the result.
				StringBuilder sb = new StringBuilder();
				sb.append(t.getMessage());

				if (t.getCause() != null) {
					sb.append(t.getCause().getMessage());
				}

				final Failure failure = this.getFailure();
				this.getFailures().add(failure);

				// Remove later.
				t.printStackTrace();

				// Also in the log.
				if (LogicActivator.DEBUG) {
					LogicActivator.TRACE.trace(
							LogicActivator.TRACE_RETENTION_OPTION,
							"Error committing: ", t);
				}
				// Restore the transaction to proceed.
				transaction.rollback();
			}
		}
	}

}
