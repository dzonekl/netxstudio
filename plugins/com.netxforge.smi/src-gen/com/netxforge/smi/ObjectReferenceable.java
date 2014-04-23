/**
 */
package com.netxforge.smi;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link com.netxforge.smi.ObjectReferenceable#getOidValue <em>Oid Value</em>}</li>
 *   <li>{@link com.netxforge.smi.ObjectReferenceable#getMacroRef <em>Macro Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.ObjectReferenceable#getAttributes <em>Attributes</em>}</li>
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
   * Returns the value of the '<em><b>Oid Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Oid Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Oid Value</em>' containment reference.
   * @see #setOidValue(ObjectIdentifierValue)
   * @see com.netxforge.smi.SmiPackage#getObjectReferenceable_OidValue()
   * @model containment="true"
   * @generated
   */
  ObjectIdentifierValue getOidValue();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ObjectReferenceable#getOidValue <em>Oid Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Oid Value</em>' containment reference.
   * @see #getOidValue()
   * @generated
   */
  void setOidValue(ObjectIdentifierValue value);

  /**
   * Returns the value of the '<em><b>Macro Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Macro Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Macro Ref</em>' reference.
   * @see #setMacroRef(Referenceable)
   * @see com.netxforge.smi.SmiPackage#getObjectReferenceable_MacroRef()
   * @model
   * @generated
   */
  Referenceable getMacroRef();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ObjectReferenceable#getMacroRef <em>Macro Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Macro Ref</em>' reference.
   * @see #getMacroRef()
   * @generated
   */
  void setMacroRef(Referenceable value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link com.netxforge.smi.Attribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see com.netxforge.smi.SmiPackage#getObjectReferenceable_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

  /**
   * Returns the value of the '<em><b>Object Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Object Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object Value</em>' containment reference.
   * @see #setObjectValue(ObjectValue)
   * @see com.netxforge.smi.SmiPackage#getObjectReferenceable_ObjectValue()
   * @model containment="true"
   * @generated
   */
  ObjectValue getObjectValue();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ObjectReferenceable#getObjectValue <em>Object Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object Value</em>' containment reference.
   * @see #getObjectValue()
   * @generated
   */
  void setObjectValue(ObjectValue value);

} // ObjectReferenceable
