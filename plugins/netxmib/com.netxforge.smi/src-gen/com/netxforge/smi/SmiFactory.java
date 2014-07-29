/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.netxforge.smi.SmiPackage
 * @generated
 */
public interface SmiFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SmiFactory eINSTANCE = com.netxforge.smi.impl.SmiFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Module</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module</em>'.
   * @generated
   */
  Module createModule();

  /**
   * Returns a new object of class '<em>Imports</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Imports</em>'.
   * @generated
   */
  Imports createImports();

  /**
   * Returns a new object of class '<em>Import Closure</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import Closure</em>'.
   * @generated
   */
  ImportClosure createImportClosure();

  /**
   * Returns a new object of class '<em>Import Refs</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import Refs</em>'.
   * @generated
   */
  ImportRefs createImportRefs();

  /**
   * Returns a new object of class '<em>Import Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import Ref</em>'.
   * @generated
   */
  ImportRef createImportRef();

  /**
   * Returns a new object of class '<em>Object Referenceable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object Referenceable</em>'.
   * @generated
   */
  ObjectReferenceable createObjectReferenceable();

  /**
   * Returns a new object of class '<em>Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object</em>'.
   * @generated
   */
  Object createObject();

  /**
   * Returns a new object of class '<em>Object Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object Reference</em>'.
   * @generated
   */
  ObjectReference createObjectReference();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns a new object of class '<em>Attribute Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Value</em>'.
   * @generated
   */
  AttributeValue createAttributeValue();

  /**
   * Returns a new object of class '<em>Identifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Identifier</em>'.
   * @generated
   */
  Identifier createIdentifier();

  /**
   * Returns a new object of class '<em>Braced Object Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Braced Object Reference</em>'.
   * @generated
   */
  BracedObjectReference createBracedObjectReference();

  /**
   * Returns a new object of class '<em>Referenceable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Referenceable</em>'.
   * @generated
   */
  Referenceable createReferenceable();

  /**
   * Returns a new object of class '<em>Type Notation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Notation</em>'.
   * @generated
   */
  TypeNotation createTypeNotation();

  /**
   * Returns a new object of class '<em>Value Notation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Notation</em>'.
   * @generated
   */
  ValueNotation createValueNotation();

  /**
   * Returns a new object of class '<em>Type Assignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Assignment</em>'.
   * @generated
   */
  TypeAssignment createTypeAssignment();

  /**
   * Returns a new object of class '<em>Type Notation Right</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Notation Right</em>'.
   * @generated
   */
  TypeNotationRight createTypeNotationRight();

  /**
   * Returns a new object of class '<em>Value Assignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Assignment</em>'.
   * @generated
   */
  ValueAssignment createValueAssignment();

  /**
   * Returns a new object of class '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value</em>'.
   * @generated
   */
  Value createValue();

  /**
   * Returns a new object of class '<em>Tag</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tag</em>'.
   * @generated
   */
  Tag createTag();

  /**
   * Returns a new object of class '<em>Value Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Type</em>'.
   * @generated
   */
  ValueType createValueType();

  /**
   * Returns a new object of class '<em>Macro Value Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Macro Value Type</em>'.
   * @generated
   */
  MacroValueType createMacroValueType();

  /**
   * Returns a new object of class '<em>ASN1 TYPE</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ASN1 TYPE</em>'.
   * @generated
   */
  ASN1_TYPE createASN1_TYPE();

  /**
   * Returns a new object of class '<em>ASN1 SIMPLE</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ASN1 SIMPLE</em>'.
   * @generated
   */
  ASN1_SIMPLE createASN1_SIMPLE();

  /**
   * Returns a new object of class '<em>ASN1 INTEGER REFINEMENT</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ASN1 INTEGER REFINEMENT</em>'.
   * @generated
   */
  ASN1_INTEGER_REFINEMENT createASN1_INTEGER_REFINEMENT();

  /**
   * Returns a new object of class '<em>ASN1 RANGE</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ASN1 RANGE</em>'.
   * @generated
   */
  ASN1_RANGE createASN1_RANGE();

  /**
   * Returns a new object of class '<em>ASN1 CHOICE</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ASN1 CHOICE</em>'.
   * @generated
   */
  ASN1_CHOICE createASN1_CHOICE();

  /**
   * Returns a new object of class '<em>ASN1 SEQUENCE</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ASN1 SEQUENCE</em>'.
   * @generated
   */
  ASN1_SEQUENCE createASN1_SEQUENCE();

  /**
   * Returns a new object of class '<em>ASN1 SEQUENCE OF</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ASN1 SEQUENCE OF</em>'.
   * @generated
   */
  ASN1_SEQUENCE_OF createASN1_SEQUENCE_OF();

  /**
   * Returns a new object of class '<em>ASN1 CHOICE ENTRY</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ASN1 CHOICE ENTRY</em>'.
   * @generated
   */
  ASN1_CHOICE_ENTRY createASN1_CHOICE_ENTRY();

  /**
   * Returns a new object of class '<em>Choice Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Choice Type</em>'.
   * @generated
   */
  ChoiceType createChoiceType();

  /**
   * Returns a new object of class '<em>Macro Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Macro Value</em>'.
   * @generated
   */
  MacroValue createMacroValue();

  /**
   * Returns a new object of class '<em>ASN1 OCTET STRING</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ASN1 OCTET STRING</em>'.
   * @generated
   */
  ASN1_OCTET_STRING createASN1_OCTET_STRING();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  SmiPackage getSmiPackage();

} //SmiFactory
