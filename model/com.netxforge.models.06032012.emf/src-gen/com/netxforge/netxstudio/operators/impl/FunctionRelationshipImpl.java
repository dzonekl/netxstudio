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
package com.netxforge.netxstudio.operators.impl;

import com.netxforge.netxstudio.library.Function;

import com.netxforge.netxstudio.operators.FunctionRelationship;
import com.netxforge.netxstudio.operators.OperatorsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.FunctionRelationshipImpl#getFunction1Ref <em>Function1 Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.FunctionRelationshipImpl#getFunction2Ref <em>Function2 Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionRelationshipImpl extends RelationshipImpl implements FunctionRelationship {
	/**
	 * The cached value of the '{@link #getFunction1Ref() <em>Function1 Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunction1Ref()
	 * @generated
	 * @ordered
	 */
	protected Function function1Ref;

	/**
	 * The cached value of the '{@link #getFunction2Ref() <em>Function2 Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunction2Ref()
	 * @generated
	 * @ordered
	 */
	protected Function function2Ref;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorsPackage.Literals.FUNCTION_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction1Ref() {
		if (function1Ref != null && function1Ref.eIsProxy()) {
			InternalEObject oldFunction1Ref = (InternalEObject)function1Ref;
			function1Ref = (Function)eResolveProxy(oldFunction1Ref);
			if (function1Ref != oldFunction1Ref) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.FUNCTION_RELATIONSHIP__FUNCTION1_REF, oldFunction1Ref, function1Ref));
			}
		}
		return function1Ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetFunction1Ref() {
		return function1Ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction1Ref(Function newFunction1Ref) {
		Function oldFunction1Ref = function1Ref;
		function1Ref = newFunction1Ref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.FUNCTION_RELATIONSHIP__FUNCTION1_REF, oldFunction1Ref, function1Ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction2Ref() {
		if (function2Ref != null && function2Ref.eIsProxy()) {
			InternalEObject oldFunction2Ref = (InternalEObject)function2Ref;
			function2Ref = (Function)eResolveProxy(oldFunction2Ref);
			if (function2Ref != oldFunction2Ref) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.FUNCTION_RELATIONSHIP__FUNCTION2_REF, oldFunction2Ref, function2Ref));
			}
		}
		return function2Ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetFunction2Ref() {
		return function2Ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction2Ref(Function newFunction2Ref) {
		Function oldFunction2Ref = function2Ref;
		function2Ref = newFunction2Ref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.FUNCTION_RELATIONSHIP__FUNCTION2_REF, oldFunction2Ref, function2Ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperatorsPackage.FUNCTION_RELATIONSHIP__FUNCTION1_REF:
				if (resolve) return getFunction1Ref();
				return basicGetFunction1Ref();
			case OperatorsPackage.FUNCTION_RELATIONSHIP__FUNCTION2_REF:
				if (resolve) return getFunction2Ref();
				return basicGetFunction2Ref();
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
			case OperatorsPackage.FUNCTION_RELATIONSHIP__FUNCTION1_REF:
				setFunction1Ref((Function)newValue);
				return;
			case OperatorsPackage.FUNCTION_RELATIONSHIP__FUNCTION2_REF:
				setFunction2Ref((Function)newValue);
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
			case OperatorsPackage.FUNCTION_RELATIONSHIP__FUNCTION1_REF:
				setFunction1Ref((Function)null);
				return;
			case OperatorsPackage.FUNCTION_RELATIONSHIP__FUNCTION2_REF:
				setFunction2Ref((Function)null);
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
			case OperatorsPackage.FUNCTION_RELATIONSHIP__FUNCTION1_REF:
				return function1Ref != null;
			case OperatorsPackage.FUNCTION_RELATIONSHIP__FUNCTION2_REF:
				return function2Ref != null;
		}
		return super.eIsSet(featureID);
	}

} //FunctionRelationshipImpl
