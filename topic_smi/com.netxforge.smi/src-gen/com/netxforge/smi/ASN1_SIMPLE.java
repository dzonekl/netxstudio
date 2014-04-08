/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.smi;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ASN1 SIMPLE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ASN1_SIMPLE#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.netxforge.smi.ASN1_SIMPLE#getValuePairs <em>Value Pairs</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getASN1_SIMPLE()
 * @model
 * @generated
 */
public interface ASN1_SIMPLE extends ASN1_TYPE
{
  /**
   * Returns the value of the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraint</em>' containment reference.
   * @see #setConstraint(ASN1_SUBTYPE)
   * @see com.netxforge.smi.SmiPackage#getASN1_SIMPLE_Constraint()
   * @model containment="true"
   * @generated
   */
  ASN1_SUBTYPE getConstraint();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ASN1_SIMPLE#getConstraint <em>Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraint</em>' containment reference.
   * @see #getConstraint()
   * @generated
   */
  void setConstraint(ASN1_SUBTYPE value);

  /**
   * Returns the value of the '<em><b>Value Pairs</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value Pairs</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Pairs</em>' attribute list.
   * @see com.netxforge.smi.SmiPackage#getASN1_SIMPLE_ValuePairs()
   * @model unique="false"
   * @generated
   */
  EList<String> getValuePairs();

} // ASN1_SIMPLE
