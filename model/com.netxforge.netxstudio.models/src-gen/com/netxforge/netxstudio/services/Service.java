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

import com.netxforge.netxstudio.generics.Base;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a service. A Service has a
 * 				name, a Description, a Category and other information.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.Service#getCIID <em>CIID</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.Service#getServices <em>Services</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.Service#getServiceForecasts <em>Service Forecasts</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.Service#getServiceMonitors <em>Service Monitors</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.Service#getServiceUserRefs <em>Service User Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.Service#getServiceDistribution <em>Service Distribution</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.Service#getServiceCategory <em>Service Category</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.Service#getServiceClass <em>Service Class</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.Service#getServiceDescription <em>Service Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.Service#getServiceName <em>Service Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.services.ServicesPackage#getService()
 * @model extendedMetaData="name='Service' kind='elementOnly'"
 * @generated
 */
public interface Service extends Base {
	/**
	 * Returns the value of the '<em><b>CIID</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.services.CIID}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 								The CIID reference, contains 0 or more CI-ID
	 * 								type. This is to map capacity management with
	 * 								other processes in
	 * 								the Service Assurance domain.
	 * 								(Incident, Problem and Change
	 * 								management).
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>CIID</em>' containment reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getService_CIID()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='CIID'"
	 * @generated
	 */
	EList<CIID> getCIID();

	/**
	 * Returns the value of the '<em><b>Services</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.services.Service}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 								The Services reference, contains 0 or more
	 * 								Service types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Services</em>' containment reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getService_Services()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Services'"
	 * @generated
	 */
	EList<Service> getServices();

	/**
	 * Returns the value of the '<em><b>Service Forecasts</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.services.ServiceForecast}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 								The ServiceForecasts reference, contains 0 or
	 * 								more ServiceForecast types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service Forecasts</em>' containment reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getService_ServiceForecasts()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ServiceForecasts'"
	 * @generated
	 */
	EList<ServiceForecast> getServiceForecasts();

	/**
	 * Returns the value of the '<em><b>Service Monitors</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.services.ServiceMonitor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 								The ServiceMonitors reference, contains 0 or
	 * 								more
	 * 								ServiceMonitor types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service Monitors</em>' containment reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getService_ServiceMonitors()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ServiceMonitors'"
	 * @generated
	 */
	EList<ServiceMonitor> getServiceMonitors();

	/**
	 * Returns the value of the '<em><b>Service User Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.services.ServiceUser}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 								The ServiceUserRefs reference, references 0 or
	 * 								more ServiceUserRef types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service User Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getService_ServiceUserRefs()
	 * @model extendedMetaData="kind='element' name='ServiceUserRefs'"
	 * @generated
	 */
	EList<ServiceUser> getServiceUserRefs();

	/**
	 * Returns the value of the '<em><b>Service Distribution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ServiceDistrubution reference, contains 0
	 * 								or
	 * 								1 ServiceDistribution type
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service Distribution</em>' containment reference.
	 * @see #setServiceDistribution(ServiceDistribution)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getService_ServiceDistribution()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ServiceDistribution'"
	 * @generated
	 */
	ServiceDistribution getServiceDistribution();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.Service#getServiceDistribution <em>Service Distribution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Distribution</em>' containment reference.
	 * @see #getServiceDistribution()
	 * @generated
	 */
	void setServiceDistribution(ServiceDistribution value);

	/**
	 * Returns the value of the '<em><b>Service Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * CI Group / OM Service Group (Service Category)
	 * 							The
	 * 							Service Category is used for a logical cluster of
	 * 							the service
	 * 
	 * 							Examples:
	 * 							1. Voice/Telephony (peer to peer)
	 * 							2. Voice and Video
	 * 							conferencing (multi peer)
	 * 							3. Content delivery Data delivery
	 * 							Messaging
	 * 							4. Customer Self Administration
	 * 							5. Customer Care
	 * 							Administration
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service Category</em>' attribute.
	 * @see #setServiceCategory(String)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getService_ServiceCategory()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='ServiceCategory'"
	 * @generated
	 */
	String getServiceCategory();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.Service#getServiceCategory <em>Service Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Category</em>' attribute.
	 * @see #getServiceCategory()
	 * @generated
	 */
	void setServiceCategory(String value);

	/**
	 * Returns the value of the '<em><b>Service Class</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.services.ServiceClassType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Offered classes of provided service:
	 * 							Gold/Silver/Bronze This is implicite the business priority
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service Class</em>' attribute.
	 * @see com.netxforge.netxstudio.services.ServiceClassType
	 * @see #isSetServiceClass()
	 * @see #unsetServiceClass()
	 * @see #setServiceClass(ServiceClassType)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getService_ServiceClass()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='ServiceClass'"
	 * @generated
	 */
	ServiceClassType getServiceClass();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.Service#getServiceClass <em>Service Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Class</em>' attribute.
	 * @see com.netxforge.netxstudio.services.ServiceClassType
	 * @see #isSetServiceClass()
	 * @see #unsetServiceClass()
	 * @see #getServiceClass()
	 * @generated
	 */
	void setServiceClass(ServiceClassType value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.services.Service#getServiceClass <em>Service Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetServiceClass()
	 * @see #getServiceClass()
	 * @see #setServiceClass(ServiceClassType)
	 * @generated
	 */
	void unsetServiceClass();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.services.Service#getServiceClass <em>Service Class</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Service Class</em>' attribute is set.
	 * @see #unsetServiceClass()
	 * @see #getServiceClass()
	 * @see #setServiceClass(ServiceClassType)
	 * @generated
	 */
	boolean isSetServiceClass();

	/**
	 * Returns the value of the '<em><b>Service Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ServiceDescription attribute, holds the
	 * 							Description of the service.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service Description</em>' attribute.
	 * @see #setServiceDescription(String)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getService_ServiceDescription()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='ServiceDescription'"
	 * @generated
	 */
	String getServiceDescription();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.Service#getServiceDescription <em>Service Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Description</em>' attribute.
	 * @see #getServiceDescription()
	 * @generated
	 */
	void setServiceDescription(String value);

	/**
	 * Returns the value of the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ServiceName attribute, holds the name of the
	 * 							service.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service Name</em>' attribute.
	 * @see #setServiceName(String)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getService_ServiceName()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='ServiceName'"
	 * @generated
	 */
	String getServiceName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.Service#getServiceName <em>Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Name</em>' attribute.
	 * @see #getServiceName()
	 * @generated
	 */
	void setServiceName(String value);

} // Service
