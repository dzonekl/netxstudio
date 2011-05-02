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

import com.netxforge.netxstudio.generics.Value;

import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MetricValueRange;
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
 * An implementation of the model object '<em><b>Metric Value Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricValueRangeImpl#getMetricValues <em>Metric Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricValueRangeImpl#getKindHint <em>Kind Hint</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricValueRangeImpl#getPeriodHint <em>Period Hint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetricValueRangeImpl extends EObjectImpl implements MetricValueRange {
	/**
	 * The cached value of the '{@link #getMetricValues() <em>Metric Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> metricValues;

	/**
	 * The default value of the '{@link #getKindHint() <em>Kind Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKindHint()
	 * @generated
	 * @ordered
	 */
	protected static final KindHintType KIND_HINT_EDEFAULT = KindHintType.BH;

	/**
	 * The cached value of the '{@link #getKindHint() <em>Kind Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKindHint()
	 * @generated
	 * @ordered
	 */
	protected KindHintType kindHint = KIND_HINT_EDEFAULT;

	/**
	 * This is true if the Kind Hint attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean kindHintESet;

	/**
	 * The default value of the '{@link #getPeriodHint() <em>Period Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriodHint()
	 * @generated
	 * @ordered
	 */
	protected static final int PERIOD_HINT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPeriodHint() <em>Period Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriodHint()
	 * @generated
	 * @ordered
	 */
	protected int periodHint = PERIOD_HINT_EDEFAULT;

	/**
	 * This is true if the Period Hint attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean periodHintESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricValueRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.METRIC_VALUE_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getMetricValues() {
		if (metricValues == null) {
			metricValues = new EObjectContainmentEList<Value>(Value.class, this, MetricsPackage.METRIC_VALUE_RANGE__METRIC_VALUES);
		}
		return metricValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KindHintType getKindHint() {
		return kindHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKindHint(KindHintType newKindHint) {
		KindHintType oldKindHint = kindHint;
		kindHint = newKindHint == null ? KIND_HINT_EDEFAULT : newKindHint;
		boolean oldKindHintESet = kindHintESet;
		kindHintESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC_VALUE_RANGE__KIND_HINT, oldKindHint, kindHint, !oldKindHintESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetKindHint() {
		KindHintType oldKindHint = kindHint;
		boolean oldKindHintESet = kindHintESet;
		kindHint = KIND_HINT_EDEFAULT;
		kindHintESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.METRIC_VALUE_RANGE__KIND_HINT, oldKindHint, KIND_HINT_EDEFAULT, oldKindHintESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetKindHint() {
		return kindHintESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPeriodHint() {
		return periodHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriodHint(int newPeriodHint) {
		int oldPeriodHint = periodHint;
		periodHint = newPeriodHint;
		boolean oldPeriodHintESet = periodHintESet;
		periodHintESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC_VALUE_RANGE__PERIOD_HINT, oldPeriodHint, periodHint, !oldPeriodHintESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPeriodHint() {
		int oldPeriodHint = periodHint;
		boolean oldPeriodHintESet = periodHintESet;
		periodHint = PERIOD_HINT_EDEFAULT;
		periodHintESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.METRIC_VALUE_RANGE__PERIOD_HINT, oldPeriodHint, PERIOD_HINT_EDEFAULT, oldPeriodHintESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPeriodHint() {
		return periodHintESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetricsPackage.METRIC_VALUE_RANGE__METRIC_VALUES:
				return ((InternalEList<?>)getMetricValues()).basicRemove(otherEnd, msgs);
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
			case MetricsPackage.METRIC_VALUE_RANGE__METRIC_VALUES:
				return getMetricValues();
			case MetricsPackage.METRIC_VALUE_RANGE__KIND_HINT:
				return getKindHint();
			case MetricsPackage.METRIC_VALUE_RANGE__PERIOD_HINT:
				return getPeriodHint();
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
			case MetricsPackage.METRIC_VALUE_RANGE__METRIC_VALUES:
				getMetricValues().clear();
				getMetricValues().addAll((Collection<? extends Value>)newValue);
				return;
			case MetricsPackage.METRIC_VALUE_RANGE__KIND_HINT:
				setKindHint((KindHintType)newValue);
				return;
			case MetricsPackage.METRIC_VALUE_RANGE__PERIOD_HINT:
				setPeriodHint((Integer)newValue);
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
			case MetricsPackage.METRIC_VALUE_RANGE__METRIC_VALUES:
				getMetricValues().clear();
				return;
			case MetricsPackage.METRIC_VALUE_RANGE__KIND_HINT:
				unsetKindHint();
				return;
			case MetricsPackage.METRIC_VALUE_RANGE__PERIOD_HINT:
				unsetPeriodHint();
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
			case MetricsPackage.METRIC_VALUE_RANGE__METRIC_VALUES:
				return metricValues != null && !metricValues.isEmpty();
			case MetricsPackage.METRIC_VALUE_RANGE__KIND_HINT:
				return isSetKindHint();
			case MetricsPackage.METRIC_VALUE_RANGE__PERIOD_HINT:
				return isSetPeriodHint();
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
		result.append(" (kindHint: ");
		if (kindHintESet) result.append(kindHint); else result.append("<unset>");
		result.append(", periodHint: ");
		if (periodHintESet) result.append(periodHint); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //MetricValueRangeImpl
