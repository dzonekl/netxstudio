package com.netxforge.netxstudio.screens.f4;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
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
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.SWTResourceManager;

import com.netxforge.netxstudio.metrics.MappingXLS;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.workspace.WorkspaceUtil;

public class NewEditXLSMapping extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtSheetNumber;
	private Text txtFirstHeaderRow;
	private Text txtFirstDataRow;
	private Table table;
	private Text txtSelectedXLSPath;
	private Form frmXLSMappingForm;
	private MetricSource owner;
	private MappingXLS mapping;
	private MappingXLS original;
	private TableViewer mappingColumnsTableViewer;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	@SuppressWarnings("unused")
	public NewEditXLSMapping(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmXLSMappingForm = toolkit.createForm(this);
		frmXLSMappingForm.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmXLSMappingForm);
		frmXLSMappingForm.setText("New XLS Mapping");
		frmXLSMappingForm.getBody().setLayout(new FormLayout());

		Section sctnSummary = toolkit.createSection(
				frmXLSMappingForm.getBody(), Section.EXPANDED
						| Section.TITLE_BAR);
		FormData fd_sctnSummary = new FormData();
		fd_sctnSummary.top = new FormAttachment(0, 10);
		fd_sctnSummary.left = new FormAttachment(0, 12);
		sctnSummary.setLayoutData(fd_sctnSummary);
		toolkit.paintBordersFor(sctnSummary);
		sctnSummary.setText("Summary");
		sctnSummary.setExpanded(true);

		Composite composite_1 = toolkit.createComposite(sctnSummary, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnSummary.setClient(composite_1);
		composite_1.setLayout(new GridLayout(2, false));

		Label lblSheetName = toolkit.createLabel(composite_1, "Sheet Name:",
				SWT.NONE);
		lblSheetName.setAlignment(SWT.RIGHT);
		GridData gd_lblSheetName = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblSheetName.widthHint = 70;
		lblSheetName.setLayoutData(gd_lblSheetName);

		txtSheetNumber = toolkit.createText(composite_1, "New Text", SWT.NONE);
		txtSheetNumber.setText("");
		GridData gd_txtSheetName = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtSheetName.widthHint = 200;
		txtSheetNumber.setLayoutData(gd_txtSheetName);

		Label lblHeaderrow = toolkit.createLabel(composite_1,
				"1st Header row:", SWT.NONE);
		lblHeaderrow.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtFirstHeaderRow = toolkit.createText(composite_1, "New Text",
				SWT.NONE);
		txtFirstHeaderRow.setText("");
		GridData gd_txtFirstHeaderRow = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_txtFirstHeaderRow.widthHint = 15;
		txtFirstHeaderRow.setLayoutData(gd_txtFirstHeaderRow);

		Label lblstDataRow = toolkit.createLabel(composite_1, "1st Data row:",
				SWT.NONE);
		lblstDataRow.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtFirstDataRow = toolkit.createText(composite_1, "New Text", SWT.NONE);
		GridData gd_txtFirstDataRow = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFirstDataRow.widthHint = 15;
		txtFirstDataRow.setLayoutData(gd_txtFirstDataRow);
		txtFirstDataRow.setText("");

		Section sctnXLSInteractive = toolkit.createSection(
				frmXLSMappingForm.getBody(), Section.EXPANDED
						| Section.TITLE_BAR);
		FormData fd_sctnXLSInteractive = new FormData();
		fd_sctnXLSInteractive.top = new FormAttachment(sctnSummary, 0, SWT.TOP);
		fd_sctnXLSInteractive.bottom = new FormAttachment(100, -12);
		fd_sctnXLSInteractive.left = new FormAttachment(sctnSummary, 15);
		fd_sctnXLSInteractive.right = new FormAttachment(100, -12);
		sctnXLSInteractive.setLayoutData(fd_sctnXLSInteractive);
		toolkit.paintBordersFor(sctnXLSInteractive);

		Composite composite_2 = toolkit.createComposite(sctnXLSInteractive,
				SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnXLSInteractive.setClient(composite_2);
		composite_2.setLayout(new GridLayout(2, false));

		Button btnSelectXls = toolkit.createButton(composite_2, "Select XLS",
				SWT.NONE);
		btnSelectXls.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				IPath[] paths = WorkspaceUtil.INSTANCE
						.browseWorkspace(NewEditXLSMapping.this.getShell());
				if (paths == null || paths.length == 0)
					return;
				// DO something with the path.
			}
		});

		txtSelectedXLSPath = toolkit.createText(composite_2, "New Text",
				SWT.NONE);
		txtSelectedXLSPath.setText("<....>");
		txtSelectedXLSPath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));

		CTabFolder tabFolder = new CTabFolder(composite_2, SWT.BORDER);
		tabFolder.setTabHeight(20);
		tabFolder.setTabPosition(SWT.BOTTOM);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2,
				1));
		toolkit.adapt(tabFolder);
		toolkit.paintBordersFor(tabFolder);
		tabFolder.setSelectionBackground(SWTResourceManager.getColor(240, 255,
				255));

		CTabItem tbtmSheet1 = new CTabItem(tabFolder, SWT.NONE);
		tbtmSheet1.setText("Sheet 1");

		ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setAlwaysShowScrollBars(true);
		tbtmSheet1.setControl(scrolledComposite);
		toolkit.paintBordersFor(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		// CDateTime dateTime = new CDateTime(scrolledComposite, CDT.NONE);
		// toolkit.adapt(dateTime);
		// toolkit.paintBordersFor(dateTime);

		// CTabItem tabItem_1 = new CTabItem(tabFolder, SWT.NONE);
		// tabItem_1.setText("New Item");

		GridTableViewer gridTableViewer = new GridTableViewer(
				scrolledComposite, SWT.BORDER);
		Grid grid = gridTableViewer.getGrid();
		grid.setCellSelectionEnabled(true);
		grid.setHeaderVisible(true);
		grid.setRowHeaderVisible(true);
		// tabItem_1.setControl(grid);
		toolkit.paintBordersFor(grid);

		GridViewerColumn gridViewerColumn = new GridViewerColumn(
				gridTableViewer, SWT.NONE);
		GridColumn gridColumn = gridViewerColumn.getColumn();
		gridColumn.setAlignment(SWT.CENTER);
		gridColumn.setWidth(80);
		gridColumn.setText("A");

		GridColumn gridColumn_1 = new GridColumn(grid, SWT.NONE);
		gridColumn_1.setAlignment(SWT.CENTER);
		gridColumn_1.setText("B");
		gridColumn_1.setWidth(80);

		GridColumn gridColumn_2 = new GridColumn(grid, SWT.NONE);
		gridColumn_2.setAlignment(SWT.CENTER);
		gridColumn_2.setText("C");
		gridColumn_2.setWidth(80);

		GridViewerColumn gridViewerColumn_1 = new GridViewerColumn(
				gridTableViewer, SWT.NONE);
		GridColumn gridColumn_3 = gridViewerColumn_1.getColumn();
		gridColumn_3.setAlignment(SWT.CENTER);
		gridColumn_3.setWidth(80);
		gridColumn_3.setText("D");

		GridViewerColumn gridViewerColumn_2 = new GridViewerColumn(
				gridTableViewer, SWT.NONE);
		GridColumn gridColumn_4 = gridViewerColumn_2.getColumn();
		gridColumn_4.setAlignment(SWT.CENTER);
		gridColumn_4.setWidth(80);
		gridColumn_4.setText("E");

		GridItem gridItem = new GridItem(grid, SWT.NONE);
		GridItem gridItem_1 = new GridItem(grid, SWT.NONE);
		GridItem gridItem_2 = new GridItem(grid, SWT.NONE);
		GridItem gridItem_3 = new GridItem(grid, SWT.NONE);
		GridItem gridItem_4 = new GridItem(grid, SWT.NONE);

		GridItem gridItem_5 = new GridItem(grid, SWT.NONE);

		GridItem gridItem_6 = new GridItem(grid, SWT.NONE);

		GridItem gridItem_7 = new GridItem(grid, SWT.NONE);

		GridItem gridItem_8 = new GridItem(grid, SWT.NONE);

		GridItem gridItem_9 = new GridItem(grid, SWT.NONE);

		GridItem gridItem_10 = new GridItem(grid, SWT.NONE);

		GridItem gridItem_11 = new GridItem(grid, SWT.NONE);

		scrolledComposite.setContent(gridTableViewer.getGrid());
		scrolledComposite.setMinSize(gridTableViewer.getGrid().computeSize(
				SWT.DEFAULT, SWT.DEFAULT));

		CTabItem tbtmSheet2 = new CTabItem(tabFolder, SWT.NONE);
		tbtmSheet2.setText("Sheet 2");
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);

		Section sctnMappingColumns = toolkit.createSection(
				frmXLSMappingForm.getBody(), Section.TITLE_BAR);
		fd_sctnSummary.bottom = new FormAttachment(sctnMappingColumns, -12);
		fd_sctnSummary.right = new FormAttachment(sctnMappingColumns, 343);
		FormData fd_sctnMappingColumns = new FormData();
		fd_sctnMappingColumns.right = new FormAttachment(0, 355);
		fd_sctnMappingColumns.top = new FormAttachment(0, 172);
		fd_sctnMappingColumns.bottom = new FormAttachment(100, -55);
		fd_sctnMappingColumns.left = new FormAttachment(0, 12);
		sctnMappingColumns.setLayoutData(fd_sctnMappingColumns);
		toolkit.paintBordersFor(sctnMappingColumns);
		sctnMappingColumns.setText("Mapping Columns");

		Composite composite_3 = toolkit.createComposite(sctnMappingColumns,
				SWT.NONE);
		toolkit.paintBordersFor(composite_3);
		sctnMappingColumns.setClient(composite_3);
		composite_3.setLayout(new GridLayout(2, false));

		Composite composite_4 = toolkit.createComposite(composite_3, SWT.NONE);
		GridData gd_composite_4 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_composite_4.widthHint = 18;
		gd_composite_4.heightHint = 18;
		composite_4.setLayoutData(gd_composite_4);
		toolkit.paintBordersFor(composite_4);

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
		tblclmnDatHeader.setText("Header");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				mappingColumnsTableViewer, SWT.NONE);
		TableColumn tblclmnType = tableViewerColumn_1.getColumn();
		tblclmnType.setWidth(59);
		tblclmnType.setText("Type");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				mappingColumnsTableViewer, SWT.NONE);
		TableColumn tblclmnRowNum = tableViewerColumn_2.getColumn();
		tblclmnRowNum.setWidth(100);
		tblclmnRowNum.setText("Row Num");

		Button button = toolkit.createButton(composite_3, "+", SWT.NONE);
		GridData gd_button = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_button.widthHint = 18;
		gd_button.heightHint = 18;
		button.setLayoutData(gd_button);
		button.setAlignment(SWT.RIGHT);

		Button btnNewButton = toolkit.createButton(composite_3, "-", SWT.NONE);
		GridData gd_btnNewButton = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_btnNewButton.widthHint = 18;
		gd_btnNewButton.heightHint = 18;
		btnNewButton.setLayoutData(gd_btnNewButton);
		new Label(composite_3, SWT.NONE);

	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext context = new EMFDataBindingContext();

		// TODO, Validations and strategies.

		IObservableValue sheetNumberObservableValue = SWTObservables
				.observeText(txtSheetNumber);
		IEMFValueProperty sheetNumberProperty = EMFProperties
				.value(MetricsPackage.Literals.MAPPING_XLS__SHEET_NUMBER);

		context.bindValue(sheetNumberObservableValue,
				sheetNumberProperty.observe(mapping), null, null);

		IObservableValue firstDataRowObservableValue = SWTObservables
				.observeText(txtFirstDataRow);
		IEMFValueProperty firstDataRowProperty = EMFProperties
				.value(MetricsPackage.Literals.MAPPING_XLS__FIRST_DATA_ROW);

		context.bindValue(firstDataRowObservableValue,
				firstDataRowProperty.observe(mapping), null, null);

		IObservableValue headerRowObservableValue = SWTObservables
				.observeText(txtFirstHeaderRow);
		IEMFValueProperty headerRowProperty = EMFProperties
				.value(MetricsPackage.Literals.MAPPING_XLS__HEADER_ROW);

		context.bindValue(headerRowObservableValue,
				headerRowProperty.observe(mapping), null, null);

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		this.mappingColumnsTableViewer.setContentProvider(listContentProvider);

		IObservableMap[] observeMaps = EMFObservables
				.observeMaps(
						listContentProvider.getKnownElements(),
						new EStructuralFeature[] {
								MetricsPackage.Literals.MAPPING_XLS_COLUMN__COLUMN,
								MetricsPackage.Literals.MAPPING_XLS_COLUMN__DATA_TYPE });
		this.mappingColumnsTableViewer
				.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		IEMFListProperty l = EMFProperties
				.list(MetricsPackage.Literals.MAPPING_XLS__MAPPING_COLUMNS);

		this.mappingColumnsTableViewer.setInput(l.observe(mapping));

		return context;
	}

	public void injectData(Object owner, Object object) {
		if (owner instanceof MetricSource) {
			this.owner = (MetricSource) owner;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}

		if (object != null && object instanceof MappingXLS) {
			if (Screens.isEditOperation(this.getOperation())) {
				MappingXLS copy = EcoreUtil.copy((MappingXLS) object);
				mapping = copy;
				original = (MappingXLS) object;
			} else if (Screens.isNewOperation(getOperation())) {
				mapping = (MappingXLS) object;
			}
		}

		this.initDataBindings_();

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Form getScreenForm() {
		return frmXLSMappingForm;
	}

	public void disposeData() {
		// N/A
		
	}
}
