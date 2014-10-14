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
package com.netxforge.netxstudio.library.impl;

import com.netxforge.netxstudio.generics.Value;

import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.library.ExpressionResult;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.RangeKind;

import com.netxforge.netxstudio.metrics.KindHintType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionResultImpl#getTargetResource <em>Target Resource</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionResultImpl#getTargetRange <em>Target Range</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionResultImpl#getTargetValues <em>Target Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionResultImpl#getTargetIntervalHint <em>Target Interval Hint</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionResultImpl#getTargetKindHint <em>Target Kind Hint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionResultImpl extends BaseExpressionResultImpl implements ExpressionResult {
	/**
	 * The cached value of the '{@link #getTargetResource() <em>Target Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetResource()
	 * @generated
	 * @ordered
	 */
	protected BaseResource targetResource;

	/**
	 * The default value of the '{@link #getTargetRange() <em>Target Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetRange()
	 * @generated
	 * @ordered
	 */
	protected static final RangeKind TARGET_RANGE_EDEFAULT = RangeKind.METRIC;

	/**
	 * The cached value of the '{@link #getTargetRange() <em>Target Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetRange()
	 * @generated
	 * @ordered
	 */
	protected RangeKind targetRange = TARGET_RANGE_EDEFAULT;

	/**
	 * This is true if the Target Range attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean targetRangeESet;

	/**
	 * The cached value of the '{@link #getTargetValues() <em>Target Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> targetValues;

	/**
	 * The default value of the '{@link #getTargetIntervalHint() <em>Target Interval Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetIntervalHint()
	 * @generated
	 * @ordered
	 */
	protected static final int TARGET_INTERVAL_HINT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTargetIntervalHint() <em>Target Interval Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetIntervalHint()
	 * @generated
	 * @ordered
	 */
	protected int targetIntervalHint = TARGET_INTERVAL_HINT_EDEFAULT;

	/**
	 * This is true if the Target Interval Hint attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean targetIntervalHintESet;

	/**
	 * The default value of the '{@link #getTargetKindHint() <em>Target Kind Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetKindHint()
	 * @generated
	 * @ordered
	 */
	protected static final KindHintType TARGET_KIND_HINT_EDEFAULT = KindHintType.BH;

	/**
	 * The cached value of the '{@link #getTargetKindHint() <em>Target Kind Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetKindHint()
	 * @generated
	 * @ordered
	 */
	protected KindHintType targetKindHint = TARGET_KIND_HINT_EDEFAULT;

	/**
	 * This is true if the Target Kind Hint attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean targetKindHintESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.EXPRESSION_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseResource getTargetResource() {
		if (targetResource != null && targetResource.eIsProxy()) {
			InternalEObject oldTargetResource = (InternalEObject)targetResource;
			targetResource = (BaseResource)eResolveProxy(oldTargetResource);
			if (targetResource != oldTargetResource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryPackage.EXPRESSION_RESULT__TARGET_RESOURCE, oldTargetResource, targetResource));
			}
		}
		return targetResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseResource basicGetTargetResource() {
		return targetResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetResource(BaseResource newTargetResource) {
		BaseResource oldTargetResource = targetResource;
		targetResource = newTargetResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EXPRESSION_RESULT__TARGET_RESOURCE, oldTargetResource, targetResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeKind getTargetRange() {
		return targetRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetRange(RangeKind newTargetRange) {
		RangeKind oldTargetRange = targetRange;
		targetRange = newTargetRange == null ? TARGET_RANGE_EDEFAULT : newTargetRange;
		boolean oldTargetRangeESet = targetRangeESet;
		targetRangeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EXPRESSION_RESULT__TARGET_RANGE, oldTargetRange, targetRange, !oldTargetRangeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTargetRange() {
		RangeKind oldTargetRange = targetRange;
		boolean oldTargetRangeESet = targetRangeESet;
		targetRange = TARGET_RANGE_EDEFAULT;
		targetRangeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LibraryPackage.EXPRESSION_RESULT__TARGET_RANGE, oldTargetRange, TARGET_RANGE_EDEFAULT, oldTargetRangeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTargetRange() {
		return targetRangeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getTargetValues() {
		if (targetValues == null) {
			targetValues = new EObjectContainmentEList<Value>(Value.class, this, LibraryPackage.EXPRESSION_RESULT__TARGET_VALUES);
		}
		return targetValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTargetIntervalHint() {
		return targetIntervalHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetIntervalHint(int newTargetIntervalHint) {
		int oldTargetIntervalHint = targetIntervalHint;
		targetIntervalHint = newTargetIntervalHint;
		boolean oldTargetIntervalHintESet = targetIntervalHintESet;
		targetIntervalHintESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EXPRESSION_RESULT__TARGET_INTERVAL_HINT, oldTargetIntervalHint, targetIntervalHint, !oldTargetIntervalHintESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTargetIntervalHint() {
		int oldTargetIntervalHint = targetIntervalHint;
		boolean oldTargetIntervalHintESet = targetIntervalHintESet;
		targetIntervalHint = TARGET_INTERVAL_HINT_EDEFAULT;
		targetIntervalHintESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LibraryPackage.EXPRESSION_RESULT__TARGET_INTERVAL_HINT, oldTargetIntervalHint, TARGET_INTERVAL_HINT_EDEFAULT, oldTargetIntervalHintESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTargetIntervalHint() {
		return targetIntervalHintESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KindHintType getTargetKindHint() {
		return targetKindHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetKindHint(KindHintType newTargetKindHint) {
		KindHintType oldTargetKindHint = targetKindHint;
		targetKindHint = newTargetKindHint == null ? TARGET_KIND_HINT_EDEFAULT : newTargetKindHint;
		boolean oldTargetKindHintESet = targetKindHintESet;
		targetKindHintESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EXPRESSION_RESULT__TARGET_KIND_HINT, oldTargetKindHint, targetKindHint, !oldTargetKindHintESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTargetKindHint() {
		KindHintType oldTargetKindHint = targetKindHint;
		boolean oldTargetKindHintESet = targetKindHintESet;
		targetKindHint = TARGET_KIND_HINT_EDEFAULT;
		targetKindHintESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LibraryPackage.EXPRESSION_RESULT__TARGET_KIND_HINT, oldTargetKindHint, TARGET_KIND_HINT_EDEFAULT, oldTargetKindHintESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTargetKindHint() {
		return targetKindHintESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryPackage.EXPRESSION_RESULT__TARGET_VALUES:
				return ((InternalEList<?>)getTargetValues()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LibraryPackage.EXPRESSION_RESULT__TARGET_RESOURCE:
				if (resolve) return getTargetResource();
				return basicGetTargetResource();
			case LibraryPackage.EXPRESSION_RESULT__TARGET_RANGE:
				return getTargetRange();
			case LibraryPackage.EXPRESSION_RESULT__TARGET_VALUES:
				return getTargetValues();
			case LibraryPackage.EXPRESSION_RESULT__TARGET_INTERVAL_HINT:
				return getTargetIntervalHint();
			case LibraryPackage.EXPRESSION_RESULT__TARGET_KIND_HINT:
				return getTargetKindHint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LibraryPackage.EXPRESSION_RESULT__TARGET_RESOURCE:
				setTargetResource((BaseResource)newValue);
				return;
			case LibraryPackage.EXPRESSION_RESULT__TARGET_RANGE:
				setTargetRange((RangeKind)newValue);
				return;
			case LibraryPackage.EXPRESSION_RESULT__TARGET_VALUES:
				getTargetValues().clear();
				getTargetValues().addAll((Collection<? extends Value>)newValue);
				return;
			case LibraryPackage.EXPRESSION_RESULT__TARGET_INTERVAL_HINT:
				setTargetIntervalHint((Integer)newValue);
				return;
			case LibraryPackage.EXPRESSION_RESULT__TARGET_KIND_HINT:
				setTargetKindHint((KindHintType)newValue);
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
			case LibraryPackage.EXPRESSION_RESULT__TARGET_RESOURCE:
				setTargetResource((BaseResource)null);
				return;
			case LibraryPackage.EXPRESSION_RESULT__TARGET_RANGE:
				unsetTargetRange();
				return;
			case LibraryPackage.EXPRESSION_RESULT__TARGET_VALUES:
				getTargetValues().clear();
				return;
			case LibraryPackage.EXPRESSION_RESULT__TARGET_INTERVAL_HINT:
				unsetTargetIntervalHint();
				return;
			case LibraryPackage.EXPRESSION_RESULT__TARGET_KIND_HINT:
				unsetTargetKindHint();
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
			case LibraryPackage.EXPRESSION_RESULT__TARGET_RESOURCE:
				return targetResource != null;
			case LibraryPackage.EXPRESSION_RESULT__TARGET_RANGE:
				return isSetTargetRange();
			case LibraryPackage.EXPRESSION_RESULT__TARGET_VALUES:
				return targetValues != null && !targetValues.isEmpty();
			case LibraryPackage.EXPRESSION_RESULT__TARGET_INTERVAL_HINT:
				return isSetTargetIntervalHint();
			case LibraryPackage.EXPRESSION_RESULT__TARGET_KIND_HINT:
				return isSetTargetKindHint();
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
		result.append(" (targetRange: ");
		if (targetRangeESet) result.append(targetRange); else result.append("<unset>");
		result.append(", targetIntervalHint: ");
		if (targetIntervalHintESet) result.append(targetIntervalHint); else result.append("<unset>");
		result.append(", targetKindHint: ");
		if (targetKindHintESet) result.append(targetKindHint); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ExpressionResultImpl
