/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.impl;

import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.NodeRef;
import com.netxforge.netxscript.PrimaryRef;

import com.netxforge.netxstudio.operators.Node;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.impl.NodeRefImpl#getNode <em>Node</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.NodeRefImpl#getPrimaryRef <em>Primary Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeRefImpl extends ReferenceImpl implements NodeRef
{
  /**
   * The cached value of the '{@link #getNode() <em>Node</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNode()
   * @generated
   * @ordered
   */
  protected Node node;

  /**
   * The cached value of the '{@link #getPrimaryRef() <em>Primary Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrimaryRef()
   * @generated
   * @ordered
   */
  protected PrimaryRef primaryRef;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NodeRefImpl()
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
    return NetxscriptPackage.Literals.NODE_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node getNode()
  {
    if (node != null && ((EObject)node).eIsProxy())
    {
      InternalEObject oldNode = (InternalEObject)node;
      node = (Node)eResolveProxy(oldNode);
      if (node != oldNode)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetxscriptPackage.NODE_REF__NODE, oldNode, node));
      }
    }
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node basicGetNode()
  {
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNode(Node newNode)
  {
    Node oldNode = node;
    node = newNode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.NODE_REF__NODE, oldNode, node));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryRef getPrimaryRef()
  {
    return primaryRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrimaryRef(PrimaryRef newPrimaryRef, NotificationChain msgs)
  {
    PrimaryRef oldPrimaryRef = primaryRef;
    primaryRef = newPrimaryRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetxscriptPackage.NODE_REF__PRIMARY_REF, oldPrimaryRef, newPrimaryRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrimaryRef(PrimaryRef newPrimaryRef)
  {
    if (newPrimaryRef != primaryRef)
    {
      NotificationChain msgs = null;
      if (primaryRef != null)
        msgs = ((InternalEObject)primaryRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.NODE_REF__PRIMARY_REF, null, msgs);
      if (newPrimaryRef != null)
        msgs = ((InternalEObject)newPrimaryRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.NODE_REF__PRIMARY_REF, null, msgs);
      msgs = basicSetPrimaryRef(newPrimaryRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.NODE_REF__PRIMARY_REF, newPrimaryRef, newPrimaryRef));
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
      case NetxscriptPackage.NODE_REF__PRIMARY_REF:
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
      case NetxscriptPackage.NODE_REF__NODE:
        if (resolve) return getNode();
        return basicGetNode();
      case NetxscriptPackage.NODE_REF__PRIMARY_REF:
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
      case NetxscriptPackage.NODE_REF__NODE:
        setNode((Node)newValue);
        return;
      case NetxscriptPackage.NODE_REF__PRIMARY_REF:
        setPrimaryRef((PrimaryRef)newValue);
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
      case NetxscriptPackage.NODE_REF__NODE:
        setNode((Node)null);
        return;
      case NetxscriptPackage.NODE_REF__PRIMARY_REF:
        setPrimaryRef((PrimaryRef)null);
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
      case NetxscriptPackage.NODE_REF__NODE:
        return node != null;
      case NetxscriptPackage.NODE_REF__PRIMARY_REF:
        return primaryRef != null;
    }
    return super.eIsSet(featureID);
  }

} //NodeRefImpl
