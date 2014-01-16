/*******************************************************************************
 * Copyright (c) 21 jan. 2013 NetXForge.
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

import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
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
import org.eclipse.ui.IMemento;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.scheduling.NodeReporterJob;
import com.netxforge.netxstudio.scheduling.OperatorReporterJob;
import com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob;
import com.netxforge.netxstudio.scheduling.RFSServiceReporterJob;
import com.netxforge.netxstudio.scheduling.RetentionJob;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.ScreenUtil;
import com.netxforge.netxstudio.screens.editing.filter.SearchFilter;
import com.netxforge.netxstudio.screens.editing.tables.CDOElementComparer;

/**
 * 
 * @author Christophe Bouhier
 */
public class Jobs extends AbstractScreen implements IDataServiceInjection {

	private static final String MEM_KEY_JOBS_SELECTION_TABLE = "MEM_KEY_JOBS_SELECTION_TABLE";
	private static final String MEM_KEY_JOBS_COLUMNS_TABLE = "MEM_KEY_JOBS_COLUMNS_TABLE";

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table jobsTable;
	private Text txtFilterText;

	private TableViewer jobsTableViewer;
	private Form frmScheduledJobs;

	private Resource jobsResource;
	// private Resource jobContainerResource;

	private TableViewerColumn tblViewerClmnState;

	@Inject
	private ServerRequest serverActions;

	// private ArrayList<Object> uniqueJobList;

	/**
	 * Mirrored scheduler state. It gets updated by init, manual request, or
	 * when the scheduler state changes start <==> Stand-by.
	 */
	boolean isRunning = false;

	/**
	 * List all scheduled actions
	 * 
	 * @author Christophe
	 * 
	 */
	public class ListScheduleAction extends Action {

		public ListScheduleAction(String text) {
			super(text);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.action.Action#run()
		 */
		@Override
		public void run() {
			try {
				updateScheduleInViewer();
				SWTResourceManager.disposeColors();
				// Update the viewer
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public Jobs(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
				// obm.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);

	}

	/**
	 * Starts or stops the scheduler. The service side HTTP handler, is
	 * synchronous, so roundtrip is awaited.
	 * 
	 * @author Christophe
	 * 
	 */
	public class SchedulerStartStopAction extends Action {

		ImageDescriptor playDescriptor = ResourceManager
				.getPluginImageDescriptor(
						"com.netxforge.netxstudio.screens.editing",
						"/icons/full/elcl16/play.png");

		ImageDescriptor pauseDescriptor = ResourceManager
				.getPluginImageDescriptor(
						"com.netxforge.netxstudio.screens.editing",
						"/icons/full/elcl16/pause.png");

		public SchedulerStartStopAction(String text) {
			super(text, SWT.PUSH);
			// check the initial status of the scheduler.
			try {
				updateSchedulerState();
			} catch (Exception e) {
				// status can't be obtained
				e.printStackTrace();
			}
			updateIcon();
		}

		/**
		 * @throws Exception
		 */
		public void updateSchedulerState() throws Exception {
			String result = serverActions
					.callJobAction(ServerRequest.COMMAND_SCHEDULER_STATUS);
			isRunning = ServerRequest.schedulerRunning(
					ServerRequest.COMMAND_SCHEDULER_STATUS, result);
			// System.out.println("Set action state scheduler is running? " +
			// isRunning + " (result text) " + result);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.action.Action#run()
		 */
		@Override
		public void run() {

			if (isRunning) {
				try {
					serverActions
							.callJobAction(ServerRequest.COMMAND_SCHEDULER_STOP);
					updateSchedulerState();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					serverActions
							.callJobAction(ServerRequest.COMMAND_SCHEDULER_START);
					updateSchedulerState();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			updateIcon();
			updateScheduleInViewer();
		}

		private void updateIcon() {
			if (isRunning) {
				this.setImageDescriptor(pauseDescriptor);
				this.setText("Pause");
			} else {
				this.setImageDescriptor(playDescriptor);
			}
		}
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmScheduledJobs = toolkit.createForm(this);

		frmScheduledJobs.getToolBarManager().add(
				new ListScheduleAction("Update scheduler information"));
		frmScheduledJobs.getToolBarManager().add(
				new SchedulerStartStopAction("Start"));

		frmScheduledJobs.getToolBarManager().update(true);
		frmScheduledJobs.setToolBarVerticalAlignment(SWT.TOP);

		frmScheduledJobs.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmScheduledJobs);
		frmScheduledJobs.setText("Scheduled Jobs");
		frmScheduledJobs.getBody().setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(frmScheduledJobs.getBody(),
				"Filter:", SWT.NONE);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 44;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmScheduledJobs.getBody(),
				"New Text", SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.setText("");
		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);
		txtFilterText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				ViewerFilter[] filters = jobsTableViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof SearchFilter) {
						((SearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
				jobsTableViewer.refresh();
			}
		});

		jobsTableViewer = new TableViewer(frmScheduledJobs.getBody(),
				SWT.BORDER | SWT.FULL_SELECTION);
		jobsTableViewer.setComparer(new CDOElementComparer());
		jobsTableViewer.addFilter(new SearchFilter());

		jobsTable = jobsTableViewer.getTable();
		jobsTable.setLinesVisible(true);
		jobsTable.setHeaderVisible(true);
		jobsTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3,
				4));
		toolkit.paintBordersFor(jobsTable);

		TableViewerColumn tblViewerClmType = new TableViewerColumn(
				jobsTableViewer, SWT.NONE);
		TableColumn tblclmnJobType = tblViewerClmType.getColumn();
		tblclmnJobType.setWidth(100);
		tblclmnJobType.setText("Job Type");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				jobsTableViewer, SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(100);
		tblclmnName.setText("Name");

		tblViewerClmnState = new TableViewerColumn(jobsTableViewer, SWT.NONE);
		TableColumn tblclmnState = tblViewerClmnState.getColumn();
		tblclmnState.setWidth(76);
		tblclmnState.setText("State");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				jobsTableViewer, SWT.NONE);
		TableColumn tblclmnStarttime = tableViewerColumn_2.getColumn();
		tblclmnStarttime.setWidth(130);
		tblclmnStarttime.setText("Scheduled start");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(
				jobsTableViewer, SWT.NONE);
		TableColumn tblclmnType = tableViewerColumn_3.getColumn();
		tblclmnType.setWidth(130);
		tblclmnType.setText("End");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				jobsTableViewer, SWT.NONE);
		TableColumn tblclmnRepeat = tableViewerColumn_1.getColumn();
		tblclmnRepeat.setWidth(100);
		tblclmnRepeat.setText("Repeats");

		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(
				jobsTableViewer, SWT.NONE);
		TableColumn tblclmnInterval = tableViewerColumn_6.getColumn();
		tblclmnInterval.setWidth(100);
		tblclmnInterval.setText("Interval");

		jobsTable.setFocus();
	}


	private final List<IAction> actions = Lists.newArrayList();
	private CDOView cdoView;

	@Override
	public IAction[] getActions() {
		// lazy init.
		if (actions.isEmpty()) {
			String actionText = ScreenUtil.isReadOnlyOperation(this
					.getOperation()) ? "View..." : "Edit...";

			actions.add(new EditJobAction(actionText));
			actions.add(new JobRunsAction("Runs..."));
		}
		return actions.toArray(new IAction[actions.size()]);

	}

	/**
	 * An addon {@link Adapter} which provides
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public class TriggerAddon extends AdapterImpl {
		private final String[] trigger;

		public TriggerAddon(String[] trigger) {
			this.trigger = trigger;
		}

		public String getTriggerTime() {
			return trigger[1];
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == TriggerAddon.class;
		}
	}

	class EditJobAction extends Action {

		public EditJobAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection).getFirstElement();
				NewEditJob job = new NewEditJob(
						screenService.getScreenContainer(), SWT.NONE);
				job.setScreenService(screenService);
				job.setOperation(ScreenUtil.OPERATION_EDIT);
				job.injectData(jobsResource, o);
				screenService.setActiveScreen(job);
			}
		}

	}

	class JobRunsAction extends Action {

		public JobRunsAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection).getFirstElement();
				JobRuns jobRunsScreen = new JobRuns(
						screenService.getScreenContainer(), SWT.NONE);
				jobRunsScreen.setScreenService(screenService);
				jobRunsScreen.setOperation(ScreenUtil.OPERATION_READ_ONLY);
				jobRunsScreen.injectData(jobsResource, o);
				screenService.setActiveScreen(jobRunsScreen);
			}

		}

	}

	// Editing support for JFace databinding.
	@SuppressWarnings("unused")
	private class CheckBoxEditingSupport extends ObservableValueEditingSupport {
		private CellEditor cellEditor;

		public CheckBoxEditingSupport(ColumnViewer viewer,
				DataBindingContext dbc) {
			super(viewer, dbc);
			// cellEditor = new TextCellEditor((Composite) viewer.getControl());

			String[] values = new String[JobState.VALUES.size()];
			int i = 0;
			for (JobState s : JobState.VALUES) {
				values[i] = s.getName();
				i++;
			}
			cellEditor = new ComboBoxCellEditor(
					(Composite) viewer.getControl(), values);
		}

		protected CellEditor getCellEditor(Object element) {
			return cellEditor;
		}

		protected IObservableValue doCreateCellEditorObservable(
				CellEditor cellEditor) {
			return SWTObservables.observeSelection(cellEditor.getControl());
		}

		protected IObservableValue doCreateElementObservable(Object element,
				ViewerCell cell) {
			IEMFValueProperty jobStateProperty = EMFEditProperties.value(
					editingService.getEditingDomain(),
					SchedulingPackage.Literals.JOB__JOB_STATE);
			return jobStateProperty.observe(element);
		}
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		// tblViewerClmnState.setEditingSupport(new CheckBoxEditingSupport(
		// jobsTableViewer, bindingContext));

		// TODO, Implement content provider, which also can deal with the type
		// of a job which is defined
		// as a job class on it's own.
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		jobsTableViewer.setContentProvider(listContentProvider);

		EAttribute dummyAttribute = EcoreFactory.eINSTANCE.createEAttribute();

		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] { dummyAttribute,
						SchedulingPackage.Literals.JOB__NAME,
						SchedulingPackage.Literals.JOB__JOB_STATE,
						SchedulingPackage.Literals.JOB__START_TIME,
						SchedulingPackage.Literals.JOB__END_TIME,
						SchedulingPackage.Literals.JOB__REPEAT,
						SchedulingPackage.Literals.JOB__INTERVAL });
		jobsTableViewer.setLabelProvider(new JobsObervableMapLabelProvider(
				observeMaps));

		IEMFListProperty jobsProperties = EMFEditProperties
				.resource(editingService.getEditingDomain());

		IObservableList jobsList = jobsProperties.observe(jobsResource);

		jobsTableViewer.setInput(jobsList);

		return bindingContext;
	}

	class JobsObervableMapLabelProvider extends ObservableMapLabelProvider
			implements org.eclipse.jface.util.IPropertyChangeListener {

		public JobsObervableMapLabelProvider(IObservableMap[] attributeMaps) {
			super(attributeMaps);

		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return super.getColumnImage(element, columnIndex);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof Job) {
				Job j = (Job) element;
				switch (columnIndex) {
				case 0: {
					if (j instanceof MetricSourceJob) {
						return "Metric Import";
						// + ((MetricSourceJob) j).getMetricSource()
						// .getName();
					}
					if (j instanceof RFSServiceMonitoringJob) {
						return "Monitoring";
						// + ((RFSServiceJob) j).getRFSService()
						// .getServiceName();
					}
					if (j instanceof RetentionJob) {
						return "Data Retention";
						// + ((RFSServiceRetentionJob) j).getRFSService()
						// .getServiceName();
					}
					if (j instanceof RFSServiceReporterJob) {
						return "Service Reporting";
						// + ((ReporterJob) j).getRFSService()
						// .getServiceName();
					}
					if (j instanceof OperatorReporterJob) {
						return "Operator Reporting";
						// + ((ReporterJob) j).getRFSService()
						// .getServiceName();
					}
					if (j instanceof NodeReporterJob) {
						return "Node Reporting";
						// + ((ReporterJob) j).getRFSService()
						// .getServiceName();
					}

				}
				case 1: {
					return j.getName();
				}
				case 2: {
					JobState state = j.getJobState();
					if (state == JobState.ACTIVE) {
						return "Active";
					} else {
						return "Not Active";
					}
				}
				// Scheduled start time Column, not the starttime (creation time
				// of the job).
				case 3:
					TriggerAddon addon = (TriggerAddon) EcoreUtil.getAdapter(
							j.eAdapters(), TriggerAddon.class);
					if (addon != null) {
						return addon.getTriggerTime();
					}
					return "";
					// End Column
				case 4:
					if (j.getEndTime() != null) {
						Date d = modelUtils.fromXMLDate(j.getEndTime());
						return modelUtils.date(d) + " @ " + modelUtils.time(d);
					}
					break;
				case 5:
					return new Integer(j.getRepeat()).toString();
				case 6:
					if (j.getInterval() > 0) {
						String fromSeconds = modelUtils.fromSeconds(j
								.getInterval());
						return fromSeconds;
					}
					break;
				}
			}
			return super.getColumnText(element, columnIndex);
		}

		public void propertyChange(PropertyChangeEvent event) {
			if (event.getSource() instanceof SchedulerStartStopAction) {
				Object newValue = event.getNewValue();
				// Guard for the object type?
				this.fireLabelProviderChanged(new LabelProviderChangedEvent(
						this, newValue));
			}
		}
	}

	public void injectData() {

		jobsResource = editingService.getData(SchedulingPackage.Literals.JOB);
		// We also need the transaction to resolve objects communicated by the
		// scheduler.
		if (jobsResource instanceof CDOResource) {
			cdoView = ((CDOResource) jobsResource).cdoView();
		}
		buildUI();
		initDataBindings_();
		updateScheduleInViewer();
	}

	private void updateScheduleInViewer() {
		try {
			String schedule = serverActions
					.callJobAction(ServerRequest.COMMAND_SCHEDULER_LIST);
			List<String[]> structure = ServerRequest
					.schedulerTriggers(schedule);
			List<Object> elementsToUpdate = Lists.newArrayList();
			for (final String[] trigger : structure) {
				CDOID triggeredObject = CDOIDUtil.read(trigger[0]); // Read the
																	// CDOID;
				CDOObject object = cdoView.getObject(triggeredObject);
				Adapter adapter = EcoreUtil.getAdapter(object.eAdapters(),
						TriggerAddon.class);
				object.eAdapters().remove(adapter);
				object.eAdapters().add(new TriggerAddon(trigger));
				elementsToUpdate.add(object);
			}

			// Update the viewer.
			jobsTableViewer.refresh(true);
			if (!isRunning) {
				frmScheduledJobs.getHead().setBackground(
						SWTResourceManager.getColor(255, 102, 102));
				frmScheduledJobs.setText("Scheduled Jobs (NOT Running)");

			} else {
				frmScheduledJobs.getHead().setBackground(
						SWTResourceManager.getColor(200, 255, 100));
				frmScheduledJobs.setText("Scheduled Jobs (Running)");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Viewer getViewer() {
		return jobsTableViewer;
	}

	@Override
	public boolean isValid() {
		return false;
	}

	public Form getScreenForm() {
		return frmScheduledJobs;
	}

	@Override
	public String getScreenName() {
		return "Jobs";
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
				jobsTableViewer, MEM_KEY_JOBS_SELECTION_TABLE);
		mementoUtils.rememberStructuredViewerColumns(memento, jobsTableViewer,
				MEM_KEY_JOBS_COLUMNS_TABLE);
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
					jobsTableViewer, MEM_KEY_JOBS_SELECTION_TABLE,
					((CDOResource) jobsResource).cdoView());
			mementoUtils.retrieveStructuredViewerColumns(memento,
					jobsTableViewer, MEM_KEY_JOBS_COLUMNS_TABLE);
		}
	}

}
