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

import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;

import com.netxforge.netxstudio.operators.FunctionRelationship;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getFunctionRelationshipRefs <em>Function Relationship Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getAllFunctions <em>All Functions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionImpl extends ComponentImpl implements Function {
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
	 * The cached value of the '{@link #getFunctionRelationshipRefs() <em>Function Relationship Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionRelationshipRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionRelationship> functionRelationshipRefs;

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
	@SuppressWarnings("unchecked")
	public EList<Function> getAllFunctions() {
		return (EList<Function>)ALL_FUNCTIONS__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryPackage.FUNCTION__FUNCTIONS:
				return ((InternalEList<?>)getFunctions()).basicRemove(otherEnd, msgs);
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
			case LibraryPackage.FUNCTION__FUNCTIONS:
				return getFunctions();
			case LibraryPackage.FUNCTION__FUNCTION_RELATIONSHIP_REFS:
				return getFunctionRelationshipRefs();
			case LibraryPackage.FUNCTION__ALL_FUNCTIONS:
				return getAllFunctions();
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
			case LibraryPackage.FUNCTION__FUNCTIONS:
				getFunctions().clear();
				getFunctions().addAll((Collection<? extends Function>)newValue);
				return;
			case LibraryPackage.FUNCTION__FUNCTION_RELATIONSHIP_REFS:
				getFunctionRelationshipRefs().clear();
				getFunctionRelationshipRefs().addAll((Collection<? extends FunctionRelationship>)newValue);
				return;
			case LibraryPackage.FUNCTION__ALL_FUNCTIONS:
				getAllFunctions().clear();
				getAllFunctions().addAll((Collection<? extends Function>)newValue);
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
			case LibraryPackage.FUNCTION__FUNCTIONS:
				getFunctions().clear();
				return;
			case LibraryPackage.FUNCTION__FUNCTION_RELATIONSHIP_REFS:
				getFunctionRelationshipRefs().clear();
				return;
			case LibraryPackage.FUNCTION__ALL_FUNCTIONS:
				getAllFunctions().clear();
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
			case LibraryPackage.FUNCTION__FUNCTIONS:
				return functions != null && !functions.isEmpty();
			case LibraryPackage.FUNCTION__FUNCTION_RELATIONSHIP_REFS:
				return functionRelationshipRefs != null && !functionRelationshipRefs.isEmpty();
			case LibraryPackage.FUNCTION__ALL_FUNCTIONS:
				return ALL_FUNCTIONS__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
		}
		return super.eIsSet(featureID);
	}

} //FunctionImpl
