/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import com.netxforge.netxstudio.library.BaseResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.ResourceRef#getResource <em>Resource</em>}</li>
 *   <li>{@link com.netxforge.netxscript.ResourceRef#isAll <em>All</em>}</li>
 *   <li>{@link com.netxforge.netxscript.ResourceRef#getRangeRef <em>Range Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getResourceRef()
 * @model
 * @generated
 */
public interface ResourceRef extends LeafReference
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
   * @see #setResource(BaseResource)
   * @see com.netxforge.netxscript.NetxscriptPackage#getResourceRef_Resource()
   * @model
   * @generated
   */
  BaseResource getResource();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.ResourceRef#getResource <em>Resource</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Resource</em>' reference.
   * @see #getResource()
   * @generated
   */
  void setResource(BaseResource value);

  /**
   * Returns the value of the '<em><b>All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>All</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>All</em>' attribute.
   * @see #setAll(boolean)
   * @see com.netxforge.netxscript.NetxscriptPackage#getResourceRef_All()
   * @model
   * @generated
   */
  boolean isAll();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.ResourceRef#isAll <em>All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>All</em>' attribute.
   * @see #isAll()
   * @generated
   */
  void setAll(boolean value);

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
   * @see com.netxforge.netxscript.NetxscriptPackage#getResourceRef_RangeRef()
   * @model containment="true"
   * @generated
   */
  RangeRef getRangeRef();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.ResourceRef#getRangeRef <em>Range Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Range Ref</em>' containment reference.
   * @see #getRangeRef()
   * @generated
   */
  void setRangeRef(RangeRef value);

} // ResourceRef
