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
import com.netxforge.netxstudio.scheduling.JobKinds;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Job</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getJobExecution <em>Job Execution</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getJobKind <em>Job Kind</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#isCurrentlyActive <em>Currently Active</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getEnded <em>Ended</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobImpl#getStarted <em>Started</em>}</li>
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
	public EList<XMLGregorianCalendar> getJobExecution() {
		return (EList<XMLGregorianCalendar>)eGet(SchedulingPackage.Literals.JOB__JOB_EXECUTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobKinds getJobKind() {
		return (JobKinds)eGet(SchedulingPackage.Literals.JOB__JOB_KIND, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJobKind(JobKinds newJobKind) {
		eSet(SchedulingPackage.Literals.JOB__JOB_KIND, newJobKind);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetJobKind() {
		eUnset(SchedulingPackage.Literals.JOB__JOB_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetJobKind() {
		return eIsSet(SchedulingPackage.Literals.JOB__JOB_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCurrentlyActive() {
		return (Boolean)eGet(SchedulingPackage.Literals.JOB__CURRENTLY_ACTIVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentlyActive(boolean newCurrentlyActive) {
		eSet(SchedulingPackage.Literals.JOB__CURRENTLY_ACTIVE, newCurrentlyActive);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurrentlyActive() {
		eUnset(SchedulingPackage.Literals.JOB__CURRENTLY_ACTIVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurrentlyActive() {
		return eIsSet(SchedulingPackage.Literals.JOB__CURRENTLY_ACTIVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getEnded() {
		return (XMLGregorianCalendar)eGet(SchedulingPackage.Literals.JOB__ENDED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnded(XMLGregorianCalendar newEnded) {
		eSet(SchedulingPackage.Literals.JOB__ENDED, newEnded);
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
	public XMLGregorianCalendar getStarted() {
		return (XMLGregorianCalendar)eGet(SchedulingPackage.Literals.JOB__STARTED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStarted(XMLGregorianCalendar newStarted) {
		eSet(SchedulingPackage.Literals.JOB__STARTED, newStarted);
	}

} //JobImpl
