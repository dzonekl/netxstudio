package com.netxforge.netxstudio.screens.f4;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.metrics.MappingStatistic;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;

public class MappingStatistics extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Form frmMappingStatistics;
	private MetricSource metricSource;
	private ListViewer statisticsListViewer;
	private Text txtTotalRecords;
	private Text txtStartDateTime;
	private Text txtEndDateTime;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public MappingStatistics(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmMappingStatistics = toolkit.createForm(this);
		frmMappingStatistics.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmMappingStatistics);
		frmMappingStatistics.setText("Mapping Statistics: <Metric Source>");
		frmMappingStatistics.getBody().setLayout(new FormLayout());

		SashForm sashForm = new SashForm(frmMappingStatistics.getBody(),
				SWT.NONE);
		FormData fd_sashForm = new FormData();
		fd_sashForm.bottom = new FormAttachment(100, -12);
		fd_sashForm.right = new FormAttachment(100, -12);
		fd_sashForm.top = new FormAttachment(0, 12);
		fd_sashForm.left = new FormAttachment(0, 12);
		sashForm.setLayoutData(fd_sashForm);
		toolkit.adapt(sashForm);
		toolkit.paintBordersFor(sashForm);

		Section sctnStatistics = toolkit.createSection(sashForm,
				Section.EXPANDED | Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnStatistics);
		sctnStatistics.setText("Statistics");

		Composite composite_2 = toolkit.createComposite(sctnStatistics,
				SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnStatistics.setClient(composite_2);
		composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));

		statisticsListViewer = new ListViewer(composite_2, SWT.BORDER
				| SWT.V_SCROLL);

		Section sctnSummary = toolkit.createSection(sashForm, Section.EXPANDED
				| Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnSummary);
		sctnSummary.setText("Summary");

		Composite composite = toolkit.createComposite(sctnSummary, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnSummary.setClient(composite);
		composite.setLayout(new GridLayout(2, false));

		Label lblTotalRecordsProcessed = toolkit.createLabel(composite,
				"Total records processed: ", SWT.NONE);
		lblTotalRecordsProcessed.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, false, false, 1, 1));

		txtTotalRecords = toolkit.createText(composite, "New Text",
				SWT.READ_ONLY);
		txtTotalRecords.setText("");
		txtTotalRecords.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1));

		Label lblStartDatetime = toolkit.createLabel(composite,
				"Start Date/Time:", SWT.NONE);
		lblStartDatetime.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		txtStartDateTime = toolkit.createText(composite, "New Text",
				SWT.READ_ONLY);
		txtStartDateTime.setText("");
		txtStartDateTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Label lblEndDatetime = toolkit.createLabel(composite, "End Date/Time:",
				SWT.NONE);
		lblEndDatetime.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtEndDateTime = toolkit.createText(composite, "New Text",
				SWT.READ_ONLY);
		txtEndDateTime.setText("");
		txtEndDateTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Composite filler = toolkit.createComposite(composite, SWT.NONE);
		GridData gd_filler = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				2, 1);
		gd_filler.heightHint = 30;
		filler.setLayoutData(gd_filler);
		toolkit.paintBordersFor(filler);

		TableViewer tableViewer = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Row");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnColumn = tableViewerColumn_1.getColumn();
		tblclmnColumn.setWidth(100);
		tblclmnColumn.setText("Column");
		sashForm.setWeights(new int[] { 1, 1 });

	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		statisticsListViewer.setContentProvider(listContentProvider);

		IObservableMap[] observeMaps = EMFObservables
				.observeMaps(
						listContentProvider.getKnownElements(),
						new EStructuralFeature[] { MetricsPackage.Literals.MAPPING_STATISTIC__MESSAGE });
		statisticsListViewer
				.setLabelProvider(new StatisticObservableMapLabelProvider(
						observeMaps));

		// Cool, observer the whole resource.
		IEMFListProperty l = EMFProperties
				.list(MetricsPackage.Literals.METRIC_SOURCE__STATISTICS);
		statisticsListViewer.setInput(l.observe(metricSource));

		IObservableValue selectionObservable = ViewerProperties
				.singleSelection().observe(statisticsListViewer);

		IObservableValue totalRecordsObservable = SWTObservables.observeText(
				this.txtTotalRecords, SWT.Modify);
		IObservableValue startTimeObservable = SWTObservables.observeText(
				this.txtStartDateTime, SWT.Modify);
		IObservableValue endTimeObservable = SWTObservables.observeText(
				this.txtEndDateTime, SWT.Modify);

		IEMFValueProperty totalRecordsProperty = EMFProperties
				.value(MetricsPackage.Literals.MAPPING_STATISTIC__TOTAL_RECORDS);

		IEMFValueProperty startDateTimeProperty = EMFProperties
				.value(FeaturePath
						.fromList(
								MetricsPackage.Literals.MAPPING_STATISTIC__MAPPING_DURATION,
								GenericsPackage.Literals.DATE_TIME_RANGE__BEGIN));

		IEMFValueProperty endDateTimeProperty = EMFProperties
				.value(FeaturePath
						.fromList(
								MetricsPackage.Literals.MAPPING_STATISTIC__MAPPING_DURATION,
								GenericsPackage.Literals.DATE_TIME_RANGE__END));

		bindingContext.bindValue(totalRecordsObservable,
				totalRecordsProperty.observeDetail(selectionObservable));

		bindingContext.bindValue(startTimeObservable,
				startDateTimeProperty.observeDetail(selectionObservable));

		bindingContext.bindValue(endTimeObservable,
				endDateTimeProperty.observeDetail(selectionObservable));

		return bindingContext;
	}

	class StatisticObservableMapLabelProvider extends
			ObservableMapLabelProvider {

		public StatisticObservableMapLabelProvider(
				IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		public StatisticObservableMapLabelProvider(IObservableMap attributeMap) {
			super(attributeMap);
		}

		@Override
		public String getText(Object element) {

			if (element instanceof MappingStatistic) {
				MappingStatistic s = (MappingStatistic) element;

				return s.getMessage() + "[" + s.getTotalRecords() + "]";
			}
			return super.getText(element);
		}
	}

	public void disposeData() {
		// N/A
	}

	public void injectData(Object owner, Object object) {
		if (object instanceof MetricSource) {
			metricSource = (MetricSource) object;
		}
		this.initDataBindings_();

	}

	public void addData() {
		// N/A Read-only view.

	}

	@Override
	public Viewer getViewer() {
		return null; // N/A
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return this.frmMappingStatistics;
	}
}
