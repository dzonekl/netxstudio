/**
 * Copyright (c) 2011 NetXForge
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

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.NetXResource;

import com.netxforge.netxstudio.services.ServiceDistribution;
import com.netxforge.netxstudio.services.ServicesPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

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
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceDistributionImpl#getServiceResources <em>Service Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceDistributionImpl#getExpressionRefs <em>Expression Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceDistributionImpl extends EObjectImpl implements ServiceDistribution {
	/**
	 * The cached value of the '{@link #getServiceResources() <em>Service Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceResources()
	 * @generated
	 * @ordered
	 */
	protected EList<NetXResource> serviceResources;

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
	public EList<NetXResource> getServiceResources() {
		if (serviceResources == null) {
			serviceResources = new EObjectContainmentEList<NetXResource>(NetXResource.class, this, ServicesPackage.SERVICE_DISTRIBUTION__SERVICE_RESOURCES);
		}
		return serviceResources;
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
			case ServicesPackage.SERVICE_DISTRIBUTION__SERVICE_RESOURCES:
				return ((InternalEList<?>)getServiceResources()).basicRemove(otherEnd, msgs);
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
			case ServicesPackage.SERVICE_DISTRIBUTION__SERVICE_RESOURCES:
				return getServiceResources();
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
			case ServicesPackage.SERVICE_DISTRIBUTION__SERVICE_RESOURCES:
				getServiceResources().clear();
				getServiceResources().addAll((Collection<? extends NetXResource>)newValue);
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
			case ServicesPackage.SERVICE_DISTRIBUTION__SERVICE_RESOURCES:
				getServiceResources().clear();
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
			case ServicesPackage.SERVICE_DISTRIBUTION__SERVICE_RESOURCES:
				return serviceResources != null && !serviceResources.isEmpty();
			case ServicesPackage.SERVICE_DISTRIBUTION__EXPRESSION_REFS:
				return expressionRefs != null && !expressionRefs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ServiceDistributionImpl
