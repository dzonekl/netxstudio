/**
 * Copyright (c) 2011 NetXForge
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors:
 * Christophe Bouhier - initial API and implementation and/or initial documentation
 */
package com.netxforge.netxstudio.delta16042013.metrics;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.netxforge.netxstudio.delta16042013.generics.GenericsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsFactory
 * @model kind="package"
 * @generated
 */
public interface MetricsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "metrics";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.netxforge.com/16042013_delta/metrics";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "metrics";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetricsPackage eINSTANCE = com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.delta16042013.metrics.impl.AddonImpl <em>Addon</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.AddonImpl
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getAddon()
	 * @generated
	 */
	int ADDON = 0;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDON__METRICS = 0;

	/**
	 * The feature id for the '<em><b>Metric Sources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDON__METRIC_SOURCES = 1;

	/**
	 * The feature id for the '<em><b>Metric Retention Rule Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDON__METRIC_RETENTION_RULE_SETS = 2;

	/**
	 * The feature id for the '<em><b>Metric Aggregation Rule Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDON__METRIC_AGGREGATION_RULE_SETS = 3;

	/**
	 * The number of structural features of the '<em>Addon</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDON_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricImpl <em>Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricImpl
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getMetric()
	 * @generated
	 */
	int METRIC = 1;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Metric Aggregation Rule Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__METRIC_AGGREGATION_RULE_SET = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Metric Retention Rule Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__METRIC_RETENTION_RULE_SET = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__NAME = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricAggregationRuleImpl <em>Metric Aggregation Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricAggregationRuleImpl
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getMetricAggregationRule()
	 * @generated
	 */
	int METRIC_AGGREGATION_RULE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_AGGREGATION_RULE__NAME = GenericsPackage.RULE__NAME;

	/**
	 * The feature id for the '<em><b>Aggregation Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_AGGREGATION_RULE__AGGREGATION_EXPRESSION = GenericsPackage.RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Interval Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_AGGREGATION_RULE__INTERVAL_HINT = GenericsPackage.RULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_AGGREGATION_RULE__PERIOD = GenericsPackage.RULE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Metric Aggregation Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_AGGREGATION_RULE_FEATURE_COUNT = GenericsPackage.RULE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricAggregationRulesImpl <em>Metric Aggregation Rules</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricAggregationRulesImpl
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getMetricAggregationRules()
	 * @generated
	 */
	int METRIC_AGGREGATION_RULES = 3;

	/**
	 * The feature id for the '<em><b>Metric Aggregation Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_AGGREGATION_RULES__METRIC_AGGREGATION_RULES = 0;

	/**
	 * The number of structural features of the '<em>Metric Aggregation Rules</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_AGGREGATION_RULES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricRetentionPeriodsImpl <em>Metric Retention Periods</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricRetentionPeriodsImpl
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getMetricRetentionPeriods()
	 * @generated
	 */
	int METRIC_RETENTION_PERIODS = 4;

	/**
	 * The feature id for the '<em><b>Metric Retention Periods</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_RETENTION_PERIODS__METRIC_RETENTION_PERIODS = 0;

	/**
	 * The number of structural features of the '<em>Metric Retention Periods</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_RETENTION_PERIODS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricRetentionRuleImpl <em>Metric Retention Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricRetentionRuleImpl
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getMetricRetentionRule()
	 * @generated
	 */
	int METRIC_RETENTION_RULE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_RETENTION_RULE__NAME = GenericsPackage.RULE__NAME;

	/**
	 * The feature id for the '<em><b>Interval Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_RETENTION_RULE__INTERVAL_HINT = GenericsPackage.RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_RETENTION_RULE__PERIOD = GenericsPackage.RULE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Metric Retention Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_RETENTION_RULE_FEATURE_COUNT = GenericsPackage.RULE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricRetentionRulesImpl <em>Metric Retention Rules</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricRetentionRulesImpl
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getMetricRetentionRules()
	 * @generated
	 */
	int METRIC_RETENTION_RULES = 6;

	/**
	 * The feature id for the '<em><b>Metric Retention Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_RETENTION_RULES__METRIC_RETENTION_RULES = 0;

	/**
	 * The number of structural features of the '<em>Metric Retention Rules</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_RETENTION_RULES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricSourceImpl <em>Metric Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricSourceImpl
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getMetricSource()
	 * @generated
	 */
	int METRIC_SOURCE = 7;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Metric Aggregation Rule Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE__METRIC_AGGREGATION_RULE_SET = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Metric Retention Rule Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE__METRIC_RETENTION_RULE_SET = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE__NAME = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Metric Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.delta16042013.metrics.FixedMetricRetentionPeriod <em>Fixed Metric Retention Period</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.delta16042013.metrics.FixedMetricRetentionPeriod
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getFixedMetricRetentionPeriod()
	 * @generated
	 */
	int FIXED_METRIC_RETENTION_PERIOD = 8;

	/**
	 * The meta object id for the '<em>Fixed Metric Retention Period Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.delta16042013.metrics.FixedMetricRetentionPeriod
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getFixedMetricRetentionPeriodObject()
	 * @generated
	 */
	int FIXED_METRIC_RETENTION_PERIOD_OBJECT = 9;

	/**
	 * The meta object id for the '<em>Metric Retention Period</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getMetricRetentionPeriod()
	 * @generated
	 */
	int METRIC_RETENTION_PERIOD = 10;

	/**
	 * The meta object id for the '<em>User Metric Retention Period</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getUserMetricRetentionPeriod()
	 * @generated
	 */
	int USER_METRIC_RETENTION_PERIOD = 11;


	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.delta16042013.metrics.Addon <em>Addon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Addon</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.Addon
	 * @generated
	 */
	EClass getAddon();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.delta16042013.metrics.Addon#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metrics</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.Addon#getMetrics()
	 * @see #getAddon()
	 * @generated
	 */
	EReference getAddon_Metrics();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.delta16042013.metrics.Addon#getMetricSources <em>Metric Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metric Sources</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.Addon#getMetricSources()
	 * @see #getAddon()
	 * @generated
	 */
	EReference getAddon_MetricSources();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.delta16042013.metrics.Addon#getMetricRetentionRuleSets <em>Metric Retention Rule Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metric Retention Rule Sets</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.Addon#getMetricRetentionRuleSets()
	 * @see #getAddon()
	 * @generated
	 */
	EReference getAddon_MetricRetentionRuleSets();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.delta16042013.metrics.Addon#getMetricAggregationRuleSets <em>Metric Aggregation Rule Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metric Aggregation Rule Sets</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.Addon#getMetricAggregationRuleSets()
	 * @see #getAddon()
	 * @generated
	 */
	EReference getAddon_MetricAggregationRuleSets();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.delta16042013.metrics.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.Metric
	 * @generated
	 */
	EClass getMetric();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.delta16042013.metrics.Metric#getMetricAggregationRuleSet <em>Metric Aggregation Rule Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metric Aggregation Rule Set</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.Metric#getMetricAggregationRuleSet()
	 * @see #getMetric()
	 * @generated
	 */
	EReference getMetric_MetricAggregationRuleSet();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.delta16042013.metrics.Metric#getMetricRetentionRuleSet <em>Metric Retention Rule Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metric Retention Rule Set</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.Metric#getMetricRetentionRuleSet()
	 * @see #getMetric()
	 * @generated
	 */
	EReference getMetric_MetricRetentionRuleSet();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.delta16042013.metrics.Metric#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.Metric#getName()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Name();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule <em>Metric Aggregation Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Aggregation Rule</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule
	 * @generated
	 */
	EClass getMetricAggregationRule();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule#getAggregationExpression <em>Aggregation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Aggregation Expression</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule#getAggregationExpression()
	 * @see #getMetricAggregationRule()
	 * @generated
	 */
	EReference getMetricAggregationRule_AggregationExpression();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule#getIntervalHint <em>Interval Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interval Hint</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule#getIntervalHint()
	 * @see #getMetricAggregationRule()
	 * @generated
	 */
	EAttribute getMetricAggregationRule_IntervalHint();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule#getPeriod()
	 * @see #getMetricAggregationRule()
	 * @generated
	 */
	EAttribute getMetricAggregationRule_Period();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRules <em>Metric Aggregation Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Aggregation Rules</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRules
	 * @generated
	 */
	EClass getMetricAggregationRules();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRules#getMetricAggregationRules <em>Metric Aggregation Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metric Aggregation Rules</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRules#getMetricAggregationRules()
	 * @see #getMetricAggregationRules()
	 * @generated
	 */
	EReference getMetricAggregationRules_MetricAggregationRules();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionPeriods <em>Metric Retention Periods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Retention Periods</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionPeriods
	 * @generated
	 */
	EClass getMetricRetentionPeriods();

	/**
	 * Returns the meta object for the attribute list '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionPeriods#getMetricRetentionPeriods <em>Metric Retention Periods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Metric Retention Periods</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionPeriods#getMetricRetentionPeriods()
	 * @see #getMetricRetentionPeriods()
	 * @generated
	 */
	EAttribute getMetricRetentionPeriods_MetricRetentionPeriods();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule <em>Metric Retention Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Retention Rule</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule
	 * @generated
	 */
	EClass getMetricRetentionRule();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule#getIntervalHint <em>Interval Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interval Hint</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule#getIntervalHint()
	 * @see #getMetricRetentionRule()
	 * @generated
	 */
	EAttribute getMetricRetentionRule_IntervalHint();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule#getPeriod()
	 * @see #getMetricRetentionRule()
	 * @generated
	 */
	EAttribute getMetricRetentionRule_Period();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRules <em>Metric Retention Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Retention Rules</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRules
	 * @generated
	 */
	EClass getMetricRetentionRules();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRules#getMetricRetentionRules <em>Metric Retention Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metric Retention Rules</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRules#getMetricRetentionRules()
	 * @see #getMetricRetentionRules()
	 * @generated
	 */
	EReference getMetricRetentionRules_MetricRetentionRules();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricSource <em>Metric Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Source</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricSource
	 * @generated
	 */
	EClass getMetricSource();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricSource#getMetricAggregationRuleSet <em>Metric Aggregation Rule Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metric Aggregation Rule Set</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricSource#getMetricAggregationRuleSet()
	 * @see #getMetricSource()
	 * @generated
	 */
	EReference getMetricSource_MetricAggregationRuleSet();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricSource#getMetricRetentionRuleSet <em>Metric Retention Rule Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metric Retention Rule Set</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricSource#getMetricRetentionRuleSet()
	 * @see #getMetricSource()
	 * @generated
	 */
	EReference getMetricSource_MetricRetentionRuleSet();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricSource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricSource#getName()
	 * @see #getMetricSource()
	 * @generated
	 */
	EAttribute getMetricSource_Name();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.delta16042013.metrics.FixedMetricRetentionPeriod <em>Fixed Metric Retention Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fixed Metric Retention Period</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.FixedMetricRetentionPeriod
	 * @generated
	 */
	EEnum getFixedMetricRetentionPeriod();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.delta16042013.metrics.FixedMetricRetentionPeriod <em>Fixed Metric Retention Period Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Fixed Metric Retention Period Object</em>'.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.FixedMetricRetentionPeriod
	 * @model instanceClass="com.netxforge.netxstudio.delta16042013.metrics.FixedMetricRetentionPeriod"
	 *        extendedMetaData="name='FixedMetricRetentionPeriod:Object' baseType='FixedMetricRetentionPeriod'"
	 * @generated
	 */
	EDataType getFixedMetricRetentionPeriodObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Metric Retention Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Metric Retention Period</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 *        extendedMetaData="name='MetricRetentionPeriod' memberTypes='UserMetricRetentionPeriod FixedMetricRetentionPeriod'"
	 * @generated
	 */
	EDataType getMetricRetentionPeriod();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>User Metric Retention Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>User Metric Retention Period</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='UserMetricRetentionPeriod' baseType='http://www.eclipse.org/emf/2003/XMLType#string'"
	 * @generated
	 */
	EDataType getUserMetricRetentionPeriod();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetricsFactory getMetricsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.delta16042013.metrics.impl.AddonImpl <em>Addon</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.AddonImpl
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getAddon()
		 * @generated
		 */
		EClass ADDON = eINSTANCE.getAddon();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDON__METRICS = eINSTANCE.getAddon_Metrics();

		/**
		 * The meta object literal for the '<em><b>Metric Sources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDON__METRIC_SOURCES = eINSTANCE.getAddon_MetricSources();

		/**
		 * The meta object literal for the '<em><b>Metric Retention Rule Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDON__METRIC_RETENTION_RULE_SETS = eINSTANCE.getAddon_MetricRetentionRuleSets();

		/**
		 * The meta object literal for the '<em><b>Metric Aggregation Rule Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDON__METRIC_AGGREGATION_RULE_SETS = eINSTANCE.getAddon_MetricAggregationRuleSets();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricImpl <em>Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricImpl
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getMetric()
		 * @generated
		 */
		EClass METRIC = eINSTANCE.getMetric();

		/**
		 * The meta object literal for the '<em><b>Metric Aggregation Rule Set</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC__METRIC_AGGREGATION_RULE_SET = eINSTANCE.getMetric_MetricAggregationRuleSet();

		/**
		 * The meta object literal for the '<em><b>Metric Retention Rule Set</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC__METRIC_RETENTION_RULE_SET = eINSTANCE.getMetric_MetricRetentionRuleSet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__NAME = eINSTANCE.getMetric_Name();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricAggregationRuleImpl <em>Metric Aggregation Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricAggregationRuleImpl
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getMetricAggregationRule()
		 * @generated
		 */
		EClass METRIC_AGGREGATION_RULE = eINSTANCE.getMetricAggregationRule();

		/**
		 * The meta object literal for the '<em><b>Aggregation Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_AGGREGATION_RULE__AGGREGATION_EXPRESSION = eINSTANCE.getMetricAggregationRule_AggregationExpression();

		/**
		 * The meta object literal for the '<em><b>Interval Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_AGGREGATION_RULE__INTERVAL_HINT = eINSTANCE.getMetricAggregationRule_IntervalHint();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_AGGREGATION_RULE__PERIOD = eINSTANCE.getMetricAggregationRule_Period();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricAggregationRulesImpl <em>Metric Aggregation Rules</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricAggregationRulesImpl
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getMetricAggregationRules()
		 * @generated
		 */
		EClass METRIC_AGGREGATION_RULES = eINSTANCE.getMetricAggregationRules();

		/**
		 * The meta object literal for the '<em><b>Metric Aggregation Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_AGGREGATION_RULES__METRIC_AGGREGATION_RULES = eINSTANCE.getMetricAggregationRules_MetricAggregationRules();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricRetentionPeriodsImpl <em>Metric Retention Periods</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricRetentionPeriodsImpl
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getMetricRetentionPeriods()
		 * @generated
		 */
		EClass METRIC_RETENTION_PERIODS = eINSTANCE.getMetricRetentionPeriods();

		/**
		 * The meta object literal for the '<em><b>Metric Retention Periods</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_RETENTION_PERIODS__METRIC_RETENTION_PERIODS = eINSTANCE.getMetricRetentionPeriods_MetricRetentionPeriods();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricRetentionRuleImpl <em>Metric Retention Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricRetentionRuleImpl
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getMetricRetentionRule()
		 * @generated
		 */
		EClass METRIC_RETENTION_RULE = eINSTANCE.getMetricRetentionRule();

		/**
		 * The meta object literal for the '<em><b>Interval Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_RETENTION_RULE__INTERVAL_HINT = eINSTANCE.getMetricRetentionRule_IntervalHint();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_RETENTION_RULE__PERIOD = eINSTANCE.getMetricRetentionRule_Period();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricRetentionRulesImpl <em>Metric Retention Rules</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricRetentionRulesImpl
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getMetricRetentionRules()
		 * @generated
		 */
		EClass METRIC_RETENTION_RULES = eINSTANCE.getMetricRetentionRules();

		/**
		 * The meta object literal for the '<em><b>Metric Retention Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_RETENTION_RULES__METRIC_RETENTION_RULES = eINSTANCE.getMetricRetentionRules_MetricRetentionRules();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricSourceImpl <em>Metric Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricSourceImpl
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getMetricSource()
		 * @generated
		 */
		EClass METRIC_SOURCE = eINSTANCE.getMetricSource();

		/**
		 * The meta object literal for the '<em><b>Metric Aggregation Rule Set</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_SOURCE__METRIC_AGGREGATION_RULE_SET = eINSTANCE.getMetricSource_MetricAggregationRuleSet();

		/**
		 * The meta object literal for the '<em><b>Metric Retention Rule Set</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_SOURCE__METRIC_RETENTION_RULE_SET = eINSTANCE.getMetricSource_MetricRetentionRuleSet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_SOURCE__NAME = eINSTANCE.getMetricSource_Name();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.delta16042013.metrics.FixedMetricRetentionPeriod <em>Fixed Metric Retention Period</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.delta16042013.metrics.FixedMetricRetentionPeriod
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getFixedMetricRetentionPeriod()
		 * @generated
		 */
		EEnum FIXED_METRIC_RETENTION_PERIOD = eINSTANCE.getFixedMetricRetentionPeriod();

		/**
		 * The meta object literal for the '<em>Fixed Metric Retention Period Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.delta16042013.metrics.FixedMetricRetentionPeriod
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getFixedMetricRetentionPeriodObject()
		 * @generated
		 */
		EDataType FIXED_METRIC_RETENTION_PERIOD_OBJECT = eINSTANCE.getFixedMetricRetentionPeriodObject();

		/**
		 * The meta object literal for the '<em>Metric Retention Period</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getMetricRetentionPeriod()
		 * @generated
		 */
		EDataType METRIC_RETENTION_PERIOD = eINSTANCE.getMetricRetentionPeriod();

		/**
		 * The meta object literal for the '<em>User Metric Retention Period</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.netxforge.netxstudio.delta16042013.metrics.impl.MetricsPackageImpl#getUserMetricRetentionPeriod()
		 * @generated
		 */
		EDataType USER_METRIC_RETENTION_PERIOD = eINSTANCE.getUserMetricRetentionPeriod();

	}

} //MetricsPackage
