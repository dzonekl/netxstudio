/**
 */
package com.netxforge.smi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

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
 *   <li>{@link com.netxforge.smi.ASN1_SIMPLE#getValuePairs <em>Value Pairs</em>}</li>
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
   * @see #setConstraint(EObject)
   * @see com.netxforge.smi.SmiPackage#getASN1_SIMPLE_Constraint()
   * @model containment="true"
   * @generated
   */
  EObject getConstraint();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ASN1_SIMPLE#getConstraint <em>Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraint</em>' containment reference.
   * @see #getConstraint()
   * @generated
   */
  void setConstraint(EObject value);

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
   * Returns the value of the '<em><b>Value Pairs</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value Pairs</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Pairs</em>' attribute list.
   * @see com.netxforge.smi.SmiPackage#getASN1_SIMPLE_ValuePairs()
   * @model unique="false"
   * @generated
   */
  EList<String> getValuePairs();

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
