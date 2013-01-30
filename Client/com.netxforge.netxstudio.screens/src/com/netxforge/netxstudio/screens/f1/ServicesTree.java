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
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.SearchFilter;
import com.netxforge.netxstudio.screens.dialog.OperatorFilterDialog;
import com.netxforge.netxstudio.screens.editing.actions.SeparatorAction;
import com.netxforge.netxstudio.screens.editing.actions.WizardUtil;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.f1.details.NewEditServiceTree_refactor;
import com.netxforge.netxstudio.screens.f1.support.RFSServiceTreeFactoryImpl;
import com.netxforge.netxstudio.screens.f1.support.RFSServiceTreeLabelProvider;
import com.netxforge.netxstudio.screens.f1.support.ScheduledReportSelectionWizard;
import com.netxforge.netxstudio.screens.f4.NewEditJob;
import com.netxforge.netxstudio.screens.f4.ServiceMonitors;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServicesFactory;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class ServicesTree extends AbstractScreen implements
		IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;
	@SuppressWarnings("unused")
	private DataBindingContext bindingContext;
	private Form frmServices;
	private TreeViewer serviceTreeViewer;
	private Composite cmpDetails;
	private SashForm sashForm;
	// private Resource rfsServiceResource;
	private Resource operatorsResource;

	@Inject
	ServerRequest serverActions;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ServicesTree(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				// obm.dispose();
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

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmServices = toolkit.createForm(this);

		frmServices.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmServices);

		frmServices.setText(this.getOperationText() + "Services");
		frmServices.getBody().setLayout(new FillLayout(SWT.HORIZONTAL));

		sashForm = new SashForm(frmServices.getBody(), SWT.VERTICAL);
		sashForm.setOrientation(SWT.HORIZONTAL);
		toolkit.adapt(sashForm);
		toolkit.paintBordersFor(sashForm);

		Composite composite = toolkit.createComposite(sashForm, SWT.NONE);
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
				serviceTreeViewer.refresh();
				ViewerFilter[] filters = serviceTreeViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof SearchFilter) {
						((SearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
			}
		});

		if (!readonly) {
			hypLnkNewRFSService = toolkit.createImageHyperlink(composite,
					SWT.NONE);
			hypLnkNewRFSService.setImage(ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/ctool16/Service_E.png"));
			hypLnkNewRFSService.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {

					OperatorFilterDialog dialog = new OperatorFilterDialog(
							ServicesTree.this.getShell(), operatorsResource);
					int result = dialog.open();

					if (result == Window.OK) {
						Operator operator = (Operator) dialog.getFirstResult();

						// Create a new top level nodetype.
						RFSService newRFSService = ServicesFactory.eINSTANCE
								.createRFSService();
						newRFSService
								.setServiceName("<new Resource Facing Service>");
						Command add = new AddCommand(editingService
								.getEditingDomain(), operator.getServices(),
								newRFSService);
						editingService.getEditingDomain().getCommandStack()
								.execute(add);
					}
				}

				public void linkEntered(HyperlinkEvent e) {
				}

				public void linkExited(HyperlinkEvent e) {
				}
			});
			hypLnkNewRFSService.setLayoutData(new GridData(SWT.RIGHT,
					SWT.CENTER, false, false, 1, 1));
			toolkit.paintBordersFor(hypLnkNewRFSService);
			hypLnkNewRFSService.setText("New");

		}

		serviceTreeViewer = new TreeViewer(composite, SWT.BORDER | SWT.MULTI
				| SWT.VIRTUAL | widgetStyle);
		serviceTreeViewer.setUseHashlookup(true);
		serviceTreeViewer.setComparer(new CDOElementComparer());

		serviceTreeViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						final ISelection s = event.getSelection();
						// TODO, We could even wait to see if we get another
						// update within 100ms.
						// If we do, we would cancel.

						ServicesTree.this.getDisplay().asyncExec(
								new Runnable() {
									public void run() {
										if (s instanceof IStructuredSelection) {
											IStructuredSelection ss = (IStructuredSelection) s;
											Object o = ss.getFirstElement();
											try {
												handleDetailsSelection(o);
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
									}
								});

					}
				});
		Tree tree = serviceTreeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 2));
		tree.setSize(74, 81);
		toolkit.paintBordersFor(tree);

		cmpDetails = toolkit.createComposite(sashForm, SWT.NONE);
		toolkit.paintBordersFor(cmpDetails);
		cmpDetails.setLayout(new FillLayout());
		sashForm.setWeights(new int[] { 3, 7 });

	}

	/**
	 * @author Christophe Bouhier
	 */
	class ExportHTMLAction extends Action {

		public ExportHTMLAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			ISelection s = serviceTreeViewer.getSelection();
			if (s instanceof IStructuredSelection) {

				// TODO Migrate.

				// WizardUtil
				// .openWizard(
				// "com.netxforge.netxstudio.models.export.wizard.ui.nodetype.html",
				// (IStructuredSelection) s);
			}
		}
	}

	/**
	 * @author Christophe Bouhier
	 */
	class ExportXLSAction extends Action {

		public ExportXLSAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			ISelection s = serviceTreeViewer.getSelection();
			if (s instanceof IStructuredSelection) {

				// TODO Migrate
				// WizardUtil
				// .openWizard(
				// "com.netxforge.netxstudio.models.export.wizard.ui.nodetype.xls",
				// (IStructuredSelection) s);
			}
		}
	}

	private final List<IAction> actions = Lists.newArrayList();

	@Override
	public IAction[] getActions() {

		if (actions.isEmpty()) {
			boolean readonly = ScreenUtil.isReadOnlyOperation(getOperation());

			// actions.add(new ExportHTMLAction("Export to HTML", SWT.PUSH));
			// actions.add(new ExportXLSAction("Export to XLS", SWT.PUSH));
			// actions.add(new SeparatorAction());

			if (!readonly) {
				actions.add(new ScheduleMonitorJobAction(
						"Schedule Monitoring Job..."));
				actions.add(new MonitorNowAction("Monitor Now..."));
			}
			actions.add(new ServiceMonitoringAction("Monitoring Result..."));
			actions.add(new SeparatorAction());

			actions.add(new SeparatorAction());
			if (!readonly) {
				actions.add(new ScheduleReportingJobAction(
						"Schedule Reporting Job..."));
			}
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

		ObservableListTreeContentProvider cp = new ObservableListTreeContentProvider(
				new RFSServiceTreeFactoryImpl(editingService.getEditingDomain()),
				new RFSServiceTreeStructureAdvisorImpl());
		serviceTreeViewer.setContentProvider(cp);
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

		serviceTreeViewer
				.setLabelProvider(new RFSServiceTreeLabelProvider(map));
		IEMFListProperty projects = EMFEditProperties.resource(editingService
				.getEditingDomain());

		IObservableList servicesObservableList = projects
				.observe(operatorsResource);
		serviceTreeViewer.setInput(servicesObservableList);

		return bindingContext;
	}

	class RFSServiceTreeStructureAdvisorImpl extends TreeStructureAdvisor {
		@Override
		public Object getParent(Object element) {
			// Can't determine parent.
			// if (element instanceof Project)
			// {
			// return ((Project)element).getParent();
			// }
			return null;
		}

		@Override
		public Boolean hasChildren(Object element) {
			if (element instanceof Operator
					&& (((Operator) element).getServices().size() > 0)) {
				return Boolean.TRUE;
			}
			if (element instanceof RFSService
					&& (((RFSService) element).getServices().size() > 0)) {
				return Boolean.TRUE;
			}

			return super.hasChildren(element);
		}
	}

	Composite currentDetails;
	private ImageHyperlink hypLnkNewRFSService;

	private void handleDetailsSelection(Object o) {

		if (currentDetails != null && !currentDetails.isDisposed()) {
			currentDetails.dispose();
		}
		if (o instanceof RFSService) {
			final NewEditServiceTree_refactor screen = new NewEditServiceTree_refactor(
					this.cmpDetails, SWT.NONE, editingService);
			screen.setParentScreen(this);
			screen.setScreenService(screenService);
			screen.setOperation(getOperation());
			screen.injectData(null, o);
			sashForm.layout(true, true);

			this.currentDetails = screen;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.ui.viewer.IViewerProvider#getViewer()
	 */
	public Viewer getViewer() {

		if (currentDetails != null) {
			if (currentDetails instanceof IScreen) {
				final Viewer v = ((IScreen) currentDetails).getViewer();
				if (v != null) {
					return v;
				}
			}
		}
		return serviceTreeViewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.selector.IScreen#isValid()
	 */
	public boolean isValid() {
		return true;
	}

	public Form getScreenForm() {
		return this.frmServices;
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

	class ShowDistributionAction extends Action {
		public ShowDistributionAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection).getFirstElement();
				if (o instanceof Service) {
					@SuppressWarnings("unused")
					Service service = (Service) o;

					// Show service distribution.
				}
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

			WizardDialog dialog = new WizardDialog(
					ServicesTree.this.getShell(), wizard);
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

	@Override
	public String getScreenName() {
		return "Services";
	}
}
