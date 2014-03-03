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
package com.netxforge.netxstudio.library.impl;

import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.generics.impl.BaseImpl;
import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.Unit;

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
		return (Boolean)eGet(LibraryPackage.Literals.BASE_RESOURCE__DETAIL_DISPLAY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDetailDisplay(boolean newDetailDisplay) {
		eSet(LibraryPackage.Literals.BASE_RESOURCE__DETAIL_DISPLAY, newDetailDisplay);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDetailDisplay() {
		eUnset(LibraryPackage.Literals.BASE_RESOURCE__DETAIL_DISPLAY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDetailDisplay() {
		return eIsSet(LibraryPackage.Literals.BASE_RESOURCE__DETAIL_DISPLAY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpressionName() {
		return (String)eGet(LibraryPackage.Literals.BASE_RESOURCE__EXPRESSION_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionName(String newExpressionName) {
		eSet(LibraryPackage.Literals.BASE_RESOURCE__EXPRESSION_NAME, newExpressionName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongName() {
		return (String)eGet(LibraryPackage.Literals.BASE_RESOURCE__LONG_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongName(String newLongName) {
		eSet(LibraryPackage.Literals.BASE_RESOURCE__LONG_NAME, newLongName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShortName() {
		return (String)eGet(LibraryPackage.Literals.BASE_RESOURCE__SHORT_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShortName(String newShortName) {
		eSet(LibraryPackage.Literals.BASE_RESOURCE__SHORT_NAME, newShortName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSummaryDisplay() {
		return (Boolean)eGet(LibraryPackage.Literals.BASE_RESOURCE__SUMMARY_DISPLAY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSummaryDisplay(boolean newSummaryDisplay) {
		eSet(LibraryPackage.Literals.BASE_RESOURCE__SUMMARY_DISPLAY, newSummaryDisplay);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSummaryDisplay() {
		eUnset(LibraryPackage.Literals.BASE_RESOURCE__SUMMARY_DISPLAY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSummaryDisplay() {
		return eIsSet(LibraryPackage.Literals.BASE_RESOURCE__SUMMARY_DISPLAY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit getUnitRef() {
		return (Unit)eGet(LibraryPackage.Literals.BASE_RESOURCE__UNIT_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitRef(Unit newUnitRef) {
		eSet(LibraryPackage.Literals.BASE_RESOURCE__UNIT_REF, newUnitRef);
	}

} //BaseResourceImpl
