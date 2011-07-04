/*******************************************************************************
 * Copyright (c) May 9, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.f2;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
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

import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.SearchFilter;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class Tolerances extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;
	private Table table;

	private TableViewer tableViewer;
	@SuppressWarnings("unused")
	private DataBindingContext bindingContext;
	private Form frmTolerances;
	// private ObservablesManager mgr;
	private ObservableListContentProvider listContentProvider;
	private Resource toleranceResource;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public Tolerances(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
				disposeData();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmTolerances = toolkit.createForm(this);
		frmTolerances.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmTolerances);
		frmTolerances.setText("Tolerances");
		frmTolerances.getBody().setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(frmTolerances.getBody(),
				"Filter:", SWT.NONE);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 36;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmTolerances.getBody(), "New Text",
				SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.setText("");
		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);

		txtFilterText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				tableViewer.refresh();
				ViewerFilter[] filters = tableViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof SearchFilter) {
						((SearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
			}
		});

		// Conditional widget.
		if (!Screens.isReadOnlyOperation(this.getOperation())) {
			ImageHyperlink mghprlnkNew = toolkit.createImageHyperlink(
					frmTolerances.getBody(), SWT.NONE);
			mghprlnkNew.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					NewEditTolerance toleranceScreen = new NewEditTolerance(
							screenService.getScreenContainer(), SWT.NONE);
					toleranceScreen.setOperation(Screens.OPERATION_NEW);
					Tolerance tolerance = LibraryFactory.eINSTANCE
							.createTolerance();
					toleranceScreen.injectData(toleranceResource, tolerance);
					screenService.setActiveScreen(toleranceScreen);
				}

				public void linkEntered(HyperlinkEvent e) {
				}

				public void linkExited(HyperlinkEvent e) {
				}
			});
			mghprlnkNew.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
					false, false, 1, 1));
			mghprlnkNew.setImage(ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/ctool16/Threshold_E.png"));
			mghprlnkNew.setBounds(0, 0, 114, 17);
			toolkit.paintBordersFor(mghprlnkNew);
			mghprlnkNew.setText("New");

		}
		new Label(frmTolerances.getBody(), SWT.NONE);

		tableViewer = new TableViewer(frmTolerances.getBody(), SWT.BORDER
				| SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 5));
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(143);
		tblclmnName.setText("Name");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnOwnedBy = tableViewerColumn_1.getColumn();
		tblclmnOwnedBy.setWidth(100);
		tblclmnOwnedBy.setText("Level");

		Menu menu = new Menu(table);
		table.setMenu(menu);

		MenuItem mntmEdit = new MenuItem(menu, SWT.NONE);
		mntmEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (screenService != null) {
					ISelection selection = getTableViewerWidget()
							.getSelection();
					if (selection instanceof IStructuredSelection) {
						Object o = ((IStructuredSelection) selection)
								.getFirstElement();
						if (o != null) {
							int operation = -1;
							if (Screens.isReadOnlyOperation(getOperation())) {
								operation = Screens.OPERATION_READ_ONLY;
							} else {
								operation = Screens.OPERATION_EDIT;
							}
							NewEditTolerance toleranceScreen = new NewEditTolerance(
									screenService.getScreenContainer(), SWT.NONE);
							toleranceScreen.setOperation(operation);
							toleranceScreen.injectData(toleranceResource, o);
							screenService.setActiveScreen(toleranceScreen);
						}
					}
				}
			}
		});

		String detailedAction;
		if (Screens.isReadOnlyOperation(getOperation())) {
			detailedAction = "View";
		} else {
			detailedAction = "Edit";
		}
		mntmEdit.setText(detailedAction + "...");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnExpression = tableViewerColumn_2.getColumn();
		tblclmnExpression.setWidth(100);
		tblclmnExpression.setText("Expression");
		tableViewer.addFilter(new SearchFilter(editingService));

		if (editingService != null) {
			injectData();
		}
	}

	public TableViewer getTableViewerWidget() {
		return tableViewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataServiceInjection#injectData()
	 */
	public void injectData() {
		toleranceResource = editingService
				.getData(LibraryPackage.Literals.TOLERANCE);
		bindingContext = initDataBindings_();
	}

	public void disposeData() {
		if (editingService != null) {
			editingService.disposeData();
		}
	}

	public EMFDataBindingContext initDataBindings_() {

		// mgr = new ObservablesManager();
		// mgr.runAndCollect(new Runnable() {
		// public void run() {

		listContentProvider = new ObservableListContentProvider();
		tableViewer.setContentProvider(listContentProvider);
		//
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] {
						LibraryPackage.Literals.TOLERANCE__NAME,
						LibraryPackage.Literals.TOLERANCE__LEVEL,
						LibraryPackage.Literals.TOLERANCE__EXPRESSION_REF });
		tableViewer
				.setLabelProvider(new ObservableMapLabelProvider(observeMaps));

		IEMFListProperty l = EMFEditProperties.resource(editingService
				.getEditingDomain());

		tableViewer.setInput(l.observe(toleranceResource));

		// }
		// });
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		return bindingContext;
	}

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

	@Override
	public Form getScreenForm() {
		return this.frmTolerances;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}

}
