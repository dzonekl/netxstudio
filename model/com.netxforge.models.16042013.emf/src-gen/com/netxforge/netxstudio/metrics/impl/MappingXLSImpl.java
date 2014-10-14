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

import com.netxforge.netxstudio.metrics.MappingXLS;
import com.netxforge.netxstudio.metrics.MetricsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping XLS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingXLSImpl#getFilterPattern <em>Filter Pattern</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingXLSImpl#getSheetNumber <em>Sheet Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingXLSImpl extends MappingImpl implements MappingXLS {
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
	 * The default value of the '{@link #getSheetNumber() <em>Sheet Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSheetNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int SHEET_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSheetNumber() <em>Sheet Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSheetNumber()
	 * @generated
	 * @ordered
	 */
	protected int sheetNumber = SHEET_NUMBER_EDEFAULT;

	/**
	 * This is true if the Sheet Number attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean sheetNumberESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingXLSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.MAPPING_XLS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_XLS__FILTER_PATTERN, oldFilterPattern, filterPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSheetNumber() {
		return sheetNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSheetNumber(int newSheetNumber) {
		int oldSheetNumber = sheetNumber;
		sheetNumber = newSheetNumber;
		boolean oldSheetNumberESet = sheetNumberESet;
		sheetNumberESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_XLS__SHEET_NUMBER, oldSheetNumber, sheetNumber, !oldSheetNumberESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSheetNumber() {
		int oldSheetNumber = sheetNumber;
		boolean oldSheetNumberESet = sheetNumberESet;
		sheetNumber = SHEET_NUMBER_EDEFAULT;
		sheetNumberESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.MAPPING_XLS__SHEET_NUMBER, oldSheetNumber, SHEET_NUMBER_EDEFAULT, oldSheetNumberESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSheetNumber() {
		return sheetNumberESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetricsPackage.MAPPING_XLS__FILTER_PATTERN:
				return getFilterPattern();
			case MetricsPackage.MAPPING_XLS__SHEET_NUMBER:
				return getSheetNumber();
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
			case MetricsPackage.MAPPING_XLS__FILTER_PATTERN:
				setFilterPattern((String)newValue);
				return;
			case MetricsPackage.MAPPING_XLS__SHEET_NUMBER:
				setSheetNumber((Integer)newValue);
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
			case MetricsPackage.MAPPING_XLS__FILTER_PATTERN:
				setFilterPattern(FILTER_PATTERN_EDEFAULT);
				return;
			case MetricsPackage.MAPPING_XLS__SHEET_NUMBER:
				unsetSheetNumber();
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
			case MetricsPackage.MAPPING_XLS__FILTER_PATTERN:
				return FILTER_PATTERN_EDEFAULT == null ? filterPattern != null : !FILTER_PATTERN_EDEFAULT.equals(filterPattern);
			case MetricsPackage.MAPPING_XLS__SHEET_NUMBER:
				return isSetSheetNumber();
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
		result.append(", sheetNumber: ");
		if (sheetNumberESet) result.append(sheetNumber); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //MappingXLSImpl
