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
package com.netxforge.netxstudio.services;

import com.netxforge.netxstudio.generics.Base;

import com.netxforge.netxstudio.library.ReferenceRelationship;

import com.netxforge.netxstudio.protocols.Message;
import com.netxforge.netxstudio.protocols.Protocol;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Flow Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a Service flow Relationship.
 * 				Service flows are part of an RFService. A Service flow consists of
 * 				service
 * 				legs. Service
 * 				flows operate on the Nodes of a Service.
 * 				A
 * 				service leg, has a start and end point, which represents the
 * 				reference interface
 * 				between two node types.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceFlowRelationship#getReferenceRelationship <em>Reference Relationship</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceFlowRelationship#getServiceFlow <em>Service Flow</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceFlowRelationship#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceFlowRelationship#getMessage <em>Message</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceFlowRelationship#getDirection <em>Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceFlowRelationship()
 * @model extendedMetaData="name='ServiceFlowRelationship' kind='elementOnly'"
 * @generated
 */
public interface ServiceFlowRelationship extends Base {
	/**
	 * Returns the value of the '<em><b>Reference Relationship</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 								
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reference Relationship</em>' reference.
	 * @see #setReferenceRelationship(ReferenceRelationship)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceFlowRelationship_ReferenceRelationship()
	 * @model extendedMetaData="kind='element' name='ReferenceRelationship'"
	 * @generated
	 */
	ReferenceRelationship getReferenceRelationship();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceFlowRelationship#getReferenceRelationship <em>Reference Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Relationship</em>' reference.
	 * @see #getReferenceRelationship()
	 * @generated
	 */
	void setReferenceRelationship(ReferenceRelationship value);

	/**
	 * Returns the value of the '<em><b>Service Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 								
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service Flow</em>' reference.
	 * @see #setServiceFlow(ServiceFlow)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceFlowRelationship_ServiceFlow()
	 * @model extendedMetaData="kind='element' name='ServiceFlow'"
	 * @generated
	 */
	ServiceFlow getServiceFlow();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceFlowRelationship#getServiceFlow <em>Service Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Flow</em>' reference.
	 * @see #getServiceFlow()
	 * @generated
	 */
	void setServiceFlow(ServiceFlow value);

	/**
	 * Returns the value of the '<em><b>Protocol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protocol used on the service flow. 
	 * 							In contrary to the protocol of the reference interface, which is likely different. 
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protocol</em>' reference.
	 * @see #setProtocol(Protocol)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceFlowRelationship_Protocol()
	 * @model extendedMetaData="kind='element' name='Protocol'"
	 * @generated
	 */
	Protocol getProtocol();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceFlowRelationship#getProtocol <em>Protocol</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol</em>' reference.
	 * @see #getProtocol()
	 * @generated
	 */
	void setProtocol(Protocol value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The specific message for the protocol. 
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Message</em>' reference.
	 * @see #setMessage(Message)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceFlowRelationship_Message()
	 * @model extendedMetaData="kind='element' name='Message'"
	 * @generated
	 */
	Message getMessage();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceFlowRelationship#getMessage <em>Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' reference.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(Message value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.services.ServiceFlowDirection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The direction of the Service Flow, between the
	 * 							Node types in the reference relationship.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see com.netxforge.netxstudio.services.ServiceFlowDirection
	 * @see #isSetDirection()
	 * @see #unsetDirection()
	 * @see #setDirection(ServiceFlowDirection)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceFlowRelationship_Direction()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='Direction'"
	 * @generated
	 */
	ServiceFlowDirection getDirection();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceFlowRelationship#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see com.netxforge.netxstudio.services.ServiceFlowDirection
	 * @see #isSetDirection()
	 * @see #unsetDirection()
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(ServiceFlowDirection value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.services.ServiceFlowRelationship#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDirection()
	 * @see #getDirection()
	 * @see #setDirection(ServiceFlowDirection)
	 * @generated
	 */
	void unsetDirection();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.services.ServiceFlowRelationship#getDirection <em>Direction</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Direction</em>' attribute is set.
	 * @see #unsetDirection()
	 * @see #getDirection()
	 * @see #setDirection(ServiceFlowDirection)
	 * @generated
	 */
	boolean isSetDirection();

} // ServiceFlowRelationship
