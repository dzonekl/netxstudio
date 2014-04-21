/**
 */
package com.netxforge.smi;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Closure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.ImportClosure#getRefs <em>Refs</em>}</li>
 *   <li>{@link com.netxforge.smi.ImportClosure#getImportURI <em>Import URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getImportClosure()
 * @model
 * @generated
 */
public interface ImportClosure extends Imports
{
  /**
   * Returns the value of the '<em><b>Refs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Refs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Refs</em>' containment reference.
   * @see #setRefs(ImportRefs)
   * @see com.netxforge.smi.SmiPackage#getImportClosure_Refs()
   * @model containment="true"
   * @generated
   */
  ImportRefs getRefs();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ImportClosure#getRefs <em>Refs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Refs</em>' containment reference.
   * @see #getRefs()
   * @generated
   */
  void setRefs(ImportRefs value);

  /**
   * Returns the value of the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Import URI</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import URI</em>' attribute.
   * @see #setImportURI(String)
   * @see com.netxforge.smi.SmiPackage#getImportClosure_ImportURI()
   * @model
   * @generated
   */
  String getImportURI();

  /**
   * Sets the value of the '{@link com.netxforge.smi.ImportClosure#getImportURI <em>Import URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import URI</em>' attribute.
   * @see #getImportURI()
   * @generated
   */
  void setImportURI(String value);

} // ImportClosure
