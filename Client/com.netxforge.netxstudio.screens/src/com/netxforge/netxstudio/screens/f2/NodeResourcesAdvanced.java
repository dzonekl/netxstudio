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
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.TreeViewerEditor;
import org.eclipse.jface.viewers.TreeViewerFocusCellManager;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
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
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.ISaveablePart2;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.engine.IExpressionEngine;
import com.netxforge.interpreter.IInterpreterContext;
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
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.ScreenDialog;
import com.netxforge.netxstudio.screens.SearchFilter;
import com.netxforge.netxstudio.screens.TableColumnFilter;
import com.netxforge.netxstudio.screens.ch9.EmbeddedLineExpression;
import com.netxforge.netxstudio.screens.ch9.ObjectExpressions;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.f3.support.NetworkTreeLabelProvider;
import com.netxforge.netxstudio.screens.tables.TableHelper;

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
	private TableHelper tableHelper;

	@Inject
	private SearchFilter searchFilter;

	@Inject
	private ValueComponentII cmpValues;

	@Inject
	private PeriodComponent periodComponent;

	@Inject
	private EmbeddedLineExpression expressionComponent;

	private IExpressionEngine expressionEngine = expressionComponent
			.getNetxScriptInjector().getInstance(IExpressionEngine.class);

	private ResultProcessor resultProcessor = expressionComponent
			.getNetxScriptInjector().getInstance(ResultProcessor.class);

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

	private Resource operatorResource;
	private NetXResourceObervableMapLabelProvider netXResourceObervableMapLabelProvider;

	private Button btnExpressionTest;

	protected TableViewer resourcesTableViewer;
	private Table resourcesTable;

	private AccessToRowsTreeViewer componentsTreeViewer;
	private Composite cmpExpressionContext;

	private TableViewer tblViewerContext;
	private TableColumn tblclmnType;
	private TableViewerColumn tblViewerClmnType;
	private TableColumn tblclmnValue;
	private TableViewerColumn tblViewerClmnValue;

	private ComputedList computedResourcesList;
	private ComputedList computedExpressionFeaturesList;

	private ExpressionAggregate expressionAggregate;
	private ContextAggregate contextAggregate;

	private IViewerObservableValue observeSingleComponentSelection;
	private IViewerObservableValue observeResourceSingleSelection;
	private WritableValue periodBeginWritableValue;
	private WritableValue periodEndWritableValue;

	// private CDateTimeObservableValue fromTimeObservableValue;
	// private CDateTimeObservableValue toTimeObservableValue;

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

		SashForm sashRoot = new SashForm(frmResources.getBody(), SWT.HORIZONTAL
				| SWT.SMOOTH);
		sashRoot.setLocation(0, 0);
		toolkit.adapt(sashRoot);
		toolkit.paintBordersFor(sashRoot);

		Composite cmpLeft = toolkit.createComposite(sashRoot, SWT.NONE);
		GridLayout gl_cmpLeft = new GridLayout(1, false);
		gl_cmpLeft.marginLeft = 10;
		gl_cmpLeft.marginHeight = 10;
		gl_cmpLeft.marginRight = 0;
		cmpLeft.setLayout(gl_cmpLeft);

		buildComponentSelector(cmpLeft, new GridData(SWT.FILL, SWT.TOP, true,
				false, 1, 1), widgetStyle);
		buildComponentViewer(cmpLeft, new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1), widgetStyle);

		Composite cmpRight = toolkit.createComposite(sashRoot, SWT.NONE);
		GridLayout gl_cmpRight = new GridLayout(1, false);
		gl_cmpRight.marginRight = 10;
		gl_cmpRight.marginHeight = 10;
		gl_cmpRight.marginLeft = 0;

		cmpRight.setLayout(gl_cmpRight);
		toolkit.adapt(cmpRight);
		toolkit.paintBordersFor(cmpRight);

		sashRoot.setWeights(new int[] { 2, 8 });

		buildExpressionSelector(cmpRight, new GridData(SWT.FILL, SWT.FILL,
				true, false, 1, 1), widgetStyle);

		SashForm sashComponentResources = new SashForm(cmpRight, SWT.HORIZONTAL);

		sashComponentResources.setLocation(0, 0);
		sashComponentResources.setSashWidth(1);
		toolkit.adapt(sashComponentResources);
		toolkit.paintBordersFor(sashComponentResources);

		sashComponentResources.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				true, true, 1, 1));

		buildResourceViewer(sashComponentResources, widgetStyle);
		buildValues(sashComponentResources);

		// WEIGHTDS FOR SASH.
		sashComponentResources.setWeights(new int[] { 5, 5 });
	}

	private void buildResourceViewer(SashForm sashComponentResources,
			int widgetStyle) {
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

	private void buildComponentViewer(Composite parent,
			GridData gd_componentsTreeViewer, int widgetStyle) {
		// COMPONENTS TREEVIEWER.

		componentsTreeViewer = new AccessToRowsTreeViewer(parent, SWT.BORDER
				| SWT.MULTI | widgetStyle);
		componentsTreeViewer.setUseHashlookup(true);
		componentsTreeViewer.setComparer(new CDOElementComparer());
		Tree tree = componentsTreeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		tree.setLayoutData(gd_componentsTreeViewer);
		toolkit.paintBordersFor(tree);

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

		// Cell navigation.

		// CB Remove later, default cell navigation works ok.
		// CellNavigationStrategy navigationStrategy = new
		// CellNavigationStrategy() {
		// public ViewerCell findSelectedCell(ColumnViewer viewer,
		// ViewerCell currentSelectedCell, Event event) {
		// ViewerCell cell = super.findSelectedCell(viewer,
		// currentSelectedCell, event);
		//
		// if (cell != null) {
		// componentsTreeViewer.getTree().showColumn(
		// componentsTreeViewer.getTree().getColumn(
		// cell.getColumnIndex()));
		// }
		// return cell;
		// }
		//
		// // TODO, decide how to expand and collapse, the default
		// // strategy will not allow expand and collapse using Arrow Right and
		// Left.
		//
		// @Override
		// public boolean isCollapseEvent(ColumnViewer viewer,
		// ViewerCell cellToCollapse, Event event) {
		// return super.isCollapseEvent(viewer, cellToCollapse, event);
		// }
		//
		// @Override
		// public boolean isExpandEvent(ColumnViewer viewer,
		// ViewerCell cellToExpand, Event event) {
		// return super.isExpandEvent(viewer, cellToExpand, event);
		// }
		//
		//
		//
		// };

		// Could potentially use a custom FocusCellOwnerDrawHighlighter which
		// could show a handle.
		TreeViewerFocusCellManager componentsFocusCellManager = new TreeViewerFocusCellManager(
				componentsTreeViewer,
				new FocusCellOwnerDrawHighlighterForMultiselection(
						componentsTreeViewer));

		ColumnViewerEditorActivationStrategy actSupport = new ColumnViewerEditorActivationStrategy(
				componentsTreeViewer) {
			protected boolean isEditorActivationEvent(
					ColumnViewerEditorActivationEvent event) {
				// return false;

				return event.eventType == ColumnViewerEditorActivationEvent.TRAVERSAL
						|| event.eventType == ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION
						|| (event.eventType == ColumnViewerEditorActivationEvent.KEY_PRESSED && event.keyCode == SWT.CR)
						|| event.eventType == ColumnViewerEditorActivationEvent.PROGRAMMATIC;
			}
		};

		TreeViewerEditor.create(componentsTreeViewer,
				componentsFocusCellManager, actSupport,
				ColumnViewerEditor.TABBING_HORIZONTAL
						| ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR
						| ColumnViewerEditor.TABBING_VERTICAL
						| ColumnViewerEditor.KEYBOARD_ACTIVATION);

		// componentsTreeViewer.getColumnViewerEditor()
		// .addEditorActivationListener(
		// new ColumnViewerEditorActivationListener() {
		// public void afterEditorActivated(
		// ColumnViewerEditorActivationEvent event) {
		// }
		//
		// public void afterEditorDeactivated(
		// ColumnViewerEditorDeactivationEvent event) {
		// }
		//
		// public void beforeEditorActivated(
		// ColumnViewerEditorActivationEvent event) {
		// ViewerCell cell = (ViewerCell) event
		// .getSource();
		// componentsTreeViewer.getTree().showColumn(
		// componentsTreeViewer.getTree()
		// .getColumn(
		// cell.getColumnIndex()));
		// }
		//
		// public void beforeEditorDeactivated(
		// ColumnViewerEditorDeactivationEvent event) {
		// }
		// });

	}

	private void buildComponentSelector(Composite parent, GridData gridData,
			int widgetStyle) {
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
			GridData gridData, int widgetStyle) {

		Composite cmpExpression = toolkit.createComposite(cmpComponents,
				SWT.NONE);

		cmpExpression.setLayoutData(gridData);
		GridLayout gl_cmpExpression = new GridLayout(3, false);
		gl_cmpExpression.marginHeight = 0;
		gl_cmpExpression.marginWidth = 0;
		cmpExpression.setLayout(gl_cmpExpression);

		btnExpressionTest = new Button(cmpExpression, SWT.FLAT);
		btnExpressionTest.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
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

				if (expression != null) {
					expressionEngine.getContext().clear();
					expressionEngine.getContext().addAll(
							contextAggregate.getContextObjects());
					expressionEngine.setExpression(expression);
					expressionEngine.run();
					if (expressionEngine.errorOccurred()) {
						// stop here will be logged
						throw new IllegalStateException(expressionEngine
								.getThrowable());
					}
					final List<BaseExpressionResult> result = expressionEngine
							.getExpressionResult();

					DateTimeRange period = contextAggregate.getPeriod();
					Date start = modelUtils.fromXMLDate(period.getBegin());
					Date end = modelUtils.fromXMLDate(period.getEnd());

					// TODO Annoying to have to provide the start and end date,
					// as this is already in the context.
					resultProcessor.processMonitoringResult(
							expressionEngine.getContext(), result, start, end);

					cmpValues.getValuesTableViewer().refresh(true);
					
					// update our view part dirty state, as we don't use the editing domain. 
					screenService.getAbsViewPart().publicFirePropertyChange(ISaveablePart2.PROP_DIRTY);
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

		cmbExpression = new Combo(cmpExpression, SWT.READ_ONLY);
		cmbViewerExpression = new ComboViewer(cmbExpression);
		GridData gd_cmbExpression = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_cmbExpression.widthHint = 145;
		cmbExpression.setLayoutData(gd_cmbExpression);

		toolkit.paintBordersFor(cmbExpression);

		cmpExpressionEditor = toolkit
				.createComposite(cmpExpression, SWT.BORDER);
		GridData gd_cmpExpressionHead = new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1);
		gd_cmpExpressionHead.heightHint = 16;
		cmpExpressionEditor.setLayoutData(gd_cmpExpressionHead);

		toolkit.paintBordersFor(cmpExpressionEditor);

		GridLayout gl_cmpExpressionHead = new GridLayout(1, false);
		gl_cmpExpressionHead.verticalSpacing = 0;
		gl_cmpExpressionHead.marginWidth = 0;
		gl_cmpExpressionHead.marginHeight = 0;
		cmpExpressionEditor.setLayout(gl_cmpExpressionHead);

		expressionComponent.buildExpression(widgetStyle, cmpExpressionEditor,
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		expressionComponent.configure(editingService, this.getOperation());

		cmpExpressionContext = new Composite(cmpExpression, SWT.NONE);
		cmpExpressionContext.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				false, false, 4, 1));
		toolkit.adapt(cmpExpressionContext);
		toolkit.paintBordersFor(cmpExpressionContext);
		GridLayout gl_cmpExpressionContext = new GridLayout(2, false);
		gl_cmpExpressionContext.marginHeight = 0;
		gl_cmpExpressionContext.marginWidth = 0;
		cmpExpressionContext.setLayout(gl_cmpExpressionContext);

		GridData gd_periodContext = new GridData(SWT.LEFT, SWT.TOP, false,
				false, 1, 1);
		gd_periodContext.heightHint = 80;
		gd_periodContext.widthHint = 170;
		periodComponent.buildUI(cmpExpressionContext, gd_periodContext);
		
		// Remove the context 
		tblViewerContext = new TableViewer(cmpExpressionContext, SWT.BORDER
				| SWT.FULL_SELECTION);
		Table tblContext = tblViewerContext.getTable();
		tblContext.setHeaderVisible(true);
		tblContext.setLinesVisible(true);
		// gd_table.heightHint = 100;
		tblContext.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));
		toolkit.paintBordersFor(tblContext);

		tblViewerClmnType = new TableViewerColumn(tblViewerContext, SWT.NONE);
		tblclmnType = tblViewerClmnType.getColumn();
		tblclmnType.setWidth(150);
		tblclmnType.setText("Type");

		tblViewerClmnValue = new TableViewerColumn(tblViewerContext, SWT.NONE);
		tblclmnValue = tblViewerClmnValue.getColumn();
		tblclmnValue.setWidth(250);
		tblclmnValue.setText("Value");
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

	/*
	 * Maintains the state of an expression.
	 */
	private final class ExpressionAggregate implements IValueChangeListener {

		private Component currentComponent;
		private EReference expressionFeature;

		private WritableValue exprFeatureWritable = new WritableValue(null,
				EReference.class);

		private WritableValue exprWritable = new WritableValue(null,
				Expression.class);

		public void handleValueChange(ValueChangeEvent event) {

			IObservable observable = event.getObservable();

			System.out.println("Observable called for = "
					+ event.getObservableValue().getValue());
			if (observable instanceof IViewerObservableValue) {
				IViewerObservableValue ivov = (IViewerObservableValue) observable;
				if (ivov.getViewer() == cmbViewerExpression) {
					expressionFeature = processExpressionChange(event
							.getObservableValue());
					exprFeatureWritable.setValue(expressionFeature);
				} else if (ivov.getViewer() == componentsTreeViewer) {
					currentComponent = processComponentChange(event
							.getObservableValue());
				}
			}

			// After a change, we inject the new expression.
			handleChange();
		}

		private void handleChange() {

			Expression expr = null;

			if (expressionFeature != null
					&& expressionFeature.getEReferenceType() == LibraryPackage.Literals.EXPRESSION) {

				if (expressionFeature.getEContainingClass() == LibraryPackage.Literals.TOLERANCE) {
					// TODO, get applicable tolerances first, need a
					// selector for this....
				} else if (expressionFeature.getEContainingClass() == LibraryPackage.Literals.COMPONENT) {
					if (currentComponent != null
							&& currentComponent.eIsSet(expressionFeature)) {
						expr = (Expression) currentComponent
								.eGet(expressionFeature);
					}
				} else if (expressionFeature.getEContainingClass() == MetricsPackage.Literals.METRIC_RETENTION_RULE) {
					// TODO, get applicable retention type first, need a
					// selector for this.
				}
			}

			if (expr == null) {
				if (currentComponent != null && expressionFeature != null) {
					expr = createExpression(currentComponent, expressionFeature);
					Resource expressionsResource = editingService
							.getData(LibraryPackage.Literals.EXPRESSION);
					expressionComponent.injectData(expressionsResource, expr,
							currentComponent, expressionFeature);
					return;
				} else {
					return;
				}
			}
			exprWritable.setValue(expr);
			expressionComponent.injectData(expr.eResource(), expr);

		}

		private Expression createExpression(EObject target,
				EStructuralFeature feature) {

			Expression expression = LibraryFactory.eINSTANCE.createExpression();

			String cName = target instanceof Function ? ((Function) target)
					.getName()
					: target instanceof Equipment ? ((Equipment) target)
							.getEquipmentCode() : "Unkwnown";

			String name = " Generated_" + cName + "_" + feature.getName();
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

		private EReference processExpressionChange(IObservableValue ob) {
			EReference eRef = null;
			Object value = ob.getValue();
			// Expecting an ERef with target EType Expression.
			if (value instanceof EReference) {
				eRef = (EReference) value;
			}
			return eRef;
		}

		WritableValue getExpressionFeatureObservable() {
			return exprFeatureWritable;
		}

		WritableValue getExpressionObservable() {
			return exprWritable;
		}

	}

	/*
	 * Maintains the state of a context for expressione execution.
	 */
	private final class ContextAggregate implements IValueChangeListener {

		private DateTimeRange dtr = GenericsFactory.eINSTANCE
				.createDateTimeRange();
		private Component currentComponent = null;
		private NetXResource currentNetXResource = null;
		private EReference currentExpressionFeature = null;

		private WritableList contextWritableList = new WritableList();
		private Expression currentExpression;

		public DateTimeRange getPeriod() {
			return dtr;
		}

		public void handleValueChange(ValueChangeEvent event) {

			// System.out.println("context aggregate value="
			// + event.getObservableValue().getValue());

			IObservable observable = event.getObservable();
			// if (observable instanceof CDateTimeObservableValue) {
			// CDateTime dateTime = ((CDateTimeObservableValue) observable)
			// .getDateTime();
			// if (dateTime == periodComponent.getDateTimeFrom()) {
			// dtr.setBegin(modelUtils.toXMLDate(dateTime.getSelection()));
			// } else if (dateTime == periodComponent.getDateTimeTo()) {
			// dtr.setEnd(modelUtils.toXMLDate(dateTime.getSelection()));
			// }
			// } else
			if (observable instanceof IViewerObservableValue) {
				IViewerObservableValue ivov = (IViewerObservableValue) observable;
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
			ImmutableList<IInterpreterContext> contextList = null;
			if (currentExpressionFeature == LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF) {
				if (currentComponent != null) {
					contextList = expressionComponent.buildContext(dtr,
							currentComponent);
				}
			} else if (currentExpressionFeature == LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF) {
				if (currentNetXResource != null) {
					contextList = expressionComponent.buildContext(dtr,
							currentNetXResource);
				}
			}

			contextWritableList.clear();
			if (contextList != null) {
				contextWritableList.addAll(contextList);
			}

			// execute the expression in the background.
			if (currentExpression != null && contextList != null
					&& contextList.size() > 0) {
				btnExpressionTest.setEnabled(true);
			} else {
				btnExpressionTest.setEnabled(false);
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

		private NetXResource processResourceChange(IObservableValue ob) {
			NetXResource r = null;
			Object value = ob.getValue();
			if (value instanceof NetXResource) {
				r = (NetXResource) value;
			}
			return r;
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

		final IViewerObservableValue observeNodeSelection = ViewersObservables
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
				System.out.println(" update resource here. "
						+ event.getSource());
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
		expressionAggregate = new ExpressionAggregate();

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
		observeSingleComponentSelection
				.addValueChangeListener(contextAggregate);
		observeResourceSingleSelection.addValueChangeListener(contextAggregate);

		expressionAggregate.getExpressionFeatureObservable()
				.addValueChangeListener(contextAggregate);

		expressionAggregate.getExpressionObservable().addValueChangeListener(
				contextAggregate);

		// bind the result to a Writable value.
		ObservableListContentProvider contextListContentProvider = new ObservableListContentProvider();
		tblViewerContext.setContentProvider(contextListContentProvider);
		tblViewerContext.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				Object element = cell.getElement();

				if (element instanceof IInterpreterContext) {
					IInterpreterContext context = (IInterpreterContext) element;
					Object contextObject = context.getContext();
					if (contextObject != null) {
						int columnIndex = cell.getColumnIndex();
						switch (columnIndex) {
						case 0: {
							cell.setText(" "
									+ contextObject.getClass().getSimpleName());
						}
							break;
						case 1: {

							String text = "";

							if (contextObject instanceof Function) {
								text = ((Function) contextObject).getName();
							} else if (contextObject instanceof Equipment) {
								text = ((Equipment) contextObject)
										.getEquipmentCode();
							} else if (contextObject instanceof Node) {
								text = ((Node) contextObject).getNodeID();
							} else if (contextObject instanceof NetXResource) {
								text = ((NetXResource) contextObject)
										.getShortName();
							} else if (contextObject instanceof DateTimeRange) {
								DateTimeRange dtr = (DateTimeRange) contextObject;
								Date start = modelUtils.fromXMLDate(dtr
										.getBegin());
								Date end = modelUtils.fromXMLDate(dtr.getEnd());

								text = modelUtils.date(start) + " ("
										+ modelUtils.time(start) + ")"
										+ " --> " + modelUtils.date(end) + " ("
										+ modelUtils.time(end) + ")";
							}
							cell.setText(text);
						}
							break;
						}
					} else {
						cell.setText("Error, context object not set");
					}
				}
			}

		});
		tblViewerContext.setInput(contextAggregate.getContextWritableList());

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
			// FIXME maps have no effect here.

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

		operatorResource = editingService
				.getData(OperatorsPackage.Literals.OPERATOR);

		buildUI();
		initDataBindings_();
	}

	public void disposeData() {
	}

	public Viewer getViewer() {
		return resourcesTableViewer;
	}

	@Override
	public Viewer[] getViewers() {
		return new Viewer[] { resourcesTableViewer };
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
