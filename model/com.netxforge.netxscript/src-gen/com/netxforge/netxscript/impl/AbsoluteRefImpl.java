/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.impl;

import com.netxforge.netxscript.AbsoluteRef;
import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.Reference;

import com.netxforge.netxstudio.library.NodeType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Absolute Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.impl.AbsoluteRefImpl#getNodetypeRef <em>Nodetype Ref</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.AbsoluteRefImpl#getPrimaryRef <em>Primary Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbsoluteRefImpl extends ReferenceImpl implements AbsoluteRef
{
  /**
   * The cached value of the '{@link #getNodetypeRef() <em>Nodetype Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNodetypeRef()
   * @generated
   * @ordered
   */
  protected NodeType nodetypeRef;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbsoluteRefImpl()
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
    return NetxscriptPackage.Literals.ABSOLUTE_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeType getNodetypeRef()
  {
    if (nodetypeRef != null && nodetypeRef.eIsProxy())
    {
      InternalEObject oldNodetypeRef = (InternalEObject)nodetypeRef;
      nodetypeRef = (NodeType)eResolveProxy(oldNodetypeRef);
      if (nodetypeRef != oldNodetypeRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetxscriptPackage.ABSOLUTE_REF__NODETYPE_REF, oldNodetypeRef, nodetypeRef));
      }
    }
    return nodetypeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeType basicGetNodetypeRef()
  {
    return nodetypeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNodetypeRef(NodeType newNodetypeRef)
  {
    NodeType oldNodetypeRef = nodetypeRef;
    nodetypeRef = newNodetypeRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.ABSOLUTE_REF__NODETYPE_REF, oldNodetypeRef, nodetypeRef));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetxscriptPackage.ABSOLUTE_REF__PRIMARY_REF, oldPrimaryRef, newPrimaryRef);
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
        msgs = ((InternalEObject)primaryRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.ABSOLUTE_REF__PRIMARY_REF, null, msgs);
      if (newPrimaryRef != null)
        msgs = ((InternalEObject)newPrimaryRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.ABSOLUTE_REF__PRIMARY_REF, null, msgs);
      msgs = basicSetPrimaryRef(newPrimaryRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.ABSOLUTE_REF__PRIMARY_REF, newPrimaryRef, newPrimaryRef));
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
      case NetxscriptPackage.ABSOLUTE_REF__PRIMARY_REF:
        return basicSetPrimaryRef(null, msgs);
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
      case NetxscriptPackage.ABSOLUTE_REF__NODETYPE_REF:
        if (resolve) return getNodetypeRef();
        return basicGetNodetypeRef();
      case NetxscriptPackage.ABSOLUTE_REF__PRIMARY_REF:
        return getPrimaryRef();
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
      case NetxscriptPackage.ABSOLUTE_REF__NODETYPE_REF:
        setNodetypeRef((NodeType)newValue);
        return;
      case NetxscriptPackage.ABSOLUTE_REF__PRIMARY_REF:
        setPrimaryRef((Reference)newValue);
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
      case NetxscriptPackage.ABSOLUTE_REF__NODETYPE_REF:
        setNodetypeRef((NodeType)null);
        return;
      case NetxscriptPackage.ABSOLUTE_REF__PRIMARY_REF:
        setPrimaryRef((Reference)null);
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
      case NetxscriptPackage.ABSOLUTE_REF__NODETYPE_REF:
        return nodetypeRef != null;
      case NetxscriptPackage.ABSOLUTE_REF__PRIMARY_REF:
        return primaryRef != null;
    }
    return super.eIsSet(featureID);
  }

} //AbsoluteRefImpl
