/**
 */
package com.netxforge.smi;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ObjectIdentifier#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link com.netxforge.smi.ObjectIdentifier#getOidValue <em>Oid Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getObjectIdentifier()
 * @model
 * @generated
 */
public interface ObjectIdentifier extends Assignment
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
   * @see com.netxforge.smi.SmiPackage#getObjectIdentifier_Descriptor()
   * @model
   * @generated
   */
  String getDescriptor();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ObjectIdentifier#getDescriptor <em>Descriptor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Descriptor</em>' attribute.
   * @see #getDescriptor()
   * @generated
   */
  void setDescriptor(String value);

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
