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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

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
 *   <li>{@link com.netxforge.netxstudio.library.impl.EquipmentImpl#getEquipmentExpressionRefs <em>Equipment Expression Refs</em>}</li>
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
public class EquipmentImpl extends EObjectImpl implements Equipment {
	/**
	 * The cached value of the '{@link #getLifecycle() <em>Lifecycle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLifecycle()
	 * @generated
	 * @ordered
	 */
	protected Lifecycle lifecycle;

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
	 * The cached value of the '{@link #getEquipments() <em>Equipments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipments()
	 * @generated
	 * @ordered
	 */
	protected EList<Equipment> equipments;

	/**
	 * The cached value of the '{@link #getEquipmentGroups() <em>Equipment Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<EquipmentGroup> equipmentGroups;

	/**
	 * The cached value of the '{@link #getEquipmentResources() <em>Equipment Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentResources()
	 * @generated
	 * @ordered
	 */
	protected EList<NetXResource> equipmentResources;

	/**
	 * The cached value of the '{@link #getEquipmentMetricRefs() <em>Equipment Metric Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentMetricRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric> equipmentMetricRefs;

	/**
	 * The cached value of the '{@link #getEquipmentRelationshipRefs() <em>Equipment Relationship Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentRelationshipRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<EquipmentRelationship> equipmentRelationshipRefs;

	/**
	 * The cached value of the '{@link #getEquipmentExpressionRefs() <em>Equipment Expression Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentExpressionRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> equipmentExpressionRefs;

	/**
	 * The cached value of the '{@link #getToleranceRefs() <em>Tolerance Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToleranceRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Tolerance> toleranceRefs;

	/**
	 * The cached value of the '{@link #getProtocolRefs() <em>Protocol Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocolRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Protocol> protocolRefs;

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
	protected EStructuralFeature.Internal.SettingDelegate ALL_EQUIPMENT_RESOURCES__ESETTING_DELEGATE = ((EStructuralFeature.Internal)LibraryPackage.Literals.EQUIPMENT__ALL_EQUIPMENT_RESOURCES).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getAllEquipments() <em>All Equipments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllEquipments()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate ALL_EQUIPMENTS__ESETTING_DELEGATE = ((EStructuralFeature.Internal)LibraryPackage.Literals.EQUIPMENT__ALL_EQUIPMENTS).getSettingDelegate();

	/**
	 * The cached value of the '{@link #getIcons() <em>Icons</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcons()
	 * @generated
	 * @ordered
	 */
	protected MultiImage icons;

	/**
	 * The cached setting delegate for the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate COUNT__ESETTING_DELEGATE = ((EStructuralFeature.Internal)LibraryPackage.Literals.EQUIPMENT__COUNT).getSettingDelegate();

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
	 * The default value of the '{@link #getEquipmentCode() <em>Equipment Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentCode()
	 * @generated
	 * @ordered
	 */
	protected static final String EQUIPMENT_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEquipmentCode() <em>Equipment Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentCode()
	 * @generated
	 * @ordered
	 */
	protected String equipmentCode = EQUIPMENT_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEquipmentName() <em>Equipment Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentName()
	 * @generated
	 * @ordered
	 */
	protected static final String EQUIPMENT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEquipmentName() <em>Equipment Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentName()
	 * @generated
	 * @ordered
	 */
	protected String equipmentName = EQUIPMENT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected static final String POSITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected String position = POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRedundancy() <em>Redundancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedundancy()
	 * @generated
	 * @ordered
	 */
	protected static final RedundancyType REDUNDANCY_EDEFAULT = RedundancyType.N;

	/**
	 * The cached value of the '{@link #getRedundancy() <em>Redundancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedundancy()
	 * @generated
	 * @ordered
	 */
	protected RedundancyType redundancy = REDUNDANCY_EDEFAULT;

	/**
	 * This is true if the Redundancy attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean redundancyESet;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final StateType STATE_EDEFAULT = StateType.ACTIVE;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected StateType state = STATE_EDEFAULT;

	/**
	 * This is true if the State attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean stateESet;

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
	public Lifecycle getLifecycle() {
		return lifecycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLifecycle(Lifecycle newLifecycle, NotificationChain msgs) {
		Lifecycle oldLifecycle = lifecycle;
		lifecycle = newLifecycle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LibraryPackage.EQUIPMENT__LIFECYCLE, oldLifecycle, newLifecycle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLifecycle(Lifecycle newLifecycle) {
		if (newLifecycle != lifecycle) {
			NotificationChain msgs = null;
			if (lifecycle != null)
				msgs = ((InternalEObject)lifecycle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.EQUIPMENT__LIFECYCLE, null, msgs);
			if (newLifecycle != null)
				msgs = ((InternalEObject)newLifecycle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.EQUIPMENT__LIFECYCLE, null, msgs);
			msgs = basicSetLifecycle(newLifecycle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EQUIPMENT__LIFECYCLE, newLifecycle, newLifecycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiagramInfo> getDiagrams() {
		if (diagrams == null) {
			diagrams = new EObjectContainmentEList<DiagramInfo>(DiagramInfo.class, this, LibraryPackage.EQUIPMENT__DIAGRAMS);
		}
		return diagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Equipment> getEquipments() {
		if (equipments == null) {
			equipments = new EObjectContainmentEList<Equipment>(Equipment.class, this, LibraryPackage.EQUIPMENT__EQUIPMENTS);
		}
		return equipments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EquipmentGroup> getEquipmentGroups() {
		if (equipmentGroups == null) {
			equipmentGroups = new EObjectContainmentEList<EquipmentGroup>(EquipmentGroup.class, this, LibraryPackage.EQUIPMENT__EQUIPMENT_GROUPS);
		}
		return equipmentGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NetXResource> getEquipmentResources() {
		if (equipmentResources == null) {
			equipmentResources = new EObjectContainmentEList<NetXResource>(NetXResource.class, this, LibraryPackage.EQUIPMENT__EQUIPMENT_RESOURCES);
		}
		return equipmentResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric> getEquipmentMetricRefs() {
		if (equipmentMetricRefs == null) {
			equipmentMetricRefs = new EObjectResolvingEList<Metric>(Metric.class, this, LibraryPackage.EQUIPMENT__EQUIPMENT_METRIC_REFS);
		}
		return equipmentMetricRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EquipmentRelationship> getEquipmentRelationshipRefs() {
		if (equipmentRelationshipRefs == null) {
			equipmentRelationshipRefs = new EObjectResolvingEList<EquipmentRelationship>(EquipmentRelationship.class, this, LibraryPackage.EQUIPMENT__EQUIPMENT_RELATIONSHIP_REFS);
		}
		return equipmentRelationshipRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getEquipmentExpressionRefs() {
		if (equipmentExpressionRefs == null) {
			equipmentExpressionRefs = new EObjectWithInverseResolvingEList.ManyInverse<Expression>(Expression.class, this, LibraryPackage.EQUIPMENT__EQUIPMENT_EXPRESSION_REFS, LibraryPackage.EXPRESSION__EQUIPMENT_REFS);
		}
		return equipmentExpressionRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tolerance> getToleranceRefs() {
		if (toleranceRefs == null) {
			toleranceRefs = new EObjectResolvingEList<Tolerance>(Tolerance.class, this, LibraryPackage.EQUIPMENT__TOLERANCE_REFS);
		}
		return toleranceRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Protocol> getProtocolRefs() {
		if (protocolRefs == null) {
			protocolRefs = new EObjectResolvingEList<Protocol>(Protocol.class, this, LibraryPackage.EQUIPMENT__PROTOCOL_REFS);
		}
		return protocolRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameterRefs() {
		if (parameterRefs == null) {
			parameterRefs = new EObjectResolvingEList<Parameter>(Parameter.class, this, LibraryPackage.EQUIPMENT__PARAMETER_REFS);
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
	public MultiImage getIcons() {
		return icons;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIcons(MultiImage newIcons, NotificationChain msgs) {
		MultiImage oldIcons = icons;
		icons = newIcons;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LibraryPackage.EQUIPMENT__ICONS, oldIcons, newIcons);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcons(MultiImage newIcons) {
		if (newIcons != icons) {
			NotificationChain msgs = null;
			if (icons != null)
				msgs = ((InternalEObject)icons).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.EQUIPMENT__ICONS, null, msgs);
			if (newIcons != null)
				msgs = ((InternalEObject)newIcons).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.EQUIPMENT__ICONS, null, msgs);
			msgs = basicSetIcons(newIcons, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EQUIPMENT__ICONS, newIcons, newIcons));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EQUIPMENT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEquipmentCode() {
		return equipmentCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquipmentCode(String newEquipmentCode) {
		String oldEquipmentCode = equipmentCode;
		equipmentCode = newEquipmentCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EQUIPMENT__EQUIPMENT_CODE, oldEquipmentCode, equipmentCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEquipmentName() {
		return equipmentName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquipmentName(String newEquipmentName) {
		String oldEquipmentName = equipmentName;
		equipmentName = newEquipmentName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EQUIPMENT__EQUIPMENT_NAME, oldEquipmentName, equipmentName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(String newPosition) {
		String oldPosition = position;
		position = newPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EQUIPMENT__POSITION, oldPosition, position));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedundancyType getRedundancy() {
		return redundancy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRedundancy(RedundancyType newRedundancy) {
		RedundancyType oldRedundancy = redundancy;
		redundancy = newRedundancy == null ? REDUNDANCY_EDEFAULT : newRedundancy;
		boolean oldRedundancyESet = redundancyESet;
		redundancyESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EQUIPMENT__REDUNDANCY, oldRedundancy, redundancy, !oldRedundancyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRedundancy() {
		RedundancyType oldRedundancy = redundancy;
		boolean oldRedundancyESet = redundancyESet;
		redundancy = REDUNDANCY_EDEFAULT;
		redundancyESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LibraryPackage.EQUIPMENT__REDUNDANCY, oldRedundancy, REDUNDANCY_EDEFAULT, oldRedundancyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRedundancy() {
		return redundancyESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateType getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(StateType newState) {
		StateType oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		boolean oldStateESet = stateESet;
		stateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EQUIPMENT__STATE, oldState, state, !oldStateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetState() {
		StateType oldState = state;
		boolean oldStateESet = stateESet;
		state = STATE_EDEFAULT;
		stateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LibraryPackage.EQUIPMENT__STATE, oldState, STATE_EDEFAULT, oldStateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetState() {
		return stateESet;
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
			case LibraryPackage.EQUIPMENT__EQUIPMENT_EXPRESSION_REFS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEquipmentExpressionRefs()).basicAdd(otherEnd, msgs);
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
			case LibraryPackage.EQUIPMENT__LIFECYCLE:
				return basicSetLifecycle(null, msgs);
			case LibraryPackage.EQUIPMENT__DIAGRAMS:
				return ((InternalEList<?>)getDiagrams()).basicRemove(otherEnd, msgs);
			case LibraryPackage.EQUIPMENT__EQUIPMENTS:
				return ((InternalEList<?>)getEquipments()).basicRemove(otherEnd, msgs);
			case LibraryPackage.EQUIPMENT__EQUIPMENT_GROUPS:
				return ((InternalEList<?>)getEquipmentGroups()).basicRemove(otherEnd, msgs);
			case LibraryPackage.EQUIPMENT__EQUIPMENT_RESOURCES:
				return ((InternalEList<?>)getEquipmentResources()).basicRemove(otherEnd, msgs);
			case LibraryPackage.EQUIPMENT__EQUIPMENT_EXPRESSION_REFS:
				return ((InternalEList<?>)getEquipmentExpressionRefs()).basicRemove(otherEnd, msgs);
			case LibraryPackage.EQUIPMENT__ICONS:
				return basicSetIcons(null, msgs);
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
			case LibraryPackage.EQUIPMENT__LIFECYCLE:
				return getLifecycle();
			case LibraryPackage.EQUIPMENT__DIAGRAMS:
				return getDiagrams();
			case LibraryPackage.EQUIPMENT__EQUIPMENTS:
				return getEquipments();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_GROUPS:
				return getEquipmentGroups();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_RESOURCES:
				return getEquipmentResources();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_METRIC_REFS:
				return getEquipmentMetricRefs();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_RELATIONSHIP_REFS:
				return getEquipmentRelationshipRefs();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_EXPRESSION_REFS:
				return getEquipmentExpressionRefs();
			case LibraryPackage.EQUIPMENT__TOLERANCE_REFS:
				return getToleranceRefs();
			case LibraryPackage.EQUIPMENT__PROTOCOL_REFS:
				return getProtocolRefs();
			case LibraryPackage.EQUIPMENT__PARAMETER_REFS:
				return getParameterRefs();
			case LibraryPackage.EQUIPMENT__ALL_EQUIPMENT_RESOURCES:
				return getAllEquipmentResources();
			case LibraryPackage.EQUIPMENT__ALL_EQUIPMENTS:
				return getAllEquipments();
			case LibraryPackage.EQUIPMENT__ICONS:
				return getIcons();
			case LibraryPackage.EQUIPMENT__COUNT:
				return getCount();
			case LibraryPackage.EQUIPMENT__DESCRIPTION:
				return getDescription();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_CODE:
				return getEquipmentCode();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_NAME:
				return getEquipmentName();
			case LibraryPackage.EQUIPMENT__POSITION:
				return getPosition();
			case LibraryPackage.EQUIPMENT__REDUNDANCY:
				return getRedundancy();
			case LibraryPackage.EQUIPMENT__STATE:
				return getState();
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
			case LibraryPackage.EQUIPMENT__LIFECYCLE:
				setLifecycle((Lifecycle)newValue);
				return;
			case LibraryPackage.EQUIPMENT__DIAGRAMS:
				getDiagrams().clear();
				getDiagrams().addAll((Collection<? extends DiagramInfo>)newValue);
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENTS:
				getEquipments().clear();
				getEquipments().addAll((Collection<? extends Equipment>)newValue);
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_GROUPS:
				getEquipmentGroups().clear();
				getEquipmentGroups().addAll((Collection<? extends EquipmentGroup>)newValue);
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_RESOURCES:
				getEquipmentResources().clear();
				getEquipmentResources().addAll((Collection<? extends NetXResource>)newValue);
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_METRIC_REFS:
				getEquipmentMetricRefs().clear();
				getEquipmentMetricRefs().addAll((Collection<? extends Metric>)newValue);
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_RELATIONSHIP_REFS:
				getEquipmentRelationshipRefs().clear();
				getEquipmentRelationshipRefs().addAll((Collection<? extends EquipmentRelationship>)newValue);
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_EXPRESSION_REFS:
				getEquipmentExpressionRefs().clear();
				getEquipmentExpressionRefs().addAll((Collection<? extends Expression>)newValue);
				return;
			case LibraryPackage.EQUIPMENT__TOLERANCE_REFS:
				getToleranceRefs().clear();
				getToleranceRefs().addAll((Collection<? extends Tolerance>)newValue);
				return;
			case LibraryPackage.EQUIPMENT__PROTOCOL_REFS:
				getProtocolRefs().clear();
				getProtocolRefs().addAll((Collection<? extends Protocol>)newValue);
				return;
			case LibraryPackage.EQUIPMENT__PARAMETER_REFS:
				getParameterRefs().clear();
				getParameterRefs().addAll((Collection<? extends Parameter>)newValue);
				return;
			case LibraryPackage.EQUIPMENT__ALL_EQUIPMENT_RESOURCES:
				getAllEquipmentResources().clear();
				getAllEquipmentResources().addAll((Collection<? extends NetXResource>)newValue);
				return;
			case LibraryPackage.EQUIPMENT__ALL_EQUIPMENTS:
				getAllEquipments().clear();
				getAllEquipments().addAll((Collection<? extends Equipment>)newValue);
				return;
			case LibraryPackage.EQUIPMENT__ICONS:
				setIcons((MultiImage)newValue);
				return;
			case LibraryPackage.EQUIPMENT__COUNT:
				setCount((Integer)newValue);
				return;
			case LibraryPackage.EQUIPMENT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_CODE:
				setEquipmentCode((String)newValue);
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_NAME:
				setEquipmentName((String)newValue);
				return;
			case LibraryPackage.EQUIPMENT__POSITION:
				setPosition((String)newValue);
				return;
			case LibraryPackage.EQUIPMENT__REDUNDANCY:
				setRedundancy((RedundancyType)newValue);
				return;
			case LibraryPackage.EQUIPMENT__STATE:
				setState((StateType)newValue);
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
			case LibraryPackage.EQUIPMENT__LIFECYCLE:
				setLifecycle((Lifecycle)null);
				return;
			case LibraryPackage.EQUIPMENT__DIAGRAMS:
				getDiagrams().clear();
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENTS:
				getEquipments().clear();
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_GROUPS:
				getEquipmentGroups().clear();
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_RESOURCES:
				getEquipmentResources().clear();
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_METRIC_REFS:
				getEquipmentMetricRefs().clear();
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_RELATIONSHIP_REFS:
				getEquipmentRelationshipRefs().clear();
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_EXPRESSION_REFS:
				getEquipmentExpressionRefs().clear();
				return;
			case LibraryPackage.EQUIPMENT__TOLERANCE_REFS:
				getToleranceRefs().clear();
				return;
			case LibraryPackage.EQUIPMENT__PROTOCOL_REFS:
				getProtocolRefs().clear();
				return;
			case LibraryPackage.EQUIPMENT__PARAMETER_REFS:
				getParameterRefs().clear();
				return;
			case LibraryPackage.EQUIPMENT__ALL_EQUIPMENT_RESOURCES:
				getAllEquipmentResources().clear();
				return;
			case LibraryPackage.EQUIPMENT__ALL_EQUIPMENTS:
				getAllEquipments().clear();
				return;
			case LibraryPackage.EQUIPMENT__ICONS:
				setIcons((MultiImage)null);
				return;
			case LibraryPackage.EQUIPMENT__COUNT:
				unsetCount();
				return;
			case LibraryPackage.EQUIPMENT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_CODE:
				setEquipmentCode(EQUIPMENT_CODE_EDEFAULT);
				return;
			case LibraryPackage.EQUIPMENT__EQUIPMENT_NAME:
				setEquipmentName(EQUIPMENT_NAME_EDEFAULT);
				return;
			case LibraryPackage.EQUIPMENT__POSITION:
				setPosition(POSITION_EDEFAULT);
				return;
			case LibraryPackage.EQUIPMENT__REDUNDANCY:
				unsetRedundancy();
				return;
			case LibraryPackage.EQUIPMENT__STATE:
				unsetState();
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
			case LibraryPackage.EQUIPMENT__LIFECYCLE:
				return lifecycle != null;
			case LibraryPackage.EQUIPMENT__DIAGRAMS:
				return diagrams != null && !diagrams.isEmpty();
			case LibraryPackage.EQUIPMENT__EQUIPMENTS:
				return equipments != null && !equipments.isEmpty();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_GROUPS:
				return equipmentGroups != null && !equipmentGroups.isEmpty();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_RESOURCES:
				return equipmentResources != null && !equipmentResources.isEmpty();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_METRIC_REFS:
				return equipmentMetricRefs != null && !equipmentMetricRefs.isEmpty();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_RELATIONSHIP_REFS:
				return equipmentRelationshipRefs != null && !equipmentRelationshipRefs.isEmpty();
			case LibraryPackage.EQUIPMENT__EQUIPMENT_EXPRESSION_REFS:
				return equipmentExpressionRefs != null && !equipmentExpressionRefs.isEmpty();
			case LibraryPackage.EQUIPMENT__TOLERANCE_REFS:
				return toleranceRefs != null && !toleranceRefs.isEmpty();
			case LibraryPackage.EQUIPMENT__PROTOCOL_REFS:
				return protocolRefs != null && !protocolRefs.isEmpty();
			case LibraryPackage.EQUIPMENT__PARAMETER_REFS:
				return parameterRefs != null && !parameterRefs.isEmpty();
			case LibraryPackage.EQUIPMENT__ALL_EQUIPMENT_RESOURCES:
				return ALL_EQUIPMENT_RESOURCES__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case LibraryPackage.EQUIPMENT__ALL_EQUIPMENTS:
				return ALL_EQUIPMENTS__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case LibraryPackage.EQUIPMENT__ICONS:
				return icons != null;
			case LibraryPackage.EQUIPMENT__COUNT:
				return isSetCount();
			case LibraryPackage.EQUIPMENT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case LibraryPackage.EQUIPMENT__EQUIPMENT_CODE:
				return EQUIPMENT_CODE_EDEFAULT == null ? equipmentCode != null : !EQUIPMENT_CODE_EDEFAULT.equals(equipmentCode);
			case LibraryPackage.EQUIPMENT__EQUIPMENT_NAME:
				return EQUIPMENT_NAME_EDEFAULT == null ? equipmentName != null : !EQUIPMENT_NAME_EDEFAULT.equals(equipmentName);
			case LibraryPackage.EQUIPMENT__POSITION:
				return POSITION_EDEFAULT == null ? position != null : !POSITION_EDEFAULT.equals(position);
			case LibraryPackage.EQUIPMENT__REDUNDANCY:
				return isSetRedundancy();
			case LibraryPackage.EQUIPMENT__STATE:
				return isSetState();
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
		result.append(", equipmentCode: ");
		result.append(equipmentCode);
		result.append(", equipmentName: ");
		result.append(equipmentName);
		result.append(", position: ");
		result.append(position);
		result.append(", redundancy: ");
		if (redundancyESet) result.append(redundancy); else result.append("<unset>");
		result.append(", state: ");
		if (stateESet) result.append(state); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //EquipmentImpl
