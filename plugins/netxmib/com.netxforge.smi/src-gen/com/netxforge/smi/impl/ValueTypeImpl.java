/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.ASN1_TYPE;
import com.netxforge.smi.Referenceable;
import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.TypeAssignment;
import com.netxforge.smi.Value;
import com.netxforge.smi.ValueType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.ValueTypeImpl#getParam <em>Param</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ValueTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ValueTypeImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ValueTypeImpl#getSimpleType <em>Simple Type</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ValueTypeImpl#getMacroValue <em>Macro Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueTypeImpl extends MinimalEObjectImpl.Container implements ValueType
{
  /**
   * The cached value of the '{@link #getParam() <em>Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParam()
   * @generated
   * @ordered
   */
  protected Referenceable param;

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
   * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypes()
   * @generated
   * @ordered
   */
  protected TypeAssignment types;

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
   * The cached value of the '{@link #getMacroValue() <em>Macro Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMacroValue()
   * @generated
   * @ordered
   */
  protected Value macroValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ValueTypeImpl()
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
    return SmiPackage.Literals.VALUE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Referenceable getParam()
  {
    return param;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParam(Referenceable newParam, NotificationChain msgs)
  {
    Referenceable oldParam = param;
    param = newParam;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE_TYPE__PARAM, oldParam, newParam);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParam(Referenceable newParam)
  {
    if (newParam != param)
    {
      NotificationChain msgs = null;
      if (param != null)
        msgs = ((InternalEObject)param).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.VALUE_TYPE__PARAM, null, msgs);
      if (newParam != null)
        msgs = ((InternalEObject)newParam).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.VALUE_TYPE__PARAM, null, msgs);
      msgs = basicSetParam(newParam, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE_TYPE__PARAM, newParam, newParam));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE_TYPE__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeAssignment getTypes()
  {
    return types;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypes(TypeAssignment newTypes, NotificationChain msgs)
  {
    TypeAssignment oldTypes = types;
    types = newTypes;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE_TYPE__TYPES, oldTypes, newTypes);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypes(TypeAssignment newTypes)
  {
    if (newTypes != types)
    {
      NotificationChain msgs = null;
      if (types != null)
        msgs = ((InternalEObject)types).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.VALUE_TYPE__TYPES, null, msgs);
      if (newTypes != null)
        msgs = ((InternalEObject)newTypes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.VALUE_TYPE__TYPES, null, msgs);
      msgs = basicSetTypes(newTypes, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE_TYPE__TYPES, newTypes, newTypes));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE_TYPE__SIMPLE_TYPE, oldSimpleType, newSimpleType);
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
        msgs = ((InternalEObject)simpleType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.VALUE_TYPE__SIMPLE_TYPE, null, msgs);
      if (newSimpleType != null)
        msgs = ((InternalEObject)newSimpleType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.VALUE_TYPE__SIMPLE_TYPE, null, msgs);
      msgs = basicSetSimpleType(newSimpleType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE_TYPE__SIMPLE_TYPE, newSimpleType, newSimpleType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Value getMacroValue()
  {
    return macroValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMacroValue(Value newMacroValue, NotificationChain msgs)
  {
    Value oldMacroValue = macroValue;
    macroValue = newMacroValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE_TYPE__MACRO_VALUE, oldMacroValue, newMacroValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMacroValue(Value newMacroValue)
  {
    if (newMacroValue != macroValue)
    {
      NotificationChain msgs = null;
      if (macroValue != null)
        msgs = ((InternalEObject)macroValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.VALUE_TYPE__MACRO_VALUE, null, msgs);
      if (newMacroValue != null)
        msgs = ((InternalEObject)newMacroValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.VALUE_TYPE__MACRO_VALUE, null, msgs);
      msgs = basicSetMacroValue(newMacroValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE_TYPE__MACRO_VALUE, newMacroValue, newMacroValue));
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
      case SmiPackage.VALUE_TYPE__PARAM:
        return basicSetParam(null, msgs);
      case SmiPackage.VALUE_TYPE__TYPES:
        return basicSetTypes(null, msgs);
      case SmiPackage.VALUE_TYPE__SIMPLE_TYPE:
        return basicSetSimpleType(null, msgs);
      case SmiPackage.VALUE_TYPE__MACRO_VALUE:
        return basicSetMacroValue(null, msgs);
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
      case SmiPackage.VALUE_TYPE__PARAM:
        return getParam();
      case SmiPackage.VALUE_TYPE__ID:
        return getId();
      case SmiPackage.VALUE_TYPE__TYPES:
        return getTypes();
      case SmiPackage.VALUE_TYPE__SIMPLE_TYPE:
        return getSimpleType();
      case SmiPackage.VALUE_TYPE__MACRO_VALUE:
        return getMacroValue();
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
      case SmiPackage.VALUE_TYPE__PARAM:
        setParam((Referenceable)newValue);
        return;
      case SmiPackage.VALUE_TYPE__ID:
        setId((String)newValue);
        return;
      case SmiPackage.VALUE_TYPE__TYPES:
        setTypes((TypeAssignment)newValue);
        return;
      case SmiPackage.VALUE_TYPE__SIMPLE_TYPE:
        setSimpleType((ASN1_TYPE)newValue);
        return;
      case SmiPackage.VALUE_TYPE__MACRO_VALUE:
        setMacroValue((Value)newValue);
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
      case SmiPackage.VALUE_TYPE__PARAM:
        setParam((Referenceable)null);
        return;
      case SmiPackage.VALUE_TYPE__ID:
        setId(ID_EDEFAULT);
        return;
      case SmiPackage.VALUE_TYPE__TYPES:
        setTypes((TypeAssignment)null);
        return;
      case SmiPackage.VALUE_TYPE__SIMPLE_TYPE:
        setSimpleType((ASN1_TYPE)null);
        return;
      case SmiPackage.VALUE_TYPE__MACRO_VALUE:
        setMacroValue((Value)null);
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
      case SmiPackage.VALUE_TYPE__PARAM:
        return param != null;
      case SmiPackage.VALUE_TYPE__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case SmiPackage.VALUE_TYPE__TYPES:
        return types != null;
      case SmiPackage.VALUE_TYPE__SIMPLE_TYPE:
        return simpleType != null;
      case SmiPackage.VALUE_TYPE__MACRO_VALUE:
        return macroValue != null;
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

} //ValueTypeImpl
