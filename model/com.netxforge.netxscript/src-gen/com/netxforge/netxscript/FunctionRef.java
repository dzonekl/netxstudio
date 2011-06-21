/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import com.netxforge.netxstudio.library.Function;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.FunctionRef#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getFunctionRef()
 * @model
 * @generated
 */
public interface FunctionRef extends Reference
{
  /**
   * Returns the value of the '<em><b>Function</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function</em>' reference.
   * @see #setFunction(Function)
   * @see com.netxforge.netxscript.NetxscriptPackage#getFunctionRef_Function()
   * @model
   * @generated
   */
  Function getFunction();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.FunctionRef#getFunction <em>Function</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function</em>' reference.
   * @see #getFunction()
   * @generated
   */
  void setFunction(Function value);

} // FunctionRef
