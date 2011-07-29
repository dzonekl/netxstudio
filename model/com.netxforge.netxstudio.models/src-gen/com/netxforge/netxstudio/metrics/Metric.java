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
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Unit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a metric in an a telecom
 * 				equipment. This is often also referred to as counter or KPI.
 * 				Metric
 * 				types can be nested to form a hiarchical structure in similar
 * 				fashion to a real KPI hiarchy.
 * 
 * 				The Metric type (and/or it's children)
 * 				is first part of the Library
 * 				type, and then referenced from a Node
 * 				type when
 * 				created.
 * 
 * 				Examples:
 * 				1. The Metric type "SGSN Attached
 * 				subscribers" reprents a KPI on a
 * 				SGSN function.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.Metric#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.Metric#getExpressionRef <em>Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.Metric#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.Metric#getMeasurementKind <em>Measurement Kind</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.Metric#getMeasurementPoint <em>Measurement Point</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.Metric#getMetricSourceRef <em>Metric Source Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.Metric#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.Metric#getUnitRef <em>Unit Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetric()
 * @model extendedMetaData="name='Metric' kind='elementOnly'"
 * @generated
 */
public interface Metric extends Base {
	/**
	 * Returns the value of the '<em><b>Metrics</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.metrics.Metric}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Metrics reference, contains 0 or more
	 * 								Metric
	 * 								types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metrics</em>' containment reference list.
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetric_Metrics()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Metrics'"
	 * @generated
	 */
	EList<Metric> getMetrics();

	/**
	 * Returns the value of the '<em><b>Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ExpressionRef reference, references 0 or
	 * 							1 Expression type.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression Ref</em>' reference.
	 * @see #setExpressionRef(Expression)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetric_ExpressionRef()
	 * @model extendedMetaData="kind='element' name='ExpressionRef'"
	 * @generated
	 */
	Expression getExpressionRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.Metric#getExpressionRef <em>Expression Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression Ref</em>' reference.
	 * @see #getExpressionRef()
	 * @generated
	 */
	void setExpressionRef(Expression value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Description attribute holds the description
	 * 							of
	 * 							the metric.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetric_Description()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.Metric#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Measurement Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The MeasurementKind attribute is a free form
	 * 							text
	 * 							field which can hold information about which
	 * 							category or group
	 * 							a Metric belongs.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Measurement Kind</em>' attribute.
	 * @see #setMeasurementKind(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetric_MeasurementKind()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MeasurementKind'"
	 * @generated
	 */
	String getMeasurementKind();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.Metric#getMeasurementKind <em>Measurement Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measurement Kind</em>' attribute.
	 * @see #getMeasurementKind()
	 * @generated
	 */
	void setMeasurementKind(String value);

	/**
	 * Returns the value of the '<em><b>Measurement Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The MeasurementPoint Attribute describes
	 * 							textually
	 * 							at which point in a procedure
	 * 							the measurement takes
	 * 							place.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Measurement Point</em>' attribute.
	 * @see #setMeasurementPoint(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetric_MeasurementPoint()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='MeasurementPoint'"
	 * @generated
	 */
	String getMeasurementPoint();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.Metric#getMeasurementPoint <em>Measurement Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measurement Point</em>' attribute.
	 * @see #getMeasurementPoint()
	 * @generated
	 */
	void setMeasurementPoint(String value);

	/**
	 * Returns the value of the '<em><b>Metric Source Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The MetricSourceRef references, references a
	 * 							MetricSource type.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metric Source Ref</em>' reference.
	 * @see #setMetricSourceRef(MetricSource)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetric_MetricSourceRef()
	 * @model extendedMetaData="kind='attribute' name='MetricSourceRef'"
	 * @generated
	 */
	MetricSource getMetricSourceRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.Metric#getMetricSourceRef <em>Metric Source Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric Source Ref</em>' reference.
	 * @see #getMetricSourceRef()
	 * @generated
	 */
	void setMetricSourceRef(MetricSource value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute holds the name of the metric.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetric_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.Metric#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetric_UnitRef()
	 * @model extendedMetaData="kind='attribute' name='UnitRef'"
	 * @generated
	 */
	Unit getUnitRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.Metric#getUnitRef <em>Unit Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Ref</em>' reference.
	 * @see #getUnitRef()
	 * @generated
	 */
	void setUnitRef(Unit value);

} // Metric
