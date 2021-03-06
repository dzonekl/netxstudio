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
package com.netxforge.netxstudio.screens.f3;

import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
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
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.geo.GeoFactory;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.geo.Site;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.filter.CDOSearchFilter;
import com.netxforge.screens.editing.base.IDataServiceInjection;
import com.netxforge.screens.editing.base.ScreenUtil;
import com.netxforge.screens.editing.base.filter.ISearchFilter;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class SitesTable extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;
	private Table table;

	private TableViewer tableViewer;
	@SuppressWarnings("unused")
	private DataBindingContext bindingContext;
	private Form frmSites;
	private ObservableListContentProvider listContentProvider;
	private Resource countryResource;
	private TableColumn tblclmnShortname;
	private TableViewerColumn tableViewerColumn_2;
	private TableColumn tblclmnCountry;
	private TableViewerColumn tableViewerColumn_1;
	private TableColumn tblclmnStreet;
	private TableViewerColumn tableViewerColumn_3;
	private TableColumn tblclmnNr;
	private TableViewerColumn tableViewerColumn_4;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public SitesTable(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class EditSiteAction extends Action {

		public EditSiteAction(String text) {
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
						NewEditSite countryScreen = new NewEditSite(
								screenService.getScreenContainer(), SWT.NONE);
						countryScreen.setOperation(getOperation());
						countryScreen.setScreenService(screenService);
						countryScreen.injectData(countryResource, o);
						screenService.setActiveScreen(countryScreen);
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
		countryResource = editingService.getData(GeoPackage.Literals.COUNTRY);
		buildUI();
		bindingContext = initDataBindings_();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		String actionText = readonly ? "View: " : "Edit: ";
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmSites = toolkit.createForm(this);
		frmSites.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmSites);
		frmSites.setText(actionText + "Sites");
		frmSites.getBody().setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(frmSites.getBody(),
				"Filter:", SWT.NONE);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 36;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmSites.getBody(), "New Text",
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
					frmSites.getBody(), SWT.NONE);
			mghprlnkNew.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					NewEditSite countryScreen = new NewEditSite(screenService
							.getScreenContainer(), SWT.NONE);
					countryScreen.setOperation(ScreenUtil.OPERATION_NEW);
					countryScreen.setScreenService(screenService);
					Site newCountry = GeoFactory.eINSTANCE.createSite();
					countryScreen.injectData(countryResource, newCountry);
					screenService.setActiveScreen(countryScreen);
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
					"icons/full/ctool16/Site_E.png"));
			mghprlnkNew.setBounds(0, 0, 114, 17);
			toolkit.paintBordersFor(mghprlnkNew);
			mghprlnkNew.setText("New");

		}
		new Label(frmSites.getBody(), SWT.NONE);

		tableViewer = new TableViewer(frmSites.getBody(), SWT.BORDER
				| SWT.FULL_SELECTION | SWT.VIRTUAL | widgetStyle);
		tableViewer.setUseHashlookup(true);

		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 2));
		toolkit.paintBordersFor(table);

		tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnCountry = tableViewerColumn_1.getColumn();
		tblclmnCountry.setWidth(76);
		tblclmnCountry.setText("Country");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(74);
		tblclmnName.setText("Name");

		tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnShortname = tableViewerColumn_2.getColumn();
		tblclmnShortname.setWidth(87);
		tblclmnShortname.setText("City");

		tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnStreet = tableViewerColumn_3.getColumn();
		tblclmnStreet.setWidth(165);
		tblclmnStreet.setText("Street");

		tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnNr = tableViewerColumn_4.getColumn();
		tblclmnNr.setWidth(51);
		tblclmnNr.setText("Nr");
		tableViewer.addFilter(new CDOSearchFilter());
	}

	public EMFDataBindingContext initDataBindings_() {
		
		
		listContentProvider = new ObservableListContentProvider();
		tableViewer.setContentProvider(listContentProvider);

		IObservableSet set = listContentProvider.getKnownElements();

		List<IObservableMap> mapList = Lists.newArrayList();

		mapList.add(EMFProperties.value(GeoPackage.Literals.LOCATION__NAME)
				.observeDetail(set));

		mapList.add(EMFProperties.value(GeoPackage.Literals.LOCATION__NAME)
				.observeDetail(set));

		mapList.add(EMFProperties.value(GeoPackage.Literals.SITE__CITY)
				.observeDetail(set));

		mapList.add(EMFProperties.value(GeoPackage.Literals.SITE__SREET)
				.observeDetail(set));

		mapList.add(EMFProperties.value(GeoPackage.Literals.SITE__HOUSENUMBER)
				.observeDetail(set));

		IObservableMap[] observeMaps = new IObservableMap[mapList.size()];
		mapList.toArray(observeMaps);

		tableViewer
				.setLabelProvider(new ObservableMapLabelProvider(observeMaps));

		IEMFListProperty resourceProperty = EMFEditProperties
				.list(editingService.getEditingDomain(), GeoPackage.Literals.COUNTRY__SITES);
		IObservableList operatorsObservableList = resourceProperty
				.observe(countryResource.getContents());

		tableViewer.setInput(operatorsObservableList);

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
		return this.frmSites;
	}

	@Override
	public IAction[] getActions() {
		String actionText = ScreenUtil.isReadOnlyOperation(getOperation()) ? "View"
				: "Edit";
		return new IAction[] { new EditSiteAction(actionText + "...") };
	}
	
	@Override
	public String getScreenName() {
		return "Sites";
	}


}
