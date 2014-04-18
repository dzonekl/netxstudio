/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.ChoiceType;
import com.netxforge.smi.Macro;
import com.netxforge.smi.MacroValue;
import com.netxforge.smi.Module;
import com.netxforge.smi.ObjectIdentifier;
import com.netxforge.smi.ObjectIdentifierValue;
import com.netxforge.smi.ParamAssignment;
import com.netxforge.smi.SmiFactory;
import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.Tag;
import com.netxforge.smi.TypeAssignment;
import com.netxforge.smi.TypeDefinition;
import com.netxforge.smi.TypeNotation;
import com.netxforge.smi.TypeNotationRight;
import com.netxforge.smi.UpdateType;
import com.netxforge.smi.Value;
import com.netxforge.smi.ValueNotation;
import com.netxforge.smi.ValueType;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
  private EClass typeNotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueNotationEClass = null;

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
  private EClass typeNotationRightEClass = null;

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
  private EClass tagEClass = null;

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
  private EClass choiceTypeEClass = null;

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
  private EClass asn1_OCTET_STRINGEClass = null;

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
  public EAttribute getModule_Name()
  {
    return (EAttribute)moduleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModule_Identifiers()
  {
    return (EReference)moduleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModule_Types()
  {
    return (EReference)moduleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModule_Macros()
  {
    return (EReference)moduleEClass.getEStructuralFeatures().get(3);
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
  public EAttribute getObjectIdentifierValue_Name()
  {
    return (EAttribute)objectIdentifierValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectIdentifierValue_DescriptorReference()
  {
    return (EReference)objectIdentifierValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObjectIdentifierValue_SubIds()
  {
    return (EAttribute)objectIdentifierValueEClass.getEStructuralFeatures().get(2);
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
  public EReference getTypeDefinition_Values()
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
  public EReference getMacro_TypeNotation()
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
  public EClass getTypeNotation()
  {
    return typeNotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeNotation_Name()
  {
    return (EAttribute)typeNotationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeNotation_TypeNotations()
  {
    return (EReference)typeNotationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValueNotation()
  {
    return valueNotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getValueNotation_Name()
  {
    return (EAttribute)valueNotationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValueNotation_ValueNotation()
  {
    return (EReference)valueNotationEClass.getEStructuralFeatures().get(1);
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
  public EReference getTypeAssignment_ParentRef()
  {
    return (EReference)typeAssignmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeAssignment_ChildRef()
  {
    return (EReference)typeAssignmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeAssignment_Type()
  {
    return (EReference)typeAssignmentEClass.getEStructuralFeatures().get(2);
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
  public EClass getTypeNotationRight()
  {
    return typeNotationRightEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeNotationRight_Value()
  {
    return (EReference)typeNotationRightEClass.getEStructuralFeatures().get(0);
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
  public EReference getValue_Tag()
  {
    return (EReference)valueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getValue_Implicit()
  {
    return (EAttribute)valueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValue_ValueTypes()
  {
    return (EReference)valueEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTag()
  {
    return tagEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTag_TagValue()
  {
    return (EAttribute)tagEClass.getEStructuralFeatures().get(0);
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
  public EReference getValueType_Param()
  {
    return (EReference)valueTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValueType_Types()
  {
    return (EReference)valueTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValueType_SimpleType()
  {
    return (EReference)valueTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValueType_MacroValue()
  {
    return (EReference)valueTypeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getValueType_Oi()
  {
    return (EAttribute)valueTypeEClass.getEStructuralFeatures().get(4);
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
  public EReference getMACRO_VALUE_TYPE_Update()
  {
    return (EReference)macrO_VALUE_TYPEEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMACRO_VALUE_TYPE_Literal()
  {
    return (EReference)macrO_VALUE_TYPEEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMACRO_VALUE_TYPE_String()
  {
    return (EAttribute)macrO_VALUE_TYPEEClass.getEStructuralFeatures().get(2);
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
  public EReference getUpdateType_Ref()
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
  public EReference getMACRO_VALUE_CAP_Ref()
  {
    return (EReference)macrO_VALUE_CAPEClass.getEStructuralFeatures().get(0);
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
  public EAttribute getASN1_SIMPLE_Name()
  {
    return (EAttribute)asn1_SIMPLEEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getASN1_SIMPLE_Range()
  {
    return (EReference)asn1_SIMPLEEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getASN1_SIMPLE_Ranges()
  {
    return (EReference)asn1_SIMPLEEClass.getEStructuralFeatures().get(3);
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
  public EReference getASN1_CHOICE_ChoiceType()
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
  public EClass getChoiceType()
  {
    return choiceTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getChoiceType_TypeRef()
  {
    return (EReference)choiceTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getChoiceType_SimpleType()
  {
    return (EReference)choiceTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getChoiceType_Oi()
  {
    return (EAttribute)choiceTypeEClass.getEStructuralFeatures().get(2);
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
  public EReference getMacroValue_ValueType()
  {
    return (EReference)macroValueEClass.getEStructuralFeatures().get(0);
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
    createEAttribute(moduleEClass, MODULE__NAME);
    createEReference(moduleEClass, MODULE__IDENTIFIERS);
    createEReference(moduleEClass, MODULE__TYPES);
    createEReference(moduleEClass, MODULE__MACROS);

    objectIdentifierEClass = createEClass(OBJECT_IDENTIFIER);
    createEAttribute(objectIdentifierEClass, OBJECT_IDENTIFIER__NAME);
    createEReference(objectIdentifierEClass, OBJECT_IDENTIFIER__OID_VALUE);

    objectIdentifierValueEClass = createEClass(OBJECT_IDENTIFIER_VALUE);
    createEAttribute(objectIdentifierValueEClass, OBJECT_IDENTIFIER_VALUE__NAME);
    createEReference(objectIdentifierValueEClass, OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REFERENCE);
    createEAttribute(objectIdentifierValueEClass, OBJECT_IDENTIFIER_VALUE__SUB_IDS);

    typeDefinitionEClass = createEClass(TYPE_DEFINITION);
    createEAttribute(typeDefinitionEClass, TYPE_DEFINITION__NAME);
    createEReference(typeDefinitionEClass, TYPE_DEFINITION__VALUES);

    macroEClass = createEClass(MACRO);
    createEAttribute(macroEClass, MACRO__NAME);
    createEReference(macroEClass, MACRO__TYPE_NOTATION);
    createEReference(macroEClass, MACRO__VALUE_NOTATION);
    createEReference(macroEClass, MACRO__INNER_TYPES);

    typeNotationEClass = createEClass(TYPE_NOTATION);
    createEAttribute(typeNotationEClass, TYPE_NOTATION__NAME);
    createEReference(typeNotationEClass, TYPE_NOTATION__TYPE_NOTATIONS);

    valueNotationEClass = createEClass(VALUE_NOTATION);
    createEAttribute(valueNotationEClass, VALUE_NOTATION__NAME);
    createEReference(valueNotationEClass, VALUE_NOTATION__VALUE_NOTATION);

    typeAssignmentEClass = createEClass(TYPE_ASSIGNMENT);
    createEReference(typeAssignmentEClass, TYPE_ASSIGNMENT__PARENT_REF);
    createEReference(typeAssignmentEClass, TYPE_ASSIGNMENT__CHILD_REF);
    createEReference(typeAssignmentEClass, TYPE_ASSIGNMENT__TYPE);

    paramAssignmentEClass = createEClass(PARAM_ASSIGNMENT);
    createEAttribute(paramAssignmentEClass, PARAM_ASSIGNMENT__PARAM);
    createEReference(paramAssignmentEClass, PARAM_ASSIGNMENT__RIGHT);

    typeNotationRightEClass = createEClass(TYPE_NOTATION_RIGHT);
    createEReference(typeNotationRightEClass, TYPE_NOTATION_RIGHT__VALUE);

    valueEClass = createEClass(VALUE);
    createEReference(valueEClass, VALUE__TAG);
    createEAttribute(valueEClass, VALUE__IMPLICIT);
    createEReference(valueEClass, VALUE__VALUE_TYPES);

    tagEClass = createEClass(TAG);
    createEAttribute(tagEClass, TAG__TAG_VALUE);

    valueTypeEClass = createEClass(VALUE_TYPE);
    createEReference(valueTypeEClass, VALUE_TYPE__PARAM);
    createEReference(valueTypeEClass, VALUE_TYPE__TYPES);
    createEReference(valueTypeEClass, VALUE_TYPE__SIMPLE_TYPE);
    createEReference(valueTypeEClass, VALUE_TYPE__MACRO_VALUE);
    createEAttribute(valueTypeEClass, VALUE_TYPE__OI);

    macrO_VALUE_TYPEEClass = createEClass(MACRO_VALUE_TYPE);
    createEReference(macrO_VALUE_TYPEEClass, MACRO_VALUE_TYPE__UPDATE);
    createEReference(macrO_VALUE_TYPEEClass, MACRO_VALUE_TYPE__LITERAL);
    createEAttribute(macrO_VALUE_TYPEEClass, MACRO_VALUE_TYPE__STRING);

    updateTypeEClass = createEClass(UPDATE_TYPE);
    createEReference(updateTypeEClass, UPDATE_TYPE__REF);

    macrO_VALUE_CAPEClass = createEClass(MACRO_VALUE_CAP);
    createEReference(macrO_VALUE_CAPEClass, MACRO_VALUE_CAP__REF);

    asn1_TYPEEClass = createEClass(ASN1_TYPE);

    asn1_SIMPLEEClass = createEClass(ASN1_SIMPLE);
    createEReference(asn1_SIMPLEEClass, ASN1_SIMPLE__CONSTRAINT);
    createEAttribute(asn1_SIMPLEEClass, ASN1_SIMPLE__NAME);
    createEReference(asn1_SIMPLEEClass, ASN1_SIMPLE__RANGE);
    createEReference(asn1_SIMPLEEClass, ASN1_SIMPLE__RANGES);

    asn1_RANGEEClass = createEClass(ASN1_RANGE);
    createEAttribute(asn1_RANGEEClass, ASN1_RANGE__VALUE);
    createEAttribute(asn1_RANGEEClass, ASN1_RANGE__START);
    createEAttribute(asn1_RANGEEClass, ASN1_RANGE__END);

    asn1_CHOICEEClass = createEClass(ASN1_CHOICE);
    createEReference(asn1_CHOICEEClass, ASN1_CHOICE__CHOICE_TYPE);

    asn1_CHOICE_ENTRYEClass = createEClass(ASN1_CHOICE_ENTRY);
    createEAttribute(asn1_CHOICE_ENTRYEClass, ASN1_CHOICE_ENTRY__ID);
    createEReference(asn1_CHOICE_ENTRYEClass, ASN1_CHOICE_ENTRY__VALUE_TYPE);

    choiceTypeEClass = createEClass(CHOICE_TYPE);
    createEReference(choiceTypeEClass, CHOICE_TYPE__TYPE_REF);
    createEReference(choiceTypeEClass, CHOICE_TYPE__SIMPLE_TYPE);
    createEAttribute(choiceTypeEClass, CHOICE_TYPE__OI);

    macroValueEClass = createEClass(MACRO_VALUE);
    createEReference(macroValueEClass, MACRO_VALUE__VALUE_TYPE);

    asn1_OCTET_STRINGEClass = createEClass(ASN1_OCTET_STRING);
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
    typeAssignmentEClass.getESuperTypes().add(this.getTypeNotationRight());
    paramAssignmentEClass.getESuperTypes().add(this.getTypeAssignment());
    valueEClass.getESuperTypes().add(this.getTypeAssignment());
    asn1_SIMPLEEClass.getESuperTypes().add(this.getASN1_TYPE());
    asn1_CHOICEEClass.getESuperTypes().add(this.getASN1_TYPE());
    macroValueEClass.getESuperTypes().add(this.getValue());
    asn1_OCTET_STRINGEClass.getESuperTypes().add(this.getASN1_SIMPLE());

    // Initialize classes and features; add operations and parameters
    initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModule_Name(), ecorePackage.getEString(), "name", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModule_Identifiers(), this.getObjectIdentifier(), null, "identifiers", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModule_Types(), this.getTypeDefinition(), null, "types", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModule_Macros(), this.getMacro(), null, "macros", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectIdentifierEClass, ObjectIdentifier.class, "ObjectIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getObjectIdentifier_Name(), ecorePackage.getEString(), "name", null, 0, 1, ObjectIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectIdentifier_OidValue(), this.getObjectIdentifierValue(), null, "oidValue", null, 0, 1, ObjectIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectIdentifierValueEClass, ObjectIdentifierValue.class, "ObjectIdentifierValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getObjectIdentifierValue_Name(), ecorePackage.getEString(), "name", null, 0, 1, ObjectIdentifierValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectIdentifierValue_DescriptorReference(), this.getObjectIdentifier(), null, "descriptorReference", null, 0, 1, ObjectIdentifierValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObjectIdentifierValue_SubIds(), ecorePackage.getEBigInteger(), "subIds", null, 0, -1, ObjectIdentifierValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeDefinitionEClass, TypeDefinition.class, "TypeDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypeDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeDefinition_Values(), this.getValue(), null, "values", null, 0, -1, TypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(macroEClass, Macro.class, "Macro", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMacro_Name(), ecorePackage.getEString(), "name", null, 0, 1, Macro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMacro_TypeNotation(), this.getTypeNotation(), null, "typeNotation", null, 0, 1, Macro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMacro_ValueNotation(), this.getValueNotation(), null, "valueNotation", null, 0, 1, Macro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMacro_InnerTypes(), this.getTypeDefinition(), null, "innerTypes", null, 0, -1, Macro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeNotationEClass, TypeNotation.class, "TypeNotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypeNotation_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypeNotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeNotation_TypeNotations(), this.getTypeAssignment(), null, "typeNotations", null, 0, -1, TypeNotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueNotationEClass, ValueNotation.class, "ValueNotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getValueNotation_Name(), ecorePackage.getEString(), "name", null, 0, 1, ValueNotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValueNotation_ValueNotation(), this.getValue(), null, "valueNotation", null, 0, 1, ValueNotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeAssignmentEClass, TypeAssignment.class, "TypeAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeAssignment_ParentRef(), this.getTypeAssignment(), null, "parentRef", null, 0, 1, TypeAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeAssignment_ChildRef(), this.getTypeAssignment(), null, "childRef", null, 0, 1, TypeAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeAssignment_Type(), this.getTypeDefinition(), null, "type", null, 0, 1, TypeAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(paramAssignmentEClass, ParamAssignment.class, "ParamAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParamAssignment_Param(), ecorePackage.getEString(), "param", null, 0, 1, ParamAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParamAssignment_Right(), this.getTypeNotationRight(), null, "right", null, 0, 1, ParamAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeNotationRightEClass, TypeNotationRight.class, "TypeNotationRight", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeNotationRight_Value(), this.getValue(), null, "value", null, 0, 1, TypeNotationRight.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueEClass, Value.class, "Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getValue_Tag(), this.getTag(), null, "tag", null, 0, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getValue_Implicit(), ecorePackage.getEBoolean(), "implicit", null, 0, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValue_ValueTypes(), this.getValueType(), null, "valueTypes", null, 0, -1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tagEClass, Tag.class, "Tag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTag_TagValue(), ecorePackage.getEBigInteger(), "tagValue", null, 0, 1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueTypeEClass, ValueType.class, "ValueType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getValueType_Param(), this.getParamAssignment(), null, "param", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValueType_Types(), this.getTypeAssignment(), null, "types", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValueType_SimpleType(), this.getASN1_TYPE(), null, "simpleType", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValueType_MacroValue(), this.getValue(), null, "macroValue", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getValueType_Oi(), ecorePackage.getEString(), "oi", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(macrO_VALUE_TYPEEClass, com.netxforge.smi.MACRO_VALUE_TYPE.class, "MACRO_VALUE_TYPE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMACRO_VALUE_TYPE_Update(), this.getUpdateType(), null, "update", null, 0, 1, com.netxforge.smi.MACRO_VALUE_TYPE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMACRO_VALUE_TYPE_Literal(), this.getMACRO_VALUE_CAP(), null, "literal", null, 0, 1, com.netxforge.smi.MACRO_VALUE_TYPE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMACRO_VALUE_TYPE_String(), ecorePackage.getEString(), "string", null, 0, 1, com.netxforge.smi.MACRO_VALUE_TYPE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(updateTypeEClass, UpdateType.class, "UpdateType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUpdateType_Ref(), this.getTypeAssignment(), null, "ref", null, 0, 1, UpdateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(macrO_VALUE_CAPEClass, com.netxforge.smi.MACRO_VALUE_CAP.class, "MACRO_VALUE_CAP", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMACRO_VALUE_CAP_Ref(), this.getTypeAssignment(), null, "ref", null, 0, 1, com.netxforge.smi.MACRO_VALUE_CAP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_TYPEEClass, com.netxforge.smi.ASN1_TYPE.class, "ASN1_TYPE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(asn1_SIMPLEEClass, com.netxforge.smi.ASN1_SIMPLE.class, "ASN1_SIMPLE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getASN1_SIMPLE_Constraint(), this.getASN1_SIMPLE(), null, "constraint", null, 0, 1, com.netxforge.smi.ASN1_SIMPLE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getASN1_SIMPLE_Name(), ecorePackage.getEString(), "name", null, 0, 1, com.netxforge.smi.ASN1_SIMPLE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getASN1_SIMPLE_Range(), this.getASN1_RANGE(), null, "range", null, 0, 1, com.netxforge.smi.ASN1_SIMPLE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getASN1_SIMPLE_Ranges(), this.getASN1_RANGE(), null, "ranges", null, 0, -1, com.netxforge.smi.ASN1_SIMPLE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_RANGEEClass, com.netxforge.smi.ASN1_RANGE.class, "ASN1_RANGE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getASN1_RANGE_Value(), ecorePackage.getEBigInteger(), "value", null, 0, 1, com.netxforge.smi.ASN1_RANGE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getASN1_RANGE_Start(), ecorePackage.getEBigInteger(), "start", null, 0, 1, com.netxforge.smi.ASN1_RANGE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getASN1_RANGE_End(), ecorePackage.getEBigInteger(), "end", null, 0, 1, com.netxforge.smi.ASN1_RANGE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_CHOICEEClass, com.netxforge.smi.ASN1_CHOICE.class, "ASN1_CHOICE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getASN1_CHOICE_ChoiceType(), this.getASN1_CHOICE_ENTRY(), null, "choiceType", null, 0, -1, com.netxforge.smi.ASN1_CHOICE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_CHOICE_ENTRYEClass, com.netxforge.smi.ASN1_CHOICE_ENTRY.class, "ASN1_CHOICE_ENTRY", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getASN1_CHOICE_ENTRY_Id(), ecorePackage.getEString(), "id", null, 0, 1, com.netxforge.smi.ASN1_CHOICE_ENTRY.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getASN1_CHOICE_ENTRY_ValueType(), this.getChoiceType(), null, "valueType", null, 0, 1, com.netxforge.smi.ASN1_CHOICE_ENTRY.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(choiceTypeEClass, ChoiceType.class, "ChoiceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getChoiceType_TypeRef(), this.getTypeAssignment(), null, "typeRef", null, 0, 1, ChoiceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getChoiceType_SimpleType(), this.getASN1_TYPE(), null, "simpleType", null, 0, 1, ChoiceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getChoiceType_Oi(), ecorePackage.getEString(), "oi", null, 0, 1, ChoiceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(macroValueEClass, MacroValue.class, "MacroValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMacroValue_ValueType(), this.getMACRO_VALUE_TYPE(), null, "valueType", null, 0, 1, MacroValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_OCTET_STRINGEClass, com.netxforge.smi.ASN1_OCTET_STRING.class, "ASN1_OCTET_STRING", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //SmiPackageImpl
