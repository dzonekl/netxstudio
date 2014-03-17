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
package com.netxforge.netxstudio.services;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.netxforge.netxstudio.services.ServicesPackage
 * @generated
 */
public interface ServicesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServicesFactory eINSTANCE = com.netxforge.netxstudio.services.impl.ServicesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CFS Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CFS Service</em>'.
	 * @generated
	 */
	CFSService createCFSService();

	/**
	 * Returns a new object of class '<em>CIID</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CIID</em>'.
	 * @generated
	 */
	CIID createCIID();

	/**
	 * Returns a new object of class '<em>Derived Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Derived Resource</em>'.
	 * @generated
	 */
	DerivedResource createDerivedResource();

	/**
	 * Returns a new object of class '<em>Distribution Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Distribution Entry</em>'.
	 * @generated
	 */
	DistributionEntry createDistributionEntry();

	/**
	 * Returns a new object of class '<em>RFS Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>RFS Service</em>'.
	 * @generated
	 */
	RFSService createRFSService();

	/**
	 * Returns a new object of class '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service</em>'.
	 * @generated
	 */
	Service createService();

	/**
	 * Returns a new object of class '<em>Service Distribution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Distribution</em>'.
	 * @generated
	 */
	ServiceDistribution createServiceDistribution();

	/**
	 * Returns a new object of class '<em>Service Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Flow</em>'.
	 * @generated
	 */
	ServiceFlow createServiceFlow();

	/**
	 * Returns a new object of class '<em>Service Flow Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Flow Relationship</em>'.
	 * @generated
	 */
	ServiceFlowRelationship createServiceFlowRelationship();

	/**
	 * Returns a new object of class '<em>Service Forecast</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Forecast</em>'.
	 * @generated
	 */
	ServiceForecast createServiceForecast();

	/**
	 * Returns a new object of class '<em>Service Forecast Users</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Forecast Users</em>'.
	 * @generated
	 */
	ServiceForecastUsers createServiceForecastUsers();

	/**
	 * Returns a new object of class '<em>Service Monitor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Monitor</em>'.
	 * @generated
	 */
	ServiceMonitor createServiceMonitor();

	/**
	 * Returns a new object of class '<em>Service Profile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Profile</em>'.
	 * @generated
	 */
	ServiceProfile createServiceProfile();

	/**
	 * Returns a new object of class '<em>Service User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service User</em>'.
	 * @generated
	 */
	ServiceUser createServiceUser();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ServicesPackage getServicesPackage();

} //ServicesFactory
