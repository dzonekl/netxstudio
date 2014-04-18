/**
 */
package com.netxforge.smi;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ASN1 SIMPLE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ASN1_SIMPLE#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.netxforge.smi.ASN1_SIMPLE#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.smi.ASN1_SIMPLE#getRange <em>Range</em>}</li>
 *   <li>{@link com.netxforge.smi.ASN1_SIMPLE#getRanges <em>Ranges</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getASN1_SIMPLE()
 * @model
 * @generated
 */
public interface ASN1_SIMPLE extends ASN1_TYPE
{
  /**
   * Returns the value of the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraint</em>' containment reference.
   * @see #setConstraint(ASN1_SIMPLE)
   * @see com.netxforge.smi.SmiPackage#getASN1_SIMPLE_Constraint()
   * @model containment="true"
   * @generated
   */
  ASN1_SIMPLE getConstraint();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ASN1_SIMPLE#getConstraint <em>Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraint</em>' containment reference.
   * @see #getConstraint()
   * @generated
   */
  void setConstraint(ASN1_SIMPLE value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.netxforge.smi.SmiPackage#getASN1_SIMPLE_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ASN1_SIMPLE#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Range</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Range</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Range</em>' containment reference.
   * @see #setRange(ASN1_RANGE)
   * @see com.netxforge.smi.SmiPackage#getASN1_SIMPLE_Range()
   * @model containment="true"
   * @generated
   */
  ASN1_RANGE getRange();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ASN1_SIMPLE#getRange <em>Range</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Range</em>' containment reference.
   * @see #getRange()
   * @generated
   */
  void setRange(ASN1_RANGE value);

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
   * @see com.netxforge.smi.SmiPackage#getASN1_SIMPLE_Ranges()
   * @model containment="true"
   * @generated
   */
  EList<ASN1_RANGE> getRanges();

} // ASN1_SIMPLE
