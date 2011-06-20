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

import com.netxforge.netxstudio.generics.DiagramInfo;
import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.generics.MultiImage;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.EquipmentGroup;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.Parameter;
import com.netxforge.netxstudio.library.RedundancyType;
import com.netxforge.netxstudio.library.StateType;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.operators.EquipmentRelationship;
import com.netxforge.netxstudio.protocols.Protocol;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equipment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getLifecycle <em>Lifecycle</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getEquipments <em>Equipments</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getEquipmentGroups <em>Equipment Groups</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getEquipmentResources <em>Equipment Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getEquipmentMetricRefs <em>Equipment Metric Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getEquipmentRelationshipRefs <em>Equipment Relationship Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getCapacityExpressionRef <em>Capacity Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getUtilizationExpressionRef <em>Utilization Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getToleranceRefs <em>Tolerance Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getProtocolRefs <em>Protocol Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getParameterRefs <em>Parameter Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getAllEquipmentResources <em>All Equipment Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getAllEquipments <em>All Equipments</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getCount <em>Count</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getEquipmentCode <em>Equipment Code</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getEquipmentName <em>Equipment Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getRedundancy <em>Redundancy</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EquipmentImpl extends CDOObjectImpl implements Equipment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquipmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.EQUIPMENT;
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
	public Lifecycle getLifecycle() {
		return (Lifecycle)eGet(LibraryPackage.Literals.EQUIPMENT__LIFECYCLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLifecycle(Lifecycle newLifecycle) {
		eSet(LibraryPackage.Literals.EQUIPMENT__LIFECYCLE, newLifecycle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<DiagramInfo> getDiagrams() {
		return (EList<DiagramInfo>)eGet(LibraryPackage.Literals.EQUIPMENT__DIAGRAMS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Equipment> getEquipments() {
		return (EList<Equipment>)eGet(LibraryPackage.Literals.EQUIPMENT__EQUIPMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<EquipmentGroup> getEquipmentGroups() {
		return (EList<EquipmentGroup>)eGet(LibraryPackage.Literals.EQUIPMENT__EQUIPMENT_GROUPS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NetXResource> getEquipmentResources() {
		return (EList<NetXResource>)eGet(LibraryPackage.Literals.EQUIPMENT__EQUIPMENT_RESOURCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Metric> getEquipmentMetricRefs() {
		return (EList<Metric>)eGet(LibraryPackage.Literals.EQUIPMENT__EQUIPMENT_METRIC_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<EquipmentRelationship> getEquipmentRelationshipRefs() {
		return (EList<EquipmentRelationship>)eGet(LibraryPackage.Literals.EQUIPMENT__EQUIPMENT_RELATIONSHIP_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getCapacityExpressionRef() {
		return (Expression)eGet(LibraryPackage.Literals.EQUIPMENT__CAPACITY_EXPRESSION_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacityExpressionRef(Expression newCapacityExpressionRef) {
		eSet(LibraryPackage.Literals.EQUIPMENT__CAPACITY_EXPRESSION_REF, newCapacityExpressionRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getUtilizationExpressionRef() {
		return (Expression)eGet(LibraryPackage.Literals.EQUIPMENT__UTILIZATION_EXPRESSION_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilizationExpressionRef(Expression newUtilizationExpressionRef) {
		eSet(LibraryPackage.Literals.EQUIPMENT__UTILIZATION_EXPRESSION_REF, newUtilizationExpressionRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Tolerance> getToleranceRefs() {
		return (EList<Tolerance>)eGet(LibraryPackage.Literals.EQUIPMENT__TOLERANCE_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Protocol> getProtocolRefs() {
		return (EList<Protocol>)eGet(LibraryPackage.Literals.EQUIPMENT__PROTOCOL_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Parameter> getParameterRefs() {
		return (EList<Parameter>)eGet(LibraryPackage.Literals.EQUIPMENT__PARAMETER_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NetXResource> getAllEquipmentResources() {
		return (EList<NetXResource>)eGet(LibraryPackage.Literals.EQUIPMENT__ALL_EQUIPMENT_RESOURCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Equipment> getAllEquipments() {
		return (EList<Equipment>)eGet(LibraryPackage.Literals.EQUIPMENT__ALL_EQUIPMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiImage getIcons() {
		return (MultiImage)eGet(LibraryPackage.Literals.EQUIPMENT__ICONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcons(MultiImage newIcons) {
		eSet(LibraryPackage.Literals.EQUIPMENT__ICONS, newIcons);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCount() {
		return (Integer)eGet(LibraryPackage.Literals.EQUIPMENT__COUNT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCount(int newCount) {
		eSet(LibraryPackage.Literals.EQUIPMENT__COUNT, newCount);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCount() {
		eUnset(LibraryPackage.Literals.EQUIPMENT__COUNT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCount() {
		return eIsSet(LibraryPackage.Literals.EQUIPMENT__COUNT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(LibraryPackage.Literals.EQUIPMENT__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(LibraryPackage.Literals.EQUIPMENT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEquipmentCode() {
		return (String)eGet(LibraryPackage.Literals.EQUIPMENT__EQUIPMENT_CODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquipmentCode(String newEquipmentCode) {
		eSet(LibraryPackage.Literals.EQUIPMENT__EQUIPMENT_CODE, newEquipmentCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEquipmentName() {
		return (String)eGet(LibraryPackage.Literals.EQUIPMENT__EQUIPMENT_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquipmentName(String newEquipmentName) {
		eSet(LibraryPackage.Literals.EQUIPMENT__EQUIPMENT_NAME, newEquipmentName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPosition() {
		return (String)eGet(LibraryPackage.Literals.EQUIPMENT__POSITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(String newPosition) {
		eSet(LibraryPackage.Literals.EQUIPMENT__POSITION, newPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedundancyType getRedundancy() {
		return (RedundancyType)eGet(LibraryPackage.Literals.EQUIPMENT__REDUNDANCY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRedundancy(RedundancyType newRedundancy) {
		eSet(LibraryPackage.Literals.EQUIPMENT__REDUNDANCY, newRedundancy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRedundancy() {
		eUnset(LibraryPackage.Literals.EQUIPMENT__REDUNDANCY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRedundancy() {
		return eIsSet(LibraryPackage.Literals.EQUIPMENT__REDUNDANCY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateType getState() {
		return (StateType)eGet(LibraryPackage.Literals.EQUIPMENT__STATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(StateType newState) {
		eSet(LibraryPackage.Literals.EQUIPMENT__STATE, newState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetState() {
		eUnset(LibraryPackage.Literals.EQUIPMENT__STATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetState() {
		return eIsSet(LibraryPackage.Literals.EQUIPMENT__STATE);
	}

} //EquipmentImpl
