/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import com.netxforge.netxstudio.library.NetXResource;

import java.math.BigDecimal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.ResourceRef#getResource <em>Resource</em>}</li>
 *   <li>{@link com.netxforge.netxscript.ResourceRef#getValuerange <em>Valuerange</em>}</li>
 *   <li>{@link com.netxforge.netxscript.ResourceRef#getKind <em>Kind</em>}</li>
 *   <li>{@link com.netxforge.netxscript.ResourceRef#getPeriod <em>Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getResourceRef()
 * @model
 * @generated
 */
public interface ResourceRef extends LeafReference
{
  /**
   * Returns the value of the '<em><b>Resource</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Resource</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Resource</em>' reference.
   * @see #setResource(NetXResource)
   * @see com.netxforge.netxscript.NetxscriptPackage#getResourceRef_Resource()
   * @model
   * @generated
   */
  NetXResource getResource();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.ResourceRef#getResource <em>Resource</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Resource</em>' reference.
   * @see #getResource()
   * @generated
   */
  void setResource(NetXResource value);

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
   * @see com.netxforge.netxscript.NetxscriptPackage#getResourceRef_Valuerange()
   * @model
   * @generated
   */
  ValueRange getValuerange();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.ResourceRef#getValuerange <em>Valuerange</em>}' attribute.
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
   * @see com.netxforge.netxscript.NetxscriptPackage#getResourceRef_Kind()
   * @model
   * @generated
   */
  ValueKind getKind();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.ResourceRef#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see com.netxforge.netxscript.ValueKind
   * @see #getKind()
   * @generated
   */
  void setKind(ValueKind value);

  /**
   * Returns the value of the '<em><b>Period</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Period</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Period</em>' attribute.
   * @see #setPeriod(BigDecimal)
   * @see com.netxforge.netxscript.NetxscriptPackage#getResourceRef_Period()
   * @model
   * @generated
   */
  BigDecimal getPeriod();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.ResourceRef#getPeriod <em>Period</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Period</em>' attribute.
   * @see #getPeriod()
   * @generated
   */
  void setPeriod(BigDecimal value);

} // ResourceRef
