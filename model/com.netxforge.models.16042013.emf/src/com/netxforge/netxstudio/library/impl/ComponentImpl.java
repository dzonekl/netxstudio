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
import com.netxforge.netxstudio.generics.ExpansionDuration;
import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.generics.MultiImage;

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.Parameter;
import com.netxforge.netxstudio.library.Tolerance;

import com.netxforge.netxstudio.metrics.Metric;

import com.netxforge.netxstudio.protocols.Protocol;

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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getLifecycle <em>Lifecycle</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getResourceRefs <em>Resource Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getMetricRefs <em>Metric Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getCapacityExpressionRef <em>Capacity Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getUtilizationExpressionRef <em>Utilization Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getToleranceRefs <em>Tolerance Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getProtocolRefs <em>Protocol Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getParameterRefs <em>Parameter Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getAllResources <em>All Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentImpl extends BaseImpl implements Component {
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
	 * The cached value of the '{@link #getResourceRefs() <em>Resource Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<NetXResource> resourceRefs;

	/**
	 * The cached value of the '{@link #getMetricRefs() <em>Metric Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric> metricRefs;

	/**
	 * The cached value of the '{@link #getCapacityExpressionRef() <em>Capacity Expression Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacityExpressionRef()
	 * @generated
	 * @ordered
	 */
	protected Expression capacityExpressionRef;

	/**
	 * The cached value of the '{@link #getUtilizationExpressionRef() <em>Utilization Expression Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationExpressionRef()
	 * @generated
	 * @ordered
	 */
	protected Expression utilizationExpressionRef;

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
	 * The cached setting delegate for the '{@link #getAllResources() <em>All Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllResources()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate ALL_RESOURCES__ESETTING_DELEGATE = ((EStructuralFeature.Internal)LibraryPackage.Literals.COMPONENT__ALL_RESOURCES).getSettingDelegate();

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
	 * The cached value of the '{@link #getIcons() <em>Icons</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcons()
	 * @generated
	 * @ordered
	 */
	protected MultiImage icons;

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
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final ExpansionDuration DURATION_EDEFAULT = ExpansionDuration.QUICK;

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected ExpansionDuration duration = DURATION_EDEFAULT;

	/**
	 * This is true if the Duration attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean durationESet;

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
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.COMPONENT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LibraryPackage.COMPONENT__LIFECYCLE, oldLifecycle, newLifecycle);
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
				msgs = ((InternalEObject)lifecycle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.COMPONENT__LIFECYCLE, null, msgs);
			if (newLifecycle != null)
				msgs = ((InternalEObject)newLifecycle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.COMPONENT__LIFECYCLE, null, msgs);
			msgs = basicSetLifecycle(newLifecycle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.COMPONENT__LIFECYCLE, newLifecycle, newLifecycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NetXResource> getResourceRefs() {
		if (resourceRefs == null) {
			resourceRefs = new EObjectWithInverseResolvingEList<NetXResource>(NetXResource.class, this, LibraryPackage.COMPONENT__RESOURCE_REFS, LibraryPackage.NET_XRESOURCE__COMPONENT_REF);
		}
		return resourceRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric> getMetricRefs() {
		if (metricRefs == null) {
			metricRefs = new EObjectResolvingEList<Metric>(Metric.class, this, LibraryPackage.COMPONENT__METRIC_REFS);
		}
		return metricRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getCapacityExpressionRef() {
		if (capacityExpressionRef != null && capacityExpressionRef.eIsProxy()) {
			InternalEObject oldCapacityExpressionRef = (InternalEObject)capacityExpressionRef;
			capacityExpressionRef = (Expression)eResolveProxy(oldCapacityExpressionRef);
			if (capacityExpressionRef != oldCapacityExpressionRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryPackage.COMPONENT__CAPACITY_EXPRESSION_REF, oldCapacityExpressionRef, capacityExpressionRef));
			}
		}
		return capacityExpressionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetCapacityExpressionRef() {
		return capacityExpressionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacityExpressionRef(Expression newCapacityExpressionRef) {
		Expression oldCapacityExpressionRef = capacityExpressionRef;
		capacityExpressionRef = newCapacityExpressionRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.COMPONENT__CAPACITY_EXPRESSION_REF, oldCapacityExpressionRef, capacityExpressionRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getUtilizationExpressionRef() {
		if (utilizationExpressionRef != null && utilizationExpressionRef.eIsProxy()) {
			InternalEObject oldUtilizationExpressionRef = (InternalEObject)utilizationExpressionRef;
			utilizationExpressionRef = (Expression)eResolveProxy(oldUtilizationExpressionRef);
			if (utilizationExpressionRef != oldUtilizationExpressionRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryPackage.COMPONENT__UTILIZATION_EXPRESSION_REF, oldUtilizationExpressionRef, utilizationExpressionRef));
			}
		}
		return utilizationExpressionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetUtilizationExpressionRef() {
		return utilizationExpressionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilizationExpressionRef(Expression newUtilizationExpressionRef) {
		Expression oldUtilizationExpressionRef = utilizationExpressionRef;
		utilizationExpressionRef = newUtilizationExpressionRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.COMPONENT__UTILIZATION_EXPRESSION_REF, oldUtilizationExpressionRef, utilizationExpressionRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tolerance> getToleranceRefs() {
		if (toleranceRefs == null) {
			toleranceRefs = new EObjectResolvingEList<Tolerance>(Tolerance.class, this, LibraryPackage.COMPONENT__TOLERANCE_REFS);
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
			protocolRefs = new EObjectResolvingEList<Protocol>(Protocol.class, this, LibraryPackage.COMPONENT__PROTOCOL_REFS);
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
			parameterRefs = new EObjectResolvingEList<Parameter>(Parameter.class, this, LibraryPackage.COMPONENT__PARAMETER_REFS);
		}
		return parameterRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NetXResource> getAllResources() {
		return (EList<NetXResource>)ALL_RESOURCES__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiagramInfo> getDiagrams() {
		if (diagrams == null) {
			diagrams = new EObjectContainmentEList<DiagramInfo>(DiagramInfo.class, this, LibraryPackage.COMPONENT__DIAGRAMS);
		}
		return diagrams;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LibraryPackage.COMPONENT__ICONS, oldIcons, newIcons);
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
				msgs = ((InternalEObject)icons).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.COMPONENT__ICONS, null, msgs);
			if (newIcons != null)
				msgs = ((InternalEObject)newIcons).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.COMPONENT__ICONS, null, msgs);
			msgs = basicSetIcons(newIcons, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.COMPONENT__ICONS, newIcons, newIcons));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.COMPONENT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionDuration getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(ExpansionDuration newDuration) {
		ExpansionDuration oldDuration = duration;
		duration = newDuration == null ? DURATION_EDEFAULT : newDuration;
		boolean oldDurationESet = durationESet;
		durationESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.COMPONENT__DURATION, oldDuration, duration, !oldDurationESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDuration() {
		ExpansionDuration oldDuration = duration;
		boolean oldDurationESet = durationESet;
		duration = DURATION_EDEFAULT;
		durationESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LibraryPackage.COMPONENT__DURATION, oldDuration, DURATION_EDEFAULT, oldDurationESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDuration() {
		return durationESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.COMPONENT__NAME, oldName, name));
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
			case LibraryPackage.COMPONENT__RESOURCE_REFS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getResourceRefs()).basicAdd(otherEnd, msgs);
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
			case LibraryPackage.COMPONENT__LIFECYCLE:
				return basicSetLifecycle(null, msgs);
			case LibraryPackage.COMPONENT__RESOURCE_REFS:
				return ((InternalEList<?>)getResourceRefs()).basicRemove(otherEnd, msgs);
			case LibraryPackage.COMPONENT__DIAGRAMS:
				return ((InternalEList<?>)getDiagrams()).basicRemove(otherEnd, msgs);
			case LibraryPackage.COMPONENT__ICONS:
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
			case LibraryPackage.COMPONENT__LIFECYCLE:
				return getLifecycle();
			case LibraryPackage.COMPONENT__RESOURCE_REFS:
				return getResourceRefs();
			case LibraryPackage.COMPONENT__METRIC_REFS:
				return getMetricRefs();
			case LibraryPackage.COMPONENT__CAPACITY_EXPRESSION_REF:
				if (resolve) return getCapacityExpressionRef();
				return basicGetCapacityExpressionRef();
			case LibraryPackage.COMPONENT__UTILIZATION_EXPRESSION_REF:
				if (resolve) return getUtilizationExpressionRef();
				return basicGetUtilizationExpressionRef();
			case LibraryPackage.COMPONENT__TOLERANCE_REFS:
				return getToleranceRefs();
			case LibraryPackage.COMPONENT__PROTOCOL_REFS:
				return getProtocolRefs();
			case LibraryPackage.COMPONENT__PARAMETER_REFS:
				return getParameterRefs();
			case LibraryPackage.COMPONENT__ALL_RESOURCES:
				return getAllResources();
			case LibraryPackage.COMPONENT__DIAGRAMS:
				return getDiagrams();
			case LibraryPackage.COMPONENT__ICONS:
				return getIcons();
			case LibraryPackage.COMPONENT__DESCRIPTION:
				return getDescription();
			case LibraryPackage.COMPONENT__DURATION:
				return getDuration();
			case LibraryPackage.COMPONENT__NAME:
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
			case LibraryPackage.COMPONENT__LIFECYCLE:
				setLifecycle((Lifecycle)newValue);
				return;
			case LibraryPackage.COMPONENT__RESOURCE_REFS:
				getResourceRefs().clear();
				getResourceRefs().addAll((Collection<? extends NetXResource>)newValue);
				return;
			case LibraryPackage.COMPONENT__METRIC_REFS:
				getMetricRefs().clear();
				getMetricRefs().addAll((Collection<? extends Metric>)newValue);
				return;
			case LibraryPackage.COMPONENT__CAPACITY_EXPRESSION_REF:
				setCapacityExpressionRef((Expression)newValue);
				return;
			case LibraryPackage.COMPONENT__UTILIZATION_EXPRESSION_REF:
				setUtilizationExpressionRef((Expression)newValue);
				return;
			case LibraryPackage.COMPONENT__TOLERANCE_REFS:
				getToleranceRefs().clear();
				getToleranceRefs().addAll((Collection<? extends Tolerance>)newValue);
				return;
			case LibraryPackage.COMPONENT__PROTOCOL_REFS:
				getProtocolRefs().clear();
				getProtocolRefs().addAll((Collection<? extends Protocol>)newValue);
				return;
			case LibraryPackage.COMPONENT__PARAMETER_REFS:
				getParameterRefs().clear();
				getParameterRefs().addAll((Collection<? extends Parameter>)newValue);
				return;
			case LibraryPackage.COMPONENT__ALL_RESOURCES:
				getAllResources().clear();
				getAllResources().addAll((Collection<? extends NetXResource>)newValue);
				return;
			case LibraryPackage.COMPONENT__DIAGRAMS:
				getDiagrams().clear();
				getDiagrams().addAll((Collection<? extends DiagramInfo>)newValue);
				return;
			case LibraryPackage.COMPONENT__ICONS:
				setIcons((MultiImage)newValue);
				return;
			case LibraryPackage.COMPONENT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case LibraryPackage.COMPONENT__DURATION:
				setDuration((ExpansionDuration)newValue);
				return;
			case LibraryPackage.COMPONENT__NAME:
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
			case LibraryPackage.COMPONENT__LIFECYCLE:
				setLifecycle((Lifecycle)null);
				return;
			case LibraryPackage.COMPONENT__RESOURCE_REFS:
				getResourceRefs().clear();
				return;
			case LibraryPackage.COMPONENT__METRIC_REFS:
				getMetricRefs().clear();
				return;
			case LibraryPackage.COMPONENT__CAPACITY_EXPRESSION_REF:
				setCapacityExpressionRef((Expression)null);
				return;
			case LibraryPackage.COMPONENT__UTILIZATION_EXPRESSION_REF:
				setUtilizationExpressionRef((Expression)null);
				return;
			case LibraryPackage.COMPONENT__TOLERANCE_REFS:
				getToleranceRefs().clear();
				return;
			case LibraryPackage.COMPONENT__PROTOCOL_REFS:
				getProtocolRefs().clear();
				return;
			case LibraryPackage.COMPONENT__PARAMETER_REFS:
				getParameterRefs().clear();
				return;
			case LibraryPackage.COMPONENT__ALL_RESOURCES:
				getAllResources().clear();
				return;
			case LibraryPackage.COMPONENT__DIAGRAMS:
				getDiagrams().clear();
				return;
			case LibraryPackage.COMPONENT__ICONS:
				setIcons((MultiImage)null);
				return;
			case LibraryPackage.COMPONENT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case LibraryPackage.COMPONENT__DURATION:
				unsetDuration();
				return;
			case LibraryPackage.COMPONENT__NAME:
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
			case LibraryPackage.COMPONENT__LIFECYCLE:
				return lifecycle != null;
			case LibraryPackage.COMPONENT__RESOURCE_REFS:
				return resourceRefs != null && !resourceRefs.isEmpty();
			case LibraryPackage.COMPONENT__METRIC_REFS:
				return metricRefs != null && !metricRefs.isEmpty();
			case LibraryPackage.COMPONENT__CAPACITY_EXPRESSION_REF:
				return capacityExpressionRef != null;
			case LibraryPackage.COMPONENT__UTILIZATION_EXPRESSION_REF:
				return utilizationExpressionRef != null;
			case LibraryPackage.COMPONENT__TOLERANCE_REFS:
				return toleranceRefs != null && !toleranceRefs.isEmpty();
			case LibraryPackage.COMPONENT__PROTOCOL_REFS:
				return protocolRefs != null && !protocolRefs.isEmpty();
			case LibraryPackage.COMPONENT__PARAMETER_REFS:
				return parameterRefs != null && !parameterRefs.isEmpty();
			case LibraryPackage.COMPONENT__ALL_RESOURCES:
				return ALL_RESOURCES__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case LibraryPackage.COMPONENT__DIAGRAMS:
				return diagrams != null && !diagrams.isEmpty();
			case LibraryPackage.COMPONENT__ICONS:
				return icons != null;
			case LibraryPackage.COMPONENT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case LibraryPackage.COMPONENT__DURATION:
				return isSetDuration();
			case LibraryPackage.COMPONENT__NAME:
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
		result.append(", duration: ");
		if (durationESet) result.append(duration); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ComponentImpl
