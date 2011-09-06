package com.netxforge.netxstudio.screens.f4;

import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
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
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.scheduling.RFSServiceJob;
import com.netxforge.netxstudio.scheduling.RFSServiceRetentionJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class Jobs extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Text txtFilterText;

	private TableViewer jobsTableViewer;
	private Form frmScheduledJobs;
	private Resource jobsResource;

	private TableViewerColumn tblViewerClmnState;

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

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmScheduledJobs = toolkit.createForm(this);
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

		ImageHyperlink mghprlnkNew = toolkit.createImageHyperlink(
				frmScheduledJobs.getBody(), SWT.NONE);
		mghprlnkNew.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				if (screenService != null) {
					NewEditJob jobScreen = new NewEditJob(screenService
							.getScreenContainer(), SWT.NONE);
					jobScreen.setOperation(Screens.OPERATION_NEW);
					jobScreen.setScreenService(screenService);
					jobScreen.injectData(jobsResource,
							SchedulingFactory.eINSTANCE.createJob());
					screenService.setActiveScreen(jobScreen);
				}

			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		mghprlnkNew.setImage(ResourceManager.getPluginImage(
				"com.netxforge.netxstudio.models.edit",
				"icons/full/ctool16/Function_E.png"));
		mghprlnkNew.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		toolkit.paintBordersFor(mghprlnkNew);
		mghprlnkNew.setText("New");

		jobsTableViewer = new TableViewer(frmScheduledJobs.getBody(),
				SWT.BORDER | SWT.FULL_SELECTION);
		table = jobsTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 4));
		toolkit.paintBordersFor(table);

		TableViewerColumn tblViewerClmType = new TableViewerColumn(
				jobsTableViewer, SWT.NONE);
		TableColumn tblclmnJobType = tblViewerClmType.getColumn();
		tblclmnJobType.setWidth(166);
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
		tblclmnStarttime.setText("Start");

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
	}

	@Override
	public IAction[] getActions() {

		String actionText = Screens.isReadOnlyOperation(this.getOperation()) ? "View..."
				: "Edit...";
		List<IAction> actions = Lists.newArrayList();
		actions.add(new EditJobAction(actionText, SWT.PUSH));
		actions.add(new JobRunsAction("Runs...", SWT.PUSH));

		IAction[] actionArray = new IAction[actions.size()];
		return actions.toArray(actionArray);

	}

	class EditJobAction extends Action {

		public EditJobAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection)
						.getFirstElement();
				NewEditJob job = new NewEditJob(screenService
						.getScreenContainer(), SWT.NONE);
				job.setScreenService(screenService);
				job.setOperation(Screens.OPERATION_EDIT);
				job.injectData(jobsResource, o);
				screenService.setActiveScreen(job);
			}
		}

	}

	class JobRunsAction extends Action {

		public JobRunsAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection).getFirstElement();
				JobRuns jobRunsScreen = new JobRuns(
						screenService.getScreenContainer(), SWT.NONE);
				jobRunsScreen.setScreenService(screenService);
				jobRunsScreen.setOperation(Screens.OPERATION_READ_ONLY);
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
		// obm.addObservable(jobsList);

		jobsTableViewer.setInput(jobsList);

		return bindingContext;
	}

	class JobsObervableMapLabelProvider extends ObservableMapLabelProvider {

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
						return "Metric Import: "
								+ ((MetricSourceJob) j).getMetricSource()
										.getName();
					}
					if (j instanceof RFSServiceJob) {
						return "Monitoring: "
								+ ((RFSServiceJob) j).getRFSService()
										.getServiceName();
					}
					if (j instanceof RFSServiceRetentionJob) {
						return "Data Retention: "
								+ ((RFSServiceRetentionJob) j).getRFSService()
										.getServiceName();
					}
				}
				case 2: {
					JobState state = j.getJobState();
					if (state == JobState.ACTIVE) {
						return "Active";
					} else {
						return "Not Active";
					}
				}
				case 3:
					if (j.getStartTime() != null) {
						Date d = modelUtils.fromXMLDate(j.getStartTime());
						return modelUtils.date(d) + " @ " + modelUtils.time(d);
					}

					break;
				case 4:
					if (j.getEndTime() != null) {
						Date d = modelUtils.fromXMLDate(j.getEndTime());
						return modelUtils.date(d) + " @ " + modelUtils.time(d);
					}
					break;
				case 6:
					if (j.getInterval() > 0) {
						return new Integer(j.getInterval()).toString();
					}
					break;
				}
			}
			return super.getColumnText(element, columnIndex);
		}
	}

	public void injectData() {
		jobsResource = editingService.getData(SchedulingPackage.Literals.JOB);
		buildUI();
		initDataBindings_();
	}

	public void disposeData() {
		editingService.disposeData(jobsResource);
	}

	@Override
	public Viewer getViewer() {
		return jobsTableViewer;
	}

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public Form getScreenForm() {
		return frmScheduledJobs;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;

	}

}
