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

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.EquipmentGroup;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;

import com.netxforge.netxstudio.services.ServiceProfile;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

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
public class ExpressionImpl extends EObjectImpl implements Expression {
	/**
	 * The cached value of the '{@link #getExpressionLines() <em>Expression Lines</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionLines()
	 * @generated
	 * @ordered
	 */
	protected EList<String> expressionLines;

	/**
	 * The cached value of the '{@link #getEquipmentRefs() <em>Equipment Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Equipment> equipmentRefs;

	/**
	 * The cached value of the '{@link #getFunctionRefs() <em>Function Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> functionRefs;

	/**
	 * The cached value of the '{@link #getEquipmentGroupRefs() <em>Equipment Group Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentGroupRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<EquipmentGroup> equipmentGroupRefs;

	/**
	 * The cached value of the '{@link #getServiceProfileRefs() <em>Service Profile Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceProfileRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceProfile> serviceProfileRefs;

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
	public EList<String> getExpressionLines() {
		if (expressionLines == null) {
			expressionLines = new EDataTypeEList<String>(String.class, this, LibraryPackage.EXPRESSION__EXPRESSION_LINES);
		}
		return expressionLines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Equipment> getEquipmentRefs() {
		if (equipmentRefs == null) {
			equipmentRefs = new EObjectWithInverseResolvingEList.ManyInverse<Equipment>(Equipment.class, this, LibraryPackage.EXPRESSION__EQUIPMENT_REFS, LibraryPackage.EQUIPMENT__EQUIPMENT_EXPRESSION_REFS);
		}
		return equipmentRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Function> getFunctionRefs() {
		if (functionRefs == null) {
			functionRefs = new EObjectWithInverseResolvingEList.ManyInverse<Function>(Function.class, this, LibraryPackage.EXPRESSION__FUNCTION_REFS, LibraryPackage.FUNCTION__FUNCTION_EXPRESSION_REFS);
		}
		return functionRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EquipmentGroup> getEquipmentGroupRefs() {
		if (equipmentGroupRefs == null) {
			equipmentGroupRefs = new EObjectWithInverseResolvingEList.ManyInverse<EquipmentGroup>(EquipmentGroup.class, this, LibraryPackage.EXPRESSION__EQUIPMENT_GROUP_REFS, LibraryPackage.EQUIPMENT_GROUP__EXPRESSION_REFS);
		}
		return equipmentGroupRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceProfile> getServiceProfileRefs() {
		if (serviceProfileRefs == null) {
			serviceProfileRefs = new EObjectResolvingEList<ServiceProfile>(ServiceProfile.class, this, LibraryPackage.EXPRESSION__SERVICE_PROFILE_REFS);
		}
		return serviceProfileRefs;
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
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EXPRESSION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryPackage.EXPRESSION__EQUIPMENT_REFS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEquipmentRefs()).basicAdd(otherEnd, msgs);
			case LibraryPackage.EXPRESSION__FUNCTION_REFS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFunctionRefs()).basicAdd(otherEnd, msgs);
			case LibraryPackage.EXPRESSION__EQUIPMENT_GROUP_REFS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEquipmentGroupRefs()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryPackage.EXPRESSION__EQUIPMENT_REFS:
				return ((InternalEList<?>)getEquipmentRefs()).basicRemove(otherEnd, msgs);
			case LibraryPackage.EXPRESSION__FUNCTION_REFS:
				return ((InternalEList<?>)getFunctionRefs()).basicRemove(otherEnd, msgs);
			case LibraryPackage.EXPRESSION__EQUIPMENT_GROUP_REFS:
				return ((InternalEList<?>)getEquipmentGroupRefs()).basicRemove(otherEnd, msgs);
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
			case LibraryPackage.EXPRESSION__EXPRESSION_LINES:
				return getExpressionLines();
			case LibraryPackage.EXPRESSION__EQUIPMENT_REFS:
				return getEquipmentRefs();
			case LibraryPackage.EXPRESSION__FUNCTION_REFS:
				return getFunctionRefs();
			case LibraryPackage.EXPRESSION__EQUIPMENT_GROUP_REFS:
				return getEquipmentGroupRefs();
			case LibraryPackage.EXPRESSION__SERVICE_PROFILE_REFS:
				return getServiceProfileRefs();
			case LibraryPackage.EXPRESSION__NAME:
				return getName();
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
			case LibraryPackage.EXPRESSION__EXPRESSION_LINES:
				getExpressionLines().clear();
				getExpressionLines().addAll((Collection<? extends String>)newValue);
				return;
			case LibraryPackage.EXPRESSION__EQUIPMENT_REFS:
				getEquipmentRefs().clear();
				getEquipmentRefs().addAll((Collection<? extends Equipment>)newValue);
				return;
			case LibraryPackage.EXPRESSION__FUNCTION_REFS:
				getFunctionRefs().clear();
				getFunctionRefs().addAll((Collection<? extends Function>)newValue);
				return;
			case LibraryPackage.EXPRESSION__EQUIPMENT_GROUP_REFS:
				getEquipmentGroupRefs().clear();
				getEquipmentGroupRefs().addAll((Collection<? extends EquipmentGroup>)newValue);
				return;
			case LibraryPackage.EXPRESSION__SERVICE_PROFILE_REFS:
				getServiceProfileRefs().clear();
				getServiceProfileRefs().addAll((Collection<? extends ServiceProfile>)newValue);
				return;
			case LibraryPackage.EXPRESSION__NAME:
				setName((String)newValue);
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
			case LibraryPackage.EXPRESSION__EXPRESSION_LINES:
				getExpressionLines().clear();
				return;
			case LibraryPackage.EXPRESSION__EQUIPMENT_REFS:
				getEquipmentRefs().clear();
				return;
			case LibraryPackage.EXPRESSION__FUNCTION_REFS:
				getFunctionRefs().clear();
				return;
			case LibraryPackage.EXPRESSION__EQUIPMENT_GROUP_REFS:
				getEquipmentGroupRefs().clear();
				return;
			case LibraryPackage.EXPRESSION__SERVICE_PROFILE_REFS:
				getServiceProfileRefs().clear();
				return;
			case LibraryPackage.EXPRESSION__NAME:
				setName(NAME_EDEFAULT);
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
			case LibraryPackage.EXPRESSION__EXPRESSION_LINES:
				return expressionLines != null && !expressionLines.isEmpty();
			case LibraryPackage.EXPRESSION__EQUIPMENT_REFS:
				return equipmentRefs != null && !equipmentRefs.isEmpty();
			case LibraryPackage.EXPRESSION__FUNCTION_REFS:
				return functionRefs != null && !functionRefs.isEmpty();
			case LibraryPackage.EXPRESSION__EQUIPMENT_GROUP_REFS:
				return equipmentGroupRefs != null && !equipmentGroupRefs.isEmpty();
			case LibraryPackage.EXPRESSION__SERVICE_PROFILE_REFS:
				return serviceProfileRefs != null && !serviceProfileRefs.isEmpty();
			case LibraryPackage.EXPRESSION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (expressionLines: ");
		result.append(expressionLines);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ExpressionImpl
