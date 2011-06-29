/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.impl;

import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.RangeRef;
import com.netxforge.netxscript.ValueKind;
import com.netxforge.netxscript.ValueRange;

import java.math.BigDecimal;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Range Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.impl.RangeRefImpl#getValuerange <em>Valuerange</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.RangeRefImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.RangeRefImpl#getPeriod <em>Period</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RangeRefImpl extends MinimalEObjectImpl.Container implements RangeRef
{
  /**
   * The default value of the '{@link #getValuerange() <em>Valuerange</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValuerange()
   * @generated
   * @ordered
   */
  protected static final ValueRange VALUERANGE_EDEFAULT = ValueRange.METRIC;

  /**
   * The cached value of the '{@link #getValuerange() <em>Valuerange</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValuerange()
   * @generated
   * @ordered
   */
  protected ValueRange valuerange = VALUERANGE_EDEFAULT;

  /**
   * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected static final ValueKind KIND_EDEFAULT = ValueKind.AVG;

  /**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected ValueKind kind = KIND_EDEFAULT;

  /**
   * The default value of the '{@link #getPeriod() <em>Period</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPeriod()
   * @generated
   * @ordered
   */
  protected static final BigDecimal PERIOD_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPeriod() <em>Period</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPeriod()
   * @generated
   * @ordered
   */
  protected BigDecimal period = PERIOD_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RangeRefImpl()
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
    return NetxscriptPackage.Literals.RANGE_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueRange getValuerange()
  {
    return valuerange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValuerange(ValueRange newValuerange)
  {
    ValueRange oldValuerange = valuerange;
    valuerange = newValuerange == null ? VALUERANGE_EDEFAULT : newValuerange;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.RANGE_REF__VALUERANGE, oldValuerange, valuerange));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueKind getKind()
  {
    return kind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKind(ValueKind newKind)
  {
    ValueKind oldKind = kind;
    kind = newKind == null ? KIND_EDEFAULT : newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.RANGE_REF__KIND, oldKind, kind));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal getPeriod()
  {
    return period;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPeriod(BigDecimal newPeriod)
  {
    BigDecimal oldPeriod = period;
    period = newPeriod;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.RANGE_REF__PERIOD, oldPeriod, period));
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
      case NetxscriptPackage.RANGE_REF__VALUERANGE:
        return getValuerange();
      case NetxscriptPackage.RANGE_REF__KIND:
        return getKind();
      case NetxscriptPackage.RANGE_REF__PERIOD:
        return getPeriod();
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
      case NetxscriptPackage.RANGE_REF__VALUERANGE:
        setValuerange((ValueRange)newValue);
        return;
      case NetxscriptPackage.RANGE_REF__KIND:
        setKind((ValueKind)newValue);
        return;
      case NetxscriptPackage.RANGE_REF__PERIOD:
        setPeriod((BigDecimal)newValue);
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
      case NetxscriptPackage.RANGE_REF__VALUERANGE:
        setValuerange(VALUERANGE_EDEFAULT);
        return;
      case NetxscriptPackage.RANGE_REF__KIND:
        setKind(KIND_EDEFAULT);
        return;
      case NetxscriptPackage.RANGE_REF__PERIOD:
        setPeriod(PERIOD_EDEFAULT);
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
      case NetxscriptPackage.RANGE_REF__VALUERANGE:
        return valuerange != VALUERANGE_EDEFAULT;
      case NetxscriptPackage.RANGE_REF__KIND:
        return kind != KIND_EDEFAULT;
      case NetxscriptPackage.RANGE_REF__PERIOD:
        return PERIOD_EDEFAULT == null ? period != null : !PERIOD_EDEFAULT.equals(period);
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
    result.append(" (valuerange: ");
    result.append(valuerange);
    result.append(", kind: ");
    result.append(kind);
    result.append(", period: ");
    result.append(period);
    result.append(')');
    return result.toString();
  }

} //RangeRefImpl
