/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.PrimaryRef#getNavigation <em>Navigation</em>}</li>
 *   <li>{@link com.netxforge.netxscript.PrimaryRef#getLeafRef <em>Leaf Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getPrimaryRef()
 * @model
 * @generated
 */
public interface PrimaryRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Navigation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Navigation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Navigation</em>' containment reference.
   * @see #setNavigation(Navigation)
   * @see com.netxforge.netxscript.NetxscriptPackage#getPrimaryRef_Navigation()
   * @model containment="true"
   * @generated
   */
  Navigation getNavigation();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.PrimaryRef#getNavigation <em>Navigation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Navigation</em>' containment reference.
   * @see #getNavigation()
   * @generated
   */
  void setNavigation(Navigation value);

  /**
   * Returns the value of the '<em><b>Leaf Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Leaf Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Leaf Ref</em>' containment reference.
   * @see #setLeafRef(LeafReference)
   * @see com.netxforge.netxscript.NetxscriptPackage#getPrimaryRef_LeafRef()
   * @model containment="true"
   * @generated
   */
  LeafReference getLeafRef();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.PrimaryRef#getLeafRef <em>Leaf Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Leaf Ref</em>' containment reference.
   * @see #getLeafRef()
   * @generated
   */
  void setLeafRef(LeafReference value);

} // PrimaryRef
