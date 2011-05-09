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
package com.netxforge.netxstudio.protocols;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.Company;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of a protocol. A communications protocol is a formal description of digital message formats 
 * and the rules for exchanging those messages.
 * 
 * 
 * Examples: 
 * 
 * 1. The ISUP protocol is defined and referred to by a Function ISDN User part. 
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.protocols.Protocol#getProcedures <em>Procedures</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.protocols.Protocol#getBodyRef <em>Body Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.protocols.Protocol#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.protocols.Protocol#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.protocols.Protocol#getOSI <em>OSI</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.protocols.Protocol#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.protocols.ProtocolsPackage#getProtocol()
 * @model extendedMetaData="name='Protocol' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface Protocol extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Procedures</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.protocols.Procedure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Procedures reference, contains 0 or more Procedure types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Procedures</em>' containment reference list.
	 * @see com.netxforge.netxstudio.protocols.ProtocolsPackage#getProtocol_Procedures()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Procedures'"
	 * @generated
	 */
	EList<Procedure> getProcedures();

	/**
	 * Returns the value of the '<em><b>Body Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The BodyRef reference, refers to a Company type. In this case we refer to standardisation bodies responsible for maintaining the protocol.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Body Ref</em>' reference.
	 * @see #setBodyRef(Company)
	 * @see com.netxforge.netxstudio.protocols.ProtocolsPackage#getProtocol_BodyRef()
	 * @model extendedMetaData="kind='attribute' name='BodyRef'"
	 * @generated
	 */
	Company getBodyRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.protocols.Protocol#getBodyRef <em>Body Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Ref</em>' reference.
	 * @see #getBodyRef()
	 * @generated
	 */
	void setBodyRef(Company value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Description attribute holds the description of the equipment
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.netxforge.netxstudio.protocols.ProtocolsPackage#getProtocol_Description()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.protocols.Protocol#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute holds a name used for presentation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.protocols.ProtocolsPackage#getProtocol_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.protocols.Protocol#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>OSI</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.protocols.OSIType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The OSI attribute refers to the OSI layer in which the protocol operates.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>OSI</em>' attribute.
	 * @see com.netxforge.netxstudio.protocols.OSIType
	 * @see #isSetOSI()
	 * @see #unsetOSI()
	 * @see #setOSI(OSIType)
	 * @see com.netxforge.netxstudio.protocols.ProtocolsPackage#getProtocol_OSI()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='OSI'"
	 * @generated
	 */
	OSIType getOSI();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.protocols.Protocol#getOSI <em>OSI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>OSI</em>' attribute.
	 * @see com.netxforge.netxstudio.protocols.OSIType
	 * @see #isSetOSI()
	 * @see #unsetOSI()
	 * @see #getOSI()
	 * @generated
	 */
	void setOSI(OSIType value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.protocols.Protocol#getOSI <em>OSI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOSI()
	 * @see #getOSI()
	 * @see #setOSI(OSIType)
	 * @generated
	 */
	void unsetOSI();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.protocols.Protocol#getOSI <em>OSI</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>OSI</em>' attribute is set.
	 * @see #unsetOSI()
	 * @see #getOSI()
	 * @see #setOSI(OSIType)
	 * @generated
	 */
	boolean isSetOSI();

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Specification attribute holds a reference to a specification code. 
	 * 
	 * Example:
	 * The specification could be: RFC 1234 or Q.711				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Specification</em>' attribute.
	 * @see #setSpecification(String)
	 * @see com.netxforge.netxstudio.protocols.ProtocolsPackage#getProtocol_Specification()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Specification'"
	 * @generated
	 */
	String getSpecification();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.protocols.Protocol#getSpecification <em>Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' attribute.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(String value);

} // Protocol
