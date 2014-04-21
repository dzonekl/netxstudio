/**
 */
package com.netxforge.smi;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Macro Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.MacroValue#getValueType <em>Value Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getMacroValue()
 * @model
 * @generated
 */
public interface MacroValue extends Value
{
  /**
   * Returns the value of the '<em><b>Value Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Type</em>' containment reference.
   * @see #setValueType(MacroValueType)
   * @see com.netxforge.smi.SmiPackage#getMacroValue_ValueType()
   * @model containment="true"
   * @generated
   */
  MacroValueType getValueType();

  /**
   * Sets the value of the '{@link com.netxforge.smi.MacroValue#getValueType <em>Value Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value Type</em>' containment reference.
   * @see #getValueType()
   * @generated
   */
  void setValueType(MacroValueType value);

} // MacroValue
