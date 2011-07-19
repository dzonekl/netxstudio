package com.netxforge.netxstudio.screens.f2;

import org.eclipse.core.databinding.observable.list.IObservableList;
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
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.services.ServiceMonitor;

public class ResourceMonitors extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Text txtFilterText;

	private TableViewer resourceMonitorsTableViewer;
	private Form frmResourceMonitors;
	private Resource rfsServiceResource;

	@Inject
	ModelUtils modelUtils;
	private TableViewerColumn tblViewerClmnState;
	// private List<ServiceMonitor> allServiceMonitors;
	private ServiceMonitor serviceMonitor;
	private Resource rmResource;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ResourceMonitors(Composite parent, int style) {
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

		frmResourceMonitors = toolkit.createForm(this);
		frmResourceMonitors.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmResourceMonitors);
		frmResourceMonitors.setText("Resource Monitors");
		frmResourceMonitors.getBody().setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(
				frmResourceMonitors.getBody(), "Filter:", SWT.NONE);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 44;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmResourceMonitors.getBody(),
				"New Text", SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.setText("");
		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);
		new Label(frmResourceMonitors.getBody(), SWT.NONE);

		resourceMonitorsTableViewer = new TableViewer(
				frmResourceMonitors.getBody(), SWT.BORDER | SWT.FULL_SELECTION);
		table = resourceMonitorsTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 4));
		toolkit.paintBordersFor(table);

		TableViewerColumn tblViewerClmType = new TableViewerColumn(
				resourceMonitorsTableViewer, SWT.NONE);
		TableColumn tblclmnNode = tblViewerClmType.getColumn();
		tblclmnNode.setWidth(76);
		tblclmnNode.setText("Node");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				resourceMonitorsTableViewer, SWT.NONE);
		TableColumn tblclmnResource = tableViewerColumn.getColumn();
		tblclmnResource.setWidth(104);
		tblclmnResource.setText("Resource");

		tblViewerClmnState = new TableViewerColumn(resourceMonitorsTableViewer,
				SWT.NONE);
		TableColumn tblclmnMarkers = tblViewerClmnState.getColumn();
		tblclmnMarkers.setWidth(207);
		tblclmnMarkers.setText("Markers");

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
					com.netxforge.netxstudio.screens.f2.ResourceMonitor rmScreen = new com.netxforge.netxstudio.screens.f2.ResourceMonitor(
							screenService.getScreenContainer(), SWT.NONE);
					rmScreen.setScreenService(screenService);
					rmScreen.setOperation(getOperation());
					rmScreen.injectData(null, o);
					screenService.setActiveScreen(rmScreen);
				}
			}
		});
		mntmEdit.setText("View...");
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		resourceMonitorsTableViewer.setContentProvider(listContentProvider);

		IObservableMap[] observeMaps = EMFObservables
				.observeMaps(
						listContentProvider.getKnownElements(),
						new EStructuralFeature[] {
								OperatorsPackage.Literals.RESOURCE_MONITOR__NODE_REF,
								OperatorsPackage.Literals.RESOURCE_MONITOR__RESOURCE_REF,
								OperatorsPackage.Literals.RESOURCE_MONITOR__MARKERS, });
		resourceMonitorsTableViewer
				.setLabelProvider(new ResourceMonitorObervableMapLabelProvider(
						observeMaps));

//		IEMFListProperty serviceMonitorObservableList = EMFEditProperties.list(
//				editingService.getEditingDomain(),
//				ServicesPackage.Literals.SERVICE_MONITOR__RESOURCE_MONITORS);
		
		IEMFListProperty serviceMonitorObservableList = EMFEditProperties.resource(
		editingService.getEditingDomain());
		
		IObservableList resourceList = serviceMonitorObservableList
				.observe(this.rmResource);
		obm.addObservable(resourceList);
		resourceMonitorsTableViewer.setInput(resourceList);

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
				ResourceMonitor rm = (ResourceMonitor) element;
				switch (columnIndex) {
				case 0:
					if (rm.getNodeRef() != null) {
						return rm.getNodeRef().getNodeID();
					}
					break;
				case 1:
					if (rm.getResourceRef() != null) {
						return rm.getResourceRef().getShortName();
					}
					break;
				case 2:
					return new Integer(rm.getMarkers().size()).toString();
				}
			}
			return super.getColumnText(element, columnIndex);
		}
	}

	public void injectData(Object owner, Object object) {

		if (object instanceof ServiceMonitor) {
			serviceMonitor = (ServiceMonitor) object;
			
			rmResource = editingService.getData(OperatorsPackage.Literals.RESOURCE_MONITOR);
			initDataBindings_();
		}
	}

	public void disposeData() {
		editingService.disposeData(rfsServiceResource);
	}

	@Override
	public Viewer getViewer() {
		return resourceMonitorsTableViewer;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return frmResourceMonitors;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;

	}

	public void addData() {
		// TODO Auto-generated method stub

	}

}
