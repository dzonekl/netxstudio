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

import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.LoadingFactory;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class LazyTolerances extends AbstractScreen implements
		IDataServiceInjection {

	private static final String MEM_KEY_TOLERANCE_SELECTION_TABLE = "MEM_KEY_TOLERANCE_SELECTION_TABLE";
	private static final String MEM_KEY_TOLERANCE_COLUMNS_TABLE = "MEM_KEY_TOLERANCE_COLUMNS_TABLE";
	protected static final int PAGE_SIZE = 64;
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	// private Text txtFilterText;
	private Table table;

	private TableViewer toleranceTblViewer;
	@SuppressWarnings("unused")
	private DataBindingContext bindingContext;
	private Form frmTolerances;
	private Resource toleranceResource;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public LazyTolerances(Composite parent, int style) {
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

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmTolerances = toolkit.createForm(this);
		frmTolerances.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmTolerances);
		frmTolerances.setText(getOperationText() + "Tolerances");
		frmTolerances.getBody().setLayout(new GridLayout(3, false));

		// Label lblFilterLabel = toolkit.createLabel(frmTolerances.getBody(),
		// "Filter:", SWT.NONE);
		// GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER,
		// false,
		// false, 1, 1);
		// gd_lblFilterLabel.widthHint = 36;
		// lblFilterLabel.setLayoutData(gd_lblFilterLabel);
		//
		// txtFilterText = toolkit.createText(frmTolerances.getBody(),
		// "New Text",
		// SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		// txtFilterText.setText("");
		// GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, true,
		// false, 1, 1);
		// gd_txtFilterText.widthHint = 200;
		// txtFilterText.setLayoutData(gd_txtFilterText);
		//
		// txtFilterText.addKeyListener(new KeyAdapter() {
		// public void keyReleased(KeyEvent ke) {
		// toleranceTblViewer.refresh();
		// ViewerFilter[] filters = toleranceTblViewer.getFilters();
		// for (ViewerFilter viewerFilter : filters) {
		// if (viewerFilter instanceof SearchFilter) {
		// ((SearchFilter) viewerFilter)
		// .setSearchText(txtFilterText.getText());
		// }
		// }
		// }
		// });

		// Conditional widget.
		if (!readonly) {
			ImageHyperlink mghprlnkNew = toolkit.createImageHyperlink(
					frmTolerances.getBody(), SWT.NONE);
			mghprlnkNew.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					NewEditTolerance toleranceScreen = new NewEditTolerance(
							screenService.getScreenContainer(), SWT.NONE);
					toleranceScreen.setOperation(ScreenUtil.OPERATION_NEW);
					toleranceScreen.setScreenService(screenService);
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

		toleranceTblViewer = new TableViewer(frmTolerances.getBody(),
				SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION | SWT.VIRTUAL
						| widgetStyle);
		toleranceTblViewer.setComparer(new CDOElementComparer());
		toleranceTblViewer.setUseHashlookup(true);
		table = toleranceTblViewer.getTable();
		table.addListener(SWT.SetData, new Listener() {
			public void handleEvent(Event event) {
				TableItem item = (TableItem) event.item;
				int index = table.indexOf(item);
				int start = index / PAGE_SIZE * PAGE_SIZE;
				int end = Math.min(start + PAGE_SIZE, table.getItemCount());
				System.out.println("SWT.SetData i=" + index + ", s=" + start
						+ ", e=" + end);
			}
		});

		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		toolkit.paintBordersFor(table);

//		toleranceTblViewer.addFilter(new SearchFilter(editingService));
	}

	/**
	 * 
	 */
	public void buildColumns() {
		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				toleranceTblViewer, SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(143);
		tblclmnName.setText("Name");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				toleranceTblViewer, SWT.NONE);
		TableColumn tblclmnOwnedBy = tableViewerColumn_1.getColumn();
		tblclmnOwnedBy.setWidth(100);
		tblclmnOwnedBy.setText("Level");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				toleranceTblViewer, SWT.NONE);
		TableColumn tblclmnExpression = tableViewerColumn_2.getColumn();
		tblclmnExpression.setWidth(250);
		tblclmnExpression.setText("Expression");
	}

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class EditToleranceAction extends Action {

		public EditToleranceAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			super.run();
			if (screenService != null) {
				ISelection selection = getTableViewerWidget().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					if (o != null) {
						NewEditTolerance toleranceScreen = new NewEditTolerance(
								screenService.getScreenContainer(), SWT.NONE);
						toleranceScreen.setOperation(getOperation());
						toleranceScreen.setScreenService(screenService);
						toleranceScreen.injectData(toleranceResource, o);
						screenService.setActiveScreen(toleranceScreen);
					}
				}
			}
		}
	}

	public TableViewer getTableViewerWidget() {
		return toleranceTblViewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataServiceInjection#injectData()
	 */
	public void injectData() {
		toleranceResource = editingService
				.getData(LibraryPackage.Literals.TOLERANCE);

		if (toleranceResource instanceof CDOResource) {
			CDOResource tolResource = (CDOResource) toleranceResource;
			tolResource.cdoPrefetch(CDORevision.DEPTH_INFINITE);
		}
		buildUI();
		buildColumns();
		toleranceTblViewer.setItemCount(((CDOResource) toleranceResource)
				.eContents().size());
		bindingContext = initDataBindings_();

	}

	public boolean initUI() {
		buildUI();
		return Boolean.TRUE;
	}

	public void showPreLoadedUI() {
		// 1. The Screenform service deals with UI initialization.

		this.toleranceTblViewer.setContentProvider(LoadingFactory
				.createLoadingContentProvider());
		this.toleranceTblViewer.setLabelProvider(LoadingFactory
				.createLoadingLabelProvider());

		// 2. Get the root object, and prefetch infinit.
		toleranceResource = editingService
				.getData(LibraryPackage.Literals.TOLERANCE);

		// prefetch this EList with infinite depth.
		if (toleranceResource instanceof CDOResource) {
			CDOResource tolResource = (CDOResource) toleranceResource;
			this.toleranceTblViewer.setInput(tolResource.cdoID().toString());
		}
	}

	public EMFDataBindingContext initDataBindings_() {

		// listContentProvider = new ObservableListContentProvider();
		toleranceTblViewer.setContentProvider(new LazyListContentProvider());
		//
		toleranceTblViewer.setLabelProvider(new TolerancesLabelProvider());
		toleranceTblViewer.setInput(toleranceResource.getContents());

		return null;
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

	public Form getScreenForm() {
		return this.frmTolerances;
	}

	private final List<IAction> actions = Lists.newArrayList();
	private boolean fCancelLoading;

	@Override
	public IAction[] getActions() {
		if (actions.isEmpty()) {
			String actionText = ScreenUtil.isReadOnlyOperation(getOperation()) ? "View"
					: "Edit";
			actions.add(new EditToleranceAction(actionText + "..."));
		}

		return actions.toArray(new IAction[actions.size()]);
	}

	@Override
	public String getScreenName() {
		return "Tolerances";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.AbstractScreenImpl#saveState(org.eclipse
	 * .ui.IMemento)
	 */
	@Override
	public void saveState(IMemento memento) {

		// sash state vertical.
		mementoUtils.rememberStructuredViewerSelection(memento,
				toleranceTblViewer, MEM_KEY_TOLERANCE_SELECTION_TABLE);
		mementoUtils.rememberStructuredViewerColumns(memento,
				toleranceTblViewer, MEM_KEY_TOLERANCE_COLUMNS_TABLE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.AbstractScreenImpl#init(org.eclipse.
	 * ui.IMemento)
	 */
	@Override
	public void restoreState(IMemento memento) {

		if (toleranceResource != null) {
			mementoUtils.retrieveStructuredViewerSelection(memento,
					toleranceTblViewer, MEM_KEY_TOLERANCE_SELECTION_TABLE,
					((CDOResource) toleranceResource).cdoView());
			mementoUtils.retrieveStructuredViewerColumns(memento,
					toleranceTblViewer, MEM_KEY_TOLERANCE_COLUMNS_TABLE);
		}
	}

	public void cancelLoading() {
		fCancelLoading = true;

	}

	public void showPostLoadedUI() {
		if (!fCancelLoading) {
			toleranceTblViewer.setInput(null);

			// Now build the columns, after cleaning the input.
			buildColumns();
			toleranceTblViewer.setItemCount(((CDOResource) toleranceResource)
					.eContents().size());
			bindingContext = initDataBindings_();
		} else {
			fCancelLoading = false;
		}
	}
}
