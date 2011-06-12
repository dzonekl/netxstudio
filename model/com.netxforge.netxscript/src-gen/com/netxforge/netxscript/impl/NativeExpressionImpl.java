/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.impl;

import com.netxforge.netxscript.Expression;
import com.netxforge.netxscript.NativeExpression;
import com.netxforge.netxscript.NativeFunction;
import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.Range;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Native Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.impl.NativeExpressionImpl#getRange <em>Range</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.NativeExpressionImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.NativeExpressionImpl#getNativeFunction <em>Native Function</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NativeExpressionImpl extends ExpressionImpl implements NativeExpression
{
  /**
   * The cached value of the '{@link #getRange() <em>Range</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRange()
   * @generated
   * @ordered
   */
  protected Range range;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected Expression ref;

  /**
   * The default value of the '{@link #getNativeFunction() <em>Native Function</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNativeFunction()
   * @generated
   * @ordered
   */
  protected static final NativeFunction NATIVE_FUNCTION_EDEFAULT = NativeFunction.COUNT;

  /**
   * The cached value of the '{@link #getNativeFunction() <em>Native Function</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNativeFunction()
   * @generated
   * @ordered
   */
  protected NativeFunction nativeFunction = NATIVE_FUNCTION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NativeExpressionImpl()
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
    return NetxscriptPackage.Literals.NATIVE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Range getRange()
  {
    return range;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRange(Range newRange, NotificationChain msgs)
  {
    Range oldRange = range;
    range = newRange;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetxscriptPackage.NATIVE_EXPRESSION__RANGE, oldRange, newRange);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRange(Range newRange)
  {
    if (newRange != range)
    {
      NotificationChain msgs = null;
      if (range != null)
        msgs = ((InternalEObject)range).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.NATIVE_EXPRESSION__RANGE, null, msgs);
      if (newRange != null)
        msgs = ((InternalEObject)newRange).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.NATIVE_EXPRESSION__RANGE, null, msgs);
      msgs = basicSetRange(newRange, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.NATIVE_EXPRESSION__RANGE, newRange, newRange));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRef(Expression newRef, NotificationChain msgs)
  {
    Expression oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetxscriptPackage.NATIVE_EXPRESSION__REF, oldRef, newRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(Expression newRef)
  {
    if (newRef != ref)
    {
      NotificationChain msgs = null;
      if (ref != null)
        msgs = ((InternalEObject)ref).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.NATIVE_EXPRESSION__REF, null, msgs);
      if (newRef != null)
        msgs = ((InternalEObject)newRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.NATIVE_EXPRESSION__REF, null, msgs);
      msgs = basicSetRef(newRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.NATIVE_EXPRESSION__REF, newRef, newRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NativeFunction getNativeFunction()
  {
    return nativeFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNativeFunction(NativeFunction newNativeFunction)
  {
    NativeFunction oldNativeFunction = nativeFunction;
    nativeFunction = newNativeFunction == null ? NATIVE_FUNCTION_EDEFAULT : newNativeFunction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.NATIVE_EXPRESSION__NATIVE_FUNCTION, oldNativeFunction, nativeFunction));
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
      case NetxscriptPackage.NATIVE_EXPRESSION__RANGE:
        return basicSetRange(null, msgs);
      case NetxscriptPackage.NATIVE_EXPRESSION__REF:
        return basicSetRef(null, msgs);
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
      case NetxscriptPackage.NATIVE_EXPRESSION__RANGE:
        return getRange();
      case NetxscriptPackage.NATIVE_EXPRESSION__REF:
        return getRef();
      case NetxscriptPackage.NATIVE_EXPRESSION__NATIVE_FUNCTION:
        return getNativeFunction();
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
      case NetxscriptPackage.NATIVE_EXPRESSION__RANGE:
        setRange((Range)newValue);
        return;
      case NetxscriptPackage.NATIVE_EXPRESSION__REF:
        setRef((Expression)newValue);
        return;
      case NetxscriptPackage.NATIVE_EXPRESSION__NATIVE_FUNCTION:
        setNativeFunction((NativeFunction)newValue);
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
      case NetxscriptPackage.NATIVE_EXPRESSION__RANGE:
        setRange((Range)null);
        return;
      case NetxscriptPackage.NATIVE_EXPRESSION__REF:
        setRef((Expression)null);
        return;
      case NetxscriptPackage.NATIVE_EXPRESSION__NATIVE_FUNCTION:
        setNativeFunction(NATIVE_FUNCTION_EDEFAULT);
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
      case NetxscriptPackage.NATIVE_EXPRESSION__RANGE:
        return range != null;
      case NetxscriptPackage.NATIVE_EXPRESSION__REF:
        return ref != null;
      case NetxscriptPackage.NATIVE_EXPRESSION__NATIVE_FUNCTION:
        return nativeFunction != NATIVE_FUNCTION_EDEFAULT;
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
    result.append(" (nativeFunction: ");
    result.append(nativeFunction);
    result.append(')');
    return result.toString();
  }

} //NativeExpressionImpl
