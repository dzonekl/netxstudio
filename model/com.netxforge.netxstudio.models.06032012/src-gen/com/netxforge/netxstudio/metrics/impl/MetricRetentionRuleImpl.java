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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.metrics.MetricRetentionPeriod;
import com.netxforge.netxstudio.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.metrics.MetricsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metric Retention Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricRetentionRuleImpl#getRetentionExpression <em>Retention Expression</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricRetentionRuleImpl#getIntervalHint <em>Interval Hint</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricRetentionRuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricRetentionRuleImpl#getPeriod <em>Period</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetricRetentionRuleImpl extends CDOObjectImpl implements MetricRetentionRule {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricRetentionRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.METRIC_RETENTION_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getRetentionExpression() {
		return (Expression)eGet(MetricsPackage.Literals.METRIC_RETENTION_RULE__RETENTION_EXPRESSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRetentionExpression(Expression newRetentionExpression) {
		eSet(MetricsPackage.Literals.METRIC_RETENTION_RULE__RETENTION_EXPRESSION, newRetentionExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIntervalHint() {
		return (Integer)eGet(MetricsPackage.Literals.METRIC_RETENTION_RULE__INTERVAL_HINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntervalHint(int newIntervalHint) {
		eSet(MetricsPackage.Literals.METRIC_RETENTION_RULE__INTERVAL_HINT, newIntervalHint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIntervalHint() {
		eUnset(MetricsPackage.Literals.METRIC_RETENTION_RULE__INTERVAL_HINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIntervalHint() {
		return eIsSet(MetricsPackage.Literals.METRIC_RETENTION_RULE__INTERVAL_HINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(MetricsPackage.Literals.METRIC_RETENTION_RULE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(MetricsPackage.Literals.METRIC_RETENTION_RULE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricRetentionPeriod getPeriod() {
		return (MetricRetentionPeriod)eGet(MetricsPackage.Literals.METRIC_RETENTION_RULE__PERIOD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriod(MetricRetentionPeriod newPeriod) {
		eSet(MetricsPackage.Literals.METRIC_RETENTION_RULE__PERIOD, newPeriod);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPeriod() {
		eUnset(MetricsPackage.Literals.METRIC_RETENTION_RULE__PERIOD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPeriod() {
		return eIsSet(MetricsPackage.Literals.METRIC_RETENTION_RULE__PERIOD);
	}

} //MetricRetentionRuleImpl
