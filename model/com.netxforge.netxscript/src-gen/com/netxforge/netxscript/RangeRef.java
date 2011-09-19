/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.RangeRef#getValuerange <em>Valuerange</em>}</li>
 *   <li>{@link com.netxforge.netxscript.RangeRef#getKind <em>Kind</em>}</li>
 *   <li>{@link com.netxforge.netxscript.RangeRef#getInterval <em>Interval</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getRangeRef()
 * @model
 * @generated
 */
public interface RangeRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Valuerange</b></em>' attribute.
   * The literals are from the enumeration {@link com.netxforge.netxscript.ValueRange}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Valuerange</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Valuerange</em>' attribute.
   * @see com.netxforge.netxscript.ValueRange
   * @see #setValuerange(ValueRange)
   * @see com.netxforge.netxscript.NetxscriptPackage#getRangeRef_Valuerange()
   * @model
   * @generated
   */
  ValueRange getValuerange();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.RangeRef#getValuerange <em>Valuerange</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Valuerange</em>' attribute.
   * @see com.netxforge.netxscript.ValueRange
   * @see #getValuerange()
   * @generated
   */
  void setValuerange(ValueRange value);

  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link com.netxforge.netxscript.ValueKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see com.netxforge.netxscript.ValueKind
   * @see #setKind(ValueKind)
   * @see com.netxforge.netxscript.NetxscriptPackage#getRangeRef_Kind()
   * @model
   * @generated
   */
  ValueKind getKind();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.RangeRef#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see com.netxforge.netxscript.ValueKind
   * @see #getKind()
   * @generated
   */
  void setKind(ValueKind value);

  /**
   * Returns the value of the '<em><b>Interval</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interval</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interval</em>' containment reference.
   * @see #setInterval(Interval)
   * @see com.netxforge.netxscript.NetxscriptPackage#getRangeRef_Interval()
   * @model containment="true"
   * @generated
   */
  Interval getInterval();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.RangeRef#getInterval <em>Interval</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Interval</em>' containment reference.
   * @see #getInterval()
   * @generated
   */
  void setInterval(Interval value);

} // RangeRef
