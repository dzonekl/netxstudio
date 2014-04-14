/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see com.netxforge.smi.SmiFactory
 * @model kind="package"
 * @generated
 */
public interface SmiPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "smi";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.netxforge.com/Smi";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "smi";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SmiPackage eINSTANCE = com.netxforge.smi.impl.SmiPackageImpl.init();

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ModuleImpl <em>Module</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ModuleImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getModule()
   * @generated
   */
  int MODULE = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__ID = 0;

  /**
   * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__ASSIGNMENTS = 1;

  /**
   * The number of structural features of the '<em>Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.AssignmentImpl <em>Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.AssignmentImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getAssignment()
   * @generated
   */
  int ASSIGNMENT = 1;

  /**
   * The feature id for the '<em><b>Identifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__IDENTIFIER = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__TYPE = 1;

  /**
   * The feature id for the '<em><b>Macro</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__MACRO = 2;

  /**
   * The number of structural features of the '<em>Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ObjectIdentifierImpl <em>Object Identifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ObjectIdentifierImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getObjectIdentifier()
   * @generated
   */
  int OBJECT_IDENTIFIER = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_IDENTIFIER__NAME = 0;

  /**
   * The feature id for the '<em><b>Oid Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_IDENTIFIER__OID_VALUE = 1;

  /**
   * The number of structural features of the '<em>Object Identifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_IDENTIFIER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ObjectIdentifierValueImpl <em>Object Identifier Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ObjectIdentifierValueImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getObjectIdentifierValue()
   * @generated
   */
  int OBJECT_IDENTIFIER_VALUE = 3;

  /**
   * The feature id for the '<em><b>Descriptor Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REFERENCE = 0;

  /**
   * The feature id for the '<em><b>Sub Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_IDENTIFIER_VALUE__SUB_IDS = 1;

  /**
   * The number of structural features of the '<em>Object Identifier Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_IDENTIFIER_VALUE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.TypeDefinitionImpl <em>Type Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.TypeDefinitionImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeDefinition()
   * @generated
   */
  int TYPE_DEFINITION = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEFINITION__NAME = 0;

  /**
   * The feature id for the '<em><b>Scope</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEFINITION__SCOPE = 1;

  /**
   * The number of structural features of the '<em>Type Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEFINITION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.MacroImpl <em>Macro</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.MacroImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getMacro()
   * @generated
   */
  int MACRO = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__NAME = 0;

  /**
   * The feature id for the '<em><b>Type Notations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__TYPE_NOTATIONS = 1;

  /**
   * The feature id for the '<em><b>Value Notation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__VALUE_NOTATION = 2;

  /**
   * The feature id for the '<em><b>Inner Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__INNER_TYPES = 3;

  /**
   * The number of structural features of the '<em>Macro</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.TypeAssignmentImpl <em>Type Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.TypeAssignmentImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeAssignment()
   * @generated
   */
  int TYPE_ASSIGNMENT = 6;

  /**
   * The number of structural features of the '<em>Type Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ASSIGNMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ParamAssignmentImpl <em>Param Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ParamAssignmentImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getParamAssignment()
   * @generated
   */
  int PARAM_ASSIGNMENT = 7;

  /**
   * The feature id for the '<em><b>Param</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_ASSIGNMENT__PARAM = TYPE_ASSIGNMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_ASSIGNMENT__RIGHT = TYPE_ASSIGNMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Param Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_ASSIGNMENT_FEATURE_COUNT = TYPE_ASSIGNMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.TypeNotationImpl <em>Type Notation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.TypeNotationImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeNotation()
   * @generated
   */
  int TYPE_NOTATION = 8;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_NOTATION__VALUE = 0;

  /**
   * The number of structural features of the '<em>Type Notation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_NOTATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.TypeReferenceExtImpl <em>Type Reference Ext</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.TypeReferenceExtImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeReferenceExt()
   * @generated
   */
  int TYPE_REFERENCE_EXT = 9;

  /**
   * The number of structural features of the '<em>Type Reference Ext</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REFERENCE_EXT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.TypeReferenceImpl <em>Type Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.TypeReferenceImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeReference()
   * @generated
   */
  int TYPE_REFERENCE = 10;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REFERENCE__VALUE = TYPE_ASSIGNMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REFERENCE__RIGHT = TYPE_ASSIGNMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REFERENCE__TYPE = TYPE_ASSIGNMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Type Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REFERENCE_FEATURE_COUNT = TYPE_ASSIGNMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ScopeImpl <em>Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ScopeImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getScope()
   * @generated
   */
  int SCOPE = 11;

  /**
   * The feature id for the '<em><b>Scope</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE__SCOPE = 0;

  /**
   * The number of structural features of the '<em>Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ValueImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getValue()
   * @generated
   */
  int VALUE = 12;

  /**
   * The feature id for the '<em><b>Value Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__VALUE_TYPES = 0;

  /**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ValueTypeImpl <em>Value Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ValueTypeImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getValueType()
   * @generated
   */
  int VALUE_TYPE = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__NAME = 0;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__PARAM = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__TYPE = 2;

  /**
   * The feature id for the '<em><b>Simple Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__SIMPLE_TYPE = 3;

  /**
   * The feature id for the '<em><b>Macro Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__MACRO_VALUE = 4;

  /**
   * The feature id for the '<em><b>Oi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__OI = 5;

  /**
   * The number of structural features of the '<em>Value Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.MacroValueImpl <em>Macro Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.MacroValueImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getMacroValue()
   * @generated
   */
  int MACRO_VALUE = 14;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE__TYPE = 0;

  /**
   * The number of structural features of the '<em>Macro Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.MACRO_VALUE_TYPEImpl <em>MACRO VALUE TYPE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.MACRO_VALUE_TYPEImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getMACRO_VALUE_TYPE()
   * @generated
   */
  int MACRO_VALUE_TYPE = 15;

  /**
   * The feature id for the '<em><b>Val Literal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_TYPE__VAL_LITERAL = 0;

  /**
   * The feature id for the '<em><b>Update</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_TYPE__UPDATE = 1;

  /**
   * The number of structural features of the '<em>MACRO VALUE TYPE</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.UpdateTypeImpl <em>Update Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.UpdateTypeImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getUpdateType()
   * @generated
   */
  int UPDATE_TYPE = 16;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPDATE_TYPE__TYPE = 0;

  /**
   * The number of structural features of the '<em>Update Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPDATE_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.MACRO_VALUE_CAPImpl <em>MACRO VALUE CAP</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.MACRO_VALUE_CAPImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getMACRO_VALUE_CAP()
   * @generated
   */
  int MACRO_VALUE_CAP = 17;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_CAP__VALUE = 0;

  /**
   * The feature id for the '<em><b>Literal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_CAP__LITERAL = 1;

  /**
   * The number of structural features of the '<em>MACRO VALUE CAP</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_CAP_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_TYPEImpl <em>ASN1 TYPE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_TYPEImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_TYPE()
   * @generated
   */
  int ASN1_TYPE = 18;

  /**
   * The number of structural features of the '<em>ASN1 TYPE</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_SIMPLEImpl <em>ASN1 SIMPLE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_SIMPLEImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_SIMPLE()
   * @generated
   */
  int ASN1_SIMPLE = 19;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SIMPLE__CONSTRAINT = ASN1_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value Pairs</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SIMPLE__VALUE_PAIRS = ASN1_TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>ASN1 SIMPLE</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SIMPLE_FEATURE_COUNT = ASN1_TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_SUBTYPEImpl <em>ASN1 SUBTYPE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_SUBTYPEImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_SUBTYPE()
   * @generated
   */
  int ASN1_SUBTYPE = 20;

  /**
   * The feature id for the '<em><b>Ranges</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SUBTYPE__RANGES = 0;

  /**
   * The number of structural features of the '<em>ASN1 SUBTYPE</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SUBTYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_RANGEImpl <em>ASN1 RANGE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_RANGEImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_RANGE()
   * @generated
   */
  int ASN1_RANGE = 21;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_RANGE__VALUE = 0;

  /**
   * The feature id for the '<em><b>Start</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_RANGE__START = 1;

  /**
   * The feature id for the '<em><b>End</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_RANGE__END = 2;

  /**
   * The number of structural features of the '<em>ASN1 RANGE</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_RANGE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_CHOICEImpl <em>ASN1 CHOICE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_CHOICEImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_CHOICE()
   * @generated
   */
  int ASN1_CHOICE = 22;

  /**
   * The feature id for the '<em><b>Choices</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_CHOICE__CHOICES = ASN1_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>ASN1 CHOICE</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_CHOICE_FEATURE_COUNT = ASN1_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_CHOICE_ENTRYImpl <em>ASN1 CHOICE ENTRY</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_CHOICE_ENTRYImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_CHOICE_ENTRY()
   * @generated
   */
  int ASN1_CHOICE_ENTRY = 23;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_CHOICE_ENTRY__ID = 0;

  /**
   * The feature id for the '<em><b>Value Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_CHOICE_ENTRY__VALUE_TYPE = 1;

  /**
   * The number of structural features of the '<em>ASN1 CHOICE ENTRY</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_CHOICE_ENTRY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_OCTET_STRINGImpl <em>ASN1 OCTET STRING</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_OCTET_STRINGImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_OCTET_STRING()
   * @generated
   */
  int ASN1_OCTET_STRING = 24;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_OCTET_STRING__CONSTRAINT = ASN1_SIMPLE__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Value Pairs</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_OCTET_STRING__VALUE_PAIRS = ASN1_SIMPLE__VALUE_PAIRS;

  /**
   * The number of structural features of the '<em>ASN1 OCTET STRING</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_OCTET_STRING_FEATURE_COUNT = ASN1_SIMPLE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.netxforge.smi.VALUE_CAP_LITERALS <em>VALUE CAP LITERALS</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.VALUE_CAP_LITERALS
   * @see com.netxforge.smi.impl.SmiPackageImpl#getVALUE_CAP_LITERALS()
   * @generated
   */
  int VALUE_CAP_LITERALS = 25;


  /**
   * Returns the meta object for class '{@link com.netxforge.smi.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module</em>'.
   * @see com.netxforge.smi.Module
   * @generated
   */
  EClass getModule();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.Module#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see com.netxforge.smi.Module#getId()
   * @see #getModule()
   * @generated
   */
  EAttribute getModule_Id();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.Module#getAssignments <em>Assignments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Assignments</em>'.
   * @see com.netxforge.smi.Module#getAssignments()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Assignments();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment</em>'.
   * @see com.netxforge.smi.Assignment
   * @generated
   */
  EClass getAssignment();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.Assignment#getIdentifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Identifier</em>'.
   * @see com.netxforge.smi.Assignment#getIdentifier()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Identifier();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.Assignment#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.netxforge.smi.Assignment#getType()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Type();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.Assignment#getMacro <em>Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Macro</em>'.
   * @see com.netxforge.smi.Assignment#getMacro()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Macro();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ObjectIdentifier <em>Object Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Identifier</em>'.
   * @see com.netxforge.smi.ObjectIdentifier
   * @generated
   */
  EClass getObjectIdentifier();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ObjectIdentifier#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.netxforge.smi.ObjectIdentifier#getName()
   * @see #getObjectIdentifier()
   * @generated
   */
  EAttribute getObjectIdentifier_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ObjectIdentifier#getOidValue <em>Oid Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Oid Value</em>'.
   * @see com.netxforge.smi.ObjectIdentifier#getOidValue()
   * @see #getObjectIdentifier()
   * @generated
   */
  EReference getObjectIdentifier_OidValue();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ObjectIdentifierValue <em>Object Identifier Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Identifier Value</em>'.
   * @see com.netxforge.smi.ObjectIdentifierValue
   * @generated
   */
  EClass getObjectIdentifierValue();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.smi.ObjectIdentifierValue#getDescriptorReference <em>Descriptor Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Descriptor Reference</em>'.
   * @see com.netxforge.smi.ObjectIdentifierValue#getDescriptorReference()
   * @see #getObjectIdentifierValue()
   * @generated
   */
  EReference getObjectIdentifierValue_DescriptorReference();

  /**
   * Returns the meta object for the attribute list '{@link com.netxforge.smi.ObjectIdentifierValue#getSubIds <em>Sub Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Sub Ids</em>'.
   * @see com.netxforge.smi.ObjectIdentifierValue#getSubIds()
   * @see #getObjectIdentifierValue()
   * @generated
   */
  EAttribute getObjectIdentifierValue_SubIds();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.TypeDefinition <em>Type Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Definition</em>'.
   * @see com.netxforge.smi.TypeDefinition
   * @generated
   */
  EClass getTypeDefinition();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.TypeDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.netxforge.smi.TypeDefinition#getName()
   * @see #getTypeDefinition()
   * @generated
   */
  EAttribute getTypeDefinition_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.TypeDefinition#getScope <em>Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Scope</em>'.
   * @see com.netxforge.smi.TypeDefinition#getScope()
   * @see #getTypeDefinition()
   * @generated
   */
  EReference getTypeDefinition_Scope();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.Macro <em>Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Macro</em>'.
   * @see com.netxforge.smi.Macro
   * @generated
   */
  EClass getMacro();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.Macro#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.netxforge.smi.Macro#getName()
   * @see #getMacro()
   * @generated
   */
  EAttribute getMacro_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.Macro#getTypeNotations <em>Type Notations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type Notations</em>'.
   * @see com.netxforge.smi.Macro#getTypeNotations()
   * @see #getMacro()
   * @generated
   */
  EReference getMacro_TypeNotations();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.Macro#getValueNotation <em>Value Notation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value Notation</em>'.
   * @see com.netxforge.smi.Macro#getValueNotation()
   * @see #getMacro()
   * @generated
   */
  EReference getMacro_ValueNotation();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.Macro#getInnerTypes <em>Inner Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inner Types</em>'.
   * @see com.netxforge.smi.Macro#getInnerTypes()
   * @see #getMacro()
   * @generated
   */
  EReference getMacro_InnerTypes();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.TypeAssignment <em>Type Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Assignment</em>'.
   * @see com.netxforge.smi.TypeAssignment
   * @generated
   */
  EClass getTypeAssignment();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ParamAssignment <em>Param Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Param Assignment</em>'.
   * @see com.netxforge.smi.ParamAssignment
   * @generated
   */
  EClass getParamAssignment();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ParamAssignment#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Param</em>'.
   * @see com.netxforge.smi.ParamAssignment#getParam()
   * @see #getParamAssignment()
   * @generated
   */
  EAttribute getParamAssignment_Param();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ParamAssignment#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.smi.ParamAssignment#getRight()
   * @see #getParamAssignment()
   * @generated
   */
  EReference getParamAssignment_Right();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.TypeNotation <em>Type Notation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Notation</em>'.
   * @see com.netxforge.smi.TypeNotation
   * @generated
   */
  EClass getTypeNotation();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.TypeNotation#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see com.netxforge.smi.TypeNotation#getValue()
   * @see #getTypeNotation()
   * @generated
   */
  EReference getTypeNotation_Value();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.TypeReferenceExt <em>Type Reference Ext</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Reference Ext</em>'.
   * @see com.netxforge.smi.TypeReferenceExt
   * @generated
   */
  EClass getTypeReferenceExt();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.TypeReference <em>Type Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Reference</em>'.
   * @see com.netxforge.smi.TypeReference
   * @generated
   */
  EClass getTypeReference();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.TypeReference#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.smi.TypeReference#getRight()
   * @see #getTypeReference()
   * @generated
   */
  EReference getTypeReference_Right();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.smi.TypeReference#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see com.netxforge.smi.TypeReference#getType()
   * @see #getTypeReference()
   * @generated
   */
  EReference getTypeReference_Type();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.Scope <em>Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scope</em>'.
   * @see com.netxforge.smi.Scope
   * @generated
   */
  EClass getScope();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.Scope#getScope <em>Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Scope</em>'.
   * @see com.netxforge.smi.Scope#getScope()
   * @see #getScope()
   * @generated
   */
  EReference getScope_Scope();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value</em>'.
   * @see com.netxforge.smi.Value
   * @generated
   */
  EClass getValue();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.Value#getValueTypes <em>Value Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Value Types</em>'.
   * @see com.netxforge.smi.Value#getValueTypes()
   * @see #getValue()
   * @generated
   */
  EReference getValue_ValueTypes();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ValueType <em>Value Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Type</em>'.
   * @see com.netxforge.smi.ValueType
   * @generated
   */
  EClass getValueType();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ValueType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.netxforge.smi.ValueType#getName()
   * @see #getValueType()
   * @generated
   */
  EAttribute getValueType_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ValueType#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param</em>'.
   * @see com.netxforge.smi.ValueType#getParam()
   * @see #getValueType()
   * @generated
   */
  EReference getValueType_Param();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ValueType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.netxforge.smi.ValueType#getType()
   * @see #getValueType()
   * @generated
   */
  EReference getValueType_Type();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ValueType#getSimpleType <em>Simple Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Simple Type</em>'.
   * @see com.netxforge.smi.ValueType#getSimpleType()
   * @see #getValueType()
   * @generated
   */
  EReference getValueType_SimpleType();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ValueType#getMacroValue <em>Macro Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Macro Value</em>'.
   * @see com.netxforge.smi.ValueType#getMacroValue()
   * @see #getValueType()
   * @generated
   */
  EReference getValueType_MacroValue();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ValueType#getOi <em>Oi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Oi</em>'.
   * @see com.netxforge.smi.ValueType#getOi()
   * @see #getValueType()
   * @generated
   */
  EAttribute getValueType_Oi();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.MacroValue <em>Macro Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Macro Value</em>'.
   * @see com.netxforge.smi.MacroValue
   * @generated
   */
  EClass getMacroValue();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.MacroValue#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.netxforge.smi.MacroValue#getType()
   * @see #getMacroValue()
   * @generated
   */
  EReference getMacroValue_Type();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.MACRO_VALUE_TYPE <em>MACRO VALUE TYPE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MACRO VALUE TYPE</em>'.
   * @see com.netxforge.smi.MACRO_VALUE_TYPE
   * @generated
   */
  EClass getMACRO_VALUE_TYPE();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.MACRO_VALUE_TYPE#getValLiteral <em>Val Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Val Literal</em>'.
   * @see com.netxforge.smi.MACRO_VALUE_TYPE#getValLiteral()
   * @see #getMACRO_VALUE_TYPE()
   * @generated
   */
  EReference getMACRO_VALUE_TYPE_ValLiteral();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.MACRO_VALUE_TYPE#getUpdate <em>Update</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Update</em>'.
   * @see com.netxforge.smi.MACRO_VALUE_TYPE#getUpdate()
   * @see #getMACRO_VALUE_TYPE()
   * @generated
   */
  EReference getMACRO_VALUE_TYPE_Update();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.UpdateType <em>Update Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Update Type</em>'.
   * @see com.netxforge.smi.UpdateType
   * @generated
   */
  EClass getUpdateType();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.smi.UpdateType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see com.netxforge.smi.UpdateType#getType()
   * @see #getUpdateType()
   * @generated
   */
  EReference getUpdateType_Type();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.MACRO_VALUE_CAP <em>MACRO VALUE CAP</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MACRO VALUE CAP</em>'.
   * @see com.netxforge.smi.MACRO_VALUE_CAP
   * @generated
   */
  EClass getMACRO_VALUE_CAP();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.MACRO_VALUE_CAP#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.netxforge.smi.MACRO_VALUE_CAP#getValue()
   * @see #getMACRO_VALUE_CAP()
   * @generated
   */
  EAttribute getMACRO_VALUE_CAP_Value();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.MACRO_VALUE_CAP#getLiteral <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Literal</em>'.
   * @see com.netxforge.smi.MACRO_VALUE_CAP#getLiteral()
   * @see #getMACRO_VALUE_CAP()
   * @generated
   */
  EAttribute getMACRO_VALUE_CAP_Literal();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ASN1_TYPE <em>ASN1 TYPE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASN1 TYPE</em>'.
   * @see com.netxforge.smi.ASN1_TYPE
   * @generated
   */
  EClass getASN1_TYPE();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ASN1_SIMPLE <em>ASN1 SIMPLE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASN1 SIMPLE</em>'.
   * @see com.netxforge.smi.ASN1_SIMPLE
   * @generated
   */
  EClass getASN1_SIMPLE();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ASN1_SIMPLE#getConstraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constraint</em>'.
   * @see com.netxforge.smi.ASN1_SIMPLE#getConstraint()
   * @see #getASN1_SIMPLE()
   * @generated
   */
  EReference getASN1_SIMPLE_Constraint();

  /**
   * Returns the meta object for the attribute list '{@link com.netxforge.smi.ASN1_SIMPLE#getValuePairs <em>Value Pairs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Value Pairs</em>'.
   * @see com.netxforge.smi.ASN1_SIMPLE#getValuePairs()
   * @see #getASN1_SIMPLE()
   * @generated
   */
  EAttribute getASN1_SIMPLE_ValuePairs();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ASN1_SUBTYPE <em>ASN1 SUBTYPE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASN1 SUBTYPE</em>'.
   * @see com.netxforge.smi.ASN1_SUBTYPE
   * @generated
   */
  EClass getASN1_SUBTYPE();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.ASN1_SUBTYPE#getRanges <em>Ranges</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ranges</em>'.
   * @see com.netxforge.smi.ASN1_SUBTYPE#getRanges()
   * @see #getASN1_SUBTYPE()
   * @generated
   */
  EReference getASN1_SUBTYPE_Ranges();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ASN1_RANGE <em>ASN1 RANGE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASN1 RANGE</em>'.
   * @see com.netxforge.smi.ASN1_RANGE
   * @generated
   */
  EClass getASN1_RANGE();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ASN1_RANGE#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.netxforge.smi.ASN1_RANGE#getValue()
   * @see #getASN1_RANGE()
   * @generated
   */
  EAttribute getASN1_RANGE_Value();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ASN1_RANGE#getStart <em>Start</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Start</em>'.
   * @see com.netxforge.smi.ASN1_RANGE#getStart()
   * @see #getASN1_RANGE()
   * @generated
   */
  EAttribute getASN1_RANGE_Start();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ASN1_RANGE#getEnd <em>End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>End</em>'.
   * @see com.netxforge.smi.ASN1_RANGE#getEnd()
   * @see #getASN1_RANGE()
   * @generated
   */
  EAttribute getASN1_RANGE_End();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ASN1_CHOICE <em>ASN1 CHOICE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASN1 CHOICE</em>'.
   * @see com.netxforge.smi.ASN1_CHOICE
   * @generated
   */
  EClass getASN1_CHOICE();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.ASN1_CHOICE#getChoices <em>Choices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Choices</em>'.
   * @see com.netxforge.smi.ASN1_CHOICE#getChoices()
   * @see #getASN1_CHOICE()
   * @generated
   */
  EReference getASN1_CHOICE_Choices();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ASN1_CHOICE_ENTRY <em>ASN1 CHOICE ENTRY</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASN1 CHOICE ENTRY</em>'.
   * @see com.netxforge.smi.ASN1_CHOICE_ENTRY
   * @generated
   */
  EClass getASN1_CHOICE_ENTRY();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ASN1_CHOICE_ENTRY#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see com.netxforge.smi.ASN1_CHOICE_ENTRY#getId()
   * @see #getASN1_CHOICE_ENTRY()
   * @generated
   */
  EAttribute getASN1_CHOICE_ENTRY_Id();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.smi.ASN1_CHOICE_ENTRY#getValueType <em>Value Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value Type</em>'.
   * @see com.netxforge.smi.ASN1_CHOICE_ENTRY#getValueType()
   * @see #getASN1_CHOICE_ENTRY()
   * @generated
   */
  EReference getASN1_CHOICE_ENTRY_ValueType();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ASN1_OCTET_STRING <em>ASN1 OCTET STRING</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASN1 OCTET STRING</em>'.
   * @see com.netxforge.smi.ASN1_OCTET_STRING
   * @generated
   */
  EClass getASN1_OCTET_STRING();

  /**
   * Returns the meta object for enum '{@link com.netxforge.smi.VALUE_CAP_LITERALS <em>VALUE CAP LITERALS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>VALUE CAP LITERALS</em>'.
   * @see com.netxforge.smi.VALUE_CAP_LITERALS
   * @generated
   */
  EEnum getVALUE_CAP_LITERALS();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SmiFactory getSmiFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ModuleImpl <em>Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ModuleImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getModule()
     * @generated
     */
    EClass MODULE = eINSTANCE.getModule();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE__ID = eINSTANCE.getModule_Id();

    /**
     * The meta object literal for the '<em><b>Assignments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__ASSIGNMENTS = eINSTANCE.getModule_Assignments();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.AssignmentImpl <em>Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.AssignmentImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getAssignment()
     * @generated
     */
    EClass ASSIGNMENT = eINSTANCE.getAssignment();

    /**
     * The meta object literal for the '<em><b>Identifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__IDENTIFIER = eINSTANCE.getAssignment_Identifier();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__TYPE = eINSTANCE.getAssignment_Type();

    /**
     * The meta object literal for the '<em><b>Macro</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__MACRO = eINSTANCE.getAssignment_Macro();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ObjectIdentifierImpl <em>Object Identifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ObjectIdentifierImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getObjectIdentifier()
     * @generated
     */
    EClass OBJECT_IDENTIFIER = eINSTANCE.getObjectIdentifier();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT_IDENTIFIER__NAME = eINSTANCE.getObjectIdentifier_Name();

    /**
     * The meta object literal for the '<em><b>Oid Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_IDENTIFIER__OID_VALUE = eINSTANCE.getObjectIdentifier_OidValue();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ObjectIdentifierValueImpl <em>Object Identifier Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ObjectIdentifierValueImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getObjectIdentifierValue()
     * @generated
     */
    EClass OBJECT_IDENTIFIER_VALUE = eINSTANCE.getObjectIdentifierValue();

    /**
     * The meta object literal for the '<em><b>Descriptor Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REFERENCE = eINSTANCE.getObjectIdentifierValue_DescriptorReference();

    /**
     * The meta object literal for the '<em><b>Sub Ids</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT_IDENTIFIER_VALUE__SUB_IDS = eINSTANCE.getObjectIdentifierValue_SubIds();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.TypeDefinitionImpl <em>Type Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.TypeDefinitionImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeDefinition()
     * @generated
     */
    EClass TYPE_DEFINITION = eINSTANCE.getTypeDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_DEFINITION__NAME = eINSTANCE.getTypeDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Scope</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_DEFINITION__SCOPE = eINSTANCE.getTypeDefinition_Scope();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.MacroImpl <em>Macro</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.MacroImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getMacro()
     * @generated
     */
    EClass MACRO = eINSTANCE.getMacro();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MACRO__NAME = eINSTANCE.getMacro_Name();

    /**
     * The meta object literal for the '<em><b>Type Notations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO__TYPE_NOTATIONS = eINSTANCE.getMacro_TypeNotations();

    /**
     * The meta object literal for the '<em><b>Value Notation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO__VALUE_NOTATION = eINSTANCE.getMacro_ValueNotation();

    /**
     * The meta object literal for the '<em><b>Inner Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO__INNER_TYPES = eINSTANCE.getMacro_InnerTypes();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.TypeAssignmentImpl <em>Type Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.TypeAssignmentImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeAssignment()
     * @generated
     */
    EClass TYPE_ASSIGNMENT = eINSTANCE.getTypeAssignment();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ParamAssignmentImpl <em>Param Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ParamAssignmentImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getParamAssignment()
     * @generated
     */
    EClass PARAM_ASSIGNMENT = eINSTANCE.getParamAssignment();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAM_ASSIGNMENT__PARAM = eINSTANCE.getParamAssignment_Param();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAM_ASSIGNMENT__RIGHT = eINSTANCE.getParamAssignment_Right();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.TypeNotationImpl <em>Type Notation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.TypeNotationImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeNotation()
     * @generated
     */
    EClass TYPE_NOTATION = eINSTANCE.getTypeNotation();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_NOTATION__VALUE = eINSTANCE.getTypeNotation_Value();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.TypeReferenceExtImpl <em>Type Reference Ext</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.TypeReferenceExtImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeReferenceExt()
     * @generated
     */
    EClass TYPE_REFERENCE_EXT = eINSTANCE.getTypeReferenceExt();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.TypeReferenceImpl <em>Type Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.TypeReferenceImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeReference()
     * @generated
     */
    EClass TYPE_REFERENCE = eINSTANCE.getTypeReference();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_REFERENCE__RIGHT = eINSTANCE.getTypeReference_Right();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_REFERENCE__TYPE = eINSTANCE.getTypeReference_Type();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ScopeImpl <em>Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ScopeImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getScope()
     * @generated
     */
    EClass SCOPE = eINSTANCE.getScope();

    /**
     * The meta object literal for the '<em><b>Scope</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCOPE__SCOPE = eINSTANCE.getScope_Scope();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ValueImpl <em>Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ValueImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getValue()
     * @generated
     */
    EClass VALUE = eINSTANCE.getValue();

    /**
     * The meta object literal for the '<em><b>Value Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE__VALUE_TYPES = eINSTANCE.getValue_ValueTypes();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ValueTypeImpl <em>Value Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ValueTypeImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getValueType()
     * @generated
     */
    EClass VALUE_TYPE = eINSTANCE.getValueType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE_TYPE__NAME = eINSTANCE.getValueType_Name();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_TYPE__PARAM = eINSTANCE.getValueType_Param();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_TYPE__TYPE = eINSTANCE.getValueType_Type();

    /**
     * The meta object literal for the '<em><b>Simple Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_TYPE__SIMPLE_TYPE = eINSTANCE.getValueType_SimpleType();

    /**
     * The meta object literal for the '<em><b>Macro Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_TYPE__MACRO_VALUE = eINSTANCE.getValueType_MacroValue();

    /**
     * The meta object literal for the '<em><b>Oi</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE_TYPE__OI = eINSTANCE.getValueType_Oi();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.MacroValueImpl <em>Macro Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.MacroValueImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getMacroValue()
     * @generated
     */
    EClass MACRO_VALUE = eINSTANCE.getMacroValue();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO_VALUE__TYPE = eINSTANCE.getMacroValue_Type();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.MACRO_VALUE_TYPEImpl <em>MACRO VALUE TYPE</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.MACRO_VALUE_TYPEImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getMACRO_VALUE_TYPE()
     * @generated
     */
    EClass MACRO_VALUE_TYPE = eINSTANCE.getMACRO_VALUE_TYPE();

    /**
     * The meta object literal for the '<em><b>Val Literal</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO_VALUE_TYPE__VAL_LITERAL = eINSTANCE.getMACRO_VALUE_TYPE_ValLiteral();

    /**
     * The meta object literal for the '<em><b>Update</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO_VALUE_TYPE__UPDATE = eINSTANCE.getMACRO_VALUE_TYPE_Update();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.UpdateTypeImpl <em>Update Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.UpdateTypeImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getUpdateType()
     * @generated
     */
    EClass UPDATE_TYPE = eINSTANCE.getUpdateType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UPDATE_TYPE__TYPE = eINSTANCE.getUpdateType_Type();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.MACRO_VALUE_CAPImpl <em>MACRO VALUE CAP</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.MACRO_VALUE_CAPImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getMACRO_VALUE_CAP()
     * @generated
     */
    EClass MACRO_VALUE_CAP = eINSTANCE.getMACRO_VALUE_CAP();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MACRO_VALUE_CAP__VALUE = eINSTANCE.getMACRO_VALUE_CAP_Value();

    /**
     * The meta object literal for the '<em><b>Literal</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MACRO_VALUE_CAP__LITERAL = eINSTANCE.getMACRO_VALUE_CAP_Literal();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ASN1_TYPEImpl <em>ASN1 TYPE</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ASN1_TYPEImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_TYPE()
     * @generated
     */
    EClass ASN1_TYPE = eINSTANCE.getASN1_TYPE();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ASN1_SIMPLEImpl <em>ASN1 SIMPLE</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ASN1_SIMPLEImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_SIMPLE()
     * @generated
     */
    EClass ASN1_SIMPLE = eINSTANCE.getASN1_SIMPLE();

    /**
     * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASN1_SIMPLE__CONSTRAINT = eINSTANCE.getASN1_SIMPLE_Constraint();

    /**
     * The meta object literal for the '<em><b>Value Pairs</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASN1_SIMPLE__VALUE_PAIRS = eINSTANCE.getASN1_SIMPLE_ValuePairs();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ASN1_SUBTYPEImpl <em>ASN1 SUBTYPE</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ASN1_SUBTYPEImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_SUBTYPE()
     * @generated
     */
    EClass ASN1_SUBTYPE = eINSTANCE.getASN1_SUBTYPE();

    /**
     * The meta object literal for the '<em><b>Ranges</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASN1_SUBTYPE__RANGES = eINSTANCE.getASN1_SUBTYPE_Ranges();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ASN1_RANGEImpl <em>ASN1 RANGE</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ASN1_RANGEImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_RANGE()
     * @generated
     */
    EClass ASN1_RANGE = eINSTANCE.getASN1_RANGE();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASN1_RANGE__VALUE = eINSTANCE.getASN1_RANGE_Value();

    /**
     * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASN1_RANGE__START = eINSTANCE.getASN1_RANGE_Start();

    /**
     * The meta object literal for the '<em><b>End</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASN1_RANGE__END = eINSTANCE.getASN1_RANGE_End();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ASN1_CHOICEImpl <em>ASN1 CHOICE</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ASN1_CHOICEImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_CHOICE()
     * @generated
     */
    EClass ASN1_CHOICE = eINSTANCE.getASN1_CHOICE();

    /**
     * The meta object literal for the '<em><b>Choices</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASN1_CHOICE__CHOICES = eINSTANCE.getASN1_CHOICE_Choices();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ASN1_CHOICE_ENTRYImpl <em>ASN1 CHOICE ENTRY</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ASN1_CHOICE_ENTRYImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_CHOICE_ENTRY()
     * @generated
     */
    EClass ASN1_CHOICE_ENTRY = eINSTANCE.getASN1_CHOICE_ENTRY();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASN1_CHOICE_ENTRY__ID = eINSTANCE.getASN1_CHOICE_ENTRY_Id();

    /**
     * The meta object literal for the '<em><b>Value Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASN1_CHOICE_ENTRY__VALUE_TYPE = eINSTANCE.getASN1_CHOICE_ENTRY_ValueType();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ASN1_OCTET_STRINGImpl <em>ASN1 OCTET STRING</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ASN1_OCTET_STRINGImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_OCTET_STRING()
     * @generated
     */
    EClass ASN1_OCTET_STRING = eINSTANCE.getASN1_OCTET_STRING();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.VALUE_CAP_LITERALS <em>VALUE CAP LITERALS</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.VALUE_CAP_LITERALS
     * @see com.netxforge.smi.impl.SmiPackageImpl#getVALUE_CAP_LITERALS()
     * @generated
     */
    EEnum VALUE_CAP_LITERALS = eINSTANCE.getVALUE_CAP_LITERALS();

  }

} //SmiPackage
