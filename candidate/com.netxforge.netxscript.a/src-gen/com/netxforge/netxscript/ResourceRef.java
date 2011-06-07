/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import library.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.ResourceRef#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getResourceRef()
 * @model
 * @generated
 */
public interface ResourceRef extends Reference
{
  /**
   * Returns the value of the '<em><b>Resource</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Resource</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Resource</em>' reference.
   * @see #setResource(Resource)
   * @see com.netxforge.netxscript.NetxscriptPackage#getResourceRef_Resource()
   * @model
   * @generated
   */
  Resource getResource();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.ResourceRef#getResource <em>Resource</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Resource</em>' reference.
   * @see #getResource()
   * @generated
   */
  void setResource(Resource value);

} // ResourceRef
