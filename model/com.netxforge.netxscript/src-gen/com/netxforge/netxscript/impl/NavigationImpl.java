/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.impl;

import com.netxforge.netxscript.Navigation;
import com.netxforge.netxscript.NetxscriptPackage;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.impl.NavigationImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.NavigationImpl#getEquipment <em>Equipment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NavigationImpl extends MinimalEObjectImpl.Container implements Navigation
{
  /**
   * The cached value of the '{@link #getFunction() <em>Function</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunction()
   * @generated
   * @ordered
   */
  protected Function function;

  /**
   * The cached value of the '{@link #getEquipment() <em>Equipment</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEquipment()
   * @generated
   * @ordered
   */
  protected Equipment equipment;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NavigationImpl()
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
    return NetxscriptPackage.Literals.NAVIGATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function getFunction()
  {
    if (function != null && ((EObject)function).eIsProxy())
    {
      InternalEObject oldFunction = (InternalEObject)function;
      function = (Function)eResolveProxy(oldFunction);
      if (function != oldFunction)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetxscriptPackage.NAVIGATION__FUNCTION, oldFunction, function));
      }
    }
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function basicGetFunction()
  {
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunction(Function newFunction)
  {
    Function oldFunction = function;
    function = newFunction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.NAVIGATION__FUNCTION, oldFunction, function));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Equipment getEquipment()
  {
    if (equipment != null && ((EObject)equipment).eIsProxy())
    {
      InternalEObject oldEquipment = (InternalEObject)equipment;
      equipment = (Equipment)eResolveProxy(oldEquipment);
      if (equipment != oldEquipment)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetxscriptPackage.NAVIGATION__EQUIPMENT, oldEquipment, equipment));
      }
    }
    return equipment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Equipment basicGetEquipment()
  {
    return equipment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEquipment(Equipment newEquipment)
  {
    Equipment oldEquipment = equipment;
    equipment = newEquipment;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.NAVIGATION__EQUIPMENT, oldEquipment, equipment));
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
      case NetxscriptPackage.NAVIGATION__FUNCTION:
        if (resolve) return getFunction();
        return basicGetFunction();
      case NetxscriptPackage.NAVIGATION__EQUIPMENT:
        if (resolve) return getEquipment();
        return basicGetEquipment();
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
      case NetxscriptPackage.NAVIGATION__FUNCTION:
        setFunction((Function)newValue);
        return;
      case NetxscriptPackage.NAVIGATION__EQUIPMENT:
        setEquipment((Equipment)newValue);
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
      case NetxscriptPackage.NAVIGATION__FUNCTION:
        setFunction((Function)null);
        return;
      case NetxscriptPackage.NAVIGATION__EQUIPMENT:
        setEquipment((Equipment)null);
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
      case NetxscriptPackage.NAVIGATION__FUNCTION:
        return function != null;
      case NetxscriptPackage.NAVIGATION__EQUIPMENT:
        return equipment != null;
    }
    return super.eIsSet(featureID);
  }

} //NavigationImpl
