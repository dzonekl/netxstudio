/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
      case SmiPackage.ASSIGNMENT: return createAssignment();
      case SmiPackage.OBJECT_IDENTIFIER: return createObjectIdentifier();
      case SmiPackage.OBJECT_IDENTIFIER_VALUE: return createObjectIdentifierValue();
      case SmiPackage.TYPE_DEFINITION: return createTypeDefinition();
      case SmiPackage.MACRO: return createMacro();
      case SmiPackage.TYPE_ASSIGNMENT: return createTypeAssignment();
      case SmiPackage.PARAM_ASSIGNMENT: return createParamAssignment();
      case SmiPackage.TYPE_NOTATION: return createTypeNotation();
      case SmiPackage.TYPE_REFERENCE_EXT: return createTypeReferenceExt();
      case SmiPackage.TYPE_REFERENCE: return createTypeReference();
      case SmiPackage.SCOPE: return createScope();
      case SmiPackage.VALUE: return createValue();
      case SmiPackage.VALUE_TYPE: return createValueType();
      case SmiPackage.MACRO_VALUE: return createMacroValue();
      case SmiPackage.MACRO_VALUE_TYPE: return createMACRO_VALUE_TYPE();
      case SmiPackage.UPDATE_TYPE: return createUpdateType();
      case SmiPackage.MACRO_VALUE_CAP: return createMACRO_VALUE_CAP();
      case SmiPackage.ASN1_TYPE: return createASN1_TYPE();
      case SmiPackage.ASN1_SIMPLE: return createASN1_SIMPLE();
      case SmiPackage.ASN1_SUBTYPE: return createASN1_SUBTYPE();
      case SmiPackage.ASN1_RANGE: return createASN1_RANGE();
      case SmiPackage.ASN1_CHOICE: return createASN1_CHOICE();
      case SmiPackage.ASN1_CHOICE_ENTRY: return createASN1_CHOICE_ENTRY();
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
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case SmiPackage.VALUE_CAP_LITERALS:
        return createVALUE_CAP_LITERALSFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case SmiPackage.VALUE_CAP_LITERALS:
        return convertVALUE_CAP_LITERALSToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
  public Assignment createAssignment()
  {
    AssignmentImpl assignment = new AssignmentImpl();
    return assignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectIdentifier createObjectIdentifier()
  {
    ObjectIdentifierImpl objectIdentifier = new ObjectIdentifierImpl();
    return objectIdentifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectIdentifierValue createObjectIdentifierValue()
  {
    ObjectIdentifierValueImpl objectIdentifierValue = new ObjectIdentifierValueImpl();
    return objectIdentifierValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDefinition createTypeDefinition()
  {
    TypeDefinitionImpl typeDefinition = new TypeDefinitionImpl();
    return typeDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Macro createMacro()
  {
    MacroImpl macro = new MacroImpl();
    return macro;
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
  public ParamAssignment createParamAssignment()
  {
    ParamAssignmentImpl paramAssignment = new ParamAssignmentImpl();
    return paramAssignment;
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
  public TypeReferenceExt createTypeReferenceExt()
  {
    TypeReferenceExtImpl typeReferenceExt = new TypeReferenceExtImpl();
    return typeReferenceExt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeReference createTypeReference()
  {
    TypeReferenceImpl typeReference = new TypeReferenceImpl();
    return typeReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scope createScope()
  {
    ScopeImpl scope = new ScopeImpl();
    return scope;
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
  public MACRO_VALUE_TYPE createMACRO_VALUE_TYPE()
  {
    MACRO_VALUE_TYPEImpl macrO_VALUE_TYPE = new MACRO_VALUE_TYPEImpl();
    return macrO_VALUE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UpdateType createUpdateType()
  {
    UpdateTypeImpl updateType = new UpdateTypeImpl();
    return updateType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MACRO_VALUE_CAP createMACRO_VALUE_CAP()
  {
    MACRO_VALUE_CAPImpl macrO_VALUE_CAP = new MACRO_VALUE_CAPImpl();
    return macrO_VALUE_CAP;
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
  public ASN1_SUBTYPE createASN1_SUBTYPE()
  {
    ASN1_SUBTYPEImpl asn1_SUBTYPE = new ASN1_SUBTYPEImpl();
    return asn1_SUBTYPE;
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
  public VALUE_CAP_LITERALS createVALUE_CAP_LITERALSFromString(EDataType eDataType, String initialValue)
  {
    VALUE_CAP_LITERALS result = VALUE_CAP_LITERALS.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertVALUE_CAP_LITERALSToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
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
