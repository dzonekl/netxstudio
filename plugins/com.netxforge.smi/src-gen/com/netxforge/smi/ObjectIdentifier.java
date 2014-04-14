/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ObjectIdentifier#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.smi.ObjectIdentifier#getOidValue <em>Oid Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getObjectIdentifier()
 * @model
 * @generated
 */
public interface ObjectIdentifier extends EObject
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
   * @see com.netxforge.smi.SmiPackage#getObjectIdentifier_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ObjectIdentifier#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Oid Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Oid Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Oid Value</em>' containment reference.
   * @see #setOidValue(ObjectIdentifierValue)
   * @see com.netxforge.smi.SmiPackage#getObjectIdentifier_OidValue()
   * @model containment="true"
   * @generated
   */
  ObjectIdentifierValue getOidValue();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ObjectIdentifier#getOidValue <em>Oid Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Oid Value</em>' containment reference.
   * @see #getOidValue()
   * @generated
   */
  void setOidValue(ObjectIdentifierValue value);

} // ObjectIdentifier
