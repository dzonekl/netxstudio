/**
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
 *   <li>{@link com.netxforge.smi.ValueAssignment#getValueNotation <em>Value Notation</em>}</li>
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
   * Returns the value of the '<em><b>Value Notation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value Notation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Notation</em>' containment reference.
   * @see #setValueNotation(Value)
   * @see com.netxforge.smi.SmiPackage#getValueAssignment_ValueNotation()
   * @model containment="true"
   * @generated
   */
  Value getValueNotation();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ValueAssignment#getValueNotation <em>Value Notation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value Notation</em>' containment reference.
   * @see #getValueNotation()
   * @generated
   */
  void setValueNotation(Value value);

} // ValueAssignment
