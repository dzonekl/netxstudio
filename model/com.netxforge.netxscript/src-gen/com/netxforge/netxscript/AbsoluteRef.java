/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import com.netxforge.netxstudio.library.NodeType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Absolute Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.AbsoluteRef#getNode <em>Node</em>}</li>
 *   <li>{@link com.netxforge.netxscript.AbsoluteRef#getPrimaryRef <em>Primary Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getAbsoluteRef()
 * @model
 * @generated
 */
public interface AbsoluteRef extends Reference
{
  /**
   * Returns the value of the '<em><b>Node</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node</em>' reference.
   * @see #setNode(NodeType)
   * @see com.netxforge.netxscript.NetxscriptPackage#getAbsoluteRef_Node()
   * @model
   * @generated
   */
  NodeType getNode();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.AbsoluteRef#getNode <em>Node</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node</em>' reference.
   * @see #getNode()
   * @generated
   */
  void setNode(NodeType value);

  /**
   * Returns the value of the '<em><b>Primary Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Primary Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primary Ref</em>' containment reference.
   * @see #setPrimaryRef(Reference)
   * @see com.netxforge.netxscript.NetxscriptPackage#getAbsoluteRef_PrimaryRef()
   * @model containment="true"
   * @generated
   */
  Reference getPrimaryRef();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.AbsoluteRef#getPrimaryRef <em>Primary Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Primary Ref</em>' containment reference.
   * @see #getPrimaryRef()
   * @generated
   */
  void setPrimaryRef(Reference value);

} // AbsoluteRef
