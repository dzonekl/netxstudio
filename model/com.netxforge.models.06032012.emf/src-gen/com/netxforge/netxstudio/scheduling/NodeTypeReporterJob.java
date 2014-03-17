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
package com.netxforge.netxstudio.scheduling;

import com.netxforge.netxstudio.library.NodeType;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Type Reporter Job</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A job producing external format reports for a
 * 				service.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.NodeTypeReporterJob#getNodeType <em>Node Type</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.NodeTypeReporterJob#getScopeObject <em>Scope Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getNodeTypeReporterJob()
 * @model extendedMetaData="name='NodeTypeReporterJob' kind='elementOnly'"
 * @generated
 */
public interface NodeTypeReporterJob extends Job {
	/**
	 * Returns the value of the '<em><b>Node Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to the NodeType for which the job
	 * 								runs.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Node Type</em>' reference.
	 * @see #setNodeType(NodeType)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getNodeTypeReporterJob_NodeType()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='NodeType'"
	 * @generated
	 */
	NodeType getNodeType();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.NodeTypeReporterJob#getNodeType <em>Node Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Type</em>' reference.
	 * @see #getNodeType()
	 * @generated
	 */
	void setNodeType(NodeType value);

	/**
	 * Returns the value of the '<em><b>Scope Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to an arbitrary Scope object. 
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Scope Object</em>' reference.
	 * @see #setScopeObject(EObject)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getNodeTypeReporterJob_ScopeObject()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='ScopeObject'"
	 * @generated
	 */
	EObject getScopeObject();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.NodeTypeReporterJob#getScopeObject <em>Scope Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope Object</em>' reference.
	 * @see #getScopeObject()
	 * @generated
	 */
	void setScopeObject(EObject value);

} // NodeTypeReporterJob
