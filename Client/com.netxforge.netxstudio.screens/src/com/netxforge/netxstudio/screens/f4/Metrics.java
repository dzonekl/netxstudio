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

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.google.inject.Inject;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.SearchFilter;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f4.support.MetricTreeFactory;
import com.netxforge.netxstudio.screens.f4.support.MetricTreeLabelProvider;
import com.netxforge.netxstudio.screens.f4.support.MetricTreeStructureAdvisor;

public class Metrics extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;
	private Resource metricResource;
	@SuppressWarnings("unused")
	private EMFDataBindingContext bindingContext;
	private Form frmMetrics;
	private TreeViewer metricsTreeViewer;
	// private ObservablesManager mgr;
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
				disposeData();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmMetrics = toolkit.createForm(this);
		frmMetrics.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmMetrics);
		frmMetrics.setText("Metrics");
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
				metricsTreeViewer.refresh();
				ViewerFilter[] filters = metricsTreeViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof SearchFilter) {
						((SearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
			}
		});
		txtFilterText.setText("");

		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);

		ImageHyperlink mghprlnkNewMetric = toolkit.createImageHyperlink(
				frmMetrics.getBody(), SWT.NONE);
		mghprlnkNewMetric.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				NewEditMetric metricScreen = new NewEditMetric(screenService
						.getScreenContainer(), SWT.NONE);
				metricScreen.setOperation(Screens.OPERATION_NEW);
				Metric metric = MetricsFactory.eINSTANCE.createMetric();
				metricScreen.injectData(metricResource, metric);

				screenService.setActiveScreen(metricScreen);
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

		metricsTreeViewer = new TreeViewer(frmMetrics.getBody(), SWT.BORDER);
		Tree tree = metricsTreeViewer.getTree();
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		toolkit.paintBordersFor(tree);

		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(
				metricsTreeViewer, SWT.NONE);
		TreeColumn trclmnName = treeViewerColumn.getColumn();
		trclmnName.setWidth(100);
		trclmnName.setText("Name");

		TreeViewerColumn treeViewerColumn_1 = new TreeViewerColumn(
				metricsTreeViewer, SWT.NONE);
		TreeColumn trclmnDescription = treeViewerColumn_1.getColumn();
		trclmnDescription.setWidth(100);
		trclmnDescription.setText("Description");

		TreeViewerColumn treeViewerColumn_2 = new TreeViewerColumn(
				metricsTreeViewer, SWT.NONE);
		TreeColumn trclmnUnit = treeViewerColumn_2.getColumn();
		trclmnUnit.setWidth(100);
		trclmnUnit.setText("Unit");

		metricsTreeViewer.addFilter(searchFilter);

		Menu menu = new Menu(tree);
		tree.setMenu(menu);
		MenuItem mntmNew = new MenuItem(menu, SWT.NONE);
		mntmNew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (screenService != null) {
					ISelection selection = getViewer().getSelection();
					if (selection instanceof IStructuredSelection) {
						Object subowner = ((IStructuredSelection) selection)
								.getFirstElement();

						NewEditMetric metricScreen = new NewEditMetric(
								screenService.getScreenContainer(), SWT.NONE);
						metricScreen.setOperation(Screens.OPERATION_NEW);
						Metric metric = MetricsFactory.eINSTANCE.createMetric();
						metricScreen.injectData(metricResource, subowner,
								metric);
						screenService.setActiveScreen(metricScreen);
					}
				}
			}
		});
		mntmNew.setText("New...");

		MenuItem mntmEdit = new MenuItem(menu, SWT.NONE);
		mntmEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (screenService != null) {
					ISelection selection = getViewer().getSelection();
					if (selection instanceof IStructuredSelection) {
						Object o = ((IStructuredSelection) selection)
								.getFirstElement();
						NewEditMetric metricScreen = new NewEditMetric(
								screenService.getScreenContainer(), SWT.NONE);
						metricScreen.setOperation(Screens.OPERATION_EDIT);
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
		});
		mntmEdit.setText("Edit...");

		this.injectData();
	}

	public EMFDataBindingContext initDataBindings_() {

		// mgr.runAndCollect(new Runnable() {
		// public void run() {
		// your code which creates observables
		listTreeContentProvider = new ObservableListTreeContentProvider(
				new MetricTreeFactory(), new MetricTreeStructureAdvisor());
		metricsTreeViewer.setContentProvider(listTreeContentProvider);

		IObservableSet set = listTreeContentProvider.getKnownElements();
		IObservableMap[] map = new IObservableMap[2];

		map[0] = EMFProperties.value(MetricsPackage.Literals.METRIC__NAME)
				.observeDetail(set);

		map[1] = EMFProperties.value(
				MetricsPackage.Literals.METRIC__DESCRIPTION).observeDetail(set);

		metricsTreeViewer.setLabelProvider(new MetricTreeLabelProvider(map));

		IEMFListProperty metricsProperty = EMFProperties.resource();
		metricsTreeViewer.setInput(metricsProperty.observe(metricResource));
		// }
		// });

		EMFDataBindingContext context = new EMFDataBindingContext();
		return context;
	}

	public void injectData() {
		metricResource = editingService.getData(MetricsPackage.Literals.METRIC);
		bindingContext = initDataBindings_();
	}

	public void disposeData() {
		editingService.disposeData();
	}

	@Override
	public Viewer getViewer() {
		return metricsTreeViewer;
	}

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public Form getScreenForm() {
		return this.frmMetrics;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;

	}
}
