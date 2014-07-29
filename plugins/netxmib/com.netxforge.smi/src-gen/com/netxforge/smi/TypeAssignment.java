/**
 */
package com.netxforge.smi;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.TypeAssignment#getParentRef <em>Parent Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.TypeAssignment#getChildRef <em>Child Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.TypeAssignment#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getTypeAssignment()
 * @model
 * @generated
 */
public interface TypeAssignment extends TypeNotationRight
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
   * @see #setParentRef(TypeAssignment)
   * @see com.netxforge.smi.SmiPackage#getTypeAssignment_ParentRef()
   * @model containment="true"
   * @generated
   */
  TypeAssignment getParentRef();

  /**
   * Sets the value of the '{@link com.netxforge.smi.TypeAssignment#getParentRef <em>Parent Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent Ref</em>' containment reference.
   * @see #getParentRef()
   * @generated
   */
  void setParentRef(TypeAssignment value);

  /**
   * Returns the value of the '<em><b>Child Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Child Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Child Ref</em>' containment reference.
   * @see #setChildRef(TypeAssignment)
   * @see com.netxforge.smi.SmiPackage#getTypeAssignment_ChildRef()
   * @model containment="true"
   * @generated
   */
  TypeAssignment getChildRef();

  /**
   * Sets the value of the '{@link com.netxforge.smi.TypeAssignment#getChildRef <em>Child Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Child Ref</em>' containment reference.
   * @see #getChildRef()
   * @generated
   */
  void setChildRef(TypeAssignment value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(Referenceable)
   * @see com.netxforge.smi.SmiPackage#getTypeAssignment_Type()
   * @model
   * @generated
   */
  Referenceable getType();

  /**
   * Sets the value of the '{@link com.netxforge.smi.TypeAssignment#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(Referenceable value);

} // TypeAssignment
