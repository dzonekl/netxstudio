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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.library.LibraryPackage;

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
 * 			Validation with pattern is not used, considering the limited
 * 			capabilities of
 * 			XSD patterns.
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
 * 			Validation with pattern is not used, considering the limited
 * 			capabilities of
 * 			XSD patterns.
 * 
 * 		
 * <!-- end-model-doc -->
 * @see com.netxforge.netxstudio.services.ServicesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL' invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface ServicesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "services";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.netxforge.com/06032012/services";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "services";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServicesPackage eINSTANCE = com.netxforge.netxstudio.services.impl.ServicesPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.services.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.impl.ServiceImpl
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 5;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>CIID</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__CIID = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lifecycle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__LIFECYCLE = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICES = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Service Forecasts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_FORECASTS = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Service Monitors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_MONITORS = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Service User Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_USER_REFS = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Service Distribution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_DISTRIBUTION = GenericsPackage.BASE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Service Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_CATEGORY = GenericsPackage.BASE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Service Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_CLASS = GenericsPackage.BASE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Service Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_DESCRIPTION = GenericsPackage.BASE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_NAME = GenericsPackage.BASE_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.services.impl.CFSServiceImpl <em>CFS Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.impl.CFSServiceImpl
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getCFSService()
	 * @generated
	 */
	int CFS_SERVICE = 0;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_SERVICE__DELETED = SERVICE__DELETED;

	/**
	 * The feature id for the '<em><b>CIID</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_SERVICE__CIID = SERVICE__CIID;

	/**
	 * The feature id for the '<em><b>Lifecycle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_SERVICE__LIFECYCLE = SERVICE__LIFECYCLE;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_SERVICE__SERVICES = SERVICE__SERVICES;

	/**
	 * The feature id for the '<em><b>Service Forecasts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_SERVICE__SERVICE_FORECASTS = SERVICE__SERVICE_FORECASTS;

	/**
	 * The feature id for the '<em><b>Service Monitors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_SERVICE__SERVICE_MONITORS = SERVICE__SERVICE_MONITORS;

	/**
	 * The feature id for the '<em><b>Service User Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_SERVICE__SERVICE_USER_REFS = SERVICE__SERVICE_USER_REFS;

	/**
	 * The feature id for the '<em><b>Service Distribution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_SERVICE__SERVICE_DISTRIBUTION = SERVICE__SERVICE_DISTRIBUTION;

	/**
	 * The feature id for the '<em><b>Service Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_SERVICE__SERVICE_CATEGORY = SERVICE__SERVICE_CATEGORY;

	/**
	 * The feature id for the '<em><b>Service Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_SERVICE__SERVICE_CLASS = SERVICE__SERVICE_CLASS;

	/**
	 * The feature id for the '<em><b>Service Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_SERVICE__SERVICE_DESCRIPTION = SERVICE__SERVICE_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_SERVICE__SERVICE_NAME = SERVICE__SERVICE_NAME;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_SERVICE__PROVIDER = SERVICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenario</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_SERVICE__SCENARIO = SERVICE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CFS Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFS_SERVICE_FEATURE_COUNT = SERVICE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.services.impl.CIIDImpl <em>CIID</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.impl.CIIDImpl
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getCIID()
	 * @generated
	 */
	int CIID = 1;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIID__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Common CIID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIID__COMMON_CIID = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Local CIID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIID__LOCAL_CIID = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CIID</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIID_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.services.impl.DerivedResourceImpl <em>Derived Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.impl.DerivedResourceImpl
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getDerivedResource()
	 * @generated
	 */
	int DERIVED_RESOURCE = 2;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_RESOURCE__DELETED = LibraryPackage.BASE_RESOURCE__DELETED;

	/**
	 * The feature id for the '<em><b>Detail Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_RESOURCE__DETAIL_DISPLAY = LibraryPackage.BASE_RESOURCE__DETAIL_DISPLAY;

	/**
	 * The feature id for the '<em><b>Expression Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_RESOURCE__EXPRESSION_NAME = LibraryPackage.BASE_RESOURCE__EXPRESSION_NAME;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_RESOURCE__LONG_NAME = LibraryPackage.BASE_RESOURCE__LONG_NAME;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_RESOURCE__SHORT_NAME = LibraryPackage.BASE_RESOURCE__SHORT_NAME;

	/**
	 * The feature id for the '<em><b>Summary Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_RESOURCE__SUMMARY_DISPLAY = LibraryPackage.BASE_RESOURCE__SUMMARY_DISPLAY;

	/**
	 * The feature id for the '<em><b>Unit Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_RESOURCE__UNIT_REF = LibraryPackage.BASE_RESOURCE__UNIT_REF;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_RESOURCE__VALUES = LibraryPackage.BASE_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Forecast Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_RESOURCE__FORECAST_VALUES = LibraryPackage.BASE_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Trended Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_RESOURCE__TRENDED_VALUES = LibraryPackage.BASE_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Derived Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_RESOURCE_FEATURE_COUNT = LibraryPackage.BASE_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.services.impl.DistributionEntryImpl <em>Distribution Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.impl.DistributionEntryImpl
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getDistributionEntry()
	 * @generated
	 */
	int DISTRIBUTION_ENTRY = 3;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_ENTRY__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Resource Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_ENTRY__RESOURCE_REF = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Distribution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_ENTRY__DISTRIBUTION = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_ENTRY__RESOURCE_ORIGIN = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Distribution Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_ENTRY_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.services.impl.RFSServiceImpl <em>RFS Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.impl.RFSServiceImpl
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getRFSService()
	 * @generated
	 */
	int RFS_SERVICE = 4;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE__DELETED = SERVICE__DELETED;

	/**
	 * The feature id for the '<em><b>CIID</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE__CIID = SERVICE__CIID;

	/**
	 * The feature id for the '<em><b>Lifecycle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE__LIFECYCLE = SERVICE__LIFECYCLE;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE__SERVICES = SERVICE__SERVICES;

	/**
	 * The feature id for the '<em><b>Service Forecasts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE__SERVICE_FORECASTS = SERVICE__SERVICE_FORECASTS;

	/**
	 * The feature id for the '<em><b>Service Monitors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE__SERVICE_MONITORS = SERVICE__SERVICE_MONITORS;

	/**
	 * The feature id for the '<em><b>Service User Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE__SERVICE_USER_REFS = SERVICE__SERVICE_USER_REFS;

	/**
	 * The feature id for the '<em><b>Service Distribution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE__SERVICE_DISTRIBUTION = SERVICE__SERVICE_DISTRIBUTION;

	/**
	 * The feature id for the '<em><b>Service Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE__SERVICE_CATEGORY = SERVICE__SERVICE_CATEGORY;

	/**
	 * The feature id for the '<em><b>Service Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE__SERVICE_CLASS = SERVICE__SERVICE_CLASS;

	/**
	 * The feature id for the '<em><b>Service Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE__SERVICE_DESCRIPTION = SERVICE__SERVICE_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE__SERVICE_NAME = SERVICE__SERVICE_NAME;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE__NODES = SERVICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tolerance Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE__TOLERANCE_REFS = SERVICE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Functional Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE__FUNCTIONAL_CATEGORY = SERVICE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>RFS Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_FEATURE_COUNT = SERVICE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.services.impl.ServiceDistributionImpl <em>Service Distribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.impl.ServiceDistributionImpl
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceDistribution()
	 * @generated
	 */
	int SERVICE_DISTRIBUTION = 6;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DISTRIBUTION__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Distribution Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DISTRIBUTION__DISTRIBUTION_ENTRIES = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DISTRIBUTION__EXPRESSION_REFS = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Service Distribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DISTRIBUTION_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.services.impl.ServiceFlowImpl <em>Service Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.impl.ServiceFlowImpl
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceFlow()
	 * @generated
	 */
	int SERVICE_FLOW = 7;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FLOW__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Service Flow Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FLOW__SERVICE_FLOW_RELATIONSHIPS = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FLOW__NAME = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Service Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FLOW_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.services.impl.ServiceFlowRelationshipImpl <em>Service Flow Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.impl.ServiceFlowRelationshipImpl
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceFlowRelationship()
	 * @generated
	 */
	int SERVICE_FLOW_RELATIONSHIP = 8;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FLOW_RELATIONSHIP__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Reference Relationship</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Service Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FLOW_RELATIONSHIP__SERVICE_FLOW = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FLOW_RELATIONSHIP__PROTOCOL = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Message</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FLOW_RELATIONSHIP__MESSAGE = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FLOW_RELATIONSHIP__DIRECTION = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Service Flow Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FLOW_RELATIONSHIP_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.services.impl.ServiceForecastImpl <em>Service Forecast</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.impl.ServiceForecastImpl
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceForecast()
	 * @generated
	 */
	int SERVICE_FORECAST = 9;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FORECAST__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Period</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FORECAST__PERIOD = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Service Forecast Users</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FORECAST__SERVICE_FORECAST_USERS = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Forecasts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FORECAST__RESOURCE_FORECASTS = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FORECAST__NAME = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FORECAST__REVISION = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Service Forecast</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FORECAST_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.services.impl.ServiceForecastUsersImpl <em>Service Forecast Users</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.impl.ServiceForecastUsersImpl
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceForecastUsers()
	 * @generated
	 */
	int SERVICE_FORECAST_USERS = 10;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FORECAST_USERS__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>User Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FORECAST_USERS__USER_VALUES = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Service User Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FORECAST_USERS__SERVICE_USER_REF = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Service Forecast Users</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FORECAST_USERS_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.services.impl.ServiceMonitorImpl <em>Service Monitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.impl.ServiceMonitorImpl
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceMonitor()
	 * @generated
	 */
	int SERVICE_MONITOR = 11;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MONITOR__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Period</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MONITOR__PERIOD = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Monitors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MONITOR__RESOURCE_MONITORS = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MONITOR__NAME = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MONITOR__REVISION = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Service Monitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MONITOR_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.services.impl.ServiceProfileImpl <em>Service Profile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.impl.ServiceProfileImpl
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceProfile()
	 * @generated
	 */
	int SERVICE_PROFILE = 12;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROFILE__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Profile Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROFILE__PROFILE_RESOURCES = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROFILE__NAME = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Service Profile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROFILE_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.services.impl.ServiceUserImpl <em>Service User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.impl.ServiceUserImpl
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceUser()
	 * @generated
	 */
	int SERVICE_USER = 13;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_USER__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Service Profile</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_USER__SERVICE_PROFILE = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_USER__EXPRESSION_REF = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_USER__DESCRIPTION = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_USER__NAME = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Service User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_USER_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.services.ResourceOriginType <em>Resource Origin Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.ResourceOriginType
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getResourceOriginType()
	 * @generated
	 */
	int RESOURCE_ORIGIN_TYPE = 14;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.services.ServiceClassType <em>Service Class Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.ServiceClassType
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceClassType()
	 * @generated
	 */
	int SERVICE_CLASS_TYPE = 15;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.services.ServiceFlowDirection <em>Service Flow Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.ServiceFlowDirection
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceFlowDirection()
	 * @generated
	 */
	int SERVICE_FLOW_DIRECTION = 16;

	/**
	 * The meta object id for the '<em>Resource Origin Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.ResourceOriginType
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getResourceOriginTypeObject()
	 * @generated
	 */
	int RESOURCE_ORIGIN_TYPE_OBJECT = 17;

	/**
	 * The meta object id for the '<em>Service Class Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.ServiceClassType
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceClassTypeObject()
	 * @generated
	 */
	int SERVICE_CLASS_TYPE_OBJECT = 18;


	/**
	 * The meta object id for the '<em>Service Flow Direction Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.services.ServiceFlowDirection
	 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceFlowDirectionObject()
	 * @generated
	 */
	int SERVICE_FLOW_DIRECTION_OBJECT = 19;

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.services.CFSService <em>CFS Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CFS Service</em>'.
	 * @see com.netxforge.netxstudio.services.CFSService
	 * @generated
	 */
	EClass getCFSService();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.CFSService#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see com.netxforge.netxstudio.services.CFSService#getProvider()
	 * @see #getCFSService()
	 * @generated
	 */
	EAttribute getCFSService_Provider();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.CFSService#getScenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scenario</em>'.
	 * @see com.netxforge.netxstudio.services.CFSService#getScenario()
	 * @see #getCFSService()
	 * @generated
	 */
	EAttribute getCFSService_Scenario();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.services.CIID <em>CIID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CIID</em>'.
	 * @see com.netxforge.netxstudio.services.CIID
	 * @generated
	 */
	EClass getCIID();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.CIID#getCommonCIID <em>Common CIID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Common CIID</em>'.
	 * @see com.netxforge.netxstudio.services.CIID#getCommonCIID()
	 * @see #getCIID()
	 * @generated
	 */
	EAttribute getCIID_CommonCIID();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.CIID#getLocalCIID <em>Local CIID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local CIID</em>'.
	 * @see com.netxforge.netxstudio.services.CIID#getLocalCIID()
	 * @see #getCIID()
	 * @generated
	 */
	EAttribute getCIID_LocalCIID();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.services.DerivedResource <em>Derived Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Derived Resource</em>'.
	 * @see com.netxforge.netxstudio.services.DerivedResource
	 * @generated
	 */
	EClass getDerivedResource();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.services.DerivedResource#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see com.netxforge.netxstudio.services.DerivedResource#getValues()
	 * @see #getDerivedResource()
	 * @generated
	 */
	EReference getDerivedResource_Values();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.services.DerivedResource#getForecastValues <em>Forecast Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Forecast Values</em>'.
	 * @see com.netxforge.netxstudio.services.DerivedResource#getForecastValues()
	 * @see #getDerivedResource()
	 * @generated
	 */
	EReference getDerivedResource_ForecastValues();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.services.DerivedResource#getTrendedValues <em>Trended Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Trended Values</em>'.
	 * @see com.netxforge.netxstudio.services.DerivedResource#getTrendedValues()
	 * @see #getDerivedResource()
	 * @generated
	 */
	EReference getDerivedResource_TrendedValues();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.services.DistributionEntry <em>Distribution Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Distribution Entry</em>'.
	 * @see com.netxforge.netxstudio.services.DistributionEntry
	 * @generated
	 */
	EClass getDistributionEntry();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.services.DistributionEntry#getResourceRef <em>Resource Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource Ref</em>'.
	 * @see com.netxforge.netxstudio.services.DistributionEntry#getResourceRef()
	 * @see #getDistributionEntry()
	 * @generated
	 */
	EReference getDistributionEntry_ResourceRef();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.services.DistributionEntry#getDistribution <em>Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Distribution</em>'.
	 * @see com.netxforge.netxstudio.services.DistributionEntry#getDistribution()
	 * @see #getDistributionEntry()
	 * @generated
	 */
	EReference getDistributionEntry_Distribution();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.DistributionEntry#getResourceOrigin <em>Resource Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Origin</em>'.
	 * @see com.netxforge.netxstudio.services.DistributionEntry#getResourceOrigin()
	 * @see #getDistributionEntry()
	 * @generated
	 */
	EAttribute getDistributionEntry_ResourceOrigin();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.services.RFSService <em>RFS Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>RFS Service</em>'.
	 * @see com.netxforge.netxstudio.services.RFSService
	 * @generated
	 */
	EClass getRFSService();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.services.RFSService#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Nodes</em>'.
	 * @see com.netxforge.netxstudio.services.RFSService#getNodes()
	 * @see #getRFSService()
	 * @generated
	 */
	EReference getRFSService_Nodes();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.services.RFSService#getToleranceRefs <em>Tolerance Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tolerance Refs</em>'.
	 * @see com.netxforge.netxstudio.services.RFSService#getToleranceRefs()
	 * @see #getRFSService()
	 * @generated
	 */
	EReference getRFSService_ToleranceRefs();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.RFSService#getFunctionalCategory <em>Functional Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Functional Category</em>'.
	 * @see com.netxforge.netxstudio.services.RFSService#getFunctionalCategory()
	 * @see #getRFSService()
	 * @generated
	 */
	EAttribute getRFSService_FunctionalCategory();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.services.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see com.netxforge.netxstudio.services.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.services.Service#getCIID <em>CIID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>CIID</em>'.
	 * @see com.netxforge.netxstudio.services.Service#getCIID()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_CIID();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.services.Service#getLifecycle <em>Lifecycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lifecycle</em>'.
	 * @see com.netxforge.netxstudio.services.Service#getLifecycle()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Lifecycle();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.services.Service#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Services</em>'.
	 * @see com.netxforge.netxstudio.services.Service#getServices()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Services();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.services.Service#getServiceForecasts <em>Service Forecasts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Forecasts</em>'.
	 * @see com.netxforge.netxstudio.services.Service#getServiceForecasts()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_ServiceForecasts();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.services.Service#getServiceMonitors <em>Service Monitors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Monitors</em>'.
	 * @see com.netxforge.netxstudio.services.Service#getServiceMonitors()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_ServiceMonitors();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.services.Service#getServiceUserRefs <em>Service User Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Service User Refs</em>'.
	 * @see com.netxforge.netxstudio.services.Service#getServiceUserRefs()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_ServiceUserRefs();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.services.Service#getServiceDistribution <em>Service Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service Distribution</em>'.
	 * @see com.netxforge.netxstudio.services.Service#getServiceDistribution()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_ServiceDistribution();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.Service#getServiceCategory <em>Service Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Category</em>'.
	 * @see com.netxforge.netxstudio.services.Service#getServiceCategory()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_ServiceCategory();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.Service#getServiceClass <em>Service Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Class</em>'.
	 * @see com.netxforge.netxstudio.services.Service#getServiceClass()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_ServiceClass();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.Service#getServiceDescription <em>Service Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Description</em>'.
	 * @see com.netxforge.netxstudio.services.Service#getServiceDescription()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_ServiceDescription();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.Service#getServiceName <em>Service Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Name</em>'.
	 * @see com.netxforge.netxstudio.services.Service#getServiceName()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_ServiceName();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.services.ServiceDistribution <em>Service Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Distribution</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceDistribution
	 * @generated
	 */
	EClass getServiceDistribution();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.services.ServiceDistribution#getDistributionEntries <em>Distribution Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Distribution Entries</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceDistribution#getDistributionEntries()
	 * @see #getServiceDistribution()
	 * @generated
	 */
	EReference getServiceDistribution_DistributionEntries();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.services.ServiceDistribution#getExpressionRefs <em>Expression Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Expression Refs</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceDistribution#getExpressionRefs()
	 * @see #getServiceDistribution()
	 * @generated
	 */
	EReference getServiceDistribution_ExpressionRefs();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.services.ServiceFlow <em>Service Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Flow</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceFlow
	 * @generated
	 */
	EClass getServiceFlow();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.services.ServiceFlow#getServiceFlowRelationships <em>Service Flow Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Flow Relationships</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceFlow#getServiceFlowRelationships()
	 * @see #getServiceFlow()
	 * @generated
	 */
	EReference getServiceFlow_ServiceFlowRelationships();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.ServiceFlow#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceFlow#getName()
	 * @see #getServiceFlow()
	 * @generated
	 */
	EAttribute getServiceFlow_Name();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.services.ServiceFlowRelationship <em>Service Flow Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Flow Relationship</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceFlowRelationship
	 * @generated
	 */
	EClass getServiceFlowRelationship();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.services.ServiceFlowRelationship#getReferenceRelationship <em>Reference Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference Relationship</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceFlowRelationship#getReferenceRelationship()
	 * @see #getServiceFlowRelationship()
	 * @generated
	 */
	EReference getServiceFlowRelationship_ReferenceRelationship();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.services.ServiceFlowRelationship#getServiceFlow <em>Service Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Service Flow</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceFlowRelationship#getServiceFlow()
	 * @see #getServiceFlowRelationship()
	 * @generated
	 */
	EReference getServiceFlowRelationship_ServiceFlow();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.services.ServiceFlowRelationship#getProtocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Protocol</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceFlowRelationship#getProtocol()
	 * @see #getServiceFlowRelationship()
	 * @generated
	 */
	EReference getServiceFlowRelationship_Protocol();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.services.ServiceFlowRelationship#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Message</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceFlowRelationship#getMessage()
	 * @see #getServiceFlowRelationship()
	 * @generated
	 */
	EReference getServiceFlowRelationship_Message();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.ServiceFlowRelationship#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceFlowRelationship#getDirection()
	 * @see #getServiceFlowRelationship()
	 * @generated
	 */
	EAttribute getServiceFlowRelationship_Direction();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.services.ServiceForecast <em>Service Forecast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Forecast</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceForecast
	 * @generated
	 */
	EClass getServiceForecast();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.services.ServiceForecast#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Period</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceForecast#getPeriod()
	 * @see #getServiceForecast()
	 * @generated
	 */
	EReference getServiceForecast_Period();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.services.ServiceForecast#getServiceForecastUsers <em>Service Forecast Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Forecast Users</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceForecast#getServiceForecastUsers()
	 * @see #getServiceForecast()
	 * @generated
	 */
	EReference getServiceForecast_ServiceForecastUsers();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.services.ServiceForecast#getResourceForecasts <em>Resource Forecasts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Forecasts</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceForecast#getResourceForecasts()
	 * @see #getServiceForecast()
	 * @generated
	 */
	EReference getServiceForecast_ResourceForecasts();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.ServiceForecast#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceForecast#getName()
	 * @see #getServiceForecast()
	 * @generated
	 */
	EAttribute getServiceForecast_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.ServiceForecast#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Revision</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceForecast#getRevision()
	 * @see #getServiceForecast()
	 * @generated
	 */
	EAttribute getServiceForecast_Revision();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.services.ServiceForecastUsers <em>Service Forecast Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Forecast Users</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceForecastUsers
	 * @generated
	 */
	EClass getServiceForecastUsers();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.services.ServiceForecastUsers#getUserValues <em>User Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>User Values</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceForecastUsers#getUserValues()
	 * @see #getServiceForecastUsers()
	 * @generated
	 */
	EReference getServiceForecastUsers_UserValues();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.services.ServiceForecastUsers#getServiceUserRef <em>Service User Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Service User Ref</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceForecastUsers#getServiceUserRef()
	 * @see #getServiceForecastUsers()
	 * @generated
	 */
	EReference getServiceForecastUsers_ServiceUserRef();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.services.ServiceMonitor <em>Service Monitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Monitor</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceMonitor
	 * @generated
	 */
	EClass getServiceMonitor();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.services.ServiceMonitor#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Period</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceMonitor#getPeriod()
	 * @see #getServiceMonitor()
	 * @generated
	 */
	EReference getServiceMonitor_Period();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.services.ServiceMonitor#getResourceMonitors <em>Resource Monitors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Monitors</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceMonitor#getResourceMonitors()
	 * @see #getServiceMonitor()
	 * @generated
	 */
	EReference getServiceMonitor_ResourceMonitors();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.ServiceMonitor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceMonitor#getName()
	 * @see #getServiceMonitor()
	 * @generated
	 */
	EAttribute getServiceMonitor_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.ServiceMonitor#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Revision</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceMonitor#getRevision()
	 * @see #getServiceMonitor()
	 * @generated
	 */
	EAttribute getServiceMonitor_Revision();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.services.ServiceProfile <em>Service Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Profile</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceProfile
	 * @generated
	 */
	EClass getServiceProfile();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.services.ServiceProfile#getProfileResources <em>Profile Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Profile Resources</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceProfile#getProfileResources()
	 * @see #getServiceProfile()
	 * @generated
	 */
	EReference getServiceProfile_ProfileResources();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.ServiceProfile#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceProfile#getName()
	 * @see #getServiceProfile()
	 * @generated
	 */
	EAttribute getServiceProfile_Name();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.services.ServiceUser <em>Service User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service User</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceUser
	 * @generated
	 */
	EClass getServiceUser();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.services.ServiceUser#getServiceProfile <em>Service Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service Profile</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceUser#getServiceProfile()
	 * @see #getServiceUser()
	 * @generated
	 */
	EReference getServiceUser_ServiceProfile();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.services.ServiceUser#getExpressionRef <em>Expression Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression Ref</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceUser#getExpressionRef()
	 * @see #getServiceUser()
	 * @generated
	 */
	EReference getServiceUser_ExpressionRef();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.ServiceUser#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceUser#getDescription()
	 * @see #getServiceUser()
	 * @generated
	 */
	EAttribute getServiceUser_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.services.ServiceUser#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceUser#getName()
	 * @see #getServiceUser()
	 * @generated
	 */
	EAttribute getServiceUser_Name();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.services.ResourceOriginType <em>Resource Origin Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Resource Origin Type</em>'.
	 * @see com.netxforge.netxstudio.services.ResourceOriginType
	 * @generated
	 */
	EEnum getResourceOriginType();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.services.ServiceClassType <em>Service Class Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Service Class Type</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceClassType
	 * @generated
	 */
	EEnum getServiceClassType();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.services.ServiceFlowDirection <em>Service Flow Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Service Flow Direction</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceFlowDirection
	 * @generated
	 */
	EEnum getServiceFlowDirection();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.services.ResourceOriginType <em>Resource Origin Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Resource Origin Type Object</em>'.
	 * @see com.netxforge.netxstudio.services.ResourceOriginType
	 * @model instanceClass="com.netxforge.netxstudio.services.ResourceOriginType"
	 *        extendedMetaData="name='ResourceOrigin_._type:Object' baseType='ResourceOrigin_._type'"
	 * @generated
	 */
	EDataType getResourceOriginTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.services.ServiceClassType <em>Service Class Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Service Class Type Object</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceClassType
	 * @model instanceClass="com.netxforge.netxstudio.services.ServiceClassType"
	 *        extendedMetaData="name='ServiceClass_._type:Object' baseType='ServiceClass_._type'"
	 * @generated
	 */
	EDataType getServiceClassTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.services.ServiceFlowDirection <em>Service Flow Direction Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Service Flow Direction Object</em>'.
	 * @see com.netxforge.netxstudio.services.ServiceFlowDirection
	 * @model instanceClass="com.netxforge.netxstudio.services.ServiceFlowDirection"
	 *        extendedMetaData="name='ServiceFlowDirection:Object' baseType='ServiceFlowDirection'"
	 * @generated
	 */
	EDataType getServiceFlowDirectionObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ServicesFactory getServicesFactory();

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
		 * The meta object literal for the '{@link com.netxforge.netxstudio.services.impl.CFSServiceImpl <em>CFS Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.impl.CFSServiceImpl
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getCFSService()
		 * @generated
		 */
		EClass CFS_SERVICE = eINSTANCE.getCFSService();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CFS_SERVICE__PROVIDER = eINSTANCE.getCFSService_Provider();

		/**
		 * The meta object literal for the '<em><b>Scenario</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CFS_SERVICE__SCENARIO = eINSTANCE.getCFSService_Scenario();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.services.impl.CIIDImpl <em>CIID</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.impl.CIIDImpl
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getCIID()
		 * @generated
		 */
		EClass CIID = eINSTANCE.getCIID();

		/**
		 * The meta object literal for the '<em><b>Common CIID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CIID__COMMON_CIID = eINSTANCE.getCIID_CommonCIID();

		/**
		 * The meta object literal for the '<em><b>Local CIID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CIID__LOCAL_CIID = eINSTANCE.getCIID_LocalCIID();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.services.impl.DerivedResourceImpl <em>Derived Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.impl.DerivedResourceImpl
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getDerivedResource()
		 * @generated
		 */
		EClass DERIVED_RESOURCE = eINSTANCE.getDerivedResource();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERIVED_RESOURCE__VALUES = eINSTANCE.getDerivedResource_Values();

		/**
		 * The meta object literal for the '<em><b>Forecast Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERIVED_RESOURCE__FORECAST_VALUES = eINSTANCE.getDerivedResource_ForecastValues();

		/**
		 * The meta object literal for the '<em><b>Trended Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERIVED_RESOURCE__TRENDED_VALUES = eINSTANCE.getDerivedResource_TrendedValues();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.services.impl.DistributionEntryImpl <em>Distribution Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.impl.DistributionEntryImpl
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getDistributionEntry()
		 * @generated
		 */
		EClass DISTRIBUTION_ENTRY = eINSTANCE.getDistributionEntry();

		/**
		 * The meta object literal for the '<em><b>Resource Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISTRIBUTION_ENTRY__RESOURCE_REF = eINSTANCE.getDistributionEntry_ResourceRef();

		/**
		 * The meta object literal for the '<em><b>Distribution</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISTRIBUTION_ENTRY__DISTRIBUTION = eINSTANCE.getDistributionEntry_Distribution();

		/**
		 * The meta object literal for the '<em><b>Resource Origin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISTRIBUTION_ENTRY__RESOURCE_ORIGIN = eINSTANCE.getDistributionEntry_ResourceOrigin();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.services.impl.RFSServiceImpl <em>RFS Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.impl.RFSServiceImpl
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getRFSService()
		 * @generated
		 */
		EClass RFS_SERVICE = eINSTANCE.getRFSService();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RFS_SERVICE__NODES = eINSTANCE.getRFSService_Nodes();

		/**
		 * The meta object literal for the '<em><b>Tolerance Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RFS_SERVICE__TOLERANCE_REFS = eINSTANCE.getRFSService_ToleranceRefs();

		/**
		 * The meta object literal for the '<em><b>Functional Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RFS_SERVICE__FUNCTIONAL_CATEGORY = eINSTANCE.getRFSService_FunctionalCategory();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.services.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.impl.ServiceImpl
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>CIID</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__CIID = eINSTANCE.getService_CIID();

		/**
		 * The meta object literal for the '<em><b>Lifecycle</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__LIFECYCLE = eINSTANCE.getService_Lifecycle();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__SERVICES = eINSTANCE.getService_Services();

		/**
		 * The meta object literal for the '<em><b>Service Forecasts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__SERVICE_FORECASTS = eINSTANCE.getService_ServiceForecasts();

		/**
		 * The meta object literal for the '<em><b>Service Monitors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__SERVICE_MONITORS = eINSTANCE.getService_ServiceMonitors();

		/**
		 * The meta object literal for the '<em><b>Service User Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__SERVICE_USER_REFS = eINSTANCE.getService_ServiceUserRefs();

		/**
		 * The meta object literal for the '<em><b>Service Distribution</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__SERVICE_DISTRIBUTION = eINSTANCE.getService_ServiceDistribution();

		/**
		 * The meta object literal for the '<em><b>Service Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__SERVICE_CATEGORY = eINSTANCE.getService_ServiceCategory();

		/**
		 * The meta object literal for the '<em><b>Service Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__SERVICE_CLASS = eINSTANCE.getService_ServiceClass();

		/**
		 * The meta object literal for the '<em><b>Service Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__SERVICE_DESCRIPTION = eINSTANCE.getService_ServiceDescription();

		/**
		 * The meta object literal for the '<em><b>Service Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__SERVICE_NAME = eINSTANCE.getService_ServiceName();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.services.impl.ServiceDistributionImpl <em>Service Distribution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.impl.ServiceDistributionImpl
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceDistribution()
		 * @generated
		 */
		EClass SERVICE_DISTRIBUTION = eINSTANCE.getServiceDistribution();

		/**
		 * The meta object literal for the '<em><b>Distribution Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_DISTRIBUTION__DISTRIBUTION_ENTRIES = eINSTANCE.getServiceDistribution_DistributionEntries();

		/**
		 * The meta object literal for the '<em><b>Expression Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_DISTRIBUTION__EXPRESSION_REFS = eINSTANCE.getServiceDistribution_ExpressionRefs();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.services.impl.ServiceFlowImpl <em>Service Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.impl.ServiceFlowImpl
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceFlow()
		 * @generated
		 */
		EClass SERVICE_FLOW = eINSTANCE.getServiceFlow();

		/**
		 * The meta object literal for the '<em><b>Service Flow Relationships</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FLOW__SERVICE_FLOW_RELATIONSHIPS = eINSTANCE.getServiceFlow_ServiceFlowRelationships();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_FLOW__NAME = eINSTANCE.getServiceFlow_Name();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.services.impl.ServiceFlowRelationshipImpl <em>Service Flow Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.impl.ServiceFlowRelationshipImpl
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceFlowRelationship()
		 * @generated
		 */
		EClass SERVICE_FLOW_RELATIONSHIP = eINSTANCE.getServiceFlowRelationship();

		/**
		 * The meta object literal for the '<em><b>Reference Relationship</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP = eINSTANCE.getServiceFlowRelationship_ReferenceRelationship();

		/**
		 * The meta object literal for the '<em><b>Service Flow</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FLOW_RELATIONSHIP__SERVICE_FLOW = eINSTANCE.getServiceFlowRelationship_ServiceFlow();

		/**
		 * The meta object literal for the '<em><b>Protocol</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FLOW_RELATIONSHIP__PROTOCOL = eINSTANCE.getServiceFlowRelationship_Protocol();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FLOW_RELATIONSHIP__MESSAGE = eINSTANCE.getServiceFlowRelationship_Message();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_FLOW_RELATIONSHIP__DIRECTION = eINSTANCE.getServiceFlowRelationship_Direction();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.services.impl.ServiceForecastImpl <em>Service Forecast</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.impl.ServiceForecastImpl
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceForecast()
		 * @generated
		 */
		EClass SERVICE_FORECAST = eINSTANCE.getServiceForecast();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FORECAST__PERIOD = eINSTANCE.getServiceForecast_Period();

		/**
		 * The meta object literal for the '<em><b>Service Forecast Users</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FORECAST__SERVICE_FORECAST_USERS = eINSTANCE.getServiceForecast_ServiceForecastUsers();

		/**
		 * The meta object literal for the '<em><b>Resource Forecasts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FORECAST__RESOURCE_FORECASTS = eINSTANCE.getServiceForecast_ResourceForecasts();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_FORECAST__NAME = eINSTANCE.getServiceForecast_Name();

		/**
		 * The meta object literal for the '<em><b>Revision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_FORECAST__REVISION = eINSTANCE.getServiceForecast_Revision();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.services.impl.ServiceForecastUsersImpl <em>Service Forecast Users</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.impl.ServiceForecastUsersImpl
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceForecastUsers()
		 * @generated
		 */
		EClass SERVICE_FORECAST_USERS = eINSTANCE.getServiceForecastUsers();

		/**
		 * The meta object literal for the '<em><b>User Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FORECAST_USERS__USER_VALUES = eINSTANCE.getServiceForecastUsers_UserValues();

		/**
		 * The meta object literal for the '<em><b>Service User Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FORECAST_USERS__SERVICE_USER_REF = eINSTANCE.getServiceForecastUsers_ServiceUserRef();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.services.impl.ServiceMonitorImpl <em>Service Monitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.impl.ServiceMonitorImpl
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceMonitor()
		 * @generated
		 */
		EClass SERVICE_MONITOR = eINSTANCE.getServiceMonitor();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_MONITOR__PERIOD = eINSTANCE.getServiceMonitor_Period();

		/**
		 * The meta object literal for the '<em><b>Resource Monitors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_MONITOR__RESOURCE_MONITORS = eINSTANCE.getServiceMonitor_ResourceMonitors();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_MONITOR__NAME = eINSTANCE.getServiceMonitor_Name();

		/**
		 * The meta object literal for the '<em><b>Revision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_MONITOR__REVISION = eINSTANCE.getServiceMonitor_Revision();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.services.impl.ServiceProfileImpl <em>Service Profile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.impl.ServiceProfileImpl
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceProfile()
		 * @generated
		 */
		EClass SERVICE_PROFILE = eINSTANCE.getServiceProfile();

		/**
		 * The meta object literal for the '<em><b>Profile Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_PROFILE__PROFILE_RESOURCES = eINSTANCE.getServiceProfile_ProfileResources();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_PROFILE__NAME = eINSTANCE.getServiceProfile_Name();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.services.impl.ServiceUserImpl <em>Service User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.impl.ServiceUserImpl
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceUser()
		 * @generated
		 */
		EClass SERVICE_USER = eINSTANCE.getServiceUser();

		/**
		 * The meta object literal for the '<em><b>Service Profile</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_USER__SERVICE_PROFILE = eINSTANCE.getServiceUser_ServiceProfile();

		/**
		 * The meta object literal for the '<em><b>Expression Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_USER__EXPRESSION_REF = eINSTANCE.getServiceUser_ExpressionRef();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_USER__DESCRIPTION = eINSTANCE.getServiceUser_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_USER__NAME = eINSTANCE.getServiceUser_Name();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.services.ResourceOriginType <em>Resource Origin Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.ResourceOriginType
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getResourceOriginType()
		 * @generated
		 */
		EEnum RESOURCE_ORIGIN_TYPE = eINSTANCE.getResourceOriginType();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.services.ServiceClassType <em>Service Class Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.ServiceClassType
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceClassType()
		 * @generated
		 */
		EEnum SERVICE_CLASS_TYPE = eINSTANCE.getServiceClassType();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.services.ServiceFlowDirection <em>Service Flow Direction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.ServiceFlowDirection
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceFlowDirection()
		 * @generated
		 */
		EEnum SERVICE_FLOW_DIRECTION = eINSTANCE.getServiceFlowDirection();

		/**
		 * The meta object literal for the '<em>Resource Origin Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.ResourceOriginType
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getResourceOriginTypeObject()
		 * @generated
		 */
		EDataType RESOURCE_ORIGIN_TYPE_OBJECT = eINSTANCE.getResourceOriginTypeObject();

		/**
		 * The meta object literal for the '<em>Service Class Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.ServiceClassType
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceClassTypeObject()
		 * @generated
		 */
		EDataType SERVICE_CLASS_TYPE_OBJECT = eINSTANCE.getServiceClassTypeObject();

		/**
		 * The meta object literal for the '<em>Service Flow Direction Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.services.ServiceFlowDirection
		 * @see com.netxforge.netxstudio.services.impl.ServicesPackageImpl#getServiceFlowDirectionObject()
		 * @generated
		 */
		EDataType SERVICE_FLOW_DIRECTION_OBJECT = eINSTANCE.getServiceFlowDirectionObject();

	}

} //ServicesPackage
