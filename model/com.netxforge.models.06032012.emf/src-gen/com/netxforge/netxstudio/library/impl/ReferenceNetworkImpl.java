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

import com.netxforge.netxstudio.generics.DiagramInfo;

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.ReferenceNetwork;
import com.netxforge.netxstudio.library.ReferenceRelationship;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

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
	 * The cached value of the '{@link #getDiagrams() <em>Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<DiagramInfo> diagrams;

	/**
	 * The cached value of the '{@link #getNodeTypes() <em>Node Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeType> nodeTypes;

	/**
	 * The cached value of the '{@link #getReferenceNetworks() <em>Reference Networks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceNetworks()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferenceNetwork> referenceNetworks;

	/**
	 * The cached value of the '{@link #getRefRelationships() <em>Ref Relationships</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefRelationships()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferenceRelationship> refRelationships;

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
	protected static final String NAME_EDEFAULT = "name";

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
	 * This is true if the Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean nameESet;

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
	public EList<DiagramInfo> getDiagrams() {
		if (diagrams == null) {
			diagrams = new EObjectContainmentEList<DiagramInfo>(DiagramInfo.class, this, LibraryPackage.REFERENCE_NETWORK__DIAGRAMS);
		}
		return diagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NodeType> getNodeTypes() {
		if (nodeTypes == null) {
			nodeTypes = new EObjectContainmentEList<NodeType>(NodeType.class, this, LibraryPackage.REFERENCE_NETWORK__NODE_TYPES);
		}
		return nodeTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReferenceNetwork> getReferenceNetworks() {
		if (referenceNetworks == null) {
			referenceNetworks = new EObjectContainmentEList<ReferenceNetwork>(ReferenceNetwork.class, this, LibraryPackage.REFERENCE_NETWORK__REFERENCE_NETWORKS);
		}
		return referenceNetworks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReferenceRelationship> getRefRelationships() {
		if (refRelationships == null) {
			refRelationships = new EObjectContainmentEList<ReferenceRelationship>(ReferenceRelationship.class, this, LibraryPackage.REFERENCE_NETWORK__REF_RELATIONSHIPS);
		}
		return refRelationships;
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
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.REFERENCE_NETWORK__DESCRIPTION, oldDescription, description));
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
		boolean oldNameESet = nameESet;
		nameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.REFERENCE_NETWORK__NAME, oldName, name, !oldNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetName() {
		String oldName = name;
		boolean oldNameESet = nameESet;
		name = NAME_EDEFAULT;
		nameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LibraryPackage.REFERENCE_NETWORK__NAME, oldName, NAME_EDEFAULT, oldNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName() {
		return nameESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryPackage.REFERENCE_NETWORK__DIAGRAMS:
				return ((InternalEList<?>)getDiagrams()).basicRemove(otherEnd, msgs);
			case LibraryPackage.REFERENCE_NETWORK__NODE_TYPES:
				return ((InternalEList<?>)getNodeTypes()).basicRemove(otherEnd, msgs);
			case LibraryPackage.REFERENCE_NETWORK__REFERENCE_NETWORKS:
				return ((InternalEList<?>)getReferenceNetworks()).basicRemove(otherEnd, msgs);
			case LibraryPackage.REFERENCE_NETWORK__REF_RELATIONSHIPS:
				return ((InternalEList<?>)getRefRelationships()).basicRemove(otherEnd, msgs);
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
			case LibraryPackage.REFERENCE_NETWORK__DIAGRAMS:
				return getDiagrams();
			case LibraryPackage.REFERENCE_NETWORK__NODE_TYPES:
				return getNodeTypes();
			case LibraryPackage.REFERENCE_NETWORK__REFERENCE_NETWORKS:
				return getReferenceNetworks();
			case LibraryPackage.REFERENCE_NETWORK__REF_RELATIONSHIPS:
				return getRefRelationships();
			case LibraryPackage.REFERENCE_NETWORK__DESCRIPTION:
				return getDescription();
			case LibraryPackage.REFERENCE_NETWORK__NAME:
				return getName();
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
			case LibraryPackage.REFERENCE_NETWORK__DIAGRAMS:
				getDiagrams().clear();
				getDiagrams().addAll((Collection<? extends DiagramInfo>)newValue);
				return;
			case LibraryPackage.REFERENCE_NETWORK__NODE_TYPES:
				getNodeTypes().clear();
				getNodeTypes().addAll((Collection<? extends NodeType>)newValue);
				return;
			case LibraryPackage.REFERENCE_NETWORK__REFERENCE_NETWORKS:
				getReferenceNetworks().clear();
				getReferenceNetworks().addAll((Collection<? extends ReferenceNetwork>)newValue);
				return;
			case LibraryPackage.REFERENCE_NETWORK__REF_RELATIONSHIPS:
				getRefRelationships().clear();
				getRefRelationships().addAll((Collection<? extends ReferenceRelationship>)newValue);
				return;
			case LibraryPackage.REFERENCE_NETWORK__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case LibraryPackage.REFERENCE_NETWORK__NAME:
				setName((String)newValue);
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
			case LibraryPackage.REFERENCE_NETWORK__DIAGRAMS:
				getDiagrams().clear();
				return;
			case LibraryPackage.REFERENCE_NETWORK__NODE_TYPES:
				getNodeTypes().clear();
				return;
			case LibraryPackage.REFERENCE_NETWORK__REFERENCE_NETWORKS:
				getReferenceNetworks().clear();
				return;
			case LibraryPackage.REFERENCE_NETWORK__REF_RELATIONSHIPS:
				getRefRelationships().clear();
				return;
			case LibraryPackage.REFERENCE_NETWORK__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case LibraryPackage.REFERENCE_NETWORK__NAME:
				unsetName();
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
			case LibraryPackage.REFERENCE_NETWORK__DIAGRAMS:
				return diagrams != null && !diagrams.isEmpty();
			case LibraryPackage.REFERENCE_NETWORK__NODE_TYPES:
				return nodeTypes != null && !nodeTypes.isEmpty();
			case LibraryPackage.REFERENCE_NETWORK__REFERENCE_NETWORKS:
				return referenceNetworks != null && !referenceNetworks.isEmpty();
			case LibraryPackage.REFERENCE_NETWORK__REF_RELATIONSHIPS:
				return refRelationships != null && !refRelationships.isEmpty();
			case LibraryPackage.REFERENCE_NETWORK__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case LibraryPackage.REFERENCE_NETWORK__NAME:
				return isSetName();
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
		if (nameESet) result.append(name); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ReferenceNetworkImpl
