/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ASN1 CHOICE ENTRY</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ASN1_CHOICE_ENTRY#getId <em>Id</em>}</li>
 *   <li>{@link com.netxforge.smi.ASN1_CHOICE_ENTRY#getValueType <em>Value Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getASN1_CHOICE_ENTRY()
 * @model
 * @generated
 */
public interface ASN1_CHOICE_ENTRY extends EObject
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see com.netxforge.smi.SmiPackage#getASN1_CHOICE_ENTRY_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ASN1_CHOICE_ENTRY#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Value Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Type</em>' reference.
   * @see #setValueType(ValueType)
   * @see com.netxforge.smi.SmiPackage#getASN1_CHOICE_ENTRY_ValueType()
   * @model
   * @generated
   */
  ValueType getValueType();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ASN1_CHOICE_ENTRY#getValueType <em>Value Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value Type</em>' reference.
   * @see #getValueType()
   * @generated
   */
  void setValueType(ValueType value);

} // ASN1_CHOICE_ENTRY
