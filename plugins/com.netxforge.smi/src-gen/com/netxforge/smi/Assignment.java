/**
 */
package com.netxforge.smi;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.Assignment#getMacros <em>Macros</em>}</li>
 *   <li>{@link com.netxforge.smi.Assignment#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getAssignment()
 * @model
 * @generated
 */
public interface Assignment extends EObject
{
  /**
   * Returns the value of the '<em><b>Macros</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Macros</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Macros</em>' containment reference.
   * @see #setMacros(Macro)
   * @see com.netxforge.smi.SmiPackage#getAssignment_Macros()
   * @model containment="true"
   * @generated
   */
  Macro getMacros();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Assignment#getMacros <em>Macros</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Macros</em>' containment reference.
   * @see #getMacros()
   * @generated
   */
  void setMacros(Macro value);

  /**
   * Returns the value of the '<em><b>Types</b></em>' containment reference list.
   * The list contents are of type {@link com.netxforge.smi.ValueAssignment}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Types</em>' containment reference list.
   * @see com.netxforge.smi.SmiPackage#getAssignment_Types()
   * @model containment="true"
   * @generated
   */
  EList<ValueAssignment> getTypes();

} // Assignment
