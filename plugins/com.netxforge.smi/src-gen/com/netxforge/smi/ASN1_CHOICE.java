/**
 */
package com.netxforge.smi;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ASN1 CHOICE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ASN1_CHOICE#getChoices <em>Choices</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getASN1_CHOICE()
 * @model
 * @generated
 */
public interface ASN1_CHOICE extends ASN1_TYPE
{
  /**
   * Returns the value of the '<em><b>Choices</b></em>' containment reference list.
   * The list contents are of type {@link com.netxforge.smi.ASN1_CHOICE_ENTRY}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Choices</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Choices</em>' containment reference list.
   * @see com.netxforge.smi.SmiPackage#getASN1_CHOICE_Choices()
   * @model containment="true"
   * @generated
   */
  EList<ASN1_CHOICE_ENTRY> getChoices();

} // ASN1_CHOICE
