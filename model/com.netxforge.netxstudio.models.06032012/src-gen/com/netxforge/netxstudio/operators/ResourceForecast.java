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
package com.netxforge.netxstudio.operators;

import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.Base;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Forecast</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a resource forecast run. The
 * 				resources in the Nodes will contain the forecast values, this type
 * 				however hold the
 * 				time markers which result from the forecast.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.ResourceForecast#getMarkers <em>Markers</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getResourceForecast()
 * @model extendedMetaData="name='ResourceForecast' kind='elementOnly'"
 * @generated
 */
public interface ResourceForecast extends Base {
	/**
	 * Returns the value of the '<em><b>Markers</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.Marker}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Markers reference, contains 0 or more
	 * 								Marker
	 * 								types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Markers</em>' containment reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getResourceForecast_Markers()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Markers'"
	 * @generated
	 */
	EList<Marker> getMarkers();

} // ResourceForecast
