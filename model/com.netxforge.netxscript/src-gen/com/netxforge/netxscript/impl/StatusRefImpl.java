/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.StatusRef;
import com.netxforge.netxscript.ToleranceLevel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Status Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.impl.StatusRefImpl#getTolerancelevel <em>Tolerancelevel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatusRefImpl extends LeafReferenceImpl implements StatusRef
{
  /**
   * The default value of the '{@link #getTolerancelevel() <em>Tolerancelevel</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTolerancelevel()
   * @generated
   * @ordered
   */
  protected static final ToleranceLevel TOLERANCELEVEL_EDEFAULT = ToleranceLevel.RED;

  /**
   * The cached value of the '{@link #getTolerancelevel() <em>Tolerancelevel</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTolerancelevel()
   * @generated
   * @ordered
   */
  protected ToleranceLevel tolerancelevel = TOLERANCELEVEL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StatusRefImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return NetxscriptPackage.Literals.STATUS_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ToleranceLevel getTolerancelevel()
  {
    return tolerancelevel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTolerancelevel(ToleranceLevel newTolerancelevel)
  {
    ToleranceLevel oldTolerancelevel = tolerancelevel;
    tolerancelevel = newTolerancelevel == null ? TOLERANCELEVEL_EDEFAULT : newTolerancelevel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.STATUS_REF__TOLERANCELEVEL, oldTolerancelevel, tolerancelevel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case NetxscriptPackage.STATUS_REF__TOLERANCELEVEL:
        return getTolerancelevel();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case NetxscriptPackage.STATUS_REF__TOLERANCELEVEL:
        setTolerancelevel((ToleranceLevel)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case NetxscriptPackage.STATUS_REF__TOLERANCELEVEL:
        setTolerancelevel(TOLERANCELEVEL_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case NetxscriptPackage.STATUS_REF__TOLERANCELEVEL:
        return tolerancelevel != TOLERANCELEVEL_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (tolerancelevel: ");
    result.append(tolerancelevel);
    result.append(')');
    return result.toString();
  }

} //StatusRefImpl
