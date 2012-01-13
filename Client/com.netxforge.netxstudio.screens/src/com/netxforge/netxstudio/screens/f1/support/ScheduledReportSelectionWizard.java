package com.netxforge.netxstudio.screens.f1.support;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.NodeReporterJob;
import com.netxforge.netxstudio.scheduling.NodeTypeReporterJob;
import com.netxforge.netxstudio.scheduling.OperatorReporterJob;
import com.netxforge.netxstudio.scheduling.RFSServiceReporterJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

public class ScheduledReportSelectionWizard extends Wizard implements
		INewWizard {

	@Inject
	ModelUtils modelUtils;

	// @Inject
	// ServerRequest serverActions;

	@Inject
	IEditingService editingService;

	private int operation;

	private Object o;

	private ScheduledReportTypeSelectionPage reportSelectionType;

	private Job job;

	public ScheduledReportSelectionWizard() {
		setWindowTitle("Reporting");
		ScreensActivator.getDefault().getInjector().injectMembers(this);
	}

	@Override
	public void addPages() {
		reportSelectionType = new ScheduledReportTypeSelectionPage(
				editingService);
		reportSelectionType.setSelection(o);
		this.addPage(reportSelectionType);
	}

	@Override
	public boolean performFinish() {

		@SuppressWarnings("unused")
		String identifier = "";

		Resource jobResource = editingService
				.getData(SchedulingPackage.Literals.JOB);

		setJob(null);

		switch (reportSelectionType.getReportSelection()) {
		case ReportTypeSelectionPage.REPORT_ON_SERVICE_NODETYPE: {
			NodeType nodeType = reportSelectionType.getNodeType();
			setJob(jobForNodeType(jobResource, nodeType));
		}
			break;
		case ReportTypeSelectionPage.REPORT_ON_SERVICE: {
			setJob(jobForService(jobResource));
		}
			break;
		case ReportTypeSelectionPage.REPORT_ON_OPERATOR: {
			setJob(jobForOperator(jobResource));
		}
			break;
		case ReportTypeSelectionPage.REPORT_ON_OPERATOR_NODETYPE: {
			NodeType nodeType = reportSelectionType.getNodeType();
			setJob(jobForNodeType(jobResource, nodeType));
		}
			break;
		case ReportTypeSelectionPage.REPORT_ON_NODE: {
			setJob(jobForNode(jobResource));
		}

		}
		return true;
	}

	private Job jobForService(Resource jobResource) {
		Job job;
		job = modelUtils
				.jobForSingleObject(
						jobResource,
						SchedulingPackage.Literals.RFS_SERVICE_REPORTER_JOB,
						SchedulingPackage.Literals.RFS_SERVICE_REPORTER_JOB__RFS_SERVICE,
						(EObject) o);

		// Edit or New if the Service has a job or not.
		if (job != null) {
			setOperation(ScreenUtil.OPERATION_EDIT);
		} else {
			setOperation(ScreenUtil.OPERATION_NEW);
			job = SchedulingFactory.eINSTANCE.createRFSServiceReporterJob();
			job.setJobState(JobState.IN_ACTIVE);
			job.setName(((Service) o).getServiceName());
			job.setInterval(ModelUtils.SECONDS_IN_A_WEEK);
			job.setStartTime(modelUtils.toXMLDate(modelUtils.todayAndNow()));
			if (job instanceof RFSServiceReporterJob) {
				((RFSServiceReporterJob) job).setRFSService((RFSService) o);
			}
		}
		return job;
	}

	private Job jobForOperator(Resource jobResource) {
		Job job;

		job = modelUtils.jobForSingleObject(jobResource,
				SchedulingPackage.Literals.OPERATOR_REPORTER_JOB,
				SchedulingPackage.Literals.OPERATOR_REPORTER_JOB__OPERATOR,
				(EObject) o);

		// Edit or New if the Service has a job or not.
		if (job != null) {
			setOperation(ScreenUtil.OPERATION_EDIT);
		} else {
			setOperation(ScreenUtil.OPERATION_NEW);
			job = SchedulingFactory.eINSTANCE.createOperatorReporterJob();
			job.setName(((Operator) o).getName());
			job.setJobState(JobState.IN_ACTIVE);
			job.setInterval(ModelUtils.SECONDS_IN_A_WEEK);
			job.setStartTime(modelUtils.toXMLDate(modelUtils.todayAndNow()));
			if (job instanceof OperatorReporterJob) {
				((OperatorReporterJob) job).setOperator((Operator) o);
			}
		}
		return job;
	}

	private Job jobForNode(Resource jobResource) {
		Job job;
		job = modelUtils
				.jobForSingleObject(jobResource,
						SchedulingPackage.Literals.NODE_REPORTER_JOB,
						SchedulingPackage.Literals.NODE_REPORTER_JOB__NODE,
						(EObject) o);

		// Edit or New if the Service has a job or not.
		if (job != null) {
			setOperation(ScreenUtil.OPERATION_EDIT);
		} else {
			setOperation(ScreenUtil.OPERATION_NEW);

			job = SchedulingFactory.eINSTANCE.createNodeReporterJob();
			job.setName(((Node) o).getNodeID());
			job.setJobState(JobState.IN_ACTIVE);
			job.setInterval(ModelUtils.SECONDS_IN_A_WEEK);
			job.setStartTime(modelUtils.toXMLDate(modelUtils.todayAndNow()));
			if (job instanceof NodeReporterJob) {
				((NodeReporterJob) job).setNode((Node) o);
			}
		}
		return job;
	}

	private Job jobForNodeType(Resource jobResource, NodeType nodeType) {
		Job job;
		job = modelUtils.jobForSingleObject(jobResource,
				SchedulingPackage.Literals.NODE_REPORTER_JOB,
				SchedulingPackage.Literals.NODE_TYPE_REPORTER_JOB__NODE_TYPE,
				(EObject) nodeType);

		// Edit or New if the Service has a job or not.
		if (job != null) {
			setOperation(ScreenUtil.OPERATION_EDIT);
		} else {
			setOperation(ScreenUtil.OPERATION_NEW);
			job = SchedulingFactory.eINSTANCE.createNodeTypeReporterJob();
			job.setName(((Operator) o).getName());
			job.setJobState(JobState.IN_ACTIVE);
			job.setInterval(ModelUtils.SECONDS_IN_A_WEEK);
			job.setStartTime(modelUtils.toXMLDate(modelUtils.todayAndNow()));
			if (job instanceof NodeTypeReporterJob) {
				((NodeTypeReporterJob) job).setScopeObject((EObject) o);
			}
		}
		return job;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		o = ((IStructuredSelection) selection).getFirstElement();
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

}
