/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.ASN1_CHOICE_ENTRY;
import com.netxforge.smi.ChoiceType;
import com.netxforge.smi.SmiPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ASN1 CHOICE ENTRY</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.ASN1_CHOICE_ENTRYImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ASN1_CHOICE_ENTRYImpl#getValueType <em>Value Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ASN1_CHOICE_ENTRYImpl extends MinimalEObjectImpl.Container implements ASN1_CHOICE_ENTRY
{
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getValueType() <em>Value Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueType()
   * @generated
   * @ordered
   */
  protected ChoiceType valueType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ASN1_CHOICE_ENTRYImpl()
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
    return SmiPackage.Literals.ASN1_CHOICE_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.ASN1_CHOICE_ENTRY__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChoiceType getValueType()
  {
    return valueType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValueType(ChoiceType newValueType, NotificationChain msgs)
  {
    ChoiceType oldValueType = valueType;
    valueType = newValueType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.ASN1_CHOICE_ENTRY__VALUE_TYPE, oldValueType, newValueType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValueType(ChoiceType newValueType)
  {
    if (newValueType != valueType)
    {
      NotificationChain msgs = null;
      if (valueType != null)
        msgs = ((InternalEObject)valueType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ASN1_CHOICE_ENTRY__VALUE_TYPE, null, msgs);
      if (newValueType != null)
        msgs = ((InternalEObject)newValueType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ASN1_CHOICE_ENTRY__VALUE_TYPE, null, msgs);
      msgs = basicSetValueType(newValueType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.ASN1_CHOICE_ENTRY__VALUE_TYPE, newValueType, newValueType));
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
      case SmiPackage.ASN1_CHOICE_ENTRY__VALUE_TYPE:
        return basicSetValueType(null, msgs);
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
      case SmiPackage.ASN1_CHOICE_ENTRY__ID:
        return getId();
      case SmiPackage.ASN1_CHOICE_ENTRY__VALUE_TYPE:
        return getValueType();
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
      case SmiPackage.ASN1_CHOICE_ENTRY__ID:
        setId((String)newValue);
        return;
      case SmiPackage.ASN1_CHOICE_ENTRY__VALUE_TYPE:
        setValueType((ChoiceType)newValue);
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
      case SmiPackage.ASN1_CHOICE_ENTRY__ID:
        setId(ID_EDEFAULT);
        return;
      case SmiPackage.ASN1_CHOICE_ENTRY__VALUE_TYPE:
        setValueType((ChoiceType)null);
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
      case SmiPackage.ASN1_CHOICE_ENTRY__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case SmiPackage.ASN1_CHOICE_ENTRY__VALUE_TYPE:
        return valueType != null;
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
    result.append(" (id: ");
    result.append(id);
    result.append(')');
    return result.toString();
  }

} //ASN1_CHOICE_ENTRYImpl
