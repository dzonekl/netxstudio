/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import java.math.BigDecimal;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.RangeLiteral#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getRangeLiteral()
 * @model
 * @generated
 */
public interface RangeLiteral extends Expression
{
  /**
   * Returns the value of the '<em><b>Values</b></em>' attribute list.
   * The list contents are of type {@link java.math.BigDecimal}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' attribute list.
   * @see com.netxforge.netxscript.NetxscriptPackage#getRangeLiteral_Values()
   * @model unique="false"
   * @generated
   */
  EList<BigDecimal> getValues();

} // RangeLiteral
