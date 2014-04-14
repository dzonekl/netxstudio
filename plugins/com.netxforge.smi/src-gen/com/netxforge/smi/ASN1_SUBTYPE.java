/**
 */
package com.netxforge.smi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ASN1 SUBTYPE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ASN1_SUBTYPE#getRanges <em>Ranges</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getASN1_SUBTYPE()
 * @model
 * @generated
 */
public interface ASN1_SUBTYPE extends EObject
{
  /**
   * Returns the value of the '<em><b>Ranges</b></em>' containment reference list.
   * The list contents are of type {@link com.netxforge.smi.ASN1_RANGE}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ranges</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ranges</em>' containment reference list.
   * @see com.netxforge.smi.SmiPackage#getASN1_SUBTYPE_Ranges()
   * @model containment="true"
   * @generated
   */
  EList<ASN1_RANGE> getRanges();

} // ASN1_SUBTYPE
