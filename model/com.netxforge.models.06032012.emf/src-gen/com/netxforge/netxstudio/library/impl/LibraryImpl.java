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

import com.netxforge.netxstudio.generics.Meta;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.Parameter;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.library.Unit;

import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricSource;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getNodeTypes <em>Node Types</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getEquipments <em>Equipments</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getMetricSources <em>Metric Sources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getTolerances <em>Tolerances</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getUnits <em>Units</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibraryImpl extends MinimalEObjectImpl.Container implements Library {
	/**
	 * The cached value of the '{@link #getFunctions() <em>Functions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> functions;

	/**
	 * The cached value of the '{@link #getNodeTypes() <em>Node Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeType> nodeTypes;

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
	 * The cached value of the '{@link #getMetrics() <em>Metrics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetrics()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric> metrics;

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
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The cached value of the '{@link #getProtocols() <em>Protocols</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocols()
	 * @generated
	 * @ordered
	 */
	protected EList<String> protocols;

	/**
	 * The cached value of the '{@link #getTolerances() <em>Tolerances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTolerances()
	 * @generated
	 * @ordered
	 */
	protected EList<Tolerance> tolerances;

	/**
	 * The cached value of the '{@link #getExpressions() <em>Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> expressions;

	/**
	 * The cached value of the '{@link #getUnits() <em>Units</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<Unit> units;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected Meta version;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "Library name";

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
	protected LibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Function> getFunctions() {
		if (functions == null) {
			functions = new EObjectContainmentEList<Function>(Function.class, this, LibraryPackage.LIBRARY__FUNCTIONS);
		}
		return functions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NodeType> getNodeTypes() {
		if (nodeTypes == null) {
			nodeTypes = new EObjectContainmentEList<NodeType>(NodeType.class, this, LibraryPackage.LIBRARY__NODE_TYPES);
		}
		return nodeTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Equipment> getEquipments() {
		if (equipments == null) {
			equipments = new EObjectContainmentEList<Equipment>(Equipment.class, this, LibraryPackage.LIBRARY__EQUIPMENTS);
		}
		return equipments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric> getMetrics() {
		if (metrics == null) {
			metrics = new EObjectContainmentEList<Metric>(Metric.class, this, LibraryPackage.LIBRARY__METRICS);
		}
		return metrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MetricSource> getMetricSources() {
		if (metricSources == null) {
			metricSources = new EObjectContainmentEList<MetricSource>(MetricSource.class, this, LibraryPackage.LIBRARY__METRIC_SOURCES);
		}
		return metricSources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, LibraryPackage.LIBRARY__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getProtocols() {
		if (protocols == null) {
			protocols = new EDataTypeEList<String>(String.class, this, LibraryPackage.LIBRARY__PROTOCOLS);
		}
		return protocols;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tolerance> getTolerances() {
		if (tolerances == null) {
			tolerances = new EObjectContainmentEList<Tolerance>(Tolerance.class, this, LibraryPackage.LIBRARY__TOLERANCES);
		}
		return tolerances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getExpressions() {
		if (expressions == null) {
			expressions = new EObjectContainmentEList<Expression>(Expression.class, this, LibraryPackage.LIBRARY__EXPRESSIONS);
		}
		return expressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Unit> getUnits() {
		if (units == null) {
			units = new EObjectContainmentEList<Unit>(Unit.class, this, LibraryPackage.LIBRARY__UNITS);
		}
		return units;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Meta getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVersion(Meta newVersion, NotificationChain msgs) {
		Meta oldVersion = version;
		version = newVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LibraryPackage.LIBRARY__VERSION, oldVersion, newVersion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(Meta newVersion) {
		if (newVersion != version) {
			NotificationChain msgs = null;
			if (version != null)
				msgs = ((InternalEObject)version).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.LIBRARY__VERSION, null, msgs);
			if (newVersion != null)
				msgs = ((InternalEObject)newVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.LIBRARY__VERSION, null, msgs);
			msgs = basicSetVersion(newVersion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.LIBRARY__VERSION, newVersion, newVersion));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.LIBRARY__NAME, oldName, name, !oldNameESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, LibraryPackage.LIBRARY__NAME, oldName, NAME_EDEFAULT, oldNameESet));
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
			case LibraryPackage.LIBRARY__FUNCTIONS:
				return ((InternalEList<?>)getFunctions()).basicRemove(otherEnd, msgs);
			case LibraryPackage.LIBRARY__NODE_TYPES:
				return ((InternalEList<?>)getNodeTypes()).basicRemove(otherEnd, msgs);
			case LibraryPackage.LIBRARY__EQUIPMENTS:
				return ((InternalEList<?>)getEquipments()).basicRemove(otherEnd, msgs);
			case LibraryPackage.LIBRARY__METRICS:
				return ((InternalEList<?>)getMetrics()).basicRemove(otherEnd, msgs);
			case LibraryPackage.LIBRARY__METRIC_SOURCES:
				return ((InternalEList<?>)getMetricSources()).basicRemove(otherEnd, msgs);
			case LibraryPackage.LIBRARY__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case LibraryPackage.LIBRARY__TOLERANCES:
				return ((InternalEList<?>)getTolerances()).basicRemove(otherEnd, msgs);
			case LibraryPackage.LIBRARY__EXPRESSIONS:
				return ((InternalEList<?>)getExpressions()).basicRemove(otherEnd, msgs);
			case LibraryPackage.LIBRARY__UNITS:
				return ((InternalEList<?>)getUnits()).basicRemove(otherEnd, msgs);
			case LibraryPackage.LIBRARY__VERSION:
				return basicSetVersion(null, msgs);
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
			case LibraryPackage.LIBRARY__FUNCTIONS:
				return getFunctions();
			case LibraryPackage.LIBRARY__NODE_TYPES:
				return getNodeTypes();
			case LibraryPackage.LIBRARY__EQUIPMENTS:
				return getEquipments();
			case LibraryPackage.LIBRARY__METRICS:
				return getMetrics();
			case LibraryPackage.LIBRARY__METRIC_SOURCES:
				return getMetricSources();
			case LibraryPackage.LIBRARY__PARAMETERS:
				return getParameters();
			case LibraryPackage.LIBRARY__PROTOCOLS:
				return getProtocols();
			case LibraryPackage.LIBRARY__TOLERANCES:
				return getTolerances();
			case LibraryPackage.LIBRARY__EXPRESSIONS:
				return getExpressions();
			case LibraryPackage.LIBRARY__UNITS:
				return getUnits();
			case LibraryPackage.LIBRARY__VERSION:
				return getVersion();
			case LibraryPackage.LIBRARY__NAME:
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
			case LibraryPackage.LIBRARY__FUNCTIONS:
				getFunctions().clear();
				getFunctions().addAll((Collection<? extends Function>)newValue);
				return;
			case LibraryPackage.LIBRARY__NODE_TYPES:
				getNodeTypes().clear();
				getNodeTypes().addAll((Collection<? extends NodeType>)newValue);
				return;
			case LibraryPackage.LIBRARY__EQUIPMENTS:
				getEquipments().clear();
				getEquipments().addAll((Collection<? extends Equipment>)newValue);
				return;
			case LibraryPackage.LIBRARY__METRICS:
				getMetrics().clear();
				getMetrics().addAll((Collection<? extends Metric>)newValue);
				return;
			case LibraryPackage.LIBRARY__METRIC_SOURCES:
				getMetricSources().clear();
				getMetricSources().addAll((Collection<? extends MetricSource>)newValue);
				return;
			case LibraryPackage.LIBRARY__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case LibraryPackage.LIBRARY__PROTOCOLS:
				getProtocols().clear();
				getProtocols().addAll((Collection<? extends String>)newValue);
				return;
			case LibraryPackage.LIBRARY__TOLERANCES:
				getTolerances().clear();
				getTolerances().addAll((Collection<? extends Tolerance>)newValue);
				return;
			case LibraryPackage.LIBRARY__EXPRESSIONS:
				getExpressions().clear();
				getExpressions().addAll((Collection<? extends Expression>)newValue);
				return;
			case LibraryPackage.LIBRARY__UNITS:
				getUnits().clear();
				getUnits().addAll((Collection<? extends Unit>)newValue);
				return;
			case LibraryPackage.LIBRARY__VERSION:
				setVersion((Meta)newValue);
				return;
			case LibraryPackage.LIBRARY__NAME:
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
			case LibraryPackage.LIBRARY__FUNCTIONS:
				getFunctions().clear();
				return;
			case LibraryPackage.LIBRARY__NODE_TYPES:
				getNodeTypes().clear();
				return;
			case LibraryPackage.LIBRARY__EQUIPMENTS:
				getEquipments().clear();
				return;
			case LibraryPackage.LIBRARY__METRICS:
				getMetrics().clear();
				return;
			case LibraryPackage.LIBRARY__METRIC_SOURCES:
				getMetricSources().clear();
				return;
			case LibraryPackage.LIBRARY__PARAMETERS:
				getParameters().clear();
				return;
			case LibraryPackage.LIBRARY__PROTOCOLS:
				getProtocols().clear();
				return;
			case LibraryPackage.LIBRARY__TOLERANCES:
				getTolerances().clear();
				return;
			case LibraryPackage.LIBRARY__EXPRESSIONS:
				getExpressions().clear();
				return;
			case LibraryPackage.LIBRARY__UNITS:
				getUnits().clear();
				return;
			case LibraryPackage.LIBRARY__VERSION:
				setVersion((Meta)null);
				return;
			case LibraryPackage.LIBRARY__NAME:
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
			case LibraryPackage.LIBRARY__FUNCTIONS:
				return functions != null && !functions.isEmpty();
			case LibraryPackage.LIBRARY__NODE_TYPES:
				return nodeTypes != null && !nodeTypes.isEmpty();
			case LibraryPackage.LIBRARY__EQUIPMENTS:
				return equipments != null && !equipments.isEmpty();
			case LibraryPackage.LIBRARY__METRICS:
				return metrics != null && !metrics.isEmpty();
			case LibraryPackage.LIBRARY__METRIC_SOURCES:
				return metricSources != null && !metricSources.isEmpty();
			case LibraryPackage.LIBRARY__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case LibraryPackage.LIBRARY__PROTOCOLS:
				return protocols != null && !protocols.isEmpty();
			case LibraryPackage.LIBRARY__TOLERANCES:
				return tolerances != null && !tolerances.isEmpty();
			case LibraryPackage.LIBRARY__EXPRESSIONS:
				return expressions != null && !expressions.isEmpty();
			case LibraryPackage.LIBRARY__UNITS:
				return units != null && !units.isEmpty();
			case LibraryPackage.LIBRARY__VERSION:
				return version != null;
			case LibraryPackage.LIBRARY__NAME:
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
		result.append(" (protocols: ");
		result.append(protocols);
		result.append(", name: ");
		if (nameESet) result.append(name); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //LibraryImpl
