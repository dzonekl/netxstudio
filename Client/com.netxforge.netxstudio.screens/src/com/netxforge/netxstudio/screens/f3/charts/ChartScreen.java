/*******************************************************************************
 * Copyright (c) 16 dec. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.f3.charts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.IWizard;
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

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.common.model.ModelUtils.TimeStampPredicate;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.operators.ToleranceMarker;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.common.tables.TableHelper;
import com.netxforge.netxstudio.screens.common.tables.TableHelper.TBVCFeatureSorter;
import com.netxforge.netxstudio.screens.editing.actions.WizardUtil;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.f1.support.ValueRangeSelectionWizard;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;
import com.netxforge.netxstudio.screens.showins.ChartShowInContext;

/**
 * 
 * @author Christophe Bouhier
 */
public class ChartScreen extends AbstractScreen implements IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private Chart chart;

	private Table table;

	private Form frmChartScreen;

	private TableViewer markersTableViewer;

	@Inject
	private TableHelper tableHelper;

	private int utilizationAxisID = -1;

	// Context variables.
	private ResourceMonitor resMonitor;

	private NetXResource netXResource;

	private DateTimeRange dtr;

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
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 4);
		gridData.heightHint = 350;
		// gridData.widthHint = 400;
		chart.setLayoutData(gridData);
		chart.setBackground(Display.getDefault()
				.getSystemColor(SWT.COLOR_WHITE));

		chart.getTitle().setVisible(false);

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

		{ // Column 1.
			tableHelper.new TBVC<String>().tbvcFor(markersTableViewer, "Type",
					"Marker Type", 125, null,
					new TableHelper.ComparableComparator<String>());
		}

		{ // Column 2.
			tableHelper.new TBVC<String>().tbvcFor(markersTableViewer,
					"Description", "Additional description for the Marker",
					200, null, new TableHelper.ComparableComparator<String>());
		}

		{ // Column 3.
			TableViewerColumn tbvcFor = tableHelper.new TBVC<Date>().tbvcFor(
					markersTableViewer, "TimeStamp",
					"The date and time the Marker occurred", 140,
					(EditingSupport) null);

			TBVCFeatureSorter<Value> tbvcFeatureSorter = tableHelper.new TBVCFeatureSorter<Value>(tbvcFor,
					OperatorsPackage.Literals.MARKER__VALUE_REF,
					modelUtils.valueTimeStampCompare());
			tbvcFeatureSorter.setSorter(TBVCFeatureSorter.DESC);
		}

		{ // Column 4.
			tableHelper.new TBVC<String>().tbvcFor(markersTableViewer, "Value",
					"The marked Value.", 100, null,
					new TableHelper.ComparableComparator<String>());
		}

		{ // Column 5.
			tableHelper.new TBVC<String>().tbvcFor(markersTableViewer,
					"Direction", "The direction in which the Value moves.",
					100, null, new TableHelper.ComparableComparator<String>());
		}

		{ // Column 6.
			tableHelper.new TBVC<String>().tbvcFor(markersTableViewer, "Level",
					"The Marker level.", 100, null,
					new TableHelper.ComparableComparator<String>());
		}

	}

	/*
	 * Creates an Y-Axis showing the utilization in percentile.
	 */
	private void createUtilizationAxis() {

		utilizationAxisID = chart.getAxisSet().createYAxis();

		// The position.
		chart.getAxisSet().getYAxis(utilizationAxisID)
				.setPosition(Position.Secondary);

		// The title.
		chart.getAxisSet().getYAxis(utilizationAxisID).getTitle()
				.setText("Utilization (%)");

		// The title foreground color.
		chart.getAxisSet()
				.getYAxis(utilizationAxisID)
				.getTitle()
				.setForeground(
						Display.getDefault().getSystemColor(SWT.COLOR_BLACK));

		// The grid style.
		chart.getAxisSet().getYAxis(utilizationAxisID).getGrid()
				.setStyle(LineStyle.DASHDOT);

		// The color of the grid for this axe.
		chart.getAxisSet()
				.getYAxis(utilizationAxisID)
				.getGrid()
				.setForeground(
						Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
	}

	/**
	 * A Scroll stick which scrolls the Y-Axis up or down, and the X-Axis left
	 * and right.
	 * 
	 * @param parent
	 * @param gd
	 */
	private void buildScrollStick(Composite parent, GridData gd) {
		Composite compositeScrollStick = toolkit.createComposite(parent,
				SWT.NONE);
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

	private int interval = -1;

	private List<Value> values;

	/* The parent component for the resource */
	private Component component;

	/* Prefer to use a Resource Monitor as a given input! */
	@SuppressWarnings("unused")
	private List<Marker> markers;

	public List<Value> sortAndApplyPeriod(List<Value> values) {
		List<Value> sortedCopy = modelUtils
				.sortValuesByTimeStampAndReverse(values);
		return modelUtils.valuesInsideRange(sortedCopy, dtr);
	}

	private void createXTickForInterval(Chart chart, int interval) {

		String primaryDatePattern = "";
		// String secondaryDatePattern = "";
		String label = "";
		switch (interval) {
		case ModelUtils.MINUTES_IN_AN_HOUR: {
			primaryDatePattern = "dd-MMM HH:mm";
			label = "HOUR";
		}
			break;
		case ModelUtils.MINUTES_IN_A_DAY: {
			primaryDatePattern = "dd-MMM";
			label = "DAY";

		}
			break;
		case ModelUtils.MINUTES_IN_A_WEEK: {
			primaryDatePattern = "ww";
			label = "WEEK";
		}
			break;
		case ModelUtils.MINUTES_IN_A_MONTH: {
			primaryDatePattern = "MMMMM";
			label = "MONTH";
		}
			break;
		default: {
			primaryDatePattern = "HH:mm";
			label = modelUtils.fromMinutes(interval);
		}
		}

		// set the label.
		chart.getAxisSet().getXAxis(0).getTitle().setText(label);

		DateFormat primaryFormat = new SimpleDateFormat(primaryDatePattern);

		IAxisTick xTick = chart.getAxisSet().getXAxis(0).getTick();
		// xTick.setTickMarkStepHint(2);
		xTick.setFormat(primaryFormat);

		xTick.setTickLabelAngle(45);

		// int secondaryAxisID = 1;
		// if (chart.getAxisSet().getXAxes().length == 1) {
		// secondaryAxisID = chart.getAxisSet().createXAxis();
		// }
		// IAxis xAxisSecondary = chart.getAxisSet().getXAxis(secondaryAxisID);
		// xAxisSecondary.getTitle().setText("DAY");
		// xAxisSecondary.getTick().setTickMarkStepHint(10);
		//
		// DateFormat secondaryFormat = new
		// SimpleDateFormat(secondaryDatePattern);
		// IAxisTick xTickSecondary = xAxisSecondary.getTick();
		// xTickSecondary.setFormat(secondaryFormat);

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
	private ILineSeries seriesFromMetric(Date[] dateArray, double[] metricValues) {

		ILineSeries metricLineSeries = (ILineSeries) chart.getSeriesSet()
				.createSeries(ISeries.SeriesType.LINE, "Metric");

		metricLineSeries.setXDateSeries(dateArray);
		metricLineSeries.enableArea(true);
		metricLineSeries.setYSeries(metricValues);
		metricLineSeries.setSymbolType(ILineSeries.PlotSymbolType.TRIANGLE);

		chart.getAxisSet().getYAxis(0).getTitle()
				.setText(netXResource.getUnitRef().getName());

		return metricLineSeries;
	}

	private ILineSeries seriesFromCapacity(Date[] dateArray,
			double[] capacityValues) {

		ILineSeries capLineSeries = (ILineSeries) chart.getSeriesSet()
				.createSeries(ISeries.SeriesType.LINE, "Capacity");

		capLineSeries.setXDateSeries(dateArray);
		capLineSeries.setYSeries(capacityValues);
		capLineSeries.enableStep(true);
		capLineSeries.setLineColor(Display.getDefault().getSystemColor(
				SWT.COLOR_DARK_YELLOW));
		capLineSeries.setLineWidth(2);
		capLineSeries.setLineStyle(LineStyle.DASHDOT);
		capLineSeries.setSymbolType(ILineSeries.PlotSymbolType.NONE);
		return capLineSeries;

	}

	private IBarSeries seriesFromUtilization(Date[] dateArray,
			double[] utilizationValues, int yAxisID) {

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
			double[] toleranceValues, int yAxisID) {

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
				// this.dtr = (DateTimeRange) object;
				this.netXResource = (NetXResource) owner;
			}

			if (object instanceof List<?>) {
				this.values = (List<Value>) object;
			}
			// buildUI();

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

		// buildUI();
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

		frmChartScreen.setText("Resource: "
				+ netXResource.getLongName()
				+ (component != null ? " ( "
						+ modelUtils.componentName(component) + ")" : ""));

		initChartBinding();
		initMarkersBinding();

		return context;
	}

	/*
	 * Build a chart. The values to show are extracted from the injected
	 * netXResource and interval. The metric values are sorted by period.
	 * 
	 * TODO split in consumable sub-ranges matching the interval. The UI allows
	 * to select the sub-range.
	 * 
	 * For a sub-range the corresponding capacity and utilization a chart series
	 * is produced.
	 * 
	 * The x-axis (xtick) is determined from the interval.
	 */
	private void initChartBinding() {

		cleanChart();

		if (values == null && netXResource != null && interval > 0) {
			MetricValueRange mvr = modelUtils.valueRangeForInterval(
					netXResource, interval);
			if (mvr != null) {
				values = mvr.getMetricValues();
				if (values == null || values.size() == 0)
					return;
			} else
				return;
		}

		if (dtr != null) {
			values = this.sortAndApplyPeriod(values);
		}

		Date[] dateArray = modelUtils.transformValueToDateArray(values);
		double[] doubleArray = modelUtils.transformValueToDoubleArray(values);

		createXTickForInterval(chart, interval);
		seriesFromMetric(dateArray, doubleArray);

		DateTimeRange metricDTR = modelUtils.range(values);

		// CAP VALUES......
		initCapacityRange(dateArray, metricDTR);

		// UTIL VALUES.
		initUtilizationRange(dateArray, values, metricDTR);

		// TOL VALUES

		// Tolerances are not stored.....
		// this.seriesFromTolerance(chart, 1);

		// Setup data binding.
		// adjust the axis range
		// chart.getAxisSet().getYAxes()[0].adjustRange();
		// chart.getAxisSet().getYAxes()[1].adjustRange();
		chart.getAxisSet().adjustRange();
		chart.redraw();
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

			// EMFEditProperties.
			markersTableViewer.setInput(resourceMonitorObservableList
					.observe(resMonitor));
		}
	}

	private void cleanChart() {

		// Clear the series set.
		ISeriesSet seriesSet = chart.getSeriesSet();
		for (ISeries serie : seriesSet.getSeries()) {
			seriesSet.deleteSeries(serie.getId());
		}

		// clear the axis.
		if (utilizationAxisID != -1
				&& chart.getAxisSet().getYAxis(utilizationAxisID) != null) {
			chart.getAxisSet().deleteYAxis(utilizationAxisID);
		}

	}

	/*
	 * Filter utlization values for metric values.
	 */
	private void initUtilizationRange(Date[] dateArray,
			List<Value> metricValues, DateTimeRange dtr) {

		// Depending on the range, we want to filter the values for which we
		// have
		// a utilization.
		List<Value> utilValues = sortAndApplyPeriod(netXResource
				.getUtilizationValues());

		// Why not get from the period?
		utilValues = modelUtils.valuesForValues(utilValues, metricValues);

		if (utilValues.isEmpty()) {
			return;
		}

		// Make sure we are equal size.
		if (dateArray.length != utilValues.size()) {
			if (ScreensActivator.DEBUG) {
				ScreensActivator.TRACE
						.trace(ScreensActivator.TRACE_SCREENS_OPTION,
								"Skip plotting utilization, date array and util array length mismatch sizes => dates: "
										+ dateArray.length
										+ " util values: "
										+ utilValues.size());
			}
			utilValues = rangeFillUpGaps(dateArray, dtr, utilValues);
		}

		List<Double> utilDoubleValues = modelUtils
				.transformValueToDouble(utilValues);

		// Multiply by 100
		double[] utilDoubleArray = modelUtils
				.multiplyByHundredAndToArray(utilDoubleValues);

		// Create the axis.
		createUtilizationAxis();

		this.seriesFromUtilization(dateArray, utilDoubleArray, 1);
	}

	private void initCapacityRange(Date[] dateArray,
			DateTimeRange metricValuesDateTimeRange) {
		List<Value> capacities = netXResource.getCapacityValues();

		if (capacities.isEmpty()) {
			return;
		}
		// Apply a period filter.
		if (dtr != null) {
			capacities = this.sortAndApplyPeriod(capacities);
		}

		List<Value> capMatchingDates = rangeFillUpWithLastValue(dateArray,
				metricValuesDateTimeRange, capacities);

		double[] capValues = modelUtils
				.transformValueToDoubleArray(capMatchingDates);
		this.seriesFromCapacity(dateArray, capValues);
	}

	/**
	 * Fill up a range with missing values from the initial collection for the
	 * provided period.
	 * 
	 * @param timeStamps
	 * @param dtr
	 * @param initialCollection
	 * @return
	 */
	private List<Value> rangeFillUpWithLastValue(Date[] timeStamps,
			DateTimeRange dtr, List<Value> initialCollection) {
		List<Value> filledCollection = Lists.newArrayList(initialCollection);

		int initialSize = filledCollection.size();
		if (initialSize > 0 && initialSize > timeStamps.length) {
			// we have more in the initial collection then the number of
			// timeStamps timestamps , strip according
			// to the metric value date time range, filling up the blanks.
			filledCollection = modelUtils.valuesInsideRange(filledCollection,
					dtr);
			return filledCollection;
		}

		// Get the last value from the collection, and fill up for the quantity
		// of dates.

		initialSize = filledCollection.size();
		if (initialSize > 0 && initialSize < timeStamps.length) {
			Value lastVal = filledCollection.get(initialSize - 1);
			for (int i = initialSize; i < timeStamps.length; i++) {
				filledCollection.add(i, lastVal);
			}
		}
		return filledCollection;
	}

	private List<Value> rangeFillUpGaps(Date[] timeStamps, DateTimeRange dtr,
			List<Value> initialCollection) {
		List<Value> filledCollection = Lists.newArrayList(initialCollection);

		int initialSize = filledCollection.size();
		if (initialSize > 0 && initialSize > timeStamps.length) {
			// we have more in the initial collection then the number of
			// timeStamps timestamps , strip according
			// to the metric value date time range, filling up the blanks.
			filledCollection = modelUtils.valuesInsideRange(filledCollection,
					dtr);
			return filledCollection;
		}

		// Get the last value from the collection, and fill up for the quantity
		// of dates.
		// Find the collection value for each date.
		ArrayList<Date> timeStampsCollection = Lists.newArrayList(timeStamps);
		filledCollection = Lists.newArrayListWithCapacity(timeStampsCollection
				.size());

		for (int i = 0; i < timeStampsCollection.size(); i++) {
			Date date = timeStampsCollection.get(i);
			TimeStampPredicate timeStampPredicate = modelUtils.new TimeStampPredicate(
					date);
			try {
				Value find = Iterables.find(initialCollection,
						timeStampPredicate);
				filledCollection.add(i, find);
			} catch (NoSuchElementException nsee) {
				Value createValue = GenericsFactory.eINSTANCE.createValue();
				createValue.setTimeStamp(modelUtils.toXMLDate(date));
				createValue.setValue(0);
				// Nope
				filledCollection.add(i, createValue);
			}

		}

		return filledCollection;
	}

	// TODO Move to ModelUtils (Even when used).
	@SuppressWarnings("unused")
	private List<Date> getTS() {
		List<Date> allTS = Lists.newArrayList();
		Multimap<Integer, XMLGregorianCalendar> timeStampsByWeek = modelUtils
				.hourlyTimeStampsByWeekFor(dtr);
		// build an index of colums and timestamps.
		for (int i : timeStampsByWeek.keySet()) {
			Collection<XMLGregorianCalendar> collection = timeStampsByWeek
					.get(i);
			allTS.addAll(modelUtils.transformXMLDateToDate(collection));

		}
		Collections.sort(allTS);
		return allTS;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.AbstractScreenImpl#handleShowIn(org.
	 * eclipse.ui.part.ShowInContext)
	 */
	@Override
	public boolean handleShowIn(ShowInContext context) {

		if (context.getInput() instanceof ChartShowInContext) {

			ChartShowInContext chartInput = (ChartShowInContext) context
					.getInput();

			// Clear our chart,
			this.interval = chartInput.getInterval();
			this.dtr = chartInput.getPeriod();
			this.resMonitor = chartInput.getResourceMonitor();
			this.markers = chartInput.getMarkers();
			
			ISelection selection = context.getSelection();

			// fire a wizard to select the range, block until we select a range.
			IWizard wiz = WizardUtil.openWizard(
					"com.netxforge.netxstudio.screens.valueranges",
					(IStructuredSelection) selection, true);

			if (wiz instanceof ValueRangeSelectionWizard) {
				MetricValueRange valueRange = ((ValueRangeSelectionWizard) wiz)
						.getValueRange();
				values = valueRange.getMetricValues();
				interval = valueRange.getIntervalHint();
			}

			if (selection instanceof IStructuredSelection) {
				if (((IStructuredSelection) selection).getFirstElement() instanceof NetXResource) {
					this.netXResource = (NetXResource) ((IStructuredSelection) selection)
							.getFirstElement();
					component = netXResource.getComponentRef();
				}
			}

			this.initDataBindings_();

			return true;
		}

		return false;
	}

}
