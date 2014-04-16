/**
 */
package com.netxforge.smi.util;

import com.netxforge.smi.*;

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
      public Adapter caseObjectIdentifier(ObjectIdentifier object)
      {
        return createObjectIdentifierAdapter();
      }
      @Override
      public Adapter caseObjectIdentifierValue(ObjectIdentifierValue object)
      {
        return createObjectIdentifierValueAdapter();
      }
      @Override
      public Adapter caseTypeDefinition(TypeDefinition object)
      {
        return createTypeDefinitionAdapter();
      }
      @Override
      public Adapter caseMacro(Macro object)
      {
        return createMacroAdapter();
      }
      @Override
      public Adapter caseTypeAssignment(TypeAssignment object)
      {
        return createTypeAssignmentAdapter();
      }
      @Override
      public Adapter caseParamAssignment(ParamAssignment object)
      {
        return createParamAssignmentAdapter();
      }
      @Override
      public Adapter caseTypeNotation(TypeNotation object)
      {
        return createTypeNotationAdapter();
      }
      @Override
      public Adapter caseValue(Value object)
      {
        return createValueAdapter();
      }
      @Override
      public Adapter caseValueType(ValueType object)
      {
        return createValueTypeAdapter();
      }
      @Override
      public Adapter caseMACRO_VALUE_TYPE(MACRO_VALUE_TYPE object)
      {
        return createMACRO_VALUE_TYPEAdapter();
      }
      @Override
      public Adapter caseUpdateType(UpdateType object)
      {
        return createUpdateTypeAdapter();
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
      public Adapter caseASN1_CHOICE_ENTRY(ASN1_CHOICE_ENTRY object)
      {
        return createASN1_CHOICE_ENTRYAdapter();
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
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ObjectIdentifier <em>Object Identifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ObjectIdentifier
   * @generated
   */
  public Adapter createObjectIdentifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ObjectIdentifierValue <em>Object Identifier Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ObjectIdentifierValue
   * @generated
   */
  public Adapter createObjectIdentifierValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.TypeDefinition <em>Type Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.TypeDefinition
   * @generated
   */
  public Adapter createTypeDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.Macro <em>Macro</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.Macro
   * @generated
   */
  public Adapter createMacroAdapter()
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
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.ParamAssignment <em>Param Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.ParamAssignment
   * @generated
   */
  public Adapter createParamAssignmentAdapter()
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
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.MACRO_VALUE_TYPE <em>MACRO VALUE TYPE</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.MACRO_VALUE_TYPE
   * @generated
   */
  public Adapter createMACRO_VALUE_TYPEAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.smi.UpdateType <em>Update Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.smi.UpdateType
   * @generated
   */
  public Adapter createUpdateTypeAdapter()
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
