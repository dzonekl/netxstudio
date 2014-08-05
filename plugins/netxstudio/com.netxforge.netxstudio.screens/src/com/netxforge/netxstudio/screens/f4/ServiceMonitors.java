/*******************************************************************************
 * Copyright (c) 17 dec. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.f4;

import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.common.collect.Lists;
import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.tables.CDOElementComparer;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.ServiceMonitor;
import com.netxforge.netxstudio.services.ServicesPackage;
import com.netxforge.screens.editing.base.IDataScreenInjection;
import com.netxforge.screens.editing.base.ScreenUtil;

/**
 * 
 * @author Christophe
 * 
 */
public class ServiceMonitors extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Text txtFilterText;

	private TableViewer serviceMonitorsTableViewer;
	private Form frmServiceMonitors;

	private TableViewerColumn tblViewerClmnState;
	private RFSService rfsService;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ServiceMonitors(Composite parent, int style) {
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

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmServiceMonitors = toolkit.createForm(this);
		frmServiceMonitors.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmServiceMonitors);
		frmServiceMonitors.setText("Service Monitoring");
		frmServiceMonitors.getBody().setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(
				frmServiceMonitors.getBody(), "Filter:", SWT.NONE);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 44;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmServiceMonitors.getBody(),
				"New Text", SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.setText("");
		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);
		new Label(frmServiceMonitors.getBody(), SWT.NONE);

		serviceMonitorsTableViewer = new TableViewer(
				frmServiceMonitors.getBody(), SWT.BORDER | SWT.FULL_SELECTION
						| SWT.MULTI);
		serviceMonitorsTableViewer.setComparer(new CDOElementComparer());

		table = serviceMonitorsTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		toolkit.paintBordersFor(table);

		TableViewerColumn tblViewerClmType = new TableViewerColumn(
				serviceMonitorsTableViewer, SWT.NONE);
		TableColumn tblclmnName = tblViewerClmType.getColumn();
		tblclmnName.setWidth(106);
		tblclmnName.setText("Name");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				serviceMonitorsTableViewer, SWT.NONE);
		TableColumn tblclmnRevision = tableViewerColumn.getColumn();
		tblclmnRevision.setWidth(104);
		tblclmnRevision.setText("Revision");

		tblViewerClmnState = new TableViewerColumn(serviceMonitorsTableViewer,
				SWT.NONE);
		TableColumn tblclmnStart = tblViewerClmnState.getColumn();
		tblclmnStart.setWidth(139);
		tblclmnStart.setText("Start");

		// Menu menu = new Menu(table);
		// table.setMenu(menu);
		//
		// MenuItem mntmEdit = new MenuItem(menu, SWT.NONE);
		// mntmEdit.addSelectionListener(new SelectionAdapter() {
		// @Override
		// public void widgetSelected(SelectionEvent e) {
		//
		// ISelection selection = getViewer().getSelection();
		// if (selection instanceof IStructuredSelection) {
		// Object o = ((IStructuredSelection) selection)
		// .getFirstElement();
		// ResourceMonitors rmScreen = new ResourceMonitors(
		// screenService.getScreenContainer(), SWT.NONE);
		// rmScreen.setOperation(Screens.OPERATION_READ_ONLY);
		// rmScreen.setScreenService(screenService);
		// rmScreen.injectData(null,o);
		// screenService.setActiveScreen(rmScreen);
		// }
		// }
		// });
		// mntmEdit.setText("View...");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				serviceMonitorsTableViewer, SWT.NONE);
		TableColumn tblclmnEnd = tableViewerColumn_1.getColumn();
		tblclmnEnd.setWidth(185);
		tblclmnEnd.setText("End");
	}

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class EditMonitorAction extends Action {

		public EditMonitorAction(String text) {
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
					ResourceMonitors rmScreen = new ResourceMonitors(
							screenService.getScreenContainer(), SWT.NONE);
					rmScreen.setOperation(ScreenUtil.OPERATION_READ_ONLY);
					rmScreen.setScreenService(screenService);
					rmScreen.injectData(null, o);
					screenService.setActiveScreen(rmScreen);
				}
			}
		}
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		// tblViewerClmnState.setEditingSupport(new CheckBoxEditingSupport(
		// jobsTableViewer, bindingContext));

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		serviceMonitorsTableViewer.setContentProvider(listContentProvider);

		EAttribute dummyAttribute = EcoreFactory.eINSTANCE.createEAttribute();

		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] { dummyAttribute,
						ServicesPackage.Literals.SERVICE_MONITOR__NAME,
						ServicesPackage.Literals.SERVICE_MONITOR__REVISION,
						ServicesPackage.Literals.SERVICE_MONITOR__PERIOD,
						ServicesPackage.Literals.SERVICE_MONITOR__PERIOD, });
		serviceMonitorsTableViewer
				.setLabelProvider(new ServiceMonitorsObervableMapLabelProvider(
						observeMaps));

		IEMFListProperty resourcesProperties = EMFEditProperties.list(
				editingService.getEditingDomain(),
				ServicesPackage.Literals.SERVICE__SERVICE_MONITORS);
		IObservableList rfsServicesObservableList = resourcesProperties
				.observe(this.rfsService);
		// obm.addObservable(rfsServicesObservableList);
		serviceMonitorsTableViewer.setInput(rfsServicesObservableList);

		return bindingContext;
	}

	class ServiceMonitorsObervableMapLabelProvider extends
			ObservableMapLabelProvider {

		public ServiceMonitorsObervableMapLabelProvider(
				IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return super.getColumnImage(element, columnIndex);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof ServiceMonitor) {
				ServiceMonitor sm = (ServiceMonitor) element;
				switch (columnIndex) {
				case 0:
					if (sm.getName() != null) {
						return sm.getName();
					}
					break;
				case 1:
					if (sm.getRevision() != null) {
						return sm.getRevision();
					}
					break;
				case 2:
					if (sm.getPeriod() != null) {
						Date begin = NonModelUtils.fromXMLDate(sm.getPeriod()
								.getBegin());
						return NonModelUtils.date(begin) + " @ "
								+ NonModelUtils.time(begin);
					}
					break;
				case 3:
					if (sm.getPeriod() != null) {
						Date end = NonModelUtils.fromXMLDate(sm.getPeriod()
								.getEnd());
						return NonModelUtils.date(end) + " @ "
								+ NonModelUtils.time(end);
					}
					break;
				}
			}
			return super.getColumnText(element, columnIndex);
		}
	}

	public void injectData(Object owner, Object object) {
		if (object instanceof RFSService) {
			rfsService = (RFSService) object;
		}
		buildUI();
		initDataBindings_();
	}

	public void addData() {
		// N/A
	}

	public void disposeData() {
		// N/A
	}

	public Viewer getViewer() {
		return serviceMonitorsTableViewer;
	}

	public boolean isValid() {
		return true;
	}

	public Form getScreenForm() {
		return frmServiceMonitors;
	}

	private final List<IAction> actions = Lists.newArrayList();

	@Override
	public IAction[] getActions() {
		// lazy initialize.
		if (actions.isEmpty()) {
			// String actionText = Screens.isReadOnlyOperation(getOperation()) ?
			// "View" : "Edit";
			actions.add(new EditMonitorAction("Resource Monitors..."));
		}
		return actions.toArray(new IAction[actions.size()]);
	}

	@Override
	public String getScreenName() {
		return "Service Monitors";
	}

}
