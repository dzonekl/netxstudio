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
package com.netxforge.netxstudio.scheduling.impl;

import com.netxforge.netxstudio.library.NodeType;

import com.netxforge.netxstudio.scheduling.NodeTypeReporterJob;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Type Reporter Job</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.NodeTypeReporterJobImpl#getNodeType <em>Node Type</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.NodeTypeReporterJobImpl#getScopeObject <em>Scope Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeTypeReporterJobImpl extends JobImpl implements NodeTypeReporterJob {
	/**
	 * The cached value of the '{@link #getNodeType() <em>Node Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeType()
	 * @generated
	 * @ordered
	 */
	protected NodeType nodeType;

	/**
	 * The cached value of the '{@link #getScopeObject() <em>Scope Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopeObject()
	 * @generated
	 * @ordered
	 */
	protected EObject scopeObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeTypeReporterJobImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.NODE_TYPE_REPORTER_JOB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType getNodeType() {
		if (nodeType != null && nodeType.eIsProxy()) {
			InternalEObject oldNodeType = (InternalEObject)nodeType;
			nodeType = (NodeType)eResolveProxy(oldNodeType);
			if (nodeType != oldNodeType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulingPackage.NODE_TYPE_REPORTER_JOB__NODE_TYPE, oldNodeType, nodeType));
			}
		}
		return nodeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType basicGetNodeType() {
		return nodeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeType(NodeType newNodeType) {
		NodeType oldNodeType = nodeType;
		nodeType = newNodeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.NODE_TYPE_REPORTER_JOB__NODE_TYPE, oldNodeType, nodeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getScopeObject() {
		if (scopeObject != null && scopeObject.eIsProxy()) {
			InternalEObject oldScopeObject = (InternalEObject)scopeObject;
			scopeObject = eResolveProxy(oldScopeObject);
			if (scopeObject != oldScopeObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulingPackage.NODE_TYPE_REPORTER_JOB__SCOPE_OBJECT, oldScopeObject, scopeObject));
			}
		}
		return scopeObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetScopeObject() {
		return scopeObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScopeObject(EObject newScopeObject) {
		EObject oldScopeObject = scopeObject;
		scopeObject = newScopeObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.NODE_TYPE_REPORTER_JOB__SCOPE_OBJECT, oldScopeObject, scopeObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulingPackage.NODE_TYPE_REPORTER_JOB__NODE_TYPE:
				if (resolve) return getNodeType();
				return basicGetNodeType();
			case SchedulingPackage.NODE_TYPE_REPORTER_JOB__SCOPE_OBJECT:
				if (resolve) return getScopeObject();
				return basicGetScopeObject();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SchedulingPackage.NODE_TYPE_REPORTER_JOB__NODE_TYPE:
				setNodeType((NodeType)newValue);
				return;
			case SchedulingPackage.NODE_TYPE_REPORTER_JOB__SCOPE_OBJECT:
				setScopeObject((EObject)newValue);
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
			case SchedulingPackage.NODE_TYPE_REPORTER_JOB__NODE_TYPE:
				setNodeType((NodeType)null);
				return;
			case SchedulingPackage.NODE_TYPE_REPORTER_JOB__SCOPE_OBJECT:
				setScopeObject((EObject)null);
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
			case SchedulingPackage.NODE_TYPE_REPORTER_JOB__NODE_TYPE:
				return nodeType != null;
			case SchedulingPackage.NODE_TYPE_REPORTER_JOB__SCOPE_OBJECT:
				return scopeObject != null;
		}
		return super.eIsSet(featureID);
	}

} //NodeTypeReporterJobImpl
