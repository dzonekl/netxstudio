/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.MACRO_VALUE_CAP;
import com.netxforge.smi.MACRO_VALUE_TYPE;
import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.UpdateType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MACRO VALUE TYPE</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.MACRO_VALUE_TYPEImpl#getValLiteral <em>Val Literal</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.MACRO_VALUE_TYPEImpl#getUpdate <em>Update</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MACRO_VALUE_TYPEImpl extends MinimalEObjectImpl.Container implements MACRO_VALUE_TYPE
{
  /**
   * The cached value of the '{@link #getValLiteral() <em>Val Literal</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValLiteral()
   * @generated
   * @ordered
   */
  protected MACRO_VALUE_CAP valLiteral;

  /**
   * The cached value of the '{@link #getUpdate() <em>Update</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpdate()
   * @generated
   * @ordered
   */
  protected UpdateType update;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MACRO_VALUE_TYPEImpl()
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
    return SmiPackage.Literals.MACRO_VALUE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MACRO_VALUE_CAP getValLiteral()
  {
    return valLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValLiteral(MACRO_VALUE_CAP newValLiteral, NotificationChain msgs)
  {
    MACRO_VALUE_CAP oldValLiteral = valLiteral;
    valLiteral = newValLiteral;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.MACRO_VALUE_TYPE__VAL_LITERAL, oldValLiteral, newValLiteral);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValLiteral(MACRO_VALUE_CAP newValLiteral)
  {
    if (newValLiteral != valLiteral)
    {
      NotificationChain msgs = null;
      if (valLiteral != null)
        msgs = ((InternalEObject)valLiteral).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.MACRO_VALUE_TYPE__VAL_LITERAL, null, msgs);
      if (newValLiteral != null)
        msgs = ((InternalEObject)newValLiteral).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.MACRO_VALUE_TYPE__VAL_LITERAL, null, msgs);
      msgs = basicSetValLiteral(newValLiteral, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.MACRO_VALUE_TYPE__VAL_LITERAL, newValLiteral, newValLiteral));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UpdateType getUpdate()
  {
    return update;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUpdate(UpdateType newUpdate, NotificationChain msgs)
  {
    UpdateType oldUpdate = update;
    update = newUpdate;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.MACRO_VALUE_TYPE__UPDATE, oldUpdate, newUpdate);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpdate(UpdateType newUpdate)
  {
    if (newUpdate != update)
    {
      NotificationChain msgs = null;
      if (update != null)
        msgs = ((InternalEObject)update).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.MACRO_VALUE_TYPE__UPDATE, null, msgs);
      if (newUpdate != null)
        msgs = ((InternalEObject)newUpdate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.MACRO_VALUE_TYPE__UPDATE, null, msgs);
      msgs = basicSetUpdate(newUpdate, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.MACRO_VALUE_TYPE__UPDATE, newUpdate, newUpdate));
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
      case SmiPackage.MACRO_VALUE_TYPE__VAL_LITERAL:
        return basicSetValLiteral(null, msgs);
      case SmiPackage.MACRO_VALUE_TYPE__UPDATE:
        return basicSetUpdate(null, msgs);
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
      case SmiPackage.MACRO_VALUE_TYPE__VAL_LITERAL:
        return getValLiteral();
      case SmiPackage.MACRO_VALUE_TYPE__UPDATE:
        return getUpdate();
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
      case SmiPackage.MACRO_VALUE_TYPE__VAL_LITERAL:
        setValLiteral((MACRO_VALUE_CAP)newValue);
        return;
      case SmiPackage.MACRO_VALUE_TYPE__UPDATE:
        setUpdate((UpdateType)newValue);
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
      case SmiPackage.MACRO_VALUE_TYPE__VAL_LITERAL:
        setValLiteral((MACRO_VALUE_CAP)null);
        return;
      case SmiPackage.MACRO_VALUE_TYPE__UPDATE:
        setUpdate((UpdateType)null);
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
      case SmiPackage.MACRO_VALUE_TYPE__VAL_LITERAL:
        return valLiteral != null;
      case SmiPackage.MACRO_VALUE_TYPE__UPDATE:
        return update != null;
    }
    return super.eIsSet(featureID);
  }

} //MACRO_VALUE_TYPEImpl
