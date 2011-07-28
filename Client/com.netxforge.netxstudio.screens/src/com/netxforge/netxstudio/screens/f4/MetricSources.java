package com.netxforge.netxstudio.screens.f4;

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
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
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
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.SearchFilter;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

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
		public EditMetricSourceAction(String text, int style) {
			super(text, style);
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
					editMetricSourceScreen.setOperation(Screens.OPERATION_EDIT);
					editMetricSourceScreen.setScreenService(screenService);
					editMetricSourceScreen.injectData(msResource, o);
					screenService.setActiveScreen(editMetricSourceScreen);
				}
			}
		}
	}

	class ScheduleCollectionJobAction extends Action {
		public ScheduleCollectionJobAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			if (screenService != null) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					if (o instanceof MetricSource) {

						int operation = -1;

						List<Job> matchingJobs = editingService
								.getDataService().getQueryService()
								.getJobWithMetricSource((MetricSource) o);

						Resource jobResource = editingService
								.getData(SchedulingPackage.Literals.JOB);
						Job job = null;

						// Edit or New if the MetricSource has a job or not.
						if (matchingJobs.size() == 1) {
							operation = Screens.OPERATION_EDIT;
							job = matchingJobs.get(0);
						} else {
							operation = Screens.OPERATION_NEW;
							job = SchedulingFactory.eINSTANCE
									.createMetricSourceJob();
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

	class StatisticsAction extends Action {
		public StatisticsAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection).getFirstElement();

				MappingStatistics stats = new MappingStatistics(
						screenService.getScreenContainer(), SWT.NONE);
				stats.setOperation(Screens.OPERATION_READ_ONLY);
				stats.setScreenService(screenService);
				stats.injectData(null, o);
				screenService.setActiveScreen(stats);
			}
		}
	}

	
	class CollectNowAction extends Action {
		public CollectNowAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection)
						.getFirstElement();
				if (o instanceof MetricSource) {
					MetricSource ms = (MetricSource) o;
					try {
						serverActions
								.setServer(editingService.getDataService()
										.getProvider().getServer());
						// TODO, We get the workflow run ID back, which
						// could be used
						// to link back to the screen showing the running
						// workflows.

						@SuppressWarnings("unused")
						String result = serverActions
								.callMetricImportAction(ms);
						MessageDialog.openInformation(
								MetricSources.this.getShell(),
								"Collect now succeeded:",
								"Collection of data from metric source: "
										+ ms.getName()
										+ "\n has been initiated on the server.");

					} catch (Exception e1) {
						e1.printStackTrace();
						MessageDialog.openError(
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
				metricSourceTableViewer.refresh();
				ViewerFilter[] filters = metricSourceTableViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof SearchFilter) {
						((SearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
			}
		});

		ImageHyperlink mghprlnkNewImagehyperlink = toolkit
				.createImageHyperlink(frmMetricSources.getBody(), SWT.NONE);
		mghprlnkNewImagehyperlink
				.addHyperlinkListener(new IHyperlinkListener() {
					public void linkActivated(HyperlinkEvent e) {
						NewEditMetricSource msScreen = new NewEditMetricSource(
								screenService.getScreenContainer(), SWT.NONE);
						msScreen.setOperation(Screens.OPERATION_NEW);
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
				SWT.BORDER | SWT.FULL_SELECTION);
		table = metricSourceTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 4));
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				metricSourceTableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Name");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				metricSourceTableViewer, SWT.NONE);
		TableColumn tblclmnLocationUrl = tableViewerColumn_1.getColumn();
		tblclmnLocationUrl.setWidth(300);
		tblclmnLocationUrl.setText("Location URL");
		metricSourceTableViewer.addFilter(new SearchFilter(editingService));

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
				.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		IEMFListProperty l = EMFEditProperties.resource(editingService
				.getEditingDomain());
		IObservableList metricSourcesObservableList = l.observe(msResource);
		metricSourceTableViewer.setInput(metricSourcesObservableList);
		return bindingContext;
	}

	public void disposeData() {
		if (editingService != null) {
			editingService.disposeData(msResource);
		}
	}

	public boolean isValid() {
		return false;
	}

	@Override
	public Form getScreenForm() {
		return this.frmMetricSources;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}

	@Override
	public IAction[] getActions() {

		List<IAction> actions = Lists.newArrayList();
		boolean readonly = Screens.isReadOnlyOperation(getOperation());
		String actionText = readonly ? "View" : "Edit";
		actions.add(new EditMetricSourceAction(actionText + "...", SWT.PUSH));
		if (!readonly) {
			
			actions.add(new ScheduleCollectionJobAction(
					"Schedule Collection Job...", SWT.PUSH));
			actions.add(new CollectNowAction("Collect Now...", SWT.PUSH));
		}
		actions.add(new StatisticsAction("Statistics...", SWT.PUSH));
		
		IAction[] actionArray = new IAction[actions.size()];
		return actions.toArray(actionArray);
	}

}
