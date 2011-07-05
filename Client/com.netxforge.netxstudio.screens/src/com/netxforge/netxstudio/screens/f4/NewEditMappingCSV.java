package com.netxforge.netxstudio.screens.f4;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.nebula.jface.gridviewer.GridTableViewer;
import org.eclipse.nebula.jface.gridviewer.GridViewerColumn;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
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
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.MappingCSV;
import com.netxforge.netxstudio.metrics.MappingColumn;
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
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f4.support.CSVServiceJob;
import com.netxforge.netxstudio.workspace.WorkspaceUtil;

public class NewEditMappingCSV extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFirstHeaderRow;
	private Text txtFirstDataRow;
	private Table table;
	private Text txtSelectedCSVPath;
	private Form frmCSVMappingForm;
	private MetricSource owner;
	private MappingCSV mapping;
	private MappingCSV original;
	private TableViewer mappingColumnsTableViewer;
	private GridTableViewer gridTableViewer;
	private Menu gridMenu;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditMappingCSV(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmCSVMappingForm = toolkit.createForm(this);
		frmCSVMappingForm.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmCSVMappingForm);
		frmCSVMappingForm.getBody().setLayout(new FormLayout());

		Section sctnSummary = toolkit.createSection(
				frmCSVMappingForm.getBody(), Section.EXPANDED
						| Section.TITLE_BAR);
		FormData fd_sctnSummary = new FormData();
		sctnSummary.setLayoutData(fd_sctnSummary);
		toolkit.paintBordersFor(sctnSummary);
		sctnSummary.setText("Summary");
		sctnSummary.setExpanded(true);

		Composite composite_1 = toolkit.createComposite(sctnSummary, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnSummary.setClient(composite_1);
		composite_1.setLayout(new GridLayout(2, false));

		Label lblHeaderrow = toolkit.createLabel(composite_1,
				"1st Header row:", SWT.NONE);
		lblHeaderrow.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtFirstHeaderRow = toolkit.createText(composite_1, "New Text",
				SWT.NONE);
		txtFirstHeaderRow.setText("");
		GridData gd_txtFirstHeaderRow = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_txtFirstHeaderRow.widthHint = 20;
		txtFirstHeaderRow.setLayoutData(gd_txtFirstHeaderRow);

		Label lblstDataRow = toolkit.createLabel(composite_1, "1st Data row:",
				SWT.NONE);
		lblstDataRow.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtFirstDataRow = toolkit.createText(composite_1, "New Text", SWT.NONE);
		GridData gd_txtFirstDataRow = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFirstDataRow.widthHint = 20;
		txtFirstDataRow.setLayoutData(gd_txtFirstDataRow);
		txtFirstDataRow.setText("");

		Section sctnCSVInteractive = toolkit.createSection(
				frmCSVMappingForm.getBody(), Section.EXPANDED
						| Section.TITLE_BAR);
		fd_sctnSummary.top = new FormAttachment(sctnCSVInteractive, 0, SWT.TOP);
		fd_sctnSummary.right = new FormAttachment(0, 355);
		FormData fd_sctnXLSInteractive = new FormData();
		fd_sctnXLSInteractive.top = new FormAttachment(0, 10);
		fd_sctnXLSInteractive.bottom = new FormAttachment(100, -12);
		fd_sctnXLSInteractive.left = new FormAttachment(0, 370);
		fd_sctnXLSInteractive.right = new FormAttachment(100, -12);
		sctnCSVInteractive.setLayoutData(fd_sctnXLSInteractive);
		toolkit.paintBordersFor(sctnCSVInteractive);

		Composite composite_2 = toolkit.createComposite(sctnCSVInteractive,
				SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnCSVInteractive.setClient(composite_2);
		composite_2.setLayout(new GridLayout(2, false));

		Button btnSelectXls = toolkit.createButton(composite_2, "Select CSV",
				SWT.NONE);
		btnSelectXls.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				IPath[] paths = WorkspaceUtil.INSTANCE
						.browseWorkspace(NewEditMappingCSV.this.getShell());
				if (paths == null || paths.length == 0)
					return;
				// We only process the first selection.
				IFile f = WorkspaceUtil.INSTANCE.createFileHandle(paths[0]);
				txtSelectedCSVPath.setText(f.getName());
				final CSVServiceJob job = new CSVServiceJob();
				job.addNotifier(new JobChangeAdapter() {
					@Override
					public void done(IJobChangeEvent event) {
						super.done(event);

						String[][] records = job.getRecords();
						if (records != null) {
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									fillGrid(job.getRecords());
								}
							});
						}
					}
				});
				job.setResourceToProcess(f);
				job.go(); // Should spawn a job processing the xls.
				resetGridSelections();// Reset the selections.
			}
		});

		txtSelectedCSVPath = toolkit.createText(composite_2, "New Text",
				SWT.NONE);
		txtSelectedCSVPath.setText("<....>");
		txtSelectedCSVPath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));

		CTabFolder tabFolder = new CTabFolder(composite_2, SWT.BORDER);
		tabFolder.setTabHeight(20);
		tabFolder.setTabPosition(SWT.BOTTOM);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2,
				2));
		toolkit.adapt(tabFolder);
		toolkit.paintBordersFor(tabFolder);
		tabFolder.setSelectionBackground(SWTResourceManager.getColor(240, 255,
				255));

		CTabItem tbtmSheet1 = new CTabItem(tabFolder, SWT.NONE);
		tbtmSheet1.setText("CSV");

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

		gridMenu = new Menu(grid);
		grid.setMenu(gridMenu);
		gridMenu.addMenuListener(new MenuListener() {
			public void menuHidden(MenuEvent e) {
				System.out.println(e);
			}

			public void menuShown(MenuEvent e) {
				System.out.println(e);
				// Can we still build the menu here before it shows.
				// Clear the entries.
				MenuItem[] mis = gridMenu.getItems();
				for (int i = 0; i < mis.length; i++) {
					mis[i].dispose();
				}

				if (currentRowIndex != -1) {
					{
						MenuItem mi = new MenuItem(gridMenu, SWT.PUSH);
						mi.setText("Set Header row index (" + currentRowIndex
								+ ")");
						mi.addSelectionListener(new SelectionAdapter() {
							@Override
							public void widgetSelected(SelectionEvent e) {
								txtFirstHeaderRow.setText(new Integer(
										currentRowIndex).toString());
							}
						});
					}
					{
						MenuItem mi = new MenuItem(gridMenu, SWT.PUSH);
						mi.setText("Set Data row index (" + currentRowIndex
								+ ")");
						mi.addSelectionListener(new SelectionAdapter() {
							@Override
							public void widgetSelected(SelectionEvent e) {
								txtFirstDataRow.setText(new Integer(
										currentRowIndex).toString());
							}
						});
					}
					{
						MenuItem mi = new MenuItem(gridMenu, SWT.PUSH);
						mi.setText("New Column Mapping with index ("
								+ currentColumnIndex + ")");
						mi.addSelectionListener(new SelectionAdapter() {
							@Override
							public void widgetSelected(SelectionEvent e) {
								// TODO Implement.

							}
						});
					}

				}
			}
		});

		Section sctnMappingColumns = toolkit.createSection(
				frmCSVMappingForm.getBody(), Section.TITLE_BAR);
		fd_sctnSummary.left = new FormAttachment(sctnMappingColumns, 0,
				SWT.LEFT);
		fd_sctnSummary.bottom = new FormAttachment(0, 120);
		FormData fd_sctnMappingColumns = new FormData();
		fd_sctnMappingColumns.top = new FormAttachment(sctnSummary, 12);
		fd_sctnMappingColumns.bottom = new FormAttachment(100, -12);
		fd_sctnMappingColumns.right = new FormAttachment(0, 355);
		fd_sctnMappingColumns.left = new FormAttachment(0, 12);
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
				mappingColumnScreen.setOperation(Screens.OPERATION_NEW);
				mappingColumnScreen.injectData(mapping,
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
					mappingColumnScreen.setOperation(Screens.OPERATION_EDIT);
					mappingColumnScreen.injectData(mapping, mappingColumn);
					screenService.setActiveScreen(mappingColumnScreen);

				}
			}
		});
		mntmEdit.setText("Edit...");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				mappingColumnsTableViewer, SWT.NONE);
		TableColumn tblclmnValueType = tableViewerColumn_1.getColumn();
		tblclmnValueType.setWidth(100);
		tblclmnValueType.setText("Value Type");
	}

	private void resetGridSelections() {
		this.currentColumnIndex = -1;
		this.currentRowIndex = -1;
	}

	/**
	 * Aggregates the selection in the grid, used by column and the grid.
	 * 
	 */
	GridSelectionListener gridSelector = new GridSelectionListener();
	private int currentRowIndex;
	private int currentColumnIndex;

	class GridSelectionListener extends SelectionAdapter {
		public void widgetSelected(SelectionEvent e) {
			System.out.println(e);
			updateSelection(e);
		}
	}

	/**
	 * Updates the row and column index to be used, by the screen further on.
	 * 
	 * Notice TODO: The mapping index for row starts at 1. The mapping index for
	 * column starts at 0.
	 * 
	 * @param e
	 */
	private void updateSelection(SelectionEvent e) {
		if (e instanceof IStructuredSelection) {
			@SuppressWarnings("unused")
			IStructuredSelection ss = (IStructuredSelection) e;
		}
		if (e.item instanceof GridItem) {
			GridItem gi = (GridItem) e.item;
			currentRowIndex = gridTableViewer.getGrid().indexOf(gi) + 1;

		}
		if (e.item instanceof GridColumn) {
			GridColumn gc = (GridColumn) e.item;
			currentColumnIndex = gridTableViewer.getGrid().indexOf(gc);
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

		// IObservableValue sheetNumberObservableValue = SWTObservables
		// .observeText(txtSheetNumber, SWT.Modify);

		IObservableValue firstDataRowObservableValue = SWTObservables
				.observeText(txtFirstDataRow, SWT.Modify);
		IObservableValue headerRowObservableValue = SWTObservables.observeText(
				txtFirstHeaderRow, SWT.Modify);

		// IEMFValueProperty sheetNumberProperty = EMFProperties
		// .value(MetricsPackage.Literals.MAPPING_XLS__SHEET_NUMBER);

		IEMFValueProperty firstDataRowProperty = EMFProperties
				.value(MetricsPackage.Literals.MAPPING__FIRST_DATA_ROW);
		IEMFValueProperty headerRowProperty = EMFProperties
				.value(MetricsPackage.Literals.MAPPING__HEADER_ROW);

		// context.bindValue(sheetNumberObservableValue,
		// sheetNumberProperty.observe(mapping), null, null);

		context.bindValue(firstDataRowObservableValue,
				firstDataRowProperty.observe(mapping), null, null);
		context.bindValue(headerRowObservableValue,
				headerRowProperty.observe(mapping), null, null);

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
		IEMFListProperty l = EMFProperties
				.list(MetricsPackage.Literals.MAPPING__MAPPING_COLUMNS);

		this.mappingColumnsTableViewer.setInput(l.observe(mapping));
		this.gridTableViewer.setContentProvider(new CSVGridContentProvider());
		gridTableViewer.setLabelProvider(new CSVGridLabelProvider());
		return context;
	}

	class CSVGridLabelProvider extends LabelProvider implements
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

	class CSVGridContentProvider implements IStructuredContentProvider {

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
			this.owner = (MetricSource) owner;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}

		if (object != null && object instanceof MappingCSV) {
			if (Screens.isEditOperation(this.getOperation())) {
				MappingCSV copy = EcoreUtil.copy((MappingCSV) object);
				mapping = copy;
				original = (MappingCSV) object;
			} else if (Screens.isNewOperation(getOperation())) {
				mapping = (MappingCSV) object;
			}
		}
		this.initDataBindings_();
		
		String title = "";
		if(Screens.isNewOperation(getOperation())){
			title = "New";
		}else{
			title = "Edit";
		}
		frmCSVMappingForm.setText( title + " CSV Mapping");
	}

	public void addData() {
		if (Screens.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.
			Command c = new SetCommand(editingService.getEditingDomain(),
					owner,
					MetricsPackage.Literals.METRIC_SOURCE__METRIC_MAPPING,
					mapping);
			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (Screens.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (original.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}

			Command c = new ReplaceCommand(editingService.getEditingDomain(),
					owner,
					MetricsPackage.Literals.METRIC_SOURCE__METRIC_MAPPING,
					original, mapping);

			editingService.getEditingDomain().getCommandStack().execute(c);

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
}
