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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.netxforge.netxstudio.generics.GenericsPackage;

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
 * <!-- end-model-doc -->
 * @see com.netxforge.netxstudio.operators.OperatorsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL' invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface OperatorsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "operators";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.netxforge.com/13042011/operators";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "operators";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OperatorsPackage eINSTANCE = com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.operators.impl.RelationshipImpl <em>Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.operators.impl.RelationshipImpl
	 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getRelationship()
	 * @generated
	 */
	int RELATIONSHIP = 6;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__NAME = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Node ID1 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__NODE_ID1_REF = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Node ID2 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__NODE_ID2_REF = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Protocol Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__PROTOCOL_REF = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.operators.impl.EquipmentRelationshipImpl <em>Equipment Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.operators.impl.EquipmentRelationshipImpl
	 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getEquipmentRelationship()
	 * @generated
	 */
	int EQUIPMENT_RELATIONSHIP = 0;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_RELATIONSHIP__DELETED = RELATIONSHIP__DELETED;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_RELATIONSHIP__NAME = RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Node ID1 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_RELATIONSHIP__NODE_ID1_REF = RELATIONSHIP__NODE_ID1_REF;

	/**
	 * The feature id for the '<em><b>Node ID2 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_RELATIONSHIP__NODE_ID2_REF = RELATIONSHIP__NODE_ID2_REF;

	/**
	 * The feature id for the '<em><b>Protocol Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_RELATIONSHIP__PROTOCOL_REF = RELATIONSHIP__PROTOCOL_REF;

	/**
	 * The feature id for the '<em><b>Equipment1 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF = RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Equipment2 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF = RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Equipment Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_RELATIONSHIP_FEATURE_COUNT = RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.operators.impl.FunctionRelationshipImpl <em>Function Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.operators.impl.FunctionRelationshipImpl
	 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getFunctionRelationship()
	 * @generated
	 */
	int FUNCTION_RELATIONSHIP = 1;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_RELATIONSHIP__DELETED = RELATIONSHIP__DELETED;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_RELATIONSHIP__NAME = RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Node ID1 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_RELATIONSHIP__NODE_ID1_REF = RELATIONSHIP__NODE_ID1_REF;

	/**
	 * The feature id for the '<em><b>Node ID2 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_RELATIONSHIP__NODE_ID2_REF = RELATIONSHIP__NODE_ID2_REF;

	/**
	 * The feature id for the '<em><b>Protocol Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_RELATIONSHIP__PROTOCOL_REF = RELATIONSHIP__PROTOCOL_REF;

	/**
	 * The feature id for the '<em><b>Function1 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_RELATIONSHIP__FUNCTION1_REF = RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Function2 Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_RELATIONSHIP__FUNCTION2_REF = RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_RELATIONSHIP_FEATURE_COUNT = RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.operators.impl.MarkerImpl <em>Marker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.operators.impl.MarkerImpl
	 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getMarker()
	 * @generated
	 */
	int MARKER = 2;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKER__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Component Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKER__COMPONENT_REF = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKER__VALUE_REF = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Marker Resource Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKER__MARKER_RESOURCE_REF = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKER__DESCRIPTION = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKER__KIND = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Marker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKER_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.operators.impl.NetworkImpl <em>Network</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.operators.impl.NetworkImpl
	 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getNetwork()
	 * @generated
	 */
	int NETWORK = 3;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__DIAGRAMS = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__NODES = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Networks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__NETWORKS = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Function Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__FUNCTION_RELATIONSHIPS = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Equipment Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__EQUIPMENT_RELATIONSHIPS = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Metric Sources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__METRIC_SOURCES = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Created By Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__CREATED_BY_REF = GenericsPackage.BASE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Created Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__CREATED_DATE = GenericsPackage.BASE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__DESCRIPTION = GenericsPackage.BASE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__NAME = GenericsPackage.BASE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.operators.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.operators.impl.NodeImpl
	 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 4;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Lifecycle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__LIFECYCLE = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Node Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NODE_TYPE = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Created By Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CREATED_BY_REF = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Location Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__LOCATION_REF = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Node ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NODE_ID = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Original Node Type Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ORIGINAL_NODE_TYPE_REF = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.operators.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.operators.impl.OperatorImpl
	 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 5;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__DELETED = GenericsPackage.COMPANY__DELETED;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__ICONS = GenericsPackage.COMPANY__ICONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__NAME = GenericsPackage.COMPANY__NAME;

	/**
	 * The feature id for the '<em><b>RS Surl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__RS_SURL = GenericsPackage.COMPANY__RS_SURL;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__SHORT_NAME = GenericsPackage.COMPANY__SHORT_NAME;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__SYMBOL = GenericsPackage.COMPANY__SYMBOL;

	/**
	 * The feature id for the '<em><b>Website</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__WEBSITE = GenericsPackage.COMPANY__WEBSITE;

	/**
	 * The feature id for the '<em><b>Networks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__NETWORKS = GenericsPackage.COMPANY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Warehouses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__WAREHOUSES = GenericsPackage.COMPANY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__SERVICES = GenericsPackage.COMPANY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Service Users</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__SERVICE_USERS = GenericsPackage.COMPANY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Resource Expansions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__RESOURCE_EXPANSIONS = GenericsPackage.COMPANY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = GenericsPackage.COMPANY_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.operators.impl.ResourceExpansionImpl <em>Resource Expansion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.operators.impl.ResourceExpansionImpl
	 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getResourceExpansion()
	 * @generated
	 */
	int RESOURCE_EXPANSION = 7;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_EXPANSION__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Node Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_EXPANSION__NODE_REFS = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Equipment Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_EXPANSION__EQUIPMENT_REFS = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Function Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_EXPANSION__FUNCTION_REFS = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Resource Expansion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_EXPANSION_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.operators.impl.ResourceForecastImpl <em>Resource Forecast</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.operators.impl.ResourceForecastImpl
	 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getResourceForecast()
	 * @generated
	 */
	int RESOURCE_FORECAST = 8;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FORECAST__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Markers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FORECAST__MARKERS = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource Forecast</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FORECAST_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.operators.impl.ResourceMonitorImpl <em>Resource Monitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.operators.impl.ResourceMonitorImpl
	 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getResourceMonitor()
	 * @generated
	 */
	int RESOURCE_MONITOR = 9;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_MONITOR__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Markers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_MONITOR__MARKERS = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Node Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_MONITOR__NODE_REF = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_MONITOR__RESOURCE_REF = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_MONITOR__END = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_MONITOR__START = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Resource Monitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_MONITOR_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.operators.impl.WarehouseImpl <em>Warehouse</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.operators.impl.WarehouseImpl
	 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getWarehouse()
	 * @generated
	 */
	int WAREHOUSE = 10;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAREHOUSE__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAREHOUSE__NODES = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Equipments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAREHOUSE__EQUIPMENTS = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAREHOUSE__DESCRIPTION = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAREHOUSE__NAME = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Warehouse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAREHOUSE_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.operators.MarkerKind <em>Marker Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.operators.MarkerKind
	 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getMarkerKind()
	 * @generated
	 */
	int MARKER_KIND = 11;

	/**
	 * The meta object id for the '<em>Marker Kind Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.operators.MarkerKind
	 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getMarkerKindObject()
	 * @generated
	 */
	int MARKER_KIND_OBJECT = 12;


	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.operators.EquipmentRelationship <em>Equipment Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equipment Relationship</em>'.
	 * @see com.netxforge.netxstudio.operators.EquipmentRelationship
	 * @generated
	 */
	EClass getEquipmentRelationship();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.operators.EquipmentRelationship#getEquipment1Ref <em>Equipment1 Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Equipment1 Ref</em>'.
	 * @see com.netxforge.netxstudio.operators.EquipmentRelationship#getEquipment1Ref()
	 * @see #getEquipmentRelationship()
	 * @generated
	 */
	EReference getEquipmentRelationship_Equipment1Ref();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.operators.EquipmentRelationship#getEquipment2Ref <em>Equipment2 Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Equipment2 Ref</em>'.
	 * @see com.netxforge.netxstudio.operators.EquipmentRelationship#getEquipment2Ref()
	 * @see #getEquipmentRelationship()
	 * @generated
	 */
	EReference getEquipmentRelationship_Equipment2Ref();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.operators.FunctionRelationship <em>Function Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Relationship</em>'.
	 * @see com.netxforge.netxstudio.operators.FunctionRelationship
	 * @generated
	 */
	EClass getFunctionRelationship();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.operators.FunctionRelationship#getFunction1Ref <em>Function1 Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function1 Ref</em>'.
	 * @see com.netxforge.netxstudio.operators.FunctionRelationship#getFunction1Ref()
	 * @see #getFunctionRelationship()
	 * @generated
	 */
	EReference getFunctionRelationship_Function1Ref();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.operators.FunctionRelationship#getFunction2Ref <em>Function2 Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function2 Ref</em>'.
	 * @see com.netxforge.netxstudio.operators.FunctionRelationship#getFunction2Ref()
	 * @see #getFunctionRelationship()
	 * @generated
	 */
	EReference getFunctionRelationship_Function2Ref();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.operators.Marker <em>Marker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Marker</em>'.
	 * @see com.netxforge.netxstudio.operators.Marker
	 * @generated
	 */
	EClass getMarker();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.operators.Marker#getComponentRef <em>Component Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component Ref</em>'.
	 * @see com.netxforge.netxstudio.operators.Marker#getComponentRef()
	 * @see #getMarker()
	 * @generated
	 */
	EReference getMarker_ComponentRef();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.operators.Marker#getValueRef <em>Value Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value Ref</em>'.
	 * @see com.netxforge.netxstudio.operators.Marker#getValueRef()
	 * @see #getMarker()
	 * @generated
	 */
	EReference getMarker_ValueRef();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.operators.Marker#getMarkerResourceRef <em>Marker Resource Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Marker Resource Ref</em>'.
	 * @see com.netxforge.netxstudio.operators.Marker#getMarkerResourceRef()
	 * @see #getMarker()
	 * @generated
	 */
	EReference getMarker_MarkerResourceRef();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.operators.Marker#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.netxforge.netxstudio.operators.Marker#getDescription()
	 * @see #getMarker()
	 * @generated
	 */
	EAttribute getMarker_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.operators.Marker#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see com.netxforge.netxstudio.operators.Marker#getKind()
	 * @see #getMarker()
	 * @generated
	 */
	EAttribute getMarker_Kind();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.operators.Network <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Network</em>'.
	 * @see com.netxforge.netxstudio.operators.Network
	 * @generated
	 */
	EClass getNetwork();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.operators.Network#getDiagrams <em>Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Diagrams</em>'.
	 * @see com.netxforge.netxstudio.operators.Network#getDiagrams()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Diagrams();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.operators.Network#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see com.netxforge.netxstudio.operators.Network#getNodes()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.operators.Network#getNetworks <em>Networks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Networks</em>'.
	 * @see com.netxforge.netxstudio.operators.Network#getNetworks()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Networks();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.operators.Network#getFunctionRelationships <em>Function Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Function Relationships</em>'.
	 * @see com.netxforge.netxstudio.operators.Network#getFunctionRelationships()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_FunctionRelationships();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.operators.Network#getEquipmentRelationships <em>Equipment Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Equipment Relationships</em>'.
	 * @see com.netxforge.netxstudio.operators.Network#getEquipmentRelationships()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_EquipmentRelationships();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.operators.Network#getMetricSources <em>Metric Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metric Sources</em>'.
	 * @see com.netxforge.netxstudio.operators.Network#getMetricSources()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_MetricSources();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.operators.Network#getCreatedByRef <em>Created By Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Created By Ref</em>'.
	 * @see com.netxforge.netxstudio.operators.Network#getCreatedByRef()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_CreatedByRef();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.operators.Network#getCreatedDate <em>Created Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created Date</em>'.
	 * @see com.netxforge.netxstudio.operators.Network#getCreatedDate()
	 * @see #getNetwork()
	 * @generated
	 */
	EAttribute getNetwork_CreatedDate();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.operators.Network#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.netxforge.netxstudio.operators.Network#getDescription()
	 * @see #getNetwork()
	 * @generated
	 */
	EAttribute getNetwork_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.operators.Network#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.operators.Network#getName()
	 * @see #getNetwork()
	 * @generated
	 */
	EAttribute getNetwork_Name();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.operators.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see com.netxforge.netxstudio.operators.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.operators.Node#getLifecycle <em>Lifecycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lifecycle</em>'.
	 * @see com.netxforge.netxstudio.operators.Node#getLifecycle()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Lifecycle();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.operators.Node#getNodeType <em>Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Node Type</em>'.
	 * @see com.netxforge.netxstudio.operators.Node#getNodeType()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_NodeType();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.operators.Node#getCreatedByRef <em>Created By Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Created By Ref</em>'.
	 * @see com.netxforge.netxstudio.operators.Node#getCreatedByRef()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_CreatedByRef();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.operators.Node#getLocationRef <em>Location Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Location Ref</em>'.
	 * @see com.netxforge.netxstudio.operators.Node#getLocationRef()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_LocationRef();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.operators.Node#getNodeID <em>Node ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node ID</em>'.
	 * @see com.netxforge.netxstudio.operators.Node#getNodeID()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_NodeID();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.operators.Node#getOriginalNodeTypeRef <em>Original Node Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Node Type Ref</em>'.
	 * @see com.netxforge.netxstudio.operators.Node#getOriginalNodeTypeRef()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_OriginalNodeTypeRef();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.operators.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see com.netxforge.netxstudio.operators.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.operators.Operator#getNetworks <em>Networks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Networks</em>'.
	 * @see com.netxforge.netxstudio.operators.Operator#getNetworks()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_Networks();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.operators.Operator#getWarehouses <em>Warehouses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Warehouses</em>'.
	 * @see com.netxforge.netxstudio.operators.Operator#getWarehouses()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_Warehouses();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.operators.Operator#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Services</em>'.
	 * @see com.netxforge.netxstudio.operators.Operator#getServices()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_Services();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.operators.Operator#getServiceUsers <em>Service Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Users</em>'.
	 * @see com.netxforge.netxstudio.operators.Operator#getServiceUsers()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_ServiceUsers();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.operators.Operator#getResourceExpansions <em>Resource Expansions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Expansions</em>'.
	 * @see com.netxforge.netxstudio.operators.Operator#getResourceExpansions()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_ResourceExpansions();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.operators.Relationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relationship</em>'.
	 * @see com.netxforge.netxstudio.operators.Relationship
	 * @generated
	 */
	EClass getRelationship();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.operators.Relationship#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.operators.Relationship#getName()
	 * @see #getRelationship()
	 * @generated
	 */
	EAttribute getRelationship_Name();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.operators.Relationship#getNodeID1Ref <em>Node ID1 Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node ID1 Ref</em>'.
	 * @see com.netxforge.netxstudio.operators.Relationship#getNodeID1Ref()
	 * @see #getRelationship()
	 * @generated
	 */
	EReference getRelationship_NodeID1Ref();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.operators.Relationship#getNodeID2Ref <em>Node ID2 Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node ID2 Ref</em>'.
	 * @see com.netxforge.netxstudio.operators.Relationship#getNodeID2Ref()
	 * @see #getRelationship()
	 * @generated
	 */
	EReference getRelationship_NodeID2Ref();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.operators.Relationship#getProtocolRef <em>Protocol Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Protocol Ref</em>'.
	 * @see com.netxforge.netxstudio.operators.Relationship#getProtocolRef()
	 * @see #getRelationship()
	 * @generated
	 */
	EReference getRelationship_ProtocolRef();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.operators.ResourceExpansion <em>Resource Expansion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Expansion</em>'.
	 * @see com.netxforge.netxstudio.operators.ResourceExpansion
	 * @generated
	 */
	EClass getResourceExpansion();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.operators.ResourceExpansion#getNodeRefs <em>Node Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Node Refs</em>'.
	 * @see com.netxforge.netxstudio.operators.ResourceExpansion#getNodeRefs()
	 * @see #getResourceExpansion()
	 * @generated
	 */
	EReference getResourceExpansion_NodeRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.operators.ResourceExpansion#getEquipmentRefs <em>Equipment Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Equipment Refs</em>'.
	 * @see com.netxforge.netxstudio.operators.ResourceExpansion#getEquipmentRefs()
	 * @see #getResourceExpansion()
	 * @generated
	 */
	EReference getResourceExpansion_EquipmentRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.operators.ResourceExpansion#getFunctionRefs <em>Function Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Function Refs</em>'.
	 * @see com.netxforge.netxstudio.operators.ResourceExpansion#getFunctionRefs()
	 * @see #getResourceExpansion()
	 * @generated
	 */
	EReference getResourceExpansion_FunctionRefs();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.operators.ResourceForecast <em>Resource Forecast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Forecast</em>'.
	 * @see com.netxforge.netxstudio.operators.ResourceForecast
	 * @generated
	 */
	EClass getResourceForecast();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.operators.ResourceForecast#getMarkers <em>Markers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Markers</em>'.
	 * @see com.netxforge.netxstudio.operators.ResourceForecast#getMarkers()
	 * @see #getResourceForecast()
	 * @generated
	 */
	EReference getResourceForecast_Markers();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.operators.ResourceMonitor <em>Resource Monitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Monitor</em>'.
	 * @see com.netxforge.netxstudio.operators.ResourceMonitor
	 * @generated
	 */
	EClass getResourceMonitor();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.operators.ResourceMonitor#getMarkers <em>Markers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Markers</em>'.
	 * @see com.netxforge.netxstudio.operators.ResourceMonitor#getMarkers()
	 * @see #getResourceMonitor()
	 * @generated
	 */
	EReference getResourceMonitor_Markers();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.operators.ResourceMonitor#getNodeRef <em>Node Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node Ref</em>'.
	 * @see com.netxforge.netxstudio.operators.ResourceMonitor#getNodeRef()
	 * @see #getResourceMonitor()
	 * @generated
	 */
	EReference getResourceMonitor_NodeRef();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.operators.ResourceMonitor#getResourceRef <em>Resource Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource Ref</em>'.
	 * @see com.netxforge.netxstudio.operators.ResourceMonitor#getResourceRef()
	 * @see #getResourceMonitor()
	 * @generated
	 */
	EReference getResourceMonitor_ResourceRef();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.operators.ResourceMonitor#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see com.netxforge.netxstudio.operators.ResourceMonitor#getEnd()
	 * @see #getResourceMonitor()
	 * @generated
	 */
	EAttribute getResourceMonitor_End();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.operators.ResourceMonitor#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see com.netxforge.netxstudio.operators.ResourceMonitor#getStart()
	 * @see #getResourceMonitor()
	 * @generated
	 */
	EAttribute getResourceMonitor_Start();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.operators.Warehouse <em>Warehouse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Warehouse</em>'.
	 * @see com.netxforge.netxstudio.operators.Warehouse
	 * @generated
	 */
	EClass getWarehouse();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.operators.Warehouse#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see com.netxforge.netxstudio.operators.Warehouse#getNodes()
	 * @see #getWarehouse()
	 * @generated
	 */
	EReference getWarehouse_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.operators.Warehouse#getEquipments <em>Equipments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Equipments</em>'.
	 * @see com.netxforge.netxstudio.operators.Warehouse#getEquipments()
	 * @see #getWarehouse()
	 * @generated
	 */
	EReference getWarehouse_Equipments();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.operators.Warehouse#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.netxforge.netxstudio.operators.Warehouse#getDescription()
	 * @see #getWarehouse()
	 * @generated
	 */
	EAttribute getWarehouse_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.operators.Warehouse#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.operators.Warehouse#getName()
	 * @see #getWarehouse()
	 * @generated
	 */
	EAttribute getWarehouse_Name();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.operators.MarkerKind <em>Marker Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Marker Kind</em>'.
	 * @see com.netxforge.netxstudio.operators.MarkerKind
	 * @generated
	 */
	EEnum getMarkerKind();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.operators.MarkerKind <em>Marker Kind Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Marker Kind Object</em>'.
	 * @see com.netxforge.netxstudio.operators.MarkerKind
	 * @model instanceClass="com.netxforge.netxstudio.operators.MarkerKind"
	 *        extendedMetaData="name='MarkerKind:Object' baseType='MarkerKind'"
	 * @generated
	 */
	EDataType getMarkerKindObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OperatorsFactory getOperatorsFactory();

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
		 * The meta object literal for the '{@link com.netxforge.netxstudio.operators.impl.EquipmentRelationshipImpl <em>Equipment Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.operators.impl.EquipmentRelationshipImpl
		 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getEquipmentRelationship()
		 * @generated
		 */
		EClass EQUIPMENT_RELATIONSHIP = eINSTANCE.getEquipmentRelationship();

		/**
		 * The meta object literal for the '<em><b>Equipment1 Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF = eINSTANCE.getEquipmentRelationship_Equipment1Ref();

		/**
		 * The meta object literal for the '<em><b>Equipment2 Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF = eINSTANCE.getEquipmentRelationship_Equipment2Ref();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.operators.impl.FunctionRelationshipImpl <em>Function Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.operators.impl.FunctionRelationshipImpl
		 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getFunctionRelationship()
		 * @generated
		 */
		EClass FUNCTION_RELATIONSHIP = eINSTANCE.getFunctionRelationship();

		/**
		 * The meta object literal for the '<em><b>Function1 Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_RELATIONSHIP__FUNCTION1_REF = eINSTANCE.getFunctionRelationship_Function1Ref();

		/**
		 * The meta object literal for the '<em><b>Function2 Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_RELATIONSHIP__FUNCTION2_REF = eINSTANCE.getFunctionRelationship_Function2Ref();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.operators.impl.MarkerImpl <em>Marker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.operators.impl.MarkerImpl
		 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getMarker()
		 * @generated
		 */
		EClass MARKER = eINSTANCE.getMarker();

		/**
		 * The meta object literal for the '<em><b>Component Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKER__COMPONENT_REF = eINSTANCE.getMarker_ComponentRef();

		/**
		 * The meta object literal for the '<em><b>Value Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKER__VALUE_REF = eINSTANCE.getMarker_ValueRef();

		/**
		 * The meta object literal for the '<em><b>Marker Resource Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKER__MARKER_RESOURCE_REF = eINSTANCE.getMarker_MarkerResourceRef();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MARKER__DESCRIPTION = eINSTANCE.getMarker_Description();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MARKER__KIND = eINSTANCE.getMarker_Kind();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.operators.impl.NetworkImpl <em>Network</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.operators.impl.NetworkImpl
		 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getNetwork()
		 * @generated
		 */
		EClass NETWORK = eINSTANCE.getNetwork();

		/**
		 * The meta object literal for the '<em><b>Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__DIAGRAMS = eINSTANCE.getNetwork_Diagrams();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__NODES = eINSTANCE.getNetwork_Nodes();

		/**
		 * The meta object literal for the '<em><b>Networks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__NETWORKS = eINSTANCE.getNetwork_Networks();

		/**
		 * The meta object literal for the '<em><b>Function Relationships</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__FUNCTION_RELATIONSHIPS = eINSTANCE.getNetwork_FunctionRelationships();

		/**
		 * The meta object literal for the '<em><b>Equipment Relationships</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__EQUIPMENT_RELATIONSHIPS = eINSTANCE.getNetwork_EquipmentRelationships();

		/**
		 * The meta object literal for the '<em><b>Metric Sources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__METRIC_SOURCES = eINSTANCE.getNetwork_MetricSources();

		/**
		 * The meta object literal for the '<em><b>Created By Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__CREATED_BY_REF = eINSTANCE.getNetwork_CreatedByRef();

		/**
		 * The meta object literal for the '<em><b>Created Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NETWORK__CREATED_DATE = eINSTANCE.getNetwork_CreatedDate();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NETWORK__DESCRIPTION = eINSTANCE.getNetwork_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NETWORK__NAME = eINSTANCE.getNetwork_Name();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.operators.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.operators.impl.NodeImpl
		 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Lifecycle</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__LIFECYCLE = eINSTANCE.getNode_Lifecycle();

		/**
		 * The meta object literal for the '<em><b>Node Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__NODE_TYPE = eINSTANCE.getNode_NodeType();

		/**
		 * The meta object literal for the '<em><b>Created By Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__CREATED_BY_REF = eINSTANCE.getNode_CreatedByRef();

		/**
		 * The meta object literal for the '<em><b>Location Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__LOCATION_REF = eINSTANCE.getNode_LocationRef();

		/**
		 * The meta object literal for the '<em><b>Node ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NODE_ID = eINSTANCE.getNode_NodeID();

		/**
		 * The meta object literal for the '<em><b>Original Node Type Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__ORIGINAL_NODE_TYPE_REF = eINSTANCE.getNode_OriginalNodeTypeRef();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.operators.impl.OperatorImpl <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.operators.impl.OperatorImpl
		 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getOperator()
		 * @generated
		 */
		EClass OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '<em><b>Networks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__NETWORKS = eINSTANCE.getOperator_Networks();

		/**
		 * The meta object literal for the '<em><b>Warehouses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__WAREHOUSES = eINSTANCE.getOperator_Warehouses();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__SERVICES = eINSTANCE.getOperator_Services();

		/**
		 * The meta object literal for the '<em><b>Service Users</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__SERVICE_USERS = eINSTANCE.getOperator_ServiceUsers();

		/**
		 * The meta object literal for the '<em><b>Resource Expansions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__RESOURCE_EXPANSIONS = eINSTANCE.getOperator_ResourceExpansions();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.operators.impl.RelationshipImpl <em>Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.operators.impl.RelationshipImpl
		 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getRelationship()
		 * @generated
		 */
		EClass RELATIONSHIP = eINSTANCE.getRelationship();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATIONSHIP__NAME = eINSTANCE.getRelationship_Name();

		/**
		 * The meta object literal for the '<em><b>Node ID1 Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONSHIP__NODE_ID1_REF = eINSTANCE.getRelationship_NodeID1Ref();

		/**
		 * The meta object literal for the '<em><b>Node ID2 Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONSHIP__NODE_ID2_REF = eINSTANCE.getRelationship_NodeID2Ref();

		/**
		 * The meta object literal for the '<em><b>Protocol Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONSHIP__PROTOCOL_REF = eINSTANCE.getRelationship_ProtocolRef();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.operators.impl.ResourceExpansionImpl <em>Resource Expansion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.operators.impl.ResourceExpansionImpl
		 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getResourceExpansion()
		 * @generated
		 */
		EClass RESOURCE_EXPANSION = eINSTANCE.getResourceExpansion();

		/**
		 * The meta object literal for the '<em><b>Node Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_EXPANSION__NODE_REFS = eINSTANCE.getResourceExpansion_NodeRefs();

		/**
		 * The meta object literal for the '<em><b>Equipment Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_EXPANSION__EQUIPMENT_REFS = eINSTANCE.getResourceExpansion_EquipmentRefs();

		/**
		 * The meta object literal for the '<em><b>Function Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_EXPANSION__FUNCTION_REFS = eINSTANCE.getResourceExpansion_FunctionRefs();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.operators.impl.ResourceForecastImpl <em>Resource Forecast</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.operators.impl.ResourceForecastImpl
		 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getResourceForecast()
		 * @generated
		 */
		EClass RESOURCE_FORECAST = eINSTANCE.getResourceForecast();

		/**
		 * The meta object literal for the '<em><b>Markers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_FORECAST__MARKERS = eINSTANCE.getResourceForecast_Markers();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.operators.impl.ResourceMonitorImpl <em>Resource Monitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.operators.impl.ResourceMonitorImpl
		 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getResourceMonitor()
		 * @generated
		 */
		EClass RESOURCE_MONITOR = eINSTANCE.getResourceMonitor();

		/**
		 * The meta object literal for the '<em><b>Markers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_MONITOR__MARKERS = eINSTANCE.getResourceMonitor_Markers();

		/**
		 * The meta object literal for the '<em><b>Node Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_MONITOR__NODE_REF = eINSTANCE.getResourceMonitor_NodeRef();

		/**
		 * The meta object literal for the '<em><b>Resource Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_MONITOR__RESOURCE_REF = eINSTANCE.getResourceMonitor_ResourceRef();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_MONITOR__END = eINSTANCE.getResourceMonitor_End();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_MONITOR__START = eINSTANCE.getResourceMonitor_Start();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.operators.impl.WarehouseImpl <em>Warehouse</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.operators.impl.WarehouseImpl
		 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getWarehouse()
		 * @generated
		 */
		EClass WAREHOUSE = eINSTANCE.getWarehouse();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WAREHOUSE__NODES = eINSTANCE.getWarehouse_Nodes();

		/**
		 * The meta object literal for the '<em><b>Equipments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WAREHOUSE__EQUIPMENTS = eINSTANCE.getWarehouse_Equipments();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WAREHOUSE__DESCRIPTION = eINSTANCE.getWarehouse_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WAREHOUSE__NAME = eINSTANCE.getWarehouse_Name();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.operators.MarkerKind <em>Marker Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.operators.MarkerKind
		 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getMarkerKind()
		 * @generated
		 */
		EEnum MARKER_KIND = eINSTANCE.getMarkerKind();

		/**
		 * The meta object literal for the '<em>Marker Kind Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.operators.MarkerKind
		 * @see com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl#getMarkerKindObject()
		 * @generated
		 */
		EDataType MARKER_KIND_OBJECT = eINSTANCE.getMarkerKindObject();

	}

} //OperatorsPackage
