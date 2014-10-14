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
package com.netxforge.netxstudio.scheduling;

import com.netxforge.netxstudio.services.RFSService;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>RFS Service Monitoring Job</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A job computing capacity and utilization for a
 * 				service.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob#getRFSService <em>RFS Service</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getRFSServiceMonitoringJob()
 * @model extendedMetaData="name='RFSServiceMonitoringJob' kind='elementOnly'"
 * @generated
 */
public interface RFSServiceMonitoringJob extends Job {
	/**
	 * Returns the value of the '<em><b>RFS Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to the RFSService for which the job
	 * 								runs.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>RFS Service</em>' reference.
	 * @see #setRFSService(RFSService)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getRFSServiceMonitoringJob_RFSService()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='RFSService'"
	 * @generated
	 */
	RFSService getRFSService();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob#getRFSService <em>RFS Service</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>RFS Service</em>' reference.
	 * @see #getRFSService()
	 * @generated
	 */
	void setRFSService(RFSService value);

} // RFSServiceMonitoringJob
