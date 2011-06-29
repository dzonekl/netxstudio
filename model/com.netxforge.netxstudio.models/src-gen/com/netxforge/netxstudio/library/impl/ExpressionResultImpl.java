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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.ExpressionResult;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.RangeKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionResultImpl#getTargetResource <em>Target Resource</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionResultImpl#getTargetRange <em>Target Range</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionResultImpl#getTargetValues <em>Target Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionResultImpl#getTargetPeriod <em>Target Period</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionResultImpl extends CDOObjectImpl implements ExpressionResult {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.EXPRESSION_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetXResource getTargetResource() {
		return (NetXResource)eGet(LibraryPackage.Literals.EXPRESSION_RESULT__TARGET_RESOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetResource(NetXResource newTargetResource) {
		eSet(LibraryPackage.Literals.EXPRESSION_RESULT__TARGET_RESOURCE, newTargetResource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeKind getTargetRange() {
		return (RangeKind)eGet(LibraryPackage.Literals.EXPRESSION_RESULT__TARGET_RANGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetRange(RangeKind newTargetRange) {
		eSet(LibraryPackage.Literals.EXPRESSION_RESULT__TARGET_RANGE, newTargetRange);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTargetRange() {
		eUnset(LibraryPackage.Literals.EXPRESSION_RESULT__TARGET_RANGE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTargetRange() {
		return eIsSet(LibraryPackage.Literals.EXPRESSION_RESULT__TARGET_RANGE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Value> getTargetValues() {
		return (EList<Value>)eGet(LibraryPackage.Literals.EXPRESSION_RESULT__TARGET_VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTargetPeriod() {
		return (Integer)eGet(LibraryPackage.Literals.EXPRESSION_RESULT__TARGET_PERIOD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPeriod(int newTargetPeriod) {
		eSet(LibraryPackage.Literals.EXPRESSION_RESULT__TARGET_PERIOD, newTargetPeriod);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTargetPeriod() {
		eUnset(LibraryPackage.Literals.EXPRESSION_RESULT__TARGET_PERIOD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTargetPeriod() {
		return eIsSet(LibraryPackage.Literals.EXPRESSION_RESULT__TARGET_PERIOD);
	}

} //ExpressionResultImpl
