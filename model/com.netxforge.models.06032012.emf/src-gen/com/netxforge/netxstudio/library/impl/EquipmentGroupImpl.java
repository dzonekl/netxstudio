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

import com.netxforge.netxstudio.generics.DiagramInfo;

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.EquipmentGroup;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.Parameter;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equipment Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentGroupImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentGroupImpl#getEquipmentGroupResources <em>Equipment Group Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentGroupImpl#getExpressionRefs <em>Expression Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentGroupImpl#getEquipmentRefs <em>Equipment Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentGroupImpl#getParameterRefs <em>Parameter Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentGroupImpl#getAllEquipmentResources <em>All Equipment Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentGroupImpl#getAllEquipments <em>All Equipments</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentGroupImpl#getCount <em>Count</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentGroupImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentGroupImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EquipmentGroupImpl extends BaseImpl implements EquipmentGroup {
	/**
	 * The cached value of the '{@link #getDiagrams() <em>Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<DiagramInfo> diagrams;

	/**
	 * The cached value of the '{@link #getEquipmentGroupResources() <em>Equipment Group Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentGroupResources()
	 * @generated
	 * @ordered
	 */
	protected EList<NetXResource> equipmentGroupResources;

	/**
	 * The cached value of the '{@link #getExpressionRefs() <em>Expression Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> expressionRefs;

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
	 * The cached value of the '{@link #getParameterRefs() <em>Parameter Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameterRefs;

	/**
	 * The cached setting delegate for the '{@link #getAllEquipmentResources() <em>All Equipment Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllEquipmentResources()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate ALL_EQUIPMENT_RESOURCES__ESETTING_DELEGATE = ((EStructuralFeature.Internal)LibraryPackage.Literals.EQUIPMENT_GROUP__ALL_EQUIPMENT_RESOURCES).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getAllEquipments() <em>All Equipments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllEquipments()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate ALL_EQUIPMENTS__ESETTING_DELEGATE = ((EStructuralFeature.Internal)LibraryPackage.Literals.EQUIPMENT_GROUP__ALL_EQUIPMENTS).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate COUNT__ESETTING_DELEGATE = ((EStructuralFeature.Internal)LibraryPackage.Literals.EQUIPMENT_GROUP__COUNT).getSettingDelegate();

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

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
	protected EquipmentGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.EQUIPMENT_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiagramInfo> getDiagrams() {
		if (diagrams == null) {
			diagrams = new EObjectContainmentEList<DiagramInfo>(DiagramInfo.class, this, LibraryPackage.EQUIPMENT_GROUP__DIAGRAMS);
		}
		return diagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NetXResource> getEquipmentGroupResources() {
		if (equipmentGroupResources == null) {
			equipmentGroupResources = new EObjectContainmentEList<NetXResource>(NetXResource.class, this, LibraryPackage.EQUIPMENT_GROUP__EQUIPMENT_GROUP_RESOURCES);
		}
		return equipmentGroupResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getExpressionRefs() {
		if (expressionRefs == null) {
			expressionRefs = new EObjectResolvingEList<Expression>(Expression.class, this, LibraryPackage.EQUIPMENT_GROUP__EXPRESSION_REFS);
		}
		return expressionRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Equipment> getEquipmentRefs() {
		if (equipmentRefs == null) {
			equipmentRefs = new EObjectResolvingEList<Equipment>(Equipment.class, this, LibraryPackage.EQUIPMENT_GROUP__EQUIPMENT_REFS);
		}
		return equipmentRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameterRefs() {
		if (parameterRefs == null) {
			parameterRefs = new EObjectResolvingEList<Parameter>(Parameter.class, this, LibraryPackage.EQUIPMENT_GROUP__PARAMETER_REFS);
		}
		return parameterRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NetXResource> getAllEquipmentResources() {
		return (EList<NetXResource>)ALL_EQUIPMENT_RESOURCES__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Equipment> getAllEquipments() {
		return (EList<Equipment>)ALL_EQUIPMENTS__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCount() {
		return (Integer)COUNT__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCount(int newCount) {
		COUNT__ESETTING_DELEGATE.dynamicSet(this, null, 0, newCount);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCount() {
		COUNT__ESETTING_DELEGATE.dynamicUnset(this, null, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCount() {
		return COUNT__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EQUIPMENT_GROUP__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EQUIPMENT_GROUP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryPackage.EQUIPMENT_GROUP__DIAGRAMS:
				return ((InternalEList<?>)getDiagrams()).basicRemove(otherEnd, msgs);
			case LibraryPackage.EQUIPMENT_GROUP__EQUIPMENT_GROUP_RESOURCES:
				return ((InternalEList<?>)getEquipmentGroupResources()).basicRemove(otherEnd, msgs);
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
			case LibraryPackage.EQUIPMENT_GROUP__DIAGRAMS:
				return getDiagrams();
			case LibraryPackage.EQUIPMENT_GROUP__EQUIPMENT_GROUP_RESOURCES:
				return getEquipmentGroupResources();
			case LibraryPackage.EQUIPMENT_GROUP__EXPRESSION_REFS:
				return getExpressionRefs();
			case LibraryPackage.EQUIPMENT_GROUP__EQUIPMENT_REFS:
				return getEquipmentRefs();
			case LibraryPackage.EQUIPMENT_GROUP__PARAMETER_REFS:
				return getParameterRefs();
			case LibraryPackage.EQUIPMENT_GROUP__ALL_EQUIPMENT_RESOURCES:
				return getAllEquipmentResources();
			case LibraryPackage.EQUIPMENT_GROUP__ALL_EQUIPMENTS:
				return getAllEquipments();
			case LibraryPackage.EQUIPMENT_GROUP__COUNT:
				return getCount();
			case LibraryPackage.EQUIPMENT_GROUP__DESCRIPTION:
				return getDescription();
			case LibraryPackage.EQUIPMENT_GROUP__NAME:
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
			case LibraryPackage.EQUIPMENT_GROUP__DIAGRAMS:
				getDiagrams().clear();
				getDiagrams().addAll((Collection<? extends DiagramInfo>)newValue);
				return;
			case LibraryPackage.EQUIPMENT_GROUP__EQUIPMENT_GROUP_RESOURCES:
				getEquipmentGroupResources().clear();
				getEquipmentGroupResources().addAll((Collection<? extends NetXResource>)newValue);
				return;
			case LibraryPackage.EQUIPMENT_GROUP__EXPRESSION_REFS:
				getExpressionRefs().clear();
				getExpressionRefs().addAll((Collection<? extends Expression>)newValue);
				return;
			case LibraryPackage.EQUIPMENT_GROUP__EQUIPMENT_REFS:
				getEquipmentRefs().clear();
				getEquipmentRefs().addAll((Collection<? extends Equipment>)newValue);
				return;
			case LibraryPackage.EQUIPMENT_GROUP__PARAMETER_REFS:
				getParameterRefs().clear();
				getParameterRefs().addAll((Collection<? extends Parameter>)newValue);
				return;
			case LibraryPackage.EQUIPMENT_GROUP__ALL_EQUIPMENT_RESOURCES:
				getAllEquipmentResources().clear();
				getAllEquipmentResources().addAll((Collection<? extends NetXResource>)newValue);
				return;
			case LibraryPackage.EQUIPMENT_GROUP__ALL_EQUIPMENTS:
				getAllEquipments().clear();
				getAllEquipments().addAll((Collection<? extends Equipment>)newValue);
				return;
			case LibraryPackage.EQUIPMENT_GROUP__COUNT:
				setCount((Integer)newValue);
				return;
			case LibraryPackage.EQUIPMENT_GROUP__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case LibraryPackage.EQUIPMENT_GROUP__NAME:
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
			case LibraryPackage.EQUIPMENT_GROUP__DIAGRAMS:
				getDiagrams().clear();
				return;
			case LibraryPackage.EQUIPMENT_GROUP__EQUIPMENT_GROUP_RESOURCES:
				getEquipmentGroupResources().clear();
				return;
			case LibraryPackage.EQUIPMENT_GROUP__EXPRESSION_REFS:
				getExpressionRefs().clear();
				return;
			case LibraryPackage.EQUIPMENT_GROUP__EQUIPMENT_REFS:
				getEquipmentRefs().clear();
				return;
			case LibraryPackage.EQUIPMENT_GROUP__PARAMETER_REFS:
				getParameterRefs().clear();
				return;
			case LibraryPackage.EQUIPMENT_GROUP__ALL_EQUIPMENT_RESOURCES:
				getAllEquipmentResources().clear();
				return;
			case LibraryPackage.EQUIPMENT_GROUP__ALL_EQUIPMENTS:
				getAllEquipments().clear();
				return;
			case LibraryPackage.EQUIPMENT_GROUP__COUNT:
				unsetCount();
				return;
			case LibraryPackage.EQUIPMENT_GROUP__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case LibraryPackage.EQUIPMENT_GROUP__NAME:
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
			case LibraryPackage.EQUIPMENT_GROUP__DIAGRAMS:
				return diagrams != null && !diagrams.isEmpty();
			case LibraryPackage.EQUIPMENT_GROUP__EQUIPMENT_GROUP_RESOURCES:
				return equipmentGroupResources != null && !equipmentGroupResources.isEmpty();
			case LibraryPackage.EQUIPMENT_GROUP__EXPRESSION_REFS:
				return expressionRefs != null && !expressionRefs.isEmpty();
			case LibraryPackage.EQUIPMENT_GROUP__EQUIPMENT_REFS:
				return equipmentRefs != null && !equipmentRefs.isEmpty();
			case LibraryPackage.EQUIPMENT_GROUP__PARAMETER_REFS:
				return parameterRefs != null && !parameterRefs.isEmpty();
			case LibraryPackage.EQUIPMENT_GROUP__ALL_EQUIPMENT_RESOURCES:
				return ALL_EQUIPMENT_RESOURCES__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case LibraryPackage.EQUIPMENT_GROUP__ALL_EQUIPMENTS:
				return ALL_EQUIPMENTS__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case LibraryPackage.EQUIPMENT_GROUP__COUNT:
				return isSetCount();
			case LibraryPackage.EQUIPMENT_GROUP__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case LibraryPackage.EQUIPMENT_GROUP__NAME:
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
		result.append(" (description: ");
		result.append(description);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //EquipmentGroupImpl
