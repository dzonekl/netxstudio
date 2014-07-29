/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.Referenceable;
import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.TypeNotation;
import com.netxforge.smi.TypeNotationRight;
import com.netxforge.smi.Value;
import com.netxforge.smi.ValueNotation;

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
 * An implementation of the model object '<em><b>Referenceable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.ReferenceableImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ReferenceableImpl#getValues <em>Values</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ReferenceableImpl#getTypeNotation <em>Type Notation</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ReferenceableImpl#getValueNotation <em>Value Notation</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ReferenceableImpl#getInnerTypes <em>Inner Types</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ReferenceableImpl#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceableImpl extends TypeAssignmentImpl implements Referenceable
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
   * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValues()
   * @generated
   * @ordered
   */
  protected EList<Value> values;

  /**
   * The cached value of the '{@link #getTypeNotation() <em>Type Notation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeNotation()
   * @generated
   * @ordered
   */
  protected TypeNotation typeNotation;

  /**
   * The cached value of the '{@link #getValueNotation() <em>Value Notation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueNotation()
   * @generated
   * @ordered
   */
  protected ValueNotation valueNotation;

  /**
   * The cached value of the '{@link #getInnerTypes() <em>Inner Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInnerTypes()
   * @generated
   * @ordered
   */
  protected EList<Referenceable> innerTypes;

  /**
   * The cached value of the '{@link #getRight() <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRight()
   * @generated
   * @ordered
   */
  protected TypeNotationRight right;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReferenceableImpl()
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
    return SmiPackage.Literals.REFERENCEABLE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.REFERENCEABLE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Value> getValues()
  {
    if (values == null)
    {
      values = new EObjectContainmentEList<Value>(Value.class, this, SmiPackage.REFERENCEABLE__VALUES);
    }
    return values;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeNotation getTypeNotation()
  {
    return typeNotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeNotation(TypeNotation newTypeNotation, NotificationChain msgs)
  {
    TypeNotation oldTypeNotation = typeNotation;
    typeNotation = newTypeNotation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.REFERENCEABLE__TYPE_NOTATION, oldTypeNotation, newTypeNotation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeNotation(TypeNotation newTypeNotation)
  {
    if (newTypeNotation != typeNotation)
    {
      NotificationChain msgs = null;
      if (typeNotation != null)
        msgs = ((InternalEObject)typeNotation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.REFERENCEABLE__TYPE_NOTATION, null, msgs);
      if (newTypeNotation != null)
        msgs = ((InternalEObject)newTypeNotation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.REFERENCEABLE__TYPE_NOTATION, null, msgs);
      msgs = basicSetTypeNotation(newTypeNotation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.REFERENCEABLE__TYPE_NOTATION, newTypeNotation, newTypeNotation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueNotation getValueNotation()
  {
    return valueNotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValueNotation(ValueNotation newValueNotation, NotificationChain msgs)
  {
    ValueNotation oldValueNotation = valueNotation;
    valueNotation = newValueNotation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.REFERENCEABLE__VALUE_NOTATION, oldValueNotation, newValueNotation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValueNotation(ValueNotation newValueNotation)
  {
    if (newValueNotation != valueNotation)
    {
      NotificationChain msgs = null;
      if (valueNotation != null)
        msgs = ((InternalEObject)valueNotation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.REFERENCEABLE__VALUE_NOTATION, null, msgs);
      if (newValueNotation != null)
        msgs = ((InternalEObject)newValueNotation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.REFERENCEABLE__VALUE_NOTATION, null, msgs);
      msgs = basicSetValueNotation(newValueNotation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.REFERENCEABLE__VALUE_NOTATION, newValueNotation, newValueNotation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Referenceable> getInnerTypes()
  {
    if (innerTypes == null)
    {
      innerTypes = new EObjectContainmentEList<Referenceable>(Referenceable.class, this, SmiPackage.REFERENCEABLE__INNER_TYPES);
    }
    return innerTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeNotationRight getRight()
  {
    return right;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRight(TypeNotationRight newRight, NotificationChain msgs)
  {
    TypeNotationRight oldRight = right;
    right = newRight;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.REFERENCEABLE__RIGHT, oldRight, newRight);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRight(TypeNotationRight newRight)
  {
    if (newRight != right)
    {
      NotificationChain msgs = null;
      if (right != null)
        msgs = ((InternalEObject)right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.REFERENCEABLE__RIGHT, null, msgs);
      if (newRight != null)
        msgs = ((InternalEObject)newRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.REFERENCEABLE__RIGHT, null, msgs);
      msgs = basicSetRight(newRight, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.REFERENCEABLE__RIGHT, newRight, newRight));
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
      case SmiPackage.REFERENCEABLE__VALUES:
        return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
      case SmiPackage.REFERENCEABLE__TYPE_NOTATION:
        return basicSetTypeNotation(null, msgs);
      case SmiPackage.REFERENCEABLE__VALUE_NOTATION:
        return basicSetValueNotation(null, msgs);
      case SmiPackage.REFERENCEABLE__INNER_TYPES:
        return ((InternalEList<?>)getInnerTypes()).basicRemove(otherEnd, msgs);
      case SmiPackage.REFERENCEABLE__RIGHT:
        return basicSetRight(null, msgs);
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
      case SmiPackage.REFERENCEABLE__NAME:
        return getName();
      case SmiPackage.REFERENCEABLE__VALUES:
        return getValues();
      case SmiPackage.REFERENCEABLE__TYPE_NOTATION:
        return getTypeNotation();
      case SmiPackage.REFERENCEABLE__VALUE_NOTATION:
        return getValueNotation();
      case SmiPackage.REFERENCEABLE__INNER_TYPES:
        return getInnerTypes();
      case SmiPackage.REFERENCEABLE__RIGHT:
        return getRight();
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
      case SmiPackage.REFERENCEABLE__NAME:
        setName((String)newValue);
        return;
      case SmiPackage.REFERENCEABLE__VALUES:
        getValues().clear();
        getValues().addAll((Collection<? extends Value>)newValue);
        return;
      case SmiPackage.REFERENCEABLE__TYPE_NOTATION:
        setTypeNotation((TypeNotation)newValue);
        return;
      case SmiPackage.REFERENCEABLE__VALUE_NOTATION:
        setValueNotation((ValueNotation)newValue);
        return;
      case SmiPackage.REFERENCEABLE__INNER_TYPES:
        getInnerTypes().clear();
        getInnerTypes().addAll((Collection<? extends Referenceable>)newValue);
        return;
      case SmiPackage.REFERENCEABLE__RIGHT:
        setRight((TypeNotationRight)newValue);
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
      case SmiPackage.REFERENCEABLE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SmiPackage.REFERENCEABLE__VALUES:
        getValues().clear();
        return;
      case SmiPackage.REFERENCEABLE__TYPE_NOTATION:
        setTypeNotation((TypeNotation)null);
        return;
      case SmiPackage.REFERENCEABLE__VALUE_NOTATION:
        setValueNotation((ValueNotation)null);
        return;
      case SmiPackage.REFERENCEABLE__INNER_TYPES:
        getInnerTypes().clear();
        return;
      case SmiPackage.REFERENCEABLE__RIGHT:
        setRight((TypeNotationRight)null);
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
      case SmiPackage.REFERENCEABLE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SmiPackage.REFERENCEABLE__VALUES:
        return values != null && !values.isEmpty();
      case SmiPackage.REFERENCEABLE__TYPE_NOTATION:
        return typeNotation != null;
      case SmiPackage.REFERENCEABLE__VALUE_NOTATION:
        return valueNotation != null;
      case SmiPackage.REFERENCEABLE__INNER_TYPES:
        return innerTypes != null && !innerTypes.isEmpty();
      case SmiPackage.REFERENCEABLE__RIGHT:
        return right != null;
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

} //ReferenceableImpl
