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

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Unit;

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
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getExpressionRef <em>Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getMeasurementKind <em>Measurement Kind</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getMeasurementPoint <em>Measurement Point</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getMetricSourceRef <em>Metric Source Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getUnitRef <em>Unit Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetricImpl extends BaseImpl implements Metric {
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
	 * The cached value of the '{@link #getExpressionRef() <em>Expression Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionRef()
	 * @generated
	 * @ordered
	 */
	protected Expression expressionRef;

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
	 * The cached value of the '{@link #getUnitRef() <em>Unit Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitRef()
	 * @generated
	 * @ordered
	 */
	protected Unit unitRef;

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
	public Expression getExpressionRef() {
		if (expressionRef != null && expressionRef.eIsProxy()) {
			InternalEObject oldExpressionRef = (InternalEObject)expressionRef;
			expressionRef = (Expression)eResolveProxy(oldExpressionRef);
			if (expressionRef != oldExpressionRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetricsPackage.METRIC__EXPRESSION_REF, oldExpressionRef, expressionRef));
			}
		}
		return expressionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetExpressionRef() {
		return expressionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionRef(Expression newExpressionRef) {
		Expression oldExpressionRef = expressionRef;
		expressionRef = newExpressionRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC__EXPRESSION_REF, oldExpressionRef, expressionRef));
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
	public void setMetricSourceRef(MetricSource newMetricSourceRef) {
		MetricSource oldMetricSourceRef = metricSourceRef;
		metricSourceRef = newMetricSourceRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC__METRIC_SOURCE_REF, oldMetricSourceRef, metricSourceRef));
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
	public Unit getUnitRef() {
		if (unitRef != null && unitRef.eIsProxy()) {
			InternalEObject oldUnitRef = (InternalEObject)unitRef;
			unitRef = (Unit)eResolveProxy(oldUnitRef);
			if (unitRef != oldUnitRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetricsPackage.METRIC__UNIT_REF, oldUnitRef, unitRef));
			}
		}
		return unitRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit basicGetUnitRef() {
		return unitRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitRef(Unit newUnitRef) {
		Unit oldUnitRef = unitRef;
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetricsPackage.METRIC__METRICS:
				return ((InternalEList<?>)getMetrics()).basicRemove(otherEnd, msgs);
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
			case MetricsPackage.METRIC__EXPRESSION_REF:
				if (resolve) return getExpressionRef();
				return basicGetExpressionRef();
			case MetricsPackage.METRIC__DESCRIPTION:
				return getDescription();
			case MetricsPackage.METRIC__MEASUREMENT_KIND:
				return getMeasurementKind();
			case MetricsPackage.METRIC__MEASUREMENT_POINT:
				return getMeasurementPoint();
			case MetricsPackage.METRIC__METRIC_SOURCE_REF:
				if (resolve) return getMetricSourceRef();
				return basicGetMetricSourceRef();
			case MetricsPackage.METRIC__NAME:
				return getName();
			case MetricsPackage.METRIC__UNIT_REF:
				if (resolve) return getUnitRef();
				return basicGetUnitRef();
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
			case MetricsPackage.METRIC__EXPRESSION_REF:
				setExpressionRef((Expression)newValue);
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
			case MetricsPackage.METRIC__METRIC_SOURCE_REF:
				setMetricSourceRef((MetricSource)newValue);
				return;
			case MetricsPackage.METRIC__NAME:
				setName((String)newValue);
				return;
			case MetricsPackage.METRIC__UNIT_REF:
				setUnitRef((Unit)newValue);
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
			case MetricsPackage.METRIC__EXPRESSION_REF:
				setExpressionRef((Expression)null);
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
			case MetricsPackage.METRIC__METRIC_SOURCE_REF:
				setMetricSourceRef((MetricSource)null);
				return;
			case MetricsPackage.METRIC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MetricsPackage.METRIC__UNIT_REF:
				setUnitRef((Unit)null);
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
			case MetricsPackage.METRIC__EXPRESSION_REF:
				return expressionRef != null;
			case MetricsPackage.METRIC__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case MetricsPackage.METRIC__MEASUREMENT_KIND:
				return MEASUREMENT_KIND_EDEFAULT == null ? measurementKind != null : !MEASUREMENT_KIND_EDEFAULT.equals(measurementKind);
			case MetricsPackage.METRIC__MEASUREMENT_POINT:
				return MEASUREMENT_POINT_EDEFAULT == null ? measurementPoint != null : !MEASUREMENT_POINT_EDEFAULT.equals(measurementPoint);
			case MetricsPackage.METRIC__METRIC_SOURCE_REF:
				return metricSourceRef != null;
			case MetricsPackage.METRIC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MetricsPackage.METRIC__UNIT_REF:
				return unitRef != null;
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
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MetricImpl
