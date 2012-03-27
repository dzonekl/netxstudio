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
package com.netxforge.netxstudio.generics.impl;

import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.generics.ExpansionDurationSetting;
import com.netxforge.netxstudio.generics.ExpansionDurationValue;
import com.netxforge.netxstudio.generics.GenericsPackage;

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
		return (ExpansionDurationValue)eGet(GenericsPackage.Literals.EXPANSION_DURATION_SETTING__QUICK_DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuickDuration(ExpansionDurationValue newQuickDuration) {
		eSet(GenericsPackage.Literals.EXPANSION_DURATION_SETTING__QUICK_DURATION, newQuickDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionDurationValue getShortDuration() {
		return (ExpansionDurationValue)eGet(GenericsPackage.Literals.EXPANSION_DURATION_SETTING__SHORT_DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShortDuration(ExpansionDurationValue newShortDuration) {
		eSet(GenericsPackage.Literals.EXPANSION_DURATION_SETTING__SHORT_DURATION, newShortDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionDurationValue getMediumDuration() {
		return (ExpansionDurationValue)eGet(GenericsPackage.Literals.EXPANSION_DURATION_SETTING__MEDIUM_DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMediumDuration(ExpansionDurationValue newMediumDuration) {
		eSet(GenericsPackage.Literals.EXPANSION_DURATION_SETTING__MEDIUM_DURATION, newMediumDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionDurationValue getLongDuration() {
		return (ExpansionDurationValue)eGet(GenericsPackage.Literals.EXPANSION_DURATION_SETTING__LONG_DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongDuration(ExpansionDurationValue newLongDuration) {
		eSet(GenericsPackage.Literals.EXPANSION_DURATION_SETTING__LONG_DURATION, newLongDuration);
	}

} //ExpansionDurationSettingImpl
