/**
 * Copyright (c) 2014 NetXForge
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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.netxforge.netxstudio.metrics.MetricsPackage
 * @generated
 */
public interface MetricsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetricsFactory eINSTANCE = com.netxforge.netxstudio.metrics.impl.MetricsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Data Kind</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Kind</em>'.
	 * @generated
	 */
	DataKind createDataKind();

	/**
	 * Returns a new object of class '<em>Identifier Data Kind</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identifier Data Kind</em>'.
	 * @generated
	 */
	IdentifierDataKind createIdentifierDataKind();

	/**
	 * Returns a new object of class '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping</em>'.
	 * @generated
	 */
	Mapping createMapping();

	/**
	 * Returns a new object of class '<em>Mapping Column</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Column</em>'.
	 * @generated
	 */
	MappingColumn createMappingColumn();

	/**
	 * Returns a new object of class '<em>Mapping CSV</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping CSV</em>'.
	 * @generated
	 */
	MappingCSV createMappingCSV();

	/**
	 * Returns a new object of class '<em>Mapping RDBMS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping RDBMS</em>'.
	 * @generated
	 */
	MappingRDBMS createMappingRDBMS();

	/**
	 * Returns a new object of class '<em>Mapping Record</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Record</em>'.
	 * @generated
	 */
	MappingRecord createMappingRecord();

	/**
	 * Returns a new object of class '<em>Mapping Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Statistic</em>'.
	 * @generated
	 */
	MappingStatistic createMappingStatistic();

	/**
	 * Returns a new object of class '<em>Mapping XLS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping XLS</em>'.
	 * @generated
	 */
	MappingXLS createMappingXLS();

	/**
	 * Returns a new object of class '<em>Metric</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metric</em>'.
	 * @generated
	 */
	Metric createMetric();

	/**
	 * Returns a new object of class '<em>Metric Retention Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metric Retention Rule</em>'.
	 * @generated
	 */
	MetricRetentionRule createMetricRetentionRule();

	/**
	 * Returns a new object of class '<em>Metric Retention Rules</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metric Retention Rules</em>'.
	 * @generated
	 */
	MetricRetentionRules createMetricRetentionRules();

	/**
	 * Returns a new object of class '<em>Metric Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metric Source</em>'.
	 * @generated
	 */
	MetricSource createMetricSource();

	/**
	 * Returns a new object of class '<em>Metric Value Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metric Value Range</em>'.
	 * @generated
	 */
	MetricValueRange createMetricValueRange();

	/**
	 * Returns a new object of class '<em>Value Data Kind</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Data Kind</em>'.
	 * @generated
	 */
	ValueDataKind createValueDataKind();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MetricsPackage getMetricsPackage();

} //MetricsFactory
