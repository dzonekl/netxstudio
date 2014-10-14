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
package com.netxforge.netxstudio.library.impl;

import com.netxforge.netxstudio.generics.Value;

import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;

import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricValueRange;

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
 * An implementation of the model object '<em><b>Net XResource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getComponentRef <em>Component Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getMetricRef <em>Metric Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getMetricValueRanges <em>Metric Value Ranges</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getCapacityValues <em>Capacity Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getUtilizationValues <em>Utilization Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getForecastCapacityValues <em>Forecast Capacity Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getForecastValues <em>Forecast Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getTrendedValues <em>Trended Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NetXResourceImpl extends BaseResourceImpl implements NetXResource {
	/**
	 * The cached value of the '{@link #getComponentRef() <em>Component Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentRef()
	 * @generated
	 * @ordered
	 */
	protected Component componentRef;

	/**
	 * The cached value of the '{@link #getMetricRef() <em>Metric Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricRef()
	 * @generated
	 * @ordered
	 */
	protected Metric metricRef;

	/**
	 * The cached value of the '{@link #getMetricValueRanges() <em>Metric Value Ranges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricValueRanges()
	 * @generated
	 * @ordered
	 */
	protected EList<MetricValueRange> metricValueRanges;

	/**
	 * The cached value of the '{@link #getCapacityValues() <em>Capacity Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacityValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> capacityValues;

	/**
	 * The cached value of the '{@link #getUtilizationValues() <em>Utilization Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> utilizationValues;

	/**
	 * The cached value of the '{@link #getForecastCapacityValues() <em>Forecast Capacity Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForecastCapacityValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> forecastCapacityValues;

	/**
	 * The cached value of the '{@link #getForecastValues() <em>Forecast Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForecastValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> forecastValues;

	/**
	 * The cached value of the '{@link #getTrendedValues() <em>Trended Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrendedValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> trendedValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NetXResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.NET_XRESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getComponentRef() {
		if (componentRef != null && componentRef.eIsProxy()) {
			InternalEObject oldComponentRef = (InternalEObject)componentRef;
			componentRef = (Component)eResolveProxy(oldComponentRef);
			if (componentRef != oldComponentRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryPackage.NET_XRESOURCE__COMPONENT_REF, oldComponentRef, componentRef));
			}
		}
		return componentRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetComponentRef() {
		return componentRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentRef(Component newComponentRef, NotificationChain msgs) {
		Component oldComponentRef = componentRef;
		componentRef = newComponentRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LibraryPackage.NET_XRESOURCE__COMPONENT_REF, oldComponentRef, newComponentRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentRef(Component newComponentRef) {
		if (newComponentRef != componentRef) {
			NotificationChain msgs = null;
			if (componentRef != null)
				msgs = ((InternalEObject)componentRef).eInverseRemove(this, LibraryPackage.COMPONENT__RESOURCE_REFS, Component.class, msgs);
			if (newComponentRef != null)
				msgs = ((InternalEObject)newComponentRef).eInverseAdd(this, LibraryPackage.COMPONENT__RESOURCE_REFS, Component.class, msgs);
			msgs = basicSetComponentRef(newComponentRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.NET_XRESOURCE__COMPONENT_REF, newComponentRef, newComponentRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metric getMetricRef() {
		if (metricRef != null && metricRef.eIsProxy()) {
			InternalEObject oldMetricRef = (InternalEObject)metricRef;
			metricRef = (Metric)eResolveProxy(oldMetricRef);
			if (metricRef != oldMetricRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryPackage.NET_XRESOURCE__METRIC_REF, oldMetricRef, metricRef));
			}
		}
		return metricRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metric basicGetMetricRef() {
		return metricRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetricRef(Metric newMetricRef) {
		Metric oldMetricRef = metricRef;
		metricRef = newMetricRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.NET_XRESOURCE__METRIC_REF, oldMetricRef, metricRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MetricValueRange> getMetricValueRanges() {
		if (metricValueRanges == null) {
			metricValueRanges = new EObjectContainmentEList<MetricValueRange>(MetricValueRange.class, this, LibraryPackage.NET_XRESOURCE__METRIC_VALUE_RANGES);
		}
		return metricValueRanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getCapacityValues() {
		if (capacityValues == null) {
			capacityValues = new EObjectContainmentEList<Value>(Value.class, this, LibraryPackage.NET_XRESOURCE__CAPACITY_VALUES);
		}
		return capacityValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getUtilizationValues() {
		if (utilizationValues == null) {
			utilizationValues = new EObjectContainmentEList<Value>(Value.class, this, LibraryPackage.NET_XRESOURCE__UTILIZATION_VALUES);
		}
		return utilizationValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getForecastCapacityValues() {
		if (forecastCapacityValues == null) {
			forecastCapacityValues = new EObjectContainmentEList<Value>(Value.class, this, LibraryPackage.NET_XRESOURCE__FORECAST_CAPACITY_VALUES);
		}
		return forecastCapacityValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getForecastValues() {
		if (forecastValues == null) {
			forecastValues = new EObjectContainmentEList<Value>(Value.class, this, LibraryPackage.NET_XRESOURCE__FORECAST_VALUES);
		}
		return forecastValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getTrendedValues() {
		if (trendedValues == null) {
			trendedValues = new EObjectContainmentEList<Value>(Value.class, this, LibraryPackage.NET_XRESOURCE__TRENDED_VALUES);
		}
		return trendedValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryPackage.NET_XRESOURCE__COMPONENT_REF:
				if (componentRef != null)
					msgs = ((InternalEObject)componentRef).eInverseRemove(this, LibraryPackage.COMPONENT__RESOURCE_REFS, Component.class, msgs);
				return basicSetComponentRef((Component)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryPackage.NET_XRESOURCE__COMPONENT_REF:
				return basicSetComponentRef(null, msgs);
			case LibraryPackage.NET_XRESOURCE__METRIC_VALUE_RANGES:
				return ((InternalEList<?>)getMetricValueRanges()).basicRemove(otherEnd, msgs);
			case LibraryPackage.NET_XRESOURCE__CAPACITY_VALUES:
				return ((InternalEList<?>)getCapacityValues()).basicRemove(otherEnd, msgs);
			case LibraryPackage.NET_XRESOURCE__UTILIZATION_VALUES:
				return ((InternalEList<?>)getUtilizationValues()).basicRemove(otherEnd, msgs);
			case LibraryPackage.NET_XRESOURCE__FORECAST_CAPACITY_VALUES:
				return ((InternalEList<?>)getForecastCapacityValues()).basicRemove(otherEnd, msgs);
			case LibraryPackage.NET_XRESOURCE__FORECAST_VALUES:
				return ((InternalEList<?>)getForecastValues()).basicRemove(otherEnd, msgs);
			case LibraryPackage.NET_XRESOURCE__TRENDED_VALUES:
				return ((InternalEList<?>)getTrendedValues()).basicRemove(otherEnd, msgs);
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
			case LibraryPackage.NET_XRESOURCE__COMPONENT_REF:
				if (resolve) return getComponentRef();
				return basicGetComponentRef();
			case LibraryPackage.NET_XRESOURCE__METRIC_REF:
				if (resolve) return getMetricRef();
				return basicGetMetricRef();
			case LibraryPackage.NET_XRESOURCE__METRIC_VALUE_RANGES:
				return getMetricValueRanges();
			case LibraryPackage.NET_XRESOURCE__CAPACITY_VALUES:
				return getCapacityValues();
			case LibraryPackage.NET_XRESOURCE__UTILIZATION_VALUES:
				return getUtilizationValues();
			case LibraryPackage.NET_XRESOURCE__FORECAST_CAPACITY_VALUES:
				return getForecastCapacityValues();
			case LibraryPackage.NET_XRESOURCE__FORECAST_VALUES:
				return getForecastValues();
			case LibraryPackage.NET_XRESOURCE__TRENDED_VALUES:
				return getTrendedValues();
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
			case LibraryPackage.NET_XRESOURCE__COMPONENT_REF:
				setComponentRef((Component)newValue);
				return;
			case LibraryPackage.NET_XRESOURCE__METRIC_REF:
				setMetricRef((Metric)newValue);
				return;
			case LibraryPackage.NET_XRESOURCE__METRIC_VALUE_RANGES:
				getMetricValueRanges().clear();
				getMetricValueRanges().addAll((Collection<? extends MetricValueRange>)newValue);
				return;
			case LibraryPackage.NET_XRESOURCE__CAPACITY_VALUES:
				getCapacityValues().clear();
				getCapacityValues().addAll((Collection<? extends Value>)newValue);
				return;
			case LibraryPackage.NET_XRESOURCE__UTILIZATION_VALUES:
				getUtilizationValues().clear();
				getUtilizationValues().addAll((Collection<? extends Value>)newValue);
				return;
			case LibraryPackage.NET_XRESOURCE__FORECAST_CAPACITY_VALUES:
				getForecastCapacityValues().clear();
				getForecastCapacityValues().addAll((Collection<? extends Value>)newValue);
				return;
			case LibraryPackage.NET_XRESOURCE__FORECAST_VALUES:
				getForecastValues().clear();
				getForecastValues().addAll((Collection<? extends Value>)newValue);
				return;
			case LibraryPackage.NET_XRESOURCE__TRENDED_VALUES:
				getTrendedValues().clear();
				getTrendedValues().addAll((Collection<? extends Value>)newValue);
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
			case LibraryPackage.NET_XRESOURCE__COMPONENT_REF:
				setComponentRef((Component)null);
				return;
			case LibraryPackage.NET_XRESOURCE__METRIC_REF:
				setMetricRef((Metric)null);
				return;
			case LibraryPackage.NET_XRESOURCE__METRIC_VALUE_RANGES:
				getMetricValueRanges().clear();
				return;
			case LibraryPackage.NET_XRESOURCE__CAPACITY_VALUES:
				getCapacityValues().clear();
				return;
			case LibraryPackage.NET_XRESOURCE__UTILIZATION_VALUES:
				getUtilizationValues().clear();
				return;
			case LibraryPackage.NET_XRESOURCE__FORECAST_CAPACITY_VALUES:
				getForecastCapacityValues().clear();
				return;
			case LibraryPackage.NET_XRESOURCE__FORECAST_VALUES:
				getForecastValues().clear();
				return;
			case LibraryPackage.NET_XRESOURCE__TRENDED_VALUES:
				getTrendedValues().clear();
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
			case LibraryPackage.NET_XRESOURCE__COMPONENT_REF:
				return componentRef != null;
			case LibraryPackage.NET_XRESOURCE__METRIC_REF:
				return metricRef != null;
			case LibraryPackage.NET_XRESOURCE__METRIC_VALUE_RANGES:
				return metricValueRanges != null && !metricValueRanges.isEmpty();
			case LibraryPackage.NET_XRESOURCE__CAPACITY_VALUES:
				return capacityValues != null && !capacityValues.isEmpty();
			case LibraryPackage.NET_XRESOURCE__UTILIZATION_VALUES:
				return utilizationValues != null && !utilizationValues.isEmpty();
			case LibraryPackage.NET_XRESOURCE__FORECAST_CAPACITY_VALUES:
				return forecastCapacityValues != null && !forecastCapacityValues.isEmpty();
			case LibraryPackage.NET_XRESOURCE__FORECAST_VALUES:
				return forecastValues != null && !forecastValues.isEmpty();
			case LibraryPackage.NET_XRESOURCE__TRENDED_VALUES:
				return trendedValues != null && !trendedValues.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NetXResourceImpl
