package com.netxforge.netxstudio.screens.f1;

import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
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
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob;
import com.netxforge.netxstudio.scheduling.RFSServiceReporterJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f4.NewEditJob;
import com.netxforge.netxstudio.screens.f4.ServiceMonitors;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceMonitor;
import com.netxforge.netxstudio.services.ServicesFactory;
import com.netxforge.netxstudio.services.ServicesPackage;

public class Services extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Text txtFilterText;

	private TableViewer servicesTableViewer;
	private Form frmServices;
	private Resource operatorsResource;

	@Inject
	ServerRequest serverActions;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public Services(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
				// obm.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		// buildUI();

	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmServices = toolkit.createForm(this);
		frmServices.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmServices);
		frmServices.setText("Services");
		frmServices.getBody().setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(frmServices.getBody(),
				"Filter:", SWT.NONE);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 44;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmServices.getBody(), "New Text",
				SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.setText("");
		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);

		ImageHyperlink mghprlnkNew = toolkit.createImageHyperlink(
				frmServices.getBody(), SWT.NONE);
		mghprlnkNew.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				if (screenService != null) {
					NewEditService smScreen = new NewEditService(screenService
							.getScreenContainer(), SWT.NONE);
					smScreen.setOperation(getOperation());
					smScreen.setScreenService(screenService);
					smScreen.injectData(operatorsResource,
							ServicesFactory.eINSTANCE.createRFSService());
					screenService.setActiveScreen(smScreen);
				}
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		mghprlnkNew.setImage(ResourceManager.getPluginImage(
				"com.netxforge.netxstudio.models.edit",
				"icons/full/ctool16/Service_E.png"));
		mghprlnkNew.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		toolkit.paintBordersFor(mghprlnkNew);
		mghprlnkNew.setText("New");

		servicesTableViewer = new TableViewer(frmServices.getBody(), SWT.BORDER
				| SWT.FULL_SELECTION);
		table = servicesTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		toolkit.paintBordersFor(table);

		TableViewerColumn tblViewerClmType = new TableViewerColumn(
				servicesTableViewer, SWT.NONE);
		TableColumn tblclmnName = tblViewerClmType.getColumn();
		tblclmnName.setWidth(106);
		tblclmnName.setText("Name");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				servicesTableViewer, SWT.NONE);
		TableColumn tblclmnDescription = tableViewerColumn.getColumn();
		tblclmnDescription.setWidth(104);
		tblclmnDescription.setText("Description");

	}

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author dzonekl
	 * 
	 */
	class ServiceMonitoringAction extends Action {

		public ServiceMonitoringAction(String text, int style) {
			super(text, style);
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
					smScreen.setOperation(Screens.OPERATION_READ_ONLY);
					smScreen.setScreenService(screenService);
					smScreen.injectData(null, o);
					screenService.setActiveScreen(smScreen);
				}
			}
		}
	}

	class MonitorNowAction extends Action {
		public MonitorNowAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection).getFirstElement();
				if (o instanceof Service) {
					Service service = (Service) o;
					try {
						serverActions.setCDOServer(editingService.getDataService()
								.getProvider().getServer());

						// TODO, provide a dialog for monitoring period
						// selection.

						Date fromDate = null;
						Date toDate = null;

						@SuppressWarnings("unused")
						String result = serverActions.callMonitorAction(
								service, fromDate, toDate);
						// TODO, We get the workflow run ID back, which
						// could be used
						// to link back to the screen showing the running
						// workflows.

						MessageDialog
								.openInformation(
										Services.this.getShell(),
										"Monitor now succeeded:",
										"Monitoring of service: "
												+ service.getServiceName()
												+ "\n has been initiated on the server.");

					} catch (Exception e1) {
						e1.printStackTrace();
						MessageDialog
								.openError(
										Services.this.getShell(),
										"Monitor now failed:",
										"Monitoring of service: "
												+ service.getServiceName()
												+ "\n failed. Consult the log for information on the failure");

					}

				}
			}
		}
	}

	class ReportNowAction extends Action {
		public ReportNowAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection).getFirstElement();
				if (o instanceof Service) {
					Service service = (Service) o;
					try {
						serverActions.setCDOServer(editingService.getDataService()
								.getProvider().getServer());

						// TODO, provide a dialog for monitoring period
						// selection.

						Date fromDate = null;
						Date toDate = null;

						@SuppressWarnings("unused")
						String result = serverActions.callReportingAction(
								service, fromDate, toDate);
						// TODO, We get the workflow run ID back, which
						// could be used
						// to link back to the screen showing the running
						// workflows.

						MessageDialog
								.openInformation(
										Services.this.getShell(),
										"Reporting now succeeded:",
										"Reporting of service: "
												+ service.getServiceName()
												+ "\n has been initiated on the server.");

					} catch (Exception e1) {
						e1.printStackTrace();
						MessageDialog
								.openError(
										Services.this.getShell(),
										"Reporting now failed:",
										"Reporting of service: "
												+ service.getServiceName()
												+ "\n failed. Consult the log for information on the failure");

					}

				}
			}
		}
	}

	class ScheduleMonitorJobAction extends Action {
		public ScheduleMonitorJobAction(String text, int style) {
			super(text, style);
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

						List<Job> matchingJobs = editingService
								.getDataService().getQueryService()
								.getJobWithService((Service) o);
						Resource jobResource = editingService
								.getData(SchedulingPackage.Literals.JOB);
						Job job = null;

						// Edit or New if the Service has a job or not.
						if (matchingJobs.size() == 1) {
							operation = Screens.OPERATION_EDIT;
							job = matchingJobs.get(0);
						} else {
							operation = Screens.OPERATION_NEW;
							job = SchedulingFactory.eINSTANCE
									.createRFSServiceMonitoringJob();
							job.setName(((Service) o).getServiceName());
							job.setInterval(ModelUtils.SECONDS_IN_A_WEEK);
							job.setStartTime(modelUtils.toXMLDate(modelUtils
									.todayAndNow()));

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
		public ScheduleReportingJobAction(String text, int style) {
			super(text, style);
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

						List<Job> matchingJobs = editingService
								.getDataService().getQueryService()
								.getJobWithServiceReporting((Service) o);

						Resource jobResource = editingService
								.getData(SchedulingPackage.Literals.JOB);
						Job job = null;

						// Edit or New if the Service has a job or not.
						if (matchingJobs.size() == 1) {
							operation = Screens.OPERATION_EDIT;
							job = matchingJobs.get(0);
						} else {
							operation = Screens.OPERATION_NEW;
							job = SchedulingFactory.eINSTANCE
									.createRFSServiceReporterJob();
							job.setName(((Service) o).getServiceName());
							job.setInterval(ModelUtils.SECONDS_IN_A_WEEK);
							job.setStartTime(modelUtils.toXMLDate(modelUtils
									.todayAndNow()));
							if (job instanceof RFSServiceReporterJob) {
								((RFSServiceReporterJob) job)
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

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author dzonekl
	 * 
	 */
	class EditServiceAction extends Action {

		public EditServiceAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			super.run();
			if (screenService != null) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					NewEditService smScreen = new NewEditService(
							screenService.getScreenContainer(), SWT.NONE);
					smScreen.setOperation(getOperation());
					smScreen.setScreenService(screenService);
					smScreen.injectData(operatorsResource, o);
					screenService.setActiveScreen(smScreen);
				}
			}
		}
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		// tblViewerClmnState.setEditingSupport(new CheckBoxEditingSupport(
		// jobsTableViewer, bindingContext));

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		servicesTableViewer.setContentProvider(listContentProvider);

		IObservableMap[] observeMaps = EMFObservables
				.observeMaps(
						listContentProvider.getKnownElements(),
						new EStructuralFeature[] {
								ServicesPackage.Literals.SERVICE__SERVICE_NAME,
								ServicesPackage.Literals.SERVICE__SERVICE_DESCRIPTION });
		servicesTableViewer
				.setLabelProvider(new ServiceMonitorsObervableMapLabelProvider(
						observeMaps));

		IEMFListProperty serviceProperty = EMFEditProperties
				.resource(editingService.getEditingDomain());
		IObservableList rfsServicesObservableList = serviceProperty
				.observe(operatorsResource);
		// obm.addObservable(rfsServicesObservableList);
		servicesTableViewer.setInput(rfsServicesObservableList);

		return bindingContext;
	}

	class ServiceMonitorsObervableMapLabelProvider extends
			ObservableMapLabelProvider {

		public ServiceMonitorsObervableMapLabelProvider(
				IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return super.getColumnImage(element, columnIndex);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof ServiceMonitor) {
				ServiceMonitor sm = (ServiceMonitor) element;
				switch (columnIndex) {
				case 0:
					if (sm.getName() != null) {
						return sm.getName();
					}
					break;
				case 1:
					if (sm.getRevision() != null) {
						return sm.getRevision();
					}
					break;
				case 2:
					if (sm.getPeriod() != null) {
						Date begin = modelUtils.fromXMLDate(sm.getPeriod()
								.getBegin());
						return modelUtils.date(begin) + modelUtils.time(begin);
					}
					break;
				case 3:
					if (sm.getPeriod() != null) {
						Date end = modelUtils.fromXMLDate(sm.getPeriod()
								.getEnd());
						return modelUtils.date(end) + modelUtils.time(end);
					}
					break;
				}
			}
			return super.getColumnText(element, columnIndex);
		}
	}

	public void injectData() {
		operatorsResource = editingService
				.getData(OperatorsPackage.Literals.OPERATOR);
		buildUI();
		initDataBindings_();
	}

	public void disposeData() {
		editingService.disposeData(operatorsResource);
	}

	@Override
	public Viewer getViewer() {
		return servicesTableViewer;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return frmServices;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;

	}

	@Override
	public IAction[] getActions() {

		boolean readonly = Screens.isReadOnlyOperation(getOperation());

		List<IAction> actions = Lists.newArrayList();

		String actionText = Screens.isReadOnlyOperation(getOperation()) ? "View"
				: "Edit";

		actions.add(new EditServiceAction(actionText + "...", SWT.PUSH));

		actions.add(new ServiceMonitoringAction("Monitor...", SWT.PUSH));

		if (!readonly) {
			actions.add(new ScheduleMonitorJobAction(
					"Schedule Monitoring Job...", SWT.PUSH));

			actions.add(new MonitorNowAction("Monitor Now...", SWT.PUSH));

			actions.add(new ScheduleReportingJobAction(
					"Schedule Reporting Job...", SWT.PUSH));

			actions.add(new ReportNowAction("Report Now...", SWT.PUSH));
		}

		IAction[] actionArray = new IAction[actions.size()];
		return actions.toArray(actionArray);
	}

}
