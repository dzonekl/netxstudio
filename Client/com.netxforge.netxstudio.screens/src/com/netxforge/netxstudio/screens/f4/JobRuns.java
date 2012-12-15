/*******************************************************************************
 * Copyright (c) May 16, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.f4;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.wb.swt.TableViewerColumnSorter;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunContainer;
import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.editing.actions.BaseSelectionListenerAction;
import com.netxforge.netxstudio.screens.editing.actions.WarningDeleteCommand;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.f4.support.LogDialog;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class JobRuns extends AbstractScreen implements IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	// private Table table;

	private Menu jobRunMenu;

	private CleanJobRunsAction cleanJobRunsAction;

	/*
	 * A Job responsible for refresh.
	 */
	private RefreshUIJob refreshUIJob;

	public JobRuns(Composite parent, int style) {
		super(parent, style);

		refreshUIJob = new RefreshUIJob("refresh JobRuns");

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmJobRuns = toolkit.createForm(this);
		frmJobRuns.setSeparatorVisible(true);
		cleanJobRunsAction = new CleanJobRunsAction("Clean up...");
		frmJobRuns.getMenuManager().add(cleanJobRunsAction);

		toolkit.paintBordersFor(frmJobRuns);

		frmJobRuns.setText("Job: \"Job name\"");
		frmJobRuns.getBody().setLayout(new FormLayout());

		Section sctnInfo = toolkit.createSection(frmJobRuns.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnInfo = new FormData();
		fd_sctnInfo.top = new FormAttachment(frmJobRuns.getBody(), 12);
		fd_sctnInfo.bottom = new FormAttachment(100, -12);
		fd_sctnInfo.right = new FormAttachment(100, -12);
		fd_sctnInfo.left = new FormAttachment(0, 12);
		sctnInfo.setLayoutData(fd_sctnInfo);
		toolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("Runs");

		Composite composite_1 = toolkit.createComposite(sctnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnInfo.setClient(composite_1);
		GridLayout gl_composite_1 = new GridLayout(1, false);
		gl_composite_1.horizontalSpacing = 8;
		composite_1.setLayout(gl_composite_1);

		jobRunsTableViewer = new TableViewer(composite_1, SWT.BORDER
				| SWT.FULL_SELECTION);
		jobRunsTableViewer.setComparer(new CDOElementComparer());
		Table table = jobRunsTableViewer.getTable();

		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(
				jobRunsTableViewer, SWT.NONE);
		TableColumn tblclmnRunType = tableViewerColumn_7.getColumn();
		tblclmnRunType.setWidth(100);
		tblclmnRunType.setText("Run Type");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				jobRunsTableViewer, SWT.NONE);
		TableColumn tblclmnStatus = tableViewerColumn.getColumn();
		tblclmnStatus.setWidth(97);
		tblclmnStatus.setText("Status");

		TableViewerColumn tblViewerColumnProgress = new TableViewerColumn(
				jobRunsTableViewer, SWT.NONE);
		TableColumn tblclmnProgress = tblViewerColumnProgress.getColumn();
		tblclmnProgress.setWidth(116);
		tblclmnProgress.setText("Progress");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				jobRunsTableViewer, SWT.NONE);
		TableColumn tblclmnTask = tableViewerColumn_2.getColumn();
		tblclmnTask.setWidth(114);
		tblclmnTask.setText("Task");

		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(
				jobRunsTableViewer, SWT.NONE);
		TableColumn tblclmnMessage = tableViewerColumn_6.getColumn();
		tblclmnMessage.setWidth(200);
		tblclmnMessage.setText("Message");

		TableViewerColumn tblViewerColumnStarted = new TableViewerColumn(
				jobRunsTableViewer, SWT.NONE);
		TableColumn tblclmnStarted = tblViewerColumnStarted.getColumn();
		tblclmnStarted.setWidth(120);
		tblclmnStarted.setText("Started");

		// Apply a sorter on the started date.
		TableViewerColumnSorter startedColumnSorter = new TableViewerColumnSorter(
				tblViewerColumnStarted) {
			protected int doCompare(Viewer viewer, Object e1, Object e2) {
				if (e1 instanceof WorkFlowRun && e2 instanceof WorkFlowRun) {

					WorkFlowRun re1 = (WorkFlowRun) e1;
					WorkFlowRun re2 = (WorkFlowRun) e2;

					if (re1.eIsSet(SchedulingPackage.Literals.WORK_FLOW_RUN__STARTED)
							&& re2.eIsSet(SchedulingPackage.Literals.WORK_FLOW_RUN__STARTED))
						return re1.getStarted().compare(re2.getStarted());
				}
				return -1;
			}

		};
		startedColumnSorter.setSorter(TableViewerColumnSorter.DESC);

		TableViewerColumn tblViewerColumnEnded = new TableViewerColumn(
				jobRunsTableViewer, SWT.NONE);
		TableColumn tblclmnEnded = tblViewerColumnEnded.getColumn();
		tblclmnEnded.setWidth(120);
		tblclmnEnded.setText("Ended");

		jobRunMenu = new Menu(table);
		table.setMenu(jobRunMenu);

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(
				jobRunsTableViewer, SWT.NONE);
		TableColumn tblclmnLog = tableViewerColumn_3.getColumn();
		tblclmnLog.setWidth(100);
		tblclmnLog.setText("Log");
	}

	private TableViewer jobRunsTableViewer;
	private Form frmJobRuns;
	private Job job;
	private JobRunContainer jobContainer;

	class ShowLogAction extends BaseSelectionListenerAction {

		public ShowLogAction(String text) {
			super(text);
		}

		@Override
		protected boolean updateSelection(IStructuredSelection selection) {
			return assertHasLog(selection.getFirstElement());
		}

		@Override
		public void run() {

			WorkFlowRun wfr = (WorkFlowRun) getStructuredSelection()
					.getFirstElement();
			String log = wfr.getLog();
			LogDialog ld = new LogDialog(JobRuns.this.getShell());
			ld.InjectData(log);
			ld.open();

		}

		private boolean assertHasLog(Object selectedObject) {
			return selectedObject instanceof WorkFlowRun
					&& ((WorkFlowRun) selectedObject)
							.eIsSet(SchedulingPackage.Literals.WORK_FLOW_RUN__LOG);

		}

	}

	class CleanJobRunsAction extends Action {

		public CleanJobRunsAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			if (jobContainer.getWorkFlowRuns().isEmpty()) {
				return;
			}

			boolean openQuestion = MessageDialog
					.openQuestion(
							JobRuns.this.getShell(),
							"Clean previous job runs",
							"When pressing OK, the job runs for this job will be cleared\nThis action can not be reverted");
			if (openQuestion) {
				// yes selected, deletes the workflow runs.
				WarningDeleteCommand dc = new WarningDeleteCommand(
						editingService.getEditingDomain(),
						jobContainer.getWorkFlowRuns());
				editingService.getEditingDomain().getCommandStack().execute(dc);

				if (editingService.isDirty()) {
					editingService.doSave(new NullProgressMonitor());
				}
			}
		}
	}

	class ShowFailuresAction extends BaseSelectionListenerAction {

		public ShowFailuresAction(String text) {
			super(text);
		}

		@Override
		protected boolean updateSelection(IStructuredSelection selection) {
			return assertHasFailures(selection.getFirstElement())
					|| isMetricSourceJob(selection.getFirstElement());
		}

		private boolean assertHasFailures(Object selectedObject) {
			return selectedObject instanceof ComponentWorkFlowRun
					&& ((ComponentWorkFlowRun) selectedObject).getFailureRefs()
							.size() > 0;
		}

		private boolean isMetricSourceJob(Object selectedObject) {
			return job instanceof MetricSourceJob;
		}

		@Override
		public void run() {

			if (job instanceof MetricSourceJob) {
				MessageDialog
						.openInformation(
								Display.getDefault().getActiveShell(),
								"Metric Source",
								"Failures for job: "
										+ job.getName()
										+ ", can be obtained from the mapping statistics for the corresponding Metric source(s)");
			} else {

				ComponentWorkFlowRun cwfr = (ComponentWorkFlowRun) this
						.getStructuredSelection().getFirstElement();
				JobFailuresDialog jf = new JobFailuresDialog(
						JobRuns.this.getShell());
				jf.setBlockOnOpen(true);
				int result = jf.open(cwfr);
				if (result == Window.OK) {
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.data.IDataScreenInjection#injectData(java.lang
	 * .Object, java.lang.Object)
	 */
	public void injectData(Object owner, Object object) {

		// Ignore the owner, we don't add data.

		if (object instanceof Job) {
			job = (Job) object;

			buildUI();
			this.getScreenForm().setText("Job:" + job.getName());

			// Get the job container, forces the registration of invalidation
			// listeners.
			Resource jobRunContainerResource = editingService
					.getData(SchedulingPackage.Literals.JOB_RUN_CONTAINER);

			// find our jobcontainer .
			for (final EObject eObject : jobRunContainerResource.getContents()) {
				final JobRunContainer container = (JobRunContainer) eObject;
				final Job containerJob = container.getJob();
				if (containerJob != null) {
					final CDOID containerJobId = ((CDOObject) containerJob)
							.cdoID();
					if (job.cdoID().equals(containerJobId)) {
						// Container found.
						jobContainer = container;
						this.initDataBindings_();
						break;
					}
				}
			}

			if (jobContainer == null) {

				// There is no container, TODO should really do this test before
				// showing the runs.
				// Do not initiate data binding.
				MessageDialog
						.openInformation(this.getShell(), "Job runs",
								"This job has not run yet, wait for a server job to start. ");
				return;
			}
		}
	}

	private final List<IAction> actions = Lists.newArrayList();

	@Override
	public IAction[] getActions() {

		// lazy init actions.
		if (actions.isEmpty()) {
			actions.add(new ShowLogAction("Show Log..."));
			actions.add(new ShowFailuresAction("Show Failures..."));
		}

		return actions.toArray(new IAction[actions.size()]);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataScreenInjection#addData()
	 */
	public void addData() {
		throw new java.lang.UnsupportedOperationException();
	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		jobRunsTableViewer.setContentProvider(listContentProvider);

		EAttribute dummyAttribute = EcoreFactory.eINSTANCE.createEAttribute();

		IObservableMap[] observeMaps = EMFObservables
				.observeMaps(
						listContentProvider.getKnownElements(),
						new EStructuralFeature[] {
								dummyAttribute,
								SchedulingPackage.Literals.WORK_FLOW_RUN__STATE,
								SchedulingPackage.Literals.WORK_FLOW_RUN__PROGRESS,
								SchedulingPackage.Literals.WORK_FLOW_RUN__PROGRESS_TASK,
								SchedulingPackage.Literals.WORK_FLOW_RUN__PROGRESS_MESSAGE,
								SchedulingPackage.Literals.WORK_FLOW_RUN__STARTED,
								SchedulingPackage.Literals.WORK_FLOW_RUN__ENDED,
								SchedulingPackage.Literals.WORK_FLOW_RUN__LOG });

		WorkflowRunObservableMapLabelProvider workflowRunObservableMapLabelProvider = new WorkflowRunObservableMapLabelProvider(
				observeMaps);
		workflowRunObservableMapLabelProvider
				.setTableViewer(jobRunsTableViewer);
		jobRunsTableViewer
				.setLabelProvider(workflowRunObservableMapLabelProvider);

		IEMFListProperty l = EMFProperties
				.list(SchedulingPackage.Literals.JOB_RUN_CONTAINER__WORK_FLOW_RUNS);
		IObservableList observeWorkFlowRuns = l.observe(jobContainer);
		jobRunsTableViewer.setInput(observeWorkFlowRuns);

		return bindingContext;
	}

	class WorkflowRunObservableMapLabelProvider extends LabelProvider implements
			ILabelProvider, ITableLabelProvider {

		protected IObservableMap[] attributeMaps;
		private TableViewer tableViewer;

		private Map<CDOID, TableEditor> progressCache = Maps.newHashMap();

		@SuppressWarnings("unused")
		private IMapChangeListener mapChangeListener = new IMapChangeListener() {
			public void handleMapChange(MapChangeEvent event) {
				@SuppressWarnings("rawtypes")
				Set affectedElements = event.diff.getChangedKeys();
				LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent(
						WorkflowRunObservableMapLabelProvider.this,
						affectedElements.toArray());

				fireLabelProviderChanged(newEvent);
				// @SuppressWarnings("rawtypes")
				// Set addedKeys = event.diff.getAddedKeys();
				// for (Object k : addedKeys) {
				// System.out.println(k);
				// addProgress(k);
				// }
			}
		};

		public WorkflowRunObservableMapLabelProvider(
				IObservableMap[] attributeMaps) {

			// Use invalidations to update the labels, so this won't depend on
			// the observables
			// on the actual objects. Invalidations are fired anyway.

			System.arraycopy(
					attributeMaps,
					0,
					this.attributeMaps = new IObservableMap[attributeMaps.length],
					0, attributeMaps.length);
			// for (int i = 0; i < attributeMaps.length; i++) {
			// attributeMaps[i].addMapChangeListener(mapChangeListener);
			// }

		}

		/*
		 * Install a table editor, for the target object TableItem Note: locate
		 * the table item first..
		 */
		protected TableEditor addProgress(Object k) {

			if (k instanceof WorkFlowRun) {
				WorkFlowRun wfr = ((WorkFlowRun) k);
				if (progressCache.containsKey(wfr.cdoID())) {
					return progressCache.get(wfr.cdoID());
				}

				// install a table editor on the last item...
				TableItem item = null;
				for (TableItem checkItem : tableViewer.getTable().getItems()) {
					Object data = checkItem.getData();
					if (data instanceof CDOObject && k instanceof CDOObject) {

						CDOID cdoID2 = ((CDOObject) data).cdoID();
						// System.out.println("table item with CDOID "
						// + cdoID2.toString());
						if (wfr.cdoID().toString().equals(cdoID2.toString())) {
							item = checkItem;
							break;
						}
					}
					// if (EcoreUtil.equals((EObject) data, (EObject) k)) {
					// item = checkItem;
					// }
				}

				if (item != null) {
					TableEditor progressEditor = new TableEditor(
							tableViewer.getTable());
					progressEditor.grabHorizontal = true;
					progressEditor.grabVertical = true;

					ProgressControl progressControl = new ProgressControl(
							tableViewer.getTable(), SWT.NONE);

					progressEditor.setEditor(progressControl, item, 2);
					progressCache.put(wfr.cdoID(), progressEditor);
					return progressEditor;
				}
			}
			return null;
		}

		public boolean hasProgress(CDOID current) {
			return progressCache.containsKey(current);
		}

		public WorkflowRunObservableMapLabelProvider(IObservableMap attributeMap) {
			this(new IObservableMap[] { attributeMap });
		}

		public void setTableViewer(TableViewer tableViewer) {
			this.tableViewer = tableViewer;
			// progressEditor = new TableEditor(table);
		}

		public String getText(Object element) {

			((EObject) element).eContainmentFeature();

			return super.getText(element);
		}

		public Image getImage(Object element) {
			return getColumnImage(element, 0);
		}

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {

			if (element instanceof WorkFlowRun) {
				WorkFlowRun j = (WorkFlowRun) element;

				if (columnIndex == 2) {
					if (j.getState() == JobRunState.RUNNING) {
						// When the application is aborted, the state will
						// remain running.
						//

						// find the progress and update it.
						TableEditor addProgress = addProgress(element);
						if (addProgress != null) {
							Control editor = addProgress.getEditor();
							if (editor instanceof ProgressControl) {
								((ProgressControl) editor).updateProgress(j
										.getProgress());
							}

							// if (editor instanceof ProgressBar) {
							// ((ProgressBar) editor).setSelection(j
							// .getProgress());
							// }
						}
					} else {
						// dispose when we are not in running state.
						if (this.hasProgress(j.cdoID())) {
							TableEditor tableEditor = progressCache.get(j
									.cdoID());
							tableEditor.getEditor().dispose();
							tableEditor.dispose();
							progressCache.remove(j.cdoID());

							// System.out.println("Disposed progress for "
							// + modelUtils.printModelObject(j));
						}
					}
					// bar.set
					// return null;
				}

				switch (columnIndex) {
				case 0: {
					if (j instanceof ComponentWorkFlowRun) {
						return "Expression run";
					} else {
						return "Workflow run";
					}
				}
				case 1: {
					switch (j.getState().getValue()) {
					case JobRunState.RUNNING_VALUE: {
						return "Running...";
					}
					case JobRunState.FINISHED_WITH_ERROR_VALUE: {
						return "Done, errors occured";
					}
					case JobRunState.FINISHED_SUCCESSFULLY_VALUE: {
						return "Done";
					}
					}
				}
				case 5: {
					if (j.getStarted() != null) {
						Date d = modelUtils.fromXMLDate(j.getStarted());
						return modelUtils.date(d) + " @ " + modelUtils.time(d);
					}
				}
				case 6: {
					if (j.getEnded() != null) {
						Date d = modelUtils.fromXMLDate(j.getEnded());
						return modelUtils.date(d) + " @ " + modelUtils.time(d);
					}
				}
				}
			}

			Object result = attributeMaps[columnIndex].get(element);
			return result == null ? "" : result.toString(); //$NON-NLS-1$

		}

		class ProgressControl extends Composite {

			private ProgressBar bar;
			private Label label;

			public ProgressControl(Composite parent, int style) {
				super(parent, style);
				StackLayout stackLayout = new StackLayout();
				stackLayout.marginHeight = 0;
				stackLayout.marginWidth = 0;

				this.setLayout(stackLayout);
				bar = new ProgressBar(this, SWT.SMOOTH);
				bar.setMaximum(100);
				bar.setSelection(0);
				// label = new Label(this, SWT.NONE);
				// label.setText("progress");
				stackLayout.topControl = bar;
			}

			public void updateProgress(int progress) {
				bar.setSelection(progress);
			}

			public void updateText(String progress) {
				label.setText(progress);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.widgets.Widget#addDisposeListener(org.eclipse
			 * .swt.events.DisposeListener)
			 */
			@Override
			public void addDisposeListener(DisposeListener listener) {
				super.addDisposeListener(listener);
				label.dispose();
				bar.dispose();

			}
		}

	}

	// class CapacityEditingSupport extends EditingSupport {
	//
	// private TableViewer viewer;
	//
	// public CapacityEditingSupport(TableViewer viewer) {
	// super(viewer);
	// this.viewer = viewer;
	// }
	//
	// @Override
	// protected CellEditor getCellEditor(Object element) {
	// EnterCapacityCellEditor enterCapacityCellEditor = new
	// EnterCapacityCellEditor(
	// viewer.getTable());
	// enterCapacityCellEditor.setResource((NetXResource) element);
	// return enterCapacityCellEditor;
	// }
	//
	// @Override
	// protected boolean canEdit(Object element) {
	// return true;
	// }
	//
	// @Override
	// protected Object getValue(Object element) {
	// if (element instanceof NetXResource) {
	// Value v = modelUtils
	// .mostRecentCapacityValue((NetXResource) element);
	//
	// if (v != null) {
	// DecimalFormat numberFormatter = new DecimalFormat(
	// "###,###,##0.00");
	// numberFormatter.setDecimalSeparatorAlwaysShown(true);
	// return numberFormatter.format(v.getValue());
	// } else {
	// return "<not set>";
	// }
	// }
	// return null;
	// }
	//
	// @Override
	// protected void setValue(Object element, Object value) {
	// viewer.update(element, null);
	// }
	//
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.ui.viewer.IViewerProvider#getViewer()
	 */
	public Viewer getViewer() {
		return this.getTableViewerWidget();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.selector.IScreen#isValid()
	 */
	public boolean isValid() {
		return true;
	}

	public TableViewer getTableViewerWidget() {
		return jobRunsTableViewer;
	}

	public Form getScreenForm() {
		return frmJobRuns;
	}

	public void disposeData() {
		// N/A
	}

	public String getScreenName() {
		return "Runs";
	}

	@Override
	public boolean shouldHandleRefresh() {
		return true;
	}

	@Override
	public void handleRefresh(Object... objects) {

		for (Object o : objects) {
			if (o instanceof Collection<?>) {
				Collection<?> dirtyObjects = (Collection<?>) o;
				for (Object dirty : dirtyObjects) {
					handleRefresh(dirty);
				}
			}
			// Any objects which are Workflows?
			if (o instanceof WorkFlowRun) {

				// Multiple WorkFlowRuns would cancel our job, when going in
				// state DONE.

				WorkFlowRun wfr = (WorkFlowRun) o;
				JobRunState jobState = wfr.getState();
				if (jobState == JobRunState.RUNNING) {
					if (refreshUIJob.getState() == org.eclipse.core.runtime.jobs.Job.NONE) {
//						System.out.println("JobRuns: schedule refreshUI");
						refreshUIJob.schedule();
					}
				} else if (jobState == JobRunState.FINISHED_SUCCESSFULLY
						|| jobState == JobRunState.FINISHED_WITH_ERROR) {
					refreshUIJob.cancel();
					// Do one more to reflect the latest status. 
					getTableViewerWidget().refresh();

				}
			}
			if( o instanceof JobRunContainer){
				refreshUIJob.schedule();	
			}
			
		}
		// super.handleReshresh(objects);
	}

	/**
	 * Updates the UI, while WorkFlow is in state running is running.
	 * TODO, Potentially feed with the object, which needs to be refreshed. 
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class RefreshUIJob extends UIJob {

		public RefreshUIJob(String name) {
			super(name);
			this.setSystem(true);
		}

		@Override
		public IStatus runInUIThread(IProgressMonitor monitor) {

			if (monitor.isCanceled() || JobRuns.this.isDisposed())
				return new Status(IStatus.OK, ScreensActivator.PLUGIN_ID,
						IStatus.OK, "", null);
			
			// Potentially only update the relevant object.
			// getTableViewerWidget().up
			getTableViewerWidget().refresh();

			if (!monitor.isCanceled()) {
				refreshUIJob.schedule(500);
			}

			return new Status(IStatus.OK, PlatformUI.PLUGIN_ID, IStatus.OK, "",
					null);
		}

	}

}
