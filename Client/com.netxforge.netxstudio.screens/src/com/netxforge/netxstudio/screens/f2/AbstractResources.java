package com.netxforge.netxstudio.screens.f2;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.core.databinding.observable.list.ComputedList;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.cdo.CDOObject;
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
import org.eclipse.wb.swt.TableViewerColumnSorter;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f4.ResourceMonitorScreen;

public abstract class AbstractResources extends AbstractScreen implements
		IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Text txtFilterText;

	private TableViewer resourcesTableViewer;
	private Form frmResources;
	// private Resource resourcesResource;

	private TableViewerColumn tbvcLongName;
	protected List<Resource> resourcesList;
	private TableViewerColumn tbvcCapacity;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public AbstractResources(Composite parent, int style) {
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
		buildResources();
	}

	private void buildResources() {
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

		resourcesTableViewer = new TableViewer(frmResources.getBody(),
				SWT.VIRTUAL | SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		table = resourcesTableViewer.getTable();
		resourcesTableViewer.setUseHashlookup(true);
		resourcesTableViewer.setComparer(new CDOElementComparer());

		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 4));
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		// tableViewerColumn.setLabelProvider(new ColumnLabelProvider() {
		// public Image getImage(Object element) {
		// // TODO Auto-generated method stub
		// return null;
		// }
		// public String getText(Object element) {
		// // TODO Auto-generated method stub
		// return element == null ? "" : element.toString();
		// }
		// });
		new TableViewerColumnSorter(tableViewerColumn) {
			@Override
			protected int doCompare(Viewer viewer, Object e1, Object e2) {
				// TODO Remove this method, if your getValue(Object) returns
				// Comparable.
				// Typical Comparable are String, Integer, Double, etc.
				return super.doCompare(viewer, e1, e2);
			}

			@Override
			protected Object getValue(Object o) {
				// TODO remove this method, if your EditingSupport returns value
				return super.getValue(o);
			}
		};
		
		// Column 0
		TableColumn tblclmnNode = tableViewerColumn.getColumn();
		tblclmnNode.setWidth(100);
		tblclmnNode.setText("Node");

		// Column 1
		TableViewerColumn tbvcOwner = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnOwner = tbvcOwner.getColumn();
		tblclmnOwner.setWidth(100);
		tblclmnOwner.setText("Component");
		
		// Column 2
		TableViewerColumn tbvcMetric = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnMetric = tbvcMetric.getColumn();
		tblclmnMetric.setWidth(112);
		tblclmnMetric.setText("Metric");

		// Column 3
		TableViewerColumn tbvcShortName = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnShortName = tbvcShortName.getColumn();
		tblclmnShortName.setWidth(76);
		tblclmnShortName.setText("Short Name");

		// Column 4
		TableViewerColumn tbvcExpressionName = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnExpression = tbvcExpressionName.getColumn();
		tblclmnExpression.setWidth(104);
		tblclmnExpression.setText("Expression Name");
		
		// Column 5
		tbvcLongName = new TableViewerColumn(resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnState = tbvcLongName.getColumn();
		tblclmnState.setWidth(200);
		tblclmnState.setText("Long Name");
		
		// Column 6
		// Set a fix capacity value. 
		tbvcCapacity = new TableViewerColumn(resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnCapacity = tbvcCapacity.getColumn();
		tblclmnCapacity.setWidth(60);
		tblclmnCapacity.setText("Capacity");
		
		// Column 7
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

				// CB, the parent is the container resource.
				if (o instanceof CDOObject) {
					resourceScreen.injectData(((CDOObject) o).cdoResource(), o);
					screenService.setActiveScreen(resourceScreen);
				}
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

					// TODO, Ask for a time range.
					// TODO, Select the value range.
					MetricValueRange mvr = ((NetXResource) o)
							.getMetricValueRanges().get(0);

					XMLGregorianCalendar start = mvr.getMetricValues().get(0)
							.getTimeStamp();
					XMLGregorianCalendar end = mvr.getMetricValues()
							.get(mvr.getMetricValues().size() - 1)
							.getTimeStamp();

					DateTimeRange timerange = GenericsFactory.eINSTANCE
							.createDateTimeRange();

					timerange.setBegin(start);
					timerange.setEnd(end);

					ResourceMonitorScreen monitorScreen = new ResourceMonitorScreen(
							screenService.getScreenContainer(), SWT.NONE);
					monitorScreen.setOperation(Screens.OPERATION_READ_ONLY);
					monitorScreen.setScreenService(screenService);
					monitorScreen.injectData(null, o, timerange);
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
				LibraryPackage.Literals.BASE_RESOURCE__SHORT_NAME)
				.observeDetail(set));
		observeMaps.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.BASE_RESOURCE__EXPRESSION_NAME)
				.observeDetail(set));
		observeMaps.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.BASE_RESOURCE__LONG_NAME)
				.observeDetail(set));
		observeMaps.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.BASE_RESOURCE__UNIT_REF).observeDetail(
				set));

		IObservableMap[] map = new IObservableMap[observeMaps.size()];
		observeMaps.toArray(map);
		resourcesTableViewer
				.setLabelProvider(new NetXResourceObervableMapLabelProvider(map));

		// IEMFListProperty resourcesProperties = EMFEditProperties
		// .resource(editingService.getEditingDomain());

		// IObservableList resourceList = resourcesProperties
		// .observe(resourcesResource);

		final IEMFListProperty computedProperties = EMFProperties.resource();
		ComputedList computedResourceList = new ComputedList() {
			@SuppressWarnings("unchecked")
			@Override
			protected List<Object> calculate() {
				List<Object> result = Lists.newArrayList();
				for (Resource r : resourcesList) {
					IObservableList observableList = computedProperties
							.observe(r);
					result.addAll(observableList);
				}
				return result;
			}
		};

		resourcesTableViewer.setInput(computedResourceList);

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
				Component c = null;
				if (resource
						.eIsSet(LibraryPackage.Literals.NET_XRESOURCE__COMPONENT_REF)) {

					c = resource.getComponentRef();

				}

				switch (columnIndex) {

				case 0: {
					if (c != null) {
						return modelUtils.resolveParentNode(c).getNodeID();
					} else {
						return "not connected";
					}
				}
				case 1: {
					if (c != null) {
						if (c instanceof Function) {
							return c.getName();
						}
						if (c instanceof Equipment) {
							return ((Equipment) c).getEquipmentCode();
						}
					} else {
						return "not connected";
					}
				}
				case 2:
					if (resource
							.eIsSet(LibraryPackage.Literals.NET_XRESOURCE__METRIC_REF)) {
						return resource.getMetricRef().getName();
					} else {
						return null;
					}
				case 5:
					if (resource.getLongName() != null) {
						return resource.getLongName();
					}
					break;
				case 6:
					Value v = modelUtils.lastCapacityValue(resource);
					if( v != null){
						return new Double(v.getValue()).toString();
					}else{
						return "<not set>";
					}
				case 7:
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

		// CB 31-08-2011, NetXResource is now sliced in own CDO resource by
		// component Hierarchy.
		// resourcesResource = editingService
		// .getData(LibraryPackage.Literals.NET_XRESOURCE);
		buildUI();
		initDataBindings_();
	}

	public void disposeData() {
		// editingService.disposeData(resourcesResource);
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
