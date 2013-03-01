/*******************************************************************************
 * Copyright (c) Jun 25, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.f4;

import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.editing.filter.SearchFilter;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.f4.support.MetricTreeFactory;
import com.netxforge.netxstudio.screens.f4.support.MetricTreeLabelProvider;
import com.netxforge.netxstudio.screens.f4.support.MetricTreeStructureAdvisor;

public class Metrics extends AbstractScreen implements IDataServiceInjection {

	private static final String MEM_KEY_METRIC_SELECTION_TABLE = "MEM_KEY_METRIC_SELECTION_TABLE";
	private static final String MEM_KEY_METRIC_COLUMNS_TABLE = "MEM_KEY_METRIC_COLUMNS_TABLE";

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;
	private Resource metricResource;
	@SuppressWarnings("unused")
	private EMFDataBindingContext bindingContext;
	private Form frmMetrics;
	private TreeViewer metricsTreeViewer;
	private ObservableListTreeContentProvider listTreeContentProvider;

	@Inject
	private SearchFilter searchFilter;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public Metrics(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		// this.buildUI();
	}

	public EMFDataBindingContext initDataBindings_() {

		listTreeContentProvider = new ObservableListTreeContentProvider(
				new MetricTreeFactory(editingService.getEditingDomain()),
				new MetricTreeStructureAdvisor());
		metricsTreeViewer.setContentProvider(listTreeContentProvider);
		IObservableSet set = listTreeContentProvider.getKnownElements();

		IObservableMap[] map = new IObservableMap[2];

		map[0] = EMFProperties.value(MetricsPackage.Literals.METRIC__NAME)
				.observeDetail(set);

		map[1] = EMFProperties.value(
				MetricsPackage.Literals.METRIC__DESCRIPTION).observeDetail(set);

		metricsTreeViewer.setLabelProvider(new MetricTreeLabelProvider(map));

		IEMFListProperty metricsProperty = EMFEditProperties
				.resource(editingService.getEditingDomain());
		IObservableList metricsObservableList = metricsProperty
				.observe(metricResource);
		metricsTreeViewer.setInput(metricsObservableList);
		EMFDataBindingContext context = new EMFDataBindingContext();
		return context;
	}

	public void injectData() {
		metricResource = editingService.getData(MetricsPackage.Literals.METRIC);
		buildUI();
		bindingContext = initDataBindings_();
	}

	private void buildUI() {

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		String actionText = readonly ? "View: " : "Edit: ";

		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmMetrics = toolkit.createForm(this);
		frmMetrics.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmMetrics);
		frmMetrics.setText(actionText + "Metrics");
		frmMetrics.getBody().setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(frmMetrics.getBody(),
				"Filter:", SWT.NONE);
		lblFilterLabel.setAlignment(SWT.RIGHT);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 36;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmMetrics.getBody(), "New Text",
				SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				ViewerFilter[] filters = metricsTreeViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof SearchFilter) {
						((SearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
				metricsTreeViewer.refresh();
			}
		});
		txtFilterText.setText("");

		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);

		if (!readonly) {

			ImageHyperlink mghprlnkNewMetric = toolkit.createImageHyperlink(
					frmMetrics.getBody(), SWT.NONE);
			mghprlnkNewMetric.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					if (screenService != null) {
						ISelection selection = getViewer().getSelection();
						if (selection instanceof IStructuredSelection) {
							Object subowner = ((IStructuredSelection) selection)
									.getFirstElement();
							NewEditMetric metricScreen = new NewEditMetric(
									screenService.getScreenContainer(),
									SWT.NONE);
							metricScreen.setOperation(ScreenUtil.OPERATION_NEW);
							metricScreen.setScreenService(screenService);
							Metric metric = MetricsFactory.eINSTANCE
									.createMetric();
							// metricScreen.injectData(metricResource, metric);
							metricScreen.injectData(metricResource, subowner,
									metric);
							screenService.setActiveScreen(metricScreen);
						}
					}
				}

				public void linkEntered(HyperlinkEvent e) {
				}

				public void linkExited(HyperlinkEvent e) {
				}
			});
			mghprlnkNewMetric.setImage(ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/ctool16/Metric_E.png"));
			toolkit.paintBordersFor(mghprlnkNewMetric);
			mghprlnkNewMetric.setText("New");
		}
		metricsTreeViewer = new TreeViewer(frmMetrics.getBody(), SWT.BORDER
				| SWT.VIRTUAL | SWT.MULTI | SWT.FULL_SELECTION);
		metricsTreeViewer.setUseHashlookup(true);
		metricsTreeViewer.setComparer(new CDOElementComparer());

		Tree tree = metricsTreeViewer.getTree();
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		toolkit.paintBordersFor(tree);

		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(
				metricsTreeViewer, SWT.NONE);
		TreeColumn trclmnName = treeViewerColumn.getColumn();
		trclmnName.setWidth(300);
		trclmnName.setText("Name");

		TreeViewerColumn treeViewerColumn_1 = new TreeViewerColumn(
				metricsTreeViewer, SWT.NONE);
		TreeColumn trclmnDescription = treeViewerColumn_1.getColumn();
		trclmnDescription.setWidth(270);
		trclmnDescription.setText("Description");

		TreeViewerColumn treeViewerColumn_2 = new TreeViewerColumn(
				metricsTreeViewer, SWT.NONE);
		TreeColumn trclmnUnit = treeViewerColumn_2.getColumn();
		trclmnUnit.setWidth(84);
		trclmnUnit.setText("Unit");

		metricsTreeViewer.addFilter(searchFilter);
	}

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class EditMetricAction extends Action {

		public EditMetricAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			super.run();
			if (screenService != null) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					NewEditMetric metricScreen = new NewEditMetric(
							screenService.getScreenContainer(), SWT.NONE);
					metricScreen.setScreenService(screenService);
					metricScreen.setOperation(getOperation());
					Object subowner = null;
					if (o instanceof Metric) {
						if (((Metric) o).eContainer() instanceof Metric) {
							subowner = ((Metric) o).eContainer();
						}
					}
					metricScreen.injectData(metricResource, subowner, o);
					screenService.setActiveScreen(metricScreen);
				}
			}
		}
	}

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class ValuesForMetricAction extends Action {

		public ValuesForMetricAction(String text) {
			super(text);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void run() {
			super.run();
			if (screenService != null) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {

					List<Metric> metrics = Lists
							.newArrayList(((IStructuredSelection) selection)
									.iterator());
					List<NetXResource> resources = modelUtils
							.resourcesForMetrics(metrics);

					// TODO, Invoke a dialog to select a DTR and Interval.

					DateTimeRange dtr = GenericsFactory.eINSTANCE
							.createDateTimeRange();
					int targetIntervalHint = ModelUtils.MINUTES_IN_AN_HOUR;

					System.out.println("VALUES FOR PERIOD:");

					System.out.println("FROM="
							+ modelUtils.dateAndTime(dtr.getBegin()));
					System.out.println("TO="
							+ modelUtils.dateAndTime(dtr.getEnd()));

					int valueCount = 0;
					for (NetXResource res : resources) {
						System.out.println("values for resource: "
								+ res.getShortName() + "on Component"
								+ res.getComponentRef().getName());

						List<Value> values = modelUtils
								.valuesForIntervalKindAndPeriod(res,
										targetIntervalHint, null, dtr);
						if (values.size() > 0) {
							valueCount += values.size();
							System.out.println("number of values "
									+ Iterables.size(values));
							for (Value v : values) {
								System.out.println(modelUtils.fromXMLDate(v
										.getTimeStamp()) + ":" + v.getValue());
							}
						}
					}
					System.out.println("total values for this import = "
							+ valueCount);
				}
			}
		}
	}

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class NewMetricAction extends Action {

		public NewMetricAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			super.run();
			if (screenService != null) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object subowner = ((IStructuredSelection) selection)
							.getFirstElement();

					NewEditMetric metricScreen = new NewEditMetric(
							screenService.getScreenContainer(), SWT.NONE);
					metricScreen.setOperation(ScreenUtil.OPERATION_NEW);
					metricScreen.setScreenService(screenService);
					Metric metric = MetricsFactory.eINSTANCE.createMetric();
					metricScreen.injectData(metricResource, subowner, metric);
					screenService.setActiveScreen(metricScreen);
				}
			}
		}
	}

	public Viewer getViewer() {
		return metricsTreeViewer;
	}

	@Override
	public boolean isValid() {
		return false;
	}

	public Form getScreenForm() {
		return this.frmMetrics;
	}

	private final List<IAction> actions = Lists.newArrayList();

	@Override
	public IAction[] getActions() {

		// lazy init actions.
		if (actions.isEmpty()) {
			String actionText = ScreenUtil.isReadOnlyOperation(getOperation()) ? "View"
					: "Edit";
			actions.add(new EditMetricAction(actionText + "..."));
			// if(!Screens.isReadOnlyOperation(getOperation())){
			// actions.add(new NewMetricAction("New...",
			// SWT.PUSH));
			// }

		}
		return actions.toArray(new IAction[actions.size()]);
	}

	@Override
	public String getScreenName() {
		return "Metrics";
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
		mementoUtils.rememberStructuredViewerSelection(memento,
				metricsTreeViewer, MEM_KEY_METRIC_SELECTION_TABLE);
		mementoUtils.rememberStructuredViewerColumns(memento,
				metricsTreeViewer, MEM_KEY_METRIC_COLUMNS_TABLE);
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
			mementoUtils.retrieveStructuredViewerSelection(memento,
					metricsTreeViewer, MEM_KEY_METRIC_SELECTION_TABLE,
					((CDOResource) metricResource).cdoView());
			mementoUtils.retrieveStructuredViewerColumns(memento,
					metricsTreeViewer, MEM_KEY_METRIC_COLUMNS_TABLE);
		}
	}

}
