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
package com.netxforge.netxstudio.library.impl;

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.ReferenceRelationship;

import com.netxforge.netxstudio.protocols.Protocol;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ReferenceRelationshipImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ReferenceRelationshipImpl#getProtocolRef <em>Protocol Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ReferenceRelationshipImpl#getRefInterface1Ref <em>Ref Interface1 Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ReferenceRelationshipImpl#getRefInterface2Ref <em>Ref Interface2 Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceRelationshipImpl extends BaseImpl implements ReferenceRelationship {
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
	 * The cached value of the '{@link #getProtocolRef() <em>Protocol Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocolRef()
	 * @generated
	 * @ordered
	 */
	protected Protocol protocolRef;

	/**
	 * The cached value of the '{@link #getRefInterface1Ref() <em>Ref Interface1 Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefInterface1Ref()
	 * @generated
	 * @ordered
	 */
	protected NodeType refInterface1Ref;

	/**
	 * The cached value of the '{@link #getRefInterface2Ref() <em>Ref Interface2 Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefInterface2Ref()
	 * @generated
	 * @ordered
	 */
	protected NodeType refInterface2Ref;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.REFERENCE_RELATIONSHIP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.REFERENCE_RELATIONSHIP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protocol getProtocolRef() {
		if (protocolRef != null && protocolRef.eIsProxy()) {
			InternalEObject oldProtocolRef = (InternalEObject)protocolRef;
			protocolRef = (Protocol)eResolveProxy(oldProtocolRef);
			if (protocolRef != oldProtocolRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryPackage.REFERENCE_RELATIONSHIP__PROTOCOL_REF, oldProtocolRef, protocolRef));
			}
		}
		return protocolRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protocol basicGetProtocolRef() {
		return protocolRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocolRef(Protocol newProtocolRef) {
		Protocol oldProtocolRef = protocolRef;
		protocolRef = newProtocolRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.REFERENCE_RELATIONSHIP__PROTOCOL_REF, oldProtocolRef, protocolRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType getRefInterface1Ref() {
		if (refInterface1Ref != null && refInterface1Ref.eIsProxy()) {
			InternalEObject oldRefInterface1Ref = (InternalEObject)refInterface1Ref;
			refInterface1Ref = (NodeType)eResolveProxy(oldRefInterface1Ref);
			if (refInterface1Ref != oldRefInterface1Ref) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryPackage.REFERENCE_RELATIONSHIP__REF_INTERFACE1_REF, oldRefInterface1Ref, refInterface1Ref));
			}
		}
		return refInterface1Ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType basicGetRefInterface1Ref() {
		return refInterface1Ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefInterface1Ref(NodeType newRefInterface1Ref) {
		NodeType oldRefInterface1Ref = refInterface1Ref;
		refInterface1Ref = newRefInterface1Ref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.REFERENCE_RELATIONSHIP__REF_INTERFACE1_REF, oldRefInterface1Ref, refInterface1Ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType getRefInterface2Ref() {
		if (refInterface2Ref != null && refInterface2Ref.eIsProxy()) {
			InternalEObject oldRefInterface2Ref = (InternalEObject)refInterface2Ref;
			refInterface2Ref = (NodeType)eResolveProxy(oldRefInterface2Ref);
			if (refInterface2Ref != oldRefInterface2Ref) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryPackage.REFERENCE_RELATIONSHIP__REF_INTERFACE2_REF, oldRefInterface2Ref, refInterface2Ref));
			}
		}
		return refInterface2Ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType basicGetRefInterface2Ref() {
		return refInterface2Ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefInterface2Ref(NodeType newRefInterface2Ref) {
		NodeType oldRefInterface2Ref = refInterface2Ref;
		refInterface2Ref = newRefInterface2Ref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.REFERENCE_RELATIONSHIP__REF_INTERFACE2_REF, oldRefInterface2Ref, refInterface2Ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LibraryPackage.REFERENCE_RELATIONSHIP__NAME:
				return getName();
			case LibraryPackage.REFERENCE_RELATIONSHIP__PROTOCOL_REF:
				if (resolve) return getProtocolRef();
				return basicGetProtocolRef();
			case LibraryPackage.REFERENCE_RELATIONSHIP__REF_INTERFACE1_REF:
				if (resolve) return getRefInterface1Ref();
				return basicGetRefInterface1Ref();
			case LibraryPackage.REFERENCE_RELATIONSHIP__REF_INTERFACE2_REF:
				if (resolve) return getRefInterface2Ref();
				return basicGetRefInterface2Ref();
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
			case LibraryPackage.REFERENCE_RELATIONSHIP__NAME:
				setName((String)newValue);
				return;
			case LibraryPackage.REFERENCE_RELATIONSHIP__PROTOCOL_REF:
				setProtocolRef((Protocol)newValue);
				return;
			case LibraryPackage.REFERENCE_RELATIONSHIP__REF_INTERFACE1_REF:
				setRefInterface1Ref((NodeType)newValue);
				return;
			case LibraryPackage.REFERENCE_RELATIONSHIP__REF_INTERFACE2_REF:
				setRefInterface2Ref((NodeType)newValue);
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
			case LibraryPackage.REFERENCE_RELATIONSHIP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LibraryPackage.REFERENCE_RELATIONSHIP__PROTOCOL_REF:
				setProtocolRef((Protocol)null);
				return;
			case LibraryPackage.REFERENCE_RELATIONSHIP__REF_INTERFACE1_REF:
				setRefInterface1Ref((NodeType)null);
				return;
			case LibraryPackage.REFERENCE_RELATIONSHIP__REF_INTERFACE2_REF:
				setRefInterface2Ref((NodeType)null);
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
			case LibraryPackage.REFERENCE_RELATIONSHIP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case LibraryPackage.REFERENCE_RELATIONSHIP__PROTOCOL_REF:
				return protocolRef != null;
			case LibraryPackage.REFERENCE_RELATIONSHIP__REF_INTERFACE1_REF:
				return refInterface1Ref != null;
			case LibraryPackage.REFERENCE_RELATIONSHIP__REF_INTERFACE2_REF:
				return refInterface2Ref != null;
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

} //ReferenceRelationshipImpl
