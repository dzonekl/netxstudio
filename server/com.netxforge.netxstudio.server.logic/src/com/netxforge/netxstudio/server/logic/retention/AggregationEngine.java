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
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.collect.Ordering;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.importer.ResultProcessor;
import com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.scheduling.ComponentFailure;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.server.logic.BaseComponentEngine;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;

/**
 * Performs the aggregation action for a component.
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public class AggregationEngine extends BaseComponentEngine {

	private MetricRetentionRules rules;

	private List<MetricRetentionRule> metricRulesSortedList = null;

	private List<MetricSource> metricSources;

	/**
	 * An Option which tells the engine to fall back to the global rules set.
	 */
	public static final boolean OPTION_AGGREGATION_FALLBACK_GLOBALRULES = false;

	@Inject
	private AddonHandler addonHandler;

	public void intitialize(boolean re_initialize) {
		Resource resource = this.getDataProvider().getResource(
				MetricsPackage.Literals.METRIC_SOURCE);

		if (LogicActivator.DEBUG) {
			LogicActivator.TRACE.trace(LogicActivator.TRACE_RETENTION_OPTION,
					"Initializing Aggregation engine");
		}

		metricSources = new ModelUtils.CollectionForObjects<MetricSource>()
				.collectionForObjects(resource.getContents());
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
						"Processing aggregation rule in order: ");
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
		addonHandler.initializeModelAddon(re_initialize);
		
		// Set the write mode to single value in interval, to avoid duplicate aggregates. 
		resultProcessor.setWriteMode(ResultProcessor.SINGLE_VALUE_IN_INTERVAL_MODE);
	}

	@Inject
	private ResultProcessor resultProcessor;

	@Override
	public void doExecute() {

		// Run for each resource, each retention rule.
		for (final NetXResource netXResource : getComponent().getResourceRefs()) {

			// Aggregate data using the defined expressions for each of
			// the mr rules. Optional depending on the model.
			// Bail aggregation when the resource has no values.
			if (this.getModelUtils().resourceHasValues(netXResource)) {
				List<MetricAggregationRule> customRuleSet = customRuleSetForNetXResource(netXResource);
				if (customRuleSet != null && !customRuleSet.isEmpty()) {
					applyCustomRuleSet(customRuleSet, netXResource);
				} else if (OPTION_AGGREGATION_FALLBACK_GLOBALRULES) {
					this.getJobMonitor().setMsg("Aggregating");
					applyGlobalRuleSet(netXResource);
				} else {
					// Skip this resource...
				}
			}
		}
	}

	/**
	 * 
	 * Get a custom rule set for this NetXResource.
	 * 
	 * @param netXResource
	 * @return
	 */
	private List<MetricAggregationRule> customRuleSetForNetXResource(
			final NetXResource netXResource) {
		List<MetricAggregationRule> customRuleSet = addonHandler
				.aggregationRulesForMetric(netXResource.getMetricRef());
		if (customRuleSet == null) {
			// Get the corresponding MetricSource and ruleset if it exists.
			MetricSource ms = addonHandler.metricSourceForMetric(metricSources,
					netXResource.getMetricRef());
			if (ms != null) {
				customRuleSet = addonHandler
						.aggregationRulesForMetricSource(ms);
			}
		}
		return customRuleSet;
	}

	private void applyCustomRuleSet(List<MetricAggregationRule> customRuleSet,
			NetXResource netXResource) {

		if (LogicActivator.DEBUG) {
			LogicActivator.TRACE.trace(
					LogicActivator.TRACE_RETENTION_OPTION,
					"data aggregation for : "
							+ this.getModelUtils().printModelObject(
									getComponent()));
			LogicActivator.TRACE
					.trace(LogicActivator.TRACE_RETENTION_DETAILS_OPTION,
							"Applying custom rule sets ("
									+ customRuleSet.size()
									+ ") on resource: "
									+ (netXResource
											.eIsSet(LibraryPackage.Literals.BASE_RESOURCE__EXPRESSION_NAME) ? netXResource
											.getShortName() : netXResource));
		}
		for (MetricAggregationRule ar : customRuleSet) {

			if (ar.eIsSet(com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage.Literals.METRIC_AGGREGATION_RULE__INTERVAL_HINT)) {
				MetricRetentionRule globalRuleForInterval = getModelUtils()
						.metricRuleGlobalForInterval(metricRulesSortedList,
								ar.getIntervalHint());
				if (globalRuleForInterval != null) {
					if (LogicActivator.DEBUG) {
						LogicActivator.TRACE
								.trace(LogicActivator.TRACE_RETENTION_DETAILS_OPTION,
										"Applying custom rule: "
												+ ar.getName()
												+ " interval: "
												+ ar.getIntervalHint()
												+ " apply corresponding global expression");
					}
					Expression expression = globalRuleForInterval
							.getRetentionExpression();

					if (ar.eIsSet(com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage.Literals.METRIC_AGGREGATION_RULE__PERIOD)) {
						// The number of days from the current logic period.
						// (Which is the current date/time).
						int period = ar.getPeriod();
						DateTimeRange customPeriod = GenericsFactory.eINSTANCE
								.createDateTimeRange();
						customPeriod.setEnd(getPeriod().getEnd());
						customPeriod.setBegin(getModelUtils().toXMLDate(
								getModelUtils().daysAgo(period)));
						runExpression(netXResource, expression, customPeriod);
					} else {
						runExpression(netXResource, expression);
					}
					continue;
				}
			}
			if (LogicActivator.DEBUG) {
				LogicActivator.TRACE
						.trace(LogicActivator.TRACE_RETENTION_DETAILS_OPTION,
								"Skip custom rule: "
										+ ar.getName()
										+ " The rule is not valid (Interval should be defined, and matching a global rule interval");
			}
		}
	}

	/**
	 * @param netXResource
	 */
	private void applyGlobalRuleSet(final NetXResource netXResource) {
		if (LogicActivator.DEBUG) {
			LogicActivator.TRACE.trace(
					LogicActivator.TRACE_RETENTION_OPTION,
					"data aggregation for : "
							+ this.getModelUtils().printModelObject(
									getComponent()) + " resource: "
							+ netXResource.getExpressionName());
		}
		for (MetricRetentionRule rule : metricRulesSortedList) {
			Expression expression = rule.getRetentionExpression();
			runExpression(netXResource, expression);
		}
	}

	/**
	 * @param netXResource
	 * @param expression
	 */
	private void runExpression(final NetXResource netXResource,
			Expression expression) {
		runExpression(netXResource, expression, null);
	}

	/**
	 * @param netXResource
	 * @param expression
	 */
	private void runExpression(final NetXResource netXResource,
			Expression expression, DateTimeRange customPeriod) {
		if (expression != null) {

			// Data will be aggregated for the period specified
			// by
			// the
			// logic period.
			// For clearing data however, we need to set the
			// MetricRetentionRule in the Interpreter.

			getExpressionEngine().getContext().clear();

			getExpressionEngine().getContext().add(
					customPeriod == null ? getPeriod() : customPeriod);
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
