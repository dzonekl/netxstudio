/*******************************************************************************
 * Copyright (c) Jun 25, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.f3;

import java.util.List;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.Warehouse;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.SearchFilter;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.f3.support.WarehouseTreeFactory;
import com.netxforge.netxstudio.screens.f3.support.WarehouseTreeStructureAdvisor;

public class WarehouseTree extends AbstractScreen implements
		IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;
	private Resource warehouseResource;
	@SuppressWarnings("unused")
	private EMFDataBindingContext bindingContext;
	private Form frmWarehouseTree;
	private TreeViewer warehouseTreeViewer;
	private ObservableListTreeContentProvider listTreeContentProvider;

	@Inject
	private SearchFilter searchFilter;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public WarehouseTree(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		// buildUI();
	}

	public EMFDataBindingContext initDataBindings_() {

		listTreeContentProvider = new ObservableListTreeContentProvider(
				new WarehouseTreeFactory(editingService.getEditingDomain()),
				new WarehouseTreeStructureAdvisor());
		warehouseTreeViewer.setContentProvider(listTreeContentProvider);
		IObservableSet set = listTreeContentProvider.getKnownElements();

		List<IObservableMap> mapList = Lists.newArrayList();

		mapList.add(EMFProperties.value(
				OperatorsPackage.Literals.WAREHOUSE__NAME).observeDetail(set));

		mapList.add(EMFProperties
				.value(OperatorsPackage.Literals.NODE__NODE_ID).observeDetail(
						set));

		mapList.add(EMFProperties.value(
				LibraryPackage.Literals.EQUIPMENT__EQUIPMENT_CODE)
				.observeDetail(set));

		IObservableMap[] observeMaps = new IObservableMap[mapList.size()];
		mapList.toArray(observeMaps);

		warehouseTreeViewer.setLabelProvider(new ObservableMapLabelProvider(
				observeMaps));

		IEMFListProperty warehouseResourceProperty = EMFEditProperties
				.resource(editingService.getEditingDomain());
		warehouseTreeViewer.setInput(warehouseResourceProperty
				.observe(warehouseResource));
		EMFDataBindingContext context = new EMFDataBindingContext();
		return context;
	}

	public void injectData() {
		warehouseResource = editingService
				.getData(OperatorsPackage.Literals.WAREHOUSE);
		buildUI();
		bindingContext = initDataBindings_();
	}

	private void buildUI() {

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());

		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmWarehouseTree = toolkit.createForm(this);
		frmWarehouseTree.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmWarehouseTree);
		frmWarehouseTree.setText(getOperationText() + "Warehouses");
		frmWarehouseTree.getBody().setLayout(new GridLayout(4, false));

		Label lblFilterLabel = toolkit.createLabel(frmWarehouseTree.getBody(),
				"Filter:", SWT.NONE);
		lblFilterLabel.setAlignment(SWT.RIGHT);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 36;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmWarehouseTree.getBody(),
				"New Text", SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				ViewerFilter[] filters = warehouseTreeViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof SearchFilter) {
						((SearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
				warehouseTreeViewer.refresh();
			}
		});
		txtFilterText.setText("");

		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);

		if (!readonly) {
			ImageHyperlink hypLnkNewWarehouse = toolkit.createImageHyperlink(
					frmWarehouseTree.getBody(), SWT.NONE);
			hypLnkNewWarehouse.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					NewEditWarehouse warehouseScreen = new NewEditWarehouse(
							screenService.getScreenContainer(), SWT.NONE);
					warehouseScreen.setOperation(ScreenUtil.OPERATION_NEW);
					warehouseScreen.setScreenService(screenService);
					Warehouse newWarehouse = OperatorsFactory.eINSTANCE
							.createWarehouse();
					warehouseScreen.injectData(warehouseResource, newWarehouse);
					screenService.setActiveScreen(warehouseScreen);
				}

				public void linkEntered(HyperlinkEvent e) {
				}

				public void linkExited(HyperlinkEvent e) {
				}
			});
			hypLnkNewWarehouse.setImage(ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/ctool16/Warehouse_E.png"));
			toolkit.paintBordersFor(hypLnkNewWarehouse);
			hypLnkNewWarehouse.setText("New");
			new Label(frmWarehouseTree.getBody(), SWT.NONE);

		}

		warehouseTreeViewer = new TreeViewer(frmWarehouseTree.getBody(),
				SWT.BORDER | SWT.VIRTUAL);
		warehouseTreeViewer.setUseHashlookup(true);
		warehouseTreeViewer.setComparer(new CDOElementComparer());

		Tree tree = warehouseTreeViewer.getTree();
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));
		toolkit.paintBordersFor(tree);

		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(
				warehouseTreeViewer, SWT.NONE);
		TreeColumn trclmnCountry = treeViewerColumn.getColumn();
		trclmnCountry.setWidth(100);
		trclmnCountry.setText("Warehouse");

		TreeViewerColumn treeViewerColumn_1 = new TreeViewerColumn(
				warehouseTreeViewer, SWT.NONE);
		TreeColumn trclmnName = treeViewerColumn_1.getColumn();
		trclmnName.setWidth(129);
		trclmnName.setText("Item name");

		warehouseTreeViewer.addFilter(searchFilter);
	}

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class EditWarehouseItemAction extends Action {

		public EditWarehouseItemAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			super.run();
			if (screenService != null) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					if (o instanceof Warehouse) {
						NewEditWarehouse warehouseScreen = new NewEditWarehouse(
								screenService.getScreenContainer(), SWT.NONE);
						warehouseScreen.setOperation(getOperation());
						warehouseScreen.setScreenService(screenService);
						warehouseScreen.injectData(warehouseResource, o);
						screenService.setActiveScreen(warehouseScreen);
					}
				}
			}
		}
	}

	public Viewer getViewer() {
		return warehouseTreeViewer;
	}

	@Override
	public boolean isValid() {
		return false;
	}

	public Form getScreenForm() {
		return this.frmWarehouseTree;
	}

	private final List<IAction> actions = Lists.newArrayList();

	@Override
	public IAction[] getActions() {
		if (actions.isEmpty()) {
			boolean readonly = ScreenUtil.isReadOnlyOperation(getOperation());
			String actionText = readonly ? "View" : "Edit";
			actions.add(new EditWarehouseItemAction(actionText + "..."));
		}
		return actions.toArray(new IAction[actions.size()]);
	}

	@Override
	public String getScreenName() {
		return "Warehouses";
	}

}
