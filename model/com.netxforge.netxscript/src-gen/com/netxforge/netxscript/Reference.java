/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.Reference#getComponent <em>Component</em>}</li>
 *   <li>{@link com.netxforge.netxscript.Reference#getLeafRef <em>Leaf Ref</em>}</li>
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
   * Returns the value of the '<em><b>Component</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Component</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component</em>' containment reference.
   * @see #setComponent(Reference)
   * @see com.netxforge.netxscript.NetxscriptPackage#getReference_Component()
   * @model containment="true"
   * @generated
   */
  Reference getComponent();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.Reference#getComponent <em>Component</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Component</em>' containment reference.
   * @see #getComponent()
   * @generated
   */
  void setComponent(Reference value);

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
   * @see com.netxforge.netxscript.NetxscriptPackage#getReference_LeafRef()
   * @model containment="true"
   * @generated
   */
  LeafReference getLeafRef();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.Reference#getLeafRef <em>Leaf Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Leaf Ref</em>' containment reference.
   * @see #getLeafRef()
   * @generated
   */
  void setLeafRef(LeafReference value);

} // Reference
