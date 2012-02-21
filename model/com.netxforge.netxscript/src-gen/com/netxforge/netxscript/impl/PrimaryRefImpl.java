/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.impl;

import com.netxforge.netxscript.LeafReference;
import com.netxforge.netxscript.Navigation;
import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.PrimaryRef;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primary Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.impl.PrimaryRefImpl#getNavigation <em>Navigation</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.PrimaryRefImpl#getLeafRef <em>Leaf Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimaryRefImpl extends MinimalEObjectImpl.Container implements PrimaryRef
{
  /**
   * The cached value of the '{@link #getNavigation() <em>Navigation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNavigation()
   * @generated
   * @ordered
   */
  protected Navigation navigation;

  /**
   * The cached value of the '{@link #getLeafRef() <em>Leaf Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeafRef()
   * @generated
   * @ordered
   */
  protected LeafReference leafRef;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrimaryRefImpl()
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
    return NetxscriptPackage.Literals.PRIMARY_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Navigation getNavigation()
  {
    return navigation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNavigation(Navigation newNavigation, NotificationChain msgs)
  {
    Navigation oldNavigation = navigation;
    navigation = newNavigation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetxscriptPackage.PRIMARY_REF__NAVIGATION, oldNavigation, newNavigation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNavigation(Navigation newNavigation)
  {
    if (newNavigation != navigation)
    {
      NotificationChain msgs = null;
      if (navigation != null)
        msgs = ((InternalEObject)navigation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.PRIMARY_REF__NAVIGATION, null, msgs);
      if (newNavigation != null)
        msgs = ((InternalEObject)newNavigation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.PRIMARY_REF__NAVIGATION, null, msgs);
      msgs = basicSetNavigation(newNavigation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.PRIMARY_REF__NAVIGATION, newNavigation, newNavigation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LeafReference getLeafRef()
  {
    return leafRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeafRef(LeafReference newLeafRef, NotificationChain msgs)
  {
    LeafReference oldLeafRef = leafRef;
    leafRef = newLeafRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetxscriptPackage.PRIMARY_REF__LEAF_REF, oldLeafRef, newLeafRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeafRef(LeafReference newLeafRef)
  {
    if (newLeafRef != leafRef)
    {
      NotificationChain msgs = null;
      if (leafRef != null)
        msgs = ((InternalEObject)leafRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.PRIMARY_REF__LEAF_REF, null, msgs);
      if (newLeafRef != null)
        msgs = ((InternalEObject)newLeafRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.PRIMARY_REF__LEAF_REF, null, msgs);
      msgs = basicSetLeafRef(newLeafRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.PRIMARY_REF__LEAF_REF, newLeafRef, newLeafRef));
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
      case NetxscriptPackage.PRIMARY_REF__NAVIGATION:
        return basicSetNavigation(null, msgs);
      case NetxscriptPackage.PRIMARY_REF__LEAF_REF:
        return basicSetLeafRef(null, msgs);
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
      case NetxscriptPackage.PRIMARY_REF__NAVIGATION:
        return getNavigation();
      case NetxscriptPackage.PRIMARY_REF__LEAF_REF:
        return getLeafRef();
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
      case NetxscriptPackage.PRIMARY_REF__NAVIGATION:
        setNavigation((Navigation)newValue);
        return;
      case NetxscriptPackage.PRIMARY_REF__LEAF_REF:
        setLeafRef((LeafReference)newValue);
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
      case NetxscriptPackage.PRIMARY_REF__NAVIGATION:
        setNavigation((Navigation)null);
        return;
      case NetxscriptPackage.PRIMARY_REF__LEAF_REF:
        setLeafRef((LeafReference)null);
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
      case NetxscriptPackage.PRIMARY_REF__NAVIGATION:
        return navigation != null;
      case NetxscriptPackage.PRIMARY_REF__LEAF_REF:
        return leafRef != null;
    }
    return super.eIsSet(featureID);
  }

} //PrimaryRefImpl
