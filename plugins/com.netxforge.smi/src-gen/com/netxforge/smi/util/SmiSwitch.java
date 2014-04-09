/**
 */
package com.netxforge.smi.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import com.netxforge.smi.ASN1_CHOICE;
import com.netxforge.smi.ASN1_CHOICE_ENTRY;
import com.netxforge.smi.ASN1_OCTET_STRING;
import com.netxforge.smi.ASN1_RANGE;
import com.netxforge.smi.ASN1_SIMPLE;
import com.netxforge.smi.ASN1_SUBTYPE;
import com.netxforge.smi.ASN1_TYPE;
import com.netxforge.smi.Assignment;
import com.netxforge.smi.Macro;
import com.netxforge.smi.MacroValue;
import com.netxforge.smi.Module;
import com.netxforge.smi.ObjectIdentifier;
import com.netxforge.smi.ObjectIdentifierValue;
import com.netxforge.smi.Or;
import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.ValueAssignment;
import com.netxforge.smi.ValueType;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.netxforge.smi.SmiPackage
 * @generated
 */
public class SmiSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SmiPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SmiSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = SmiPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case SmiPackage.MODULE:
      {
        Module module = (Module)theEObject;
        T result = caseModule(module);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.ASSIGNMENT:
      {
        Assignment assignment = (Assignment)theEObject;
        T result = caseAssignment(assignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.MACRO:
      {
        Macro macro = (Macro)theEObject;
        T result = caseMacro(macro);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.MACRO_VALUE:
      {
        MacroValue macroValue = (MacroValue)theEObject;
        T result = caseMacroValue(macroValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.VALUE_ASSIGNMENT:
      {
        ValueAssignment valueAssignment = (ValueAssignment)theEObject;
        T result = caseValueAssignment(valueAssignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.OR:
      {
        Or or = (Or)theEObject;
        T result = caseOr(or);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.VALUE_TYPE:
      {
        ValueType valueType = (ValueType)theEObject;
        T result = caseValueType(valueType);
        if (result == null) result = caseOr(valueType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.ASN1_TYPE:
      {
        ASN1_TYPE asn1_TYPE = (ASN1_TYPE)theEObject;
        T result = caseASN1_TYPE(asn1_TYPE);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.ASN1_SIMPLE:
      {
        ASN1_SIMPLE asn1_SIMPLE = (ASN1_SIMPLE)theEObject;
        T result = caseASN1_SIMPLE(asn1_SIMPLE);
        if (result == null) result = caseASN1_TYPE(asn1_SIMPLE);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.ASN1_CHOICE:
      {
        ASN1_CHOICE asn1_CHOICE = (ASN1_CHOICE)theEObject;
        T result = caseASN1_CHOICE(asn1_CHOICE);
        if (result == null) result = caseASN1_TYPE(asn1_CHOICE);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.ASN1_CHOICE_ENTRY:
      {
        ASN1_CHOICE_ENTRY asn1_CHOICE_ENTRY = (ASN1_CHOICE_ENTRY)theEObject;
        T result = caseASN1_CHOICE_ENTRY(asn1_CHOICE_ENTRY);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.ASN1_SUBTYPE:
      {
        ASN1_SUBTYPE asn1_SUBTYPE = (ASN1_SUBTYPE)theEObject;
        T result = caseASN1_SUBTYPE(asn1_SUBTYPE);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.ASN1_RANGE:
      {
        ASN1_RANGE asn1_RANGE = (ASN1_RANGE)theEObject;
        T result = caseASN1_RANGE(asn1_RANGE);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.OBJECT_IDENTIFIER:
      {
        ObjectIdentifier objectIdentifier = (ObjectIdentifier)theEObject;
        T result = caseObjectIdentifier(objectIdentifier);
        if (result == null) result = caseAssignment(objectIdentifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.OBJECT_IDENTIFIER_VALUE:
      {
        ObjectIdentifierValue objectIdentifierValue = (ObjectIdentifierValue)theEObject;
        T result = caseObjectIdentifierValue(objectIdentifierValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.ASN1_OCTET_STRING:
      {
        ASN1_OCTET_STRING asn1_OCTET_STRING = (ASN1_OCTET_STRING)theEObject;
        T result = caseASN1_OCTET_STRING(asn1_OCTET_STRING);
        if (result == null) result = caseASN1_SIMPLE(asn1_OCTET_STRING);
        if (result == null) result = caseASN1_TYPE(asn1_OCTET_STRING);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModule(Module object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignment(Assignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Macro</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Macro</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMacro(Macro object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Macro Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Macro Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMacroValue(MacroValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueAssignment(ValueAssignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Or</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOr(Or object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueType(ValueType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ASN1 TYPE</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASN1 TYPE</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASN1_TYPE(ASN1_TYPE object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ASN1 SIMPLE</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASN1 SIMPLE</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASN1_SIMPLE(ASN1_SIMPLE object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ASN1 CHOICE</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASN1 CHOICE</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASN1_CHOICE(ASN1_CHOICE object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ASN1 CHOICE ENTRY</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASN1 CHOICE ENTRY</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASN1_CHOICE_ENTRY(ASN1_CHOICE_ENTRY object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ASN1 SUBTYPE</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASN1 SUBTYPE</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASN1_SUBTYPE(ASN1_SUBTYPE object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ASN1 RANGE</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASN1 RANGE</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASN1_RANGE(ASN1_RANGE object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object Identifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object Identifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectIdentifier(ObjectIdentifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object Identifier Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object Identifier Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectIdentifierValue(ObjectIdentifierValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ASN1 OCTET STRING</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASN1 OCTET STRING</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASN1_OCTET_STRING(ASN1_OCTET_STRING object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //SmiSwitch
