/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.Attribute;
import com.netxforge.smi.Macro;
import com.netxforge.smi.ObjectValue;
import com.netxforge.smi.SmiPackage;

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
 * An implementation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.ObjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ObjectImpl#getMacroRef <em>Macro Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ObjectImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ObjectImpl#getObjectValue <em>Object Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectImpl extends MinimalEObjectImpl.Container implements com.netxforge.smi.Object
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
   * The cached value of the '{@link #getMacroRef() <em>Macro Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMacroRef()
   * @generated
   * @ordered
   */
  protected Macro macroRef;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<Attribute> attributes;

  /**
   * The cached value of the '{@link #getObjectValue() <em>Object Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjectValue()
   * @generated
   * @ordered
   */
  protected ObjectValue objectValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ObjectImpl()
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
    return SmiPackage.Literals.OBJECT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.OBJECT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Macro getMacroRef()
  {
    if (macroRef != null && macroRef.eIsProxy())
    {
      InternalEObject oldMacroRef = (InternalEObject)macroRef;
      macroRef = (Macro)eResolveProxy(oldMacroRef);
      if (macroRef != oldMacroRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmiPackage.OBJECT__MACRO_REF, oldMacroRef, macroRef));
      }
    }
    return macroRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Macro basicGetMacroRef()
  {
    return macroRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMacroRef(Macro newMacroRef)
  {
    Macro oldMacroRef = macroRef;
    macroRef = newMacroRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.OBJECT__MACRO_REF, oldMacroRef, macroRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Attribute> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, SmiPackage.OBJECT__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectValue getObjectValue()
  {
    return objectValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetObjectValue(ObjectValue newObjectValue, NotificationChain msgs)
  {
    ObjectValue oldObjectValue = objectValue;
    objectValue = newObjectValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.OBJECT__OBJECT_VALUE, oldObjectValue, newObjectValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObjectValue(ObjectValue newObjectValue)
  {
    if (newObjectValue != objectValue)
    {
      NotificationChain msgs = null;
      if (objectValue != null)
        msgs = ((InternalEObject)objectValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.OBJECT__OBJECT_VALUE, null, msgs);
      if (newObjectValue != null)
        msgs = ((InternalEObject)newObjectValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.OBJECT__OBJECT_VALUE, null, msgs);
      msgs = basicSetObjectValue(newObjectValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.OBJECT__OBJECT_VALUE, newObjectValue, newObjectValue));
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
      case SmiPackage.OBJECT__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
      case SmiPackage.OBJECT__OBJECT_VALUE:
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
      case SmiPackage.OBJECT__NAME:
        return getName();
      case SmiPackage.OBJECT__MACRO_REF:
        if (resolve) return getMacroRef();
        return basicGetMacroRef();
      case SmiPackage.OBJECT__ATTRIBUTES:
        return getAttributes();
      case SmiPackage.OBJECT__OBJECT_VALUE:
        return getObjectValue();
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
      case SmiPackage.OBJECT__NAME:
        setName((String)newValue);
        return;
      case SmiPackage.OBJECT__MACRO_REF:
        setMacroRef((Macro)newValue);
        return;
      case SmiPackage.OBJECT__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends Attribute>)newValue);
        return;
      case SmiPackage.OBJECT__OBJECT_VALUE:
        setObjectValue((ObjectValue)newValue);
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
      case SmiPackage.OBJECT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SmiPackage.OBJECT__MACRO_REF:
        setMacroRef((Macro)null);
        return;
      case SmiPackage.OBJECT__ATTRIBUTES:
        getAttributes().clear();
        return;
      case SmiPackage.OBJECT__OBJECT_VALUE:
        setObjectValue((ObjectValue)null);
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
      case SmiPackage.OBJECT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SmiPackage.OBJECT__MACRO_REF:
        return macroRef != null;
      case SmiPackage.OBJECT__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case SmiPackage.OBJECT__OBJECT_VALUE:
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

} //ObjectImpl
