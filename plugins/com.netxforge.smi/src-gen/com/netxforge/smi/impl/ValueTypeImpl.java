/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.ASN1_TYPE;
import com.netxforge.smi.MacroValue;
import com.netxforge.smi.ParamAssignment;
import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.TypeReferenceExt;
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
 *   <li>{@link com.netxforge.smi.impl.ValueTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ValueTypeImpl#getParam <em>Param</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ValueTypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ValueTypeImpl#getSimpleType <em>Simple Type</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ValueTypeImpl#getMacroValue <em>Macro Value</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ValueTypeImpl#getOi <em>Oi</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueTypeImpl extends MinimalEObjectImpl.Container implements ValueType
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
   * The cached value of the '{@link #getParam() <em>Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParam()
   * @generated
   * @ordered
   */
  protected ParamAssignment param;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected TypeReferenceExt type;

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
  protected MacroValue macroValue;

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
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE_TYPE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParamAssignment getParam()
  {
    return param;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParam(ParamAssignment newParam, NotificationChain msgs)
  {
    ParamAssignment oldParam = param;
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
  public void setParam(ParamAssignment newParam)
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
  public TypeReferenceExt getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(TypeReferenceExt newType, NotificationChain msgs)
  {
    TypeReferenceExt oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE_TYPE__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(TypeReferenceExt newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.VALUE_TYPE__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.VALUE_TYPE__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE_TYPE__TYPE, newType, newType));
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
  public MacroValue getMacroValue()
  {
    return macroValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMacroValue(MacroValue newMacroValue, NotificationChain msgs)
  {
    MacroValue oldMacroValue = macroValue;
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
  public void setMacroValue(MacroValue newMacroValue)
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
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE_TYPE__OI, oldOi, oi));
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
      case SmiPackage.VALUE_TYPE__TYPE:
        return basicSetType(null, msgs);
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
      case SmiPackage.VALUE_TYPE__NAME:
        return getName();
      case SmiPackage.VALUE_TYPE__PARAM:
        return getParam();
      case SmiPackage.VALUE_TYPE__TYPE:
        return getType();
      case SmiPackage.VALUE_TYPE__SIMPLE_TYPE:
        return getSimpleType();
      case SmiPackage.VALUE_TYPE__MACRO_VALUE:
        return getMacroValue();
      case SmiPackage.VALUE_TYPE__OI:
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
      case SmiPackage.VALUE_TYPE__NAME:
        setName((String)newValue);
        return;
      case SmiPackage.VALUE_TYPE__PARAM:
        setParam((ParamAssignment)newValue);
        return;
      case SmiPackage.VALUE_TYPE__TYPE:
        setType((TypeReferenceExt)newValue);
        return;
      case SmiPackage.VALUE_TYPE__SIMPLE_TYPE:
        setSimpleType((ASN1_TYPE)newValue);
        return;
      case SmiPackage.VALUE_TYPE__MACRO_VALUE:
        setMacroValue((MacroValue)newValue);
        return;
      case SmiPackage.VALUE_TYPE__OI:
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
      case SmiPackage.VALUE_TYPE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SmiPackage.VALUE_TYPE__PARAM:
        setParam((ParamAssignment)null);
        return;
      case SmiPackage.VALUE_TYPE__TYPE:
        setType((TypeReferenceExt)null);
        return;
      case SmiPackage.VALUE_TYPE__SIMPLE_TYPE:
        setSimpleType((ASN1_TYPE)null);
        return;
      case SmiPackage.VALUE_TYPE__MACRO_VALUE:
        setMacroValue((MacroValue)null);
        return;
      case SmiPackage.VALUE_TYPE__OI:
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
      case SmiPackage.VALUE_TYPE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SmiPackage.VALUE_TYPE__PARAM:
        return param != null;
      case SmiPackage.VALUE_TYPE__TYPE:
        return type != null;
      case SmiPackage.VALUE_TYPE__SIMPLE_TYPE:
        return simpleType != null;
      case SmiPackage.VALUE_TYPE__MACRO_VALUE:
        return macroValue != null;
      case SmiPackage.VALUE_TYPE__OI:
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
    result.append(" (name: ");
    result.append(name);
    result.append(", oi: ");
    result.append(oi);
    result.append(')');
    return result.toString();
  }

} //ValueTypeImpl
