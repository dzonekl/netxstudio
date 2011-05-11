/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.netxforge.netxstudio.models.xtextwrapper;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.models.xtextwrapper.Model#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.models.xtextwrapper.Model#getScripts <em>Scripts</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.models.xtextwrapper.XtextwrapperPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
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
	 * @see com.netxforge.netxstudio.models.xtextwrapper.XtextwrapperPackage#getModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.models.xtextwrapper.Model#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Scripts</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.models.xtextwrapper.NetXScriptWrapper}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scripts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scripts</em>' containment reference list.
	 * @see com.netxforge.netxstudio.models.xtextwrapper.XtextwrapperPackage#getModel_Scripts()
	 * @model containment="true"
	 * @generated
	 */
	EList<NetXScriptWrapper> getScripts();

} // Model
