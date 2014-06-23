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
import org.eclipse.emf.spi.cdo.FSMUtil;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.inject.Inject;
import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.data.cdo.CDOQueryService;
import com.netxforge.netxstudio.data.cdo.CDOQueryUtil;
import com.netxforge.netxstudio.data.services.ResultProcessor;
import com.netxforge.netxstudio.data.services.ValueProcessor;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsPackage;
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
	private static final int MODE_RETENTION = 200;

	private static final boolean OPTION_RETENTION_FALLBACK_GLOBALRULES = false;

	private int operations_mode = MODE_RETENTION;

	@Inject
	private ResultProcessor resultProcessor;

	@Inject
	private ValueProcessor valueProcessor;

	@Inject
	private AddonHandler addonHandler;

	private List<MetricSource> metricSources;

	public void initialize(boolean re_initialize) {

		if (LogicActivator.DEBUG) {
			LogicActivator.TRACE.trace(LogicActivator.TRACE_RETENTION_OPTION,
					"Initializing Retention engine");
		}
		Resource resource = this.getDataProvider().getResource(
				MetricsPackage.Literals.METRIC_SOURCE);

		metricSources = new NonModelUtils.CollectionForObjects<MetricSource>()
				.collectionForObjects(resource.getContents());
		// Rules should execute considering the order of the smallest
		// interval first,
		// as to allow aggregation.
		// Order the rules by smallest interval.
		if (metricRulesSortedList == null) {
			metricRulesSortedList = Ordering.from(
					StudioUtils.retentionRuleCompare()).sortedCopy(
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
		addonHandler.initializeModelAddon(re_initialize);
	}

	@Override
	public void doExecute() {

		// Run for each resource, each retention rule.
		for (final NetXResource netXResource : getComponent().getResourceRefs()) {

			// Note this is a non-settable MODE, for testing only.
			if (operations_mode == MODE_RETENTION) {

				List<com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule> customRuleSet = customRuleSetForNetXResource(netXResource);

				// Next do the clearing.
				// Determine the clearing period.
				this.getJobMonitor().setMsg("Clearing");
				if (customRuleSet != null) {
					this.applyCustomRuleSet(customRuleSet, netXResource);
				} else if (OPTION_RETENTION_FALLBACK_GLOBALRULES) {
					this.getJobMonitor().setMsg("Clearing");
					applyGlobalRuleSet(netXResource);
				} else {
					// Skip this resource...
				}

			} else if (operations_mode == MODE_CLEAR_ALL) {

				List<MetricValueRange> mvrs = Lists.newArrayList();

				for (MetricValueRange mvr : netXResource.getMetricValueRanges()) {
					mvrs.add(mvr);
					// The total amount of work....
					int metricValues = mvr.getMetricValues().size();
					valueProcessor.removeValues(mvr.getMetricValues());

					if (LogicActivator.DEBUG) {
						LogicActivator.TRACE
								.trace(LogicActivator.TRACE_RETENTION_OPTION,
										"Cleared metric values total= "
												+ metricValues
												+ ", from resource "
												+ StudioUtils
														.printModelObject(netXResource)
												+ " interval= "
												+ mvr.getIntervalHint());

					}
				}

				netXResource.getMetricValueRanges().removeAll(mvrs);

				int totalValues = netXResource.getUtilizationValues().size()
						+ netXResource.getCapacityValues().size();

				valueProcessor
						.removeValues(netXResource.getUtilizationValues());
				valueProcessor.removeValues(netXResource.getCapacityValues());

				if (LogicActivator.DEBUG) {
					LogicActivator.TRACE.trace(
							LogicActivator.TRACE_RETENTION_OPTION,
							"Cleared cap & util values total= "
									+ totalValues
									+ ", from resource "
									+ StudioUtils
											.printModelObject(netXResource));

				}

			}
		}
	}

	/**
	 * @param netXResource
	 * @return
	 */
	private List<com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule> customRuleSetForNetXResource(
			final NetXResource netXResource) {
		List<com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule> customRuleSet = addonHandler
				.retentionRulesForMetric(netXResource.getMetricRef());
		if (customRuleSet == null) {
			// Get the corresponding MetricSource and ruleset if it exists.
			MetricSource ms = addonHandler.metricSourceForMetric(metricSources,
					netXResource.getMetricRef());
			if (ms != null) {
				customRuleSet = addonHandler.retentionRulesForMetricSource(ms);
			}
		}
		return customRuleSet;
	}

	private void applyCustomRuleSet(
			List<com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule> customRuleSet,
			NetXResource netXResource) {

		if (LogicActivator.DEBUG) {
			LogicActivator.TRACE.trace(
					LogicActivator.TRACE_RETENTION_OPTION,
					"data retention for : "
							+ StudioUtils.printModelObject(getComponent())
							+ " resource: " + netXResource.getExpressionName());
			LogicActivator.TRACE
					.trace(LogicActivator.TRACE_RETENTION_DETAILS_OPTION,
							"Applying custom rule sets ("
									+ customRuleSet.size()
									+ ") on resource: "
									+ (netXResource
											.eIsSet(LibraryPackage.Literals.BASE_RESOURCE__EXPRESSION_NAME) ? netXResource
											.getShortName() : netXResource));
		}
		// track the MVR's processed.
		final List<MetricValueRange> mvrsCleared = Lists.newArrayList();
		for (com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule rule : customRuleSet) {
			int intervalHint = rule.getIntervalHint();

			// How far back to retend data is historical infinity, as the query
			// will not apply the begin period.
			final DateTimeRange period = addonHandler.getDTRForRetentionRule(
					rule,
					NonModelUtils.fromXMLDate(this.getPeriod().getBegin()));

			LogicActivator.TRACE.trace(
					LogicActivator.TRACE_RETENTION_DETAILS_OPTION,
					"Applying custom rule: "
							+ rule.getName()
							+ " interval: "
							+ rule.getIntervalHint()
							+ " clear upto: "
							+ NonModelUtils.date(NonModelUtils
									.fromXMLDate(period.getEnd())));

			mvrsCleared.addAll(clear(netXResource, period, intervalHint));

		}
		// Log the result.
		logClearingResult(netXResource, mvrsCleared);

		// Clear the ranges from the resource.
		if (!mvrsCleared.isEmpty()) {
			clearRanges(netXResource, mvrsCleared);
		}
	}

	/**
	 * @param netXResource
	 */
	private void applyGlobalRuleSet(final NetXResource netXResource) {

		if (LogicActivator.DEBUG) {
			LogicActivator.TRACE.trace(
					LogicActivator.TRACE_RETENTION_OPTION,
					"data retention for : "
							+ StudioUtils.printModelObject(getComponent())
							+ " resource: " + netXResource.getExpressionName());
		}

		// track the MVR's processed.
		final List<MetricValueRange> mvrsCleared = Lists.newArrayList();

		for (MetricRetentionRule rule : metricRulesSortedList) {

			int intervalHint = rule.getIntervalHint();

			final DateTimeRange period = StudioUtils.periodForRetentionRule(
					rule,
					NonModelUtils.fromXMLDate(this.getPeriod().getBegin()));

			mvrsCleared.addAll(clear(netXResource, period, intervalHint));
		}
		// Log the result.
		logClearingResult(netXResource, mvrsCleared);
		// Clear the ranges from the resource.
		clearRanges(netXResource, mvrsCleared);
	}

	/**
	 * @param netXResource
	 * @param mvrsCleared
	 */
	private void clearRanges(final NetXResource netXResource,
			final List<MetricValueRange> mvrsCleared) {
		// Clean-up the ranges which have been affected and are empty.
		final List<MetricValueRange> mvrsToRemove = Lists
				.newArrayList(Iterables.filter(mvrsCleared,
						new Predicate<MetricValueRange>() {

							public boolean apply(MetricValueRange mvr) {
								boolean empty = mvr.getMetricValues().isEmpty();
								return empty;
							}

						}));

		netXResource.getMetricValueRanges().removeAll(mvrsToRemove);
	}

	/**
	 * @param netXResource
	 * @param mvrsCleared
	 */
	private void logClearingResult(final NetXResource netXResource,
			final List<MetricValueRange> mvrsCleared) {
		// report if any of the mvrs in the resource is not processed.
		if (LogicActivator.DEBUG) {
			if (mvrsCleared.size() != netXResource.getMetricValueRanges()
					.size()) {

				// Hey we are different size.
				LogicActivator.TRACE.trace(
						LogicActivator.TRACE_RETENTION_OPTION,
						"Retention rules missing, netxResource: "
								+ StudioUtils.printModelObject(netXResource));

				// Analyze.
				for (MetricValueRange mvr : netXResource.getMetricValueRanges()) {
					if (!netXResource.getMetricValueRanges().contains(mvr)) {
						// Hey we are different size.
						LogicActivator.TRACE.trace(
								LogicActivator.TRACE_RETENTION_OPTION,
								" -- missing "
										+ NonModelUtils.fromMinutes(mvr
												.getIntervalHint()) + ", "
										+ mvr.getKindHint().getName());
					}
				}
			}
		}
	}

	/**
	 * Clear the value ranges
	 * {@link LibraryPackage.Literals#NET_XRESOURCE__CAPACITY_VALUES Capacity
	 * range}, {@link LibraryPackage.Literals#NET_XRESOURCE__UTILIZATION_VALUES
	 * Utilization range} &
	 * {@link LibraryPackage.Literals#NET_XRESOURCE__METRIC_VALUE_RANGES Metric
	 * ranges} with the given intervalHint for the given period. Note the period
	 * end is considered only, the start is historical infinity.
	 * 
	 * @param netXResource
	 * @param period
	 * @param intervalHint
	 * @return A collection of cleared {@link MetricValueRange metric ranges}
	 */
	private List<MetricValueRange> clear(final NetXResource netXResource,
			DateTimeRange period, int intervalHint) {

		final List<MetricValueRange> mvrsCleared = Lists.newArrayList();

		if (period == null) {
			LogicActivator.TRACE.trace(
					LogicActivator.TRACE_RETENTION_OPTION,
					"skip metric retention rule "
							+ StudioUtils.printModelObject(netXResource)
							+ " interval= " + intervalHint
							+ " (Always keep these values)");
			return mvrsCleared;
		}

		// Clear utilization and capacity for this period for
		// the smallest interval defined as a fixture.
		// ??? Why not clearing for other values?
		if (intervalHint == 15) {
			final List<Value> capacityValues = CDOQueryService.capacityValues(
					netXResource.cdoView(), netXResource,
					CDOQueryUtil.QUERY_MYSQL, period.getEnd());

			if (!capacityValues.isEmpty()) {
				valueProcessor.removeValues(netXResource.getCapacityValues(),
						capacityValues);
			}

			final List<Value> utilizationValues = CDOQueryService
					.utilizationValues(netXResource.cdoView(), netXResource,
							CDOQueryUtil.QUERY_MYSQL, period.getEnd());

			if (!utilizationValues.isEmpty()) {
				valueProcessor.removeValues(
						netXResource.getUtilizationValues(), utilizationValues);
			}
		}

		final List<MetricValueRange> valueRangesForInterval = StudioUtils
				.valueRangesForInterval(netXResource, intervalHint);

		if (valueRangesForInterval.isEmpty()) {
			LogicActivator.TRACE.trace(LogicActivator.TRACE_RETENTION_OPTION,
					"no ranges (neither AVG nor BH) for resource: "
							+ StudioUtils.printModelObject(netXResource)
							+ " Interval= " + intervalHint);
		}

		for (MetricValueRange mvr : valueRangesForInterval) {
			if (FSMUtil.isClean(mvr)) {

				LogicActivator.TRACE.trace(
						LogicActivator.TRACE_RETENTION_OPTION,
						"Clearing metric values from resource "
								+ StudioUtils.printModelObject(netXResource)
								+ " interval= "
								+ NonModelUtils.fromMinutes(mvr
										.getIntervalHint())
								+ " clear upto: "
								+ NonModelUtils.date(NonModelUtils
										.fromXMLDate(period.getEnd())));

				// // Do we get a List or ELis?
				final List<Value> mvrValues = CDOQueryService
						.mvrValuesPriortoDate(mvr.cdoView(), mvr,
								CDOQueryUtil.QUERY_MYSQL, period.getEnd());

				if (!mvrValues.isEmpty()) {

					if (!valueProcessor.removeValues(mvr, mvrValues)) {
						LogicActivator.TRACE.trace(
								LogicActivator.TRACE_RETENTION_OPTION,
								"values not removed: " + mvrValues);
					}
				}
				mvrsCleared.add(mvr);
				commitInbetween(netXResource.cdoView());

			} else {

				if (mvr.getMetricValues().isEmpty()) {
					LogicActivator.TRACE.trace(
							LogicActivator.TRACE_RETENTION_OPTION,
							"no values for resource: "
									+ StudioUtils
											.printModelObject(netXResource)
									+ " Interval: " + mvr.getIntervalHint()
									+ " Kind: " + mvr.getKindHint());
					mvrsCleared.add(mvr);
				} else {
					LogicActivator.TRACE.trace(
							LogicActivator.TRACE_RETENTION_OPTION,
							"Attempt to query uncommited object: " + mvr);
				}

			}
		}
		return mvrsCleared;
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

	public AddonHandler getAddonHandler() {
		return addonHandler;
	}

}
