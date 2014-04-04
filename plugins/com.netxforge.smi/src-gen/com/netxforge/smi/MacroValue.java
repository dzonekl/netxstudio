/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Macro Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.MacroValue#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getMacroValue()
 * @model
 * @generated
 */
public interface MacroValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link com.netxforge.smi.MACRO_VALUE_TYPE}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see com.netxforge.smi.MACRO_VALUE_TYPE
   * @see #setType(MACRO_VALUE_TYPE)
   * @see com.netxforge.smi.SmiPackage#getMacroValue_Type()
   * @model
   * @generated
   */
  MACRO_VALUE_TYPE getType();

  /**
   * Sets the value of the '{@link com.netxforge.smi.MacroValue#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see com.netxforge.smi.MACRO_VALUE_TYPE
   * @see #getType()
   * @generated
   */
  void setType(MACRO_VALUE_TYPE value);

} // MacroValue
