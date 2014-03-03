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
package com.netxforge.netxstudio.services.impl;

import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.generics.impl.BaseImpl;
import com.netxforge.netxstudio.library.ReferenceRelationship;
import com.netxforge.netxstudio.protocols.Message;
import com.netxforge.netxstudio.protocols.Protocol;
import com.netxforge.netxstudio.services.ServiceFlow;
import com.netxforge.netxstudio.services.ServiceFlowDirection;
import com.netxforge.netxstudio.services.ServiceFlowRelationship;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Flow Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceFlowRelationshipImpl#getReferenceRelationship <em>Reference Relationship</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceFlowRelationshipImpl#getServiceFlow <em>Service Flow</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceFlowRelationshipImpl#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceFlowRelationshipImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceFlowRelationshipImpl#getDirection <em>Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceFlowRelationshipImpl extends BaseImpl implements ServiceFlowRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceFlowRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceRelationship getReferenceRelationship() {
		return (ReferenceRelationship)eGet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceRelationship(ReferenceRelationship newReferenceRelationship) {
		eSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP, newReferenceRelationship);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceFlow getServiceFlow() {
		return (ServiceFlow)eGet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__SERVICE_FLOW, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceFlow(ServiceFlow newServiceFlow) {
		eSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__SERVICE_FLOW, newServiceFlow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protocol getProtocol() {
		return (Protocol)eGet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__PROTOCOL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocol(Protocol newProtocol) {
		eSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__PROTOCOL, newProtocol);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getMessage() {
		return (Message)eGet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__MESSAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(Message newMessage) {
		eSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__MESSAGE, newMessage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceFlowDirection getDirection() {
		return (ServiceFlowDirection)eGet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__DIRECTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(ServiceFlowDirection newDirection) {
		eSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__DIRECTION, newDirection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDirection() {
		eUnset(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__DIRECTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDirection() {
		return eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__DIRECTION);
	}

} //ServiceFlowRelationshipImpl
