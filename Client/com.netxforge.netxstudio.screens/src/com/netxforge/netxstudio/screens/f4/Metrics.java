package com.netxforge.netxstudio.screens.f4;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class Metrics extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;
	private Library library;
	@SuppressWarnings("unused")
	private EMFDataBindingContext bindingContext;
	private Form frmMetrics;
	private TreeViewer treeViewer;
	
	/**
	 * Create the composite.
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
		
		Label lblFilterLabel = toolkit.createLabel(frmMetrics.getBody(), "Filter:", SWT.NONE);
		lblFilterLabel.setAlignment(SWT.RIGHT);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblFilterLabel.widthHint = 36;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);
		
		txtFilterText = toolkit.createText(frmMetrics.getBody(), "New Text", SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.setText("");
		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);
		
		ImageHyperlink mghprlnkNewMetric = toolkit.createImageHyperlink(frmMetrics.getBody(), SWT.NONE);
		mghprlnkNewMetric.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				NewEditMetric metricScreen = new NewEditMetric(
						screenService.getScreenContainer(), SWT.NONE
								| Screens.OPERATION_NEW);
				screenService.setActiveScreen(metricScreen);
				Metric metric = MetricsFactory.eINSTANCE
						.createMetric();
				metricScreen.injectData(library.getMetrics(), metric);
			}
			public void linkEntered(HyperlinkEvent e) {
			}
			public void linkExited(HyperlinkEvent e) {
			}
		});
		mghprlnkNewMetric.setImage(ResourceManager.getPluginImage("com.netxforge.netxstudio.models.edit", "icons/full/ctool16/Metric_E.png"));
		toolkit.paintBordersFor(mghprlnkNewMetric);
		mghprlnkNewMetric.setText("New");
		
		treeViewer = new TreeViewer(frmMetrics.getBody(), SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		toolkit.paintBordersFor(tree);
		
		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnName = treeViewerColumn.getColumn();
		trclmnName.setWidth(100);
		trclmnName.setText("Name");
		
		TreeViewerColumn treeViewerColumn_1 = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnDescription = treeViewerColumn_1.getColumn();
		trclmnDescription.setWidth(100);
		trclmnDescription.setText("Description");
		
		TreeViewerColumn treeViewerColumn_2 = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnUnit = treeViewerColumn_2.getColumn();
		trclmnUnit.setWidth(100);
		trclmnUnit.setText("Unit");
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();
		
		return context;
	}

	public void injectData() {
		Resource res = editingService.getData(LibraryPackage.LIBRARY);
		if (res.getContents().size() == 0) {
			Library lib = LibraryFactory.eINSTANCE.createLibrary();
			res.getContents().add(lib);
			this.library = lib;
		} else {
			this.library = (Library) res.getContents().get(0);
		}
		bindingContext = initDataBindings_();
	}

	public void disposeData() {
		editingService.disposeData();
	}

	@Override
	public Viewer getViewer() {
		return treeViewer;
	}

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public Form getScreenForm() {
		return this.frmMetrics;
	}
}
