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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.netxforge.netxstudio.delta16042013.generics.impl.BaseImpl;
import com.netxforge.netxstudio.delta16042013.metrics.Metric;
import com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRules;
import com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricImpl#getMetricAggregationRuleSet <em>Metric Aggregation Rule Set</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricImpl#getMetricRetentionRuleSet <em>Metric Retention Rule Set</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetricImpl extends BaseImpl implements Metric {
	/**
	 * The cached value of the '{@link #getMetricAggregationRuleSet() <em>Metric Aggregation Rule Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricAggregationRuleSet()
	 * @generated
	 * @ordered
	 */
	protected MetricAggregationRules metricAggregationRuleSet;

	/**
	 * The cached value of the '{@link #getMetricRetentionRuleSet() <em>Metric Retention Rule Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricRetentionRuleSet()
	 * @generated
	 * @ordered
	 */
	protected MetricRetentionRules metricRetentionRuleSet;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.METRIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricAggregationRules getMetricAggregationRuleSet() {
		if (metricAggregationRuleSet != null && metricAggregationRuleSet.eIsProxy()) {
			InternalEObject oldMetricAggregationRuleSet = (InternalEObject)metricAggregationRuleSet;
			metricAggregationRuleSet = (MetricAggregationRules)eResolveProxy(oldMetricAggregationRuleSet);
			if (metricAggregationRuleSet != oldMetricAggregationRuleSet) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetricsPackage.METRIC__METRIC_AGGREGATION_RULE_SET, oldMetricAggregationRuleSet, metricAggregationRuleSet));
			}
		}
		return metricAggregationRuleSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricAggregationRules basicGetMetricAggregationRuleSet() {
		return metricAggregationRuleSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetricAggregationRuleSet(MetricAggregationRules newMetricAggregationRuleSet) {
		MetricAggregationRules oldMetricAggregationRuleSet = metricAggregationRuleSet;
		metricAggregationRuleSet = newMetricAggregationRuleSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC__METRIC_AGGREGATION_RULE_SET, oldMetricAggregationRuleSet, metricAggregationRuleSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricRetentionRules getMetricRetentionRuleSet() {
		if (metricRetentionRuleSet != null && metricRetentionRuleSet.eIsProxy()) {
			InternalEObject oldMetricRetentionRuleSet = (InternalEObject)metricRetentionRuleSet;
			metricRetentionRuleSet = (MetricRetentionRules)eResolveProxy(oldMetricRetentionRuleSet);
			if (metricRetentionRuleSet != oldMetricRetentionRuleSet) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetricsPackage.METRIC__METRIC_RETENTION_RULE_SET, oldMetricRetentionRuleSet, metricRetentionRuleSet));
			}
		}
		return metricRetentionRuleSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricRetentionRules basicGetMetricRetentionRuleSet() {
		return metricRetentionRuleSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetricRetentionRuleSet(MetricRetentionRules newMetricRetentionRuleSet) {
		MetricRetentionRules oldMetricRetentionRuleSet = metricRetentionRuleSet;
		metricRetentionRuleSet = newMetricRetentionRuleSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC__METRIC_RETENTION_RULE_SET, oldMetricRetentionRuleSet, metricRetentionRuleSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetricsPackage.METRIC__METRIC_AGGREGATION_RULE_SET:
				if (resolve) return getMetricAggregationRuleSet();
				return basicGetMetricAggregationRuleSet();
			case MetricsPackage.METRIC__METRIC_RETENTION_RULE_SET:
				if (resolve) return getMetricRetentionRuleSet();
				return basicGetMetricRetentionRuleSet();
			case MetricsPackage.METRIC__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetricsPackage.METRIC__METRIC_AGGREGATION_RULE_SET:
				setMetricAggregationRuleSet((MetricAggregationRules)newValue);
				return;
			case MetricsPackage.METRIC__METRIC_RETENTION_RULE_SET:
				setMetricRetentionRuleSet((MetricRetentionRules)newValue);
				return;
			case MetricsPackage.METRIC__NAME:
				setName((String)newValue);
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
			case MetricsPackage.METRIC__METRIC_AGGREGATION_RULE_SET:
				setMetricAggregationRuleSet((MetricAggregationRules)null);
				return;
			case MetricsPackage.METRIC__METRIC_RETENTION_RULE_SET:
				setMetricRetentionRuleSet((MetricRetentionRules)null);
				return;
			case MetricsPackage.METRIC__NAME:
				setName(NAME_EDEFAULT);
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
			case MetricsPackage.METRIC__METRIC_AGGREGATION_RULE_SET:
				return metricAggregationRuleSet != null;
			case MetricsPackage.METRIC__METRIC_RETENTION_RULE_SET:
				return metricRetentionRuleSet != null;
			case MetricsPackage.METRIC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MetricImpl
