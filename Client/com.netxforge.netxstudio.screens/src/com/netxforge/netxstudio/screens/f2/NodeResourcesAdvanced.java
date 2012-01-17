package com.netxforge.netxstudio.screens.f2;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.ComputedList;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.viewers.IViewerObservableList;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.wb.swt.TableViewerColumnSorter;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.SearchFilter;
import com.netxforge.netxstudio.screens.TableColumnFilter;
import com.netxforge.netxstudio.screens.ch9.EmbeddedLineExpression;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.f3.support.NetworkTreeLabelProvider;

/**
 * See this for filtering. http://www.eclipsezone.com/eclipse/forums/t63214.html
 * 
 * @author dzonekl
 * 
 */
public class NodeResourcesAdvanced extends AbstractScreen implements
		IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Form frmResources;

	@Inject
	private SearchFilter searchFilter;

	@Inject
	private ValueComponentII valueComponent;

	@Inject
	private PeriodComponent periodComponent;

	@Inject
	private EmbeddedLineExpression expressionComponent;

	/**
	 * A Map of filters.
	 */
	Map<String, TableColumnFilter> columnFilters = Maps.newHashMap();

	private Composite cmpExpressionHead;

	private ComboViewer cmbViewerNetwork;
	private ComboViewer cmbViewerNode;
	private ComboViewer cmbViewerOperator;
	private ComboViewer cmbViewerExpression;

	private Combo cmbOperator;
	private Combo cmbNetwork;
	private Combo cmbNode;
	private Combo cmbExpression;

	private Label lblOperator;
	private Label lblNetwork;
	private Label lblComponent;
	private Label lblExpression;

	protected TableViewer resourcesTableViewer;
	private Table resourcesTable;

	private Resource operatorResource;
	private NetXResourceObervableMapLabelProvider netXResourceObervableMapLabelProvider;
	private ComputedList resourcesList;
	private Button button;
	private TreeViewer componentsTreeViewer;
	private ComputedList componentsList;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NodeResourcesAdvanced(Composite parent, int style) {
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
		doBuildUI();
	}

	private void doBuildUI() {

		int widgetStyle = SWT.None;
		if (ScreenUtil.isReadOnlyOperation(getOperation())) {
			widgetStyle |= SWT.READ_ONLY;
		}

		// Create the form.
		frmResources = toolkit.createForm(this);
		frmResources.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmResources);
		frmResources.setText("Resources");

		// Body of the form.
		FillLayout fl = new FillLayout();
		frmResources.getBody().setLayout(fl);

		SashForm sashForm = new SashForm(frmResources.getBody(), SWT.VERTICAL);
		sashForm.setLocation(0, 0);
		toolkit.adapt(sashForm);
		toolkit.paintBordersFor(sashForm);

		// A selection mechanism which allows
		// Shows a closure of all belong resources.
		//
		// 1. primary the operator.
		// 2. the network
		// 3.

		buildSelector(widgetStyle, sashForm);
		buildValues(sashForm);

	}

	private void buildSelector(int widgetStyle, Composite parent) {

		Composite cmpComponents = toolkit.createComposite(parent, SWT.NONE);
		GridLayout gl_cmpComponents = new GridLayout(3, false);
		gl_cmpComponents.marginWidth = 5;
		gl_cmpComponents.marginHeight = 2;
		gl_cmpComponents.verticalSpacing = 2;
		cmpComponents.setLayout(gl_cmpComponents);

		// Selector.
		Composite cmpSelector = toolkit
				.createComposite(cmpComponents, SWT.NONE);
		cmpSelector.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false,
				3, 1));
		GridLayout gl_cmpSelector = new GridLayout(4, false);
		gl_cmpSelector.verticalSpacing = 0;
		gl_cmpSelector.marginWidth = 20;
		gl_cmpSelector.marginHeight = 10;
		cmpSelector.setLayout(gl_cmpSelector);

		lblOperator = toolkit.createLabel(cmpSelector, "Operator:", SWT.NONE);
		lblOperator.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		cmbViewerOperator = new ComboViewer(cmpSelector, SWT.NONE);
		cmbOperator = cmbViewerOperator.getCombo();
		GridData gd_cmbOperator = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_cmbOperator.widthHint = 150;
		cmbOperator.setLayoutData(gd_cmbOperator);
		cmbOperator.setBounds(0, 0, 26, 22);
		toolkit.paintBordersFor(cmbOperator);
		new Label(cmpSelector, SWT.NONE);
		toolkit.createLabel(cmpSelector, "");

		lblNetwork = toolkit.createLabel(cmpSelector, "Network:", SWT.NONE);
		lblNetwork.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		cmbViewerNetwork = new ComboViewer(cmpSelector, SWT.NONE);
		cmbNetwork = cmbViewerNetwork.getCombo();
		cmbNetwork.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		toolkit.paintBordersFor(cmbNetwork);
		cmbNetwork.setEnabled(false);
		new Label(cmpSelector, SWT.NONE);
		toolkit.createLabel(cmpSelector, "");

		lblComponent = toolkit
				.createLabel(cmpSelector, "N. Element:", SWT.NONE);
		lblComponent.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		cmbViewerNode = new ComboViewer(cmpSelector, SWT.NONE);
		cmbNode = cmbViewerNode.getCombo();
		cmbNode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));
		toolkit.paintBordersFor(cmbNode);
		cmbNode.setEnabled(false);
		new Label(cmpSelector, SWT.NONE);
		toolkit.createLabel(cmpSelector, "");

		lblExpression = toolkit.createLabel(cmpSelector, "Expression: ",
				SWT.NONE);
		lblExpression.setAlignment(SWT.RIGHT);
		lblExpression.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		cmbViewerExpression = new ComboViewer(cmpSelector, SWT.NONE);
		cmbExpression = cmbViewerExpression.getCombo();
		cmbExpression.add("Utilization");
		cmbExpression.add("Capacity");
		cmbExpression.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO, switch the expression.
			}
		});

		cmbExpression.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		toolkit.paintBordersFor(cmbExpression);

		button = new Button(cmpSelector, SWT.FLAT);
		button.setImage(ResourceManager.getPluginImage(
				"com.netxforge.netxstudio.models.edit",
				"icons/full/obj16/Expression_H.png"));
		button.setAlignment(SWT.LEFT);
		toolkit.adapt(button, true, true);

		cmpExpressionHead = toolkit.createComposite(cmpSelector, SWT.BORDER);
		cmpExpressionHead.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_GRAY));
		GridData gd_cmpExpressionHead = new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1);
		gd_cmpExpressionHead.heightHint = 16;
		cmpExpressionHead.setLayoutData(gd_cmpExpressionHead);

		toolkit.paintBordersFor(cmpExpressionHead);

		GridLayout gl_cmpExpressionHead = new GridLayout(1, false);
		gl_cmpExpressionHead.verticalSpacing = 0;
		gl_cmpExpressionHead.marginWidth = 0;
		gl_cmpExpressionHead.marginHeight = 0;
		cmpExpressionHead.setLayout(gl_cmpExpressionHead);
		expressionComponent.buildExpression(widgetStyle, cmpExpressionHead,
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		expressionComponent.configure(editingService, this.getOperation());

		// SASHFORM FOR COMPONENTS (Left) AND RESOURCES (Left).

		SashForm sashForm = new SashForm(cmpComponents, SWT.HORIZONTAL);
		sashForm.setLocation(0, 0);
		toolkit.adapt(sashForm);
		toolkit.paintBordersFor(sashForm);

		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3,
				1));

		// COMPONENTS TREEVIEWER.

		componentsTreeViewer = new TreeViewer(sashForm, SWT.BORDER
				| SWT.VIRTUAL | SWT.MULTI | widgetStyle);
		Tree tree = componentsTreeViewer.getTree();
		// tree.setSize(74, 81);
		toolkit.paintBordersFor(tree);

		// RESOURCE TABLEVIEWER.

		resourcesTableViewer = new TableViewer(sashForm, SWT.VIRTUAL
				| SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		resourcesTable = resourcesTableViewer.getTable();
		resourcesTableViewer.setUseHashlookup(true);
		resourcesTableViewer.setComparer(new CDOElementComparer());
		resourcesTableViewer.addFilter(searchFilter);
		resourcesTable.setLinesVisible(true);
		resourcesTable.setHeaderVisible(true);

		// resourcesTable.setLayoutData();
		toolkit.paintBordersFor(resourcesTable);

		// WEIGHTDS FOR SASH.
		sashForm.setWeights(new int[] { 3, 7 });

		periodComponent.buildUI(cmpComponents, new GridData(SWT.FILL,
				SWT.CENTER, true, false, 1, 1));

	}

	private void buildValues(SashForm sashForm) {

		valueComponent.configure(screenService);
		valueComponent.buildValuesUI(sashForm, new GridData(SWT.FILL,
				SWT.CENTER, true, false, 1, 1));
	}

	public void buildColumns() {
		String[] properties = new String[] { "Component", "Long Name",
				"Metric", "Expression Name", "Unit" };

		int[] columnWidths = new int[] { 100, 200, 120, 120, 104, 68 };

		// Enable editing support.
		EditingSupport[] editingSupport = new EditingSupport[] { null, null,
				null, null, null, null, null };

		// disable capacity for now.
		// EditingSupport[] editingSupport = new EditingSupport[] { null, null,
		// null, null, null, null,
		// new CapacityEditingSupport(resourcesTableViewer), null };

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

	/*
	 * Column builder.
	 */
	protected void buildTableColumns(String[] properties, int[] columnWidths,
			EditingSupport[] editingSupport) {

		// final Menu headerMenu = new Menu(shell, SWT.POP_UP);

		for (int i = 0; i < properties.length; i++) {

			String property = properties[i];

			TableViewerColumn viewerColumn = new TableViewerColumn(
					resourcesTableViewer, SWT.NONE);

			viewerColumn
					.setLabelProvider(netXResourceObervableMapLabelProvider);

			EditingSupport sup;
			if ((sup = editingSupport[i]) != null) {
				viewerColumn.setEditingSupport(sup);
			}
			TableColumn tblColumn = viewerColumn.getColumn();
			tblColumn.setText(property);
			tblColumn.setWidth(columnWidths[i]);
			tblColumn.setMoveable(true);

			// Column filtering.

			// TODO, filtering disabled for now.
			// TableColumnFilter tableColumnFilter = new TableColumnFilter(
			// tblColumn);
			// columnFilters.put(property, tableColumnFilter);
			// resourcesTableViewer.addFilter(tableColumnFilter);

			// Specializations:

			// if (property.equals("Capacity")) {
			// tblColumn.setAlignment(SWT.RIGHT);
			// }

			// if (property.equals("Node")) {
			// new TableViewerColumnSorter(viewerColumn);
			// }

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

		public EditResourceAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object o = ((IStructuredSelection) selection).getFirstElement();
				NewEditResource resourceScreen = new NewEditResource(
						screenService.getScreenContainer(), SWT.NONE);
				resourceScreen.setOperation(ScreenUtil.OPERATION_EDIT);
				resourceScreen.setScreenService(screenService);

				// CB, the parent is the container resource.
				if (o instanceof CDOObject) {
					resourceScreen.injectData(null, o);
					screenService.setActiveScreen(resourceScreen);
				}
			}
		}
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		bindSelector(bindingContext);
		valueComponent.bindValues();

		buildColumns();
		return bindingContext;
	}

	private void bindSelector(EMFDataBindingContext bindingContext) {

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		cmbViewerOperator.setContentProvider(listContentProvider);
		cmbViewerOperator.setLabelProvider(new AdapterFactoryLabelProvider(
				editingService.getAdapterFactory()));
		IEMFListProperty operatorResourceProperties = EMFProperties.resource();
		cmbViewerOperator.setInput(operatorResourceProperties
				.observe(operatorResource));

		final IViewerObservableValue observeOperatorSelection = ViewersObservables
				.observeSingleSelection(cmbViewerOperator);
		IObservableList operatorsList = new ComputedList() {
			@Override
			protected List<Object> calculate() {
				// When triggered for a new calculation, we have to clear the
				// children.
				cmbNetwork.setText("");
				cmbNode.setText("");
				cmbNode.setEnabled(false);
				cmbViewerNode.setSelection(null);

				List<Object> result = Lists.newArrayList();
				Object value = observeOperatorSelection.getValue();
				if (value instanceof Operator) {
					// closure of all Network objects.
					result.addAll(modelUtils
							.networksForOperator((Operator) value));
				}
				cmbNetwork.setEnabled(!result.isEmpty());
				return result;
			}
		};

		ObservableListContentProvider networksListContentProvider = new ObservableListContentProvider();
		cmbViewerNetwork.setContentProvider(networksListContentProvider);

		cmbViewerNetwork.setLabelProvider(new AdapterFactoryLabelProvider(
				editingService.getAdapterFactory()));
		cmbViewerNetwork.setInput(operatorsList);

		// Compute the closure of all nodes for the selected network.
		final IViewerObservableValue observeNetworkSelection = ViewersObservables
				.observeSingleSelection(cmbViewerNetwork);
		IObservableList nodesList = new ComputedList() {
			@Override
			protected List<Object> calculate() {
				cmbNode.setText("");
				cmbViewerNode.setSelection(null);

				List<Object> result = Lists.newArrayList();
				Object value = observeNetworkSelection.getValue();
				if (value instanceof Network) {
					// closure of all Network objects.
					result.addAll(modelUtils.nodesForNetwork((Network) value));
				}
				cmbNode.setEnabled(!result.isEmpty());
				return result;
			}
		};

		ObservableListContentProvider nodesListContentProvider = new ObservableListContentProvider();
		cmbViewerNode.setContentProvider(nodesListContentProvider);

		cmbViewerNode.setLabelProvider(new AdapterFactoryLabelProvider(
				editingService.getAdapterFactory()));
		cmbViewerNode.setInput(nodesList);

		// NODE SELECTION OBSERVABLE.

		final IViewerObservableValue observeNodeSelection = ViewersObservables
				.observeSingleSelection(cmbViewerNode);

		// BINDING, OF THE COMPONENTS TABLE.

		ObservableListTreeContentProvider cp = new ObservableListTreeContentProvider(
				new ComponentTreeFactoryImpl(editingService.getEditingDomain()),
				new ComponentTreeStructureAdvisorImpl());
		componentsTreeViewer.setContentProvider(cp);
		componentsList = new ComputedList() {
			@Override
			protected List<Object> calculate() {
				List<Object> result = Lists.newArrayList();
				componentsTreeViewer.setSelection(null);
				Object value = observeNodeSelection.getValue();
				if (value instanceof Node) {
					// closure of all Network objects.
					Node n = (Node) value;
					if (n.eIsSet(OperatorsPackage.Literals.NODE__NODE_TYPE)) {
						result.addAll(n.getNodeType().getFunctions());
						result.addAll(n.getNodeType().getEquipments());
					}
				}
				if (result.isEmpty()) {
					System.out.println("no result");
				}
				return result;
			}
		};

		componentsTreeViewer.setLabelProvider(new NetworkTreeLabelProvider());
		componentsTreeViewer.setInput(componentsList);

		// NODE SELECTION OBSERVABLE.
		final IViewerObservableList observeMultipleComponentSelection = ViewersObservables
				.observeMultiSelection(componentsTreeViewer);

		resourcesList = new ComputedList() {
			@Override
			protected List<Object> calculate() {
				List<Object> result = Lists.newArrayList();
				resourcesTableViewer.setSelection(null);
				for (Object value : observeMultipleComponentSelection) {
					if (value instanceof Component) {
						Component c = (Component) value;
						result.addAll(c.getResourceRefs());
					}
				}
				if (result.isEmpty()) {
					System.out.println("no result");
				}
				return result;
			}
		};

		// BINDING, OF THE RESOURCES TABLE.

		ObservableListContentProvider componentsListContentProvider = new ObservableListContentProvider();
		resourcesTableViewer.setContentProvider(componentsListContentProvider);

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
		netXResourceObervableMapLabelProvider = new NetXResourceObervableMapLabelProvider(
				map);
		resourcesTableViewer
				.setLabelProvider(netXResourceObervableMapLabelProvider);
		resourcesTableViewer.setInput(resourcesList);

		final IViewerObservableValue observeResourceSelection = ViewersObservables
				.observeSingleSelection(resourcesTableViewer);

		IObservableValue writableValue = new WritableValue();
		writableValue.addChangeListener(new IChangeListener() {

			public void handleChange(ChangeEvent event) {
				System.out.println(" update resource here. "
						+ event.getSource());
				if (event.getSource() instanceof WritableValue) {
					WritableValue v = (WritableValue) event.getSource();
					Object value = v.getValue();
					if (value instanceof NetXResource) {
						valueComponent.injectData((BaseResource) value);

						NetXResource res = (NetXResource) value;
						Component componentRef = res.getComponentRef();
						if (componentRef != null) {
							Expression capacityExpressionRef = componentRef
									.getCapacityExpressionRef();
							if (capacityExpressionRef != null) {
								System.out.println("Cap expression available");
								expressionComponent
										.injectData(capacityExpressionRef);
							}
						}
						//
					} else {
						valueComponent.injectData(null);
					}
				}

			}
		});
		bindingContext.bindValue(observeResourceSelection, writableValue);

	}

	class ComponentTreeFactoryImpl implements IObservableFactory {

		EditingDomain domain;

		private IEMFListProperty operatorObservableProperty = EMFEditProperties
				.list(domain, OperatorsPackage.Literals.OPERATOR__NETWORKS);

		private IEMFListProperty networkObservableProperty = EMFEditProperties
				.multiList(
						domain,
						OperatorsPackage.Literals.NETWORK__NODES,
						OperatorsPackage.Literals.NETWORK__NETWORKS,
						OperatorsPackage.Literals.NETWORK__EQUIPMENT_RELATIONSHIPS,
						OperatorsPackage.Literals.NETWORK__FUNCTION_RELATIONSHIPS);

		// private IEMFListProperty nodeObservableProperty = EMFEditProperties
		// .list(domain, OperatorsPackage.Literals.NODE__NODE_TYPE);

		private IEMFListProperty nodeObservableProperty = EMFEditProperties
				.multiList(domain, FeaturePath.fromList(
						OperatorsPackage.Literals.NODE__NODE_TYPE,
						LibraryPackage.Literals.NODE_TYPE__FUNCTIONS),
						FeaturePath.fromList(
								OperatorsPackage.Literals.NODE__NODE_TYPE,
								LibraryPackage.Literals.NODE_TYPE__EQUIPMENTS));

		private IEMFListProperty functionsObservableProperty = EMFEditProperties
				.list(domain, LibraryPackage.Literals.FUNCTION__FUNCTIONS);

		private IEMFListProperty equipmentsObservableProperty = EMFEditProperties
				.list(domain, LibraryPackage.Literals.EQUIPMENT__EQUIPMENTS);

		ComponentTreeFactoryImpl(EditingDomain domain) {
			this.domain = domain;
		}

		public IObservable createObservable(final Object target) {

			IObservable ol = null;

			if (target instanceof IObservableList) {
				ol = (IObservable) target;
			} else if (target instanceof Operator) {
				ol = operatorObservableProperty.observe(target);
			} else if (target instanceof Network) {
				ol = networkObservableProperty.observe(target);
			} else if (target instanceof Node) {
				ol = nodeObservableProperty.observe(target);
			}

			// else if (target instanceof NodeType) {
			// ol = nodeTypeObservableProperty.observe(target);
			// }

			else if (target instanceof Function) {
				ol = functionsObservableProperty.observe(target);
			} else if (target instanceof Equipment) {
				ol = equipmentsObservableProperty.observe(target);
			}
			return ol;
		}
	}

	class ComponentTreeStructureAdvisorImpl extends TreeStructureAdvisor {
		@Override
		public Object getParent(Object element) {

			if (element instanceof EObject) {
				EObject eo = (EObject) element;
				if (eo.eContainer() != null) {
					return eo.eContainer();
				}
			}
			return null;
		}

		@Override
		public Boolean hasChildren(Object element) {

			if (element instanceof Operator) {
				return ((Operator) element).getNetworks().size() > 0 ? Boolean.TRUE
						: null;
			} else if (element instanceof Network) {
				Network net = (Network) element;
				if (net.getNetworks().size() > 0 || net.getNodes().size() > 0
						|| net.getEquipmentRelationships().size() > 0
						|| net.getFunctionRelationships().size() > 0) {
					return Boolean.TRUE;
				} else {
					return null;
				}
			} else if (element instanceof Node) {
				Node n = (Node) element;
				if (n.getNodeType() != null) {
					return Boolean.TRUE;
				} else {
					return null;
				}
			} else

			if (element instanceof NodeType) {
				if (((NodeType) element).getFunctions().size() > 0
						|| ((NodeType) element).getEquipments().size() > 0) {
					return Boolean.TRUE;
				}
				return Boolean.FALSE;
			} else if (element instanceof Function) {
				if (((Function) element).getFunctions().size() > 0) {
					return Boolean.TRUE;
				} else {
					return null;
				}
			} else if (element instanceof Equipment) {
				if (((Equipment) element).getEquipments().size() > 0) {
					return Boolean.TRUE;
				} else {
					return null;
				}
			}
			return super.hasChildren(element);
		}
	}

	class NetXResourceObervableMapLabelProvider extends CellLabelProvider {

		public NetXResourceObervableMapLabelProvider(
				IObservableMap[] attributeMaps) {
		}

		@Override
		public void update(ViewerCell cell) {
			Object element = cell.getElement();
			int columnIndex = cell.getColumnIndex();
			if (element instanceof NetXResource) {

				final NetXResource resource = (NetXResource) element;
				Component c = null;
				if (resource
						.eIsSet(LibraryPackage.Literals.NET_XRESOURCE__COMPONENT_REF)) {

					c = resource.getComponentRef();

				}
				String result = null;
				switch (columnIndex) {

				// case 0: {
				// NodeType nt = modelUtils.resolveParentNodeType(c);
				// if (nt != null) {
				// Node n = null;
				// if ((n = modelUtils.resolveParentNode(nt)) != null) {
				// return n.getNodeID();
				// } else {
				// return nt.getName();
				// }
				// }
				// return "not connected";
				// }
				case 0: {
					if (c != null) {
						if (c instanceof Function) {
							result = c.getName();
						}
						if (c instanceof Equipment) {
							Equipment eq = (Equipment) c;
							StringBuffer buf = new StringBuffer();
							buf.append(eq.getEquipmentCode() != null ? eq
									.getEquipmentCode() : "?");
							if (eq.eIsSet(LibraryPackage.Literals.COMPONENT__NAME)) {
								buf.append(" : " + eq.getName());
							}
							result = buf.toString();
						}
					} else {
						result = "not connected";
					}
				}
					break;
				case 1:
					if (resource.getLongName() != null) {
						result = resource.getLongName();
					}
					break;

				case 2:
					if (resource
							.eIsSet(LibraryPackage.Literals.NET_XRESOURCE__METRIC_REF)) {
						result = resource.getMetricRef().getName();
					}
					break;
				// case 3:
				// if (resource
				// .eIsSet(LibraryPackage.Literals.BASE_RESOURCE__SHORT_NAME)) {
				// result = resource.getShortName();
				// }
				// break;
				case 3:
					if (resource
							.eIsSet(LibraryPackage.Literals.BASE_RESOURCE__EXPRESSION_NAME)) {
						result = resource.getExpressionName();
					}
					break;
				// case 5:
				// Value v = modelUtils.mostRecentCapacityValue(resource);
				// if (v != null) {
				// DecimalFormat numberFormatter = new DecimalFormat(
				// "###,###,##0.00");
				// numberFormatter.setDecimalSeparatorAlwaysShown(true);
				// return numberFormatter.format(v.getValue());
				// } else {
				// return "<not set>";
				// }
				case 4:
					if (resource.getUnitRef() != null) {
						result = resource.getUnitRef().getCode();
					}
					break;
				}
				if (result != null) {
					cell.setText(result);
				}
			}
		}
	}

	public void injectData() {

		operatorResource = editingService
				.getData(OperatorsPackage.Literals.OPERATOR);

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
	public String getScreenName() {
		return "Resources";
	}

	@Override
	public IAction[] getActions() {
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		String actionText = readonly ? "View..." : "Edit...";

		List<IAction> actionList = Lists.newArrayList();
		actionList.add(new EditResourceAction(actionText));
		// actionList.add(new MonitorResourceAction("Monitor...", SWT.PUSH));
		return actionList.toArray(new IAction[actionList.size()]);
	}
}
