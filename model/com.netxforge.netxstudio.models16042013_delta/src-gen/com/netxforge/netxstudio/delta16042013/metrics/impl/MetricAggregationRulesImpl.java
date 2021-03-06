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

import com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule;
import com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRules;
import com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metric Aggregation Rules</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricAggregationRulesImpl#getMetricAggregationRules <em>Metric Aggregation Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetricAggregationRulesImpl extends EObjectImpl implements MetricAggregationRules {
	/**
	 * The cached value of the '{@link #getMetricAggregationRules() <em>Metric Aggregation Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricAggregationRules()
	 * @generated
	 * @ordered
	 */
	protected EList<MetricAggregationRule> metricAggregationRules;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricAggregationRulesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.METRIC_AGGREGATION_RULES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MetricAggregationRule> getMetricAggregationRules() {
		if (metricAggregationRules == null) {
			metricAggregationRules = new EObjectContainmentEList<MetricAggregationRule>(MetricAggregationRule.class, this, MetricsPackage.METRIC_AGGREGATION_RULES__METRIC_AGGREGATION_RULES);
		}
		return metricAggregationRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetricsPackage.METRIC_AGGREGATION_RULES__METRIC_AGGREGATION_RULES:
				return ((InternalEList<?>)getMetricAggregationRules()).basicRemove(otherEnd, msgs);
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
			case MetricsPackage.METRIC_AGGREGATION_RULES__METRIC_AGGREGATION_RULES:
				return getMetricAggregationRules();
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
			case MetricsPackage.METRIC_AGGREGATION_RULES__METRIC_AGGREGATION_RULES:
				getMetricAggregationRules().clear();
				getMetricAggregationRules().addAll((Collection<? extends MetricAggregationRule>)newValue);
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
			case MetricsPackage.METRIC_AGGREGATION_RULES__METRIC_AGGREGATION_RULES:
				getMetricAggregationRules().clear();
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
			case MetricsPackage.METRIC_AGGREGATION_RULES__METRIC_AGGREGATION_RULES:
				return metricAggregationRules != null && !metricAggregationRules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MetricAggregationRulesImpl
