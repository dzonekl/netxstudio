package com.netxforge.netxstudio.screens.f4;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
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
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.SWTResourceManager;

import com.netxforge.netxstudio.common.Tuple;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.f4.support.ColumnMappingMenu;
import com.netxforge.netxstudio.screens.f4.support.ColumnMappingMenu.MappingMenuListener;
import com.netxforge.netxstudio.workspace.WorkspaceUtil;

public class NewEditMappingCSV extends AbstractFileBasedMapping implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	
	private Text txtSelectedCSVPath;
	
	private GridTableViewer gridTableViewer;
	private Menu gridMenu;
	
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

	protected void buildUI() {
		
		buildSashComposites();
		buildGeneralSection(leftComposite);
		buildHeaderMappingSection(leftComposite);
		buildDataMappingSection(leftComposite);
		buildInteractiveSection(rightComposite);
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
		createGridMenu(grid);
	}

	private void createGridMenu(Grid grid) {
		gridMenu = new Menu(grid);
		grid.setMenu(gridMenu);

		// Delegate to a singleton holding the MappingMenuListener class.
		mmListener = ColumnMappingMenu.getINSTANCE().new MappingMenuListener(
				gridMenu, mapping, screenService, txtFirstHeaderRow,
				txtFirstDataRow);
	
		mmListener.setMetricSource(metricSource);
		gridMenu.addMenuListener(mmListener);
	}
	
	protected void setGridSelection(MappingColumn mc, int row) {
		int column = mc.getColumn();
		if (this.gridTableViewer.getInput() != null) {
			gridTableViewer.getGrid().setCellSelection(new Point(column, row));
		}
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
		initGeneralBinding(context);
		initHeaderMappingBinding(context);
		initDataMappingBinding(context);
		initInteractiveBinding();
		return context;

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
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof String[][]) {
				String[][] input = (String[][]) inputElement;
				return input;
			}
			return null;
		}
	}

	public void injectData(Object owner, Object object) {
		super.injectData(owner, object);

		boolean edit = ScreenUtil.isEditOperation(getOperation());
		String actionText = edit ? "Edit: " : "New: ";
		frmMappings.setText(actionText + " CSV Mapping: "
				+ metricSource.getName());

		
		IFile file = this.getMetricSourceSampleFile(metricSource);
		if (file != null) {
			this.txtSelectedCSVPath.setText(file.getName());
			this.loadCSVSampleFile(metricSource, file);
		}

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

	public Viewer getViewer() {
		return null; // N/A
	}

	@Override
	public boolean isValid() {
		return true;
	}


	public void disposeData() {
		// N/A

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
