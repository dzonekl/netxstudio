/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Macro Value Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.MacroValueType#getUpdate <em>Update</em>}</li>
 *   <li>{@link com.netxforge.smi.MacroValueType#getLiteral <em>Literal</em>}</li>
 *   <li>{@link com.netxforge.smi.MacroValueType#getString <em>String</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getMacroValueType()
 * @model
 * @generated
 */
public interface MacroValueType extends EObject
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
   * @see com.netxforge.smi.SmiPackage#getMacroValueType_Update()
   * @model containment="true"
   * @generated
   */
  UpdateType getUpdate();

  /**
   * Sets the value of the '{@link com.netxforge.smi.MacroValueType#getUpdate <em>Update</em>}' containment reference.
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
   * @see #setLiteral(ValueCapType)
   * @see com.netxforge.smi.SmiPackage#getMacroValueType_Literal()
   * @model containment="true"
   * @generated
   */
  ValueCapType getLiteral();

  /**
   * Sets the value of the '{@link com.netxforge.smi.MacroValueType#getLiteral <em>Literal</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Literal</em>' containment reference.
   * @see #getLiteral()
   * @generated
   */
  void setLiteral(ValueCapType value);

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
   * @see com.netxforge.smi.SmiPackage#getMacroValueType_String()
   * @model
   * @generated
   */
  String getString();

  /**
   * Sets the value of the '{@link com.netxforge.smi.MacroValueType#getString <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String</em>' attribute.
   * @see #getString()
   * @generated
   */
  void setString(String value);

} // MacroValueType
