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
package com.netxforge.netxstudio.services;

import com.netxforge.netxstudio.generics.DateTimeRange;

import com.netxforge.netxstudio.operators.ResourceForecast;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Forecast</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a ServiceForecast. A ServiceForecast is a forecast of a service, which 
 * impacts the consumption of resources when using a service. The Forecast applies to a period, and contains Service forecast users.
 * The forecast also has a name and a revision
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceForecast#getPeriod <em>Period</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceForecast#getServiceForecastUsers <em>Service Forecast Users</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceForecast#getResourceForecasts <em>Resource Forecasts</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceForecast#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceForecast#getRevision <em>Revision</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceForecast()
 * @model extendedMetaData="name='ServiceForecast' kind='elementOnly'"
 * @generated
 */
public interface ServiceForecast extends EObject {
	/**
	 * Returns the value of the '<em><b>Period</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Period reference, contains 0 or 1 DatetimeRange types.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Period</em>' containment reference.
	 * @see #setPeriod(DateTimeRange)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceForecast_Period()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Period'"
	 * @generated
	 */
	DateTimeRange getPeriod();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceForecast#getPeriod <em>Period</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' containment reference.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(DateTimeRange value);

	/**
	 * Returns the value of the '<em><b>Service Forecast Users</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.services.ServiceForecastUsers}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ServiceUser reference, contains 0 or more ServiceForecastUsers type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service Forecast Users</em>' containment reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceForecast_ServiceForecastUsers()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ServiceForecastUsers'"
	 * @generated
	 */
	EList<ServiceForecastUsers> getServiceForecastUsers();

	/**
	 * Returns the value of the '<em><b>Resource Forecasts</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.ResourceForecast}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ResourceForcasts reference, contains 0 or more ResourceForcast type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resource Forecasts</em>' containment reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceForecast_ResourceForecasts()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ResourceForecasts'"
	 * @generated
	 */
	EList<ResourceForecast> getResourceForecasts();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute holds the name of the ServiceForecast.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceForecast_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceForecast#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Revision attribute holds the revision of this forecast.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Revision</em>' attribute.
	 * @see #setRevision(String)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceForecast_Revision()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Revision'"
	 * @generated
	 */
	String getRevision();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceForecast#getRevision <em>Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revision</em>' attribute.
	 * @see #getRevision()
	 * @generated
	 */
	void setRevision(String value);

} // ServiceForecast
