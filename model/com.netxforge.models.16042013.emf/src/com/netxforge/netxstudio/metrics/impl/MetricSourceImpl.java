/**
 * Copyright (c) 2014 NetXForge
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
package com.netxforge.netxstudio.metrics.impl;

import com.netxforge.netxstudio.generics.RuleSet;

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.metrics.Mapping;
import com.netxforge.netxstudio.metrics.MappingStatistic;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metric Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricSourceImpl#getMetricMapping <em>Metric Mapping</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricSourceImpl#getStatistics <em>Statistics</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricSourceImpl#getFilterPattern <em>Filter Pattern</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricSourceImpl#getMetricAggregationRules <em>Metric Aggregation Rules</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricSourceImpl#getMetricLocation <em>Metric Location</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricSourceImpl#getMetricRetentionRules <em>Metric Retention Rules</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricSourceImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetricSourceImpl extends BaseImpl implements MetricSource {
	/**
	 * The cached value of the '{@link #getMetricMapping() <em>Metric Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricMapping()
	 * @generated
	 * @ordered
	 */
	protected Mapping metricMapping;

	/**
	 * The cached value of the '{@link #getStatistics() <em>Statistics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatistics()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingStatistic> statistics;

	/**
	 * The default value of the '{@link #getFilterPattern() <em>Filter Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String FILTER_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFilterPattern() <em>Filter Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterPattern()
	 * @generated
	 * @ordered
	 */
	protected String filterPattern = FILTER_PATTERN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetricAggregationRules() <em>Metric Aggregation Rules</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricAggregationRules()
	 * @generated
	 * @ordered
	 */
	protected RuleSet metricAggregationRules;

	/**
	 * The default value of the '{@link #getMetricLocation() <em>Metric Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String METRIC_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetricLocation() <em>Metric Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricLocation()
	 * @generated
	 * @ordered
	 */
	protected String metricLocation = METRIC_LOCATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetricRetentionRules() <em>Metric Retention Rules</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricRetentionRules()
	 * @generated
	 * @ordered
	 */
	protected RuleSet metricRetentionRules;

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
	protected MetricSourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.METRIC_SOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping getMetricMapping() {
		return metricMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMetricMapping(Mapping newMetricMapping, NotificationChain msgs) {
		Mapping oldMetricMapping = metricMapping;
		metricMapping = newMetricMapping;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC_SOURCE__METRIC_MAPPING, oldMetricMapping, newMetricMapping);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetricMapping(Mapping newMetricMapping) {
		if (newMetricMapping != metricMapping) {
			NotificationChain msgs = null;
			if (metricMapping != null)
				msgs = ((InternalEObject)metricMapping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetricsPackage.METRIC_SOURCE__METRIC_MAPPING, null, msgs);
			if (newMetricMapping != null)
				msgs = ((InternalEObject)newMetricMapping).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetricsPackage.METRIC_SOURCE__METRIC_MAPPING, null, msgs);
			msgs = basicSetMetricMapping(newMetricMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC_SOURCE__METRIC_MAPPING, newMetricMapping, newMetricMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingStatistic> getStatistics() {
		if (statistics == null) {
			statistics = new EObjectContainmentEList<MappingStatistic>(MappingStatistic.class, this, MetricsPackage.METRIC_SOURCE__STATISTICS);
		}
		return statistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilterPattern() {
		return filterPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilterPattern(String newFilterPattern) {
		String oldFilterPattern = filterPattern;
		filterPattern = newFilterPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC_SOURCE__FILTER_PATTERN, oldFilterPattern, filterPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleSet getMetricAggregationRules() {
		if (metricAggregationRules != null && metricAggregationRules.eIsProxy()) {
			InternalEObject oldMetricAggregationRules = (InternalEObject)metricAggregationRules;
			metricAggregationRules = (RuleSet)eResolveProxy(oldMetricAggregationRules);
			if (metricAggregationRules != oldMetricAggregationRules) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetricsPackage.METRIC_SOURCE__METRIC_AGGREGATION_RULES, oldMetricAggregationRules, metricAggregationRules));
			}
		}
		return metricAggregationRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleSet basicGetMetricAggregationRules() {
		return metricAggregationRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetricAggregationRules(RuleSet newMetricAggregationRules) {
		RuleSet oldMetricAggregationRules = metricAggregationRules;
		metricAggregationRules = newMetricAggregationRules;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC_SOURCE__METRIC_AGGREGATION_RULES, oldMetricAggregationRules, metricAggregationRules));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetricLocation() {
		return metricLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetricLocation(String newMetricLocation) {
		String oldMetricLocation = metricLocation;
		metricLocation = newMetricLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC_SOURCE__METRIC_LOCATION, oldMetricLocation, metricLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleSet getMetricRetentionRules() {
		if (metricRetentionRules != null && metricRetentionRules.eIsProxy()) {
			InternalEObject oldMetricRetentionRules = (InternalEObject)metricRetentionRules;
			metricRetentionRules = (RuleSet)eResolveProxy(oldMetricRetentionRules);
			if (metricRetentionRules != oldMetricRetentionRules) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetricsPackage.METRIC_SOURCE__METRIC_RETENTION_RULES, oldMetricRetentionRules, metricRetentionRules));
			}
		}
		return metricRetentionRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleSet basicGetMetricRetentionRules() {
		return metricRetentionRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetricRetentionRules(RuleSet newMetricRetentionRules) {
		RuleSet oldMetricRetentionRules = metricRetentionRules;
		metricRetentionRules = newMetricRetentionRules;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC_SOURCE__METRIC_RETENTION_RULES, oldMetricRetentionRules, metricRetentionRules));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC_SOURCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetricsPackage.METRIC_SOURCE__METRIC_MAPPING:
				return basicSetMetricMapping(null, msgs);
			case MetricsPackage.METRIC_SOURCE__STATISTICS:
				return ((InternalEList<?>)getStatistics()).basicRemove(otherEnd, msgs);
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
			case MetricsPackage.METRIC_SOURCE__METRIC_MAPPING:
				return getMetricMapping();
			case MetricsPackage.METRIC_SOURCE__STATISTICS:
				return getStatistics();
			case MetricsPackage.METRIC_SOURCE__FILTER_PATTERN:
				return getFilterPattern();
			case MetricsPackage.METRIC_SOURCE__METRIC_AGGREGATION_RULES:
				if (resolve) return getMetricAggregationRules();
				return basicGetMetricAggregationRules();
			case MetricsPackage.METRIC_SOURCE__METRIC_LOCATION:
				return getMetricLocation();
			case MetricsPackage.METRIC_SOURCE__METRIC_RETENTION_RULES:
				if (resolve) return getMetricRetentionRules();
				return basicGetMetricRetentionRules();
			case MetricsPackage.METRIC_SOURCE__NAME:
				return getName();
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
			case MetricsPackage.METRIC_SOURCE__METRIC_MAPPING:
				setMetricMapping((Mapping)newValue);
				return;
			case MetricsPackage.METRIC_SOURCE__STATISTICS:
				getStatistics().clear();
				getStatistics().addAll((Collection<? extends MappingStatistic>)newValue);
				return;
			case MetricsPackage.METRIC_SOURCE__FILTER_PATTERN:
				setFilterPattern((String)newValue);
				return;
			case MetricsPackage.METRIC_SOURCE__METRIC_AGGREGATION_RULES:
				setMetricAggregationRules((RuleSet)newValue);
				return;
			case MetricsPackage.METRIC_SOURCE__METRIC_LOCATION:
				setMetricLocation((String)newValue);
				return;
			case MetricsPackage.METRIC_SOURCE__METRIC_RETENTION_RULES:
				setMetricRetentionRules((RuleSet)newValue);
				return;
			case MetricsPackage.METRIC_SOURCE__NAME:
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
			case MetricsPackage.METRIC_SOURCE__METRIC_MAPPING:
				setMetricMapping((Mapping)null);
				return;
			case MetricsPackage.METRIC_SOURCE__STATISTICS:
				getStatistics().clear();
				return;
			case MetricsPackage.METRIC_SOURCE__FILTER_PATTERN:
				setFilterPattern(FILTER_PATTERN_EDEFAULT);
				return;
			case MetricsPackage.METRIC_SOURCE__METRIC_AGGREGATION_RULES:
				setMetricAggregationRules((RuleSet)null);
				return;
			case MetricsPackage.METRIC_SOURCE__METRIC_LOCATION:
				setMetricLocation(METRIC_LOCATION_EDEFAULT);
				return;
			case MetricsPackage.METRIC_SOURCE__METRIC_RETENTION_RULES:
				setMetricRetentionRules((RuleSet)null);
				return;
			case MetricsPackage.METRIC_SOURCE__NAME:
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
			case MetricsPackage.METRIC_SOURCE__METRIC_MAPPING:
				return metricMapping != null;
			case MetricsPackage.METRIC_SOURCE__STATISTICS:
				return statistics != null && !statistics.isEmpty();
			case MetricsPackage.METRIC_SOURCE__FILTER_PATTERN:
				return FILTER_PATTERN_EDEFAULT == null ? filterPattern != null : !FILTER_PATTERN_EDEFAULT.equals(filterPattern);
			case MetricsPackage.METRIC_SOURCE__METRIC_AGGREGATION_RULES:
				return metricAggregationRules != null;
			case MetricsPackage.METRIC_SOURCE__METRIC_LOCATION:
				return METRIC_LOCATION_EDEFAULT == null ? metricLocation != null : !METRIC_LOCATION_EDEFAULT.equals(metricLocation);
			case MetricsPackage.METRIC_SOURCE__METRIC_RETENTION_RULES:
				return metricRetentionRules != null;
			case MetricsPackage.METRIC_SOURCE__NAME:
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
		result.append(" (filterPattern: ");
		result.append(filterPattern);
		result.append(", metricLocation: ");
		result.append(metricLocation);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MetricSourceImpl
