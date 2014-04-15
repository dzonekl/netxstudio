/**
 */
package com.netxforge.smi;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.TypeReference#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getTypeReference()
 * @model
 * @generated
 */
public interface TypeReference extends TypeAssignment, TypeNotation
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(TypeDefinition)
   * @see com.netxforge.smi.SmiPackage#getTypeReference_Type()
   * @model
   * @generated
   */
  TypeDefinition getType();

  /**
   * Sets the value of the '{@link com.netxforge.smi.TypeReference#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeDefinition value);

} // TypeReference
