/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.Reference#getNativeFunction <em>Native Function</em>}</li>
 *   <li>{@link com.netxforge.netxscript.Reference#getNodes <em>Nodes</em>}</li>
 *   <li>{@link com.netxforge.netxscript.Reference#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends Expression
{
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
   * @see com.netxforge.netxscript.NetxscriptPackage#getReference_NativeFunction()
   * @model
   * @generated
   */
  NativeFunction getNativeFunction();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.Reference#getNativeFunction <em>Native Function</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Native Function</em>' attribute.
   * @see com.netxforge.netxscript.NativeFunction
   * @see #getNativeFunction()
   * @generated
   */
  void setNativeFunction(NativeFunction value);

  /**
   * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
   * The list contents are of type {@link com.netxforge.netxscript.Reference}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nodes</em>' containment reference list.
   * @see com.netxforge.netxscript.NetxscriptPackage#getReference_Nodes()
   * @model containment="true"
   * @generated
   */
  EList<Reference> getNodes();

  /**
   * Returns the value of the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' containment reference.
   * @see #setRef(Reference)
   * @see com.netxforge.netxscript.NetxscriptPackage#getReference_Ref()
   * @model containment="true"
   * @generated
   */
  Reference getRef();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.Reference#getRef <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' containment reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Reference value);

} // Reference
