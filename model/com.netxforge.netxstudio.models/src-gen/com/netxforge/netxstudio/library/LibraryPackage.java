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
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.EquipmentImpl <em>Equipment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.EquipmentImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getEquipment()
	 * @generated
	 */
	int EQUIPMENT = 0;

	/**
	 * The feature id for the '<em><b>Lifecycle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__LIFECYCLE = 0;

	/**
	 * The feature id for the '<em><b>Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__DIAGRAMS = 1;

	/**
	 * The feature id for the '<em><b>Equipments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__EQUIPMENTS = 2;

	/**
	 * The feature id for the '<em><b>Equipment Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__EQUIPMENT_GROUPS = 3;

	/**
	 * The feature id for the '<em><b>Equipment Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__EQUIPMENT_RESOURCES = 4;

	/**
	 * The feature id for the '<em><b>Equipment Metric Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__EQUIPMENT_METRIC_REFS = 5;

	/**
	 * The feature id for the '<em><b>Equipment Relationship Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__EQUIPMENT_RELATIONSHIP_REFS = 6;

	/**
	 * The feature id for the '<em><b>Equipment Expression Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__EQUIPMENT_EXPRESSION_REFS = 7;

	/**
	 * The feature id for the '<em><b>Tolerance Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__TOLERANCE_REFS = 8;

	/**
	 * The feature id for the '<em><b>Protocol Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__PROTOCOL_REFS = 9;

	/**
	 * The feature id for the '<em><b>Parameter Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__PARAMETER_REFS = 10;

	/**
	 * The feature id for the '<em><b>All Equipment Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__ALL_EQUIPMENT_RESOURCES = 11;

	/**
	 * The feature id for the '<em><b>All Equipments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__ALL_EQUIPMENTS = 12;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__ICONS = 13;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__COUNT = 14;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__DESCRIPTION = 15;

	/**
	 * The feature id for the '<em><b>Equipment Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__EQUIPMENT_CODE = 16;

	/**
	 * The feature id for the '<em><b>Equipment Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__EQUIPMENT_NAME = 17;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__POSITION = 18;

	/**
	 * The feature id for the '<em><b>Redundancy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__REDUNDANCY = 19;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT__STATE = 20;

	/**
	 * The number of structural features of the '<em>Equipment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_FEATURE_COUNT = 21;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.EquipmentGroupImpl <em>Equipment Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.EquipmentGroupImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getEquipmentGroup()
	 * @generated
	 */
	int EQUIPMENT_GROUP = 1;

	/**
	 * The feature id for the '<em><b>Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__DIAGRAMS = 0;

	/**
	 * The feature id for the '<em><b>Equipment Group Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__EQUIPMENT_GROUP_RESOURCES = 1;

	/**
	 * The feature id for the '<em><b>Expression Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__EXPRESSION_REFS = 2;

	/**
	 * The feature id for the '<em><b>Equipment Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__EQUIPMENT_REFS = 3;

	/**
	 * The feature id for the '<em><b>Parameter Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__PARAMETER_REFS = 4;

	/**
	 * The feature id for the '<em><b>All Equipment Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__ALL_EQUIPMENT_RESOURCES = 5;

	/**
	 * The feature id for the '<em><b>All Equipments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__ALL_EQUIPMENTS = 6;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__COUNT = 7;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__DESCRIPTION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP__NAME = 9;

	/**
	 * The number of structural features of the '<em>Equipment Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_GROUP_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.ExpressionImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 2;

	/**
	 * The feature id for the '<em><b>Expression Lines</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__EXPRESSION_LINES = 0;

	/**
	 * The feature id for the '<em><b>Evaluation Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__EVALUATION_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Equipment Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__EQUIPMENT_REFS = 2;

	/**
	 * The feature id for the '<em><b>Function Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__FUNCTION_REFS = 3;

	/**
	 * The feature id for the '<em><b>Equipment Group Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__EQUIPMENT_GROUP_REFS = 4;

	/**
	 * The feature id for the '<em><b>Service Profile Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__SERVICE_PROFILE_REFS = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__NAME = 6;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.FunctionImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 3;

	/**
	 * The feature id for the '<em><b>Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__DIAGRAMS = 0;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__ICONS = 1;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__FUNCTIONS = 2;

	/**
	 * The feature id for the '<em><b>Function Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__FUNCTION_RESOURCES = 3;

	/**
	 * The feature id for the '<em><b>Function Metric Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__FUNCTION_METRIC_REFS = 4;

	/**
	 * The feature id for the '<em><b>Function Relationship Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__FUNCTION_RELATIONSHIP_REFS = 5;

	/**
	 * The feature id for the '<em><b>Function Expression Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__FUNCTION_EXPRESSION_REFS = 6;

	/**
	 * The feature id for the '<em><b>Tolerance Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__TOLERANCE_REFS = 7;

	/**
	 * The feature id for the '<em><b>Protocol Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__PROTOCOL_REFS = 8;

	/**
	 * The feature id for the '<em><b>Parameter Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__PARAMETER_REFS = 9;

	/**
	 * The feature id for the '<em><b>All Function Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__ALL_FUNCTION_RESOURCES = 10;

	/**
	 * The feature id for the '<em><b>All Functions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__ALL_FUNCTIONS = 11;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__DESCRIPTION = 12;

	/**
	 * The feature id for the '<em><b>Function Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__FUNCTION_NAME = 13;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.LibraryImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 4;

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
	int NET_XRESOURCE = 5;

	/**
	 * The feature id for the '<em><b>Metric Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__METRIC_REF = 0;

	/**
	 * The feature id for the '<em><b>Metric Value Ranges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__METRIC_VALUE_RANGES = 1;

	/**
	 * The feature id for the '<em><b>Capacity Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__CAPACITY_VALUES = 2;

	/**
	 * The feature id for the '<em><b>Forecast Capacity Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__FORECAST_CAPACITY_VALUES = 3;

	/**
	 * The feature id for the '<em><b>Forecast Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__FORECAST_VALUES = 4;

	/**
	 * The feature id for the '<em><b>Trended Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__TRENDED_VALUES = 5;

	/**
	 * The feature id for the '<em><b>Detail Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__DETAIL_DISPLAY = 6;

	/**
	 * The feature id for the '<em><b>Expression Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__EXPRESSION_NAME = 7;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__LONG_NAME = 8;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__SHORT_NAME = 9;

	/**
	 * The feature id for the '<em><b>Summary Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__SUMMARY_DISPLAY = 10;

	/**
	 * The feature id for the '<em><b>Unit Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE__UNIT_REF = 11;

	/**
	 * The number of structural features of the '<em>Net XResource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XRESOURCE_FEATURE_COUNT = 12;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.NodeTypeImpl <em>Node Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.NodeTypeImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getNodeType()
	 * @generated
	 */
	int NODE_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__FUNCTIONS = 0;

	/**
	 * The feature id for the '<em><b>Equipments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__EQUIPMENTS = 1;

	/**
	 * The number of structural features of the '<em>Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.ParameterImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 7;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Expression Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__EXPRESSION_NAME = 1;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__MODIFIABLE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VALUE = 4;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.ProductInfoImpl <em>Product Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.ProductInfoImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getProductInfo()
	 * @generated
	 */
	int PRODUCT_INFO = 8;

	/**
	 * The feature id for the '<em><b>Equipment Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__EQUIPMENT_REF = 0;

	/**
	 * The feature id for the '<em><b>Licensed Function Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__LICENSED_FUNCTION_REF = 1;

	/**
	 * The feature id for the '<em><b>Node Type Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__NODE_TYPE_REF = 2;

	/**
	 * The feature id for the '<em><b>Available Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__AVAILABLE_DATE = 3;

	/**
	 * The feature id for the '<em><b>End Of Sales Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__END_OF_SALES_DATE = 4;

	/**
	 * The feature id for the '<em><b>End Of Support Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__END_OF_SUPPORT_DATE = 5;

	/**
	 * The feature id for the '<em><b>Product Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__PRODUCT_CODE = 6;

	/**
	 * The feature id for the '<em><b>Sales Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__SALES_CODE = 7;

	/**
	 * The feature id for the '<em><b>Under Development Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO__UNDER_DEVELOPMENT_DATE = 8;

	/**
	 * The number of structural features of the '<em>Product Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_INFO_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.ToleranceImpl <em>Tolerance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.ToleranceImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getTolerance()
	 * @generated
	 */
	int TOLERANCE = 9;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOLERANCE__EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOLERANCE__LEVEL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOLERANCE__NAME = 2;

	/**
	 * The number of structural features of the '<em>Tolerance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOLERANCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.UnitImpl <em>Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.UnitImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getUnit()
	 * @generated
	 */
	int UNIT = 10;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__ICONS = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__CODE = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__NAME = 3;

	/**
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.impl.VendorImpl <em>Vendor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.impl.VendorImpl
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getVendor()
	 * @generated
	 */
	int VENDOR = 11;

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
	int LEVEL_TYPE = 12;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.RedundancyType <em>Redundancy Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.RedundancyType
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getRedundancyType()
	 * @generated
	 */
	int REDUNDANCY_TYPE = 13;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.library.StateType <em>State Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.StateType
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getStateType()
	 * @generated
	 */
	int STATE_TYPE = 14;

	/**
	 * The meta object id for the '<em>Level Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.LevelType
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getLevelTypeObject()
	 * @generated
	 */
	int LEVEL_TYPE_OBJECT = 15;

	/**
	 * The meta object id for the '<em>Redundancy Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.RedundancyType
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getRedundancyTypeObject()
	 * @generated
	 */
	int REDUNDANCY_TYPE_OBJECT = 16;

	/**
	 * The meta object id for the '<em>State Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.library.StateType
	 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getStateTypeObject()
	 * @generated
	 */
	int STATE_TYPE_OBJECT = 17;


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
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Equipment#getDiagrams <em>Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Diagrams</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getDiagrams()
	 * @see #getEquipment()
	 * @generated
	 */
	EReference getEquipment_Diagrams();

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
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Equipment#getEquipmentResources <em>Equipment Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Equipment Resources</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getEquipmentResources()
	 * @see #getEquipment()
	 * @generated
	 */
	EReference getEquipment_EquipmentResources();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Equipment#getEquipmentMetricRefs <em>Equipment Metric Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Equipment Metric Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getEquipmentMetricRefs()
	 * @see #getEquipment()
	 * @generated
	 */
	EReference getEquipment_EquipmentMetricRefs();

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
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Equipment#getEquipmentExpressionRefs <em>Equipment Expression Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Equipment Expression Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getEquipmentExpressionRefs()
	 * @see #getEquipment()
	 * @generated
	 */
	EReference getEquipment_EquipmentExpressionRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Equipment#getToleranceRefs <em>Tolerance Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tolerance Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getToleranceRefs()
	 * @see #getEquipment()
	 * @generated
	 */
	EReference getEquipment_ToleranceRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Equipment#getProtocolRefs <em>Protocol Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Protocol Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getProtocolRefs()
	 * @see #getEquipment()
	 * @generated
	 */
	EReference getEquipment_ProtocolRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Equipment#getParameterRefs <em>Parameter Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameter Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getParameterRefs()
	 * @see #getEquipment()
	 * @generated
	 */
	EReference getEquipment_ParameterRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Equipment#getAllEquipmentResources <em>All Equipment Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Equipment Resources</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getAllEquipmentResources()
	 * @see #getEquipment()
	 * @generated
	 */
	EReference getEquipment_AllEquipmentResources();

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
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.library.Equipment#getIcons <em>Icons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Icons</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getIcons()
	 * @see #getEquipment()
	 * @generated
	 */
	EReference getEquipment_Icons();

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
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Equipment#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getDescription()
	 * @see #getEquipment()
	 * @generated
	 */
	EAttribute getEquipment_Description();

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
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Equipment#getEquipmentName <em>Equipment Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Equipment Name</em>'.
	 * @see com.netxforge.netxstudio.library.Equipment#getEquipmentName()
	 * @see #getEquipment()
	 * @generated
	 */
	EAttribute getEquipment_EquipmentName();

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
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Expression#getEquipmentRefs <em>Equipment Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Equipment Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Expression#getEquipmentRefs()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_EquipmentRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Expression#getFunctionRefs <em>Function Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Function Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Expression#getFunctionRefs()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_FunctionRefs();

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
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.library.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see com.netxforge.netxstudio.library.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Function#getDiagrams <em>Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Diagrams</em>'.
	 * @see com.netxforge.netxstudio.library.Function#getDiagrams()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Diagrams();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.library.Function#getIcons <em>Icons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Icons</em>'.
	 * @see com.netxforge.netxstudio.library.Function#getIcons()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Icons();

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
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.library.Function#getFunctionResources <em>Function Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Function Resources</em>'.
	 * @see com.netxforge.netxstudio.library.Function#getFunctionResources()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_FunctionResources();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Function#getFunctionMetricRefs <em>Function Metric Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Function Metric Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Function#getFunctionMetricRefs()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_FunctionMetricRefs();

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
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Function#getFunctionExpressionRefs <em>Function Expression Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Function Expression Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Function#getFunctionExpressionRefs()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_FunctionExpressionRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Function#getToleranceRefs <em>Tolerance Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tolerance Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Function#getToleranceRefs()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_ToleranceRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Function#getProtocolRefs <em>Protocol Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Protocol Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Function#getProtocolRefs()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_ProtocolRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Function#getParameterRefs <em>Parameter Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameter Refs</em>'.
	 * @see com.netxforge.netxstudio.library.Function#getParameterRefs()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_ParameterRefs();

	/**
	 * Returns the meta object for the reference list '{@link com.netxforge.netxstudio.library.Function#getAllFunctionResources <em>All Function Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Function Resources</em>'.
	 * @see com.netxforge.netxstudio.library.Function#getAllFunctionResources()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_AllFunctionResources();

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
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Function#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.netxforge.netxstudio.library.Function#getDescription()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Function#getFunctionName <em>Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Function Name</em>'.
	 * @see com.netxforge.netxstudio.library.Function#getFunctionName()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_FunctionName();

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
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.library.Tolerance#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see com.netxforge.netxstudio.library.Tolerance#getExpression()
	 * @see #getTolerance()
	 * @generated
	 */
	EAttribute getTolerance_Expression();

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
		 * The meta object literal for the '<em><b>Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT__DIAGRAMS = eINSTANCE.getEquipment_Diagrams();

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
		 * The meta object literal for the '<em><b>Equipment Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT__EQUIPMENT_RESOURCES = eINSTANCE.getEquipment_EquipmentResources();

		/**
		 * The meta object literal for the '<em><b>Equipment Metric Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT__EQUIPMENT_METRIC_REFS = eINSTANCE.getEquipment_EquipmentMetricRefs();

		/**
		 * The meta object literal for the '<em><b>Equipment Relationship Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT__EQUIPMENT_RELATIONSHIP_REFS = eINSTANCE.getEquipment_EquipmentRelationshipRefs();

		/**
		 * The meta object literal for the '<em><b>Equipment Expression Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT__EQUIPMENT_EXPRESSION_REFS = eINSTANCE.getEquipment_EquipmentExpressionRefs();

		/**
		 * The meta object literal for the '<em><b>Tolerance Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT__TOLERANCE_REFS = eINSTANCE.getEquipment_ToleranceRefs();

		/**
		 * The meta object literal for the '<em><b>Protocol Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT__PROTOCOL_REFS = eINSTANCE.getEquipment_ProtocolRefs();

		/**
		 * The meta object literal for the '<em><b>Parameter Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT__PARAMETER_REFS = eINSTANCE.getEquipment_ParameterRefs();

		/**
		 * The meta object literal for the '<em><b>All Equipment Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT__ALL_EQUIPMENT_RESOURCES = eINSTANCE.getEquipment_AllEquipmentResources();

		/**
		 * The meta object literal for the '<em><b>All Equipments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT__ALL_EQUIPMENTS = eINSTANCE.getEquipment_AllEquipments();

		/**
		 * The meta object literal for the '<em><b>Icons</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIPMENT__ICONS = eINSTANCE.getEquipment_Icons();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIPMENT__COUNT = eINSTANCE.getEquipment_Count();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIPMENT__DESCRIPTION = eINSTANCE.getEquipment_Description();

		/**
		 * The meta object literal for the '<em><b>Equipment Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIPMENT__EQUIPMENT_CODE = eINSTANCE.getEquipment_EquipmentCode();

		/**
		 * The meta object literal for the '<em><b>Equipment Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIPMENT__EQUIPMENT_NAME = eINSTANCE.getEquipment_EquipmentName();

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
		 * The meta object literal for the '<em><b>Equipment Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__EQUIPMENT_REFS = eINSTANCE.getExpression_EquipmentRefs();

		/**
		 * The meta object literal for the '<em><b>Function Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__FUNCTION_REFS = eINSTANCE.getExpression_FunctionRefs();

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
		 * The meta object literal for the '{@link com.netxforge.netxstudio.library.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.library.impl.FunctionImpl
		 * @see com.netxforge.netxstudio.library.impl.LibraryPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__DIAGRAMS = eINSTANCE.getFunction_Diagrams();

		/**
		 * The meta object literal for the '<em><b>Icons</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__ICONS = eINSTANCE.getFunction_Icons();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__FUNCTIONS = eINSTANCE.getFunction_Functions();

		/**
		 * The meta object literal for the '<em><b>Function Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__FUNCTION_RESOURCES = eINSTANCE.getFunction_FunctionResources();

		/**
		 * The meta object literal for the '<em><b>Function Metric Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__FUNCTION_METRIC_REFS = eINSTANCE.getFunction_FunctionMetricRefs();

		/**
		 * The meta object literal for the '<em><b>Function Relationship Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__FUNCTION_RELATIONSHIP_REFS = eINSTANCE.getFunction_FunctionRelationshipRefs();

		/**
		 * The meta object literal for the '<em><b>Function Expression Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__FUNCTION_EXPRESSION_REFS = eINSTANCE.getFunction_FunctionExpressionRefs();

		/**
		 * The meta object literal for the '<em><b>Tolerance Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__TOLERANCE_REFS = eINSTANCE.getFunction_ToleranceRefs();

		/**
		 * The meta object literal for the '<em><b>Protocol Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__PROTOCOL_REFS = eINSTANCE.getFunction_ProtocolRefs();

		/**
		 * The meta object literal for the '<em><b>Parameter Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__PARAMETER_REFS = eINSTANCE.getFunction_ParameterRefs();

		/**
		 * The meta object literal for the '<em><b>All Function Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__ALL_FUNCTION_RESOURCES = eINSTANCE.getFunction_AllFunctionResources();

		/**
		 * The meta object literal for the '<em><b>All Functions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__ALL_FUNCTIONS = eINSTANCE.getFunction_AllFunctions();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__DESCRIPTION = eINSTANCE.getFunction_Description();

		/**
		 * The meta object literal for the '<em><b>Function Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__FUNCTION_NAME = eINSTANCE.getFunction_FunctionName();

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
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOLERANCE__EXPRESSION = eINSTANCE.getTolerance_Expression();

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
