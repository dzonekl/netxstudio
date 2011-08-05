package com.netxforge.netxstudio.screens.f2;

import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
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
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.services.ServiceMonitor;
import com.netxforge.netxstudio.services.ServicesPackage;

public class Services extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Text txtFilterText;

	private TableViewer servicesTableViewer;
	private Form frmServices;
	private Resource rfsServiceResource;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public Services(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
//				obm.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);

	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmServices = toolkit.createForm(this);
		frmServices.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmServices);
		frmServices.setText("Services");
		frmServices.getBody().setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(frmServices.getBody(),
				"Filter:", SWT.NONE);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 44;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmServices.getBody(), "New Text",
				SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.setText("");
		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);
		new Label(frmServices.getBody(), SWT.NONE);

		servicesTableViewer = new TableViewer(frmServices.getBody(), SWT.BORDER
				| SWT.FULL_SELECTION);
		table = servicesTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		toolkit.paintBordersFor(table);

		TableViewerColumn tblViewerClmType = new TableViewerColumn(
				servicesTableViewer, SWT.NONE);
		TableColumn tblclmnName = tblViewerClmType.getColumn();
		tblclmnName.setWidth(106);
		tblclmnName.setText("Name");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				servicesTableViewer, SWT.NONE);
		TableColumn tblclmnDescription = tableViewerColumn.getColumn();
		tblclmnDescription.setWidth(104);
		tblclmnDescription.setText("Description");

	}
	
	

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author dzonekl
	 * 
	 */
	class EditServiceAction extends Action {

		public EditServiceAction(String text, int style) {
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
					ServiceMonitors smScreen = new ServiceMonitors(
							screenService.getScreenContainer(), SWT.NONE);
					smScreen.setOperation(Screens.OPERATION_READ_ONLY);
					smScreen.setScreenService(screenService);
					smScreen.injectData(null, o);
					screenService.setActiveScreen(smScreen);
				}
			}
		}
	}
	
	

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		// tblViewerClmnState.setEditingSupport(new CheckBoxEditingSupport(
		// jobsTableViewer, bindingContext));

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		servicesTableViewer.setContentProvider(listContentProvider);

		IObservableMap[] observeMaps = EMFObservables
				.observeMaps(
						listContentProvider.getKnownElements(),
						new EStructuralFeature[] {
								ServicesPackage.Literals.SERVICE__SERVICE_NAME,
								ServicesPackage.Literals.SERVICE__SERVICE_DESCRIPTION });
		servicesTableViewer
				.setLabelProvider(new ServiceMonitorsObervableMapLabelProvider(
						observeMaps));

		IEMFListProperty serviceProperty = EMFEditProperties
				.resource(editingService.getEditingDomain());
		IObservableList rfsServicesObservableList = serviceProperty
				.observe(rfsServiceResource);
//		obm.addObservable(rfsServicesObservableList);
		servicesTableViewer.setInput(rfsServicesObservableList);

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
						Date begin = modelUtils.fromXMLDate(sm.getPeriod()
								.getBegin());
						return modelUtils.date(begin) + modelUtils.time(begin);
					}
					break;
				case 3:
					if (sm.getPeriod() != null) {
						Date end = modelUtils.fromXMLDate(sm.getPeriod()
								.getEnd());
						return modelUtils.date(end) + modelUtils.time(end);
					}
					break;
				}
			}
			return super.getColumnText(element, columnIndex);
		}
	}

	public void injectData() {
		rfsServiceResource = editingService
				.getData(ServicesPackage.Literals.RFS_SERVICE);
		buildUI();
		initDataBindings_();
	}

	public void disposeData() {
		editingService.disposeData(rfsServiceResource);
	}

	@Override
	public Viewer getViewer() {
		return servicesTableViewer;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return frmServices;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;

	}

	
	@Override
	public IAction[] getActions() {
		
		List<IAction> actions = Lists.newArrayList();
		
		String actionText = Screens.isReadOnlyOperation(getOperation()) ? "View"
				: "Edit";
		actions.add(new EditServiceAction(actionText + "...",
				SWT.PUSH));
		IAction[] actionArray = new IAction[actions.size()];
		return actions.toArray(actionArray); 
	}
	
	

}
