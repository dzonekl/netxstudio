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

import com.netxforge.netxstudio.library.Expression;

import com.netxforge.netxstudio.metrics.MetricRetentionPeriod;
import com.netxforge.netxstudio.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.metrics.MetricsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

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
public class MetricRetentionRuleImpl extends MinimalEObjectImpl.Container implements MetricRetentionRule {
	/**
	 * The cached value of the '{@link #getRetentionExpression() <em>Retention Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetentionExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression retentionExpression;

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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPeriod() <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final MetricRetentionPeriod PERIOD_EDEFAULT = MetricRetentionPeriod.ALWAYS;

	/**
	 * The cached value of the '{@link #getPeriod() <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected MetricRetentionPeriod period = PERIOD_EDEFAULT;

	/**
	 * This is true if the Period attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean periodESet;

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
	public Expression getRetentionExpression() {
		if (retentionExpression != null && retentionExpression.eIsProxy()) {
			InternalEObject oldRetentionExpression = (InternalEObject)retentionExpression;
			retentionExpression = (Expression)eResolveProxy(oldRetentionExpression);
			if (retentionExpression != oldRetentionExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetricsPackage.METRIC_RETENTION_RULE__RETENTION_EXPRESSION, oldRetentionExpression, retentionExpression));
			}
		}
		return retentionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetRetentionExpression() {
		return retentionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRetentionExpression(Expression newRetentionExpression) {
		Expression oldRetentionExpression = retentionExpression;
		retentionExpression = newRetentionExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC_RETENTION_RULE__RETENTION_EXPRESSION, oldRetentionExpression, retentionExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC_RETENTION_RULE__INTERVAL_HINT, oldIntervalHint, intervalHint, !oldIntervalHintESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.METRIC_RETENTION_RULE__INTERVAL_HINT, oldIntervalHint, INTERVAL_HINT_EDEFAULT, oldIntervalHintESet));
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
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC_RETENTION_RULE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricRetentionPeriod getPeriod() {
		return period;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriod(MetricRetentionPeriod newPeriod) {
		MetricRetentionPeriod oldPeriod = period;
		period = newPeriod == null ? PERIOD_EDEFAULT : newPeriod;
		boolean oldPeriodESet = periodESet;
		periodESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC_RETENTION_RULE__PERIOD, oldPeriod, period, !oldPeriodESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPeriod() {
		MetricRetentionPeriod oldPeriod = period;
		boolean oldPeriodESet = periodESet;
		period = PERIOD_EDEFAULT;
		periodESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.METRIC_RETENTION_RULE__PERIOD, oldPeriod, PERIOD_EDEFAULT, oldPeriodESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPeriod() {
		return periodESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetricsPackage.METRIC_RETENTION_RULE__RETENTION_EXPRESSION:
				if (resolve) return getRetentionExpression();
				return basicGetRetentionExpression();
			case MetricsPackage.METRIC_RETENTION_RULE__INTERVAL_HINT:
				return getIntervalHint();
			case MetricsPackage.METRIC_RETENTION_RULE__NAME:
				return getName();
			case MetricsPackage.METRIC_RETENTION_RULE__PERIOD:
				return getPeriod();
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
			case MetricsPackage.METRIC_RETENTION_RULE__RETENTION_EXPRESSION:
				setRetentionExpression((Expression)newValue);
				return;
			case MetricsPackage.METRIC_RETENTION_RULE__INTERVAL_HINT:
				setIntervalHint((Integer)newValue);
				return;
			case MetricsPackage.METRIC_RETENTION_RULE__NAME:
				setName((String)newValue);
				return;
			case MetricsPackage.METRIC_RETENTION_RULE__PERIOD:
				setPeriod((MetricRetentionPeriod)newValue);
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
			case MetricsPackage.METRIC_RETENTION_RULE__RETENTION_EXPRESSION:
				setRetentionExpression((Expression)null);
				return;
			case MetricsPackage.METRIC_RETENTION_RULE__INTERVAL_HINT:
				unsetIntervalHint();
				return;
			case MetricsPackage.METRIC_RETENTION_RULE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MetricsPackage.METRIC_RETENTION_RULE__PERIOD:
				unsetPeriod();
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
			case MetricsPackage.METRIC_RETENTION_RULE__RETENTION_EXPRESSION:
				return retentionExpression != null;
			case MetricsPackage.METRIC_RETENTION_RULE__INTERVAL_HINT:
				return isSetIntervalHint();
			case MetricsPackage.METRIC_RETENTION_RULE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MetricsPackage.METRIC_RETENTION_RULE__PERIOD:
				return isSetPeriod();
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
		result.append(", name: ");
		result.append(name);
		result.append(", period: ");
		if (periodESet) result.append(period); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //MetricRetentionRuleImpl
