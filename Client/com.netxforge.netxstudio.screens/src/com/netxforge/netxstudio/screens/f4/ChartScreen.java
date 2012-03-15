package com.netxforge.netxstudio.screens.f4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.ShowInContext;
import org.swtchart.Chart;
import org.swtchart.IAxis.Position;
import org.swtchart.IAxisTick;
import org.swtchart.IBarSeries;
import org.swtchart.ILineSeries;
import org.swtchart.ISeries;
import org.swtchart.ISeriesSet;
import org.swtchart.LineStyle;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.operators.ToleranceMarker;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.showins.ChartShowInContext;

public class ChartScreen extends AbstractScreen implements IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Chart chart;
	private Table table;
	private Form frmChartScreen;
	private ResourceMonitor resMonitor;
	private NetXResource netXResource;
	private DateTimeRange dtr;
	private TableViewer markersTableViewer;

	public ChartScreen(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
				disposeData();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		// buildUI();
	}

	public void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmChartScreen = toolkit.createForm(this);
		// frmFunction.setText("Resource Monitor " +
		// netXResource.getShortName());
		frmChartScreen.setText("Resource charts");
		frmChartScreen.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmChartScreen);

		frmChartScreen.getBody().setLayout(new ColumnLayout());

		Composite cmChart = toolkit.createComposite(frmChartScreen.getBody(),
				SWT.NONE);
		toolkit.paintBordersFor(cmChart);
		// sctnPeriod.setClient(composite_2);
		cmChart.setLayout(new GridLayout(2, false));

		buildScrollStick(cmChart, new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1));

		// CHART
		chart = new Chart(cmChart, SWT.NONE);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4);
		gridData.heightHint = 350;
		chart.setLayoutData(gridData);
		chart.setBackground(Display.getDefault()
				.getSystemColor(SWT.COLOR_WHITE));

		chart.getTitle().setVisible(false);

		chart.getAxisSet().getXAxis(0).getTitle().setText("Time stamps");
		IAxisTick xTick = chart.getAxisSet().getXAxis(0).getTick();
		xTick.setTickMarkStepHint(20);
		DateFormat format = new SimpleDateFormat("HH:mm");
		xTick.setFormat(format);

		chart.getAxisSet().getYAxis(0).getTitle().setText("Value");

		// Set another right axis.
		int utilizationAxisID = chart.getAxisSet().createYAxis();
		chart.getAxisSet().getYAxis(utilizationAxisID)
				.setPosition(Position.Secondary);
		chart.getAxisSet().getYAxis(utilizationAxisID).getTitle()
				.setText("Utilization (%)");
		chart.getAxisSet()
				.getYAxis(utilizationAxisID)
				.getTitle()
				.setForeground(
						Display.getDefault().getSystemColor(SWT.COLOR_BLACK));
		chart.getAxisSet().getYAxis(utilizationAxisID).getGrid()
				.setStyle(LineStyle.DASHDOT);
		chart.getAxisSet()
				.getYAxis(utilizationAxisID)
				.getTick()
				.setForeground(
						Display.getDefault().getSystemColor(SWT.COLOR_BLACK));

		// chart.getAxisSet().getYAxis(utilizationAxisID).getTick()
		// .setFormat(new DecimalFormat("##%"));

		// ZOOM etc... buttons.

		Button btnZoomIn = toolkit.createButton(cmChart, "Z+", SWT.NONE);
		btnZoomIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().zoomIn();
				getChart().redraw();
			}
		});
		GridData gd_btnZoomIn = new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1);
		gd_btnZoomIn.widthHint = 24;
		gd_btnZoomIn.heightHint = 18;
		btnZoomIn.setLayoutData(gd_btnZoomIn);

		Button btnZoomOut = toolkit.createButton(cmChart, "Z-", SWT.NONE);
		btnZoomOut.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().zoomOut();
				getChart().redraw();
			}
		});
		GridData gd_btnZoomOut = new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1);
		gd_btnZoomOut.widthHint = 24;
		gd_btnZoomOut.heightHint = 18;
		btnZoomOut.setLayoutData(gd_btnZoomOut);

		Section sctnMarkers = toolkit.createSection(frmChartScreen.getBody(),
				Section.TWISTIE | Section.TITLE_BAR);

		toolkit.paintBordersFor(sctnMarkers);
		sctnMarkers.setText("Markers");
		sctnMarkers.setExpanded(false);

		Composite composite = toolkit.createComposite(sctnMarkers, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnMarkers.setClient(composite);
		composite.setLayout(new GridLayout(1, false));

		markersTableViewer = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION);

		table = markersTableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		GridData gdMarkers = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gdMarkers.heightHint = 250;
		table.setLayoutData(gdMarkers);
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				markersTableViewer, SWT.NONE);
		TableColumn tblclmnType = tableViewerColumn.getColumn();
		tblclmnType.setWidth(125);
		tblclmnType.setText("Type");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				markersTableViewer, SWT.NONE);
		TableColumn tblclmnDescription = tableViewerColumn_1.getColumn();
		tblclmnDescription.setWidth(200);
		tblclmnDescription.setText("Description");

		// TableItem tableItem = new TableItem(table, SWT.NONE);
		// tableItem
		// .setText(new String[] {
		// "Threshold Breached,",
		// "The Threshold for this resource has been crossed. The resource is not within tolerance. "
		// });

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(
				markersTableViewer, SWT.NONE);
		TableColumn tblclmnTimestamp = tableViewerColumn_3.getColumn();
		tblclmnTimestamp.setWidth(140);
		tblclmnTimestamp.setText("TimeStamp");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				markersTableViewer, SWT.NONE);
		TableColumn tblclmnValue = tableViewerColumn_2.getColumn();
		tblclmnValue.setWidth(100);
		tblclmnValue.setText("Value");

		TableViewerColumn tableViewerColumnDirection = new TableViewerColumn(
				markersTableViewer, SWT.NONE);
		TableColumn tblclmnDirection = tableViewerColumnDirection.getColumn();
		tblclmnDirection.setWidth(100);
		tblclmnDirection.setText("Direction");

		TableViewerColumn tableViewerColumnLevel = new TableViewerColumn(
				markersTableViewer, SWT.NONE);
		TableColumn tblclmnLevel = tableViewerColumnLevel.getColumn();
		tblclmnLevel.setWidth(100);
		tblclmnLevel.setText("Level");

	}

	private void buildScrollStick(Composite composite_2, GridData gd) {
		Composite compositeScrollStick = toolkit.createComposite(composite_2,
				SWT.NO_BACKGROUND);
		compositeScrollStick.setLayoutData(gd);
		toolkit.paintBordersFor(compositeScrollStick);
		GridLayout gl_compositeScrollStick = new GridLayout(3, false);
		gl_compositeScrollStick.marginTop = 3;
		gl_compositeScrollStick.verticalSpacing = 0;
		gl_compositeScrollStick.marginWidth = 0;
		gl_compositeScrollStick.marginHeight = 0;
		gl_compositeScrollStick.horizontalSpacing = 0;
		compositeScrollStick.setLayout(gl_compositeScrollStick);

		new Label(compositeScrollStick, SWT.NONE);
		Button btnUpScroll = toolkit.createButton(compositeScrollStick, "",
				SWT.ARROW | SWT.UP);
		btnUpScroll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().getYAxis(0).scrollUp();
				getChart().redraw();
			}
		});
		new Label(compositeScrollStick, SWT.NONE);

		Button btnLeftScroll = toolkit.createButton(compositeScrollStick, "",
				SWT.ARROW | SWT.LEFT);
		btnLeftScroll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().getXAxis(0).scrollDown();
				getChart().redraw();
			}
		});
		new Label(compositeScrollStick, SWT.NONE);
		Button btnRightScroll = toolkit.createButton(compositeScrollStick, "",
				SWT.ARROW | SWT.RIGHT);
		btnRightScroll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().getXAxis(0).scrollUp();
				getChart().redraw();
			}
		});

		new Label(compositeScrollStick, SWT.NONE);
		Button btnDownScroll = toolkit.createButton(compositeScrollStick, "",
				SWT.ARROW | SWT.DOWN);
		btnDownScroll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().getYAxis(0).scrollDown();
				getChart().redraw();
			}
		});
		new Label(compositeScrollStick, SWT.NONE);
	}

	public void loadDummyData() {

		// Demo values. Use Databinding !
		long ts = System.currentTimeMillis();
		double v = 10;
		int ticks = 30;
		List<Date> dates = new ArrayList<Date>();
		double[] ySeries = new double[ticks];

		// Dummy Series settings.
		for (int i = 0; i < ticks; i++) {
			// x
			ts += (1000 * 60) * 15;
			dates.add(new Date(ts));
			// y
			v += 1;
			ySeries[i] = v;
		}
		Date[] xSeries = new Date[ticks];
		dates.toArray(xSeries);

		v = 20;
		double[] yCapSeries = new double[ticks];

		for (int i = 0; i < ticks; i++) {
			if (i % 5 == 0)
				v += 5;
			yCapSeries[i] = v;
		}

		double[] yUtilSeries = new double[ticks];
		for (int i = 0; i < ticks; i++) {
			yUtilSeries[i] = (ySeries[i] / yCapSeries[i]);
		}

		double[] yToleranceSeries = new double[ticks];
		for (int i = 0; i < ticks; i++) {
			yToleranceSeries[i] = 0.9;
		}
	}

	int expectedValueQuantity = -1;
	private int interval;
	private List<Value> values;

	public List<Value> sortAndApplyPeriod(List<Value> values) {
		List<Value> sortedCopy = modelUtils.sortValuesByTimeStampAndReverse(values);
		return modelUtils.valuesInRange(sortedCopy, dtr);
	}

	/**
	 * Get a Chart Lineseries from a Resource.
	 * 
	 * @param metricValues
	 * 
	 * @param chart
	 * @param resource
	 * @return
	 */
	private ILineSeries seriesFromMetric(Date[] dateArray,
			double[] metricValues, Chart chart, NetXResource resource) {

		ILineSeries metricLineSeries = (ILineSeries) chart.getSeriesSet()
				.createSeries(ISeries.SeriesType.LINE, "Metric");

		metricLineSeries.setXDateSeries(dateArray);
		DateFormat format = new SimpleDateFormat("ddMM HH:mm");
		IAxisTick xTick = chart.getAxisSet().getXAxis(0).getTick();
		xTick.setFormat(format);

		metricLineSeries.setYSeries(metricValues);
		metricLineSeries.setSymbolType(ILineSeries.PlotSymbolType.TRIANGLE);
		return metricLineSeries;
	}

	private ILineSeries seriesFromCapacity(Date[] dateArray,
			double[] capacityValues, Chart chart) {

		ILineSeries capLineSeries = (ILineSeries) chart.getSeriesSet()
				.createSeries(ISeries.SeriesType.LINE, "Capacity");

		capLineSeries.setXDateSeries(dateArray);
		capLineSeries.setYSeries(capacityValues);
		capLineSeries.enableStep(true);
		capLineSeries.setLineColor(Display.getDefault().getSystemColor(
				SWT.COLOR_DARK_YELLOW));
		capLineSeries.setSymbolType(ILineSeries.PlotSymbolType.NONE);
		return capLineSeries;

	}

	private IBarSeries seriesFromUtilization(Date[] dateArray,
			double[] utilizationValues, Chart chart, int yAxisID) {

		IBarSeries utilLineSeries = (IBarSeries) chart.getSeriesSet()
				.createSeries(ISeries.SeriesType.BAR, "Utilization");
		utilLineSeries.setXDateSeries(dateArray);
		utilLineSeries.setYSeries(utilizationValues);
		utilLineSeries.setYAxisId(yAxisID); // Connect a series to the
											// Y-Axis.
		utilLineSeries.setBarColor(Display.getDefault().getSystemColor(
				SWT.COLOR_GREEN));
		utilLineSeries.setBarPadding(50);
		return utilLineSeries;
	}

	@SuppressWarnings("unused")
	private ILineSeries seriesFromTolerance(Date[] dateArray,
			double[] toleranceValues, Chart chart, int yAxisID) {

		ILineSeries toleranceLineSeries = (ILineSeries) chart.getSeriesSet()
				.createSeries(ISeries.SeriesType.LINE, "Tolerance");
		toleranceLineSeries.setXDateSeries(dateArray);
		toleranceLineSeries.setYSeries(toleranceValues);
		toleranceLineSeries.setYAxisId(yAxisID);
		toleranceLineSeries.setLineStyle(LineStyle.DASHDOTDOT);
		toleranceLineSeries.setLineColor(Display.getDefault().getSystemColor(
				SWT.COLOR_DARK_RED));
		toleranceLineSeries.setSymbolType(ILineSeries.PlotSymbolType.NONE);
		return toleranceLineSeries;
	}

	public Chart getChart() {
		return chart;
	}

	public Viewer getViewer() {
		return null;
	}

	/**
	 * Use with additional parameter DateTimeRange.
	 */
	@SuppressWarnings("unchecked")
	public void injectData(Object owner, Object object) {

		if (object instanceof ResourceMonitor) {
			resMonitor = (ResourceMonitor) object;
			netXResource = resMonitor.getResourceRef();
			dtr = resMonitor.getPeriod();
			buildUI();
			frmChartScreen.setText("Resource Monitor "
					+ netXResource.getShortName());
			initDataBindings_();
		} else {
			if (owner instanceof NetXResource) {
//				this.dtr = (DateTimeRange) object;
				this.netXResource = (NetXResource) owner;
			}

			if (object instanceof List<?>) {
				this.values = (List<Value>) object;
			}
//			buildUI();
			initDataBindings_();
		}

	}

	public void injectData(Object owner, Object object, DateTimeRange dtr,
			int interval) {
		if (object != null && object instanceof NetXResource) {
			netXResource = (NetXResource) object;
		} else {
			throw new java.lang.IllegalArgumentException(
					"The target object is expected to be a NetXResource");
		}

		if (dtr != null) {
			this.dtr = dtr;
		}

		if (interval > 0) {
			this.interval = interval;
		}

//		buildUI();
		initDataBindings_();
	}

	public void addData() {
		// N/A this is a view screen.

	}

	public boolean isValid() {
		return true;
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();

		initChartBinding();
		initMarkersBinding();

		return context;
	}

	private void initMarkersBinding() {
		if (resMonitor != null) {

			ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
			markersTableViewer.setContentProvider(listContentProvider);

			IObservableMap[] observeMaps = EMFObservables
					.observeMaps(
							listContentProvider.getKnownElements(),
							new EStructuralFeature[] {
									OperatorsPackage.Literals.MARKER__KIND,
									OperatorsPackage.Literals.MARKER__DESCRIPTION,
									OperatorsPackage.Literals.MARKER__VALUE_REF,
									OperatorsPackage.Literals.TOLERANCE_MARKER__DIRECTION,
									OperatorsPackage.Literals.TOLERANCE_MARKER__LEVEL });

			markersTableViewer
					.setLabelProvider(new MarkersObervableMapLabelProvider(
							observeMaps));

			IEMFListProperty resourceMonitorObservableList = EMFEditProperties
					.list(editingService.getEditingDomain(),
							OperatorsPackage.Literals.RESOURCE_MONITOR__MARKERS);

			markersTableViewer.setInput(resourceMonitorObservableList
					.observe(resMonitor));
		}
	}

	private void initChartBinding() {
		
		ISeriesSet seriesSet = chart.getSeriesSet();
		for( ISeries serie : seriesSet.getSeries()){
			seriesSet.deleteSeries(serie.getId());
		}
		
		// METRIC VALUES....
		List<Value> metricValues = null;

		if (values == null) {
			if (interval > 0) {
				MetricValueRange mvr = modelUtils.valueRangeForInterval(
						netXResource, interval);
				metricValues = mvr.getMetricValues();
				if (metricValues == null || metricValues.size() == 0) {
					return;
				}
			} else {
				// if(netXResource.getMetricValueRanges().size() > 0 ){
				// values = netXResource.getMetricValueRanges().get(0);
				// }
				return;
			}

		} else {
			metricValues = values;
		}

		if (dtr != null) {
			metricValues = this.sortAndApplyPeriod(metricValues);
		}

		// DATE RANGE FROM METRIC VALUES
		List<Date> dates = modelUtils.transformValueToDate(metricValues);
		Date[] dateArray = new Date[dates.size()];
		dates.toArray(dateArray);

		double[] metricDoubleValues = modelUtils
				.transformValueToDoubleArray(metricValues);
		this.seriesFromMetric(dateArray, metricDoubleValues, chart,
				netXResource);

		// TODO, Apply Period Filter.

		// CAP VALUES......
		List<Value> capacities = netXResource.getCapacityValues();
		List<Value> capMatchingDates = Lists.newArrayList(capacities);
		int capSize = capMatchingDates.size();
		int delta = dates.size() - capSize;
		if (capSize > 0 && delta > 0) {
			Value lastVal = capMatchingDates.get(capSize - 1);
			for (int i = capSize; i < dates.size(); i++) {
				capMatchingDates.add(i, lastVal);
			}
		}
		double[] capValues = modelUtils
				.transformValueToDoubleArray(capMatchingDates);
		this.seriesFromCapacity(dateArray, capValues, chart);

		// UTIL VALUES.
		List<Value> utilValues = sortAndApplyPeriod(netXResource
				.getUtilizationValues());

		List<Double> utilDoubleValues = modelUtils
				.transformValueToDouble(utilValues);

		// Multiply by 100
		double[] utilDoubleArray = modelUtils
				.multiplyByHundredAndToArray(utilDoubleValues);

		this.seriesFromUtilization(dateArray, utilDoubleArray, chart, 1);

		// TOL VALUES

		// Tolerances are not stored.....
		// this.seriesFromTolerance(chart, 1);

		// Setup data binding.
		// adjust the axis range
		chart.getAxisSet().adjustRange();
		chart.redraw();
	}

	public class MarkersObervableMapLabelProvider extends
			ObservableMapLabelProvider {

		public MarkersObervableMapLabelProvider(IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return super.getColumnImage(element, columnIndex);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof ToleranceMarker) {
				ToleranceMarker rm = (ToleranceMarker) element;
				switch (columnIndex) {
				case 0:
					return rm.getKind().getName();
				case 1:
					return rm.getDescription();
				case 2:

					return modelUtils.date(modelUtils.fromXMLDate(rm
							.getValueRef().getTimeStamp()))
							+ "@"
							+ modelUtils.time(modelUtils.fromXMLDate(rm
									.getValueRef().getTimeStamp()));
				case 3:
					return new Double(rm.getValueRef().getValue()).toString();
				case 4:
					return rm.getDirection().getLiteral();
				case 5:
					return rm.getLevel().getLiteral();
				}
			}
			return super.getColumnText(element, columnIndex);
		}
	}

	public Form getScreenForm() {
		return this.frmChartScreen;
	}

	public void disposeData() {
	}

	public String getScreenName() {
		return "Resource graph";
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.screens.AbstractScreenImpl#handleShowIn(org.eclipse.ui.part.ShowInContext)
	 */
	@Override
	public boolean handleShowIn(ShowInContext context) {
		
		if(context.getInput() instanceof ChartShowInContext){
			
			ChartShowInContext chartInput = (ChartShowInContext) context.getInput();
			// Clear our chart,
			this.interval = chartInput.getInterval();
			this.dtr = chartInput.getPeriod();
			this.resMonitor = chartInput.getResourceMonitor();
			ISelection selection = context.getSelection();
			if( selection instanceof IStructuredSelection){
				if(((IStructuredSelection) selection).getFirstElement() instanceof NetXResource){
					this.netXResource = (NetXResource) ((IStructuredSelection) selection).getFirstElement();
				}
			}
			
			this.initDataBindings_();
			
			return true;
		}
		
		return false;
	}
	
	
}
