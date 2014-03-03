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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.generics.DiagramInfo;
import com.netxforge.netxstudio.generics.impl.BaseImpl;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.ReferenceNetwork;
import com.netxforge.netxstudio.library.ReferenceRelationship;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Network</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ReferenceNetworkImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ReferenceNetworkImpl#getNodeTypes <em>Node Types</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ReferenceNetworkImpl#getReferenceNetworks <em>Reference Networks</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ReferenceNetworkImpl#getRefRelationships <em>Ref Relationships</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ReferenceNetworkImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ReferenceNetworkImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceNetworkImpl extends BaseImpl implements ReferenceNetwork {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceNetworkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.REFERENCE_NETWORK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<DiagramInfo> getDiagrams() {
		return (EList<DiagramInfo>)eGet(LibraryPackage.Literals.REFERENCE_NETWORK__DIAGRAMS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NodeType> getNodeTypes() {
		return (EList<NodeType>)eGet(LibraryPackage.Literals.REFERENCE_NETWORK__NODE_TYPES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ReferenceNetwork> getReferenceNetworks() {
		return (EList<ReferenceNetwork>)eGet(LibraryPackage.Literals.REFERENCE_NETWORK__REFERENCE_NETWORKS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ReferenceRelationship> getRefRelationships() {
		return (EList<ReferenceRelationship>)eGet(LibraryPackage.Literals.REFERENCE_NETWORK__REF_RELATIONSHIPS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(LibraryPackage.Literals.REFERENCE_NETWORK__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(LibraryPackage.Literals.REFERENCE_NETWORK__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(LibraryPackage.Literals.REFERENCE_NETWORK__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(LibraryPackage.Literals.REFERENCE_NETWORK__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetName() {
		eUnset(LibraryPackage.Literals.REFERENCE_NETWORK__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName() {
		return eIsSet(LibraryPackage.Literals.REFERENCE_NETWORK__NAME);
	}

} //ReferenceNetworkImpl
