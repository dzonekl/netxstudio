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
package com.netxforge.netxstudio.delta16042013.metrics.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.netxforge.netxstudio.delta16042013.generics.impl.RuleImpl;
import com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule;
import com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metric Aggregation Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricAggregationRuleImpl#getAggregationExpression <em>Aggregation Expression</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.impl.MetricAggregationRuleImpl#getIntervalHint <em>Interval Hint</em>}</li>
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
	protected EObject aggregationExpression;

	/**
	 * The default value of the '{@link #getIntervalHint() <em>Interval Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntervalHint()
	 * @generated
	 * @ordered
	 */
	protected static final int INTERVAL_HINT_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getIntervalHint() <em>Interval Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntervalHint()
	 * @generated
	 * @ordered
	 */
	protected int intervalHint = INTERVAL_HINT_EDEFAULT;
	/**
	 * This is true if the Interval Hint attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean intervalHintESet;

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
	public EObject getAggregationExpression() {
		if (aggregationExpression != null && aggregationExpression.eIsProxy()) {
			InternalEObject oldAggregationExpression = (InternalEObject)aggregationExpression;
			aggregationExpression = eResolveProxy(oldAggregationExpression);
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
	public EObject basicGetAggregationExpression() {
		return aggregationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregationExpression(EObject newAggregationExpression) {
		EObject oldAggregationExpression = aggregationExpression;
		aggregationExpression = newAggregationExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC_AGGREGATION_RULE__AGGREGATION_EXPRESSION, oldAggregationExpression, aggregationExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIntervalHint() {
		return intervalHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntervalHint(int newIntervalHint) {
		int oldIntervalHint = intervalHint;
		intervalHint = newIntervalHint;
		boolean oldIntervalHintESet = intervalHintESet;
		intervalHintESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC_AGGREGATION_RULE__INTERVAL_HINT, oldIntervalHint, intervalHint, !oldIntervalHintESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIntervalHint() {
		int oldIntervalHint = intervalHint;
		boolean oldIntervalHintESet = intervalHintESet;
		intervalHint = INTERVAL_HINT_EDEFAULT;
		intervalHintESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.METRIC_AGGREGATION_RULE__INTERVAL_HINT, oldIntervalHint, INTERVAL_HINT_EDEFAULT, oldIntervalHintESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIntervalHint() {
		return intervalHintESet;
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
			case MetricsPackage.METRIC_AGGREGATION_RULE__INTERVAL_HINT:
				return getIntervalHint();
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
				setAggregationExpression((EObject)newValue);
				return;
			case MetricsPackage.METRIC_AGGREGATION_RULE__INTERVAL_HINT:
				setIntervalHint((Integer)newValue);
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
				setAggregationExpression((EObject)null);
				return;
			case MetricsPackage.METRIC_AGGREGATION_RULE__INTERVAL_HINT:
				unsetIntervalHint();
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
			case MetricsPackage.METRIC_AGGREGATION_RULE__INTERVAL_HINT:
				return isSetIntervalHint();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (intervalHint: ");
		if (intervalHintESet) result.append(intervalHint); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //MetricAggregationRuleImpl
