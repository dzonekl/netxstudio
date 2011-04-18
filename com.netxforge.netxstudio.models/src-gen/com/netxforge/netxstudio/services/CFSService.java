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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CFS Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a Customer Facing Service.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.CFSService#getProvider <em>Provider</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.CFSService#getScenario <em>Scenario</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.services.ServicesPackage#getCFSService()
 * @model extendedMetaData="name='CFSService' kind='elementOnly'"
 * @generated
 */
public interface CFSService extends Service {
	/**
	 * Returns the value of the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Provider attributes holds the entity responsible for providing the service.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Provider</em>' attribute.
	 * @see #setProvider(String)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getCFSService_Provider()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Provider'"
	 * @generated
	 */
	String getProvider();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.CFSService#getProvider <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider</em>' attribute.
	 * @see #getProvider()
	 * @generated
	 */
	void setProvider(String value);

	/**
	 * Returns the value of the '<em><b>Scenario</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Scenario attribute, holds a scenario for the service. 
	 * 
	 * Examples:
	 * 1. SMS Mobile 2 Mobile
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Scenario</em>' attribute.
	 * @see #setScenario(String)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getCFSService_Scenario()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Scenario'"
	 * @generated
	 */
	String getScenario();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.CFSService#getScenario <em>Scenario</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scenario</em>' attribute.
	 * @see #getScenario()
	 * @generated
	 */
	void setScenario(String value);

} // CFSService
