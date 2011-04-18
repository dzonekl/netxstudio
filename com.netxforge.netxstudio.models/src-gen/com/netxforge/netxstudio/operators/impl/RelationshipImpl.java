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

import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.Relationship;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.RelationshipImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.RelationshipImpl#getNodeID1Ref <em>Node ID1 Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.RelationshipImpl#getNodeID2Ref <em>Node ID2 Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.RelationshipImpl#getProtocolRef <em>Protocol Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationshipImpl extends EObjectImpl implements Relationship {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNodeID1Ref() <em>Node ID1 Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeID1Ref()
	 * @generated
	 * @ordered
	 */
	protected Node nodeID1Ref;

	/**
	 * The cached value of the '{@link #getNodeID2Ref() <em>Node ID2 Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeID2Ref()
	 * @generated
	 * @ordered
	 */
	protected Node nodeID2Ref;

	/**
	 * The cached value of the '{@link #getProtocolRef() <em>Protocol Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocolRef()
	 * @generated
	 * @ordered
	 */
	protected EObject protocolRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorsPackage.Literals.RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.RELATIONSHIP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getNodeID1Ref() {
		if (nodeID1Ref != null && nodeID1Ref.eIsProxy()) {
			InternalEObject oldNodeID1Ref = (InternalEObject)nodeID1Ref;
			nodeID1Ref = (Node)eResolveProxy(oldNodeID1Ref);
			if (nodeID1Ref != oldNodeID1Ref) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.RELATIONSHIP__NODE_ID1_REF, oldNodeID1Ref, nodeID1Ref));
			}
		}
		return nodeID1Ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetNodeID1Ref() {
		return nodeID1Ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeID1Ref(Node newNodeID1Ref) {
		Node oldNodeID1Ref = nodeID1Ref;
		nodeID1Ref = newNodeID1Ref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.RELATIONSHIP__NODE_ID1_REF, oldNodeID1Ref, nodeID1Ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getNodeID2Ref() {
		if (nodeID2Ref != null && nodeID2Ref.eIsProxy()) {
			InternalEObject oldNodeID2Ref = (InternalEObject)nodeID2Ref;
			nodeID2Ref = (Node)eResolveProxy(oldNodeID2Ref);
			if (nodeID2Ref != oldNodeID2Ref) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.RELATIONSHIP__NODE_ID2_REF, oldNodeID2Ref, nodeID2Ref));
			}
		}
		return nodeID2Ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetNodeID2Ref() {
		return nodeID2Ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeID2Ref(Node newNodeID2Ref) {
		Node oldNodeID2Ref = nodeID2Ref;
		nodeID2Ref = newNodeID2Ref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.RELATIONSHIP__NODE_ID2_REF, oldNodeID2Ref, nodeID2Ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getProtocolRef() {
		if (protocolRef != null && protocolRef.eIsProxy()) {
			InternalEObject oldProtocolRef = (InternalEObject)protocolRef;
			protocolRef = eResolveProxy(oldProtocolRef);
			if (protocolRef != oldProtocolRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.RELATIONSHIP__PROTOCOL_REF, oldProtocolRef, protocolRef));
			}
		}
		return protocolRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetProtocolRef() {
		return protocolRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocolRef(EObject newProtocolRef) {
		EObject oldProtocolRef = protocolRef;
		protocolRef = newProtocolRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.RELATIONSHIP__PROTOCOL_REF, oldProtocolRef, protocolRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperatorsPackage.RELATIONSHIP__NAME:
				return getName();
			case OperatorsPackage.RELATIONSHIP__NODE_ID1_REF:
				if (resolve) return getNodeID1Ref();
				return basicGetNodeID1Ref();
			case OperatorsPackage.RELATIONSHIP__NODE_ID2_REF:
				if (resolve) return getNodeID2Ref();
				return basicGetNodeID2Ref();
			case OperatorsPackage.RELATIONSHIP__PROTOCOL_REF:
				if (resolve) return getProtocolRef();
				return basicGetProtocolRef();
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
			case OperatorsPackage.RELATIONSHIP__NAME:
				setName((String)newValue);
				return;
			case OperatorsPackage.RELATIONSHIP__NODE_ID1_REF:
				setNodeID1Ref((Node)newValue);
				return;
			case OperatorsPackage.RELATIONSHIP__NODE_ID2_REF:
				setNodeID2Ref((Node)newValue);
				return;
			case OperatorsPackage.RELATIONSHIP__PROTOCOL_REF:
				setProtocolRef((EObject)newValue);
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
			case OperatorsPackage.RELATIONSHIP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OperatorsPackage.RELATIONSHIP__NODE_ID1_REF:
				setNodeID1Ref((Node)null);
				return;
			case OperatorsPackage.RELATIONSHIP__NODE_ID2_REF:
				setNodeID2Ref((Node)null);
				return;
			case OperatorsPackage.RELATIONSHIP__PROTOCOL_REF:
				setProtocolRef((EObject)null);
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
			case OperatorsPackage.RELATIONSHIP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OperatorsPackage.RELATIONSHIP__NODE_ID1_REF:
				return nodeID1Ref != null;
			case OperatorsPackage.RELATIONSHIP__NODE_ID2_REF:
				return nodeID2Ref != null;
			case OperatorsPackage.RELATIONSHIP__PROTOCOL_REF:
				return protocolRef != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //RelationshipImpl
