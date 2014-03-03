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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.generics.Company;
import com.netxforge.netxstudio.generics.impl.BaseImpl;
import com.netxforge.netxstudio.protocols.OSIType;
import com.netxforge.netxstudio.protocols.Procedure;
import com.netxforge.netxstudio.protocols.Protocol;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;

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
public class ProtocolImpl extends BaseImpl implements Protocol {
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
	@SuppressWarnings("unchecked")
	public EList<Procedure> getProcedures() {
		return (EList<Procedure>)eGet(ProtocolsPackage.Literals.PROTOCOL__PROCEDURES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Company getBodyRef() {
		return (Company)eGet(ProtocolsPackage.Literals.PROTOCOL__BODY_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyRef(Company newBodyRef) {
		eSet(ProtocolsPackage.Literals.PROTOCOL__BODY_REF, newBodyRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(ProtocolsPackage.Literals.PROTOCOL__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(ProtocolsPackage.Literals.PROTOCOL__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(ProtocolsPackage.Literals.PROTOCOL__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(ProtocolsPackage.Literals.PROTOCOL__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OSIType getOSI() {
		return (OSIType)eGet(ProtocolsPackage.Literals.PROTOCOL__OSI, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOSI(OSIType newOSI) {
		eSet(ProtocolsPackage.Literals.PROTOCOL__OSI, newOSI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOSI() {
		eUnset(ProtocolsPackage.Literals.PROTOCOL__OSI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOSI() {
		return eIsSet(ProtocolsPackage.Literals.PROTOCOL__OSI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpecification() {
		return (String)eGet(ProtocolsPackage.Literals.PROTOCOL__SPECIFICATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification(String newSpecification) {
		eSet(ProtocolsPackage.Literals.PROTOCOL__SPECIFICATION, newSpecification);
	}

} //ProtocolImpl
