package com.netxforge.netxstudio.screens.f4;

import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.google.common.collect.Iterables;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MappingRecord;
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

	private TableViewer tblViewerRecords;

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
		// buildUI();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmMappingStatistics = toolkit.createForm(this);
		frmMappingStatistics.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmMappingStatistics);
		frmMappingStatistics.setText("Mapping Statistics: "
				+ metricSource.getName());
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

		Menu menu = new Menu(statisticsListViewer.getList());
		statisticsListViewer.getList().setMenu(menu);

		MenuItem mntmMore = new MenuItem(menu, SWT.NONE);
		mntmMore.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Show the period etc..
				ISelection selection = statisticsListViewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					if (o instanceof MappingStatistic) {

						// Create a predicate for filtering the values within a
						// range.
						MappingStatistic mappingStatistics = (MappingStatistic) o;

						final int targetIntervalHint = mappingStatistics
								.getIntervalEstimate();

						Resource metricResource = editingService
								.getData(MetricsPackage.Literals.METRIC);
						List<NetXResource> resourcesInMetricSource = modelUtils
								.resourcesInMetricSource(
										metricResource.getContents(),
										metricSource);
						if (resourcesInMetricSource.isEmpty()) {
							System.out
									.println("No resources for this metricsource");
							return;
						}

						DateTimeRange dtr = mappingStatistics
								.getPeriodEstimate();
						
						System.out.println("VALUES FOR PERIOD:");
						
						System.out.println("FROM="+ modelUtils.dateAndTime(dtr.getBegin()));
						System.out.println("TO="+ modelUtils.dateAndTime(dtr.getEnd()));
						
						int valueCount = 0;
						for (NetXResource res : resourcesInMetricSource) {
							System.out.println("values for resource: "
									+ res.getShortName() + "on Component" + res.getComponentRef().getName());

							List<Value> values = modelUtils.metricValuesInRange(res,
									targetIntervalHint, null, dtr);
							if (values.size() > 0) {
								valueCount += values.size();
								System.out.println("number of values "
										+ Iterables.size(values));
								for (Value v : values) {
									System.out.println(modelUtils.fromXMLDate(v
											.getTimeStamp())
											+ ":"
											+ v.getValue());
								}
							}
						}
						System.out.println("total values for this import = " + valueCount);
						
					}
				}
			}
		});
		mntmMore.setText("Values...");

		MenuItem mntmDelete = new MenuItem(menu, SWT.NONE);
		mntmDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Show the period etc..
				ISelection selection = statisticsListViewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					if (o instanceof MappingStatistic) {
						MappingStatistic mappingStatistics = (MappingStatistic) o;
						final int targetIntervalHint = mappingStatistics
								.getIntervalEstimate();
						Resource metricResource = editingService
								.getData(MetricsPackage.Literals.METRIC);
						List<NetXResource> resourcesInMetricSource = modelUtils
								.resourcesInMetricSource(
										metricResource.getContents(),
										metricSource);
						DateTimeRange dtr = mappingStatistics
								.getPeriodEstimate();

						for (NetXResource res : resourcesInMetricSource) {
							List<Value> values = modelUtils.metricValuesInRange(res,
									targetIntervalHint, null, dtr);
							if (values.size() > 0) {
								DeleteCommand dc = new DeleteCommand(editingService.getEditingDomain(), values);
								editingService.getEditingDomain().getCommandStack().execute(dc);
							}
						}
					}
				}
			}
		});
		mntmDelete.setText("Purge import...");

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

		tblViewerRecords = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = tblViewerRecords.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tblViewerRecords, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Row");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tblViewerRecords, SWT.NONE);
		TableColumn tblclmnColumn = tableViewerColumn_1.getColumn();
		tblclmnColumn.setWidth(100);
		tblclmnColumn.setText("Column");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tblViewerRecords, SWT.NONE);
		TableColumn tblclmnMessage = tableViewerColumn_2.getColumn();
		tblclmnMessage.setWidth(100);
		tblclmnMessage.setText("Message");
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

		IObservableList metricSourceObservableList = l.observe(metricSource);

		statisticsListViewer.setInput(metricSourceObservableList);

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

		EMFUpdateValueStrategy modelToTargetStrategy = new EMFUpdateValueStrategy();
		modelToTargetStrategy.setConverter(new ModelDateConverter());
		bindingContext.bindValue(totalRecordsObservable,
				totalRecordsProperty.observeDetail(selectionObservable));

		bindingContext.bindValue(startTimeObservable,
				startDateTimeProperty.observeDetail(selectionObservable), null,
				modelToTargetStrategy);

		bindingContext.bindValue(endTimeObservable,
				endDateTimeProperty.observeDetail(selectionObservable), null,
				modelToTargetStrategy);

		ObservableListContentProvider recordsContentProvider = new ObservableListContentProvider();
		tblViewerRecords.setContentProvider(recordsContentProvider);

		IObservableMap[] recordsObserveMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] {
						MetricsPackage.Literals.MAPPING_RECORD__ROW,
						MetricsPackage.Literals.MAPPING_RECORD__COLUMN,
						MetricsPackage.Literals.MAPPING_RECORD__MESSAGE, });
		tblViewerRecords
				.setLabelProvider(new RecordsObservableMapLabelProvider(
						recordsObserveMaps));
		IEMFListProperty recordsProperty = EMFProperties
				.list(MetricsPackage.Literals.MAPPING_STATISTIC__FAILED_RECORDS);

		tblViewerRecords.setInput(recordsProperty
				.observeDetail(selectionObservable));

		return bindingContext;
	}

	class ModelDateConverter implements IConverter {

		public Object getFromType() {
			return XMLGregorianCalendar.class;
		}

		public Object getToType() {
			return String.class;
		}

		public Object convert(Object fromObject) {
			if (fromObject instanceof XMLGregorianCalendar) {
				Date d = modelUtils
						.fromXMLDate((XMLGregorianCalendar) fromObject);
				return modelUtils.date(d) + " @ " + modelUtils.time(d);
			}

			return null;
		}
	}

	class RecordsObservableMapLabelProvider extends ObservableMapLabelProvider {

		public RecordsObservableMapLabelProvider(IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {

			if (element instanceof MappingRecord) {

				MappingRecord mr = (MappingRecord) element;
				switch (columnIndex) {
				case 0: {
					return mr.getRow();
				}
				case 1: {
					return mr.getColumn();
				}
				case 2: {
					return mr.getMessage();
				}
				}
			}

			return super.getColumnText(element, columnIndex);
		}

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

		buildUI();
		this.initDataBindings_();
	}

	public void addData() {
		// N/A Read-only view.

	}

	@Override
	public Viewer getViewer() {
		return null;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return this.frmMappingStatistics;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}
}
