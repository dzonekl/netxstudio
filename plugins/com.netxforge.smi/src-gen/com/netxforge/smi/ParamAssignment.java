/**
 */
package com.netxforge.smi;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Param Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ParamAssignment#getParam <em>Param</em>}</li>
 *   <li>{@link com.netxforge.smi.ParamAssignment#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getParamAssignment()
 * @model
 * @generated
 */
public interface ParamAssignment extends TypeAssignment
{
  /**
   * Returns the value of the '<em><b>Param</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param</em>' attribute.
   * @see #setParam(String)
   * @see com.netxforge.smi.SmiPackage#getParamAssignment_Param()
   * @model
   * @generated
   */
  String getParam();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ParamAssignment#getParam <em>Param</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Param</em>' attribute.
   * @see #getParam()
   * @generated
   */
  void setParam(String value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(TypeNotation)
   * @see com.netxforge.smi.SmiPackage#getParamAssignment_Right()
   * @model containment="true"
   * @generated
   */
  TypeNotation getRight();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ParamAssignment#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(TypeNotation value);

} // ParamAssignment
