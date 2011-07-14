package com.netxforge.netxstudio.screens.f2;

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
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
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
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.services.ServiceMonitor;
import com.netxforge.netxstudio.services.ServicesPackage;

public class ServiceMonitors extends AbstractScreen implements
		IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Text txtFilterText;

	private TableViewer serviceMonitorsTableViewer;
	private Form frmServiceMonitors;
	private Resource rfsServiceResource;

	@Inject
	ModelUtils modelUtils;
	private TableViewerColumn tblViewerClmnState;
	private List<ServiceMonitor> allServiceMonitors;

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
				obm.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
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
				frmServiceMonitors.getBody(), SWT.BORDER | SWT.FULL_SELECTION);
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

		Menu menu = new Menu(table);
		table.setMenu(menu);

		MenuItem mntmEdit = new MenuItem(menu, SWT.NONE);
		mntmEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					
					
					// TODO, Show a resource Monitor screen.

					// NewEditResource job = new NewEditResource(screenService
					// .getScreenContainer(), SWT.NONE);
					// job.setOperation(Screens.OPERATION_EDIT);
					// screenService.setActiveScreen(job);
					// job.injectData(resourcesResource, o);
				}
			}
		});
		mntmEdit.setText("View...");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(serviceMonitorsTableViewer, SWT.NONE);
		TableColumn tblclmnEnd = tableViewerColumn_1.getColumn();
		tblclmnEnd.setWidth(185);
		tblclmnEnd.setText("End");

		if (editingService != null) {
			injectData();
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
						OperatorsPackage.Literals.RESOURCE_MONITOR__MARKERS,
						 });
		serviceMonitorsTableViewer
				.setLabelProvider(new ResourceMonitorObervableMapLabelProvider(
						observeMaps));

		IEMFListProperty resourcesProperties = EMFEditProperties
				.list(editingService.getEditingDomain(), ServicesPackage.Literals.SERVICE_MONITOR__RESOURCE_MONITORS);
		IObservableList resourceList = resourcesProperties
				.observe(allServiceMonitors);
		obm.addObservable(resourceList);
		serviceMonitorsTableViewer.setInput(resourceList);

		return bindingContext;
	}

	class ResourceMonitorObervableMapLabelProvider extends
			ObservableMapLabelProvider {

		public ResourceMonitorObervableMapLabelProvider(
				IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return super.getColumnImage(element, columnIndex);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof ResourceMonitor) {
				ResourceMonitor j = (ResourceMonitor) element;
				switch (columnIndex) {
				case 0:
					if (j.getNodeRef() != null) {
						return j.getNodeRef().getNodeID();
					}
					break;
				case 1:
					if (j.getResourceRef() != null) {
						return j.getResourceRef().getShortName();
					}
					break;
				case 2:
					return new Integer(j.getMarkers().size()).toString();
				}
			}
			return super.getColumnText(element, columnIndex);
		}
	}

	public void injectData() {
		rfsServiceResource = editingService
				.getData(ServicesPackage.Literals.RFS_SERVICE);
		initDataBindings_();
	}

	public void disposeData() {
		editingService.disposeData(rfsServiceResource);
	}

	@Override
	public Viewer getViewer() {
		return serviceMonitorsTableViewer;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return frmServiceMonitors;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;

	}

}
