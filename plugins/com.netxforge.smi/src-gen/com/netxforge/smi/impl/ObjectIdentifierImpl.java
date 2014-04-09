/**
 */
package com.netxforge.smi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.netxforge.smi.ObjectIdentifier;
import com.netxforge.smi.ObjectIdentifierValue;
import com.netxforge.smi.SmiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Identifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.ObjectIdentifierImpl#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ObjectIdentifierImpl#getOidValue <em>Oid Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectIdentifierImpl extends AssignmentImpl implements ObjectIdentifier
{
  /**
   * The default value of the '{@link #getDescriptor() <em>Descriptor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescriptor()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTOR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescriptor() <em>Descriptor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescriptor()
   * @generated
   * @ordered
   */
  protected String descriptor = DESCRIPTOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getOidValue() <em>Oid Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOidValue()
   * @generated
   * @ordered
   */
  protected ObjectIdentifierValue oidValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ObjectIdentifierImpl()
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
    return SmiPackage.Literals.OBJECT_IDENTIFIER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescriptor()
  {
    return descriptor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescriptor(String newDescriptor)
  {
    String oldDescriptor = descriptor;
    descriptor = newDescriptor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.OBJECT_IDENTIFIER__DESCRIPTOR, oldDescriptor, descriptor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectIdentifierValue getOidValue()
  {
    return oidValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOidValue(ObjectIdentifierValue newOidValue, NotificationChain msgs)
  {
    ObjectIdentifierValue oldOidValue = oidValue;
    oidValue = newOidValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.OBJECT_IDENTIFIER__OID_VALUE, oldOidValue, newOidValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOidValue(ObjectIdentifierValue newOidValue)
  {
    if (newOidValue != oidValue)
    {
      NotificationChain msgs = null;
      if (oidValue != null)
        msgs = ((InternalEObject)oidValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.OBJECT_IDENTIFIER__OID_VALUE, null, msgs);
      if (newOidValue != null)
        msgs = ((InternalEObject)newOidValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.OBJECT_IDENTIFIER__OID_VALUE, null, msgs);
      msgs = basicSetOidValue(newOidValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.OBJECT_IDENTIFIER__OID_VALUE, newOidValue, newOidValue));
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
      case SmiPackage.OBJECT_IDENTIFIER__OID_VALUE:
        return basicSetOidValue(null, msgs);
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
      case SmiPackage.OBJECT_IDENTIFIER__DESCRIPTOR:
        return getDescriptor();
      case SmiPackage.OBJECT_IDENTIFIER__OID_VALUE:
        return getOidValue();
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
      case SmiPackage.OBJECT_IDENTIFIER__DESCRIPTOR:
        setDescriptor((String)newValue);
        return;
      case SmiPackage.OBJECT_IDENTIFIER__OID_VALUE:
        setOidValue((ObjectIdentifierValue)newValue);
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
      case SmiPackage.OBJECT_IDENTIFIER__DESCRIPTOR:
        setDescriptor(DESCRIPTOR_EDEFAULT);
        return;
      case SmiPackage.OBJECT_IDENTIFIER__OID_VALUE:
        setOidValue((ObjectIdentifierValue)null);
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
      case SmiPackage.OBJECT_IDENTIFIER__DESCRIPTOR:
        return DESCRIPTOR_EDEFAULT == null ? descriptor != null : !DESCRIPTOR_EDEFAULT.equals(descriptor);
      case SmiPackage.OBJECT_IDENTIFIER__OID_VALUE:
        return oidValue != null;
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
    result.append(" (descriptor: ");
    result.append(descriptor);
    result.append(')');
    return result.toString();
  }

} //ObjectIdentifierImpl
