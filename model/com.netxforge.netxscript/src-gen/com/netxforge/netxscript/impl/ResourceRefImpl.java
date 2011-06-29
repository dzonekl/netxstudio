/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.impl;

import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.RangeRef;
import com.netxforge.netxscript.ResourceRef;

import com.netxforge.netxstudio.library.NetXResource;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.impl.ResourceRefImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.ResourceRefImpl#getRangeRef <em>Range Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceRefImpl extends LeafReferenceImpl implements ResourceRef
{
  /**
   * The cached value of the '{@link #getResource() <em>Resource</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResource()
   * @generated
   * @ordered
   */
  protected NetXResource resource;

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
  protected ResourceRefImpl()
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
    return NetxscriptPackage.Literals.RESOURCE_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NetXResource getResource()
  {
    if (resource != null && resource.eIsProxy())
    {
      InternalEObject oldResource = (InternalEObject)resource;
      resource = (NetXResource)eResolveProxy(oldResource);
      if (resource != oldResource)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetxscriptPackage.RESOURCE_REF__RESOURCE, oldResource, resource));
      }
    }
    return resource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NetXResource basicGetResource()
  {
    return resource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResource(NetXResource newResource)
  {
    NetXResource oldResource = resource;
    resource = newResource;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.RESOURCE_REF__RESOURCE, oldResource, resource));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetxscriptPackage.RESOURCE_REF__RANGE_REF, oldRangeRef, newRangeRef);
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
        msgs = ((InternalEObject)rangeRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.RESOURCE_REF__RANGE_REF, null, msgs);
      if (newRangeRef != null)
        msgs = ((InternalEObject)newRangeRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.RESOURCE_REF__RANGE_REF, null, msgs);
      msgs = basicSetRangeRef(newRangeRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.RESOURCE_REF__RANGE_REF, newRangeRef, newRangeRef));
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
      case NetxscriptPackage.RESOURCE_REF__RANGE_REF:
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
      case NetxscriptPackage.RESOURCE_REF__RESOURCE:
        if (resolve) return getResource();
        return basicGetResource();
      case NetxscriptPackage.RESOURCE_REF__RANGE_REF:
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
      case NetxscriptPackage.RESOURCE_REF__RESOURCE:
        setResource((NetXResource)newValue);
        return;
      case NetxscriptPackage.RESOURCE_REF__RANGE_REF:
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
      case NetxscriptPackage.RESOURCE_REF__RESOURCE:
        setResource((NetXResource)null);
        return;
      case NetxscriptPackage.RESOURCE_REF__RANGE_REF:
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
      case NetxscriptPackage.RESOURCE_REF__RESOURCE:
        return resource != null;
      case NetxscriptPackage.RESOURCE_REF__RANGE_REF:
        return rangeRef != null;
    }
    return super.eIsSet(featureID);
  }

} //ResourceRefImpl
