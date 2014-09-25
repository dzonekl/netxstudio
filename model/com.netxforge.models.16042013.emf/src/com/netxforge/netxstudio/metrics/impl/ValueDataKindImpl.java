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

import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.metrics.ValueKindType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Data Kind</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.ValueDataKindImpl#getMetricRef <em>Metric Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.ValueDataKindImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.ValueDataKindImpl#getKindHint <em>Kind Hint</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.ValueDataKindImpl#getValueKind <em>Value Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueDataKindImpl extends DataKindImpl implements ValueDataKind {
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
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected String format = FORMAT_EDEFAULT;

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
	 * The default value of the '{@link #getValueKind() <em>Value Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueKind()
	 * @generated
	 * @ordered
	 */
	protected static final ValueKindType VALUE_KIND_EDEFAULT = ValueKindType.INTERVAL;

	/**
	 * The cached value of the '{@link #getValueKind() <em>Value Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueKind()
	 * @generated
	 * @ordered
	 */
	protected ValueKindType valueKind = VALUE_KIND_EDEFAULT;

	/**
	 * This is true if the Value Kind attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean valueKindESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueDataKindImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.VALUE_DATA_KIND;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetricsPackage.VALUE_DATA_KIND__METRIC_REF, oldMetricRef, metricRef));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.VALUE_DATA_KIND__METRIC_REF, oldMetricRef, metricRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormat(String newFormat) {
		String oldFormat = format;
		format = newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.VALUE_DATA_KIND__FORMAT, oldFormat, format));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.VALUE_DATA_KIND__KIND_HINT, oldKindHint, kindHint, !oldKindHintESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.VALUE_DATA_KIND__KIND_HINT, oldKindHint, KIND_HINT_EDEFAULT, oldKindHintESet));
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
	public ValueKindType getValueKind() {
		return valueKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueKind(ValueKindType newValueKind) {
		ValueKindType oldValueKind = valueKind;
		valueKind = newValueKind == null ? VALUE_KIND_EDEFAULT : newValueKind;
		boolean oldValueKindESet = valueKindESet;
		valueKindESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.VALUE_DATA_KIND__VALUE_KIND, oldValueKind, valueKind, !oldValueKindESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetValueKind() {
		ValueKindType oldValueKind = valueKind;
		boolean oldValueKindESet = valueKindESet;
		valueKind = VALUE_KIND_EDEFAULT;
		valueKindESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.VALUE_DATA_KIND__VALUE_KIND, oldValueKind, VALUE_KIND_EDEFAULT, oldValueKindESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetValueKind() {
		return valueKindESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetricsPackage.VALUE_DATA_KIND__METRIC_REF:
				if (resolve) return getMetricRef();
				return basicGetMetricRef();
			case MetricsPackage.VALUE_DATA_KIND__FORMAT:
				return getFormat();
			case MetricsPackage.VALUE_DATA_KIND__KIND_HINT:
				return getKindHint();
			case MetricsPackage.VALUE_DATA_KIND__VALUE_KIND:
				return getValueKind();
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
			case MetricsPackage.VALUE_DATA_KIND__METRIC_REF:
				setMetricRef((Metric)newValue);
				return;
			case MetricsPackage.VALUE_DATA_KIND__FORMAT:
				setFormat((String)newValue);
				return;
			case MetricsPackage.VALUE_DATA_KIND__KIND_HINT:
				setKindHint((KindHintType)newValue);
				return;
			case MetricsPackage.VALUE_DATA_KIND__VALUE_KIND:
				setValueKind((ValueKindType)newValue);
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
			case MetricsPackage.VALUE_DATA_KIND__METRIC_REF:
				setMetricRef((Metric)null);
				return;
			case MetricsPackage.VALUE_DATA_KIND__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case MetricsPackage.VALUE_DATA_KIND__KIND_HINT:
				unsetKindHint();
				return;
			case MetricsPackage.VALUE_DATA_KIND__VALUE_KIND:
				unsetValueKind();
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
			case MetricsPackage.VALUE_DATA_KIND__METRIC_REF:
				return metricRef != null;
			case MetricsPackage.VALUE_DATA_KIND__FORMAT:
				return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals(format);
			case MetricsPackage.VALUE_DATA_KIND__KIND_HINT:
				return isSetKindHint();
			case MetricsPackage.VALUE_DATA_KIND__VALUE_KIND:
				return isSetValueKind();
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
		result.append(" (format: ");
		result.append(format);
		result.append(", kindHint: ");
		if (kindHintESet) result.append(kindHint); else result.append("<unset>");
		result.append(", valueKind: ");
		if (valueKindESet) result.append(valueKind); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ValueDataKindImpl
