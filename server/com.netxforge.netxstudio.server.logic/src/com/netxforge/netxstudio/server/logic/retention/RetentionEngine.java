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
import org.eclipse.emf.spi.cdo.FSMUtil;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.data.importer.ResultProcessor;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.scheduling.ComponentFailure;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.server.logic.BaseComponentEngine;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;

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
	private static final int MODE_CLEAR_ALL = 100;

	/**
	 * In this mode we aggregate data as specified by the
	 * {@link MetricRetentionRule retention rules} prior to clearing the content
	 * of a resource. The clearing respects the retention period defined per
	 * measuring interval.
	 */
	private static final int MODE_RETENTION= 200;

	private int operations_mode = MODE_RETENTION;

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

			// Two pass run.
			// Pass 1. Aggregate data using the defined expressions for each of
			// the mr rules. Optional depending on the model.

			if (operations_mode == MODE_RETENTION) {

				// Next do the clearing.
				// Determine the clearing period.

				this.getJobMonitor().setMsg("Clearing");

				// track the MVR's processed.
				final List<MetricValueRange> mvrsCleared = Lists.newArrayList();

				for (MetricRetentionRule rule : metricRulesSortedList) {

					final DateTimeRange period = this.getModelUtils()
							.getDTRForRetentionRule(
									rule,
									this.getModelUtils().fromXMLDate(
											this.getPeriod().getBegin()));

					if (period == null) {
						LogicActivator.TRACE.trace(
								LogicActivator.TRACE_RETENTION_OPTION,
								"skip metric retention rule "
										+ this.getModelUtils()
												.printModelObject(netXResource)
										+ " interval= "
										+ rule.getIntervalHint()
										+ " (Always keep these values)");
						continue;
					}

					// Try to match an MVR with a metric rule.
					final int intervalHint = rule.getIntervalHint();

					// Clear utilization and capacity for this period for
					// the smallest interval defined as a fixture.
					if (intervalHint == 15) {
						final List<Value> capacityValues = queryService
								.capacityValues(netXResource.cdoView(),
										netXResource,
										IQueryService.QUERY_MYSQL, period);

						if (!capacityValues.isEmpty()) {
							resultProcessor.removeValues(
									netXResource.getCapacityValues(),
									capacityValues);
						}

						final List<Value> utilizationValues = queryService
								.utilizationValues(netXResource.cdoView(),
										netXResource,
										IQueryService.QUERY_MYSQL, period);

						if (!utilizationValues.isEmpty()) {
							resultProcessor.removeValues(
									netXResource.getUtilizationValues(),
									utilizationValues);
						}
					}

					final MetricValueRange mvr = this.getModelUtils()
							.valueRangeForInterval(netXResource, intervalHint);

					if (mvr != null && !mvr.getMetricValues().isEmpty()
							&& FSMUtil.isClean(mvr)) {

						LogicActivator.TRACE.trace(
								LogicActivator.TRACE_RETENTION_OPTION,
								"Clearing metric values from resource "
										+ this.getModelUtils()
												.printModelObject(netXResource)
										+ " interval= "
										+ this.getModelUtils().fromMinutes(
												mvr.getIntervalHint())
										+ ", period: "
										+ this.getModelUtils()
												.periodToStringMore(period));

						// // Do we get a List or ELis?
						final List<Value> mvrValues = queryService.mvrValues(
								mvr.cdoView(), mvr, IQueryService.QUERY_MYSQL,
								period);

						if (!resultProcessor.removeValues(mvr, mvrValues)) {
							LogicActivator.TRACE.trace(
									LogicActivator.TRACE_RETENTION_OPTION,
									"values not removed: " + mvrValues);
						} else {
							mvrsCleared.add(mvr);
						}

						commitInbetween(netXResource.cdoView());

					} else {

						if (mvr == null || mvr.getMetricValues().isEmpty()) {
							LogicActivator.TRACE.trace(
									LogicActivator.TRACE_RETENTION_OPTION,
									"no range or emty for resource: "
											+ this.getModelUtils()
													.printModelObject(
															netXResource)
											+ " Interval= "
											+ rule.getIntervalHint());
						} else {
							LogicActivator.TRACE.trace(
									LogicActivator.TRACE_RETENTION_OPTION,
									"Attempt to query uncommited object: "
											+ mvr);
						}

					}
				}

				// report if any of the mvrs in the resource is not processed.
				if (LogicActivator.DEBUG) {
					if (mvrsCleared.size() != netXResource
							.getMetricValueRanges().size()) {

						// Hey we are different size.
						LogicActivator.TRACE
								.trace(LogicActivator.TRACE_RETENTION_OPTION,
										"Retention rules missing, netxResource: "
												+ this.getModelUtils()
														.printModelObject(
																netXResource));

						// Analyze.
						for (MetricValueRange mvr : netXResource
								.getMetricValueRanges()) {
							if (!netXResource.getMetricValueRanges().contains(
									mvr)) {
								// Hey we are different size.
								LogicActivator.TRACE
										.trace(LogicActivator.TRACE_RETENTION_OPTION,
												" -- missing "
														+ this.getModelUtils()
																.fromMinutes(
																		mvr.getIntervalHint())
														+ ", "
														+ mvr.getKindHint()
																.getName());
							}
						}
					}
				}

				// Clean-up the ranges which have been affected and are empty.
				final List<MetricValueRange> mvrsToRemove = Lists
						.newArrayList(Iterables.filter(mvrsCleared,
								new Predicate<MetricValueRange>() {

									public boolean apply(MetricValueRange mvr) {
										return mvr.getMetricValues().isEmpty();
									}

								}));

				netXResource.getMetricValueRanges().removeAll(mvrsToRemove);

			} else if (operations_mode == MODE_CLEAR_ALL) {

				List<MetricValueRange> mvrs = Lists.newArrayList();

				for (MetricValueRange mvr : netXResource.getMetricValueRanges()) {
					mvrs.add(mvr);
					// The total amount of work....
					int metricValues = mvr.getMetricValues().size();
					resultProcessor.removeValues(mvr.getMetricValues());

					if (LogicActivator.DEBUG) {
						LogicActivator.TRACE
								.trace(LogicActivator.TRACE_RETENTION_OPTION,
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
