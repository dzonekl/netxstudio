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
 * @see com.netxforge.netxstudio.library.LibraryFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL' invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface LibraryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "library";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.netxforge.com/13042011/library";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "library";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LibraryPackage eINSTANCE = com.netxforge.netxstudio.library.impl.LibraryPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.ComponentImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__RESOURCES = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Metric Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__METRIC_REFS = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Capacity Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__CAPACITY_EXPRESSION_REF = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Utilization Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__UTILIZATION_EXPRESSION_REF = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Retention Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__RETENTION_EXPRESSION_REF = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Tolerance Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__TOLERANCE_REFS = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Protocol Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__PROTOCOL_REFS = GenericsPackage.BASE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Parameter Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__PARAMETER_REFS = GenericsPackage.BASE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>All Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ALL_RESOURCES = GenericsPackage.BASE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__DIAGRAMS = GenericsPackage.BASE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ICONS = GenericsPackage.BASE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__DESCRIPTION = GenericsPackage.BASE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = GenericsPackage.BASE_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 13;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.EquipmentImpl <em>Equipment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.EquipmentImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getEquipment()
	 * @generated
	 */
	int EQUIPMENT = 1;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__DELETED = COMPONENT__DELETED;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__RESOURCES = COMPONENT__RESOURCES;

	/**
	 * The feature id for the '<em><b>Metric Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__METRIC_REFS = COMPONENT__METRIC_REFS;

	/**
	 * The feature id for the '<em><b>Capacity Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__CAPACITY_EXPRESSION_REF = COMPONENT__CAPACITY_EXPRESSION_REF;

	/**
	 * The feature id for the '<em><b>Utilization Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__UTILIZATION_EXPRESSION_REF = COMPONENT__UTILIZATION_EXPRESSION_REF;

	/**
	 * The feature id for the '<em><b>Retention Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__RETENTION_EXPRESSION_REF = COMPONENT__RETENTION_EXPRESSION_REF;

	/**
	 * The feature id for the '<em><b>Tolerance Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__TOLERANCE_REFS = COMPONENT__TOLERANCE_REFS;

	/**
	 * The feature id for the '<em><b>Protocol Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__PROTOCOL_REFS = COMPONENT__PROTOCOL_REFS;

	/**
	 * The feature id for the '<em><b>Parameter Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__PARAMETER_REFS = COMPONENT__PARAMETER_REFS;

	/**
	 * The feature id for the '<em><b>All Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__ALL_RESOURCES = COMPONENT__ALL_RESOURCES;

	/**
	 * The feature id for the '<em><b>Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__DIAGRAMS = COMPONENT__DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__ICONS = COMPONENT__ICONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__DESCRIPTION = COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Lifecycle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__LIFECYCLE = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Equipments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__EQUIPMENTS = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Equipment Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__EQUIPMENT_GROUPS = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Equipment Relationship Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__EQUIPMENT_RELATIONSHIP_REFS = COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>All Equipments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__ALL_EQUIPMENTS = COMPONENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__COUNT = COMPONENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Equipment Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__EQUIPMENT_CODE = COMPONENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__POSITION = COMPONENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Redundancy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__REDUNDANCY = COMPONENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__STATE = COMPONENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Equipment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.EquipmentGroupImpl <em>Equipment Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.EquipmentGroupImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getEquipmentGroup()
	 * @generated
	 */
	int EQUIPMENT_GROUP = 2;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__DIAGRAMS = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Equipment Group Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__EQUIPMENT_GROUP_RESOURCES = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expression Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__EXPRESSION_REFS = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Equipment Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__EQUIPMENT_REFS = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parameter Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__PARAMETER_REFS = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>All Equipment Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__ALL_EQUIPMENT_RESOURCES = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>All Equipments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__ALL_EQUIPMENTS = GenericsPackage.BASE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__COUNT = GenericsPackage.BASE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__DESCRIPTION = GenericsPackage.BASE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__NAME = GenericsPackage.BASE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Equipment Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.ExpressionImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 3;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Expression Lines</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__EXPRESSION_LINES = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Evaluation Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__EVALUATION_OBJECT = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Equipment Group Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__EQUIPMENT_GROUP_REFS = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Service Profile Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__SERVICE_PROFILE_REFS = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__NAME = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.ExpressionResultImpl <em>Expression Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.ExpressionResultImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getExpressionResult()
	 * @generated
	 */
	int EXPRESSION_RESULT = 4;

	/**
	 * The feature id for the '<em><b>Target Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_RESULT__TARGET_RESOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_RESULT__TARGET_RANGE = 1;

	/**
	 * The feature id for the '<em><b>Target Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_RESULT__TARGET_VALUES = 2;

	/**
	 * The feature id for the '<em><b>Target Interval Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_RESULT__TARGET_INTERVAL_HINT = 3;

	/**
	 * The feature id for the '<em><b>Target Kind Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_RESULT__TARGET_KIND_HINT = 4;

	/**
	 * The number of structural features of the '<em>Expression Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_RESULT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.FunctionImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 5;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__DELETED = COMPONENT__DELETED;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__RESOURCES = COMPONENT__RESOURCES;

	/**
	 * The feature id for the '<em><b>Metric Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__METRIC_REFS = COMPONENT__METRIC_REFS;

	/**
	 * The feature id for the '<em><b>Capacity Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__CAPACITY_EXPRESSION_REF = COMPONENT__CAPACITY_EXPRESSION_REF;

	/**
	 * The feature id for the '<em><b>Utilization Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__UTILIZATION_EXPRESSION_REF = COMPONENT__UTILIZATION_EXPRESSION_REF;

	/**
	 * The feature id for the '<em><b>Retention Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__RETENTION_EXPRESSION_REF = COMPONENT__RETENTION_EXPRESSION_REF;

	/**
	 * The feature id for the '<em><b>Tolerance Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__TOLERANCE_REFS = COMPONENT__TOLERANCE_REFS;

	/**
	 * The feature id for the '<em><b>Protocol Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__PROTOCOL_REFS = COMPONENT__PROTOCOL_REFS;

	/**
	 * The feature id for the '<em><b>Parameter Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__PARAMETER_REFS = COMPONENT__PARAMETER_REFS;

	/**
	 * The feature id for the '<em><b>All Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__ALL_RESOURCES = COMPONENT__ALL_RESOURCES;

	/**
	 * The feature id for the '<em><b>Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__DIAGRAMS = COMPONENT__DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__ICONS = COMPONENT__ICONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__DESCRIPTION = COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__FUNCTIONS = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Function Relationship Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__FUNCTION_RELATIONSHIP_REFS = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Functions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__ALL_FUNCTIONS = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.LibraryImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 6;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__FUNCTIONS = 0;

	/**
	 * The feature id for the '<em><b>Node Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NODE_TYPES = 1;

	/**
	 * The feature id for the '<em><b>Equipments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EQUIPMENTS = 2;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__METRICS = 3;

	/**
	 * The feature id for the '<em><b>Metric Sources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__METRIC_SOURCES = 4;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__PARAMETERS = 5;

	/**
	 * The feature id for the '<em><b>Protocols</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__PROTOCOLS = 6;

	/**
	 * The feature id for the '<em><b>Tolerances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__TOLERANCES = 7;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EXPRESSIONS = 8;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__UNITS = 9;

	/**
	 * The feature id for the '<em><b>Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__VERSION = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NAME = 11;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = 12;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl <em>Net XResource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.NetXResourceImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getNetXResource()
	 * @generated
	 */
	int NET_XRESOURCE = 7;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Metric Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__METRIC_REF = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Metric Value Ranges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__METRIC_VALUE_RANGES = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Capacity Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__CAPACITY_VALUES = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Utilization Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__UTILIZATION_VALUES = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Forecast Capacity Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__FORECAST_CAPACITY_VALUES = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Forecast Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__FORECAST_VALUES = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Trended Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__TRENDED_VALUES = GenericsPackage.BASE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Detail Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__DETAIL_DISPLAY = GenericsPackage.BASE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Expression Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__EXPRESSION_NAME = GenericsPackage.BASE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__LONG_NAME = GenericsPackage.BASE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__SHORT_NAME = GenericsPackage.BASE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Summary Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__SUMMARY_DISPLAY = GenericsPackage.BASE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Unit Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__UNIT_REF = GenericsPackage.BASE_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Net XResource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 13;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.NodeTypeImpl <em>Node Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.NodeTypeImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getNodeType()
	 * @generated
	 */
	int NODE_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__FUNCTIONS = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Equipments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__EQUIPMENTS = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Leaf Node</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__LEAF_NODE = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.ParameterImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 9;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DESCRIPTION = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__EXPRESSION_NAME = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__MODIFIABLE = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VALUE = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.ProductInfoImpl <em>Product Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.ProductInfoImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getProductInfo()
	 * @generated
	 */
	int PRODUCT_INFO = 10;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Equipment Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__EQUIPMENT_REF = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Licensed Function Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__LICENSED_FUNCTION_REF = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Node Type Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__NODE_TYPE_REF = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Available Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__AVAILABLE_DATE = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>End Of Sales Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__END_OF_SALES_DATE = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>End Of Support Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__END_OF_SUPPORT_DATE = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Product Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__PRODUCT_CODE = GenericsPackage.BASE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Sales Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__SALES_CODE = GenericsPackage.BASE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Under Development Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__UNDER_DEVELOPMENT_DATE = GenericsPackage.BASE_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Product Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.ToleranceImpl <em>Tolerance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.ToleranceImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getTolerance()
	 * @generated
	 */
	int TOLERANCE = 11;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOLERANCE__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOLERANCE__EXPRESSION_REF = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOLERANCE__LEVEL = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOLERANCE__NAME = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Tolerance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOLERANCE_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.UnitImpl <em>Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.UnitImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getUnit()
	 * @generated
	 */
	int UNIT = 12;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__ICONS = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__CODE = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__DESCRIPTION = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__NAME = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.VendorImpl <em>Vendor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.VendorImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getVendor()
	 * @generated
	 */
	int VENDOR = 13;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VENDOR__DELETED = GenericsPackage.COMPANY__DELETED;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VENDOR__ICONS = GenericsPackage.COMPANY__ICONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VENDOR__NAME = GenericsPackage.COMPANY__NAME;

	/**
	 * The feature id for the '<em><b>RS Surl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VENDOR__RS_SURL = GenericsPackage.COMPANY__RS_SURL;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VENDOR__SHORT_NAME = GenericsPackage.COMPANY__SHORT_NAME;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VENDOR__SYMBOL = GenericsPackage.COMPANY__SYMBOL;

	/**
	 * The feature id for the '<em><b>Website</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VENDOR__WEBSITE = GenericsPackage.COMPANY__WEBSITE;

	/**
	 * The feature id for the '<em><b>Products</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VENDOR__PRODUCTS = GenericsPackage.COMPANY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Vendor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VENDOR_FEATURE_COUNT = GenericsPackage.COMPANY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.LevelType <em>Level Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.LevelType
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getLevelType()
	 * @generated
	 */
	int LEVEL_TYPE = 14;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.RangeKind <em>Range Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.RangeKind
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getRangeKind()
	 * @generated
	 */
	int RANGE_KIND = 15;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.RedundancyType <em>Redundancy Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.RedundancyType
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getRedundancyType()
	 * @generated
	 */
	int REDUNDANCY_TYPE = 16;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.StateType <em>State Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.StateType
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getStateType()
	 * @generated
	 */
	int STATE_TYPE = 17;

	/**
	 * The meta object id for the '<em>Level Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.LevelType
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getLevelTypeObject()
	 * @generated
	 */
	int LEVEL_TYPE_OBJECT = 18;

	/**
	 * The meta object id for the '<em>Range Kind Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.RangeKind
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getRangeKindObject()
	 * @generated
	 */
	int RANGE_KIND_OBJECT = 19;

	/**
	 * The meta object id for the '<em>Redundancy Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.RedundancyType
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getRedundancyTypeObject()
	 * @generated
	 */
	int REDUNDANCY_TYPE_OBJECT = 20;

	/**
	 * The meta object id for the '<em>State Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.StateType
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getStateTypeObject()
	 * @generated
	 */
	int STATE_TYPE_OBJECT = 21;


	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.library.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see com.netxforge.netxstudio.library.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Component#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see com.netxforge.netxstudio.library.Component#getResources()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Resources();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Component#getMetricRefs <em>Metric Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Metric Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Component#getMetricRefs()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_MetricRefs();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.library.Component#getCapacityExpressionRef <em>Capacity Expression Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Capacity Expression Ref</em>'.
	 * @see com.netxforge.netxstudio.library.Component#getCapacityExpressionRef()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_CapacityExpressionRef();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.library.Component#getUtilizationExpressionRef <em>Utilization Expression Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Utilization Expression Ref</em>'.
	 * @see com.netxforge.netxstudio.library.Component#getUtilizationExpressionRef()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_UtilizationExpressionRef();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.library.Component#getRetentionExpressionRef <em>Retention Expression Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Retention Expression Ref</em>'.
	 * @see com.netxforge.netxstudio.library.Component#getRetentionExpressionRef()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_RetentionExpressionRef();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Component#getToleranceRefs <em>Tolerance Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tolerance Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Component#getToleranceRefs()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_ToleranceRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Component#getProtocolRefs <em>Protocol Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Protocol Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Component#getProtocolRefs()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_ProtocolRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Component#getParameterRefs <em>Parameter Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameter Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Component#getParameterRefs()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_ParameterRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Component#getAllResources <em>All Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Resources</em>'.
	 * @see com.netxforge.netxstudio.library.Component#getAllResources()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_AllResources();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Component#getDiagrams <em>Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Diagrams</em>'.
	 * @see com.netxforge.netxstudio.library.Component#getDiagrams()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Diagrams();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.library.Component#getIcons <em>Icons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Icons</em>'.
	 * @see com.netxforge.netxstudio.library.Component#getIcons()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Icons();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Component#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.netxforge.netxstudio.library.Component#getDescription()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Component#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.library.Component#getName()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Name();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.library.Equipment <em>Equipment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equipment</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment
	 * @generated
	 */
	EClass getEquipment();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.library.Equipment#getLifecycle <em>Lifecycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lifecycle</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getLifecycle()
	 * @see #getEquipment()
	 * @generated
	 */
	EReference getEquipment_Lifecycle();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Equipment#getEquipments <em>Equipments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Equipments</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getEquipments()
	 * @see #getEquipment()
	 * @generated
	 */
	EReference getEquipment_Equipments();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Equipment#getEquipmentGroups <em>Equipment Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Equipment Groups</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getEquipmentGroups()
	 * @see #getEquipment()
	 * @generated
	 */
	EReference getEquipment_EquipmentGroups();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Equipment#getEquipmentRelationshipRefs <em>Equipment Relationship Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Equipment Relationship Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getEquipmentRelationshipRefs()
	 * @see #getEquipment()
	 * @generated
	 */
	EReference getEquipment_EquipmentRelationshipRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Equipment#getAllEquipments <em>All Equipments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Equipments</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getAllEquipments()
	 * @see #getEquipment()
	 * @generated
	 */
	EReference getEquipment_AllEquipments();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Equipment#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getCount()
	 * @see #getEquipment()
	 * @generated
	 */
	EAttribute getEquipment_Count();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Equipment#getEquipmentCode <em>Equipment Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Equipment Code</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getEquipmentCode()
	 * @see #getEquipment()
	 * @generated
	 */
	EAttribute getEquipment_EquipmentCode();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Equipment#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getPosition()
	 * @see #getEquipment()
	 * @generated
	 */
	EAttribute getEquipment_Position();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Equipment#getRedundancy <em>Redundancy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Redundancy</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getRedundancy()
	 * @see #getEquipment()
	 * @generated
	 */
	EAttribute getEquipment_Redundancy();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Equipment#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getState()
	 * @see #getEquipment()
	 * @generated
	 */
	EAttribute getEquipment_State();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.library.EquipmentGroup <em>Equipment Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equipment Group</em>'.
	 * @see com.netxforge.netxstudio.library.EquipmentGroup
	 * @generated
	 */
	EClass getEquipmentGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.EquipmentGroup#getDiagrams <em>Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Diagrams</em>'.
	 * @see com.netxforge.netxstudio.library.EquipmentGroup#getDiagrams()
	 * @see #getEquipmentGroup()
	 * @generated
	 */
	EReference getEquipmentGroup_Diagrams();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.EquipmentGroup#getEquipmentGroupResources <em>Equipment Group Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Equipment Group Resources</em>'.
	 * @see com.netxforge.netxstudio.library.EquipmentGroup#getEquipmentGroupResources()
	 * @see #getEquipmentGroup()
	 * @generated
	 */
	EReference getEquipmentGroup_EquipmentGroupResources();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.EquipmentGroup#getExpressionRefs <em>Expression Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Expression Refs</em>'.
	 * @see com.netxforge.netxstudio.library.EquipmentGroup#getExpressionRefs()
	 * @see #getEquipmentGroup()
	 * @generated
	 */
	EReference getEquipmentGroup_ExpressionRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.EquipmentGroup#getEquipmentRefs <em>Equipment Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Equipment Refs</em>'.
	 * @see com.netxforge.netxstudio.library.EquipmentGroup#getEquipmentRefs()
	 * @see #getEquipmentGroup()
	 * @generated
	 */
	EReference getEquipmentGroup_EquipmentRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.EquipmentGroup#getParameterRefs <em>Parameter Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameter Refs</em>'.
	 * @see com.netxforge.netxstudio.library.EquipmentGroup#getParameterRefs()
	 * @see #getEquipmentGroup()
	 * @generated
	 */
	EReference getEquipmentGroup_ParameterRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.EquipmentGroup#getAllEquipmentResources <em>All Equipment Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Equipment Resources</em>'.
	 * @see com.netxforge.netxstudio.library.EquipmentGroup#getAllEquipmentResources()
	 * @see #getEquipmentGroup()
	 * @generated
	 */
	EReference getEquipmentGroup_AllEquipmentResources();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.EquipmentGroup#getAllEquipments <em>All Equipments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Equipments</em>'.
	 * @see com.netxforge.netxstudio.library.EquipmentGroup#getAllEquipments()
	 * @see #getEquipmentGroup()
	 * @generated
	 */
	EReference getEquipmentGroup_AllEquipments();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.EquipmentGroup#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see com.netxforge.netxstudio.library.EquipmentGroup#getCount()
	 * @see #getEquipmentGroup()
	 * @generated
	 */
	EAttribute getEquipmentGroup_Count();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.EquipmentGroup#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.netxforge.netxstudio.library.EquipmentGroup#getDescription()
	 * @see #getEquipmentGroup()
	 * @generated
	 */
	EAttribute getEquipmentGroup_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.EquipmentGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.library.EquipmentGroup#getName()
	 * @see #getEquipmentGroup()
	 * @generated
	 */
	EAttribute getEquipmentGroup_Name();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.library.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see com.netxforge.netxstudio.library.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for the attribute list '{@link com.netxforge.netxstudio.library.Expression#getExpressionLines <em>Expression Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Expression Lines</em>'.
	 * @see com.netxforge.netxstudio.library.Expression#getExpressionLines()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_ExpressionLines();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.library.Expression#getEvaluationObject <em>Evaluation Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Evaluation Object</em>'.
	 * @see com.netxforge.netxstudio.library.Expression#getEvaluationObject()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_EvaluationObject();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Expression#getEquipmentGroupRefs <em>Equipment Group Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Equipment Group Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Expression#getEquipmentGroupRefs()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_EquipmentGroupRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Expression#getServiceProfileRefs <em>Service Profile Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Service Profile Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Expression#getServiceProfileRefs()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_ServiceProfileRefs();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Expression#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.library.Expression#getName()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_Name();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.library.ExpressionResult <em>Expression Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Result</em>'.
	 * @see com.netxforge.netxstudio.library.ExpressionResult
	 * @generated
	 */
	EClass getExpressionResult();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetResource <em>Target Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Resource</em>'.
	 * @see com.netxforge.netxstudio.library.ExpressionResult#getTargetResource()
	 * @see #getExpressionResult()
	 * @generated
	 */
	EReference getExpressionResult_TargetResource();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetRange <em>Target Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Range</em>'.
	 * @see com.netxforge.netxstudio.library.ExpressionResult#getTargetRange()
	 * @see #getExpressionResult()
	 * @generated
	 */
	EAttribute getExpressionResult_TargetRange();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetValues <em>Target Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target Values</em>'.
	 * @see com.netxforge.netxstudio.library.ExpressionResult#getTargetValues()
	 * @see #getExpressionResult()
	 * @generated
	 */
	EReference getExpressionResult_TargetValues();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetIntervalHint <em>Target Interval Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Interval Hint</em>'.
	 * @see com.netxforge.netxstudio.library.ExpressionResult#getTargetIntervalHint()
	 * @see #getExpressionResult()
	 * @generated
	 */
	EAttribute getExpressionResult_TargetIntervalHint();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.ExpressionResult#getTargetKindHint <em>Target Kind Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Kind Hint</em>'.
	 * @see com.netxforge.netxstudio.library.ExpressionResult#getTargetKindHint()
	 * @see #getExpressionResult()
	 * @generated
	 */
	EAttribute getExpressionResult_TargetKindHint();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.library.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see com.netxforge.netxstudio.library.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Function#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functions</em>'.
	 * @see com.netxforge.netxstudio.library.Function#getFunctions()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Functions();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Function#getFunctionRelationshipRefs <em>Function Relationship Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Function Relationship Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Function#getFunctionRelationshipRefs()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_FunctionRelationshipRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Function#getAllFunctions <em>All Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Functions</em>'.
	 * @see com.netxforge.netxstudio.library.Function#getAllFunctions()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_AllFunctions();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.library.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see com.netxforge.netxstudio.library.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Library#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functions</em>'.
	 * @see com.netxforge.netxstudio.library.Library#getFunctions()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Functions();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Library#getNodeTypes <em>Node Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Node Types</em>'.
	 * @see com.netxforge.netxstudio.library.Library#getNodeTypes()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_NodeTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Library#getEquipments <em>Equipments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Equipments</em>'.
	 * @see com.netxforge.netxstudio.library.Library#getEquipments()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Equipments();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Library#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metrics</em>'.
	 * @see com.netxforge.netxstudio.library.Library#getMetrics()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Metrics();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Library#getMetricSources <em>Metric Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metric Sources</em>'.
	 * @see com.netxforge.netxstudio.library.Library#getMetricSources()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_MetricSources();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Library#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see com.netxforge.netxstudio.library.Library#getParameters()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Parameters();

	/**
	 * Returns the meta object for the attribute list '{@link com.netxforge.netxstudio.library.Library#getProtocols <em>Protocols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Protocols</em>'.
	 * @see com.netxforge.netxstudio.library.Library#getProtocols()
	 * @see #getLibrary()
	 * @generated
	 */
	EAttribute getLibrary_Protocols();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Library#getTolerances <em>Tolerances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tolerances</em>'.
	 * @see com.netxforge.netxstudio.library.Library#getTolerances()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Tolerances();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Library#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see com.netxforge.netxstudio.library.Library#getExpressions()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Expressions();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Library#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Units</em>'.
	 * @see com.netxforge.netxstudio.library.Library#getUnits()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Units();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.library.Library#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Version</em>'.
	 * @see com.netxforge.netxstudio.library.Library#getVersion()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Version();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Library#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.library.Library#getName()
	 * @see #getLibrary()
	 * @generated
	 */
	EAttribute getLibrary_Name();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.library.NetXResource <em>Net XResource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Net XResource</em>'.
	 * @see com.netxforge.netxstudio.library.NetXResource
	 * @generated
	 */
	EClass getNetXResource();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.library.NetXResource#getMetricRef <em>Metric Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metric Ref</em>'.
	 * @see com.netxforge.netxstudio.library.NetXResource#getMetricRef()
	 * @see #getNetXResource()
	 * @generated
	 */
	EReference getNetXResource_MetricRef();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.NetXResource#getMetricValueRanges <em>Metric Value Ranges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metric Value Ranges</em>'.
	 * @see com.netxforge.netxstudio.library.NetXResource#getMetricValueRanges()
	 * @see #getNetXResource()
	 * @generated
	 */
	EReference getNetXResource_MetricValueRanges();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.NetXResource#getCapacityValues <em>Capacity Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Capacity Values</em>'.
	 * @see com.netxforge.netxstudio.library.NetXResource#getCapacityValues()
	 * @see #getNetXResource()
	 * @generated
	 */
	EReference getNetXResource_CapacityValues();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.NetXResource#getUtilizationValues <em>Utilization Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Utilization Values</em>'.
	 * @see com.netxforge.netxstudio.library.NetXResource#getUtilizationValues()
	 * @see #getNetXResource()
	 * @generated
	 */
	EReference getNetXResource_UtilizationValues();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.NetXResource#getForecastCapacityValues <em>Forecast Capacity Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Forecast Capacity Values</em>'.
	 * @see com.netxforge.netxstudio.library.NetXResource#getForecastCapacityValues()
	 * @see #getNetXResource()
	 * @generated
	 */
	EReference getNetXResource_ForecastCapacityValues();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.NetXResource#getForecastValues <em>Forecast Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Forecast Values</em>'.
	 * @see com.netxforge.netxstudio.library.NetXResource#getForecastValues()
	 * @see #getNetXResource()
	 * @generated
	 */
	EReference getNetXResource_ForecastValues();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.NetXResource#getTrendedValues <em>Trended Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Trended Values</em>'.
	 * @see com.netxforge.netxstudio.library.NetXResource#getTrendedValues()
	 * @see #getNetXResource()
	 * @generated
	 */
	EReference getNetXResource_TrendedValues();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.NetXResource#isDetailDisplay <em>Detail Display</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Detail Display</em>'.
	 * @see com.netxforge.netxstudio.library.NetXResource#isDetailDisplay()
	 * @see #getNetXResource()
	 * @generated
	 */
	EAttribute getNetXResource_DetailDisplay();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.NetXResource#getExpressionName <em>Expression Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression Name</em>'.
	 * @see com.netxforge.netxstudio.library.NetXResource#getExpressionName()
	 * @see #getNetXResource()
	 * @generated
	 */
	EAttribute getNetXResource_ExpressionName();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.NetXResource#getLongName <em>Long Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Long Name</em>'.
	 * @see com.netxforge.netxstudio.library.NetXResource#getLongName()
	 * @see #getNetXResource()
	 * @generated
	 */
	EAttribute getNetXResource_LongName();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.NetXResource#getShortName <em>Short Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Short Name</em>'.
	 * @see com.netxforge.netxstudio.library.NetXResource#getShortName()
	 * @see #getNetXResource()
	 * @generated
	 */
	EAttribute getNetXResource_ShortName();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.NetXResource#isSummaryDisplay <em>Summary Display</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Summary Display</em>'.
	 * @see com.netxforge.netxstudio.library.NetXResource#isSummaryDisplay()
	 * @see #getNetXResource()
	 * @generated
	 */
	EAttribute getNetXResource_SummaryDisplay();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.library.NetXResource#getUnitRef <em>Unit Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unit Ref</em>'.
	 * @see com.netxforge.netxstudio.library.NetXResource#getUnitRef()
	 * @see #getNetXResource()
	 * @generated
	 */
	EReference getNetXResource_UnitRef();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.library.NodeType <em>Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Type</em>'.
	 * @see com.netxforge.netxstudio.library.NodeType
	 * @generated
	 */
	EClass getNodeType();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.NodeType#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functions</em>'.
	 * @see com.netxforge.netxstudio.library.NodeType#getFunctions()
	 * @see #getNodeType()
	 * @generated
	 */
	EReference getNodeType_Functions();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.NodeType#getEquipments <em>Equipments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Equipments</em>'.
	 * @see com.netxforge.netxstudio.library.NodeType#getEquipments()
	 * @see #getNodeType()
	 * @generated
	 */
	EReference getNodeType_Equipments();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.NodeType#isLeafNode <em>Leaf Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Leaf Node</em>'.
	 * @see com.netxforge.netxstudio.library.NodeType#isLeafNode()
	 * @see #getNodeType()
	 * @generated
	 */
	EAttribute getNodeType_LeafNode();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.library.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see com.netxforge.netxstudio.library.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Parameter#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.netxforge.netxstudio.library.Parameter#getDescription()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Parameter#getExpressionName <em>Expression Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression Name</em>'.
	 * @see com.netxforge.netxstudio.library.Parameter#getExpressionName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_ExpressionName();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Parameter#isModifiable <em>Modifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modifiable</em>'.
	 * @see com.netxforge.netxstudio.library.Parameter#isModifiable()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Modifiable();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.library.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Parameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.netxforge.netxstudio.library.Parameter#getValue()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Value();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.library.ProductInfo <em>Product Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Product Info</em>'.
	 * @see com.netxforge.netxstudio.library.ProductInfo
	 * @generated
	 */
	EClass getProductInfo();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.ProductInfo#getEquipmentRef <em>Equipment Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Equipment Ref</em>'.
	 * @see com.netxforge.netxstudio.library.ProductInfo#getEquipmentRef()
	 * @see #getProductInfo()
	 * @generated
	 */
	EReference getProductInfo_EquipmentRef();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.ProductInfo#getLicensedFunctionRef <em>Licensed Function Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Licensed Function Ref</em>'.
	 * @see com.netxforge.netxstudio.library.ProductInfo#getLicensedFunctionRef()
	 * @see #getProductInfo()
	 * @generated
	 */
	EReference getProductInfo_LicensedFunctionRef();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.ProductInfo#getNodeTypeRef <em>Node Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Node Type Ref</em>'.
	 * @see com.netxforge.netxstudio.library.ProductInfo#getNodeTypeRef()
	 * @see #getProductInfo()
	 * @generated
	 */
	EReference getProductInfo_NodeTypeRef();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.ProductInfo#getAvailableDate <em>Available Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Available Date</em>'.
	 * @see com.netxforge.netxstudio.library.ProductInfo#getAvailableDate()
	 * @see #getProductInfo()
	 * @generated
	 */
	EAttribute getProductInfo_AvailableDate();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.ProductInfo#getEndOfSalesDate <em>End Of Sales Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Of Sales Date</em>'.
	 * @see com.netxforge.netxstudio.library.ProductInfo#getEndOfSalesDate()
	 * @see #getProductInfo()
	 * @generated
	 */
	EAttribute getProductInfo_EndOfSalesDate();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.ProductInfo#getEndOfSupportDate <em>End Of Support Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Of Support Date</em>'.
	 * @see com.netxforge.netxstudio.library.ProductInfo#getEndOfSupportDate()
	 * @see #getProductInfo()
	 * @generated
	 */
	EAttribute getProductInfo_EndOfSupportDate();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.ProductInfo#getProductCode <em>Product Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product Code</em>'.
	 * @see com.netxforge.netxstudio.library.ProductInfo#getProductCode()
	 * @see #getProductInfo()
	 * @generated
	 */
	EAttribute getProductInfo_ProductCode();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.ProductInfo#getSalesCode <em>Sales Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sales Code</em>'.
	 * @see com.netxforge.netxstudio.library.ProductInfo#getSalesCode()
	 * @see #getProductInfo()
	 * @generated
	 */
	EAttribute getProductInfo_SalesCode();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.ProductInfo#getUnderDevelopmentDate <em>Under Development Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Under Development Date</em>'.
	 * @see com.netxforge.netxstudio.library.ProductInfo#getUnderDevelopmentDate()
	 * @see #getProductInfo()
	 * @generated
	 */
	EAttribute getProductInfo_UnderDevelopmentDate();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.library.Tolerance <em>Tolerance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tolerance</em>'.
	 * @see com.netxforge.netxstudio.library.Tolerance
	 * @generated
	 */
	EClass getTolerance();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.library.Tolerance#getExpressionRef <em>Expression Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression Ref</em>'.
	 * @see com.netxforge.netxstudio.library.Tolerance#getExpressionRef()
	 * @see #getTolerance()
	 * @generated
	 */
	EReference getTolerance_ExpressionRef();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Tolerance#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see com.netxforge.netxstudio.library.Tolerance#getLevel()
	 * @see #getTolerance()
	 * @generated
	 */
	EAttribute getTolerance_Level();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Tolerance#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.library.Tolerance#getName()
	 * @see #getTolerance()
	 * @generated
	 */
	EAttribute getTolerance_Name();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.library.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit</em>'.
	 * @see com.netxforge.netxstudio.library.Unit
	 * @generated
	 */
	EClass getUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.library.Unit#getIcons <em>Icons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Icons</em>'.
	 * @see com.netxforge.netxstudio.library.Unit#getIcons()
	 * @see #getUnit()
	 * @generated
	 */
	EReference getUnit_Icons();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Unit#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.netxforge.netxstudio.library.Unit#getCode()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Unit#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.netxforge.netxstudio.library.Unit#getDescription()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Unit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.library.Unit#getName()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_Name();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.library.Vendor <em>Vendor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vendor</em>'.
	 * @see com.netxforge.netxstudio.library.Vendor
	 * @generated
	 */
	EClass getVendor();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Vendor#getProducts <em>Products</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Products</em>'.
	 * @see com.netxforge.netxstudio.library.Vendor#getProducts()
	 * @see #getVendor()
	 * @generated
	 */
	EReference getVendor_Products();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.library.LevelType <em>Level Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Level Type</em>'.
	 * @see com.netxforge.netxstudio.library.LevelType
	 * @generated
	 */
	EEnum getLevelType();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.library.RangeKind <em>Range Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Range Kind</em>'.
	 * @see com.netxforge.netxstudio.library.RangeKind
	 * @generated
	 */
	EEnum getRangeKind();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.library.RedundancyType <em>Redundancy Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Redundancy Type</em>'.
	 * @see com.netxforge.netxstudio.library.RedundancyType
	 * @generated
	 */
	EEnum getRedundancyType();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.library.StateType <em>State Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>State Type</em>'.
	 * @see com.netxforge.netxstudio.library.StateType
	 * @generated
	 */
	EEnum getStateType();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.library.LevelType <em>Level Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Level Type Object</em>'.
	 * @see com.netxforge.netxstudio.library.LevelType
	 * @model instanceClass="com.netxforge.netxstudio.library.LevelType"
	 *        extendedMetaData="name='Level_._type:Object' baseType='Level_._type'"
	 * @generated
	 */
	EDataType getLevelTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.library.RangeKind <em>Range Kind Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Range Kind Object</em>'.
	 * @see com.netxforge.netxstudio.library.RangeKind
	 * @model instanceClass="com.netxforge.netxstudio.library.RangeKind"
	 *        extendedMetaData="name='RangeKind:Object' baseType='RangeKind'"
	 * @generated
	 */
	EDataType getRangeKindObject();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.library.RedundancyType <em>Redundancy Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Redundancy Type Object</em>'.
	 * @see com.netxforge.netxstudio.library.RedundancyType
	 * @model instanceClass="com.netxforge.netxstudio.library.RedundancyType"
	 *        extendedMetaData="name='Redundancy_._type:Object' baseType='Redundancy_._type'"
	 * @generated
	 */
	EDataType getRedundancyTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.library.StateType <em>State Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>State Type Object</em>'.
	 * @see com.netxforge.netxstudio.library.StateType
	 * @model instanceClass="com.netxforge.netxstudio.library.StateType"
	 *        extendedMetaData="name='State_._type:Object' baseType='State_._type'"
	 * @generated
	 */
	EDataType getStateTypeObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LibraryFactory getLibraryFactory();

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
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.impl.ComponentImpl
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__RESOURCES = eINSTANCE.getComponent_Resources();

		/**
		 * The meta object literal for the '<em><b>Metric Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__METRIC_REFS = eINSTANCE.getComponent_MetricRefs();

		/**
		 * The meta object literal for the '<em><b>Capacity Expression Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__CAPACITY_EXPRESSION_REF = eINSTANCE.getComponent_CapacityExpressionRef();

		/**
		 * The meta object literal for the '<em><b>Utilization Expression Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__UTILIZATION_EXPRESSION_REF = eINSTANCE.getComponent_UtilizationExpressionRef();

		/**
		 * The meta object literal for the '<em><b>Retention Expression Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__RETENTION_EXPRESSION_REF = eINSTANCE.getComponent_RetentionExpressionRef();

		/**
		 * The meta object literal for the '<em><b>Tolerance Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__TOLERANCE_REFS = eINSTANCE.getComponent_ToleranceRefs();

		/**
		 * The meta object literal for the '<em><b>Protocol Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__PROTOCOL_REFS = eINSTANCE.getComponent_ProtocolRefs();

		/**
		 * The meta object literal for the '<em><b>Parameter Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__PARAMETER_REFS = eINSTANCE.getComponent_ParameterRefs();

		/**
		 * The meta object literal for the '<em><b>All Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__ALL_RESOURCES = eINSTANCE.getComponent_AllResources();

		/**
		 * The meta object literal for the '<em><b>Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__DIAGRAMS = eINSTANCE.getComponent_Diagrams();

		/**
		 * The meta object literal for the '<em><b>Icons</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__ICONS = eINSTANCE.getComponent_Icons();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__DESCRIPTION = eINSTANCE.getComponent_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__NAME = eINSTANCE.getComponent_Name();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.impl.EquipmentImpl <em>Equipment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.impl.EquipmentImpl
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getEquipment()
		 * @generated
		 */
		EClass EQUIPMENT = eINSTANCE.getEquipment();

		/**
		 * The meta object literal for the '<em><b>Lifecycle</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT__LIFECYCLE = eINSTANCE.getEquipment_Lifecycle();

		/**
		 * The meta object literal for the '<em><b>Equipments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT__EQUIPMENTS = eINSTANCE.getEquipment_Equipments();

		/**
		 * The meta object literal for the '<em><b>Equipment Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT__EQUIPMENT_GROUPS = eINSTANCE.getEquipment_EquipmentGroups();

		/**
		 * The meta object literal for the '<em><b>Equipment Relationship Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT__EQUIPMENT_RELATIONSHIP_REFS = eINSTANCE.getEquipment_EquipmentRelationshipRefs();

		/**
		 * The meta object literal for the '<em><b>All Equipments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT__ALL_EQUIPMENTS = eINSTANCE.getEquipment_AllEquipments();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIPMENT__COUNT = eINSTANCE.getEquipment_Count();

		/**
		 * The meta object literal for the '<em><b>Equipment Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIPMENT__EQUIPMENT_CODE = eINSTANCE.getEquipment_EquipmentCode();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIPMENT__POSITION = eINSTANCE.getEquipment_Position();

		/**
		 * The meta object literal for the '<em><b>Redundancy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIPMENT__REDUNDANCY = eINSTANCE.getEquipment_Redundancy();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIPMENT__STATE = eINSTANCE.getEquipment_State();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.impl.EquipmentGroupImpl <em>Equipment Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.impl.EquipmentGroupImpl
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getEquipmentGroup()
		 * @generated
		 */
		EClass EQUIPMENT_GROUP = eINSTANCE.getEquipmentGroup();

		/**
		 * The meta object literal for the '<em><b>Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT_GROUP__DIAGRAMS = eINSTANCE.getEquipmentGroup_Diagrams();

		/**
		 * The meta object literal for the '<em><b>Equipment Group Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT_GROUP__EQUIPMENT_GROUP_RESOURCES = eINSTANCE.getEquipmentGroup_EquipmentGroupResources();

		/**
		 * The meta object literal for the '<em><b>Expression Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT_GROUP__EXPRESSION_REFS = eINSTANCE.getEquipmentGroup_ExpressionRefs();

		/**
		 * The meta object literal for the '<em><b>Equipment Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT_GROUP__EQUIPMENT_REFS = eINSTANCE.getEquipmentGroup_EquipmentRefs();

		/**
		 * The meta object literal for the '<em><b>Parameter Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT_GROUP__PARAMETER_REFS = eINSTANCE.getEquipmentGroup_ParameterRefs();

		/**
		 * The meta object literal for the '<em><b>All Equipment Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT_GROUP__ALL_EQUIPMENT_RESOURCES = eINSTANCE.getEquipmentGroup_AllEquipmentResources();

		/**
		 * The meta object literal for the '<em><b>All Equipments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT_GROUP__ALL_EQUIPMENTS = eINSTANCE.getEquipmentGroup_AllEquipments();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIPMENT_GROUP__COUNT = eINSTANCE.getEquipmentGroup_Count();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIPMENT_GROUP__DESCRIPTION = eINSTANCE.getEquipmentGroup_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIPMENT_GROUP__NAME = eINSTANCE.getEquipmentGroup_Name();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.impl.ExpressionImpl
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '<em><b>Expression Lines</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__EXPRESSION_LINES = eINSTANCE.getExpression_ExpressionLines();

		/**
		 * The meta object literal for the '<em><b>Evaluation Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__EVALUATION_OBJECT = eINSTANCE.getExpression_EvaluationObject();

		/**
		 * The meta object literal for the '<em><b>Equipment Group Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__EQUIPMENT_GROUP_REFS = eINSTANCE.getExpression_EquipmentGroupRefs();

		/**
		 * The meta object literal for the '<em><b>Service Profile Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__SERVICE_PROFILE_REFS = eINSTANCE.getExpression_ServiceProfileRefs();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__NAME = eINSTANCE.getExpression_Name();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.impl.ExpressionResultImpl <em>Expression Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.impl.ExpressionResultImpl
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getExpressionResult()
		 * @generated
		 */
		EClass EXPRESSION_RESULT = eINSTANCE.getExpressionResult();

		/**
		 * The meta object literal for the '<em><b>Target Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_RESULT__TARGET_RESOURCE = eINSTANCE.getExpressionResult_TargetResource();

		/**
		 * The meta object literal for the '<em><b>Target Range</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_RESULT__TARGET_RANGE = eINSTANCE.getExpressionResult_TargetRange();

		/**
		 * The meta object literal for the '<em><b>Target Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_RESULT__TARGET_VALUES = eINSTANCE.getExpressionResult_TargetValues();

		/**
		 * The meta object literal for the '<em><b>Target Interval Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_RESULT__TARGET_INTERVAL_HINT = eINSTANCE.getExpressionResult_TargetIntervalHint();

		/**
		 * The meta object literal for the '<em><b>Target Kind Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_RESULT__TARGET_KIND_HINT = eINSTANCE.getExpressionResult_TargetKindHint();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.impl.FunctionImpl
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__FUNCTIONS = eINSTANCE.getFunction_Functions();

		/**
		 * The meta object literal for the '<em><b>Function Relationship Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__FUNCTION_RELATIONSHIP_REFS = eINSTANCE.getFunction_FunctionRelationshipRefs();

		/**
		 * The meta object literal for the '<em><b>All Functions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__ALL_FUNCTIONS = eINSTANCE.getFunction_AllFunctions();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.impl.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.impl.LibraryImpl
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__FUNCTIONS = eINSTANCE.getLibrary_Functions();

		/**
		 * The meta object literal for the '<em><b>Node Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__NODE_TYPES = eINSTANCE.getLibrary_NodeTypes();

		/**
		 * The meta object literal for the '<em><b>Equipments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__EQUIPMENTS = eINSTANCE.getLibrary_Equipments();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__METRICS = eINSTANCE.getLibrary_Metrics();

		/**
		 * The meta object literal for the '<em><b>Metric Sources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__METRIC_SOURCES = eINSTANCE.getLibrary_MetricSources();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__PARAMETERS = eINSTANCE.getLibrary_Parameters();

		/**
		 * The meta object literal for the '<em><b>Protocols</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY__PROTOCOLS = eINSTANCE.getLibrary_Protocols();

		/**
		 * The meta object literal for the '<em><b>Tolerances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__TOLERANCES = eINSTANCE.getLibrary_Tolerances();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__EXPRESSIONS = eINSTANCE.getLibrary_Expressions();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__UNITS = eINSTANCE.getLibrary_Units();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__VERSION = eINSTANCE.getLibrary_Version();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY__NAME = eINSTANCE.getLibrary_Name();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl <em>Net XResource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.impl.NetXResourceImpl
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getNetXResource()
		 * @generated
		 */
		EClass NET_XRESOURCE = eINSTANCE.getNetXResource();

		/**
		 * The meta object literal for the '<em><b>Metric Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NET_XRESOURCE__METRIC_REF = eINSTANCE.getNetXResource_MetricRef();

		/**
		 * The meta object literal for the '<em><b>Metric Value Ranges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NET_XRESOURCE__METRIC_VALUE_RANGES = eINSTANCE.getNetXResource_MetricValueRanges();

		/**
		 * The meta object literal for the '<em><b>Capacity Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NET_XRESOURCE__CAPACITY_VALUES = eINSTANCE.getNetXResource_CapacityValues();

		/**
		 * The meta object literal for the '<em><b>Utilization Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NET_XRESOURCE__UTILIZATION_VALUES = eINSTANCE.getNetXResource_UtilizationValues();

		/**
		 * The meta object literal for the '<em><b>Forecast Capacity Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NET_XRESOURCE__FORECAST_CAPACITY_VALUES = eINSTANCE.getNetXResource_ForecastCapacityValues();

		/**
		 * The meta object literal for the '<em><b>Forecast Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NET_XRESOURCE__FORECAST_VALUES = eINSTANCE.getNetXResource_ForecastValues();

		/**
		 * The meta object literal for the '<em><b>Trended Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NET_XRESOURCE__TRENDED_VALUES = eINSTANCE.getNetXResource_TrendedValues();

		/**
		 * The meta object literal for the '<em><b>Detail Display</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NET_XRESOURCE__DETAIL_DISPLAY = eINSTANCE.getNetXResource_DetailDisplay();

		/**
		 * The meta object literal for the '<em><b>Expression Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NET_XRESOURCE__EXPRESSION_NAME = eINSTANCE.getNetXResource_ExpressionName();

		/**
		 * The meta object literal for the '<em><b>Long Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NET_XRESOURCE__LONG_NAME = eINSTANCE.getNetXResource_LongName();

		/**
		 * The meta object literal for the '<em><b>Short Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NET_XRESOURCE__SHORT_NAME = eINSTANCE.getNetXResource_ShortName();

		/**
		 * The meta object literal for the '<em><b>Summary Display</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NET_XRESOURCE__SUMMARY_DISPLAY = eINSTANCE.getNetXResource_SummaryDisplay();

		/**
		 * The meta object literal for the '<em><b>Unit Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NET_XRESOURCE__UNIT_REF = eINSTANCE.getNetXResource_UnitRef();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.impl.NodeTypeImpl <em>Node Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.impl.NodeTypeImpl
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getNodeType()
		 * @generated
		 */
		EClass NODE_TYPE = eINSTANCE.getNodeType();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TYPE__FUNCTIONS = eINSTANCE.getNodeType_Functions();

		/**
		 * The meta object literal for the '<em><b>Equipments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TYPE__EQUIPMENTS = eINSTANCE.getNodeType_Equipments();

		/**
		 * The meta object literal for the '<em><b>Leaf Node</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_TYPE__LEAF_NODE = eINSTANCE.getNodeType_LeafNode();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.impl.ParameterImpl
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__DESCRIPTION = eINSTANCE.getParameter_Description();

		/**
		 * The meta object literal for the '<em><b>Expression Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__EXPRESSION_NAME = eINSTANCE.getParameter_ExpressionName();

		/**
		 * The meta object literal for the '<em><b>Modifiable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__MODIFIABLE = eINSTANCE.getParameter_Modifiable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__VALUE = eINSTANCE.getParameter_Value();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.impl.ProductInfoImpl <em>Product Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.impl.ProductInfoImpl
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getProductInfo()
		 * @generated
		 */
		EClass PRODUCT_INFO = eINSTANCE.getProductInfo();

		/**
		 * The meta object literal for the '<em><b>Equipment Ref</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCT_INFO__EQUIPMENT_REF = eINSTANCE.getProductInfo_EquipmentRef();

		/**
		 * The meta object literal for the '<em><b>Licensed Function Ref</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCT_INFO__LICENSED_FUNCTION_REF = eINSTANCE.getProductInfo_LicensedFunctionRef();

		/**
		 * The meta object literal for the '<em><b>Node Type Ref</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCT_INFO__NODE_TYPE_REF = eINSTANCE.getProductInfo_NodeTypeRef();

		/**
		 * The meta object literal for the '<em><b>Available Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT_INFO__AVAILABLE_DATE = eINSTANCE.getProductInfo_AvailableDate();

		/**
		 * The meta object literal for the '<em><b>End Of Sales Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT_INFO__END_OF_SALES_DATE = eINSTANCE.getProductInfo_EndOfSalesDate();

		/**
		 * The meta object literal for the '<em><b>End Of Support Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT_INFO__END_OF_SUPPORT_DATE = eINSTANCE.getProductInfo_EndOfSupportDate();

		/**
		 * The meta object literal for the '<em><b>Product Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT_INFO__PRODUCT_CODE = eINSTANCE.getProductInfo_ProductCode();

		/**
		 * The meta object literal for the '<em><b>Sales Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT_INFO__SALES_CODE = eINSTANCE.getProductInfo_SalesCode();

		/**
		 * The meta object literal for the '<em><b>Under Development Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT_INFO__UNDER_DEVELOPMENT_DATE = eINSTANCE.getProductInfo_UnderDevelopmentDate();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.impl.ToleranceImpl <em>Tolerance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.impl.ToleranceImpl
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getTolerance()
		 * @generated
		 */
		EClass TOLERANCE = eINSTANCE.getTolerance();

		/**
		 * The meta object literal for the '<em><b>Expression Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOLERANCE__EXPRESSION_REF = eINSTANCE.getTolerance_ExpressionRef();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOLERANCE__LEVEL = eINSTANCE.getTolerance_Level();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOLERANCE__NAME = eINSTANCE.getTolerance_Name();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.impl.UnitImpl <em>Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.impl.UnitImpl
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getUnit()
		 * @generated
		 */
		EClass UNIT = eINSTANCE.getUnit();

		/**
		 * The meta object literal for the '<em><b>Icons</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT__ICONS = eINSTANCE.getUnit_Icons();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__CODE = eINSTANCE.getUnit_Code();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__DESCRIPTION = eINSTANCE.getUnit_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__NAME = eINSTANCE.getUnit_Name();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.impl.VendorImpl <em>Vendor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.impl.VendorImpl
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getVendor()
		 * @generated
		 */
		EClass VENDOR = eINSTANCE.getVendor();

		/**
		 * The meta object literal for the '<em><b>Products</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VENDOR__PRODUCTS = eINSTANCE.getVendor_Products();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.LevelType <em>Level Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.LevelType
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getLevelType()
		 * @generated
		 */
		EEnum LEVEL_TYPE = eINSTANCE.getLevelType();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.RangeKind <em>Range Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.RangeKind
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getRangeKind()
		 * @generated
		 */
		EEnum RANGE_KIND = eINSTANCE.getRangeKind();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.RedundancyType <em>Redundancy Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.RedundancyType
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getRedundancyType()
		 * @generated
		 */
		EEnum REDUNDANCY_TYPE = eINSTANCE.getRedundancyType();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.StateType <em>State Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.StateType
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getStateType()
		 * @generated
		 */
		EEnum STATE_TYPE = eINSTANCE.getStateType();

		/**
		 * The meta object literal for the '<em>Level Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.LevelType
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getLevelTypeObject()
		 * @generated
		 */
		EDataType LEVEL_TYPE_OBJECT = eINSTANCE.getLevelTypeObject();

		/**
		 * The meta object literal for the '<em>Range Kind Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.RangeKind
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getRangeKindObject()
		 * @generated
		 */
		EDataType RANGE_KIND_OBJECT = eINSTANCE.getRangeKindObject();

		/**
		 * The meta object literal for the '<em>Redundancy Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.RedundancyType
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getRedundancyTypeObject()
		 * @generated
		 */
		EDataType REDUNDANCY_TYPE_OBJECT = eINSTANCE.getRedundancyTypeObject();

		/**
		 * The meta object literal for the '<em>State Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.StateType
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getStateTypeObject()
		 * @generated
		 */
		EDataType STATE_TYPE_OBJECT = eINSTANCE.getStateTypeObject();

	}

} //LibraryPackage
