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
import com.netxforge.netxstudio.generics.MultiImage;

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.Parameter;
import com.netxforge.netxstudio.library.Tolerance;

import com.netxforge.netxstudio.metrics.Metric;

import com.netxforge.netxstudio.operators.FunctionRelationship;

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
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getFunctionResources <em>Function Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getFunctionMetricRefs <em>Function Metric Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getFunctionRelationshipRefs <em>Function Relationship Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getFunctionExpressionRefs <em>Function Expression Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getToleranceRefs <em>Tolerance Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getProtocolRefs <em>Protocol Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getParameterRefs <em>Parameter Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getAllFunctionResources <em>All Function Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getAllFunctions <em>All Functions</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getFunctionName <em>Function Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionImpl extends EObjectImpl implements Function {
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
	 * The cached value of the '{@link #getFunctions() <em>Functions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> functions;

	/**
	 * The cached value of the '{@link #getFunctionResources() <em>Function Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionResources()
	 * @generated
	 * @ordered
	 */
	protected EList<NetXResource> functionResources;

	/**
	 * The cached value of the '{@link #getFunctionMetricRefs() <em>Function Metric Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionMetricRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric> functionMetricRefs;

	/**
	 * The cached value of the '{@link #getFunctionRelationshipRefs() <em>Function Relationship Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionRelationshipRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionRelationship> functionRelationshipRefs;

	/**
	 * The cached value of the '{@link #getFunctionExpressionRefs() <em>Function Expression Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionExpressionRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> functionExpressionRefs;

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
	 * The cached setting delegate for the '{@link #getAllFunctionResources() <em>All Function Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllFunctionResources()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate ALL_FUNCTION_RESOURCES__ESETTING_DELEGATE = ((EStructuralFeature.Internal)LibraryPackage.Literals.FUNCTION__ALL_FUNCTION_RESOURCES).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getAllFunctions() <em>All Functions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllFunctions()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate ALL_FUNCTIONS__ESETTING_DELEGATE = ((EStructuralFeature.Internal)LibraryPackage.Literals.FUNCTION__ALL_FUNCTIONS).getSettingDelegate();

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
	 * The default value of the '{@link #getFunctionName() <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionName()
	 * @generated
	 * @ordered
	 */
	protected static final String FUNCTION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFunctionName() <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionName()
	 * @generated
	 * @ordered
	 */
	protected String functionName = FUNCTION_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiagramInfo> getDiagrams() {
		if (diagrams == null) {
			diagrams = new EObjectContainmentEList<DiagramInfo>(DiagramInfo.class, this, LibraryPackage.FUNCTION__DIAGRAMS);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LibraryPackage.FUNCTION__ICONS, oldIcons, newIcons);
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
				msgs = ((InternalEObject)icons).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.FUNCTION__ICONS, null, msgs);
			if (newIcons != null)
				msgs = ((InternalEObject)newIcons).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.FUNCTION__ICONS, null, msgs);
			msgs = basicSetIcons(newIcons, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.FUNCTION__ICONS, newIcons, newIcons));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Function> getFunctions() {
		if (functions == null) {
			functions = new EObjectContainmentEList<Function>(Function.class, this, LibraryPackage.FUNCTION__FUNCTIONS);
		}
		return functions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NetXResource> getFunctionResources() {
		if (functionResources == null) {
			functionResources = new EObjectContainmentEList<NetXResource>(NetXResource.class, this, LibraryPackage.FUNCTION__FUNCTION_RESOURCES);
		}
		return functionResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric> getFunctionMetricRefs() {
		if (functionMetricRefs == null) {
			functionMetricRefs = new EObjectResolvingEList<Metric>(Metric.class, this, LibraryPackage.FUNCTION__FUNCTION_METRIC_REFS);
		}
		return functionMetricRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionRelationship> getFunctionRelationshipRefs() {
		if (functionRelationshipRefs == null) {
			functionRelationshipRefs = new EObjectResolvingEList<FunctionRelationship>(FunctionRelationship.class, this, LibraryPackage.FUNCTION__FUNCTION_RELATIONSHIP_REFS);
		}
		return functionRelationshipRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getFunctionExpressionRefs() {
		if (functionExpressionRefs == null) {
			functionExpressionRefs = new EObjectWithInverseResolvingEList.ManyInverse<Expression>(Expression.class, this, LibraryPackage.FUNCTION__FUNCTION_EXPRESSION_REFS, LibraryPackage.EXPRESSION__FUNCTION_REFS);
		}
		return functionExpressionRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tolerance> getToleranceRefs() {
		if (toleranceRefs == null) {
			toleranceRefs = new EObjectResolvingEList<Tolerance>(Tolerance.class, this, LibraryPackage.FUNCTION__TOLERANCE_REFS);
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
			protocolRefs = new EObjectResolvingEList<Protocol>(Protocol.class, this, LibraryPackage.FUNCTION__PROTOCOL_REFS);
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
			parameterRefs = new EObjectResolvingEList<Parameter>(Parameter.class, this, LibraryPackage.FUNCTION__PARAMETER_REFS);
		}
		return parameterRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NetXResource> getAllFunctionResources() {
		return (EList<NetXResource>)ALL_FUNCTION_RESOURCES__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Function> getAllFunctions() {
		return (EList<Function>)ALL_FUNCTIONS__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
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
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.FUNCTION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFunctionName() {
		return functionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionName(String newFunctionName) {
		String oldFunctionName = functionName;
		functionName = newFunctionName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.FUNCTION__FUNCTION_NAME, oldFunctionName, functionName));
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
			case LibraryPackage.FUNCTION__FUNCTION_EXPRESSION_REFS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFunctionExpressionRefs()).basicAdd(otherEnd, msgs);
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
			case LibraryPackage.FUNCTION__DIAGRAMS:
				return ((InternalEList<?>)getDiagrams()).basicRemove(otherEnd, msgs);
			case LibraryPackage.FUNCTION__ICONS:
				return basicSetIcons(null, msgs);
			case LibraryPackage.FUNCTION__FUNCTIONS:
				return ((InternalEList<?>)getFunctions()).basicRemove(otherEnd, msgs);
			case LibraryPackage.FUNCTION__FUNCTION_RESOURCES:
				return ((InternalEList<?>)getFunctionResources()).basicRemove(otherEnd, msgs);
			case LibraryPackage.FUNCTION__FUNCTION_EXPRESSION_REFS:
				return ((InternalEList<?>)getFunctionExpressionRefs()).basicRemove(otherEnd, msgs);
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
			case LibraryPackage.FUNCTION__DIAGRAMS:
				return getDiagrams();
			case LibraryPackage.FUNCTION__ICONS:
				return getIcons();
			case LibraryPackage.FUNCTION__FUNCTIONS:
				return getFunctions();
			case LibraryPackage.FUNCTION__FUNCTION_RESOURCES:
				return getFunctionResources();
			case LibraryPackage.FUNCTION__FUNCTION_METRIC_REFS:
				return getFunctionMetricRefs();
			case LibraryPackage.FUNCTION__FUNCTION_RELATIONSHIP_REFS:
				return getFunctionRelationshipRefs();
			case LibraryPackage.FUNCTION__FUNCTION_EXPRESSION_REFS:
				return getFunctionExpressionRefs();
			case LibraryPackage.FUNCTION__TOLERANCE_REFS:
				return getToleranceRefs();
			case LibraryPackage.FUNCTION__PROTOCOL_REFS:
				return getProtocolRefs();
			case LibraryPackage.FUNCTION__PARAMETER_REFS:
				return getParameterRefs();
			case LibraryPackage.FUNCTION__ALL_FUNCTION_RESOURCES:
				return getAllFunctionResources();
			case LibraryPackage.FUNCTION__ALL_FUNCTIONS:
				return getAllFunctions();
			case LibraryPackage.FUNCTION__DESCRIPTION:
				return getDescription();
			case LibraryPackage.FUNCTION__FUNCTION_NAME:
				return getFunctionName();
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
			case LibraryPackage.FUNCTION__DIAGRAMS:
				getDiagrams().clear();
				getDiagrams().addAll((Collection<? extends DiagramInfo>)newValue);
				return;
			case LibraryPackage.FUNCTION__ICONS:
				setIcons((MultiImage)newValue);
				return;
			case LibraryPackage.FUNCTION__FUNCTIONS:
				getFunctions().clear();
				getFunctions().addAll((Collection<? extends Function>)newValue);
				return;
			case LibraryPackage.FUNCTION__FUNCTION_RESOURCES:
				getFunctionResources().clear();
				getFunctionResources().addAll((Collection<? extends NetXResource>)newValue);
				return;
			case LibraryPackage.FUNCTION__FUNCTION_METRIC_REFS:
				getFunctionMetricRefs().clear();
				getFunctionMetricRefs().addAll((Collection<? extends Metric>)newValue);
				return;
			case LibraryPackage.FUNCTION__FUNCTION_RELATIONSHIP_REFS:
				getFunctionRelationshipRefs().clear();
				getFunctionRelationshipRefs().addAll((Collection<? extends FunctionRelationship>)newValue);
				return;
			case LibraryPackage.FUNCTION__FUNCTION_EXPRESSION_REFS:
				getFunctionExpressionRefs().clear();
				getFunctionExpressionRefs().addAll((Collection<? extends Expression>)newValue);
				return;
			case LibraryPackage.FUNCTION__TOLERANCE_REFS:
				getToleranceRefs().clear();
				getToleranceRefs().addAll((Collection<? extends Tolerance>)newValue);
				return;
			case LibraryPackage.FUNCTION__PROTOCOL_REFS:
				getProtocolRefs().clear();
				getProtocolRefs().addAll((Collection<? extends Protocol>)newValue);
				return;
			case LibraryPackage.FUNCTION__PARAMETER_REFS:
				getParameterRefs().clear();
				getParameterRefs().addAll((Collection<? extends Parameter>)newValue);
				return;
			case LibraryPackage.FUNCTION__ALL_FUNCTION_RESOURCES:
				getAllFunctionResources().clear();
				getAllFunctionResources().addAll((Collection<? extends NetXResource>)newValue);
				return;
			case LibraryPackage.FUNCTION__ALL_FUNCTIONS:
				getAllFunctions().clear();
				getAllFunctions().addAll((Collection<? extends Function>)newValue);
				return;
			case LibraryPackage.FUNCTION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case LibraryPackage.FUNCTION__FUNCTION_NAME:
				setFunctionName((String)newValue);
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
			case LibraryPackage.FUNCTION__DIAGRAMS:
				getDiagrams().clear();
				return;
			case LibraryPackage.FUNCTION__ICONS:
				setIcons((MultiImage)null);
				return;
			case LibraryPackage.FUNCTION__FUNCTIONS:
				getFunctions().clear();
				return;
			case LibraryPackage.FUNCTION__FUNCTION_RESOURCES:
				getFunctionResources().clear();
				return;
			case LibraryPackage.FUNCTION__FUNCTION_METRIC_REFS:
				getFunctionMetricRefs().clear();
				return;
			case LibraryPackage.FUNCTION__FUNCTION_RELATIONSHIP_REFS:
				getFunctionRelationshipRefs().clear();
				return;
			case LibraryPackage.FUNCTION__FUNCTION_EXPRESSION_REFS:
				getFunctionExpressionRefs().clear();
				return;
			case LibraryPackage.FUNCTION__TOLERANCE_REFS:
				getToleranceRefs().clear();
				return;
			case LibraryPackage.FUNCTION__PROTOCOL_REFS:
				getProtocolRefs().clear();
				return;
			case LibraryPackage.FUNCTION__PARAMETER_REFS:
				getParameterRefs().clear();
				return;
			case LibraryPackage.FUNCTION__ALL_FUNCTION_RESOURCES:
				getAllFunctionResources().clear();
				return;
			case LibraryPackage.FUNCTION__ALL_FUNCTIONS:
				getAllFunctions().clear();
				return;
			case LibraryPackage.FUNCTION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case LibraryPackage.FUNCTION__FUNCTION_NAME:
				setFunctionName(FUNCTION_NAME_EDEFAULT);
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
			case LibraryPackage.FUNCTION__DIAGRAMS:
				return diagrams != null && !diagrams.isEmpty();
			case LibraryPackage.FUNCTION__ICONS:
				return icons != null;
			case LibraryPackage.FUNCTION__FUNCTIONS:
				return functions != null && !functions.isEmpty();
			case LibraryPackage.FUNCTION__FUNCTION_RESOURCES:
				return functionResources != null && !functionResources.isEmpty();
			case LibraryPackage.FUNCTION__FUNCTION_METRIC_REFS:
				return functionMetricRefs != null && !functionMetricRefs.isEmpty();
			case LibraryPackage.FUNCTION__FUNCTION_RELATIONSHIP_REFS:
				return functionRelationshipRefs != null && !functionRelationshipRefs.isEmpty();
			case LibraryPackage.FUNCTION__FUNCTION_EXPRESSION_REFS:
				return functionExpressionRefs != null && !functionExpressionRefs.isEmpty();
			case LibraryPackage.FUNCTION__TOLERANCE_REFS:
				return toleranceRefs != null && !toleranceRefs.isEmpty();
			case LibraryPackage.FUNCTION__PROTOCOL_REFS:
				return protocolRefs != null && !protocolRefs.isEmpty();
			case LibraryPackage.FUNCTION__PARAMETER_REFS:
				return parameterRefs != null && !parameterRefs.isEmpty();
			case LibraryPackage.FUNCTION__ALL_FUNCTION_RESOURCES:
				return ALL_FUNCTION_RESOURCES__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case LibraryPackage.FUNCTION__ALL_FUNCTIONS:
				return ALL_FUNCTIONS__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case LibraryPackage.FUNCTION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case LibraryPackage.FUNCTION__FUNCTION_NAME:
				return FUNCTION_NAME_EDEFAULT == null ? functionName != null : !FUNCTION_NAME_EDEFAULT.equals(functionName);
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
		result.append(", functionName: ");
		result.append(functionName);
		result.append(')');
		return result.toString();
	}

} //FunctionImpl
