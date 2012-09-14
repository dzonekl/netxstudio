package com.netxforge.netxstudio.screens.f2;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.ComputedList;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
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
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
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
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.ISaveablePart2;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.part.ShowInContext;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.netxforge.engine.IExpressionEngine;
import com.netxforge.interpreter.IInterpreterContext;
import com.netxforge.netxstudio.common.guice.IInjectorProxy;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.importer.ResultProcessor;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.ScreenDialog;
import com.netxforge.netxstudio.screens.SearchFilter;
import com.netxforge.netxstudio.screens.TableColumnFilter;
import com.netxforge.netxstudio.screens.ch9.ObjectExpressions;
import com.netxforge.netxstudio.screens.common.tables.CopyFeatureCommand.FeatureInitializer;
import com.netxforge.netxstudio.screens.common.tables.FocusBlockOwnerDrawHighlighterForMultiselection;
import com.netxforge.netxstudio.screens.common.tables.FocusColumnToModelMap;
import com.netxforge.netxstudio.screens.common.tables.OpenTreeViewer;
import com.netxforge.netxstudio.screens.common.tables.TableHelper;
import com.netxforge.netxstudio.screens.common.tables.TreeViewerFocusBlockManager;
import com.netxforge.netxstudio.screens.dialog.ToleranceFilterDialog;
import com.netxforge.netxstudio.screens.editing.actions.BaseSelectionListenerAction;
import com.netxforge.netxstudio.screens.editing.actions.SeparatorAction;
import com.netxforge.netxstudio.screens.editing.actions.WizardUtil;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.f1.support.ReportWizard;
import com.netxforge.netxstudio.screens.f3.NetworkViewerComparator;
import com.netxforge.netxstudio.screens.f3.support.NetworkTreeLabelProvider;
import com.netxforge.netxstudio.screens.showins.ChartShowInContext;
import com.netxforge.netxstudio.screens.xtext.embedded.EmbeddedLineExpression;

/**
 * See this for filtering. http://www.eclipsezone.com/eclipse/forums/t63214.html
 * 
 * @author dzonekl
 * 
 */
public class NodeResourcesAdvanced extends AbstractScreen implements
		IDataServiceInjection {

	/*
	 * Memento keys.
	 */
	private static final String MEM_KEY_NODERESOURCEADVANCED_SEPARATOR_VERTICAL = "MEM_KEY_NODERESOURCESADVANCED_SEPARATOR_VERTICAL";

	private static final String MEM_KEY_NODERESOURCEADVANCED_SEPARATOR_DATA = "MEM_KEY_NODERESOURCESADVANCED_SEPARATOR_DATA";

	private static final String MEM_KEY_NODERESOURCEADVANCED_SELECTION_NETWORK = "MEM_KEY_NODERESOURCESADVANCED_SELECTION_NETWORK";

	private static final String MEM_KEY_NODERESOURCEADVANCED_SELECTION_NODE = "MEM_KEY_NODERESOURCESADVANCED_SELECTION_NODE";

	private static final String MEM_KEY_NODERESOURCEADVANCED_SELECTION_COMPONENT = "MEM_KEY_NODERESOURCEADVANCED_SELECTION_COMPONENT";

	private static final String MEM_KEY_NODERESOURCEADVANCED_SELECTION_RESOURCE = "MEM_KEY_NODERESOURCEADVANCED_SELECTION_RESOURCE";

	private static final String MEM_KEY_NODERESOURCEADVANCED_PERIOD_FROM = "MEM_KEY_NODERESOURCEADVANCED_PERIOD_FROM";

	private static final String MEM_KEY_NODERESOURCEADVANCED_PERIOD_TO = "MEM_KEY_NODERESOURCEADVANCED_PERIOD_TO";

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Form frmResources;

	@Inject
	private TableHelper tableHelper;

	@Inject
	private SearchFilter searchFilter;

	@Inject
	private ValueComponentII cmpValues;

	@Inject
	private PeriodComponent periodComponent;

	@Inject
	private EmbeddedLineExpression expressionComponent;

	@Inject
	private ExpressionSupport expressionSupport;

	@Inject
	@Named("Netxscript")
	private IInjectorProxy injectorProxy;

	// Delegated injection.
	private Injector nextscriptInjector = injectorProxy
			.getInjector("com.netxforge.Netxscript");

	private IExpressionEngine expressionEngine = nextscriptInjector
			.getInstance(IExpressionEngine.class);

	private ResultProcessor resultProcessor = nextscriptInjector
			.getInstance(ResultProcessor.class);

	/**
	 * A Map of filters.
	 */
	Map<String, TableColumnFilter> columnFilters = Maps.newHashMap();

	private Composite cmpExpressionEditor;

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

	private CDOResource operatorResource;
	private NetXResourceObervableMapLabelProvider netXResourceObervableMapLabelProvider;

	private Button btnExpressionTest;

	protected TableViewer resourcesTableViewer;
	private Table resourcesTable;

	private OpenTreeViewer componentsTreeViewer;
	// private Composite cmpExpressionContext;

	private ComputedList computedResourcesList;
	private ComputedList computedExpressionFeaturesList;

	private ExpressionAggregate expressionAggregate;
	private ContextAggregate contextAggregate;

	private IViewerObservableValue observeSingleComponentSelection;
	private IViewerObservableValue observeResourceSingleSelection;
	private WritableValue periodBeginWritableValue;
	private WritableValue periodEndWritableValue;
	private Composite cmpExpression;
	private Composite cmpSubSelector;
	private IViewerObservableValue observeNodeSelection;
	private Tree componentsTree;
	private SashForm sashVertical;
	private SashForm sashData;

	private boolean readOnly;

	private int widgetStyle;

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

		// Readonlyness.
		readOnly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		widgetStyle = readOnly ? SWT.READ_ONLY : SWT.NONE;

		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Create the form.
		frmResources = toolkit.createForm(this);
		frmResources.setSeparatorVisible(true);

		frmResources.setText(this.getOperationText() + "Resources");
		frmResources.getToolBarManager().add(new showContextAction("Context"));
		frmResources.getToolBarManager().update(true);
		frmResources.setToolBarVerticalAlignment(SWT.TOP);

		periodComponent.buildUI(frmResources.getHead(), null);

		frmResources.setHeadClient(periodComponent.getCmpPeriod());

		toolkit.decorateFormHeading(frmResources);
		toolkit.paintBordersFor(frmResources);

		// Body of the form.
		FillLayout fl = new FillLayout();
		frmResources.getBody().setLayout(fl);

		sashVertical = new SashForm(frmResources.getBody(), SWT.VERTICAL);
		sashVertical.setSashWidth(3);
		toolkit.adapt(sashVertical);
		toolkit.paintBordersFor(sashVertical);

		// Demo code constraint for minimum.
		// Control[] comps = sashVertical.getChildren();
		// for (Control comp : comps) {
		// if (comp instanceof Sash) {
		//
		// final int SASH_LIMIT = 200;
		// final Sash sash = (Sash)comp;
		//
		// sash.addSelectionListener(new SelectionAdapter() {
		// public void widgetSelected(SelectionEvent event) {
		// Rectangle rect = sash.getParent().getClientArea();
		// event.x = Math.min(Math.max(event.x, SASH_LIMIT),
		// rect.width - SASH_LIMIT);
		// if (event.detail != SWT.DRAG) {
		// sash.setBounds(event.x, event.y, event.width,
		// event.height);
		// sashVertical.layout();
		// }
		// }
		// });
		// }
		// }

		sashVertical.addDragDetectListener(new DragDetectListener() {

			public void dragDetected(DragDetectEvent e) {
				System.out.println(e.x + e.y);
			}

		});

		Composite cmpRoot = toolkit.createComposite(sashVertical, SWT.NONE);
		GridLayout gl_cmpRoot = new GridLayout(2, false);
		gl_cmpRoot.marginLeft = 10;
		gl_cmpRoot.marginHeight = 5;
		gl_cmpRoot.marginRight = 5;
		// gl_cmpRoot.verticalSpacing = 10;
		cmpRoot.setLayout(gl_cmpRoot);

		GridData gdCompSelector = new GridData(SWT.LEFT, SWT.TOP, false, false,
				1, 1);
		buildComponentSelector(cmpRoot, gdCompSelector);
		buildExpressionSelector(cmpRoot, new GridData(SWT.FILL, SWT.FILL, true,
				true));

		sashData = new SashForm(sashVertical, SWT.HORIZONTAL);
		sashData.setSashWidth(5);
		toolkit.adapt(sashData);
		toolkit.paintBordersFor(sashData);

		sashData.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2,
				1));

		buildComponentViewer(sashData, null);
		buildResourceViewer(sashData);
		buildValues(sashData);

		// WEIGHTS FOR SASH.
		sashVertical.setWeights(new int[] { 1, 9 });
		sashData.setWeights(new int[] { 3, 5, 5 });

	}

	private void buildResourceViewer(SashForm sashComponentResources) {
		resourcesTableViewer = new TableViewer(sashComponentResources,
				SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		resourcesTable = resourcesTableViewer.getTable();
		// Bug having virtual with hashlookup etc...
		// resourcesTableViewer.setUseHashlookup(true);
		// resourcesTableViewer.setComparer(new CDOElementComparer());
		resourcesTableViewer.addFilter(searchFilter);
		resourcesTable.setLinesVisible(true);
		resourcesTable.setHeaderVisible(true);
		toolkit.paintBordersFor(resourcesTable);

		buildResourcesColumns();
	}

	private void buildComponentViewer(SashForm parent,
			GridData gd_componentsTreeViewer) {
		// COMPONENTS TREEVIEWER.

		componentsTreeViewer = new OpenTreeViewer(parent, SWT.BORDER
				| SWT.MULTI | widgetStyle);
		componentsTreeViewer.setUseHashlookup(true);
		componentsTreeViewer.setComparer(new CDOElementComparer());
		// CB http://work.netxforge.com/issues/290
		componentsTreeViewer.setComparator(new NetworkViewerComparator());
		
		componentsTree = componentsTreeViewer.getTree();
		componentsTree.setHeaderVisible(true);
		componentsTree.setLinesVisible(true);
		
		if (gd_componentsTreeViewer != null) {
			componentsTree.setLayoutData(gd_componentsTreeViewer);
		}

		toolkit.paintBordersFor(componentsTree);

		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(
				componentsTreeViewer, SWT.NONE);
		TreeColumn trclmnCountry = treeViewerColumn.getColumn();
		trclmnCountry.setWidth(200);
		trclmnCountry.setText("Component");
		
		
		// TreeViewerColumn treeViewerColumn_2 = new TreeViewerColumn(
		// componentsTreeViewer, SWT.NONE);
		// TreeColumn trclmnSite = treeViewerColumn_2.getColumn();
		// trclmnSite.setWidth(100);
		// trclmnSite.setText("Resource");

		TreeViewerColumn treeViewerColumn_1 = new TreeViewerColumn(
				componentsTreeViewer, SWT.NONE);
		TreeColumn trclmnName = treeViewerColumn_1.getColumn();
		trclmnName.setWidth(30);
		trclmnName.setText("Cap.");

		TreeViewerColumn treeViewerUtilization = new TreeViewerColumn(
				componentsTreeViewer, SWT.NONE);
		TreeColumn trclmnUtilization = treeViewerUtilization.getColumn();
		trclmnUtilization.setWidth(30);
		trclmnUtilization.setText("Util.");
		
		
		TreeViewerColumn treeViewerTolerance = new TreeViewerColumn(
				componentsTreeViewer, SWT.NONE);
		TreeColumn trclmnTolerance = treeViewerTolerance.getColumn();
		trclmnTolerance.setWidth(30);
		trclmnTolerance.setText("Tol.");
		

		// Multi cell focus block selection, with drag copy action build in.
		FocusBlockOwnerDrawHighlighterForMultiselection fcHighlighter = new FocusBlockOwnerDrawHighlighterForMultiselection(
				componentsTreeViewer);

		// instantiate it, it will hook listeners.
		TreeViewerFocusBlockManager treeViewerFocusBlockManager = new TreeViewerFocusBlockManager(
				componentsTreeViewer, fcHighlighter);
		treeViewerFocusBlockManager.setEditingDomain(this.getEditingService()
				.getEditingDomain());

		FocusColumnToModelMap focusColumnToModelMap = new FocusColumnToModelMap();
		focusColumnToModelMap.getColumnFeatureMap().put(1,
				LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF);
		focusColumnToModelMap.getColumnFeatureMap().put(2,
				LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF);

		treeViewerFocusBlockManager.setFeatureMap(focusColumnToModelMap);
		treeViewerFocusBlockManager
				.setFeatureInitializer(new ExpressionInitializer());

		// We shall set a target for the copied object if non-containment.
		Resource expressionsResource = editingService
				.getData(LibraryPackage.Literals.EXPRESSION);

		treeViewerFocusBlockManager
				.setTargetResourceForNonContainment(expressionsResource);

	}

	/*
	 * The copied expression will need to have a generated name set.
	 */
	class ExpressionInitializer extends FeatureInitializer {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.netxforge.netxstudio.screens.common.tables.CopyFeatureCommand
		 * .FeatureInitializer#initialize(java.lang.Object)
		 */
		@Override
		public void initialize(Object owner, Object copy,
				EStructuralFeature feature) {
			if (owner instanceof Component && copy instanceof Expression) {
				String name = getExpressionName((Component) owner, feature);
				Expression copiedExpression = (Expression) copy;
				copiedExpression.setName(name);
			}
		}

	}

	private void buildComponentSelector(Composite parent, GridData gridData) {
		// Selector.
		Composite cmpComponentSelector = toolkit.createComposite(parent,
				SWT.NONE);

		cmpComponentSelector.setLayoutData(gridData);
		GridLayout gl_cmpSelector = new GridLayout(2, false);
		gl_cmpSelector.verticalSpacing = 0;
		gl_cmpSelector.marginWidth = 0;
		gl_cmpSelector.marginHeight = 0;
		cmpComponentSelector.setLayout(gl_cmpSelector);

		lblOperator = toolkit.createLabel(cmpComponentSelector, "Operator:",
				SWT.NONE);
		lblOperator.setAlignment(SWT.RIGHT);
		GridData gd_lblOperator = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblOperator.widthHint = 70;
		lblOperator.setLayoutData(gd_lblOperator);

		cmbOperator = new Combo(cmpComponentSelector, SWT.READ_ONLY);
		cmbViewerOperator = new ComboViewer(cmbOperator);

		cmbOperator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		toolkit.paintBordersFor(cmbOperator);

		lblNetwork = toolkit.createLabel(cmpComponentSelector, "Network:",
				SWT.NONE);
		lblNetwork.setAlignment(SWT.RIGHT);
		GridData gd_lblNetwork = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNetwork.widthHint = 70;
		lblNetwork.setLayoutData(gd_lblNetwork);

		cmbNetwork = new Combo(cmpComponentSelector, SWT.READ_ONLY);
		cmbViewerNetwork = new ComboViewer(cmbNetwork);
		cmbViewerNetwork.setComparer(new CDOElementComparer());

		cmbNetwork.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		toolkit.paintBordersFor(cmbNetwork);
		cmbNetwork.setEnabled(false);

		lblComponent = toolkit.createLabel(cmpComponentSelector, "N. Element:",
				SWT.NONE);
		lblComponent.setAlignment(SWT.RIGHT);

		cmbNode = new Combo(cmpComponentSelector, SWT.READ_ONLY);
		cmbViewerNode = new ComboViewer(cmbNode);
		cmbNode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		toolkit.paintBordersFor(cmbNode);
	}

	private void buildExpressionSelector(Composite cmpComponents,
			GridData gridData) {

		cmpExpression = toolkit.createComposite(cmpComponents, SWT.NONE);

		cmpExpression.setLayoutData(gridData);

		// a grid layout with 3 columns.
		GridLayout gl_cmpExpression = new GridLayout(3, false);
		gl_cmpExpression.marginHeight = 0;
		gl_cmpExpression.marginWidth = 0;
		cmpExpression.setLayout(gl_cmpExpression);

		cmbExpression = new Combo(cmpExpression, SWT.READ_ONLY);
		cmbViewerExpression = new ComboViewer(cmbExpression);
		GridData gd_cmbExpression = new GridData(SWT.LEFT, SWT.TOP, false,
				false, 1, 1);
		gd_cmbExpression.widthHint = 145;
		cmbExpression.setLayoutData(gd_cmbExpression);

		toolkit.paintBordersFor(cmbExpression);

		btnExpressionTest = new Button(cmpExpression, SWT.FLAT);
		btnExpressionTest.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false,
				false, 1, 1));
		btnExpressionTest.setImage(ResourceManager.getPluginImage(
				"com.netxforge.netxstudio.models.edit",
				"icons/full/obj16/Expression_H.png"));
		btnExpressionTest.setEnabled(false);

		btnExpressionTest.setAlignment(SWT.RIGHT);
		toolkit.adapt(btnExpressionTest, true, true);
		btnExpressionTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				testExpression();
				ISelection selection = componentsTreeViewer.getSelection();
				if (selection instanceof IStructuredSelection) {
				}
			}

			private void testExpression() {

				Expression expression = (Expression) expressionAggregate
						.getExpressionObservable().getValue();

				// The expression could be
				// A Utilization Expression.
				if (expression != null) {

					expressionEngine.getContext().clear();
					expressionEngine.getContext().addAll(
							contextAggregate.getContextObjects());

					int currentExpressionType = contextAggregate
							.getCurrentExpressionType();

					// RETENTION EXPRESSION.
					// If the expression is a retention expression we have to
					// override the DTR from the metric retention rule.
					if (currentExpressionType == ContextAggregate.RETENTION_EXPRESSION_CONTEXT
							&& expressionAggregate.getCurrentSubSelection() instanceof MetricRetentionRule) {

						MetricRetentionRule currentSubSelection = (MetricRetentionRule) expressionAggregate
								.getCurrentSubSelection();
						// The retention rule DTR, is only used for cleaning,
						// not aggregation.
						@SuppressWarnings("unused")
						DateTimeRange dtrForRetentionRule = modelUtils
								.getDTRForRetentionRule(currentSubSelection);
					}

					// TOLERANCE EXPRESSION.
					// If the expression is a tolerance expression, we have to
					// provide
					// a resource monitor...
					DateTimeRange period = contextAggregate.getPeriod();
					Date start = modelUtils.fromXMLDate(period.getBegin());
					Date end = modelUtils.fromXMLDate(period.getEnd());

					ResourceMonitor resourceMonitor = null;
					if (currentExpressionType == ContextAggregate.TOL_EXPRESSION_CONTEXT
							&& expressionAggregate.getCurrentSubSelection() instanceof Tolerance) {
						resultProcessor
								.setTolerance((Tolerance) expressionAggregate
										.getCurrentSubSelection());

						// RESOURCE MONITOR CREATION
						resourceMonitor = OperatorsFactory.eINSTANCE
								.createResourceMonitor();
						resourceMonitor.setNodeRef(contextAggregate
								.getCurrentNode());
						resourceMonitor.setResourceRef(contextAggregate
								.getCurrentNetXResource());
						// CB 22-02, we don't need a copy, we are not contained.
						resourceMonitor.setPeriod(period);

						resultProcessor.setResourceMonitor(resourceMonitor);

					}

					expressionEngine.setExpression(expression);
					expressionEngine.run();

					if (expressionEngine.errorOccurred()) {
						// stop here will be logged
						throw new IllegalStateException(expressionEngine
								.getThrowable());
					}
					final List<BaseExpressionResult> result = expressionEngine
							.getExpressionResult();

					// TODO Annoying to have to provide the start and end date,
					// as this is already in the context.
					resultProcessor.processMonitoringResult(
							expressionEngine.getContext(), result, start, end);

					// Apply the markers to the value viewer.
					if (resourceMonitor != null) {
						cmpValues.applyMarkers(modelUtils
								.toleranceMarkersForResourceMonitor(resourceMonitor));
					}

					// update the values UI.

					if (currentExpressionType == ContextAggregate.RETENTION_EXPRESSION_CONTEXT) {
						cmpValues.injectData(contextAggregate
								.getCurrentNetXResource());
						cmpValues.applyDateFilter(periodComponent.getPeriod());
					} else {

						cmpValues.getValuesTableViewer().refresh(true);
					}

					// update our view part dirty state, as we don't use the
					// editing domain.
					screenService.getAbsViewPart().publicFirePropertyChange(
							ISaveablePart2.PROP_DIRTY);
				}
			}

			@SuppressWarnings("unused")
			private void showExpressionsDialog(ISelection selection) {
				IStructuredSelection ss = (IStructuredSelection) selection;
				Object firstElement = ss.getFirstElement();
				if (firstElement instanceof Component) {
					Component comp = (Component) firstElement;
					ScreenDialog dialog = new ScreenDialog(Display.getDefault()
							.getActiveShell());
					dialog.create();
					dialog.inializeScreenFor(ObjectExpressions.class);
					dialog.screen().setScreenService(screenService);
					dialog.screen().setOperation(ScreenUtil.OPERATION_EDIT);
					ScreenUtil.dataScreenInjectionFor(dialog.screen())
							.injectData(comp.eResource(), comp);
					dialog.getShell().layout(true, true);
					dialog.open();
				}
			}
		});

		if (readOnly) {
			btnExpressionTest.setEnabled(false);
		}

		cmpExpressionEditor = toolkit
				.createComposite(cmpExpression, SWT.BORDER);
		GridData gd_cmpExpressionHead = new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 2);
		// gd_cmpExpressionHead.heightHint = 16;
		cmpExpressionEditor.setLayoutData(gd_cmpExpressionHead);

		toolkit.paintBordersFor(cmpExpressionEditor);

		GridLayout gl_cmpExpressionHead = new GridLayout(1, false);
		gl_cmpExpressionHead.verticalSpacing = 0;
		gl_cmpExpressionHead.marginWidth = 0;
		gl_cmpExpressionHead.marginHeight = 0;
		cmpExpressionEditor.setLayout(gl_cmpExpressionHead);

		expressionComponent.setInjector(this.nextscriptInjector);
		expressionComponent.buildExpression(widgetStyle, cmpExpressionEditor,
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		expressionComponent.configure(editingService, this.getOperation());

		// Label fillerLabel = new Label(cmpExpressionContext, SWT.NONE);
		// GridData gd_filler = new GridData(SWT.LEFT, SWT.CENTER, false,
		// false, 1, 1);
		// gd_filler.widthHint = 145;
		// fillerLabel.setLayoutData(gd_filler);

		// GridData gd_periodContext = new GridData(SWT.RIGHT, SWT.TOP, false,
		// false, 1, 1);
		// gd_periodContext.heightHint = 80;
		// gd_periodContext.widthHint = 170;
		// periodComponent.buildUI(cmpExpressionContext, gd_periodContext);

		cmpSubSelector = new Composite(cmpExpression, SWT.NONE);
		cmpSubSelector.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false,
				false, 2, 1));
		toolkit.adapt(cmpSubSelector);
		toolkit.paintBordersFor(cmpSubSelector);
		GridLayout gl_cmpSubSelector = new GridLayout(2, false);
		gl_cmpSubSelector.marginHeight = 0;
		gl_cmpSubSelector.marginWidth = 0;
		cmpSubSelector.setLayout(gl_cmpSubSelector);
		cmpSubSelector.setVisible(false);

	}

	class showContextAction extends Action {

		public showContextAction(String text) {
			super(text);
		}

		@Override
		public void run() {

			WritableList contextWritableList = contextAggregate
					.getContextWritableList();
			ExpressionContextDialog expressionContextDialog = new ExpressionContextDialog(
					NodeResourcesAdvanced.this.getShell(), editingService,
					modelUtils);
			expressionContextDialog.setBlockOnOpen(false);
			expressionContextDialog.open();
			expressionContextDialog.injectData(contextWritableList);
		}
	}

	private void buildValues(SashForm sashForm) {

		cmpValues.configure(screenService);
		cmpValues.buildValuesUI(sashForm, new GridData(SWT.FILL, SWT.FILL,
				true, true, 1, 1));
	}

	public void buildResourcesColumns() {

		String[] properties = new String[] { "Component", "Long Name",
				"Metric", "Expression Name", "Unit", "Cap. Expression" };

		String[] toolTips = new String[] { "Component holding resource",
				"The long name of the resource",
				"Metric used to create the resource",
				"The expression Name of the resource",
				"The unit of the resource", "Capacity Expression" };

		int[] columnWidths = new int[] { 100, 200, 120, 120, 104, 68, 100 };

		// Enable editing support.
		EditingSupport[] editingSupport = new EditingSupport[] { null, null,
				null, null, null, null, null };

		// disable capacity for now.
		// EditingSupport[] editingSupport = new EditingSupport[] { null, null,
		// null, null, null, null,
		// new CapacityEditingSupport(resourcesTableViewer), null };

		{
			int column = 0;
			@SuppressWarnings("unused")
			TableViewerColumn tbvcFor = tableHelper.new TBVC<String>(
					netXResourceObervableMapLabelProvider).tbvcFor(
					resourcesTableViewer, properties[column], toolTips[column],
					columnWidths[column], editingSupport[column],
					new TableHelper.ComparableComparator<String>());

		}

		{
			int column = 1;
			@SuppressWarnings("unused")
			TableViewerColumn tbvcFor = tableHelper.new TBVC<String>(
					netXResourceObervableMapLabelProvider).tbvcFor(
					resourcesTableViewer, properties[column], toolTips[column],
					columnWidths[column], editingSupport[column],
					new TableHelper.ComparableComparator<String>());

		}

		{
			int column = 2;
			@SuppressWarnings("unused")
			TableViewerColumn tbvcFor = tableHelper.new TBVC<String>(
					netXResourceObervableMapLabelProvider).tbvcFor(
					resourcesTableViewer, properties[column], toolTips[column],
					columnWidths[column], editingSupport[column],
					new TableHelper.ComparableComparator<String>());

		}

		{
			int column = 3;
			@SuppressWarnings("unused")
			TableViewerColumn tbvcFor = tableHelper.new TBVC<String>(
					netXResourceObervableMapLabelProvider).tbvcFor(
					resourcesTableViewer, properties[column], toolTips[column],
					columnWidths[column], editingSupport[column],
					new TableHelper.ComparableComparator<String>());

		}
		{
			int column = 4;
			@SuppressWarnings("unused")
			TableViewerColumn tbvcFor = tableHelper.new TBVC<String>(
					netXResourceObervableMapLabelProvider).tbvcFor(
					resourcesTableViewer, properties[column], toolTips[column],
					columnWidths[column], editingSupport[column],
					new TableHelper.ComparableComparator<String>());
		}

		// {
		// int column = 5;
		// @SuppressWarnings("unused")
		// TableViewerColumn tbvcFor = tableHelper.new TBVC<String>(
		// netXResourceObervableMapLabelProvider).tbvcFor(
		// resourcesTableViewer, properties[column], toolTips[column],
		// columnWidths[column], editingSupport[column],
		// new TableHelper.ComparableComparator<String>());
		// }

	}

	/**
	 * Generates a name for the target component using the feature and the
	 * component type.
	 * 
	 * @param target
	 * @param feature
	 * @return
	 */
	private String getExpressionName(Component target,
			EStructuralFeature feature) {
		String cName = target instanceof Function ? ((Function) target)
				.getName() : target instanceof Equipment ? ((Equipment) target)
				.getEquipmentCode() : "Unknown";

		String name = " Generated_comp_" + cName + "_" + feature.getName();
		return name;
	}

	/*
	 * Maintains the state of an expression selector and sub-selector.
	 */
	private final class ExpressionAggregate implements IValueChangeListener {

		/*
		 * The currently selected component.
		 */
		private Component currentComponent;

		/*
		 * Writable observable others can listen to.
		 */
		private WritableValue exprFeatureWritable = new WritableValue(null,
				EReference.class);

		/*
		 * Writable observable others can listen to.
		 */
		private WritableValue exprWritable = new WritableValue(null,
				Expression.class);

		/*
		 * A composite holding the subselector which is dynamically animated.
		 */
		private ComboViewer cmbViewerSubSelector;

		/*
		 * The currently selected sub selection object.
		 */
		private Object currentSubSelection;

		/*
		 * The currently selected expression feature.
		 */
		private EReference expressionFeature;

		/*
		 * Sub selection hyperkink
		 */
		private ImageHyperlink hypLnkAddTolerance;

		public ExpressionAggregate(Composite subSelectorParent) {
			initSubSelector(subSelectorParent);
		}

		private void initSubSelector(Composite subSelectorParent) {

			Combo cmbSubSelector = new Combo(cmpSubSelector, SWT.READ_ONLY);
			cmbViewerSubSelector = new ComboViewer(cmbSubSelector);
			GridData gd_cmbExpression = new GridData(SWT.LEFT, SWT.CENTER,
					false, false, 1, 1);
			gd_cmbExpression.widthHint = 145;
			cmbSubSelector.setLayoutData(gd_cmbExpression);

			toolkit.paintBordersFor(cmbExpression);

			ObservableListContentProvider expressionFeaturesListContentProvider = new ObservableListContentProvider();
			cmbViewerSubSelector
					.setContentProvider(expressionFeaturesListContentProvider);

			cmbViewerSubSelector
					.setLabelProvider(new AdapterFactoryLabelProvider(
							editingService.getAdapterFactory()));

			if (!readOnly) {
				hypLnkAddTolerance = toolkit.createImageHyperlink(
						subSelectorParent, SWT.NONE);
				hypLnkAddTolerance
						.addHyperlinkListener(new IHyperlinkListener() {
							public void linkActivated(HyperlinkEvent e) {
								Resource toleranceResource = editingService
										.getData(LibraryPackage.Literals.TOLERANCE);
								ToleranceFilterDialog dialog = new ToleranceFilterDialog(
										NodeResourcesAdvanced.this.getShell(),
										toleranceResource);
								if (dialog.open() == IDialogConstants.OK_ID) {
									Tolerance tolerance = (Tolerance) dialog
											.getFirstResult();
									if (!currentComponent.getToleranceRefs()
											.contains(tolerance)) {
										Command c = new AddCommand(
												editingService
														.getEditingDomain(),
												currentComponent
														.getToleranceRefs(),
												tolerance);
										editingService.getEditingDomain()
												.getCommandStack().execute(c);
									}
								}
							}

							public void linkEntered(HyperlinkEvent e) {
							}

							public void linkExited(HyperlinkEvent e) {
							}
						});
				hypLnkAddTolerance.setLayoutData(new GridData(SWT.RIGHT,
						SWT.CENTER, false, false, 1, 1));
				toolkit.paintBordersFor(hypLnkAddTolerance);
				hypLnkAddTolerance.setText("Add");
			}
		}

		public void handleValueChange(ValueChangeEvent event) {

			IObservable observable = event.getObservable();

			System.out.println("Observable called for = "
					+ event.getObservableValue().getValue());
			if (observable instanceof IViewerObservableValue) {
				IViewerObservableValue ivov = (IViewerObservableValue) observable;
				// A change on the expression viewer?
				if (ivov.getViewer() == cmbViewerExpression) {
					expressionFeature = processExpressionFeatureChange(event
							.getObservableValue());
					exprFeatureWritable.setValue(expressionFeature);
					if (currentComponent != null) {
						showAndBindSubSelection();
						loadExpression();
					}

				}
				// A change on the component viewer?
				else if (ivov.getViewer() == componentsTreeViewer) {
					currentComponent = processComponentChange(event
							.getObservableValue());
					if (currentComponent != null) {
						showAndBindSubSelection();
						loadExpression();
					}

				}
				// A change on the sub selection viewer.
				else if (ivov.getViewer() == cmbViewerSubSelector) {
					processSubSelectionChange(event.getObservableValue());
					if (currentComponent != null) {
						loadExpression();
					}
				}
			}

			// handleComponentChange();
		}

		private void showAndBindSubSelection() {

			if (expressionFeature.getEContainingClass() == LibraryPackage.Literals.TOLERANCE
					|| expressionFeature.getEContainingClass() == MetricsPackage.Literals.METRIC_RETENTION_RULE) {
				if (!cmpSubSelector.isVisible()) {
					cmpSubSelector.setVisible(true);
				}

				if (expressionFeature.getEContainingClass() == MetricsPackage.Literals.METRIC_RETENTION_RULE) {
					hypLnkAddTolerance.setVisible(false);
				} else {
					hypLnkAddTolerance.setVisible(true);
				}

			} else {
				cmpSubSelector.setVisible(false);
			}

			if (expressionFeature.getEContainingClass() == LibraryPackage.Literals.TOLERANCE) {
				IEMFListProperty list = EMFProperties
						.list(LibraryPackage.Literals.COMPONENT__TOLERANCE_REFS);
				cmbViewerSubSelector.setInput(list.observe(currentComponent));
			}
			if (expressionFeature.getEContainingClass() == MetricsPackage.Literals.METRIC_RETENTION_RULE) {

				// get the rules from a resource.
				Resource retentionRulesResource = editingService
						.getData(MetricsPackage.Literals.METRIC_RETENTION_RULES);
				IEMFListProperty list = EMFProperties
						.list(MetricsPackage.Literals.METRIC_RETENTION_RULES__METRIC_RETENTION_RULES);
				cmbViewerSubSelector.setInput(list
						.observe(retentionRulesResource.getContents().get(0)));
			}
			// observe the sub selector, and handle change with this class.
			IViewerObservableValue observerSubSelection = ViewersObservables
					.observeSingleSelection(cmbViewerSubSelector);
			observerSubSelection.addValueChangeListener(this);
			currentSubSelection = null;
		}

		/*
		 * Get the expression based on the feature from the current component
		 * and sub selection.
		 */
		private Expression loadExpression() {
			Expression expr = null;

			if (expressionFeature == null
					|| expressionFeature.getEReferenceType() != LibraryPackage.Literals.EXPRESSION) {
				return expr;
			}

			if (expressionFeature.getEContainingClass() == LibraryPackage.Literals.TOLERANCE) {
				// If we have a sub-selection, otherwise show the
				// sub-selection menu.
				if (currentSubSelection instanceof Tolerance) {
					if (((Tolerance) currentSubSelection)
							.eIsSet(LibraryPackage.Literals.TOLERANCE__EXPRESSION_REF)) {
						expr = ((Tolerance) currentSubSelection)
								.getExpressionRef();
						expressionComponent.injectData(expr.eResource(), expr);

					} else {
						expr = createToleranceExpression(
								(Tolerance) currentSubSelection,
								expressionFeature);
						Resource expressionsResource = editingService
								.getData(LibraryPackage.Literals.EXPRESSION);
						expressionComponent.injectData(expressionsResource,
								expr, currentSubSelection, expressionFeature);
					}
				} else {
					// do nothing.
					// well clean the expression editor, as no...
					expressionComponent.clearData();
				}
			} else if (expressionFeature.getEContainingClass() == LibraryPackage.Literals.COMPONENT) {
				if (currentComponent.eIsSet(expressionFeature)) {
					expr = (Expression) currentComponent
							.eGet(expressionFeature);
					expressionComponent.injectData(expr.eResource(), expr);
				} else {
					expr = createComponentExpression(currentComponent,
							expressionFeature);
					Resource expressionsResource = editingService
							.getData(LibraryPackage.Literals.EXPRESSION);
					expressionComponent.injectData(expressionsResource, expr,
							currentComponent, expressionFeature);
				}
			} else if (expressionFeature.getEContainingClass() == MetricsPackage.Literals.METRIC_RETENTION_RULE) {
				if (currentSubSelection instanceof MetricRetentionRule) {
					if (((MetricRetentionRule) currentSubSelection)
							.eIsSet(MetricsPackage.Literals.METRIC_RETENTION_RULE__RETENTION_EXPRESSION)) {
						expr = ((MetricRetentionRule) currentSubSelection)
								.getRetentionExpression();
						expressionComponent.injectData(expr.eResource(), expr);
					} // else DO NOT auto create a retention expression.

				} else {
					// do nothing.
					// well clean the expression editor, as no...
					expressionComponent.clearData();
				}
			}

			if (expr != null) {
				exprWritable.setValue(expr);
			}
			return expr;
		}

		private Expression createComponentExpression(Component target,
				EStructuralFeature feature) {

			Expression expression = LibraryFactory.eINSTANCE.createExpression();

			String name = getExpressionName(target, feature);
			expression.setName(name);

			return expression;
		}

		private Expression createToleranceExpression(Tolerance target,
				EStructuralFeature feature) {

			Expression expression = LibraryFactory.eINSTANCE.createExpression();

			String tName = target.getName();

			String name = " Generated_tolerance_" + tName + "_"
					+ feature.getName();
			expression.setName(name);

			return expression;
		}

		private Component processComponentChange(IObservableValue ob) {
			Component c = null;
			Object value = ob.getValue();
			if (value instanceof Component) {
				c = (Component) value;
			}
			return c;
		}

		private EReference processExpressionFeatureChange(IObservableValue ob) {
			EReference eRef = null;
			Object value = ob.getValue();
			// Expecting an ERef with target EType Expression.
			if (value instanceof EReference) {
				eRef = (EReference) value;
			}
			return eRef;
		}

		private void processSubSelectionChange(IObservableValue ob) {
			Object value = ob.getValue();
			if (value instanceof Tolerance
					|| value instanceof MetricRetentionRule) {
				currentSubSelection = value;
			}
		}

		WritableValue getExpressionFeatureObservable() {
			return exprFeatureWritable;
		}

		WritableValue getExpressionObservable() {
			return exprWritable;
		}

		Object getCurrentSubSelection() {
			return this.currentSubSelection;
		}
	}

	/*
	 * Maintains the state of a context for expressione execution.
	 */
	private final class ContextAggregate implements IValueChangeListener {

		private DateTimeRange dtr = GenericsFactory.eINSTANCE
				.createDateTimeRange();

		private Node currentNode = null;
		private Component currentComponent = null;
		private NetXResource currentNetXResource = null;
		private EReference currentExpressionFeature = null;
		private WritableList contextWritableList = new WritableList();
		private Expression currentExpression;

		// Our model doesn't differential the expression types, but we need this
		// for testing , so define them here.
		static final int NOTSET_EXPRESSION_CONTEXT = -1;
		static final int CAP_EXPRESSION_CONTEXT = 1;
		static final int UTIL_EXPRESSION_CONTEXT = 2;
		static final int TOL_EXPRESSION_CONTEXT = 3;
		static final int RETENTION_EXPRESSION_CONTEXT = 4;

		private int currentExpressionType = NOTSET_EXPRESSION_CONTEXT;

		public void handleValueChange(ValueChangeEvent event) {
			IObservable observable = event.getObservable();
			if (observable instanceof IViewerObservableValue) {
				IViewerObservableValue ivov = (IViewerObservableValue) observable;
				if (ivov.getViewer() == cmbViewerNode) {
					currentNode = processNodeChange(event.getObservableValue());
				}
				if (ivov.getViewer() == componentsTreeViewer) {
					currentComponent = processComponentChange(event
							.getObservableValue());
				} else if (ivov.getViewer() == resourcesTableViewer) {
					currentNetXResource = processResourceChange(event
							.getObservableValue());
				}
			} else if (observable instanceof WritableValue) {
				Object value = ((WritableValue) observable).getValue();
				if (observable == periodBeginWritableValue) {
					this.dtr.setBegin((XMLGregorianCalendar) value);
				} else if (observable == periodEndWritableValue) {
					this.dtr.setEnd((XMLGregorianCalendar) value);
				} else if (value instanceof EReference) {
					this.currentExpressionFeature = (EReference) value;
				} else if (value instanceof Expression) {
					this.currentExpression = (Expression) value;
				}
			}

			handleChange();

		}

		private void handleChange() {
			// printData();
			// build the context.

			// reset the expression type.
			currentExpressionType = NOTSET_EXPRESSION_CONTEXT;

			ImmutableList<IInterpreterContext> contextList = null;
			if (currentExpressionFeature == LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF) {
				if (currentComponent != null) {
					contextList = expressionSupport.buildContext(dtr,
							currentComponent);
					currentExpressionType = CAP_EXPRESSION_CONTEXT;
				}
			} else if (currentExpressionFeature == LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF) {
				if (currentNetXResource != null) {
					contextList = expressionSupport.buildContext(dtr,
							currentNetXResource);
					currentExpressionType = UTIL_EXPRESSION_CONTEXT;
				}
			} else if (currentExpressionFeature == LibraryPackage.Literals.TOLERANCE__EXPRESSION_REF) {
				if (currentNetXResource != null) {
					contextList = expressionSupport.buildContext(dtr,
							currentNetXResource);
					currentExpressionType = TOL_EXPRESSION_CONTEXT;
				}
			} else if (currentExpressionFeature == MetricsPackage.Literals.METRIC_RETENTION_RULE__RETENTION_EXPRESSION) {

				// the context of an retention rule is the NetXResource, the
				// component and the DTR. First we take the DTR from the UI, and
				// override it with the
				// DTR from the retention rule, once the actual rule is selected
				// as a subexpression.
				contextList = expressionSupport.buildContext(dtr, new Object[] {
						this.currentComponent, this.currentNetXResource });
				currentExpressionType = RETENTION_EXPRESSION_CONTEXT;
			}

			contextWritableList.clear();
			if (contextList != null) {
				contextWritableList.addAll(contextList);
			}

			// update the test expression button, if we are not readonly.
			if (!readOnly) {
				if (currentExpression != null && contextList != null
						&& contextList.size() > 0) {
					btnExpressionTest.setEnabled(true);
				} else {
					btnExpressionTest.setEnabled(false);
				}
			}
		}

		public WritableList getContextWritableList() {
			return contextWritableList;
		}

		public List<Object> getContextObjects() {
			List<Object> contextObjects = Lists.newArrayList();
			for (Object o : contextWritableList) {
				if (o instanceof IInterpreterContext) {
					IInterpreterContext ic = (IInterpreterContext) o;
					contextObjects.add(ic.getContext());
				}
			}
			return contextObjects;
		}

		Node getCurrentNode() {
			return currentNode;
		}

		@SuppressWarnings("unused")
		Component getCurrentComponent() {
			return currentComponent;
		}

		NetXResource getCurrentNetXResource() {
			return currentNetXResource;
		}

		public int getCurrentExpressionType() {
			return currentExpressionType;
		}

		public DateTimeRange getPeriod() {
			return dtr;
		}

		@SuppressWarnings("unused")
		private void printData() {
			System.out
					.println("period start="
							+ (dtr.eIsSet(GenericsPackage.Literals.DATE_TIME_RANGE__BEGIN) ? modelUtils
									.dateAndTime(dtr.getBegin()) : "?")
							+ " , end="
							+ (dtr.eIsSet(GenericsPackage.Literals.DATE_TIME_RANGE__END) ? modelUtils
									.dateAndTime(dtr.getEnd()) : "?")
							+ ", component="
							+ (currentComponent != null ? currentComponent
									.getName() : "")
							+ ", resource="
							+ (currentNetXResource != null ? currentNetXResource
									.getShortName() : "")
							+ ", expression="
							+ (currentExpressionFeature != null ? currentExpressionFeature
									.getName() : "?"));
		}

		private Node processNodeChange(IObservableValue ob) {
			Node n = null;
			Object value = ob.getValue();
			if (value instanceof Node) {
				n = (Node) value;
				currentComponent = null;
				currentNetXResource = null;
			}
			return n;
		}

		private Component processComponentChange(IObservableValue ob) {
			Component c = null;
			Object value = ob.getValue();
			if (value instanceof Component) {
				c = (Component) value;
				currentNetXResource = null;
			}
			return c;
		}

		private NetXResource processResourceChange(IObservableValue ob) {
			NetXResource r = null;
			Object value = ob.getValue();
			if (value instanceof NetXResource) {
				r = (NetXResource) value;
			}
			return r;
		}

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

	class ReportNodeAction extends BaseSelectionListenerAction {

		public ReportNodeAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			IStructuredSelection structuredSelection = super
					.getStructuredSelection();

			IWizard wiz = WizardUtil.openWizard(
					"com.netxforge.netxstudio.screens.reporting",
					structuredSelection);
			if (wiz instanceof ReportWizard) {
				ReportWizard rWiz = (ReportWizard) wiz;
				rWiz.forceReportPeriod(periodComponent.getPeriod());

			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.netxforge.netxstudio.screens.editing.actions.
		 * BaseSelectionListenerAction
		 * #updateSelection(org.eclipse.jface.viewers.IStructuredSelection)
		 */
		@Override
		protected boolean updateSelection(IStructuredSelection selection) {
			Object firstElement = selection.getFirstElement();
			return firstElement instanceof Component;
		}
	}

	class EditResourceAction extends BaseSelectionListenerAction {

		public EditResourceAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			IStructuredSelection structuredSelection = super
					.getStructuredSelection();

			Object o = structuredSelection.getFirstElement();
			NewEditResource resourceScreen = new NewEditResource(
					screenService.getScreenContainer(), SWT.NONE);
			resourceScreen.setOperation(getOperation());
			resourceScreen.setScreenService(screenService);

			// CB, the parent is the container resource.
			if (o instanceof CDOObject) {
				resourceScreen.injectData(null, o);
				screenService.setActiveScreen(resourceScreen);
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.netxforge.netxstudio.screens.editing.actions.
		 * BaseSelectionListenerAction
		 * #updateSelection(org.eclipse.jface.viewers.IStructuredSelection)
		 */
		@Override
		protected boolean updateSelection(IStructuredSelection selection) {
			Object firstElement = selection.getFirstElement();
			return firstElement instanceof NetXResource;
		}
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		bindComponentSelector(bindingContext);

		bindExpressionSelector(bindingContext);

		cmpValues.bindValues();

		return bindingContext;
	}

	private void bindComponentSelector(EMFDataBindingContext bindingContext) {

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		cmbViewerOperator.setContentProvider(listContentProvider);
		cmbViewerOperator.setLabelProvider(new AdapterFactoryLabelProvider(
				editingService.getAdapterFactory()));
		IEMFListProperty operatorResourceProperties = EMFProperties.resource();
		cmbViewerOperator.setInput(operatorResourceProperties
				.observe(operatorResource));
		if (cmbViewerOperator.getCombo().getItemCount() > 0) {
			cmbViewerOperator.getCombo().select(0);
		}

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
				componentsTreeViewer.setSelection(null);
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

		if (cmbViewerNetwork.getCombo().getItemCount() > 0) {
			cmbViewerNetwork.getCombo().select(0);
		}

		// Compute the closure of all nodes for the selected network.
		final IViewerObservableValue observeNetworkSelection = ViewersObservables
				.observeSingleSelection(cmbViewerNetwork);

		IObservableList computedNodesList = new ComputedList() {
			@Override
			protected List<Object> calculate() {
				cmbNode.setText("");
				cmbViewerNode.setSelection(null);
				// componentsTreeViewer.setSelection(null);
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
		cmbViewerNode.setInput(computedNodesList);

		// NODE SINGLE SELECTION OBSERVABLE.

		observeNodeSelection = ViewersObservables
				.observeSingleSelection(cmbViewerNode);

		// BINDING OF THE COMPONENTS TABLE.

		ObservableListTreeContentProvider cp = new ObservableListTreeContentProvider(
				new ComponentTreeFactoryImpl(editingService.getEditingDomain()),
				new ComponentTreeStructureAdvisorImpl());
		componentsTreeViewer.setContentProvider(cp);

		{
			IObservableSet set = cp.getKnownElements();
			List<IObservableMap> observeMaps = Lists.newArrayList();

			observeMaps.add(EMFEditProperties.value(
					editingService.getEditingDomain(),
					LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF)
					.observeDetail(set));

			observeMaps
					.add(EMFEditProperties
							.value(editingService.getEditingDomain(),
									LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF)
							.observeDetail(set));

			observeMaps
			.add(EMFEditProperties
					.value(editingService.getEditingDomain(),
							LibraryPackage.Literals.COMPONENT__TOLERANCE_REFS)
					.observeDetail(set));

			IObservableMap[] map = new IObservableMap[observeMaps.size()];
			observeMaps.toArray(map);

			componentsTreeViewer.setLabelProvider(new NetworkTreeLabelProvider(
					map));
		}

		IEMFListProperty nodeTypeList = EMFProperties.multiList(FeaturePath
				.fromList(OperatorsPackage.Literals.NODE__NODE_TYPE,
						LibraryPackage.Literals.NODE_TYPE__FUNCTIONS),
				FeaturePath.fromList(OperatorsPackage.Literals.NODE__NODE_TYPE,
						LibraryPackage.Literals.NODE_TYPE__EQUIPMENTS));

		componentsTreeViewer.setInput(nodeTypeList
				.observeDetail(observeNodeSelection));

		// COMPONENT MULTIPLE SELECTION OBSERVABLE.
		// To populate the resources table.
		final IViewerObservableList observeMultipleComponentSelection = ViewersObservables
				.observeMultiSelection(componentsTreeViewer);

		// COMPONENT SINGLE SELECTION OBSERVABLE
		observeSingleComponentSelection = ViewersObservables
				.observeSingleSelection(componentsTreeViewer);

		computedResourcesList = new ComputedList() {
			@Override
			protected List<Object> calculate() {
				List<Object> result = Lists.newArrayList();
				resourcesTableViewer.setSelection(null);
				for (Object value : observeMultipleComponentSelection) {
					if (value instanceof Component) {
						// Should be a filter or else.
						result.addAll(modelUtils
								.resourcesForComponent((Component) value));
					}
				}
				// if (result.isEmpty()) {
				// System.out.println("no result");
				// }
				return result;
			}
		};

		// BINDING, OF THE RESOURCES TABLE.

		ObservableListContentProvider componentsListContentProvider = new ObservableListContentProvider();
		resourcesTableViewer.setContentProvider(componentsListContentProvider);

		{
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
					LibraryPackage.Literals.BASE_RESOURCE__UNIT_REF)
					.observeDetail(set));

			IObservableMap[] map = new IObservableMap[observeMaps.size()];
			observeMaps.toArray(map);
			netXResourceObervableMapLabelProvider = new NetXResourceObervableMapLabelProvider(
					map);
		}
		resourcesTableViewer
				.setLabelProvider(netXResourceObervableMapLabelProvider);

		resourcesTableViewer.setInput(computedResourcesList);

		observeResourceSingleSelection = ViewersObservables
				.observeSingleSelection(resourcesTableViewer);

		// TODO Consider, binding the resourceSelectionObservable directly with
		// the value widget.
		// as this is a Component, we would need an API to pass the observable.
		IObservableValue valueWritableObservable = new WritableValue();
		valueWritableObservable.addChangeListener(new IChangeListener() {
			public void handleChange(ChangeEvent event) {
				if (event.getSource() instanceof WritableValue) {
					WritableValue v = (WritableValue) event.getSource();
					Object value = v.getValue();
					if (value instanceof NetXResource) {
						cmpValues.injectData((BaseResource) value);
						cmpValues.applyDateFilter(periodComponent.getPeriod());
					} else {
						cmpValues.clearData();
					}
				}
			}
		});

		bindingContext.bindValue(observeResourceSingleSelection,
				valueWritableObservable);

	}

	private void bindExpressionSelector(EMFDataBindingContext bindingContext) {
		computedExpressionFeaturesList = new ComputedList() {
			@Override
			protected List<Object> calculate() {
				List<Object> result = Lists.newArrayList();
				result.add(LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF);
				result.add(LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF);
				result.add(LibraryPackage.Literals.TOLERANCE__EXPRESSION_REF);

				// We would have multiple entries for this feature, which should
				// be injected separately,
				// as these won't be accesible from the component.
				result.add(MetricsPackage.Literals.METRIC_RETENTION_RULE__RETENTION_EXPRESSION);
				// if (result.isEmpty()) {
				// System.out.println("no result");
				// }
				return result;
			}
		};

		IViewerObservableValue observerExpressionFeature = ViewersObservables
				.observeSingleSelection(cmbViewerExpression);

		ObservableListContentProvider expressionFeaturesListContentProvider = new ObservableListContentProvider();
		cmbViewerExpression
				.setContentProvider(expressionFeaturesListContentProvider);

		// Should also adapt ecore model objects, so also EStructuralFeature.
		cmbViewerExpression.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {

				if (element instanceof EReference) {
					EReference ref = (EReference) element;
					if (ref == LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF) {
						return "Resources Capacity";
					} else if (ref == LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF) {
						return "Resources Utilization";
					} else if (ref == LibraryPackage.Literals.TOLERANCE__EXPRESSION_REF) {
						return "Resource Tolerance";
					} else if (ref == MetricsPackage.Literals.METRIC_RETENTION_RULE__RETENTION_EXPRESSION) {
						return "Resource Retention";
					}
					return "";
				}
				return super.getText(element);
			}

		});
		cmbViewerExpression.setInput(computedExpressionFeaturesList);

		// EXPRESSION EDITOR BINDING
		// Put Component and Expression observables in an aggregate.
		expressionAggregate = new ExpressionAggregate(cmpSubSelector);

		observerExpressionFeature.addValueChangeListener(expressionAggregate);
		observeSingleComponentSelection
				.addValueChangeListener(expressionAggregate);

		// CONTEXT BINDING.

		contextAggregate = new ContextAggregate();

		periodBeginWritableValue = new WritableValue();
		periodEndWritableValue = new WritableValue();

		periodBeginWritableValue.addValueChangeListener(contextAggregate);
		periodEndWritableValue.addValueChangeListener(contextAggregate);

		periodComponent.getDateTimeFrom().addSelectionListener(
				new SelectionAdapter() {

					@Override
					public void widgetSelected(SelectionEvent e) {
						periodBeginWritableValue.setValue(periodComponent
								.getPeriod().getBegin());
						cmpValues.applyDateFilter(periodComponent.getPeriod());
					}
				});

		periodComponent.getDateTimeTo().addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						periodEndWritableValue.setValue(periodComponent
								.getPeriod().getEnd());
						cmpValues.applyDateFilter(periodComponent.getPeriod());
					}

				});

		periodComponent.presetLastMonth();

		periodBeginWritableValue.setValue(periodComponent.getPeriod()
				.getBegin());
		periodEndWritableValue.setValue(periodComponent.getPeriod().getEnd());

		observerExpressionFeature.addValueChangeListener(contextAggregate);

		observeNodeSelection.addValueChangeListener(contextAggregate);
		observeSingleComponentSelection
				.addValueChangeListener(contextAggregate);
		observeResourceSingleSelection.addValueChangeListener(contextAggregate);

		expressionAggregate.getExpressionFeatureObservable()
				.addValueChangeListener(contextAggregate);

		expressionAggregate.getExpressionObservable().addValueChangeListener(
				contextAggregate);

		// IViewerObservableValue observeValueSingleSelection =
		// ViewersObservables
		// .observeSingleSelection(resourcesTableViewer);

		cmbViewerExpression.setSelection(new StructuredSelection(
				LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF));
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

		private IEMFListProperty nodeTypeObservableProperty = EMFEditProperties
				.multiList(domain,
						LibraryPackage.Literals.NODE_TYPE__FUNCTIONS,
						LibraryPackage.Literals.NODE_TYPE__EQUIPMENTS);

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
			} else
			// if (target instanceof Node) {
			// ol = nodeObservableProperty.observe(target);
			// } else
			if (target instanceof NodeType) {
				ol = nodeTypeObservableProperty.observe(target);
			} else if (target instanceof Function) {
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
				return null;
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

	class NetXResourceObervableMapLabelProvider extends CellLabelProvider
			implements ITableLabelProvider {

		public NetXResourceObervableMapLabelProvider(
				IObservableMap[] attributeMaps) {
		}

		@Override
		public void update(ViewerCell cell) {
			Object element = cell.getElement();
			int columnIndex = cell.getColumnIndex();

			// delegate to an ITableProvider, so this lp can be used in a
			// sorter.
			String result = this.getColumnText(element, columnIndex);
			if (result != null) {
				cell.setText(result);
			}
		}

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			String result = null;
			if (element instanceof NetXResource) {

				final NetXResource resource = (NetXResource) element;
				Component c = null;
				if (resource
						.eIsSet(LibraryPackage.Literals.NET_XRESOURCE__COMPONENT_REF)) {

					c = resource.getComponentRef();

				}
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
				// case 5:
				// if (c != null
				// &&
				// c.eIsSet(LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF))
				// {
				// return c.getCapacityExpressionRef().getName();
				// }
				// break;
				}
			}
			return result;
		}
	}

	public void injectData() {

		operatorResource = (CDOResource) editingService
				.getData(OperatorsPackage.Literals.OPERATOR);

		buildUI();
		registerFocus(this);
		initDataBindings_();
	}

	public void disposeData() {
	}

	public Viewer getViewer() {
		return resourcesTableViewer;
	}

	@Override
	public Viewer[] getViewers() {
		return new Viewer[] { componentsTreeViewer, resourcesTableViewer,
				cmpValues.getValuesTableViewer() };
	}

	@Override
	public boolean isValid() {
		return true;
	}

	public Form getScreenForm() {
		return frmResources;
	}

	@Override
	public String getScreenName() {
		return "Resources";
	}

	List<IAction> actionList = Lists.newArrayList();

	@Override
	public IAction[] getActions() {
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		String actionText = readonly ? "View..." : "Edit...";

		if (actionList.size() == 0) {

			actionList.add(new EditResourceAction(actionText));
			actionList.add(new SeparatorAction());
			actionList.add(new ReportNodeAction("Report..."));
			// actionList.add(new MonitorResourceAction("Monitor...",
			// SWT.PUSH));
		}
		return actionList.toArray(new IAction[actionList.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.AbstractScreenImpl#getShowIn(org.eclipse
	 * .jface.viewers.ISelection)
	 */
	@Override
	public ShowInContext getShowIn(ISelection selection) {

		ChartShowInContext chartInput = new ChartShowInContext();

		DateTimeRange period = contextAggregate.getPeriod();
		chartInput.setPeriod(period);

		chartInput.setInterval(ModelUtils.MINUTES_IN_AN_HOUR);

		// If we have a resource monitor, we can pass this as well.
		if (resultProcessor.getResourceMonitor() != null) {
			chartInput.setResourceMonitor(resultProcessor.getResourceMonitor());
		}

		// Note the selection for Values, override for the Value selection by
		// the netxresource
		// selection. The Value, could still be passed on to sync the selection
		// in the chart?
		StructuredSelection netXResourceSelection = contextAggregate
				.getCurrentNetXResource() != null ? new StructuredSelection(
				contextAggregate.getCurrentNetXResource()) : null;

		// create a chart show in.
		ShowInContext showInContext = new ShowInContext(chartInput,
				netXResourceSelection);

		return showInContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.AbstractScreenImpl#
	 * resolveSelectionProviderFromWidget(java.lang.Object)
	 */
	@Override
	protected ISelectionProvider resolveSelectionProviderFromWidget(
			Object widget) {

		if (widget == componentsTree) {
			return componentsTreeViewer;
		} else if (widget == resourcesTable) {
			return resourcesTableViewer;
		} else if (widget == cmpValues.getValuesTableViewer().getTable()) {
			return cmpValues.getValuesTableViewer();
		} else if (widget == expressionComponent.getXtextEditor().getViewer()
				.getTextWidget()) {
			return expressionComponent.getXtextEditor().getViewer()
					.getSelectionProvider();
		}

		return super.resolveSelectionProviderFromWidget(widget);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.AbstractScreenImpl#saveState(org.eclipse
	 * .ui.IMemento)
	 */
	@Override
	public void saveState(IMemento memento) {

		// sash state vertical.
		mementoUtils.rememberSashForm(memento, sashVertical,
				MEM_KEY_NODERESOURCEADVANCED_SEPARATOR_VERTICAL);

		// sash state data.
		mementoUtils.rememberSashForm(memento, sashData,
				MEM_KEY_NODERESOURCEADVANCED_SEPARATOR_DATA);

		// combo network.
		mementoUtils.rememberStructuredViewerSelection(memento,
				cmbViewerNetwork,
				MEM_KEY_NODERESOURCEADVANCED_SELECTION_NETWORK);

		// combo node.
		mementoUtils.rememberStructuredViewerSelection(memento, cmbViewerNode,
				MEM_KEY_NODERESOURCEADVANCED_SELECTION_NODE);

		// tree component
		mementoUtils.rememberStructuredViewerSelection(memento,
				componentsTreeViewer,
				MEM_KEY_NODERESOURCEADVANCED_SELECTION_COMPONENT);

		// table resource
		mementoUtils.rememberStructuredViewerSelection(memento,
				resourcesTableViewer,
				MEM_KEY_NODERESOURCEADVANCED_SELECTION_RESOURCE);

		// from date.
		mementoUtils.rememberCDateTime(memento,
				periodComponent.getDateTimeFrom(),
				MEM_KEY_NODERESOURCEADVANCED_PERIOD_FROM);

		// to date.
		mementoUtils.rememberCDateTime(memento,
				periodComponent.getDateTimeTo(),
				MEM_KEY_NODERESOURCEADVANCED_PERIOD_TO);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.AbstractScreenImpl#init(org.eclipse.
	 * ui.IMemento)
	 */
	@Override
	public void restoreState(IMemento memento) {

		mementoUtils.retrieveSashForm(memento, sashVertical,
				MEM_KEY_NODERESOURCEADVANCED_SEPARATOR_VERTICAL);
		mementoUtils.retrieveSashForm(memento, sashData,
				MEM_KEY_NODERESOURCEADVANCED_SEPARATOR_DATA);

		mementoUtils.retrieveStructuredViewerSelection(memento,
				cmbViewerNetwork,
				MEM_KEY_NODERESOURCEADVANCED_SELECTION_NETWORK,
				this.operatorResource.cdoView());
		mementoUtils.retrieveStructuredViewerSelection(memento, cmbViewerNode,
				MEM_KEY_NODERESOURCEADVANCED_SELECTION_NODE,
				this.operatorResource.cdoView());
		mementoUtils.retrieveStructuredViewerSelection(memento,
				componentsTreeViewer,
				MEM_KEY_NODERESOURCEADVANCED_SELECTION_COMPONENT,
				this.operatorResource.cdoView());
		mementoUtils.retrieveStructuredViewerSelection(memento,
				resourcesTableViewer,
				MEM_KEY_NODERESOURCEADVANCED_SELECTION_RESOURCE,
				this.operatorResource.cdoView());

		mementoUtils.retrieveCDateTime(memento,
				periodComponent.getDateTimeFrom(),
				MEM_KEY_NODERESOURCEADVANCED_PERIOD_FROM);
		mementoUtils.retrieveCDateTime(memento,
				periodComponent.getDateTimeTo(),
				MEM_KEY_NODERESOURCEADVANCED_PERIOD_TO);

		// update the binding, as this won't work by setting the UI widget
		// selection.
		periodComponent.updatePeriod();
		periodBeginWritableValue.setValue(periodComponent.getPeriod()
				.getBegin());
		periodEndWritableValue.setValue(periodComponent.getPeriod().getEnd());

	}

}
