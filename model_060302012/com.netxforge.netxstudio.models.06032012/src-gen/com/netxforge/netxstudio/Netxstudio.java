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
package com.netxforge.netxstudio;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.Company;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.geo.Country;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.Vendor;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.scheduling.Job;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Netxstudio</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Netxstudio is a container which groups all main
 * 				other types. It is the root object.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.Netxstudio#getOperators <em>Operators</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.Netxstudio#getLibraries <em>Libraries</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.Netxstudio#getCompanies <em>Companies</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.Netxstudio#getVendors <em>Vendors</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.Netxstudio#getUsers <em>Users</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.Netxstudio#getRoles <em>Roles</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.Netxstudio#getCountries <em>Countries</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.Netxstudio#getJobs <em>Jobs</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.NetxstudioPackage#getNetxstudio()
 * @model extendedMetaData="name='Netxstudio' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface Netxstudio extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Operators</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.Operator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Operators reference, contains 0 or more
	 * 						Operator type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operators</em>' containment reference list.
	 * @see com.netxforge.netxstudio.NetxstudioPackage#getNetxstudio_Operators()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Operators'"
	 * @generated
	 */
	EList<Operator> getOperators();

	/**
	 * Returns the value of the '<em><b>Libraries</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Library}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Libraries reference, contains 0 or more
	 * 						Library type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Libraries</em>' containment reference list.
	 * @see com.netxforge.netxstudio.NetxstudioPackage#getNetxstudio_Libraries()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Libraries'"
	 * @generated
	 */
	EList<Library> getLibraries();

	/**
	 * Returns the value of the '<em><b>Companies</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.generics.Company}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Companies reference, contains 0 or more
	 * 						Company type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Companies</em>' containment reference list.
	 * @see com.netxforge.netxstudio.NetxstudioPackage#getNetxstudio_Companies()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Companies'"
	 * @generated
	 */
	EList<Company> getCompanies();

	/**
	 * Returns the value of the '<em><b>Vendors</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Vendor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Companies reference, contains 0 or more
	 * 						Company type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Vendors</em>' containment reference list.
	 * @see com.netxforge.netxstudio.NetxstudioPackage#getNetxstudio_Vendors()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Vendors'"
	 * @generated
	 */
	EList<Vendor> getVendors();

	/**
	 * Returns the value of the '<em><b>Users</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.generics.Person}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Users reference, contains 0 or more User
	 * 						type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Users</em>' containment reference list.
	 * @see com.netxforge.netxstudio.NetxstudioPackage#getNetxstudio_Users()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Users'"
	 * @generated
	 */
	EList<Person> getUsers();

	/**
	 * Returns the value of the '<em><b>Roles</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.generics.Role}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Roles reference, contains 0 or more Role
	 * 						type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Roles</em>' containment reference list.
	 * @see com.netxforge.netxstudio.NetxstudioPackage#getNetxstudio_Roles()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Roles'"
	 * @generated
	 */
	EList<Role> getRoles();

	/**
	 * Returns the value of the '<em><b>Countries</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.geo.Country}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Countries reference, contains 0 or more
	 * 						Country type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Countries</em>' containment reference list.
	 * @see com.netxforge.netxstudio.NetxstudioPackage#getNetxstudio_Countries()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Countries'"
	 * @generated
	 */
	EList<Country> getCountries();

	/**
	 * Returns the value of the '<em><b>Jobs</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.scheduling.Job}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Jobs reference, contains 0 or more Job type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Jobs</em>' containment reference list.
	 * @see com.netxforge.netxstudio.NetxstudioPackage#getNetxstudio_Jobs()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Jobs'"
	 * @generated
	 */
	EList<Job> getJobs();

} // Netxstudio
