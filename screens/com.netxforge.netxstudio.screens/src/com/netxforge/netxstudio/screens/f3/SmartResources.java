/*******************************************************************************
 * Copyright (c) Oct 10, 2012 NetXForge.
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

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.ComputedList;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditListProperty;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.IViewerObservableList;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
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
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
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
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.part.ShowInContext;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.engine.IExpressionEngine;
import com.netxforge.netxstudio.common.context.IComputationContext;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.data.importer.ResultProcessor;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.BaseExpressionResult;
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
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.screens.AbstractPeriodScreen;
import com.netxforge.netxstudio.screens.LabelTextTableColumnFilter;
import com.netxforge.netxstudio.screens.ScreenDialog;
import com.netxforge.netxstudio.screens.ch9.ObjectExpressions;
import com.netxforge.netxstudio.screens.dialog.ToleranceFilterDialog;
import com.netxforge.netxstudio.screens.editing.EMFEditingService;
import com.netxforge.netxstudio.screens.editing.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.ScreenUtil;
import com.netxforge.netxstudio.screens.editing.WizardUtil;
import com.netxforge.netxstudio.screens.editing.actions.BaseSelectionListenerAction;
import com.netxforge.netxstudio.screens.editing.actions.SeparatorAction;
import com.netxforge.netxstudio.screens.editing.actions.TableViewerWithState;
import com.netxforge.netxstudio.screens.editing.filter.SearchFilter;
import com.netxforge.netxstudio.screens.editing.tables.CDOElementComparer;
import com.netxforge.netxstudio.screens.editing.tables.CopyFeatureCommand.FeatureInitializer;
import com.netxforge.netxstudio.screens.editing.tables.CopyFeaturesActionHandler;
import com.netxforge.netxstudio.screens.editing.tables.FocusBlockOwnerDrawHighlighterForMultiselection;
import com.netxforge.netxstudio.screens.editing.tables.FocusColumnToModelMap;
import com.netxforge.netxstudio.screens.editing.tables.OpenTreeViewer;
import com.netxforge.netxstudio.screens.editing.tables.TableHelper;
import com.netxforge.netxstudio.screens.editing.tables.TreeViewerFocusBlockManager;
import com.netxforge.netxstudio.screens.f1.support.ReportWizard;
import com.netxforge.netxstudio.screens.f2.CapacityEditingDialog;
import com.netxforge.netxstudio.screens.f2.ExpressionContextDialog;
import com.netxforge.netxstudio.screens.f2.ExpressionSupport;
import com.netxforge.netxstudio.screens.f2.NewEditResource;
import com.netxforge.netxstudio.screens.f2.RangeSelectionDialog;
import com.netxforge.netxstudio.screens.f3.support.NetXResourceLabelProvider;
import com.netxforge.netxstudio.screens.f3.support.NetworkTreeLabelProvider;
import com.netxforge.netxstudio.screens.monitoring.AbstractMonitoringProcessor;
import com.netxforge.netxstudio.screens.showins.ChartInput;
import com.netxforge.netxstudio.screens.xtext.embedded.EmbeddedLineExpression;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

/**
 * 
 * @author Christophe Bouhier
 * 
 */
public class SmartResources extends AbstractPeriodScreen implements
		IDataServiceInjection {

	/*
	 * Memento keys.
	 */
	private static final String MEM_KEY_NODERESOURCEADVANCED_SEPARATOR_VERTICAL = "MEM_KEY_NODERESOURCESADVANCED_SEPARATOR_VERTICAL";

	private static final String MEM_KEY_NODERESOURCEADVANCED_SEPARATOR_DATA = "MEM_KEY_NODERESOURCESADVANCED_SEPARATOR_DATA";

	private static final String MEM_KEY_NODERESOURCEADVANCED_SELECTION_OPERATOR = "MEM_KEY_NODERESOURCEADVANCED_SELECTION_OPERATOR";

	private static final String MEM_KEY_NODERESOURCEADVANCED_SELECTION_NETWORK = "MEM_KEY_NODERESOURCESADVANCED_SELECTION_NETWORK";

	private static final String MEM_KEY_NODERESOURCEADVANCED_SELECTION_NODE = "MEM_KEY_NODERESOURCESADVANCED_SELECTION_NODE";

	private static final String MEM_KEY_NODERESOURCEADVANCED_SELECTION_COMPONENT = "MEM_KEY_NODERESOURCEADVANCED_SELECTION_COMPONENT";

	private static final String MEM_KEY_NODERESOURCEADVANCED_SELECTION_RESOURCE = "MEM_KEY_NODERESOURCEADVANCED_SELECTION_RESOURCE";

	@Inject
	private TableHelper tableHelper;

	@Inject
	private SearchFilter searchFilter;

	@Inject
	private EmbeddedLineExpression expressionComponent;

	@Inject
	private ExpressionSupport expressionSupport;

	@Inject
	private MonitoringStateModel monitoringStateModel;

	@Inject
	private IExpressionEngine expressionEngine;

	@Inject
	private ResultProcessor resultProcessor;

	/**
	 * A Map of filters.
	 */
	Map<String, LabelTextTableColumnFilter> columnFilters = Maps.newHashMap();

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
	private Label lblNode;

	private CDOResource operatorResource;
	private NetXResourceLabelProvider netXResourceObervableMapLabelProvider;

	private Button btnExpressionTest;

	protected TableViewer resourcesTableViewer;
	private Table resourcesTable;

	private OpenTreeViewer componentsTreeViewer;

	private ComputedList computedResourcesList;
	private ComputedList computedExpressionFeaturesList;

	private ExpressionAggregate expressionAggregate;

	/*
	 * The Expression Context Aggregate.
	 */
	private ContextAggregate contextAggregate;

	/*
	 * The Monitoring Context Aggregate
	 */
	private MonitoringAggregate monitoringAggregate;

	private Composite cmpExpression;
	private Composite cmpSubSelector;

	// Selection observables.
	private IViewerObservableValue observeNodeSelection;
	private IViewerObservableValue observeOperatorOrServiceSelection;
	private IViewerObservableValue observeComponentSingleSelection;
	private IViewerObservableValue observeResourceSingleSelection;

	private IViewerObservableList observeResourceMultipleSelection;

	private Tree componentsTree;
	private SashForm sashVertical;
	private SashForm sashData;

	private boolean readOnly;

	private int widgetStyle;

	/*
	 * A notifier, attached to an IObservableMap (Capable to listen to a
	 * structure).
	 */
	private final ObservableMapChangeListener componentsChangeListener = ObservableMapChangeListener
			.getInstance();

	private Composite cmpComponentSelector;

	private ISWTObservableValue observeComponentFocus;

	private ISWTObservableValue observeResourceFocus;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public SmartResources(Composite parent, int style) {
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

	protected void buildUI() {
		super.buildUI();

		// Readonlyness.
		readOnly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		widgetStyle = readOnly ? SWT.READ_ONLY : SWT.NONE;

		Form frmResources = getScreenForm();
		frmResources.setText(this.getOperationText() + "Resources");
		frmResources.getToolBarManager().add(new showContextAction("Context"));

		sashVertical = new SashForm(frmResources.getBody(), SWT.VERTICAL);
		// Width ugly on WinXP. 
//		sashVertical.setSashWidth(3);
		toolkit.adapt(sashVertical);
		toolkit.paintBordersFor(sashVertical);

		sashVertical.addDragDetectListener(new DragDetectListener() {

			public void dragDetected(DragDetectEvent e) {
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

		sashData = new SashForm(sashVertical, SWT.HORIZONTAL | SWT.BORDER);
		sashData.setSashWidth(5);
		toolkit.adapt(sashData);
		toolkit.paintBordersFor(sashData);

		sashData.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2,
				1));

		buildComponentViewer(sashData, null);
		buildResourceViewer(sashData);

		// WEIGHTS FOR SASH.
		sashVertical.setWeights(new int[] { 4, 4 });
		sashData.setWeights(new int[] { 3, 5 });

	}

	private Label buildViewerLabels(Composite parent) {

		Composite labels = toolkit.createComposite(parent, SWT.NONE);
		labels.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		GridLayout layout = new GridLayout();

		layout.numColumns = 2;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		layout.verticalSpacing = 0;
		labels.setLayout(layout);

		Label listLabel = toolkit.createLabel(labels, "", SWT.NONE);

		listLabel.addTraverseListener(new TraverseListener() {
			public void keyTraversed(TraverseEvent e) {
				if (e.detail == SWT.TRAVERSE_MNEMONIC && e.doit) {
					e.detail = SWT.TRAVERSE_NONE;
					resourcesTableViewer.getTable().setFocus();
				}
			}
		});

		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		listLabel.setLayoutData(gd);

		Label progressLabel = toolkit.createLabel(labels, "", SWT.RIGHT);
		progressLabel.setLayoutData(gd);

		labels.setLayoutData(gd);
		return listLabel;

	}

	private void buildResourceViewer(SashForm sashComponentResources) {

		Composite content = toolkit.createComposite(sashComponentResources,
				SWT.NONE);
		toolkit.paintBordersFor(content);

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		// layout.verticalSpacing = 0;
		content.setLayout(layout);

		this.buildViewerLabels(content);

		resourcesTableViewer = new TableViewerWithState(content, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.MULTI);
		resourcesTableViewer.getTable().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
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

	private void buildComponentViewer(SashForm sashComponent,
			GridData gd_componentsTreeViewer) {

		Composite content = toolkit.createComposite(sashComponent, SWT.NONE);
		toolkit.paintBordersFor(content);
		if (gd_componentsTreeViewer != null) {
			content.setLayoutData(gd_componentsTreeViewer);
		}

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		// layout.verticalSpacing = 0;
		content.setLayout(layout);

		this.buildViewerLabels(content);

		// COMPONENTS TREEVIEWER.

		componentsTreeViewer = new OpenTreeViewer(content, SWT.BORDER
				| SWT.MULTI | widgetStyle);
		componentsTreeViewer.setUseHashlookup(true);
		componentsTreeViewer.setComparer(new CDOElementComparer());
		// CB http://work.netxforge.com/issues/290
		componentsTreeViewer.setComparator(new NetworkViewerComparator());

		componentsTree = componentsTreeViewer.getTree();
		componentsTree.setHeaderVisible(true);
		componentsTree.setLinesVisible(true);
		componentsTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));

		// Add a drag source...

		toolkit.paintBordersFor(componentsTree);

		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(
				componentsTreeViewer, SWT.NONE);
		TreeColumn trclmnCountry = treeViewerColumn.getColumn();
		trclmnCountry.setWidth(400);
		trclmnCountry.setText("Component");

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

		// Our action handler.
		CopyFeaturesActionHandler copyFeaturesActionHandler = new CopyFeaturesActionHandler();
		copyFeaturesActionHandler.setEditingDomain(this.getEditingService()
				.getEditingDomain());

		FocusColumnToModelMap focusColumnToModelMap = new FocusColumnToModelMap();
		focusColumnToModelMap.getColumnFeatureMap().put(1,
				LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF);
		focusColumnToModelMap.getColumnFeatureMap().put(2,
				LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF);

		copyFeaturesActionHandler.setFeatureMap(focusColumnToModelMap);
		copyFeaturesActionHandler
				.setFeatureInitializer(new ExpressionInitializer());

		// We shall set a target for the copied object if non-containment.
		Resource expressionsResource = editingService
				.getData(LibraryPackage.Literals.EXPRESSION);

		copyFeaturesActionHandler
				.setTargetResourceForNonContainment(expressionsResource);

		// instantiate it, it will hook listeners.
		TreeViewerFocusBlockManager treeViewerFocusBlockManager = new TreeViewerFocusBlockManager(
				componentsTreeViewer, fcHighlighter);

		treeViewerFocusBlockManager
				.setFocusBlockActionHandler(copyFeaturesActionHandler);

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
				String name = modelUtils.expressionName((Component) owner,
						feature);
				Expression copiedExpression = (Expression) copy;
				copiedExpression.setName(name);
			}
		}

	}

	private void buildComponentSelector(Composite parent, GridData gridData) {
		// Selector.
		cmpComponentSelector = toolkit.createComposite(parent, SWT.NONE);

		cmpComponentSelector.setLayoutData(gridData);
		GridLayout gl_cmpSelector = new GridLayout(2, false);
		gl_cmpSelector.verticalSpacing = 0;
		gl_cmpSelector.marginWidth = 0;
		gl_cmpSelector.marginHeight = 0;
		cmpComponentSelector.setLayout(gl_cmpSelector);

		// OPERATOR SELCTOR

		lblOperator = toolkit.createLabel(cmpComponentSelector,
				"Operator/Service:", SWT.NONE);
		lblOperator.setAlignment(SWT.RIGHT);
		GridData gd_lblOperator = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblOperator.widthHint = 100;
		lblOperator.setLayoutData(gd_lblOperator);

		cmbOperator = new Combo(cmpComponentSelector, SWT.READ_ONLY);
		cmbViewerOperator = new ComboViewer(cmbOperator);

		GridData gd_cmbOperator = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_cmbOperator.widthHint = 200;
		cmbOperator.setLayoutData(gd_cmbOperator);
		toolkit.paintBordersFor(cmbOperator);

		// NETWORK SELCTOR

		lblNetwork = toolkit.createLabel(cmpComponentSelector, "Network:",
				SWT.NONE);
		lblNetwork.setAlignment(SWT.RIGHT);
		GridData gd_lblNetwork = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		// gd_lblNetwork.widthHint = 70;
		lblNetwork.setLayoutData(gd_lblNetwork);

		cmbNetwork = new Combo(cmpComponentSelector, SWT.READ_ONLY);
		cmbViewerNetwork = new ComboViewer(cmbNetwork);
		cmbViewerNetwork.setComparer(new CDOElementComparer());

		cmbNetwork.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		toolkit.paintBordersFor(cmbNetwork);
		cmbNetwork.setEnabled(false);

		// COMPONENT SELCTOR

		lblNode = toolkit.createLabel(cmpComponentSelector, "N. Element:",
				SWT.NONE);
		lblNode.setAlignment(SWT.RIGHT);
		GridData gd_lblNode = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		// gd_lblNode.widthHint = 70;
		lblNode.setLayoutData(gd_lblNode);

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

			/**
			 * Uses the information from the context Aggregate to run an
			 * expression in the standard expression. Deals with different types
			 * of expressions.
			 * <ul>
			 * <li>Tolerance Expressions</li>
			 * <li>Retention Expressions</li>
			 * </ul>
			 */
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

						@SuppressWarnings("unused")
						MetricRetentionRule currentSubSelection = (MetricRetentionRule) expressionAggregate
								.getCurrentSubSelection();

						// DateTimeRange dtrForRetentionRule = modelUtils
						// .getDTRForRetentionRule(currentSubSelection, 2);
					}

					// TOLERANCE EXPRESSION.
					// If the expression is a tolerance expression, we have to
					// provide
					// a resource monitor...
					DateTimeRange period = getPeriodComponent().getPeriod();
					ResourceMonitor resourceMonitor = null;
					if (currentExpressionType == ContextAggregate.TOL_EXPRESSION_CONTEXT
							&& expressionAggregate.getCurrentSubSelection() instanceof Tolerance) {
						resultProcessor.getToleranceProcessor().setTolerance(
								(Tolerance) expressionAggregate
										.getCurrentSubSelection());

						// RESOURCE MONITOR
						resourceMonitor = OperatorsFactory.eINSTANCE
								.createResourceMonitor();
						resourceMonitor.setNodeRef(contextAggregate
								.getCurrentNode());
						resourceMonitor.setResourceRef(contextAggregate
								.getCurrentNetXResource());
						// CB 22-02, we don't need a copy, we are not contained.
						resourceMonitor.setPeriod(period);
						resultProcessor.getToleranceProcessor()
								.setResourceMonitor(resourceMonitor);

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

					resultProcessor.processMonitoringResult(
							expressionEngine.getContext(), result, period);

					// Apply the markers to the value viewer.

					// FIXME, Refactor using MonitoringStateModel
					if (resourceMonitor != null) {
						// cmpValues.applyMarkers(modelUtils
						// .toleranceMarkersForResourceMonitor(resourceMonitor));
					}

					// update the values component by re-applying the filter.

					// CB TODO.... DEAL WITH VALUES AND EXPRESSIONS.

					// if (currentExpressionType ==
					// ContextAggregate.RETENTION_EXPRESSION_CONTEXT) {
					// cmpValues.injectData(contextAggregate
					// .getCurrentNetXResource());
					// } else {
					// cmpValues.applyDateFilter(getPeriodComponent()
					// .getPeriod(), true);
					// }
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

		expressionComponent.setGrammar("com.netxforge.Netxscript");
		expressionComponent.buildExpression(widgetStyle, cmpExpressionEditor,
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		expressionComponent.configure(editingService, this.getOperation());

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
					SmartResources.this.getShell(), editingService, modelUtils);
			expressionContextDialog.setBlockOnOpen(false);
			expressionContextDialog.open();
			expressionContextDialog.injectData(contextWritableList);
		}
	}

	public void buildResourcesColumns() {

		String[] properties = new String[] { "Component", "Long Name",
				"Metric", "Expression Name", "Unit", "Markers" };

		String[] toolTips = new String[] { "Component holding resource",
				"The long name of the resource",
				"Metric used to create the resource",
				"The expression Name of the resource",
				"The unit of the resource", "Monitored" };

		int[] columnWidths = new int[] { 100, 200, 120, 120, 40, 68 };

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
					columnWidths[column], editingSupport[column]);
		}

		{
			int column = 1;
			@SuppressWarnings("unused")
			TableViewerColumn tbvcFor = tableHelper.new TBVC<String>(
					netXResourceObervableMapLabelProvider).tbvcFor(
					resourcesTableViewer, properties[column], toolTips[column],
					columnWidths[column], editingSupport[column]);

		}

		{
			int column = 2;
			@SuppressWarnings("unused")
			TableViewerColumn tbvcFor = tableHelper.new TBVC<String>(
					netXResourceObervableMapLabelProvider).tbvcFor(
					resourcesTableViewer, properties[column], toolTips[column],
					columnWidths[column], editingSupport[column]);

		}

		{
			int column = 3;
			@SuppressWarnings("unused")
			TableViewerColumn tbvcFor = tableHelper.new TBVC<String>(
					netXResourceObervableMapLabelProvider).tbvcFor(
					resourcesTableViewer, properties[column], toolTips[column],
					columnWidths[column], editingSupport[column]);

		}
		{
			int column = 4;
			@SuppressWarnings("unused")
			TableViewerColumn tbvcFor = tableHelper.new TBVC<String>(
					netXResourceObervableMapLabelProvider).tbvcFor(
					resourcesTableViewer, properties[column], toolTips[column],
					columnWidths[column], editingSupport[column]);
		}

		{
			int column = 5;
			@SuppressWarnings("unused")
			TableViewerColumn tbvcFor = tableHelper.new TBVC<String>(
					netXResourceObervableMapLabelProvider).tbvcFor(
					resourcesTableViewer, properties[column], toolTips[column],
					columnWidths[column], editingSupport[column]);
		}

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
							EMFEditingService.getAdapterFactory()));

			if (!readOnly) {
				hypLnkAddTolerance = toolkit.createImageHyperlink(
						subSelectorParent, SWT.NONE);
				hypLnkAddTolerance
						.addHyperlinkListener(new IHyperlinkListener() {
							public void linkActivated(HyperlinkEvent e) {
								Resource toleranceResource = editingService
										.getData(LibraryPackage.Literals.TOLERANCE);
								ToleranceFilterDialog dialog = new ToleranceFilterDialog(
										SmartResources.this.getShell(),
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

			String name = modelUtils.expressionName(target, feature);
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

	/**
	 * Maintains monitoring selection.
	 * 
	 */
	final class MonitoringAggregate extends AbstractMonitoringProcessor {

		public MonitoringAggregate(MonitoringStateModel monitoringStateModel) {
			super(monitoringStateModel);
		}

		/*
		 * The current monitored node.
		 */
		private Node currentNode = null;

		/*
		 * The current monitored node.
		 */
		private Component currentComponent = null;

		/*
		 * The current monitored resource.
		 */
		private NetXResource currentNetXResource = null;

		/**
		 * Track the last value change which corresponds to the selection.
		 */
		private EObject lastSelection;

		public void handleValueChange(ValueChangeEvent event) {

			IObservable observable = event.getObservable();
			IObservableValue observableValue = event.getObservableValue();

			if (observable instanceof IViewerObservableValue) {

				IViewerObservableValue ivov = (IViewerObservableValue) observable;
				lastSelection = (EObject) ivov.getValue();
				if (ivov.getViewer() == cmbViewerOperator) {
					currentService = processServiceChange(observableValue);
				} else if (ivov.getViewer() == cmbViewerNode) {

					cleanResourceMon(currentNode);
					currentNode = processNodeChange(observableValue);
					updateResourceMon(currentNode);

				} else if (ivov.getViewer() == componentsTreeViewer) {

					cleanResourceMon(currentComponent);
					currentComponent = processComponentChange(observableValue);
					updateResourceMon(currentComponent);

				} else if (ivov.getViewer() == resourcesTableViewer) {

					cleanResourceMon(currentNetXResource);

					currentNetXResource = processResourceChange(observableValue);

					updateResourceMon(currentNetXResource);
				}
			} else if (observable instanceof WritableValue) {

				updateResourceMon(lastSelection);
			}
		}

		/**
		 * For multiple {@link NetXResource} objects we are interested in
		 * keeping the monitor
		 * 
		 */
		public void handleListChange(ListChangeEvent event) {

			if (event.getObservable() == observeResourceMultipleSelection) {
				for (Object o : event.getObservableList()) {
					updateResourceMon((EObject) o);
				}
			}

		}

		// THE CURRENT SELECTIONS.

		public Node getCurrentNode() {
			return currentNode;
		}

		public Component getCurrentComponent() {
			return currentComponent;
		}

		public NetXResource getCurrentNetXResource() {
			return currentNetXResource;
		}

		private Service processServiceChange(IObservableValue ob) {
			Service s = null;
			final Object value = ob.getValue();
			if (value instanceof Service) {
				s = (Service) value;
			}
			return s;
		}

		private Node processNodeChange(IObservableValue ob) {
			Node n = null;
			final Object value = ob.getValue();
			if (value instanceof Node) {
				n = (Node) value;
			}
			return n;
		}

		private Component processComponentChange(IObservableValue ob) {
			Component c = null;
			final Object value = ob.getValue();
			if (value instanceof Component) {
				c = (Component) value;
			}
			return c;
		}

		private NetXResource processResourceChange(IObservableValue ob) {
			NetXResource netXResource = null;
			final Object value = ob.getValue();
			if (value instanceof NetXResource) {
				netXResource = (NetXResource) value;
			}
			return netXResource;
		}

		@Override
		protected void updateValues(EObject target) {
			// TODO Do we still need the callback for the smartResources ?

		}

	}

	/*
	 * Maintains the state of a context for expressione execution.
	 */
	private final class ContextAggregate implements IValueChangeListener {

		private Node currentNode = null;
		private Service currentService = null;
		private Component currentComponent = null;
		private NetXResource currentNetXResource = null;
		private EReference currentExpressionFeature = null;
		private Expression currentExpression;

		private int currentExpressionType = NOTSET_EXPRESSION_CONTEXT;

		private WritableList contextWritableList = new WritableList();

		// Our model doesn't differential the expression types, but we need this
		// for testing , so define them here.
		static final int NOTSET_EXPRESSION_CONTEXT = -1;
		static final int CAP_EXPRESSION_CONTEXT = 1;
		static final int UTIL_EXPRESSION_CONTEXT = 2;
		static final int TOL_EXPRESSION_CONTEXT = 3;
		static final int RETENTION_EXPRESSION_CONTEXT = 4;

		public void handleValueChange(ValueChangeEvent event) {
			IObservable observable = event.getObservable();
			if (observable instanceof IViewerObservableValue) {
				IViewerObservableValue ivov = (IViewerObservableValue) observable;
				if (ivov.getViewer() == cmbViewerOperator) {
					currentService = processServiceChange(event
							.getObservableValue());
				} else if (ivov.getViewer() == cmbViewerNode) {
					currentNode = processNodeChange(event.getObservableValue());
				} else if (ivov.getViewer() == componentsTreeViewer) {
					currentComponent = processComponentChange(event
							.getObservableValue());
				} else if (ivov.getViewer() == resourcesTableViewer) {
					currentNetXResource = processResourceChange(event
							.getObservableValue());
				}
			} else if (observable instanceof WritableValue) {
				Object value = ((WritableValue) observable).getValue();
				if (value instanceof EReference) {
					this.currentExpressionFeature = (EReference) value;
				} else if (value instanceof Expression) {
					this.currentExpression = (Expression) value;
				}
			}

			handleChange();

		}

		@SuppressWarnings("unused")
		public Service getCurrentService() {
			return currentService;
		}

		private void handleChange() {
			// printData();
			// build the context.

			// reset the expression type.
			currentExpressionType = NOTSET_EXPRESSION_CONTEXT;

			ImmutableList<IComputationContext> contextList = null;
			if (currentExpressionFeature == LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF) {
				if (currentComponent != null) {
					contextList = expressionSupport.buildContext(
							getPeriodComponent().getPeriod(), currentComponent);
					currentExpressionType = CAP_EXPRESSION_CONTEXT;
				}
			} else if (currentExpressionFeature == LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF) {
				if (currentNetXResource != null) {
					contextList = expressionSupport.buildContext(
							getPeriodComponent().getPeriod(),
							currentNetXResource);
					currentExpressionType = UTIL_EXPRESSION_CONTEXT;
				}
			} else if (currentExpressionFeature == LibraryPackage.Literals.TOLERANCE__EXPRESSION_REF) {
				if (currentNetXResource != null) {
					contextList = expressionSupport.buildContext(
							getPeriodComponent().getPeriod(),
							currentNetXResource);
					currentExpressionType = TOL_EXPRESSION_CONTEXT;
				}
			} else if (currentExpressionFeature == MetricsPackage.Literals.METRIC_RETENTION_RULE__RETENTION_EXPRESSION) {

				// the context of an retention rule is the NetXResource, the
				// component and the DTR. First we take the DTR from the UI, and
				// override it with the
				// DTR from the retention rule, once the actual rule is selected
				// as a subexpression.
				contextList = expressionSupport.buildContext(
						getPeriodComponent().getPeriod(),
						new Object[] { this.currentComponent,
								this.currentNetXResource });
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
				if (o instanceof IComputationContext) {
					IComputationContext ic = (IComputationContext) o;
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

		@SuppressWarnings("unused")
		private void printData() {
			DateTimeRange dtr = getPeriodComponent().getPeriod();
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

		private Service processServiceChange(IObservableValue ob) {
			Service s = null;
			Object value = ob.getValue();
			if (value instanceof Service) {
				s = (Service) value;
			}
			return s;
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
				rWiz.forceReportPeriod(getPeriodComponent().getPeriod());

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

	/*
	 * Syncs the period to the values available for a resources. Shows a dialog
	 * which allows to select for which range, the period should be synced.
	 */
	class AdjustToRangeAction extends BaseSelectionListenerAction {

		public AdjustToRangeAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			IStructuredSelection structuredSelection = super
					.getStructuredSelection();

			// Do something with the resource.
			NetXResource res = (NetXResource) structuredSelection
					.getFirstElement();

			RangeSelectionDialog selectDialog = new RangeSelectionDialog(
					SmartResources.this.getShell(), modelUtils);

			selectDialog.setBlockOnOpen(true);
			selectDialog.create();

			selectDialog
					.setMessage("Adjust the period according to a value range for resource: \""
							+ res.getLongName() + "\"");
			selectDialog.injectData(res);

			if (selectDialog.open() == Window.OK) {
				MetricValueRange mvr = selectDialog.getValueRange();
				if (mvr != null) {
					DateTimeRange range = modelUtils.period(mvr
							.getMetricValues());
					// update the period component.
					getPeriodComponent().setPeriod(range);

				} else {
				}
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

		EMFDataBindingContext bindingContext = super.initDataBindings_();

		contextAggregate = new ContextAggregate();

		monitoringAggregate = new MonitoringAggregate(monitoringStateModel);
		monitoringAggregate.setPeriod(getPeriodComponent().getPeriod());

		bindComponentSelector(bindingContext);

		bindExpressionSelector(bindingContext);

		return bindingContext;
	}

	private void bindComponentSelector(EMFDataBindingContext bindingContext) {

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		cmbViewerOperator.setContentProvider(listContentProvider);
		cmbViewerOperator.setLabelProvider(new AdapterFactoryLabelProvider(
				EMFEditingService.getAdapterFactory()));

		// IEMFListProperty operatorResourceProperties =
		// EMFProperties.resource();

		IObservableList sourceList = new ComputedList() {
			@Override
			protected List<Object> calculate() {

				List<Object> result = Lists.newArrayList();
				if (operatorResource != null) {

					for (EObject o : operatorResource.getContents()) {
						if (o instanceof Operator) {
							result.add(o);
							EList<Service> services = ((Operator) o)
									.getServices();
							for (Service s : services) {
								result.add(s);
								TreeIterator<EObject> allServices = s
										.eAllContents();
								while (allServices.hasNext()) {
									EObject next = allServices.next();
									if (next instanceof Service) {
										result.add(next);
									}
								}
							}
						}
					}
				}
				return result;
			}
		};

		cmbViewerOperator.setInput(sourceList);

		if (cmbViewerOperator.getCombo().getItemCount() > 0) {
			cmbViewerOperator.getCombo().select(0);
		}

		observeOperatorOrServiceSelection = ViewersObservables
				.observeSingleSelection(cmbViewerOperator);

		IObservableList networksList = new ComputedList() {
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
				Object value = observeOperatorOrServiceSelection.getValue();
				if (value instanceof Operator) {
					// closure of all Network objects.
					result.addAll(modelUtils
							.networksForOperator((Operator) value));
				} else if (value instanceof Service) {
					// In this case, we do not need the networks, the Nodes,
					// are retrieved from the nodes themselves.
				}

				cmbNetwork.setEnabled(!result.isEmpty());
				return result;
			}
		};

		ObservableListContentProvider networksListContentProvider = new ObservableListContentProvider();
		cmbViewerNetwork.setContentProvider(networksListContentProvider);

		cmbViewerNetwork.setLabelProvider(new AdapterFactoryLabelProvider(
				EMFEditingService.getAdapterFactory()));
		cmbViewerNetwork.setInput(networksList);

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

				{ // Any network selected?
					Object value = observeNetworkSelection.getValue();
					if (value instanceof Network) {
						// closure of all Network objects.
						result.addAll(modelUtils
								.nodesForNetwork((Network) value));
					}
				}
				{ // Any RFS Service selected.
					Object value = observeOperatorOrServiceSelection.getValue();
					if (value instanceof RFSService) {
						// closure of all Network objects.
						result.addAll(((RFSService) value).getNodes());
					}
				}

				cmbNode.setEnabled(!result.isEmpty());
				return result;
			}
		};

		ObservableListContentProvider nodesListContentProvider = new ObservableListContentProvider();
		cmbViewerNode.setContentProvider(nodesListContentProvider);
		cmbViewerNode.setLabelProvider(new AdapterFactoryLabelProvider(
				EMFEditingService.getAdapterFactory()));
		cmbViewerNode.setInput(computedNodesList);

		// NODE SINGLE SELECTION OBSERVABLE.

		observeNodeSelection = ViewersObservables
				.observeSingleSelection(cmbViewerNode);

		// RE_LAYOUT THE COMPONENT SELECTOR WHEN POPULATED.
		cmpComponentSelector.layout();

		// BINDING OF THE COMPONENTS TABLE.

		ObservableListTreeContentProvider cp = new ObservableListTreeContentProvider(
				new ComponentTreeFactoryImpl(editingService.getEditingDomain()),
				new ComponentTreeStructureAdvisorImpl());

		componentsTreeViewer.setContentProvider(cp);

		// Each IObservableMap observes the specified property/feature of the
		// elements in set.
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

			{
				IObservableMap observeDetail = EMFEditProperties.value(
						editingService.getEditingDomain(),
						LibraryPackage.Literals.FUNCTION__FUNCTIONS)
						.observeDetail(set);

				componentsChangeListener.notifyObservableMap(observeDetail);
				observeMaps.add(observeDetail);

			}

			{
				IObservableMap observeDetail = EMFEditProperties.value(
						editingService.getEditingDomain(),
						LibraryPackage.Literals.EQUIPMENT__EQUIPMENTS)
						.observeDetail(set);
				componentsChangeListener.notifyObservableMap(observeDetail);
				observeMaps.add(observeDetail);
			}
			observeMaps.add(EMFEditProperties.value(
					editingService.getEditingDomain(),
					LibraryPackage.Literals.COMPONENT__TOLERANCE_REFS)
					.observeDetail(set));

			IObservableMap[] map = new IObservableMap[observeMaps.size()];

			observeMaps.toArray(map);

			componentsTreeViewer.setLabelProvider(new NetworkTreeLabelProvider(
					modelUtils, map));
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

		final IEMFEditListProperty list = EMFEditProperties.list(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.COMPONENT__RESOURCE_REFS);

		// COMPONENT SINGLE SELECTION OBSERVABLE
		observeComponentSingleSelection = ViewersObservables
				.observeSingleSelection(componentsTreeViewer);

		observeComponentFocus = SWTObservables
				.observeFocus(componentsTreeViewer.getTree());

		computedResourcesList = new ComputedList() {
			@SuppressWarnings("unchecked")
			@Override
			protected List<Object> calculate() {
				List<Object> result = Lists.newArrayList();

				// Forces, no selection on the resources tableviewer???
				// resourcesTableViewer.setSelection(null);
				for (Object value : observeMultipleComponentSelection) {
					if (value instanceof Component) {
						// Should be a filter or else.
						for (Component c : modelUtils
								.componentsForComponent((Component) value)) {
							IObservableList observe = list.observe(c);
							result.addAll(observe);
						}
					}
				}
				return result;
			}
		};

		// BINDING, OF THE RESOURCES TABLE.

		ObservableListContentProvider componentsListContentProvider = new ObservableListContentProvider();
		resourcesTableViewer.setContentProvider(componentsListContentProvider);

		{
			List<IObservableMap> observeMaps = Lists.newArrayList();
			IObservableSet set = componentsListContentProvider
					.getKnownElements();
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
			netXResourceObervableMapLabelProvider = new NetXResourceLabelProvider(
					map);
		}

		resourcesTableViewer
				.setLabelProvider(netXResourceObervableMapLabelProvider);

		resourcesTableViewer.setInput(computedResourcesList);

		observeResourceSingleSelection = ViewersObservables
				.observeSingleSelection(resourcesTableViewer);

		observeResourceFocus = SWTObservables.observeFocus(resourcesTableViewer
				.getTable());

		observeResourceMultipleSelection = ViewersObservables
				.observeMultiSelection(resourcesTableViewer);

		// CONTEXT AGGREGATE.

		observeNodeSelection.addValueChangeListener(contextAggregate);
		observeOperatorOrServiceSelection
				.addValueChangeListener(contextAggregate);
		observeComponentSingleSelection
				.addValueChangeListener(contextAggregate);
		observeResourceSingleSelection.addValueChangeListener(contextAggregate);

		// MONITORING AGGREGATE

		observeNodeSelection.addValueChangeListener(monitoringAggregate);
		observeOperatorOrServiceSelection
				.addValueChangeListener(monitoringAggregate);
		observeComponentSingleSelection
				.addValueChangeListener(monitoringAggregate);
		observeComponentFocus.addValueChangeListener(monitoringAggregate);
		observeResourceMultipleSelection
				.addListChangeListener(monitoringAggregate);
		observeResourceFocus.addValueChangeListener(monitoringAggregate);
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
		observeComponentSingleSelection
				.addValueChangeListener(expressionAggregate);

		// CONTEXT BINDING.

		this.getPeriodComponent().presetLastMonth();

		// A Context for selections in the screen.
		observerExpressionFeature.addValueChangeListener(contextAggregate);

		expressionAggregate.getExpressionFeatureObservable()
				.addValueChangeListener(contextAggregate);

		expressionAggregate.getExpressionObservable().addValueChangeListener(
				contextAggregate);

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

	public void injectData() {
		operatorResource = (CDOResource) editingService
				.getData(OperatorsPackage.Literals.OPERATOR);

		buildUI();
		registerFocus(this);
		enableDragAndDrop();
		initDataBindings_();

	}

	/* We handle refresh */
	@Override
	public boolean shouldHandleRefresh() {
		return true;
	}

	@Override
	public void handleRefresh(Object... objects) {

		// Turn-off live update.
		// http://work.netxforge.com/issues/355

		// for (Object o : objects) {
		// if (o instanceof Collection<?>) {
		// Collection<?> collection = (Collection<?>) o;
		// handleRefresh(collection.toArray());
		// continue;
		// } else if (o instanceof Service) {
		// System.out.println("Invalid " + ((Service) o).cdoRevision());
		// } else if (o instanceof ServiceMonitor) {
		// System.out.println("Invalid "
		// + ((ServiceMonitor) o).cdoRevision());
		// } else if (o instanceof ResourceMonitor) {
		// System.out.println("Invalid "
		// + ((ResourceMonitor) o).cdoRevision());
		// } else if (o instanceof NetXResource) {
		// System.out.println("Invalid "
		// + ((NetXResource) o).cdoRevision());
		// continue;
		// }
		//
		// if (!(o instanceof WorkFlowRun)) {
		// cmpValues.smartRefresh();
		// }
		// }

	}

	public void disposeData() {
	}

	public Viewer getViewer() {
		return resolveViewerFromWidget(super.currentFocusWidget);
	}

	@Override
	public Viewer[] getViewers() {
		return new Viewer[] { componentsTreeViewer, resourcesTableViewer,
				expressionComponent.getXtextEditor().getViewer() };
	}

	@Override
	public boolean isValid() {
		return true;
	}

	List<IAction> actionList = Lists.newArrayList();

	@Override
	public IAction[] getActions() {
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		String actionText = readonly ? "View..." : "Edit...";

		if (actionList.size() == 0) {

			actionList.add(new EditResourceAction(actionText));
			actionList.add(new AdjustToRangeAction("Adjust period..."));
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

		final ChartInput chartInput = new ChartInput();
		// create a chart show in.
		final ShowInContext showInContext = new ShowInContext(chartInput,
				selection);

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
		} else if (widget == expressionComponent.getXtextEditor().getViewer()
				.getTextWidget()) {
			return expressionComponent.getXtextEditor().getViewer()
					.getSelectionProvider();
		}

		return super.resolveSelectionProviderFromWidget(widget);
	}

	@Override
	protected Viewer resolveViewerFromWidget(Object widget) {

		if (widget == null) {
			return resourcesTableViewer;
		}

		if (widget == componentsTree) {
			return componentsTreeViewer;
		} else if (widget == resourcesTable) {
			return resourcesTableViewer;
		} else if (widget == expressionComponent.getXtextEditor().getViewer()
				.getTextWidget()) {
			return expressionComponent.getXtextEditor().getViewer();
		}
		return resourcesTableViewer;
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

		super.saveState(memento);

		// sash state vertical.
		mementoUtils.rememberSashForm(memento, sashVertical,
				MEM_KEY_NODERESOURCEADVANCED_SEPARATOR_VERTICAL);

		// sash state data.
		mementoUtils.rememberSashForm(memento, sashData,
				MEM_KEY_NODERESOURCEADVANCED_SEPARATOR_DATA);

		// combo operator.
		mementoUtils.rememberStructuredViewerSelection(memento,
				cmbViewerOperator,
				MEM_KEY_NODERESOURCEADVANCED_SELECTION_OPERATOR);

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
		if (memento != null) {

			try {
				super.restoreState(memento);

				mementoUtils.retrieveSashForm(memento, sashVertical,
						MEM_KEY_NODERESOURCEADVANCED_SEPARATOR_VERTICAL);
				mementoUtils.retrieveSashForm(memento, sashData,
						MEM_KEY_NODERESOURCEADVANCED_SEPARATOR_DATA);

				mementoUtils.retrieveStructuredViewerSelection(memento,
						cmbViewerOperator,
						MEM_KEY_NODERESOURCEADVANCED_SELECTION_OPERATOR,
						this.operatorResource.cdoView());

				mementoUtils.retrieveStructuredViewerSelection(memento,
						cmbViewerNetwork,
						MEM_KEY_NODERESOURCEADVANCED_SELECTION_NETWORK,
						this.operatorResource.cdoView());

				mementoUtils.retrieveStructuredViewerSelection(memento,
						cmbViewerNode,
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
			} catch (Exception e) {
				// Wrap in exception as UI change could restore wrong or non
				// existing components...
			}
		}
	}

	@Override
	protected void doHandleValueChange(ValueChangeEvent event) {
		// This is to notify the period
		monitoringAggregate.setPeriod(getPeriodComponent().getPeriod());
	}

}
