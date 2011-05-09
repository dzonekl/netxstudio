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
package com.netxforge.netxstudio.operators;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Expansion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing an expansion of the network. It references either node(s) or equipment(s).
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.ResourceExpansion#getNodeRefs <em>Node Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.ResourceExpansion#getEquipmentRefs <em>Equipment Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.ResourceExpansion#getFunctionRefs <em>Function Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getResourceExpansion()
 * @model extendedMetaData="name='ResourceExpansion' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface ResourceExpansion extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Node Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Node reference, references 1 or more Node types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Node Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getResourceExpansion_NodeRefs()
	 * @model extendedMetaData="kind='element' name='NodeRefs'"
	 * @generated
	 */
	EList<Node> getNodeRefs();

	/**
	 * Returns the value of the '<em><b>Equipment Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Equipment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Equipment reference, references 1 or more Equipment types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipment Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getResourceExpansion_EquipmentRefs()
	 * @model extendedMetaData="kind='element' name='EquipmentRefs'"
	 * @generated
	 */
	EList<Equipment> getEquipmentRefs();

	/**
	 * Returns the value of the '<em><b>Function Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Function reference, references 1 or more Function types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Function Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getResourceExpansion_FunctionRefs()
	 * @model extendedMetaData="kind='element' name='FunctionRefs'"
	 * @generated
	 */
	EList<Function> getFunctionRefs();

} // ResourceExpansion
