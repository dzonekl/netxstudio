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
 * 			Validation with pattern is not used, considering the limited capabilities of XSD patterns. 
 * 			
 * 		
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
 * 			Validation with pattern is not used, considering the limited capabilities of XSD patterns. 
 * 			
 * 		
 * 
 * 		
 * <!-- end-model-doc -->
 * @see com.netxforge.netxstudio.scheduling.SchedulingFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL' invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL'"
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
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.JobImpl <em>Job</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.JobImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJob()
	 * @generated
	 */
	int JOB = 0;

	/**
	 * The feature id for the '<em><b>Job Runs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__JOB_RUNS = 0;

	/**
	 * The feature id for the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__INTERVAL = 1;

	/**
	 * The feature id for the '<em><b>Job State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__JOB_STATE = 2;

	/**
	 * The feature id for the '<em><b>Last Run Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__LAST_RUN_TIME = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__NAME = 4;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__START_TIME = 5;

	/**
	 * The number of structural features of the '<em>Job</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.JobRunImpl <em>Job Run</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.JobRunImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobRun()
	 * @generated
	 */
	int JOB_RUN = 1;

	/**
	 * The feature id for the '<em><b>Ended</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_RUN__ENDED = 0;

	/**
	 * The feature id for the '<em><b>Job Run State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_RUN__JOB_RUN_STATE = 1;

	/**
	 * The feature id for the '<em><b>Log</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_RUN__LOG = 2;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_RUN__PROGRESS = 3;

	/**
	 * The feature id for the '<em><b>Progress Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_RUN__PROGRESS_MESSAGE = 4;

	/**
	 * The feature id for the '<em><b>Progress Task</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_RUN__PROGRESS_TASK = 5;

	/**
	 * The feature id for the '<em><b>Started</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_RUN__STARTED = 6;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_RUN__STATE = 7;

	/**
	 * The number of structural features of the '<em>Job Run</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_RUN_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.MetricSourceJobImpl <em>Metric Source Job</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.MetricSourceJobImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getMetricSourceJob()
	 * @generated
	 */
	int METRIC_SOURCE_JOB = 2;

	/**
	 * The feature id for the '<em><b>Job Runs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE_JOB__JOB_RUNS = JOB__JOB_RUNS;

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
	 * The feature id for the '<em><b>Last Run Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE_JOB__LAST_RUN_TIME = JOB__LAST_RUN_TIME;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE_JOB__NAME = JOB__NAME;

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
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.JobRunState <em>Job Run State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.JobRunState
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobRunState()
	 * @generated
	 */
	int JOB_RUN_STATE = 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.JobState <em>Job State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.JobState
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobState()
	 * @generated
	 */
	int JOB_STATE = 4;

	/**
	 * The meta object id for the '<em>Job Run State Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.JobRunState
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobRunStateObject()
	 * @generated
	 */
	int JOB_RUN_STATE_OBJECT = 5;

	/**
	 * The meta object id for the '<em>Job State Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.JobState
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobStateObject()
	 * @generated
	 */
	int JOB_STATE_OBJECT = 6;

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
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.scheduling.Job#getJobRuns <em>Job Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Job Runs</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Job#getJobRuns()
	 * @see #getJob()
	 * @generated
	 */
	EReference getJob_JobRuns();

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
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.Job#getLastRunTime <em>Last Run Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Run Time</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Job#getLastRunTime()
	 * @see #getJob()
	 * @generated
	 */
	EAttribute getJob_LastRunTime();

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
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.JobRun <em>Job Run</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Job Run</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobRun
	 * @generated
	 */
	EClass getJobRun();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.JobRun#getEnded <em>Ended</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ended</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobRun#getEnded()
	 * @see #getJobRun()
	 * @generated
	 */
	EAttribute getJobRun_Ended();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.JobRun#getJobRunState <em>Job Run State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Job Run State</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobRun#getJobRunState()
	 * @see #getJobRun()
	 * @generated
	 */
	EAttribute getJobRun_JobRunState();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.JobRun#getLog <em>Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobRun#getLog()
	 * @see #getJobRun()
	 * @generated
	 */
	EAttribute getJobRun_Log();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.JobRun#getProgress <em>Progress</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Progress</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobRun#getProgress()
	 * @see #getJobRun()
	 * @generated
	 */
	EAttribute getJobRun_Progress();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.JobRun#getProgressMessage <em>Progress Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Progress Message</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobRun#getProgressMessage()
	 * @see #getJobRun()
	 * @generated
	 */
	EAttribute getJobRun_ProgressMessage();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.JobRun#getProgressTask <em>Progress Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Progress Task</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobRun#getProgressTask()
	 * @see #getJobRun()
	 * @generated
	 */
	EAttribute getJobRun_ProgressTask();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.JobRun#getStarted <em>Started</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Started</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobRun#getStarted()
	 * @see #getJobRun()
	 * @generated
	 */
	EAttribute getJobRun_Started();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.JobRun#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobRun#getState()
	 * @see #getJobRun()
	 * @generated
	 */
	EAttribute getJobRun_State();

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
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.JobImpl <em>Job</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.JobImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJob()
		 * @generated
		 */
		EClass JOB = eINSTANCE.getJob();

		/**
		 * The meta object literal for the '<em><b>Job Runs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOB__JOB_RUNS = eINSTANCE.getJob_JobRuns();

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
		 * The meta object literal for the '<em><b>Last Run Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__LAST_RUN_TIME = eINSTANCE.getJob_LastRunTime();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__NAME = eINSTANCE.getJob_Name();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__START_TIME = eINSTANCE.getJob_StartTime();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.JobRunImpl <em>Job Run</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.JobRunImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobRun()
		 * @generated
		 */
		EClass JOB_RUN = eINSTANCE.getJobRun();

		/**
		 * The meta object literal for the '<em><b>Ended</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_RUN__ENDED = eINSTANCE.getJobRun_Ended();

		/**
		 * The meta object literal for the '<em><b>Job Run State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_RUN__JOB_RUN_STATE = eINSTANCE.getJobRun_JobRunState();

		/**
		 * The meta object literal for the '<em><b>Log</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_RUN__LOG = eINSTANCE.getJobRun_Log();

		/**
		 * The meta object literal for the '<em><b>Progress</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_RUN__PROGRESS = eINSTANCE.getJobRun_Progress();

		/**
		 * The meta object literal for the '<em><b>Progress Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_RUN__PROGRESS_MESSAGE = eINSTANCE.getJobRun_ProgressMessage();

		/**
		 * The meta object literal for the '<em><b>Progress Task</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_RUN__PROGRESS_TASK = eINSTANCE.getJobRun_ProgressTask();

		/**
		 * The meta object literal for the '<em><b>Started</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_RUN__STARTED = eINSTANCE.getJobRun_Started();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_RUN__STATE = eINSTANCE.getJobRun_State();

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
