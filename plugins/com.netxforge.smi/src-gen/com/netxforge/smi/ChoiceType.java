/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ChoiceType#getTypeRef <em>Type Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.ChoiceType#getSimpleType <em>Simple Type</em>}</li>
 *   <li>{@link com.netxforge.smi.ChoiceType#getOi <em>Oi</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getChoiceType()
 * @model
 * @generated
 */
public interface ChoiceType extends EObject
{
  /**
   * Returns the value of the '<em><b>Type Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Ref</em>' containment reference.
   * @see #setTypeRef(TypeAssignment)
   * @see com.netxforge.smi.SmiPackage#getChoiceType_TypeRef()
   * @model containment="true"
   * @generated
   */
  TypeAssignment getTypeRef();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ChoiceType#getTypeRef <em>Type Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Ref</em>' containment reference.
   * @see #getTypeRef()
   * @generated
   */
  void setTypeRef(TypeAssignment value);

  /**
   * Returns the value of the '<em><b>Simple Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Simple Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Simple Type</em>' containment reference.
   * @see #setSimpleType(ASN1_TYPE)
   * @see com.netxforge.smi.SmiPackage#getChoiceType_SimpleType()
   * @model containment="true"
   * @generated
   */
  ASN1_TYPE getSimpleType();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ChoiceType#getSimpleType <em>Simple Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Simple Type</em>' containment reference.
   * @see #getSimpleType()
   * @generated
   */
  void setSimpleType(ASN1_TYPE value);

  /**
   * Returns the value of the '<em><b>Oi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Oi</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Oi</em>' attribute.
   * @see #setOi(String)
   * @see com.netxforge.smi.SmiPackage#getChoiceType_Oi()
   * @model
   * @generated
   */
  String getOi();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ChoiceType#getOi <em>Oi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Oi</em>' attribute.
   * @see #getOi()
   * @generated
   */
  void setOi(String value);

} // ChoiceType
