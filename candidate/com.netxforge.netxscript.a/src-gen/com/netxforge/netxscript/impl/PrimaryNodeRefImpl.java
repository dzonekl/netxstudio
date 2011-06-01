/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.impl;

import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.PrimaryNodeRef;

import java.util.Collection;

import library.Node;
import library.Resource;

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
 * An implementation of the model object '<em><b>Primary Node Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.impl.PrimaryNodeRefImpl#getDepth <em>Depth</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.PrimaryNodeRefImpl#getResRef <em>Res Ref</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.PrimaryNodeRefImpl#getNodeRef <em>Node Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimaryNodeRefImpl extends NodeDepthImpl implements PrimaryNodeRef
{
  /**
   * The cached value of the '{@link #getDepth() <em>Depth</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDepth()
   * @generated
   * @ordered
   */
  protected EList<PrimaryNodeRef> depth;

  /**
   * The cached value of the '{@link #getResRef() <em>Res Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResRef()
   * @generated
   * @ordered
   */
  protected Resource resRef;

  /**
   * The cached value of the '{@link #getNodeRef() <em>Node Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNodeRef()
   * @generated
   * @ordered
   */
  protected Node nodeRef;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrimaryNodeRefImpl()
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
    return NetxscriptPackage.Literals.PRIMARY_NODE_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PrimaryNodeRef> getDepth()
  {
    if (depth == null)
    {
      depth = new EObjectContainmentEList<PrimaryNodeRef>(PrimaryNodeRef.class, this, NetxscriptPackage.PRIMARY_NODE_REF__DEPTH);
    }
    return depth;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Resource getResRef()
  {
    if (resRef != null && resRef.eIsProxy())
    {
      InternalEObject oldResRef = (InternalEObject)resRef;
      resRef = (Resource)eResolveProxy(oldResRef);
      if (resRef != oldResRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetxscriptPackage.PRIMARY_NODE_REF__RES_REF, oldResRef, resRef));
      }
    }
    return resRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Resource basicGetResRef()
  {
    return resRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResRef(Resource newResRef)
  {
    Resource oldResRef = resRef;
    resRef = newResRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.PRIMARY_NODE_REF__RES_REF, oldResRef, resRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node getNodeRef()
  {
    if (nodeRef != null && nodeRef.eIsProxy())
    {
      InternalEObject oldNodeRef = (InternalEObject)nodeRef;
      nodeRef = (Node)eResolveProxy(oldNodeRef);
      if (nodeRef != oldNodeRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetxscriptPackage.PRIMARY_NODE_REF__NODE_REF, oldNodeRef, nodeRef));
      }
    }
    return nodeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node basicGetNodeRef()
  {
    return nodeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNodeRef(Node newNodeRef)
  {
    Node oldNodeRef = nodeRef;
    nodeRef = newNodeRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.PRIMARY_NODE_REF__NODE_REF, oldNodeRef, nodeRef));
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
      case NetxscriptPackage.PRIMARY_NODE_REF__DEPTH:
        return ((InternalEList<?>)getDepth()).basicRemove(otherEnd, msgs);
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
      case NetxscriptPackage.PRIMARY_NODE_REF__DEPTH:
        return getDepth();
      case NetxscriptPackage.PRIMARY_NODE_REF__RES_REF:
        if (resolve) return getResRef();
        return basicGetResRef();
      case NetxscriptPackage.PRIMARY_NODE_REF__NODE_REF:
        if (resolve) return getNodeRef();
        return basicGetNodeRef();
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
      case NetxscriptPackage.PRIMARY_NODE_REF__DEPTH:
        getDepth().clear();
        getDepth().addAll((Collection<? extends PrimaryNodeRef>)newValue);
        return;
      case NetxscriptPackage.PRIMARY_NODE_REF__RES_REF:
        setResRef((Resource)newValue);
        return;
      case NetxscriptPackage.PRIMARY_NODE_REF__NODE_REF:
        setNodeRef((Node)newValue);
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
      case NetxscriptPackage.PRIMARY_NODE_REF__DEPTH:
        getDepth().clear();
        return;
      case NetxscriptPackage.PRIMARY_NODE_REF__RES_REF:
        setResRef((Resource)null);
        return;
      case NetxscriptPackage.PRIMARY_NODE_REF__NODE_REF:
        setNodeRef((Node)null);
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
      case NetxscriptPackage.PRIMARY_NODE_REF__DEPTH:
        return depth != null && !depth.isEmpty();
      case NetxscriptPackage.PRIMARY_NODE_REF__RES_REF:
        return resRef != null;
      case NetxscriptPackage.PRIMARY_NODE_REF__NODE_REF:
        return nodeRef != null;
    }
    return super.eIsSet(featureID);
  }

} //PrimaryNodeRefImpl
