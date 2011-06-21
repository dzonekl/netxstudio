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
package com.netxforge.netxstudio.operators.impl;

import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.generics.ExpansionDuration;
import com.netxforge.netxstudio.generics.impl.BaseImpl;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.operators.ExpansionExperience;
import com.netxforge.netxstudio.operators.OperatorsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expansion Experience</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.ExpansionExperienceImpl#getEquipmentRef <em>Equipment Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.ExpansionExperienceImpl#getDuration <em>Duration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpansionExperienceImpl extends BaseImpl implements ExpansionExperience {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpansionExperienceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorsPackage.Literals.EXPANSION_EXPERIENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equipment getEquipmentRef() {
		return (Equipment)eGet(OperatorsPackage.Literals.EXPANSION_EXPERIENCE__EQUIPMENT_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquipmentRef(Equipment newEquipmentRef) {
		eSet(OperatorsPackage.Literals.EXPANSION_EXPERIENCE__EQUIPMENT_REF, newEquipmentRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionDuration getDuration() {
		return (ExpansionDuration)eGet(OperatorsPackage.Literals.EXPANSION_EXPERIENCE__DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(ExpansionDuration newDuration) {
		eSet(OperatorsPackage.Literals.EXPANSION_EXPERIENCE__DURATION, newDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDuration() {
		eUnset(OperatorsPackage.Literals.EXPANSION_EXPERIENCE__DURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDuration() {
		return eIsSet(OperatorsPackage.Literals.EXPANSION_EXPERIENCE__DURATION);
	}

} //ExpansionExperienceImpl
