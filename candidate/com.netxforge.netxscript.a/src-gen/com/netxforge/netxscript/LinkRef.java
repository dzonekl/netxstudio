/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import library.Link;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.LinkRef#getLink <em>Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getLinkRef()
 * @model
 * @generated
 */
public interface LinkRef extends Reference
{
  /**
   * Returns the value of the '<em><b>Link</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Link</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Link</em>' reference.
   * @see #setLink(Link)
   * @see com.netxforge.netxscript.NetxscriptPackage#getLinkRef_Link()
   * @model
   * @generated
   */
  Link getLink();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.LinkRef#getLink <em>Link</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Link</em>' reference.
   * @see #getLink()
   * @generated
   */
  void setLink(Link value);

} // LinkRef
