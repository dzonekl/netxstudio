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
package com.netxforge.netxstudio.services;

import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.Base;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a Service flow.
 * 				Service flows
 * 				are part of an RFService. A Service flow consists of service
 * 				legs.
 * 				Service
 * 				flows operate on the Nodes of a Service.
 * 				A service leg, has a
 * 				start and end point, which represents the
 * 				reference interface
 * 				between
 * 				two node types.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceFlow#getServiceFlowRelationships <em>Service Flow Relationships</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceFlow#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceFlow()
 * @model extendedMetaData="name='ServiceFlow' kind='elementOnly'"
 * @generated
 */
public interface ServiceFlow extends Base {
	/**
	 * Returns the value of the '<em><b>Service Flow Relationships</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.services.ServiceFlowRelationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ServiceFlowRelationships are a sequence of
	 * 								ServiceFlowRelationship.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service Flow Relationships</em>' containment reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceFlow_ServiceFlowRelationships()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ServiceFlowRelationships'"
	 * @generated
	 */
	EList<ServiceFlowRelationship> getServiceFlowRelationships();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the Service Flow.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceFlow_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceFlow#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // ServiceFlow
