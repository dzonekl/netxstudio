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

import com.netxforge.netxstudio.scheduling.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.netxforge.netxstudio.scheduling.ExpressionFailure;
import com.netxforge.netxstudio.scheduling.ExpressionWorkFlowRun;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunContainer;
import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.scheduling.RFSServiceJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulingFactoryImpl extends EFactoryImpl implements SchedulingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SchedulingFactory init() {
		try {
			SchedulingFactory theSchedulingFactory = (SchedulingFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.netxforge.com/13042011/scheduling"); 
			if (theSchedulingFactory != null) {
				return theSchedulingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SchedulingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SchedulingPackage.EXPRESSION_FAILURE: return (EObject)createExpressionFailure();
			case SchedulingPackage.EXPRESSION_WORK_FLOW_RUN: return (EObject)createExpressionWorkFlowRun();
			case SchedulingPackage.JOB: return (EObject)createJob();
			case SchedulingPackage.JOB_RUN_CONTAINER: return (EObject)createJobRunContainer();
			case SchedulingPackage.METRIC_SOURCE_JOB: return (EObject)createMetricSourceJob();
			case SchedulingPackage.RFS_SERVICE_JOB: return (EObject)createRFSServiceJob();
			case SchedulingPackage.RFS_SERVICE_RETENTION_JOB: return (EObject)createRFSServiceRetentionJob();
			case SchedulingPackage.WORK_FLOW_RUN: return (EObject)createWorkFlowRun();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SchedulingPackage.JOB_RUN_STATE:
				return createJobRunStateFromString(eDataType, initialValue);
			case SchedulingPackage.JOB_STATE:
				return createJobStateFromString(eDataType, initialValue);
			case SchedulingPackage.JOB_RUN_STATE_OBJECT:
				return createJobRunStateObjectFromString(eDataType, initialValue);
			case SchedulingPackage.JOB_STATE_OBJECT:
				return createJobStateObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SchedulingPackage.JOB_RUN_STATE:
				return convertJobRunStateToString(eDataType, instanceValue);
			case SchedulingPackage.JOB_STATE:
				return convertJobStateToString(eDataType, instanceValue);
			case SchedulingPackage.JOB_RUN_STATE_OBJECT:
				return convertJobRunStateObjectToString(eDataType, instanceValue);
			case SchedulingPackage.JOB_STATE_OBJECT:
				return convertJobStateObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionFailure createExpressionFailure() {
		ExpressionFailureImpl expressionFailure = new ExpressionFailureImpl();
		return expressionFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionWorkFlowRun createExpressionWorkFlowRun() {
		ExpressionWorkFlowRunImpl expressionWorkFlowRun = new ExpressionWorkFlowRunImpl();
		return expressionWorkFlowRun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Job createJob() {
		JobImpl job = new JobImpl();
		return job;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobRunContainer createJobRunContainer() {
		JobRunContainerImpl jobRunContainer = new JobRunContainerImpl();
		return jobRunContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricSourceJob createMetricSourceJob() {
		MetricSourceJobImpl metricSourceJob = new MetricSourceJobImpl();
		return metricSourceJob;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RFSServiceJob createRFSServiceJob() {
		RFSServiceJobImpl rfsServiceJob = new RFSServiceJobImpl();
		return rfsServiceJob;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RFSServiceRetentionJob createRFSServiceRetentionJob() {
		RFSServiceRetentionJobImpl rfsServiceRetentionJob = new RFSServiceRetentionJobImpl();
		return rfsServiceRetentionJob;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkFlowRun createWorkFlowRun() {
		WorkFlowRunImpl workFlowRun = new WorkFlowRunImpl();
		return workFlowRun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobRunState createJobRunStateFromString(EDataType eDataType, String initialValue) {
		JobRunState result = JobRunState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJobRunStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobState createJobStateFromString(EDataType eDataType, String initialValue) {
		JobState result = JobState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJobStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobRunState createJobRunStateObjectFromString(EDataType eDataType, String initialValue) {
		return createJobRunStateFromString(SchedulingPackage.Literals.JOB_RUN_STATE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJobRunStateObjectToString(EDataType eDataType, Object instanceValue) {
		return convertJobRunStateToString(SchedulingPackage.Literals.JOB_RUN_STATE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobState createJobStateObjectFromString(EDataType eDataType, String initialValue) {
		return createJobStateFromString(SchedulingPackage.Literals.JOB_STATE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJobStateObjectToString(EDataType eDataType, Object instanceValue) {
		return convertJobStateToString(SchedulingPackage.Literals.JOB_STATE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingPackage getSchedulingPackage() {
		return (SchedulingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SchedulingPackage getPackage() {
		return SchedulingPackage.eINSTANCE;
	}

} //SchedulingFactoryImpl
