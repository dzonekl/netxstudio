/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.ImportRef;
import com.netxforge.smi.ObjectReferenceable;
import com.netxforge.smi.Referenceable;
import com.netxforge.smi.SmiPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.ImportRefImpl#getOiRef <em>Oi Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ImportRefImpl#getTypeRef <em>Type Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImportRefImpl extends MinimalEObjectImpl.Container implements ImportRef
{
  /**
   * The cached value of the '{@link #getOiRef() <em>Oi Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOiRef()
   * @generated
   * @ordered
   */
  protected ObjectReferenceable oiRef;

  /**
   * The cached value of the '{@link #getTypeRef() <em>Type Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeRef()
   * @generated
   * @ordered
   */
  protected Referenceable typeRef;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImportRefImpl()
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
    return SmiPackage.Literals.IMPORT_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectReferenceable getOiRef()
  {
    if (oiRef != null && oiRef.eIsProxy())
    {
      InternalEObject oldOiRef = (InternalEObject)oiRef;
      oiRef = (ObjectReferenceable)eResolveProxy(oldOiRef);
      if (oiRef != oldOiRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmiPackage.IMPORT_REF__OI_REF, oldOiRef, oiRef));
      }
    }
    return oiRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectReferenceable basicGetOiRef()
  {
    return oiRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOiRef(ObjectReferenceable newOiRef)
  {
    ObjectReferenceable oldOiRef = oiRef;
    oiRef = newOiRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.IMPORT_REF__OI_REF, oldOiRef, oiRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Referenceable getTypeRef()
  {
    if (typeRef != null && typeRef.eIsProxy())
    {
      InternalEObject oldTypeRef = (InternalEObject)typeRef;
      typeRef = (Referenceable)eResolveProxy(oldTypeRef);
      if (typeRef != oldTypeRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmiPackage.IMPORT_REF__TYPE_REF, oldTypeRef, typeRef));
      }
    }
    return typeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Referenceable basicGetTypeRef()
  {
    return typeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeRef(Referenceable newTypeRef)
  {
    Referenceable oldTypeRef = typeRef;
    typeRef = newTypeRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.IMPORT_REF__TYPE_REF, oldTypeRef, typeRef));
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
      case SmiPackage.IMPORT_REF__OI_REF:
        if (resolve) return getOiRef();
        return basicGetOiRef();
      case SmiPackage.IMPORT_REF__TYPE_REF:
        if (resolve) return getTypeRef();
        return basicGetTypeRef();
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
      case SmiPackage.IMPORT_REF__OI_REF:
        setOiRef((ObjectReferenceable)newValue);
        return;
      case SmiPackage.IMPORT_REF__TYPE_REF:
        setTypeRef((Referenceable)newValue);
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
      case SmiPackage.IMPORT_REF__OI_REF:
        setOiRef((ObjectReferenceable)null);
        return;
      case SmiPackage.IMPORT_REF__TYPE_REF:
        setTypeRef((Referenceable)null);
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
      case SmiPackage.IMPORT_REF__OI_REF:
        return oiRef != null;
      case SmiPackage.IMPORT_REF__TYPE_REF:
        return typeRef != null;
    }
    return super.eIsSet(featureID);
  }

} //ImportRefImpl
