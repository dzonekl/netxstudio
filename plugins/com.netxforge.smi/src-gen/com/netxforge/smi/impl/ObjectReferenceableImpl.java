/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.ObjectReference;
import com.netxforge.smi.ObjectReferenceable;
import com.netxforge.smi.SmiPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Referenceable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.ObjectReferenceableImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ObjectReferenceableImpl#getObject <em>Object</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ObjectReferenceableImpl#getObjectValue <em>Object Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectReferenceableImpl extends MinimalEObjectImpl.Container implements ObjectReferenceable
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getObject() <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObject()
   * @generated
   * @ordered
   */
  protected com.netxforge.smi.Object object;

  /**
   * The cached value of the '{@link #getObjectValue() <em>Object Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjectValue()
   * @generated
   * @ordered
   */
  protected ObjectReference objectValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ObjectReferenceableImpl()
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
    return SmiPackage.Literals.OBJECT_REFERENCEABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.OBJECT_REFERENCEABLE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public com.netxforge.smi.Object getObject()
  {
    return object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetObject(com.netxforge.smi.Object newObject, NotificationChain msgs)
  {
    com.netxforge.smi.Object oldObject = object;
    object = newObject;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.OBJECT_REFERENCEABLE__OBJECT, oldObject, newObject);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObject(com.netxforge.smi.Object newObject)
  {
    if (newObject != object)
    {
      NotificationChain msgs = null;
      if (object != null)
        msgs = ((InternalEObject)object).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.OBJECT_REFERENCEABLE__OBJECT, null, msgs);
      if (newObject != null)
        msgs = ((InternalEObject)newObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.OBJECT_REFERENCEABLE__OBJECT, null, msgs);
      msgs = basicSetObject(newObject, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.OBJECT_REFERENCEABLE__OBJECT, newObject, newObject));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectReference getObjectValue()
  {
    return objectValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetObjectValue(ObjectReference newObjectValue, NotificationChain msgs)
  {
    ObjectReference oldObjectValue = objectValue;
    objectValue = newObjectValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.OBJECT_REFERENCEABLE__OBJECT_VALUE, oldObjectValue, newObjectValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObjectValue(ObjectReference newObjectValue)
  {
    if (newObjectValue != objectValue)
    {
      NotificationChain msgs = null;
      if (objectValue != null)
        msgs = ((InternalEObject)objectValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.OBJECT_REFERENCEABLE__OBJECT_VALUE, null, msgs);
      if (newObjectValue != null)
        msgs = ((InternalEObject)newObjectValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.OBJECT_REFERENCEABLE__OBJECT_VALUE, null, msgs);
      msgs = basicSetObjectValue(newObjectValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.OBJECT_REFERENCEABLE__OBJECT_VALUE, newObjectValue, newObjectValue));
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
      case SmiPackage.OBJECT_REFERENCEABLE__OBJECT:
        return basicSetObject(null, msgs);
      case SmiPackage.OBJECT_REFERENCEABLE__OBJECT_VALUE:
        return basicSetObjectValue(null, msgs);
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
      case SmiPackage.OBJECT_REFERENCEABLE__NAME:
        return getName();
      case SmiPackage.OBJECT_REFERENCEABLE__OBJECT:
        return getObject();
      case SmiPackage.OBJECT_REFERENCEABLE__OBJECT_VALUE:
        return getObjectValue();
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
      case SmiPackage.OBJECT_REFERENCEABLE__NAME:
        setName((String)newValue);
        return;
      case SmiPackage.OBJECT_REFERENCEABLE__OBJECT:
        setObject((com.netxforge.smi.Object)newValue);
        return;
      case SmiPackage.OBJECT_REFERENCEABLE__OBJECT_VALUE:
        setObjectValue((ObjectReference)newValue);
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
      case SmiPackage.OBJECT_REFERENCEABLE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SmiPackage.OBJECT_REFERENCEABLE__OBJECT:
        setObject((com.netxforge.smi.Object)null);
        return;
      case SmiPackage.OBJECT_REFERENCEABLE__OBJECT_VALUE:
        setObjectValue((ObjectReference)null);
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
      case SmiPackage.OBJECT_REFERENCEABLE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SmiPackage.OBJECT_REFERENCEABLE__OBJECT:
        return object != null;
      case SmiPackage.OBJECT_REFERENCEABLE__OBJECT_VALUE:
        return objectValue != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ObjectReferenceableImpl
