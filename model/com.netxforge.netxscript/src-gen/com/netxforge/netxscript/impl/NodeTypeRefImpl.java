/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.impl;

import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.NodeTypeRef;
import com.netxforge.netxscript.Reference;

import com.netxforge.netxstudio.library.NodeType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Type Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.impl.NodeTypeRefImpl#getNodetype <em>Nodetype</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.NodeTypeRefImpl#getPrimaryRef <em>Primary Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeTypeRefImpl extends ReferenceImpl implements NodeTypeRef
{
  /**
   * The cached value of the '{@link #getNodetype() <em>Nodetype</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNodetype()
   * @generated
   * @ordered
   */
  protected NodeType nodetype;

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
  protected NodeTypeRefImpl()
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
    return NetxscriptPackage.Literals.NODE_TYPE_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeType getNodetype()
  {
    if (nodetype != null && ((EObject)nodetype).eIsProxy())
    {
      InternalEObject oldNodetype = (InternalEObject)nodetype;
      nodetype = (NodeType)eResolveProxy(oldNodetype);
      if (nodetype != oldNodetype)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetxscriptPackage.NODE_TYPE_REF__NODETYPE, oldNodetype, nodetype));
      }
    }
    return nodetype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeType basicGetNodetype()
  {
    return nodetype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNodetype(NodeType newNodetype)
  {
    NodeType oldNodetype = nodetype;
    nodetype = newNodetype;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.NODE_TYPE_REF__NODETYPE, oldNodetype, nodetype));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetxscriptPackage.NODE_TYPE_REF__PRIMARY_REF, oldPrimaryRef, newPrimaryRef);
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
        msgs = ((InternalEObject)primaryRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.NODE_TYPE_REF__PRIMARY_REF, null, msgs);
      if (newPrimaryRef != null)
        msgs = ((InternalEObject)newPrimaryRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.NODE_TYPE_REF__PRIMARY_REF, null, msgs);
      msgs = basicSetPrimaryRef(newPrimaryRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.NODE_TYPE_REF__PRIMARY_REF, newPrimaryRef, newPrimaryRef));
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
      case NetxscriptPackage.NODE_TYPE_REF__PRIMARY_REF:
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
      case NetxscriptPackage.NODE_TYPE_REF__NODETYPE:
        if (resolve) return getNodetype();
        return basicGetNodetype();
      case NetxscriptPackage.NODE_TYPE_REF__PRIMARY_REF:
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
      case NetxscriptPackage.NODE_TYPE_REF__NODETYPE:
        setNodetype((NodeType)newValue);
        return;
      case NetxscriptPackage.NODE_TYPE_REF__PRIMARY_REF:
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
      case NetxscriptPackage.NODE_TYPE_REF__NODETYPE:
        setNodetype((NodeType)null);
        return;
      case NetxscriptPackage.NODE_TYPE_REF__PRIMARY_REF:
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
      case NetxscriptPackage.NODE_TYPE_REF__NODETYPE:
        return nodetype != null;
      case NetxscriptPackage.NODE_TYPE_REF__PRIMARY_REF:
        return primaryRef != null;
    }
    return super.eIsSet(featureID);
  }

} //NodeTypeRefImpl
