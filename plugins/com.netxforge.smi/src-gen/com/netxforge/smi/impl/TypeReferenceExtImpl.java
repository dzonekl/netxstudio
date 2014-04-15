/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.TypeReference;
import com.netxforge.smi.TypeReferenceExt;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Reference Ext</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.TypeReferenceExtImpl#getParentRef <em>Parent Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.TypeReferenceExtImpl#getChildRef <em>Child Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeReferenceExtImpl extends MinimalEObjectImpl.Container implements TypeReferenceExt
{
  /**
   * The cached value of the '{@link #getParentRef() <em>Parent Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParentRef()
   * @generated
   * @ordered
   */
  protected TypeReference parentRef;

  /**
   * The cached value of the '{@link #getChildRef() <em>Child Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChildRef()
   * @generated
   * @ordered
   */
  protected TypeReference childRef;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeReferenceExtImpl()
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
    return SmiPackage.Literals.TYPE_REFERENCE_EXT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeReference getParentRef()
  {
    return parentRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParentRef(TypeReference newParentRef, NotificationChain msgs)
  {
    TypeReference oldParentRef = parentRef;
    parentRef = newParentRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.TYPE_REFERENCE_EXT__PARENT_REF, oldParentRef, newParentRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParentRef(TypeReference newParentRef)
  {
    if (newParentRef != parentRef)
    {
      NotificationChain msgs = null;
      if (parentRef != null)
        msgs = ((InternalEObject)parentRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.TYPE_REFERENCE_EXT__PARENT_REF, null, msgs);
      if (newParentRef != null)
        msgs = ((InternalEObject)newParentRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.TYPE_REFERENCE_EXT__PARENT_REF, null, msgs);
      msgs = basicSetParentRef(newParentRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.TYPE_REFERENCE_EXT__PARENT_REF, newParentRef, newParentRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeReference getChildRef()
  {
    return childRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChildRef(TypeReference newChildRef, NotificationChain msgs)
  {
    TypeReference oldChildRef = childRef;
    childRef = newChildRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.TYPE_REFERENCE_EXT__CHILD_REF, oldChildRef, newChildRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChildRef(TypeReference newChildRef)
  {
    if (newChildRef != childRef)
    {
      NotificationChain msgs = null;
      if (childRef != null)
        msgs = ((InternalEObject)childRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.TYPE_REFERENCE_EXT__CHILD_REF, null, msgs);
      if (newChildRef != null)
        msgs = ((InternalEObject)newChildRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.TYPE_REFERENCE_EXT__CHILD_REF, null, msgs);
      msgs = basicSetChildRef(newChildRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.TYPE_REFERENCE_EXT__CHILD_REF, newChildRef, newChildRef));
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
      case SmiPackage.TYPE_REFERENCE_EXT__PARENT_REF:
        return basicSetParentRef(null, msgs);
      case SmiPackage.TYPE_REFERENCE_EXT__CHILD_REF:
        return basicSetChildRef(null, msgs);
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
      case SmiPackage.TYPE_REFERENCE_EXT__PARENT_REF:
        return getParentRef();
      case SmiPackage.TYPE_REFERENCE_EXT__CHILD_REF:
        return getChildRef();
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
      case SmiPackage.TYPE_REFERENCE_EXT__PARENT_REF:
        setParentRef((TypeReference)newValue);
        return;
      case SmiPackage.TYPE_REFERENCE_EXT__CHILD_REF:
        setChildRef((TypeReference)newValue);
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
      case SmiPackage.TYPE_REFERENCE_EXT__PARENT_REF:
        setParentRef((TypeReference)null);
        return;
      case SmiPackage.TYPE_REFERENCE_EXT__CHILD_REF:
        setChildRef((TypeReference)null);
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
      case SmiPackage.TYPE_REFERENCE_EXT__PARENT_REF:
        return parentRef != null;
      case SmiPackage.TYPE_REFERENCE_EXT__CHILD_REF:
        return childRef != null;
    }
    return super.eIsSet(featureID);
  }

} //TypeReferenceExtImpl
