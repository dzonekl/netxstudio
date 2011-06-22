/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.impl;

import com.netxforge.netxscript.LeafReference;
import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.Reference;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.impl.ReferenceImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.ReferenceImpl#getLeafRef <em>Leaf Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceImpl extends ExpressionImpl implements Reference
{
  /**
   * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChildren()
   * @generated
   * @ordered
   */
  protected EList<Reference> children;

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
  protected ReferenceImpl()
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
    return NetxscriptPackage.Literals.REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Reference> getChildren()
  {
    if (children == null)
    {
      children = new EObjectContainmentEList<Reference>(Reference.class, this, NetxscriptPackage.REFERENCE__CHILDREN);
    }
    return children;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetxscriptPackage.REFERENCE__LEAF_REF, oldLeafRef, newLeafRef);
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
        msgs = ((InternalEObject)leafRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.REFERENCE__LEAF_REF, null, msgs);
      if (newLeafRef != null)
        msgs = ((InternalEObject)newLeafRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.REFERENCE__LEAF_REF, null, msgs);
      msgs = basicSetLeafRef(newLeafRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.REFERENCE__LEAF_REF, newLeafRef, newLeafRef));
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
      case NetxscriptPackage.REFERENCE__CHILDREN:
        return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
      case NetxscriptPackage.REFERENCE__LEAF_REF:
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
      case NetxscriptPackage.REFERENCE__CHILDREN:
        return getChildren();
      case NetxscriptPackage.REFERENCE__LEAF_REF:
        return getLeafRef();
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
      case NetxscriptPackage.REFERENCE__CHILDREN:
        getChildren().clear();
        getChildren().addAll((Collection<? extends Reference>)newValue);
        return;
      case NetxscriptPackage.REFERENCE__LEAF_REF:
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
      case NetxscriptPackage.REFERENCE__CHILDREN:
        getChildren().clear();
        return;
      case NetxscriptPackage.REFERENCE__LEAF_REF:
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
      case NetxscriptPackage.REFERENCE__CHILDREN:
        return children != null && !children.isEmpty();
      case NetxscriptPackage.REFERENCE__LEAF_REF:
        return leafRef != null;
    }
    return super.eIsSet(featureID);
  }

} //ReferenceImpl
