/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.Block#getStatements <em>Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getBlock()
 * @model
 * @generated
 */
public interface Block extends Statement
{
  /**
   * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
   * The list contents are of type {@link com.netxforge.netxscript.Statement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statements</em>' containment reference list.
   * @see com.netxforge.netxscript.NetxscriptPackage#getBlock_Statements()
   * @model containment="true"
   * @generated
   */
  EList<Statement> getStatements();

} // Block
