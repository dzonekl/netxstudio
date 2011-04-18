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

import com.netxforge.netxstudio.library.Expression;

import com.netxforge.netxstudio.services.ServiceProfile;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.ServicesPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceUserImpl#getServiceProfile <em>Service Profile</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceUserImpl#getExpressionRefs <em>Expression Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceUserImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceUserImpl extends EObjectImpl implements ServiceUser {
	/**
	 * The cached value of the '{@link #getServiceProfile() <em>Service Profile</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceProfile()
	 * @generated
	 * @ordered
	 */
	protected ServiceProfile serviceProfile;

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
	protected ServiceUserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicesPackage.Literals.SERVICE_USER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceProfile getServiceProfile() {
		return serviceProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServiceProfile(ServiceProfile newServiceProfile, NotificationChain msgs) {
		ServiceProfile oldServiceProfile = serviceProfile;
		serviceProfile = newServiceProfile;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE_USER__SERVICE_PROFILE, oldServiceProfile, newServiceProfile);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceProfile(ServiceProfile newServiceProfile) {
		if (newServiceProfile != serviceProfile) {
			NotificationChain msgs = null;
			if (serviceProfile != null)
				msgs = ((InternalEObject)serviceProfile).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicesPackage.SERVICE_USER__SERVICE_PROFILE, null, msgs);
			if (newServiceProfile != null)
				msgs = ((InternalEObject)newServiceProfile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicesPackage.SERVICE_USER__SERVICE_PROFILE, null, msgs);
			msgs = basicSetServiceProfile(newServiceProfile, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE_USER__SERVICE_PROFILE, newServiceProfile, newServiceProfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getExpressionRefs() {
		if (expressionRefs == null) {
			expressionRefs = new EObjectResolvingEList<Expression>(Expression.class, this, ServicesPackage.SERVICE_USER__EXPRESSION_REFS);
		}
		return expressionRefs;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE_USER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicesPackage.SERVICE_USER__SERVICE_PROFILE:
				return basicSetServiceProfile(null, msgs);
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
			case ServicesPackage.SERVICE_USER__SERVICE_PROFILE:
				return getServiceProfile();
			case ServicesPackage.SERVICE_USER__EXPRESSION_REFS:
				return getExpressionRefs();
			case ServicesPackage.SERVICE_USER__NAME:
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
			case ServicesPackage.SERVICE_USER__SERVICE_PROFILE:
				setServiceProfile((ServiceProfile)newValue);
				return;
			case ServicesPackage.SERVICE_USER__EXPRESSION_REFS:
				getExpressionRefs().clear();
				getExpressionRefs().addAll((Collection<? extends Expression>)newValue);
				return;
			case ServicesPackage.SERVICE_USER__NAME:
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
			case ServicesPackage.SERVICE_USER__SERVICE_PROFILE:
				setServiceProfile((ServiceProfile)null);
				return;
			case ServicesPackage.SERVICE_USER__EXPRESSION_REFS:
				getExpressionRefs().clear();
				return;
			case ServicesPackage.SERVICE_USER__NAME:
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
			case ServicesPackage.SERVICE_USER__SERVICE_PROFILE:
				return serviceProfile != null;
			case ServicesPackage.SERVICE_USER__EXPRESSION_REFS:
				return expressionRefs != null && !expressionRefs.isEmpty();
			case ServicesPackage.SERVICE_USER__NAME:
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ServiceUserImpl
