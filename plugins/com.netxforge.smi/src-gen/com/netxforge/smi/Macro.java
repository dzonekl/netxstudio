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
 *   <li>{@link com.netxforge.smi.Macro#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link com.netxforge.smi.Macro#getTypeNotations <em>Type Notations</em>}</li>
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
   * Returns the value of the '<em><b>Descriptor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Descriptor</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Descriptor</em>' attribute.
   * @see #setDescriptor(String)
   * @see com.netxforge.smi.SmiPackage#getMacro_Descriptor()
   * @model
   * @generated
   */
  String getDescriptor();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Macro#getDescriptor <em>Descriptor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Descriptor</em>' attribute.
   * @see #getDescriptor()
   * @generated
   */
  void setDescriptor(String value);

  /**
   * Returns the value of the '<em><b>Type Notations</b></em>' reference list.
   * The list contents are of type {@link com.netxforge.smi.ValueAssignment}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Notations</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Notations</em>' reference list.
   * @see com.netxforge.smi.SmiPackage#getMacro_TypeNotations()
   * @model
   * @generated
   */
  EList<ValueAssignment> getTypeNotations();

  /**
   * Returns the value of the '<em><b>Value Notation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value Notation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Notation</em>' containment reference.
   * @see #setValueNotation(MacroValue)
   * @see com.netxforge.smi.SmiPackage#getMacro_ValueNotation()
   * @model containment="true"
   * @generated
   */
  MacroValue getValueNotation();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Macro#getValueNotation <em>Value Notation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value Notation</em>' containment reference.
   * @see #getValueNotation()
   * @generated
   */
  void setValueNotation(MacroValue value);

  /**
   * Returns the value of the '<em><b>Inner Types</b></em>' containment reference list.
   * The list contents are of type {@link com.netxforge.smi.ValueAssignment}.
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
  EList<ValueAssignment> getInnerTypes();

} // Macro
