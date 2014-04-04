/**
 * <copyright>
 * </copyright>
 *
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
   * Returns a new object of class '<em>Assignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment</em>'.
   * @generated
   */
  Assignment createAssignment();

  /**
   * Returns a new object of class '<em>Macro</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Macro</em>'.
   * @generated
   */
  Macro createMacro();

  /**
   * Returns a new object of class '<em>Macro Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Macro Value</em>'.
   * @generated
   */
  MacroValue createMacroValue();

  /**
   * Returns a new object of class '<em>Value Assignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Assignment</em>'.
   * @generated
   */
  ValueAssignment createValueAssignment();

  /**
   * Returns a new object of class '<em>Or</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or</em>'.
   * @generated
   */
  Or createOr();

  /**
   * Returns a new object of class '<em>Value Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Type</em>'.
   * @generated
   */
  ValueType createValueType();

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
   * Returns a new object of class '<em>ASN1 CHOICE</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ASN1 CHOICE</em>'.
   * @generated
   */
  ASN1_CHOICE createASN1_CHOICE();

  /**
   * Returns a new object of class '<em>ASN1 CHOICE ENTRY</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ASN1 CHOICE ENTRY</em>'.
   * @generated
   */
  ASN1_CHOICE_ENTRY createASN1_CHOICE_ENTRY();

  /**
   * Returns a new object of class '<em>ASN1 SUBTYPE</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ASN1 SUBTYPE</em>'.
   * @generated
   */
  ASN1_SUBTYPE createASN1_SUBTYPE();

  /**
   * Returns a new object of class '<em>ASN1 RANGE</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ASN1 RANGE</em>'.
   * @generated
   */
  ASN1_RANGE createASN1_RANGE();

  /**
   * Returns a new object of class '<em>Object Identifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object Identifier</em>'.
   * @generated
   */
  ObjectIdentifier createObjectIdentifier();

  /**
   * Returns a new object of class '<em>Object Identifier Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object Identifier Value</em>'.
   * @generated
   */
  ObjectIdentifierValue createObjectIdentifierValue();

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
