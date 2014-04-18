/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MACRO VALUE TYPE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.MACRO_VALUE_TYPE#getUpdate <em>Update</em>}</li>
 *   <li>{@link com.netxforge.smi.MACRO_VALUE_TYPE#getLiteral <em>Literal</em>}</li>
 *   <li>{@link com.netxforge.smi.MACRO_VALUE_TYPE#getString <em>String</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getMACRO_VALUE_TYPE()
 * @model
 * @generated
 */
public interface MACRO_VALUE_TYPE extends EObject
{
  /**
   * Returns the value of the '<em><b>Update</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Update</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Update</em>' containment reference.
   * @see #setUpdate(UpdateType)
   * @see com.netxforge.smi.SmiPackage#getMACRO_VALUE_TYPE_Update()
   * @model containment="true"
   * @generated
   */
  UpdateType getUpdate();

  /**
   * Sets the value of the '{@link com.netxforge.smi.MACRO_VALUE_TYPE#getUpdate <em>Update</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Update</em>' containment reference.
   * @see #getUpdate()
   * @generated
   */
  void setUpdate(UpdateType value);

  /**
   * Returns the value of the '<em><b>Literal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Literal</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literal</em>' containment reference.
   * @see #setLiteral(MACRO_VALUE_CAP)
   * @see com.netxforge.smi.SmiPackage#getMACRO_VALUE_TYPE_Literal()
   * @model containment="true"
   * @generated
   */
  MACRO_VALUE_CAP getLiteral();

  /**
   * Sets the value of the '{@link com.netxforge.smi.MACRO_VALUE_TYPE#getLiteral <em>Literal</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Literal</em>' containment reference.
   * @see #getLiteral()
   * @generated
   */
  void setLiteral(MACRO_VALUE_CAP value);

  /**
   * Returns the value of the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>String</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>String</em>' attribute.
   * @see #setString(String)
   * @see com.netxforge.smi.SmiPackage#getMACRO_VALUE_TYPE_String()
   * @model
   * @generated
   */
  String getString();

  /**
   * Sets the value of the '{@link com.netxforge.smi.MACRO_VALUE_TYPE#getString <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String</em>' attribute.
   * @see #getString()
   * @generated
   */
  void setString(String value);

} // MACRO_VALUE_TYPE
