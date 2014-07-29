/**
 */
package com.netxforge.smi;

import java.math.BigInteger;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.Tag#getTagValue <em>Tag Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getTag()
 * @model
 * @generated
 */
public interface Tag extends EObject
{
  /**
   * Returns the value of the '<em><b>Tag Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tag Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tag Value</em>' attribute.
   * @see #setTagValue(BigInteger)
   * @see com.netxforge.smi.SmiPackage#getTag_TagValue()
   * @model
   * @generated
   */
  BigInteger getTagValue();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Tag#getTagValue <em>Tag Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tag Value</em>' attribute.
   * @see #getTagValue()
   * @generated
   */
  void setTagValue(BigInteger value);

} // Tag
