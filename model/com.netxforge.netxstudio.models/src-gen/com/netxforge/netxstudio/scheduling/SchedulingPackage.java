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
package com.netxforge.netxstudio.scheduling;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.netxforge.netxstudio.generics.GenericsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 * 
 * 			Network Data schema Copyright 2008 The schema uses
 * 			ecore
 * 			references syntax, but should easily map into an SQL schema.
 * 			The
 * 			ecore
 * 			references, are mapped into ORM specific DLL (See
 * 			Hibernate or
 * 			other
 * 			ORM. EMF/Hibernate
 * 			however uses a custom mechanism.
 * 
 * 			Don't use
 * 			the
 * 			word
 * 			"Item", as this is appended to the Object
 * 			name in the EMF
 * 			edit
 * 			model.
 * 
 * 			Validation with pattern is not used, considering the limited
 * 			capabilities of
 * 			XSD patterns.
 * 
 * 		
 * 
 * 
 * 			Network Data schema Copyright 2008 The schema uses
 * 			ecore
 * 			references syntax, but should easily map into an SQL schema.
 * 			The
 * 			ecore
 * 			references, are mapped into ORM specific DLL (See
 * 			Hibernate or
 * 			other
 * 			ORM. EMF/Hibernate
 * 			however uses a custom mechanism.
 * 
 * 			Don't use
 * 			the
 * 			word
 * 			"Item", as this is appended to the Object
 * 			name in the EMF
 * 			edit
 * 			model.
 * 
 * 			Validation with pattern is not used, considering the limited
 * 			capabilities of
 * 			XSD patterns.
 * 
 * 		
 * 
 * 		
 * <!-- end-model-doc -->
 * @see com.netxforge.netxstudio.scheduling.SchedulingFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL' invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface SchedulingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scheduling";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.netxforge.com/13042011/scheduling";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "scheduling";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchedulingPackage eINSTANCE = com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.ExpressionFailureImpl <em>Expression Failure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.ExpressionFailureImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getExpressionFailure()
	 * @generated
	 */
	int EXPRESSION_FAILURE = 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl <em>Work Flow Run</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getWorkFlowRun()
	 * @generated
	 */
	int WORK_FLOW_RUN = 15;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.JobImpl <em>Job</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.JobImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJob()
	 * @generated
	 */
	int JOB = 5;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__END_TIME = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__INTERVAL = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Job State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__JOB_STATE = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__NAME = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__REPEAT = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__START_TIME = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Job</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.AnalyzerJobImpl <em>Analyzer Job</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.AnalyzerJobImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getAnalyzerJob()
	 * @generated
	 */
	int ANALYZER_JOB = 0;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZER_JOB__DELETED = JOB__DELETED;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZER_JOB__END_TIME = JOB__END_TIME;

	/**
	 * The feature id for the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZER_JOB__INTERVAL = JOB__INTERVAL;

	/**
	 * The feature id for the '<em><b>Job State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZER_JOB__JOB_STATE = JOB__JOB_STATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZER_JOB__NAME = JOB__NAME;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZER_JOB__REPEAT = JOB__REPEAT;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZER_JOB__START_TIME = JOB__START_TIME;

	/**
	 * The feature id for the '<em><b>RFS Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZER_JOB__RFS_SERVICE = JOB_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Analyzer Job</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZER_JOB_FEATURE_COUNT = JOB_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.FailureImpl <em>Failure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.FailureImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getFailure()
	 * @generated
	 */
	int FAILURE = 4;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE__MESSAGE = 0;

	/**
	 * The number of structural features of the '<em>Failure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.ComponentFailureImpl <em>Component Failure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.ComponentFailureImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getComponentFailure()
	 * @generated
	 */
	int COMPONENT_FAILURE = 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.ComponentWorkFlowRunImpl <em>Component Work Flow Run</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.ComponentWorkFlowRunImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getComponentWorkFlowRun()
	 * @generated
	 */
	int COMPONENT_WORK_FLOW_RUN = 2;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FAILURE__MESSAGE = FAILURE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FAILURE__EXPRESSION_REF = FAILURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Failure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FAILURE_FEATURE_COUNT = FAILURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FAILURE__MESSAGE = EXPRESSION_FAILURE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FAILURE__EXPRESSION_REF = EXPRESSION_FAILURE__EXPRESSION_REF;

	/**
	 * The feature id for the '<em><b>Component Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FAILURE__COMPONENT_REF = EXPRESSION_FAILURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component Failure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FAILURE_FEATURE_COUNT = EXPRESSION_FAILURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ended</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_RUN__ENDED = 0;

	/**
	 * The feature id for the '<em><b>Log</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_RUN__LOG = 1;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_RUN__PROGRESS = 2;

	/**
	 * The feature id for the '<em><b>Progress Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_RUN__PROGRESS_MESSAGE = 3;

	/**
	 * The feature id for the '<em><b>Progress Task</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_RUN__PROGRESS_TASK = 4;

	/**
	 * The feature id for the '<em><b>Started</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_RUN__STARTED = 5;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_RUN__STATE = 6;

	/**
	 * The number of structural features of the '<em>Work Flow Run</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_FLOW_RUN_FEATURE_COUNT = 7;

	/**
	 * The feature id for the '<em><b>Ended</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_WORK_FLOW_RUN__ENDED = WORK_FLOW_RUN__ENDED;

	/**
	 * The feature id for the '<em><b>Log</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_WORK_FLOW_RUN__LOG = WORK_FLOW_RUN__LOG;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_WORK_FLOW_RUN__PROGRESS = WORK_FLOW_RUN__PROGRESS;

	/**
	 * The feature id for the '<em><b>Progress Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_WORK_FLOW_RUN__PROGRESS_MESSAGE = WORK_FLOW_RUN__PROGRESS_MESSAGE;

	/**
	 * The feature id for the '<em><b>Progress Task</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_WORK_FLOW_RUN__PROGRESS_TASK = WORK_FLOW_RUN__PROGRESS_TASK;

	/**
	 * The feature id for the '<em><b>Started</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_WORK_FLOW_RUN__STARTED = WORK_FLOW_RUN__STARTED;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_WORK_FLOW_RUN__STATE = WORK_FLOW_RUN__STATE;

	/**
	 * The feature id for the '<em><b>Failure Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_WORK_FLOW_RUN__FAILURE_REFS = WORK_FLOW_RUN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component Work Flow Run</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_WORK_FLOW_RUN_FEATURE_COUNT = WORK_FLOW_RUN_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.JobRunContainerImpl <em>Job Run Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.JobRunContainerImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobRunContainer()
	 * @generated
	 */
	int JOB_RUN_CONTAINER = 6;

	/**
	 * The feature id for the '<em><b>Job</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_RUN_CONTAINER__JOB = 0;

	/**
	 * The feature id for the '<em><b>Work Flow Runs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_RUN_CONTAINER__WORK_FLOW_RUNS = 1;

	/**
	 * The number of structural features of the '<em>Job Run Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_RUN_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.MetricSourceJobImpl <em>Metric Source Job</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.MetricSourceJobImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getMetricSourceJob()
	 * @generated
	 */
	int METRIC_SOURCE_JOB = 7;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE_JOB__DELETED = JOB__DELETED;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE_JOB__END_TIME = JOB__END_TIME;

	/**
	 * The feature id for the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE_JOB__INTERVAL = JOB__INTERVAL;

	/**
	 * The feature id for the '<em><b>Job State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE_JOB__JOB_STATE = JOB__JOB_STATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE_JOB__NAME = JOB__NAME;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE_JOB__REPEAT = JOB__REPEAT;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE_JOB__START_TIME = JOB__START_TIME;

	/**
	 * The feature id for the '<em><b>Metric Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE_JOB__METRIC_SOURCE = JOB_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Metric Source Job</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE_JOB_FEATURE_COUNT = JOB_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.NodeReporterJobImpl <em>Node Reporter Job</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.NodeReporterJobImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getNodeReporterJob()
	 * @generated
	 */
	int NODE_REPORTER_JOB = 8;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_REPORTER_JOB__DELETED = JOB__DELETED;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_REPORTER_JOB__END_TIME = JOB__END_TIME;

	/**
	 * The feature id for the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_REPORTER_JOB__INTERVAL = JOB__INTERVAL;

	/**
	 * The feature id for the '<em><b>Job State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_REPORTER_JOB__JOB_STATE = JOB__JOB_STATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_REPORTER_JOB__NAME = JOB__NAME;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_REPORTER_JOB__REPEAT = JOB__REPEAT;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_REPORTER_JOB__START_TIME = JOB__START_TIME;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_REPORTER_JOB__NODE = JOB_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node Reporter Job</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_REPORTER_JOB_FEATURE_COUNT = JOB_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.NodeTypeReporterJobImpl <em>Node Type Reporter Job</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.NodeTypeReporterJobImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getNodeTypeReporterJob()
	 * @generated
	 */
	int NODE_TYPE_REPORTER_JOB = 9;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_REPORTER_JOB__DELETED = JOB__DELETED;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_REPORTER_JOB__END_TIME = JOB__END_TIME;

	/**
	 * The feature id for the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_REPORTER_JOB__INTERVAL = JOB__INTERVAL;

	/**
	 * The feature id for the '<em><b>Job State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_REPORTER_JOB__JOB_STATE = JOB__JOB_STATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_REPORTER_JOB__NAME = JOB__NAME;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_REPORTER_JOB__REPEAT = JOB__REPEAT;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_REPORTER_JOB__START_TIME = JOB__START_TIME;

	/**
	 * The feature id for the '<em><b>Node Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_REPORTER_JOB__NODE_TYPE = JOB_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node Type Reporter Job</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_REPORTER_JOB_FEATURE_COUNT = JOB_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.OperatorReporterJobImpl <em>Operator Reporter Job</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.OperatorReporterJobImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getOperatorReporterJob()
	 * @generated
	 */
	int OPERATOR_REPORTER_JOB = 10;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_REPORTER_JOB__DELETED = JOB__DELETED;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_REPORTER_JOB__END_TIME = JOB__END_TIME;

	/**
	 * The feature id for the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_REPORTER_JOB__INTERVAL = JOB__INTERVAL;

	/**
	 * The feature id for the '<em><b>Job State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_REPORTER_JOB__JOB_STATE = JOB__JOB_STATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_REPORTER_JOB__NAME = JOB__NAME;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_REPORTER_JOB__REPEAT = JOB__REPEAT;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_REPORTER_JOB__START_TIME = JOB__START_TIME;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_REPORTER_JOB__OPERATOR = JOB_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operator Reporter Job</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_REPORTER_JOB_FEATURE_COUNT = JOB_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.RFSServiceMonitoringJobImpl <em>RFS Service Monitoring Job</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.RFSServiceMonitoringJobImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getRFSServiceMonitoringJob()
	 * @generated
	 */
	int RFS_SERVICE_MONITORING_JOB = 11;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_MONITORING_JOB__DELETED = JOB__DELETED;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_MONITORING_JOB__END_TIME = JOB__END_TIME;

	/**
	 * The feature id for the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_MONITORING_JOB__INTERVAL = JOB__INTERVAL;

	/**
	 * The feature id for the '<em><b>Job State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_MONITORING_JOB__JOB_STATE = JOB__JOB_STATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_MONITORING_JOB__NAME = JOB__NAME;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_MONITORING_JOB__REPEAT = JOB__REPEAT;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_MONITORING_JOB__START_TIME = JOB__START_TIME;

	/**
	 * The feature id for the '<em><b>RFS Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_MONITORING_JOB__RFS_SERVICE = JOB_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>RFS Service Monitoring Job</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_MONITORING_JOB_FEATURE_COUNT = JOB_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.RFSServiceReporterJobImpl <em>RFS Service Reporter Job</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.RFSServiceReporterJobImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getRFSServiceReporterJob()
	 * @generated
	 */
	int RFS_SERVICE_REPORTER_JOB = 12;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_REPORTER_JOB__DELETED = JOB__DELETED;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_REPORTER_JOB__END_TIME = JOB__END_TIME;

	/**
	 * The feature id for the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_REPORTER_JOB__INTERVAL = JOB__INTERVAL;

	/**
	 * The feature id for the '<em><b>Job State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_REPORTER_JOB__JOB_STATE = JOB__JOB_STATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_REPORTER_JOB__NAME = JOB__NAME;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_REPORTER_JOB__REPEAT = JOB__REPEAT;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_REPORTER_JOB__START_TIME = JOB__START_TIME;

	/**
	 * The feature id for the '<em><b>RFS Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_REPORTER_JOB__RFS_SERVICE = JOB_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>RFS Service Reporter Job</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_REPORTER_JOB_FEATURE_COUNT = JOB_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.RFSServiceRetentionJobImpl <em>RFS Service Retention Job</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.RFSServiceRetentionJobImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getRFSServiceRetentionJob()
	 * @generated
	 */
	int RFS_SERVICE_RETENTION_JOB = 13;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_RETENTION_JOB__DELETED = JOB__DELETED;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_RETENTION_JOB__END_TIME = JOB__END_TIME;

	/**
	 * The feature id for the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_RETENTION_JOB__INTERVAL = JOB__INTERVAL;

	/**
	 * The feature id for the '<em><b>Job State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_RETENTION_JOB__JOB_STATE = JOB__JOB_STATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_RETENTION_JOB__NAME = JOB__NAME;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_RETENTION_JOB__REPEAT = JOB__REPEAT;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_RETENTION_JOB__START_TIME = JOB__START_TIME;

	/**
	 * The feature id for the '<em><b>RFS Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_RETENTION_JOB__RFS_SERVICE = JOB_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>RFS Service Retention Job</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_SERVICE_RETENTION_JOB_FEATURE_COUNT = JOB_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.ServiceUserFailureImpl <em>Service User Failure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.ServiceUserFailureImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getServiceUserFailure()
	 * @generated
	 */
	int SERVICE_USER_FAILURE = 14;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_USER_FAILURE__MESSAGE = EXPRESSION_FAILURE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_USER_FAILURE__EXPRESSION_REF = EXPRESSION_FAILURE__EXPRESSION_REF;

	/**
	 * The feature id for the '<em><b>Service User Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_USER_FAILURE__SERVICE_USER_REF = EXPRESSION_FAILURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Service User Failure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_USER_FAILURE_FEATURE_COUNT = EXPRESSION_FAILURE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.JobRunState <em>Job Run State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.JobRunState
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobRunState()
	 * @generated
	 */
	int JOB_RUN_STATE = 16;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.JobState <em>Job State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.JobState
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobState()
	 * @generated
	 */
	int JOB_STATE = 17;

	/**
	 * The meta object id for the '<em>Job Run State Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.JobRunState
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobRunStateObject()
	 * @generated
	 */
	int JOB_RUN_STATE_OBJECT = 18;

	/**
	 * The meta object id for the '<em>Job State Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.JobState
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobStateObject()
	 * @generated
	 */
	int JOB_STATE_OBJECT = 19;

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.AnalyzerJob <em>Analyzer Job</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Analyzer Job</em>'.
	 * @see com.netxforge.netxstudio.scheduling.AnalyzerJob
	 * @generated
	 */
	EClass getAnalyzerJob();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.scheduling.AnalyzerJob#getRFSService <em>RFS Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>RFS Service</em>'.
	 * @see com.netxforge.netxstudio.scheduling.AnalyzerJob#getRFSService()
	 * @see #getAnalyzerJob()
	 * @generated
	 */
	EReference getAnalyzerJob_RFSService();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.ComponentFailure <em>Component Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Failure</em>'.
	 * @see com.netxforge.netxstudio.scheduling.ComponentFailure
	 * @generated
	 */
	EClass getComponentFailure();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.scheduling.ComponentFailure#getComponentRef <em>Component Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component Ref</em>'.
	 * @see com.netxforge.netxstudio.scheduling.ComponentFailure#getComponentRef()
	 * @see #getComponentFailure()
	 * @generated
	 */
	EReference getComponentFailure_ComponentRef();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun <em>Component Work Flow Run</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Work Flow Run</em>'.
	 * @see com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun
	 * @generated
	 */
	EClass getComponentWorkFlowRun();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun#getFailureRefs <em>Failure Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Failure Refs</em>'.
	 * @see com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun#getFailureRefs()
	 * @see #getComponentWorkFlowRun()
	 * @generated
	 */
	EReference getComponentWorkFlowRun_FailureRefs();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.ExpressionFailure <em>Expression Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Failure</em>'.
	 * @see com.netxforge.netxstudio.scheduling.ExpressionFailure
	 * @generated
	 */
	EClass getExpressionFailure();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.scheduling.ExpressionFailure#getExpressionRef <em>Expression Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression Ref</em>'.
	 * @see com.netxforge.netxstudio.scheduling.ExpressionFailure#getExpressionRef()
	 * @see #getExpressionFailure()
	 * @generated
	 */
	EReference getExpressionFailure_ExpressionRef();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.Failure <em>Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Failure</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Failure
	 * @generated
	 */
	EClass getFailure();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.Failure#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Failure#getMessage()
	 * @see #getFailure()
	 * @generated
	 */
	EAttribute getFailure_Message();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.Job <em>Job</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Job</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Job
	 * @generated
	 */
	EClass getJob();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.Job#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Time</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Job#getEndTime()
	 * @see #getJob()
	 * @generated
	 */
	EAttribute getJob_EndTime();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.Job#getInterval <em>Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interval</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Job#getInterval()
	 * @see #getJob()
	 * @generated
	 */
	EAttribute getJob_Interval();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.Job#getJobState <em>Job State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Job State</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Job#getJobState()
	 * @see #getJob()
	 * @generated
	 */
	EAttribute getJob_JobState();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.Job#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Job#getName()
	 * @see #getJob()
	 * @generated
	 */
	EAttribute getJob_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.Job#getRepeat <em>Repeat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repeat</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Job#getRepeat()
	 * @see #getJob()
	 * @generated
	 */
	EAttribute getJob_Repeat();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.Job#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Job#getStartTime()
	 * @see #getJob()
	 * @generated
	 */
	EAttribute getJob_StartTime();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.JobRunContainer <em>Job Run Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Job Run Container</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobRunContainer
	 * @generated
	 */
	EClass getJobRunContainer();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.scheduling.JobRunContainer#getJob <em>Job</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Job</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobRunContainer#getJob()
	 * @see #getJobRunContainer()
	 * @generated
	 */
	EReference getJobRunContainer_Job();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.scheduling.JobRunContainer#getWorkFlowRuns <em>Work Flow Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Work Flow Runs</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobRunContainer#getWorkFlowRuns()
	 * @see #getJobRunContainer()
	 * @generated
	 */
	EReference getJobRunContainer_WorkFlowRuns();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.MetricSourceJob <em>Metric Source Job</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Source Job</em>'.
	 * @see com.netxforge.netxstudio.scheduling.MetricSourceJob
	 * @generated
	 */
	EClass getMetricSourceJob();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.scheduling.MetricSourceJob#getMetricSource <em>Metric Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metric Source</em>'.
	 * @see com.netxforge.netxstudio.scheduling.MetricSourceJob#getMetricSource()
	 * @see #getMetricSourceJob()
	 * @generated
	 */
	EReference getMetricSourceJob_MetricSource();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.NodeReporterJob <em>Node Reporter Job</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Reporter Job</em>'.
	 * @see com.netxforge.netxstudio.scheduling.NodeReporterJob
	 * @generated
	 */
	EClass getNodeReporterJob();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.scheduling.NodeReporterJob#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node</em>'.
	 * @see com.netxforge.netxstudio.scheduling.NodeReporterJob#getNode()
	 * @see #getNodeReporterJob()
	 * @generated
	 */
	EReference getNodeReporterJob_Node();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.NodeTypeReporterJob <em>Node Type Reporter Job</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Type Reporter Job</em>'.
	 * @see com.netxforge.netxstudio.scheduling.NodeTypeReporterJob
	 * @generated
	 */
	EClass getNodeTypeReporterJob();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.scheduling.NodeTypeReporterJob#getNodeType <em>Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node Type</em>'.
	 * @see com.netxforge.netxstudio.scheduling.NodeTypeReporterJob#getNodeType()
	 * @see #getNodeTypeReporterJob()
	 * @generated
	 */
	EReference getNodeTypeReporterJob_NodeType();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.OperatorReporterJob <em>Operator Reporter Job</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator Reporter Job</em>'.
	 * @see com.netxforge.netxstudio.scheduling.OperatorReporterJob
	 * @generated
	 */
	EClass getOperatorReporterJob();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.scheduling.OperatorReporterJob#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operator</em>'.
	 * @see com.netxforge.netxstudio.scheduling.OperatorReporterJob#getOperator()
	 * @see #getOperatorReporterJob()
	 * @generated
	 */
	EReference getOperatorReporterJob_Operator();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob <em>RFS Service Monitoring Job</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>RFS Service Monitoring Job</em>'.
	 * @see com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob
	 * @generated
	 */
	EClass getRFSServiceMonitoringJob();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob#getRFSService <em>RFS Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>RFS Service</em>'.
	 * @see com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob#getRFSService()
	 * @see #getRFSServiceMonitoringJob()
	 * @generated
	 */
	EReference getRFSServiceMonitoringJob_RFSService();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.RFSServiceReporterJob <em>RFS Service Reporter Job</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>RFS Service Reporter Job</em>'.
	 * @see com.netxforge.netxstudio.scheduling.RFSServiceReporterJob
	 * @generated
	 */
	EClass getRFSServiceReporterJob();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.scheduling.RFSServiceReporterJob#getRFSService <em>RFS Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>RFS Service</em>'.
	 * @see com.netxforge.netxstudio.scheduling.RFSServiceReporterJob#getRFSService()
	 * @see #getRFSServiceReporterJob()
	 * @generated
	 */
	EReference getRFSServiceReporterJob_RFSService();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.RFSServiceRetentionJob <em>RFS Service Retention Job</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>RFS Service Retention Job</em>'.
	 * @see com.netxforge.netxstudio.scheduling.RFSServiceRetentionJob
	 * @generated
	 */
	EClass getRFSServiceRetentionJob();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.scheduling.RFSServiceRetentionJob#getRFSService <em>RFS Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>RFS Service</em>'.
	 * @see com.netxforge.netxstudio.scheduling.RFSServiceRetentionJob#getRFSService()
	 * @see #getRFSServiceRetentionJob()
	 * @generated
	 */
	EReference getRFSServiceRetentionJob_RFSService();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.ServiceUserFailure <em>Service User Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service User Failure</em>'.
	 * @see com.netxforge.netxstudio.scheduling.ServiceUserFailure
	 * @generated
	 */
	EClass getServiceUserFailure();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.scheduling.ServiceUserFailure#getServiceUserRef <em>Service User Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Service User Ref</em>'.
	 * @see com.netxforge.netxstudio.scheduling.ServiceUserFailure#getServiceUserRef()
	 * @see #getServiceUserFailure()
	 * @generated
	 */
	EReference getServiceUserFailure_ServiceUserRef();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.WorkFlowRun <em>Work Flow Run</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Work Flow Run</em>'.
	 * @see com.netxforge.netxstudio.scheduling.WorkFlowRun
	 * @generated
	 */
	EClass getWorkFlowRun();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.WorkFlowRun#getEnded <em>Ended</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ended</em>'.
	 * @see com.netxforge.netxstudio.scheduling.WorkFlowRun#getEnded()
	 * @see #getWorkFlowRun()
	 * @generated
	 */
	EAttribute getWorkFlowRun_Ended();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.WorkFlowRun#getLog <em>Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log</em>'.
	 * @see com.netxforge.netxstudio.scheduling.WorkFlowRun#getLog()
	 * @see #getWorkFlowRun()
	 * @generated
	 */
	EAttribute getWorkFlowRun_Log();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.WorkFlowRun#getProgress <em>Progress</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Progress</em>'.
	 * @see com.netxforge.netxstudio.scheduling.WorkFlowRun#getProgress()
	 * @see #getWorkFlowRun()
	 * @generated
	 */
	EAttribute getWorkFlowRun_Progress();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.WorkFlowRun#getProgressMessage <em>Progress Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Progress Message</em>'.
	 * @see com.netxforge.netxstudio.scheduling.WorkFlowRun#getProgressMessage()
	 * @see #getWorkFlowRun()
	 * @generated
	 */
	EAttribute getWorkFlowRun_ProgressMessage();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.WorkFlowRun#getProgressTask <em>Progress Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Progress Task</em>'.
	 * @see com.netxforge.netxstudio.scheduling.WorkFlowRun#getProgressTask()
	 * @see #getWorkFlowRun()
	 * @generated
	 */
	EAttribute getWorkFlowRun_ProgressTask();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.WorkFlowRun#getStarted <em>Started</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Started</em>'.
	 * @see com.netxforge.netxstudio.scheduling.WorkFlowRun#getStarted()
	 * @see #getWorkFlowRun()
	 * @generated
	 */
	EAttribute getWorkFlowRun_Started();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.WorkFlowRun#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see com.netxforge.netxstudio.scheduling.WorkFlowRun#getState()
	 * @see #getWorkFlowRun()
	 * @generated
	 */
	EAttribute getWorkFlowRun_State();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.scheduling.JobRunState <em>Job Run State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Job Run State</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobRunState
	 * @generated
	 */
	EEnum getJobRunState();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.scheduling.JobState <em>Job State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Job State</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobState
	 * @generated
	 */
	EEnum getJobState();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.scheduling.JobRunState <em>Job Run State Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Job Run State Object</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobRunState
	 * @model instanceClass="com.netxforge.netxstudio.scheduling.JobRunState"
	 *        extendedMetaData="name='JobRunState:Object' baseType='JobRunState'"
	 * @generated
	 */
	EDataType getJobRunStateObject();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.scheduling.JobState <em>Job State Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Job State Object</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobState
	 * @model instanceClass="com.netxforge.netxstudio.scheduling.JobState"
	 *        extendedMetaData="name='JobState:Object' baseType='JobState'"
	 * @generated
	 */
	EDataType getJobStateObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SchedulingFactory getSchedulingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.AnalyzerJobImpl <em>Analyzer Job</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.AnalyzerJobImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getAnalyzerJob()
		 * @generated
		 */
		EClass ANALYZER_JOB = eINSTANCE.getAnalyzerJob();

		/**
		 * The meta object literal for the '<em><b>RFS Service</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYZER_JOB__RFS_SERVICE = eINSTANCE.getAnalyzerJob_RFSService();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.ComponentFailureImpl <em>Component Failure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.ComponentFailureImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getComponentFailure()
		 * @generated
		 */
		EClass COMPONENT_FAILURE = eINSTANCE.getComponentFailure();

		/**
		 * The meta object literal for the '<em><b>Component Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_FAILURE__COMPONENT_REF = eINSTANCE.getComponentFailure_ComponentRef();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.ComponentWorkFlowRunImpl <em>Component Work Flow Run</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.ComponentWorkFlowRunImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getComponentWorkFlowRun()
		 * @generated
		 */
		EClass COMPONENT_WORK_FLOW_RUN = eINSTANCE.getComponentWorkFlowRun();

		/**
		 * The meta object literal for the '<em><b>Failure Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_WORK_FLOW_RUN__FAILURE_REFS = eINSTANCE.getComponentWorkFlowRun_FailureRefs();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.ExpressionFailureImpl <em>Expression Failure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.ExpressionFailureImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getExpressionFailure()
		 * @generated
		 */
		EClass EXPRESSION_FAILURE = eINSTANCE.getExpressionFailure();

		/**
		 * The meta object literal for the '<em><b>Expression Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_FAILURE__EXPRESSION_REF = eINSTANCE.getExpressionFailure_ExpressionRef();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.FailureImpl <em>Failure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.FailureImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getFailure()
		 * @generated
		 */
		EClass FAILURE = eINSTANCE.getFailure();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE__MESSAGE = eINSTANCE.getFailure_Message();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.JobImpl <em>Job</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.JobImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJob()
		 * @generated
		 */
		EClass JOB = eINSTANCE.getJob();

		/**
		 * The meta object literal for the '<em><b>End Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__END_TIME = eINSTANCE.getJob_EndTime();

		/**
		 * The meta object literal for the '<em><b>Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__INTERVAL = eINSTANCE.getJob_Interval();

		/**
		 * The meta object literal for the '<em><b>Job State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__JOB_STATE = eINSTANCE.getJob_JobState();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__NAME = eINSTANCE.getJob_Name();

		/**
		 * The meta object literal for the '<em><b>Repeat</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__REPEAT = eINSTANCE.getJob_Repeat();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__START_TIME = eINSTANCE.getJob_StartTime();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.JobRunContainerImpl <em>Job Run Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.JobRunContainerImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobRunContainer()
		 * @generated
		 */
		EClass JOB_RUN_CONTAINER = eINSTANCE.getJobRunContainer();

		/**
		 * The meta object literal for the '<em><b>Job</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOB_RUN_CONTAINER__JOB = eINSTANCE.getJobRunContainer_Job();

		/**
		 * The meta object literal for the '<em><b>Work Flow Runs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOB_RUN_CONTAINER__WORK_FLOW_RUNS = eINSTANCE.getJobRunContainer_WorkFlowRuns();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.MetricSourceJobImpl <em>Metric Source Job</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.MetricSourceJobImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getMetricSourceJob()
		 * @generated
		 */
		EClass METRIC_SOURCE_JOB = eINSTANCE.getMetricSourceJob();

		/**
		 * The meta object literal for the '<em><b>Metric Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_SOURCE_JOB__METRIC_SOURCE = eINSTANCE.getMetricSourceJob_MetricSource();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.NodeReporterJobImpl <em>Node Reporter Job</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.NodeReporterJobImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getNodeReporterJob()
		 * @generated
		 */
		EClass NODE_REPORTER_JOB = eINSTANCE.getNodeReporterJob();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_REPORTER_JOB__NODE = eINSTANCE.getNodeReporterJob_Node();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.NodeTypeReporterJobImpl <em>Node Type Reporter Job</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.NodeTypeReporterJobImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getNodeTypeReporterJob()
		 * @generated
		 */
		EClass NODE_TYPE_REPORTER_JOB = eINSTANCE.getNodeTypeReporterJob();

		/**
		 * The meta object literal for the '<em><b>Node Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TYPE_REPORTER_JOB__NODE_TYPE = eINSTANCE.getNodeTypeReporterJob_NodeType();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.OperatorReporterJobImpl <em>Operator Reporter Job</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.OperatorReporterJobImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getOperatorReporterJob()
		 * @generated
		 */
		EClass OPERATOR_REPORTER_JOB = eINSTANCE.getOperatorReporterJob();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_REPORTER_JOB__OPERATOR = eINSTANCE.getOperatorReporterJob_Operator();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.RFSServiceMonitoringJobImpl <em>RFS Service Monitoring Job</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.RFSServiceMonitoringJobImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getRFSServiceMonitoringJob()
		 * @generated
		 */
		EClass RFS_SERVICE_MONITORING_JOB = eINSTANCE.getRFSServiceMonitoringJob();

		/**
		 * The meta object literal for the '<em><b>RFS Service</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RFS_SERVICE_MONITORING_JOB__RFS_SERVICE = eINSTANCE.getRFSServiceMonitoringJob_RFSService();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.RFSServiceReporterJobImpl <em>RFS Service Reporter Job</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.RFSServiceReporterJobImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getRFSServiceReporterJob()
		 * @generated
		 */
		EClass RFS_SERVICE_REPORTER_JOB = eINSTANCE.getRFSServiceReporterJob();

		/**
		 * The meta object literal for the '<em><b>RFS Service</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RFS_SERVICE_REPORTER_JOB__RFS_SERVICE = eINSTANCE.getRFSServiceReporterJob_RFSService();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.RFSServiceRetentionJobImpl <em>RFS Service Retention Job</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.RFSServiceRetentionJobImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getRFSServiceRetentionJob()
		 * @generated
		 */
		EClass RFS_SERVICE_RETENTION_JOB = eINSTANCE.getRFSServiceRetentionJob();

		/**
		 * The meta object literal for the '<em><b>RFS Service</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RFS_SERVICE_RETENTION_JOB__RFS_SERVICE = eINSTANCE.getRFSServiceRetentionJob_RFSService();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.ServiceUserFailureImpl <em>Service User Failure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.ServiceUserFailureImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getServiceUserFailure()
		 * @generated
		 */
		EClass SERVICE_USER_FAILURE = eINSTANCE.getServiceUserFailure();

		/**
		 * The meta object literal for the '<em><b>Service User Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_USER_FAILURE__SERVICE_USER_REF = eINSTANCE.getServiceUserFailure_ServiceUserRef();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl <em>Work Flow Run</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getWorkFlowRun()
		 * @generated
		 */
		EClass WORK_FLOW_RUN = eINSTANCE.getWorkFlowRun();

		/**
		 * The meta object literal for the '<em><b>Ended</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORK_FLOW_RUN__ENDED = eINSTANCE.getWorkFlowRun_Ended();

		/**
		 * The meta object literal for the '<em><b>Log</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORK_FLOW_RUN__LOG = eINSTANCE.getWorkFlowRun_Log();

		/**
		 * The meta object literal for the '<em><b>Progress</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORK_FLOW_RUN__PROGRESS = eINSTANCE.getWorkFlowRun_Progress();

		/**
		 * The meta object literal for the '<em><b>Progress Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORK_FLOW_RUN__PROGRESS_MESSAGE = eINSTANCE.getWorkFlowRun_ProgressMessage();

		/**
		 * The meta object literal for the '<em><b>Progress Task</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORK_FLOW_RUN__PROGRESS_TASK = eINSTANCE.getWorkFlowRun_ProgressTask();

		/**
		 * The meta object literal for the '<em><b>Started</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORK_FLOW_RUN__STARTED = eINSTANCE.getWorkFlowRun_Started();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORK_FLOW_RUN__STATE = eINSTANCE.getWorkFlowRun_State();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.JobRunState <em>Job Run State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.JobRunState
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobRunState()
		 * @generated
		 */
		EEnum JOB_RUN_STATE = eINSTANCE.getJobRunState();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.JobState <em>Job State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.JobState
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobState()
		 * @generated
		 */
		EEnum JOB_STATE = eINSTANCE.getJobState();

		/**
		 * The meta object literal for the '<em>Job Run State Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.JobRunState
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobRunStateObject()
		 * @generated
		 */
		EDataType JOB_RUN_STATE_OBJECT = eINSTANCE.getJobRunStateObject();

		/**
		 * The meta object literal for the '<em>Job State Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.JobState
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobStateObject()
		 * @generated
		 */
		EDataType JOB_STATE_OBJECT = eINSTANCE.getJobStateObject();

	}

} //SchedulingPackage
