/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interval</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.Interval#getInterval <em>Interval</em>}</li>
 *   <li>{@link com.netxforge.netxscript.Interval#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getInterval()
 * @model
 * @generated
 */
public interface Interval extends EObject
{
  /**
   * Returns the value of the '<em><b>Interval</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interval</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interval</em>' attribute.
   * @see #setInterval(BigDecimal)
   * @see com.netxforge.netxscript.NetxscriptPackage#getInterval_Interval()
   * @model
   * @generated
   */
  BigDecimal getInterval();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.Interval#getInterval <em>Interval</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Interval</em>' attribute.
   * @see #getInterval()
   * @generated
   */
  void setInterval(BigDecimal value);

  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link com.netxforge.netxscript.IntervalKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see com.netxforge.netxscript.IntervalKind
   * @see #setKind(IntervalKind)
   * @see com.netxforge.netxscript.NetxscriptPackage#getInterval_Kind()
   * @model
   * @generated
   */
  IntervalKind getKind();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.Interval#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see com.netxforge.netxscript.IntervalKind
   * @see #getKind()
   * @generated
   */
  void setKind(IntervalKind value);

} // Interval
