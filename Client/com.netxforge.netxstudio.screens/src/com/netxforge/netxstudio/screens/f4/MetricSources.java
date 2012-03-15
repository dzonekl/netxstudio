package com.netxforge.netxstudio.screens.f4;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.model.CDOClassifierRef;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.spi.common.id.AbstractCDOIDLong;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
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
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.SearchFilter;
import com.netxforge.netxstudio.screens.editing.actions.SeparatorAction;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;

public class MetricSources extends AbstractScreen implements
		IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Text txtFilterText;
	private Form frmMetricSources;
	private TableViewer metricSourceTableViewer;
	private Resource msResource;

	@Inject
	ServerRequest serverActions;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public MetricSources(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	public Viewer getViewer() {
		return metricSourceTableViewer;
	}

	public void injectData() {
		msResource = editingService
				.getData(MetricsPackage.Literals.METRIC_SOURCE);
		buildUI();
		initDataBindings_();
	}

	class EditMetricSourceAction extends Action {
		public EditMetricSourceAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			if (screenService != null) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					NewEditMetricSource editMetricSourceScreen = new NewEditMetricSource(
							screenService.getScreenContainer(), SWT.NONE);
					editMetricSourceScreen.setOperation(ScreenUtil.OPERATION_EDIT);
					editMetricSourceScreen.setScreenService(screenService);
					editMetricSourceScreen.injectData(msResource, o);
					screenService.setActiveScreen(editMetricSourceScreen);
				}
			}
		}
	}

	class ScheduleCollectionJobAction extends Action {
		public ScheduleCollectionJobAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			if (screenService != null) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {

					// Object o = ((IStructuredSelection) selection)
					// .getFirstElement();

					if (((IStructuredSelection) selection).size() > 0) {
						@SuppressWarnings("unchecked")
						Iterator<MetricSource> iterator = ((IStructuredSelection) selection)
								.iterator();

						List<MetricSource> metricSources = Lists
								.newArrayList(iterator);
						int operation = -1;
						boolean showJobScreen = false;
						// CB Replaced by model util.
						// List<Job> matchingJobs = editingService
						// .getDataService().getQueryService()
						// .getJobWithMetricSource((MetricSource) o);

						Resource jobResource = editingService
								.getData(SchedulingPackage.Literals.JOB);

						Job job = modelUtils
								.jobForMultipleObjects(
										jobResource,
										SchedulingPackage.Literals.METRIC_SOURCE_JOB,
										SchedulingPackage.Literals.METRIC_SOURCE_JOB__METRIC_SOURCES,
										metricSources);

						// Edit or New if the MetricSource has a job or not.
						if (job != null) {
							operation = ScreenUtil.OPERATION_EDIT;
							showJobScreen = true;
						} else {
							// We could be dealing with a partial match.
							boolean yes = MessageDialog
									.openQuestion(
											MetricSources.this.getShell(),
											"No existing job found ",
											"No existing job was found for the selected Metric Sources\n"
													+ "Do you wish to create a new job for these sources?");

							if (yes) {
								operation = ScreenUtil.OPERATION_NEW;
								job = SchedulingFactory.eINSTANCE
										.createMetricSourceJob();

								MetricSource first = metricSources.get(0);
								job.setName(first.getName()
										+ (metricSources.size() > 1 ? ",..."
												: ""));

								job.setInterval(ModelUtils.SECONDS_IN_A_WEEK);
								job.setStartTime(modelUtils
										.toXMLDate(modelUtils.todayAndNow()));
								job.setJobState(JobState.IN_ACTIVE);
								if (job instanceof MetricSourceJob) {
									((MetricSourceJob) job).getMetricSources()
											.addAll(metricSources);
								}
								showJobScreen = true;
							} else {
								// Abort.
							}
						}
						if (showJobScreen) {
							NewEditJob newEditJob = new NewEditJob(
									screenService.getScreenContainer(),
									SWT.NONE);
							newEditJob.setOperation(operation);
							newEditJob.setScreenService(screenService);
							newEditJob.injectData(jobResource, job);
							screenService.setActiveScreen(newEditJob);
						}
					}
				}
			}
		}
	}

	class StatisticsAction extends Action {
		public StatisticsAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection).getFirstElement();

				// Reading the stats to update?
				if (o instanceof MetricSource) {
					System.out.println("stats size = "
							+ ((MetricSource) o).getStatistics().size());
				}

				MappingStatistics stats = new MappingStatistics(
						screenService.getScreenContainer(), SWT.NONE);
				stats.setOperation(ScreenUtil.OPERATION_READ_ONLY);
				stats.setScreenService(screenService);
				stats.injectData(null, o);
				screenService.setActiveScreen(stats);
			}
		}
	}

	class CollectNowAction extends Action {
		public CollectNowAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection).getFirstElement();
				if (o instanceof MetricSource) {
					final MetricSource ms = (MetricSource) o;
					try {
						serverActions.setCDOServer(editingService
								.getDataService().getProvider().getServer());

						@SuppressWarnings("unused")
						String result = serverActions
								.callMetricImportAction(ms);

						// @SuppressWarnings("unused")
						// WorkflowRunJob workflowRunJob = serverActions
						// .jobFromRequest(result);

						MessageDialog
								.openInformation(
										MetricSources.this.getShell(),
										"Collect now succeeded:",
										"Collection of data from metric source: "
												+ ms.getName()
												+ "\n has been initiated on the server.");

						// TODO, Disable for now, requires more testing.
						// workflowRunJob.addNotifier(new JobChangeAdapter() {
						//
						// @Override
						// public void done(IJobChangeEvent event) {
						// MessageDialog.openInformation(
						// MetricSources.this.getShell(),
						// "Collect now completed:",
						// "Collection of data from metric source: "
						// + ms.getName()
						// + "\n has been initiated on the server.");
						// }
						// });
						// workflowRunJob.go();

					} catch (Exception e1) {
						e1.printStackTrace();
						MessageDialog
								.openError(
										MetricSources.this.getShell(),
										"Collect now failed:",
										"Collection of data from metric source: "
												+ ms.getName()
												+ "\n failed. Consult the log for information on the failure");

					}

				}
			}
		}
	}

	class FindResourcesAction extends Action {
		public FindResourcesAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection).getFirstElement();
				if (o instanceof MetricSource) {
					MetricSource ms = (MetricSource) o;
					Resource metricResource = editingService
							.getData(MetricsPackage.Literals.METRIC);
					List<NetXResource> resourcesInMetricSource = modelUtils
							.resourcesInMetricSource(
									metricResource.getContents(), ms);
					if (resourcesInMetricSource.isEmpty()) {
						System.out
								.println("No resources for this metricsource");
					}
					for (NetXResource res : resourcesInMetricSource) {
						System.out.println("resource: " + res.getShortName());
					}
				}
			}
		}
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmMetricSources = toolkit.createForm(this);
		frmMetricSources.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmMetricSources);
		frmMetricSources.setText("Metric Sources");
		frmMetricSources.getBody().setLayout(new GridLayout(3, false));

		@SuppressWarnings("unused")
		Label lblFilterLabel = toolkit.createLabel(frmMetricSources.getBody(),
				"Filter:", SWT.NONE);

		txtFilterText = toolkit.createText(frmMetricSources.getBody(),
				"New Text", SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.setText("");
		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);

		txtFilterText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				ViewerFilter[] filters = metricSourceTableViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof SearchFilter) {
						((SearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
				metricSourceTableViewer.refresh();
			}
		});

		ImageHyperlink mghprlnkNewImagehyperlink = toolkit
				.createImageHyperlink(frmMetricSources.getBody(), SWT.NONE);
		mghprlnkNewImagehyperlink
				.addHyperlinkListener(new IHyperlinkListener() {
					public void linkActivated(HyperlinkEvent e) {
						NewEditMetricSource msScreen = new NewEditMetricSource(
								screenService.getScreenContainer(), SWT.NONE);
						msScreen.setOperation(ScreenUtil.OPERATION_NEW);
						msScreen.setScreenService(screenService);

						msScreen.injectData(msResource,
								MetricsFactory.eINSTANCE.createMetricSource());
						screenService.setActiveScreen(msScreen);

					}

					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}
				});
		mghprlnkNewImagehyperlink.setImage(ResourceManager.getPluginImage(
				"com.netxforge.netxstudio.models.edit",
				"icons/full/ctool16/Metricsource_E.png"));
		mghprlnkNewImagehyperlink.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, false, false, 1, 1));
		toolkit.paintBordersFor(mghprlnkNewImagehyperlink);
		mghprlnkNewImagehyperlink.setText("New");

		metricSourceTableViewer = new TableViewer(frmMetricSources.getBody(),
				SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI | SWT.VIRTUAL);
		metricSourceTableViewer.setUseHashlookup(true);
		metricSourceTableViewer.setComparer(new CDOElementComparer());
		metricSourceTableViewer.addFilter(new SearchFilter(editingService));

		table = metricSourceTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 4));
		table.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				Object o = e.item.getData();
				if (o instanceof MetricSource) {
					MetricSource ms = (MetricSource) o;
					System.out.println(ms.getName() + "--" + ms.cdoState());
					CDORevision cdoRevision = ms.cdoRevision();
					if (cdoRevision != null) {
						if (ms.cdoInvalid()) {
							System.out.println("object not locally valid ");
							// CDOSession session =
							// editingService.getDataService().getProvider().getSession();
							// session.getRevisionManager().getRevisions(ids,
							// ms.cdoRevision().getBranch()., referenceChunk,
							// CDORevision.DEPTH_INFINITE, true);
						}
						System.out.println(" version ="
								+ cdoRevision.getVersion() + " timestamp="
								+ new Date(cdoRevision.getTimeStamp()));
						CDOID cdoID = ms.cdoID();
						long longValue = ((AbstractCDOIDLong) cdoID)
								.getLongValue();

						CDOID createLongWithClassifier = CDOIDUtil
								.createLongWithClassifier(new CDOClassifierRef(
										MetricsPackage.Literals.METRIC_SOURCE),
										longValue);

						CDOTransaction transaction = editingService
								.getDataService().getProvider()
								.getTransaction();
						CDOObject object = transaction
								.getObject(createLongWithClassifier);
						System.out
								.println(" reloaded object ="
										+ object.cdoRevision().getVersion()
										+ " timestamp="
										+ new Date(object.cdoRevision()
												.getTimeStamp()));
						editingService.getDataService().getProvider()
								.commitTransaction();
						// metricSourceTableViewer.refresh(true);
						// CDOResource cdoResource = ms.cdoResource();
						// cdoResource.cdoReload();
					}
				}
			}
		});

		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				metricSourceTableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(300);
		tblclmnNewColumn.setText("Name");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				metricSourceTableViewer, SWT.NONE);
		TableColumn tblclmnLocationUrl = tableViewerColumn_1.getColumn();
		tblclmnLocationUrl.setWidth(300);
		tblclmnLocationUrl.setText("Location URL");

		TableViewerColumn tableViewerColumnLastUpdate = new TableViewerColumn(
				metricSourceTableViewer, SWT.NONE);
		TableColumn tblclmnLocationLastUpdate = tableViewerColumnLastUpdate
				.getColumn();
		tblclmnLocationLastUpdate.setWidth(300);
		tblclmnLocationLastUpdate.setText("Last update");
	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		metricSourceTableViewer.setContentProvider(listContentProvider);

		IObservableMap[] observeMaps = EMFObservables
				.observeMaps(
						listContentProvider.getKnownElements(),
						new EStructuralFeature[] {
								MetricsPackage.Literals.METRIC_SOURCE__NAME,
								MetricsPackage.Literals.METRIC_SOURCE__METRIC_LOCATION });
		metricSourceTableViewer
				.setLabelProvider(new MetricSourceObservableMapLabelProvider(
						observeMaps));

		IEMFListProperty l = EMFEditProperties.resource(editingService
				.getEditingDomain());
		IObservableList metricSourcesObservableList = l.observe(msResource);
		metricSourceTableViewer.setInput(metricSourcesObservableList);
		return bindingContext;
	}

	public class MetricSourceObservableMapLabelProvider extends
			ObservableMapLabelProvider {

		public MetricSourceObservableMapLabelProvider(
				IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {

			if (element instanceof MetricSource) {

				MetricSource ms = (MetricSource) element;
				switch (columnIndex) {
				case 0: {
					return ms.getName();
				}
				case 1: {
					return ms.getMetricLocation();
				}
				case 2: {

//					long ts = modelUtils.mostRecentContainedDated(ms);
//					if (ts == 0) {
//						return "<unknown>";
//					}
//					Date d = new Date(ts);
//					return modelUtils.date(d) + " @ " + modelUtils.time(d);
					return "";
				}

				}

			}
			return super.getColumnText(element, columnIndex);
		}

	}

	public boolean isValid() {
		return false;
	}

	public Form getScreenForm() {
		return this.frmMetricSources;
	}

	private final List<IAction> actions = Lists.newArrayList();

	@Override
	public IAction[] getActions() {
		
		// lazy init actions.
		if (actions.isEmpty()) {
			boolean readonly = ScreenUtil.isReadOnlyOperation(getOperation());
			String actionText = readonly ? "View" : "Edit";
			actions.add(new EditMetricSourceAction(actionText + "..."));
			actions.add(new SeparatorAction());
			if (!readonly) {

				actions.add(new ScheduleCollectionJobAction(
						"Schedule Collection Job..."));
				CollectNowAction collectNowAction = new CollectNowAction(
						"Collect Now (sorry disabled)...");
				collectNowAction.setEnabled(false);
				actions.add(collectNowAction);

			}
			actions.add(new StatisticsAction("Statistics..."));
			actions.add(new SeparatorAction());
			// actions.add(new FindResourcesAction("Resources for...",
			// SWT.PUSH));
		}
		
		return actions.toArray(new IAction[actions.size()]);
	}

	@Override
	public String getScreenName() {
		return "Metric Sources";
	}

}
