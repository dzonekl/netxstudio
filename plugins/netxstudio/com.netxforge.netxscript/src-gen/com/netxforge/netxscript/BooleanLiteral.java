/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.BooleanLiteral#isCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getBooleanLiteral()
 * @model
 * @generated
 */
public interface BooleanLiteral extends Expression
{
  /**
   * Returns the value of the '<em><b>Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' attribute.
   * @see #setCondition(boolean)
   * @see com.netxforge.netxscript.NetxscriptPackage#getBooleanLiteral_Condition()
   * @model
   * @generated
   */
  boolean isCondition();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.BooleanLiteral#isCondition <em>Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' attribute.
   * @see #isCondition()
   * @generated
   */
  void setCondition(boolean value);

} // BooleanLiteral
