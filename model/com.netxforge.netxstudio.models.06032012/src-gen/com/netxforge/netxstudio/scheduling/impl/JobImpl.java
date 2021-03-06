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

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.generics.impl.BaseImpl;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Job</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getEndTime <em>End Time</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getInterval <em>Interval</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getJobState <em>Job State</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getRepeat <em>Repeat</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getStartTime <em>Start Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JobImpl extends BaseImpl implements Job {
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
	public XMLGregorianCalendar getEndTime() {
		return (XMLGregorianCalendar)eGet(SchedulingPackage.Literals.JOB__END_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndTime(XMLGregorianCalendar newEndTime) {
		eSet(SchedulingPackage.Literals.JOB__END_TIME, newEndTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInterval() {
		return (Integer)eGet(SchedulingPackage.Literals.JOB__INTERVAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterval(int newInterval) {
		eSet(SchedulingPackage.Literals.JOB__INTERVAL, newInterval);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInterval() {
		eUnset(SchedulingPackage.Literals.JOB__INTERVAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInterval() {
		return eIsSet(SchedulingPackage.Literals.JOB__INTERVAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobState getJobState() {
		return (JobState)eGet(SchedulingPackage.Literals.JOB__JOB_STATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJobState(JobState newJobState) {
		eSet(SchedulingPackage.Literals.JOB__JOB_STATE, newJobState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetJobState() {
		eUnset(SchedulingPackage.Literals.JOB__JOB_STATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetJobState() {
		return eIsSet(SchedulingPackage.Literals.JOB__JOB_STATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(SchedulingPackage.Literals.JOB__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(SchedulingPackage.Literals.JOB__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRepeat() {
		return (Integer)eGet(SchedulingPackage.Literals.JOB__REPEAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepeat(int newRepeat) {
		eSet(SchedulingPackage.Literals.JOB__REPEAT, newRepeat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRepeat() {
		eUnset(SchedulingPackage.Literals.JOB__REPEAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRepeat() {
		return eIsSet(SchedulingPackage.Literals.JOB__REPEAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getStartTime() {
		return (XMLGregorianCalendar)eGet(SchedulingPackage.Literals.JOB__START_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartTime(XMLGregorianCalendar newStartTime) {
		eSet(SchedulingPackage.Literals.JOB__START_TIME, newStartTime);
	}

} //JobImpl
