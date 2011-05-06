/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.netxforge.netxstudio.models.xtextwrapper;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XBlockExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Net XScript Wrapper</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.models.xtextwrapper.NetXScriptWrapper#getAsString <em>As String</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.models.xtextwrapper.NetXScriptWrapper#getXblock <em>Xblock</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.models.xtextwrapper.XtextwrapperPackage#getNetXScriptWrapper()
 * @model
 * @generated
 */
public interface NetXScriptWrapper extends EObject {
	/**
	 * Returns the value of the '<em><b>As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>As String</em>' attribute.
	 * @see #setAsString(String)
	 * @see com.netxforge.netxstudio.models.xtextwrapper.XtextwrapperPackage#getNetXScriptWrapper_AsString()
	 * @model
	 * @generated
	 */
	String getAsString();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.models.xtextwrapper.NetXScriptWrapper#getAsString <em>As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>As String</em>' attribute.
	 * @see #getAsString()
	 * @generated
	 */
	void setAsString(String value);

	/**
	 * Returns the value of the '<em><b>Xblock</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xblock</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xblock</em>' containment reference.
	 * @see #setXblock(XBlockExpression)
	 * @see com.netxforge.netxstudio.models.xtextwrapper.XtextwrapperPackage#getNetXScriptWrapper_Xblock()
	 * @model containment="true"
	 * @generated
	 */
	XBlockExpression getXblock();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.models.xtextwrapper.NetXScriptWrapper#getXblock <em>Xblock</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xblock</em>' containment reference.
	 * @see #getXblock()
	 * @generated
	 */
	void setXblock(XBlockExpression value);

} // NetXScriptWrapper
