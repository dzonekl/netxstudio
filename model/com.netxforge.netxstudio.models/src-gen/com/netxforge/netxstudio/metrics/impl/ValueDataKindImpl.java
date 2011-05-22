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

import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.metrics.ValueKindType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Data Kind</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.ValueDataKindImpl#getMetricRef <em>Metric Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.ValueDataKindImpl#getKindHint <em>Kind Hint</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.ValueDataKindImpl#getValueKind <em>Value Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueDataKindImpl extends DataKindImpl implements ValueDataKind {
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
		return (Metric)eGet(MetricsPackage.Literals.VALUE_DATA_KIND__METRIC_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetricRef(Metric newMetricRef) {
		eSet(MetricsPackage.Literals.VALUE_DATA_KIND__METRIC_REF, newMetricRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KindHintType getKindHint() {
		return (KindHintType)eGet(MetricsPackage.Literals.VALUE_DATA_KIND__KIND_HINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKindHint(KindHintType newKindHint) {
		eSet(MetricsPackage.Literals.VALUE_DATA_KIND__KIND_HINT, newKindHint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetKindHint() {
		eUnset(MetricsPackage.Literals.VALUE_DATA_KIND__KIND_HINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetKindHint() {
		return eIsSet(MetricsPackage.Literals.VALUE_DATA_KIND__KIND_HINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueKindType getValueKind() {
		return (ValueKindType)eGet(MetricsPackage.Literals.VALUE_DATA_KIND__VALUE_KIND, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueKind(ValueKindType newValueKind) {
		eSet(MetricsPackage.Literals.VALUE_DATA_KIND__VALUE_KIND, newValueKind);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetValueKind() {
		eUnset(MetricsPackage.Literals.VALUE_DATA_KIND__VALUE_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetValueKind() {
		return eIsSet(MetricsPackage.Literals.VALUE_DATA_KIND__VALUE_KIND);
	}

} //ValueDataKindImpl
