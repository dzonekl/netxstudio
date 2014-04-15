/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.Macro;
import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.TypeAssignment;
import com.netxforge.smi.TypeDefinition;
import com.netxforge.smi.Value;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Macro</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.MacroImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.MacroImpl#getTypeNotations <em>Type Notations</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.MacroImpl#getValueNotation <em>Value Notation</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.MacroImpl#getInnerTypes <em>Inner Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MacroImpl extends MinimalEObjectImpl.Container implements Macro
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
   * The cached value of the '{@link #getTypeNotations() <em>Type Notations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeNotations()
   * @generated
   * @ordered
   */
  protected EList<TypeAssignment> typeNotations;

  /**
   * The cached value of the '{@link #getValueNotation() <em>Value Notation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueNotation()
   * @generated
   * @ordered
   */
  protected Value valueNotation;

  /**
   * The cached value of the '{@link #getInnerTypes() <em>Inner Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInnerTypes()
   * @generated
   * @ordered
   */
  protected EList<TypeDefinition> innerTypes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MacroImpl()
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
    return SmiPackage.Literals.MACRO;
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
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.MACRO__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TypeAssignment> getTypeNotations()
  {
    if (typeNotations == null)
    {
      typeNotations = new EObjectContainmentEList<TypeAssignment>(TypeAssignment.class, this, SmiPackage.MACRO__TYPE_NOTATIONS);
    }
    return typeNotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Value getValueNotation()
  {
    return valueNotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValueNotation(Value newValueNotation, NotificationChain msgs)
  {
    Value oldValueNotation = valueNotation;
    valueNotation = newValueNotation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.MACRO__VALUE_NOTATION, oldValueNotation, newValueNotation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValueNotation(Value newValueNotation)
  {
    if (newValueNotation != valueNotation)
    {
      NotificationChain msgs = null;
      if (valueNotation != null)
        msgs = ((InternalEObject)valueNotation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.MACRO__VALUE_NOTATION, null, msgs);
      if (newValueNotation != null)
        msgs = ((InternalEObject)newValueNotation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.MACRO__VALUE_NOTATION, null, msgs);
      msgs = basicSetValueNotation(newValueNotation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.MACRO__VALUE_NOTATION, newValueNotation, newValueNotation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TypeDefinition> getInnerTypes()
  {
    if (innerTypes == null)
    {
      innerTypes = new EObjectContainmentEList<TypeDefinition>(TypeDefinition.class, this, SmiPackage.MACRO__INNER_TYPES);
    }
    return innerTypes;
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
      case SmiPackage.MACRO__TYPE_NOTATIONS:
        return ((InternalEList<?>)getTypeNotations()).basicRemove(otherEnd, msgs);
      case SmiPackage.MACRO__VALUE_NOTATION:
        return basicSetValueNotation(null, msgs);
      case SmiPackage.MACRO__INNER_TYPES:
        return ((InternalEList<?>)getInnerTypes()).basicRemove(otherEnd, msgs);
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
      case SmiPackage.MACRO__NAME:
        return getName();
      case SmiPackage.MACRO__TYPE_NOTATIONS:
        return getTypeNotations();
      case SmiPackage.MACRO__VALUE_NOTATION:
        return getValueNotation();
      case SmiPackage.MACRO__INNER_TYPES:
        return getInnerTypes();
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
      case SmiPackage.MACRO__NAME:
        setName((String)newValue);
        return;
      case SmiPackage.MACRO__TYPE_NOTATIONS:
        getTypeNotations().clear();
        getTypeNotations().addAll((Collection<? extends TypeAssignment>)newValue);
        return;
      case SmiPackage.MACRO__VALUE_NOTATION:
        setValueNotation((Value)newValue);
        return;
      case SmiPackage.MACRO__INNER_TYPES:
        getInnerTypes().clear();
        getInnerTypes().addAll((Collection<? extends TypeDefinition>)newValue);
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
      case SmiPackage.MACRO__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SmiPackage.MACRO__TYPE_NOTATIONS:
        getTypeNotations().clear();
        return;
      case SmiPackage.MACRO__VALUE_NOTATION:
        setValueNotation((Value)null);
        return;
      case SmiPackage.MACRO__INNER_TYPES:
        getInnerTypes().clear();
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
      case SmiPackage.MACRO__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SmiPackage.MACRO__TYPE_NOTATIONS:
        return typeNotations != null && !typeNotations.isEmpty();
      case SmiPackage.MACRO__VALUE_NOTATION:
        return valueNotation != null;
      case SmiPackage.MACRO__INNER_TYPES:
        return innerTypes != null && !innerTypes.isEmpty();
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

} //MacroImpl
