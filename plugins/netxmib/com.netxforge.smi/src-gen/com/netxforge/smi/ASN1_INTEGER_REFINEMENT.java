/**
 */
package com.netxforge.smi;

import java.math.BigInteger;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ASN1 INTEGER REFINEMENT</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ASN1_INTEGER_REFINEMENT#getRefinements <em>Refinements</em>}</li>
 *   <li>{@link com.netxforge.smi.ASN1_INTEGER_REFINEMENT#getInts <em>Ints</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getASN1_INTEGER_REFINEMENT()
 * @model
 * @generated
 */
public interface ASN1_INTEGER_REFINEMENT extends EObject
{
  /**
   * Returns the value of the '<em><b>Refinements</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Refinements</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Refinements</em>' attribute list.
   * @see com.netxforge.smi.SmiPackage#getASN1_INTEGER_REFINEMENT_Refinements()
   * @model unique="false"
   * @generated
   */
  EList<String> getRefinements();

  /**
   * Returns the value of the '<em><b>Ints</b></em>' attribute list.
   * The list contents are of type {@link java.math.BigInteger}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ints</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ints</em>' attribute list.
   * @see com.netxforge.smi.SmiPackage#getASN1_INTEGER_REFINEMENT_Ints()
   * @model unique="false"
   * @generated
   */
  EList<BigInteger> getInts();

} // ASN1_INTEGER_REFINEMENT
