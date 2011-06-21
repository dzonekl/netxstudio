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

import com.netxforge.netxstudio.generics.Base;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the information points of a
 * 				source which provides metric values.
 * 				A source, is an external data
 * 				source like an RDBMS or an Excel or CSV
 * 				file. The MetricSource type
 * 				will contain all necessary
 * 				to access, and map the metric values of
 * 				the source to the correct
 * 				Object. (Most commonly a Node).
 * 
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.MetricSource#getMetricRefs <em>Metric Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MetricSource#getMetricMapping <em>Metric Mapping</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MetricSource#getStatistics <em>Statistics</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MetricSource#getMetricLocation <em>Metric Location</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MetricSource#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricSource()
 * @model extendedMetaData="name='MetricSource' kind='elementOnly'"
 * @generated
 */
public interface MetricSource extends Base {
	/**
	 * Returns the value of the '<em><b>Metric Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.metrics.Metric}.
	 * It is bidirectional and its opposite is '{@link com.netxforge.netxstudio.metrics.Metric#getMetricSourceRef <em>Metric Source Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The MetricRefs reference, refers to one or more
	 * 								Metric types for which this source provides values.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metric Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricSource_MetricRefs()
	 * @see com.netxforge.netxstudio.metrics.Metric#getMetricSourceRef
	 * @model opposite="metricSourceRef"
	 *        extendedMetaData="kind='element' name='MetricRefs'"
	 * @generated
	 */
	EList<Metric> getMetricRefs();

	/**
	 * Returns the value of the '<em><b>Metric Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Will not be persisted in the DB, but would use
	 * 								a
	 * 								.properties file for now.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metric Mapping</em>' containment reference.
	 * @see #setMetricMapping(Mapping)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricSource_MetricMapping()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='MetricMapping'"
	 * @generated
	 */
	Mapping getMetricMapping();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MetricSource#getMetricMapping <em>Metric Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric Mapping</em>' containment reference.
	 * @see #getMetricMapping()
	 * @generated
	 */
	void setMetricMapping(Mapping value);

	/**
	 * Returns the value of the '<em><b>Statistics</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.metrics.MappingStatistic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Statistics reference, contains one or more
	 * 								MappingStatistic types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Statistics</em>' containment reference list.
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricSource_Statistics()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Statistics'"
	 * @generated
	 */
	EList<MappingStatistic> getStatistics();

	/**
	 * Returns the value of the '<em><b>Metric Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * a URI representation of the location additional
	 * 							information like login/password can be appended to the URI.
	 * 
	 * 							Examples:
	 * 							1. For an XLS file this could be
	 * 							file://path_to_where_the_xls_files_are_stored/
	 * 							2. For an RDMS this
	 * 							could be: jdbc:mysql://localhost:3306/DB (In
	 * 							this
	 * 							case a JDBC URL
	 * 							to access the DB). The login/password can be
	 * 							appended to the URI.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metric Location</em>' attribute.
	 * @see #setMetricLocation(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricSource_MetricLocation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='MetricLocation'"
	 * @generated
	 */
	String getMetricLocation();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MetricSource#getMetricLocation <em>Metric Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric Location</em>' attribute.
	 * @see #getMetricLocation()
	 * @generated
	 */
	void setMetricLocation(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute holds the name of the
	 * 							MetricSource as it will be presented.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricSource_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MetricSource#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // MetricSource
