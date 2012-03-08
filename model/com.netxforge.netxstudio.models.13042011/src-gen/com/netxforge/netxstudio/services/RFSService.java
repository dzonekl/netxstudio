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
package com.netxforge.netxstudio.services;

import com.netxforge.netxstudio.library.Tolerance;

import com.netxforge.netxstudio.operators.Node;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>RFS Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a Resource Facing Service.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.RFSService#getNodes <em>Nodes</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.RFSService#getToleranceRefs <em>Tolerance Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.RFSService#getFunctionalCategory <em>Functional Category</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.services.ServicesPackage#getRFSService()
 * @model extendedMetaData="name='RFSService' kind='elementOnly'"
 * @generated
 */
public interface RFSService extends Service {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Nodes reference, references 0 or more Node
	 * 								types
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nodes</em>' reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getRFSService_Nodes()
	 * @model extendedMetaData="kind='element' name='Nodes'"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Tolerance Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Tolerance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ToleranceRefs reference, refers to 0 or
	 * 								more Tolerance types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tolerance Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getRFSService_ToleranceRefs()
	 * @model extendedMetaData="kind='element' name='ToleranceRefs'"
	 * @generated
	 */
	EList<Tolerance> getToleranceRefs();

	/**
	 * Returns the value of the '<em><b>Functional Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The functionalCategory attribute holds the
	 * 							category of the service.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Functional Category</em>' attribute.
	 * @see #setFunctionalCategory(String)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getRFSService_FunctionalCategory()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='functionalCategory'"
	 * @generated
	 */
	String getFunctionalCategory();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.RFSService#getFunctionalCategory <em>Functional Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Functional Category</em>' attribute.
	 * @see #getFunctionalCategory()
	 * @generated
	 */
	void setFunctionalCategory(String value);

} // RFSService
