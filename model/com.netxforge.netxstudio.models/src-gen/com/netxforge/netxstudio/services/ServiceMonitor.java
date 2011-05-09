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

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.operators.ResourceMonitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Monitor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a ServiceMonitor. A ServiceMonitoris a monitoring run for a service, which 
 * has consumed resources. The Monitor applies to a period. The monitor has a name and a revision.
 * 
 * The Monitor can be seen as a window covering a period, for the service, and underlying resources.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceMonitor#getPeriod <em>Period</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceMonitor#getResourceMonitors <em>Resource Monitors</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceMonitor#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceMonitor#getRevision <em>Revision</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceMonitor()
 * @model extendedMetaData="name='ServiceMonitor' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface ServiceMonitor extends CDOObject {
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
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceMonitor_Period()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Period'"
	 * @generated
	 */
	DateTimeRange getPeriod();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceMonitor#getPeriod <em>Period</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' containment reference.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(DateTimeRange value);

	/**
	 * Returns the value of the '<em><b>Resource Monitors</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.ResourceMonitor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ResourceMonitors reference, contains 0 or more ResourceForcast type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resource Monitors</em>' containment reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceMonitor_ResourceMonitors()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ResourceMonitors'"
	 * @generated
	 */
	EList<ResourceMonitor> getResourceMonitors();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute holds the name of the ServiceMonitor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceMonitor_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceMonitor#getName <em>Name</em>}' attribute.
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
	 * The Revision attribute holds the revision of this monitor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Revision</em>' attribute.
	 * @see #setRevision(String)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceMonitor_Revision()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Revision'"
	 * @generated
	 */
	String getRevision();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.ServiceMonitor#getRevision <em>Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revision</em>' attribute.
	 * @see #getRevision()
	 * @generated
	 */
	void setRevision(String value);

} // ServiceMonitor
