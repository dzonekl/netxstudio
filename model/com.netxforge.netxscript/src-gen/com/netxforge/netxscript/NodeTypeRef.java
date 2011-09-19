/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import com.netxforge.netxstudio.library.NodeType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Type Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.NodeTypeRef#getNodetype <em>Nodetype</em>}</li>
 *   <li>{@link com.netxforge.netxscript.NodeTypeRef#getPrimaryRef <em>Primary Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getNodeTypeRef()
 * @model
 * @generated
 */
public interface NodeTypeRef extends Reference
{
  /**
   * Returns the value of the '<em><b>Nodetype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nodetype</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nodetype</em>' reference.
   * @see #setNodetype(NodeType)
   * @see com.netxforge.netxscript.NetxscriptPackage#getNodeTypeRef_Nodetype()
   * @model
   * @generated
   */
  NodeType getNodetype();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.NodeTypeRef#getNodetype <em>Nodetype</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Nodetype</em>' reference.
   * @see #getNodetype()
   * @generated
   */
  void setNodetype(NodeType value);

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
   * @see com.netxforge.netxscript.NetxscriptPackage#getNodeTypeRef_PrimaryRef()
   * @model containment="true"
   * @generated
   */
  Reference getPrimaryRef();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.NodeTypeRef#getPrimaryRef <em>Primary Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Primary Ref</em>' containment reference.
   * @see #getPrimaryRef()
   * @generated
   */
  void setPrimaryRef(Reference value);

} // NodeTypeRef
