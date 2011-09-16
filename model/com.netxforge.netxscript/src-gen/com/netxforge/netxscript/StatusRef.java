/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Status Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.StatusRef#getTolerancelevel <em>Tolerancelevel</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxscript.NetxscriptPackage#getStatusRef()
 * @model
 * @generated
 */
public interface StatusRef extends LeafReference
{
  /**
   * Returns the value of the '<em><b>Tolerancelevel</b></em>' attribute.
   * The literals are from the enumeration {@link com.netxforge.netxscript.ToleranceLevel}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tolerancelevel</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tolerancelevel</em>' attribute.
   * @see com.netxforge.netxscript.ToleranceLevel
   * @see #setTolerancelevel(ToleranceLevel)
   * @see com.netxforge.netxscript.NetxscriptPackage#getStatusRef_Tolerancelevel()
   * @model
   * @generated
   */
  ToleranceLevel getTolerancelevel();

  /**
   * Sets the value of the '{@link com.netxforge.netxscript.StatusRef#getTolerancelevel <em>Tolerancelevel</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tolerancelevel</em>' attribute.
   * @see com.netxforge.netxscript.ToleranceLevel
   * @see #getTolerancelevel()
   * @generated
   */
  void setTolerancelevel(ToleranceLevel value);

} // StatusRef
