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
package com.netxforge.netxstudio.scheduling.util;

import com.netxforge.netxstudio.generics.Base;
import com.netxforge.netxstudio.scheduling.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import com.netxforge.netxstudio.scheduling.ExpressionFailure;
import com.netxforge.netxstudio.scheduling.ExpressionWorkFlowRun;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunContainer;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.scheduling.RFSServiceJob;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage
 * @generated
 */
public class SchedulingSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SchedulingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingSwitch() {
		if (modelPackage == null) {
			modelPackage = SchedulingPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SchedulingPackage.EXPRESSION_FAILURE: {
				ExpressionFailure expressionFailure = (ExpressionFailure)theEObject;
				T result = caseExpressionFailure(expressionFailure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.EXPRESSION_WORK_FLOW_RUN: {
				ExpressionWorkFlowRun expressionWorkFlowRun = (ExpressionWorkFlowRun)theEObject;
				T result = caseExpressionWorkFlowRun(expressionWorkFlowRun);
				if (result == null) result = caseWorkFlowRun(expressionWorkFlowRun);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.JOB: {
				Job job = (Job)theEObject;
				T result = caseJob(job);
				if (result == null) result = caseBase(job);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.JOB_RUN_CONTAINER: {
				JobRunContainer jobRunContainer = (JobRunContainer)theEObject;
				T result = caseJobRunContainer(jobRunContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.METRIC_SOURCE_JOB: {
				MetricSourceJob metricSourceJob = (MetricSourceJob)theEObject;
				T result = caseMetricSourceJob(metricSourceJob);
				if (result == null) result = caseJob(metricSourceJob);
				if (result == null) result = caseBase(metricSourceJob);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.RFS_SERVICE_JOB: {
				RFSServiceJob rfsServiceJob = (RFSServiceJob)theEObject;
				T result = caseRFSServiceJob(rfsServiceJob);
				if (result == null) result = caseJob(rfsServiceJob);
				if (result == null) result = caseBase(rfsServiceJob);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.RFS_SERVICE_RETENTION_JOB: {
				RFSServiceRetentionJob rfsServiceRetentionJob = (RFSServiceRetentionJob)theEObject;
				T result = caseRFSServiceRetentionJob(rfsServiceRetentionJob);
				if (result == null) result = caseJob(rfsServiceRetentionJob);
				if (result == null) result = caseBase(rfsServiceRetentionJob);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.WORK_FLOW_RUN: {
				WorkFlowRun workFlowRun = (WorkFlowRun)theEObject;
				T result = caseWorkFlowRun(workFlowRun);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Failure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Failure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionFailure(ExpressionFailure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Work Flow Run</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Work Flow Run</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionWorkFlowRun(ExpressionWorkFlowRun object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Job</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Job</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJob(Job object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Job Run Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Job Run Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJobRunContainer(JobRunContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metric Source Job</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metric Source Job</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetricSourceJob(MetricSourceJob object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RFS Service Job</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RFS Service Job</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRFSServiceJob(RFSServiceJob object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RFS Service Retention Job</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RFS Service Retention Job</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRFSServiceRetentionJob(RFSServiceRetentionJob object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Work Flow Run</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Work Flow Run</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkFlowRun(WorkFlowRun object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBase(Base object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SchedulingSwitch
