package com.netxforge.netxstudio.screens.f2;

import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.databinding.EMFDataBindingContext;
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
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class Resources extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Text txtFilterText;

	private TableViewer resourcesTableViewer;
	private Form frmResources;
	private Resource resourcesResource;

	private TableViewerColumn tbvcLongName;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public Resources(Composite parent, int style) {
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

		frmResources = toolkit.createForm(this);
		frmResources.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmResources);
		frmResources.setText("Resources");
		frmResources.getBody().setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(frmResources.getBody(),
				"Filter:", SWT.NONE);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 44;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmResources.getBody(), "New Text",
				SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.setText("");
		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);
		new Label(frmResources.getBody(), SWT.NONE);

		// ImageHyperlink mghprlnkNew = toolkit.createImageHyperlink(
		// frmResources.getBody(), SWT.NONE);
		// mghprlnkNew.addHyperlinkListener(new IHyperlinkListener() {
		// public void linkActivated(HyperlinkEvent e) {
		// if (screenService != null) {
		// NewEditResource resourceScreen = new NewEditResource(screenService
		// .getScreenContainer(), SWT.NONE);
		// resourceScreen.setOperation(Screens.OPERATION_NEW);
		// resourceScreen.setScreenService(screenService);
		// resourceScreen.injectData(resourcesResource,
		// LibraryFactory.eINSTANCE.createNetXResource());
		// screenService.setActiveScreen(resourceScreen);
		// }
		//
		// }
		//
		// public void linkEntered(HyperlinkEvent e) {
		// }
		//
		// public void linkExited(HyperlinkEvent e) {
		// }
		// });
		// mghprlnkNew.setImage(ResourceManager.getPluginImage("com.netxforge.netxstudio.models.edit",
		// "icons/full/ctool16/Resource_E.png"));
		// mghprlnkNew.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
		// false, 1, 1));
		// toolkit.paintBordersFor(mghprlnkNew);
		// mghprlnkNew.setText("New");

		resourcesTableViewer = new TableViewer(frmResources.getBody(),
				SWT.BORDER | SWT.FULL_SELECTION);
		table = resourcesTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 4));
		toolkit.paintBordersFor(table);

		TableViewerColumn tbvcOwner = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnOwner = tbvcOwner.getColumn();
		tblclmnOwner.setWidth(100);
		tblclmnOwner.setText("Owner");
		
		TableViewerColumn tbvcMetric = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnMetric = tbvcMetric.getColumn();
		tblclmnMetric.setWidth(100);
		tblclmnMetric.setText("Metric");

		TableViewerColumn tbvcShortName = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnShortName = tbvcShortName.getColumn();
		tblclmnShortName.setWidth(76);
		tblclmnShortName.setText("Short Name");

		TableViewerColumn tbvcExpressionName = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnExpression = tbvcExpressionName.getColumn();
		tblclmnExpression.setWidth(104);
		tblclmnExpression.setText("Expression Name");

		tbvcLongName = new TableViewerColumn(resourcesTableViewer,
				SWT.NONE);
		TableColumn tblclmnState = tbvcLongName.getColumn();
		tblclmnState.setWidth(200);
		tblclmnState.setText("Long Name");

		TableViewerColumn tbvcUnit = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnUnit = tbvcUnit.getColumn();
		tblclmnUnit.setWidth(68);
		tblclmnUnit.setText("Unit");
	}

	class EditResourceAction extends Action {

		public EditResourceAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection).getFirstElement();
				NewEditResource resourceScreen = new NewEditResource(
						screenService.getScreenContainer(), SWT.NONE);
				resourceScreen.setOperation(Screens.OPERATION_EDIT);
				resourceScreen.setScreenService(screenService);
				resourceScreen.injectData(resourcesResource, o);
				screenService.setActiveScreen(resourceScreen);
			}
		}
	}

	class MonitorResourceAction extends Action {

		public MonitorResourceAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection).getFirstElement();
				if (o instanceof NetXResource) {
					ResourceMonitor monitorScreen = new ResourceMonitor(
							screenService.getScreenContainer(), SWT.NONE);
					monitorScreen.setOperation(Screens.OPERATION_READ_ONLY);
					monitorScreen.setScreenService(screenService);
					monitorScreen.injectData(null, o);
					screenService.setActiveScreen(monitorScreen);
				}
			}
		}
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		resourcesTableViewer.setContentProvider(listContentProvider);


		List<IObservableMap> observeMaps = Lists.newArrayList();
		IObservableSet set = listContentProvider.getKnownElements();
		observeMaps.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.NET_XRESOURCE__COMPONENT_REF)
				.observeDetail(set));

		observeMaps.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.NET_XRESOURCE__METRIC_REF)
				.observeDetail(set));

		observeMaps.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.NET_XRESOURCE__SHORT_NAME)
				.observeDetail(set));
		observeMaps.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.NET_XRESOURCE__EXPRESSION_NAME)
				.observeDetail(set));
		observeMaps.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.NET_XRESOURCE__LONG_NAME)
				.observeDetail(set));
		observeMaps.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.NET_XRESOURCE__UNIT_REF).observeDetail(
				set));

		IObservableMap[] map = new IObservableMap[observeMaps.size()];
		observeMaps.toArray(map);
		resourcesTableViewer
				.setLabelProvider(new NetXResourceObervableMapLabelProvider(map));

		IEMFListProperty resourcesProperties = EMFEditProperties
				.resource(editingService.getEditingDomain());
		IObservableList resourceList = resourcesProperties
				.observe(resourcesResource);
		resourcesTableViewer.setInput(resourceList);

		return bindingContext;
	}

	class NetXResourceObervableMapLabelProvider extends
			ObservableMapLabelProvider {

		public NetXResourceObervableMapLabelProvider(
				IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return super.getColumnImage(element, columnIndex);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof NetXResource) {

				NetXResource resource = (NetXResource) element;
				switch (columnIndex) {
				case 0: {
					if (resource
							.eIsSet(LibraryPackage.Literals.NET_XRESOURCE__COMPONENT_REF)) {
						return resource.getComponentRef().getName();
					} else {
						return "not connected";
					}
				}
				case 1: {
					if (resource
							.eIsSet(LibraryPackage.Literals.NET_XRESOURCE__METRIC_REF)) {
						return resource.getMetricRef().getName();
					} else {
						return null;
					}
				}

				case 5:
					if (resource.getUnitRef() != null) {
						return resource.getUnitRef().getCode();
					}
					break;
				}
			}
			return super.getColumnText(element, columnIndex);
		}
	}

	public void injectData() {
		resourcesResource = editingService
				.getData(LibraryPackage.Literals.NET_XRESOURCE);
		buildUI();
		initDataBindings_();
	}

	public void disposeData() {
		editingService.disposeData(resourcesResource);
	}

	@Override
	public Viewer getViewer() {
		return resourcesTableViewer;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return frmResources;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}

	@Override
	public IAction[] getActions() {
		boolean readonly = Screens.isReadOnlyOperation(this.getOperation());
		String actionText = readonly ? "View..." : "Edit...";

		List<IAction> actionList = Lists.newArrayList();
		actionList.add(new EditResourceAction(actionText, SWT.PUSH));
		actionList.add(new MonitorResourceAction("Monitor...", SWT.PUSH));
		return actionList.toArray(new IAction[actionList.size()]);
	}

}
