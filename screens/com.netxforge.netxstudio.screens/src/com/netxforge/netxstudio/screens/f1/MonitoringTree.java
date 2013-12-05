/*******************************************************************************
 * Copyright (c) May 9, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.f1;

import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.Form;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.context.IComputationContext;
import com.netxforge.netxstudio.common.context.ObjectContext;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.common.model.MonitoringStateEvent;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.common.model.MonitoringStateModel.MonitoringStateCallBack;
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.screens.AbstractPeriodScreen;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.editing.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.ScreenUtil;
import com.netxforge.netxstudio.screens.editing.actions.SeparatorAction;
import com.netxforge.netxstudio.screens.editing.actions.WizardUtil;
import com.netxforge.netxstudio.screens.editing.filter.TreeSearchFilter;
import com.netxforge.netxstudio.screens.f1.support.MonitoringTreeFactoryImpl;
import com.netxforge.netxstudio.screens.f1.support.MonitoringTreeLabelProvider;
import com.netxforge.netxstudio.screens.f1.support.MonitoringTreeStructureAdvisorImpl;
import com.netxforge.netxstudio.screens.f1.support.ScheduledReportSelectionWizard;
import com.netxforge.netxstudio.screens.f4.NewEditJob;
import com.netxforge.netxstudio.screens.f4.ServiceMonitors;
import com.netxforge.netxstudio.screens.monitoring.AbstractMonitoringProcessor;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * A non editing Monitoring screen.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class MonitoringTree extends AbstractPeriodScreen implements
		IDataServiceInjection, MonitoringStateCallBack {

	private Text txtFilterText;
	@SuppressWarnings("unused")
	private DataBindingContext bindingContext;
	private TreeViewer monitoringTreeViewer;
	private Resource operatorsResource;

	@Inject
	ServerRequest serverActions;

	@Inject
	MonitoringStateModel monitoringStateModel;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public MonitoringTree(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataServiceInjection#injectData()
	 */
	public void injectData() {

		operatorsResource = editingService
				.getData(OperatorsPackage.Literals.OPERATOR);
		// rfsServiceResource = editingService
		// .getData(ServicesPackage.Literals.RFS_SERVICE);

		buildUI();
		initDataBindings_();
	}

	Thread updateDetails;

	protected void buildUI() {
		super.buildUI();

		Form monitoring = getScreenForm();
		monitoring.setText(this.getOperationText() + "Monitoring");
		Composite composite = toolkit.createComposite(monitoring.getBody(),
				SWT.NONE);
		toolkit.paintBordersFor(composite);
		composite.setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(composite, "Filter:",
				SWT.NONE);
		lblFilterLabel.setSize(64, 81);

		txtFilterText = toolkit.createText(composite, "New Text", SWT.H_SCROLL
				| SWT.SEARCH | SWT.CANCEL);
		GridData gd_txtFilterText = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		// gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);
		txtFilterText.setSize(64, 81);
		txtFilterText.setText("");

		txtFilterText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				monitoringTreeViewer.refresh();
				ViewerFilter[] filters = monitoringTreeViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof TreeSearchFilter) {
						((TreeSearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
			}
		});

		monitoringTreeViewer = new TreeViewer(composite, SWT.BORDER | SWT.MULTI
				| SWT.VIRTUAL | SWT.READ_ONLY);
		monitoringTreeViewer.setUseHashlookup(true);
		monitoringTreeViewer.setComparer(new CDOElementComparer());

		monitoringTreeViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						final ISelection s = event.getSelection();
						@SuppressWarnings("unused")
						final Object o;
						if (s instanceof IStructuredSelection) {
							IStructuredSelection ss = (IStructuredSelection) s;
							o = ss.getFirstElement();
						} else {
							o = null;
						}
					}
				});

		Tree tree = monitoringTreeViewer.getTree();
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 2));
		tree.setSize(74, 81);

		TreeViewerColumn treeViewerColumn_1 = new TreeViewerColumn(
				monitoringTreeViewer, SWT.NONE);

		TreeColumn trclmnName_1 = treeViewerColumn_1.getColumn();
		trclmnName_1.setWidth(300);
		trclmnName_1.setText("ID");
		trclmnName_1.setResizable(true);

		TreeViewerColumn treeViewerColumn_2 = new TreeViewerColumn(
				monitoringTreeViewer, SWT.NONE);
		TreeColumn trclmn_2 = treeViewerColumn_2.getColumn();
		trclmn_2.setWidth(50);
		trclmn_2.setResizable(true);
		
		TreeViewerColumn treeViewerColumn_3 = new TreeViewerColumn(
				monitoringTreeViewer, SWT.NONE);
		TreeColumn trclmn_3 = treeViewerColumn_3.getColumn();
		trclmn_3.setWidth(50);
		trclmn_3.setResizable(true);

		TreeViewerColumn treeViewerColumn_4 = new TreeViewerColumn(
				monitoringTreeViewer, SWT.NONE);
		TreeColumn trclmn_4 = treeViewerColumn_4.getColumn();
		trclmn_4.setWidth(50);
		trclmn_4.setResizable(true);
		
		toolkit.paintBordersFor(tree);

		monitoringTreeViewer.addFilter(new TreeSearchFilter(this
				.getEditingService()));
	}

	private final List<IAction> actions = Lists.newArrayList();

	// private MonitoringAggregate monitoringAggregate;

	@Override
	public IAction[] getActions() {

		if (actions.isEmpty()) {
			actions.add(new UpdateMonitoringAction("Update status"));
			actions.add(new CleanMonitoringAction("Clear status"));
			actions.add(new SeparatorAction());
			actions.add(new ScheduleMonitorJobAction(
					"Schedule Monitoring Job..."));
			actions.add(new MonitorNowAction("Monitor Now..."));
			actions.add(new SeparatorAction());
			actions.add(new ServiceMonitoringAction("Monitoring Result..."));
			actions.add(new SeparatorAction());
			actions.add(new SeparatorAction());
			actions.add(new ScheduleReportingJobAction(
					"Schedule Reporting Job..."));
			actions.add(new ReportNowAction("Report Now..."));
			actions.add(new SeparatorAction());
		}

		return actions.toArray(new IAction[actions.size()]);
	}

	public void disposeData() {
		// N/A
	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		
		super.initDataBindings_();
		
		// Set to one month ago...will be overwritten if state is available. 
		getPeriodComponent().presetLastMonth();
		
		ObservableListTreeContentProvider cp = new ObservableListTreeContentProvider(
				new MonitoringTreeFactoryImpl(editingService.getEditingDomain()),
				new MonitoringTreeStructureAdvisorImpl(modelUtils));
		monitoringTreeViewer.setContentProvider(cp);
		IObservableSet set = cp.getKnownElements();

		List<IObservableMap> mapList = Lists.newArrayList();

		mapList.add(EMFEditProperties.value(editingService.getEditingDomain(),
				GenericsPackage.Literals.COMPANY__NAME).observeDetail(set));

		mapList.add(EMFEditProperties.value(editingService.getEditingDomain(),
				ServicesPackage.Literals.SERVICE__SERVICE_NAME).observeDetail(
				set));

		mapList.add(EMFProperties.value(
				ServicesPackage.Literals.RFS_SERVICE__NODES).observeDetail(set));

		IObservableMap[] map = new IObservableMap[mapList.size()];
		mapList.toArray(map);

		monitoringTreeViewer.setLabelProvider(new MonitoringTreeLabelProvider(
				monitoringStateModel, modelUtils, map));

		IEMFListProperty projects = EMFEditProperties.resource(editingService
				.getEditingDomain());

		IObservableList servicesObservableList = projects
				.observe(operatorsResource);
		monitoringTreeViewer.setInput(servicesObservableList);

		// Monitoring Observable.
		// monitoringAggregate = new MonitoringAggregate(monitoringStateModel);

		// IViewerObservableValue observeSelection = ViewersObservables
		// .observeSingleSelection(monitoringTreeViewer);
		// observeSelection.addValueChangeListener(monitoringAggregate);

		return bindingContext;
	}

	/**
	 * Maintains monitoring selection. Note: We don't have a period selector.
	 */
	final class MonitoringAggregate extends AbstractMonitoringProcessor {

		public MonitoringAggregate(MonitoringStateModel monitoringStateModel) {
			super(monitoringStateModel);
		}

		/**
		 * Track the last value change which corresponds to the selection.
		 */
		private EObject lastSelection;

		public void handleValueChange(ValueChangeEvent event) {

			IObservable observable = event.getObservable();
			IObservableValue observableValue = event.getObservableValue();

			if (observable instanceof IViewerObservableValue) {

				IViewerObservableValue ivov = (IViewerObservableValue) observable;
				lastSelection = (EObject) ivov.getValue();
				if (ivov.getViewer() == monitoringTreeViewer) {
					if (currentService != null) {
						cleanResourceMon(currentService);
					}
					currentService = processServiceChange(observableValue);

					updateResourceMon(lastSelection);
				}
			} else if (observable instanceof WritableValue) {
				processPeriodChange(observable);
				updateResourceMon(lastSelection);
			}
		}

		protected void updateValues(EObject target) {

			// Should update the whole subtree of a service.
			monitoringTreeViewer.refresh();
		}

		private Service processServiceChange(IObservableValue ob) {
			Service s = null;
			final Object value = ob.getValue();
			if (value instanceof Service) {
				s = (Service) value;
			}
			return s;
		}

		private void processPeriodChange(IObservable observable) {
			@SuppressWarnings("unused")
			Object value = ((WritableValue) observable).getValue();

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.ui.viewer.IViewerProvider#getViewer()
	 */
	public Viewer getViewer() {

		return monitoringTreeViewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.selector.IScreen#isValid()
	 */
	public boolean isValid() {
		return true;
	}

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class ServiceMonitoringAction extends Action {

		public ServiceMonitoringAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			super.run();
			if (screenService != null) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					ServiceMonitors smScreen = new ServiceMonitors(
							screenService.getScreenContainer(), SWT.NONE);
					// CB 09-04-2012 Will prevent delete!
					// smScreen.setOperation(ScreenUtil.OPERATION_READ_ONLY);
					smScreen.setOperation(ScreenUtil.OPERATION_EDIT);
					smScreen.setScreenService(screenService);
					smScreen.injectData(null, o);
					screenService.setActiveScreen(smScreen);
				}
			}
		}
	}

	class MonitorNowAction extends Action {
		public MonitorNowAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				WizardUtil.openWizard(
						"com.netxforge.netxstudio.screens.monitoring",
						(IStructuredSelection) selection);
			}
		}
	}

	class ReportNowAction extends Action {
		public ReportNowAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				WizardUtil.openWizard(
						"com.netxforge.netxstudio.screens.reporting",
						(IStructuredSelection) selection);
			}
		}
	}

	class ScheduleMonitorJobAction extends Action {
		public ScheduleMonitorJobAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			if (screenService != null) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					if (o instanceof Service) {

						int operation = -1;

						Resource jobResource = editingService
								.getData(SchedulingPackage.Literals.JOB);

						Job job = modelUtils
								.jobForSingleObject(
										jobResource,
										SchedulingPackage.Literals.RFS_SERVICE_MONITORING_JOB,
										SchedulingPackage.Literals.RFS_SERVICE_MONITORING_JOB__RFS_SERVICE,
										(Service) o);

						// List<Job> matchingJobs = editingService
						// .getDataService().getQueryService()
						// .getJobWithService((Service) o);

						// Edit or New if the Service has a job or not.
						if (job != null) {
							operation = ScreenUtil.OPERATION_EDIT;
						} else {
							operation = ScreenUtil.OPERATION_NEW;
							job = SchedulingFactory.eINSTANCE
									.createRFSServiceMonitoringJob();
							job.setName(((Service) o).getServiceName());
							job.setInterval(ModelUtils.SECONDS_IN_A_WEEK);
							job.setStartTime(modelUtils.toXMLDate(modelUtils
									.todayAndNow()));
							job.setJobState(JobState.IN_ACTIVE);
							if (job instanceof RFSServiceMonitoringJob) {
								((RFSServiceMonitoringJob) job)
										.setRFSService((RFSService) o);
							}
						}

						NewEditJob newEditJob = new NewEditJob(
								screenService.getScreenContainer(), SWT.NONE);
						newEditJob.setOperation(operation);
						newEditJob.setScreenService(screenService);
						newEditJob.injectData(jobResource, job);
						screenService.setActiveScreen(newEditJob);
					}
				}
			}
		}
	}

	class UpdateMonitoringAction extends Action {
		public UpdateMonitoringAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			if (screenService != null) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					monitoringStateModel
							.summary(
									MonitoringTree.this,
									o,
									new IComputationContext[] { new ObjectContext<DateTimeRange>(
											getPeriod()) });
				}
			}
		}

		@Override
		public String getToolTipText() {
			return "Updates the RAG status for the selection";
		}
	}

	class CleanMonitoringAction extends Action {
		public CleanMonitoringAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			// Clean all monitoring in this screen!
			EList<EObject> contents = operatorsResource.getContents();
			for (EObject eo : contents) {
				monitoringStateModel.clearSummary(eo);
			}
		}

		@Override
		public String getToolTipText() {
			return "Updates the RAG status for the selection";
		}
	}

	class ScheduleReportingJobAction extends Action {
		public ScheduleReportingJobAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();

			Resource jobResource = editingService
					.getData(SchedulingPackage.Literals.JOB);

			ScheduledReportSelectionWizard wizard = new ScheduledReportSelectionWizard();
			wizard.init(PlatformUI.getWorkbench(),
					(IStructuredSelection) selection);
			wizard.setEditingService(editingService);

			WizardDialog dialog = new WizardDialog(
					MonitoringTree.this.getShell(), wizard);
			dialog.open();
			Job job = wizard.getJob();

			NewEditJob newEditJob = new NewEditJob(
					screenService.getScreenContainer(), SWT.NONE);
			newEditJob.setOperation(wizard.getOperation());
			newEditJob.setScreenService(screenService);
			newEditJob.injectData(jobResource, job);
			screenService.setActiveScreen(newEditJob);
		}
	}

	public void callBackEvent(MonitoringStateEvent event) {
		Object result = event.getResult();
		System.out.println(result);
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				monitoringTreeViewer.refresh();
			}
		});
	}
}
