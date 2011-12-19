package com.netxforge.netxstudio.screens.f2;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

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
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.TableViewerColumnSorter;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.SearchFilter;
import com.netxforge.netxstudio.screens.TableColumnFilter;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

/**
 * See this for filtering. http://www.eclipsezone.com/eclipse/forums/t63214.html
 * 
 * @author dzonekl
 * 
 */
public abstract class AbstractResources extends AbstractScreen implements
		IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Text txtFilterText;

	protected TableViewer resourcesTableViewer;
	private Form frmResources;
	// private Resource resourcesResource;

	@Inject
	private SearchFilter searchFilter;

	protected List<Resource> resourcesList;

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
		txtFilterText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				ViewerFilter[] filters = resourcesTableViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof SearchFilter) {
						((SearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
				resourcesTableViewer.refresh();
			}
		});

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
		resourcesTableViewer.addFilter(searchFilter);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 4));
		toolkit.paintBordersFor(table);

		buildColumns();
	}

	public abstract void buildColumns();

	class CapacityEditingSupport extends EditingSupport {

		private TableViewer viewer;

		public CapacityEditingSupport(TableViewer viewer) {
			super(viewer);
			this.viewer = viewer;
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			EnterCapacityCellEditor enterCapacityCellEditor = new EnterCapacityCellEditor(
					viewer.getTable());
			enterCapacityCellEditor.setResource((NetXResource) element);
			return enterCapacityCellEditor;
		}

		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		@Override
		protected Object getValue(Object element) {
			if (element instanceof NetXResource) {
				Value v = modelUtils
						.mostRecentCapacityValue((NetXResource) element);

				if (v != null) {
					DecimalFormat numberFormatter = new DecimalFormat(
							"###,###,##0.00");
					numberFormatter.setDecimalSeparatorAlwaysShown(true);
					return numberFormatter.format(v.getValue());
				} else {
					return "<not set>";
				}
			}
			return null;
		}

		@Override
		protected void setValue(Object element, Object value) {
			viewer.update(element, null);
		}

	}

	class EnterCapacityCellEditor extends DialogCellEditor {

		// The last capacity value.
		private NetXResource resource;

		public EnterCapacityCellEditor(Composite parent) {
			super(parent);
		}

		public NetXResource getResource() {
			return resource;
		}

		public void setResource(NetXResource resource) {
			this.resource = resource;
		}

		@Override
		protected Object openDialogBox(Control cellEditorWindow) {

			CapacityEditingDialog capacityEditingDialog = new CapacityEditingDialog(
					cellEditorWindow.getShell(), editingService, modelUtils);
			capacityEditingDialog.setBlockOnOpen(true);
			capacityEditingDialog.injectData(resource);
			int open = capacityEditingDialog.open();
			List<Value> result = capacityEditingDialog.getResult();
			if (open == Window.OK) {
				return result;
			} else {
				return null;
			}
		}

	}

	/**
	 * A Map of filters.
	 */
	Map<String, TableColumnFilter> columnFilters = Maps.newHashMap();

	protected void buildTableColumns(String[] properties, int[] columnWidths,
			EditingSupport[] editingSupport) {

		// final Menu headerMenu = new Menu(shell, SWT.POP_UP);

		for (int i = 0; i < properties.length; i++) {

			String property = properties[i];

			TableViewerColumn viewerColumn = new TableViewerColumn(
					resourcesTableViewer, SWT.NONE);
			EditingSupport sup;
			if ((sup = editingSupport[i]) != null) {
				viewerColumn.setEditingSupport(sup);
			}
			TableColumn tblColumn = viewerColumn.getColumn();
			tblColumn.setText(property);
			tblColumn.setWidth(columnWidths[i]);
			tblColumn.setMoveable(true);

			// Column filtering.
			TableColumnFilter tableColumnFilter = new TableColumnFilter(
					tblColumn);
			columnFilters.put(property, tableColumnFilter);
			resourcesTableViewer.addFilter(tableColumnFilter);

			// Specializations:

			if (property.equals("Capacity")) {
				tblColumn.setAlignment(SWT.RIGHT);
			}
			if (property.equals("Node")) {
				new TableViewerColumnSorter(viewerColumn);
			}

			if (properties[i].equals("Component")) {
				// Inline override the comparer based on the component, as this
				// is a non-editable column.
				new TableViewerColumnSorter(viewerColumn) {
					protected int doCompare(Viewer viewer, Object e1, Object e2) {
						if (e1 instanceof NetXResource
								&& e2 instanceof NetXResource) {

							NetXResource re1 = (NetXResource) e1;
							NetXResource re2 = (NetXResource) e2;

							if (re1.eIsSet(LibraryPackage.Literals.NET_XRESOURCE__COMPONENT_REF)
									&& re2.eIsSet(LibraryPackage.Literals.NET_XRESOURCE__COMPONENT_REF))
								return re1
										.getComponentRef()
										.getName()
										.compareToIgnoreCase(
												re2.getComponentRef().getName());
						}
						return 0;
					}

				};
			}
		}
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
					resourceScreen.injectData(null, o);
					screenService.setActiveScreen(resourceScreen);
				}
			}
		}
	}

	// class MonitorResourceAction extends Action {
	//
	// public MonitorResourceAction(String text, int style) {
	// super(text, style);
	// }
	//
	// @Override
	// public void run() {
	// ISelection selection = getViewer().getSelection();
	// if (selection instanceof IStructuredSelection) {
	// Object o = ((IStructuredSelection) selection).getFirstElement();
	// if (o instanceof NetXResource) {
	//
	// // TODO, Ask for a time range.
	// // TODO, Select the value range.
	// MetricValueRange mvr = ((NetXResource) o)
	// .getMetricValueRanges().get(0);
	//
	// XMLGregorianCalendar start = mvr.getMetricValues().get(0)
	// .getTimeStamp();
	// XMLGregorianCalendar end = mvr.getMetricValues()
	// .get(mvr.getMetricValues().size() - 1)
	// .getTimeStamp();
	//
	// DateTimeRange timerange = GenericsFactory.eINSTANCE
	// .createDateTimeRange();
	//
	// timerange.setBegin(start);
	// timerange.setEnd(end);
	//
	// ResourceMonitorScreen monitorScreen = new ResourceMonitorScreen(
	// screenService.getScreenContainer(), SWT.NONE);
	// monitorScreen.setOperation(Screens.OPERATION_READ_ONLY);
	// monitorScreen.setScreenService(screenService);
	// monitorScreen.injectData(null, o, timerange);
	// screenService.setActiveScreen(monitorScreen);
	// }
	// }
	// }
	// }

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
					NodeType nt = modelUtils.resolveParentNodeType(c);
					if (nt != null) {
						Node n = null;
						if ((n = modelUtils.resolveParentNode(nt)) != null) {
							return n.getNodeID();
						} else {
							return nt.getName();
						}
					}
					return "not connected";
				}
				case 1: {
					if (c != null) {
						if (c instanceof Function) {
							return c.getName();
						}
						if (c instanceof Equipment) {
							Equipment eq = (Equipment) c;
							StringBuffer buf = new StringBuffer();
							buf.append(eq.getEquipmentCode() != null ? eq
									.getEquipmentCode() : "?");
							if (eq.eIsSet(LibraryPackage.Literals.COMPONENT__NAME)) {
								buf.append(" : " + eq.getName());
							}
							return buf.toString();
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
				case 3:
					if (resource
							.eIsSet(LibraryPackage.Literals.BASE_RESOURCE__SHORT_NAME)) {
						return resource.getShortName();
					} else {
						return null;
					}
				case 4:
					if (resource
							.eIsSet(LibraryPackage.Literals.BASE_RESOURCE__EXPRESSION_NAME)) {
						return resource.getExpressionName();
					} else {
						return null;
					}
				case 5:
					if (resource.getLongName() != null) {
						return resource.getLongName();
					}
					break;
				case 6:
					Value v = modelUtils.mostRecentCapacityValue(resource);
					if (v != null) {
						DecimalFormat numberFormatter = new DecimalFormat(
								"###,###,##0.00");
						numberFormatter.setDecimalSeparatorAlwaysShown(true);
						return numberFormatter.format(v.getValue());
					} else {
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

	private final List<IAction> actionList = Lists.newArrayList();

	@Override
	public IAction[] getActions() {
		
		// lazy init the aciton list. 
		if (actionList.isEmpty()) {
			String actionText = Screens.isReadOnlyOperation(this.getOperation()) ? "View..." : "Edit...";
			actionList.add(new EditResourceAction(actionText, SWT.PUSH));
		}

		// actionList.add(new MonitorResourceAction("Monitor...", SWT.PUSH));
		return actionList.toArray(new IAction[actionList.size()]);
	}
}
