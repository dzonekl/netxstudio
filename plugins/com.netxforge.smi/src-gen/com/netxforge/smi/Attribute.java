/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.Attribute#getParamRef <em>Param Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.Attribute#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends EObject
{
  /**
   * Returns the value of the '<em><b>Param Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param Ref</em>' reference.
   * @see #setParamRef(Referenceable)
   * @see com.netxforge.smi.SmiPackage#getAttribute_ParamRef()
   * @model
   * @generated
   */
  Referenceable getParamRef();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Attribute#getParamRef <em>Param Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Param Ref</em>' reference.
   * @see #getParamRef()
   * @generated
   */
  void setParamRef(Referenceable value);

  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference.
   * @see #setValues(AttributeValue)
   * @see com.netxforge.smi.SmiPackage#getAttribute_Values()
   * @model containment="true"
   * @generated
   */
  AttributeValue getValues();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Attribute#getValues <em>Values</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Values</em>' containment reference.
   * @see #getValues()
   * @generated
   */
  void setValues(AttributeValue value);

} // Attribute
