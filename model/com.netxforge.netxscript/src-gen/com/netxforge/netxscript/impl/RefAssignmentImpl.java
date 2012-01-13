/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.impl;

import com.netxforge.netxscript.Expression;
import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.RefAssignment;
import com.netxforge.netxscript.Reference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ref Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxscript.impl.RefAssignmentImpl#getAssignmentRef <em>Assignment Ref</em>}</li>
 *   <li>{@link com.netxforge.netxscript.impl.RefAssignmentImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RefAssignmentImpl extends StatementImpl implements RefAssignment
{
  /**
   * The cached value of the '{@link #getAssignmentRef() <em>Assignment Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignmentRef()
   * @generated
   * @ordered
   */
  protected Reference assignmentRef;

  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected Expression expression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RefAssignmentImpl()
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
    return NetxscriptPackage.Literals.REF_ASSIGNMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Reference getAssignmentRef()
  {
    return assignmentRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssignmentRef(Reference newAssignmentRef, NotificationChain msgs)
  {
    Reference oldAssignmentRef = assignmentRef;
    assignmentRef = newAssignmentRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetxscriptPackage.REF_ASSIGNMENT__ASSIGNMENT_REF, oldAssignmentRef, newAssignmentRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssignmentRef(Reference newAssignmentRef)
  {
    if (newAssignmentRef != assignmentRef)
    {
      NotificationChain msgs = null;
      if (assignmentRef != null)
        msgs = ((InternalEObject)assignmentRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.REF_ASSIGNMENT__ASSIGNMENT_REF, null, msgs);
      if (newAssignmentRef != null)
        msgs = ((InternalEObject)newAssignmentRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.REF_ASSIGNMENT__ASSIGNMENT_REF, null, msgs);
      msgs = basicSetAssignmentRef(newAssignmentRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.REF_ASSIGNMENT__ASSIGNMENT_REF, newAssignmentRef, newAssignmentRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs)
  {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetxscriptPackage.REF_ASSIGNMENT__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(Expression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.REF_ASSIGNMENT__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetxscriptPackage.REF_ASSIGNMENT__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NetxscriptPackage.REF_ASSIGNMENT__EXPRESSION, newExpression, newExpression));
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
      case NetxscriptPackage.REF_ASSIGNMENT__ASSIGNMENT_REF:
        return basicSetAssignmentRef(null, msgs);
      case NetxscriptPackage.REF_ASSIGNMENT__EXPRESSION:
        return basicSetExpression(null, msgs);
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
      case NetxscriptPackage.REF_ASSIGNMENT__ASSIGNMENT_REF:
        return getAssignmentRef();
      case NetxscriptPackage.REF_ASSIGNMENT__EXPRESSION:
        return getExpression();
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
      case NetxscriptPackage.REF_ASSIGNMENT__ASSIGNMENT_REF:
        setAssignmentRef((Reference)newValue);
        return;
      case NetxscriptPackage.REF_ASSIGNMENT__EXPRESSION:
        setExpression((Expression)newValue);
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
      case NetxscriptPackage.REF_ASSIGNMENT__ASSIGNMENT_REF:
        setAssignmentRef((Reference)null);
        return;
      case NetxscriptPackage.REF_ASSIGNMENT__EXPRESSION:
        setExpression((Expression)null);
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
      case NetxscriptPackage.REF_ASSIGNMENT__ASSIGNMENT_REF:
        return assignmentRef != null;
      case NetxscriptPackage.REF_ASSIGNMENT__EXPRESSION:
        return expression != null;
    }
    return super.eIsSet(featureID);
  }

} //RefAssignmentImpl
