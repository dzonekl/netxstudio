/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.ASN1_CHOICE;
import com.netxforge.smi.ASN1_CHOICE_ENTRY;
import com.netxforge.smi.ASN1_INTEGER_REFINEMENT;
import com.netxforge.smi.ASN1_OCTET_STRING;
import com.netxforge.smi.ASN1_RANGE;
import com.netxforge.smi.ASN1_SEQUENCE;
import com.netxforge.smi.ASN1_SEQUENCE_OF;
import com.netxforge.smi.ASN1_SIMPLE;
import com.netxforge.smi.ASN1_TYPE;
import com.netxforge.smi.Attribute;
import com.netxforge.smi.AttributeValue;
import com.netxforge.smi.BracedObjectReference;
import com.netxforge.smi.ChoiceType;
import com.netxforge.smi.Identifier;
import com.netxforge.smi.ImportClosure;
import com.netxforge.smi.ImportRef;
import com.netxforge.smi.ImportRefs;
import com.netxforge.smi.Imports;
import com.netxforge.smi.MacroValue;
import com.netxforge.smi.MacroValueType;
import com.netxforge.smi.Module;
import com.netxforge.smi.ObjectReference;
import com.netxforge.smi.ObjectReferenceable;
import com.netxforge.smi.Referenceable;
import com.netxforge.smi.SmiFactory;
import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.Tag;
import com.netxforge.smi.TypeAssignment;
import com.netxforge.smi.TypeNotation;
import com.netxforge.smi.TypeNotationRight;
import com.netxforge.smi.Value;
import com.netxforge.smi.ValueAssignment;
import com.netxforge.smi.ValueNotation;
import com.netxforge.smi.ValueType;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SmiFactoryImpl extends EFactoryImpl implements SmiFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SmiFactory init()
  {
    try
    {
      SmiFactory theSmiFactory = (SmiFactory)EPackage.Registry.INSTANCE.getEFactory(SmiPackage.eNS_URI);
      if (theSmiFactory != null)
      {
        return theSmiFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SmiFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SmiFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case SmiPackage.MODULE: return createModule();
      case SmiPackage.IMPORTS: return createImports();
      case SmiPackage.IMPORT_CLOSURE: return createImportClosure();
      case SmiPackage.IMPORT_REFS: return createImportRefs();
      case SmiPackage.IMPORT_REF: return createImportRef();
      case SmiPackage.OBJECT_REFERENCEABLE: return createObjectReferenceable();
      case SmiPackage.OBJECT: return createObject();
      case SmiPackage.OBJECT_REFERENCE: return createObjectReference();
      case SmiPackage.ATTRIBUTE: return createAttribute();
      case SmiPackage.ATTRIBUTE_VALUE: return createAttributeValue();
      case SmiPackage.IDENTIFIER: return createIdentifier();
      case SmiPackage.BRACED_OBJECT_REFERENCE: return createBracedObjectReference();
      case SmiPackage.REFERENCEABLE: return createReferenceable();
      case SmiPackage.TYPE_NOTATION: return createTypeNotation();
      case SmiPackage.VALUE_NOTATION: return createValueNotation();
      case SmiPackage.TYPE_ASSIGNMENT: return createTypeAssignment();
      case SmiPackage.TYPE_NOTATION_RIGHT: return createTypeNotationRight();
      case SmiPackage.VALUE_ASSIGNMENT: return createValueAssignment();
      case SmiPackage.VALUE: return createValue();
      case SmiPackage.TAG: return createTag();
      case SmiPackage.VALUE_TYPE: return createValueType();
      case SmiPackage.MACRO_VALUE_TYPE: return createMacroValueType();
      case SmiPackage.ASN1_TYPE: return createASN1_TYPE();
      case SmiPackage.ASN1_SIMPLE: return createASN1_SIMPLE();
      case SmiPackage.ASN1_INTEGER_REFINEMENT: return createASN1_INTEGER_REFINEMENT();
      case SmiPackage.ASN1_RANGE: return createASN1_RANGE();
      case SmiPackage.ASN1_CHOICE: return createASN1_CHOICE();
      case SmiPackage.ASN1_SEQUENCE: return createASN1_SEQUENCE();
      case SmiPackage.ASN1_SEQUENCE_OF: return createASN1_SEQUENCE_OF();
      case SmiPackage.ASN1_CHOICE_ENTRY: return createASN1_CHOICE_ENTRY();
      case SmiPackage.CHOICE_TYPE: return createChoiceType();
      case SmiPackage.MACRO_VALUE: return createMacroValue();
      case SmiPackage.ASN1_OCTET_STRING: return createASN1_OCTET_STRING();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Module createModule()
  {
    ModuleImpl module = new ModuleImpl();
    return module;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Imports createImports()
  {
    ImportsImpl imports = new ImportsImpl();
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportClosure createImportClosure()
  {
    ImportClosureImpl importClosure = new ImportClosureImpl();
    return importClosure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportRefs createImportRefs()
  {
    ImportRefsImpl importRefs = new ImportRefsImpl();
    return importRefs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportRef createImportRef()
  {
    ImportRefImpl importRef = new ImportRefImpl();
    return importRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectReferenceable createObjectReferenceable()
  {
    ObjectReferenceableImpl objectReferenceable = new ObjectReferenceableImpl();
    return objectReferenceable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public com.netxforge.smi.Object createObject()
  {
    ObjectImpl object = new ObjectImpl();
    return object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectReference createObjectReference()
  {
    ObjectReferenceImpl objectReference = new ObjectReferenceImpl();
    return objectReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeValue createAttributeValue()
  {
    AttributeValueImpl attributeValue = new AttributeValueImpl();
    return attributeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Identifier createIdentifier()
  {
    IdentifierImpl identifier = new IdentifierImpl();
    return identifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BracedObjectReference createBracedObjectReference()
  {
    BracedObjectReferenceImpl bracedObjectReference = new BracedObjectReferenceImpl();
    return bracedObjectReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Referenceable createReferenceable()
  {
    ReferenceableImpl referenceable = new ReferenceableImpl();
    return referenceable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeNotation createTypeNotation()
  {
    TypeNotationImpl typeNotation = new TypeNotationImpl();
    return typeNotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueNotation createValueNotation()
  {
    ValueNotationImpl valueNotation = new ValueNotationImpl();
    return valueNotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeAssignment createTypeAssignment()
  {
    TypeAssignmentImpl typeAssignment = new TypeAssignmentImpl();
    return typeAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeNotationRight createTypeNotationRight()
  {
    TypeNotationRightImpl typeNotationRight = new TypeNotationRightImpl();
    return typeNotationRight;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueAssignment createValueAssignment()
  {
    ValueAssignmentImpl valueAssignment = new ValueAssignmentImpl();
    return valueAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Value createValue()
  {
    ValueImpl value = new ValueImpl();
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tag createTag()
  {
    TagImpl tag = new TagImpl();
    return tag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueType createValueType()
  {
    ValueTypeImpl valueType = new ValueTypeImpl();
    return valueType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MacroValueType createMacroValueType()
  {
    MacroValueTypeImpl macroValueType = new MacroValueTypeImpl();
    return macroValueType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASN1_TYPE createASN1_TYPE()
  {
    ASN1_TYPEImpl asn1_TYPE = new ASN1_TYPEImpl();
    return asn1_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASN1_SIMPLE createASN1_SIMPLE()
  {
    ASN1_SIMPLEImpl asn1_SIMPLE = new ASN1_SIMPLEImpl();
    return asn1_SIMPLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASN1_INTEGER_REFINEMENT createASN1_INTEGER_REFINEMENT()
  {
    ASN1_INTEGER_REFINEMENTImpl asn1_INTEGER_REFINEMENT = new ASN1_INTEGER_REFINEMENTImpl();
    return asn1_INTEGER_REFINEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASN1_RANGE createASN1_RANGE()
  {
    ASN1_RANGEImpl asn1_RANGE = new ASN1_RANGEImpl();
    return asn1_RANGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASN1_CHOICE createASN1_CHOICE()
  {
    ASN1_CHOICEImpl asn1_CHOICE = new ASN1_CHOICEImpl();
    return asn1_CHOICE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASN1_SEQUENCE createASN1_SEQUENCE()
  {
    ASN1_SEQUENCEImpl asn1_SEQUENCE = new ASN1_SEQUENCEImpl();
    return asn1_SEQUENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASN1_SEQUENCE_OF createASN1_SEQUENCE_OF()
  {
    ASN1_SEQUENCE_OFImpl asn1_SEQUENCE_OF = new ASN1_SEQUENCE_OFImpl();
    return asn1_SEQUENCE_OF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASN1_CHOICE_ENTRY createASN1_CHOICE_ENTRY()
  {
    ASN1_CHOICE_ENTRYImpl asn1_CHOICE_ENTRY = new ASN1_CHOICE_ENTRYImpl();
    return asn1_CHOICE_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChoiceType createChoiceType()
  {
    ChoiceTypeImpl choiceType = new ChoiceTypeImpl();
    return choiceType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MacroValue createMacroValue()
  {
    MacroValueImpl macroValue = new MacroValueImpl();
    return macroValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASN1_OCTET_STRING createASN1_OCTET_STRING()
  {
    ASN1_OCTET_STRINGImpl asn1_OCTET_STRING = new ASN1_OCTET_STRINGImpl();
    return asn1_OCTET_STRING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SmiPackage getSmiPackage()
  {
    return (SmiPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SmiPackage getPackage()
  {
    return SmiPackage.eINSTANCE;
  }

} //SmiFactoryImpl
