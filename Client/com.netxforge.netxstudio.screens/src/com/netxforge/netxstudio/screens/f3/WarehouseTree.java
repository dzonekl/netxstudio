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

import org.eclipse.core.databinding.observable.list.IObservableList;
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
import org.eclipse.jface.resource.ImageDescriptor;
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
import com.netxforge.netxstudio.geo.Country;
import com.netxforge.netxstudio.geo.GeoFactory;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.geo.Site;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.SearchFilter;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f3.support.SiteTreeFactory;
import com.netxforge.netxstudio.screens.f3.support.SiteTreeStructureAdvisor;

public class WarehouseTree extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;
	private Resource countryResource;
	@SuppressWarnings("unused")
	private EMFDataBindingContext bindingContext;
	private Form frmWarehouseTree;
	private TreeViewer sitesTreeViewer;
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
		buildUI();
	}

	public EMFDataBindingContext initDataBindings_() {

		listTreeContentProvider = new ObservableListTreeContentProvider(
				new SiteTreeFactory(editingService.getEditingDomain()), new SiteTreeStructureAdvisor());
		sitesTreeViewer.setContentProvider(listTreeContentProvider);
		IObservableSet set = listTreeContentProvider.getKnownElements();
		
		List<IObservableMap> mapList = Lists.newArrayList();

		mapList.add(EMFProperties.value(GeoPackage.Literals.COUNTRY__NAME)
				.observeDetail(set));

		mapList.add(EMFProperties.value(GeoPackage.Literals.SITE__NAME)
				.observeDetail(set));

		mapList.add(EMFProperties.value(GeoPackage.Literals.SITE__CITY)
				.observeDetail(set));

		mapList.add(EMFProperties.value(GeoPackage.Literals.SITE__SREET)
				.observeDetail(set));

		mapList.add(EMFProperties.value(GeoPackage.Literals.SITE__HOUSENUMBER)
				.observeDetail(set));

		IObservableMap[] observeMaps = new IObservableMap[mapList.size()];
		mapList.toArray(observeMaps);

		sitesTreeViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));

		IEMFListProperty countryResourceProperty = EMFEditProperties.resource(editingService.getEditingDomain());
		IObservableList countryObservableList = countryResourceProperty.observe(countryResource);
		sitesTreeViewer.setInput(countryObservableList);
		EMFDataBindingContext context = new EMFDataBindingContext();
		return context;
	}

	public void injectData() {
		countryResource = editingService.getData(GeoPackage.Literals.COUNTRY);
		buildUI();
		bindingContext = initDataBindings_();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmWarehouseTree = toolkit.createForm(this);
		frmWarehouseTree.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmWarehouseTree);
		frmWarehouseTree.setText("Warehouses");
		frmWarehouseTree.getBody().setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(frmWarehouseTree.getBody(),
				"Filter:", SWT.NONE);
		lblFilterLabel.setAlignment(SWT.RIGHT);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 36;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmWarehouseTree.getBody(), "New Text",
				SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				sitesTreeViewer.refresh();
				ViewerFilter[] filters = sitesTreeViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof SearchFilter) {
						((SearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
			}
		});
		txtFilterText.setText("");

		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);
		new Label(frmWarehouseTree.getBody(), SWT.NONE);

		sitesTreeViewer = new TreeViewer(frmWarehouseTree.getBody(), SWT.BORDER | SWT.VIRTUAL);
		sitesTreeViewer.setUseHashlookup(true);
		Tree tree = sitesTreeViewer.getTree();
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		toolkit.paintBordersFor(tree);

		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(
				sitesTreeViewer, SWT.NONE);
		TreeColumn trclmnCountry = treeViewerColumn.getColumn();
		trclmnCountry.setWidth(100);
		trclmnCountry.setText("Warehouse");

		TreeViewerColumn treeViewerColumn_1 = new TreeViewerColumn(
				sitesTreeViewer, SWT.NONE);
		TreeColumn trclmnName = treeViewerColumn_1.getColumn();
		trclmnName.setWidth(129);
		trclmnName.setText("Item name");

		sitesTreeViewer.addFilter(searchFilter);
	}
	

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author dzonekl
	 * 
	 */
	class EditWarehouseItemAction extends Action {

		public EditWarehouseItemAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			super.run();
			if (screenService != null) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
//					if( o instanceof Site){
//						NewEditSite siteScreen = new NewEditSite(
//								screenService.getScreenContainer(), SWT.NONE);
//						siteScreen.setScreenService(screenService);
//						siteScreen.setOperation(getOperation());
//						siteScreen.injectData(((Site)o).eContainer(), o);
//						screenService.setActiveScreen(siteScreen);
//					}
					// TODO. 
					
					
				}
			}
		}
	}
	
	public void disposeData() {
		editingService.disposeData(countryResource);
	}

	@Override
	public Viewer getViewer() {
		return sitesTreeViewer;
	}

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public Form getScreenForm() {
		return this.frmWarehouseTree;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}

	@Override
	public IAction[] getActions() {
		
		List<IAction> actions = Lists.newArrayList();
		
		boolean readonly =  Screens.isReadOnlyOperation(getOperation());
		String actionText = readonly? "View" : "Edit";
		actions.add(new EditWarehouseItemAction(actionText + "...",
				SWT.PUSH));
		
		IAction[] actionArray = new IAction[actions.size()];
		return actions.toArray(actionArray); 
	}

}
