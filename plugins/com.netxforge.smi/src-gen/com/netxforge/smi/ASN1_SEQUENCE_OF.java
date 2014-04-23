/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ASN1 SEQUENCE OF</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ASN1_SEQUENCE_OF#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getASN1_SEQUENCE_OF()
 * @model
 * @generated
 */
public interface ASN1_SEQUENCE_OF extends EObject
{
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
   * @see com.netxforge.smi.SmiPackage#getASN1_SEQUENCE_OF_Ref()
   * @model containment="true"
   * @generated
   */
  TypeAssignment getRef();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ASN1_SEQUENCE_OF#getRef <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' containment reference.
   * @see #getRef()
   * @generated
   */
  void setRef(TypeAssignment value);

} // ASN1_SEQUENCE_OF
