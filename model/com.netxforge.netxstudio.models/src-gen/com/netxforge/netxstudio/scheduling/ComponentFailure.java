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

import com.netxforge.netxstudio.library.Component;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Failure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Gives information about a failed component
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.ComponentFailure#getComponentRef <em>Component Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.ComponentFailure#getMessage <em>Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getComponentFailure()
 * @model extendedMetaData="name='ComponentFailure' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface ComponentFailure extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Component Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to the component for which the
	 * 						computation failed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Component Ref</em>' reference.
	 * @see #setComponentRef(Component)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getComponentFailure_ComponentRef()
	 * @model extendedMetaData="kind='element' name='ComponentRef'"
	 * @generated
	 */
	Component getComponentRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.ComponentFailure#getComponentRef <em>Component Ref</em>}' reference.
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
	 * Message giving some extra information on the
	 * 						failure
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getComponentFailure_Message()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='Message'"
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.ComponentFailure#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

} // ComponentFailure
