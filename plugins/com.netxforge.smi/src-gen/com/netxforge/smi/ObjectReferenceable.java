/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Referenceable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ObjectReferenceable#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.smi.ObjectReferenceable#getObject <em>Object</em>}</li>
 *   <li>{@link com.netxforge.smi.ObjectReferenceable#getObjectValue <em>Object Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getObjectReferenceable()
 * @model
 * @generated
 */
public interface ObjectReferenceable extends EObject
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
   * @see com.netxforge.smi.SmiPackage#getObjectReferenceable_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ObjectReferenceable#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Object</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object</em>' containment reference.
   * @see #setObject(com.netxforge.smi.Object)
   * @see com.netxforge.smi.SmiPackage#getObjectReferenceable_Object()
   * @model containment="true"
   * @generated
   */
  com.netxforge.smi.Object getObject();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ObjectReferenceable#getObject <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object</em>' containment reference.
   * @see #getObject()
   * @generated
   */
  void setObject(com.netxforge.smi.Object value);

  /**
   * Returns the value of the '<em><b>Object Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Object Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object Value</em>' containment reference.
   * @see #setObjectValue(ObjectReference)
   * @see com.netxforge.smi.SmiPackage#getObjectReferenceable_ObjectValue()
   * @model containment="true"
   * @generated
   */
  ObjectReference getObjectValue();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ObjectReferenceable#getObjectValue <em>Object Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object Value</em>' containment reference.
   * @see #getObjectValue()
   * @generated
   */
  void setObjectValue(ObjectReference value);

} // ObjectReferenceable
