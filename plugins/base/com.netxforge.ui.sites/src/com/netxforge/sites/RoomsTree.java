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
package com.netxforge.sites;

import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
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
import com.netxforge.netxstudio.geo.GeoFactory;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.geo.Room;
import com.netxforge.netxstudio.geo.Site;
import com.netxforge.screens.editing.base.AbstractScreenImpl;
import com.netxforge.screens.editing.base.IDataServiceInjection;
import com.netxforge.screens.editing.base.ScreenUtil;
import com.netxforge.screens.editing.base.actions.BaseSelectionListenerAction;
import com.netxforge.screens.editing.base.filter.ISearchFilter;
import com.netxforge.sites.support.RoomTreeFactory;
import com.netxforge.sites.support.RoomTreeStructureAdvisor;

public class RoomsTree extends AbstractScreenImpl implements
		IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;
	private Resource countryResource;
	@SuppressWarnings("unused")
	private EMFDataBindingContext bindingContext;
	private Form frmSites;
	private TreeViewer roomsTreeViewer;
	private ObservableListTreeContentProvider listTreeContentProvider;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public RoomsTree(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	public EMFDataBindingContext initDataBindings_() {

		listTreeContentProvider = new ObservableListTreeContentProvider(
				new RoomTreeFactory(editingService.getEditingDomain()),
				new RoomTreeStructureAdvisor());
		roomsTreeViewer.setContentProvider(listTreeContentProvider);
		IObservableSet set = listTreeContentProvider.getKnownElements();

		List<IObservableMap> mapList = Lists.newArrayList();

		mapList.add(EMFProperties.value(GeoPackage.Literals.LOCATION__NAME)
				.observeDetail(set));

		// mapList.add(EMFProperties.value(GeoPackage.Literals.LOCATION__NAME)
		// .observeDetail(set));
		//
		// mapList.add(EMFProperties.value(GeoPackage.Literals.LOCATION__NAME)
		// .observeDetail(set));

		IObservableMap[] observeMaps = new IObservableMap[mapList.size()];
		mapList.toArray(observeMaps);

		roomsTreeViewer.setLabelProvider(new ObservableMapLabelProvider(
				observeMaps));

		IEMFListProperty countryResourceProperty = EMFEditProperties
				.resource(editingService.getEditingDomain());
		IObservableList countryObservableList = countryResourceProperty
				.observe(countryResource);
		roomsTreeViewer.setInput(countryObservableList);
		EMFDataBindingContext context = new EMFDataBindingContext();
		return context;
	}

	public void injectData() {
		countryResource = editingService.getData(GeoPackage.Literals.COUNTRY);
		buildUI();
		bindingContext = initDataBindings_();
	}

	private void buildUI() {

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());

		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmSites = toolkit.createForm(this);
		frmSites.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmSites);
		frmSites.setText(this.getOperationText() + "Rooms");
		frmSites.getBody().setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(frmSites.getBody(),
				"Filter:", SWT.NONE);
		lblFilterLabel.setAlignment(SWT.RIGHT);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 36;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmSites.getBody(), "New Text",
				SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				ViewerFilter[] filters = roomsTreeViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof ISearchFilter) {
						((ISearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
				roomsTreeViewer.refresh();
			}
		});
		txtFilterText.setText("");

		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);

		if (!readonly) {

			ImageHyperlink mghprlnkNewMetric = toolkit.createImageHyperlink(
					frmSites.getBody(), SWT.NONE);
			mghprlnkNewMetric.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					ISelection sel = getViewer().getSelection();
					if (sel instanceof IStructuredSelection) {
						Object o = ((IStructuredSelection) sel)
								.getFirstElement();
						if (o instanceof Site) {
							NewEditRoom roomScreen = new NewEditRoom(
									screenService.getScreenContainer(),
									SWT.NONE);
							roomScreen.setScreenService(screenService);
							roomScreen.setOperation(ScreenUtil.OPERATION_NEW);
							roomScreen.injectData(o,
									GeoFactory.eINSTANCE.createRoom());
							screenService.setActiveScreen(roomScreen);
						}
					}
				}

				public void linkEntered(HyperlinkEvent e) {
				}

				public void linkExited(HyperlinkEvent e) {
				}
			});
			mghprlnkNewMetric.setImage(ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/ctool16/Room_E.png"));
			toolkit.paintBordersFor(mghprlnkNewMetric);
			mghprlnkNewMetric.setText("New");

		}

		roomsTreeViewer = new TreeViewer(frmSites.getBody(), SWT.BORDER
				| SWT.VIRTUAL);
		roomsTreeViewer.setUseHashlookup(true);
		roomsTreeViewer.setComparer(getElementComparor());

		Tree tree = roomsTreeViewer.getTree();
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		toolkit.paintBordersFor(tree);

		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(
				roomsTreeViewer, SWT.NONE);
		TreeColumn trclmnCountry = treeViewerColumn.getColumn();
		trclmnCountry.setWidth(100);
		trclmnCountry.setText("Country");

		TreeViewerColumn treeViewerColumn_2 = new TreeViewerColumn(
				roomsTreeViewer, SWT.NONE);
		TreeColumn trclmnSite = treeViewerColumn_2.getColumn();
		trclmnSite.setWidth(100);
		trclmnSite.setText("Site");

		TreeViewerColumn treeViewerColumn_1 = new TreeViewerColumn(
				roomsTreeViewer, SWT.NONE);
		TreeColumn trclmnName = treeViewerColumn_1.getColumn();
		trclmnName.setWidth(129);
		trclmnName.setText("Name");

		roomsTreeViewer.addFilter(this.getSearchFilter());
	}

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class EditRoomAction extends BaseSelectionListenerAction {

		public EditRoomAction(String text) {
			super(text);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.netxforge.netxstudio.screens.editing.actions.
		 * BaseSelectionListenerAction
		 * #updateSelection(org.eclipse.jface.viewers.IStructuredSelection)
		 */
		@Override
		protected boolean updateSelection(IStructuredSelection selection) {
			return selection.getFirstElement() instanceof Room;
		}

		@Override
		public void run() {
			super.run();
			Object o = this.getStructuredSelection().getFirstElement();
			NewEditRoom roomScreen = new NewEditRoom(
					screenService.getScreenContainer(), SWT.NONE);
			roomScreen.setScreenService(screenService);
			roomScreen.setOperation(getOperation());
			roomScreen.injectData(((EObject) o).eContainer(), o);
			screenService.setActiveScreen(roomScreen);
		}
	}

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class NewRoomAction extends Action {

		public NewRoomAction(String text) {
			super(text);
			ImageDescriptor descriptor = ResourceManager
					.getPluginImageDescriptor(
							"com.netxforge.netxstudio.models.edit",
							"icons/full/ctool16/Room_E.png");
			setImageDescriptor(descriptor);
		}

		@Override
		public void run() {
			super.run();
			if (screenService != null) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					if (o instanceof Site) {
						NewEditRoom roomScreen = new NewEditRoom(
								screenService.getScreenContainer(), SWT.NONE);
						roomScreen.setScreenService(screenService);
						roomScreen.setOperation(ScreenUtil.OPERATION_NEW);
						roomScreen.injectData(o,
								GeoFactory.eINSTANCE.createRoom());
						screenService.setActiveScreen(roomScreen);
					}
				}
			}
		}
	}

	public Viewer getViewer() {
		return roomsTreeViewer;
	}

	@Override
	public boolean isValid() {
		return false;
	}

	public Form getScreenForm() {
		return this.frmSites;
	}

	private final List<IAction> actions = Lists.newArrayList();

	@Override
	public IAction[] getActions() {

		if (actions.isEmpty()) {
			boolean readonly = ScreenUtil.isReadOnlyOperation(getOperation());
			String actionText = readonly ? "View" : "Edit";
			actions.add(new EditRoomAction(actionText + "..."));
		}
		return actions.toArray(new IAction[actions.size()]);
	}

	@Override
	public String getScreenName() {
		return "Rooms";
	}

}
