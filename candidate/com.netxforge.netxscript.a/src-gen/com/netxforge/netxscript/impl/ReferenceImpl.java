/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.impl;

import com.netxforge.netxscript.NativeFunction;
import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.Reference;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.impl.ReferenceImpl#getNativeFunction <em>Native Function</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.ReferenceImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.ReferenceImpl#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceImpl extends ExpressionImpl implements Reference
{
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
   * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNodes()
   * @generated
   * @ordered
   */
  protected EList<Reference> nodes;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected Reference ref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReferenceImpl()
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
    return NetxscriptPackage.Literals.REFERENCE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.REFERENCE__NATIVE_FUNCTION, oldNativeFunction, nativeFunction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Reference> getNodes()
  {
    if (nodes == null)
    {
      nodes = new EObjectContainmentEList<Reference>(Reference.class, this, NetxscriptPackage.REFERENCE__NODES);
    }
    return nodes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Reference getRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRef(Reference newRef, NotificationChain msgs)
  {
    Reference oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetxscriptPackage.REFERENCE__REF, oldRef, newRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(Reference newRef)
  {
    if (newRef != ref)
    {
      NotificationChain msgs = null;
      if (ref != null)
        msgs = ((InternalEObject)ref).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.REFERENCE__REF, null, msgs);
      if (newRef != null)
        msgs = ((InternalEObject)newRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.REFERENCE__REF, null, msgs);
      msgs = basicSetRef(newRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.REFERENCE__REF, newRef, newRef));
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
      case NetxscriptPackage.REFERENCE__NODES:
        return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
      case NetxscriptPackage.REFERENCE__REF:
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
      case NetxscriptPackage.REFERENCE__NATIVE_FUNCTION:
        return getNativeFunction();
      case NetxscriptPackage.REFERENCE__NODES:
        return getNodes();
      case NetxscriptPackage.REFERENCE__REF:
        return getRef();
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
      case NetxscriptPackage.REFERENCE__NATIVE_FUNCTION:
        setNativeFunction((NativeFunction)newValue);
        return;
      case NetxscriptPackage.REFERENCE__NODES:
        getNodes().clear();
        getNodes().addAll((Collection<? extends Reference>)newValue);
        return;
      case NetxscriptPackage.REFERENCE__REF:
        setRef((Reference)newValue);
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
      case NetxscriptPackage.REFERENCE__NATIVE_FUNCTION:
        setNativeFunction(NATIVE_FUNCTION_EDEFAULT);
        return;
      case NetxscriptPackage.REFERENCE__NODES:
        getNodes().clear();
        return;
      case NetxscriptPackage.REFERENCE__REF:
        setRef((Reference)null);
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
      case NetxscriptPackage.REFERENCE__NATIVE_FUNCTION:
        return nativeFunction != NATIVE_FUNCTION_EDEFAULT;
      case NetxscriptPackage.REFERENCE__NODES:
        return nodes != null && !nodes.isEmpty();
      case NetxscriptPackage.REFERENCE__REF:
        return ref != null;
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

} //ReferenceImpl
