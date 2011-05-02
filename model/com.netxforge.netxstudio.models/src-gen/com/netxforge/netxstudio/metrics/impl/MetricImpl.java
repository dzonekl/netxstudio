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
package com.netxforge.netxstudio.metrics.impl;

import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getMeasurementKind <em>Measurement Kind</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getMeasurementPoint <em>Measurement Point</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getMetricCalculation <em>Metric Calculation</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getMetricSourceRef <em>Metric Source Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getUnitRef <em>Unit Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetricImpl extends EObjectImpl implements Metric {
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getMeasurementKind() <em>Measurement Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasurementKind()
	 * @generated
	 * @ordered
	 */
	protected static final String MEASUREMENT_KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMeasurementKind() <em>Measurement Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasurementKind()
	 * @generated
	 * @ordered
	 */
	protected String measurementKind = MEASUREMENT_KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getMeasurementPoint() <em>Measurement Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasurementPoint()
	 * @generated
	 * @ordered
	 */
	protected static final String MEASUREMENT_POINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMeasurementPoint() <em>Measurement Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasurementPoint()
	 * @generated
	 * @ordered
	 */
	protected String measurementPoint = MEASUREMENT_POINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetricCalculation() <em>Metric Calculation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricCalculation()
	 * @generated
	 * @ordered
	 */
	protected static final String METRIC_CALCULATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetricCalculation() <em>Metric Calculation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricCalculation()
	 * @generated
	 * @ordered
	 */
	protected String metricCalculation = METRIC_CALCULATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetricSourceRef() <em>Metric Source Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricSourceRef()
	 * @generated
	 * @ordered
	 */
	protected MetricSource metricSourceRef;

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
	 * The default value of the '{@link #getUnitRef() <em>Unit Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitRef()
	 * @generated
	 * @ordered
	 */
	protected static final String UNIT_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnitRef() <em>Unit Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitRef()
	 * @generated
	 * @ordered
	 */
	protected String unitRef = UNIT_REF_EDEFAULT;

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
	public EList<Metric> getMetrics() {
		if (metrics == null) {
			metrics = new EObjectContainmentEList<Metric>(Metric.class, this, MetricsPackage.METRIC__METRICS);
		}
		return metrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeasurementKind() {
		return measurementKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasurementKind(String newMeasurementKind) {
		String oldMeasurementKind = measurementKind;
		measurementKind = newMeasurementKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC__MEASUREMENT_KIND, oldMeasurementKind, measurementKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeasurementPoint() {
		return measurementPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasurementPoint(String newMeasurementPoint) {
		String oldMeasurementPoint = measurementPoint;
		measurementPoint = newMeasurementPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC__MEASUREMENT_POINT, oldMeasurementPoint, measurementPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetricCalculation() {
		return metricCalculation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetricCalculation(String newMetricCalculation) {
		String oldMetricCalculation = metricCalculation;
		metricCalculation = newMetricCalculation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC__METRIC_CALCULATION, oldMetricCalculation, metricCalculation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricSource getMetricSourceRef() {
		if (metricSourceRef != null && metricSourceRef.eIsProxy()) {
			InternalEObject oldMetricSourceRef = (InternalEObject)metricSourceRef;
			metricSourceRef = (MetricSource)eResolveProxy(oldMetricSourceRef);
			if (metricSourceRef != oldMetricSourceRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetricsPackage.METRIC__METRIC_SOURCE_REF, oldMetricSourceRef, metricSourceRef));
			}
		}
		return metricSourceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricSource basicGetMetricSourceRef() {
		return metricSourceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMetricSourceRef(MetricSource newMetricSourceRef, NotificationChain msgs) {
		MetricSource oldMetricSourceRef = metricSourceRef;
		metricSourceRef = newMetricSourceRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC__METRIC_SOURCE_REF, oldMetricSourceRef, newMetricSourceRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetricSourceRef(MetricSource newMetricSourceRef) {
		if (newMetricSourceRef != metricSourceRef) {
			NotificationChain msgs = null;
			if (metricSourceRef != null)
				msgs = ((InternalEObject)metricSourceRef).eInverseRemove(this, MetricsPackage.METRIC_SOURCE__METRIC_REFS, MetricSource.class, msgs);
			if (newMetricSourceRef != null)
				msgs = ((InternalEObject)newMetricSourceRef).eInverseAdd(this, MetricsPackage.METRIC_SOURCE__METRIC_REFS, MetricSource.class, msgs);
			msgs = basicSetMetricSourceRef(newMetricSourceRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC__METRIC_SOURCE_REF, newMetricSourceRef, newMetricSourceRef));
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
	public String getUnitRef() {
		return unitRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitRef(String newUnitRef) {
		String oldUnitRef = unitRef;
		unitRef = newUnitRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC__UNIT_REF, oldUnitRef, unitRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetricsPackage.METRIC__METRIC_SOURCE_REF:
				if (metricSourceRef != null)
					msgs = ((InternalEObject)metricSourceRef).eInverseRemove(this, MetricsPackage.METRIC_SOURCE__METRIC_REFS, MetricSource.class, msgs);
				return basicSetMetricSourceRef((MetricSource)otherEnd, msgs);
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
			case MetricsPackage.METRIC__METRICS:
				return ((InternalEList<?>)getMetrics()).basicRemove(otherEnd, msgs);
			case MetricsPackage.METRIC__METRIC_SOURCE_REF:
				return basicSetMetricSourceRef(null, msgs);
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
			case MetricsPackage.METRIC__METRICS:
				return getMetrics();
			case MetricsPackage.METRIC__DESCRIPTION:
				return getDescription();
			case MetricsPackage.METRIC__MEASUREMENT_KIND:
				return getMeasurementKind();
			case MetricsPackage.METRIC__MEASUREMENT_POINT:
				return getMeasurementPoint();
			case MetricsPackage.METRIC__METRIC_CALCULATION:
				return getMetricCalculation();
			case MetricsPackage.METRIC__METRIC_SOURCE_REF:
				if (resolve) return getMetricSourceRef();
				return basicGetMetricSourceRef();
			case MetricsPackage.METRIC__NAME:
				return getName();
			case MetricsPackage.METRIC__UNIT_REF:
				return getUnitRef();
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
			case MetricsPackage.METRIC__METRICS:
				getMetrics().clear();
				getMetrics().addAll((Collection<? extends Metric>)newValue);
				return;
			case MetricsPackage.METRIC__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case MetricsPackage.METRIC__MEASUREMENT_KIND:
				setMeasurementKind((String)newValue);
				return;
			case MetricsPackage.METRIC__MEASUREMENT_POINT:
				setMeasurementPoint((String)newValue);
				return;
			case MetricsPackage.METRIC__METRIC_CALCULATION:
				setMetricCalculation((String)newValue);
				return;
			case MetricsPackage.METRIC__METRIC_SOURCE_REF:
				setMetricSourceRef((MetricSource)newValue);
				return;
			case MetricsPackage.METRIC__NAME:
				setName((String)newValue);
				return;
			case MetricsPackage.METRIC__UNIT_REF:
				setUnitRef((String)newValue);
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
			case MetricsPackage.METRIC__METRICS:
				getMetrics().clear();
				return;
			case MetricsPackage.METRIC__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MetricsPackage.METRIC__MEASUREMENT_KIND:
				setMeasurementKind(MEASUREMENT_KIND_EDEFAULT);
				return;
			case MetricsPackage.METRIC__MEASUREMENT_POINT:
				setMeasurementPoint(MEASUREMENT_POINT_EDEFAULT);
				return;
			case MetricsPackage.METRIC__METRIC_CALCULATION:
				setMetricCalculation(METRIC_CALCULATION_EDEFAULT);
				return;
			case MetricsPackage.METRIC__METRIC_SOURCE_REF:
				setMetricSourceRef((MetricSource)null);
				return;
			case MetricsPackage.METRIC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MetricsPackage.METRIC__UNIT_REF:
				setUnitRef(UNIT_REF_EDEFAULT);
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
			case MetricsPackage.METRIC__METRICS:
				return metrics != null && !metrics.isEmpty();
			case MetricsPackage.METRIC__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case MetricsPackage.METRIC__MEASUREMENT_KIND:
				return MEASUREMENT_KIND_EDEFAULT == null ? measurementKind != null : !MEASUREMENT_KIND_EDEFAULT.equals(measurementKind);
			case MetricsPackage.METRIC__MEASUREMENT_POINT:
				return MEASUREMENT_POINT_EDEFAULT == null ? measurementPoint != null : !MEASUREMENT_POINT_EDEFAULT.equals(measurementPoint);
			case MetricsPackage.METRIC__METRIC_CALCULATION:
				return METRIC_CALCULATION_EDEFAULT == null ? metricCalculation != null : !METRIC_CALCULATION_EDEFAULT.equals(metricCalculation);
			case MetricsPackage.METRIC__METRIC_SOURCE_REF:
				return metricSourceRef != null;
			case MetricsPackage.METRIC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MetricsPackage.METRIC__UNIT_REF:
				return UNIT_REF_EDEFAULT == null ? unitRef != null : !UNIT_REF_EDEFAULT.equals(unitRef);
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
		result.append(" (description: ");
		result.append(description);
		result.append(", measurementKind: ");
		result.append(measurementKind);
		result.append(", measurementPoint: ");
		result.append(measurementPoint);
		result.append(", metricCalculation: ");
		result.append(metricCalculation);
		result.append(", name: ");
		result.append(name);
		result.append(", unitRef: ");
		result.append(unitRef);
		result.append(')');
		return result.toString();
	}

} //MetricImpl
