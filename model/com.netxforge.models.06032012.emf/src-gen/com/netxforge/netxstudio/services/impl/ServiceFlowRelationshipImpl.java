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
package com.netxforge.netxstudio.services.impl;

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.library.ReferenceRelationship;

import com.netxforge.netxstudio.protocols.Message;
import com.netxforge.netxstudio.protocols.Protocol;

import com.netxforge.netxstudio.services.ServiceFlow;
import com.netxforge.netxstudio.services.ServiceFlowDirection;
import com.netxforge.netxstudio.services.ServiceFlowRelationship;
import com.netxforge.netxstudio.services.ServicesPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

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
	 * The cached value of the '{@link #getReferenceRelationship() <em>Reference Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceRelationship()
	 * @generated
	 * @ordered
	 */
	protected ReferenceRelationship referenceRelationship;

	/**
	 * The cached value of the '{@link #getServiceFlow() <em>Service Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceFlow()
	 * @generated
	 * @ordered
	 */
	protected ServiceFlow serviceFlow;

	/**
	 * The cached value of the '{@link #getProtocol() <em>Protocol</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
	protected Protocol protocol;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected Message message;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final ServiceFlowDirection DIRECTION_EDEFAULT = ServiceFlowDirection.LEFTTORIGHT;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected ServiceFlowDirection direction = DIRECTION_EDEFAULT;

	/**
	 * This is true if the Direction attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean directionESet;

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
		if (referenceRelationship != null && referenceRelationship.eIsProxy()) {
			InternalEObject oldReferenceRelationship = (InternalEObject)referenceRelationship;
			referenceRelationship = (ReferenceRelationship)eResolveProxy(oldReferenceRelationship);
			if (referenceRelationship != oldReferenceRelationship) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicesPackage.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP, oldReferenceRelationship, referenceRelationship));
			}
		}
		return referenceRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceRelationship basicGetReferenceRelationship() {
		return referenceRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceRelationship(ReferenceRelationship newReferenceRelationship) {
		ReferenceRelationship oldReferenceRelationship = referenceRelationship;
		referenceRelationship = newReferenceRelationship;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP, oldReferenceRelationship, referenceRelationship));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceFlow getServiceFlow() {
		if (serviceFlow != null && serviceFlow.eIsProxy()) {
			InternalEObject oldServiceFlow = (InternalEObject)serviceFlow;
			serviceFlow = (ServiceFlow)eResolveProxy(oldServiceFlow);
			if (serviceFlow != oldServiceFlow) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicesPackage.SERVICE_FLOW_RELATIONSHIP__SERVICE_FLOW, oldServiceFlow, serviceFlow));
			}
		}
		return serviceFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceFlow basicGetServiceFlow() {
		return serviceFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceFlow(ServiceFlow newServiceFlow) {
		ServiceFlow oldServiceFlow = serviceFlow;
		serviceFlow = newServiceFlow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE_FLOW_RELATIONSHIP__SERVICE_FLOW, oldServiceFlow, serviceFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protocol getProtocol() {
		if (protocol != null && protocol.eIsProxy()) {
			InternalEObject oldProtocol = (InternalEObject)protocol;
			protocol = (Protocol)eResolveProxy(oldProtocol);
			if (protocol != oldProtocol) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicesPackage.SERVICE_FLOW_RELATIONSHIP__PROTOCOL, oldProtocol, protocol));
			}
		}
		return protocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protocol basicGetProtocol() {
		return protocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocol(Protocol newProtocol) {
		Protocol oldProtocol = protocol;
		protocol = newProtocol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE_FLOW_RELATIONSHIP__PROTOCOL, oldProtocol, protocol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMessage(Message newMessage, NotificationChain msgs) {
		Message oldMessage = message;
		message = newMessage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE_FLOW_RELATIONSHIP__MESSAGE, oldMessage, newMessage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(Message newMessage) {
		if (newMessage != message) {
			NotificationChain msgs = null;
			if (message != null)
				msgs = ((InternalEObject)message).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicesPackage.SERVICE_FLOW_RELATIONSHIP__MESSAGE, null, msgs);
			if (newMessage != null)
				msgs = ((InternalEObject)newMessage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicesPackage.SERVICE_FLOW_RELATIONSHIP__MESSAGE, null, msgs);
			msgs = basicSetMessage(newMessage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE_FLOW_RELATIONSHIP__MESSAGE, newMessage, newMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceFlowDirection getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(ServiceFlowDirection newDirection) {
		ServiceFlowDirection oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		boolean oldDirectionESet = directionESet;
		directionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE_FLOW_RELATIONSHIP__DIRECTION, oldDirection, direction, !oldDirectionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDirection() {
		ServiceFlowDirection oldDirection = direction;
		boolean oldDirectionESet = directionESet;
		direction = DIRECTION_EDEFAULT;
		directionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ServicesPackage.SERVICE_FLOW_RELATIONSHIP__DIRECTION, oldDirection, DIRECTION_EDEFAULT, oldDirectionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDirection() {
		return directionESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__MESSAGE:
				return basicSetMessage(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP:
				if (resolve) return getReferenceRelationship();
				return basicGetReferenceRelationship();
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__SERVICE_FLOW:
				if (resolve) return getServiceFlow();
				return basicGetServiceFlow();
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__PROTOCOL:
				if (resolve) return getProtocol();
				return basicGetProtocol();
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__MESSAGE:
				return getMessage();
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__DIRECTION:
				return getDirection();
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
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP:
				setReferenceRelationship((ReferenceRelationship)newValue);
				return;
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__SERVICE_FLOW:
				setServiceFlow((ServiceFlow)newValue);
				return;
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__PROTOCOL:
				setProtocol((Protocol)newValue);
				return;
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__MESSAGE:
				setMessage((Message)newValue);
				return;
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__DIRECTION:
				setDirection((ServiceFlowDirection)newValue);
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
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP:
				setReferenceRelationship((ReferenceRelationship)null);
				return;
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__SERVICE_FLOW:
				setServiceFlow((ServiceFlow)null);
				return;
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__PROTOCOL:
				setProtocol((Protocol)null);
				return;
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__MESSAGE:
				setMessage((Message)null);
				return;
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__DIRECTION:
				unsetDirection();
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
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP:
				return referenceRelationship != null;
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__SERVICE_FLOW:
				return serviceFlow != null;
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__PROTOCOL:
				return protocol != null;
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__MESSAGE:
				return message != null;
			case ServicesPackage.SERVICE_FLOW_RELATIONSHIP__DIRECTION:
				return isSetDirection();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (direction: ");
		if (directionESet) result.append(direction); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ServiceFlowRelationshipImpl
