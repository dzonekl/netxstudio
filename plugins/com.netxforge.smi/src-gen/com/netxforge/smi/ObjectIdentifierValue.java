/**
 */
package com.netxforge.smi;

import java.math.BigInteger;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Identifier Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ObjectIdentifierValue#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.smi.ObjectIdentifierValue#getDescriptorReference <em>Descriptor Reference</em>}</li>
 *   <li>{@link com.netxforge.smi.ObjectIdentifierValue#getSubIds <em>Sub Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getObjectIdentifierValue()
 * @model
 * @generated
 */
public interface ObjectIdentifierValue extends EObject
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
   * @see com.netxforge.smi.SmiPackage#getObjectIdentifierValue_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ObjectIdentifierValue#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Descriptor Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Descriptor Reference</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Descriptor Reference</em>' reference.
   * @see #setDescriptorReference(ObjectIdentifier)
   * @see com.netxforge.smi.SmiPackage#getObjectIdentifierValue_DescriptorReference()
   * @model
   * @generated
   */
  ObjectIdentifier getDescriptorReference();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ObjectIdentifierValue#getDescriptorReference <em>Descriptor Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Descriptor Reference</em>' reference.
   * @see #getDescriptorReference()
   * @generated
   */
  void setDescriptorReference(ObjectIdentifier value);

  /**
   * Returns the value of the '<em><b>Sub Ids</b></em>' attribute list.
   * The list contents are of type {@link java.math.BigInteger}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Ids</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Ids</em>' attribute list.
   * @see com.netxforge.smi.SmiPackage#getObjectIdentifierValue_SubIds()
   * @model unique="false"
   * @generated
   */
  EList<BigInteger> getSubIds();

} // ObjectIdentifierValue
