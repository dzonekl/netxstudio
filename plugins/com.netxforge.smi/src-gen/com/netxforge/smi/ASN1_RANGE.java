/**
 */
package com.netxforge.smi;

import java.math.BigInteger;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ASN1 RANGE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ASN1_RANGE#getValue <em>Value</em>}</li>
 *   <li>{@link com.netxforge.smi.ASN1_RANGE#getStart <em>Start</em>}</li>
 *   <li>{@link com.netxforge.smi.ASN1_RANGE#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getASN1_RANGE()
 * @model
 * @generated
 */
public interface ASN1_RANGE extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(BigInteger)
   * @see com.netxforge.smi.SmiPackage#getASN1_RANGE_Value()
   * @model
   * @generated
   */
  BigInteger getValue();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ASN1_RANGE#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(BigInteger value);

  /**
   * Returns the value of the '<em><b>Start</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start</em>' attribute.
   * @see #setStart(BigInteger)
   * @see com.netxforge.smi.SmiPackage#getASN1_RANGE_Start()
   * @model
   * @generated
   */
  BigInteger getStart();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ASN1_RANGE#getStart <em>Start</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start</em>' attribute.
   * @see #getStart()
   * @generated
   */
  void setStart(BigInteger value);

  /**
   * Returns the value of the '<em><b>End</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End</em>' attribute.
   * @see #setEnd(BigInteger)
   * @see com.netxforge.smi.SmiPackage#getASN1_RANGE_End()
   * @model
   * @generated
   */
  BigInteger getEnd();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ASN1_RANGE#getEnd <em>End</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End</em>' attribute.
   * @see #getEnd()
   * @generated
   */
  void setEnd(BigInteger value);

} // ASN1_RANGE
