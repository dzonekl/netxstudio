/**
 */
package com.netxforge.smi;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ASN1 SEQUENCE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ASN1_SEQUENCE#getChoiceType <em>Choice Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getASN1_SEQUENCE()
 * @model
 * @generated
 */
public interface ASN1_SEQUENCE extends ASN1_TYPE
{
  /**
   * Returns the value of the '<em><b>Choice Type</b></em>' containment reference list.
   * The list contents are of type {@link com.netxforge.smi.ASN1_CHOICE_ENTRY}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Choice Type</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Choice Type</em>' containment reference list.
   * @see com.netxforge.smi.SmiPackage#getASN1_SEQUENCE_ChoiceType()
   * @model containment="true"
   * @generated
   */
  EList<ASN1_CHOICE_ENTRY> getChoiceType();

} // ASN1_SEQUENCE
