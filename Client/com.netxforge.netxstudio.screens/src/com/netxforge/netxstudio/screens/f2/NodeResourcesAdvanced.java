package com.netxforge.netxstudio.screens.f2;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

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
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.window.Window;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
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
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.interpreter.IInterpreterContext;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Function;
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
import com.netxforge.netxstudio.screens.CDateTimeObservableValue;
import com.netxforge.netxstudio.screens.SearchFilter;
import com.netxforge.netxstudio.screens.TableColumnFilter;
import com.netxforge.netxstudio.screens.ch9.EmbeddedLineExpression;
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
	private ComputedList computedResourcesList;
	private Button btnExpression;
	private TreeViewer componentsTreeViewer;
	// private ComputedList computedComponentsList;
	private Composite cmpExpressionSelector;
	private Composite cmpExpressionContext;
	private Table table;
	private TableViewer tblViewerContext;
	private TableColumn tblclmnType;
	private TableViewerColumn tblViewerClmnType;
	private TableColumn tblclmnValue;
	private TableViewerColumn tblViewerClmnValue;
	private ComputedList computedExpressionFeaturesList;
	private ExpressionAggregate expressionAggregate;
	private ContextAggregate contextAggregate;
	
//	private CDateTimeObservableValue fromTimeObservableValue;
//	private CDateTimeObservableValue toTimeObservableValue;

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
//		buildUI();
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

		SashForm sashComponentsValues = new SashForm(frmResources.getBody(),
				SWT.HORIZONTAL);
		sashComponentsValues.setLocation(0, 0);
		toolkit.adapt(sashComponentsValues);
		toolkit.paintBordersFor(sashComponentsValues);

		// A selection mechanism which allows
		// Shows a closure of all belong resources.
		//
		// 1. primary the operator.
		// 2. the network
		// 3.

		buildSelector(widgetStyle, sashComponentsValues);
		buildValues(sashComponentsValues);

		sashComponentsValues.setWeights(new int[] { 7, 3 });

	}

	private void buildSelector(int widgetStyle, Composite parent) {

		Composite cmpComponents = toolkit.createComposite(parent, SWT.NONE);
		GridLayout gl_cmpComponents = new GridLayout(2, false);
		gl_cmpComponents.marginWidth = 10;
		gl_cmpComponents.marginHeight = 2;
		gl_cmpComponents.verticalSpacing = 2;
		cmpComponents.setLayout(gl_cmpComponents);

		// Selector.
		Composite cmpSelector = toolkit.createComposite(cmpComponents,
				SWT.BORDER);
		cmpSelector.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false,
				1, 1));
		GridLayout gl_cmpSelector = new GridLayout(4, false);
		gl_cmpSelector.verticalSpacing = 0;
		gl_cmpSelector.marginWidth = 0;
		gl_cmpSelector.marginHeight = 10;
		cmpSelector.setLayout(gl_cmpSelector);

		lblOperator = toolkit.createLabel(cmpSelector, "Operator:", SWT.NONE);
		lblOperator.setAlignment(SWT.RIGHT);
		GridData gd_lblOperator = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblOperator.widthHint = 70;
		lblOperator.setLayoutData(gd_lblOperator);

		cmbViewerOperator = new ComboViewer(cmpSelector, SWT.NONE);
		cmbOperator = cmbViewerOperator.getCombo();
		GridData gd_cmbOperator = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_cmbOperator.widthHint = 200;
		cmbOperator.setLayoutData(gd_cmbOperator);
		cmbOperator.setBounds(0, 0, 26, 22);
		toolkit.paintBordersFor(cmbOperator);
		new Label(cmpSelector, SWT.NONE);
		toolkit.createLabel(cmpSelector, "");

		lblNetwork = toolkit.createLabel(cmpSelector, "Network:", SWT.NONE);
		lblNetwork.setAlignment(SWT.RIGHT);
		GridData gd_lblNetwork = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNetwork.widthHint = 70;
		lblNetwork.setLayoutData(gd_lblNetwork);

		cmbViewerNetwork = new ComboViewer(cmpSelector, SWT.NONE);
		cmbNetwork = cmbViewerNetwork.getCombo();
		GridData gd_cmbNetwork = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_cmbNetwork.widthHint = 200;
		cmbNetwork.setLayoutData(gd_cmbNetwork);
		toolkit.paintBordersFor(cmbNetwork);
		cmbNetwork.setEnabled(false);
		new Label(cmpSelector, SWT.NONE);
		toolkit.createLabel(cmpSelector, "");

		lblComponent = toolkit
				.createLabel(cmpSelector, "N. Element:", SWT.NONE);
		lblComponent.setAlignment(SWT.RIGHT);
		GridData gd_lblComponent = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblComponent.widthHint = 70;
		lblComponent.setLayoutData(gd_lblComponent);

		cmbViewerNode = new ComboViewer(cmpSelector, SWT.NONE);
		cmbNode = cmbViewerNode.getCombo();
		GridData gd_cmbNode = new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1);
		gd_cmbNode.widthHint = 200;
		cmbNode.setLayoutData(gd_cmbNode);
		toolkit.paintBordersFor(cmbNode);
		// cmbNode.setEnabled(false);
		new Label(cmpSelector, SWT.NONE);
		toolkit.createLabel(cmpSelector, "");

		// EXPRESSION SELECTOR, EDITOR and CONTEXT.

		Composite cmpExpression = toolkit.createComposite(cmpComponents,
				SWT.BORDER);
		GridLayout gl_cmpExpression = new GridLayout(2, false);
		// gl_cmpExpression.marginWidth = 10;
		// gl_cmpExpression.marginHeight = 2;
		// gl_cmpExpression.verticalSpacing = 2;
		cmpExpression.setLayout(gl_cmpExpression);
		cmpExpression.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));

		cmpExpressionSelector = new Composite(cmpExpression, SWT.NONE);
		cmpExpressionSelector.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				false, false, 2, 1));
		toolkit.adapt(cmpExpressionSelector);
		toolkit.paintBordersFor(cmpExpressionSelector);
		GridLayout gl_cmpExpressionSelector = new GridLayout(3, false);
		gl_cmpExpressionSelector.marginHeight = 10;
		gl_cmpExpressionSelector.marginWidth = 20;
		cmpExpressionSelector.setLayout(gl_cmpExpressionSelector);

		lblExpression = toolkit.createLabel(cmpExpressionSelector,
				"Expression: ", SWT.NONE);
		lblExpression.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblExpression.setAlignment(SWT.RIGHT);

		cmbViewerExpression = new ComboViewer(cmpExpressionSelector, SWT.NONE);
		cmbExpression = cmbViewerExpression.getCombo();
		GridData gd_cmbExpression = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1);
		gd_cmbExpression.widthHint = 200;
		cmbExpression.setLayoutData(gd_cmbExpression);

		toolkit.paintBordersFor(cmbExpression);

		btnExpression = new Button(cmpExpression, SWT.FLAT);
		btnExpression.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		btnExpression.setImage(ResourceManager.getPluginImage(
				"com.netxforge.netxstudio.models.edit",
				"icons/full/obj16/Expression_H.png"));

		btnExpression.setAlignment(SWT.RIGHT);
		toolkit.adapt(btnExpression, true, true);

		cmpExpressionHead = toolkit.createComposite(cmpExpression, SWT.BORDER);
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

		cmpExpressionContext = new Composite(cmpExpression, SWT.NONE);
		cmpExpressionContext.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				false, false, 2, 1));
		toolkit.adapt(cmpExpressionContext);
		toolkit.paintBordersFor(cmpExpressionContext);
		GridLayout gl_cmpExpressionContext = new GridLayout(3, false);
		// gl_cmpExpressionSelector.marginHeight = 10;
		// gl_cmpExpressionSelector.marginWidth = 20;
		cmpExpressionContext.setLayout(gl_cmpExpressionContext);

		periodComponent.buildUI(cmpExpressionContext, new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1));

//		periodComponent.getDateTimeFrom().addSelectionListener(
//				new SelectionAdapter() {
//					@Override
//					public void widgetSelected(SelectionEvent e) {
//						valueComponent.applyDateFilter(periodComponent
//								.getPeriod());
//					}
//				});

//		periodComponent.getDateTimeTo().addSelectionListener(
//				new SelectionAdapter() {
//					@Override
//					public void widgetSelected(SelectionEvent e) {
//						valueComponent.applyDateFilter(periodComponent
//								.getPeriod());
//					}
//				});

		@SuppressWarnings("unused")
		Label lblNewLabel = toolkit.createLabel(cmpExpressionContext,
				"Context Objects:", SWT.NONE);

		tblViewerContext = new TableViewer(cmpExpressionContext, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = tblViewerContext.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_table.heightHint = 60;
		table.setLayoutData(gd_table);
		toolkit.paintBordersFor(table);

		tblViewerClmnType = new TableViewerColumn(tblViewerContext, SWT.NONE);
		tblclmnType = tblViewerClmnType.getColumn();
		tblclmnType.setWidth(150);
		tblclmnType.setText("Type");

		tblViewerClmnValue = new TableViewerColumn(tblViewerContext, SWT.NONE);
		tblclmnValue = tblViewerClmnValue.getColumn();
		tblclmnValue.setWidth(250);
		tblclmnValue.setText("Value");

		// SASHFORM FOR COMPONENTS (Left) AND RESOURCES (Right).

		SashForm sashComponentResources = new SashForm(cmpComponents,
				SWT.HORIZONTAL);
		sashComponentResources.setLocation(0, 0);
		toolkit.adapt(sashComponentResources);
		toolkit.paintBordersFor(sashComponentResources);

		sashComponentResources.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				true, true, 2, 1));

		// COMPONENTS TREEVIEWER.

		componentsTreeViewer = new TreeViewer(sashComponentResources,
				SWT.BORDER | SWT.MULTI | widgetStyle);
		componentsTreeViewer.setUseHashlookup(true);
		componentsTreeViewer.setComparer(new CDOElementComparer());
		Tree tree = componentsTreeViewer.getTree();
		toolkit.paintBordersFor(tree);

		// RESOURCE TABLEVIEWER.

		// Bug having virtual with hashlookup etc...
		resourcesTableViewer = new TableViewer(sashComponentResources,
				SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		resourcesTable = resourcesTableViewer.getTable();
		// resourcesTableViewer.setUseHashlookup(true);
		// resourcesTableViewer.setComparer(new CDOElementComparer());
		resourcesTableViewer.addFilter(searchFilter);
		resourcesTable.setLinesVisible(true);
		resourcesTable.setHeaderVisible(true);

		// resourcesTable.setLayoutData();
		toolkit.paintBordersFor(resourcesTable);

		// WEIGHTDS FOR SASH.
		sashComponentResources.setWeights(new int[] { 2, 8 });

	}

	private void buildValues(SashForm sashForm) {

		valueComponent.configure(screenService);
		valueComponent.buildValuesUI(sashForm, new GridData(SWT.FILL, SWT.FILL,
				true, true, 1, 1));
	}

	public void buildColumns() {

		String[] properties = new String[] { "Component", "Long Name",
				"Metric", "Expression Name", "Unit" };

		String[] toolTips = new String[] { "Component holding resource",
				"The long name of the resource",
				"Metric used to create the resource",
				"The expression Name of the resource",
				"The unit of the resource" };

		int[] columnWidths = new int[] { 100, 200, 120, 120, 104, 68 };

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

		// buildTableColumns(properties, columnWidths, editingSupport);
	}

	/*
	 * Maintains the state of an expression.
	 */
	private final class ExpressionAggregate implements IValueChangeListener {

		private Component currentComponent;
		private EReference expressionFeature;
		private WritableValue expressionWritable = new WritableValue(null,
				EReference.class);

		public void handleValueChange(ValueChangeEvent event) {

			IObservable observable = event.getObservable();

			if (observable instanceof IViewerObservableValue) {
				IViewerObservableValue ivov = (IViewerObservableValue) observable;
				if (ivov.getViewer() == cmbViewerExpression) {
					expressionFeature = processExpressionChange(event
							.getObservableValue());
					expressionWritable.setValue(expressionFeature);
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

			if (expr != null) {
				expressionComponent.injectData(expr);
			}

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

		public WritableValue getExpressionObservable() {
			return expressionWritable;
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

//		public void initialize(DateTimeRange dtr) {
//			this.dtr = dtr;
//		}

		public void handleValueChange(ValueChangeEvent event) {

			// System.out.println("context aggregate value="
			// + event.getObservableValue().getValue());

			IObservable observable = event.getObservable();
			if (observable instanceof CDateTimeObservableValue) {
				CDateTime dateTime = ((CDateTimeObservableValue) observable)
						.getDateTime();
				if (dateTime == periodComponent.getDateTimeFrom()) {
					dtr.setBegin(modelUtils.toXMLDate(dateTime.getSelection()));
				} else if (dateTime == periodComponent.getDateTimeTo()) {
					dtr.setEnd(modelUtils.toXMLDate(dateTime.getSelection()));
				}
			} else if (observable instanceof IViewerObservableValue) {
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
				if (value instanceof EReference) {
					this.currentExpressionFeature = (EReference) value;
				}
			}

			handleChange();

		}

		private void handleChange() {
			printData();
			// build the context.
			ImmutableList<IInterpreterContext> contextList = null;
			if (currentExpressionFeature == LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF) {
				if (currentComponent != null) {
					contextList = expressionComponent.buildContext(dtr,
							currentComponent);
				}
			}

			if (contextList != null) {
				contextWritableList.clear();
				contextWritableList.addAll(contextList);
			}
		}

		public WritableList getContextWritableList() {
			return contextWritableList;
		}

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

		IEMFListProperty nodeTypeList = EMFProperties.multiList(FeaturePath
				.fromList(OperatorsPackage.Literals.NODE__NODE_TYPE,
						LibraryPackage.Literals.NODE_TYPE__FUNCTIONS),
				FeaturePath.fromList(OperatorsPackage.Literals.NODE__NODE_TYPE,
						LibraryPackage.Literals.NODE_TYPE__EQUIPMENTS));

		componentsTreeViewer.setLabelProvider(new NetworkTreeLabelProvider());
		componentsTreeViewer.setInput(nodeTypeList
				.observeDetail(observeNodeSelection));

		// COMPONENT MULTIPLE SELECTION OBSERVABLE.
		// To populate the resources table.
		final IViewerObservableList observeMultipleComponentSelection = ViewersObservables
				.observeMultiSelection(componentsTreeViewer);

		// COMPONENT SINGLE SELECTION OBSERVABLE
		final IViewerObservableValue observeSingleComponentSelection = ViewersObservables
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

		resourcesTableViewer.setInput(computedResourcesList);

		final IViewerObservableValue observeResourceSelection = ViewersObservables
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
						valueComponent.injectData((BaseResource) value);
					} else {
						valueComponent.injectData(null);
					}
				}
			}
		});

		bindingContext.bindValue(observeResourceSelection,
				valueWritableObservable);

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

//		fromTimeObservableValue = new CDateTimeObservableValue(
//				periodComponent.getDateTimeFrom());
//		fromTimeObservableValue.addValueChangeListener(contextAggregate);

//		toTimeObservableValue = new CDateTimeObservableValue(
//				periodComponent.getDateTimeTo());
//		toTimeObservableValue.addValueChangeListener(contextAggregate);
		
		WritableValue fromTimeWritable = new WritableValue();
		WritableValue toTimeWritable = new WritableValue();
		
//		bindingContext.bindValue(fromTimeObservableValue,fromTimeWritable);
//		bindingContext.bindValue(toTimeObservableValue,toTimeWritable);
		
		// defaults to last month, note: this will not be picked up by the
		// observables,
		// so set the observable value manually.
		periodComponent.presetLastMonth();
		fromTimeWritable.setValue(modelUtils.fromXMLDate(periodComponent.getPeriod().getBegin()));
		toTimeWritable.setValue(modelUtils.fromXMLDate(periodComponent.getPeriod().getEnd()));
		
//		contextAggregate.initialize(periodComponent.getPeriod());

		observerExpressionFeature.addValueChangeListener(contextAggregate);
		observeSingleComponentSelection
				.addValueChangeListener(contextAggregate);
		observeResourceSelection.addValueChangeListener(contextAggregate);
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
					int columnIndex = cell.getColumnIndex();
					switch (columnIndex) {
					case 0: {
						cell.setText("type "
								+ context.getClass().getSimpleName());
					}
						break;
					case 1: {
						cell.setText("value "
								+ modelUtils.printModelObject((EObject) context
										.getContext()));
					}
						break;
					}
				}
			}

		});
		tblViewerContext.setInput(contextAggregate.getContextWritableList());
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
