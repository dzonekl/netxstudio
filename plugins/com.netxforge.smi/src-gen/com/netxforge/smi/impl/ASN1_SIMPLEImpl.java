/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.ASN1_SIMPLE;
import com.netxforge.smi.ASN1_SUBTYPE;
import com.netxforge.smi.SmiPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ASN1 SIMPLE</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.ASN1_SIMPLEImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ASN1_SIMPLEImpl#getValuePairs <em>Value Pairs</em>}</li>
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
  protected ASN1_SUBTYPE constraint;

  /**
   * The cached value of the '{@link #getValuePairs() <em>Value Pairs</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValuePairs()
   * @generated
   * @ordered
   */
  protected EList<String> valuePairs;

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
  public ASN1_SUBTYPE getConstraint()
  {
    return constraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConstraint(ASN1_SUBTYPE newConstraint, NotificationChain msgs)
  {
    ASN1_SUBTYPE oldConstraint = constraint;
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
  public void setConstraint(ASN1_SUBTYPE newConstraint)
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
  public EList<String> getValuePairs()
  {
    if (valuePairs == null)
    {
      valuePairs = new EDataTypeEList<String>(String.class, this, SmiPackage.ASN1_SIMPLE__VALUE_PAIRS);
    }
    return valuePairs;
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
      case SmiPackage.ASN1_SIMPLE__VALUE_PAIRS:
        return getValuePairs();
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
        setConstraint((ASN1_SUBTYPE)newValue);
        return;
      case SmiPackage.ASN1_SIMPLE__VALUE_PAIRS:
        getValuePairs().clear();
        getValuePairs().addAll((Collection<? extends String>)newValue);
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
        setConstraint((ASN1_SUBTYPE)null);
        return;
      case SmiPackage.ASN1_SIMPLE__VALUE_PAIRS:
        getValuePairs().clear();
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
      case SmiPackage.ASN1_SIMPLE__VALUE_PAIRS:
        return valuePairs != null && !valuePairs.isEmpty();
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
    result.append(" (valuePairs: ");
    result.append(valuePairs);
    result.append(')');
    return result.toString();
  }

} //ASN1_SIMPLEImpl
