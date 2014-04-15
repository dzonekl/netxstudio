/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ValueType#getParam <em>Param</em>}</li>
 *   <li>{@link com.netxforge.smi.ValueType#getType <em>Type</em>}</li>
 *   <li>{@link com.netxforge.smi.ValueType#getSimpleType <em>Simple Type</em>}</li>
 *   <li>{@link com.netxforge.smi.ValueType#getMacroValue <em>Macro Value</em>}</li>
 *   <li>{@link com.netxforge.smi.ValueType#getOi <em>Oi</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getValueType()
 * @model
 * @generated
 */
public interface ValueType extends EObject
{
  /**
   * Returns the value of the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param</em>' containment reference.
   * @see #setParam(ParamAssignment)
   * @see com.netxforge.smi.SmiPackage#getValueType_Param()
   * @model containment="true"
   * @generated
   */
  ParamAssignment getParam();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ValueType#getParam <em>Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Param</em>' containment reference.
   * @see #getParam()
   * @generated
   */
  void setParam(ParamAssignment value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(TypeReferenceExt)
   * @see com.netxforge.smi.SmiPackage#getValueType_Type()
   * @model containment="true"
   * @generated
   */
  TypeReferenceExt getType();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ValueType#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeReferenceExt value);

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
   * @see com.netxforge.smi.SmiPackage#getValueType_SimpleType()
   * @model containment="true"
   * @generated
   */
  ASN1_TYPE getSimpleType();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ValueType#getSimpleType <em>Simple Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Simple Type</em>' containment reference.
   * @see #getSimpleType()
   * @generated
   */
  void setSimpleType(ASN1_TYPE value);

  /**
   * Returns the value of the '<em><b>Macro Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Macro Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Macro Value</em>' containment reference.
   * @see #setMacroValue(Value)
   * @see com.netxforge.smi.SmiPackage#getValueType_MacroValue()
   * @model containment="true"
   * @generated
   */
  Value getMacroValue();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ValueType#getMacroValue <em>Macro Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Macro Value</em>' containment reference.
   * @see #getMacroValue()
   * @generated
   */
  void setMacroValue(Value value);

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
   * @see com.netxforge.smi.SmiPackage#getValueType_Oi()
   * @model
   * @generated
   */
  String getOi();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ValueType#getOi <em>Oi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Oi</em>' attribute.
   * @see #getOi()
   * @generated
   */
  void setOi(String value);

} // ValueType
