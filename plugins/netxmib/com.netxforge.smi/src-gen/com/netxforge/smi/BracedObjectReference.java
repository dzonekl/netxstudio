/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Braced Object Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.BracedObjectReference#getObjectRef <em>Object Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getBracedObjectReference()
 * @model
 * @generated
 */
public interface BracedObjectReference extends EObject
{
  /**
   * Returns the value of the '<em><b>Object Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Object Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object Ref</em>' reference.
   * @see #setObjectRef(ObjectReferenceable)
   * @see com.netxforge.smi.SmiPackage#getBracedObjectReference_ObjectRef()
   * @model
   * @generated
   */
  ObjectReferenceable getObjectRef();

  /**
   * Sets the value of the '{@link com.netxforge.smi.BracedObjectReference#getObjectRef <em>Object Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object Ref</em>' reference.
   * @see #getObjectRef()
   * @generated
   */
  void setObjectRef(ObjectReferenceable value);

} // BracedObjectReference
