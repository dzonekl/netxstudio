/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.ASN1_TYPE;
import com.netxforge.smi.ChoiceType;
import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.TypeAssignment;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.ChoiceTypeImpl#getTypeRef <em>Type Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ChoiceTypeImpl#getSimpleType <em>Simple Type</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ChoiceTypeImpl#getOi <em>Oi</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChoiceTypeImpl extends MinimalEObjectImpl.Container implements ChoiceType
{
  /**
   * The cached value of the '{@link #getTypeRef() <em>Type Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeRef()
   * @generated
   * @ordered
   */
  protected TypeAssignment typeRef;

  /**
   * The cached value of the '{@link #getSimpleType() <em>Simple Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSimpleType()
   * @generated
   * @ordered
   */
  protected ASN1_TYPE simpleType;

  /**
   * The default value of the '{@link #getOi() <em>Oi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOi()
   * @generated
   * @ordered
   */
  protected static final String OI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOi() <em>Oi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOi()
   * @generated
   * @ordered
   */
  protected String oi = OI_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ChoiceTypeImpl()
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
    return SmiPackage.Literals.CHOICE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeAssignment getTypeRef()
  {
    return typeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeRef(TypeAssignment newTypeRef, NotificationChain msgs)
  {
    TypeAssignment oldTypeRef = typeRef;
    typeRef = newTypeRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.CHOICE_TYPE__TYPE_REF, oldTypeRef, newTypeRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeRef(TypeAssignment newTypeRef)
  {
    if (newTypeRef != typeRef)
    {
      NotificationChain msgs = null;
      if (typeRef != null)
        msgs = ((InternalEObject)typeRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.CHOICE_TYPE__TYPE_REF, null, msgs);
      if (newTypeRef != null)
        msgs = ((InternalEObject)newTypeRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.CHOICE_TYPE__TYPE_REF, null, msgs);
      msgs = basicSetTypeRef(newTypeRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.CHOICE_TYPE__TYPE_REF, newTypeRef, newTypeRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASN1_TYPE getSimpleType()
  {
    return simpleType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSimpleType(ASN1_TYPE newSimpleType, NotificationChain msgs)
  {
    ASN1_TYPE oldSimpleType = simpleType;
    simpleType = newSimpleType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.CHOICE_TYPE__SIMPLE_TYPE, oldSimpleType, newSimpleType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSimpleType(ASN1_TYPE newSimpleType)
  {
    if (newSimpleType != simpleType)
    {
      NotificationChain msgs = null;
      if (simpleType != null)
        msgs = ((InternalEObject)simpleType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.CHOICE_TYPE__SIMPLE_TYPE, null, msgs);
      if (newSimpleType != null)
        msgs = ((InternalEObject)newSimpleType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.CHOICE_TYPE__SIMPLE_TYPE, null, msgs);
      msgs = basicSetSimpleType(newSimpleType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.CHOICE_TYPE__SIMPLE_TYPE, newSimpleType, newSimpleType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOi()
  {
    return oi;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOi(String newOi)
  {
    String oldOi = oi;
    oi = newOi;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.CHOICE_TYPE__OI, oldOi, oi));
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
      case SmiPackage.CHOICE_TYPE__TYPE_REF:
        return basicSetTypeRef(null, msgs);
      case SmiPackage.CHOICE_TYPE__SIMPLE_TYPE:
        return basicSetSimpleType(null, msgs);
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
      case SmiPackage.CHOICE_TYPE__TYPE_REF:
        return getTypeRef();
      case SmiPackage.CHOICE_TYPE__SIMPLE_TYPE:
        return getSimpleType();
      case SmiPackage.CHOICE_TYPE__OI:
        return getOi();
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
      case SmiPackage.CHOICE_TYPE__TYPE_REF:
        setTypeRef((TypeAssignment)newValue);
        return;
      case SmiPackage.CHOICE_TYPE__SIMPLE_TYPE:
        setSimpleType((ASN1_TYPE)newValue);
        return;
      case SmiPackage.CHOICE_TYPE__OI:
        setOi((String)newValue);
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
      case SmiPackage.CHOICE_TYPE__TYPE_REF:
        setTypeRef((TypeAssignment)null);
        return;
      case SmiPackage.CHOICE_TYPE__SIMPLE_TYPE:
        setSimpleType((ASN1_TYPE)null);
        return;
      case SmiPackage.CHOICE_TYPE__OI:
        setOi(OI_EDEFAULT);
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
      case SmiPackage.CHOICE_TYPE__TYPE_REF:
        return typeRef != null;
      case SmiPackage.CHOICE_TYPE__SIMPLE_TYPE:
        return simpleType != null;
      case SmiPackage.CHOICE_TYPE__OI:
        return OI_EDEFAULT == null ? oi != null : !OI_EDEFAULT.equals(oi);
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
    result.append(" (oi: ");
    result.append(oi);
    result.append(')');
    return result.toString();
  }

} //ChoiceTypeImpl
