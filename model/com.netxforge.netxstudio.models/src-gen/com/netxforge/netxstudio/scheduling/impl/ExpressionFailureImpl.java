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
package com.netxforge.netxstudio.scheduling.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.scheduling.ExpressionFailure;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Failure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.ExpressionFailureImpl#getExpressionRef <em>Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.ExpressionFailureImpl#getComponentRef <em>Component Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.ExpressionFailureImpl#getMessage <em>Message</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionFailureImpl extends CDOObjectImpl implements ExpressionFailure {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionFailureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.EXPRESSION_FAILURE;
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
	public EObject getExpressionRef() {
		return (EObject)eGet(SchedulingPackage.Literals.EXPRESSION_FAILURE__EXPRESSION_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionRef(EObject newExpressionRef) {
		eSet(SchedulingPackage.Literals.EXPRESSION_FAILURE__EXPRESSION_REF, newExpressionRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Component getComponentRef() {
		return (Component)eGet(SchedulingPackage.Literals.EXPRESSION_FAILURE__COMPONENT_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentRef(Component newComponentRef) {
		eSet(SchedulingPackage.Literals.EXPRESSION_FAILURE__COMPONENT_REF, newComponentRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return (String)eGet(SchedulingPackage.Literals.EXPRESSION_FAILURE__MESSAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		eSet(SchedulingPackage.Literals.EXPRESSION_FAILURE__MESSAGE, newMessage);
	}

} //ExpressionFailureImpl
