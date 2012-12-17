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
package com.netxforge.netxstudio.screens.f3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.swtchart.Chart;
import org.swtchart.IAxis.Position;
import org.swtchart.IAxisTick;
import org.swtchart.IBarSeries;
import org.swtchart.ILineSeries;
import org.swtchart.ISeries;
import org.swtchart.ISeriesSet;
import org.swtchart.LineStyle;
import org.swtchart.internal.PlotArea;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.common.model.ModelUtils.TimeStampPredicate;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

/**
 * WORK IN PROGRESS, DO NOT USE YET. 
 * 
 * 
 * 
 * A Chart which presents a NetXResource, with the following features. </br>
 * <ul>
 * <li>Populates an {@link }</li>
 * <li></li>
 * </ul>
 * 
 * @author Christophe
 * 
 */
public class SmartResourceChart extends Chart {

	private static final String LEGEND_VISIBILITY = null;

	@Inject
	ModelUtils modelUtils;

	/**
	 * Wraps model references:
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class ModelWrapper {

		/** The period covering the chart */
		protected DateTimeRange dtr;

		/** The interval */
		protected int interval = -1;

		/** The NetXResource */
		protected NetXResource netXRes = null;

		/** The ResourceMonitor */
		protected ResourceMonitor resMonitor = null;

		/** A bunch of values */
		protected List<Value> values = null;

		public ModelWrapper(DateTimeRange dtr, int interval,
				NetXResource netXRes, ResourceMonitor resMonitor,
				List<Value> values) {
			super();
			this.dtr = dtr;
			this.interval = interval;
			this.netXRes = netXRes;
			this.resMonitor = resMonitor;
			this.values = values;
		}

		public DateTimeRange getDtr() {
			return dtr;
		}

		public void setDtr(DateTimeRange dtr) {
			this.dtr = dtr;
		}

		public int getInterval() {
			return interval;
		}

		public void setInterval(int interval) {
			this.interval = interval;
		}

		public NetXResource getNetXRes() {
			return netXRes;
		}

		public void setNetXRes(NetXResource netXRes) {
			this.netXRes = netXRes;
		}

		public ResourceMonitor getResMonitor() {
			return resMonitor;
		}

		public void setResMonitor(ResourceMonitor resMonitor) {
			this.resMonitor = resMonitor;
		}

		public List<Value> getValues() {
			return values;
		}

		public void setValues(List<Value> values) {
			this.values = values;
		}

	}

	private ModelWrapper model;

	/*
	 * The ID of the Y-Axis showing Utilization.
	 */
	private int utilizationAxisID = -1;

	public SmartResourceChart(Composite parent, int style, Object layoutData) {
		super(parent, style);

		if (layoutData != null) {
			this.setLayoutData(layoutData);
		}

		Color white = Display.getDefault().getSystemColor(SWT.COLOR_WHITE);

		// Initialize Chart color.
		setBackground(white);

		// Set legend visibility.
		getLegend().setPosition(SWT.BOTTOM);
		getLegend().setVisible(
				ScreensActivator.getDefault().getPreferenceStore()
						.getBoolean(LEGEND_VISIBILITY));

		MyMouseListener plotAreaListener = new MyMouseListener(getPlotArea());
		getPlotArea().addListener(SWT.MouseMove, plotAreaListener);
		getPlotArea().addListener(SWT.MouseDown, plotAreaListener);
		getPlotArea().addListener(SWT.MouseUp, plotAreaListener);

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
	@SuppressWarnings("unused")
	private void initChartBinding() {

		cleanChart();

		if (model.values == null && model.netXRes != null && model.interval > 0) {
			MetricValueRange mvr = modelUtils.valueRangeForInterval(
					model.netXRes, model.interval);
			if (mvr != null) {
				model.values = mvr.getMetricValues();
				if (model.values == null || model.values.size() == 0)
					return;
			} else
				return;
		}

		if (model.dtr != null) {
			model.values = this.sortAndApplyPeriod(model.values, model.dtr);
		}

		Date[] dateArray = modelUtils.transformValueToDateArray(model.values);
		double[] doubleArray = modelUtils
				.transformValueToDoubleArray(model.values);

		createXTickForInterval(this, model.interval);
		seriesFromMetric(dateArray, doubleArray);

		DateTimeRange metricDTR = modelUtils.range(model.values);

		// CAP VALUES......
		initCapacityRange(dateArray, metricDTR);

		// UTIL VALUES.
		initUtilizationRange(dateArray, model.values, metricDTR);

		// TOL VALUES

		// Tolerances are not stored.....
		// this.seriesFromTolerance(chart, 1);

		// Setup data binding.
		// adjust the axis range
		// chart.getAxisSet().getYAxes()[0].adjustRange();
		// chart.getAxisSet().getYAxes()[1].adjustRange();
		getAxisSet().adjustRange();
		redraw();
	}

	/**
	 * Clean by removing all series and deleting the Utilization Y-Axis.
	 */
	private void cleanChart() {

		// Clear the series set.
		ISeriesSet seriesSet = getSeriesSet();
		for (ISeries serie : seriesSet.getSeries()) {
			seriesSet.deleteSeries(serie.getId());
		}

		// clear the axis.
		if (utilizationAxisID != -1
				&& getAxisSet().getYAxis(utilizationAxisID) != null) {
			getAxisSet().deleteYAxis(utilizationAxisID);
			utilizationAxisID = -1;
		}

	}

	private void initCapacityRange(Date[] dateArray,
			DateTimeRange metricValuesDateTimeRange) {
		List<Value> capacities = model.netXRes.getCapacityValues();

		if (capacities.isEmpty()) {
			return;
		}
		// Apply a period filter.
		if (model.dtr != null) {
			capacities = this.sortAndApplyPeriod(capacities, model.dtr);
		}

		List<Value> capMatchingDates = rangeFillUpWithLastValue(dateArray,
				metricValuesDateTimeRange, capacities);

		double[] capValues = modelUtils
				.transformValueToDoubleArray(capMatchingDates);
		this.seriesFromCapacity(dateArray, capValues);
	}

	/*
	 * Filter utilization values for metric values.
	 */
	private void initUtilizationRange(Date[] dateArray,
			List<Value> metricValues, DateTimeRange dtr) {

		// Depending on the range, we want to filter the values for which we
		// have
		// a utilization.
		List<Value> utilValues = sortAndApplyPeriod(
				model.netXRes.getUtilizationValues(), dtr);

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

	/*
	 * Creates an Y-Axis showing the utilization in percentile.
	 */
	private void createUtilizationAxis() {

		utilizationAxisID = getAxisSet().createYAxis();

		// The position.
		getAxisSet().getYAxis(utilizationAxisID)
				.setPosition(Position.Secondary);

		// The title.
		getAxisSet().getYAxis(utilizationAxisID).getTitle()
				.setText("Utilization (%)");

		// The title foreground color.
		getAxisSet()
				.getYAxis(utilizationAxisID)
				.getTitle()
				.setForeground(
						Display.getDefault().getSystemColor(SWT.COLOR_BLACK));

		// The grid style.
		getAxisSet().getYAxis(utilizationAxisID).getGrid()
				.setStyle(LineStyle.DASHDOT);

		// The color of the grid for this axe.
		getAxisSet()
				.getYAxis(utilizationAxisID)
				.getGrid()
				.setForeground(
						Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
	}

	/**
	 * The mouse listener to show marker on chart.
	 */
	private class MyMouseListener implements Listener {

		/** The control to add listener. */
		private Control control;
		
		/** The Marker**/
		private ChartMarker marker;

		/**
		 * The constructor.
		 * 
		 * @param control
		 *            The control to add listener
		 */
		public MyMouseListener(Control control) {
			this.control = control;
		}

		/*
		 * @see Listener#handleEvent(Event)
		 */
		public void handleEvent(Event event) {
			int position;
			if (control instanceof Chart) {
				position = event.x - getPlotArea().getBounds().x;
			} else if (control instanceof PlotArea) {
				position = event.x;
			} else {
				throw new IllegalStateException("unknown object");//$NON-NLS-1$
			}

			switch (event.type) {
			case SWT.MouseMove:
				if (!marker.isDisposed()) {
					marker.setPosition(position);
				}
				break;
			case SWT.MouseDown:
				if (event.button == 1) {
					marker.setPosition(position);
				}
				break;
			case SWT.MouseUp:
				marker.dispose();
				break;
			default:
				break;
			}
		}
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

		ILineSeries metricLineSeries = (ILineSeries) getSeriesSet()
				.createSeries(ISeries.SeriesType.LINE, "Metric");

		metricLineSeries.setXDateSeries(dateArray);
		metricLineSeries.enableArea(true);
		metricLineSeries.setYSeries(metricValues);
		metricLineSeries.setSymbolType(ILineSeries.PlotSymbolType.TRIANGLE);

		getAxisSet().getYAxis(0).getTitle()
				.setText(model.netXRes.getUnitRef().getName());

		return metricLineSeries;
	}

	private ILineSeries seriesFromCapacity(Date[] dateArray,
			double[] capacityValues) {

		ILineSeries capLineSeries = (ILineSeries) getSeriesSet().createSeries(
				ISeries.SeriesType.LINE, "Capacity");

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

		IBarSeries utilLineSeries = (IBarSeries) getSeriesSet().createSeries(
				ISeries.SeriesType.BAR, "Utilization");
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

		ILineSeries toleranceLineSeries = (ILineSeries) getSeriesSet()
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

	public List<Value> sortAndApplyPeriod(List<Value> values, DateTimeRange dtr) {
		List<Value> sortedCopy = modelUtils
				.sortValuesByTimeStampAndReverse(values);
		return modelUtils.valuesInsideRange(sortedCopy, dtr);
	}

}
