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
package com.netxforge.netxstudio.screens.f2;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.ComputedList;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.EresourcePackage;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.screens.LabelTextTableColumnFilter;
import com.netxforge.netxstudio.screens.editing.CDOEditingService;
import com.netxforge.netxstudio.screens.editing.tables.CDOElementComparer;
import com.netxforge.screens.editing.base.IEditingService;
import com.netxforge.screens.editing.base.IScreenFormService;
import com.netxforge.screens.editing.base.filter.TreeSearchFilter;

/**
 * A UI Component for NetXResource objects.
 * 
 * @author Christophe Bouhier
 * 
 */
public class DisconnectedResourcesComponent {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;

	private TreeViewer resourcesTreeViewer;

	private IScreenFormService screenService;
	private IEditingService editingService;

	private Composite resourcesComposite;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	@Inject
	public DisconnectedResourcesComponent() {
	}

	public void configure(IScreenFormService screenService) {
		this.screenService = screenService;
		this.editingService = screenService.getEditingService();
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
				ViewerFilter[] filters = resourcesTreeViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof TreeSearchFilter) {
						((TreeSearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
				resourcesTreeViewer.refresh();
			}
		});

		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);

		resourcesTreeViewer = new TreeViewer(resourcesComposite, SWT.BORDER
				| SWT.VIRTUAL | SWT.MULTI | SWT.FULL_SELECTION);
		Tree tree = resourcesTreeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		resourcesTreeViewer.setUseHashlookup(true);
		resourcesTreeViewer.setComparer(new CDOElementComparer());
		resourcesTreeViewer.addFilter(new TreeSearchFilter(editingService));
		resourcesTreeViewer.addFilter(new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement,
					Object element) {
				if (element instanceof NetXResource) {
					return !((NetXResource) element)
							.eIsSet(LibraryPackage.Literals.NET_XRESOURCE__COMPONENT_REF);
				}
				return true;
			}
		});

		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 4));
		toolkit.paintBordersFor(tree);

		buildColumns();
	}

	private void buildColumns() {
		String[] properties = new String[] { "Container Path",
				"Network Element", "Component", "Metric", "Short Name",
				"Expression Name", "Long Name", "Unit" };

		int[] columnWidths = new int[] { 200, 100, 100, 112, 76, 104, 200, 68 };

		EditingSupport[] editingSupport = new EditingSupport[] { null, null,
				null, null, null, null, null, null };

		buildTreeColumns(properties, columnWidths, editingSupport);
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
	private CDOView view;

	protected void buildTreeColumns(String[] properties, int[] columnWidths,
			EditingSupport[] editingSupport) {

		for (int i = 0; i < properties.length; i++) {

			String property = properties[i];

			TreeViewerColumn viewerColumn = new TreeViewerColumn(
					resourcesTreeViewer, SWT.NONE);
			EditingSupport sup;
			if ((sup = editingSupport[i]) != null) {
				viewerColumn.setEditingSupport(sup);
			}
			TreeColumn tblColumn = viewerColumn.getColumn();
			tblColumn.setText(property);
			tblColumn.setWidth(columnWidths[i]);
			tblColumn.setMoveable(true);

		}
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		ObservableListTreeContentProvider listContentProvider = new ObservableListTreeContentProvider(
				new CDOResourceFactory(editingService.getEditingDomain()),
				new TreeStructureAdvisor() {

				});
		resourcesTreeViewer.setContentProvider(listContentProvider);

		final IObservableSet set = listContentProvider.getKnownElements();

		{
			List<IObservableMap> observeMaps = Lists.newArrayList();

			observeMaps.add(EMFEditProperties.value(
					editingService.getEditingDomain(),
					EresourcePackage.Literals.CDO_RESOURCE__CONTENTS)
					.observeDetail(set));

			// FeaturePath compPath = FeaturePath.fromList(
			// EresourcePackage.Literals.CDO_RESOURCE__CONTENTS,
			// LibraryPackage.Literals.NET_XRESOURCE__COMPONENT_REF);
			// observeMaps.add(EMFEditProperties.value(
			// editingService.getEditingDomain(), compPath).observeDetail(
			// set));
			//
			// observeMaps.add(EMFEditProperties.value(
			// editingService.getEditingDomain(),
			// LibraryPackage.Literals.NET_XRESOURCE__METRIC_REF)
			// .observeDetail(set));
			//
			// observeMaps.add(EMFEditProperties.value(
			// editingService.getEditingDomain(),
			// LibraryPackage.Literals.BASE_RESOURCE__SHORT_NAME)
			// .observeDetail(set));
			// observeMaps.add(EMFEditProperties.value(
			// editingService.getEditingDomain(),
			// LibraryPackage.Literals.BASE_RESOURCE__EXPRESSION_NAME)
			// .observeDetail(set));
			// observeMaps.add(EMFEditProperties.value(
			// editingService.getEditingDomain(),
			// LibraryPackage.Literals.BASE_RESOURCE__LONG_NAME)
			// .observeDetail(set));
			// observeMaps.add(EMFEditProperties.value(
			// editingService.getEditingDomain(),
			// LibraryPackage.Literals.BASE_RESOURCE__UNIT_REF)
			// .observeDetail(set));

			IObservableMap[] map = new IObservableMap[observeMaps.size()];
			observeMaps.toArray(map);
			resourcesTreeViewer.setLabelProvider(new NetXResourceProvider(map));
		}

		// Compute the disconnected resources.
		ComputedList computedResourceList = new ComputedList() {
			@Override
			protected List<Object> calculate() {
				List<NetXResource> updateDisconnectedResources = updateDisconnectedResources();
				List<Object> result = Lists.newArrayList();
				for (NetXResource res : updateDisconnectedResources) {
					Resource eResource = res.eResource();
					if (!result.contains(eResource)) {
						result.add(eResource);
					}
				}
				// result.addAll(updateDisconnectedResources);
				return result;
			}
		};

		resourcesTreeViewer.setInput(computedResourceList);
		resourcesTreeViewer.expandAll();
		return bindingContext;
	}

	/**
	 * Query based retrieval of {@link NetXResource} objects from
	 * {@link IQueryService#getUnconnectedResources(CDOView, String)}
	 * 
	 * @return
	 */
	private List<NetXResource> updateDisconnectedResources() {

		final IQueryService queryService = screenService.getEditingService()
				.getDataService().getQueryService();
		IEditingService editingService = screenService.getEditingService();

		if (editingService instanceof CDOEditingService
				&& ((CDOEditingService) editingService).getView() != null) {
			view = ((CDOEditingService) editingService).getView();
			List<NetXResource> unconnectedResources = queryService
					.getUnconnectedResources(view, IQueryService.QUERY_MYSQL);
			return unconnectedResources;
		}

		return null;
	}

	/**
	 * A Factory for producing {@link IObservable observables} for the content
	 * of a {@link CDOResource}
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class CDOResourceFactory implements IObservableFactory {

		private EditingDomain domain;

		private IEMFListProperty cdoSingleList = EMFEditProperties.list(domain,
				EresourcePackage.Literals.CDO_RESOURCE__CONTENTS);

		public CDOResourceFactory(EditingDomain domain) {
			this.domain = domain;
		}

		public IObservable createObservable(final Object target) {

			IObservable ol = null;
			if (target instanceof IObservableList) {
				ol = (IObservable) target;
			} else

			if (target instanceof CDOResource) {
				ol = cdoSingleList.observe(target);
			}

			return ol;
		}
	}

	class NetXResourceProvider extends ObservableMapLabelProvider {

		/**
		 * A delegator for EMF {@link AdapterFactory}, it is initialized with
		 * the {@link CDOEditingService#getAdapterFactory()}
		 */
		private AdapterFactoryItemDelegator adapterFactoryItemDelegator;

		public NetXResourceProvider(IObservableMap[] attributeMaps) {
			super(attributeMaps);
			adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
					CDOEditingService.getAdapterFactory());
		}

		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex == 0 && element instanceof CDOResource) {
				Object image = adapterFactoryItemDelegator.getImage(element);
				return ExtendedImageRegistry.INSTANCE.getImage(image);
			}
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof CDOResource) {
				if (columnIndex == 0) {
					return ((CDOResource) element).getPath();
				}
			} else if (element instanceof NetXResource) {

				NetXResource resource = (NetXResource) element;
				Component c = null;
				if (resource
						.eIsSet(LibraryPackage.Literals.NET_XRESOURCE__COMPONENT_REF)) {
					c = resource.getComponentRef();
				}

				switch (columnIndex) {

				case 1: {
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
				case 2: {
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
				case 3:
					if (resource
							.eIsSet(LibraryPackage.Literals.NET_XRESOURCE__METRIC_REF)) {
						return resource.getMetricRef().getName();
					} else {
						return null;
					}
				case 4:
					if (resource
							.eIsSet(LibraryPackage.Literals.BASE_RESOURCE__SHORT_NAME)) {
						return resource.getShortName();
					} else {
						return null;
					}
				case 5:
					if (resource
							.eIsSet(LibraryPackage.Literals.BASE_RESOURCE__EXPRESSION_NAME)) {
						return resource.getExpressionName();
					} else {
						return null;
					}
				case 6:
					if (resource.getLongName() != null) {
						return resource.getLongName();
					}
					break;
				case 7:
					if (resource.getUnitRef() != null) {
						return resource.getUnitRef().getCode();
					}
					break;
				}
			}
			return "";
		}
	}

	public Viewer getViewer() {
		return resourcesTreeViewer;
	}

	public Composite getResourcesComposite() {
		return resourcesComposite;
	}

	private final List<IAction> actionList = Lists.newArrayList();

	public IAction[] getActions(int operation) {
		return actionList.toArray(new IAction[actionList.size()]);
	}
}
