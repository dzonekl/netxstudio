/**
 */
package com.netxforge.smi.impl;

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

import com.netxforge.smi.Assignment;
import com.netxforge.smi.Macro;
import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.ValueAssignment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.AssignmentImpl#getMacros <em>Macros</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.AssignmentImpl#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssignmentImpl extends MinimalEObjectImpl.Container implements Assignment
{
  /**
   * The cached value of the '{@link #getMacros() <em>Macros</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMacros()
   * @generated
   * @ordered
   */
  protected Macro macros;

  /**
   * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypes()
   * @generated
   * @ordered
   */
  protected EList<ValueAssignment> types;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssignmentImpl()
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
    return SmiPackage.Literals.ASSIGNMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Macro getMacros()
  {
    return macros;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMacros(Macro newMacros, NotificationChain msgs)
  {
    Macro oldMacros = macros;
    macros = newMacros;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.ASSIGNMENT__MACROS, oldMacros, newMacros);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMacros(Macro newMacros)
  {
    if (newMacros != macros)
    {
      NotificationChain msgs = null;
      if (macros != null)
        msgs = ((InternalEObject)macros).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ASSIGNMENT__MACROS, null, msgs);
      if (newMacros != null)
        msgs = ((InternalEObject)newMacros).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ASSIGNMENT__MACROS, null, msgs);
      msgs = basicSetMacros(newMacros, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.ASSIGNMENT__MACROS, newMacros, newMacros));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ValueAssignment> getTypes()
  {
    if (types == null)
    {
      types = new EObjectContainmentEList<ValueAssignment>(ValueAssignment.class, this, SmiPackage.ASSIGNMENT__TYPES);
    }
    return types;
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
      case SmiPackage.ASSIGNMENT__MACROS:
        return basicSetMacros(null, msgs);
      case SmiPackage.ASSIGNMENT__TYPES:
        return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
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
      case SmiPackage.ASSIGNMENT__MACROS:
        return getMacros();
      case SmiPackage.ASSIGNMENT__TYPES:
        return getTypes();
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
      case SmiPackage.ASSIGNMENT__MACROS:
        setMacros((Macro)newValue);
        return;
      case SmiPackage.ASSIGNMENT__TYPES:
        getTypes().clear();
        getTypes().addAll((Collection<? extends ValueAssignment>)newValue);
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
      case SmiPackage.ASSIGNMENT__MACROS:
        setMacros((Macro)null);
        return;
      case SmiPackage.ASSIGNMENT__TYPES:
        getTypes().clear();
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
      case SmiPackage.ASSIGNMENT__MACROS:
        return macros != null;
      case SmiPackage.ASSIGNMENT__TYPES:
        return types != null && !types.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AssignmentImpl
