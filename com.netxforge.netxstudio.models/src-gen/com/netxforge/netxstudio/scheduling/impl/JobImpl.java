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
package com.netxforge.netxstudio.scheduling.impl;

import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobKinds;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;

import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Job</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getJobExecution <em>Job Execution</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getJobKind <em>Job Kind</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getStart <em>Start</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JobImpl extends EObjectImpl implements Job {
	/**
	 * The cached value of the '{@link #getJobExecution() <em>Job Execution</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJobExecution()
	 * @generated
	 * @ordered
	 */
	protected EList<XMLGregorianCalendar> jobExecution;

	/**
	 * The default value of the '{@link #getJobKind() <em>Job Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJobKind()
	 * @generated
	 * @ordered
	 */
	protected static final JobKinds JOB_KIND_EDEFAULT = JobKinds.RESOURCE_MONITORING;

	/**
	 * The cached value of the '{@link #getJobKind() <em>Job Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJobKind()
	 * @generated
	 * @ordered
	 */
	protected JobKinds jobKind = JOB_KIND_EDEFAULT;

	/**
	 * This is true if the Job Kind attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean jobKindESet;

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
	 * The default value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar START_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar start = START_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JobImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.JOB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XMLGregorianCalendar> getJobExecution() {
		if (jobExecution == null) {
			jobExecution = new EDataTypeEList<XMLGregorianCalendar>(XMLGregorianCalendar.class, this, SchedulingPackage.JOB__JOB_EXECUTION);
		}
		return jobExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobKinds getJobKind() {
		return jobKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJobKind(JobKinds newJobKind) {
		JobKinds oldJobKind = jobKind;
		jobKind = newJobKind == null ? JOB_KIND_EDEFAULT : newJobKind;
		boolean oldJobKindESet = jobKindESet;
		jobKindESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.JOB__JOB_KIND, oldJobKind, jobKind, !oldJobKindESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetJobKind() {
		JobKinds oldJobKind = jobKind;
		boolean oldJobKindESet = jobKindESet;
		jobKind = JOB_KIND_EDEFAULT;
		jobKindESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, SchedulingPackage.JOB__JOB_KIND, oldJobKind, JOB_KIND_EDEFAULT, oldJobKindESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetJobKind() {
		return jobKindESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.JOB__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(XMLGregorianCalendar newStart) {
		XMLGregorianCalendar oldStart = start;
		start = newStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.JOB__START, oldStart, start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulingPackage.JOB__JOB_EXECUTION:
				return getJobExecution();
			case SchedulingPackage.JOB__JOB_KIND:
				return getJobKind();
			case SchedulingPackage.JOB__NAME:
				return getName();
			case SchedulingPackage.JOB__START:
				return getStart();
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
			case SchedulingPackage.JOB__JOB_EXECUTION:
				getJobExecution().clear();
				getJobExecution().addAll((Collection<? extends XMLGregorianCalendar>)newValue);
				return;
			case SchedulingPackage.JOB__JOB_KIND:
				setJobKind((JobKinds)newValue);
				return;
			case SchedulingPackage.JOB__NAME:
				setName((String)newValue);
				return;
			case SchedulingPackage.JOB__START:
				setStart((XMLGregorianCalendar)newValue);
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
			case SchedulingPackage.JOB__JOB_EXECUTION:
				getJobExecution().clear();
				return;
			case SchedulingPackage.JOB__JOB_KIND:
				unsetJobKind();
				return;
			case SchedulingPackage.JOB__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SchedulingPackage.JOB__START:
				setStart(START_EDEFAULT);
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
			case SchedulingPackage.JOB__JOB_EXECUTION:
				return jobExecution != null && !jobExecution.isEmpty();
			case SchedulingPackage.JOB__JOB_KIND:
				return isSetJobKind();
			case SchedulingPackage.JOB__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SchedulingPackage.JOB__START:
				return START_EDEFAULT == null ? start != null : !START_EDEFAULT.equals(start);
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
		result.append(" (jobExecution: ");
		result.append(jobExecution);
		result.append(", jobKind: ");
		if (jobKindESet) result.append(jobKind); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(", start: ");
		result.append(start);
		result.append(')');
		return result.toString();
	}

} //JobImpl
