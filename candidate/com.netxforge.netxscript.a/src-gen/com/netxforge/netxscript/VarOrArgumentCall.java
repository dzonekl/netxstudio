/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Or Argument Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.VarOrArgumentCall#getCall <em>Call</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getVarOrArgumentCall()
 * @model
 * @generated
 */
public interface VarOrArgumentCall extends Expression
{
  /**
   * Returns the value of the '<em><b>Call</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Call</em>' reference.
   * @see #setCall(AbstractVarOrArgument)
   * @see com.netxforge.netxscript.NetxscriptPackage#getVarOrArgumentCall_Call()
   * @model
   * @generated
   */
  AbstractVarOrArgument getCall();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.VarOrArgumentCall#getCall <em>Call</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Call</em>' reference.
   * @see #getCall()
   * @generated
   */
  void setCall(AbstractVarOrArgument value);

} // VarOrArgumentCall
