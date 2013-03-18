/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ValueAssignment#getTypeReference <em>Type Reference</em>}</li>
 *   <li>{@link com.netxforge.smi.ValueAssignment#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getValueAssignment()
 * @model
 * @generated
 */
public interface ValueAssignment extends EObject
{
  /**
   * Returns the value of the '<em><b>Type Reference</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Reference</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Reference</em>' attribute.
   * @see #setTypeReference(String)
   * @see com.netxforge.smi.SmiPackage#getValueAssignment_TypeReference()
   * @model
   * @generated
   */
  String getTypeReference();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ValueAssignment#getTypeReference <em>Type Reference</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Reference</em>' attribute.
   * @see #getTypeReference()
   * @generated
   */
  void setTypeReference(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Or)
   * @see com.netxforge.smi.SmiPackage#getValueAssignment_Value()
   * @model containment="true"
   * @generated
   */
  Or getValue();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ValueAssignment#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Or value);

} // ValueAssignment
