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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRun;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Job</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getJobRuns <em>Job Runs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getInterval <em>Interval</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getJobState <em>Job State</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getLastRunTime <em>Last Run Time</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getStartTime <em>Start Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JobImpl extends CDOObjectImpl implements Job {
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
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<JobRun> getJobRuns() {
		return (EList<JobRun>)eGet(SchedulingPackage.Literals.JOB__JOB_RUNS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getInterval() {
		return (Long)eGet(SchedulingPackage.Literals.JOB__INTERVAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterval(long newInterval) {
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
	public XMLGregorianCalendar getLastRunTime() {
		return (XMLGregorianCalendar)eGet(SchedulingPackage.Literals.JOB__LAST_RUN_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastRunTime(XMLGregorianCalendar newLastRunTime) {
		eSet(SchedulingPackage.Literals.JOB__LAST_RUN_TIME, newLastRunTime);
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
