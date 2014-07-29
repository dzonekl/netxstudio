/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.Value;
import com.netxforge.smi.ValueAssignment;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.ValueAssignmentImpl#getValueNotation <em>Value Notation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueAssignmentImpl extends MinimalEObjectImpl.Container implements ValueAssignment
{
  /**
   * The cached value of the '{@link #getValueNotation() <em>Value Notation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueNotation()
   * @generated
   * @ordered
   */
  protected Value valueNotation;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ValueAssignmentImpl()
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
    return SmiPackage.Literals.VALUE_ASSIGNMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Value getValueNotation()
  {
    return valueNotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValueNotation(Value newValueNotation, NotificationChain msgs)
  {
    Value oldValueNotation = valueNotation;
    valueNotation = newValueNotation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE_ASSIGNMENT__VALUE_NOTATION, oldValueNotation, newValueNotation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValueNotation(Value newValueNotation)
  {
    if (newValueNotation != valueNotation)
    {
      NotificationChain msgs = null;
      if (valueNotation != null)
        msgs = ((InternalEObject)valueNotation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.VALUE_ASSIGNMENT__VALUE_NOTATION, null, msgs);
      if (newValueNotation != null)
        msgs = ((InternalEObject)newValueNotation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.VALUE_ASSIGNMENT__VALUE_NOTATION, null, msgs);
      msgs = basicSetValueNotation(newValueNotation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE_ASSIGNMENT__VALUE_NOTATION, newValueNotation, newValueNotation));
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
      case SmiPackage.VALUE_ASSIGNMENT__VALUE_NOTATION:
        return basicSetValueNotation(null, msgs);
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
      case SmiPackage.VALUE_ASSIGNMENT__VALUE_NOTATION:
        return getValueNotation();
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
      case SmiPackage.VALUE_ASSIGNMENT__VALUE_NOTATION:
        setValueNotation((Value)newValue);
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
      case SmiPackage.VALUE_ASSIGNMENT__VALUE_NOTATION:
        setValueNotation((Value)null);
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
      case SmiPackage.VALUE_ASSIGNMENT__VALUE_NOTATION:
        return valueNotation != null;
    }
    return super.eIsSet(featureID);
  }

} //ValueAssignmentImpl
