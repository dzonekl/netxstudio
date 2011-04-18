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
package com.netxforge.netxstudio.protocols.impl;

import com.netxforge.netxstudio.generics.Company;

import com.netxforge.netxstudio.protocols.OSIType;
import com.netxforge.netxstudio.protocols.Procedure;
import com.netxforge.netxstudio.protocols.Protocol;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Protocol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.protocols.impl.ProtocolImpl#getProcedures <em>Procedures</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.protocols.impl.ProtocolImpl#getBodyRef <em>Body Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.protocols.impl.ProtocolImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.protocols.impl.ProtocolImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.protocols.impl.ProtocolImpl#getOSI <em>OSI</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.protocols.impl.ProtocolImpl#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProtocolImpl extends EObjectImpl implements Protocol {
	/**
	 * The cached value of the '{@link #getProcedures() <em>Procedures</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcedures()
	 * @generated
	 * @ordered
	 */
	protected EList<Procedure> procedures;

	/**
	 * The cached value of the '{@link #getBodyRef() <em>Body Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyRef()
	 * @generated
	 * @ordered
	 */
	protected Company bodyRef;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

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
	 * The default value of the '{@link #getOSI() <em>OSI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOSI()
	 * @generated
	 * @ordered
	 */
	protected static final OSIType OSI_EDEFAULT = OSIType.APPLICATION;

	/**
	 * The cached value of the '{@link #getOSI() <em>OSI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOSI()
	 * @generated
	 * @ordered
	 */
	protected OSIType oSI = OSI_EDEFAULT;

	/**
	 * This is true if the OSI attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean oSIESet;

	/**
	 * The default value of the '{@link #getSpecification() <em>Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIFICATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpecification() <em>Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected String specification = SPECIFICATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProtocolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProtocolsPackage.Literals.PROTOCOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Procedure> getProcedures() {
		if (procedures == null) {
			procedures = new EObjectContainmentEList<Procedure>(Procedure.class, this, ProtocolsPackage.PROTOCOL__PROCEDURES);
		}
		return procedures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Company getBodyRef() {
		if (bodyRef != null && bodyRef.eIsProxy()) {
			InternalEObject oldBodyRef = (InternalEObject)bodyRef;
			bodyRef = (Company)eResolveProxy(oldBodyRef);
			if (bodyRef != oldBodyRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProtocolsPackage.PROTOCOL__BODY_REF, oldBodyRef, bodyRef));
			}
		}
		return bodyRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Company basicGetBodyRef() {
		return bodyRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyRef(Company newBodyRef) {
		Company oldBodyRef = bodyRef;
		bodyRef = newBodyRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolsPackage.PROTOCOL__BODY_REF, oldBodyRef, bodyRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolsPackage.PROTOCOL__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolsPackage.PROTOCOL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OSIType getOSI() {
		return oSI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOSI(OSIType newOSI) {
		OSIType oldOSI = oSI;
		oSI = newOSI == null ? OSI_EDEFAULT : newOSI;
		boolean oldOSIESet = oSIESet;
		oSIESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolsPackage.PROTOCOL__OSI, oldOSI, oSI, !oldOSIESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOSI() {
		OSIType oldOSI = oSI;
		boolean oldOSIESet = oSIESet;
		oSI = OSI_EDEFAULT;
		oSIESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ProtocolsPackage.PROTOCOL__OSI, oldOSI, OSI_EDEFAULT, oldOSIESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOSI() {
		return oSIESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpecification() {
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification(String newSpecification) {
		String oldSpecification = specification;
		specification = newSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolsPackage.PROTOCOL__SPECIFICATION, oldSpecification, specification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProtocolsPackage.PROTOCOL__PROCEDURES:
				return ((InternalEList<?>)getProcedures()).basicRemove(otherEnd, msgs);
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
			case ProtocolsPackage.PROTOCOL__PROCEDURES:
				return getProcedures();
			case ProtocolsPackage.PROTOCOL__BODY_REF:
				if (resolve) return getBodyRef();
				return basicGetBodyRef();
			case ProtocolsPackage.PROTOCOL__DESCRIPTION:
				return getDescription();
			case ProtocolsPackage.PROTOCOL__NAME:
				return getName();
			case ProtocolsPackage.PROTOCOL__OSI:
				return getOSI();
			case ProtocolsPackage.PROTOCOL__SPECIFICATION:
				return getSpecification();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProtocolsPackage.PROTOCOL__PROCEDURES:
				getProcedures().clear();
				getProcedures().addAll((Collection<? extends Procedure>)newValue);
				return;
			case ProtocolsPackage.PROTOCOL__BODY_REF:
				setBodyRef((Company)newValue);
				return;
			case ProtocolsPackage.PROTOCOL__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ProtocolsPackage.PROTOCOL__NAME:
				setName((String)newValue);
				return;
			case ProtocolsPackage.PROTOCOL__OSI:
				setOSI((OSIType)newValue);
				return;
			case ProtocolsPackage.PROTOCOL__SPECIFICATION:
				setSpecification((String)newValue);
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
			case ProtocolsPackage.PROTOCOL__PROCEDURES:
				getProcedures().clear();
				return;
			case ProtocolsPackage.PROTOCOL__BODY_REF:
				setBodyRef((Company)null);
				return;
			case ProtocolsPackage.PROTOCOL__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ProtocolsPackage.PROTOCOL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProtocolsPackage.PROTOCOL__OSI:
				unsetOSI();
				return;
			case ProtocolsPackage.PROTOCOL__SPECIFICATION:
				setSpecification(SPECIFICATION_EDEFAULT);
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
			case ProtocolsPackage.PROTOCOL__PROCEDURES:
				return procedures != null && !procedures.isEmpty();
			case ProtocolsPackage.PROTOCOL__BODY_REF:
				return bodyRef != null;
			case ProtocolsPackage.PROTOCOL__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ProtocolsPackage.PROTOCOL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProtocolsPackage.PROTOCOL__OSI:
				return isSetOSI();
			case ProtocolsPackage.PROTOCOL__SPECIFICATION:
				return SPECIFICATION_EDEFAULT == null ? specification != null : !SPECIFICATION_EDEFAULT.equals(specification);
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
		result.append(" (description: ");
		result.append(description);
		result.append(", name: ");
		result.append(name);
		result.append(", oSI: ");
		if (oSIESet) result.append(oSI); else result.append("<unset>");
		result.append(", specification: ");
		result.append(specification);
		result.append(')');
		return result.toString();
	}

} //ProtocolImpl
