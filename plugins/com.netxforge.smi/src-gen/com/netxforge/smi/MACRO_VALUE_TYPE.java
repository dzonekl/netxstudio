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
 *   <li>{@link com.netxforge.smi.MACRO_VALUE_TYPE#getValLiteral <em>Val Literal</em>}</li>
 *   <li>{@link com.netxforge.smi.MACRO_VALUE_TYPE#getUpdate <em>Update</em>}</li>
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
   * Returns the value of the '<em><b>Val Literal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val Literal</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val Literal</em>' containment reference.
   * @see #setValLiteral(MACRO_VALUE_CAP)
   * @see com.netxforge.smi.SmiPackage#getMACRO_VALUE_TYPE_ValLiteral()
   * @model containment="true"
   * @generated
   */
  MACRO_VALUE_CAP getValLiteral();

  /**
   * Sets the value of the '{@link com.netxforge.smi.MACRO_VALUE_TYPE#getValLiteral <em>Val Literal</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val Literal</em>' containment reference.
   * @see #getValLiteral()
   * @generated
   */
  void setValLiteral(MACRO_VALUE_CAP value);

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

} // MACRO_VALUE_TYPE
