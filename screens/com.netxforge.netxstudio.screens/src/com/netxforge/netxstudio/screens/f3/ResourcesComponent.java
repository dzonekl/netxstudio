/*******************************************************************************
 * Copyright (c) Oct 22, 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.f3;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.list.ComputedList;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.util.ObjectNotFoundException;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.TableViewerColumnSorter;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.screens.FunctionLabelTextTableColumnFilter;
import com.netxforge.netxstudio.screens.LabelTextTableColumnFilter;
import com.netxforge.netxstudio.screens.f2.CapacityEditingDialog;
import com.netxforge.screens.editing.base.IScreenFormService;
import com.netxforge.screens.editing.base.filter.SearchFilter;

/**
 * A UI Component for NetXResource objects. It can be injected with a
 * 
 * @author Christophe Bouhier
 * 
 */
public class ResourcesComponent {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Text txtFilterText;
	private TableViewer resourcesTableViewer;

	@Inject
	private SearchFilter searchFilter;
	private IScreenFormService screenService;
	private Composite resourcesComposite;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	@Inject
	public ResourcesComponent() {
	}

	public void configure(IScreenFormService screenService) {
		this.screenService = screenService;
	}

	/**
	 * Build this component. The layoutData is optional, won't be set if null.
	 * 
	 * @param parent
	 * @param layoutData
	 */
	public void buildUI(Composite parent, Object layoutData) {

		// A place holder with 3 columns.
		resourcesComposite = toolkit.createComposite(parent, SWT.NONE);
		if (layoutData != null) {
			resourcesComposite.setLayoutData(layoutData);
		}
		toolkit.adapt(resourcesComposite);
		GridLayout gridLayout = new GridLayout(2, false);
		resourcesComposite.setLayout(gridLayout);

		Label lblFilterLabel = toolkit.createLabel(resourcesComposite,
				"Filter:", SWT.NONE);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 44;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(resourcesComposite, "New Text",
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

		// CB Temporarly disable virtual and hashlookup.
		resourcesTableViewer = new TableViewer(resourcesComposite, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.MULTI);
		table = resourcesTableViewer.getTable();
		// resourcesTableViewer.setUseHashlookup(true);
		// resourcesTableViewer.setComparer(new CDOElementComparer());
		resourcesTableViewer.addFilter(searchFilter);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 4));
		toolkit.paintBordersFor(table);

		buildColumns();
	}

	private void buildColumns() {
		final String[] properties = new String[] { "Network Element", "Component",
				"Metric", "Short Name", "Expression Name", "Long Name", "Unit" };

		final int[] columnWidths = new int[] { 100, 100, 112, 76, 104, 200, 68 };

		final EditingSupport[] editingSupport = new EditingSupport[] { null, null,
				null, null, null, null, null };

		buildTableColumns(properties, columnWidths, editingSupport);
	}

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
				Value v = StudioUtils
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
					cellEditorWindow.getShell(),
					screenService.getEditingService());
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
	Map<String, LabelTextTableColumnFilter> columnFilters = Maps.newHashMap();

	protected void buildTableColumns(String[] properties, int[] columnWidths,
			EditingSupport[] editingSupport) {

		// final Menu headerMenu = new Menu(shell, SWT.POP_UP);

		for (int i = 0; i < properties.length; i++) {

			final String property = properties[i];

			final TableViewerColumn viewerColumn = new TableViewerColumn(
					resourcesTableViewer, SWT.NONE);
			EditingSupport sup;
			if ((sup = editingSupport[i]) != null) {
				viewerColumn.setEditingSupport(sup);
			}
			final TableColumn tblColumn = viewerColumn.getColumn();
			tblColumn.setText(property);
			tblColumn.setWidth(columnWidths[i]);
			tblColumn.setMoveable(true);

			// Column filtering.
			FunctionLabelTextTableColumnFilter tableColumnFilter = new FunctionLabelTextTableColumnFilter(
					tblColumn);
			tableColumnFilter
					.setFilterFunction(new com.google.common.base.Function<CDOObject, Boolean>() {

						public Boolean apply(CDOObject from) {
							if (from instanceof NetXResource) {
								NetXResource netXResource = (NetXResource) from;
								boolean result = !netXResource
										.eIsSet(LibraryPackage.Literals.NET_XRESOURCE__COMPONENT_REF);
								return result;
							}
							return false;
						}

					});
			columnFilters.put(property, tableColumnFilter);
			resourcesTableViewer.addFilter(tableColumnFilter);

			// Specializations:

			if (property.equals("Capacity")) {
				tblColumn.setAlignment(SWT.RIGHT);
			}
			if (property.equals("Node")) {
				new TableViewerColumnSorter(viewerColumn);
			}

			if (property.equals("Component")) {
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

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		resourcesTableViewer.setContentProvider(listContentProvider);

		List<IObservableMap> observeMaps = Lists.newArrayList();
		IObservableSet set = listContentProvider.getKnownElements();

		observeMaps.add(EMFEditProperties.value(
				screenService.getEditingService().getEditingDomain(),
				LibraryPackage.Literals.NET_XRESOURCE__COMPONENT_REF)
				.observeDetail(set));

		observeMaps.add(EMFEditProperties.value(
				screenService.getEditingService().getEditingDomain(),
				LibraryPackage.Literals.NET_XRESOURCE__METRIC_REF)
				.observeDetail(set));

		observeMaps.add(EMFEditProperties.value(
				screenService.getEditingService().getEditingDomain(),
				LibraryPackage.Literals.BASE_RESOURCE__SHORT_NAME)
				.observeDetail(set));
		observeMaps.add(EMFEditProperties.value(
				screenService.getEditingService().getEditingDomain(),
				LibraryPackage.Literals.BASE_RESOURCE__EXPRESSION_NAME)
				.observeDetail(set));
		observeMaps.add(EMFEditProperties.value(
				screenService.getEditingService().getEditingDomain(),
				LibraryPackage.Literals.BASE_RESOURCE__LONG_NAME)
				.observeDetail(set));
		observeMaps.add(EMFEditProperties.value(
				screenService.getEditingService().getEditingDomain(),
				LibraryPackage.Literals.BASE_RESOURCE__UNIT_REF).observeDetail(
				set));

		IObservableMap[] map = new IObservableMap[observeMaps.size()];
		observeMaps.toArray(map);
		resourcesTableViewer
				.setLabelProvider(new NetXResourceObervableMapLabelProvider(map));

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
					NodeType nt = StudioUtils.resolveParentNodeType(c);
					if (nt != null) {
						Node n = null;
						if ((n = StudioUtils.nodeFor(nt)) != null) {
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
				// case 6:
				// Value v = modelUtils.mostRecentCapacityValue(resource);
				// if (v != null) {
				// DecimalFormat numberFormatter = new DecimalFormat(
				// "###,###,##0.00");
				// numberFormatter.setDecimalSeparatorAlwaysShown(true);
				// return numberFormatter.format(v.getValue());
				// } else {
				// return "<not set>";
				// }
				case 6:
					if (resource.getUnitRef() != null) {
						return resource.getUnitRef().getCode();
					}
					break;
				}
			}
			return super.getColumnText(element, columnIndex);
		}
	}
	
	
	/**
	 * Inject our components with CDO Resources which should hold NetXResource objects. 
	 * Note that, the any other object contained in the CDO Resource, will be dealt with by the 
	 * content provider of the viewer.   
	 * 
	 * @param bind
	 * @param cdoResources
	 */
	public void injectDataWithCDOResources(boolean bind, final List<Resource> cdoResources) {
		
		if (bind) {
			initDataBindings_();
		}
		
		final IEMFListProperty computedProperties = EMFEditProperties
				.resource(screenService.getEditingService().getEditingDomain());
		
		ComputedList computedResourceList = new ComputedList() {
			@SuppressWarnings("unchecked")
			@Override
			protected List<Object> calculate() {
				List<Object> result = Lists.newArrayList();
				for (Resource r : cdoResources) {
					IObservableList observableList = computedProperties
							.observe(r);
					result.addAll(observableList);
				}
				return result;
			}
		};
		resourcesTableViewer.setInput(computedResourceList);

	}

	/**
	 * 
	 * @param bind
	 *            Force initializing of bindings.
	 * @param unconnectedResources
	 */
	public void injectData(boolean bind,
			final List<NetXResource> unconnectedResources) {

		if (bind) {
			initDataBindings_();
		}

		final IEMFListProperty computedProperties = EMFEditProperties
				.resource(screenService.getEditingService().getEditingDomain());
		ComputedList computedResourceList = new ComputedList() {
			@SuppressWarnings("unchecked")
			@Override
			protected List<Object> calculate() {
				List<Object> result = Lists.newArrayList();

				// Make sure we don't observe the same CDO Resource twice.
				List<String> observingResources = Lists.newArrayList();

				for (int i = 0; i < unconnectedResources.size(); i++) {

					try {
						NetXResource netXResource = unconnectedResources.get(i);

						CDOResource cdoRes = netXResource.cdoResource();
						if (cdoRes != null
								&& !observingResources.contains(cdoRes.getURI()
										.toString())) {

							observingResources.add(cdoRes.getURI().toString());
							IObservableList observableList = computedProperties
									.observe(netXResource.cdoResource());
							result.addAll(observableList);

						}
					} catch (ObjectNotFoundException onf) {
						// skip, this is a CDO bug, objects are not really
						// deleted,
						// the query returns a through result.
						// Could also add: and cdo_version > 0; in the
						// query.
					}
				}
				return result;
			}
		};

		resourcesTableViewer.setInput(computedResourceList);

	}

	public Viewer getViewer() {
		return resourcesTableViewer;
	}

	public Composite getResourcesComposite() {
		return resourcesComposite;
	}

	private final List<IAction> actionList = Lists.newArrayList();

	public IAction[] getActions(int operation) {

		// lazy init the aciton list.
		// if (actionList.isEmpty()) {
		// String actionText = ScreenUtil.isReadOnlyOperation(operation) ?
		// "View..."
		// : "Edit...";
		// actionList.add(new EditResourceAction(actionText));
		// }

		// actionList.add(new MonitorResourceAction("Monitor...", SWT.PUSH));
		return actionList.toArray(new IAction[actionList.size()]);
	}
}
