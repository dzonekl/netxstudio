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
 *   <li>{@link com.netxforge.smi.MacroValueType#isUpdate <em>Update</em>}</li>
 *   <li>{@link com.netxforge.smi.MacroValueType#isValueCAP <em>Value CAP</em>}</li>
 *   <li>{@link com.netxforge.smi.MacroValueType#getRef <em>Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.MacroValueType#getOi <em>Oi</em>}</li>
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
   * Returns the value of the '<em><b>Update</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Update</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Update</em>' attribute.
   * @see #setUpdate(boolean)
   * @see com.netxforge.smi.SmiPackage#getMacroValueType_Update()
   * @model
   * @generated
   */
  boolean isUpdate();

  /**
   * Sets the value of the '{@link com.netxforge.smi.MacroValueType#isUpdate <em>Update</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Update</em>' attribute.
   * @see #isUpdate()
   * @generated
   */
  void setUpdate(boolean value);

  /**
   * Returns the value of the '<em><b>Value CAP</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value CAP</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value CAP</em>' attribute.
   * @see #setValueCAP(boolean)
   * @see com.netxforge.smi.SmiPackage#getMacroValueType_ValueCAP()
   * @model
   * @generated
   */
  boolean isValueCAP();

  /**
   * Sets the value of the '{@link com.netxforge.smi.MacroValueType#isValueCAP <em>Value CAP</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value CAP</em>' attribute.
   * @see #isValueCAP()
   * @generated
   */
  void setValueCAP(boolean value);

  /**
   * Returns the value of the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' containment reference.
   * @see #setRef(TypeAssignment)
   * @see com.netxforge.smi.SmiPackage#getMacroValueType_Ref()
   * @model containment="true"
   * @generated
   */
  TypeAssignment getRef();

  /**
   * Sets the value of the '{@link com.netxforge.smi.MacroValueType#getRef <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' containment reference.
   * @see #getRef()
   * @generated
   */
  void setRef(TypeAssignment value);

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
   * @see com.netxforge.smi.SmiPackage#getMacroValueType_Oi()
   * @model
   * @generated
   */
  String getOi();

  /**
   * Sets the value of the '{@link com.netxforge.smi.MacroValueType#getOi <em>Oi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Oi</em>' attribute.
   * @see #getOi()
   * @generated
   */
  void setOi(String value);

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
