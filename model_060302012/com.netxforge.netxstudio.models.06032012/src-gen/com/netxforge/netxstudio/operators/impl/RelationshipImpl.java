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

import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.generics.impl.BaseImpl;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.Relationship;
import com.netxforge.netxstudio.protocols.Protocol;

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
public class RelationshipImpl extends BaseImpl implements Relationship {
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
		return (String)eGet(OperatorsPackage.Literals.RELATIONSHIP__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(OperatorsPackage.Literals.RELATIONSHIP__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getNodeID1Ref() {
		return (Node)eGet(OperatorsPackage.Literals.RELATIONSHIP__NODE_ID1_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeID1Ref(Node newNodeID1Ref) {
		eSet(OperatorsPackage.Literals.RELATIONSHIP__NODE_ID1_REF, newNodeID1Ref);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getNodeID2Ref() {
		return (Node)eGet(OperatorsPackage.Literals.RELATIONSHIP__NODE_ID2_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeID2Ref(Node newNodeID2Ref) {
		eSet(OperatorsPackage.Literals.RELATIONSHIP__NODE_ID2_REF, newNodeID2Ref);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protocol getProtocolRef() {
		return (Protocol)eGet(OperatorsPackage.Literals.RELATIONSHIP__PROTOCOL_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocolRef(Protocol newProtocolRef) {
		eSet(OperatorsPackage.Literals.RELATIONSHIP__PROTOCOL_REF, newProtocolRef);
	}

} //RelationshipImpl
