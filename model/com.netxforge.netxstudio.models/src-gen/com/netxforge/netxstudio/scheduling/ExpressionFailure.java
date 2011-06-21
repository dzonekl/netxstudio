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
package com.netxforge.netxstudio.scheduling;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EObject;

import com.netxforge.netxstudio.library.Component;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Failure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Gives information about a failed expression
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.ExpressionFailure#getExpressionRef <em>Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.ExpressionFailure#getComponentRef <em>Component Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.ExpressionFailure#getMessage <em>Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getExpressionFailure()
 * @model extendedMetaData="name='ExpressionFailure' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface ExpressionFailure extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression which failed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression Ref</em>' reference.
	 * @see #setExpressionRef(EObject)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getExpressionFailure_ExpressionRef()
	 * @model extendedMetaData="kind='element' name='ExpressionRef'"
	 * @generated
	 */
	EObject getExpressionRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.ExpressionFailure#getExpressionRef <em>Expression Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression Ref</em>' reference.
	 * @see #getExpressionRef()
	 * @generated
	 */
	void setExpressionRef(EObject value);

	/**
	 * Returns the value of the '<em><b>Component Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to the component for which the computation failed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Component Ref</em>' reference.
	 * @see #setComponentRef(Component)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getExpressionFailure_ComponentRef()
	 * @model extendedMetaData="kind='element' name='ComponentRef'"
	 * @generated
	 */
	Component getComponentRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.ExpressionFailure#getComponentRef <em>Component Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Ref</em>' reference.
	 * @see #getComponentRef()
	 * @generated
	 */
	void setComponentRef(Component value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Message giving some extra information on the failure
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getExpressionFailure_Message()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='Message'"
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.ExpressionFailure#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

} // ExpressionFailure
