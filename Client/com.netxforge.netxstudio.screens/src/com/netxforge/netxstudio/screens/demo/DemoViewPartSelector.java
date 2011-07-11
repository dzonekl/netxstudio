package com.netxforge.netxstudio.screens.demo;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.ViewPart;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.screens.f2.NewEditResource;
import com.netxforge.netxstudio.screens.f2.ResourceCapacityRange;
import com.netxforge.netxstudio.screens.f4.MappingStatistics;
import com.netxforge.netxstudio.screens.f4.MetricSources;
import com.netxforge.netxstudio.screens.f4.MetricValueRange;
import com.netxforge.netxstudio.screens.f4.Metrics;
import com.netxforge.netxstudio.screens.f4.NewEditJob;
import com.netxforge.netxstudio.screens.f4.NewEditMappingColumn;
import com.netxforge.netxstudio.screens.f4.NewEditMappingXLS;
import com.netxforge.netxstudio.screens.f4.NewEditMetric;
import com.netxforge.netxstudio.screens.f4.NewEditMetricSource;
import com.netxforge.netxstudio.screens.f4.PurgeMetrics;
import com.netxforge.netxstudio.screens.f4.ResourceMonitor;
import com.netxforge.netxstudio.screens.f4.Jobs;
import com.netxforge.netxstudio.screens.nf4.LoginDialog;
import com.netxforge.netxstudio.screens.nf4.NewEditUser;
import com.netxforge.netxstudio.screens.nf4.UsersAndRoles;

public class DemoViewPartSelector extends ViewPart {

	@Inject
	IDataService service;
	
	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		service.getProvider().openSession("admin","admin");
	}
	
	public static final String ID = "com.netxforge.netxstudio.screens.demo.DemoViewPartSelector"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private Composite parentComposite = null;
	private Composite currentComposite = null;
	private Form frmNewForm;
	FormData fd_frmNewForm = new FormData();

	public DemoViewPartSelector() {
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		parentComposite = parent;
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		final Composite container = toolkit.createComposite(parent, SWT.NONE);

		toolkit.paintBordersFor(container);
		container.setLayout(new FormLayout());

		frmNewForm = toolkit.createForm(container);
		fd_frmNewForm.left = new FormAttachment(0, 10);

		fd_frmNewForm.bottom = new FormAttachment(100, -3);
		fd_frmNewForm.top = new FormAttachment(0, 3);
		frmNewForm.setLayoutData(fd_frmNewForm);
		toolkit.paintBordersFor(frmNewForm);
		frmNewForm.setText("Screens");
		frmNewForm.getBody().setLayout(new FormLayout());

		Section sctnNewSection = toolkit.createSection(frmNewForm.getBody(),
				Section.COMPACT | Section.EXPANDED | Section.TREE_NODE
						| Section.TITLE_BAR);
		FormData fd_sctnNewSection = new FormData();
		fd_sctnNewSection.bottom = new FormAttachment(0, 170);
		fd_sctnNewSection.right = new FormAttachment(0, 161);
		fd_sctnNewSection.top = new FormAttachment(0);
		fd_sctnNewSection.left = new FormAttachment(0);
		sctnNewSection.setLayoutData(fd_sctnNewSection);
		toolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Iteration #1");

		Composite composite_1 = toolkit.createComposite(sctnNewSection,
				SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnNewSection.setClient(composite_1);
		composite_1.setLayout(new GridLayout(1, false));

		Button btnLogin = new Button(composite_1, SWT.FLAT);
		btnLogin.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				LoginDialog ld = new LoginDialog(DemoViewPartSelector.this
						.getSite().getShell());
				ld.open();

			}
		});
		toolkit.adapt(btnLogin, true, true);
		btnLogin.setText("Login");

		Button btnUsersAndRoles = toolkit.createButton(composite_1,
				"Users and Roles", SWT.NONE);
		btnUsersAndRoles.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (currentComposite instanceof UsersAndRoles)
					return;
				updateComposite(container, new UsersAndRoles(container,
						SWT.NONE));
			}
		});
		btnUsersAndRoles.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Button btnNewUser = toolkit.createButton(composite_1, "New User",
				SWT.NONE);
		btnNewUser.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (currentComposite instanceof NewEditUser)
					return;
				updateComposite(container, new NewEditUser(container, SWT.NONE));
			}
		});
		btnNewUser.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Button btnJobs = new Button(composite_1, SWT.FLAT);
		btnJobs.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));
		btnJobs.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (currentComposite instanceof Jobs)
					return;
				updateComposite(container, new Jobs(container, SWT.NONE));
			}
		});
		toolkit.adapt(btnJobs, true, true);
		btnJobs.setText("Scheduler Jobs");

		Button btnNewJob = new Button(composite_1, SWT.FLAT);
		btnNewJob.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (currentComposite instanceof NewEditJob)
					return;
				updateComposite(container, new NewEditJob(container,
						SWT.NONE));
			}
		});
		btnNewJob.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		toolkit.adapt(btnNewJob, true, true);
		btnNewJob.setText("New Job");

		Section sctnNewSection_1 = toolkit.createSection(frmNewForm.getBody(),
				Section.TREE_NODE | Section.TITLE_BAR);
		FormData fd_sctnNewSection_1 = new FormData();
		fd_sctnNewSection_1.bottom = new FormAttachment(100, -12);
		fd_sctnNewSection_1.right = new FormAttachment(sctnNewSection, 0,
				SWT.RIGHT);
		fd_sctnNewSection_1.top = new FormAttachment(sctnNewSection);
		fd_sctnNewSection_1.left = new FormAttachment(0);
		sctnNewSection_1.setLayoutData(fd_sctnNewSection_1);
		toolkit.paintBordersFor(sctnNewSection_1);
		sctnNewSection_1.setText("Iteration #2");
		sctnNewSection_1.setExpanded(true);

		Composite composite = toolkit.createComposite(sctnNewSection_1,
				SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnNewSection_1.setClient(composite);
		composite.setLayout(new GridLayout(1, false));

		Button btnNewButton = toolkit.createButton(composite, "Metrics",
				SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (currentComposite instanceof Metrics)
					return;
				updateComposite(container, new Metrics(container, SWT.NONE));
			}
		});
		btnNewButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		Button btnNewButton_1 = toolkit.createButton(composite, "New Metric",
				SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (currentComposite instanceof NewEditMetric)
					return;
				updateComposite(container, new NewEditMetric(container, SWT.NONE));

			}
		});
		btnNewButton_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		Button btnMetricSources = new Button(composite, SWT.FLAT);
		btnMetricSources.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		btnMetricSources.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Launch the editor.
				if (currentComposite instanceof MetricSources)
					return;
				updateComposite(container, new MetricSources(container,
						SWT.NONE));
			}
		});
		toolkit.adapt(btnMetricSources, true, true);
		btnMetricSources.setText("Metric Sources");

		Button btnNewMetricSource = toolkit.createButton(composite,
				"New Metric Source", SWT.NONE);
		btnNewMetricSource.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));

		Button btnPurgeMetrics = toolkit.createButton(composite,
				"Purge Metrics", SWT.NONE);
		btnPurgeMetrics.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		Button btnNewXlsMapping = toolkit.createButton(composite,
				"New XLS Mapping", SWT.NONE);
		btnNewXlsMapping.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));

		Button btnNewMappingColumn = toolkit.createButton(composite,
				"New Mapping Column", SWT.NONE);
		btnNewMappingColumn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (currentComposite instanceof NewEditMappingColumn)
					return;
				updateComposite(container, new NewEditMappingColumn(container,
						SWT.NONE));
			}
		});
		btnNewMappingColumn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));

		Button btnXlsMappingStatistics = toolkit.createButton(composite,
				"XLS Mapping Statistics", SWT.NONE);
		btnXlsMappingStatistics.setLayoutData(new GridData(SWT.FILL,
				SWT.CENTER, false, false, 1, 1));

		Button btnResource = toolkit.createButton(composite, "Resource",
				SWT.NONE);
		btnResource.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (currentComposite instanceof NewEditResource)
					return;
				updateComposite(container, new NewEditResource(container, SWT.NONE));

			}
		});
		btnResource.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		Button btnMetricValueRange = toolkit.createButton(composite,
				"Metric Value Range", SWT.NONE);
		btnMetricValueRange.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (currentComposite instanceof MetricValueRange)
					return;
				updateComposite(container, new MetricValueRange(container,
						SWT.NONE));

			}
		});
		btnMetricValueRange.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));

		Button btnCapacityRange = toolkit.createButton(composite,
				"Capacity Range", SWT.NONE);
		btnCapacityRange.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (currentComposite instanceof ResourceCapacityRange)
					return;
				updateComposite(container, new ResourceCapacityRange(container,
						SWT.NONE));
			}
		});
		btnCapacityRange.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		
		Button btnResourceMonitor = toolkit.createButton(composite, "Resource Monitor", SWT.NONE);
		btnResourceMonitor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (currentComposite instanceof ResourceMonitor)
					return;
				updateComposite(container, new ResourceMonitor(container,
						SWT.NONE));
			}
		});
		btnResourceMonitor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnXlsMappingStatistics.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				if (currentComposite instanceof MappingStatistics)
					return;
				updateComposite(container, new MappingStatistics(container,
						SWT.NONE));
			}
		});
		btnNewXlsMapping.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (currentComposite instanceof NewEditMappingXLS)
					return;
				updateComposite(container, new NewEditMappingXLS(container,
						SWT.NONE));
			}
		});
		btnPurgeMetrics.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (currentComposite instanceof PurgeMetrics)
					return;
				updateComposite(container,
						new PurgeMetrics(container, SWT.NONE));
			}
		});
		btnNewMetricSource.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (currentComposite instanceof NewEditMetricSource)
					return;
				updateComposite(container, new NewEditMetricSource(container,
						SWT.NONE));
			}
		});

		updateComposite(container, new Composite(container, SWT.BORDER));

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	public void updateComposite(Composite container, Composite control) {
		if (currentComposite != null) {
			currentComposite.dispose();
		}

		currentComposite = control;
		FormData fd_currentComposite = new FormData();
		fd_currentComposite.left = new FormAttachment(0, 177);
		fd_currentComposite.right = new FormAttachment(100, -10);
		fd_currentComposite.bottom = new FormAttachment(100, -3);
		fd_currentComposite.top = new FormAttachment(0, 34);
		currentComposite.setLayoutData(fd_currentComposite);

		toolkit.adapt(control);
		toolkit.paintBordersFor(control);

		fd_frmNewForm.right = new FormAttachment(currentComposite, -6);

		container.pack();
		// parentComposite.pack();
		parentComposite.layout(true);
	}

	public void dispose() {
		toolkit.dispose();
		super.dispose();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		@SuppressWarnings("unused")
		IToolBarManager tbm = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		@SuppressWarnings("unused")
		IMenuManager manager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
}
