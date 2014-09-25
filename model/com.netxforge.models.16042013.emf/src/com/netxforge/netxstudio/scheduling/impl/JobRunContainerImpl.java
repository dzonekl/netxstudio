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

import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunContainer;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Job Run Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobRunContainerImpl#getJob <em>Job</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.JobRunContainerImpl#getWorkFlowRuns <em>Work Flow Runs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JobRunContainerImpl extends MinimalEObjectImpl.Container implements JobRunContainer {
	/**
	 * The cached value of the '{@link #getJob() <em>Job</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJob()
	 * @generated
	 * @ordered
	 */
	protected Job job;

	/**
	 * The cached value of the '{@link #getWorkFlowRuns() <em>Work Flow Runs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkFlowRuns()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkFlowRun> workFlowRuns;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JobRunContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.JOB_RUN_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Job getJob() {
		if (job != null && job.eIsProxy()) {
			InternalEObject oldJob = (InternalEObject)job;
			job = (Job)eResolveProxy(oldJob);
			if (job != oldJob) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulingPackage.JOB_RUN_CONTAINER__JOB, oldJob, job));
			}
		}
		return job;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Job basicGetJob() {
		return job;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJob(Job newJob) {
		Job oldJob = job;
		job = newJob;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.JOB_RUN_CONTAINER__JOB, oldJob, job));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkFlowRun> getWorkFlowRuns() {
		if (workFlowRuns == null) {
			workFlowRuns = new EObjectContainmentEList<WorkFlowRun>(WorkFlowRun.class, this, SchedulingPackage.JOB_RUN_CONTAINER__WORK_FLOW_RUNS);
		}
		return workFlowRuns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulingPackage.JOB_RUN_CONTAINER__WORK_FLOW_RUNS:
				return ((InternalEList<?>)getWorkFlowRuns()).basicRemove(otherEnd, msgs);
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
			case SchedulingPackage.JOB_RUN_CONTAINER__JOB:
				if (resolve) return getJob();
				return basicGetJob();
			case SchedulingPackage.JOB_RUN_CONTAINER__WORK_FLOW_RUNS:
				return getWorkFlowRuns();
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
			case SchedulingPackage.JOB_RUN_CONTAINER__JOB:
				setJob((Job)newValue);
				return;
			case SchedulingPackage.JOB_RUN_CONTAINER__WORK_FLOW_RUNS:
				getWorkFlowRuns().clear();
				getWorkFlowRuns().addAll((Collection<? extends WorkFlowRun>)newValue);
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
			case SchedulingPackage.JOB_RUN_CONTAINER__JOB:
				setJob((Job)null);
				return;
			case SchedulingPackage.JOB_RUN_CONTAINER__WORK_FLOW_RUNS:
				getWorkFlowRuns().clear();
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
			case SchedulingPackage.JOB_RUN_CONTAINER__JOB:
				return job != null;
			case SchedulingPackage.JOB_RUN_CONTAINER__WORK_FLOW_RUNS:
				return workFlowRuns != null && !workFlowRuns.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //JobRunContainerImpl
