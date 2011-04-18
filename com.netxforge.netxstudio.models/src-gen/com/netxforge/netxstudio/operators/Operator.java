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

import com.netxforge.netxstudio.generics.Company;

import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceUser;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the information points of a telecommunications Operator. It contains various aspects like the network(s)
 * , the Wharehouse(s), the services etc...			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.Operator#getNetworks <em>Networks</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Operator#getWarehouses <em>Warehouses</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Operator#getServices <em>Services</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Operator#getServiceUsers <em>Service Users</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Operator#getResourceExpansions <em>Resource Expansions</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.Operator#getExpansionExperiences <em>Expansion Experiences</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getOperator()
 * @model extendedMetaData="name='Operator' kind='elementOnly'"
 * @generated
 */
public interface Operator extends Company {
	/**
	 * Returns the value of the '<em><b>Networks</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.Network}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Networks reference, contains 0 or more Network type
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Networks</em>' containment reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getOperator_Networks()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Networks'"
	 * @generated
	 */
	EList<Network> getNetworks();

	/**
	 * Returns the value of the '<em><b>Warehouses</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.Warehouse}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Wharehouses reference, contains 0 or more Wharehouse type
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Warehouses</em>' containment reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getOperator_Warehouses()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Warehouses'"
	 * @generated
	 */
	EList<Warehouse> getWarehouses();

	/**
	 * Returns the value of the '<em><b>Services</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.services.Service}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Services reference, contains 0 or more Service type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Services</em>' containment reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getOperator_Services()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Services'"
	 * @generated
	 */
	EList<Service> getServices();

	/**
	 * Returns the value of the '<em><b>Service Users</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.services.ServiceUser}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ServiceUsers reference, contains 0 or more ServiceUser type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service Users</em>' containment reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getOperator_ServiceUsers()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ServiceUsers'"
	 * @generated
	 */
	EList<ServiceUser> getServiceUsers();

	/**
	 * Returns the value of the '<em><b>Resource Expansions</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.ResourceExpansion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Services reference, contains 0 or more Service type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resource Expansions</em>' containment reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getOperator_ResourceExpansions()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ResourceExpansions'"
	 * @generated
	 */
	EList<ResourceExpansion> getResourceExpansions();

	/**
	 * Returns the value of the '<em><b>Expansion Experiences</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.ExpansionExperience}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ExpansionExperiences reference, contains 0 or more ExpansionExperience type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expansion Experiences</em>' containment reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getOperator_ExpansionExperiences()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ExpansionExperiences'"
	 * @generated
	 */
	EList<ExpansionExperience> getExpansionExperiences();

} // Operator
