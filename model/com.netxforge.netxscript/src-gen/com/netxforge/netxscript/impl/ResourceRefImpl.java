/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.impl;

import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.ResourceRef;
import com.netxforge.netxscript.ValueRange;

import com.netxforge.netxstudio.library.NetXResource;

import org.eclipse.emf.common.notify.Notification;

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
 *   <li>{@link com.netxforge.netxscript.impl.ResourceRefImpl#getValuerange <em>Valuerange</em>}</li>
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
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.RESOURCE_REF__VALUERANGE, oldValuerange, valuerange));
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
      case NetxscriptPackage.RESOURCE_REF__VALUERANGE:
        return getValuerange();
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
      case NetxscriptPackage.RESOURCE_REF__VALUERANGE:
        setValuerange((ValueRange)newValue);
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
      case NetxscriptPackage.RESOURCE_REF__VALUERANGE:
        setValuerange(VALUERANGE_EDEFAULT);
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
      case NetxscriptPackage.RESOURCE_REF__VALUERANGE:
        return valuerange != VALUERANGE_EDEFAULT;
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
    result.append(')');
    return result.toString();
  }

} //ResourceRefImpl
