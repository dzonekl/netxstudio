/**
 */
package com.netxforge.smi;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.Value#getValueTypes <em>Value Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getValue()
 * @model
 * @generated
 */
public interface Value extends TypeAssignment
{
  /**
   * Returns the value of the '<em><b>Value Types</b></em>' containment reference list.
   * The list contents are of type {@link com.netxforge.smi.ValueType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Types</em>' containment reference list.
   * @see com.netxforge.smi.SmiPackage#getValue_ValueTypes()
   * @model containment="true"
   * @generated
   */
  EList<ValueType> getValueTypes();

} // Value
