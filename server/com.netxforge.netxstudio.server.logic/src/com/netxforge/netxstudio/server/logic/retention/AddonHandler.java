package com.netxforge.netxstudio.server.logic.retention;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.inject.Inject;
import com.netxforge.base.NonModelUtils;
import com.netxforge.base.properties.IPropertiesProvider;
import com.netxforge.base.properties.PropertiesUtil;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.data.IExternalDataProvider;
import com.netxforge.netxstudio.delta16042013.metrics.Addon;
import com.netxforge.netxstudio.delta16042013.metrics.FixedMetricRetentionPeriod;
import com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricRetentionPeriod;
import com.netxforge.netxstudio.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;

/**
 * Enrich model objects with an external version of the model. Specific for
 * certain functionality, which should be migrated in later in the DataModel.
 * 
 * @author Christophe Bouhier
 */

public class AddonHandler {

	protected static final Object WILDCARD_ALL = "*";

	@Inject
	private IExternalDataProvider.ExternalDataProvider externalProvider;

	@Inject
	private IPropertiesProvider propsProvider;

	public AddonHandler() {
	}

	/**
	 * Compare two value ranges, on the interval in minutes.
	 */
	public class MetricAggregationRuleComparator
			implements
			Comparator<com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule> {
		public int compare(
				final com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule mrr1,
				final com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule mrr2) {
			return new Integer(mrr1.getIntervalHint()).compareTo(mrr2
					.getIntervalHint());
		}
	};

	/**
	 * Compare two value ranges, on the interval in minutes.
	 */
	public class MetricRetentionRuleComparator
			implements
			Comparator<com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule> {
		public int compare(
				final com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule mrr1,
				final com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule mrr2) {
			return new Integer(mrr1.getIntervalHint()).compareTo(mrr2
					.getIntervalHint());
		}
	};

	private Addon addon;

	/**
	 * The addon metric sources which can be matched with persisted Metric
	 * Source objects
	 **/
	private List<com.netxforge.netxstudio.delta16042013.metrics.MetricSource> addOnMetricSources;

	/**
	 * The addon metrics which can be matched with persisted Metric objects
	 */
	private List<com.netxforge.netxstudio.delta16042013.metrics.Metric> addOnMetrics;

	private boolean initialized = false;

	private boolean running = false;

	public boolean isRunning() {
		return running;
	}

	/**
	 * Initialize the {@link Addon} model by loading it from the URI specified
	 * by the property {@link PropertiesUtil#NETXSERVER_PROP_ADDON_MODEL_URI}.
	 * We cache multiple variables from the addon model namely:
	 * 
	 * @param force
	 *            re-initialization.
	 */
	public void initializeModelAddon(boolean force) {

		if (!initialized || force) {

			addon = null;
			addOnMetricSources = null;
			addOnMetrics = null;

			Object pathName = propsProvider.get().get(
					PropertiesUtil.NETXSERVER_PROP_ADDON_MODEL_URI);

			if (pathName != null && pathName instanceof String) {
				if (LogicActivator.DEBUG) {
					LogicActivator.TRACE.trace(
							LogicActivator.TRACE_RETENTION_OPTION,
							"found add model URI: " + pathName);
				}

				try {
					Resource externalModelAddon = externalProvider
							.getResource(URI.createFileURI((String) pathName));
					List<Addon> addonCollection = new NonModelUtils.CollectionForObjects<com.netxforge.netxstudio.delta16042013.metrics.Addon>()
							.collectionForObjects(externalModelAddon
									.getContents());
					if (!addonCollection.isEmpty()
							&& addonCollection.size() == 1) {
						addon = addonCollection.get(0);
						addOnMetricSources = addon.getMetricSources();
						addOnMetrics = addon.getMetrics();
					}
					running = true;
					initialized = true;
				} catch (Exception e) {
					LogicActivator.TRACE.trace(
							LogicActivator.TRACE_RETENTION_OPTION,
							"Error loading addon module URI: " + pathName);
				}
			}
		}
	}

	/**
	 * Return the @link{@link MetricRetentionRules} in the corresponding
	 * {@link com.netxforge.netxstudio.delta16042013.metrics.Metric} in the
	 * {@link Addon AddOn model}.
	 * 
	 * @param metric
	 * @return
	 */
	public List<com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule> retentionRulesForMetric(
			Metric metric) {
		if (!running || metric == null) {
			return null;
		}

		try {
			com.netxforge.netxstudio.delta16042013.metrics.Metric matchAddOnMetric = this
					.matchAddOnMetric(metric);
			// return matchAddOnMetric.getMetricRetentionRuleSet()
			// .getMetricRetentionRules();
			if (matchAddOnMetric
					.eIsSet(com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage.Literals.ADDON__METRIC_RETENTION_RULE_SETS)) {
				List<com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule> sortedCopy = Ordering
						.from(new MetricRetentionRuleComparator()).sortedCopy(
								matchAddOnMetric.getMetricRetentionRuleSet()
										.getMetricRetentionRules());
				return sortedCopy;
			}
		} catch (NoSuchElementException nsee) {
			// if (LogicActivator.DEBUG) {
			// LogicActivator.TRACE.trace(
			// LogicActivator.TRACE_RETENTION_DETAILS_OPTION,
			// "No a matching addon Metric for " + metric.getName());
			// }

		}
		return null;
	}

	/**
	 * Return the @link{@link MetricRetentionRules} in the corresponding
	 * {@link Addon}.
	 * 
	 * @param ms
	 * @return
	 */
	public List<com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule> retentionRulesForMetricSource(
			MetricSource ms) {
		if (!running) {
			return null;
		}

		try {
			com.netxforge.netxstudio.delta16042013.metrics.MetricSource matchAddOnMetricSource = this
					.matchAddOnMetricSource(ms);

			if (matchAddOnMetricSource
					.eIsSet(com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage.Literals.METRIC_SOURCE__METRIC_RETENTION_RULE_SET)) {

				List<com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule> sortedCopy = Ordering
						.from(new MetricRetentionRuleComparator()).sortedCopy(
								matchAddOnMetricSource
										.getMetricRetentionRuleSet()
										.getMetricRetentionRules());

				return sortedCopy;
			}
		} catch (NoSuchElementException nsee) {
			// if (LogicActivator.DEBUG) {
			// LogicActivator.TRACE.trace(
			// LogicActivator.TRACE_RETENTION_DETAILS_OPTION,
			// "No matching addon Metric Source for " + ms.getName());
			// }
		}
		return null;
	}

	public List<com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule> aggregationRulesForMetric(
			Metric metric) {
		if (!running) {
			return null;
		}
		try {
			com.netxforge.netxstudio.delta16042013.metrics.Metric addOnMetric = matchAddOnMetric(metric);

			if (addOnMetric
					.eIsSet(com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage.Literals.ADDON__METRIC_AGGREGATION_RULE_SETS)) {

				List<com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule> sortedCopy = Ordering
						.from(new MetricAggregationRuleComparator())
						.sortedCopy(
								addOnMetric.getMetricAggregationRuleSet()
										.getMetricAggregationRules());
				// return addOnMetric.getMetricAggregationRuleSet()
				// .getMetricAggregationRules();
				return sortedCopy;
			}
		} catch (NoSuchElementException nsee) {
			// if (LogicActivator.DEBUG) {
			// LogicActivator.TRACE.trace(
			// LogicActivator.TRACE_RETENTION_DETAILS_OPTION,
			// "No matching addon Metric for " + metric.getName());
			// }
		}
		return null;
	}

	public List<com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule> aggregationRulesForMetricSource(
			MetricSource ms) {

		if (!running) {
			return null;
		}

		try {
			com.netxforge.netxstudio.delta16042013.metrics.MetricSource matchAddOnMetricSource = this
					.matchAddOnMetricSource(ms);

			if (LogicActivator.DEBUG) {
				LogicActivator.TRACE.trace(
						LogicActivator.TRACE_RETENTION_DETAILS_OPTION,
						"Found a matching addon Metric Source for "
								+ ms.getName());
			}
			if (matchAddOnMetricSource
					.eIsSet(com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage.Literals.METRIC_SOURCE__METRIC_AGGREGATION_RULE_SET)) {
				List<com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule> sortedCopy = Ordering
						.from(new MetricAggregationRuleComparator())
						.sortedCopy(
								matchAddOnMetricSource
										.getMetricAggregationRuleSet()
										.getMetricAggregationRules());

				return sortedCopy;
			}
		} catch (NoSuchElementException nsee) {
			// if (LogicActivator.DEBUG) {
			// LogicActivator.TRACE.trace(
			// LogicActivator.TRACE_RETENTION_DETAILS_OPTION,
			// "No matching addon Metric Source for " + ms.getName());
			// }
		}
		return null;
	}

	public MetricSource metricSourceForMetric(
			List<com.netxforge.netxstudio.metrics.MetricSource> metricSources,
			Metric metricRef) {

		// The collection could be multiple. The exact one is related to the
		// mapping
		// of the Metric Source to a Component for the specified metric.
		List<com.netxforge.netxstudio.metrics.MetricSource> metricSourcesForMetric = StudioUtils
				.metricSourcesForMetric(metricSources, metricRef);

		if (metricSourcesForMetric.size() > 1) {
			// if (LogicActivator.DEBUG) {
			// LogicActivator.TRACE.trace(
			// LogicActivator.TRACE_RETENTION_DETAILS_OPTION, ""
			// + "Metric: " + metricRef.getName()
			// + ", referred in multiple Metric Sources "
			// + metricSourcesForMetric
			// + " returning the first entry (OID) : "
			// + metricSourcesForMetric.get(0));
			// }
		}
		if (metricSourcesForMetric.size() > 0) {
			return metricSourcesForMetric.get(0);
		}
		return null;
	}

	/**
	 * Match the add on Object with the persisted object. (MetricSource).
	 * 
	 * @param ms
	 * @return
	 */
	private com.netxforge.netxstudio.delta16042013.metrics.MetricSource matchAddOnMetricSource(
			final com.netxforge.netxstudio.metrics.MetricSource ms) {

		com.netxforge.netxstudio.delta16042013.metrics.MetricSource find = Iterables
				.find(addOnMetricSources,
						new Predicate<com.netxforge.netxstudio.delta16042013.metrics.MetricSource>() {

							public boolean apply(
									com.netxforge.netxstudio.delta16042013.metrics.MetricSource input) {
								if (input
										.eIsSet(com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage.Literals.METRIC_SOURCE__NAME)) {
									return ms.getName().equals(input.getName());
								}
								return false;
							}

						});
		return find;
	}

	/**
	 * 
	 * @param metric
	 * @return
	 */
	private com.netxforge.netxstudio.delta16042013.metrics.Metric matchAddOnMetric(
			final Metric metric) {
		com.netxforge.netxstudio.delta16042013.metrics.Metric find = Iterables
				.find(addOnMetrics,
						new Predicate<com.netxforge.netxstudio.delta16042013.metrics.Metric>() {

							public boolean apply(
									com.netxforge.netxstudio.delta16042013.metrics.Metric input) {
								if (input != null
										&& metric != null
										&& input.eIsSet(com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage.Literals.METRIC__NAME)
										&& metric
												.eIsSet(MetricsPackage.Literals.METRIC__NAME)) {
									if (input.getName().equals(WILDCARD_ALL)) {
										return true;
									} else {

										return metric.getName().equals(
												input.getName());
									}
								}
								return false;
							}

						});
		return find;
	}

	/**
	 * Creates a {@link DateTimeRange period} from the
	 * {@link MetricRetentionPeriod Metric Retention Period} of
	 * {@link MetricRetentionRule}. The end date of the period is the numbers of
	 * days of the retention period, from today (End of the day), and the start
	 * as the number of years which should be evaluated.
	 * 
	 * @param rule
	 * @param years
	 *            the number of years to evaluate for retention.
	 * @return the {@link DateTimeRange period} or <code>null</code>, when the
	 *         retention period is {@link MetricRetentionPeriod#ALWAYS}
	 */
	public DateTimeRange getDTRForRetentionRule(
			com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule rule,
			Date begin) {
		DateTimeRange dtr = null;
		dtr = GenericsFactory.eINSTANCE.createDateTimeRange();
		Calendar instance = Calendar.getInstance();
		instance.setTime(NonModelUtils.todayAtDayEnd());

		Object period = rule.getPeriod();
		if (period instanceof FixedMetricRetentionPeriod) {
			FixedMetricRetentionPeriod fmep = (FixedMetricRetentionPeriod) period;
			switch (fmep.getValue()) {
			case FixedMetricRetentionPeriod.ALWAYS_VALUE: {
				return null;
			}
			case FixedMetricRetentionPeriod.ONE_YEAR_VALUE: {
				instance.add(Calendar.YEAR, -1);
			}
				break;
			case FixedMetricRetentionPeriod.ONE_MONTH_VALUE: {
				instance.add(Calendar.MONTH, -1);
			}
				break;
			case FixedMetricRetentionPeriod.ONE_WEEK_VALUE: {
				instance.add(Calendar.WEEK_OF_YEAR, -1);
				break;
			}
			}
		} else if (period instanceof String) {
			// Interpret as months.

			try {
				int months = NumberFormat.getInstance().parse((String) period)
						.intValue();
				instance.add(Calendar.MONTH, -months);
			} catch (ParseException e) {
			}
		}

		dtr.setEnd(NonModelUtils.toXMLDate(instance.getTime()));
		dtr.setBegin(NonModelUtils.toXMLDate(begin));

		return dtr;
	}

}
