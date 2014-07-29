/**
 */
package com.netxforge.smi;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Referenceable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.Referenceable#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.smi.Referenceable#getValues <em>Values</em>}</li>
 *   <li>{@link com.netxforge.smi.Referenceable#getTypeNotation <em>Type Notation</em>}</li>
 *   <li>{@link com.netxforge.smi.Referenceable#getValueNotation <em>Value Notation</em>}</li>
 *   <li>{@link com.netxforge.smi.Referenceable#getInnerTypes <em>Inner Types</em>}</li>
 *   <li>{@link com.netxforge.smi.Referenceable#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getReferenceable()
 * @model
 * @generated
 */
public interface Referenceable extends TypeAssignment
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
   * @see com.netxforge.smi.SmiPackage#getReferenceable_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Referenceable#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link com.netxforge.smi.Value}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see com.netxforge.smi.SmiPackage#getReferenceable_Values()
   * @model containment="true"
   * @generated
   */
  EList<Value> getValues();

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
   * @see com.netxforge.smi.SmiPackage#getReferenceable_TypeNotation()
   * @model containment="true"
   * @generated
   */
  TypeNotation getTypeNotation();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Referenceable#getTypeNotation <em>Type Notation</em>}' containment reference.
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
   * @see com.netxforge.smi.SmiPackage#getReferenceable_ValueNotation()
   * @model containment="true"
   * @generated
   */
  ValueNotation getValueNotation();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Referenceable#getValueNotation <em>Value Notation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value Notation</em>' containment reference.
   * @see #getValueNotation()
   * @generated
   */
  void setValueNotation(ValueNotation value);

  /**
   * Returns the value of the '<em><b>Inner Types</b></em>' containment reference list.
   * The list contents are of type {@link com.netxforge.smi.Referenceable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inner Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inner Types</em>' containment reference list.
   * @see com.netxforge.smi.SmiPackage#getReferenceable_InnerTypes()
   * @model containment="true"
   * @generated
   */
  EList<Referenceable> getInnerTypes();

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(TypeNotationRight)
   * @see com.netxforge.smi.SmiPackage#getReferenceable_Right()
   * @model containment="true"
   * @generated
   */
  TypeNotationRight getRight();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Referenceable#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(TypeNotationRight value);

} // Referenceable
