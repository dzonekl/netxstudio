/**
 */
package com.netxforge.smi.util;

import com.netxforge.smi.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

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
      case SmiPackage.IMPORTS:
      {
        Imports imports = (Imports)theEObject;
        T result = caseImports(imports);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.IMPORT_CLOSURE:
      {
        ImportClosure importClosure = (ImportClosure)theEObject;
        T result = caseImportClosure(importClosure);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.IMPORT_REFS:
      {
        ImportRefs importRefs = (ImportRefs)theEObject;
        T result = caseImportRefs(importRefs);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.IMPORT_REF:
      {
        ImportRef importRef = (ImportRef)theEObject;
        T result = caseImportRef(importRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.REFERENCEABLE:
      {
        Referenceable referenceable = (Referenceable)theEObject;
        T result = caseReferenceable(referenceable);
        if (result == null) result = caseTypeAssignment(referenceable);
        if (result == null) result = caseTypeNotationRight(referenceable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.OBJECT_REFERENCEABLE:
      {
        ObjectReferenceable objectReferenceable = (ObjectReferenceable)theEObject;
        T result = caseObjectReferenceable(objectReferenceable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.OBJECT_IDENTIFIER_VALUE:
      {
        ObjectIdentifierValue objectIdentifierValue = (ObjectIdentifierValue)theEObject;
        T result = caseObjectIdentifierValue(objectIdentifierValue);
        if (result == null) result = caseObjectValue(objectIdentifierValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.ATTRIBUTE:
      {
        Attribute attribute = (Attribute)theEObject;
        T result = caseAttribute(attribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.ATTRIBUTE_VALUE:
      {
        AttributeValue attributeValue = (AttributeValue)theEObject;
        T result = caseAttributeValue(attributeValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.IDENTIFIER:
      {
        Identifier identifier = (Identifier)theEObject;
        T result = caseIdentifier(identifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.BRACED_OBJECT_REFERENCE:
      {
        BracedObjectReference bracedObjectReference = (BracedObjectReference)theEObject;
        T result = caseBracedObjectReference(bracedObjectReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.OBJECT_VALUE:
      {
        ObjectValue objectValue = (ObjectValue)theEObject;
        T result = caseObjectValue(objectValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.TYPE_NOTATION:
      {
        TypeNotation typeNotation = (TypeNotation)theEObject;
        T result = caseTypeNotation(typeNotation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.VALUE_NOTATION:
      {
        ValueNotation valueNotation = (ValueNotation)theEObject;
        T result = caseValueNotation(valueNotation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.TYPE_ASSIGNMENT:
      {
        TypeAssignment typeAssignment = (TypeAssignment)theEObject;
        T result = caseTypeAssignment(typeAssignment);
        if (result == null) result = caseTypeNotationRight(typeAssignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.TYPE_NOTATION_RIGHT:
      {
        TypeNotationRight typeNotationRight = (TypeNotationRight)theEObject;
        T result = caseTypeNotationRight(typeNotationRight);
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
      case SmiPackage.VALUE:
      {
        Value value = (Value)theEObject;
        T result = caseValue(value);
        if (result == null) result = caseTypeAssignment(value);
        if (result == null) result = caseTypeNotationRight(value);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.TAG:
      {
        Tag tag = (Tag)theEObject;
        T result = caseTag(tag);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.VALUE_TYPE:
      {
        ValueType valueType = (ValueType)theEObject;
        T result = caseValueType(valueType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.MACRO_VALUE_TYPE:
      {
        MacroValueType macroValueType = (MacroValueType)theEObject;
        T result = caseMacroValueType(macroValueType);
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
      case SmiPackage.ASN1_INTEGER_REFINEMENT:
      {
        ASN1_INTEGER_REFINEMENT asn1_INTEGER_REFINEMENT = (ASN1_INTEGER_REFINEMENT)theEObject;
        T result = caseASN1_INTEGER_REFINEMENT(asn1_INTEGER_REFINEMENT);
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
      case SmiPackage.ASN1_CHOICE:
      {
        ASN1_CHOICE asn1_CHOICE = (ASN1_CHOICE)theEObject;
        T result = caseASN1_CHOICE(asn1_CHOICE);
        if (result == null) result = caseASN1_TYPE(asn1_CHOICE);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.ASN1_SEQUENCE:
      {
        ASN1_SEQUENCE asn1_SEQUENCE = (ASN1_SEQUENCE)theEObject;
        T result = caseASN1_SEQUENCE(asn1_SEQUENCE);
        if (result == null) result = caseASN1_TYPE(asn1_SEQUENCE);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.ASN1_SEQUENCE_OF:
      {
        ASN1_SEQUENCE_OF asn1_SEQUENCE_OF = (ASN1_SEQUENCE_OF)theEObject;
        T result = caseASN1_SEQUENCE_OF(asn1_SEQUENCE_OF);
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
      case SmiPackage.CHOICE_TYPE:
      {
        ChoiceType choiceType = (ChoiceType)theEObject;
        T result = caseChoiceType(choiceType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SmiPackage.MACRO_VALUE:
      {
        MacroValue macroValue = (MacroValue)theEObject;
        T result = caseMacroValue(macroValue);
        if (result == null) result = caseValue(macroValue);
        if (result == null) result = caseTypeAssignment(macroValue);
        if (result == null) result = caseTypeNotationRight(macroValue);
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
   * Returns the result of interpreting the object as an instance of '<em>Imports</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Imports</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImports(Imports object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import Closure</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import Closure</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImportClosure(ImportClosure object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import Refs</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import Refs</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImportRefs(ImportRefs object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImportRef(ImportRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Referenceable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Referenceable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReferenceable(Referenceable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object Referenceable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object Referenceable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectReferenceable(ObjectReferenceable object)
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
   * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttribute(Attribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeValue(AttributeValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIdentifier(Identifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Braced Object Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Braced Object Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBracedObjectReference(BracedObjectReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectValue(ObjectValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Notation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Notation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeNotation(TypeNotation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Notation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Notation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueNotation(ValueNotation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeAssignment(TypeAssignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Notation Right</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Notation Right</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeNotationRight(TypeNotationRight object)
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
   * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValue(Value object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tag</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tag</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTag(Tag object)
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
   * Returns the result of interpreting the object as an instance of '<em>Macro Value Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Macro Value Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMacroValueType(MacroValueType object)
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
   * Returns the result of interpreting the object as an instance of '<em>ASN1 INTEGER REFINEMENT</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASN1 INTEGER REFINEMENT</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASN1_INTEGER_REFINEMENT(ASN1_INTEGER_REFINEMENT object)
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
   * Returns the result of interpreting the object as an instance of '<em>ASN1 SEQUENCE</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASN1 SEQUENCE</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASN1_SEQUENCE(ASN1_SEQUENCE object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ASN1 SEQUENCE OF</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASN1 SEQUENCE OF</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASN1_SEQUENCE_OF(ASN1_SEQUENCE_OF object)
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
   * Returns the result of interpreting the object as an instance of '<em>Choice Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Choice Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseChoiceType(ChoiceType object)
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
