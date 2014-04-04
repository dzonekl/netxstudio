/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.ObjectIdentifier;
import com.netxforge.smi.ObjectIdentifierValue;
import com.netxforge.smi.SmiPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Identifier Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.ObjectIdentifierValueImpl#getDescriptorReference <em>Descriptor Reference</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ObjectIdentifierValueImpl#getSubIds <em>Sub Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectIdentifierValueImpl extends MinimalEObjectImpl.Container implements ObjectIdentifierValue
{
  /**
   * The cached value of the '{@link #getDescriptorReference() <em>Descriptor Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescriptorReference()
   * @generated
   * @ordered
   */
  protected ObjectIdentifier descriptorReference;

  /**
   * The cached value of the '{@link #getSubIds() <em>Sub Ids</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubIds()
   * @generated
   * @ordered
   */
  protected EList<Integer> subIds;

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
  public ObjectIdentifier getDescriptorReference()
  {
    if (descriptorReference != null && descriptorReference.eIsProxy())
    {
      InternalEObject oldDescriptorReference = (InternalEObject)descriptorReference;
      descriptorReference = (ObjectIdentifier)eResolveProxy(oldDescriptorReference);
      if (descriptorReference != oldDescriptorReference)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmiPackage.OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REFERENCE, oldDescriptorReference, descriptorReference));
      }
    }
    return descriptorReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectIdentifier basicGetDescriptorReference()
  {
    return descriptorReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescriptorReference(ObjectIdentifier newDescriptorReference)
  {
    ObjectIdentifier oldDescriptorReference = descriptorReference;
    descriptorReference = newDescriptorReference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REFERENCE, oldDescriptorReference, descriptorReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Integer> getSubIds()
  {
    if (subIds == null)
    {
      subIds = new EDataTypeEList<Integer>(Integer.class, this, SmiPackage.OBJECT_IDENTIFIER_VALUE__SUB_IDS);
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
      case SmiPackage.OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REFERENCE:
        if (resolve) return getDescriptorReference();
        return basicGetDescriptorReference();
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
      case SmiPackage.OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REFERENCE:
        setDescriptorReference((ObjectIdentifier)newValue);
        return;
      case SmiPackage.OBJECT_IDENTIFIER_VALUE__SUB_IDS:
        getSubIds().clear();
        getSubIds().addAll((Collection<? extends Integer>)newValue);
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
      case SmiPackage.OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REFERENCE:
        setDescriptorReference((ObjectIdentifier)null);
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
      case SmiPackage.OBJECT_IDENTIFIER_VALUE__DESCRIPTOR_REFERENCE:
        return descriptorReference != null;
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
    result.append(" (subIds: ");
    result.append(subIds);
    result.append(')');
    return result.toString();
  }

} //ObjectIdentifierValueImpl
