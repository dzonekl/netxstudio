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

import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.generics.Person;

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.geo.Location;

import com.netxforge.netxstudio.library.NodeType;

import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.NodeImpl#getLifecycle <em>Lifecycle</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.NodeImpl#getNodeType <em>Node Type</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.NodeImpl#getCreatedByRef <em>Created By Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.NodeImpl#getLocationRef <em>Location Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.NodeImpl#getNodeID <em>Node ID</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.NodeImpl#getOriginalNodeTypeRef <em>Original Node Type Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeImpl extends BaseImpl implements Node {
	/**
	 * The cached value of the '{@link #getLifecycle() <em>Lifecycle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLifecycle()
	 * @generated
	 * @ordered
	 */
	protected Lifecycle lifecycle;

	/**
	 * The cached value of the '{@link #getNodeType() <em>Node Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeType()
	 * @generated
	 * @ordered
	 */
	protected NodeType nodeType;

	/**
	 * The cached value of the '{@link #getCreatedByRef() <em>Created By Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatedByRef()
	 * @generated
	 * @ordered
	 */
	protected Person createdByRef;

	/**
	 * The cached value of the '{@link #getLocationRef() <em>Location Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocationRef()
	 * @generated
	 * @ordered
	 */
	protected Location locationRef;

	/**
	 * The default value of the '{@link #getNodeID() <em>Node ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeID()
	 * @generated
	 * @ordered
	 */
	protected static final String NODE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNodeID() <em>Node ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeID()
	 * @generated
	 * @ordered
	 */
	protected String nodeID = NODE_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOriginalNodeTypeRef() <em>Original Node Type Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalNodeTypeRef()
	 * @generated
	 * @ordered
	 */
	protected NodeType originalNodeTypeRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorsPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lifecycle getLifecycle() {
		return lifecycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLifecycle(Lifecycle newLifecycle, NotificationChain msgs) {
		Lifecycle oldLifecycle = lifecycle;
		lifecycle = newLifecycle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperatorsPackage.NODE__LIFECYCLE, oldLifecycle, newLifecycle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLifecycle(Lifecycle newLifecycle) {
		if (newLifecycle != lifecycle) {
			NotificationChain msgs = null;
			if (lifecycle != null)
				msgs = ((InternalEObject)lifecycle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.NODE__LIFECYCLE, null, msgs);
			if (newLifecycle != null)
				msgs = ((InternalEObject)newLifecycle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.NODE__LIFECYCLE, null, msgs);
			msgs = basicSetLifecycle(newLifecycle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.NODE__LIFECYCLE, newLifecycle, newLifecycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType getNodeType() {
		return nodeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNodeType(NodeType newNodeType, NotificationChain msgs) {
		NodeType oldNodeType = nodeType;
		nodeType = newNodeType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperatorsPackage.NODE__NODE_TYPE, oldNodeType, newNodeType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeType(NodeType newNodeType) {
		if (newNodeType != nodeType) {
			NotificationChain msgs = null;
			if (nodeType != null)
				msgs = ((InternalEObject)nodeType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.NODE__NODE_TYPE, null, msgs);
			if (newNodeType != null)
				msgs = ((InternalEObject)newNodeType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.NODE__NODE_TYPE, null, msgs);
			msgs = basicSetNodeType(newNodeType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.NODE__NODE_TYPE, newNodeType, newNodeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person getCreatedByRef() {
		if (createdByRef != null && createdByRef.eIsProxy()) {
			InternalEObject oldCreatedByRef = (InternalEObject)createdByRef;
			createdByRef = (Person)eResolveProxy(oldCreatedByRef);
			if (createdByRef != oldCreatedByRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.NODE__CREATED_BY_REF, oldCreatedByRef, createdByRef));
			}
		}
		return createdByRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person basicGetCreatedByRef() {
		return createdByRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatedByRef(Person newCreatedByRef) {
		Person oldCreatedByRef = createdByRef;
		createdByRef = newCreatedByRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.NODE__CREATED_BY_REF, oldCreatedByRef, createdByRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location getLocationRef() {
		if (locationRef != null && locationRef.eIsProxy()) {
			InternalEObject oldLocationRef = (InternalEObject)locationRef;
			locationRef = (Location)eResolveProxy(oldLocationRef);
			if (locationRef != oldLocationRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.NODE__LOCATION_REF, oldLocationRef, locationRef));
			}
		}
		return locationRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location basicGetLocationRef() {
		return locationRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocationRef(Location newLocationRef) {
		Location oldLocationRef = locationRef;
		locationRef = newLocationRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.NODE__LOCATION_REF, oldLocationRef, locationRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNodeID() {
		return nodeID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeID(String newNodeID) {
		String oldNodeID = nodeID;
		nodeID = newNodeID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.NODE__NODE_ID, oldNodeID, nodeID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType getOriginalNodeTypeRef() {
		if (originalNodeTypeRef != null && originalNodeTypeRef.eIsProxy()) {
			InternalEObject oldOriginalNodeTypeRef = (InternalEObject)originalNodeTypeRef;
			originalNodeTypeRef = (NodeType)eResolveProxy(oldOriginalNodeTypeRef);
			if (originalNodeTypeRef != oldOriginalNodeTypeRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.NODE__ORIGINAL_NODE_TYPE_REF, oldOriginalNodeTypeRef, originalNodeTypeRef));
			}
		}
		return originalNodeTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType basicGetOriginalNodeTypeRef() {
		return originalNodeTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalNodeTypeRef(NodeType newOriginalNodeTypeRef) {
		NodeType oldOriginalNodeTypeRef = originalNodeTypeRef;
		originalNodeTypeRef = newOriginalNodeTypeRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.NODE__ORIGINAL_NODE_TYPE_REF, oldOriginalNodeTypeRef, originalNodeTypeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperatorsPackage.NODE__LIFECYCLE:
				return basicSetLifecycle(null, msgs);
			case OperatorsPackage.NODE__NODE_TYPE:
				return basicSetNodeType(null, msgs);
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
			case OperatorsPackage.NODE__LIFECYCLE:
				return getLifecycle();
			case OperatorsPackage.NODE__NODE_TYPE:
				return getNodeType();
			case OperatorsPackage.NODE__CREATED_BY_REF:
				if (resolve) return getCreatedByRef();
				return basicGetCreatedByRef();
			case OperatorsPackage.NODE__LOCATION_REF:
				if (resolve) return getLocationRef();
				return basicGetLocationRef();
			case OperatorsPackage.NODE__NODE_ID:
				return getNodeID();
			case OperatorsPackage.NODE__ORIGINAL_NODE_TYPE_REF:
				if (resolve) return getOriginalNodeTypeRef();
				return basicGetOriginalNodeTypeRef();
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
			case OperatorsPackage.NODE__LIFECYCLE:
				setLifecycle((Lifecycle)newValue);
				return;
			case OperatorsPackage.NODE__NODE_TYPE:
				setNodeType((NodeType)newValue);
				return;
			case OperatorsPackage.NODE__CREATED_BY_REF:
				setCreatedByRef((Person)newValue);
				return;
			case OperatorsPackage.NODE__LOCATION_REF:
				setLocationRef((Location)newValue);
				return;
			case OperatorsPackage.NODE__NODE_ID:
				setNodeID((String)newValue);
				return;
			case OperatorsPackage.NODE__ORIGINAL_NODE_TYPE_REF:
				setOriginalNodeTypeRef((NodeType)newValue);
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
			case OperatorsPackage.NODE__LIFECYCLE:
				setLifecycle((Lifecycle)null);
				return;
			case OperatorsPackage.NODE__NODE_TYPE:
				setNodeType((NodeType)null);
				return;
			case OperatorsPackage.NODE__CREATED_BY_REF:
				setCreatedByRef((Person)null);
				return;
			case OperatorsPackage.NODE__LOCATION_REF:
				setLocationRef((Location)null);
				return;
			case OperatorsPackage.NODE__NODE_ID:
				setNodeID(NODE_ID_EDEFAULT);
				return;
			case OperatorsPackage.NODE__ORIGINAL_NODE_TYPE_REF:
				setOriginalNodeTypeRef((NodeType)null);
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
			case OperatorsPackage.NODE__LIFECYCLE:
				return lifecycle != null;
			case OperatorsPackage.NODE__NODE_TYPE:
				return nodeType != null;
			case OperatorsPackage.NODE__CREATED_BY_REF:
				return createdByRef != null;
			case OperatorsPackage.NODE__LOCATION_REF:
				return locationRef != null;
			case OperatorsPackage.NODE__NODE_ID:
				return NODE_ID_EDEFAULT == null ? nodeID != null : !NODE_ID_EDEFAULT.equals(nodeID);
			case OperatorsPackage.NODE__ORIGINAL_NODE_TYPE_REF:
				return originalNodeTypeRef != null;
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
		result.append(" (nodeID: ");
		result.append(nodeID);
		result.append(')');
		return result.toString();
	}

} //NodeImpl
