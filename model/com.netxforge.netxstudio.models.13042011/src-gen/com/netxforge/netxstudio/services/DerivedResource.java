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

import com.netxforge.netxstudio.generics.Value;

import com.netxforge.netxstudio.library.BaseResource;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Derived Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				TODO
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.DerivedResource#getValues <em>Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.DerivedResource#getForecastValues <em>Forecast Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.DerivedResource#getTrendedValues <em>Trended Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.services.ServicesPackage#getDerivedResource()
 * @model extendedMetaData="name='DerivedResource' kind='elementOnly'"
 * @generated
 */
public interface DerivedResource extends BaseResource {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.generics.Value}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ProfileValues reference, contains
	 * 								profile
	 * 								values. Profile values are populated with expressions.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getDerivedResource_Values()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Values'"
	 * @generated
	 */
	EList<Value> getValues();

	/**
	 * Returns the value of the '<em><b>Forecast Values</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.generics.Value}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ForecastValues reference, contains forecast
	 * 								values. Forecast values are populated with
	 * 								expressions, imported
	 * 								or
	 * 								entered manually.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Forecast Values</em>' containment reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getDerivedResource_ForecastValues()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ForecastValues'"
	 * @generated
	 */
	EList<Value> getForecastValues();

	/**
	 * Returns the value of the '<em><b>Trended Values</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.generics.Value}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TrendedValues reference, contains trended
	 * 								values. Trended values are populated with
	 * 								expressions.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Trended Values</em>' containment reference list.
	 * @see com.netxforge.netxstudio.services.ServicesPackage#getDerivedResource_TrendedValues()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='TrendedValues'"
	 * @generated
	 */
	EList<Value> getTrendedValues();

} // DerivedResource
