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
package com.netxforge.netxstudio.operators.impl;

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;

import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.ResourceExpansion;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Expansion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.ResourceExpansionImpl#getNodeRefs <em>Node Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.ResourceExpansionImpl#getEquipmentRefs <em>Equipment Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.ResourceExpansionImpl#getFunctionRefs <em>Function Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceExpansionImpl extends BaseImpl implements ResourceExpansion {
	/**
	 * The cached value of the '{@link #getNodeRefs() <em>Node Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> nodeRefs;

	/**
	 * The cached value of the '{@link #getEquipmentRefs() <em>Equipment Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Equipment> equipmentRefs;

	/**
	 * The cached value of the '{@link #getFunctionRefs() <em>Function Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> functionRefs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceExpansionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorsPackage.Literals.RESOURCE_EXPANSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Node> getNodeRefs() {
		if (nodeRefs == null) {
			nodeRefs = new EObjectResolvingEList<Node>(Node.class, this, OperatorsPackage.RESOURCE_EXPANSION__NODE_REFS);
		}
		return nodeRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Equipment> getEquipmentRefs() {
		if (equipmentRefs == null) {
			equipmentRefs = new EObjectResolvingEList<Equipment>(Equipment.class, this, OperatorsPackage.RESOURCE_EXPANSION__EQUIPMENT_REFS);
		}
		return equipmentRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Function> getFunctionRefs() {
		if (functionRefs == null) {
			functionRefs = new EObjectResolvingEList<Function>(Function.class, this, OperatorsPackage.RESOURCE_EXPANSION__FUNCTION_REFS);
		}
		return functionRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperatorsPackage.RESOURCE_EXPANSION__NODE_REFS:
				return getNodeRefs();
			case OperatorsPackage.RESOURCE_EXPANSION__EQUIPMENT_REFS:
				return getEquipmentRefs();
			case OperatorsPackage.RESOURCE_EXPANSION__FUNCTION_REFS:
				return getFunctionRefs();
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
			case OperatorsPackage.RESOURCE_EXPANSION__NODE_REFS:
				getNodeRefs().clear();
				getNodeRefs().addAll((Collection<? extends Node>)newValue);
				return;
			case OperatorsPackage.RESOURCE_EXPANSION__EQUIPMENT_REFS:
				getEquipmentRefs().clear();
				getEquipmentRefs().addAll((Collection<? extends Equipment>)newValue);
				return;
			case OperatorsPackage.RESOURCE_EXPANSION__FUNCTION_REFS:
				getFunctionRefs().clear();
				getFunctionRefs().addAll((Collection<? extends Function>)newValue);
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
			case OperatorsPackage.RESOURCE_EXPANSION__NODE_REFS:
				getNodeRefs().clear();
				return;
			case OperatorsPackage.RESOURCE_EXPANSION__EQUIPMENT_REFS:
				getEquipmentRefs().clear();
				return;
			case OperatorsPackage.RESOURCE_EXPANSION__FUNCTION_REFS:
				getFunctionRefs().clear();
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
			case OperatorsPackage.RESOURCE_EXPANSION__NODE_REFS:
				return nodeRefs != null && !nodeRefs.isEmpty();
			case OperatorsPackage.RESOURCE_EXPANSION__EQUIPMENT_REFS:
				return equipmentRefs != null && !equipmentRefs.isEmpty();
			case OperatorsPackage.RESOURCE_EXPANSION__FUNCTION_REFS:
				return functionRefs != null && !functionRefs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ResourceExpansionImpl
