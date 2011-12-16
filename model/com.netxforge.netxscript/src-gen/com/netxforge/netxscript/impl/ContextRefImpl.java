/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.netxforge.netxscript.ContextRef;
import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.RangeRef;
import com.netxforge.netxscript.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.impl.ContextRefImpl#getPrimaryRef <em>Primary Ref</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.ContextRefImpl#getRangeRef <em>Range Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextRefImpl extends ReferenceImpl implements ContextRef
{
  /**
   * The cached value of the '{@link #getPrimaryRef() <em>Primary Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrimaryRef()
   * @generated
   * @ordered
   */
  protected Reference primaryRef;

  /**
   * The cached value of the '{@link #getRangeRef() <em>Range Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRangeRef()
   * @generated
   * @ordered
   */
  protected RangeRef rangeRef;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContextRefImpl()
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
    return NetxscriptPackage.Literals.CONTEXT_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Reference getPrimaryRef()
  {
    return primaryRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrimaryRef(Reference newPrimaryRef, NotificationChain msgs)
  {
    Reference oldPrimaryRef = primaryRef;
    primaryRef = newPrimaryRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetxscriptPackage.CONTEXT_REF__PRIMARY_REF, oldPrimaryRef, newPrimaryRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrimaryRef(Reference newPrimaryRef)
  {
    if (newPrimaryRef != primaryRef)
    {
      NotificationChain msgs = null;
      if (primaryRef != null)
        msgs = ((InternalEObject)primaryRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.CONTEXT_REF__PRIMARY_REF, null, msgs);
      if (newPrimaryRef != null)
        msgs = ((InternalEObject)newPrimaryRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.CONTEXT_REF__PRIMARY_REF, null, msgs);
      msgs = basicSetPrimaryRef(newPrimaryRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.CONTEXT_REF__PRIMARY_REF, newPrimaryRef, newPrimaryRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RangeRef getRangeRef()
  {
    return rangeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRangeRef(RangeRef newRangeRef, NotificationChain msgs)
  {
    RangeRef oldRangeRef = rangeRef;
    rangeRef = newRangeRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetxscriptPackage.CONTEXT_REF__RANGE_REF, oldRangeRef, newRangeRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRangeRef(RangeRef newRangeRef)
  {
    if (newRangeRef != rangeRef)
    {
      NotificationChain msgs = null;
      if (rangeRef != null)
        msgs = ((InternalEObject)rangeRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.CONTEXT_REF__RANGE_REF, null, msgs);
      if (newRangeRef != null)
        msgs = ((InternalEObject)newRangeRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.CONTEXT_REF__RANGE_REF, null, msgs);
      msgs = basicSetRangeRef(newRangeRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.CONTEXT_REF__RANGE_REF, newRangeRef, newRangeRef));
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
      case NetxscriptPackage.CONTEXT_REF__PRIMARY_REF:
        return basicSetPrimaryRef(null, msgs);
      case NetxscriptPackage.CONTEXT_REF__RANGE_REF:
        return basicSetRangeRef(null, msgs);
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
      case NetxscriptPackage.CONTEXT_REF__PRIMARY_REF:
        return getPrimaryRef();
      case NetxscriptPackage.CONTEXT_REF__RANGE_REF:
        return getRangeRef();
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
      case NetxscriptPackage.CONTEXT_REF__PRIMARY_REF:
        setPrimaryRef((Reference)newValue);
        return;
      case NetxscriptPackage.CONTEXT_REF__RANGE_REF:
        setRangeRef((RangeRef)newValue);
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
      case NetxscriptPackage.CONTEXT_REF__PRIMARY_REF:
        setPrimaryRef((Reference)null);
        return;
      case NetxscriptPackage.CONTEXT_REF__RANGE_REF:
        setRangeRef((RangeRef)null);
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
      case NetxscriptPackage.CONTEXT_REF__PRIMARY_REF:
        return primaryRef != null;
      case NetxscriptPackage.CONTEXT_REF__RANGE_REF:
        return rangeRef != null;
    }
    return super.eIsSet(featureID);
  }

} //ContextRefImpl
