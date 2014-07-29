/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.Tag;
import com.netxforge.smi.Value;
import com.netxforge.smi.ValueType;

import java.util.Collection;

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
 * An implementation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.ValueImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ValueImpl#isImplicit <em>Implicit</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ValueImpl#getValueTypes <em>Value Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueImpl extends TypeAssignmentImpl implements Value
{
  /**
   * The cached value of the '{@link #getTag() <em>Tag</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTag()
   * @generated
   * @ordered
   */
  protected Tag tag;

  /**
   * The default value of the '{@link #isImplicit() <em>Implicit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isImplicit()
   * @generated
   * @ordered
   */
  protected static final boolean IMPLICIT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isImplicit() <em>Implicit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isImplicit()
   * @generated
   * @ordered
   */
  protected boolean implicit = IMPLICIT_EDEFAULT;

  /**
   * The cached value of the '{@link #getValueTypes() <em>Value Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueTypes()
   * @generated
   * @ordered
   */
  protected EList<ValueType> valueTypes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ValueImpl()
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
    return SmiPackage.Literals.VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tag getTag()
  {
    return tag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTag(Tag newTag, NotificationChain msgs)
  {
    Tag oldTag = tag;
    tag = newTag;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE__TAG, oldTag, newTag);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTag(Tag newTag)
  {
    if (newTag != tag)
    {
      NotificationChain msgs = null;
      if (tag != null)
        msgs = ((InternalEObject)tag).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.VALUE__TAG, null, msgs);
      if (newTag != null)
        msgs = ((InternalEObject)newTag).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.VALUE__TAG, null, msgs);
      msgs = basicSetTag(newTag, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE__TAG, newTag, newTag));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isImplicit()
  {
    return implicit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImplicit(boolean newImplicit)
  {
    boolean oldImplicit = implicit;
    implicit = newImplicit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.VALUE__IMPLICIT, oldImplicit, implicit));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ValueType> getValueTypes()
  {
    if (valueTypes == null)
    {
      valueTypes = new EObjectContainmentEList<ValueType>(ValueType.class, this, SmiPackage.VALUE__VALUE_TYPES);
    }
    return valueTypes;
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
      case SmiPackage.VALUE__TAG:
        return basicSetTag(null, msgs);
      case SmiPackage.VALUE__VALUE_TYPES:
        return ((InternalEList<?>)getValueTypes()).basicRemove(otherEnd, msgs);
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
      case SmiPackage.VALUE__TAG:
        return getTag();
      case SmiPackage.VALUE__IMPLICIT:
        return isImplicit();
      case SmiPackage.VALUE__VALUE_TYPES:
        return getValueTypes();
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
      case SmiPackage.VALUE__TAG:
        setTag((Tag)newValue);
        return;
      case SmiPackage.VALUE__IMPLICIT:
        setImplicit((Boolean)newValue);
        return;
      case SmiPackage.VALUE__VALUE_TYPES:
        getValueTypes().clear();
        getValueTypes().addAll((Collection<? extends ValueType>)newValue);
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
      case SmiPackage.VALUE__TAG:
        setTag((Tag)null);
        return;
      case SmiPackage.VALUE__IMPLICIT:
        setImplicit(IMPLICIT_EDEFAULT);
        return;
      case SmiPackage.VALUE__VALUE_TYPES:
        getValueTypes().clear();
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
      case SmiPackage.VALUE__TAG:
        return tag != null;
      case SmiPackage.VALUE__IMPLICIT:
        return implicit != IMPLICIT_EDEFAULT;
      case SmiPackage.VALUE__VALUE_TYPES:
        return valueTypes != null && !valueTypes.isEmpty();
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
    result.append(" (implicit: ");
    result.append(implicit);
    result.append(')');
    return result.toString();
  }

} //ValueImpl
