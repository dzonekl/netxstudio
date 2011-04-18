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
package com.netxforge.netxstudio.services.impl;

import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.ServicesPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RFS Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.impl.RFSServiceImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.RFSServiceImpl#getToleranceRefs <em>Tolerance Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.RFSServiceImpl#getFunctionalCategory <em>Functional Category</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RFSServiceImpl extends ServiceImpl implements RFSService {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> nodes;

	/**
	 * The cached value of the '{@link #getToleranceRefs() <em>Tolerance Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToleranceRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> toleranceRefs;

	/**
	 * The default value of the '{@link #getFunctionalCategory() <em>Functional Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionalCategory()
	 * @generated
	 * @ordered
	 */
	protected static final String FUNCTIONAL_CATEGORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFunctionalCategory() <em>Functional Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionalCategory()
	 * @generated
	 * @ordered
	 */
	protected String functionalCategory = FUNCTIONAL_CATEGORY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RFSServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicesPackage.Literals.RFS_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getNodes() {
		if (nodes == null) {
			nodes = new EObjectResolvingEList<EObject>(EObject.class, this, ServicesPackage.RFS_SERVICE__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getToleranceRefs() {
		if (toleranceRefs == null) {
			toleranceRefs = new EObjectResolvingEList<EObject>(EObject.class, this, ServicesPackage.RFS_SERVICE__TOLERANCE_REFS);
		}
		return toleranceRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFunctionalCategory() {
		return functionalCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionalCategory(String newFunctionalCategory) {
		String oldFunctionalCategory = functionalCategory;
		functionalCategory = newFunctionalCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.RFS_SERVICE__FUNCTIONAL_CATEGORY, oldFunctionalCategory, functionalCategory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicesPackage.RFS_SERVICE__NODES:
				return getNodes();
			case ServicesPackage.RFS_SERVICE__TOLERANCE_REFS:
				return getToleranceRefs();
			case ServicesPackage.RFS_SERVICE__FUNCTIONAL_CATEGORY:
				return getFunctionalCategory();
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
			case ServicesPackage.RFS_SERVICE__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends EObject>)newValue);
				return;
			case ServicesPackage.RFS_SERVICE__TOLERANCE_REFS:
				getToleranceRefs().clear();
				getToleranceRefs().addAll((Collection<? extends EObject>)newValue);
				return;
			case ServicesPackage.RFS_SERVICE__FUNCTIONAL_CATEGORY:
				setFunctionalCategory((String)newValue);
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
			case ServicesPackage.RFS_SERVICE__NODES:
				getNodes().clear();
				return;
			case ServicesPackage.RFS_SERVICE__TOLERANCE_REFS:
				getToleranceRefs().clear();
				return;
			case ServicesPackage.RFS_SERVICE__FUNCTIONAL_CATEGORY:
				setFunctionalCategory(FUNCTIONAL_CATEGORY_EDEFAULT);
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
			case ServicesPackage.RFS_SERVICE__NODES:
				return nodes != null && !nodes.isEmpty();
			case ServicesPackage.RFS_SERVICE__TOLERANCE_REFS:
				return toleranceRefs != null && !toleranceRefs.isEmpty();
			case ServicesPackage.RFS_SERVICE__FUNCTIONAL_CATEGORY:
				return FUNCTIONAL_CATEGORY_EDEFAULT == null ? functionalCategory != null : !FUNCTIONAL_CATEGORY_EDEFAULT.equals(functionalCategory);
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
		result.append(" (functionalCategory: ");
		result.append(functionalCategory);
		result.append(')');
		return result.toString();
	}

} //RFSServiceImpl
