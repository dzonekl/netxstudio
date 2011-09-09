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
package com.netxforge.netxstudio.library;

import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricValueRange;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Net XResource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of
 * 				a resource.
 * 				A resource is a container for holding values. Resources
 * 				are
 * 				produced/consumed by expressions for
 * 				various purposes. Resources
 * 				belong to either to an Equipment, a Function or
 * 				an EquipmentGroup
 * 				type.
 * 
 * 				Note: The Resource values, contain a timestamp. As a resource
 * 				ultimately
 * 				belongs to a Network, which has
 * 				as a Start and End date,
 * 				the timestamp should be within the Network
 * 				period.
 * 
 * 				Examples:
 * 				1. A
 * 				Resource is used to hold Metric values, which is populated from a
 * 				MetricSource.
 * 				2. A Resource is used to hold Capacity values. These
 * 				are populated by
 * 				expressions which are defined
 * 				for an equipment. The
 * 				capacity values, can also be keyed in manually
 * 				through an UI Widget.
 * 				3. A Resource is used to hold Forecast values. These are populated
 * 				by
 * 				expressions which are defined
 * 				for an equipment or a function.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getComponentRef <em>Component Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getMetricRef <em>Metric Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getMetricValueRanges <em>Metric Value Ranges</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getCapacityValues <em>Capacity Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getUtilizationValues <em>Utilization Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getForecastCapacityValues <em>Forecast Capacity Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getForecastValues <em>Forecast Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getTrendedValues <em>Trended Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getNetXResource()
 * @model extendedMetaData="name='NetXResource' kind='elementOnly'"
 * @generated
 */
public interface NetXResource extends BaseResource {
	/**
	 * Returns the value of the '<em><b>Component Ref</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.netxforge.netxstudio.library.Component#getResourceRefs <em>Resource Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to the component for which this netx resource was created.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Component Ref</em>' reference.
	 * @see #setComponentRef(Component)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getNetXResource_ComponentRef()
	 * @see com.netxforge.netxstudio.library.Component#getResourceRefs
	 * @model opposite="resourceRefs" required="true"
	 *        extendedMetaData="kind='element' name='ComponentRef'"
	 * @generated
	 */
	Component getComponentRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.NetXResource#getComponentRef <em>Component Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Ref</em>' reference.
	 * @see #getComponentRef()
	 * @generated
	 */
	void setComponentRef(Component value);

	/**
	 * Returns the value of the '<em><b>Metric Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The MetricRef reference, refers to zero or one
	 * 								Metric for which this resource contains values.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metric Ref</em>' reference.
	 * @see #setMetricRef(Metric)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getNetXResource_MetricRef()
	 * @model extendedMetaData="kind='element' name='MetricRef'"
	 * @generated
	 */
	Metric getMetricRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.NetXResource#getMetricRef <em>Metric Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric Ref</em>' reference.
	 * @see #getMetricRef()
	 * @generated
	 */
	void setMetricRef(Metric value);

	/**
	 * Returns the value of the '<em><b>Metric Value Ranges</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.metrics.MetricValueRange}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The MetricValueRanges reference, contains
	 * 								measured usage values. Metric values are values
	 * 								retrieved from
	 * 								the
	 * 								real network element.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metric Value Ranges</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getNetXResource_MetricValueRanges()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='MetricValueRanges'"
	 * @generated
	 */
	EList<MetricValueRange> getMetricValueRanges();

	/**
	 * Returns the value of the '<em><b>Capacity Values</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.generics.Value}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The CapacityValues reference, contains capacity
	 * 								values. Capacity values are populated with
	 * 								expressions, imported
	 * 								or
	 * 								entered manually.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Capacity Values</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getNetXResource_CapacityValues()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='CapacityValues'"
	 * @generated
	 */
	EList<Value> getCapacityValues();

	/**
	 * Returns the value of the '<em><b>Utilization Values</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.generics.Value}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The UtilizationValues reference, contains
	 * 								utilization values. Utilization values are populated through
	 * 								a
	 * 								work
	 * 								flow computation run.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Utilization Values</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getNetXResource_UtilizationValues()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='UtilizationValues'"
	 * @generated
	 */
	EList<Value> getUtilizationValues();

	/**
	 * Returns the value of the '<em><b>Forecast Capacity Values</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.generics.Value}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ForecastCapacityValues reference, contains
	 * 								forecasted capacity values. ForecastedCapacity values are
	 * 								populated with
	 * 								expressions in represent the target capacity for a
	 * 								resource (Versus the
	 * 								actual capacity).
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Forecast Capacity Values</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getNetXResource_ForecastCapacityValues()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ForecastCapacityValues'"
	 * @generated
	 */
	EList<Value> getForecastCapacityValues();

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
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getNetXResource_ForecastValues()
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
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getNetXResource_TrendedValues()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='TrendedValues'"
	 * @generated
	 */
	EList<Value> getTrendedValues();

} // NetXResource
