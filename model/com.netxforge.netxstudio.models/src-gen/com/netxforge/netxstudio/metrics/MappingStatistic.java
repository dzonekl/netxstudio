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

import com.netxforge.netxstudio.generics.DateTimeRange;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Statistic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the information points of a statistic for each time a source was accessed.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingStatistic#getFailedRecords <em>Failed Records</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingStatistic#getMappingDuration <em>Mapping Duration</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingStatistic#getTotalRecords <em>Total Records</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingStatistic()
 * @model extendedMetaData="name='MappingStatistic' kind='elementOnly'"
 * @generated
 */
public interface MappingStatistic extends EObject {
	/**
	 * Returns the value of the '<em><b>Failed Records</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.metrics.MappingRecord}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The FailedRecords reference, contains 0 or more MappingRecord types.
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
	 * The MappingDuration reference, refers to a DateTimeRange type.
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
	 * Returns the value of the '<em><b>Total Records</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TotalRecords attribute holds a the number of records for this mapping run.
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
