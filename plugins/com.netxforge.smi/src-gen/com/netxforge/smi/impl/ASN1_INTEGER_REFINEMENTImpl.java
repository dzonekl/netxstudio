/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.ASN1_INTEGER_REFINEMENT;
import com.netxforge.smi.SmiPackage;

import java.math.BigInteger;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ASN1 INTEGER REFINEMENT</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.ASN1_INTEGER_REFINEMENTImpl#getRefinements <em>Refinements</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ASN1_INTEGER_REFINEMENTImpl#getInts <em>Ints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ASN1_INTEGER_REFINEMENTImpl extends MinimalEObjectImpl.Container implements ASN1_INTEGER_REFINEMENT
{
  /**
   * The cached value of the '{@link #getRefinements() <em>Refinements</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefinements()
   * @generated
   * @ordered
   */
  protected EList<String> refinements;

  /**
   * The cached value of the '{@link #getInts() <em>Ints</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInts()
   * @generated
   * @ordered
   */
  protected EList<BigInteger> ints;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ASN1_INTEGER_REFINEMENTImpl()
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
    return SmiPackage.Literals.ASN1_INTEGER_REFINEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getRefinements()
  {
    if (refinements == null)
    {
      refinements = new EDataTypeEList<String>(String.class, this, SmiPackage.ASN1_INTEGER_REFINEMENT__REFINEMENTS);
    }
    return refinements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<BigInteger> getInts()
  {
    if (ints == null)
    {
      ints = new EDataTypeEList<BigInteger>(BigInteger.class, this, SmiPackage.ASN1_INTEGER_REFINEMENT__INTS);
    }
    return ints;
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
      case SmiPackage.ASN1_INTEGER_REFINEMENT__REFINEMENTS:
        return getRefinements();
      case SmiPackage.ASN1_INTEGER_REFINEMENT__INTS:
        return getInts();
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
      case SmiPackage.ASN1_INTEGER_REFINEMENT__REFINEMENTS:
        getRefinements().clear();
        getRefinements().addAll((Collection<? extends String>)newValue);
        return;
      case SmiPackage.ASN1_INTEGER_REFINEMENT__INTS:
        getInts().clear();
        getInts().addAll((Collection<? extends BigInteger>)newValue);
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
      case SmiPackage.ASN1_INTEGER_REFINEMENT__REFINEMENTS:
        getRefinements().clear();
        return;
      case SmiPackage.ASN1_INTEGER_REFINEMENT__INTS:
        getInts().clear();
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
      case SmiPackage.ASN1_INTEGER_REFINEMENT__REFINEMENTS:
        return refinements != null && !refinements.isEmpty();
      case SmiPackage.ASN1_INTEGER_REFINEMENT__INTS:
        return ints != null && !ints.isEmpty();
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
    result.append(" (refinements: ");
    result.append(refinements);
    result.append(", ints: ");
    result.append(ints);
    result.append(')');
    return result.toString();
  }

} //ASN1_INTEGER_REFINEMENTImpl
