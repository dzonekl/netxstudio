/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Reference Ext</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.TypeReferenceExt#getParentRef <em>Parent Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.TypeReferenceExt#getChildRef <em>Child Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getTypeReferenceExt()
 * @model
 * @generated
 */
public interface TypeReferenceExt extends EObject
{
  /**
   * Returns the value of the '<em><b>Parent Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parent Ref</em>' containment reference.
   * @see #setParentRef(TypeReference)
   * @see com.netxforge.smi.SmiPackage#getTypeReferenceExt_ParentRef()
   * @model containment="true"
   * @generated
   */
  TypeReference getParentRef();

  /**
   * Sets the value of the '{@link com.netxforge.smi.TypeReferenceExt#getParentRef <em>Parent Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent Ref</em>' containment reference.
   * @see #getParentRef()
   * @generated
   */
  void setParentRef(TypeReference value);

  /**
   * Returns the value of the '<em><b>Child Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Child Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Child Ref</em>' containment reference.
   * @see #setChildRef(TypeReference)
   * @see com.netxforge.smi.SmiPackage#getTypeReferenceExt_ChildRef()
   * @model containment="true"
   * @generated
   */
  TypeReference getChildRef();

  /**
   * Sets the value of the '{@link com.netxforge.smi.TypeReferenceExt#getChildRef <em>Child Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Child Ref</em>' containment reference.
   * @see #getChildRef()
   * @generated
   */
  void setChildRef(TypeReference value);

} // TypeReferenceExt
