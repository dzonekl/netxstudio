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

import com.netxforge.netxstudio.generics.Base;
import org.eclipse.emf.cdo.CDOObject;
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
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getMetricRef <em>Metric Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getMetricValueRanges <em>Metric Value Ranges</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getCapacityValues <em>Capacity Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getUtilizationValues <em>Utilization Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getForecastCapacityValues <em>Forecast Capacity Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getForecastValues <em>Forecast Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getTrendedValues <em>Trended Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#isDetailDisplay <em>Detail Display</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getExpressionName <em>Expression Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getLongName <em>Long Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getShortName <em>Short Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#isSummaryDisplay <em>Summary Display</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.NetXResource#getUnitRef <em>Unit Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getNetXResource()
 * @model extendedMetaData="name='NetXResource' kind='elementOnly'"
 * @generated
 */
public interface NetXResource extends Base {
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

	/**
	 * Returns the value of the '<em><b>Detail Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The DetailDisplay attribute is a flag specifiy
	 * 							if
	 * 							the resource should be displayed in a detailed presentation.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Detail Display</em>' attribute.
	 * @see #isSetDetailDisplay()
	 * @see #unsetDetailDisplay()
	 * @see #setDetailDisplay(boolean)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getNetXResource_DetailDisplay()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='DetailDisplay'"
	 * @generated
	 */
	boolean isDetailDisplay();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.NetXResource#isDetailDisplay <em>Detail Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Detail Display</em>' attribute.
	 * @see #isSetDetailDisplay()
	 * @see #unsetDetailDisplay()
	 * @see #isDetailDisplay()
	 * @generated
	 */
	void setDetailDisplay(boolean value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.library.NetXResource#isDetailDisplay <em>Detail Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDetailDisplay()
	 * @see #isDetailDisplay()
	 * @see #setDetailDisplay(boolean)
	 * @generated
	 */
	void unsetDetailDisplay();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.library.NetXResource#isDetailDisplay <em>Detail Display</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Detail Display</em>' attribute is set.
	 * @see #unsetDetailDisplay()
	 * @see #isDetailDisplay()
	 * @see #setDetailDisplay(boolean)
	 * @generated
	 */
	boolean isSetDetailDisplay();

	/**
	 * Returns the value of the '<em><b>Expression Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ExpressionName attribute holds a name which
	 * 							is
	 * 							used in the expressions referencing
	 * 							the resource.
	 * 
	 * 							See: The
	 * 							NetXScript
	 * 							specification.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression Name</em>' attribute.
	 * @see #setExpressionName(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getNetXResource_ExpressionName()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='ExpressionName'"
	 * @generated
	 */
	String getExpressionName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.NetXResource#getExpressionName <em>Expression Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression Name</em>' attribute.
	 * @see #getExpressionName()
	 * @generated
	 */
	void setExpressionName(String value);

	/**
	 * Returns the value of the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The LongName attribute holds a long name which
	 * 							is
	 * 							used for presentation of the resource.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Long Name</em>' attribute.
	 * @see #setLongName(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getNetXResource_LongName()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='LongName'"
	 * @generated
	 */
	String getLongName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.NetXResource#getLongName <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Long Name</em>' attribute.
	 * @see #getLongName()
	 * @generated
	 */
	void setLongName(String value);

	/**
	 * Returns the value of the '<em><b>Short Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ShortName attribute holds a short name which
	 * 							is used for presentation of the resource.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Short Name</em>' attribute.
	 * @see #setShortName(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getNetXResource_ShortName()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='ShortName'"
	 * @generated
	 */
	String getShortName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.NetXResource#getShortName <em>Short Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Short Name</em>' attribute.
	 * @see #getShortName()
	 * @generated
	 */
	void setShortName(String value);

	/**
	 * Returns the value of the '<em><b>Summary Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The SummaryDisplay attribute is a flag specifiy
	 * 							if
	 * 							the resource should be displayed in a summary presentation.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Summary Display</em>' attribute.
	 * @see #isSetSummaryDisplay()
	 * @see #unsetSummaryDisplay()
	 * @see #setSummaryDisplay(boolean)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getNetXResource_SummaryDisplay()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='SummaryDisplay'"
	 * @generated
	 */
	boolean isSummaryDisplay();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.NetXResource#isSummaryDisplay <em>Summary Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Summary Display</em>' attribute.
	 * @see #isSetSummaryDisplay()
	 * @see #unsetSummaryDisplay()
	 * @see #isSummaryDisplay()
	 * @generated
	 */
	void setSummaryDisplay(boolean value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.library.NetXResource#isSummaryDisplay <em>Summary Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSummaryDisplay()
	 * @see #isSummaryDisplay()
	 * @see #setSummaryDisplay(boolean)
	 * @generated
	 */
	void unsetSummaryDisplay();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.library.NetXResource#isSummaryDisplay <em>Summary Display</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Summary Display</em>' attribute is set.
	 * @see #unsetSummaryDisplay()
	 * @see #isSummaryDisplay()
	 * @see #setSummaryDisplay(boolean)
	 * @generated
	 */
	boolean isSetSummaryDisplay();

	/**
	 * Returns the value of the '<em><b>Unit Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The UnitRef reference, refers to 0 or 1 Unit
	 * 							type.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unit Ref</em>' reference.
	 * @see #setUnitRef(Unit)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getNetXResource_UnitRef()
	 * @model extendedMetaData="kind='attribute' name='UnitRef'"
	 * @generated
	 */
	Unit getUnitRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.NetXResource#getUnitRef <em>Unit Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Ref</em>' reference.
	 * @see #getUnitRef()
	 * @generated
	 */
	void setUnitRef(Unit value);

} // NetXResource
