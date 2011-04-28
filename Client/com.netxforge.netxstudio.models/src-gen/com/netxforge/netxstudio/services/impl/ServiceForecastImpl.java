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

import com.netxforge.netxstudio.generics.DateTimeRange;

import com.netxforge.netxstudio.operators.ResourceForecast;

import com.netxforge.netxstudio.services.ServiceForecast;
import com.netxforge.netxstudio.services.ServiceForecastUsers;
import com.netxforge.netxstudio.services.ServicesPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Forecast</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceForecastImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceForecastImpl#getServiceForecastUsers <em>Service Forecast Users</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceForecastImpl#getResourceForecasts <em>Resource Forecasts</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceForecastImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceForecastImpl#getRevision <em>Revision</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceForecastImpl extends EObjectImpl implements ServiceForecast {
	/**
	 * The cached value of the '{@link #getPeriod() <em>Period</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected DateTimeRange period;

	/**
	 * The cached value of the '{@link #getServiceForecastUsers() <em>Service Forecast Users</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceForecastUsers()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceForecastUsers> serviceForecastUsers;

	/**
	 * The cached value of the '{@link #getResourceForecasts() <em>Resource Forecasts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceForecasts()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceForecast> resourceForecasts;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRevision() <em>Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevision()
	 * @generated
	 * @ordered
	 */
	protected static final String REVISION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRevision() <em>Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevision()
	 * @generated
	 * @ordered
	 */
	protected String revision = REVISION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceForecastImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicesPackage.Literals.SERVICE_FORECAST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DateTimeRange getPeriod() {
		return period;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPeriod(DateTimeRange newPeriod, NotificationChain msgs) {
		DateTimeRange oldPeriod = period;
		period = newPeriod;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE_FORECAST__PERIOD, oldPeriod, newPeriod);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriod(DateTimeRange newPeriod) {
		if (newPeriod != period) {
			NotificationChain msgs = null;
			if (period != null)
				msgs = ((InternalEObject)period).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicesPackage.SERVICE_FORECAST__PERIOD, null, msgs);
			if (newPeriod != null)
				msgs = ((InternalEObject)newPeriod).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicesPackage.SERVICE_FORECAST__PERIOD, null, msgs);
			msgs = basicSetPeriod(newPeriod, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE_FORECAST__PERIOD, newPeriod, newPeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceForecastUsers> getServiceForecastUsers() {
		if (serviceForecastUsers == null) {
			serviceForecastUsers = new EObjectContainmentEList<ServiceForecastUsers>(ServiceForecastUsers.class, this, ServicesPackage.SERVICE_FORECAST__SERVICE_FORECAST_USERS);
		}
		return serviceForecastUsers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceForecast> getResourceForecasts() {
		if (resourceForecasts == null) {
			resourceForecasts = new EObjectContainmentEList<ResourceForecast>(ResourceForecast.class, this, ServicesPackage.SERVICE_FORECAST__RESOURCE_FORECASTS);
		}
		return resourceForecasts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE_FORECAST__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRevision() {
		return revision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevision(String newRevision) {
		String oldRevision = revision;
		revision = newRevision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE_FORECAST__REVISION, oldRevision, revision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicesPackage.SERVICE_FORECAST__PERIOD:
				return basicSetPeriod(null, msgs);
			case ServicesPackage.SERVICE_FORECAST__SERVICE_FORECAST_USERS:
				return ((InternalEList<?>)getServiceForecastUsers()).basicRemove(otherEnd, msgs);
			case ServicesPackage.SERVICE_FORECAST__RESOURCE_FORECASTS:
				return ((InternalEList<?>)getResourceForecasts()).basicRemove(otherEnd, msgs);
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
			case ServicesPackage.SERVICE_FORECAST__PERIOD:
				return getPeriod();
			case ServicesPackage.SERVICE_FORECAST__SERVICE_FORECAST_USERS:
				return getServiceForecastUsers();
			case ServicesPackage.SERVICE_FORECAST__RESOURCE_FORECASTS:
				return getResourceForecasts();
			case ServicesPackage.SERVICE_FORECAST__NAME:
				return getName();
			case ServicesPackage.SERVICE_FORECAST__REVISION:
				return getRevision();
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
			case ServicesPackage.SERVICE_FORECAST__PERIOD:
				setPeriod((DateTimeRange)newValue);
				return;
			case ServicesPackage.SERVICE_FORECAST__SERVICE_FORECAST_USERS:
				getServiceForecastUsers().clear();
				getServiceForecastUsers().addAll((Collection<? extends ServiceForecastUsers>)newValue);
				return;
			case ServicesPackage.SERVICE_FORECAST__RESOURCE_FORECASTS:
				getResourceForecasts().clear();
				getResourceForecasts().addAll((Collection<? extends ResourceForecast>)newValue);
				return;
			case ServicesPackage.SERVICE_FORECAST__NAME:
				setName((String)newValue);
				return;
			case ServicesPackage.SERVICE_FORECAST__REVISION:
				setRevision((String)newValue);
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
			case ServicesPackage.SERVICE_FORECAST__PERIOD:
				setPeriod((DateTimeRange)null);
				return;
			case ServicesPackage.SERVICE_FORECAST__SERVICE_FORECAST_USERS:
				getServiceForecastUsers().clear();
				return;
			case ServicesPackage.SERVICE_FORECAST__RESOURCE_FORECASTS:
				getResourceForecasts().clear();
				return;
			case ServicesPackage.SERVICE_FORECAST__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ServicesPackage.SERVICE_FORECAST__REVISION:
				setRevision(REVISION_EDEFAULT);
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
			case ServicesPackage.SERVICE_FORECAST__PERIOD:
				return period != null;
			case ServicesPackage.SERVICE_FORECAST__SERVICE_FORECAST_USERS:
				return serviceForecastUsers != null && !serviceForecastUsers.isEmpty();
			case ServicesPackage.SERVICE_FORECAST__RESOURCE_FORECASTS:
				return resourceForecasts != null && !resourceForecasts.isEmpty();
			case ServicesPackage.SERVICE_FORECAST__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ServicesPackage.SERVICE_FORECAST__REVISION:
				return REVISION_EDEFAULT == null ? revision != null : !REVISION_EDEFAULT.equals(revision);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", revision: ");
		result.append(revision);
		result.append(')');
		return result.toString();
	}

} //ServiceForecastImpl
