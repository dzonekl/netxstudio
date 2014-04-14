/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.Assignment#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link com.netxforge.smi.Assignment#getType <em>Type</em>}</li>
 *   <li>{@link com.netxforge.smi.Assignment#getMacro <em>Macro</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getAssignment()
 * @model
 * @generated
 */
public interface Assignment extends EObject
{
  /**
   * Returns the value of the '<em><b>Identifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Identifier</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Identifier</em>' containment reference.
   * @see #setIdentifier(ObjectIdentifier)
   * @see com.netxforge.smi.SmiPackage#getAssignment_Identifier()
   * @model containment="true"
   * @generated
   */
  ObjectIdentifier getIdentifier();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Assignment#getIdentifier <em>Identifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Identifier</em>' containment reference.
   * @see #getIdentifier()
   * @generated
   */
  void setIdentifier(ObjectIdentifier value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(TypeDefinition)
   * @see com.netxforge.smi.SmiPackage#getAssignment_Type()
   * @model containment="true"
   * @generated
   */
  TypeDefinition getType();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Assignment#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeDefinition value);

  /**
   * Returns the value of the '<em><b>Macro</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Macro</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Macro</em>' containment reference.
   * @see #setMacro(Macro)
   * @see com.netxforge.smi.SmiPackage#getAssignment_Macro()
   * @model containment="true"
   * @generated
   */
  Macro getMacro();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Assignment#getMacro <em>Macro</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Macro</em>' containment reference.
   * @see #getMacro()
   * @generated
   */
  void setMacro(Macro value);

} // Assignment
