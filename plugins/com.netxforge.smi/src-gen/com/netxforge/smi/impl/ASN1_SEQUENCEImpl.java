/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.ASN1_CHOICE_ENTRY;
import com.netxforge.smi.ASN1_SEQUENCE;
import com.netxforge.smi.SmiPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ASN1 SEQUENCE</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.ASN1_SEQUENCEImpl#getChoiceType <em>Choice Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ASN1_SEQUENCEImpl extends ASN1_TYPEImpl implements ASN1_SEQUENCE
{
  /**
   * The cached value of the '{@link #getChoiceType() <em>Choice Type</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChoiceType()
   * @generated
   * @ordered
   */
  protected EList<ASN1_CHOICE_ENTRY> choiceType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ASN1_SEQUENCEImpl()
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
    return SmiPackage.Literals.ASN1_SEQUENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ASN1_CHOICE_ENTRY> getChoiceType()
  {
    if (choiceType == null)
    {
      choiceType = new EObjectContainmentEList<ASN1_CHOICE_ENTRY>(ASN1_CHOICE_ENTRY.class, this, SmiPackage.ASN1_SEQUENCE__CHOICE_TYPE);
    }
    return choiceType;
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
      case SmiPackage.ASN1_SEQUENCE__CHOICE_TYPE:
        return ((InternalEList<?>)getChoiceType()).basicRemove(otherEnd, msgs);
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
      case SmiPackage.ASN1_SEQUENCE__CHOICE_TYPE:
        return getChoiceType();
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
      case SmiPackage.ASN1_SEQUENCE__CHOICE_TYPE:
        getChoiceType().clear();
        getChoiceType().addAll((Collection<? extends ASN1_CHOICE_ENTRY>)newValue);
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
      case SmiPackage.ASN1_SEQUENCE__CHOICE_TYPE:
        getChoiceType().clear();
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
      case SmiPackage.ASN1_SEQUENCE__CHOICE_TYPE:
        return choiceType != null && !choiceType.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ASN1_SEQUENCEImpl
