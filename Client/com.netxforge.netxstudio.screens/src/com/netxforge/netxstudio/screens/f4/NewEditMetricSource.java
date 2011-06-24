package com.netxforge.netxstudio.screens.f4;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
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
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.ResourceManager;

import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f4.support.MetricTreeFactory;
import com.netxforge.netxstudio.screens.f4.support.MetricTreeLabelProvider;
import com.netxforge.netxstudio.screens.f4.support.MetricTreeStructureAdvisor;

public class NewEditMetricSource extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtName;
	private Text txtLocationUrl;
	private MetricSource metricSource;
	private MetricSource original;
	private Resource owner;
	private TreeViewer treeViewer;
	private Form frmNewEditMetricSource;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditMetricSource(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmNewEditMetricSource = toolkit.createForm(this);
		frmNewEditMetricSource.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewEditMetricSource);

		String title = Screens.isNewOperation(getOperation()) ? "New" : "Edit";

		frmNewEditMetricSource.setText(title + "Metric Source");
		frmNewEditMetricSource.getBody().setLayout(new FormLayout());

		Section sctnNewSection = toolkit.createSection(frmNewEditMetricSource.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnNewSection = new FormData();
		fd_sctnNewSection.top = new FormAttachment(0, 28);
		fd_sctnNewSection.right = new FormAttachment(100, -12);
		fd_sctnNewSection.left = new FormAttachment(0, 12);
		sctnNewSection.setLayoutData(fd_sctnNewSection);
		toolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Info");

		Composite composite_1 = toolkit.createComposite(sctnNewSection,
				SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnNewSection.setClient(composite_1);
		composite_1.setLayout(new GridLayout(2, false));

		Label lblName = toolkit.createLabel(composite_1, "Name:", SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblName.widthHint = 70;
		lblName.setLayoutData(gd_lblName);

		txtName = toolkit.createText(composite_1, "New Text", SWT.NONE);
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtName.widthHint = 200;
		txtName.setLayoutData(gd_txtName);
		txtName.setText("");

		Label lblLocationUrl = toolkit.createLabel(composite_1,
				"Location URL:", SWT.NONE);
		lblLocationUrl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblLocationUrl.setAlignment(SWT.RIGHT);

		txtLocationUrl = toolkit.createText(composite_1, "New Text", SWT.NONE);
		txtLocationUrl.setText("");
		GridData gd_txtLocationUrl = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_txtLocationUrl.widthHint = 200;
		txtLocationUrl.setLayoutData(gd_txtLocationUrl);

		Label lblNewEditMapping = toolkit.createLabel(composite_1, "Mapping:",
				SWT.NONE);
		lblNewEditMapping.setAlignment(SWT.RIGHT);
		lblNewEditMapping.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		Hyperlink hprlnkAddMapping = toolkit.createHyperlink(composite_1,
				"Mapping", SWT.NONE);
		hprlnkAddMapping.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {

				// We are add, or edit.

				NewEditXLSMapping mapping = new NewEditXLSMapping(screenService
						.getScreenContainer(), SWT.NONE | Screens.OPERATION_NEW);
				screenService.setActiveScreen(mapping);
				mapping.injectData(metricSource,
						MetricsFactory.eINSTANCE.createMappingXLS());

			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		toolkit.paintBordersFor(hprlnkAddMapping);

		Label lblNewEditSchedule = toolkit.createLabel(composite_1,
				"Schedule:", SWT.NONE);
		lblNewEditSchedule.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		Hyperlink hprlnkScheduleTheData = toolkit.createHyperlink(composite_1,
				"Add a Job to schedule the metrics collection", SWT.NONE);
		hprlnkScheduleTheData.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		toolkit.paintBordersFor(hprlnkScheduleTheData);

		Section sctnMetrics = toolkit.createSection(frmNewEditMetricSource.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		fd_sctnNewSection.bottom = new FormAttachment(sctnMetrics, -6);
		FormData fd_sctnMetrics = new FormData();
		fd_sctnMetrics.bottom = new FormAttachment(100, -12);
		fd_sctnMetrics.right = new FormAttachment(100, -12);
		fd_sctnMetrics.left = new FormAttachment(sctnNewSection, 0, SWT.LEFT);
		fd_sctnMetrics.top = new FormAttachment(0, 171);
		sctnMetrics.setLayoutData(fd_sctnMetrics);
		toolkit.paintBordersFor(sctnMetrics);
		sctnMetrics.setText("Metrics");

		Composite composite_2 = toolkit.createComposite(sctnMetrics, SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnMetrics.setClient(composite_2);
		composite_2.setLayout(new GridLayout(2, false));

		treeViewer = new TreeViewer(composite_2, SWT.BORDER);
		treeViewer.setAutoExpandLevel(3);
		treeViewer.setColumnProperties(new String[] {});
		Tree tree = treeViewer.getTree();
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 4));
		toolkit.paintBordersFor(tree);

		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer,
				SWT.NONE);
		TreeColumn trclmnName = treeViewerColumn.getColumn();
		trclmnName.setWidth(100);
		trclmnName.setText("Name");

		TreeViewerColumn treeViewerColumn_1 = new TreeViewerColumn(treeViewer,
				SWT.NONE);
		TreeColumn trclmnDescription = treeViewerColumn_1.getColumn();
		trclmnDescription.setWidth(100);
		trclmnDescription.setText("Description");

		ImageHyperlink mghprlnkNew = toolkit.createImageHyperlink(sctnMetrics,
				SWT.NONE);
		mghprlnkNew.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				// TODO Add a new Metric, select from a list of existing metrics. 
				//
				
				
			}
			public void linkEntered(HyperlinkEvent e) {
			}
			public void linkExited(HyperlinkEvent e) {
			}
		});
		mghprlnkNew.setImage(ResourceManager.getPluginImage(
				"com.netxforge.netxstudio.models.edit",
				"icons/full/ctool16/Metric_E.png"));
		toolkit.paintBordersFor(mghprlnkNew);
		sctnMetrics.setTextClient(mghprlnkNew);
		mghprlnkNew.setText("New");
		
	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext context = new EMFDataBindingContext();

		IObservableValue nameObservable = SWTObservables.observeText(txtName);
		IEMFValueProperty nameProperty = EMFProperties
				.value(MetricsPackage.Literals.METRIC_SOURCE__NAME);
		context.bindValue(nameObservable, nameProperty.observe(metricSource), null, null);

		IObservableValue locationObservable = SWTObservables
				.observeText(this.txtLocationUrl);
		IEMFValueProperty locationProperty = EMFProperties
				.value(MetricsPackage.Literals.METRIC_SOURCE__METRIC_LOCATION);
		context.bindValue(locationObservable, locationProperty.observe(metricSource),
				null, null);

		ObservableListTreeContentProvider listTreeContentProvider = new ObservableListTreeContentProvider(
				new MetricTreeFactory(), new MetricTreeStructureAdvisor());
		this.treeViewer.setContentProvider(listTreeContentProvider);

		IObservableSet set = listTreeContentProvider.getKnownElements();
		IObservableMap[] map = new IObservableMap[2];

		map[0] = EMFProperties
				.value(MetricsPackage.Literals.METRIC__NAME)
				.observeDetail(set);

		map[1] = EMFProperties.value(
				MetricsPackage.Literals.METRIC__DESCRIPTION).observeDetail(set);

		treeViewer.setLabelProvider(new MetricTreeLabelProvider(map));
		
		IEMFListProperty metricsProperty = EMFProperties
				.list(MetricsPackage.Literals.METRIC_SOURCE__METRIC_REFS);
		treeViewer.setInput(metricsProperty.observe(metricSource));
		
		return context;
	}

	
	// Needed for the tree stuff.

	public void injectData(Object owner, Object object) {

		if (owner instanceof Resource) {
			this.owner = (Resource) owner;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}

		if (object != null && object instanceof MetricSource) {
			if (Screens.isEditOperation(this.getOperation())) {
				MetricSource copy = EcoreUtil.copy((MetricSource) object);
				metricSource = copy;
				original = (MetricSource) object;
			} else if (Screens.isNewOperation(getOperation())) {
				metricSource = (MetricSource) object;
			}
		}

		this.initDataBindings_();
	}

	public void addData() {
		if (Screens.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.
			Command c = new AddCommand(editingService.getEditingDomain(),
					owner.getContents(), metricSource);
			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (Screens.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (original.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}

			Command c = new ReplaceCommand(editingService.getEditingDomain(),
					owner.getContents(), original, metricSource);
			editingService.getEditingDomain().getCommandStack().execute(c);

			System.out.println(metricSource.cdoID() + "" + metricSource.cdoState());

		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
		}
	}

	@Override
	public Viewer getViewer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return frmNewEditMetricSource;
	}

	public void disposeData() {
		//N/A
		
	}
}
