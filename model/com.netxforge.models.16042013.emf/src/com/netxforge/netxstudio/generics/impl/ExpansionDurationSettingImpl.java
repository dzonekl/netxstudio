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
package com.netxforge.netxstudio.generics.impl;

import com.netxforge.netxstudio.generics.ExpansionDurationSetting;
import com.netxforge.netxstudio.generics.ExpansionDurationValue;
import com.netxforge.netxstudio.generics.GenericsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expansion Duration Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.ExpansionDurationSettingImpl#getQuickDuration <em>Quick Duration</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.ExpansionDurationSettingImpl#getShortDuration <em>Short Duration</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.ExpansionDurationSettingImpl#getMediumDuration <em>Medium Duration</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.ExpansionDurationSettingImpl#getLongDuration <em>Long Duration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpansionDurationSettingImpl extends BaseImpl implements ExpansionDurationSetting {
	/**
	 * The cached value of the '{@link #getQuickDuration() <em>Quick Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuickDuration()
	 * @generated
	 * @ordered
	 */
	protected ExpansionDurationValue quickDuration;

	/**
	 * The cached value of the '{@link #getShortDuration() <em>Short Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortDuration()
	 * @generated
	 * @ordered
	 */
	protected ExpansionDurationValue shortDuration;

	/**
	 * The cached value of the '{@link #getMediumDuration() <em>Medium Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediumDuration()
	 * @generated
	 * @ordered
	 */
	protected ExpansionDurationValue mediumDuration;

	/**
	 * The cached value of the '{@link #getLongDuration() <em>Long Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongDuration()
	 * @generated
	 * @ordered
	 */
	protected ExpansionDurationValue longDuration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpansionDurationSettingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericsPackage.Literals.EXPANSION_DURATION_SETTING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionDurationValue getQuickDuration() {
		return quickDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQuickDuration(ExpansionDurationValue newQuickDuration, NotificationChain msgs) {
		ExpansionDurationValue oldQuickDuration = quickDuration;
		quickDuration = newQuickDuration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenericsPackage.EXPANSION_DURATION_SETTING__QUICK_DURATION, oldQuickDuration, newQuickDuration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuickDuration(ExpansionDurationValue newQuickDuration) {
		if (newQuickDuration != quickDuration) {
			NotificationChain msgs = null;
			if (quickDuration != null)
				msgs = ((InternalEObject)quickDuration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GenericsPackage.EXPANSION_DURATION_SETTING__QUICK_DURATION, null, msgs);
			if (newQuickDuration != null)
				msgs = ((InternalEObject)newQuickDuration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GenericsPackage.EXPANSION_DURATION_SETTING__QUICK_DURATION, null, msgs);
			msgs = basicSetQuickDuration(newQuickDuration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.EXPANSION_DURATION_SETTING__QUICK_DURATION, newQuickDuration, newQuickDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionDurationValue getShortDuration() {
		return shortDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetShortDuration(ExpansionDurationValue newShortDuration, NotificationChain msgs) {
		ExpansionDurationValue oldShortDuration = shortDuration;
		shortDuration = newShortDuration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenericsPackage.EXPANSION_DURATION_SETTING__SHORT_DURATION, oldShortDuration, newShortDuration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShortDuration(ExpansionDurationValue newShortDuration) {
		if (newShortDuration != shortDuration) {
			NotificationChain msgs = null;
			if (shortDuration != null)
				msgs = ((InternalEObject)shortDuration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GenericsPackage.EXPANSION_DURATION_SETTING__SHORT_DURATION, null, msgs);
			if (newShortDuration != null)
				msgs = ((InternalEObject)newShortDuration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GenericsPackage.EXPANSION_DURATION_SETTING__SHORT_DURATION, null, msgs);
			msgs = basicSetShortDuration(newShortDuration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.EXPANSION_DURATION_SETTING__SHORT_DURATION, newShortDuration, newShortDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionDurationValue getMediumDuration() {
		return mediumDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMediumDuration(ExpansionDurationValue newMediumDuration, NotificationChain msgs) {
		ExpansionDurationValue oldMediumDuration = mediumDuration;
		mediumDuration = newMediumDuration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenericsPackage.EXPANSION_DURATION_SETTING__MEDIUM_DURATION, oldMediumDuration, newMediumDuration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMediumDuration(ExpansionDurationValue newMediumDuration) {
		if (newMediumDuration != mediumDuration) {
			NotificationChain msgs = null;
			if (mediumDuration != null)
				msgs = ((InternalEObject)mediumDuration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GenericsPackage.EXPANSION_DURATION_SETTING__MEDIUM_DURATION, null, msgs);
			if (newMediumDuration != null)
				msgs = ((InternalEObject)newMediumDuration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GenericsPackage.EXPANSION_DURATION_SETTING__MEDIUM_DURATION, null, msgs);
			msgs = basicSetMediumDuration(newMediumDuration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.EXPANSION_DURATION_SETTING__MEDIUM_DURATION, newMediumDuration, newMediumDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionDurationValue getLongDuration() {
		return longDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLongDuration(ExpansionDurationValue newLongDuration, NotificationChain msgs) {
		ExpansionDurationValue oldLongDuration = longDuration;
		longDuration = newLongDuration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenericsPackage.EXPANSION_DURATION_SETTING__LONG_DURATION, oldLongDuration, newLongDuration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongDuration(ExpansionDurationValue newLongDuration) {
		if (newLongDuration != longDuration) {
			NotificationChain msgs = null;
			if (longDuration != null)
				msgs = ((InternalEObject)longDuration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GenericsPackage.EXPANSION_DURATION_SETTING__LONG_DURATION, null, msgs);
			if (newLongDuration != null)
				msgs = ((InternalEObject)newLongDuration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GenericsPackage.EXPANSION_DURATION_SETTING__LONG_DURATION, null, msgs);
			msgs = basicSetLongDuration(newLongDuration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.EXPANSION_DURATION_SETTING__LONG_DURATION, newLongDuration, newLongDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenericsPackage.EXPANSION_DURATION_SETTING__QUICK_DURATION:
				return basicSetQuickDuration(null, msgs);
			case GenericsPackage.EXPANSION_DURATION_SETTING__SHORT_DURATION:
				return basicSetShortDuration(null, msgs);
			case GenericsPackage.EXPANSION_DURATION_SETTING__MEDIUM_DURATION:
				return basicSetMediumDuration(null, msgs);
			case GenericsPackage.EXPANSION_DURATION_SETTING__LONG_DURATION:
				return basicSetLongDuration(null, msgs);
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
			case GenericsPackage.EXPANSION_DURATION_SETTING__QUICK_DURATION:
				return getQuickDuration();
			case GenericsPackage.EXPANSION_DURATION_SETTING__SHORT_DURATION:
				return getShortDuration();
			case GenericsPackage.EXPANSION_DURATION_SETTING__MEDIUM_DURATION:
				return getMediumDuration();
			case GenericsPackage.EXPANSION_DURATION_SETTING__LONG_DURATION:
				return getLongDuration();
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
			case GenericsPackage.EXPANSION_DURATION_SETTING__QUICK_DURATION:
				setQuickDuration((ExpansionDurationValue)newValue);
				return;
			case GenericsPackage.EXPANSION_DURATION_SETTING__SHORT_DURATION:
				setShortDuration((ExpansionDurationValue)newValue);
				return;
			case GenericsPackage.EXPANSION_DURATION_SETTING__MEDIUM_DURATION:
				setMediumDuration((ExpansionDurationValue)newValue);
				return;
			case GenericsPackage.EXPANSION_DURATION_SETTING__LONG_DURATION:
				setLongDuration((ExpansionDurationValue)newValue);
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
			case GenericsPackage.EXPANSION_DURATION_SETTING__QUICK_DURATION:
				setQuickDuration((ExpansionDurationValue)null);
				return;
			case GenericsPackage.EXPANSION_DURATION_SETTING__SHORT_DURATION:
				setShortDuration((ExpansionDurationValue)null);
				return;
			case GenericsPackage.EXPANSION_DURATION_SETTING__MEDIUM_DURATION:
				setMediumDuration((ExpansionDurationValue)null);
				return;
			case GenericsPackage.EXPANSION_DURATION_SETTING__LONG_DURATION:
				setLongDuration((ExpansionDurationValue)null);
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
			case GenericsPackage.EXPANSION_DURATION_SETTING__QUICK_DURATION:
				return quickDuration != null;
			case GenericsPackage.EXPANSION_DURATION_SETTING__SHORT_DURATION:
				return shortDuration != null;
			case GenericsPackage.EXPANSION_DURATION_SETTING__MEDIUM_DURATION:
				return mediumDuration != null;
			case GenericsPackage.EXPANSION_DURATION_SETTING__LONG_DURATION:
				return longDuration != null;
		}
		return super.eIsSet(featureID);
	}

} //ExpansionDurationSettingImpl
