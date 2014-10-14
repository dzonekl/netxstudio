/**
 * Copyright (c) 2014 NetXForge
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors:
 * Christophe Bouhier - initial API and implementation and/or initial documentation
 */
package com.netxforge.netxstudio.services.impl;

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.library.Expression;

import com.netxforge.netxstudio.services.DistributionEntry;
import com.netxforge.netxstudio.services.ServiceDistribution;
import com.netxforge.netxstudio.services.ServicesPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Distribution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceDistributionImpl#getDistributionEntries <em>Distribution Entries</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceDistributionImpl#getExpressionRefs <em>Expression Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceDistributionImpl extends BaseImpl implements ServiceDistribution {
	/**
	 * The cached value of the '{@link #getDistributionEntries() <em>Distribution Entries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistributionEntries()
	 * @generated
	 * @ordered
	 */
	protected EList<DistributionEntry> distributionEntries;

	/**
	 * The cached value of the '{@link #getExpressionRefs() <em>Expression Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> expressionRefs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceDistributionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicesPackage.Literals.SERVICE_DISTRIBUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DistributionEntry> getDistributionEntries() {
		if (distributionEntries == null) {
			distributionEntries = new EObjectContainmentEList<DistributionEntry>(DistributionEntry.class, this, ServicesPackage.SERVICE_DISTRIBUTION__DISTRIBUTION_ENTRIES);
		}
		return distributionEntries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getExpressionRefs() {
		if (expressionRefs == null) {
			expressionRefs = new EObjectResolvingEList<Expression>(Expression.class, this, ServicesPackage.SERVICE_DISTRIBUTION__EXPRESSION_REFS);
		}
		return expressionRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicesPackage.SERVICE_DISTRIBUTION__DISTRIBUTION_ENTRIES:
				return ((InternalEList<?>)getDistributionEntries()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicesPackage.SERVICE_DISTRIBUTION__DISTRIBUTION_ENTRIES:
				return getDistributionEntries();
			case ServicesPackage.SERVICE_DISTRIBUTION__EXPRESSION_REFS:
				return getExpressionRefs();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ServicesPackage.SERVICE_DISTRIBUTION__DISTRIBUTION_ENTRIES:
				getDistributionEntries().clear();
				getDistributionEntries().addAll((Collection<? extends DistributionEntry>)newValue);
				return;
			case ServicesPackage.SERVICE_DISTRIBUTION__EXPRESSION_REFS:
				getExpressionRefs().clear();
				getExpressionRefs().addAll((Collection<? extends Expression>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case ServicesPackage.SERVICE_DISTRIBUTION__DISTRIBUTION_ENTRIES:
				getDistributionEntries().clear();
				return;
			case ServicesPackage.SERVICE_DISTRIBUTION__EXPRESSION_REFS:
				getExpressionRefs().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ServicesPackage.SERVICE_DISTRIBUTION__DISTRIBUTION_ENTRIES:
				return distributionEntries != null && !distributionEntries.isEmpty();
			case ServicesPackage.SERVICE_DISTRIBUTION__EXPRESSION_REFS:
				return expressionRefs != null && !expressionRefs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ServiceDistributionImpl
