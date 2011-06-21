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

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.NetXResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Distribution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing how the service is distributed
 * 				across the Nodes.
 * 				How the service is distributed over network depends
 * 				on various factors.
 * 
 * 				1. Geographical spread of the service.
 * 				2. Service
 * 				distribution mechanism implemented for functions.
 * 				3. Overall network
 * 				conditions i.e. load or specific node conditions,
 * 				and measures for
 * 				overload.
 * 
 * 				The service distribution is derived from the node
 * 				resources. The
 * 				service distribution contains therefor the definition
 * 				of "service resources" and expressions to populate these resources.
 * 				(The expression is expected to add node resource values together
 * 				and
 * 				store the result in the defined Service Resource )
 * 
 * 				TODO, The
 * 				distribution should be organized by Function in order to
 * 				present it
 * 				as such. As the resource, is likely a copy of the
 * 				a Function
 * 				resource, we could perhaps keep a reference to the node
 * 				Function,
 * 				from which the service resource is derived through the
 * 				expression.
 * 				Another option, is to resolve the Function, from the
 * 				resource name,
 * 				but this would require additional lookups.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceDistribution#getServiceResources <em>Service Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.ServiceDistribution#getExpressionRefs <em>Expression Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceDistribution()
 * @model extendedMetaData="name='ServiceDistribution' kind='elementOnly'"
 * @generated
 */
public interface ServiceDistribution extends Base {
	/**
	 * Returns the value of the '<em><b>Service Resources</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.NetXResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ServiceResource reference, contains 0 or
	 * 								more
	 * 								Resource types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service Resources</em>' containment reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceDistribution_ServiceResources()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ServiceResources'"
	 * @generated
	 */
	EList<NetXResource> getServiceResources();

	/**
	 * Returns the value of the '<em><b>Expression Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ServiceDistributionExpressionRefs
	 * 								reference,
	 * 								refers to 0 or more Expression types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceDistribution_ExpressionRefs()
	 * @model extendedMetaData="kind='element' name='ExpressionRefs'"
	 * @generated
	 */
	EList<Expression> getExpressionRefs();

} // ServiceDistribution
