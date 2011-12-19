/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.OperatorRef#getFunction <em>Function</em>}</li>
 *   <li>{@link com.netxforge.netxscript.OperatorRef#getEquipment <em>Equipment</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getOperatorRef()
 * @model
 * @generated
 */
public interface OperatorRef extends Reference
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
   * @see com.netxforge.netxscript.NetxscriptPackage#getOperatorRef_Function()
   * @model
   * @generated
   */
  Function getFunction();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.OperatorRef#getFunction <em>Function</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function</em>' reference.
   * @see #getFunction()
   * @generated
   */
  void setFunction(Function value);

  /**
   * Returns the value of the '<em><b>Equipment</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Equipment</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Equipment</em>' reference.
   * @see #setEquipment(Equipment)
   * @see com.netxforge.netxscript.NetxscriptPackage#getOperatorRef_Equipment()
   * @model
   * @generated
   */
  Equipment getEquipment();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.OperatorRef#getEquipment <em>Equipment</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Equipment</em>' reference.
   * @see #getEquipment()
   * @generated
   */
  void setEquipment(Equipment value);

} // OperatorRef
