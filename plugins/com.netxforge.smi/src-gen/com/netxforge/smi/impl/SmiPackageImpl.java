/**
 */
package com.netxforge.smi.impl;

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
import com.netxforge.smi.ObjectIdentifierValue;
import com.netxforge.smi.ObjectReferenceable;
import com.netxforge.smi.ObjectValue;
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
  private EClass importsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importClosureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importRefsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass referenceableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectReferenceableEClass = null;

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
  private EClass attributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass identifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bracedObjectReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectValueEClass = null;

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
  private EClass typeNotationRightEClass = null;

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
  private EClass macroValueTypeEClass = null;

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
  private EClass asn1_INTEGER_REFINEMENTEClass = null;

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
  private EClass asn1_SEQUENCEEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asn1_SEQUENCE_OFEClass = null;

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
  public EReference getModule_Imports()
  {
    return (EReference)moduleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModule_Objects()
  {
    return (EReference)moduleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModule_Identifiers()
  {
    return (EReference)moduleEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModule_Types()
  {
    return (EReference)moduleEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImports()
  {
    return importsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImports_Imports()
  {
    return (EReference)importsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImportClosure()
  {
    return importClosureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImportClosure_Refs()
  {
    return (EReference)importClosureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImportClosure_ImportURI()
  {
    return (EAttribute)importClosureEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImportRefs()
  {
    return importRefsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImportRefs_Refs()
  {
    return (EReference)importRefsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImportRef()
  {
    return importRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImportRef_OiRef()
  {
    return (EReference)importRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImportRef_TypeRef()
  {
    return (EReference)importRefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReferenceable()
  {
    return referenceableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReferenceable_Name()
  {
    return (EAttribute)referenceableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReferenceable_Values()
  {
    return (EReference)referenceableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReferenceable_TypeNotation()
  {
    return (EReference)referenceableEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReferenceable_ValueNotation()
  {
    return (EReference)referenceableEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReferenceable_InnerTypes()
  {
    return (EReference)referenceableEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReferenceable_Right()
  {
    return (EReference)referenceableEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectReferenceable()
  {
    return objectReferenceableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObjectReferenceable_Name()
  {
    return (EAttribute)objectReferenceableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectReferenceable_OidValue()
  {
    return (EReference)objectReferenceableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectReferenceable_MacroRef()
  {
    return (EReference)objectReferenceableEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectReferenceable_Attributes()
  {
    return (EReference)objectReferenceableEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectReferenceable_ObjectValue()
  {
    return (EReference)objectReferenceableEClass.getEStructuralFeatures().get(4);
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
  public EReference getObjectIdentifierValue_DescriptorRef()
  {
    return (EReference)objectIdentifierValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObjectIdentifierValue_Name()
  {
    return (EAttribute)objectIdentifierValueEClass.getEStructuralFeatures().get(1);
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
  public EClass getAttribute()
  {
    return attributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttribute_ParamRef()
  {
    return (EReference)attributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttribute_Value()
  {
    return (EReference)attributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttributeValue()
  {
    return attributeValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributeValue_Identifier()
  {
    return (EReference)attributeValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttributeValue_Text()
  {
    return (EAttribute)attributeValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributeValue_TypeRef()
  {
    return (EReference)attributeValueEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributeValue_SubType()
  {
    return (EReference)attributeValueEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributeValue_ObjectRef()
  {
    return (EReference)attributeValueEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributeValue_Integer()
  {
    return (EReference)attributeValueEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributeValue_SequenceOf()
  {
    return (EReference)attributeValueEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIdentifier()
  {
    return identifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIdentifier_Id()
  {
    return (EAttribute)identifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBracedObjectReference()
  {
    return bracedObjectReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBracedObjectReference_ObjectRef()
  {
    return (EReference)bracedObjectReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectValue()
  {
    return objectValueEClass;
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
  public EReference getValueNotation_ValueNotations()
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
  public EClass getValueAssignment()
  {
    return valueAssignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValueAssignment_ValueNotation()
  {
    return (EReference)valueAssignmentEClass.getEStructuralFeatures().get(0);
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
  public EAttribute getValueType_Id()
  {
    return (EAttribute)valueTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValueType_Types()
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
  public EClass getMacroValueType()
  {
    return macroValueTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMacroValueType_Update()
  {
    return (EAttribute)macroValueTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMacroValueType_ValueCAP()
  {
    return (EAttribute)macroValueTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMacroValueType_Ref()
  {
    return (EReference)macroValueTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMacroValueType_Oi()
  {
    return (EAttribute)macroValueTypeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMacroValueType_String()
  {
    return (EAttribute)macroValueTypeEClass.getEStructuralFeatures().get(4);
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
  public EReference getASN1_SIMPLE_Refinement()
  {
    return (EReference)asn1_SIMPLEEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getASN1_SIMPLE_Ranges()
  {
    return (EReference)asn1_SIMPLEEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getASN1_INTEGER_REFINEMENT()
  {
    return asn1_INTEGER_REFINEMENTEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getASN1_INTEGER_REFINEMENT_Refinements()
  {
    return (EAttribute)asn1_INTEGER_REFINEMENTEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getASN1_INTEGER_REFINEMENT_Ints()
  {
    return (EAttribute)asn1_INTEGER_REFINEMENTEClass.getEStructuralFeatures().get(1);
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
  public EClass getASN1_SEQUENCE()
  {
    return asn1_SEQUENCEEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getASN1_SEQUENCE_ChoiceType()
  {
    return (EReference)asn1_SEQUENCEEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getASN1_SEQUENCE_OF()
  {
    return asn1_SEQUENCE_OFEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getASN1_SEQUENCE_OF_Ref()
  {
    return (EReference)asn1_SEQUENCE_OFEClass.getEStructuralFeatures().get(0);
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
    createEReference(moduleEClass, MODULE__IMPORTS);
    createEReference(moduleEClass, MODULE__OBJECTS);
    createEReference(moduleEClass, MODULE__IDENTIFIERS);
    createEReference(moduleEClass, MODULE__TYPES);

    importsEClass = createEClass(IMPORTS);
    createEReference(importsEClass, IMPORTS__IMPORTS);

    importClosureEClass = createEClass(IMPORT_CLOSURE);
    createEReference(importClosureEClass, IMPORT_CLOSURE__REFS);
    createEAttribute(importClosureEClass, IMPORT_CLOSURE__IMPORT_URI);

    importRefsEClass = createEClass(IMPORT_REFS);
    createEReference(importRefsEClass, IMPORT_REFS__REFS);

    importRefEClass = createEClass(IMPORT_REF);
    createEReference(importRefEClass, IMPORT_REF__OI_REF);
    createEReference(importRefEClass, IMPORT_REF__TYPE_REF);

    referenceableEClass = createEClass(REFERENCEABLE);
    createEAttribute(referenceableEClass, REFERENCEABLE__NAME);
    createEReference(referenceableEClass, REFERENCEABLE__VALUES);
    createEReference(referenceableEClass, REFERENCEABLE__TYPE_NOTATION);
    createEReference(referenceableEClass, REFERENCEABLE__VALUE_NOTATION);
    createEReference(referenceableEClass, REFERENCEABLE__INNER_TYPES);
    createEReference(referenceableEClass, REFERENCEABLE__RIGHT);

    objectReferenceableEClass = createEClass(OBJECT_REFERENCEABLE);
    createEAttribute(objectReferenceableEClass, OBJECT_REFERENCEABLE__NAME);
    createEReference(objectReferenceableEClass, OBJECT_REFERENCEABLE__OID_VALUE);
    createEReference(objectReferenceableEClass, OBJECT_REFERENCEABLE__MACRO_REF);
    createEReference(objectReferenceableEClass, OBJECT_REFERENCEABLE__ATTRIBUTES);
    createEReference(objectReferenceableEClass, OBJECT_REFERENCEABLE__OBJECT_VALUE);

    objectIdentifierValueEClass = createEClass(OBJECT_IDENTIFIER_VALUE);
    createEReference(objectIdentifierValueEClass, OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REF);
    createEAttribute(objectIdentifierValueEClass, OBJECT_IDENTIFIER_VALUE__NAME);
    createEAttribute(objectIdentifierValueEClass, OBJECT_IDENTIFIER_VALUE__SUB_IDS);

    attributeEClass = createEClass(ATTRIBUTE);
    createEReference(attributeEClass, ATTRIBUTE__PARAM_REF);
    createEReference(attributeEClass, ATTRIBUTE__VALUE);

    attributeValueEClass = createEClass(ATTRIBUTE_VALUE);
    createEReference(attributeValueEClass, ATTRIBUTE_VALUE__IDENTIFIER);
    createEAttribute(attributeValueEClass, ATTRIBUTE_VALUE__TEXT);
    createEReference(attributeValueEClass, ATTRIBUTE_VALUE__TYPE_REF);
    createEReference(attributeValueEClass, ATTRIBUTE_VALUE__SUB_TYPE);
    createEReference(attributeValueEClass, ATTRIBUTE_VALUE__OBJECT_REF);
    createEReference(attributeValueEClass, ATTRIBUTE_VALUE__INTEGER);
    createEReference(attributeValueEClass, ATTRIBUTE_VALUE__SEQUENCE_OF);

    identifierEClass = createEClass(IDENTIFIER);
    createEAttribute(identifierEClass, IDENTIFIER__ID);

    bracedObjectReferenceEClass = createEClass(BRACED_OBJECT_REFERENCE);
    createEReference(bracedObjectReferenceEClass, BRACED_OBJECT_REFERENCE__OBJECT_REF);

    objectValueEClass = createEClass(OBJECT_VALUE);

    typeNotationEClass = createEClass(TYPE_NOTATION);
    createEAttribute(typeNotationEClass, TYPE_NOTATION__NAME);
    createEReference(typeNotationEClass, TYPE_NOTATION__TYPE_NOTATIONS);

    valueNotationEClass = createEClass(VALUE_NOTATION);
    createEAttribute(valueNotationEClass, VALUE_NOTATION__NAME);
    createEReference(valueNotationEClass, VALUE_NOTATION__VALUE_NOTATIONS);

    typeAssignmentEClass = createEClass(TYPE_ASSIGNMENT);
    createEReference(typeAssignmentEClass, TYPE_ASSIGNMENT__PARENT_REF);
    createEReference(typeAssignmentEClass, TYPE_ASSIGNMENT__CHILD_REF);
    createEReference(typeAssignmentEClass, TYPE_ASSIGNMENT__TYPE);

    typeNotationRightEClass = createEClass(TYPE_NOTATION_RIGHT);
    createEReference(typeNotationRightEClass, TYPE_NOTATION_RIGHT__VALUE);

    valueAssignmentEClass = createEClass(VALUE_ASSIGNMENT);
    createEReference(valueAssignmentEClass, VALUE_ASSIGNMENT__VALUE_NOTATION);

    valueEClass = createEClass(VALUE);
    createEReference(valueEClass, VALUE__TAG);
    createEAttribute(valueEClass, VALUE__IMPLICIT);
    createEReference(valueEClass, VALUE__VALUE_TYPES);

    tagEClass = createEClass(TAG);
    createEAttribute(tagEClass, TAG__TAG_VALUE);

    valueTypeEClass = createEClass(VALUE_TYPE);
    createEReference(valueTypeEClass, VALUE_TYPE__PARAM);
    createEAttribute(valueTypeEClass, VALUE_TYPE__ID);
    createEReference(valueTypeEClass, VALUE_TYPE__TYPES);
    createEReference(valueTypeEClass, VALUE_TYPE__SIMPLE_TYPE);
    createEReference(valueTypeEClass, VALUE_TYPE__MACRO_VALUE);

    macroValueTypeEClass = createEClass(MACRO_VALUE_TYPE);
    createEAttribute(macroValueTypeEClass, MACRO_VALUE_TYPE__UPDATE);
    createEAttribute(macroValueTypeEClass, MACRO_VALUE_TYPE__VALUE_CAP);
    createEReference(macroValueTypeEClass, MACRO_VALUE_TYPE__REF);
    createEAttribute(macroValueTypeEClass, MACRO_VALUE_TYPE__OI);
    createEAttribute(macroValueTypeEClass, MACRO_VALUE_TYPE__STRING);

    asn1_TYPEEClass = createEClass(ASN1_TYPE);

    asn1_SIMPLEEClass = createEClass(ASN1_SIMPLE);
    createEReference(asn1_SIMPLEEClass, ASN1_SIMPLE__CONSTRAINT);
    createEAttribute(asn1_SIMPLEEClass, ASN1_SIMPLE__NAME);
    createEReference(asn1_SIMPLEEClass, ASN1_SIMPLE__RANGE);
    createEReference(asn1_SIMPLEEClass, ASN1_SIMPLE__REFINEMENT);
    createEReference(asn1_SIMPLEEClass, ASN1_SIMPLE__RANGES);

    asn1_INTEGER_REFINEMENTEClass = createEClass(ASN1_INTEGER_REFINEMENT);
    createEAttribute(asn1_INTEGER_REFINEMENTEClass, ASN1_INTEGER_REFINEMENT__REFINEMENTS);
    createEAttribute(asn1_INTEGER_REFINEMENTEClass, ASN1_INTEGER_REFINEMENT__INTS);

    asn1_RANGEEClass = createEClass(ASN1_RANGE);
    createEAttribute(asn1_RANGEEClass, ASN1_RANGE__VALUE);
    createEAttribute(asn1_RANGEEClass, ASN1_RANGE__START);
    createEAttribute(asn1_RANGEEClass, ASN1_RANGE__END);

    asn1_CHOICEEClass = createEClass(ASN1_CHOICE);
    createEReference(asn1_CHOICEEClass, ASN1_CHOICE__CHOICE_TYPE);

    asn1_SEQUENCEEClass = createEClass(ASN1_SEQUENCE);
    createEReference(asn1_SEQUENCEEClass, ASN1_SEQUENCE__CHOICE_TYPE);

    asn1_SEQUENCE_OFEClass = createEClass(ASN1_SEQUENCE_OF);
    createEReference(asn1_SEQUENCE_OFEClass, ASN1_SEQUENCE_OF__REF);

    asn1_CHOICE_ENTRYEClass = createEClass(ASN1_CHOICE_ENTRY);
    createEAttribute(asn1_CHOICE_ENTRYEClass, ASN1_CHOICE_ENTRY__ID);
    createEReference(asn1_CHOICE_ENTRYEClass, ASN1_CHOICE_ENTRY__VALUE_TYPE);

    choiceTypeEClass = createEClass(CHOICE_TYPE);
    createEReference(choiceTypeEClass, CHOICE_TYPE__TYPE_REF);
    createEReference(choiceTypeEClass, CHOICE_TYPE__SIMPLE_TYPE);

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
    referenceableEClass.getESuperTypes().add(this.getTypeAssignment());
    objectIdentifierValueEClass.getESuperTypes().add(this.getObjectValue());
    typeAssignmentEClass.getESuperTypes().add(this.getTypeNotationRight());
    valueEClass.getESuperTypes().add(this.getTypeAssignment());
    asn1_SIMPLEEClass.getESuperTypes().add(this.getASN1_TYPE());
    asn1_CHOICEEClass.getESuperTypes().add(this.getASN1_TYPE());
    asn1_SEQUENCEEClass.getESuperTypes().add(this.getASN1_TYPE());
    macroValueEClass.getESuperTypes().add(this.getValue());
    asn1_OCTET_STRINGEClass.getESuperTypes().add(this.getASN1_SIMPLE());

    // Initialize classes and features; add operations and parameters
    initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModule_Name(), ecorePackage.getEString(), "name", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModule_Imports(), this.getImports(), null, "imports", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModule_Objects(), this.getObjectReferenceable(), null, "objects", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModule_Identifiers(), this.getObjectReferenceable(), null, "identifiers", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModule_Types(), this.getReferenceable(), null, "types", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importsEClass, Imports.class, "Imports", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getImports_Imports(), this.getImportClosure(), null, "imports", null, 0, -1, Imports.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importClosureEClass, ImportClosure.class, "ImportClosure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getImportClosure_Refs(), this.getImportRefs(), null, "refs", null, 0, 1, ImportClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getImportClosure_ImportURI(), ecorePackage.getEString(), "importURI", null, 0, 1, ImportClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importRefsEClass, ImportRefs.class, "ImportRefs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getImportRefs_Refs(), this.getImportRef(), null, "refs", null, 0, -1, ImportRefs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importRefEClass, ImportRef.class, "ImportRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getImportRef_OiRef(), this.getObjectReferenceable(), null, "oiRef", null, 0, 1, ImportRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getImportRef_TypeRef(), this.getReferenceable(), null, "typeRef", null, 0, 1, ImportRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(referenceableEClass, Referenceable.class, "Referenceable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReferenceable_Name(), ecorePackage.getEString(), "name", null, 0, 1, Referenceable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReferenceable_Values(), this.getValue(), null, "values", null, 0, -1, Referenceable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReferenceable_TypeNotation(), this.getTypeNotation(), null, "typeNotation", null, 0, 1, Referenceable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReferenceable_ValueNotation(), this.getValueNotation(), null, "valueNotation", null, 0, 1, Referenceable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReferenceable_InnerTypes(), this.getReferenceable(), null, "innerTypes", null, 0, -1, Referenceable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReferenceable_Right(), this.getTypeNotationRight(), null, "right", null, 0, 1, Referenceable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectReferenceableEClass, ObjectReferenceable.class, "ObjectReferenceable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getObjectReferenceable_Name(), ecorePackage.getEString(), "name", null, 0, 1, ObjectReferenceable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectReferenceable_OidValue(), this.getObjectIdentifierValue(), null, "oidValue", null, 0, 1, ObjectReferenceable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectReferenceable_MacroRef(), this.getReferenceable(), null, "macroRef", null, 0, 1, ObjectReferenceable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectReferenceable_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, ObjectReferenceable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectReferenceable_ObjectValue(), this.getObjectValue(), null, "objectValue", null, 0, 1, ObjectReferenceable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectIdentifierValueEClass, ObjectIdentifierValue.class, "ObjectIdentifierValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getObjectIdentifierValue_DescriptorRef(), this.getObjectReferenceable(), null, "descriptorRef", null, 0, 1, ObjectIdentifierValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObjectIdentifierValue_Name(), ecorePackage.getEString(), "name", null, 0, 1, ObjectIdentifierValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObjectIdentifierValue_SubIds(), ecorePackage.getEBigInteger(), "subIds", null, 0, -1, ObjectIdentifierValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAttribute_ParamRef(), this.getReferenceable(), null, "paramRef", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttribute_Value(), this.getAttributeValue(), null, "value", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeValueEClass, AttributeValue.class, "AttributeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAttributeValue_Identifier(), this.getIdentifier(), null, "identifier", null, 0, 1, AttributeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAttributeValue_Text(), ecorePackage.getEString(), "text", null, 0, 1, AttributeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttributeValue_TypeRef(), this.getReferenceable(), null, "typeRef", null, 0, 1, AttributeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttributeValue_SubType(), this.getASN1_SIMPLE(), null, "subType", null, 0, 1, AttributeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttributeValue_ObjectRef(), this.getBracedObjectReference(), null, "objectRef", null, 0, 1, AttributeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttributeValue_Integer(), this.getASN1_SIMPLE(), null, "integer", null, 0, 1, AttributeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttributeValue_SequenceOf(), this.getASN1_SEQUENCE_OF(), null, "sequenceOf", null, 0, 1, AttributeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(identifierEClass, Identifier.class, "Identifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIdentifier_Id(), ecorePackage.getEString(), "id", null, 0, 1, Identifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bracedObjectReferenceEClass, BracedObjectReference.class, "BracedObjectReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBracedObjectReference_ObjectRef(), this.getObjectReferenceable(), null, "objectRef", null, 0, 1, BracedObjectReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectValueEClass, ObjectValue.class, "ObjectValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(typeNotationEClass, TypeNotation.class, "TypeNotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypeNotation_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypeNotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeNotation_TypeNotations(), this.getTypeAssignment(), null, "typeNotations", null, 0, -1, TypeNotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueNotationEClass, ValueNotation.class, "ValueNotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getValueNotation_Name(), ecorePackage.getEString(), "name", null, 0, 1, ValueNotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValueNotation_ValueNotations(), this.getValueAssignment(), null, "valueNotations", null, 0, -1, ValueNotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeAssignmentEClass, TypeAssignment.class, "TypeAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeAssignment_ParentRef(), this.getTypeAssignment(), null, "parentRef", null, 0, 1, TypeAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeAssignment_ChildRef(), this.getTypeAssignment(), null, "childRef", null, 0, 1, TypeAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeAssignment_Type(), this.getReferenceable(), null, "type", null, 0, 1, TypeAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeNotationRightEClass, TypeNotationRight.class, "TypeNotationRight", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeNotationRight_Value(), this.getValue(), null, "value", null, 0, 1, TypeNotationRight.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueAssignmentEClass, ValueAssignment.class, "ValueAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getValueAssignment_ValueNotation(), this.getValue(), null, "valueNotation", null, 0, 1, ValueAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueEClass, Value.class, "Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getValue_Tag(), this.getTag(), null, "tag", null, 0, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getValue_Implicit(), ecorePackage.getEBoolean(), "implicit", null, 0, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValue_ValueTypes(), this.getValueType(), null, "valueTypes", null, 0, -1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tagEClass, Tag.class, "Tag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTag_TagValue(), ecorePackage.getEBigInteger(), "tagValue", null, 0, 1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueTypeEClass, ValueType.class, "ValueType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getValueType_Param(), this.getReferenceable(), null, "param", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getValueType_Id(), ecorePackage.getEString(), "id", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValueType_Types(), this.getTypeAssignment(), null, "types", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValueType_SimpleType(), this.getASN1_TYPE(), null, "simpleType", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValueType_MacroValue(), this.getValue(), null, "macroValue", null, 0, 1, ValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(macroValueTypeEClass, MacroValueType.class, "MacroValueType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMacroValueType_Update(), ecorePackage.getEBoolean(), "update", null, 0, 1, MacroValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMacroValueType_ValueCAP(), ecorePackage.getEBoolean(), "valueCAP", null, 0, 1, MacroValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMacroValueType_Ref(), this.getTypeAssignment(), null, "ref", null, 0, 1, MacroValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMacroValueType_Oi(), ecorePackage.getEString(), "oi", null, 0, 1, MacroValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMacroValueType_String(), ecorePackage.getEString(), "string", null, 0, 1, MacroValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_TYPEEClass, com.netxforge.smi.ASN1_TYPE.class, "ASN1_TYPE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(asn1_SIMPLEEClass, com.netxforge.smi.ASN1_SIMPLE.class, "ASN1_SIMPLE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getASN1_SIMPLE_Constraint(), this.getASN1_SIMPLE(), null, "constraint", null, 0, 1, com.netxforge.smi.ASN1_SIMPLE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getASN1_SIMPLE_Name(), ecorePackage.getEString(), "name", null, 0, 1, com.netxforge.smi.ASN1_SIMPLE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getASN1_SIMPLE_Range(), this.getASN1_RANGE(), null, "range", null, 0, 1, com.netxforge.smi.ASN1_SIMPLE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getASN1_SIMPLE_Refinement(), this.getASN1_INTEGER_REFINEMENT(), null, "refinement", null, 0, 1, com.netxforge.smi.ASN1_SIMPLE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getASN1_SIMPLE_Ranges(), this.getASN1_RANGE(), null, "ranges", null, 0, -1, com.netxforge.smi.ASN1_SIMPLE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_INTEGER_REFINEMENTEClass, com.netxforge.smi.ASN1_INTEGER_REFINEMENT.class, "ASN1_INTEGER_REFINEMENT", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getASN1_INTEGER_REFINEMENT_Refinements(), ecorePackage.getEString(), "refinements", null, 0, -1, com.netxforge.smi.ASN1_INTEGER_REFINEMENT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getASN1_INTEGER_REFINEMENT_Ints(), ecorePackage.getEBigInteger(), "ints", null, 0, -1, com.netxforge.smi.ASN1_INTEGER_REFINEMENT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_RANGEEClass, com.netxforge.smi.ASN1_RANGE.class, "ASN1_RANGE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getASN1_RANGE_Value(), ecorePackage.getEBigInteger(), "value", null, 0, 1, com.netxforge.smi.ASN1_RANGE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getASN1_RANGE_Start(), ecorePackage.getEBigInteger(), "start", null, 0, 1, com.netxforge.smi.ASN1_RANGE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getASN1_RANGE_End(), ecorePackage.getEBigInteger(), "end", null, 0, 1, com.netxforge.smi.ASN1_RANGE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_CHOICEEClass, com.netxforge.smi.ASN1_CHOICE.class, "ASN1_CHOICE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getASN1_CHOICE_ChoiceType(), this.getASN1_CHOICE_ENTRY(), null, "choiceType", null, 0, -1, com.netxforge.smi.ASN1_CHOICE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_SEQUENCEEClass, com.netxforge.smi.ASN1_SEQUENCE.class, "ASN1_SEQUENCE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getASN1_SEQUENCE_ChoiceType(), this.getASN1_CHOICE_ENTRY(), null, "choiceType", null, 0, -1, com.netxforge.smi.ASN1_SEQUENCE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_SEQUENCE_OFEClass, com.netxforge.smi.ASN1_SEQUENCE_OF.class, "ASN1_SEQUENCE_OF", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getASN1_SEQUENCE_OF_Ref(), this.getTypeAssignment(), null, "ref", null, 0, 1, com.netxforge.smi.ASN1_SEQUENCE_OF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_CHOICE_ENTRYEClass, com.netxforge.smi.ASN1_CHOICE_ENTRY.class, "ASN1_CHOICE_ENTRY", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getASN1_CHOICE_ENTRY_Id(), ecorePackage.getEString(), "id", null, 0, 1, com.netxforge.smi.ASN1_CHOICE_ENTRY.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getASN1_CHOICE_ENTRY_ValueType(), this.getChoiceType(), null, "valueType", null, 0, 1, com.netxforge.smi.ASN1_CHOICE_ENTRY.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(choiceTypeEClass, ChoiceType.class, "ChoiceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getChoiceType_TypeRef(), this.getTypeAssignment(), null, "typeRef", null, 0, 1, ChoiceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getChoiceType_SimpleType(), this.getASN1_TYPE(), null, "simpleType", null, 0, 1, ChoiceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(macroValueEClass, MacroValue.class, "MacroValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMacroValue_ValueType(), this.getMacroValueType(), null, "valueType", null, 0, 1, MacroValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asn1_OCTET_STRINGEClass, com.netxforge.smi.ASN1_OCTET_STRING.class, "ASN1_OCTET_STRING", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //SmiPackageImpl
