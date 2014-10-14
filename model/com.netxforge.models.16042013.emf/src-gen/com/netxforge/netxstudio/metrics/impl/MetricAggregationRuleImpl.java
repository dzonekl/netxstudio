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
package com.netxforge.netxstudio.metrics.impl;

import com.netxforge.netxstudio.generics.impl.RuleImpl;

import com.netxforge.netxstudio.library.Expression;

import com.netxforge.netxstudio.metrics.MetricAggregationRule;
import com.netxforge.netxstudio.metrics.MetricsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metric Aggregation Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricAggregationRuleImpl#getAggregationExpression <em>Aggregation Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetricAggregationRuleImpl extends RuleImpl implements MetricAggregationRule {
	/**
	 * The cached value of the '{@link #getAggregationExpression() <em>Aggregation Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregationExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression aggregationExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricAggregationRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.METRIC_AGGREGATION_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getAggregationExpression() {
		if (aggregationExpression != null && aggregationExpression.eIsProxy()) {
			InternalEObject oldAggregationExpression = (InternalEObject)aggregationExpression;
			aggregationExpression = (Expression)eResolveProxy(oldAggregationExpression);
			if (aggregationExpression != oldAggregationExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetricsPackage.METRIC_AGGREGATION_RULE__AGGREGATION_EXPRESSION, oldAggregationExpression, aggregationExpression));
			}
		}
		return aggregationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetAggregationExpression() {
		return aggregationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregationExpression(Expression newAggregationExpression) {
		Expression oldAggregationExpression = aggregationExpression;
		aggregationExpression = newAggregationExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC_AGGREGATION_RULE__AGGREGATION_EXPRESSION, oldAggregationExpression, aggregationExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetricsPackage.METRIC_AGGREGATION_RULE__AGGREGATION_EXPRESSION:
				if (resolve) return getAggregationExpression();
				return basicGetAggregationExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetricsPackage.METRIC_AGGREGATION_RULE__AGGREGATION_EXPRESSION:
				setAggregationExpression((Expression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetricsPackage.METRIC_AGGREGATION_RULE__AGGREGATION_EXPRESSION:
				setAggregationExpression((Expression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetricsPackage.METRIC_AGGREGATION_RULE__AGGREGATION_EXPRESSION:
				return aggregationExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //MetricAggregationRuleImpl
