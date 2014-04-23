/**
 */
package com.netxforge.smi.util;

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
import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.Tag;
import com.netxforge.smi.TypeAssignment;
import com.netxforge.smi.TypeNotation;
import com.netxforge.smi.TypeNotationRight;
import com.netxforge.smi.Value;
import com.netxforge.smi.ValueAssignment;
import com.netxforge.smi.ValueNotation;
import com.netxforge.smi.ValueType;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.netxforge.smi.SmiPackage
 * @generated
 */
public class SmiAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SmiPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SmiAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = SmiPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SmiSwitch<Adapter> modelSwitch =
    new SmiSwitch<Adapter>()
    {
      @Override
      public Adapter caseModule(Module object)
      {
        return createModuleAdapter();
      }
      @Override
      public Adapter caseImports(Imports object)
      {
        return createImportsAdapter();
      }
      @Override
      public Adapter caseImportClosure(ImportClosure object)
      {
        return createImportClosureAdapter();
      }
      @Override
      public Adapter caseImportRefs(ImportRefs object)
      {
        return createImportRefsAdapter();
      }
      @Override
      public Adapter caseImportRef(ImportRef object)
      {
        return createImportRefAdapter();
      }
      @Override
      public Adapter caseObjectReferenceable(ObjectReferenceable object)
      {
        return createObjectReferenceableAdapter();
      }
      @Override
      public Adapter caseObject(com.netxforge.smi.Object object)
      {
        return createObjectAdapter();
      }
      @Override
      public Adapter caseObjectReference(ObjectReference object)
      {
        return createObjectReferenceAdapter();
      }
      @Override
      public Adapter caseAttribute(Attribute object)
      {
        return createAttributeAdapter();
      }
      @Override
      public Adapter caseAttributeValue(AttributeValue object)
      {
        return createAttributeValueAdapter();
      }
      @Override
      public Adapter caseIdentifier(Identifier object)
      {
        return createIdentifierAdapter();
      }
      @Override
      public Adapter caseBracedObjectReference(BracedObjectReference object)
      {
        return createBracedObjectReferenceAdapter();
      }
      @Override
      public Adapter caseReferenceable(Referenceable object)
      {
        return createReferenceableAdapter();
      }
      @Override
      public Adapter caseTypeNotation(TypeNotation object)
      {
        return createTypeNotationAdapter();
      }
      @Override
      public Adapter caseValueNotation(ValueNotation object)
      {
        return createValueNotationAdapter();
      }
      @Override
      public Adapter caseTypeAssignment(TypeAssignment object)
      {
        return createTypeAssignmentAdapter();
      }
      @Override
      public Adapter caseTypeNotationRight(TypeNotationRight object)
      {
        return createTypeNotationRightAdapter();
      }
      @Override
      public Adapter caseValueAssignment(ValueAssignment object)
      {
        return createValueAssignmentAdapter();
      }
      @Override
      public Adapter caseValue(Value object)
      {
        return createValueAdapter();
      }
      @Override
      public Adapter caseTag(Tag object)
      {
        return createTagAdapter();
      }
      @Override
      public Adapter caseValueType(ValueType object)
      {
        return createValueTypeAdapter();
      }
      @Override
      public Adapter caseMacroValueType(MacroValueType object)
      {
        return createMacroValueTypeAdapter();
      }
      @Override
      public Adapter caseASN1_TYPE(ASN1_TYPE object)
      {
        return createASN1_TYPEAdapter();
      }
      @Override
      public Adapter caseASN1_SIMPLE(ASN1_SIMPLE object)
      {
        return createASN1_SIMPLEAdapter();
      }
      @Override
      public Adapter caseASN1_INTEGER_REFINEMENT(ASN1_INTEGER_REFINEMENT object)
      {
        return createASN1_INTEGER_REFINEMENTAdapter();
      }
      @Override
      public Adapter caseASN1_RANGE(ASN1_RANGE object)
      {
        return createASN1_RANGEAdapter();
      }
      @Override
      public Adapter caseASN1_CHOICE(ASN1_CHOICE object)
      {
        return createASN1_CHOICEAdapter();
      }
      @Override
      public Adapter caseASN1_SEQUENCE(ASN1_SEQUENCE object)
      {
        return createASN1_SEQUENCEAdapter();
      }
      @Override
      public Adapter caseASN1_SEQUENCE_OF(ASN1_SEQUENCE_OF object)
      {
        return createASN1_SEQUENCE_OFAdapter();
      }
      @Override
      public Adapter caseASN1_CHOICE_ENTRY(ASN1_CHOICE_ENTRY object)
      {
        return createASN1_CHOICE_ENTRYAdapter();
      }
      @Override
      public Adapter caseChoiceType(ChoiceType object)
      {
        return createChoiceTypeAdapter();
      }
      @Override
      public Adapter caseMacroValue(MacroValue object)
      {
        return createMacroValueAdapter();
      }
      @Override
      public Adapter caseASN1_OCTET_STRING(ASN1_OCTET_STRING object)
      {
        return createASN1_OCTET_STRINGAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.Module
   * @generated
   */
  public Adapter createModuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.Imports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.Imports
   * @generated
   */
  public Adapter createImportsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ImportClosure <em>Import Closure</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ImportClosure
   * @generated
   */
  public Adapter createImportClosureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ImportRefs <em>Import Refs</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ImportRefs
   * @generated
   */
  public Adapter createImportRefsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ImportRef <em>Import Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ImportRef
   * @generated
   */
  public Adapter createImportRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ObjectReferenceable <em>Object Referenceable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ObjectReferenceable
   * @generated
   */
  public Adapter createObjectReferenceableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.Object <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.Object
   * @generated
   */
  public Adapter createObjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ObjectReference <em>Object Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ObjectReference
   * @generated
   */
  public Adapter createObjectReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.Attribute
   * @generated
   */
  public Adapter createAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.AttributeValue <em>Attribute Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.AttributeValue
   * @generated
   */
  public Adapter createAttributeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.Identifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.Identifier
   * @generated
   */
  public Adapter createIdentifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.BracedObjectReference <em>Braced Object Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.BracedObjectReference
   * @generated
   */
  public Adapter createBracedObjectReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.Referenceable <em>Referenceable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.Referenceable
   * @generated
   */
  public Adapter createReferenceableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.TypeNotation <em>Type Notation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.TypeNotation
   * @generated
   */
  public Adapter createTypeNotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ValueNotation <em>Value Notation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ValueNotation
   * @generated
   */
  public Adapter createValueNotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.TypeAssignment <em>Type Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.TypeAssignment
   * @generated
   */
  public Adapter createTypeAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.TypeNotationRight <em>Type Notation Right</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.TypeNotationRight
   * @generated
   */
  public Adapter createTypeNotationRightAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ValueAssignment <em>Value Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ValueAssignment
   * @generated
   */
  public Adapter createValueAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.Value
   * @generated
   */
  public Adapter createValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.Tag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.Tag
   * @generated
   */
  public Adapter createTagAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ValueType <em>Value Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ValueType
   * @generated
   */
  public Adapter createValueTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.MacroValueType <em>Macro Value Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.MacroValueType
   * @generated
   */
  public Adapter createMacroValueTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ASN1_TYPE <em>ASN1 TYPE</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ASN1_TYPE
   * @generated
   */
  public Adapter createASN1_TYPEAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ASN1_SIMPLE <em>ASN1 SIMPLE</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ASN1_SIMPLE
   * @generated
   */
  public Adapter createASN1_SIMPLEAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ASN1_INTEGER_REFINEMENT <em>ASN1 INTEGER REFINEMENT</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ASN1_INTEGER_REFINEMENT
   * @generated
   */
  public Adapter createASN1_INTEGER_REFINEMENTAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ASN1_RANGE <em>ASN1 RANGE</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ASN1_RANGE
   * @generated
   */
  public Adapter createASN1_RANGEAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ASN1_CHOICE <em>ASN1 CHOICE</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ASN1_CHOICE
   * @generated
   */
  public Adapter createASN1_CHOICEAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ASN1_SEQUENCE <em>ASN1 SEQUENCE</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ASN1_SEQUENCE
   * @generated
   */
  public Adapter createASN1_SEQUENCEAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ASN1_SEQUENCE_OF <em>ASN1 SEQUENCE OF</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ASN1_SEQUENCE_OF
   * @generated
   */
  public Adapter createASN1_SEQUENCE_OFAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ASN1_CHOICE_ENTRY <em>ASN1 CHOICE ENTRY</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ASN1_CHOICE_ENTRY
   * @generated
   */
  public Adapter createASN1_CHOICE_ENTRYAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ChoiceType <em>Choice Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ChoiceType
   * @generated
   */
  public Adapter createChoiceTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.MacroValue <em>Macro Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.MacroValue
   * @generated
   */
  public Adapter createMacroValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ASN1_OCTET_STRING <em>ASN1 OCTET STRING</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ASN1_OCTET_STRING
   * @generated
   */
  public Adapter createASN1_OCTET_STRINGAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //SmiAdapterFactory
