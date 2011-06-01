/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import library.Node;
import library.Resource;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Node Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.PrimaryNodeRef#getDepth <em>Depth</em>}</li>
 *   <li>{@link com.netxforge.netxscript.PrimaryNodeRef#getResRef <em>Res Ref</em>}</li>
 *   <li>{@link com.netxforge.netxscript.PrimaryNodeRef#getNodeRef <em>Node Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getPrimaryNodeRef()
 * @model
 * @generated
 */
public interface PrimaryNodeRef extends NodeDepth
{
  /**
   * Returns the value of the '<em><b>Depth</b></em>' containment reference list.
   * The list contents are of type {@link com.netxforge.netxscript.PrimaryNodeRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Depth</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Depth</em>' containment reference list.
   * @see com.netxforge.netxscript.NetxscriptPackage#getPrimaryNodeRef_Depth()
   * @model containment="true"
   * @generated
   */
  EList<PrimaryNodeRef> getDepth();

  /**
   * Returns the value of the '<em><b>Res Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Res Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Res Ref</em>' reference.
   * @see #setResRef(Resource)
   * @see com.netxforge.netxscript.NetxscriptPackage#getPrimaryNodeRef_ResRef()
   * @model
   * @generated
   */
  Resource getResRef();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.PrimaryNodeRef#getResRef <em>Res Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Res Ref</em>' reference.
   * @see #getResRef()
   * @generated
   */
  void setResRef(Resource value);

  /**
   * Returns the value of the '<em><b>Node Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node Ref</em>' reference.
   * @see #setNodeRef(Node)
   * @see com.netxforge.netxscript.NetxscriptPackage#getPrimaryNodeRef_NodeRef()
   * @model
   * @generated
   */
  Node getNodeRef();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.PrimaryNodeRef#getNodeRef <em>Node Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node Ref</em>' reference.
   * @see #getNodeRef()
   * @generated
   */
  void setNodeRef(Node value);

} // PrimaryNodeRef
