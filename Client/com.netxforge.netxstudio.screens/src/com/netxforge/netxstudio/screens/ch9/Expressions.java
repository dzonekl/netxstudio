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
package com.netxforge.netxstudio.screens.ch9;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
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

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.LibraryPackage.Literals;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.IScreenFormService;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class Expressions extends AbstractScreen implements
		IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;
	private Table table;

	private Library library;

	private TableViewer tableViewer;
	@SuppressWarnings("unused")
	private DataBindingContext bindingContext;
	private Form frmExpressions;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public Expressions(Composite parent, int style) {
		this(parent, style, null, null);
	}

	public Expressions(Composite parent, int style,
			IScreenFormService sService, IEditingService eService) {
		super(parent, SWT.BORDER, sService, eService);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
				disposeData();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmExpressions = toolkit.createForm(this);
		frmExpressions.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmExpressions);
		frmExpressions.setText("Expression");
		frmExpressions.getBody().setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(frmExpressions.getBody(),
				"Filter:", SWT.NONE);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 36;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmExpressions.getBody(),
				"New Text", SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
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
					frmExpressions.getBody(), SWT.NONE);
			mghprlnkNew.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					if (screenService != null) {
						NewEditExpression user = new NewEditExpression(
								screenService.getScreenContainer(), SWT.NONE
										| Screens.OPERATION_NEW, editingService);
						screenService.setActiveScreen(user);
						Expression exp = LibraryFactory.eINSTANCE
								.createExpression();

						// New Expressions always need an evaluation object.
						// What ever object is set as evaluation object, should
						// be
						// the root object
						// of our expression language.
						// Model m = NetxscriptFactory.eINSTANCE.createModel();
						// exp.setEvaluationObject(m);
						user.injectData(library.getExpressions(), exp);
					}
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
					"icons/full/obj16/Expression_H.png"));
			mghprlnkNew.setBounds(0, 0, 114, 17);
			toolkit.paintBordersFor(mghprlnkNew);
			mghprlnkNew.setText("New");

		}

		tableViewer = new TableViewer(frmExpressions.getBody(), SWT.BORDER
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
		tblclmnOwnedBy.setText("Owned by");

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
							int widgetStyle = SWT.None;
							// Conditional widget.
							if (Screens.isReadOnlyOperation(getOperation())) {
								widgetStyle |= Screens.OPERATION_READ_ONLY;
							} else {
								widgetStyle |= Screens.OPERATION_EDIT;
							}
							NewEditExpression editExpression = new NewEditExpression(
									screenService.getScreenContainer(),
									widgetStyle, editingService);
							editExpression.injectData(library.getExpressions(),
									o);
							screenService.setActiveScreen(editExpression);
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
		tableViewer.addFilter(new SearchFilter());

		if (editingService != null) {
			injectData();
		}
	}

	public TableViewer getTableViewerWidget() {
		return tableViewer;
	}

	public class SearchFilter extends ViewerFilter {

		private String searchString;

		public void setSearchText(String s) {
			// Search must be a substring of the existing value
			this.searchString = ".*" + s + ".*"; //$NON-NLS-1$ //$NON-NLS-2$
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement,
				Object element) {
			if (searchString == null || searchString.length() == 0) {
				return true;
			}

			if (element instanceof EObject) {

				String match = new AdapterFactoryItemDelegator(
						editingService.getAdapterFactory()).getText(element);
				return match.matches(searchString);
			}
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataServiceInjection#injectData()
	 */
	public void injectData() {
		Resource res = editingService.getData(LibraryPackage.LIBRARY);
		if (res.getContents().size() == 0) {
			Library lib = LibraryFactory.eINSTANCE.createLibrary();
			res.getContents().add(lib);
			this.library = lib;
		} else {
			this.library = (Library) res.getContents().get(0);
		}
		bindingContext = initDataBindings_();
	}

	public void disposeData() {
		if (editingService != null) {
			editingService.disposeData();
		}
	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		tableViewer.setContentProvider(listContentProvider);
		//
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] { Literals.EXPRESSION__NAME });
		tableViewer
				.setLabelProvider(new ObservableMapLabelProvider(observeMaps));

		IEMFListProperty l = EMFEditProperties.list(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.LIBRARY__EXPRESSIONS);

		tableViewer.setInput(l.observe(library));
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
		return this.frmExpressions;
	}

}
