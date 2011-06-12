/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.If#getIf <em>If</em>}</li>
 *   <li>{@link com.netxforge.netxscript.If#getThen <em>Then</em>}</li>
 *   <li>{@link com.netxforge.netxscript.If#getElse <em>Else</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getIf()
 * @model
 * @generated
 */
public interface If extends Statement
{
  /**
   * Returns the value of the '<em><b>If</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>If</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>If</em>' containment reference.
   * @see #setIf(Expression)
   * @see com.netxforge.netxscript.NetxscriptPackage#getIf_If()
   * @model containment="true"
   * @generated
   */
  Expression getIf();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.If#getIf <em>If</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>If</em>' containment reference.
   * @see #getIf()
   * @generated
   */
  void setIf(Expression value);

  /**
   * Returns the value of the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then</em>' containment reference.
   * @see #setThen(Block)
   * @see com.netxforge.netxscript.NetxscriptPackage#getIf_Then()
   * @model containment="true"
   * @generated
   */
  Block getThen();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.If#getThen <em>Then</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then</em>' containment reference.
   * @see #getThen()
   * @generated
   */
  void setThen(Block value);

  /**
   * Returns the value of the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else</em>' containment reference.
   * @see #setElse(Block)
   * @see com.netxforge.netxscript.NetxscriptPackage#getIf_Else()
   * @model containment="true"
   * @generated
   */
  Block getElse();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.If#getElse <em>Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else</em>' containment reference.
   * @see #getElse()
   * @generated
   */
  void setElse(Block value);

} // If
