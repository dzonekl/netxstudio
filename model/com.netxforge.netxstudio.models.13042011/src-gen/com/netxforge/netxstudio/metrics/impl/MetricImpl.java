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
package com.netxforge.netxstudio.metrics.impl;

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Unit;

import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getExpressionRef <em>Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getMeasurementKind <em>Measurement Kind</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getMeasurementPoint <em>Measurement Point</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getMetricSourceRef <em>Metric Source Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricImpl#getUnitRef <em>Unit Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetricImpl extends BaseImpl implements Metric {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.METRIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Metric> getMetrics() {
		return (EList<Metric>)eGet(MetricsPackage.Literals.METRIC__METRICS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpressionRef() {
		return (Expression)eGet(MetricsPackage.Literals.METRIC__EXPRESSION_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionRef(Expression newExpressionRef) {
		eSet(MetricsPackage.Literals.METRIC__EXPRESSION_REF, newExpressionRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(MetricsPackage.Literals.METRIC__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(MetricsPackage.Literals.METRIC__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeasurementKind() {
		return (String)eGet(MetricsPackage.Literals.METRIC__MEASUREMENT_KIND, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasurementKind(String newMeasurementKind) {
		eSet(MetricsPackage.Literals.METRIC__MEASUREMENT_KIND, newMeasurementKind);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeasurementPoint() {
		return (String)eGet(MetricsPackage.Literals.METRIC__MEASUREMENT_POINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasurementPoint(String newMeasurementPoint) {
		eSet(MetricsPackage.Literals.METRIC__MEASUREMENT_POINT, newMeasurementPoint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricSource getMetricSourceRef() {
		return (MetricSource)eGet(MetricsPackage.Literals.METRIC__METRIC_SOURCE_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetricSourceRef(MetricSource newMetricSourceRef) {
		eSet(MetricsPackage.Literals.METRIC__METRIC_SOURCE_REF, newMetricSourceRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(MetricsPackage.Literals.METRIC__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(MetricsPackage.Literals.METRIC__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit getUnitRef() {
		return (Unit)eGet(MetricsPackage.Literals.METRIC__UNIT_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitRef(Unit newUnitRef) {
		eSet(MetricsPackage.Literals.METRIC__UNIT_REF, newUnitRef);
	}

} //MetricImpl
