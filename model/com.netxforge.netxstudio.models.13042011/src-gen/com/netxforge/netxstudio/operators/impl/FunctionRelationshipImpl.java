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
package com.netxforge.netxstudio.operators.impl;

import com.netxforge.netxstudio.library.Function;

import com.netxforge.netxstudio.operators.FunctionRelationship;
import com.netxforge.netxstudio.operators.OperatorsPackage;

import org.eclipse.emf.ecore.EClass;

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
		return (Function)eGet(OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION1_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction1Ref(Function newFunction1Ref) {
		eSet(OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION1_REF, newFunction1Ref);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction2Ref() {
		return (Function)eGet(OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION2_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction2Ref(Function newFunction2Ref) {
		eSet(OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION2_REF, newFunction2Ref);
	}

} //FunctionRelationshipImpl
