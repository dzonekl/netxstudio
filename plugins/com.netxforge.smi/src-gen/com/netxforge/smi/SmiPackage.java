/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EAttribute;
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
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__NAME = 0;

  /**
   * The feature id for the '<em><b>Identifiers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__IDENTIFIERS = 1;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__TYPES = 2;

  /**
   * The feature id for the '<em><b>Macros</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__MACROS = 3;

  /**
   * The number of structural features of the '<em>Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ObjectIdentifierImpl <em>Object Identifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ObjectIdentifierImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getObjectIdentifier()
   * @generated
   */
  int OBJECT_IDENTIFIER = 1;

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
  int OBJECT_IDENTIFIER_VALUE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_IDENTIFIER_VALUE__NAME = 0;

  /**
   * The feature id for the '<em><b>Descriptor Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REFERENCE = 1;

  /**
   * The feature id for the '<em><b>Sub Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_IDENTIFIER_VALUE__SUB_IDS = 2;

  /**
   * The number of structural features of the '<em>Object Identifier Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_IDENTIFIER_VALUE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.TypeDefinitionImpl <em>Type Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.TypeDefinitionImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeDefinition()
   * @generated
   */
  int TYPE_DEFINITION = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEFINITION__NAME = 0;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEFINITION__VALUES = 1;

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
  int MACRO = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__NAME = 0;

  /**
   * The feature id for the '<em><b>Type Notation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__TYPE_NOTATION = 1;

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
   * The meta object id for the '{@link com.netxforge.smi.impl.TypeNotationImpl <em>Type Notation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.TypeNotationImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeNotation()
   * @generated
   */
  int TYPE_NOTATION = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_NOTATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Type Notations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_NOTATION__TYPE_NOTATIONS = 1;

  /**
   * The number of structural features of the '<em>Type Notation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_NOTATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ValueNotationImpl <em>Value Notation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ValueNotationImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getValueNotation()
   * @generated
   */
  int VALUE_NOTATION = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_NOTATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Value Notation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_NOTATION__VALUE_NOTATION = 1;

  /**
   * The number of structural features of the '<em>Value Notation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_NOTATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.TypeNotationRightImpl <em>Type Notation Right</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.TypeNotationRightImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeNotationRight()
   * @generated
   */
  int TYPE_NOTATION_RIGHT = 9;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_NOTATION_RIGHT__VALUE = 0;

  /**
   * The number of structural features of the '<em>Type Notation Right</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_NOTATION_RIGHT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.TypeAssignmentImpl <em>Type Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.TypeAssignmentImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeAssignment()
   * @generated
   */
  int TYPE_ASSIGNMENT = 7;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ASSIGNMENT__VALUE = TYPE_NOTATION_RIGHT__VALUE;

  /**
   * The feature id for the '<em><b>Parent Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ASSIGNMENT__PARENT_REF = TYPE_NOTATION_RIGHT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Child Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ASSIGNMENT__CHILD_REF = TYPE_NOTATION_RIGHT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ASSIGNMENT__TYPE = TYPE_NOTATION_RIGHT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Type Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ASSIGNMENT_FEATURE_COUNT = TYPE_NOTATION_RIGHT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ParamAssignmentImpl <em>Param Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ParamAssignmentImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getParamAssignment()
   * @generated
   */
  int PARAM_ASSIGNMENT = 8;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_ASSIGNMENT__VALUE = TYPE_ASSIGNMENT__VALUE;

  /**
   * The feature id for the '<em><b>Parent Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_ASSIGNMENT__PARENT_REF = TYPE_ASSIGNMENT__PARENT_REF;

  /**
   * The feature id for the '<em><b>Child Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_ASSIGNMENT__CHILD_REF = TYPE_ASSIGNMENT__CHILD_REF;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_ASSIGNMENT__TYPE = TYPE_ASSIGNMENT__TYPE;

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
   * The meta object id for the '{@link com.netxforge.smi.impl.ValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ValueImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getValue()
   * @generated
   */
  int VALUE = 10;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__VALUE = TYPE_ASSIGNMENT__VALUE;

  /**
   * The feature id for the '<em><b>Parent Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__PARENT_REF = TYPE_ASSIGNMENT__PARENT_REF;

  /**
   * The feature id for the '<em><b>Child Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__CHILD_REF = TYPE_ASSIGNMENT__CHILD_REF;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__TYPE = TYPE_ASSIGNMENT__TYPE;

  /**
   * The feature id for the '<em><b>Tag</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__TAG = TYPE_ASSIGNMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Implicit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__IMPLICIT = TYPE_ASSIGNMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Value Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__VALUE_TYPES = TYPE_ASSIGNMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_FEATURE_COUNT = TYPE_ASSIGNMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.TagImpl <em>Tag</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.TagImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getTag()
   * @generated
   */
  int TAG = 11;

  /**
   * The feature id for the '<em><b>Tag Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAG__TAG_VALUE = 0;

  /**
   * The number of structural features of the '<em>Tag</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAG_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ValueTypeImpl <em>Value Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ValueTypeImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getValueType()
   * @generated
   */
  int VALUE_TYPE = 12;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__PARAM = 0;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__TYPES = 1;

  /**
   * The feature id for the '<em><b>Simple Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__SIMPLE_TYPE = 2;

  /**
   * The feature id for the '<em><b>Macro Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__MACRO_VALUE = 3;

  /**
   * The feature id for the '<em><b>Oi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__OI = 4;

  /**
   * The number of structural features of the '<em>Value Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.MACRO_VALUE_TYPEImpl <em>MACRO VALUE TYPE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.MACRO_VALUE_TYPEImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getMACRO_VALUE_TYPE()
   * @generated
   */
  int MACRO_VALUE_TYPE = 13;

  /**
   * The feature id for the '<em><b>Update</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_TYPE__UPDATE = 0;

  /**
   * The feature id for the '<em><b>Literal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_TYPE__LITERAL = 1;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_TYPE__STRING = 2;

  /**
   * The number of structural features of the '<em>MACRO VALUE TYPE</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_TYPE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.UpdateTypeImpl <em>Update Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.UpdateTypeImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getUpdateType()
   * @generated
   */
  int UPDATE_TYPE = 14;

  /**
   * The feature id for the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPDATE_TYPE__REF = 0;

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
  int MACRO_VALUE_CAP = 15;

  /**
   * The feature id for the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_CAP__REF = 0;

  /**
   * The number of structural features of the '<em>MACRO VALUE CAP</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_CAP_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_TYPEImpl <em>ASN1 TYPE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_TYPEImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_TYPE()
   * @generated
   */
  int ASN1_TYPE = 16;

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
  int ASN1_SIMPLE = 17;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SIMPLE__CONSTRAINT = ASN1_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SIMPLE__NAME = ASN1_TYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Range</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SIMPLE__RANGE = ASN1_TYPE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Ranges</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SIMPLE__RANGES = ASN1_TYPE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>ASN1 SIMPLE</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SIMPLE_FEATURE_COUNT = ASN1_TYPE_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_RANGEImpl <em>ASN1 RANGE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_RANGEImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_RANGE()
   * @generated
   */
  int ASN1_RANGE = 18;

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
  int ASN1_CHOICE = 19;

  /**
   * The feature id for the '<em><b>Choice Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_CHOICE__CHOICE_TYPE = ASN1_TYPE_FEATURE_COUNT + 0;

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
  int ASN1_CHOICE_ENTRY = 20;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_CHOICE_ENTRY__ID = 0;

  /**
   * The feature id for the '<em><b>Value Type</b></em>' containment reference.
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
   * The meta object id for the '{@link com.netxforge.smi.impl.ChoiceTypeImpl <em>Choice Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ChoiceTypeImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getChoiceType()
   * @generated
   */
  int CHOICE_TYPE = 21;

  /**
   * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE_TYPE__TYPE_REF = 0;

  /**
   * The feature id for the '<em><b>Simple Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE_TYPE__SIMPLE_TYPE = 1;

  /**
   * The feature id for the '<em><b>Oi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE_TYPE__OI = 2;

  /**
   * The number of structural features of the '<em>Choice Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE_TYPE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.MacroValueImpl <em>Macro Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.MacroValueImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getMacroValue()
   * @generated
   */
  int MACRO_VALUE = 22;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE__VALUE = VALUE__VALUE;

  /**
   * The feature id for the '<em><b>Parent Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE__PARENT_REF = VALUE__PARENT_REF;

  /**
   * The feature id for the '<em><b>Child Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE__CHILD_REF = VALUE__CHILD_REF;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE__TYPE = VALUE__TYPE;

  /**
   * The feature id for the '<em><b>Tag</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE__TAG = VALUE__TAG;

  /**
   * The feature id for the '<em><b>Implicit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE__IMPLICIT = VALUE__IMPLICIT;

  /**
   * The feature id for the '<em><b>Value Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE__VALUE_TYPES = VALUE__VALUE_TYPES;

  /**
   * The feature id for the '<em><b>Value Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE__VALUE_TYPE = VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Macro Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_OCTET_STRINGImpl <em>ASN1 OCTET STRING</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_OCTET_STRINGImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_OCTET_STRING()
   * @generated
   */
  int ASN1_OCTET_STRING = 23;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_OCTET_STRING__CONSTRAINT = ASN1_SIMPLE__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_OCTET_STRING__NAME = ASN1_SIMPLE__NAME;

  /**
   * The feature id for the '<em><b>Range</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_OCTET_STRING__RANGE = ASN1_SIMPLE__RANGE;

  /**
   * The feature id for the '<em><b>Ranges</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_OCTET_STRING__RANGES = ASN1_SIMPLE__RANGES;

  /**
   * The number of structural features of the '<em>ASN1 OCTET STRING</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_OCTET_STRING_FEATURE_COUNT = ASN1_SIMPLE_FEATURE_COUNT + 0;


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
   * Returns the meta object for the attribute '{@link com.netxforge.smi.Module#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.netxforge.smi.Module#getName()
   * @see #getModule()
   * @generated
   */
  EAttribute getModule_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.Module#getIdentifiers <em>Identifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Identifiers</em>'.
   * @see com.netxforge.smi.Module#getIdentifiers()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Identifiers();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.Module#getTypes <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Types</em>'.
   * @see com.netxforge.smi.Module#getTypes()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Types();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.Module#getMacros <em>Macros</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Macros</em>'.
   * @see com.netxforge.smi.Module#getMacros()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Macros();

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
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ObjectIdentifierValue#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.netxforge.smi.ObjectIdentifierValue#getName()
   * @see #getObjectIdentifierValue()
   * @generated
   */
  EAttribute getObjectIdentifierValue_Name();

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
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.TypeDefinition#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see com.netxforge.smi.TypeDefinition#getValues()
   * @see #getTypeDefinition()
   * @generated
   */
  EReference getTypeDefinition_Values();

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
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.Macro#getTypeNotation <em>Type Notation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type Notation</em>'.
   * @see com.netxforge.smi.Macro#getTypeNotation()
   * @see #getMacro()
   * @generated
   */
  EReference getMacro_TypeNotation();

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
   * Returns the meta object for class '{@link com.netxforge.smi.TypeNotation <em>Type Notation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Notation</em>'.
   * @see com.netxforge.smi.TypeNotation
   * @generated
   */
  EClass getTypeNotation();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.TypeNotation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.netxforge.smi.TypeNotation#getName()
   * @see #getTypeNotation()
   * @generated
   */
  EAttribute getTypeNotation_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.TypeNotation#getTypeNotations <em>Type Notations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type Notations</em>'.
   * @see com.netxforge.smi.TypeNotation#getTypeNotations()
   * @see #getTypeNotation()
   * @generated
   */
  EReference getTypeNotation_TypeNotations();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ValueNotation <em>Value Notation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Notation</em>'.
   * @see com.netxforge.smi.ValueNotation
   * @generated
   */
  EClass getValueNotation();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ValueNotation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.netxforge.smi.ValueNotation#getName()
   * @see #getValueNotation()
   * @generated
   */
  EAttribute getValueNotation_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ValueNotation#getValueNotation <em>Value Notation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value Notation</em>'.
   * @see com.netxforge.smi.ValueNotation#getValueNotation()
   * @see #getValueNotation()
   * @generated
   */
  EReference getValueNotation_ValueNotation();

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
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.TypeAssignment#getParentRef <em>Parent Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parent Ref</em>'.
   * @see com.netxforge.smi.TypeAssignment#getParentRef()
   * @see #getTypeAssignment()
   * @generated
   */
  EReference getTypeAssignment_ParentRef();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.TypeAssignment#getChildRef <em>Child Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Child Ref</em>'.
   * @see com.netxforge.smi.TypeAssignment#getChildRef()
   * @see #getTypeAssignment()
   * @generated
   */
  EReference getTypeAssignment_ChildRef();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.smi.TypeAssignment#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see com.netxforge.smi.TypeAssignment#getType()
   * @see #getTypeAssignment()
   * @generated
   */
  EReference getTypeAssignment_Type();

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
   * Returns the meta object for class '{@link com.netxforge.smi.TypeNotationRight <em>Type Notation Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Notation Right</em>'.
   * @see com.netxforge.smi.TypeNotationRight
   * @generated
   */
  EClass getTypeNotationRight();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.TypeNotationRight#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see com.netxforge.smi.TypeNotationRight#getValue()
   * @see #getTypeNotationRight()
   * @generated
   */
  EReference getTypeNotationRight_Value();

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
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.Value#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tag</em>'.
   * @see com.netxforge.smi.Value#getTag()
   * @see #getValue()
   * @generated
   */
  EReference getValue_Tag();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.Value#isImplicit <em>Implicit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Implicit</em>'.
   * @see com.netxforge.smi.Value#isImplicit()
   * @see #getValue()
   * @generated
   */
  EAttribute getValue_Implicit();

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
   * Returns the meta object for class '{@link com.netxforge.smi.Tag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tag</em>'.
   * @see com.netxforge.smi.Tag
   * @generated
   */
  EClass getTag();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.Tag#getTagValue <em>Tag Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tag Value</em>'.
   * @see com.netxforge.smi.Tag#getTagValue()
   * @see #getTag()
   * @generated
   */
  EAttribute getTag_TagValue();

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
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ValueType#getTypes <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Types</em>'.
   * @see com.netxforge.smi.ValueType#getTypes()
   * @see #getValueType()
   * @generated
   */
  EReference getValueType_Types();

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
   * Returns the meta object for class '{@link com.netxforge.smi.MACRO_VALUE_TYPE <em>MACRO VALUE TYPE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MACRO VALUE TYPE</em>'.
   * @see com.netxforge.smi.MACRO_VALUE_TYPE
   * @generated
   */
  EClass getMACRO_VALUE_TYPE();

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
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.MACRO_VALUE_TYPE#getLiteral <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Literal</em>'.
   * @see com.netxforge.smi.MACRO_VALUE_TYPE#getLiteral()
   * @see #getMACRO_VALUE_TYPE()
   * @generated
   */
  EReference getMACRO_VALUE_TYPE_Literal();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.MACRO_VALUE_TYPE#getString <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String</em>'.
   * @see com.netxforge.smi.MACRO_VALUE_TYPE#getString()
   * @see #getMACRO_VALUE_TYPE()
   * @generated
   */
  EAttribute getMACRO_VALUE_TYPE_String();

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
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.UpdateType#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ref</em>'.
   * @see com.netxforge.smi.UpdateType#getRef()
   * @see #getUpdateType()
   * @generated
   */
  EReference getUpdateType_Ref();

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
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.MACRO_VALUE_CAP#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ref</em>'.
   * @see com.netxforge.smi.MACRO_VALUE_CAP#getRef()
   * @see #getMACRO_VALUE_CAP()
   * @generated
   */
  EReference getMACRO_VALUE_CAP_Ref();

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
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ASN1_SIMPLE#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.netxforge.smi.ASN1_SIMPLE#getName()
   * @see #getASN1_SIMPLE()
   * @generated
   */
  EAttribute getASN1_SIMPLE_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ASN1_SIMPLE#getRange <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Range</em>'.
   * @see com.netxforge.smi.ASN1_SIMPLE#getRange()
   * @see #getASN1_SIMPLE()
   * @generated
   */
  EReference getASN1_SIMPLE_Range();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.ASN1_SIMPLE#getRanges <em>Ranges</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ranges</em>'.
   * @see com.netxforge.smi.ASN1_SIMPLE#getRanges()
   * @see #getASN1_SIMPLE()
   * @generated
   */
  EReference getASN1_SIMPLE_Ranges();

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
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.ASN1_CHOICE#getChoiceType <em>Choice Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Choice Type</em>'.
   * @see com.netxforge.smi.ASN1_CHOICE#getChoiceType()
   * @see #getASN1_CHOICE()
   * @generated
   */
  EReference getASN1_CHOICE_ChoiceType();

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
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ASN1_CHOICE_ENTRY#getValueType <em>Value Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value Type</em>'.
   * @see com.netxforge.smi.ASN1_CHOICE_ENTRY#getValueType()
   * @see #getASN1_CHOICE_ENTRY()
   * @generated
   */
  EReference getASN1_CHOICE_ENTRY_ValueType();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ChoiceType <em>Choice Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Choice Type</em>'.
   * @see com.netxforge.smi.ChoiceType
   * @generated
   */
  EClass getChoiceType();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ChoiceType#getTypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type Ref</em>'.
   * @see com.netxforge.smi.ChoiceType#getTypeRef()
   * @see #getChoiceType()
   * @generated
   */
  EReference getChoiceType_TypeRef();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ChoiceType#getSimpleType <em>Simple Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Simple Type</em>'.
   * @see com.netxforge.smi.ChoiceType#getSimpleType()
   * @see #getChoiceType()
   * @generated
   */
  EReference getChoiceType_SimpleType();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ChoiceType#getOi <em>Oi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Oi</em>'.
   * @see com.netxforge.smi.ChoiceType#getOi()
   * @see #getChoiceType()
   * @generated
   */
  EAttribute getChoiceType_Oi();

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
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.MacroValue#getValueType <em>Value Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value Type</em>'.
   * @see com.netxforge.smi.MacroValue#getValueType()
   * @see #getMacroValue()
   * @generated
   */
  EReference getMacroValue_ValueType();

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
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE__NAME = eINSTANCE.getModule_Name();

    /**
     * The meta object literal for the '<em><b>Identifiers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__IDENTIFIERS = eINSTANCE.getModule_Identifiers();

    /**
     * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__TYPES = eINSTANCE.getModule_Types();

    /**
     * The meta object literal for the '<em><b>Macros</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__MACROS = eINSTANCE.getModule_Macros();

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
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT_IDENTIFIER_VALUE__NAME = eINSTANCE.getObjectIdentifierValue_Name();

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
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_DEFINITION__VALUES = eINSTANCE.getTypeDefinition_Values();

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
     * The meta object literal for the '<em><b>Type Notation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO__TYPE_NOTATION = eINSTANCE.getMacro_TypeNotation();

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
     * The meta object literal for the '{@link com.netxforge.smi.impl.TypeNotationImpl <em>Type Notation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.TypeNotationImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeNotation()
     * @generated
     */
    EClass TYPE_NOTATION = eINSTANCE.getTypeNotation();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_NOTATION__NAME = eINSTANCE.getTypeNotation_Name();

    /**
     * The meta object literal for the '<em><b>Type Notations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_NOTATION__TYPE_NOTATIONS = eINSTANCE.getTypeNotation_TypeNotations();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ValueNotationImpl <em>Value Notation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ValueNotationImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getValueNotation()
     * @generated
     */
    EClass VALUE_NOTATION = eINSTANCE.getValueNotation();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE_NOTATION__NAME = eINSTANCE.getValueNotation_Name();

    /**
     * The meta object literal for the '<em><b>Value Notation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_NOTATION__VALUE_NOTATION = eINSTANCE.getValueNotation_ValueNotation();

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
     * The meta object literal for the '<em><b>Parent Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_ASSIGNMENT__PARENT_REF = eINSTANCE.getTypeAssignment_ParentRef();

    /**
     * The meta object literal for the '<em><b>Child Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_ASSIGNMENT__CHILD_REF = eINSTANCE.getTypeAssignment_ChildRef();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_ASSIGNMENT__TYPE = eINSTANCE.getTypeAssignment_Type();

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
     * The meta object literal for the '{@link com.netxforge.smi.impl.TypeNotationRightImpl <em>Type Notation Right</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.TypeNotationRightImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeNotationRight()
     * @generated
     */
    EClass TYPE_NOTATION_RIGHT = eINSTANCE.getTypeNotationRight();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_NOTATION_RIGHT__VALUE = eINSTANCE.getTypeNotationRight_Value();

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
     * The meta object literal for the '<em><b>Tag</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE__TAG = eINSTANCE.getValue_Tag();

    /**
     * The meta object literal for the '<em><b>Implicit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE__IMPLICIT = eINSTANCE.getValue_Implicit();

    /**
     * The meta object literal for the '<em><b>Value Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE__VALUE_TYPES = eINSTANCE.getValue_ValueTypes();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.TagImpl <em>Tag</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.TagImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getTag()
     * @generated
     */
    EClass TAG = eINSTANCE.getTag();

    /**
     * The meta object literal for the '<em><b>Tag Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TAG__TAG_VALUE = eINSTANCE.getTag_TagValue();

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
     * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_TYPE__PARAM = eINSTANCE.getValueType_Param();

    /**
     * The meta object literal for the '<em><b>Types</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_TYPE__TYPES = eINSTANCE.getValueType_Types();

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
     * The meta object literal for the '{@link com.netxforge.smi.impl.MACRO_VALUE_TYPEImpl <em>MACRO VALUE TYPE</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.MACRO_VALUE_TYPEImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getMACRO_VALUE_TYPE()
     * @generated
     */
    EClass MACRO_VALUE_TYPE = eINSTANCE.getMACRO_VALUE_TYPE();

    /**
     * The meta object literal for the '<em><b>Update</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO_VALUE_TYPE__UPDATE = eINSTANCE.getMACRO_VALUE_TYPE_Update();

    /**
     * The meta object literal for the '<em><b>Literal</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO_VALUE_TYPE__LITERAL = eINSTANCE.getMACRO_VALUE_TYPE_Literal();

    /**
     * The meta object literal for the '<em><b>String</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MACRO_VALUE_TYPE__STRING = eINSTANCE.getMACRO_VALUE_TYPE_String();

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
     * The meta object literal for the '<em><b>Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UPDATE_TYPE__REF = eINSTANCE.getUpdateType_Ref();

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
     * The meta object literal for the '<em><b>Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO_VALUE_CAP__REF = eINSTANCE.getMACRO_VALUE_CAP_Ref();

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
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASN1_SIMPLE__NAME = eINSTANCE.getASN1_SIMPLE_Name();

    /**
     * The meta object literal for the '<em><b>Range</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASN1_SIMPLE__RANGE = eINSTANCE.getASN1_SIMPLE_Range();

    /**
     * The meta object literal for the '<em><b>Ranges</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASN1_SIMPLE__RANGES = eINSTANCE.getASN1_SIMPLE_Ranges();

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
     * The meta object literal for the '<em><b>Choice Type</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASN1_CHOICE__CHOICE_TYPE = eINSTANCE.getASN1_CHOICE_ChoiceType();

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
     * The meta object literal for the '<em><b>Value Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASN1_CHOICE_ENTRY__VALUE_TYPE = eINSTANCE.getASN1_CHOICE_ENTRY_ValueType();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ChoiceTypeImpl <em>Choice Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ChoiceTypeImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getChoiceType()
     * @generated
     */
    EClass CHOICE_TYPE = eINSTANCE.getChoiceType();

    /**
     * The meta object literal for the '<em><b>Type Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHOICE_TYPE__TYPE_REF = eINSTANCE.getChoiceType_TypeRef();

    /**
     * The meta object literal for the '<em><b>Simple Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHOICE_TYPE__SIMPLE_TYPE = eINSTANCE.getChoiceType_SimpleType();

    /**
     * The meta object literal for the '<em><b>Oi</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHOICE_TYPE__OI = eINSTANCE.getChoiceType_Oi();

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
     * The meta object literal for the '<em><b>Value Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO_VALUE__VALUE_TYPE = eINSTANCE.getMacroValue_ValueType();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ASN1_OCTET_STRINGImpl <em>ASN1 OCTET STRING</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ASN1_OCTET_STRINGImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_OCTET_STRING()
     * @generated
     */
    EClass ASN1_OCTET_STRING = eINSTANCE.getASN1_OCTET_STRING();

  }

} //SmiPackage
