/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.BracedObjectReference;
import com.netxforge.smi.ObjectReferenceable;
import com.netxforge.smi.SmiPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Braced Object Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.BracedObjectReferenceImpl#getObjectRef <em>Object Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BracedObjectReferenceImpl extends MinimalEObjectImpl.Container implements BracedObjectReference
{
  /**
   * The cached value of the '{@link #getObjectRef() <em>Object Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjectRef()
   * @generated
   * @ordered
   */
  protected ObjectReferenceable objectRef;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BracedObjectReferenceImpl()
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
    return SmiPackage.Literals.BRACED_OBJECT_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectReferenceable getObjectRef()
  {
    if (objectRef != null && objectRef.eIsProxy())
    {
      InternalEObject oldObjectRef = (InternalEObject)objectRef;
      objectRef = (ObjectReferenceable)eResolveProxy(oldObjectRef);
      if (objectRef != oldObjectRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmiPackage.BRACED_OBJECT_REFERENCE__OBJECT_REF, oldObjectRef, objectRef));
      }
    }
    return objectRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectReferenceable basicGetObjectRef()
  {
    return objectRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObjectRef(ObjectReferenceable newObjectRef)
  {
    ObjectReferenceable oldObjectRef = objectRef;
    objectRef = newObjectRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.BRACED_OBJECT_REFERENCE__OBJECT_REF, oldObjectRef, objectRef));
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
      case SmiPackage.BRACED_OBJECT_REFERENCE__OBJECT_REF:
        if (resolve) return getObjectRef();
        return basicGetObjectRef();
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
      case SmiPackage.BRACED_OBJECT_REFERENCE__OBJECT_REF:
        setObjectRef((ObjectReferenceable)newValue);
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
      case SmiPackage.BRACED_OBJECT_REFERENCE__OBJECT_REF:
        setObjectRef((ObjectReferenceable)null);
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
      case SmiPackage.BRACED_OBJECT_REFERENCE__OBJECT_REF:
        return objectRef != null;
    }
    return super.eIsSet(featureID);
  }

} //BracedObjectReferenceImpl
