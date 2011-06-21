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
package com.netxforge.netxstudio.library;

import com.netxforge.netxstudio.generics.Base;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of
 * 				a real telecommunications Node. This is also often referred
 * 				to as a
 * 				Network Element type. A NodeType type is a plannable Node with
 * 				Functions and Equipments. As the NodeType has no attribute,
 * 				it will
 * 				be identified by the name of the root function and the root
 * 				equipment.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.NodeType#getFunctions <em>Functions</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NodeType#getEquipments <em>Equipments</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NodeType#isLeafNode <em>Leaf Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getNodeType()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='\n\t\t\t\tValidNodeID\n\t\t\t'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ValidNodeID='\n\t\t\t\tnot self.nodeID.oclIsUndefined()\n\t\t\t'"
 *        extendedMetaData="name='NodeType' kind='elementOnly'"
 * @generated
 */
public interface NodeType extends Base {
	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Functions reference, contains 0 or more
	 * 								Function types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getNodeType_Functions()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Functions'"
	 * @generated
	 */
	EList<Function> getFunctions();

	/**
	 * Returns the value of the '<em><b>Equipments</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Equipment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Equipments reference, contains 0 or more
	 * 								Equipment types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipments</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getNodeType_Equipments()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Equipments'"
	 * @generated
	 */
	EList<Equipment> getEquipments();

	/**
	 * Returns the value of the '<em><b>Leaf Node</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Leaf Node</em>' attribute.
	 * @see #isSetLeafNode()
	 * @see #unsetLeafNode()
	 * @see #setLeafNode(boolean)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getNodeType_LeafNode()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='LeafNode'"
	 * @generated
	 */
	boolean isLeafNode();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.NodeType#isLeafNode <em>Leaf Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Leaf Node</em>' attribute.
	 * @see #isSetLeafNode()
	 * @see #unsetLeafNode()
	 * @see #isLeafNode()
	 * @generated
	 */
	void setLeafNode(boolean value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.library.NodeType#isLeafNode <em>Leaf Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLeafNode()
	 * @see #isLeafNode()
	 * @see #setLeafNode(boolean)
	 * @generated
	 */
	void unsetLeafNode();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.library.NodeType#isLeafNode <em>Leaf Node</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Leaf Node</em>' attribute is set.
	 * @see #unsetLeafNode()
	 * @see #isLeafNode()
	 * @see #setLeafNode(boolean)
	 * @generated
	 */
	boolean isSetLeafNode();

} // NodeType
