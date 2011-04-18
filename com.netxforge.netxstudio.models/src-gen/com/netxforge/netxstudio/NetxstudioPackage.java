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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 * 			Network Data schema Copyright 2008 The schema uses
 * 			ecore
 * 			references syntax, but should easily map into an SQL schema.
 * 			The
 * 			ecore
 * 			references, are mapped into ORM specific DLL (See
 * 			Hibernate or
 * 			other
 * 			ORM). Most tables have an ID field, which
 * 			could actually be
 * 			removed.
 * 			the Original intent is the use of
 * 			an ID column, as a reference
 * 			identifier. EMF/Hibernate
 * 			however uses a custom mechanism.
 * 
 * 			Don't use
 * 			the word "Item", as this is appended to the Object
 * 			name in the EMF
 * 			edit model.
 * 		
 * 
 * 
 * 			Network Data schema Copyright 2008 The schema uses
 * 			ecore
 * 			references syntax, but should easily map into an SQL schema.
 * 			The
 * 			ecore
 * 			references, are mapped into ORM specific DLL (See
 * 			Hibernate or
 * 			other
 * 			ORM. EMF/Hibernate
 * 			however uses a custom mechanism.
 * 
 * 			Don't use
 * 			the
 * 			word
 * 			"Item", as this is appended to the Object
 * 			name in the EMF
 * 			edit
 * 			model.
 * 			
 * 			Validation with pattern is not used, considering the limited capabilities of XSD patterns. 
 * 			
 * 		
 * 
 * 
 * 			Network Data schema Copyright 2008 The schema uses
 * 			ecore
 * 			references syntax, but should easily map into an SQL schema.
 * 			The
 * 			ecore
 * 			references, are mapped into ORM specific DLL (See
 * 			Hibernate or
 * 			other
 * 			ORM. EMF/Hibernate
 * 			however uses a custom mechanism.
 * 
 * 			Don't use
 * 			the
 * 			word
 * 			"Item", as this is appended to the Object
 * 			name in the EMF
 * 			edit
 * 			model.
 * 			
 * 			Validation with pattern is not used, considering the limited capabilities of XSD patterns. 
 * 			
 * 		
 * 
 * 		
 * 
 * 
 * 			Network Data schema Copyright 2008 The schema uses
 * 			ecore
 * 			references syntax, but should easily map into an SQL schema.
 * 			The
 * 			ecore
 * 			references, are mapped into ORM specific DLL (See
 * 			Hibernate or
 * 			other
 * 			ORM. EMF/Hibernate
 * 			however uses a custom mechanism.
 * 
 * 			Don't use
 * 			the
 * 			word
 * 			"Item", as this is appended to the Object
 * 			name in the EMF
 * 			edit
 * 			model.
 * 			
 * 			Validation with pattern is not used, considering the limited capabilities of XSD patterns. 
 * 			
 * 		
 * <!-- end-model-doc -->
 * @see com.netxforge.netxstudio.NetxstudioFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL' invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface NetxstudioPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "netxstudio";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.netxforge.com/13042011/netxstudio";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "netxstudio";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NetxstudioPackage eINSTANCE = com.netxforge.netxstudio.impl.NetxstudioPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.impl.NetxstudioImpl <em>Netxstudio</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.impl.NetxstudioImpl
	 * @see com.netxforge.netxstudio.impl.NetxstudioPackageImpl#getNetxstudio()
	 * @generated
	 */
	int NETXSTUDIO = 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETXSTUDIO__OPERATORS = 0;

	/**
	 * The feature id for the '<em><b>Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETXSTUDIO__LIBRARIES = 1;

	/**
	 * The feature id for the '<em><b>Companies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETXSTUDIO__COMPANIES = 2;

	/**
	 * The feature id for the '<em><b>Vendors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETXSTUDIO__VENDORS = 3;

	/**
	 * The feature id for the '<em><b>Users</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETXSTUDIO__USERS = 4;

	/**
	 * The feature id for the '<em><b>Countries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETXSTUDIO__COUNTRIES = 5;

	/**
	 * The feature id for the '<em><b>Jobs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETXSTUDIO__JOBS = 6;

	/**
	 * The number of structural features of the '<em>Netxstudio</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETXSTUDIO_FEATURE_COUNT = 7;


	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.Netxstudio <em>Netxstudio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Netxstudio</em>'.
	 * @see com.netxforge.netxstudio.Netxstudio
	 * @generated
	 */
	EClass getNetxstudio();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.Netxstudio#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operators</em>'.
	 * @see com.netxforge.netxstudio.Netxstudio#getOperators()
	 * @see #getNetxstudio()
	 * @generated
	 */
	EReference getNetxstudio_Operators();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.Netxstudio#getLibraries <em>Libraries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Libraries</em>'.
	 * @see com.netxforge.netxstudio.Netxstudio#getLibraries()
	 * @see #getNetxstudio()
	 * @generated
	 */
	EReference getNetxstudio_Libraries();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.Netxstudio#getCompanies <em>Companies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Companies</em>'.
	 * @see com.netxforge.netxstudio.Netxstudio#getCompanies()
	 * @see #getNetxstudio()
	 * @generated
	 */
	EReference getNetxstudio_Companies();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.Netxstudio#getVendors <em>Vendors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vendors</em>'.
	 * @see com.netxforge.netxstudio.Netxstudio#getVendors()
	 * @see #getNetxstudio()
	 * @generated
	 */
	EReference getNetxstudio_Vendors();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.Netxstudio#getUsers <em>Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Users</em>'.
	 * @see com.netxforge.netxstudio.Netxstudio#getUsers()
	 * @see #getNetxstudio()
	 * @generated
	 */
	EReference getNetxstudio_Users();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.Netxstudio#getCountries <em>Countries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Countries</em>'.
	 * @see com.netxforge.netxstudio.Netxstudio#getCountries()
	 * @see #getNetxstudio()
	 * @generated
	 */
	EReference getNetxstudio_Countries();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.Netxstudio#getJobs <em>Jobs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Jobs</em>'.
	 * @see com.netxforge.netxstudio.Netxstudio#getJobs()
	 * @see #getNetxstudio()
	 * @generated
	 */
	EReference getNetxstudio_Jobs();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NetxstudioFactory getNetxstudioFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.impl.NetxstudioImpl <em>Netxstudio</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.impl.NetxstudioImpl
		 * @see com.netxforge.netxstudio.impl.NetxstudioPackageImpl#getNetxstudio()
		 * @generated
		 */
		EClass NETXSTUDIO = eINSTANCE.getNetxstudio();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETXSTUDIO__OPERATORS = eINSTANCE.getNetxstudio_Operators();

		/**
		 * The meta object literal for the '<em><b>Libraries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETXSTUDIO__LIBRARIES = eINSTANCE.getNetxstudio_Libraries();

		/**
		 * The meta object literal for the '<em><b>Companies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETXSTUDIO__COMPANIES = eINSTANCE.getNetxstudio_Companies();

		/**
		 * The meta object literal for the '<em><b>Vendors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETXSTUDIO__VENDORS = eINSTANCE.getNetxstudio_Vendors();

		/**
		 * The meta object literal for the '<em><b>Users</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETXSTUDIO__USERS = eINSTANCE.getNetxstudio_Users();

		/**
		 * The meta object literal for the '<em><b>Countries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETXSTUDIO__COUNTRIES = eINSTANCE.getNetxstudio_Countries();

		/**
		 * The meta object literal for the '<em><b>Jobs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETXSTUDIO__JOBS = eINSTANCE.getNetxstudio_Jobs();

	}

} //NetxstudioPackage
