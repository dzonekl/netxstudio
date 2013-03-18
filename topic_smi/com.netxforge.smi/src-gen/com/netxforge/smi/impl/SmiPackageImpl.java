/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.Assignment;
import com.netxforge.smi.Macro;
import com.netxforge.smi.MacroValue;
import com.netxforge.smi.Module;
import com.netxforge.smi.ObjectIdentifier;
import com.netxforge.smi.ObjectIdentifierValue;
import com.netxforge.smi.Or;
import com.netxforge.smi.SmiFactory;
import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.ValueAssignment;
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
  private EClass macroEClass = null;

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
  private EClass valueAssignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orEClass = null;

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
  private EClass asn1_OCTET_STRINGEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum macrO_VALUE_TYPEEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum welL_KNOWN_NAMESEEnum = null;

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
  public EReference getAssignment_Macros()
  {
    return (EReference)assignmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignment_Types()
  {
    return (EReference)assignmentEClass.getEStructuralFeatures().get(1);
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
  public EAttribute getMacro_Descriptor()
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
  public EClass getMacroValue()
  {
    return macroValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMacroValue_Type()
  {
    return (EAttribute)macroValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValueAssignment()
  {
    return valueAssignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getValueAssignment_TypeReference()
  {
    return (EAttribute)valueAssignmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValueAssignment_Value()
  {
    return (EReference)valueAssignmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOr()
  {
    return orEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOr_Left()
  {
    return (EReference)orEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOr_Right()
  {
    return (EReference)orEClass.getEStructuralFeatures().get(1);
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
  public EReference getValueType_Type()
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
  public EClass getASN1_SUBTYPE()
  {
    return asn1_SUBTYPEEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getASN1_SUBTYPE_Range()
  {
    return (EReference)asn1_SUBTYPEEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getASN1_SUBTYPE_Value()
  {
    return (EAttribute)asn1_SUBTYPEEClass.getEStructuralFeatures().get(1);
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
  public EAttribute getASN1_RANGE_Start()
  {
    return (EAttribute)asn1_RANGEEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getASN1_RANGE_End()
  {
    return (EAttribute)asn1_RANGEEClass.getEStructuralFeatures().get(1);
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
  public EAttribute getObjectIdentifier_Descriptor()
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
  public EClass getASN1_OCTET_STRING()
  {
    return asn1_OCTET_STRINGEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getMACRO_VALUE_TYPE()
  {
    return macrO_VALUE_TYPEEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getWELL_KNOWN_NAMES()
  {
    return welL_KNOWN_NAMESEEnum;
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
    createEReference(assignmentEClass, ASSIGNMENT__MACROS);
    createEReference(assignmentEClass, ASSIGNMENT__TYPES);

    macroEClass = createEClass(MACRO);
    createEAttribute(macroEClass, MACRO__DESCRIPTOR);
    createEReference(macroEClass, MACRO__TYPE_NOTATIONS);
    createEReference(macroEClass, MACRO__VALUE_NOTATION);
    createEReference(macroEClass, MACRO__INNER_TYPES);

    macroValueEClass = createEClass(MACRO_VALUE);
    createEAttribute(macroValueEClass, MACRO_VALUE__TYPE);

    valueAssignmentEClass = createEClass(VALUE_ASSIGNMENT);
    createEAttribute(valueAssignmentEClass, VALUE_ASSIGNMENT__TYPE_REFERENCE);
    createEReference(valueAssignmentEClass, VALUE_ASSIGNMENT__VALUE);

    orEClass = createEClass(OR);
    createEReference(orEClass, OR__LEFT);
    createEReference(orEClass, OR__RIGHT);

    valueTypeEClass = createEClass(VALUE_TYPE);
    createEAttribute(valueTypeEClass, VALUE_TYPE__NAME);
    createEReference(valueTypeEClass, VALUE_TYPE__TYPE);
    createEReference(valueTypeEClass, VALUE_TYPE__SIMPLE_TYPE);

    asn1_TYPEEClass = createEClass(ASN1_TYPE);

    asn1_SIMPLEEClass = createEClass(ASN1_SIMPLE);
    createEReference(asn1_SIMPLEEClass, ASN1_SIMPLE__CONSTRAINT);
    createEAttribute(asn1_SIMPLEEClass, ASN1_SIMPLE__VALUE_PAIRS);

    asn1_CHOICEEClass = createEClass(ASN1_CHOICE);
    createEReference(asn1_CHOICEEClass, ASN1_CHOICE__CHOICES);

    asn1_CHOICE_ENTRYEClass = createEClass(ASN1_CHOICE_ENTRY);
    createEAttribute(asn1_CHOICE_ENTRYEClass, ASN1_CHOICE_ENTRY__ID);
    createEReference(asn1_CHOICE_ENTRYEClass, ASN1_CHOICE_ENTRY__VALUE_TYPE);

    asn1_SUBTYPEEClass = createEClass(ASN1_SUBTYPE);
    createEReference(asn1_SUBTYPEEClass, ASN1_SUBTYPE__RANGE);
    createEAttribute(asn1_SUBTYPEEClass, ASN1_SUBTYPE__VALUE);

    asn1_RANGEEClass = createEClass(ASN1_RANGE);
    createEAttribute(asn1_RANGEEClass, ASN1_RANGE__START);
    createEAttribute(asn1_RANGEEClass, ASN1_RANGE__END);

    objectIdentifierEClass = createEClass(OBJECT_IDENTIFIER);
    createEAttribute(objectIdentifierEClass, OBJECT_IDENTIFIER__DESCRIPTOR);
    createEReference(objectIdentifierEClass, OBJECT_IDENTIFIER__OID_VALUE);

    objectIdentifierValueEClass = createEClass(OBJECT_IDENTIFIER_VALUE);
    createEReference(objectIdentifierValueEClass, OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REFERENCE);
    createEAttribute(objectIdentifierValueEClass, OBJECT_IDENTIFIER_VALUE__SUB_IDS);

    asn1_OCTET_STRINGEClass = createEClass(ASN1_OCTET_STRING);

    // Create enums
    macrO_VALUE_TYPEEEnum = createEEnum(MACRO_VALUE_TYPE);
    welL_KNOWN_NAMESEEnum = createEEnum(WELL_KNOWN_NAMES);
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
    valueTypeEClass.getESuperTypes().add(this.getOr());
    asn1_SIMPLEEClass.getESuperTypes().add(this.getASN1_TYPE());
    asn1_CHOICEEClass.getESuperTypes().add(this.getASN1_TYPE());
    objectIdentifierEClass.getESuperTypes().add(this.getAssignment());
    asn1_OCTET_STRINGEClass.getESuperTypes().add(this.getASN1_SIMPLE());

    // Initialize classes and features; add operations and parameters
    initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModule_Id(), ecorePackage.getEString(), "id", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModule_Assignments(), this.getAssignment(), null, "assignments", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssignment_Macros(), this.getMacro(), null, "macros", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssignment_Types(), this.getValueAssignment(), null, "types", null, 0, -1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(macroEClass, Macro.class, "Macro", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMacro_Descriptor(), ecorePackage.getEString(), "descriptor", null, 0, 1, Macro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMacro_TypeNotations(), this.getValueAssignment(), null, "typeNotations", null, 0, -1, Macro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMacro_ValueNotation(), this.getMacroValue(), null, "valueNotation", null, 0, 1, Macro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMacro_InnerTypes(), this.getValueAssignment(), null, "innerTypes", null, 0, -1, Macro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(macroValueEClass, MacroValue.class, "MacroValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMacroValue_Type(), this.getMACRO_VALUE_TYPE(), "type", null, 0, 1, MacroValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueAssignmentEClass, ValueAssignment.class, "ValueAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getValueAssignment_TypeReference(), ecorePackage.getEString(), "typeReference", null, 0, 1, ValueAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValueAssignment_Value(), this.getOr(), null, "value", null, 0, 1, ValueAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(orEClass, Or.class, "Or", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOr_Left(), this.getValueType(), null, "left", null, 0, 1, Or.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOr_Right(), this.getValueType(), null, "right", null, 0, 1, Or.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueTypeEClass, ValueType.class, "ValueType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getValueType_Name(), ecorePackage.getEString(), "name", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValueType_Type(), this.getValueAssignment(), null, "type", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValueType_SimpleType(), this.getASN1_TYPE(), null, "simpleType", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_TYPEEClass, com.netxforge.smi.ASN1_TYPE.class, "ASN1_TYPE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(asn1_SIMPLEEClass, com.netxforge.smi.ASN1_SIMPLE.class, "ASN1_SIMPLE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getASN1_SIMPLE_Constraint(), this.getASN1_SUBTYPE(), null, "constraint", null, 0, 1, com.netxforge.smi.ASN1_SIMPLE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getASN1_SIMPLE_ValuePairs(), ecorePackage.getEString(), "valuePairs", null, 0, -1, com.netxforge.smi.ASN1_SIMPLE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_CHOICEEClass, com.netxforge.smi.ASN1_CHOICE.class, "ASN1_CHOICE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getASN1_CHOICE_Choices(), this.getASN1_CHOICE_ENTRY(), null, "choices", null, 0, -1, com.netxforge.smi.ASN1_CHOICE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_CHOICE_ENTRYEClass, com.netxforge.smi.ASN1_CHOICE_ENTRY.class, "ASN1_CHOICE_ENTRY", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getASN1_CHOICE_ENTRY_Id(), ecorePackage.getEString(), "id", null, 0, 1, com.netxforge.smi.ASN1_CHOICE_ENTRY.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getASN1_CHOICE_ENTRY_ValueType(), this.getValueType(), null, "valueType", null, 0, 1, com.netxforge.smi.ASN1_CHOICE_ENTRY.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_SUBTYPEEClass, com.netxforge.smi.ASN1_SUBTYPE.class, "ASN1_SUBTYPE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getASN1_SUBTYPE_Range(), this.getASN1_RANGE(), null, "range", null, 0, 1, com.netxforge.smi.ASN1_SUBTYPE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getASN1_SUBTYPE_Value(), ecorePackage.getEInt(), "value", null, 0, 1, com.netxforge.smi.ASN1_SUBTYPE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_RANGEEClass, com.netxforge.smi.ASN1_RANGE.class, "ASN1_RANGE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getASN1_RANGE_Start(), ecorePackage.getEInt(), "start", null, 0, 1, com.netxforge.smi.ASN1_RANGE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getASN1_RANGE_End(), ecorePackage.getEInt(), "end", null, 0, 1, com.netxforge.smi.ASN1_RANGE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectIdentifierEClass, ObjectIdentifier.class, "ObjectIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getObjectIdentifier_Descriptor(), ecorePackage.getEString(), "descriptor", null, 0, 1, ObjectIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectIdentifier_OidValue(), this.getObjectIdentifierValue(), null, "oidValue", null, 0, 1, ObjectIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectIdentifierValueEClass, ObjectIdentifierValue.class, "ObjectIdentifierValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getObjectIdentifierValue_DescriptorReference(), this.getObjectIdentifier(), null, "descriptorReference", null, 0, 1, ObjectIdentifierValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObjectIdentifierValue_SubIds(), ecorePackage.getEInt(), "subIds", null, 0, -1, ObjectIdentifierValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_OCTET_STRINGEClass, com.netxforge.smi.ASN1_OCTET_STRING.class, "ASN1_OCTET_STRING", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(macrO_VALUE_TYPEEEnum, com.netxforge.smi.MACRO_VALUE_TYPE.class, "MACRO_VALUE_TYPE");
    addEEnumLiteral(macrO_VALUE_TYPEEEnum, com.netxforge.smi.MACRO_VALUE_TYPE.VALUE);
    addEEnumLiteral(macrO_VALUE_TYPEEEnum, com.netxforge.smi.MACRO_VALUE_TYPE.UPDATE);

    initEEnum(welL_KNOWN_NAMESEEnum, com.netxforge.smi.WELL_KNOWN_NAMES.class, "WELL_KNOWN_NAMES");
    addEEnumLiteral(welL_KNOWN_NAMESEEnum, com.netxforge.smi.WELL_KNOWN_NAMES.CCITT);
    addEEnumLiteral(welL_KNOWN_NAMESEEnum, com.netxforge.smi.WELL_KNOWN_NAMES.ISO);
    addEEnumLiteral(welL_KNOWN_NAMESEEnum, com.netxforge.smi.WELL_KNOWN_NAMES.JOINT_ISO_CCITT);

    // Create resource
    createResource(eNS_URI);
  }

} //SmiPackageImpl
