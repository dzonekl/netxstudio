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
 *   <li>{@link com.netxforge.netxscript.impl.ReferenceImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.ReferenceImpl#getLeaveRef <em>Leave Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceImpl extends ExpressionImpl implements Reference
{
  /**
   * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNodes()
   * @generated
   * @ordered
   */
  protected EList<Reference> nodes;

  /**
   * The cached value of the '{@link #getLeaveRef() <em>Leave Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeaveRef()
   * @generated
   * @ordered
   */
  protected LeafReference leaveRef;

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
  public EList<Reference> getNodes()
  {
    if (nodes == null)
    {
      nodes = new EObjectContainmentEList<Reference>(Reference.class, this, NetxscriptPackage.REFERENCE__NODES);
    }
    return nodes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LeafReference getLeaveRef()
  {
    return leaveRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeaveRef(LeafReference newLeaveRef, NotificationChain msgs)
  {
    LeafReference oldLeaveRef = leaveRef;
    leaveRef = newLeaveRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetxscriptPackage.REFERENCE__LEAVE_REF, oldLeaveRef, newLeaveRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeaveRef(LeafReference newLeaveRef)
  {
    if (newLeaveRef != leaveRef)
    {
      NotificationChain msgs = null;
      if (leaveRef != null)
        msgs = ((InternalEObject)leaveRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.REFERENCE__LEAVE_REF, null, msgs);
      if (newLeaveRef != null)
        msgs = ((InternalEObject)newLeaveRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.REFERENCE__LEAVE_REF, null, msgs);
      msgs = basicSetLeaveRef(newLeaveRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.REFERENCE__LEAVE_REF, newLeaveRef, newLeaveRef));
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
      case NetxscriptPackage.REFERENCE__NODES:
        return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
      case NetxscriptPackage.REFERENCE__LEAVE_REF:
        return basicSetLeaveRef(null, msgs);
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
      case NetxscriptPackage.REFERENCE__NODES:
        return getNodes();
      case NetxscriptPackage.REFERENCE__LEAVE_REF:
        return getLeaveRef();
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
      case NetxscriptPackage.REFERENCE__NODES:
        getNodes().clear();
        getNodes().addAll((Collection<? extends Reference>)newValue);
        return;
      case NetxscriptPackage.REFERENCE__LEAVE_REF:
        setLeaveRef((LeafReference)newValue);
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
      case NetxscriptPackage.REFERENCE__NODES:
        getNodes().clear();
        return;
      case NetxscriptPackage.REFERENCE__LEAVE_REF:
        setLeaveRef((LeafReference)null);
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
      case NetxscriptPackage.REFERENCE__NODES:
        return nodes != null && !nodes.isEmpty();
      case NetxscriptPackage.REFERENCE__LEAVE_REF:
        return leaveRef != null;
    }
    return super.eIsSet(featureID);
  }

} //ReferenceImpl
