/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ref Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.RefAssignment#getAssignmentRef <em>Assignment Ref</em>}</li>
 *   <li>{@link com.netxforge.netxscript.RefAssignment#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getRefAssignment()
 * @model
 * @generated
 */
public interface RefAssignment extends Statement
{
  /**
   * Returns the value of the '<em><b>Assignment Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assignment Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assignment Ref</em>' containment reference.
   * @see #setAssignmentRef(Reference)
   * @see com.netxforge.netxscript.NetxscriptPackage#getRefAssignment_AssignmentRef()
   * @model containment="true"
   * @generated
   */
  Reference getAssignmentRef();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.RefAssignment#getAssignmentRef <em>Assignment Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assignment Ref</em>' containment reference.
   * @see #getAssignmentRef()
   * @generated
   */
  void setAssignmentRef(Reference value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(Expression)
   * @see com.netxforge.netxscript.NetxscriptPackage#getRefAssignment_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.RefAssignment#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

} // RefAssignment
