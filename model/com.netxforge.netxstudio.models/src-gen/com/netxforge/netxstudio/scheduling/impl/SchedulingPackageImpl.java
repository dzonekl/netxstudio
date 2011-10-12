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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.impl.GenericsPackageImpl;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.geo.impl.GeoPackageImpl;
import com.netxforge.netxstudio.impl.NetxstudioPackageImpl;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.impl.LibraryPackageImpl;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.netxstudio.protocols.impl.ProtocolsPackageImpl;
import com.netxforge.netxstudio.scheduling.AnalyzerJob;
import com.netxforge.netxstudio.scheduling.ComponentFailure;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.ExpressionFailure;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunContainer;
import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.scheduling.NodeReporterJob;
import com.netxforge.netxstudio.scheduling.NodeTypeReporterJob;
import com.netxforge.netxstudio.scheduling.OperatorReporterJob;
import com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob;
import com.netxforge.netxstudio.scheduling.RFSServiceReporterJob;
import com.netxforge.netxstudio.scheduling.RFSServiceRetentionJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.ServiceUserFailure;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.services.ServicesPackage;
import com.netxforge.netxstudio.services.impl.ServicesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulingPackageImpl extends EPackageImpl implements SchedulingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass analyzerJobEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentFailureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentWorkFlowRunEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionFailureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jobEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jobRunContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricSourceJobEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeReporterJobEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeTypeReporterJobEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorReporterJobEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rfsServiceMonitoringJobEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rfsServiceReporterJobEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rfsServiceRetentionJobEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceUserFailureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workFlowRunEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum jobRunStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum jobStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType jobRunStateObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType jobStateObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SchedulingPackageImpl() {
		super(eNS_URI, SchedulingFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SchedulingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SchedulingPackage init() {
		if (isInited) return (SchedulingPackage)EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI);

		// Obtain or create and register package
		SchedulingPackageImpl theSchedulingPackage = (SchedulingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SchedulingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SchedulingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		GenericsPackageImpl theGenericsPackage = (GenericsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI) instanceof GenericsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI) : GenericsPackage.eINSTANCE);
		ServicesPackageImpl theServicesPackage = (ServicesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServicesPackage.eNS_URI) instanceof ServicesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServicesPackage.eNS_URI) : ServicesPackage.eINSTANCE);
		LibraryPackageImpl theLibraryPackage = (LibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) instanceof LibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) : LibraryPackage.eINSTANCE);
		OperatorsPackageImpl theOperatorsPackage = (OperatorsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OperatorsPackage.eNS_URI) instanceof OperatorsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OperatorsPackage.eNS_URI) : OperatorsPackage.eINSTANCE);
		MetricsPackageImpl theMetricsPackage = (MetricsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI) instanceof MetricsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI) : MetricsPackage.eINSTANCE);
		ProtocolsPackageImpl theProtocolsPackage = (ProtocolsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProtocolsPackage.eNS_URI) instanceof ProtocolsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProtocolsPackage.eNS_URI) : ProtocolsPackage.eINSTANCE);
		GeoPackageImpl theGeoPackage = (GeoPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GeoPackage.eNS_URI) instanceof GeoPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GeoPackage.eNS_URI) : GeoPackage.eINSTANCE);
		NetxstudioPackageImpl theNetxstudioPackage = (NetxstudioPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NetxstudioPackage.eNS_URI) instanceof NetxstudioPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NetxstudioPackage.eNS_URI) : NetxstudioPackage.eINSTANCE);

		// Create package meta-data objects
		theSchedulingPackage.createPackageContents();
		theGenericsPackage.createPackageContents();
		theServicesPackage.createPackageContents();
		theLibraryPackage.createPackageContents();
		theOperatorsPackage.createPackageContents();
		theMetricsPackage.createPackageContents();
		theProtocolsPackage.createPackageContents();
		theGeoPackage.createPackageContents();
		theNetxstudioPackage.createPackageContents();

		// Initialize created meta-data
		theSchedulingPackage.initializePackageContents();
		theGenericsPackage.initializePackageContents();
		theServicesPackage.initializePackageContents();
		theLibraryPackage.initializePackageContents();
		theOperatorsPackage.initializePackageContents();
		theMetricsPackage.initializePackageContents();
		theProtocolsPackage.initializePackageContents();
		theGeoPackage.initializePackageContents();
		theNetxstudioPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSchedulingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SchedulingPackage.eNS_URI, theSchedulingPackage);
		return theSchedulingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnalyzerJob() {
		return analyzerJobEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalyzerJob_RFSService() {
		return (EReference)analyzerJobEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentFailure() {
		return componentFailureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentFailure_ComponentRef() {
		return (EReference)componentFailureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentWorkFlowRun() {
		return componentWorkFlowRunEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentWorkFlowRun_FailureRefs() {
		return (EReference)componentWorkFlowRunEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionFailure() {
		return expressionFailureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionFailure_ExpressionRef() {
		return (EReference)expressionFailureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFailure() {
		return failureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFailure_Message() {
		return (EAttribute)failureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJob() {
		return jobEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJob_EndTime() {
		return (EAttribute)jobEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJob_Interval() {
		return (EAttribute)jobEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJob_JobState() {
		return (EAttribute)jobEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJob_Name() {
		return (EAttribute)jobEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJob_Repeat() {
		return (EAttribute)jobEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJob_StartTime() {
		return (EAttribute)jobEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJobRunContainer() {
		return jobRunContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJobRunContainer_Job() {
		return (EReference)jobRunContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJobRunContainer_WorkFlowRuns() {
		return (EReference)jobRunContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetricSourceJob() {
		return metricSourceJobEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetricSourceJob_MetricSources() {
		return (EReference)metricSourceJobEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeReporterJob() {
		return nodeReporterJobEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeReporterJob_Node() {
		return (EReference)nodeReporterJobEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeTypeReporterJob() {
		return nodeTypeReporterJobEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeTypeReporterJob_NodeType() {
		return (EReference)nodeTypeReporterJobEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeTypeReporterJob_ScopeObject() {
		return (EReference)nodeTypeReporterJobEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatorReporterJob() {
		return operatorReporterJobEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorReporterJob_Operator() {
		return (EReference)operatorReporterJobEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRFSServiceMonitoringJob() {
		return rfsServiceMonitoringJobEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRFSServiceMonitoringJob_RFSService() {
		return (EReference)rfsServiceMonitoringJobEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRFSServiceReporterJob() {
		return rfsServiceReporterJobEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRFSServiceReporterJob_RFSService() {
		return (EReference)rfsServiceReporterJobEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRFSServiceRetentionJob() {
		return rfsServiceRetentionJobEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRFSServiceRetentionJob_RFSService() {
		return (EReference)rfsServiceRetentionJobEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceUserFailure() {
		return serviceUserFailureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceUserFailure_ServiceUserRef() {
		return (EReference)serviceUserFailureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkFlowRun() {
		return workFlowRunEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkFlowRun_Ended() {
		return (EAttribute)workFlowRunEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkFlowRun_Log() {
		return (EAttribute)workFlowRunEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkFlowRun_Progress() {
		return (EAttribute)workFlowRunEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkFlowRun_ProgressMessage() {
		return (EAttribute)workFlowRunEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkFlowRun_ProgressTask() {
		return (EAttribute)workFlowRunEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkFlowRun_Started() {
		return (EAttribute)workFlowRunEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkFlowRun_State() {
		return (EAttribute)workFlowRunEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJobRunState() {
		return jobRunStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJobState() {
		return jobStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJobRunStateObject() {
		return jobRunStateObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJobStateObject() {
		return jobStateObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingFactory getSchedulingFactory() {
		return (SchedulingFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		analyzerJobEClass = createEClass(ANALYZER_JOB);
		createEReference(analyzerJobEClass, ANALYZER_JOB__RFS_SERVICE);

		componentFailureEClass = createEClass(COMPONENT_FAILURE);
		createEReference(componentFailureEClass, COMPONENT_FAILURE__COMPONENT_REF);

		componentWorkFlowRunEClass = createEClass(COMPONENT_WORK_FLOW_RUN);
		createEReference(componentWorkFlowRunEClass, COMPONENT_WORK_FLOW_RUN__FAILURE_REFS);

		expressionFailureEClass = createEClass(EXPRESSION_FAILURE);
		createEReference(expressionFailureEClass, EXPRESSION_FAILURE__EXPRESSION_REF);

		failureEClass = createEClass(FAILURE);
		createEAttribute(failureEClass, FAILURE__MESSAGE);

		jobEClass = createEClass(JOB);
		createEAttribute(jobEClass, JOB__END_TIME);
		createEAttribute(jobEClass, JOB__INTERVAL);
		createEAttribute(jobEClass, JOB__JOB_STATE);
		createEAttribute(jobEClass, JOB__NAME);
		createEAttribute(jobEClass, JOB__REPEAT);
		createEAttribute(jobEClass, JOB__START_TIME);

		jobRunContainerEClass = createEClass(JOB_RUN_CONTAINER);
		createEReference(jobRunContainerEClass, JOB_RUN_CONTAINER__JOB);
		createEReference(jobRunContainerEClass, JOB_RUN_CONTAINER__WORK_FLOW_RUNS);

		metricSourceJobEClass = createEClass(METRIC_SOURCE_JOB);
		createEReference(metricSourceJobEClass, METRIC_SOURCE_JOB__METRIC_SOURCES);

		nodeReporterJobEClass = createEClass(NODE_REPORTER_JOB);
		createEReference(nodeReporterJobEClass, NODE_REPORTER_JOB__NODE);

		nodeTypeReporterJobEClass = createEClass(NODE_TYPE_REPORTER_JOB);
		createEReference(nodeTypeReporterJobEClass, NODE_TYPE_REPORTER_JOB__NODE_TYPE);
		createEReference(nodeTypeReporterJobEClass, NODE_TYPE_REPORTER_JOB__SCOPE_OBJECT);

		operatorReporterJobEClass = createEClass(OPERATOR_REPORTER_JOB);
		createEReference(operatorReporterJobEClass, OPERATOR_REPORTER_JOB__OPERATOR);

		rfsServiceMonitoringJobEClass = createEClass(RFS_SERVICE_MONITORING_JOB);
		createEReference(rfsServiceMonitoringJobEClass, RFS_SERVICE_MONITORING_JOB__RFS_SERVICE);

		rfsServiceReporterJobEClass = createEClass(RFS_SERVICE_REPORTER_JOB);
		createEReference(rfsServiceReporterJobEClass, RFS_SERVICE_REPORTER_JOB__RFS_SERVICE);

		rfsServiceRetentionJobEClass = createEClass(RFS_SERVICE_RETENTION_JOB);
		createEReference(rfsServiceRetentionJobEClass, RFS_SERVICE_RETENTION_JOB__RFS_SERVICE);

		serviceUserFailureEClass = createEClass(SERVICE_USER_FAILURE);
		createEReference(serviceUserFailureEClass, SERVICE_USER_FAILURE__SERVICE_USER_REF);

		workFlowRunEClass = createEClass(WORK_FLOW_RUN);
		createEAttribute(workFlowRunEClass, WORK_FLOW_RUN__ENDED);
		createEAttribute(workFlowRunEClass, WORK_FLOW_RUN__LOG);
		createEAttribute(workFlowRunEClass, WORK_FLOW_RUN__PROGRESS);
		createEAttribute(workFlowRunEClass, WORK_FLOW_RUN__PROGRESS_MESSAGE);
		createEAttribute(workFlowRunEClass, WORK_FLOW_RUN__PROGRESS_TASK);
		createEAttribute(workFlowRunEClass, WORK_FLOW_RUN__STARTED);
		createEAttribute(workFlowRunEClass, WORK_FLOW_RUN__STATE);

		// Create enums
		jobRunStateEEnum = createEEnum(JOB_RUN_STATE);
		jobStateEEnum = createEEnum(JOB_STATE);

		// Create data types
		jobRunStateObjectEDataType = createEDataType(JOB_RUN_STATE_OBJECT);
		jobStateObjectEDataType = createEDataType(JOB_STATE_OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ServicesPackage theServicesPackage = (ServicesPackage)EPackage.Registry.INSTANCE.getEPackage(ServicesPackage.eNS_URI);
		LibraryPackage theLibraryPackage = (LibraryPackage)EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		GenericsPackage theGenericsPackage = (GenericsPackage)EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI);
		MetricsPackage theMetricsPackage = (MetricsPackage)EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI);
		OperatorsPackage theOperatorsPackage = (OperatorsPackage)EPackage.Registry.INSTANCE.getEPackage(OperatorsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		analyzerJobEClass.getESuperTypes().add(this.getJob());
		componentFailureEClass.getESuperTypes().add(this.getExpressionFailure());
		componentWorkFlowRunEClass.getESuperTypes().add(this.getWorkFlowRun());
		expressionFailureEClass.getESuperTypes().add(this.getFailure());
		jobEClass.getESuperTypes().add(theGenericsPackage.getBase());
		metricSourceJobEClass.getESuperTypes().add(this.getJob());
		nodeReporterJobEClass.getESuperTypes().add(this.getJob());
		nodeTypeReporterJobEClass.getESuperTypes().add(this.getJob());
		operatorReporterJobEClass.getESuperTypes().add(this.getJob());
		rfsServiceMonitoringJobEClass.getESuperTypes().add(this.getJob());
		rfsServiceReporterJobEClass.getESuperTypes().add(this.getJob());
		rfsServiceRetentionJobEClass.getESuperTypes().add(this.getJob());
		serviceUserFailureEClass.getESuperTypes().add(this.getExpressionFailure());

		// Initialize classes and features; add operations and parameters
		initEClass(analyzerJobEClass, AnalyzerJob.class, "AnalyzerJob", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnalyzerJob_RFSService(), theServicesPackage.getRFSService(), null, "rFSService", null, 1, 1, AnalyzerJob.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentFailureEClass, ComponentFailure.class, "ComponentFailure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentFailure_ComponentRef(), theLibraryPackage.getComponent(), null, "componentRef", null, 0, 1, ComponentFailure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentWorkFlowRunEClass, ComponentWorkFlowRun.class, "ComponentWorkFlowRun", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentWorkFlowRun_FailureRefs(), this.getFailure(), null, "failureRefs", null, 0, -1, ComponentWorkFlowRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionFailureEClass, ExpressionFailure.class, "ExpressionFailure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionFailure_ExpressionRef(), theLibraryPackage.getExpression(), null, "expressionRef", null, 0, 1, ExpressionFailure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(failureEClass, Failure.class, "Failure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFailure_Message(), theXMLTypePackage.getString(), "message", null, 0, 1, Failure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jobEClass, Job.class, "Job", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJob_EndTime(), theXMLTypePackage.getDateTime(), "endTime", null, 0, 1, Job.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJob_Interval(), theXMLTypePackage.getInt(), "interval", null, 0, 1, Job.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJob_JobState(), this.getJobState(), "jobState", null, 0, 1, Job.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJob_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, Job.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJob_Repeat(), theXMLTypePackage.getInt(), "repeat", null, 0, 1, Job.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJob_StartTime(), theXMLTypePackage.getDateTime(), "startTime", null, 0, 1, Job.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jobRunContainerEClass, JobRunContainer.class, "JobRunContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJobRunContainer_Job(), this.getJob(), null, "job", null, 1, 1, JobRunContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJobRunContainer_WorkFlowRuns(), this.getWorkFlowRun(), null, "workFlowRuns", null, 0, -1, JobRunContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricSourceJobEClass, MetricSourceJob.class, "MetricSourceJob", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetricSourceJob_MetricSources(), theMetricsPackage.getMetricSource(), null, "metricSources", null, 1, -1, MetricSourceJob.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeReporterJobEClass, NodeReporterJob.class, "NodeReporterJob", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeReporterJob_Node(), theOperatorsPackage.getNode(), null, "node", null, 1, 1, NodeReporterJob.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeTypeReporterJobEClass, NodeTypeReporterJob.class, "NodeTypeReporterJob", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeTypeReporterJob_NodeType(), theLibraryPackage.getNodeType(), null, "nodeType", null, 1, 1, NodeTypeReporterJob.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeTypeReporterJob_ScopeObject(), ecorePackage.getEObject(), null, "scopeObject", null, 1, 1, NodeTypeReporterJob.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operatorReporterJobEClass, OperatorReporterJob.class, "OperatorReporterJob", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperatorReporterJob_Operator(), theOperatorsPackage.getOperator(), null, "operator", null, 1, 1, OperatorReporterJob.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rfsServiceMonitoringJobEClass, RFSServiceMonitoringJob.class, "RFSServiceMonitoringJob", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRFSServiceMonitoringJob_RFSService(), theServicesPackage.getRFSService(), null, "rFSService", null, 1, 1, RFSServiceMonitoringJob.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rfsServiceReporterJobEClass, RFSServiceReporterJob.class, "RFSServiceReporterJob", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRFSServiceReporterJob_RFSService(), theServicesPackage.getRFSService(), null, "rFSService", null, 1, 1, RFSServiceReporterJob.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rfsServiceRetentionJobEClass, RFSServiceRetentionJob.class, "RFSServiceRetentionJob", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRFSServiceRetentionJob_RFSService(), theServicesPackage.getRFSService(), null, "rFSService", null, 1, 1, RFSServiceRetentionJob.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceUserFailureEClass, ServiceUserFailure.class, "ServiceUserFailure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceUserFailure_ServiceUserRef(), theServicesPackage.getServiceUser(), null, "serviceUserRef", null, 0, 1, ServiceUserFailure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(workFlowRunEClass, WorkFlowRun.class, "WorkFlowRun", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWorkFlowRun_Ended(), theXMLTypePackage.getDateTime(), "ended", null, 0, 1, WorkFlowRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkFlowRun_Log(), theGenericsPackage.getLongText(), "log", null, 0, 1, WorkFlowRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkFlowRun_Progress(), theXMLTypePackage.getInt(), "progress", null, 0, 1, WorkFlowRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkFlowRun_ProgressMessage(), theXMLTypePackage.getString(), "progressMessage", null, 0, 1, WorkFlowRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkFlowRun_ProgressTask(), theXMLTypePackage.getString(), "progressTask", null, 0, 1, WorkFlowRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkFlowRun_Started(), theXMLTypePackage.getDateTime(), "started", null, 0, 1, WorkFlowRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkFlowRun_State(), this.getJobRunState(), "state", null, 0, 1, WorkFlowRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(jobRunStateEEnum, JobRunState.class, "JobRunState");
		addEEnumLiteral(jobRunStateEEnum, JobRunState.RUNNING);
		addEEnumLiteral(jobRunStateEEnum, JobRunState.FINISHED_SUCCESSFULLY);
		addEEnumLiteral(jobRunStateEEnum, JobRunState.FINISHED_WITH_ERROR);

		initEEnum(jobStateEEnum, JobState.class, "JobState");
		addEEnumLiteral(jobStateEEnum, JobState.ACTIVE);
		addEEnumLiteral(jobStateEEnum, JobState.IN_ACTIVE);

		// Initialize data types
		initEDataType(jobRunStateObjectEDataType, JobRunState.class, "JobRunStateObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(jobStateObjectEDataType, JobState.class, "JobStateObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";			
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL",
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL"
		   });																																																																														
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";					
		addAnnotation
		  (analyzerJobEClass, 
		   source, 
		   new String[] {
			 "name", "AnalyzerJob",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getAnalyzerJob_RFSService(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RFSService"
		   });			
		addAnnotation
		  (componentFailureEClass, 
		   source, 
		   new String[] {
			 "name", "ComponentFailure",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getComponentFailure_ComponentRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ComponentRef"
		   });			
		addAnnotation
		  (componentWorkFlowRunEClass, 
		   source, 
		   new String[] {
			 "name", "ComponentWorkFlowRun",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getComponentWorkFlowRun_FailureRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FailureRefs"
		   });			
		addAnnotation
		  (expressionFailureEClass, 
		   source, 
		   new String[] {
			 "name", "ExpressionFailure",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getExpressionFailure_ExpressionRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ExpressionRef"
		   });			
		addAnnotation
		  (failureEClass, 
		   source, 
		   new String[] {
			 "name", "Failure",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getFailure_Message(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Message"
		   });		
		addAnnotation
		  (jobEClass, 
		   source, 
		   new String[] {
			 "name", "Job",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getJob_EndTime(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "EndTime"
		   });		
		addAnnotation
		  (getJob_Interval(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Interval"
		   });		
		addAnnotation
		  (getJob_JobState(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "JobState"
		   });		
		addAnnotation
		  (getJob_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });		
		addAnnotation
		  (getJob_Repeat(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Repeat"
		   });		
		addAnnotation
		  (getJob_StartTime(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "StartTime"
		   });		
		addAnnotation
		  (jobRunContainerEClass, 
		   source, 
		   new String[] {
			 "name", "JobRunContainer",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getJobRunContainer_Job(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Job"
		   });		
		addAnnotation
		  (getJobRunContainer_WorkFlowRuns(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "WorkFlowRuns"
		   });			
		addAnnotation
		  (jobRunStateEEnum, 
		   source, 
		   new String[] {
			 "name", "JobRunState"
		   });		
		addAnnotation
		  (jobRunStateObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "JobRunState:Object",
			 "baseType", "JobRunState"
		   });			
		addAnnotation
		  (jobStateEEnum, 
		   source, 
		   new String[] {
			 "name", "JobState"
		   });		
		addAnnotation
		  (jobStateObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "JobState:Object",
			 "baseType", "JobState"
		   });			
		addAnnotation
		  (metricSourceJobEClass, 
		   source, 
		   new String[] {
			 "name", "MetricSourceJob",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getMetricSourceJob_MetricSources(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MetricSources"
		   });			
		addAnnotation
		  (nodeReporterJobEClass, 
		   source, 
		   new String[] {
			 "name", "NodeReporterJob",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getNodeReporterJob_Node(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Node"
		   });			
		addAnnotation
		  (nodeTypeReporterJobEClass, 
		   source, 
		   new String[] {
			 "name", "NodeTypeReporterJob",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getNodeTypeReporterJob_NodeType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "NodeType"
		   });			
		addAnnotation
		  (getNodeTypeReporterJob_ScopeObject(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ScopeObject"
		   });			
		addAnnotation
		  (operatorReporterJobEClass, 
		   source, 
		   new String[] {
			 "name", "OperatorReporterJob",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getOperatorReporterJob_Operator(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Operator"
		   });			
		addAnnotation
		  (rfsServiceMonitoringJobEClass, 
		   source, 
		   new String[] {
			 "name", "RFSServiceMonitoringJob",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getRFSServiceMonitoringJob_RFSService(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RFSService"
		   });			
		addAnnotation
		  (rfsServiceReporterJobEClass, 
		   source, 
		   new String[] {
			 "name", "RFSServiceReporterJob",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getRFSServiceReporterJob_RFSService(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RFSService"
		   });			
		addAnnotation
		  (rfsServiceRetentionJobEClass, 
		   source, 
		   new String[] {
			 "name", "RFSServiceRetentionJob",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getRFSServiceRetentionJob_RFSService(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RFSService"
		   });			
		addAnnotation
		  (serviceUserFailureEClass, 
		   source, 
		   new String[] {
			 "name", "ServiceUserFailure",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getServiceUserFailure_ServiceUserRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ServiceUserRef"
		   });		
		addAnnotation
		  (workFlowRunEClass, 
		   source, 
		   new String[] {
			 "name", "WorkFlowRun",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getWorkFlowRun_Ended(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Ended"
		   });		
		addAnnotation
		  (getWorkFlowRun_Log(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Log"
		   });		
		addAnnotation
		  (getWorkFlowRun_Progress(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Progress"
		   });		
		addAnnotation
		  (getWorkFlowRun_ProgressMessage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ProgressMessage"
		   });		
		addAnnotation
		  (getWorkFlowRun_ProgressTask(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ProgressTask"
		   });		
		addAnnotation
		  (getWorkFlowRun_Started(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Started"
		   });		
		addAnnotation
		  (getWorkFlowRun_State(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "State"
		   });
	}

} //SchedulingPackageImpl
