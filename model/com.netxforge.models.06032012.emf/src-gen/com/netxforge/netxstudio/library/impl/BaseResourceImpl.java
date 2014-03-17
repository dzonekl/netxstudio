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

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.Unit;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.BaseResourceImpl#isDetailDisplay <em>Detail Display</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.BaseResourceImpl#getExpressionName <em>Expression Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.BaseResourceImpl#getLongName <em>Long Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.BaseResourceImpl#getShortName <em>Short Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.BaseResourceImpl#isSummaryDisplay <em>Summary Display</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.BaseResourceImpl#getUnitRef <em>Unit Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BaseResourceImpl extends BaseImpl implements BaseResource {
	/**
	 * The default value of the '{@link #isDetailDisplay() <em>Detail Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDetailDisplay()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DETAIL_DISPLAY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDetailDisplay() <em>Detail Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDetailDisplay()
	 * @generated
	 * @ordered
	 */
	protected boolean detailDisplay = DETAIL_DISPLAY_EDEFAULT;

	/**
	 * This is true if the Detail Display attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean detailDisplayESet;

	/**
	 * The default value of the '{@link #getExpressionName() <em>Expression Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionName()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpressionName() <em>Expression Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionName()
	 * @generated
	 * @ordered
	 */
	protected String expressionName = EXPRESSION_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLongName() <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongName()
	 * @generated
	 * @ordered
	 */
	protected static final String LONG_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLongName() <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongName()
	 * @generated
	 * @ordered
	 */
	protected String longName = LONG_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getShortName() <em>Short Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortName()
	 * @generated
	 * @ordered
	 */
	protected static final String SHORT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShortName() <em>Short Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortName()
	 * @generated
	 * @ordered
	 */
	protected String shortName = SHORT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isSummaryDisplay() <em>Summary Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSummaryDisplay()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUMMARY_DISPLAY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSummaryDisplay() <em>Summary Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSummaryDisplay()
	 * @generated
	 * @ordered
	 */
	protected boolean summaryDisplay = SUMMARY_DISPLAY_EDEFAULT;

	/**
	 * This is true if the Summary Display attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean summaryDisplayESet;

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
	protected BaseResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.BASE_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDetailDisplay() {
		return detailDisplay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDetailDisplay(boolean newDetailDisplay) {
		boolean oldDetailDisplay = detailDisplay;
		detailDisplay = newDetailDisplay;
		boolean oldDetailDisplayESet = detailDisplayESet;
		detailDisplayESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.BASE_RESOURCE__DETAIL_DISPLAY, oldDetailDisplay, detailDisplay, !oldDetailDisplayESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDetailDisplay() {
		boolean oldDetailDisplay = detailDisplay;
		boolean oldDetailDisplayESet = detailDisplayESet;
		detailDisplay = DETAIL_DISPLAY_EDEFAULT;
		detailDisplayESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LibraryPackage.BASE_RESOURCE__DETAIL_DISPLAY, oldDetailDisplay, DETAIL_DISPLAY_EDEFAULT, oldDetailDisplayESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDetailDisplay() {
		return detailDisplayESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpressionName() {
		return expressionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionName(String newExpressionName) {
		String oldExpressionName = expressionName;
		expressionName = newExpressionName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.BASE_RESOURCE__EXPRESSION_NAME, oldExpressionName, expressionName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongName() {
		return longName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongName(String newLongName) {
		String oldLongName = longName;
		longName = newLongName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.BASE_RESOURCE__LONG_NAME, oldLongName, longName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShortName(String newShortName) {
		String oldShortName = shortName;
		shortName = newShortName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.BASE_RESOURCE__SHORT_NAME, oldShortName, shortName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSummaryDisplay() {
		return summaryDisplay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSummaryDisplay(boolean newSummaryDisplay) {
		boolean oldSummaryDisplay = summaryDisplay;
		summaryDisplay = newSummaryDisplay;
		boolean oldSummaryDisplayESet = summaryDisplayESet;
		summaryDisplayESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.BASE_RESOURCE__SUMMARY_DISPLAY, oldSummaryDisplay, summaryDisplay, !oldSummaryDisplayESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSummaryDisplay() {
		boolean oldSummaryDisplay = summaryDisplay;
		boolean oldSummaryDisplayESet = summaryDisplayESet;
		summaryDisplay = SUMMARY_DISPLAY_EDEFAULT;
		summaryDisplayESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LibraryPackage.BASE_RESOURCE__SUMMARY_DISPLAY, oldSummaryDisplay, SUMMARY_DISPLAY_EDEFAULT, oldSummaryDisplayESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSummaryDisplay() {
		return summaryDisplayESet;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryPackage.BASE_RESOURCE__UNIT_REF, oldUnitRef, unitRef));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.BASE_RESOURCE__UNIT_REF, oldUnitRef, unitRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LibraryPackage.BASE_RESOURCE__DETAIL_DISPLAY:
				return isDetailDisplay();
			case LibraryPackage.BASE_RESOURCE__EXPRESSION_NAME:
				return getExpressionName();
			case LibraryPackage.BASE_RESOURCE__LONG_NAME:
				return getLongName();
			case LibraryPackage.BASE_RESOURCE__SHORT_NAME:
				return getShortName();
			case LibraryPackage.BASE_RESOURCE__SUMMARY_DISPLAY:
				return isSummaryDisplay();
			case LibraryPackage.BASE_RESOURCE__UNIT_REF:
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LibraryPackage.BASE_RESOURCE__DETAIL_DISPLAY:
				setDetailDisplay((Boolean)newValue);
				return;
			case LibraryPackage.BASE_RESOURCE__EXPRESSION_NAME:
				setExpressionName((String)newValue);
				return;
			case LibraryPackage.BASE_RESOURCE__LONG_NAME:
				setLongName((String)newValue);
				return;
			case LibraryPackage.BASE_RESOURCE__SHORT_NAME:
				setShortName((String)newValue);
				return;
			case LibraryPackage.BASE_RESOURCE__SUMMARY_DISPLAY:
				setSummaryDisplay((Boolean)newValue);
				return;
			case LibraryPackage.BASE_RESOURCE__UNIT_REF:
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
			case LibraryPackage.BASE_RESOURCE__DETAIL_DISPLAY:
				unsetDetailDisplay();
				return;
			case LibraryPackage.BASE_RESOURCE__EXPRESSION_NAME:
				setExpressionName(EXPRESSION_NAME_EDEFAULT);
				return;
			case LibraryPackage.BASE_RESOURCE__LONG_NAME:
				setLongName(LONG_NAME_EDEFAULT);
				return;
			case LibraryPackage.BASE_RESOURCE__SHORT_NAME:
				setShortName(SHORT_NAME_EDEFAULT);
				return;
			case LibraryPackage.BASE_RESOURCE__SUMMARY_DISPLAY:
				unsetSummaryDisplay();
				return;
			case LibraryPackage.BASE_RESOURCE__UNIT_REF:
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
			case LibraryPackage.BASE_RESOURCE__DETAIL_DISPLAY:
				return isSetDetailDisplay();
			case LibraryPackage.BASE_RESOURCE__EXPRESSION_NAME:
				return EXPRESSION_NAME_EDEFAULT == null ? expressionName != null : !EXPRESSION_NAME_EDEFAULT.equals(expressionName);
			case LibraryPackage.BASE_RESOURCE__LONG_NAME:
				return LONG_NAME_EDEFAULT == null ? longName != null : !LONG_NAME_EDEFAULT.equals(longName);
			case LibraryPackage.BASE_RESOURCE__SHORT_NAME:
				return SHORT_NAME_EDEFAULT == null ? shortName != null : !SHORT_NAME_EDEFAULT.equals(shortName);
			case LibraryPackage.BASE_RESOURCE__SUMMARY_DISPLAY:
				return isSetSummaryDisplay();
			case LibraryPackage.BASE_RESOURCE__UNIT_REF:
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
		result.append(" (detailDisplay: ");
		if (detailDisplayESet) result.append(detailDisplay); else result.append("<unset>");
		result.append(", expressionName: ");
		result.append(expressionName);
		result.append(", longName: ");
		result.append(longName);
		result.append(", shortName: ");
		result.append(shortName);
		result.append(", summaryDisplay: ");
		if (summaryDisplayESet) result.append(summaryDisplay); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //BaseResourceImpl
