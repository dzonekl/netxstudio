/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ImportRef#getOiRef <em>Oi Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.ImportRef#getTypeRef <em>Type Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getImportRef()
 * @model
 * @generated
 */
public interface ImportRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Oi Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Oi Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Oi Ref</em>' reference.
   * @see #setOiRef(ObjectIdentifier)
   * @see com.netxforge.smi.SmiPackage#getImportRef_OiRef()
   * @model
   * @generated
   */
  ObjectIdentifier getOiRef();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ImportRef#getOiRef <em>Oi Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Oi Ref</em>' reference.
   * @see #getOiRef()
   * @generated
   */
  void setOiRef(ObjectIdentifier value);

  /**
   * Returns the value of the '<em><b>Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Ref</em>' reference.
   * @see #setTypeRef(TypeDefinition)
   * @see com.netxforge.smi.SmiPackage#getImportRef_TypeRef()
   * @model
   * @generated
   */
  TypeDefinition getTypeRef();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ImportRef#getTypeRef <em>Type Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Ref</em>' reference.
   * @see #getTypeRef()
   * @generated
   */
  void setTypeRef(TypeDefinition value);

} // ImportRef
