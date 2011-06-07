/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import library.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.NodeRef#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getNodeRef()
 * @model
 * @generated
 */
public interface NodeRef extends Reference
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
   * @see #setNode(Node)
   * @see com.netxforge.netxscript.NetxscriptPackage#getNodeRef_Node()
   * @model
   * @generated
   */
  Node getNode();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.NodeRef#getNode <em>Node</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node</em>' reference.
   * @see #getNode()
   * @generated
   */
  void setNode(Node value);

} // NodeRef
