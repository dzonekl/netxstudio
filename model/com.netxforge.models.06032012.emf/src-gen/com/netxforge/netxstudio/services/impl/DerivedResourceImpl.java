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

import com.netxforge.netxstudio.generics.Value;

import com.netxforge.netxstudio.library.impl.BaseResourceImpl;

import com.netxforge.netxstudio.services.DerivedResource;
import com.netxforge.netxstudio.services.ServicesPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Derived Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.impl.DerivedResourceImpl#getValues <em>Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.DerivedResourceImpl#getForecastValues <em>Forecast Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.DerivedResourceImpl#getTrendedValues <em>Trended Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DerivedResourceImpl extends BaseResourceImpl implements DerivedResource {
	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> values;

	/**
	 * The cached value of the '{@link #getForecastValues() <em>Forecast Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForecastValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> forecastValues;

	/**
	 * The cached value of the '{@link #getTrendedValues() <em>Trended Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrendedValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> trendedValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DerivedResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicesPackage.Literals.DERIVED_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getValues() {
		if (values == null) {
			values = new EObjectContainmentEList<Value>(Value.class, this, ServicesPackage.DERIVED_RESOURCE__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getForecastValues() {
		if (forecastValues == null) {
			forecastValues = new EObjectContainmentEList<Value>(Value.class, this, ServicesPackage.DERIVED_RESOURCE__FORECAST_VALUES);
		}
		return forecastValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getTrendedValues() {
		if (trendedValues == null) {
			trendedValues = new EObjectContainmentEList<Value>(Value.class, this, ServicesPackage.DERIVED_RESOURCE__TRENDED_VALUES);
		}
		return trendedValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicesPackage.DERIVED_RESOURCE__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
			case ServicesPackage.DERIVED_RESOURCE__FORECAST_VALUES:
				return ((InternalEList<?>)getForecastValues()).basicRemove(otherEnd, msgs);
			case ServicesPackage.DERIVED_RESOURCE__TRENDED_VALUES:
				return ((InternalEList<?>)getTrendedValues()).basicRemove(otherEnd, msgs);
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
			case ServicesPackage.DERIVED_RESOURCE__VALUES:
				return getValues();
			case ServicesPackage.DERIVED_RESOURCE__FORECAST_VALUES:
				return getForecastValues();
			case ServicesPackage.DERIVED_RESOURCE__TRENDED_VALUES:
				return getTrendedValues();
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
			case ServicesPackage.DERIVED_RESOURCE__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends Value>)newValue);
				return;
			case ServicesPackage.DERIVED_RESOURCE__FORECAST_VALUES:
				getForecastValues().clear();
				getForecastValues().addAll((Collection<? extends Value>)newValue);
				return;
			case ServicesPackage.DERIVED_RESOURCE__TRENDED_VALUES:
				getTrendedValues().clear();
				getTrendedValues().addAll((Collection<? extends Value>)newValue);
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
			case ServicesPackage.DERIVED_RESOURCE__VALUES:
				getValues().clear();
				return;
			case ServicesPackage.DERIVED_RESOURCE__FORECAST_VALUES:
				getForecastValues().clear();
				return;
			case ServicesPackage.DERIVED_RESOURCE__TRENDED_VALUES:
				getTrendedValues().clear();
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
			case ServicesPackage.DERIVED_RESOURCE__VALUES:
				return values != null && !values.isEmpty();
			case ServicesPackage.DERIVED_RESOURCE__FORECAST_VALUES:
				return forecastValues != null && !forecastValues.isEmpty();
			case ServicesPackage.DERIVED_RESOURCE__TRENDED_VALUES:
				return trendedValues != null && !trendedValues.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DerivedResourceImpl
