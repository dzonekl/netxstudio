/*******************************************************************************
 * Copyright (c) 17 mei 2013 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.f4;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
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
import org.eclipse.ui.IMemento;
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
import com.netxforge.netxstudio.screens.editing.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.ScreenUtil;
import com.netxforge.netxstudio.screens.editing.actions.SeparatorAction;
import com.netxforge.netxstudio.screens.editing.filter.SearchFilter;

/**
 * @author Christophe Bouhier
 */
public class MetricSources extends AbstractScreen implements
		IDataServiceInjection {

	private static final String MEM_KEY_METRICSOURCE_SELECTION_TABLE = "MEM_KEY_METRICSOURCE_SELECTION_TABLE";
	private static final String MEM_KEY_METRICSOURCE_COLUMNS_TABLE = "MEM_KEY_METRICSOURCE_COLUMNS_TABLE";
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table metricSourceTable;
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
					editMetricSourceScreen
							.setOperation(ScreenUtil.OPERATION_EDIT);
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
		metricSourceTableViewer.addFilter(new SearchFilter());

		metricSourceTable = metricSourceTableViewer.getTable();
		metricSourceTable.setLinesVisible(true);
		metricSourceTable.setHeaderVisible(true);
		metricSourceTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 3, 4));

		toolkit.paintBordersFor(metricSourceTable);

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

		TableViewerColumn tableViewerType = new TableViewerColumn(
				metricSourceTableViewer, SWT.NONE);
		TableColumn tblclmnType = tableViewerType.getColumn();
		tblclmnType.setWidth(60);
		tblclmnType.setText("Mapping Type");

		TableViewerColumn tableViewerFilterPattern = new TableViewerColumn(
				metricSourceTableViewer, SWT.NONE);
		TableColumn tblclmnFilterPattern = tableViewerFilterPattern.getColumn();
		tblclmnFilterPattern.setWidth(300);
		tblclmnFilterPattern.setText("File pattern");

		metricSourceTable.setFocus();
	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		metricSourceTableViewer.setContentProvider(listContentProvider);

		final IObservableSet knownElements = listContentProvider
				.getKnownElements();

		List<IObservableMap> maps = Lists.newArrayList();

		maps.add(EMFProperties.value(
				MetricsPackage.Literals.METRIC_SOURCE__NAME).observeDetail(
				knownElements));

		maps.add(EMFProperties.value(
				MetricsPackage.Literals.METRIC_SOURCE__METRIC_LOCATION)
				.observeDetail(knownElements));

		maps.add(EMFProperties.value(
				MetricsPackage.Literals.METRIC_SOURCE__METRIC_MAPPING)
				.observeDetail(knownElements));

		IObservableMap[] observeMaps = new IObservableMap[maps.size()];
		maps.toArray(observeMaps);

		metricSourceTableViewer
				.setLabelProvider(new MetricSourceObservableMapLabelProvider(
						observeMaps));

		IEMFListProperty l = EMFEditProperties.resource(editingService
				.getEditingDomain());
		IObservableList metricSourcesObservableList = l.observe(msResource);
		metricSourceTableViewer.setInput(metricSourcesObservableList);
		return bindingContext;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.AbstractScreenImpl#saveState(org.eclipse
	 * .ui.IMemento)
	 */
	@Override
	public void saveState(IMemento memento) {

		// sash state vertical.
		mementoUtils.rememberStructuredViewerSelection(memento,
				metricSourceTableViewer, MEM_KEY_METRICSOURCE_SELECTION_TABLE);
		mementoUtils.rememberStructuredViewerColumns(memento,
				metricSourceTableViewer, MEM_KEY_METRICSOURCE_COLUMNS_TABLE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.AbstractScreenImpl#init(org.eclipse.
	 * ui.IMemento)
	 */
	@Override
	public void restoreState(IMemento memento) {

		if (memento != null) {
			mementoUtils.retrieveStructuredViewerSelection(memento,
					metricSourceTableViewer,
					MEM_KEY_METRICSOURCE_SELECTION_TABLE,
					((CDOResource) msResource).cdoView());
			mementoUtils
					.retrieveStructuredViewerColumns(memento,
							metricSourceTableViewer,
							MEM_KEY_METRICSOURCE_COLUMNS_TABLE);
		}
	}

}
