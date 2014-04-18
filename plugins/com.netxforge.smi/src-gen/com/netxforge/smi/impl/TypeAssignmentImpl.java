/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.TypeAssignment;
import com.netxforge.smi.TypeDefinition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.TypeAssignmentImpl#getParentRef <em>Parent Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.TypeAssignmentImpl#getChildRef <em>Child Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.TypeAssignmentImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeAssignmentImpl extends TypeNotationRightImpl implements TypeAssignment
{
  /**
   * The cached value of the '{@link #getParentRef() <em>Parent Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParentRef()
   * @generated
   * @ordered
   */
  protected TypeAssignment parentRef;

  /**
   * The cached value of the '{@link #getChildRef() <em>Child Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChildRef()
   * @generated
   * @ordered
   */
  protected TypeAssignment childRef;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected TypeDefinition type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeAssignmentImpl()
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
    return SmiPackage.Literals.TYPE_ASSIGNMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeAssignment getParentRef()
  {
    return parentRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParentRef(TypeAssignment newParentRef, NotificationChain msgs)
  {
    TypeAssignment oldParentRef = parentRef;
    parentRef = newParentRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.TYPE_ASSIGNMENT__PARENT_REF, oldParentRef, newParentRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParentRef(TypeAssignment newParentRef)
  {
    if (newParentRef != parentRef)
    {
      NotificationChain msgs = null;
      if (parentRef != null)
        msgs = ((InternalEObject)parentRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.TYPE_ASSIGNMENT__PARENT_REF, null, msgs);
      if (newParentRef != null)
        msgs = ((InternalEObject)newParentRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.TYPE_ASSIGNMENT__PARENT_REF, null, msgs);
      msgs = basicSetParentRef(newParentRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.TYPE_ASSIGNMENT__PARENT_REF, newParentRef, newParentRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeAssignment getChildRef()
  {
    return childRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChildRef(TypeAssignment newChildRef, NotificationChain msgs)
  {
    TypeAssignment oldChildRef = childRef;
    childRef = newChildRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.TYPE_ASSIGNMENT__CHILD_REF, oldChildRef, newChildRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChildRef(TypeAssignment newChildRef)
  {
    if (newChildRef != childRef)
    {
      NotificationChain msgs = null;
      if (childRef != null)
        msgs = ((InternalEObject)childRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.TYPE_ASSIGNMENT__CHILD_REF, null, msgs);
      if (newChildRef != null)
        msgs = ((InternalEObject)newChildRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.TYPE_ASSIGNMENT__CHILD_REF, null, msgs);
      msgs = basicSetChildRef(newChildRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.TYPE_ASSIGNMENT__CHILD_REF, newChildRef, newChildRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDefinition getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (TypeDefinition)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmiPackage.TYPE_ASSIGNMENT__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDefinition basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(TypeDefinition newType)
  {
    TypeDefinition oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.TYPE_ASSIGNMENT__TYPE, oldType, type));
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
      case SmiPackage.TYPE_ASSIGNMENT__PARENT_REF:
        return basicSetParentRef(null, msgs);
      case SmiPackage.TYPE_ASSIGNMENT__CHILD_REF:
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
      case SmiPackage.TYPE_ASSIGNMENT__PARENT_REF:
        return getParentRef();
      case SmiPackage.TYPE_ASSIGNMENT__CHILD_REF:
        return getChildRef();
      case SmiPackage.TYPE_ASSIGNMENT__TYPE:
        if (resolve) return getType();
        return basicGetType();
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
      case SmiPackage.TYPE_ASSIGNMENT__PARENT_REF:
        setParentRef((TypeAssignment)newValue);
        return;
      case SmiPackage.TYPE_ASSIGNMENT__CHILD_REF:
        setChildRef((TypeAssignment)newValue);
        return;
      case SmiPackage.TYPE_ASSIGNMENT__TYPE:
        setType((TypeDefinition)newValue);
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
      case SmiPackage.TYPE_ASSIGNMENT__PARENT_REF:
        setParentRef((TypeAssignment)null);
        return;
      case SmiPackage.TYPE_ASSIGNMENT__CHILD_REF:
        setChildRef((TypeAssignment)null);
        return;
      case SmiPackage.TYPE_ASSIGNMENT__TYPE:
        setType((TypeDefinition)null);
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
      case SmiPackage.TYPE_ASSIGNMENT__PARENT_REF:
        return parentRef != null;
      case SmiPackage.TYPE_ASSIGNMENT__CHILD_REF:
        return childRef != null;
      case SmiPackage.TYPE_ASSIGNMENT__TYPE:
        return type != null;
    }
    return super.eIsSet(featureID);
  }

} //TypeAssignmentImpl
