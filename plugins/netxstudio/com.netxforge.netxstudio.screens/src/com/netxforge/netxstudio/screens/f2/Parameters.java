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

import java.text.DecimalFormat;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.Lists;
import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.Parameter;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.filter.CDOSearchFilter;
import com.netxforge.netxstudio.screens.editing.tables.CDOElementComparer;
import com.netxforge.netxstudio.screens.editing.util.CDOMementoUtil;
import com.netxforge.screens.editing.base.IDataServiceInjection;
import com.netxforge.screens.editing.base.ScreenUtil;
import com.netxforge.screens.editing.base.filter.ISearchFilter;
import com.netxforge.screens.editing.base.util.MementoUtil;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class Parameters extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;
	private Table table;

	private TableViewer tableViewer;
	@SuppressWarnings("unused")
	private DataBindingContext bindingContext;
	private Form frmParameters;
	private ObservableListContentProvider listContentProvider;
	private Resource parametersResource;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public Parameters(Composite parent, int style) {
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
		String actionText = readonly ? "View: " : "Edit: ";
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmParameters = toolkit.createForm(this);
		frmParameters.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmParameters);
		frmParameters.setText(actionText + "Parameters");
		frmParameters.getBody().setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(frmParameters.getBody(),
				"Filter:", SWT.NONE);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 36;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmParameters.getBody(), "New Text",
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
					if (viewerFilter instanceof ISearchFilter) {
						((ISearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
			}
		});

		// Conditional widget.
		if (!readonly) {
			ImageHyperlink mghprlnkNew = toolkit.createImageHyperlink(
					frmParameters.getBody(), SWT.NONE);
			mghprlnkNew.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					NewEditParameter parameterScreen = new NewEditParameter(
							screenService.getScreenContainer(), SWT.NONE);
					parameterScreen.setOperation(ScreenUtil.OPERATION_NEW);
					parameterScreen.setScreenService(screenService);
					Parameter parameter = LibraryFactory.eINSTANCE
							.createParameter();
					parameterScreen.injectData(parametersResource, parameter);
					screenService.setActiveScreen(parameterScreen);
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
					"icons/full/ctool16/Parameter_E.png"));
			mghprlnkNew.setBounds(0, 0, 114, 17);
			toolkit.paintBordersFor(mghprlnkNew);
			mghprlnkNew.setText("New");

		}

		tableViewer = new TableViewer(frmParameters.getBody(), SWT.BORDER
				| SWT.FULL_SELECTION | SWT.MULTI | widgetStyle);
		tableViewer.setComparer(new CDOElementComparer());
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
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
		tblclmnOwnedBy.setText("Expression Name");

		TableViewerColumn tableViewerColumnDescription = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnDescription = tableViewerColumnDescription
				.getColumn();
		tblclmnDescription.setWidth(200);
		tblclmnDescription.setText("Description");

		TableViewerColumn tableViewerColumnValue = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnValue = tableViewerColumnValue.getColumn();
		tblclmnValue.setWidth(100);
		tblclmnValue.setText("Value");
		tblclmnValue.setAlignment(SWT.RIGHT);
		tableViewer.addFilter(new CDOSearchFilter());
	}

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class EditParameterAction extends Action {

		public EditParameterAction(String text) {
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
						NewEditParameter parameterScreen = new NewEditParameter(
								screenService.getScreenContainer(), SWT.NONE);
						parameterScreen.setOperation(getOperation());
						parameterScreen.setScreenService(screenService);
						parameterScreen.injectData(parametersResource, o);
						screenService.setActiveScreen(parameterScreen);
					}
				}
			}
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
		parametersResource = editingService
				.getData(LibraryPackage.Literals.PARAMETER);
		buildUI();
		bindingContext = initDataBindings_();
	}

	public void disposeData() {
	}

	public EMFDataBindingContext initDataBindings_() {

		listContentProvider = new ObservableListContentProvider();
		tableViewer.setContentProvider(listContentProvider);
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] {
						LibraryPackage.Literals.PARAMETER__NAME,
						LibraryPackage.Literals.PARAMETER__EXPRESSION_NAME,
						LibraryPackage.Literals.PARAMETER__DESCRIPTION,
						LibraryPackage.Literals.PARAMETER__VALUE, });
		tableViewer
				.setLabelProvider(new ValueLabelProvider(observeMaps));
		IEMFListProperty l = EMFEditProperties.resource(editingService
				.getEditingDomain());
		IObservableList parametersObservableList = l
				.observe(parametersResource);

		tableViewer.setInput(parametersObservableList);

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

	public Form getScreenForm() {
		return this.frmParameters;
	}

	private final List<IAction> actions = Lists.newArrayList();
	private static final String MEM_KEY_PARAMETERS_SELECTION_TABLE = "MEM_KEY_PARAMETERS_SELECTION_TABLE";
	private static final String MEM_KEY_PARAMETERS_COLUMNS_TABLE = "MEM_KEY_PARAMETERS_COLUMNS_TABLE";

	@Override
	public IAction[] getActions() {
		// Lazy init actions.
		if (actions.isEmpty()) {
			String actionText = ScreenUtil.isReadOnlyOperation(getOperation()) ? "View"
					: "Edit";
			actions.add(new EditParameterAction(actionText + "..."));
		}
		return actions.toArray(new IAction[actions.size()]);
	}

	@Override
	public String getScreenName() {
		return "Parameters";
	}

	@Override
	public void saveState(IMemento memento) {
		CDOMementoUtil.rememberStructuredViewerSelection(memento, tableViewer,
				MEM_KEY_PARAMETERS_SELECTION_TABLE);
		MementoUtil.rememberStructuredViewerColumns(memento, tableViewer,
				MEM_KEY_PARAMETERS_COLUMNS_TABLE);

	}

	@Override
	public void restoreState(IMemento memento) {
		if (memento != null && parametersResource != null) {
			MementoUtil.retrieveStructuredViewerColumns(memento, tableViewer,
					MEM_KEY_PARAMETERS_COLUMNS_TABLE);
			CDOMementoUtil.retrieveStructuredViewerSelection(memento,
					tableViewer, MEM_KEY_PARAMETERS_SELECTION_TABLE,
					((CDOResource) parametersResource).cdoView());

		}
	}

	/**
	 * Override the presentation of some features/Columns.
	 * 
	 * @author Christophe Bouhier
	 */
	class ValueLabelProvider extends ObservableMapLabelProvider {

		public ValueLabelProvider(IObservableMap attributeMap) {
			super(attributeMap);
		}

		public ValueLabelProvider(IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof Parameter && columnIndex == 3) {
				return new DecimalFormat(
						NonModelUtils.DEFAULT_VALUE_FORMAT_PATTERN)
						.format(((Parameter) element).getValue());
			}

			return super.getColumnText(element, columnIndex);
		}

	}

}
