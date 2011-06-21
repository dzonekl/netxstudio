package com.netxforge.netxstudio.screens.f4;

import java.util.List;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOQuery;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.cdo.ICDOQueries;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class Scheduler extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Text txtFilterText;

	private TableViewer tableViewer;
	private Form frmScheduledJobs;
	private Resource jobsResource;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public Scheduler(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
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
					NewEditJob user = new NewEditJob(screenService
							.getScreenContainer(), SWT.NONE
							| Screens.OPERATION_NEW);
					screenService.setActiveScreen(user);
					user.injectData(jobsResource,
							SchedulingFactory.eINSTANCE.createJob());
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

		tableViewer = new TableViewer(frmScheduledJobs.getBody(), SWT.BORDER
				| SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 4));
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(100);
		tblclmnName.setText("Name");


		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnState = tableViewerColumn_4.getColumn();
		tblclmnState.setWidth(100);
		tblclmnState.setText("State");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnStarttime = tableViewerColumn_2.getColumn();
		tblclmnStarttime.setWidth(81);
		tblclmnStarttime.setText("Startime");
		

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnType = tableViewerColumn_3.getColumn();
		tblclmnType.setWidth(100);
		tblclmnType.setText("Endtime");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnInterval = tableViewerColumn_1.getColumn();
		tblclmnInterval.setWidth(100);
		tblclmnInterval.setText("Repeat");

		Menu menu = new Menu(table);
		table.setMenu(menu);

		MenuItem mntmEdit = new MenuItem(menu, SWT.NONE);
		mntmEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					NewEditJob user = new NewEditJob(screenService
							.getScreenContainer(), SWT.NONE
							| Screens.OPERATION_EDIT);
					screenService.setActiveScreen(user);
					user.injectData(jobsResource, o);
				}
			}
		});
		mntmEdit.setText("Edit...");
		
		MenuItem mntmRuns = new MenuItem(menu, SWT.NONE);
		mntmRuns.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					JobRuns user = new JobRuns(screenService
							.getScreenContainer(), SWT.NONE
							| Screens.OPERATION_READ_ONLY);
					screenService.setActiveScreen(user);
					user.injectData(jobsResource, o);
				}
				
				
			}
		});
		mntmRuns.setText("Runs...");
		
		if (editingService != null) {
			injectData();
		}

	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		// TODO, Implement content provider, which also can deal with the type
		// of a job which is defined
		// as a job class on it's own.
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		tableViewer.setContentProvider(listContentProvider);

		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] {
						SchedulingPackage.Literals.JOB__NAME,
						SchedulingPackage.Literals.JOB__JOB_STATE,
						SchedulingPackage.Literals.JOB__START_TIME,
						SchedulingPackage.Literals.JOB__END_TIME,
						SchedulingPackage.Literals.JOB__REPEAT });
		tableViewer
				.setLabelProvider(new ObservableMapLabelProvider(observeMaps));

		IEMFListProperty l = EMFProperties.resource();

		tableViewer.setInput(l.observe(jobsResource));
		return bindingContext;
	}

	public void injectData() {
		// Resource jobResource =
		// this.editingService.getData(SchedulingPackage.Literals.JOB);
		IDataService dService = editingService.getDataService();
		CDOTransaction t = dService.getProvider().getSession()
				.openTransaction();
		CDOQuery q = t.createQuery("hql", ICDOQueries.SELECT_JOBS);
		q.setParameter(ICDOQueries.CACHE_RESULTS, true);
		List<Job> jobs = q.getResult(Job.class);

		// Get a resource, to store our query.
		jobsResource = editingService.getData(SchedulingPackage.Literals.JOB);
		jobsResource.getContents().addAll(jobs);

		initDataBindings_();
	}

	public void disposeData() {
		editingService.disposeData();
	}

	@Override
	public Viewer getViewer() {
		return tableViewer;
	}

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public Form getScreenForm() {
		return frmScheduledJobs;
	}
}
