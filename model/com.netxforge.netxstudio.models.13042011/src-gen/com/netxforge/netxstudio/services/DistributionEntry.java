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

import com.netxforge.netxstudio.library.NetXResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Distribution Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.DistributionEntry#getResourceRef <em>Resource Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.DistributionEntry#getDistribution <em>Distribution</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.DistributionEntry#getResourceOrigin <em>Resource Origin</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.services.ServicesPackage#getDistributionEntry()
 * @model extendedMetaData="name='DistributionEntry' kind='elementOnly'"
 * @generated
 */
public interface DistributionEntry extends Base {
	/**
	 * Returns the value of the '<em><b>Resource Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ServiceResource reference, contains 0 or 1
	 * 								Resource type.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resource Ref</em>' reference.
	 * @see #setResourceRef(NetXResource)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getDistributionEntry_ResourceRef()
	 * @model extendedMetaData="kind='element' name='ResourceRef'"
	 * @generated
	 */
	NetXResource getResourceRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.DistributionEntry#getResourceRef <em>Resource Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Ref</em>' reference.
	 * @see #getResourceRef()
	 * @generated
	 */
	void setResourceRef(NetXResource value);

	/**
	 * Returns the value of the '<em><b>Distribution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ServiceResource reference, contains 0 or
	 * 								more DerivedResource type.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Distribution</em>' containment reference.
	 * @see #setDistribution(DerivedResource)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getDistributionEntry_Distribution()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Distribution'"
	 * @generated
	 */
	DerivedResource getDistribution();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.DistributionEntry#getDistribution <em>Distribution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distribution</em>' containment reference.
	 * @see #getDistribution()
	 * @generated
	 */
	void setDistribution(DerivedResource value);

	/**
	 * Returns the value of the '<em><b>Resource Origin</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.services.ResourceOriginType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Origin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Origin</em>' attribute.
	 * @see com.netxforge.netxstudio.services.ResourceOriginType
	 * @see #isSetResourceOrigin()
	 * @see #unsetResourceOrigin()
	 * @see #setResourceOrigin(ResourceOriginType)
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getDistributionEntry_ResourceOrigin()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='ResourceOrigin'"
	 * @generated
	 */
	ResourceOriginType getResourceOrigin();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.services.DistributionEntry#getResourceOrigin <em>Resource Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Origin</em>' attribute.
	 * @see com.netxforge.netxstudio.services.ResourceOriginType
	 * @see #isSetResourceOrigin()
	 * @see #unsetResourceOrigin()
	 * @see #getResourceOrigin()
	 * @generated
	 */
	void setResourceOrigin(ResourceOriginType value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.services.DistributionEntry#getResourceOrigin <em>Resource Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetResourceOrigin()
	 * @see #getResourceOrigin()
	 * @see #setResourceOrigin(ResourceOriginType)
	 * @generated
	 */
	void unsetResourceOrigin();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.services.DistributionEntry#getResourceOrigin <em>Resource Origin</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Resource Origin</em>' attribute is set.
	 * @see #unsetResourceOrigin()
	 * @see #getResourceOrigin()
	 * @see #setResourceOrigin(ResourceOriginType)
	 * @generated
	 */
	boolean isSetResourceOrigin();

} // DistributionEntry
