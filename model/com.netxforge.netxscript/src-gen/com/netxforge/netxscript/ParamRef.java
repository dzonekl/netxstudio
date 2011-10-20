/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import com.netxforge.netxstudio.library.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Param Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.ParamRef#getParam <em>Param</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getParamRef()
 * @model
 * @generated
 */
public interface ParamRef extends Reference
{
  /**
   * Returns the value of the '<em><b>Param</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param</em>' reference.
   * @see #setParam(Parameter)
   * @see com.netxforge.netxscript.NetxscriptPackage#getParamRef_Param()
   * @model
   * @generated
   */
  Parameter getParam();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.ParamRef#getParam <em>Param</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Param</em>' reference.
   * @see #getParam()
   * @generated
   */
  void setParam(Parameter value);

} // ParamRef
