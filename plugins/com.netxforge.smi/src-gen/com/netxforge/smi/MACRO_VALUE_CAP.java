/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MACRO VALUE CAP</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.MACRO_VALUE_CAP#getValue <em>Value</em>}</li>
 *   <li>{@link com.netxforge.smi.MACRO_VALUE_CAP#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getMACRO_VALUE_CAP()
 * @model
 * @generated
 */
public interface MACRO_VALUE_CAP extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see com.netxforge.smi.SmiPackage#getMACRO_VALUE_CAP_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link com.netxforge.smi.MACRO_VALUE_CAP#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Literal</b></em>' attribute.
   * The literals are from the enumeration {@link com.netxforge.smi.VALUE_CAP_LITERALS}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Literal</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literal</em>' attribute.
   * @see com.netxforge.smi.VALUE_CAP_LITERALS
   * @see #setLiteral(VALUE_CAP_LITERALS)
   * @see com.netxforge.smi.SmiPackage#getMACRO_VALUE_CAP_Literal()
   * @model
   * @generated
   */
  VALUE_CAP_LITERALS getLiteral();

  /**
   * Sets the value of the '{@link com.netxforge.smi.MACRO_VALUE_CAP#getLiteral <em>Literal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Literal</em>' attribute.
   * @see com.netxforge.smi.VALUE_CAP_LITERALS
   * @see #getLiteral()
   * @generated
   */
  void setLiteral(VALUE_CAP_LITERALS value);

} // MACRO_VALUE_CAP
