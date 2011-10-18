package com.netxforge.netxstudio.screens.f4;

import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellLabelProvider;
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
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.ColumnLayoutData;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.SWTResourceManager;

import com.google.common.collect.ImmutableMap;
import com.netxforge.netxstudio.common.Tuple;
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
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f4.support.ColumnMappingMenu;
import com.netxforge.netxstudio.screens.f4.support.ColumnMappingMenu.MappingMenuListener;
import com.netxforge.netxstudio.workspace.WorkspaceUtil;

public class NewEditMappingCSV extends AbstractMapping implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFirstHeaderRow;
	private Text txtFirstDataRow;
	private Table tblDataColumnMapping;
	private Text txtSelectedCSVPath;
	private Form frmCSVMappingForm;
	private MetricSource metricSource;
	private MappingCSV mapping;
	private TableViewer tblViewerDataColumnMapping;
	private GridTableViewer gridTableViewer;
	private Menu gridMenu;
	private TableViewer tblViewerHeaderColumnMapping;
	private MappingMenuListener mmListener;

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
//		buildUI();
	}

	private void buildUI() {
		
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// New or Edit.
		boolean edit = Screens.isEditOperation(getOperation());
		String actionText = edit ? "Edit: " : "New: ";

		frmCSVMappingForm = toolkit.createForm(this);
		frmCSVMappingForm.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmCSVMappingForm);
		frmCSVMappingForm.setText(actionText + " CSV Mapping: "
				+ metricSource.getName());
		frmCSVMappingForm.getBody().setLayout(new FillLayout());

		SashForm sashFormMappings = new SashForm(frmCSVMappingForm.getBody(),
				SWT.SMOOTH);
		toolkit.adapt(sashFormMappings);
		toolkit.paintBordersFor(sashFormMappings);

		Composite leftComposite = toolkit.createComposite(sashFormMappings,
				SWT.NONE);
		toolkit.paintBordersFor(leftComposite);
		ColumnLayout cl_leftComposite = new ColumnLayout();
		cl_leftComposite.rightMargin = 10;
		cl_leftComposite.leftMargin = 10;
		cl_leftComposite.topMargin = 10;
		cl_leftComposite.maxNumColumns = 1;
		leftComposite.setLayout(cl_leftComposite);

		buildIntervalSection(leftComposite);
		buildHeaderMappingSection(leftComposite);
		buildDataMappingSection(leftComposite);
		
		Composite rightComposite = toolkit.createComposite(sashFormMappings,
				SWT.NONE);
		toolkit.paintBordersFor(rightComposite);
		
		FillLayout fLayout = new FillLayout();
		fLayout.marginHeight = 10;
		fLayout.marginWidth = 10;
		rightComposite.setLayout(fLayout);

		this.buildInteractiveSection(rightComposite);
		sashFormMappings.setWeights(new int[] {4, 6});

		// sashFormMappings.setWeights(new int[]{5,5});

	}

	private void buildHeaderMappingSection(Composite leftComposite) {
		Section sctnHeaderMapping = toolkit.createSection(leftComposite,
				Section.EXPANDED | Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnHeaderMapping);
		sctnHeaderMapping.setText("Header Mapping");
		sctnHeaderMapping.setExpanded(true);

		Composite headerMappingComposite = toolkit.createComposite(sctnHeaderMapping, SWT.NONE);
		toolkit.paintBordersFor(headerMappingComposite);
		sctnHeaderMapping.setClient(headerMappingComposite);
		headerMappingComposite.setLayout(new GridLayout(2, false));

		Label lblHeaderrow = toolkit.createLabel(headerMappingComposite, "Header row:",
				SWT.NONE);
		GridData gd_lblHeaderrow = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblHeaderrow.widthHint = 70;
		lblHeaderrow.setLayoutData(gd_lblHeaderrow);

		txtFirstHeaderRow = toolkit.createText(headerMappingComposite, "New Text",
				SWT.NONE);
		txtFirstHeaderRow.setText("");
		GridData gd_txtFirstHeaderRow = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_txtFirstHeaderRow.widthHint = 20;
		txtFirstHeaderRow.setLayoutData(gd_txtFirstHeaderRow);
		new Label(headerMappingComposite, SWT.NONE);

		ImageHyperlink mghprlnkNewHeaderMappingColumn = toolkit
				.createImageHyperlink(headerMappingComposite, SWT.NONE);
		mghprlnkNewHeaderMappingColumn
				.addHyperlinkListener(new IHyperlinkListener() {
					public void linkActivated(HyperlinkEvent e) {
						newColumnMappingScreen(false, Screens.OPERATION_NEW,
								mapping.getHeaderMappingColumns(),
								MetricsFactory.eINSTANCE.createMappingColumn());
					}

					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}
				});
		mghprlnkNewHeaderMappingColumn.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, false, false, 1, 1));
		toolkit.paintBordersFor(mghprlnkNewHeaderMappingColumn);
		mghprlnkNewHeaderMappingColumn.setText("New");

		tblViewerHeaderColumnMapping = new TableViewer(headerMappingComposite, SWT.BORDER
				| SWT.FULL_SELECTION);
		tblHeaderColumnMapping = tblViewerHeaderColumnMapping.getTable();
		tblHeaderColumnMapping.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerHeaderColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();
					int row = mapping.getHeaderRow();
					setGridSelection((MappingColumn) mappingColumn, row);
				}
			}
		});
		tblHeaderColumnMapping.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerHeaderColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();
					int row = mapping.getHeaderRow();
					setGridSelection((MappingColumn) mappingColumn, row);
				}
			}
		});
		tblHeaderColumnMapping.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerHeaderColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();
					int row = mapping.getHeaderRow();
					setGridSelection((MappingColumn) mappingColumn, row);
				}
			}
		});

		tblHeaderColumnMapping.setLinesVisible(true);
		tblHeaderColumnMapping.setHeaderVisible(true);
		GridData gd_tblHeaderColumnMapping = new GridData(SWT.FILL, SWT.FILL,
				true, true, 2, 1);
		gd_tblHeaderColumnMapping.heightHint = 100;
		tblHeaderColumnMapping.setLayoutData(gd_tblHeaderColumnMapping);
		toolkit.paintBordersFor(tblHeaderColumnMapping);

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(
				tblViewerHeaderColumnMapping, SWT.NONE);
		TableColumn tblclmnType = tableViewerColumn_3.getColumn();
		tblclmnType.setWidth(90);
		tblclmnType.setText("Type");

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(
				tblViewerHeaderColumnMapping, SWT.NONE);
		TableColumn tblclmnColumnNum = tableViewerColumn_4.getColumn();
		tblclmnColumnNum.setWidth(80);
		tblclmnColumnNum.setText("Column Num");

		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(
				tblViewerHeaderColumnMapping, SWT.NONE);
		TableColumn tblclmnValueType_1 = tableViewerColumn_5.getColumn();
		tblclmnValueType_1.setWidth(100);
		tblclmnValueType_1.setText("Value Type");

		Menu headerColumnMappingMenu = new Menu(tblHeaderColumnMapping);
		tblHeaderColumnMapping.setMenu(headerColumnMappingMenu);

		MenuItem mntmEdit_1 = new MenuItem(headerColumnMappingMenu, SWT.NONE);
		mntmEdit_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerHeaderColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();
					newColumnMappingScreen(false, Screens.OPERATION_EDIT,
							mapping.getHeaderMappingColumns(), mappingColumn);
				}

			}
		});
		mntmEdit_1.setText("Edit...");

		MenuItem mntmRemove = new MenuItem(headerColumnMappingMenu, SWT.NONE);
		mntmRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerHeaderColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();
					RemoveCommand rc = new RemoveCommand(editingService
							.getEditingDomain(), mapping
							.getDataMappingColumns(), mappingColumn);
					editingService.getEditingDomain().getCommandStack()
							.execute(rc);
				}

			}
		});
		mntmRemove.setText("Remove");
	}
	
	
	private void buildDataMappingSection(Composite composite){
		Section sctnMappingColumns = toolkit.createSection(composite,
				Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnMappingColumns);
		sctnMappingColumns.setText("Data Mapping");

		Composite composite_3 = toolkit.createComposite(sctnMappingColumns,
				SWT.NONE);
		toolkit.paintBordersFor(composite_3);
		sctnMappingColumns.setClient(composite_3);
		composite_3.setLayout(new GridLayout(2, false));

		Label lblstDataRow = toolkit.createLabel(composite_3, "Data row:",
				SWT.NONE);
		GridData gd_lblstDataRow = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblstDataRow.widthHint = 70;
		lblstDataRow.setLayoutData(gd_lblstDataRow);

		txtFirstDataRow = toolkit.createText(composite_3, "New Text", SWT.NONE);
		GridData gd_txtFirstDataRow = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFirstDataRow.widthHint = 20;
		txtFirstDataRow.setLayoutData(gd_txtFirstDataRow);
		txtFirstDataRow.setText("");
		new Label(composite_3, SWT.NONE);

		ImageHyperlink mghprlnkNew = toolkit.createImageHyperlink(composite_3,
				SWT.NONE);
		mghprlnkNew.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				newColumnMappingScreen(true, Screens.OPERATION_NEW,
						mapping.getDataMappingColumns(),
						MetricsFactory.eINSTANCE.createMappingColumn());
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

		tblViewerDataColumnMapping = new TableViewer(composite_3, SWT.BORDER
				| SWT.FULL_SELECTION);
		tblDataColumnMapping = tblViewerDataColumnMapping.getTable();
		tblDataColumnMapping.setLinesVisible(true);
		tblDataColumnMapping.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerDataColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();
					int row = mapping.getFirstDataRow();
					setGridSelection((MappingColumn) mappingColumn, row);
				}
			}
		});

		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 2);
		gd_table.heightHint = 137;
		tblDataColumnMapping.setLayoutData(gd_table);
		tblDataColumnMapping.setHeaderVisible(true);
		toolkit.paintBordersFor(tblDataColumnMapping);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tblViewerDataColumnMapping, SWT.NONE);
		TableColumn tblclmnDatHeader = tableViewerColumn.getColumn();
		tblclmnDatHeader.setWidth(90);
		tblclmnDatHeader.setText("Type");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tblViewerDataColumnMapping, SWT.NONE);
		TableColumn tblclmnRowNum = tableViewerColumn_2.getColumn();
		tblclmnRowNum.setWidth(80);
		tblclmnRowNum.setText("Column Num");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tblViewerDataColumnMapping, SWT.NONE);
		TableColumn tblclmnValueType = tableViewerColumn_1.getColumn();
		tblclmnValueType.setWidth(100);
		tblclmnValueType.setText("Value Type");

		TableViewerColumn tblViewerColumnValue = new TableViewerColumn(
				tblViewerDataColumnMapping, SWT.NONE);
		TableColumn tblclmnValue = tblViewerColumnValue.getColumn();
		tblclmnValue.setWidth(80);
		tblclmnValue.setText("Value");

		Menu dataColumnMappingMenu = new Menu(tblDataColumnMapping);
		tblDataColumnMapping.setMenu(dataColumnMappingMenu);

		MenuItem mntmEdit = new MenuItem(dataColumnMappingMenu, SWT.NONE);
		mntmEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerDataColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();
					newColumnMappingScreen(true, Screens.OPERATION_EDIT,
							mapping.getDataMappingColumns(), mappingColumn);
				}
			}
		});
		mntmEdit.setText("Edit...");

		MenuItem mntmRemove_1 = new MenuItem(dataColumnMappingMenu, SWT.NONE);
		mntmRemove_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tblViewerDataColumnMapping
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object mappingColumn = ((IStructuredSelection) selection)
							.getFirstElement();
					RemoveCommand rc = new RemoveCommand(editingService
							.getEditingDomain(), mapping
							.getDataMappingColumns(), mappingColumn);
					editingService.getEditingDomain().getCommandStack()
							.execute(rc);
				}

			}
		});
		mntmRemove_1.setText("Remove");
	}

	private void buildIntervalSection(Composite leftComposite) {
		
		Section sctnIntervalSection = toolkit.createSection(leftComposite, Section.TITLE_BAR);
		sctnIntervalSection.setLayoutData(new ColumnLayoutData());
		toolkit.paintBordersFor(sctnIntervalSection);
		sctnIntervalSection.setText("General");
		
		Composite intervalComposite = toolkit.createComposite(sctnIntervalSection, SWT.NONE);
		toolkit.paintBordersFor(intervalComposite);
		sctnIntervalSection.setClient(intervalComposite);
		intervalComposite.setLayout(new GridLayout(2, false));
		
		Label lblIntervalHint = toolkit.createLabel(intervalComposite, "Interval:", SWT.NONE);
		GridData gd_lblIntervalHint = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblIntervalHint.widthHint = 70;
		lblIntervalHint.setLayoutData(gd_lblIntervalHint);
		lblIntervalHint.setAlignment(SWT.RIGHT);
		
		txtInterval = toolkit.createText(intervalComposite, "New Text", SWT.NONE);
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text.widthHint = 20;
		txtInterval.setLayoutData(gd_text);
		txtInterval.setText("");
	}
	
	public void buildInteractiveSection(Composite parentComposite){
		
		
		Section sctnCSVInteractive = toolkit.createSection(parentComposite,
				Section.EXPANDED | Section.TITLE_BAR);

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
				loadCSVSampleFile(metricSource, f);
			}
		});

		txtSelectedCSVPath = toolkit.createText(composite_2, "New Text",
				SWT.READ_ONLY);
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

		// Delegate to a singleton holding the MappingMenuListener class.
		mmListener = ColumnMappingMenu.getINSTANCE().new MappingMenuListener(
				gridMenu, mapping, screenService, txtFirstHeaderRow,
				txtFirstDataRow);
	
		mmListener.setMetricSource(metricSource);
		gridMenu.addMenuListener(mmListener);

	}
	
	

	private void setGridSelection(MappingColumn mc, int row) {
		int column = mc.getColumn();
		if (this.gridTableViewer.getInput() != null) {
			gridTableViewer.getGrid().setCellSelection(new Point(column, row));
			// GridColumn gc = gridTableViewer.getGrid().getColumn(column);
			// GridItem gi = gridTableViewer.getGrid().getItem(row);
			// gridTableViewer.getGrid().setFocusColumn(gc);
			// gridTableViewer.getGrid().setFocusItem(gi);
		}
	}

	private void newColumnMappingScreen(boolean showDataMapping, int op,
			Object owner, Object target) {
		NewEditMappingColumn mappingColumnScreen = new NewEditMappingColumn(
				screenService.getScreenContainer(), SWT.NONE);
		mappingColumnScreen.setOperation(op);
		mappingColumnScreen.setScreenService(screenService);
		mappingColumnScreen.injectData(metricSource, showDataMapping, owner,
				target);
		screenService.setActiveScreen(mappingColumnScreen);
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

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext context = new EMFDataBindingContext();

		// TODO, Validations and strategies.
		initIntervalMappingBinding(context);
		initHeaderMappingBinding(context);
		initDataMappingBinding(context);
		initInteractiveBinding();
		return context;

	}

	private void initIntervalMappingBinding(EMFDataBindingContext context) {
		
		IObservableValue intervalObservableValue = SWTObservables
				.observeText(txtInterval, SWT.Modify);

		IEMFValueProperty intervalHintProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.MAPPING__INTERVAL_HINT);
		
		context.bindValue(intervalObservableValue,
				intervalHintProperty.observe(mapping), null, null);
		
	}

	private void initInteractiveBinding() {
		// Grid.

		gridTableViewer.setContentProvider(new CSVGridContentProvider());
		gridTableViewer.setLabelProvider(new CSVGridLabelProvider());

		// Make sure our row headers, show starting with 0.
		gridTableViewer.setRowHeaderLabelProvider(new CellLabelProvider() {
			@Override
			public void update(ViewerCell cell) {
				GridItem gi = (GridItem) cell.getItem();
				int index = gridTableViewer.getGrid().indexOf(gi);
				cell.setText(new Integer(index).toString());
			}

		});
	}

	private void initDataMappingBinding(EMFDataBindingContext context) {
		// DATA MAPPING COLUMN

		// data row mapping

		IObservableValue firstDataRowObservableValue = SWTObservables
				.observeText(txtFirstDataRow, SWT.Modify);

		IEMFValueProperty firstDataRowProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.MAPPING__FIRST_DATA_ROW);
		context.bindValue(firstDataRowObservableValue,
				firstDataRowProperty.observe(mapping), null, null);

		// data columns mapping.
		{
			ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
			this.tblViewerDataColumnMapping
					.setContentProvider(listContentProvider);

			IObservableMap[] observeMaps = EMFObservables.observeMaps(
					listContentProvider.getKnownElements(),
					new EStructuralFeature[] {
							MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE,
							MetricsPackage.Literals.MAPPING_COLUMN__COLUMN });

			this.tblViewerDataColumnMapping
					.setLabelProvider(new ColumnObservableMapLabelProvider(
							observeMaps));
			IEMFListProperty l = EMFEditProperties.list(
					editingService.getEditingDomain(),
					MetricsPackage.Literals.MAPPING__DATA_MAPPING_COLUMNS);

			IObservableList dataColumnMappingObservableList = l
					.observe(mapping);
			// obm.addObservable(dataColumnMappingObservableList);
			this.tblViewerDataColumnMapping
					.setInput(dataColumnMappingObservableList);
		}
	}

	private void initHeaderMappingBinding(EMFDataBindingContext context) {
		// HEADER MAPPING COLUMN

		// header row mapping.
		IObservableValue headerRowObservableValue = SWTObservables.observeText(
				txtFirstHeaderRow, SWT.Modify);

		IEMFValueProperty headerRowProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.MAPPING__HEADER_ROW);

		context.bindValue(headerRowObservableValue,
				headerRowProperty.observe(mapping), null, null);

		// header columns mapping.

		{
			ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
			this.tblViewerHeaderColumnMapping
					.setContentProvider(listContentProvider);

			IObservableMap[] observeMaps = EMFObservables.observeMaps(
					listContentProvider.getKnownElements(),
					new EStructuralFeature[] {
							MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE,
							MetricsPackage.Literals.MAPPING_COLUMN__COLUMN });

			tblViewerHeaderColumnMapping
					.setLabelProvider(new ColumnObservableMapLabelProvider(
							observeMaps));
			IEMFListProperty l = EMFEditProperties.list(
					editingService.getEditingDomain(),
					MetricsPackage.Literals.MAPPING__HEADER_MAPPING_COLUMNS);

			IObservableList dataColumnMappingObservableList = l
					.observe(mapping);
			// obm.addObservable(dataColumnMappingObservableList);
			tblViewerHeaderColumnMapping
					.setInput(dataColumnMappingObservableList);
		}
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
	private Table tblHeaderColumnMapping;
	private Text txtInterval;

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
			DataKind k = c.getDataType();

			if (columnIndex == 0) {
				// This is the type Column.

				if (k != null) {
					return dataKindMap.get(k.getClass());
				}
			}
			if (columnIndex == 2) {
				if (k instanceof ValueDataKind) {
					ValueKindType vkt = ((ValueDataKind) k).getValueKind();
					return vkt.getName();
				}
				if (k instanceof IdentifierDataKind) {
					IdentifierDataKind idk = (IdentifierDataKind) k;
					ObjectKindType okt = idk.getObjectKind();
					return okt.getName();
				}
			}
			if (columnIndex == 3) {
				if (k instanceof ValueDataKind) {
					ValueKindType vkt = ((ValueDataKind) k).getValueKind();
					switch (vkt.getValue()) {
					case ValueKindType.METRIC_VALUE: {
						if (k.eIsSet(MetricsPackage.Literals.VALUE_DATA_KIND__METRIC_REF)) {
							return ((ValueDataKind) k).getMetricRef().getName();
						} else {
							return "<not set>!!";
						}

					}
					// TODO, OTHER KINDS.....
					}
					return vkt.getName();
				}
				if (k instanceof IdentifierDataKind) {
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
		if (object != null && object instanceof MappingCSV) {
			mapping = (MappingCSV) object;
		}

		buildUI();
		this.initDataBindings_();

		IFile file = this.getMetricSourceSampleFile(metricSource);
		if (file != null) {
			this.txtSelectedCSVPath.setText(file.getName());
			this.loadCSVSampleFile(metricSource, file);
		}

	}

	public void addData() {
		if (Screens.isNewOperation(getOperation()) && metricSource != null) {
			// If new, we have been operating on an object not added yet.
			Command c = new SetCommand(editingService.getEditingDomain(),
					metricSource,
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

	@Override
	public void fillGrid(List<Map<Integer, Tuple>> records) {
		// this.gridTableViewer.setInput(records);
		// N/A
	}

	public void fillCSVGrid(String[][] records) {
		this.gridTableViewer.setInput(records);
	}

	public String getScreenName() {
		return "Mapping CSV";
	}
}
