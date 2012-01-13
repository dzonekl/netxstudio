package com.netxforge.netxstudio.screens.f4;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.nebula.jface.gridviewer.GridTableViewer;
import org.eclipse.nebula.jface.gridviewer.GridViewerColumn;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
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
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.SWTResourceManager;

import com.google.common.collect.ImmutableMap;
import com.netxforge.netxstudio.metrics.DataKind;
import com.netxforge.netxstudio.metrics.DatabaseTypeType;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.MappingRDBMS;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ObjectKindType;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.metrics.ValueKindType;
import com.netxforge.netxstudio.metrics.impl.IdentifierDataKindImpl;
import com.netxforge.netxstudio.metrics.impl.ValueDataKindImpl;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.f4.support.ColumnMappingMenu;
import com.netxforge.netxstudio.screens.f4.support.ColumnMappingMenu.MappingMenuListener;
import com.netxforge.netxstudio.screens.f4.support.RDBMSServiceJob;

public class NewEditMappingRDBMS extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtDBUser;
	private Text txtDBPassword;
	private Table table;
	private Text txtDBQuery;
	private Form frmCSVMappingForm;
	private MetricSource metricSource;
	private MappingRDBMS mapping;
	private TableViewer mappingColumnsTableViewer;
	private GridTableViewer gridTableViewer;
	private Menu gridMenu;
	private ComboViewer cmbDBTypeViewer;
	private MappingMenuListener mmListener;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditMappingRDBMS(Composite parent, int style) {
		super(parent, style);
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

		// New or Edit.
		boolean edit = ScreenUtil.isEditOperation(getOperation());
		String actionText = edit ? "Edit: " : "New: ";

		frmCSVMappingForm = toolkit.createForm(this);
		frmCSVMappingForm.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmCSVMappingForm);
		frmCSVMappingForm.setText(actionText + " RDBMS Mapping: " + metricSource.getName());
		frmCSVMappingForm.getBody().setLayout(new FormLayout());

		Section sctnSummary = toolkit.createSection(
				frmCSVMappingForm.getBody(), Section.EXPANDED
						| Section.TITLE_BAR);
		FormData fd_sctnSummary = new FormData();
		fd_sctnSummary.top = new FormAttachment(0, 10);
		fd_sctnSummary.left = new FormAttachment(0, 12);
		sctnSummary.setLayoutData(fd_sctnSummary);
		toolkit.paintBordersFor(sctnSummary);
		sctnSummary.setText("Authentication");
		sctnSummary.setExpanded(true);

		Composite composite_1 = toolkit.createComposite(sctnSummary, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnSummary.setClient(composite_1);
		composite_1.setLayout(new GridLayout(2, false));

		Label lblUser = toolkit.createLabel(composite_1, "User:", SWT.NONE);
		lblUser.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));

		txtDBUser = toolkit.createText(composite_1, "New Text", SWT.NONE);
		txtDBUser.setText("");
		GridData gd_txtDBUser = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtDBUser.widthHint = 100;
		txtDBUser.setLayoutData(gd_txtDBUser);

		Label lblPassword = toolkit.createLabel(composite_1, "Password:",
				SWT.NONE);
		lblPassword.setAlignment(SWT.RIGHT);
		GridData gd_lblPassword = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblPassword.widthHint = 70;
		lblPassword.setLayoutData(gd_lblPassword);

		txtDBPassword = toolkit.createText(composite_1, "New Text",
				SWT.PASSWORD);
		GridData gd_txtDBPassword = new GridData(SWT.LEFT, SWT.TOP, false,
				false, 1, 1);
		gd_txtDBPassword.widthHint = 100;
		txtDBPassword.setLayoutData(gd_txtDBPassword);
		txtDBPassword.setText("");

		Section sctnRDBMSInteractive = toolkit.createSection(
				frmCSVMappingForm.getBody(), Section.EXPANDED
						| Section.TITLE_BAR);
		fd_sctnSummary.right = new FormAttachment(sctnRDBMSInteractive, -15);
		sctnRDBMSInteractive.setText("Query");
		FormData fd_sctnRDBMSInteractive = new FormData();
		fd_sctnRDBMSInteractive.top = new FormAttachment(0, 10);
		fd_sctnRDBMSInteractive.bottom = new FormAttachment(100, -12);
		fd_sctnRDBMSInteractive.left = new FormAttachment(0, 370);
		fd_sctnRDBMSInteractive.right = new FormAttachment(100, -12);
		sctnRDBMSInteractive.setLayoutData(fd_sctnRDBMSInteractive);
		toolkit.paintBordersFor(sctnRDBMSInteractive);

		Composite cmpQuery = toolkit.createComposite(sctnRDBMSInteractive,
				SWT.NONE);
		toolkit.paintBordersFor(cmpQuery);
		sctnRDBMSInteractive.setClient(cmpQuery);
		cmpQuery.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm = new SashForm(cmpQuery, SWT.VERTICAL);

		toolkit.adapt(sashForm);
		toolkit.paintBordersFor(sashForm);

		txtDBQuery = toolkit.createText(sashForm, "New Text", SWT.WRAP
				| SWT.MULTI);
		txtDBQuery.setText("<....>");

		Composite cmpGrid = toolkit.createComposite(sashForm, SWT.NONE);
		toolkit.paintBordersFor(cmpGrid);
		cmpGrid.setLayout(new GridLayout(1, false));

		Button btnTestQuery = toolkit.createButton(cmpGrid, "Test Query",
				SWT.NONE);

		CTabFolder tabFolder = new CTabFolder(cmpGrid, SWT.BORDER);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));
		tabFolder.setTabHeight(20);
		tabFolder.setTabPosition(SWT.BOTTOM);
		toolkit.adapt(tabFolder);
		toolkit.paintBordersFor(tabFolder);
		tabFolder.setSelectionBackground(SWTResourceManager.getColor(240, 255,
				255));

		CTabItem tbtmSheet1 = new CTabItem(tabFolder, SWT.NONE);
		tbtmSheet1.setText("Query Result");

		tabFolder.setSelection(tbtmSheet1);

		Composite composite = new Composite(tabFolder, SWT.BORDER);
		tbtmSheet1.setControl(composite);
		toolkit.paintBordersFor(composite);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));

		gridTableViewer = new GridTableViewer(composite, SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER);
		Grid grid = gridTableViewer.getGrid();
		grid.setCellSelectionEnabled(true);
		grid.setHeaderVisible(true);
		grid.setRowHeaderVisible(true);
		toolkit.paintBordersFor(grid);
		grid.addSelectionListener(gridSelector);
		buildFixedColumns(gridTableViewer);

		btnTestQuery.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				final RDBMSServiceJob job = new RDBMSServiceJob();
				job.addNotifier(new JobChangeAdapter() {
					@Override
					public void done(IJobChangeEvent event) {
						super.done(event);
						if (event.getResult().getSeverity() == IStatus.OK) {
							String[][] records = job.getRecords();
							if (records != null) {
								Display.getDefault().asyncExec(new Runnable() {
									public void run() {
										fillGrid(job.getRecords());
									}
								});
							}
						} else {
							MessageDialog.openError(NewEditMappingRDBMS.this
									.getShell(), "Error testing query", event
									.getResult().getMessage());
						}
					}
				});
				job.setDetailsToProcess(metricSource, mapping);
				job.go(); // Should spawn a job processing the xls.
				// resetGridSelections();// Reset the selections.
			}
		});

		sashForm.setWeights(new int[] { 3, 7 });

		Section sctnMappingColumns = toolkit.createSection(
				frmCSVMappingForm.getBody(), Section.TITLE_BAR);
		FormData fd_sctnMappingColumns = new FormData();
		fd_sctnMappingColumns.bottom = new FormAttachment(100, -12);
		fd_sctnMappingColumns.left = new FormAttachment(0, 12);
		fd_sctnMappingColumns.right = new FormAttachment(0, 355);
		sctnMappingColumns.setLayoutData(fd_sctnMappingColumns);
		toolkit.paintBordersFor(sctnMappingColumns);
		sctnMappingColumns.setText("Mapping Columns");

		Composite composite_3 = toolkit.createComposite(sctnMappingColumns,
				SWT.NONE);
		toolkit.paintBordersFor(composite_3);
		sctnMappingColumns.setClient(composite_3);
		composite_3.setLayout(new GridLayout(1, false));

		ImageHyperlink mghprlnkNew = toolkit.createImageHyperlink(composite_3,
				SWT.NONE);
		mghprlnkNew.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {

				NewEditMappingColumn mappingColumnScreen = new NewEditMappingColumn(
						screenService.getScreenContainer(), SWT.NONE);
				mappingColumnScreen.setOperation(ScreenUtil.OPERATION_NEW);
				mappingColumnScreen.setScreenService(screenService);
				mappingColumnScreen.injectData(mapping.getDataMappingColumns(),
						MetricsFactory.eINSTANCE.createMappingColumn());
				screenService.setActiveScreen(mappingColumnScreen);

			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		mghprlnkNew.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		toolkit.paintBordersFor(mghprlnkNew);
		mghprlnkNew.setText("New");

		mappingColumnsTableViewer = new TableViewer(composite_3, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = mappingColumnsTableViewer.getTable();
		table.setLinesVisible(true);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4);
		gd_table.heightHint = 148;
		table.setLayoutData(gd_table);
		table.setHeaderVisible(true);
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				mappingColumnsTableViewer, SWT.NONE);
		TableColumn tblclmnDatHeader = tableViewerColumn.getColumn();
		tblclmnDatHeader.setWidth(100);
		tblclmnDatHeader.setText("Type");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				mappingColumnsTableViewer, SWT.NONE);
		TableColumn tblclmnRowNum = tableViewerColumn_2.getColumn();
		tblclmnRowNum.setWidth(100);
		tblclmnRowNum.setText("Column Num");

		Menu menu = new Menu(table);
		table.setMenu(menu);

		MenuItem mntmEdit = new MenuItem(menu, SWT.NONE);
		mntmEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = mappingColumnsTableViewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();

					NewEditMappingColumn mappingColumnScreen = new NewEditMappingColumn(
							screenService.getScreenContainer(), SWT.NONE);
					mappingColumnScreen.setOperation(ScreenUtil.OPERATION_EDIT);
					mappingColumnScreen.setScreenService(screenService);
					mappingColumnScreen.injectData(metricSource, true, mapping.getDataMappingColumns(), mappingColumn);
					screenService.setActiveScreen(mappingColumnScreen);

				}
			}
		});
		mntmEdit.setText("Edit...");
		
		

		MenuItem mntmRemove = new MenuItem(menu, SWT.NONE);
		mntmRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = mappingColumnsTableViewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();
					RemoveCommand rc = new RemoveCommand(editingService
							.getEditingDomain(), mapping
							.getDataMappingColumns(), mappingColumn);
					editingService.getEditingDomain().getCommandStack().execute(rc);
				}

			}
		});
		mntmRemove.setText("Remove");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				mappingColumnsTableViewer, SWT.NONE);
		TableColumn tblclmnValueType = tableViewerColumn_1.getColumn();
		tblclmnValueType.setWidth(100);
		tblclmnValueType.setText("Value Type");

		Section sctnRDBMSInfo = toolkit.createSection(
				frmCSVMappingForm.getBody(), Section.EXPANDED
						| Section.TITLE_BAR);
		fd_sctnSummary.bottom = new FormAttachment(sctnRDBMSInfo, -6);
		fd_sctnMappingColumns.top = new FormAttachment(0, 272);
		FormData fd_sctnRDBMSInfo = new FormData();
		fd_sctnRDBMSInfo.top = new FormAttachment(0, 128);
		fd_sctnRDBMSInfo.bottom = new FormAttachment(sctnMappingColumns, -6);
		fd_sctnRDBMSInfo.right = new FormAttachment(sctnRDBMSInteractive, -15);
		fd_sctnRDBMSInfo.left = new FormAttachment(0, 12);
		sctnRDBMSInfo.setLayoutData(fd_sctnRDBMSInfo);
		toolkit.paintBordersFor(sctnRDBMSInfo);
		sctnRDBMSInfo.setText("RDBMS Info");

		Composite composite_4 = toolkit
				.createComposite(sctnRDBMSInfo, SWT.NONE);
		toolkit.paintBordersFor(composite_4);
		sctnRDBMSInfo.setClient(composite_4);
		composite_4.setLayout(new GridLayout(2, false));

		Label lblDbType = toolkit.createLabel(composite_4, "DB Type", SWT.NONE);
		GridData gd_lblDbType = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblDbType.widthHint = 70;
		lblDbType.setLayoutData(gd_lblDbType);

		cmbDBTypeViewer = new ComboViewer(composite_4, SWT.NONE);
		Combo cmbDBType = cmbDBTypeViewer.getCombo();
		GridData gd_cmbDBType = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_cmbDBType.widthHint = 100;
		cmbDBType.setLayoutData(gd_cmbDBType);
		toolkit.paintBordersFor(cmbDBType);

		gridMenu = new Menu(grid);
		grid.setMenu(gridMenu);

		// Delegate to a singleton holding the MappingMenuListener class.
		mmListener = ColumnMappingMenu.getINSTANCE().new MappingMenuListener(
				gridMenu, mapping, screenService, null, null);
		mmListener.setMetricSource(metricSource);
		gridMenu.addMenuListener(mmListener);

	}

	// private void resetGridSelections() {
	// this.currentColumnIndex = -1;
	// this.currentRowIndex = -1;
	// }

	/**
	 * Aggregates the selection in the grid, used by column and the grid.
	 * 
	 */
	GridSelectionListener gridSelector = new GridSelectionListener();

	// private int currentRowIndex;
	// private int currentColumnIndex;

	class GridSelectionListener extends SelectionAdapter {
		public void widgetSelected(SelectionEvent e) {
			System.out.println(e);
			updateSelection(e);
		}
	}

	/**
	 * Updates the row and column index to be used, by the screen further on.
	 * 
	 * @param e
	 */
	private void updateSelection(SelectionEvent e) {
		Point[] p = gridTableViewer.getGrid().getCellSelection();
		if (p.length >= 1) {

			mmListener.setCurrentColumnIndex(p[0].x);
			mmListener.setCurrentRowIndex(p[0].y);
		}
	}

	private void buildFixedColumns(GridTableViewer v) {
		int i = 0;
		for (; i < 70; i++) {
			GridViewerColumn gvc = new GridViewerColumn(gridTableViewer,
					SWT.NONE);
			GridColumn newGridColumn = gvc.getColumn();
			newGridColumn.setAlignment(SWT.CENTER);
			newGridColumn.setWidth(80);
			newGridColumn.addSelectionListener(gridSelector);
			newGridColumn.setText(new Integer(i).toString());
		}
	}

	protected void fillGrid(String[][] records) {
		this.gridTableViewer.setInput(records);
	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext context = new EMFDataBindingContext();

		// TODO, Validations and strategies.

		IObservableValue dbUserObservableValue = SWTObservables.observeText(
				txtDBUser, SWT.Modify);
		IObservableValue dbPasswordObservableValue = SWTObservables
				.observeText(txtDBPassword, SWT.Modify);

		IObservableValue dbQueryObservableValue = SWTObservables.observeText(
				txtDBQuery, SWT.Modify);

		IEMFValueProperty dbUserProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.MAPPING_RDBMS__USER);

		IEMFValueProperty dbPasswordProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.MAPPING_RDBMS__PASSWORD);

		IEMFValueProperty dbQueryProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.MAPPING_RDBMS__QUERY);

		IEMFValueProperty dbTypeProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.MAPPING_RDBMS__DATABASE_TYPE);

		cmbDBTypeViewer.setContentProvider(new ArrayContentProvider());
		cmbDBTypeViewer.setLabelProvider(new LabelProvider());
		cmbDBTypeViewer.setInput(DatabaseTypeType.VALUES);

		IValueProperty selectionProperty = ViewerProperties.singleSelection();

		context.bindValue(selectionProperty.observe(cmbDBTypeViewer),
				dbTypeProperty.observe(mapping), null, null);

		context.bindValue(dbUserObservableValue,
				dbUserProperty.observe(mapping), null, null);

		context.bindValue(dbPasswordObservableValue,
				dbPasswordProperty.observe(mapping), null, null);

		context.bindValue(dbQueryObservableValue,
				dbQueryProperty.observe(mapping), null, null);

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		this.mappingColumnsTableViewer.setContentProvider(listContentProvider);

		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] {
						MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE,
						MetricsPackage.Literals.MAPPING_COLUMN__COLUMN });

		this.mappingColumnsTableViewer
				.setLabelProvider(new ColumnObservableMapLabelProvider(
						observeMaps));
		IEMFListProperty l = EMFEditProperties.list(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.MAPPING__DATA_MAPPING_COLUMNS);

		this.mappingColumnsTableViewer.setInput(l.observe(mapping));
		this.gridTableViewer.setContentProvider(new RDBMSGridContentProvider());
		gridTableViewer.setLabelProvider(new RDBMSGridLabelProvider());

		// Make sure our row headers, show starting with 0.
		gridTableViewer.setRowHeaderLabelProvider(new CellLabelProvider() {
			@Override
			public void update(ViewerCell cell) {
				GridItem gi = (GridItem) cell.getItem();
				int index = gridTableViewer.getGrid().indexOf(gi);
				cell.setText(new Integer(index).toString());
			}

		});

		return context;
	}

	class RDBMSGridLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof String[]) {
				String[] array = (String[]) element;
				if (columnIndex < array.length) {
					return array[columnIndex];
				}
			}
			return "";
		}

	}

	class RDBMSGridContentProvider implements IStructuredContentProvider {

		public void dispose() {
			// ?
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// Not applicable.
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof String[][]) {
				String[][] input = (String[][]) inputElement;
				return input;
			}
			return null;
		}
	}

	ImmutableMap<?, String> dataKindMap = ImmutableMap.of(
			IdentifierDataKindImpl.class, "Identifier",
			ValueDataKindImpl.class, "Value");

	private class ColumnObservableMapLabelProvider extends
			ObservableMapLabelProvider {

		public ColumnObservableMapLabelProvider(IObservableMap attributeMap) {
			super(attributeMap);
		}

		public ColumnObservableMapLabelProvider(IObservableMap[] observeMaps) {
			super(observeMaps);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			MappingColumn c = (MappingColumn) element;
			if (columnIndex == 0) {
				// This is the type Column.
				DataKind k = c.getDataType();
				if (k != null) {
					return dataKindMap.get(k.getClass());
				}
			}
			if (columnIndex == 2) {
				if (c.getDataType() instanceof ValueDataKind) {
					ValueKindType vkt = ((ValueDataKind) c.getDataType())
							.getValueKind();
					return vkt.getName();
				}
				if (c.getDataType() instanceof IdentifierDataKind) {
					IdentifierDataKind idk = (IdentifierDataKind) c
							.getDataType();
					ObjectKindType okt = idk.getObjectKind();
					return okt.getName();
				}

			}

			return super.getColumnText(element, columnIndex);
		}
	}

	public void injectData(Object owner, Object object) {
		if (owner instanceof MetricSource) {
			this.metricSource = (MetricSource) owner;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}

		if (object != null && object instanceof MappingRDBMS) {
			mapping = (MappingRDBMS) object;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}

		buildUI();
		this.initDataBindings_();
	}

	public void addData() {
		if (ScreenUtil.isNewOperation(getOperation()) && metricSource != null) {
			// If new, we have been operating on an object not added yet.
			Command c = new SetCommand(editingService.getEditingDomain(),
					metricSource,
					MetricsPackage.Literals.METRIC_SOURCE__METRIC_MAPPING,
					mapping);
			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (ScreenUtil.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (mapping.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}

			System.out.println(mapping.cdoID() + "" + mapping.cdoState());

		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
		}

	}

	@Override
	public Viewer getViewer() {
		return null; // N/A
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return frmCSVMappingForm;
	}

	public void disposeData() {
		// N/A

	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}
	
	public String getScreenName() {
		return "Mapping RDBMS";
	}

}
