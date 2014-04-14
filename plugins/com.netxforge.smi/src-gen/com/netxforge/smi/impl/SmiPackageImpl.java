/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.Assignment;
import com.netxforge.smi.Macro;
import com.netxforge.smi.MacroValue;
import com.netxforge.smi.Module;
import com.netxforge.smi.ObjectIdentifier;
import com.netxforge.smi.ObjectIdentifierValue;
import com.netxforge.smi.ParamAssignment;
import com.netxforge.smi.Scope;
import com.netxforge.smi.SmiFactory;
import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.TypeAssignment;
import com.netxforge.smi.TypeDefinition;
import com.netxforge.smi.TypeNotation;
import com.netxforge.smi.TypeReference;
import com.netxforge.smi.TypeReferenceExt;
import com.netxforge.smi.UpdateType;
import com.netxforge.smi.Value;
import com.netxforge.smi.ValueType;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SmiPackageImpl extends EPackageImpl implements SmiPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectIdentifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectIdentifierValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass macroEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeAssignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass paramAssignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeNotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeReferenceExtEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scopeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass macroValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass macrO_VALUE_TYPEEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass updateTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass macrO_VALUE_CAPEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asn1_TYPEEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asn1_SIMPLEEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asn1_SUBTYPEEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asn1_RANGEEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asn1_CHOICEEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asn1_CHOICE_ENTRYEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asn1_OCTET_STRINGEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum valuE_CAP_LITERALSEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see com.netxforge.smi.SmiPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private SmiPackageImpl()
  {
    super(eNS_URI, SmiFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link SmiPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static SmiPackage init()
  {
    if (isInited) return (SmiPackage)EPackage.Registry.INSTANCE.getEPackage(SmiPackage.eNS_URI);

    // Obtain or create and register package
    SmiPackageImpl theSmiPackage = (SmiPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SmiPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SmiPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theSmiPackage.createPackageContents();

    // Initialize created meta-data
    theSmiPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSmiPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(SmiPackage.eNS_URI, theSmiPackage);
    return theSmiPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModule()
  {
    return moduleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModule_Id()
  {
    return (EAttribute)moduleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModule_Assignments()
  {
    return (EReference)moduleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssignment()
  {
    return assignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignment_Identifier()
  {
    return (EReference)assignmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignment_Type()
  {
    return (EReference)assignmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignment_Macro()
  {
    return (EReference)assignmentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectIdentifier()
  {
    return objectIdentifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObjectIdentifier_Name()
  {
    return (EAttribute)objectIdentifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectIdentifier_OidValue()
  {
    return (EReference)objectIdentifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectIdentifierValue()
  {
    return objectIdentifierValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectIdentifierValue_DescriptorReference()
  {
    return (EReference)objectIdentifierValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObjectIdentifierValue_SubIds()
  {
    return (EAttribute)objectIdentifierValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeDefinition()
  {
    return typeDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeDefinition_Name()
  {
    return (EAttribute)typeDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeDefinition_Scope()
  {
    return (EReference)typeDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMacro()
  {
    return macroEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMacro_Name()
  {
    return (EAttribute)macroEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMacro_TypeNotations()
  {
    return (EReference)macroEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMacro_ValueNotation()
  {
    return (EReference)macroEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMacro_InnerTypes()
  {
    return (EReference)macroEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeAssignment()
  {
    return typeAssignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParamAssignment()
  {
    return paramAssignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParamAssignment_Param()
  {
    return (EAttribute)paramAssignmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParamAssignment_Right()
  {
    return (EReference)paramAssignmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeNotation()
  {
    return typeNotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeNotation_Value()
  {
    return (EReference)typeNotationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeReferenceExt()
  {
    return typeReferenceExtEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeReference()
  {
    return typeReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeReference_Right()
  {
    return (EReference)typeReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeReference_Type()
  {
    return (EReference)typeReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScope()
  {
    return scopeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScope_Scope()
  {
    return (EReference)scopeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValue()
  {
    return valueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValue_ValueTypes()
  {
    return (EReference)valueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValueType()
  {
    return valueTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getValueType_Name()
  {
    return (EAttribute)valueTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValueType_Param()
  {
    return (EReference)valueTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValueType_Type()
  {
    return (EReference)valueTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValueType_SimpleType()
  {
    return (EReference)valueTypeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValueType_MacroValue()
  {
    return (EReference)valueTypeEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getValueType_Oi()
  {
    return (EAttribute)valueTypeEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMacroValue()
  {
    return macroValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMacroValue_Type()
  {
    return (EReference)macroValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMACRO_VALUE_TYPE()
  {
    return macrO_VALUE_TYPEEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMACRO_VALUE_TYPE_ValLiteral()
  {
    return (EReference)macrO_VALUE_TYPEEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMACRO_VALUE_TYPE_Update()
  {
    return (EReference)macrO_VALUE_TYPEEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUpdateType()
  {
    return updateTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUpdateType_Type()
  {
    return (EReference)updateTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMACRO_VALUE_CAP()
  {
    return macrO_VALUE_CAPEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMACRO_VALUE_CAP_Value()
  {
    return (EAttribute)macrO_VALUE_CAPEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMACRO_VALUE_CAP_Literal()
  {
    return (EAttribute)macrO_VALUE_CAPEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getASN1_TYPE()
  {
    return asn1_TYPEEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getASN1_SIMPLE()
  {
    return asn1_SIMPLEEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getASN1_SIMPLE_Constraint()
  {
    return (EReference)asn1_SIMPLEEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getASN1_SIMPLE_ValuePairs()
  {
    return (EAttribute)asn1_SIMPLEEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getASN1_SUBTYPE()
  {
    return asn1_SUBTYPEEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getASN1_SUBTYPE_Ranges()
  {
    return (EReference)asn1_SUBTYPEEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getASN1_RANGE()
  {
    return asn1_RANGEEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getASN1_RANGE_Value()
  {
    return (EAttribute)asn1_RANGEEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getASN1_RANGE_Start()
  {
    return (EAttribute)asn1_RANGEEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getASN1_RANGE_End()
  {
    return (EAttribute)asn1_RANGEEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getASN1_CHOICE()
  {
    return asn1_CHOICEEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getASN1_CHOICE_Choices()
  {
    return (EReference)asn1_CHOICEEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getASN1_CHOICE_ENTRY()
  {
    return asn1_CHOICE_ENTRYEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getASN1_CHOICE_ENTRY_Id()
  {
    return (EAttribute)asn1_CHOICE_ENTRYEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getASN1_CHOICE_ENTRY_ValueType()
  {
    return (EReference)asn1_CHOICE_ENTRYEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getASN1_OCTET_STRING()
  {
    return asn1_OCTET_STRINGEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getVALUE_CAP_LITERALS()
  {
    return valuE_CAP_LITERALSEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SmiFactory getSmiFactory()
  {
    return (SmiFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    moduleEClass = createEClass(MODULE);
    createEAttribute(moduleEClass, MODULE__ID);
    createEReference(moduleEClass, MODULE__ASSIGNMENTS);

    assignmentEClass = createEClass(ASSIGNMENT);
    createEReference(assignmentEClass, ASSIGNMENT__IDENTIFIER);
    createEReference(assignmentEClass, ASSIGNMENT__TYPE);
    createEReference(assignmentEClass, ASSIGNMENT__MACRO);

    objectIdentifierEClass = createEClass(OBJECT_IDENTIFIER);
    createEAttribute(objectIdentifierEClass, OBJECT_IDENTIFIER__NAME);
    createEReference(objectIdentifierEClass, OBJECT_IDENTIFIER__OID_VALUE);

    objectIdentifierValueEClass = createEClass(OBJECT_IDENTIFIER_VALUE);
    createEReference(objectIdentifierValueEClass, OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REFERENCE);
    createEAttribute(objectIdentifierValueEClass, OBJECT_IDENTIFIER_VALUE__SUB_IDS);

    typeDefinitionEClass = createEClass(TYPE_DEFINITION);
    createEAttribute(typeDefinitionEClass, TYPE_DEFINITION__NAME);
    createEReference(typeDefinitionEClass, TYPE_DEFINITION__SCOPE);

    macroEClass = createEClass(MACRO);
    createEAttribute(macroEClass, MACRO__NAME);
    createEReference(macroEClass, MACRO__TYPE_NOTATIONS);
    createEReference(macroEClass, MACRO__VALUE_NOTATION);
    createEReference(macroEClass, MACRO__INNER_TYPES);

    typeAssignmentEClass = createEClass(TYPE_ASSIGNMENT);

    paramAssignmentEClass = createEClass(PARAM_ASSIGNMENT);
    createEAttribute(paramAssignmentEClass, PARAM_ASSIGNMENT__PARAM);
    createEReference(paramAssignmentEClass, PARAM_ASSIGNMENT__RIGHT);

    typeNotationEClass = createEClass(TYPE_NOTATION);
    createEReference(typeNotationEClass, TYPE_NOTATION__VALUE);

    typeReferenceExtEClass = createEClass(TYPE_REFERENCE_EXT);

    typeReferenceEClass = createEClass(TYPE_REFERENCE);
    createEReference(typeReferenceEClass, TYPE_REFERENCE__RIGHT);
    createEReference(typeReferenceEClass, TYPE_REFERENCE__TYPE);

    scopeEClass = createEClass(SCOPE);
    createEReference(scopeEClass, SCOPE__SCOPE);

    valueEClass = createEClass(VALUE);
    createEReference(valueEClass, VALUE__VALUE_TYPES);

    valueTypeEClass = createEClass(VALUE_TYPE);
    createEAttribute(valueTypeEClass, VALUE_TYPE__NAME);
    createEReference(valueTypeEClass, VALUE_TYPE__PARAM);
    createEReference(valueTypeEClass, VALUE_TYPE__TYPE);
    createEReference(valueTypeEClass, VALUE_TYPE__SIMPLE_TYPE);
    createEReference(valueTypeEClass, VALUE_TYPE__MACRO_VALUE);
    createEAttribute(valueTypeEClass, VALUE_TYPE__OI);

    macroValueEClass = createEClass(MACRO_VALUE);
    createEReference(macroValueEClass, MACRO_VALUE__TYPE);

    macrO_VALUE_TYPEEClass = createEClass(MACRO_VALUE_TYPE);
    createEReference(macrO_VALUE_TYPEEClass, MACRO_VALUE_TYPE__VAL_LITERAL);
    createEReference(macrO_VALUE_TYPEEClass, MACRO_VALUE_TYPE__UPDATE);

    updateTypeEClass = createEClass(UPDATE_TYPE);
    createEReference(updateTypeEClass, UPDATE_TYPE__TYPE);

    macrO_VALUE_CAPEClass = createEClass(MACRO_VALUE_CAP);
    createEAttribute(macrO_VALUE_CAPEClass, MACRO_VALUE_CAP__VALUE);
    createEAttribute(macrO_VALUE_CAPEClass, MACRO_VALUE_CAP__LITERAL);

    asn1_TYPEEClass = createEClass(ASN1_TYPE);

    asn1_SIMPLEEClass = createEClass(ASN1_SIMPLE);
    createEReference(asn1_SIMPLEEClass, ASN1_SIMPLE__CONSTRAINT);
    createEAttribute(asn1_SIMPLEEClass, ASN1_SIMPLE__VALUE_PAIRS);

    asn1_SUBTYPEEClass = createEClass(ASN1_SUBTYPE);
    createEReference(asn1_SUBTYPEEClass, ASN1_SUBTYPE__RANGES);

    asn1_RANGEEClass = createEClass(ASN1_RANGE);
    createEAttribute(asn1_RANGEEClass, ASN1_RANGE__VALUE);
    createEAttribute(asn1_RANGEEClass, ASN1_RANGE__START);
    createEAttribute(asn1_RANGEEClass, ASN1_RANGE__END);

    asn1_CHOICEEClass = createEClass(ASN1_CHOICE);
    createEReference(asn1_CHOICEEClass, ASN1_CHOICE__CHOICES);

    asn1_CHOICE_ENTRYEClass = createEClass(ASN1_CHOICE_ENTRY);
    createEAttribute(asn1_CHOICE_ENTRYEClass, ASN1_CHOICE_ENTRY__ID);
    createEReference(asn1_CHOICE_ENTRYEClass, ASN1_CHOICE_ENTRY__VALUE_TYPE);

    asn1_OCTET_STRINGEClass = createEClass(ASN1_OCTET_STRING);

    // Create enums
    valuE_CAP_LITERALSEEnum = createEEnum(VALUE_CAP_LITERALS);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    paramAssignmentEClass.getESuperTypes().add(this.getTypeAssignment());
    typeReferenceEClass.getESuperTypes().add(this.getTypeAssignment());
    typeReferenceEClass.getESuperTypes().add(this.getTypeNotation());
    typeReferenceEClass.getESuperTypes().add(this.getTypeReferenceExt());
    asn1_SIMPLEEClass.getESuperTypes().add(this.getASN1_TYPE());
    asn1_CHOICEEClass.getESuperTypes().add(this.getASN1_TYPE());
    asn1_OCTET_STRINGEClass.getESuperTypes().add(this.getASN1_SIMPLE());

    // Initialize classes and features; add operations and parameters
    initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModule_Id(), ecorePackage.getEString(), "id", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModule_Assignments(), this.getAssignment(), null, "assignments", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssignment_Identifier(), this.getObjectIdentifier(), null, "identifier", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssignment_Type(), this.getTypeDefinition(), null, "type", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssignment_Macro(), this.getMacro(), null, "macro", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectIdentifierEClass, ObjectIdentifier.class, "ObjectIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getObjectIdentifier_Name(), ecorePackage.getEString(), "name", null, 0, 1, ObjectIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectIdentifier_OidValue(), this.getObjectIdentifierValue(), null, "oidValue", null, 0, 1, ObjectIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectIdentifierValueEClass, ObjectIdentifierValue.class, "ObjectIdentifierValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getObjectIdentifierValue_DescriptorReference(), this.getObjectIdentifier(), null, "descriptorReference", null, 0, 1, ObjectIdentifierValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObjectIdentifierValue_SubIds(), ecorePackage.getEInt(), "subIds", null, 0, -1, ObjectIdentifierValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeDefinitionEClass, TypeDefinition.class, "TypeDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypeDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeDefinition_Scope(), this.getScope(), null, "scope", null, 0, 1, TypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(macroEClass, Macro.class, "Macro", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMacro_Name(), ecorePackage.getEString(), "name", null, 0, 1, Macro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMacro_TypeNotations(), this.getTypeAssignment(), null, "typeNotations", null, 0, -1, Macro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMacro_ValueNotation(), this.getMacroValue(), null, "valueNotation", null, 0, 1, Macro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMacro_InnerTypes(), this.getTypeDefinition(), null, "innerTypes", null, 0, -1, Macro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeAssignmentEClass, TypeAssignment.class, "TypeAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(paramAssignmentEClass, ParamAssignment.class, "ParamAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParamAssignment_Param(), ecorePackage.getEString(), "param", null, 0, 1, ParamAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParamAssignment_Right(), this.getTypeNotation(), null, "right", null, 0, 1, ParamAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeNotationEClass, TypeNotation.class, "TypeNotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeNotation_Value(), this.getMacroValue(), null, "value", null, 0, 1, TypeNotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeReferenceExtEClass, TypeReferenceExt.class, "TypeReferenceExt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(typeReferenceEClass, TypeReference.class, "TypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeReference_Right(), this.getTypeReference(), null, "right", null, 0, 1, TypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeReference_Type(), this.getTypeDefinition(), null, "type", null, 0, 1, TypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scopeEClass, Scope.class, "Scope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getScope_Scope(), this.getValue(), null, "scope", null, 0, 1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueEClass, Value.class, "Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getValue_ValueTypes(), this.getValueType(), null, "valueTypes", null, 0, -1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueTypeEClass, ValueType.class, "ValueType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getValueType_Name(), ecorePackage.getEString(), "name", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValueType_Param(), this.getParamAssignment(), null, "param", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValueType_Type(), this.getTypeReferenceExt(), null, "type", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValueType_SimpleType(), this.getASN1_TYPE(), null, "simpleType", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValueType_MacroValue(), this.getMacroValue(), null, "macroValue", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getValueType_Oi(), ecorePackage.getEString(), "oi", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(macroValueEClass, MacroValue.class, "MacroValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMacroValue_Type(), this.getMACRO_VALUE_TYPE(), null, "type", null, 0, 1, MacroValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(macrO_VALUE_TYPEEClass, com.netxforge.smi.MACRO_VALUE_TYPE.class, "MACRO_VALUE_TYPE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMACRO_VALUE_TYPE_ValLiteral(), this.getMACRO_VALUE_CAP(), null, "valLiteral", null, 0, 1, com.netxforge.smi.MACRO_VALUE_TYPE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMACRO_VALUE_TYPE_Update(), this.getUpdateType(), null, "update", null, 0, 1, com.netxforge.smi.MACRO_VALUE_TYPE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(updateTypeEClass, UpdateType.class, "UpdateType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUpdateType_Type(), this.getTypeDefinition(), null, "type", null, 0, 1, UpdateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(macrO_VALUE_CAPEClass, com.netxforge.smi.MACRO_VALUE_CAP.class, "MACRO_VALUE_CAP", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMACRO_VALUE_CAP_Value(), ecorePackage.getEString(), "value", null, 0, 1, com.netxforge.smi.MACRO_VALUE_CAP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMACRO_VALUE_CAP_Literal(), this.getVALUE_CAP_LITERALS(), "literal", null, 0, 1, com.netxforge.smi.MACRO_VALUE_CAP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_TYPEEClass, com.netxforge.smi.ASN1_TYPE.class, "ASN1_TYPE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(asn1_SIMPLEEClass, com.netxforge.smi.ASN1_SIMPLE.class, "ASN1_SIMPLE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getASN1_SIMPLE_Constraint(), ecorePackage.getEObject(), null, "constraint", null, 0, 1, com.netxforge.smi.ASN1_SIMPLE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getASN1_SIMPLE_ValuePairs(), ecorePackage.getEString(), "valuePairs", null, 0, -1, com.netxforge.smi.ASN1_SIMPLE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_SUBTYPEEClass, com.netxforge.smi.ASN1_SUBTYPE.class, "ASN1_SUBTYPE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getASN1_SUBTYPE_Ranges(), this.getASN1_RANGE(), null, "ranges", null, 0, -1, com.netxforge.smi.ASN1_SUBTYPE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_RANGEEClass, com.netxforge.smi.ASN1_RANGE.class, "ASN1_RANGE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getASN1_RANGE_Value(), ecorePackage.getEInt(), "value", null, 0, 1, com.netxforge.smi.ASN1_RANGE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getASN1_RANGE_Start(), ecorePackage.getEInt(), "start", null, 0, 1, com.netxforge.smi.ASN1_RANGE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getASN1_RANGE_End(), ecorePackage.getEInt(), "end", null, 0, 1, com.netxforge.smi.ASN1_RANGE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_CHOICEEClass, com.netxforge.smi.ASN1_CHOICE.class, "ASN1_CHOICE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getASN1_CHOICE_Choices(), this.getASN1_CHOICE_ENTRY(), null, "choices", null, 0, -1, com.netxforge.smi.ASN1_CHOICE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_CHOICE_ENTRYEClass, com.netxforge.smi.ASN1_CHOICE_ENTRY.class, "ASN1_CHOICE_ENTRY", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getASN1_CHOICE_ENTRY_Id(), ecorePackage.getEString(), "id", null, 0, 1, com.netxforge.smi.ASN1_CHOICE_ENTRY.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getASN1_CHOICE_ENTRY_ValueType(), this.getValueType(), null, "valueType", null, 0, 1, com.netxforge.smi.ASN1_CHOICE_ENTRY.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_OCTET_STRINGEClass, com.netxforge.smi.ASN1_OCTET_STRING.class, "ASN1_OCTET_STRING", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(valuE_CAP_LITERALSEEnum, com.netxforge.smi.VALUE_CAP_LITERALS.class, "VALUE_CAP_LITERALS");
    addEEnumLiteral(valuE_CAP_LITERALSEEnum, com.netxforge.smi.VALUE_CAP_LITERALS.OI_LITERAL);
    addEEnumLiteral(valuE_CAP_LITERALSEEnum, com.netxforge.smi.VALUE_CAP_LITERALS.IA5_STRING_LITERAL);

    // Create resource
    createResource(eNS_URI);
  }

} //SmiPackageImpl
