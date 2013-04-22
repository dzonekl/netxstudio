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
package com.netxforge.netxstudio.delta16042013.metrics.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.netxforge.netxstudio.delta16042013.metrics.Addon;
import com.netxforge.netxstudio.delta16042013.metrics.Metric;
import com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRules;
import com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.delta16042013.metrics.MetricSource;
import com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Addon</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.impl.AddonImpl#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.impl.AddonImpl#getMetricSources <em>Metric Sources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.impl.AddonImpl#getMetricRetentionRuleSets <em>Metric Retention Rule Sets</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.impl.AddonImpl#getMetricAggregationRuleSets <em>Metric Aggregation Rule Sets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AddonImpl extends EObjectImpl implements Addon {
	/**
	 * The cached value of the '{@link #getMetrics() <em>Metrics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetrics()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric> metrics;

	/**
	 * The cached value of the '{@link #getMetricSources() <em>Metric Sources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricSources()
	 * @generated
	 * @ordered
	 */
	protected EList<MetricSource> metricSources;

	/**
	 * The cached value of the '{@link #getMetricRetentionRuleSets() <em>Metric Retention Rule Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricRetentionRuleSets()
	 * @generated
	 * @ordered
	 */
	protected EList<MetricRetentionRules> metricRetentionRuleSets;

	/**
	 * The cached value of the '{@link #getMetricAggregationRuleSets() <em>Metric Aggregation Rule Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricAggregationRuleSets()
	 * @generated
	 * @ordered
	 */
	protected EList<MetricAggregationRules> metricAggregationRuleSets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.ADDON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric> getMetrics() {
		if (metrics == null) {
			metrics = new EObjectContainmentEList<Metric>(Metric.class, this, MetricsPackage.ADDON__METRICS);
		}
		return metrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MetricSource> getMetricSources() {
		if (metricSources == null) {
			metricSources = new EObjectContainmentEList<MetricSource>(MetricSource.class, this, MetricsPackage.ADDON__METRIC_SOURCES);
		}
		return metricSources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MetricRetentionRules> getMetricRetentionRuleSets() {
		if (metricRetentionRuleSets == null) {
			metricRetentionRuleSets = new EObjectContainmentEList<MetricRetentionRules>(MetricRetentionRules.class, this, MetricsPackage.ADDON__METRIC_RETENTION_RULE_SETS);
		}
		return metricRetentionRuleSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MetricAggregationRules> getMetricAggregationRuleSets() {
		if (metricAggregationRuleSets == null) {
			metricAggregationRuleSets = new EObjectContainmentEList<MetricAggregationRules>(MetricAggregationRules.class, this, MetricsPackage.ADDON__METRIC_AGGREGATION_RULE_SETS);
		}
		return metricAggregationRuleSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetricsPackage.ADDON__METRICS:
				return ((InternalEList<?>)getMetrics()).basicRemove(otherEnd, msgs);
			case MetricsPackage.ADDON__METRIC_SOURCES:
				return ((InternalEList<?>)getMetricSources()).basicRemove(otherEnd, msgs);
			case MetricsPackage.ADDON__METRIC_RETENTION_RULE_SETS:
				return ((InternalEList<?>)getMetricRetentionRuleSets()).basicRemove(otherEnd, msgs);
			case MetricsPackage.ADDON__METRIC_AGGREGATION_RULE_SETS:
				return ((InternalEList<?>)getMetricAggregationRuleSets()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetricsPackage.ADDON__METRICS:
				return getMetrics();
			case MetricsPackage.ADDON__METRIC_SOURCES:
				return getMetricSources();
			case MetricsPackage.ADDON__METRIC_RETENTION_RULE_SETS:
				return getMetricRetentionRuleSets();
			case MetricsPackage.ADDON__METRIC_AGGREGATION_RULE_SETS:
				return getMetricAggregationRuleSets();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetricsPackage.ADDON__METRICS:
				getMetrics().clear();
				getMetrics().addAll((Collection<? extends Metric>)newValue);
				return;
			case MetricsPackage.ADDON__METRIC_SOURCES:
				getMetricSources().clear();
				getMetricSources().addAll((Collection<? extends MetricSource>)newValue);
				return;
			case MetricsPackage.ADDON__METRIC_RETENTION_RULE_SETS:
				getMetricRetentionRuleSets().clear();
				getMetricRetentionRuleSets().addAll((Collection<? extends MetricRetentionRules>)newValue);
				return;
			case MetricsPackage.ADDON__METRIC_AGGREGATION_RULE_SETS:
				getMetricAggregationRuleSets().clear();
				getMetricAggregationRuleSets().addAll((Collection<? extends MetricAggregationRules>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetricsPackage.ADDON__METRICS:
				getMetrics().clear();
				return;
			case MetricsPackage.ADDON__METRIC_SOURCES:
				getMetricSources().clear();
				return;
			case MetricsPackage.ADDON__METRIC_RETENTION_RULE_SETS:
				getMetricRetentionRuleSets().clear();
				return;
			case MetricsPackage.ADDON__METRIC_AGGREGATION_RULE_SETS:
				getMetricAggregationRuleSets().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetricsPackage.ADDON__METRICS:
				return metrics != null && !metrics.isEmpty();
			case MetricsPackage.ADDON__METRIC_SOURCES:
				return metricSources != null && !metricSources.isEmpty();
			case MetricsPackage.ADDON__METRIC_RETENTION_RULE_SETS:
				return metricRetentionRuleSets != null && !metricRetentionRuleSets.isEmpty();
			case MetricsPackage.ADDON__METRIC_AGGREGATION_RULE_SETS:
				return metricAggregationRuleSets != null && !metricAggregationRuleSets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AddonImpl
