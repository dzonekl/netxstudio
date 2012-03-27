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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import com.netxforge.netxstudio.generics.Base;
import com.netxforge.netxstudio.scheduling.AnalyzerJob;
import com.netxforge.netxstudio.scheduling.ComponentFailure;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.ExpressionFailure;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunContainer;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.scheduling.NodeReporterJob;
import com.netxforge.netxstudio.scheduling.NodeTypeReporterJob;
import com.netxforge.netxstudio.scheduling.OperatorReporterJob;
import com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob;
import com.netxforge.netxstudio.scheduling.RFSServiceReporterJob;
import com.netxforge.netxstudio.scheduling.RetentionJob;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.ServiceUserFailure;
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
			case SchedulingPackage.ANALYZER_JOB: {
				AnalyzerJob analyzerJob = (AnalyzerJob)theEObject;
				T result = caseAnalyzerJob(analyzerJob);
				if (result == null) result = caseJob(analyzerJob);
				if (result == null) result = caseBase(analyzerJob);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.COMPONENT_FAILURE: {
				ComponentFailure componentFailure = (ComponentFailure)theEObject;
				T result = caseComponentFailure(componentFailure);
				if (result == null) result = caseExpressionFailure(componentFailure);
				if (result == null) result = caseFailure(componentFailure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.COMPONENT_WORK_FLOW_RUN: {
				ComponentWorkFlowRun componentWorkFlowRun = (ComponentWorkFlowRun)theEObject;
				T result = caseComponentWorkFlowRun(componentWorkFlowRun);
				if (result == null) result = caseWorkFlowRun(componentWorkFlowRun);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.EXPRESSION_FAILURE: {
				ExpressionFailure expressionFailure = (ExpressionFailure)theEObject;
				T result = caseExpressionFailure(expressionFailure);
				if (result == null) result = caseFailure(expressionFailure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.FAILURE: {
				Failure failure = (Failure)theEObject;
				T result = caseFailure(failure);
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
			case SchedulingPackage.NODE_REPORTER_JOB: {
				NodeReporterJob nodeReporterJob = (NodeReporterJob)theEObject;
				T result = caseNodeReporterJob(nodeReporterJob);
				if (result == null) result = caseJob(nodeReporterJob);
				if (result == null) result = caseBase(nodeReporterJob);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.NODE_TYPE_REPORTER_JOB: {
				NodeTypeReporterJob nodeTypeReporterJob = (NodeTypeReporterJob)theEObject;
				T result = caseNodeTypeReporterJob(nodeTypeReporterJob);
				if (result == null) result = caseJob(nodeTypeReporterJob);
				if (result == null) result = caseBase(nodeTypeReporterJob);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.OPERATOR_REPORTER_JOB: {
				OperatorReporterJob operatorReporterJob = (OperatorReporterJob)theEObject;
				T result = caseOperatorReporterJob(operatorReporterJob);
				if (result == null) result = caseJob(operatorReporterJob);
				if (result == null) result = caseBase(operatorReporterJob);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.RETENTION_JOB: {
				RetentionJob retentionJob = (RetentionJob)theEObject;
				T result = caseRetentionJob(retentionJob);
				if (result == null) result = caseJob(retentionJob);
				if (result == null) result = caseBase(retentionJob);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.RFS_SERVICE_MONITORING_JOB: {
				RFSServiceMonitoringJob rfsServiceMonitoringJob = (RFSServiceMonitoringJob)theEObject;
				T result = caseRFSServiceMonitoringJob(rfsServiceMonitoringJob);
				if (result == null) result = caseJob(rfsServiceMonitoringJob);
				if (result == null) result = caseBase(rfsServiceMonitoringJob);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.RFS_SERVICE_REPORTER_JOB: {
				RFSServiceReporterJob rfsServiceReporterJob = (RFSServiceReporterJob)theEObject;
				T result = caseRFSServiceReporterJob(rfsServiceReporterJob);
				if (result == null) result = caseJob(rfsServiceReporterJob);
				if (result == null) result = caseBase(rfsServiceReporterJob);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.SERVICE_USER_FAILURE: {
				ServiceUserFailure serviceUserFailure = (ServiceUserFailure)theEObject;
				T result = caseServiceUserFailure(serviceUserFailure);
				if (result == null) result = caseExpressionFailure(serviceUserFailure);
				if (result == null) result = caseFailure(serviceUserFailure);
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
	 * Returns the result of interpreting the object as an instance of '<em>Analyzer Job</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Analyzer Job</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnalyzerJob(AnalyzerJob object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Failure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Failure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentFailure(ComponentFailure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Work Flow Run</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Work Flow Run</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentWorkFlowRun(ComponentWorkFlowRun object) {
		return null;
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
	 * Returns the result of interpreting the object as an instance of '<em>Failure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Failure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFailure(Failure object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Node Reporter Job</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Reporter Job</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeReporterJob(NodeReporterJob object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Type Reporter Job</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Type Reporter Job</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeTypeReporterJob(NodeTypeReporterJob object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator Reporter Job</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator Reporter Job</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperatorReporterJob(OperatorReporterJob object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Retention Job</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Retention Job</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRetentionJob(RetentionJob object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RFS Service Monitoring Job</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RFS Service Monitoring Job</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRFSServiceMonitoringJob(RFSServiceMonitoringJob object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RFS Service Reporter Job</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RFS Service Reporter Job</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRFSServiceReporterJob(RFSServiceReporterJob object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service User Failure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service User Failure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceUserFailure(ServiceUserFailure object) {
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
