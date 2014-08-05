/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.ContextRef#getPrimaryRef <em>Primary Ref</em>}</li>
 *   <li>{@link com.netxforge.netxscript.ContextRef#getRangeRef <em>Range Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getContextRef()
 * @model
 * @generated
 */
public interface ContextRef extends Reference
{
  /**
   * Returns the value of the '<em><b>Primary Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Primary Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primary Ref</em>' containment reference.
   * @see #setPrimaryRef(PrimaryRef)
   * @see com.netxforge.netxscript.NetxscriptPackage#getContextRef_PrimaryRef()
   * @model containment="true"
   * @generated
   */
  PrimaryRef getPrimaryRef();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.ContextRef#getPrimaryRef <em>Primary Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Primary Ref</em>' containment reference.
   * @see #getPrimaryRef()
   * @generated
   */
  void setPrimaryRef(PrimaryRef value);

  /**
   * Returns the value of the '<em><b>Range Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Range Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Range Ref</em>' containment reference.
   * @see #setRangeRef(RangeRef)
   * @see com.netxforge.netxscript.NetxscriptPackage#getContextRef_RangeRef()
   * @model containment="true"
   * @generated
   */
  RangeRef getRangeRef();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.ContextRef#getRangeRef <em>Range Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Range Ref</em>' containment reference.
   * @see #getRangeRef()
   * @generated
   */
  void setRangeRef(RangeRef value);

} // ContextRef
