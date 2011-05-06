/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.netxforge.netxstudio.models.xtextwrapper;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.example.arithmetics.arithmetics.Evaluation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arithmetic Wrapper</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.models.xtextwrapper.ArithmeticWrapper#getAsString <em>As String</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.models.xtextwrapper.ArithmeticWrapper#getEval <em>Eval</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.models.xtextwrapper.XtextwrapperPackage#getArithmeticWrapper()
 * @model
 * @generated
 */
public interface ArithmeticWrapper extends EObject {
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
	 * @see com.netxforge.netxstudio.models.xtextwrapper.XtextwrapperPackage#getArithmeticWrapper_AsString()
	 * @model
	 * @generated
	 */
	String getAsString();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.models.xtextwrapper.ArithmeticWrapper#getAsString <em>As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>As String</em>' attribute.
	 * @see #getAsString()
	 * @generated
	 */
	void setAsString(String value);

	/**
	 * Returns the value of the '<em><b>Eval</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eval</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eval</em>' containment reference.
	 * @see #setEval(Evaluation)
	 * @see com.netxforge.netxstudio.models.xtextwrapper.XtextwrapperPackage#getArithmeticWrapper_Eval()
	 * @model containment="true"
	 * @generated
	 */
	Evaluation getEval();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.models.xtextwrapper.ArithmeticWrapper#getEval <em>Eval</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eval</em>' containment reference.
	 * @see #getEval()
	 * @generated
	 */
	void setEval(Evaluation value);

} // ArithmeticWrapper
