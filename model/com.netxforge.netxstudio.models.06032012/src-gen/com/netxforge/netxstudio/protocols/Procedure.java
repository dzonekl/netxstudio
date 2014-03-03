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

import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.Base;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Procedure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of
 * 				a protocol procedure. A procedure is a sequence of messages in a
 * 				protocol. The order in which the messages are expected, is the order
 * 				in which
 * 				the messages are stored in the messages reference.
 * 
 * 				THIS TYPE
 * 				SHOULD NOT BE CONSIDERED FOR NOW.
 * 
 * 				Examples:
 * 				1. The routing procedure
 * 				for a terminating cal consists of the
 * 				following messages.
 * 				- Send
 * 				Routing Information
 * 				- Provide Roaming Number.
 * 				- etc..
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.protocols.Procedure#getMessages <em>Messages</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.protocols.Procedure#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.protocols.ProtocolsPackage#getProcedure()
 * @model extendedMetaData="name='Procedure' kind='elementOnly'"
 * @generated
 */
public interface Procedure extends Base {
	/**
	 * Returns the value of the '<em><b>Messages</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.protocols.Message}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Messages reference, refers to 0 or more
	 * 								Message types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Messages</em>' containment reference list.
	 * @see com.netxforge.netxstudio.protocols.ProtocolsPackage#getProcedure_Messages()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Messages'"
	 * @generated
	 */
	EList<Message> getMessages();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute holds a name used for
	 * 							presentation.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.protocols.ProtocolsPackage#getProcedure_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.protocols.Procedure#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Procedure
