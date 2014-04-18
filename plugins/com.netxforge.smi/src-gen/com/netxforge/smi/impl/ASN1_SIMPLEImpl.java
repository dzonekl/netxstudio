/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.ASN1_RANGE;
import com.netxforge.smi.ASN1_SIMPLE;
import com.netxforge.smi.SmiPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ASN1 SIMPLE</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.ASN1_SIMPLEImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ASN1_SIMPLEImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ASN1_SIMPLEImpl#getRange <em>Range</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ASN1_SIMPLEImpl#getRanges <em>Ranges</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ASN1_SIMPLEImpl extends ASN1_TYPEImpl implements ASN1_SIMPLE
{
  /**
   * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraint()
   * @generated
   * @ordered
   */
  protected ASN1_SIMPLE constraint;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getRange() <em>Range</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRange()
   * @generated
   * @ordered
   */
  protected ASN1_RANGE range;

  /**
   * The cached value of the '{@link #getRanges() <em>Ranges</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRanges()
   * @generated
   * @ordered
   */
  protected EList<ASN1_RANGE> ranges;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ASN1_SIMPLEImpl()
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
    return SmiPackage.Literals.ASN1_SIMPLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASN1_SIMPLE getConstraint()
  {
    return constraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConstraint(ASN1_SIMPLE newConstraint, NotificationChain msgs)
  {
    ASN1_SIMPLE oldConstraint = constraint;
    constraint = newConstraint;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.ASN1_SIMPLE__CONSTRAINT, oldConstraint, newConstraint);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstraint(ASN1_SIMPLE newConstraint)
  {
    if (newConstraint != constraint)
    {
      NotificationChain msgs = null;
      if (constraint != null)
        msgs = ((InternalEObject)constraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ASN1_SIMPLE__CONSTRAINT, null, msgs);
      if (newConstraint != null)
        msgs = ((InternalEObject)newConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ASN1_SIMPLE__CONSTRAINT, null, msgs);
      msgs = basicSetConstraint(newConstraint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.ASN1_SIMPLE__CONSTRAINT, newConstraint, newConstraint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.ASN1_SIMPLE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASN1_RANGE getRange()
  {
    return range;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRange(ASN1_RANGE newRange, NotificationChain msgs)
  {
    ASN1_RANGE oldRange = range;
    range = newRange;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.ASN1_SIMPLE__RANGE, oldRange, newRange);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRange(ASN1_RANGE newRange)
  {
    if (newRange != range)
    {
      NotificationChain msgs = null;
      if (range != null)
        msgs = ((InternalEObject)range).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ASN1_SIMPLE__RANGE, null, msgs);
      if (newRange != null)
        msgs = ((InternalEObject)newRange).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ASN1_SIMPLE__RANGE, null, msgs);
      msgs = basicSetRange(newRange, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.ASN1_SIMPLE__RANGE, newRange, newRange));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ASN1_RANGE> getRanges()
  {
    if (ranges == null)
    {
      ranges = new EObjectContainmentEList<ASN1_RANGE>(ASN1_RANGE.class, this, SmiPackage.ASN1_SIMPLE__RANGES);
    }
    return ranges;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SmiPackage.ASN1_SIMPLE__CONSTRAINT:
        return basicSetConstraint(null, msgs);
      case SmiPackage.ASN1_SIMPLE__RANGE:
        return basicSetRange(null, msgs);
      case SmiPackage.ASN1_SIMPLE__RANGES:
        return ((InternalEList<?>)getRanges()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case SmiPackage.ASN1_SIMPLE__CONSTRAINT:
        return getConstraint();
      case SmiPackage.ASN1_SIMPLE__NAME:
        return getName();
      case SmiPackage.ASN1_SIMPLE__RANGE:
        return getRange();
      case SmiPackage.ASN1_SIMPLE__RANGES:
        return getRanges();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SmiPackage.ASN1_SIMPLE__CONSTRAINT:
        setConstraint((ASN1_SIMPLE)newValue);
        return;
      case SmiPackage.ASN1_SIMPLE__NAME:
        setName((String)newValue);
        return;
      case SmiPackage.ASN1_SIMPLE__RANGE:
        setRange((ASN1_RANGE)newValue);
        return;
      case SmiPackage.ASN1_SIMPLE__RANGES:
        getRanges().clear();
        getRanges().addAll((Collection<? extends ASN1_RANGE>)newValue);
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
      case SmiPackage.ASN1_SIMPLE__CONSTRAINT:
        setConstraint((ASN1_SIMPLE)null);
        return;
      case SmiPackage.ASN1_SIMPLE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SmiPackage.ASN1_SIMPLE__RANGE:
        setRange((ASN1_RANGE)null);
        return;
      case SmiPackage.ASN1_SIMPLE__RANGES:
        getRanges().clear();
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
      case SmiPackage.ASN1_SIMPLE__CONSTRAINT:
        return constraint != null;
      case SmiPackage.ASN1_SIMPLE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SmiPackage.ASN1_SIMPLE__RANGE:
        return range != null;
      case SmiPackage.ASN1_SIMPLE__RANGES:
        return ranges != null && !ranges.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ASN1_SIMPLEImpl
