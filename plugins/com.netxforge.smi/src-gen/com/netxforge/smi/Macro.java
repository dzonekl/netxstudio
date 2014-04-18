/**
 */
package com.netxforge.smi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Macro</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.Macro#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.smi.Macro#getTypeNotation <em>Type Notation</em>}</li>
 *   <li>{@link com.netxforge.smi.Macro#getValueNotation <em>Value Notation</em>}</li>
 *   <li>{@link com.netxforge.smi.Macro#getInnerTypes <em>Inner Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getMacro()
 * @model
 * @generated
 */
public interface Macro extends EObject
{
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
   * @see com.netxforge.smi.SmiPackage#getMacro_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Macro#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type Notation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Notation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Notation</em>' containment reference.
   * @see #setTypeNotation(TypeNotation)
   * @see com.netxforge.smi.SmiPackage#getMacro_TypeNotation()
   * @model containment="true"
   * @generated
   */
  TypeNotation getTypeNotation();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Macro#getTypeNotation <em>Type Notation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Notation</em>' containment reference.
   * @see #getTypeNotation()
   * @generated
   */
  void setTypeNotation(TypeNotation value);

  /**
   * Returns the value of the '<em><b>Value Notation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value Notation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Notation</em>' containment reference.
   * @see #setValueNotation(ValueNotation)
   * @see com.netxforge.smi.SmiPackage#getMacro_ValueNotation()
   * @model containment="true"
   * @generated
   */
  ValueNotation getValueNotation();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Macro#getValueNotation <em>Value Notation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value Notation</em>' containment reference.
   * @see #getValueNotation()
   * @generated
   */
  void setValueNotation(ValueNotation value);

  /**
   * Returns the value of the '<em><b>Inner Types</b></em>' containment reference list.
   * The list contents are of type {@link com.netxforge.smi.TypeDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inner Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inner Types</em>' containment reference list.
   * @see com.netxforge.smi.SmiPackage#getMacro_InnerTypes()
   * @model containment="true"
   * @generated
   */
  EList<TypeDefinition> getInnerTypes();

} // Macro
