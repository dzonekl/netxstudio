/**
 */
package com.netxforge.smi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.Module#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.smi.Module#getImports <em>Imports</em>}</li>
 *   <li>{@link com.netxforge.smi.Module#getObjects <em>Objects</em>}</li>
 *   <li>{@link com.netxforge.smi.Module#getIdentifiers <em>Identifiers</em>}</li>
 *   <li>{@link com.netxforge.smi.Module#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends EObject
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
   * @see com.netxforge.smi.SmiPackage#getModule_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Module#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference.
   * @see #setImports(Imports)
   * @see com.netxforge.smi.SmiPackage#getModule_Imports()
   * @model containment="true"
   * @generated
   */
  Imports getImports();

  /**
   * Sets the value of the '{@link com.netxforge.smi.Module#getImports <em>Imports</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Imports</em>' containment reference.
   * @see #getImports()
   * @generated
   */
  void setImports(Imports value);

  /**
   * Returns the value of the '<em><b>Objects</b></em>' containment reference list.
   * The list contents are of type {@link com.netxforge.smi.ObjectReferenceable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Objects</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Objects</em>' containment reference list.
   * @see com.netxforge.smi.SmiPackage#getModule_Objects()
   * @model containment="true"
   * @generated
   */
  EList<ObjectReferenceable> getObjects();

  /**
   * Returns the value of the '<em><b>Identifiers</b></em>' containment reference list.
   * The list contents are of type {@link com.netxforge.smi.ObjectReferenceable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Identifiers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Identifiers</em>' containment reference list.
   * @see com.netxforge.smi.SmiPackage#getModule_Identifiers()
   * @model containment="true"
   * @generated
   */
  EList<ObjectReferenceable> getIdentifiers();

  /**
   * Returns the value of the '<em><b>Types</b></em>' containment reference list.
   * The list contents are of type {@link com.netxforge.smi.Referenceable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Types</em>' containment reference list.
   * @see com.netxforge.smi.SmiPackage#getModule_Types()
   * @model containment="true"
   * @generated
   */
  EList<Referenceable> getTypes();

} // Module
