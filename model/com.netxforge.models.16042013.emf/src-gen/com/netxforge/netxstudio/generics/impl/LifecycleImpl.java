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
package com.netxforge.netxstudio.generics.impl;

import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Lifecycle;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lifecycle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.LifecycleImpl#getConstructionDate <em>Construction Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.LifecycleImpl#getInServiceDate <em>In Service Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.LifecycleImpl#getOutOfServiceDate <em>Out Of Service Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.LifecycleImpl#getPlannedDate <em>Planned Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.LifecycleImpl#getProposed <em>Proposed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LifecycleImpl extends BaseImpl implements Lifecycle {
	/**
	 * The default value of the '{@link #getConstructionDate() <em>Construction Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstructionDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar CONSTRUCTION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConstructionDate() <em>Construction Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstructionDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar constructionDate = CONSTRUCTION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getInServiceDate() <em>In Service Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInServiceDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar IN_SERVICE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInServiceDate() <em>In Service Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInServiceDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar inServiceDate = IN_SERVICE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutOfServiceDate() <em>Out Of Service Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutOfServiceDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar OUT_OF_SERVICE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutOfServiceDate() <em>Out Of Service Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutOfServiceDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar outOfServiceDate = OUT_OF_SERVICE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlannedDate() <em>Planned Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlannedDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar PLANNED_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlannedDate() <em>Planned Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlannedDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar plannedDate = PLANNED_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProposed() <em>Proposed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProposed()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar PROPOSED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProposed() <em>Proposed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProposed()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar proposed = PROPOSED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LifecycleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericsPackage.Literals.LIFECYCLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getConstructionDate() {
		return constructionDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstructionDate(XMLGregorianCalendar newConstructionDate) {
		XMLGregorianCalendar oldConstructionDate = constructionDate;
		constructionDate = newConstructionDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.LIFECYCLE__CONSTRUCTION_DATE, oldConstructionDate, constructionDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getInServiceDate() {
		return inServiceDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInServiceDate(XMLGregorianCalendar newInServiceDate) {
		XMLGregorianCalendar oldInServiceDate = inServiceDate;
		inServiceDate = newInServiceDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.LIFECYCLE__IN_SERVICE_DATE, oldInServiceDate, inServiceDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getOutOfServiceDate() {
		return outOfServiceDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutOfServiceDate(XMLGregorianCalendar newOutOfServiceDate) {
		XMLGregorianCalendar oldOutOfServiceDate = outOfServiceDate;
		outOfServiceDate = newOutOfServiceDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.LIFECYCLE__OUT_OF_SERVICE_DATE, oldOutOfServiceDate, outOfServiceDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getPlannedDate() {
		return plannedDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlannedDate(XMLGregorianCalendar newPlannedDate) {
		XMLGregorianCalendar oldPlannedDate = plannedDate;
		plannedDate = newPlannedDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.LIFECYCLE__PLANNED_DATE, oldPlannedDate, plannedDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getProposed() {
		return proposed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProposed(XMLGregorianCalendar newProposed) {
		XMLGregorianCalendar oldProposed = proposed;
		proposed = newProposed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.LIFECYCLE__PROPOSED, oldProposed, proposed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenericsPackage.LIFECYCLE__CONSTRUCTION_DATE:
				return getConstructionDate();
			case GenericsPackage.LIFECYCLE__IN_SERVICE_DATE:
				return getInServiceDate();
			case GenericsPackage.LIFECYCLE__OUT_OF_SERVICE_DATE:
				return getOutOfServiceDate();
			case GenericsPackage.LIFECYCLE__PLANNED_DATE:
				return getPlannedDate();
			case GenericsPackage.LIFECYCLE__PROPOSED:
				return getProposed();
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
			case GenericsPackage.LIFECYCLE__CONSTRUCTION_DATE:
				setConstructionDate((XMLGregorianCalendar)newValue);
				return;
			case GenericsPackage.LIFECYCLE__IN_SERVICE_DATE:
				setInServiceDate((XMLGregorianCalendar)newValue);
				return;
			case GenericsPackage.LIFECYCLE__OUT_OF_SERVICE_DATE:
				setOutOfServiceDate((XMLGregorianCalendar)newValue);
				return;
			case GenericsPackage.LIFECYCLE__PLANNED_DATE:
				setPlannedDate((XMLGregorianCalendar)newValue);
				return;
			case GenericsPackage.LIFECYCLE__PROPOSED:
				setProposed((XMLGregorianCalendar)newValue);
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
			case GenericsPackage.LIFECYCLE__CONSTRUCTION_DATE:
				setConstructionDate(CONSTRUCTION_DATE_EDEFAULT);
				return;
			case GenericsPackage.LIFECYCLE__IN_SERVICE_DATE:
				setInServiceDate(IN_SERVICE_DATE_EDEFAULT);
				return;
			case GenericsPackage.LIFECYCLE__OUT_OF_SERVICE_DATE:
				setOutOfServiceDate(OUT_OF_SERVICE_DATE_EDEFAULT);
				return;
			case GenericsPackage.LIFECYCLE__PLANNED_DATE:
				setPlannedDate(PLANNED_DATE_EDEFAULT);
				return;
			case GenericsPackage.LIFECYCLE__PROPOSED:
				setProposed(PROPOSED_EDEFAULT);
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
			case GenericsPackage.LIFECYCLE__CONSTRUCTION_DATE:
				return CONSTRUCTION_DATE_EDEFAULT == null ? constructionDate != null : !CONSTRUCTION_DATE_EDEFAULT.equals(constructionDate);
			case GenericsPackage.LIFECYCLE__IN_SERVICE_DATE:
				return IN_SERVICE_DATE_EDEFAULT == null ? inServiceDate != null : !IN_SERVICE_DATE_EDEFAULT.equals(inServiceDate);
			case GenericsPackage.LIFECYCLE__OUT_OF_SERVICE_DATE:
				return OUT_OF_SERVICE_DATE_EDEFAULT == null ? outOfServiceDate != null : !OUT_OF_SERVICE_DATE_EDEFAULT.equals(outOfServiceDate);
			case GenericsPackage.LIFECYCLE__PLANNED_DATE:
				return PLANNED_DATE_EDEFAULT == null ? plannedDate != null : !PLANNED_DATE_EDEFAULT.equals(plannedDate);
			case GenericsPackage.LIFECYCLE__PROPOSED:
				return PROPOSED_EDEFAULT == null ? proposed != null : !PROPOSED_EDEFAULT.equals(proposed);
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
		result.append(" (constructionDate: ");
		result.append(constructionDate);
		result.append(", inServiceDate: ");
		result.append(inServiceDate);
		result.append(", outOfServiceDate: ");
		result.append(outOfServiceDate);
		result.append(", plannedDate: ");
		result.append(plannedDate);
		result.append(", proposed: ");
		result.append(proposed);
		result.append(')');
		return result.toString();
	}

} //LifecycleImpl
