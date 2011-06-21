/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.Reference#getNodes <em>Nodes</em>}</li>
 *   <li>{@link com.netxforge.netxscript.Reference#getLeaveRef <em>Leave Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends Expression
{
  /**
   * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
   * The list contents are of type {@link com.netxforge.netxscript.Reference}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nodes</em>' containment reference list.
   * @see com.netxforge.netxscript.NetxscriptPackage#getReference_Nodes()
   * @model containment="true"
   * @generated
   */
  EList<Reference> getNodes();

  /**
   * Returns the value of the '<em><b>Leave Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Leave Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Leave Ref</em>' containment reference.
   * @see #setLeaveRef(LeafReference)
   * @see com.netxforge.netxscript.NetxscriptPackage#getReference_LeaveRef()
   * @model containment="true"
   * @generated
   */
  LeafReference getLeaveRef();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.Reference#getLeaveRef <em>Leave Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Leave Ref</em>' containment reference.
   * @see #getLeaveRef()
   * @generated
   */
  void setLeaveRef(LeafReference value);

} // Reference
