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
package com.netxforge.netxstudio.operators.impl;

import com.netxforge.netxstudio.generics.DiagramInfo;
import com.netxforge.netxstudio.generics.Person;

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.metrics.MetricSource;

import com.netxforge.netxstudio.operators.EquipmentRelationship;
import com.netxforge.netxstudio.operators.FunctionRelationship;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;

import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;

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
 * An implementation of the model object '<em><b>Network</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.NetworkImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.NetworkImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.NetworkImpl#getNetworks <em>Networks</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.NetworkImpl#getFunctionRelationships <em>Function Relationships</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.NetworkImpl#getEquipmentRelationships <em>Equipment Relationships</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.NetworkImpl#getMetricSources <em>Metric Sources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.NetworkImpl#getCreatedByRef <em>Created By Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.NetworkImpl#getCreatedDate <em>Created Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.NetworkImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.NetworkImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NetworkImpl extends BaseImpl implements Network {
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
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> nodes;

	/**
	 * The cached value of the '{@link #getNetworks() <em>Networks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetworks()
	 * @generated
	 * @ordered
	 */
	protected EList<Network> networks;

	/**
	 * The cached value of the '{@link #getFunctionRelationships() <em>Function Relationships</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionRelationships()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionRelationship> functionRelationships;

	/**
	 * The cached value of the '{@link #getEquipmentRelationships() <em>Equipment Relationships</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentRelationships()
	 * @generated
	 * @ordered
	 */
	protected EList<EquipmentRelationship> equipmentRelationships;

	/**
	 * The cached value of the '{@link #getMetricSources() <em>Metric Sources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricSources()
	 * @generated
	 * @ordered
	 */
	protected EList<MetricSource> metricSources;

	/**
	 * The cached value of the '{@link #getCreatedByRef() <em>Created By Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatedByRef()
	 * @generated
	 * @ordered
	 */
	protected Person createdByRef;

	/**
	 * The default value of the '{@link #getCreatedDate() <em>Created Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatedDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar CREATED_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreatedDate() <em>Created Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatedDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar createdDate = CREATED_DATE_EDEFAULT;

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
	protected static final String NAME_EDEFAULT = "name";

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
	 * This is true if the Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean nameESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NetworkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorsPackage.Literals.NETWORK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiagramInfo> getDiagrams() {
		if (diagrams == null) {
			diagrams = new EObjectContainmentEList<DiagramInfo>(DiagramInfo.class, this, OperatorsPackage.NETWORK__DIAGRAMS);
		}
		return diagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Node> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<Node>(Node.class, this, OperatorsPackage.NETWORK__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Network> getNetworks() {
		if (networks == null) {
			networks = new EObjectContainmentEList<Network>(Network.class, this, OperatorsPackage.NETWORK__NETWORKS);
		}
		return networks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionRelationship> getFunctionRelationships() {
		if (functionRelationships == null) {
			functionRelationships = new EObjectContainmentEList<FunctionRelationship>(FunctionRelationship.class, this, OperatorsPackage.NETWORK__FUNCTION_RELATIONSHIPS);
		}
		return functionRelationships;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EquipmentRelationship> getEquipmentRelationships() {
		if (equipmentRelationships == null) {
			equipmentRelationships = new EObjectContainmentEList<EquipmentRelationship>(EquipmentRelationship.class, this, OperatorsPackage.NETWORK__EQUIPMENT_RELATIONSHIPS);
		}
		return equipmentRelationships;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MetricSource> getMetricSources() {
		if (metricSources == null) {
			metricSources = new EObjectContainmentEList<MetricSource>(MetricSource.class, this, OperatorsPackage.NETWORK__METRIC_SOURCES);
		}
		return metricSources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person getCreatedByRef() {
		if (createdByRef != null && createdByRef.eIsProxy()) {
			InternalEObject oldCreatedByRef = (InternalEObject)createdByRef;
			createdByRef = (Person)eResolveProxy(oldCreatedByRef);
			if (createdByRef != oldCreatedByRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorsPackage.NETWORK__CREATED_BY_REF, oldCreatedByRef, createdByRef));
			}
		}
		return createdByRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person basicGetCreatedByRef() {
		return createdByRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatedByRef(Person newCreatedByRef) {
		Person oldCreatedByRef = createdByRef;
		createdByRef = newCreatedByRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.NETWORK__CREATED_BY_REF, oldCreatedByRef, createdByRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getCreatedDate() {
		return createdDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatedDate(XMLGregorianCalendar newCreatedDate) {
		XMLGregorianCalendar oldCreatedDate = createdDate;
		createdDate = newCreatedDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.NETWORK__CREATED_DATE, oldCreatedDate, createdDate));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.NETWORK__DESCRIPTION, oldDescription, description));
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
		boolean oldNameESet = nameESet;
		nameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.NETWORK__NAME, oldName, name, !oldNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetName() {
		String oldName = name;
		boolean oldNameESet = nameESet;
		name = NAME_EDEFAULT;
		nameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OperatorsPackage.NETWORK__NAME, oldName, NAME_EDEFAULT, oldNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName() {
		return nameESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperatorsPackage.NETWORK__DIAGRAMS:
				return ((InternalEList<?>)getDiagrams()).basicRemove(otherEnd, msgs);
			case OperatorsPackage.NETWORK__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case OperatorsPackage.NETWORK__NETWORKS:
				return ((InternalEList<?>)getNetworks()).basicRemove(otherEnd, msgs);
			case OperatorsPackage.NETWORK__FUNCTION_RELATIONSHIPS:
				return ((InternalEList<?>)getFunctionRelationships()).basicRemove(otherEnd, msgs);
			case OperatorsPackage.NETWORK__EQUIPMENT_RELATIONSHIPS:
				return ((InternalEList<?>)getEquipmentRelationships()).basicRemove(otherEnd, msgs);
			case OperatorsPackage.NETWORK__METRIC_SOURCES:
				return ((InternalEList<?>)getMetricSources()).basicRemove(otherEnd, msgs);
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
			case OperatorsPackage.NETWORK__DIAGRAMS:
				return getDiagrams();
			case OperatorsPackage.NETWORK__NODES:
				return getNodes();
			case OperatorsPackage.NETWORK__NETWORKS:
				return getNetworks();
			case OperatorsPackage.NETWORK__FUNCTION_RELATIONSHIPS:
				return getFunctionRelationships();
			case OperatorsPackage.NETWORK__EQUIPMENT_RELATIONSHIPS:
				return getEquipmentRelationships();
			case OperatorsPackage.NETWORK__METRIC_SOURCES:
				return getMetricSources();
			case OperatorsPackage.NETWORK__CREATED_BY_REF:
				if (resolve) return getCreatedByRef();
				return basicGetCreatedByRef();
			case OperatorsPackage.NETWORK__CREATED_DATE:
				return getCreatedDate();
			case OperatorsPackage.NETWORK__DESCRIPTION:
				return getDescription();
			case OperatorsPackage.NETWORK__NAME:
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
			case OperatorsPackage.NETWORK__DIAGRAMS:
				getDiagrams().clear();
				getDiagrams().addAll((Collection<? extends DiagramInfo>)newValue);
				return;
			case OperatorsPackage.NETWORK__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case OperatorsPackage.NETWORK__NETWORKS:
				getNetworks().clear();
				getNetworks().addAll((Collection<? extends Network>)newValue);
				return;
			case OperatorsPackage.NETWORK__FUNCTION_RELATIONSHIPS:
				getFunctionRelationships().clear();
				getFunctionRelationships().addAll((Collection<? extends FunctionRelationship>)newValue);
				return;
			case OperatorsPackage.NETWORK__EQUIPMENT_RELATIONSHIPS:
				getEquipmentRelationships().clear();
				getEquipmentRelationships().addAll((Collection<? extends EquipmentRelationship>)newValue);
				return;
			case OperatorsPackage.NETWORK__METRIC_SOURCES:
				getMetricSources().clear();
				getMetricSources().addAll((Collection<? extends MetricSource>)newValue);
				return;
			case OperatorsPackage.NETWORK__CREATED_BY_REF:
				setCreatedByRef((Person)newValue);
				return;
			case OperatorsPackage.NETWORK__CREATED_DATE:
				setCreatedDate((XMLGregorianCalendar)newValue);
				return;
			case OperatorsPackage.NETWORK__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case OperatorsPackage.NETWORK__NAME:
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
			case OperatorsPackage.NETWORK__DIAGRAMS:
				getDiagrams().clear();
				return;
			case OperatorsPackage.NETWORK__NODES:
				getNodes().clear();
				return;
			case OperatorsPackage.NETWORK__NETWORKS:
				getNetworks().clear();
				return;
			case OperatorsPackage.NETWORK__FUNCTION_RELATIONSHIPS:
				getFunctionRelationships().clear();
				return;
			case OperatorsPackage.NETWORK__EQUIPMENT_RELATIONSHIPS:
				getEquipmentRelationships().clear();
				return;
			case OperatorsPackage.NETWORK__METRIC_SOURCES:
				getMetricSources().clear();
				return;
			case OperatorsPackage.NETWORK__CREATED_BY_REF:
				setCreatedByRef((Person)null);
				return;
			case OperatorsPackage.NETWORK__CREATED_DATE:
				setCreatedDate(CREATED_DATE_EDEFAULT);
				return;
			case OperatorsPackage.NETWORK__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case OperatorsPackage.NETWORK__NAME:
				unsetName();
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
			case OperatorsPackage.NETWORK__DIAGRAMS:
				return diagrams != null && !diagrams.isEmpty();
			case OperatorsPackage.NETWORK__NODES:
				return nodes != null && !nodes.isEmpty();
			case OperatorsPackage.NETWORK__NETWORKS:
				return networks != null && !networks.isEmpty();
			case OperatorsPackage.NETWORK__FUNCTION_RELATIONSHIPS:
				return functionRelationships != null && !functionRelationships.isEmpty();
			case OperatorsPackage.NETWORK__EQUIPMENT_RELATIONSHIPS:
				return equipmentRelationships != null && !equipmentRelationships.isEmpty();
			case OperatorsPackage.NETWORK__METRIC_SOURCES:
				return metricSources != null && !metricSources.isEmpty();
			case OperatorsPackage.NETWORK__CREATED_BY_REF:
				return createdByRef != null;
			case OperatorsPackage.NETWORK__CREATED_DATE:
				return CREATED_DATE_EDEFAULT == null ? createdDate != null : !CREATED_DATE_EDEFAULT.equals(createdDate);
			case OperatorsPackage.NETWORK__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case OperatorsPackage.NETWORK__NAME:
				return isSetName();
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
		result.append(" (createdDate: ");
		result.append(createdDate);
		result.append(", description: ");
		result.append(description);
		result.append(", name: ");
		if (nameESet) result.append(name); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //NetworkImpl
