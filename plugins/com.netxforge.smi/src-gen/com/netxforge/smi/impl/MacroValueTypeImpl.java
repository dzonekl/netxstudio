/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.MacroValueType;
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
 * An implementation of the model object '<em><b>Macro Value Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.MacroValueTypeImpl#isUpdate <em>Update</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.MacroValueTypeImpl#isValueCAP <em>Value CAP</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.MacroValueTypeImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.MacroValueTypeImpl#getOi <em>Oi</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.MacroValueTypeImpl#getString <em>String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MacroValueTypeImpl extends MinimalEObjectImpl.Container implements MacroValueType
{
  /**
   * The default value of the '{@link #isUpdate() <em>Update</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUpdate()
   * @generated
   * @ordered
   */
  protected static final boolean UPDATE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUpdate() <em>Update</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUpdate()
   * @generated
   * @ordered
   */
  protected boolean update = UPDATE_EDEFAULT;

  /**
   * The default value of the '{@link #isValueCAP() <em>Value CAP</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isValueCAP()
   * @generated
   * @ordered
   */
  protected static final boolean VALUE_CAP_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isValueCAP() <em>Value CAP</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isValueCAP()
   * @generated
   * @ordered
   */
  protected boolean valueCAP = VALUE_CAP_EDEFAULT;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected TypeAssignment ref;

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
   * The default value of the '{@link #getString() <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getString()
   * @generated
   * @ordered
   */
  protected static final String STRING_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getString() <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getString()
   * @generated
   * @ordered
   */
  protected String string = STRING_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MacroValueTypeImpl()
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
    return SmiPackage.Literals.MACRO_VALUE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUpdate()
  {
    return update;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpdate(boolean newUpdate)
  {
    boolean oldUpdate = update;
    update = newUpdate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.MACRO_VALUE_TYPE__UPDATE, oldUpdate, update));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isValueCAP()
  {
    return valueCAP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValueCAP(boolean newValueCAP)
  {
    boolean oldValueCAP = valueCAP;
    valueCAP = newValueCAP;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.MACRO_VALUE_TYPE__VALUE_CAP, oldValueCAP, valueCAP));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeAssignment getRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRef(TypeAssignment newRef, NotificationChain msgs)
  {
    TypeAssignment oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.MACRO_VALUE_TYPE__REF, oldRef, newRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(TypeAssignment newRef)
  {
    if (newRef != ref)
    {
      NotificationChain msgs = null;
      if (ref != null)
        msgs = ((InternalEObject)ref).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.MACRO_VALUE_TYPE__REF, null, msgs);
      if (newRef != null)
        msgs = ((InternalEObject)newRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.MACRO_VALUE_TYPE__REF, null, msgs);
      msgs = basicSetRef(newRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.MACRO_VALUE_TYPE__REF, newRef, newRef));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.MACRO_VALUE_TYPE__OI, oldOi, oi));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getString()
  {
    return string;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setString(String newString)
  {
    String oldString = string;
    string = newString;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.MACRO_VALUE_TYPE__STRING, oldString, string));
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
      case SmiPackage.MACRO_VALUE_TYPE__REF:
        return basicSetRef(null, msgs);
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
      case SmiPackage.MACRO_VALUE_TYPE__UPDATE:
        return isUpdate();
      case SmiPackage.MACRO_VALUE_TYPE__VALUE_CAP:
        return isValueCAP();
      case SmiPackage.MACRO_VALUE_TYPE__REF:
        return getRef();
      case SmiPackage.MACRO_VALUE_TYPE__OI:
        return getOi();
      case SmiPackage.MACRO_VALUE_TYPE__STRING:
        return getString();
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
      case SmiPackage.MACRO_VALUE_TYPE__UPDATE:
        setUpdate((Boolean)newValue);
        return;
      case SmiPackage.MACRO_VALUE_TYPE__VALUE_CAP:
        setValueCAP((Boolean)newValue);
        return;
      case SmiPackage.MACRO_VALUE_TYPE__REF:
        setRef((TypeAssignment)newValue);
        return;
      case SmiPackage.MACRO_VALUE_TYPE__OI:
        setOi((String)newValue);
        return;
      case SmiPackage.MACRO_VALUE_TYPE__STRING:
        setString((String)newValue);
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
      case SmiPackage.MACRO_VALUE_TYPE__UPDATE:
        setUpdate(UPDATE_EDEFAULT);
        return;
      case SmiPackage.MACRO_VALUE_TYPE__VALUE_CAP:
        setValueCAP(VALUE_CAP_EDEFAULT);
        return;
      case SmiPackage.MACRO_VALUE_TYPE__REF:
        setRef((TypeAssignment)null);
        return;
      case SmiPackage.MACRO_VALUE_TYPE__OI:
        setOi(OI_EDEFAULT);
        return;
      case SmiPackage.MACRO_VALUE_TYPE__STRING:
        setString(STRING_EDEFAULT);
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
      case SmiPackage.MACRO_VALUE_TYPE__UPDATE:
        return update != UPDATE_EDEFAULT;
      case SmiPackage.MACRO_VALUE_TYPE__VALUE_CAP:
        return valueCAP != VALUE_CAP_EDEFAULT;
      case SmiPackage.MACRO_VALUE_TYPE__REF:
        return ref != null;
      case SmiPackage.MACRO_VALUE_TYPE__OI:
        return OI_EDEFAULT == null ? oi != null : !OI_EDEFAULT.equals(oi);
      case SmiPackage.MACRO_VALUE_TYPE__STRING:
        return STRING_EDEFAULT == null ? string != null : !STRING_EDEFAULT.equals(string);
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
    result.append(" (update: ");
    result.append(update);
    result.append(", valueCAP: ");
    result.append(valueCAP);
    result.append(", oi: ");
    result.append(oi);
    result.append(", string: ");
    result.append(string);
    result.append(')');
    return result.toString();
  }

} //MacroValueTypeImpl
