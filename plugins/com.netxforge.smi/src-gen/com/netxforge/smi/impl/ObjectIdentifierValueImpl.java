/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.ObjectIdentifierValue;
import com.netxforge.smi.ObjectReferenceable;
import com.netxforge.smi.SmiPackage;

import java.math.BigInteger;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Identifier Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.ObjectIdentifierValueImpl#getDescriptorRef <em>Descriptor Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ObjectIdentifierValueImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ObjectIdentifierValueImpl#getSubIds <em>Sub Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectIdentifierValueImpl extends ObjectValueImpl implements ObjectIdentifierValue
{
  /**
   * The cached value of the '{@link #getDescriptorRef() <em>Descriptor Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescriptorRef()
   * @generated
   * @ordered
   */
  protected ObjectReferenceable descriptorRef;

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
   * The cached value of the '{@link #getSubIds() <em>Sub Ids</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubIds()
   * @generated
   * @ordered
   */
  protected EList<BigInteger> subIds;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ObjectIdentifierValueImpl()
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
    return SmiPackage.Literals.OBJECT_IDENTIFIER_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectReferenceable getDescriptorRef()
  {
    if (descriptorRef != null && descriptorRef.eIsProxy())
    {
      InternalEObject oldDescriptorRef = (InternalEObject)descriptorRef;
      descriptorRef = (ObjectReferenceable)eResolveProxy(oldDescriptorRef);
      if (descriptorRef != oldDescriptorRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmiPackage.OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REF, oldDescriptorRef, descriptorRef));
      }
    }
    return descriptorRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectReferenceable basicGetDescriptorRef()
  {
    return descriptorRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescriptorRef(ObjectReferenceable newDescriptorRef)
  {
    ObjectReferenceable oldDescriptorRef = descriptorRef;
    descriptorRef = newDescriptorRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REF, oldDescriptorRef, descriptorRef));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.OBJECT_IDENTIFIER_VALUE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<BigInteger> getSubIds()
  {
    if (subIds == null)
    {
      subIds = new EDataTypeEList<BigInteger>(BigInteger.class, this, SmiPackage.OBJECT_IDENTIFIER_VALUE__SUB_IDS);
    }
    return subIds;
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
      case SmiPackage.OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REF:
        if (resolve) return getDescriptorRef();
        return basicGetDescriptorRef();
      case SmiPackage.OBJECT_IDENTIFIER_VALUE__NAME:
        return getName();
      case SmiPackage.OBJECT_IDENTIFIER_VALUE__SUB_IDS:
        return getSubIds();
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
      case SmiPackage.OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REF:
        setDescriptorRef((ObjectReferenceable)newValue);
        return;
      case SmiPackage.OBJECT_IDENTIFIER_VALUE__NAME:
        setName((String)newValue);
        return;
      case SmiPackage.OBJECT_IDENTIFIER_VALUE__SUB_IDS:
        getSubIds().clear();
        getSubIds().addAll((Collection<? extends BigInteger>)newValue);
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
      case SmiPackage.OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REF:
        setDescriptorRef((ObjectReferenceable)null);
        return;
      case SmiPackage.OBJECT_IDENTIFIER_VALUE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SmiPackage.OBJECT_IDENTIFIER_VALUE__SUB_IDS:
        getSubIds().clear();
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
      case SmiPackage.OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REF:
        return descriptorRef != null;
      case SmiPackage.OBJECT_IDENTIFIER_VALUE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SmiPackage.OBJECT_IDENTIFIER_VALUE__SUB_IDS:
        return subIds != null && !subIds.isEmpty();
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
    result.append(", subIds: ");
    result.append(subIds);
    result.append(')');
    return result.toString();
  }

} //ObjectIdentifierValueImpl
