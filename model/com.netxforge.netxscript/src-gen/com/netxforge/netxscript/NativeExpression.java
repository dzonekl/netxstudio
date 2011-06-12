/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Native Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.NativeExpression#getRange <em>Range</em>}</li>
 *   <li>{@link com.netxforge.netxscript.NativeExpression#getRef <em>Ref</em>}</li>
 *   <li>{@link com.netxforge.netxscript.NativeExpression#getNativeFunction <em>Native Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getNativeExpression()
 * @model
 * @generated
 */
public interface NativeExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Range</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Range</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Range</em>' containment reference.
   * @see #setRange(Range)
   * @see com.netxforge.netxscript.NetxscriptPackage#getNativeExpression_Range()
   * @model containment="true"
   * @generated
   */
  Range getRange();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.NativeExpression#getRange <em>Range</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Range</em>' containment reference.
   * @see #getRange()
   * @generated
   */
  void setRange(Range value);

  /**
   * Returns the value of the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' containment reference.
   * @see #setRef(Expression)
   * @see com.netxforge.netxscript.NetxscriptPackage#getNativeExpression_Ref()
   * @model containment="true"
   * @generated
   */
  Expression getRef();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.NativeExpression#getRef <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' containment reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Expression value);

  /**
   * Returns the value of the '<em><b>Native Function</b></em>' attribute.
   * The literals are from the enumeration {@link com.netxforge.netxscript.NativeFunction}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Native Function</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Native Function</em>' attribute.
   * @see com.netxforge.netxscript.NativeFunction
   * @see #setNativeFunction(NativeFunction)
   * @see com.netxforge.netxscript.NetxscriptPackage#getNativeExpression_NativeFunction()
   * @model
   * @generated
   */
  NativeFunction getNativeFunction();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.NativeExpression#getNativeFunction <em>Native Function</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Native Function</em>' attribute.
   * @see com.netxforge.netxscript.NativeFunction
   * @see #getNativeFunction()
   * @generated
   */
  void setNativeFunction(NativeFunction value);

} // NativeExpression
