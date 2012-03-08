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

import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Work Flow Run</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl#getEnded <em>Ended</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl#getLog <em>Log</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl#getProgress <em>Progress</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl#getProgressMessage <em>Progress Message</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl#getProgressTask <em>Progress Task</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl#getStarted <em>Started</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkFlowRunImpl extends CDOObjectImpl implements WorkFlowRun {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkFlowRunImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.WORK_FLOW_RUN;
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
	public XMLGregorianCalendar getEnded() {
		return (XMLGregorianCalendar)eGet(SchedulingPackage.Literals.WORK_FLOW_RUN__ENDED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnded(XMLGregorianCalendar newEnded) {
		eSet(SchedulingPackage.Literals.WORK_FLOW_RUN__ENDED, newEnded);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLog() {
		return (String)eGet(SchedulingPackage.Literals.WORK_FLOW_RUN__LOG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLog(String newLog) {
		eSet(SchedulingPackage.Literals.WORK_FLOW_RUN__LOG, newLog);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getProgress() {
		return (Integer)eGet(SchedulingPackage.Literals.WORK_FLOW_RUN__PROGRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProgress(int newProgress) {
		eSet(SchedulingPackage.Literals.WORK_FLOW_RUN__PROGRESS, newProgress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProgress() {
		eUnset(SchedulingPackage.Literals.WORK_FLOW_RUN__PROGRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProgress() {
		return eIsSet(SchedulingPackage.Literals.WORK_FLOW_RUN__PROGRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProgressMessage() {
		return (String)eGet(SchedulingPackage.Literals.WORK_FLOW_RUN__PROGRESS_MESSAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProgressMessage(String newProgressMessage) {
		eSet(SchedulingPackage.Literals.WORK_FLOW_RUN__PROGRESS_MESSAGE, newProgressMessage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProgressTask() {
		return (String)eGet(SchedulingPackage.Literals.WORK_FLOW_RUN__PROGRESS_TASK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProgressTask(String newProgressTask) {
		eSet(SchedulingPackage.Literals.WORK_FLOW_RUN__PROGRESS_TASK, newProgressTask);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getStarted() {
		return (XMLGregorianCalendar)eGet(SchedulingPackage.Literals.WORK_FLOW_RUN__STARTED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStarted(XMLGregorianCalendar newStarted) {
		eSet(SchedulingPackage.Literals.WORK_FLOW_RUN__STARTED, newStarted);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobRunState getState() {
		return (JobRunState)eGet(SchedulingPackage.Literals.WORK_FLOW_RUN__STATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(JobRunState newState) {
		eSet(SchedulingPackage.Literals.WORK_FLOW_RUN__STATE, newState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetState() {
		eUnset(SchedulingPackage.Literals.WORK_FLOW_RUN__STATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetState() {
		return eIsSet(SchedulingPackage.Literals.WORK_FLOW_RUN__STATE);
	}

} //WorkFlowRunImpl
