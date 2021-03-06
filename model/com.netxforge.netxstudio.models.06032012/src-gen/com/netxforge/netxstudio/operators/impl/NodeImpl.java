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

import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.generics.impl.BaseImpl;
import com.netxforge.netxstudio.geo.Location;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;

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
		return (Lifecycle)eGet(OperatorsPackage.Literals.NODE__LIFECYCLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLifecycle(Lifecycle newLifecycle) {
		eSet(OperatorsPackage.Literals.NODE__LIFECYCLE, newLifecycle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType getNodeType() {
		return (NodeType)eGet(OperatorsPackage.Literals.NODE__NODE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeType(NodeType newNodeType) {
		eSet(OperatorsPackage.Literals.NODE__NODE_TYPE, newNodeType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person getCreatedByRef() {
		return (Person)eGet(OperatorsPackage.Literals.NODE__CREATED_BY_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatedByRef(Person newCreatedByRef) {
		eSet(OperatorsPackage.Literals.NODE__CREATED_BY_REF, newCreatedByRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location getLocationRef() {
		return (Location)eGet(OperatorsPackage.Literals.NODE__LOCATION_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocationRef(Location newLocationRef) {
		eSet(OperatorsPackage.Literals.NODE__LOCATION_REF, newLocationRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNodeID() {
		return (String)eGet(OperatorsPackage.Literals.NODE__NODE_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeID(String newNodeID) {
		eSet(OperatorsPackage.Literals.NODE__NODE_ID, newNodeID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType getOriginalNodeTypeRef() {
		return (NodeType)eGet(OperatorsPackage.Literals.NODE__ORIGINAL_NODE_TYPE_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalNodeTypeRef(NodeType newOriginalNodeTypeRef) {
		eSet(OperatorsPackage.Literals.NODE__ORIGINAL_NODE_TYPE_REF, newOriginalNodeTypeRef);
	}

} //NodeImpl
