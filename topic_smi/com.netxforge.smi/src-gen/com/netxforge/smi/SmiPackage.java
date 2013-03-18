/**
 * <copyright>
 * </copyright>
 *
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
   * The feature id for the '<em><b>Macros</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__MACROS = 0;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__TYPES = 1;

  /**
   * The number of structural features of the '<em>Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.MacroImpl <em>Macro</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.MacroImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getMacro()
   * @generated
   */
  int MACRO = 2;

  /**
   * The feature id for the '<em><b>Descriptor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__DESCRIPTOR = 0;

  /**
   * The feature id for the '<em><b>Type Notations</b></em>' reference list.
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
   * The meta object id for the '{@link com.netxforge.smi.impl.MacroValueImpl <em>Macro Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.MacroValueImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getMacroValue()
   * @generated
   */
  int MACRO_VALUE = 3;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
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
   * The meta object id for the '{@link com.netxforge.smi.impl.ValueAssignmentImpl <em>Value Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ValueAssignmentImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getValueAssignment()
   * @generated
   */
  int VALUE_ASSIGNMENT = 4;

  /**
   * The feature id for the '<em><b>Type Reference</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_ASSIGNMENT__TYPE_REFERENCE = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_ASSIGNMENT__VALUE = 1;

  /**
   * The number of structural features of the '<em>Value Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_ASSIGNMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.OrImpl <em>Or</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.OrImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getOr()
   * @generated
   */
  int OR = 5;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR__LEFT = 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR__RIGHT = 1;

  /**
   * The number of structural features of the '<em>Or</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ValueTypeImpl <em>Value Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ValueTypeImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getValueType()
   * @generated
   */
  int VALUE_TYPE = 6;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__LEFT = OR__LEFT;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__RIGHT = OR__RIGHT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__NAME = OR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__TYPE = OR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Simple Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__SIMPLE_TYPE = OR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Value Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE_FEATURE_COUNT = OR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_TYPEImpl <em>ASN1 TYPE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_TYPEImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_TYPE()
   * @generated
   */
  int ASN1_TYPE = 7;

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
  int ASN1_SIMPLE = 8;

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
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_CHOICEImpl <em>ASN1 CHOICE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_CHOICEImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_CHOICE()
   * @generated
   */
  int ASN1_CHOICE = 9;

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
  int ASN1_CHOICE_ENTRY = 10;

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
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_SUBTYPEImpl <em>ASN1 SUBTYPE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_SUBTYPEImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_SUBTYPE()
   * @generated
   */
  int ASN1_SUBTYPE = 11;

  /**
   * The feature id for the '<em><b>Range</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SUBTYPE__RANGE = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SUBTYPE__VALUE = 1;

  /**
   * The number of structural features of the '<em>ASN1 SUBTYPE</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SUBTYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_RANGEImpl <em>ASN1 RANGE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_RANGEImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_RANGE()
   * @generated
   */
  int ASN1_RANGE = 12;

  /**
   * The feature id for the '<em><b>Start</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_RANGE__START = 0;

  /**
   * The feature id for the '<em><b>End</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_RANGE__END = 1;

  /**
   * The number of structural features of the '<em>ASN1 RANGE</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_RANGE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ObjectIdentifierImpl <em>Object Identifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ObjectIdentifierImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getObjectIdentifier()
   * @generated
   */
  int OBJECT_IDENTIFIER = 13;

  /**
   * The feature id for the '<em><b>Macros</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_IDENTIFIER__MACROS = ASSIGNMENT__MACROS;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_IDENTIFIER__TYPES = ASSIGNMENT__TYPES;

  /**
   * The feature id for the '<em><b>Descriptor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_IDENTIFIER__DESCRIPTOR = ASSIGNMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Oid Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_IDENTIFIER__OID_VALUE = ASSIGNMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Object Identifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_IDENTIFIER_FEATURE_COUNT = ASSIGNMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ObjectIdentifierValueImpl <em>Object Identifier Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ObjectIdentifierValueImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getObjectIdentifierValue()
   * @generated
   */
  int OBJECT_IDENTIFIER_VALUE = 14;

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
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_OCTET_STRINGImpl <em>ASN1 OCTET STRING</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_OCTET_STRINGImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_OCTET_STRING()
   * @generated
   */
  int ASN1_OCTET_STRING = 15;

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
   * The meta object id for the '{@link com.netxforge.smi.MACRO_VALUE_TYPE <em>MACRO VALUE TYPE</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.MACRO_VALUE_TYPE
   * @see com.netxforge.smi.impl.SmiPackageImpl#getMACRO_VALUE_TYPE()
   * @generated
   */
  int MACRO_VALUE_TYPE = 16;

  /**
   * The meta object id for the '{@link com.netxforge.smi.WELL_KNOWN_NAMES <em>WELL KNOWN NAMES</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.WELL_KNOWN_NAMES
   * @see com.netxforge.smi.impl.SmiPackageImpl#getWELL_KNOWN_NAMES()
   * @generated
   */
  int WELL_KNOWN_NAMES = 17;


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
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.Assignment#getMacros <em>Macros</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Macros</em>'.
   * @see com.netxforge.smi.Assignment#getMacros()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Macros();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.Assignment#getTypes <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Types</em>'.
   * @see com.netxforge.smi.Assignment#getTypes()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Types();

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
   * Returns the meta object for the attribute '{@link com.netxforge.smi.Macro#getDescriptor <em>Descriptor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Descriptor</em>'.
   * @see com.netxforge.smi.Macro#getDescriptor()
   * @see #getMacro()
   * @generated
   */
  EAttribute getMacro_Descriptor();

  /**
   * Returns the meta object for the reference list '{@link com.netxforge.smi.Macro#getTypeNotations <em>Type Notations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Type Notations</em>'.
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
   * Returns the meta object for class '{@link com.netxforge.smi.MacroValue <em>Macro Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Macro Value</em>'.
   * @see com.netxforge.smi.MacroValue
   * @generated
   */
  EClass getMacroValue();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.MacroValue#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see com.netxforge.smi.MacroValue#getType()
   * @see #getMacroValue()
   * @generated
   */
  EAttribute getMacroValue_Type();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ValueAssignment <em>Value Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Assignment</em>'.
   * @see com.netxforge.smi.ValueAssignment
   * @generated
   */
  EClass getValueAssignment();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ValueAssignment#getTypeReference <em>Type Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Reference</em>'.
   * @see com.netxforge.smi.ValueAssignment#getTypeReference()
   * @see #getValueAssignment()
   * @generated
   */
  EAttribute getValueAssignment_TypeReference();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ValueAssignment#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see com.netxforge.smi.ValueAssignment#getValue()
   * @see #getValueAssignment()
   * @generated
   */
  EReference getValueAssignment_Value();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.Or <em>Or</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or</em>'.
   * @see com.netxforge.smi.Or
   * @generated
   */
  EClass getOr();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.Or#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.netxforge.smi.Or#getLeft()
   * @see #getOr()
   * @generated
   */
  EReference getOr_Left();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.Or#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.smi.Or#getRight()
   * @see #getOr()
   * @generated
   */
  EReference getOr_Right();

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
   * Returns the meta object for the reference '{@link com.netxforge.smi.ValueType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
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
   * Returns the meta object for class '{@link com.netxforge.smi.ASN1_SUBTYPE <em>ASN1 SUBTYPE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASN1 SUBTYPE</em>'.
   * @see com.netxforge.smi.ASN1_SUBTYPE
   * @generated
   */
  EClass getASN1_SUBTYPE();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ASN1_SUBTYPE#getRange <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Range</em>'.
   * @see com.netxforge.smi.ASN1_SUBTYPE#getRange()
   * @see #getASN1_SUBTYPE()
   * @generated
   */
  EReference getASN1_SUBTYPE_Range();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ASN1_SUBTYPE#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.netxforge.smi.ASN1_SUBTYPE#getValue()
   * @see #getASN1_SUBTYPE()
   * @generated
   */
  EAttribute getASN1_SUBTYPE_Value();

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
   * Returns the meta object for class '{@link com.netxforge.smi.ObjectIdentifier <em>Object Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Identifier</em>'.
   * @see com.netxforge.smi.ObjectIdentifier
   * @generated
   */
  EClass getObjectIdentifier();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ObjectIdentifier#getDescriptor <em>Descriptor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Descriptor</em>'.
   * @see com.netxforge.smi.ObjectIdentifier#getDescriptor()
   * @see #getObjectIdentifier()
   * @generated
   */
  EAttribute getObjectIdentifier_Descriptor();

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
   * Returns the meta object for class '{@link com.netxforge.smi.ASN1_OCTET_STRING <em>ASN1 OCTET STRING</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASN1 OCTET STRING</em>'.
   * @see com.netxforge.smi.ASN1_OCTET_STRING
   * @generated
   */
  EClass getASN1_OCTET_STRING();

  /**
   * Returns the meta object for enum '{@link com.netxforge.smi.MACRO_VALUE_TYPE <em>MACRO VALUE TYPE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>MACRO VALUE TYPE</em>'.
   * @see com.netxforge.smi.MACRO_VALUE_TYPE
   * @generated
   */
  EEnum getMACRO_VALUE_TYPE();

  /**
   * Returns the meta object for enum '{@link com.netxforge.smi.WELL_KNOWN_NAMES <em>WELL KNOWN NAMES</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>WELL KNOWN NAMES</em>'.
   * @see com.netxforge.smi.WELL_KNOWN_NAMES
   * @generated
   */
  EEnum getWELL_KNOWN_NAMES();

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
     * The meta object literal for the '<em><b>Macros</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__MACROS = eINSTANCE.getAssignment_Macros();

    /**
     * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__TYPES = eINSTANCE.getAssignment_Types();

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
     * The meta object literal for the '<em><b>Descriptor</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MACRO__DESCRIPTOR = eINSTANCE.getMacro_Descriptor();

    /**
     * The meta object literal for the '<em><b>Type Notations</b></em>' reference list feature.
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
     * The meta object literal for the '{@link com.netxforge.smi.impl.MacroValueImpl <em>Macro Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.MacroValueImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getMacroValue()
     * @generated
     */
    EClass MACRO_VALUE = eINSTANCE.getMacroValue();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MACRO_VALUE__TYPE = eINSTANCE.getMacroValue_Type();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ValueAssignmentImpl <em>Value Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ValueAssignmentImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getValueAssignment()
     * @generated
     */
    EClass VALUE_ASSIGNMENT = eINSTANCE.getValueAssignment();

    /**
     * The meta object literal for the '<em><b>Type Reference</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE_ASSIGNMENT__TYPE_REFERENCE = eINSTANCE.getValueAssignment_TypeReference();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_ASSIGNMENT__VALUE = eINSTANCE.getValueAssignment_Value();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.OrImpl <em>Or</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.OrImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getOr()
     * @generated
     */
    EClass OR = eINSTANCE.getOr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR__LEFT = eINSTANCE.getOr_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR__RIGHT = eINSTANCE.getOr_Right();

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
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
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
     * The meta object literal for the '{@link com.netxforge.smi.impl.ASN1_SUBTYPEImpl <em>ASN1 SUBTYPE</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ASN1_SUBTYPEImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_SUBTYPE()
     * @generated
     */
    EClass ASN1_SUBTYPE = eINSTANCE.getASN1_SUBTYPE();

    /**
     * The meta object literal for the '<em><b>Range</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASN1_SUBTYPE__RANGE = eINSTANCE.getASN1_SUBTYPE_Range();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASN1_SUBTYPE__VALUE = eINSTANCE.getASN1_SUBTYPE_Value();

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
     * The meta object literal for the '{@link com.netxforge.smi.impl.ObjectIdentifierImpl <em>Object Identifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ObjectIdentifierImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getObjectIdentifier()
     * @generated
     */
    EClass OBJECT_IDENTIFIER = eINSTANCE.getObjectIdentifier();

    /**
     * The meta object literal for the '<em><b>Descriptor</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT_IDENTIFIER__DESCRIPTOR = eINSTANCE.getObjectIdentifier_Descriptor();

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
     * The meta object literal for the '{@link com.netxforge.smi.impl.ASN1_OCTET_STRINGImpl <em>ASN1 OCTET STRING</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ASN1_OCTET_STRINGImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_OCTET_STRING()
     * @generated
     */
    EClass ASN1_OCTET_STRING = eINSTANCE.getASN1_OCTET_STRING();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.MACRO_VALUE_TYPE <em>MACRO VALUE TYPE</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.MACRO_VALUE_TYPE
     * @see com.netxforge.smi.impl.SmiPackageImpl#getMACRO_VALUE_TYPE()
     * @generated
     */
    EEnum MACRO_VALUE_TYPE = eINSTANCE.getMACRO_VALUE_TYPE();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.WELL_KNOWN_NAMES <em>WELL KNOWN NAMES</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.WELL_KNOWN_NAMES
     * @see com.netxforge.smi.impl.SmiPackageImpl#getWELL_KNOWN_NAMES()
     * @generated
     */
    EEnum WELL_KNOWN_NAMES = eINSTANCE.getWELL_KNOWN_NAMES();

  }

} //SmiPackage
