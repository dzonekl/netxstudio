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
package com.netxforge.netxstudio.services.impl;

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.library.NetXResource;

import com.netxforge.netxstudio.services.DerivedResource;
import com.netxforge.netxstudio.services.DistributionEntry;
import com.netxforge.netxstudio.services.ResourceOriginType;
import com.netxforge.netxstudio.services.ServicesPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Distribution Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.impl.DistributionEntryImpl#getResourceRef <em>Resource Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.DistributionEntryImpl#getDistribution <em>Distribution</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.DistributionEntryImpl#getResourceOrigin <em>Resource Origin</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DistributionEntryImpl extends BaseImpl implements DistributionEntry {
	/**
	 * The cached value of the '{@link #getResourceRef() <em>Resource Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceRef()
	 * @generated
	 * @ordered
	 */
	protected NetXResource resourceRef;

	/**
	 * The cached value of the '{@link #getDistribution() <em>Distribution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistribution()
	 * @generated
	 * @ordered
	 */
	protected DerivedResource distribution;

	/**
	 * The default value of the '{@link #getResourceOrigin() <em>Resource Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceOrigin()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceOriginType RESOURCE_ORIGIN_EDEFAULT = ResourceOriginType.IN_BOUND;

	/**
	 * The cached value of the '{@link #getResourceOrigin() <em>Resource Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceOrigin()
	 * @generated
	 * @ordered
	 */
	protected ResourceOriginType resourceOrigin = RESOURCE_ORIGIN_EDEFAULT;

	/**
	 * This is true if the Resource Origin attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean resourceOriginESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DistributionEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicesPackage.Literals.DISTRIBUTION_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetXResource getResourceRef() {
		if (resourceRef != null && resourceRef.eIsProxy()) {
			InternalEObject oldResourceRef = (InternalEObject)resourceRef;
			resourceRef = (NetXResource)eResolveProxy(oldResourceRef);
			if (resourceRef != oldResourceRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicesPackage.DISTRIBUTION_ENTRY__RESOURCE_REF, oldResourceRef, resourceRef));
			}
		}
		return resourceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetXResource basicGetResourceRef() {
		return resourceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceRef(NetXResource newResourceRef) {
		NetXResource oldResourceRef = resourceRef;
		resourceRef = newResourceRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.DISTRIBUTION_ENTRY__RESOURCE_REF, oldResourceRef, resourceRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DerivedResource getDistribution() {
		return distribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDistribution(DerivedResource newDistribution, NotificationChain msgs) {
		DerivedResource oldDistribution = distribution;
		distribution = newDistribution;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicesPackage.DISTRIBUTION_ENTRY__DISTRIBUTION, oldDistribution, newDistribution);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistribution(DerivedResource newDistribution) {
		if (newDistribution != distribution) {
			NotificationChain msgs = null;
			if (distribution != null)
				msgs = ((InternalEObject)distribution).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicesPackage.DISTRIBUTION_ENTRY__DISTRIBUTION, null, msgs);
			if (newDistribution != null)
				msgs = ((InternalEObject)newDistribution).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicesPackage.DISTRIBUTION_ENTRY__DISTRIBUTION, null, msgs);
			msgs = basicSetDistribution(newDistribution, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.DISTRIBUTION_ENTRY__DISTRIBUTION, newDistribution, newDistribution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceOriginType getResourceOrigin() {
		return resourceOrigin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceOrigin(ResourceOriginType newResourceOrigin) {
		ResourceOriginType oldResourceOrigin = resourceOrigin;
		resourceOrigin = newResourceOrigin == null ? RESOURCE_ORIGIN_EDEFAULT : newResourceOrigin;
		boolean oldResourceOriginESet = resourceOriginESet;
		resourceOriginESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.DISTRIBUTION_ENTRY__RESOURCE_ORIGIN, oldResourceOrigin, resourceOrigin, !oldResourceOriginESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetResourceOrigin() {
		ResourceOriginType oldResourceOrigin = resourceOrigin;
		boolean oldResourceOriginESet = resourceOriginESet;
		resourceOrigin = RESOURCE_ORIGIN_EDEFAULT;
		resourceOriginESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ServicesPackage.DISTRIBUTION_ENTRY__RESOURCE_ORIGIN, oldResourceOrigin, RESOURCE_ORIGIN_EDEFAULT, oldResourceOriginESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetResourceOrigin() {
		return resourceOriginESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicesPackage.DISTRIBUTION_ENTRY__DISTRIBUTION:
				return basicSetDistribution(null, msgs);
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
			case ServicesPackage.DISTRIBUTION_ENTRY__RESOURCE_REF:
				if (resolve) return getResourceRef();
				return basicGetResourceRef();
			case ServicesPackage.DISTRIBUTION_ENTRY__DISTRIBUTION:
				return getDistribution();
			case ServicesPackage.DISTRIBUTION_ENTRY__RESOURCE_ORIGIN:
				return getResourceOrigin();
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
			case ServicesPackage.DISTRIBUTION_ENTRY__RESOURCE_REF:
				setResourceRef((NetXResource)newValue);
				return;
			case ServicesPackage.DISTRIBUTION_ENTRY__DISTRIBUTION:
				setDistribution((DerivedResource)newValue);
				return;
			case ServicesPackage.DISTRIBUTION_ENTRY__RESOURCE_ORIGIN:
				setResourceOrigin((ResourceOriginType)newValue);
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
			case ServicesPackage.DISTRIBUTION_ENTRY__RESOURCE_REF:
				setResourceRef((NetXResource)null);
				return;
			case ServicesPackage.DISTRIBUTION_ENTRY__DISTRIBUTION:
				setDistribution((DerivedResource)null);
				return;
			case ServicesPackage.DISTRIBUTION_ENTRY__RESOURCE_ORIGIN:
				unsetResourceOrigin();
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
			case ServicesPackage.DISTRIBUTION_ENTRY__RESOURCE_REF:
				return resourceRef != null;
			case ServicesPackage.DISTRIBUTION_ENTRY__DISTRIBUTION:
				return distribution != null;
			case ServicesPackage.DISTRIBUTION_ENTRY__RESOURCE_ORIGIN:
				return isSetResourceOrigin();
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
		result.append(" (resourceOrigin: ");
		if (resourceOriginESet) result.append(resourceOrigin); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //DistributionEntryImpl
