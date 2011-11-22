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
package com.netxforge.netxstudio.metrics;

import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.Base;
import com.netxforge.netxstudio.generics.DateTimeRange;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Statistic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the information points of a
 * 				statistic for each time a source was accessed.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingStatistic#getFailedRecords <em>Failed Records</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingStatistic#getMappingDuration <em>Mapping Duration</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingStatistic#getPeriodEstimate <em>Period Estimate</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingStatistic#getIntervalEstimate <em>Interval Estimate</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingStatistic#getMessage <em>Message</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingStatistic#getTotalRecords <em>Total Records</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingStatistic()
 * @model extendedMetaData="name='MappingStatistic' kind='elementOnly'"
 * @generated
 */
public interface MappingStatistic extends Base {
	/**
	 * Returns the value of the '<em><b>Failed Records</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.metrics.MappingRecord}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The FailedRecords reference, contains 0 or more
	 * 								MappingRecord types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Failed Records</em>' containment reference list.
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingStatistic_FailedRecords()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='FailedRecords'"
	 * @generated
	 */
	EList<MappingRecord> getFailedRecords();

	/**
	 * Returns the value of the '<em><b>Mapping Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The MappingDuration reference, refers to a
	 * 								DateTimeRange type.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mapping Duration</em>' containment reference.
	 * @see #setMappingDuration(DateTimeRange)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingStatistic_MappingDuration()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='MappingDuration'"
	 * @generated
	 */
	DateTimeRange getMappingDuration();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingStatistic#getMappingDuration <em>Mapping Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Duration</em>' containment reference.
	 * @see #getMappingDuration()
	 * @generated
	 */
	void setMappingDuration(DateTimeRange value);

	/**
	 * Returns the value of the '<em><b>Period Estimate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The PeriodEstimate reference, refers to a
	 * 								DateTimeRange type. It contains an estimate of the start till end date and time 
	 * 								for a single mapping run.  
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Period Estimate</em>' containment reference.
	 * @see #setPeriodEstimate(DateTimeRange)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingStatistic_PeriodEstimate()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='PeriodEstimate'"
	 * @generated
	 */
	DateTimeRange getPeriodEstimate();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingStatistic#getPeriodEstimate <em>Period Estimate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period Estimate</em>' containment reference.
	 * @see #getPeriodEstimate()
	 * @generated
	 */
	void setPeriodEstimate(DateTimeRange value);

	/**
	 * Returns the value of the '<em><b>Interval Estimate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The IntervalEstimate attribute contains a number in minutes for 
	 * 						the mapping run. It also corresponds the MetricValueRange for the mapping run. 
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interval Estimate</em>' attribute.
	 * @see #isSetIntervalEstimate()
	 * @see #unsetIntervalEstimate()
	 * @see #setIntervalEstimate(int)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingStatistic_IntervalEstimate()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='IntervalEstimate'"
	 * @generated
	 */
	int getIntervalEstimate();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingStatistic#getIntervalEstimate <em>Interval Estimate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interval Estimate</em>' attribute.
	 * @see #isSetIntervalEstimate()
	 * @see #unsetIntervalEstimate()
	 * @see #getIntervalEstimate()
	 * @generated
	 */
	void setIntervalEstimate(int value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.MappingStatistic#getIntervalEstimate <em>Interval Estimate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIntervalEstimate()
	 * @see #getIntervalEstimate()
	 * @see #setIntervalEstimate(int)
	 * @generated
	 */
	void unsetIntervalEstimate();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.MappingStatistic#getIntervalEstimate <em>Interval Estimate</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Interval Estimate</em>' attribute is set.
	 * @see #unsetIntervalEstimate()
	 * @see #getIntervalEstimate()
	 * @see #setIntervalEstimate(int)
	 * @generated
	 */
	boolean isSetIntervalEstimate();

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A global error or information message
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingStatistic_Message()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='Message'"
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingStatistic#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Total Records</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TotalRecords attribute holds a the number of
	 * 							records for this mapping run.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Total Records</em>' attribute.
	 * @see #isSetTotalRecords()
	 * @see #unsetTotalRecords()
	 * @see #setTotalRecords(int)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingStatistic_TotalRecords()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='TotalRecords'"
	 * @generated
	 */
	int getTotalRecords();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingStatistic#getTotalRecords <em>Total Records</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Records</em>' attribute.
	 * @see #isSetTotalRecords()
	 * @see #unsetTotalRecords()
	 * @see #getTotalRecords()
	 * @generated
	 */
	void setTotalRecords(int value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.MappingStatistic#getTotalRecords <em>Total Records</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTotalRecords()
	 * @see #getTotalRecords()
	 * @see #setTotalRecords(int)
	 * @generated
	 */
	void unsetTotalRecords();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.MappingStatistic#getTotalRecords <em>Total Records</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Total Records</em>' attribute is set.
	 * @see #unsetTotalRecords()
	 * @see #getTotalRecords()
	 * @see #setTotalRecords(int)
	 * @generated
	 */
	boolean isSetTotalRecords();

} // MappingStatistic
