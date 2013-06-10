package com.netxforge.netxstudio.screens.f1;

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
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.editing.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.ScreenUtil;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.ServicesFactory;
import com.netxforge.netxstudio.services.ServicesPackage;

public class ServiceUsers extends AbstractScreen implements
		IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Text txtFilterText;

	private TableViewer serviceUsers;
	private Form frmServiceUsers;
	private Resource serviceUserResource;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ServiceUsers(Composite parent, int style) {
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

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());

		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmServiceUsers = toolkit.createForm(this);
		frmServiceUsers.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmServiceUsers);
		frmServiceUsers.setText(this.getOperationText() + "Service Users");
		frmServiceUsers.getBody().setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(frmServiceUsers.getBody(),
				"Filter:", SWT.NONE);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 44;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmServiceUsers.getBody(),
				"New Text", SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.setText("");
		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);

		if (!readonly) {

			ImageHyperlink mghprlnkNew = toolkit.createImageHyperlink(
					frmServiceUsers.getBody(), SWT.NONE);
			mghprlnkNew.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					if (screenService != null) {
						NewEditServiceUser smScreen = new NewEditServiceUser(
								screenService.getScreenContainer(), SWT.NONE);
						smScreen.setOperation(ScreenUtil.OPERATION_NEW);
						smScreen.setScreenService(screenService);
						ServiceUser su = ServicesFactory.eINSTANCE
								.createServiceUser();
						su.setServiceProfile(ServicesFactory.eINSTANCE
								.createServiceProfile());
						smScreen.injectData(serviceUserResource, su);
						screenService.setActiveScreen(smScreen);
					}
				}

				public void linkEntered(HyperlinkEvent e) {
				}

				public void linkExited(HyperlinkEvent e) {
				}
			});
			mghprlnkNew.setImage(ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/ctool16/ServiceUserProfile_E.png"));
			mghprlnkNew.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
					false, false, 1, 1));
			toolkit.paintBordersFor(mghprlnkNew);
			mghprlnkNew.setText("New");
		}
		
		serviceUsers = new TableViewer(frmServiceUsers.getBody(), SWT.BORDER
				| SWT.MULTI | SWT.FULL_SELECTION);
		serviceUsers.setComparer(new CDOElementComparer());
		table = serviceUsers.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		toolkit.paintBordersFor(table);

		TableViewerColumn tblViewerClmType = new TableViewerColumn(
				serviceUsers, SWT.NONE);
		TableColumn tblclmnName = tblViewerClmType.getColumn();
		tblclmnName.setWidth(200);
		tblclmnName.setText("Name");

	}

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class EditServiceAction extends Action {

		public EditServiceAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			super.run();
			if (screenService != null) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					final Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					NewEditServiceUser smScreen = new NewEditServiceUser(
							screenService.getScreenContainer(), SWT.NONE);
					smScreen.setOperation(getOperation());
					smScreen.setScreenService(screenService);
					smScreen.injectData(serviceUserResource, o);
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
		serviceUsers.setContentProvider(listContentProvider);

		IObservableMap[] observeMaps = EMFObservables
				.observeMaps(
						listContentProvider.getKnownElements(),
						new EStructuralFeature[] { ServicesPackage.Literals.SERVICE_USER__NAME });
		serviceUsers.setLabelProvider(new ObservableMapLabelProvider(
				observeMaps));

		IEMFListProperty serviceProperty = EMFEditProperties
				.resource(editingService.getEditingDomain());
		IObservableList rfsServicesObservableList = serviceProperty
				.observe(serviceUserResource);
		// obm.addObservable(rfsServicesObservableList);
		serviceUsers.setInput(rfsServicesObservableList);

		return bindingContext;
	}

	// class ServiceMonitorsObervableMapLabelProvider extends
	// ObservableMapLabelProvider {
	//
	// public ServiceMonitorsObervableMapLabelProvider(
	// IObservableMap[] attributeMaps) {
	// super(attributeMaps);
	// }
	//
	// @Override
	// public Image getColumnImage(Object element, int columnIndex) {
	// return super.getColumnImage(element, columnIndex);
	// }
	//
	// @Override
	// public String getColumnText(Object element, int columnIndex) {
	// if (element instanceof ServiceMonitor) {
	// ServiceMonitor sm = (ServiceMonitor) element;
	// switch (columnIndex) {
	// case 0:
	// if (sm.getName() != null) {
	// return sm.getName();
	// }
	// break;
	// case 1:
	// if (sm.getRevision() != null) {
	// return sm.getRevision();
	// }
	// break;
	// case 2:
	// if (sm.getPeriod() != null) {
	// Date begin = modelUtils.fromXMLDate(sm.getPeriod()
	// .getBegin());
	// return modelUtils.date(begin) + modelUtils.time(begin);
	// }
	// break;
	// case 3:
	// if (sm.getPeriod() != null) {
	// Date end = modelUtils.fromXMLDate(sm.getPeriod()
	// .getEnd());
	// return modelUtils.date(end) + modelUtils.time(end);
	// }
	// break;
	// }
	// }
	// return super.getColumnText(element, columnIndex);
	// }
	// }

	public void injectData() {
		serviceUserResource = editingService
				.getData(ServicesPackage.Literals.SERVICE_USER);
		buildUI();
		initDataBindings_();
	}

	public void disposeData() {
	}

	public Viewer getViewer() {
		return serviceUsers;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	public Form getScreenForm() {
		return frmServiceUsers;
	}

	@Override
	public IAction[] getActions() {

		List<IAction> actions = Lists.newArrayList();

		String actionText = ScreenUtil.isReadOnlyOperation(getOperation()) ? "View"
				: "Edit";

		actions.add(new EditServiceAction(actionText + "..."));

		// actions.add(new ServiceMonitoringAction("Monitor...", SWT.PUSH));

		IAction[] actionArray = new IAction[actions.size()];
		return actions.toArray(actionArray);
	}

	@Override
	public String getScreenName() {
		return "Service Users";
	}

}
