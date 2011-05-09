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
package com.netxforge.netxstudio.library.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.EquipmentGroup;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.services.ServiceProfile;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionImpl#getExpressionLines <em>Expression Lines</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionImpl#getEquipmentRefs <em>Equipment Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionImpl#getFunctionRefs <em>Function Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionImpl#getEquipmentGroupRefs <em>Equipment Group Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionImpl#getServiceProfileRefs <em>Service Profile Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionImpl extends CDOObjectImpl implements Expression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.EXPRESSION;
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
	@SuppressWarnings("unchecked")
	public EList<String> getExpressionLines() {
		return (EList<String>)eGet(LibraryPackage.Literals.EXPRESSION__EXPRESSION_LINES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Equipment> getEquipmentRefs() {
		return (EList<Equipment>)eGet(LibraryPackage.Literals.EXPRESSION__EQUIPMENT_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Function> getFunctionRefs() {
		return (EList<Function>)eGet(LibraryPackage.Literals.EXPRESSION__FUNCTION_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<EquipmentGroup> getEquipmentGroupRefs() {
		return (EList<EquipmentGroup>)eGet(LibraryPackage.Literals.EXPRESSION__EQUIPMENT_GROUP_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ServiceProfile> getServiceProfileRefs() {
		return (EList<ServiceProfile>)eGet(LibraryPackage.Literals.EXPRESSION__SERVICE_PROFILE_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(LibraryPackage.Literals.EXPRESSION__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(LibraryPackage.Literals.EXPRESSION__NAME, newName);
	}

} //ExpressionImpl
