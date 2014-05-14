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
   * The feature id for the '<em><b>Imports</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__IMPORTS = 1;

  /**
   * The feature id for the '<em><b>Objects</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__OBJECTS = 2;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__TYPES = 3;

  /**
   * The number of structural features of the '<em>Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ImportsImpl <em>Imports</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ImportsImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getImports()
   * @generated
   */
  int IMPORTS = 1;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORTS__IMPORTS = 0;

  /**
   * The number of structural features of the '<em>Imports</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORTS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ImportClosureImpl <em>Import Closure</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ImportClosureImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getImportClosure()
   * @generated
   */
  int IMPORT_CLOSURE = 2;

  /**
   * The feature id for the '<em><b>Refs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_CLOSURE__REFS = 0;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_CLOSURE__IMPORT_URI = 1;

  /**
   * The number of structural features of the '<em>Import Closure</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_CLOSURE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ImportRefsImpl <em>Import Refs</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ImportRefsImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getImportRefs()
   * @generated
   */
  int IMPORT_REFS = 3;

  /**
   * The feature id for the '<em><b>Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_REFS__REFS = 0;

  /**
   * The number of structural features of the '<em>Import Refs</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_REFS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ImportRefImpl <em>Import Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ImportRefImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getImportRef()
   * @generated
   */
  int IMPORT_REF = 4;

  /**
   * The feature id for the '<em><b>Oi Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_REF__OI_REF = 0;

  /**
   * The feature id for the '<em><b>Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_REF__TYPE_REF = 1;

  /**
   * The number of structural features of the '<em>Import Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_REF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ObjectReferenceableImpl <em>Object Referenceable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ObjectReferenceableImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getObjectReferenceable()
   * @generated
   */
  int OBJECT_REFERENCEABLE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REFERENCEABLE__NAME = 0;

  /**
   * The feature id for the '<em><b>Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REFERENCEABLE__OBJECT = 1;

  /**
   * The feature id for the '<em><b>Object Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REFERENCEABLE__OBJECT_VALUE = 2;

  /**
   * The number of structural features of the '<em>Object Referenceable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REFERENCEABLE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ObjectImpl <em>Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ObjectImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getObject()
   * @generated
   */
  int OBJECT = 6;

  /**
   * The feature id for the '<em><b>Macro Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT__MACRO_REF = 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT__ATTRIBUTES = 1;

  /**
   * The number of structural features of the '<em>Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ObjectReferenceImpl <em>Object Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ObjectReferenceImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getObjectReference()
   * @generated
   */
  int OBJECT_REFERENCE = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REFERENCE__NAME = 0;

  /**
   * The feature id for the '<em><b>Descriptor Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REFERENCE__DESCRIPTOR_REF = 1;

  /**
   * The feature id for the '<em><b>Sub Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REFERENCE__SUB_IDS = 2;

  /**
   * The number of structural features of the '<em>Object Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REFERENCE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.AttributeImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 8;

  /**
   * The feature id for the '<em><b>Param Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__PARAM_REF = 0;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__VALUES = 1;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.AttributeValueImpl <em>Attribute Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.AttributeValueImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getAttributeValue()
   * @generated
   */
  int ATTRIBUTE_VALUE = 9;

  /**
   * The feature id for the '<em><b>Identifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_VALUE__IDENTIFIER = 0;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_VALUE__TEXT = 1;

  /**
   * The feature id for the '<em><b>Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_VALUE__TYPE_REF = 2;

  /**
   * The feature id for the '<em><b>Sub Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_VALUE__SUB_TYPE = 3;

  /**
   * The feature id for the '<em><b>Object Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_VALUE__OBJECT_REF = 4;

  /**
   * The feature id for the '<em><b>Integer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_VALUE__INTEGER = 5;

  /**
   * The feature id for the '<em><b>Sequence Of</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_VALUE__SEQUENCE_OF = 6;

  /**
   * The number of structural features of the '<em>Attribute Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_VALUE_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.IdentifierImpl <em>Identifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.IdentifierImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getIdentifier()
   * @generated
   */
  int IDENTIFIER = 10;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__ID = 0;

  /**
   * The number of structural features of the '<em>Identifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.BracedObjectReferenceImpl <em>Braced Object Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.BracedObjectReferenceImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getBracedObjectReference()
   * @generated
   */
  int BRACED_OBJECT_REFERENCE = 11;

  /**
   * The feature id for the '<em><b>Object Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BRACED_OBJECT_REFERENCE__OBJECT_REF = 0;

  /**
   * The number of structural features of the '<em>Braced Object Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BRACED_OBJECT_REFERENCE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.TypeNotationRightImpl <em>Type Notation Right</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.TypeNotationRightImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeNotationRight()
   * @generated
   */
  int TYPE_NOTATION_RIGHT = 16;

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
  int TYPE_ASSIGNMENT = 15;

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
   * The meta object id for the '{@link com.netxforge.smi.impl.ReferenceableImpl <em>Referenceable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ReferenceableImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getReferenceable()
   * @generated
   */
  int REFERENCEABLE = 12;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCEABLE__VALUE = TYPE_ASSIGNMENT__VALUE;

  /**
   * The feature id for the '<em><b>Parent Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCEABLE__PARENT_REF = TYPE_ASSIGNMENT__PARENT_REF;

  /**
   * The feature id for the '<em><b>Child Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCEABLE__CHILD_REF = TYPE_ASSIGNMENT__CHILD_REF;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCEABLE__TYPE = TYPE_ASSIGNMENT__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCEABLE__NAME = TYPE_ASSIGNMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCEABLE__VALUES = TYPE_ASSIGNMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type Notation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCEABLE__TYPE_NOTATION = TYPE_ASSIGNMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Value Notation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCEABLE__VALUE_NOTATION = TYPE_ASSIGNMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Inner Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCEABLE__INNER_TYPES = TYPE_ASSIGNMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCEABLE__RIGHT = TYPE_ASSIGNMENT_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Referenceable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCEABLE_FEATURE_COUNT = TYPE_ASSIGNMENT_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.TypeNotationImpl <em>Type Notation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.TypeNotationImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getTypeNotation()
   * @generated
   */
  int TYPE_NOTATION = 13;

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
  int VALUE_NOTATION = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_NOTATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Value Notations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_NOTATION__VALUE_NOTATIONS = 1;

  /**
   * The number of structural features of the '<em>Value Notation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_NOTATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ValueAssignmentImpl <em>Value Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ValueAssignmentImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getValueAssignment()
   * @generated
   */
  int VALUE_ASSIGNMENT = 17;

  /**
   * The feature id for the '<em><b>Value Notation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_ASSIGNMENT__VALUE_NOTATION = 0;

  /**
   * The number of structural features of the '<em>Value Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_ASSIGNMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ValueImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getValue()
   * @generated
   */
  int VALUE = 18;

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
  int TAG = 19;

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
  int VALUE_TYPE = 20;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__PARAM = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__ID = 1;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE__TYPES = 2;

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
   * The number of structural features of the '<em>Value Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_TYPE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.MacroValueTypeImpl <em>Macro Value Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.MacroValueTypeImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getMacroValueType()
   * @generated
   */
  int MACRO_VALUE_TYPE = 21;

  /**
   * The feature id for the '<em><b>Update</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_TYPE__UPDATE = 0;

  /**
   * The feature id for the '<em><b>Value CAP</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_TYPE__VALUE_CAP = 1;

  /**
   * The feature id for the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_TYPE__REF = 2;

  /**
   * The feature id for the '<em><b>Oi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_TYPE__OI = 3;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_TYPE__STRING = 4;

  /**
   * The number of structural features of the '<em>Macro Value Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_VALUE_TYPE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_TYPEImpl <em>ASN1 TYPE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_TYPEImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_TYPE()
   * @generated
   */
  int ASN1_TYPE = 22;

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
  int ASN1_SIMPLE = 23;

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
   * The feature id for the '<em><b>Refinement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SIMPLE__REFINEMENT = ASN1_TYPE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Ranges</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SIMPLE__RANGES = ASN1_TYPE_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>ASN1 SIMPLE</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SIMPLE_FEATURE_COUNT = ASN1_TYPE_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_INTEGER_REFINEMENTImpl <em>ASN1 INTEGER REFINEMENT</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_INTEGER_REFINEMENTImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_INTEGER_REFINEMENT()
   * @generated
   */
  int ASN1_INTEGER_REFINEMENT = 24;

  /**
   * The feature id for the '<em><b>Refinements</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_INTEGER_REFINEMENT__REFINEMENTS = 0;

  /**
   * The feature id for the '<em><b>Ints</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_INTEGER_REFINEMENT__INTS = 1;

  /**
   * The number of structural features of the '<em>ASN1 INTEGER REFINEMENT</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_INTEGER_REFINEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_RANGEImpl <em>ASN1 RANGE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_RANGEImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_RANGE()
   * @generated
   */
  int ASN1_RANGE = 25;

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
  int ASN1_CHOICE = 26;

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
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_SEQUENCEImpl <em>ASN1 SEQUENCE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_SEQUENCEImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_SEQUENCE()
   * @generated
   */
  int ASN1_SEQUENCE = 27;

  /**
   * The feature id for the '<em><b>Choice Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SEQUENCE__CHOICE_TYPE = ASN1_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>ASN1 SEQUENCE</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SEQUENCE_FEATURE_COUNT = ASN1_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_SEQUENCE_OFImpl <em>ASN1 SEQUENCE OF</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_SEQUENCE_OFImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_SEQUENCE_OF()
   * @generated
   */
  int ASN1_SEQUENCE_OF = 28;

  /**
   * The feature id for the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SEQUENCE_OF__REF = 0;

  /**
   * The number of structural features of the '<em>ASN1 SEQUENCE OF</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_SEQUENCE_OF_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.ASN1_CHOICE_ENTRYImpl <em>ASN1 CHOICE ENTRY</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.ASN1_CHOICE_ENTRYImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_CHOICE_ENTRY()
   * @generated
   */
  int ASN1_CHOICE_ENTRY = 29;

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
  int CHOICE_TYPE = 30;

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
   * The number of structural features of the '<em>Choice Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.smi.impl.MacroValueImpl <em>Macro Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.smi.impl.MacroValueImpl
   * @see com.netxforge.smi.impl.SmiPackageImpl#getMacroValue()
   * @generated
   */
  int MACRO_VALUE = 31;

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
  int ASN1_OCTET_STRING = 32;

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
   * The feature id for the '<em><b>Refinement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASN1_OCTET_STRING__REFINEMENT = ASN1_SIMPLE__REFINEMENT;

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
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.Module#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Imports</em>'.
   * @see com.netxforge.smi.Module#getImports()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.Module#getObjects <em>Objects</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Objects</em>'.
   * @see com.netxforge.smi.Module#getObjects()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Objects();

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
   * Returns the meta object for class '{@link com.netxforge.smi.Imports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Imports</em>'.
   * @see com.netxforge.smi.Imports
   * @generated
   */
  EClass getImports();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.Imports#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see com.netxforge.smi.Imports#getImports()
   * @see #getImports()
   * @generated
   */
  EReference getImports_Imports();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ImportClosure <em>Import Closure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import Closure</em>'.
   * @see com.netxforge.smi.ImportClosure
   * @generated
   */
  EClass getImportClosure();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ImportClosure#getRefs <em>Refs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Refs</em>'.
   * @see com.netxforge.smi.ImportClosure#getRefs()
   * @see #getImportClosure()
   * @generated
   */
  EReference getImportClosure_Refs();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ImportClosure#getImportURI <em>Import URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import URI</em>'.
   * @see com.netxforge.smi.ImportClosure#getImportURI()
   * @see #getImportClosure()
   * @generated
   */
  EAttribute getImportClosure_ImportURI();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ImportRefs <em>Import Refs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import Refs</em>'.
   * @see com.netxforge.smi.ImportRefs
   * @generated
   */
  EClass getImportRefs();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.ImportRefs#getRefs <em>Refs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Refs</em>'.
   * @see com.netxforge.smi.ImportRefs#getRefs()
   * @see #getImportRefs()
   * @generated
   */
  EReference getImportRefs_Refs();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ImportRef <em>Import Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import Ref</em>'.
   * @see com.netxforge.smi.ImportRef
   * @generated
   */
  EClass getImportRef();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.smi.ImportRef#getOiRef <em>Oi Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Oi Ref</em>'.
   * @see com.netxforge.smi.ImportRef#getOiRef()
   * @see #getImportRef()
   * @generated
   */
  EReference getImportRef_OiRef();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.smi.ImportRef#getTypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type Ref</em>'.
   * @see com.netxforge.smi.ImportRef#getTypeRef()
   * @see #getImportRef()
   * @generated
   */
  EReference getImportRef_TypeRef();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ObjectReferenceable <em>Object Referenceable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Referenceable</em>'.
   * @see com.netxforge.smi.ObjectReferenceable
   * @generated
   */
  EClass getObjectReferenceable();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ObjectReferenceable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.netxforge.smi.ObjectReferenceable#getName()
   * @see #getObjectReferenceable()
   * @generated
   */
  EAttribute getObjectReferenceable_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ObjectReferenceable#getObject <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Object</em>'.
   * @see com.netxforge.smi.ObjectReferenceable#getObject()
   * @see #getObjectReferenceable()
   * @generated
   */
  EReference getObjectReferenceable_Object();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ObjectReferenceable#getObjectValue <em>Object Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Object Value</em>'.
   * @see com.netxforge.smi.ObjectReferenceable#getObjectValue()
   * @see #getObjectReferenceable()
   * @generated
   */
  EReference getObjectReferenceable_ObjectValue();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.Object <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object</em>'.
   * @see com.netxforge.smi.Object
   * @generated
   */
  EClass getObject();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.smi.Object#getMacroRef <em>Macro Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Macro Ref</em>'.
   * @see com.netxforge.smi.Object#getMacroRef()
   * @see #getObject()
   * @generated
   */
  EReference getObject_MacroRef();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.Object#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see com.netxforge.smi.Object#getAttributes()
   * @see #getObject()
   * @generated
   */
  EReference getObject_Attributes();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ObjectReference <em>Object Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Reference</em>'.
   * @see com.netxforge.smi.ObjectReference
   * @generated
   */
  EClass getObjectReference();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ObjectReference#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.netxforge.smi.ObjectReference#getName()
   * @see #getObjectReference()
   * @generated
   */
  EAttribute getObjectReference_Name();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.smi.ObjectReference#getDescriptorRef <em>Descriptor Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Descriptor Ref</em>'.
   * @see com.netxforge.smi.ObjectReference#getDescriptorRef()
   * @see #getObjectReference()
   * @generated
   */
  EReference getObjectReference_DescriptorRef();

  /**
   * Returns the meta object for the attribute list '{@link com.netxforge.smi.ObjectReference#getSubIds <em>Sub Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Sub Ids</em>'.
   * @see com.netxforge.smi.ObjectReference#getSubIds()
   * @see #getObjectReference()
   * @generated
   */
  EAttribute getObjectReference_SubIds();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see com.netxforge.smi.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.smi.Attribute#getParamRef <em>Param Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Param Ref</em>'.
   * @see com.netxforge.smi.Attribute#getParamRef()
   * @see #getAttribute()
   * @generated
   */
  EReference getAttribute_ParamRef();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.Attribute#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Values</em>'.
   * @see com.netxforge.smi.Attribute#getValues()
   * @see #getAttribute()
   * @generated
   */
  EReference getAttribute_Values();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.AttributeValue <em>Attribute Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Value</em>'.
   * @see com.netxforge.smi.AttributeValue
   * @generated
   */
  EClass getAttributeValue();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.AttributeValue#getIdentifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Identifier</em>'.
   * @see com.netxforge.smi.AttributeValue#getIdentifier()
   * @see #getAttributeValue()
   * @generated
   */
  EReference getAttributeValue_Identifier();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.AttributeValue#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text</em>'.
   * @see com.netxforge.smi.AttributeValue#getText()
   * @see #getAttributeValue()
   * @generated
   */
  EAttribute getAttributeValue_Text();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.smi.AttributeValue#getTypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type Ref</em>'.
   * @see com.netxforge.smi.AttributeValue#getTypeRef()
   * @see #getAttributeValue()
   * @generated
   */
  EReference getAttributeValue_TypeRef();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.AttributeValue#getSubType <em>Sub Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sub Type</em>'.
   * @see com.netxforge.smi.AttributeValue#getSubType()
   * @see #getAttributeValue()
   * @generated
   */
  EReference getAttributeValue_SubType();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.AttributeValue#getObjectRef <em>Object Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Object Ref</em>'.
   * @see com.netxforge.smi.AttributeValue#getObjectRef()
   * @see #getAttributeValue()
   * @generated
   */
  EReference getAttributeValue_ObjectRef();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.AttributeValue#getInteger <em>Integer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Integer</em>'.
   * @see com.netxforge.smi.AttributeValue#getInteger()
   * @see #getAttributeValue()
   * @generated
   */
  EReference getAttributeValue_Integer();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.AttributeValue#getSequenceOf <em>Sequence Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sequence Of</em>'.
   * @see com.netxforge.smi.AttributeValue#getSequenceOf()
   * @see #getAttributeValue()
   * @generated
   */
  EReference getAttributeValue_SequenceOf();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.Identifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Identifier</em>'.
   * @see com.netxforge.smi.Identifier
   * @generated
   */
  EClass getIdentifier();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.Identifier#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see com.netxforge.smi.Identifier#getId()
   * @see #getIdentifier()
   * @generated
   */
  EAttribute getIdentifier_Id();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.BracedObjectReference <em>Braced Object Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Braced Object Reference</em>'.
   * @see com.netxforge.smi.BracedObjectReference
   * @generated
   */
  EClass getBracedObjectReference();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.smi.BracedObjectReference#getObjectRef <em>Object Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Object Ref</em>'.
   * @see com.netxforge.smi.BracedObjectReference#getObjectRef()
   * @see #getBracedObjectReference()
   * @generated
   */
  EReference getBracedObjectReference_ObjectRef();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.Referenceable <em>Referenceable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Referenceable</em>'.
   * @see com.netxforge.smi.Referenceable
   * @generated
   */
  EClass getReferenceable();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.Referenceable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.netxforge.smi.Referenceable#getName()
   * @see #getReferenceable()
   * @generated
   */
  EAttribute getReferenceable_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.Referenceable#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see com.netxforge.smi.Referenceable#getValues()
   * @see #getReferenceable()
   * @generated
   */
  EReference getReferenceable_Values();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.Referenceable#getTypeNotation <em>Type Notation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type Notation</em>'.
   * @see com.netxforge.smi.Referenceable#getTypeNotation()
   * @see #getReferenceable()
   * @generated
   */
  EReference getReferenceable_TypeNotation();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.Referenceable#getValueNotation <em>Value Notation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value Notation</em>'.
   * @see com.netxforge.smi.Referenceable#getValueNotation()
   * @see #getReferenceable()
   * @generated
   */
  EReference getReferenceable_ValueNotation();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.Referenceable#getInnerTypes <em>Inner Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inner Types</em>'.
   * @see com.netxforge.smi.Referenceable#getInnerTypes()
   * @see #getReferenceable()
   * @generated
   */
  EReference getReferenceable_InnerTypes();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.Referenceable#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.smi.Referenceable#getRight()
   * @see #getReferenceable()
   * @generated
   */
  EReference getReferenceable_Right();

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
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.ValueNotation#getValueNotations <em>Value Notations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Value Notations</em>'.
   * @see com.netxforge.smi.ValueNotation#getValueNotations()
   * @see #getValueNotation()
   * @generated
   */
  EReference getValueNotation_ValueNotations();

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
   * Returns the meta object for class '{@link com.netxforge.smi.ValueAssignment <em>Value Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Assignment</em>'.
   * @see com.netxforge.smi.ValueAssignment
   * @generated
   */
  EClass getValueAssignment();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ValueAssignment#getValueNotation <em>Value Notation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value Notation</em>'.
   * @see com.netxforge.smi.ValueAssignment#getValueNotation()
   * @see #getValueAssignment()
   * @generated
   */
  EReference getValueAssignment_ValueNotation();

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
   * Returns the meta object for the attribute '{@link com.netxforge.smi.ValueType#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see com.netxforge.smi.ValueType#getId()
   * @see #getValueType()
   * @generated
   */
  EAttribute getValueType_Id();

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
   * Returns the meta object for class '{@link com.netxforge.smi.MacroValueType <em>Macro Value Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Macro Value Type</em>'.
   * @see com.netxforge.smi.MacroValueType
   * @generated
   */
  EClass getMacroValueType();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.MacroValueType#isUpdate <em>Update</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Update</em>'.
   * @see com.netxforge.smi.MacroValueType#isUpdate()
   * @see #getMacroValueType()
   * @generated
   */
  EAttribute getMacroValueType_Update();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.MacroValueType#isValueCAP <em>Value CAP</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value CAP</em>'.
   * @see com.netxforge.smi.MacroValueType#isValueCAP()
   * @see #getMacroValueType()
   * @generated
   */
  EAttribute getMacroValueType_ValueCAP();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.MacroValueType#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ref</em>'.
   * @see com.netxforge.smi.MacroValueType#getRef()
   * @see #getMacroValueType()
   * @generated
   */
  EReference getMacroValueType_Ref();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.MacroValueType#getOi <em>Oi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Oi</em>'.
   * @see com.netxforge.smi.MacroValueType#getOi()
   * @see #getMacroValueType()
   * @generated
   */
  EAttribute getMacroValueType_Oi();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.smi.MacroValueType#getString <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String</em>'.
   * @see com.netxforge.smi.MacroValueType#getString()
   * @see #getMacroValueType()
   * @generated
   */
  EAttribute getMacroValueType_String();

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
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ASN1_SIMPLE#getRefinement <em>Refinement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Refinement</em>'.
   * @see com.netxforge.smi.ASN1_SIMPLE#getRefinement()
   * @see #getASN1_SIMPLE()
   * @generated
   */
  EReference getASN1_SIMPLE_Refinement();

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
   * Returns the meta object for class '{@link com.netxforge.smi.ASN1_INTEGER_REFINEMENT <em>ASN1 INTEGER REFINEMENT</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASN1 INTEGER REFINEMENT</em>'.
   * @see com.netxforge.smi.ASN1_INTEGER_REFINEMENT
   * @generated
   */
  EClass getASN1_INTEGER_REFINEMENT();

  /**
   * Returns the meta object for the attribute list '{@link com.netxforge.smi.ASN1_INTEGER_REFINEMENT#getRefinements <em>Refinements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Refinements</em>'.
   * @see com.netxforge.smi.ASN1_INTEGER_REFINEMENT#getRefinements()
   * @see #getASN1_INTEGER_REFINEMENT()
   * @generated
   */
  EAttribute getASN1_INTEGER_REFINEMENT_Refinements();

  /**
   * Returns the meta object for the attribute list '{@link com.netxforge.smi.ASN1_INTEGER_REFINEMENT#getInts <em>Ints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Ints</em>'.
   * @see com.netxforge.smi.ASN1_INTEGER_REFINEMENT#getInts()
   * @see #getASN1_INTEGER_REFINEMENT()
   * @generated
   */
  EAttribute getASN1_INTEGER_REFINEMENT_Ints();

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
   * Returns the meta object for class '{@link com.netxforge.smi.ASN1_SEQUENCE <em>ASN1 SEQUENCE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASN1 SEQUENCE</em>'.
   * @see com.netxforge.smi.ASN1_SEQUENCE
   * @generated
   */
  EClass getASN1_SEQUENCE();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.smi.ASN1_SEQUENCE#getChoiceType <em>Choice Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Choice Type</em>'.
   * @see com.netxforge.smi.ASN1_SEQUENCE#getChoiceType()
   * @see #getASN1_SEQUENCE()
   * @generated
   */
  EReference getASN1_SEQUENCE_ChoiceType();

  /**
   * Returns the meta object for class '{@link com.netxforge.smi.ASN1_SEQUENCE_OF <em>ASN1 SEQUENCE OF</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASN1 SEQUENCE OF</em>'.
   * @see com.netxforge.smi.ASN1_SEQUENCE_OF
   * @generated
   */
  EClass getASN1_SEQUENCE_OF();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.smi.ASN1_SEQUENCE_OF#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ref</em>'.
   * @see com.netxforge.smi.ASN1_SEQUENCE_OF#getRef()
   * @see #getASN1_SEQUENCE_OF()
   * @generated
   */
  EReference getASN1_SEQUENCE_OF_Ref();

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
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__IMPORTS = eINSTANCE.getModule_Imports();

    /**
     * The meta object literal for the '<em><b>Objects</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__OBJECTS = eINSTANCE.getModule_Objects();

    /**
     * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__TYPES = eINSTANCE.getModule_Types();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ImportsImpl <em>Imports</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ImportsImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getImports()
     * @generated
     */
    EClass IMPORTS = eINSTANCE.getImports();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPORTS__IMPORTS = eINSTANCE.getImports_Imports();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ImportClosureImpl <em>Import Closure</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ImportClosureImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getImportClosure()
     * @generated
     */
    EClass IMPORT_CLOSURE = eINSTANCE.getImportClosure();

    /**
     * The meta object literal for the '<em><b>Refs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPORT_CLOSURE__REFS = eINSTANCE.getImportClosure_Refs();

    /**
     * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT_CLOSURE__IMPORT_URI = eINSTANCE.getImportClosure_ImportURI();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ImportRefsImpl <em>Import Refs</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ImportRefsImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getImportRefs()
     * @generated
     */
    EClass IMPORT_REFS = eINSTANCE.getImportRefs();

    /**
     * The meta object literal for the '<em><b>Refs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPORT_REFS__REFS = eINSTANCE.getImportRefs_Refs();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ImportRefImpl <em>Import Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ImportRefImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getImportRef()
     * @generated
     */
    EClass IMPORT_REF = eINSTANCE.getImportRef();

    /**
     * The meta object literal for the '<em><b>Oi Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPORT_REF__OI_REF = eINSTANCE.getImportRef_OiRef();

    /**
     * The meta object literal for the '<em><b>Type Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPORT_REF__TYPE_REF = eINSTANCE.getImportRef_TypeRef();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ObjectReferenceableImpl <em>Object Referenceable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ObjectReferenceableImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getObjectReferenceable()
     * @generated
     */
    EClass OBJECT_REFERENCEABLE = eINSTANCE.getObjectReferenceable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT_REFERENCEABLE__NAME = eINSTANCE.getObjectReferenceable_Name();

    /**
     * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_REFERENCEABLE__OBJECT = eINSTANCE.getObjectReferenceable_Object();

    /**
     * The meta object literal for the '<em><b>Object Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_REFERENCEABLE__OBJECT_VALUE = eINSTANCE.getObjectReferenceable_ObjectValue();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ObjectImpl <em>Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ObjectImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getObject()
     * @generated
     */
    EClass OBJECT = eINSTANCE.getObject();

    /**
     * The meta object literal for the '<em><b>Macro Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT__MACRO_REF = eINSTANCE.getObject_MacroRef();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT__ATTRIBUTES = eINSTANCE.getObject_Attributes();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ObjectReferenceImpl <em>Object Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ObjectReferenceImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getObjectReference()
     * @generated
     */
    EClass OBJECT_REFERENCE = eINSTANCE.getObjectReference();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT_REFERENCE__NAME = eINSTANCE.getObjectReference_Name();

    /**
     * The meta object literal for the '<em><b>Descriptor Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_REFERENCE__DESCRIPTOR_REF = eINSTANCE.getObjectReference_DescriptorRef();

    /**
     * The meta object literal for the '<em><b>Sub Ids</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT_REFERENCE__SUB_IDS = eINSTANCE.getObjectReference_SubIds();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.AttributeImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Param Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__PARAM_REF = eINSTANCE.getAttribute_ParamRef();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__VALUES = eINSTANCE.getAttribute_Values();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.AttributeValueImpl <em>Attribute Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.AttributeValueImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getAttributeValue()
     * @generated
     */
    EClass ATTRIBUTE_VALUE = eINSTANCE.getAttributeValue();

    /**
     * The meta object literal for the '<em><b>Identifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_VALUE__IDENTIFIER = eINSTANCE.getAttributeValue_Identifier();

    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_VALUE__TEXT = eINSTANCE.getAttributeValue_Text();

    /**
     * The meta object literal for the '<em><b>Type Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_VALUE__TYPE_REF = eINSTANCE.getAttributeValue_TypeRef();

    /**
     * The meta object literal for the '<em><b>Sub Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_VALUE__SUB_TYPE = eINSTANCE.getAttributeValue_SubType();

    /**
     * The meta object literal for the '<em><b>Object Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_VALUE__OBJECT_REF = eINSTANCE.getAttributeValue_ObjectRef();

    /**
     * The meta object literal for the '<em><b>Integer</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_VALUE__INTEGER = eINSTANCE.getAttributeValue_Integer();

    /**
     * The meta object literal for the '<em><b>Sequence Of</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_VALUE__SEQUENCE_OF = eINSTANCE.getAttributeValue_SequenceOf();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.IdentifierImpl <em>Identifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.IdentifierImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getIdentifier()
     * @generated
     */
    EClass IDENTIFIER = eINSTANCE.getIdentifier();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IDENTIFIER__ID = eINSTANCE.getIdentifier_Id();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.BracedObjectReferenceImpl <em>Braced Object Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.BracedObjectReferenceImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getBracedObjectReference()
     * @generated
     */
    EClass BRACED_OBJECT_REFERENCE = eINSTANCE.getBracedObjectReference();

    /**
     * The meta object literal for the '<em><b>Object Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BRACED_OBJECT_REFERENCE__OBJECT_REF = eINSTANCE.getBracedObjectReference_ObjectRef();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ReferenceableImpl <em>Referenceable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ReferenceableImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getReferenceable()
     * @generated
     */
    EClass REFERENCEABLE = eINSTANCE.getReferenceable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REFERENCEABLE__NAME = eINSTANCE.getReferenceable_Name();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCEABLE__VALUES = eINSTANCE.getReferenceable_Values();

    /**
     * The meta object literal for the '<em><b>Type Notation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCEABLE__TYPE_NOTATION = eINSTANCE.getReferenceable_TypeNotation();

    /**
     * The meta object literal for the '<em><b>Value Notation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCEABLE__VALUE_NOTATION = eINSTANCE.getReferenceable_ValueNotation();

    /**
     * The meta object literal for the '<em><b>Inner Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCEABLE__INNER_TYPES = eINSTANCE.getReferenceable_InnerTypes();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCEABLE__RIGHT = eINSTANCE.getReferenceable_Right();

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
     * The meta object literal for the '<em><b>Value Notations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_NOTATION__VALUE_NOTATIONS = eINSTANCE.getValueNotation_ValueNotations();

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
     * The meta object literal for the '{@link com.netxforge.smi.impl.ValueAssignmentImpl <em>Value Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ValueAssignmentImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getValueAssignment()
     * @generated
     */
    EClass VALUE_ASSIGNMENT = eINSTANCE.getValueAssignment();

    /**
     * The meta object literal for the '<em><b>Value Notation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_ASSIGNMENT__VALUE_NOTATION = eINSTANCE.getValueAssignment_ValueNotation();

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
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE_TYPE__ID = eINSTANCE.getValueType_Id();

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
     * The meta object literal for the '{@link com.netxforge.smi.impl.MacroValueTypeImpl <em>Macro Value Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.MacroValueTypeImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getMacroValueType()
     * @generated
     */
    EClass MACRO_VALUE_TYPE = eINSTANCE.getMacroValueType();

    /**
     * The meta object literal for the '<em><b>Update</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MACRO_VALUE_TYPE__UPDATE = eINSTANCE.getMacroValueType_Update();

    /**
     * The meta object literal for the '<em><b>Value CAP</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MACRO_VALUE_TYPE__VALUE_CAP = eINSTANCE.getMacroValueType_ValueCAP();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO_VALUE_TYPE__REF = eINSTANCE.getMacroValueType_Ref();

    /**
     * The meta object literal for the '<em><b>Oi</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MACRO_VALUE_TYPE__OI = eINSTANCE.getMacroValueType_Oi();

    /**
     * The meta object literal for the '<em><b>String</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MACRO_VALUE_TYPE__STRING = eINSTANCE.getMacroValueType_String();

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
     * The meta object literal for the '<em><b>Refinement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASN1_SIMPLE__REFINEMENT = eINSTANCE.getASN1_SIMPLE_Refinement();

    /**
     * The meta object literal for the '<em><b>Ranges</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASN1_SIMPLE__RANGES = eINSTANCE.getASN1_SIMPLE_Ranges();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ASN1_INTEGER_REFINEMENTImpl <em>ASN1 INTEGER REFINEMENT</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ASN1_INTEGER_REFINEMENTImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_INTEGER_REFINEMENT()
     * @generated
     */
    EClass ASN1_INTEGER_REFINEMENT = eINSTANCE.getASN1_INTEGER_REFINEMENT();

    /**
     * The meta object literal for the '<em><b>Refinements</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASN1_INTEGER_REFINEMENT__REFINEMENTS = eINSTANCE.getASN1_INTEGER_REFINEMENT_Refinements();

    /**
     * The meta object literal for the '<em><b>Ints</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASN1_INTEGER_REFINEMENT__INTS = eINSTANCE.getASN1_INTEGER_REFINEMENT_Ints();

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
     * The meta object literal for the '{@link com.netxforge.smi.impl.ASN1_SEQUENCEImpl <em>ASN1 SEQUENCE</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ASN1_SEQUENCEImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_SEQUENCE()
     * @generated
     */
    EClass ASN1_SEQUENCE = eINSTANCE.getASN1_SEQUENCE();

    /**
     * The meta object literal for the '<em><b>Choice Type</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASN1_SEQUENCE__CHOICE_TYPE = eINSTANCE.getASN1_SEQUENCE_ChoiceType();

    /**
     * The meta object literal for the '{@link com.netxforge.smi.impl.ASN1_SEQUENCE_OFImpl <em>ASN1 SEQUENCE OF</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.smi.impl.ASN1_SEQUENCE_OFImpl
     * @see com.netxforge.smi.impl.SmiPackageImpl#getASN1_SEQUENCE_OF()
     * @generated
     */
    EClass ASN1_SEQUENCE_OF = eINSTANCE.getASN1_SEQUENCE_OF();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASN1_SEQUENCE_OF__REF = eINSTANCE.getASN1_SEQUENCE_OF_Ref();

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
