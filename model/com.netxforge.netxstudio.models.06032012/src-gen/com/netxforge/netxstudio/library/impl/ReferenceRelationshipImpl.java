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
package com.netxforge.netxstudio.library.impl;

import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.generics.impl.BaseImpl;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.ReferenceRelationship;
import com.netxforge.netxstudio.protocols.Protocol;

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
		return (String)eGet(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protocol getProtocolRef() {
		return (Protocol)eGet(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__PROTOCOL_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocolRef(Protocol newProtocolRef) {
		eSet(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__PROTOCOL_REF, newProtocolRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType getRefInterface1Ref() {
		return (NodeType)eGet(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__REF_INTERFACE1_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefInterface1Ref(NodeType newRefInterface1Ref) {
		eSet(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__REF_INTERFACE1_REF, newRefInterface1Ref);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType getRefInterface2Ref() {
		return (NodeType)eGet(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__REF_INTERFACE2_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefInterface2Ref(NodeType newRefInterface2Ref) {
		eSet(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__REF_INTERFACE2_REF, newRefInterface2Ref);
	}

} //ReferenceRelationshipImpl
