/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.impl;

import com.netxforge.netxscript.AbstractVarOrArgument;
import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.VarOrArgumentCall;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Var Or Argument Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.impl.VarOrArgumentCallImpl#getCall <em>Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VarOrArgumentCallImpl extends ExpressionImpl implements VarOrArgumentCall
{
  /**
   * The cached value of the '{@link #getCall() <em>Call</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCall()
   * @generated
   * @ordered
   */
  protected AbstractVarOrArgument call;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VarOrArgumentCallImpl()
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
    return NetxscriptPackage.Literals.VAR_OR_ARGUMENT_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractVarOrArgument getCall()
  {
    if (call != null && call.eIsProxy())
    {
      InternalEObject oldCall = (InternalEObject)call;
      call = (AbstractVarOrArgument)eResolveProxy(oldCall);
      if (call != oldCall)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetxscriptPackage.VAR_OR_ARGUMENT_CALL__CALL, oldCall, call));
      }
    }
    return call;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractVarOrArgument basicGetCall()
  {
    return call;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCall(AbstractVarOrArgument newCall)
  {
    AbstractVarOrArgument oldCall = call;
    call = newCall;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.VAR_OR_ARGUMENT_CALL__CALL, oldCall, call));
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
      case NetxscriptPackage.VAR_OR_ARGUMENT_CALL__CALL:
        if (resolve) return getCall();
        return basicGetCall();
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
      case NetxscriptPackage.VAR_OR_ARGUMENT_CALL__CALL:
        setCall((AbstractVarOrArgument)newValue);
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
      case NetxscriptPackage.VAR_OR_ARGUMENT_CALL__CALL:
        setCall((AbstractVarOrArgument)null);
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
      case NetxscriptPackage.VAR_OR_ARGUMENT_CALL__CALL:
        return call != null;
    }
    return super.eIsSet(featureID);
  }

} //VarOrArgumentCallImpl
