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
 *   <li>{@link com.netxforge.smi.Value#getTag <em>Tag</em>}</li>
 *   <li>{@link com.netxforge.smi.Value#isImplicit <em>Implicit</em>}</li>
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
   * Returns the value of the '<em><b>Tag</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tag</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tag</em>' containment reference.
   * @see #setTag(Tag)
   * @see com.netxforge.smi.SmiPackage#getValue_Tag()
   * @model containment="true"
   * @generated
   */
  Tag getTag();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Value#getTag <em>Tag</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tag</em>' containment reference.
   * @see #getTag()
   * @generated
   */
  void setTag(Tag value);

  /**
   * Returns the value of the '<em><b>Implicit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Implicit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Implicit</em>' attribute.
   * @see #setImplicit(boolean)
   * @see com.netxforge.smi.SmiPackage#getValue_Implicit()
   * @model
   * @generated
   */
  boolean isImplicit();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Value#isImplicit <em>Implicit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Implicit</em>' attribute.
   * @see #isImplicit()
   * @generated
   */
  void setImplicit(boolean value);

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
