/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Update Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.UpdateType#isUpdate <em>Update</em>}</li>
 *   <li>{@link com.netxforge.smi.UpdateType#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getUpdateType()
 * @model
 * @generated
 */
public interface UpdateType extends EObject
{
  /**
   * Returns the value of the '<em><b>Update</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Update</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Update</em>' attribute.
   * @see #setUpdate(boolean)
   * @see com.netxforge.smi.SmiPackage#getUpdateType_Update()
   * @model
   * @generated
   */
  boolean isUpdate();

  /**
   * Sets the value of the '{@link com.netxforge.smi.UpdateType#isUpdate <em>Update</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Update</em>' attribute.
   * @see #isUpdate()
   * @generated
   */
  void setUpdate(boolean value);

  /**
   * Returns the value of the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' containment reference.
   * @see #setRef(TypeAssignment)
   * @see com.netxforge.smi.SmiPackage#getUpdateType_Ref()
   * @model containment="true"
   * @generated
   */
  TypeAssignment getRef();

  /**
   * Sets the value of the '{@link com.netxforge.smi.UpdateType#getRef <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' containment reference.
   * @see #getRef()
   * @generated
   */
  void setRef(TypeAssignment value);

} // UpdateType
