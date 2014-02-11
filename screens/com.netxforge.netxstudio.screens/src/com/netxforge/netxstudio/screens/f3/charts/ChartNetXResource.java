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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.swtchart.Chart;
import org.swtchart.IAxis;
import org.swtchart.IAxis.Direction;
import org.swtchart.IAxis.Position;
import org.swtchart.IAxisTick;
import org.swtchart.IBarSeries;
import org.swtchart.ILineSeries;
import org.swtchart.ISeries;
import org.swtchart.ISeriesSet;
import org.swtchart.LineStyle;
import org.swtchart.Range;
import org.swtchart.ext.Messages;
import org.swtchart.internal.PlotArea;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.common.Tuple;
import com.netxforge.netxstudio.common.model.IChartModel;
import com.netxforge.netxstudio.common.model.IChartResource;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.ToleranceMarker;
import com.netxforge.netxstudio.screens.ColorManager;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;
import com.netxforge.netxstudio.screens.preferences.ScreenConstants;

/**
 * A Chart which presents a NetXResource, with the following features. </br>
 * <ul>
 * <li>Can draw 3 difference chart series</li>
 * </ul>
 * 
 * @author Christophe Bouhier
 * 
 */
public class ChartNetXResource extends Chart implements
		IPropertyChangeListener, PaintListener {

	/** the filter extensions */
	private static final String[] EXTENSIONS = new String[] { "*.jpeg",
			"*.jpg", "*.png" };

	private static final String SUM_SERIES = "Sum";

	public static final String UTILIZATION_SERIES = "Utilization";

	public static final String CAPACITY_SERIES = "Capacity";

	// public static final String METRIC_SERIES = "Metric";

	private ModelUtils modelUtils;

	/** The marker. */
	protected ChartMarker marker = null;

	/** the selection rectangle for zoom in/out */
	protected ChartSelectionRectangle selection;

	/** the clicked time in milliseconds */
	private long clickedTime;

	/*
	 * The ID of the Y-Axis showing Utilization.
	 */
	private int utilizationAxisID = -1;

	private ChartMouseListener plotAreaListener;

	private IChartModel chartModel;

	public ChartNetXResource(Composite parent, int style, Object layoutData) {
		super(parent, style);

		selection = new ChartSelectionRectangle();

		ScreensActivator.doGetPreferenceStore().addPropertyChangeListener(this);

		if (layoutData != null) {
			this.setLayoutData(layoutData);
		}
		getTitle().setVisible(false);

		Color white = Display.getDefault().getSystemColor(SWT.COLOR_WHITE);
		// Initialize Chart color.
		setBackground(white);

		// Set legend visibility.
		getLegend().setPosition(SWT.BOTTOM);
		getLegend().setVisible(
				ScreensActivator.getInstance().getPreferenceStore()
						.getBoolean(ScreenConstants.PREFERENCE_LEGEND_VISIBLE));

		plotAreaListener = new ChartMouseListener(getPlotArea());

		plotAreaListener.setActive(false);

		getPlotArea().addListener(SWT.MouseMove, plotAreaListener);
		getPlotArea().addListener(SWT.MouseDown, plotAreaListener);
		getPlotArea().addListener(SWT.MouseUp, plotAreaListener);
		getPlotArea().addListener(SWT.MouseHover, plotAreaListener);
		getPlotArea().addListener(SWT.Resize, plotAreaListener);
		getPlotArea().addListener(SWT.MouseWheel, plotAreaListener);
		getPlotArea().addListener(SWT.KeyDown, plotAreaListener);
		getPlotArea().addPaintListener(this);

		createMenuItems(plotAreaListener);

		marker = new ChartMarker(this);

		// Add drag and drop support.

	}

	/**
	 * A Selection Rectangle which is instructed to draw to select the zoom
	 * in/out area.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class ChartSelectionRectangle {
		/** the start point of selection */
		private Point startPoint;

		/** the end point of selection */
		private Point endPoint;

		/**
		 * Sets the start point.
		 * 
		 * @param x
		 *            the X coordinate of start point in pixels
		 * @param y
		 *            the Y coordinate of start point in pixels
		 */
		public void setStartPoint(int x, int y) {
			startPoint = new Point(x, y);
		}

		/**
		 * Sets the end point.
		 * 
		 * @param x
		 *            the X coordinate of end point in pixels
		 * @param y
		 *            the X coordinate of end point in pixels
		 */
		public void setEndPoint(int x, int y) {
			endPoint = new Point(x, y);
		}

		/**
		 * Gets the horizontal selected range.
		 * 
		 * @return the horizontal selected range in pixels
		 */
		public Point getHorizontalRange() {
			if (startPoint == null || endPoint == null) {
				return null;
			}

			return new Point(startPoint.x, endPoint.x);
		}

		/**
		 * Gets the vertical selected range.
		 * 
		 * @return the vertical selected range in pixels
		 */
		public Point getVerticalRange() {
			if (startPoint == null || endPoint == null) {
				return null;
			}

			return new Point(startPoint.y, endPoint.y);
		}

		/**
		 * Check if selection is disposed.
		 * 
		 * @return true if selection is disposed.
		 */
		public boolean isDisposed() {
			return startPoint == null;
		}

		/**
		 * Disposes the resource.
		 */
		public void dispose() {
			startPoint = null;
			endPoint = null;
		}

		/**
		 * Draws the selection rectangle on chart panel.
		 * 
		 * @param gc
		 *            the graphics context
		 */
		public void draw(GC gc) {
			if (startPoint == null || endPoint == null) {
				return;
			}

			int minX;
			int maxX;
			if (startPoint.x > endPoint.x) {
				minX = endPoint.x;
				maxX = startPoint.x;
			} else {
				minX = startPoint.x;
				maxX = endPoint.x;
			}

			int minY;
			int maxY;
			if (startPoint.y > endPoint.y) {
				minY = endPoint.y;
				maxY = startPoint.y;
			} else {
				minY = startPoint.y;
				maxY = endPoint.y;
			}

			gc.setLineStyle(SWT.LINE_DOT);
			gc.setForeground(Display.getDefault().getSystemColor(
					SWT.COLOR_DARK_CYAN));
			gc.drawRectangle(minX, minY, maxX - minX, maxY - minY);
		}
	}

	public void setModelUtils(ModelUtils modelUtils) {
		this.modelUtils = modelUtils;
	}

	/**
	 * Creates menu items.
	 * 
	 * @param plotAreaListener
	 */
	private void createMenuItems(ChartMouseListener plotAreaListener) {
		Menu menu = new Menu(getPlotArea());
		getPlotArea().setMenu(menu);

		// adjust axis range menu group
		MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
		menuItem.setText(Messages.ADJUST_AXIS_RANGE_GROUP);
		Menu adjustAxisRangeMenu = new Menu(menuItem);
		menuItem.setMenu(adjustAxisRangeMenu);

		// adjust axis range
		menuItem = new MenuItem(adjustAxisRangeMenu, SWT.PUSH);
		menuItem.setText(Messages.ADJUST_AXIS_RANGE);
		menuItem.addListener(SWT.Selection, plotAreaListener);

		// adjust X axis range
		menuItem = new MenuItem(adjustAxisRangeMenu, SWT.PUSH);
		menuItem.setText(Messages.ADJUST_X_AXIS_RANGE);
		menuItem.addListener(SWT.Selection, plotAreaListener);

		// adjust Y axis range
		menuItem = new MenuItem(adjustAxisRangeMenu, SWT.PUSH);
		menuItem.setText(Messages.ADJUST_Y_AXIS_RANGE);
		menuItem.addListener(SWT.Selection, plotAreaListener);

		menuItem = new MenuItem(menu, SWT.SEPARATOR);

		// zoom in menu group
		menuItem = new MenuItem(menu, SWT.CASCADE);
		menuItem.setText(Messages.ZOOMIN_GROUP);
		Menu zoomInMenu = new Menu(menuItem);
		menuItem.setMenu(zoomInMenu);

		// zoom in both axes
		menuItem = new MenuItem(zoomInMenu, SWT.PUSH);
		menuItem.setText(Messages.ZOOMIN);
		menuItem.addListener(SWT.Selection, plotAreaListener);

		// zoom in X axis
		menuItem = new MenuItem(zoomInMenu, SWT.PUSH);
		menuItem.setText(Messages.ZOOMIN_X);
		menuItem.addListener(SWT.Selection, plotAreaListener);

		// zoom in Y axis
		menuItem = new MenuItem(zoomInMenu, SWT.PUSH);
		menuItem.setText(Messages.ZOOMIN_Y);
		menuItem.addListener(SWT.Selection, plotAreaListener);

		// zoom out menu group
		menuItem = new MenuItem(menu, SWT.CASCADE);
		menuItem.setText(Messages.ZOOMOUT_GROUP);
		Menu zoomOutMenu = new Menu(menuItem);
		menuItem.setMenu(zoomOutMenu);

		// zoom out both axes
		menuItem = new MenuItem(zoomOutMenu, SWT.PUSH);
		menuItem.setText(Messages.ZOOMOUT);
		menuItem.addListener(SWT.Selection, plotAreaListener);

		// zoom out X axis
		menuItem = new MenuItem(zoomOutMenu, SWT.PUSH);
		menuItem.setText(Messages.ZOOMOUT_X);
		menuItem.addListener(SWT.Selection, plotAreaListener);

		// zoom out Y axis
		menuItem = new MenuItem(zoomOutMenu, SWT.PUSH);
		menuItem.setText(Messages.ZOOMOUT_Y);
		menuItem.addListener(SWT.Selection, plotAreaListener);

		menuItem = new MenuItem(menu, SWT.SEPARATOR);

		// save as
		menuItem = new MenuItem(menu, SWT.PUSH);
		menuItem.setText(Messages.SAVE_AS);
		menuItem.addListener(SWT.Selection, plotAreaListener);

	}

	/**
	 * Initialize the chart from the {@link IChartModel}
	 * 
	 * @param model
	 */
	public void initChartBinding(IChartModel model) {

		this.chartModel = model;

		// Re-initialize the chart, clean it.
		plotAreaListener.setActive(false);
		cleanChart();
		redraw();

		List<IChartResource> chartResources = (List<IChartResource>) model
				.getChartResources();

		boolean first = true;
		Date[] timestampArray = null;
		for (int i = 0; i < chartResources.size(); i++) {

			IChartResource cr = chartResources.get(i);

			if (cr.isFiltered())
				continue;
			// Create the axis with info from the first IChartResource
			if (first) {
				first = false;
				timestampArray = cr.getTimeStampArray();
				configureXAxis(cr, model.getInterval());
				configureYAxis();
			}
			addSeriesMetric(cr, i);

			// Add a capacity line... this can be per resource?
			if (cr.hasCapacity()) {
				configureSeriesCapacity(cr);
			}
		}

		if (timestampArray != null
				&& model.getChartNonFilteredResources().size() >= 2) {
			addSeriesSum(model, timestampArray);
			getSumSeries().setVisibleInLegend(chartModel.shouldSum());
		}

		// CB FIXME Refactor for a single IChartResource

		// if(!model.isChartModelOk()){
		// plotAreaListener.setActive(false);
		// cleanChart();
		// redraw();
		// return;
		// }
		//
		//
		// cleanChart();
		//
		// configureXAxis(model);
		// configureYAxis();
		//
		// configureSeriesMetric(model);
		//
		// if (model.hasCapacity()) {
		// configureSeriesCapacity(model);
		// }
		//
		// if (model.hasUtilization()) {
		// configureYAxisUtilization();
		// configureSeriesUtilization(model, 1);
		// configureUtilizationVisible(ScreensActivator.getInstance()
		// .getPreferenceStore()
		// .getBoolean(ScreenConstants.PREFERENCE_UTIL_VISIBLE));
		//
		// }

		getAxisSet().adjustRange();
		redraw();

		plotAreaListener.setActive(true);
	}

	private void configureUtilizationVisible(boolean visible) {

		if (getUtilAxis() != null) {
			getUtilSeries().setVisible(visible);
		}

		final IAxis utilAxis = getUtilAxis();
		if (utilAxis != null) {

			utilAxis.getTick().setVisible(visible);
			utilAxis.getTitle().setVisible(visible);
			utilAxis.getGrid().setStyle(
					visible ? LineStyle.DASHDOT : LineStyle.NONE);
		}

	}

	/**
	 * Clean by removing all series and deleting the Utilization Y-Axis.
	 */
	public void cleanChart() {

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

		getAxisSet().adjustRange();

		// for( int id : getAxisSet().getXAxisIds()){
		// IAxisTick tick = getAxisSet().getXAxis(id).getTick();
		// }
		//
		// for( int id : getAxisSet().getYAxisIds()){
		// getAxisSet().deleteYAxis(id);
		// }

	}

	private void configureYAxis() {

		// We need some info on the data to set the decimal format.
		IAxisTick yTick = this.getAxisSet().getYAxis(0).getTick();
		yTick.setFormat(new DecimalFormat("##,###.#"));
		yTick.setForeground(Display.getDefault()
				.getSystemColor(SWT.COLOR_BLACK));
	}

	private void configureXAxis(IChartResource model, int modelInterval) {

		if (model.hasNetXResource()) {

			getAxisSet()
					.getYAxis(0)
					.getTitle()
					.setText(
							(model.getNetXResource()
									.eIsSet(LibraryPackage.Literals.BASE_RESOURCE__UNIT_REF) ? model
									.getNetXResource().getUnitRef().getName()
									: " ?"));
			getAxisSet()
					.getYAxis(0)
					.getTitle()
					.setForeground(
							Display.getDefault()
									.getSystemColor(SWT.COLOR_BLACK));
		}

		Tuple interval = modelUtils.interval(modelInterval);

		String label = (String) interval.getKey();
		String primaryDatePattern = (String) interval.getValue();

		// set the label.
		getAxisSet().getXAxis(0).getTitle().setText(label);
		getAxisSet()
				.getXAxis(0)
				.getTitle()
				.setForeground(
						Display.getDefault().getSystemColor(SWT.COLOR_BLACK));

		DateFormat primaryFormat = new SimpleDateFormat(primaryDatePattern);

		IAxisTick xTick = getAxisSet().getXAxis(0).getTick();
		xTick.setFormat(primaryFormat);
		xTick.setTickLabelAngle(45);
		xTick.setForeground(Display.getDefault()
				.getSystemColor(SWT.COLOR_BLACK));

	}

	/*
	 * Creates an Y-Axis showing the utilization in percentile.
	 */
	@SuppressWarnings("unused")
	private void configureYAxisUtilization() {

		utilizationAxisID = getAxisSet().createYAxis();
		IAxis yAxis = getAxisSet().getYAxis(utilizationAxisID);

		// The position.

		yAxis.setPosition(Position.Secondary);
		// The title.
		yAxis.getTitle().setText("Utilization (%)");
		// The title foreground color.
		yAxis.getTitle().setForeground(
				Display.getDefault().getSystemColor(SWT.COLOR_BLACK));
		// The grid style.
		yAxis.getGrid().setStyle(LineStyle.DASHDOT);
		// The color of the grid for this axe.
		yAxis.getGrid().setForeground(
				Display.getDefault().getSystemColor(SWT.COLOR_GREEN));

		yAxis.getTick().setForeground(
				Display.getDefault().getSystemColor(SWT.COLOR_BLACK));

		// Hide the grid when not active.

	}

	/**
	 * The mouse listener to show marker on chart.
	 */
	private class ChartMouseListener implements Listener {

		/** The control to add listener. */
		private Control control;

		// If the listener is active.
		private boolean active = false;

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		/**
		 * The constructor.
		 * 
		 * @param control
		 *            The control to add listener
		 */
		public ChartMouseListener(Control control) {
			this.control = control;
			control.addFocusListener(new FocusAdapter() {

				@Override
				public void focusLost(FocusEvent e) {
					if (!marker.isDisposed()) {
						marker.dispose();
					}
				}
			});
		}

		/*
		 * @see Listener#handleEvent(Event)
		 */
		public void handleEvent(Event event) {

//			System.out.println("process event for chart:" + event);

			if (!isActive()) {
				return;
			}

			if (marker == null) {
				return;
			}

			int xPosition;
			int yPosition;

			if (control instanceof Chart) {
				xPosition = event.x - getPlotArea().getBounds().x;
				yPosition = event.y - getPlotArea().getBounds().y;
			} else if (control instanceof PlotArea) {
				xPosition = event.x;
				yPosition = event.y;
			} else {
				throw new IllegalStateException("unknown object");//$NON-NLS-1$
			}

			switch (event.type) {
			case SWT.MouseHover:
				marker.setPosition(xPosition, yPosition);
				redraw();
				break;
			case SWT.MouseMove:
				if (!marker.isDisposed()) {
					marker.dispose();

				}
				if (!selection.isDisposed()) {

					selection.setEndPoint(event.x, event.y);

					// The rectange size, should be at least...To avoid the
					// intention
					// to show the marker, but instead having an intense deep
					// zoom.
					// if (selectionIntended()) {
					// marker.dispose(); // Hide the marker when dragging.
					//
					// }
					redraw();
				}
				break;
			case SWT.MouseDown:
				if (event.button == 1) {
					marker.setPosition(xPosition, yPosition);
					selection.setStartPoint(event.x, event.y);
					clickedTime = System.currentTimeMillis();
				}else if(event.button == 3){
					// dispose the markers. 
					marker.dispose();
				}
				break;
			case SWT.MouseUp:
				// Use the clicked time to deal with the Marker handling.
				if (event.button == 1
						&& System.currentTimeMillis() - clickedTime > 100
						&& selectionIntended()) {
					for (IAxis axis : getAxisSet().getAxes()) {
						Point range = null;
						if ((getOrientation() == SWT.HORIZONTAL && axis
								.getDirection() == Direction.X)
								|| (getOrientation() == SWT.VERTICAL && axis
										.getDirection() == Direction.Y)) {
							range = selection.getHorizontalRange();
						} else {
							range = selection.getVerticalRange();
						}

						if (range != null && range.x != range.y) {
							setRange(range, axis);
						}
					}
				}
				selection.dispose();

				redraw();
				break;
			case SWT.MouseWheel:
				handleMouseWheel(event);
				break;
			case SWT.KeyDown:
				handleKeyDownEvent(event);
				break;
			case SWT.Selection:
				handleSelectionEvent(event);
				break;
			default:
				break;
			}
		}

		/**
		 * The selection range should be a certain size before working.
		 * 
		 * @return
		 */
		private boolean selectionIntended() {
			if (selection.getHorizontalRange() != null
					&& selection.getVerticalRange() != null) {

				return selection.getHorizontalRange().y
						- selection.getHorizontalRange().x > 15
						&& selection.getVerticalRange().y
								- selection.getVerticalRange().x > 15;
			} else {
				return false;
			}
		}
	}

	/**
	 * Sets the axis range.
	 * 
	 * @param range
	 *            the axis range in pixels
	 * @param axis
	 *            the axis to set range
	 */
	private void setRange(Point range, IAxis axis) {
		if (range == null) {
			return;
		}

		double min = axis.getDataCoordinate(range.x);
		double max = axis.getDataCoordinate(range.y);

		axis.setRange(new Range(min, max));
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
	private ILineSeries addSeriesMetric(IChartResource model, int count) {

		ILineSeries metricLineSeries = (ILineSeries) getSeriesSet()
				.createSeries(ISeries.SeriesType.LINE, model.getChartID());

		metricLineSeries.setXDateSeries(model.getTimeStampArray());

		// Make optional.
		// metricLineSeries.enableArea(true);
		metricLineSeries.setYSeries(model.getMetriDoubleArray());
		metricLineSeries.setSymbolType(ILineSeries.PlotSymbolType.TRIANGLE);
		final Color metricColor = ScreensActivator.getInstance()
				.getPreferenceColor(
						ScreenConstants.PREFERENCE_METRIC_COLORS[count]);
		metricLineSeries.setLineColor(metricColor);
		return metricLineSeries;
	}

	private ILineSeries addSeriesSum(IChartModel model, Date[] timestampArray) {
		ILineSeries sumSeries = (ILineSeries) getSeriesSet().createSeries(
				ISeries.SeriesType.LINE, SUM_SERIES);
		sumSeries.setVisible(false);

		sumSeries.setXDateSeries(timestampArray);

		// Make optional.
		// metricLineSeries.enableArea(true);
		sumSeries.setYSeries(model.sum());
		sumSeries.setSymbolType(ILineSeries.PlotSymbolType.TRIANGLE);
		final Color metricColor = ScreensActivator
				.getInstance()
				.getPreferenceColor(ScreenConstants.PREFERENCE_METRIC_SUM_COLOR);
		sumSeries.setLineColor(metricColor);
		return sumSeries;

	}

	private ILineSeries configureSeriesCapacity(IChartResource model) {

		ILineSeries capLineSeries = (ILineSeries) getSeriesSet().createSeries(
				ISeries.SeriesType.LINE, CAPACITY_SERIES);

		capLineSeries.setXDateSeries(model.getTimeStampArray());
		capLineSeries.setYSeries(model.getCapDoubleArray());
		capLineSeries.enableStep(true);
		final Color capColor = ScreensActivator.getInstance()
				.getPreferenceColor(ScreenConstants.PREFERENCE_CAP_COLOR);
		capLineSeries.setLineColor(capColor);
		capLineSeries.setLineWidth(2);
		capLineSeries.setLineStyle(LineStyle.DASHDOT);
		capLineSeries.setSymbolType(ILineSeries.PlotSymbolType.NONE);
		return capLineSeries;

	}

	@SuppressWarnings("unused")
	private IBarSeries configureSeriesUtilization(IChartResource model,
			int yAxisID) {

		IBarSeries utilLineSeries = (IBarSeries) getSeriesSet().createSeries(
				ISeries.SeriesType.BAR, UTILIZATION_SERIES);
		utilLineSeries.setXDateSeries(model.getTimeStampArray());
		utilLineSeries.setYSeries(model.getUtilDoubleArray());
		utilLineSeries.setYAxisId(yAxisID); // Connect a series to the
											// Y-Axis.
		final Color utilColor = ScreensActivator.getInstance()
				.getPreferenceColor(ScreenConstants.PREFERENCE_UTIL_COLOR);
		utilLineSeries.setBarColor(utilColor);
		utilLineSeries.setBarPadding(50);
		return utilLineSeries;
	}

	@SuppressWarnings("unused")
	private ILineSeries configureSeriesTolerance(Date[] dateArray,
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

	/*
	 * Return the metric series in the proper series type.
	 */
	public List<ILineSeries> getMetricSeries() {

		List<ILineSeries> metricSeries = Lists.newArrayList();
		if (chartModel != null) {
			for (IChartResource r : chartModel.getChartNonFilteredResources()) {
				String chartID = r.getChartID();
				ILineSeries series = (ILineSeries) getSeries(chartID);
				if (series == null) {
					throw new IllegalStateException("No series for chart ID! "
							+ chartID);
				} else {
					metricSeries.add(series);
				}
			}
		}
		return metricSeries;
	}

	/*
	 * Return the capacity series in the proper series type.
	 */

	public ILineSeries getCapSeries() {
		return (ILineSeries) getSeries(CAPACITY_SERIES);
	}

	public ILineSeries getSumSeries() {
		return (ILineSeries) getSeries(SUM_SERIES);
	}

	/*
	 * Return the capacity series in the proper series type.
	 */
	public IBarSeries getUtilSeries() {
		ISeries utilSeries = getSeries(UTILIZATION_SERIES);
		return utilSeries != null ? (IBarSeries) utilSeries : null;
	}

	/*
	 * Return the IAxis for the utilization.
	 */
	private IAxis getUtilAxis() {
		return this.getAxisSet().getYAxis(utilizationAxisID);
	}

	/*
	 * return an ISeries for the specified ID.
	 */
	private ISeries getSeries(String seriesID) {
		return this.getSeriesSet().getSeries(seriesID);
	}

	/*
	 * Gets the axes for given orientation.
	 */
	private IAxis[] getAxes(int orientation) {
		IAxis[] axes;
		if (getOrientation() == orientation) {
			axes = getAxisSet().getXAxes();
		} else {
			axes = getAxisSet().getYAxes();
		}
		return axes;
	}

	/*
	 * @see IPropertyChangeListener#propertyChange(PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent event) {
		boolean needsRedraw = false;
		if (ScreenConstants.PREFERENCE_LEGEND_VISIBLE.equals(event
				.getProperty()) && !isDisposed()) {
			getLegend().setVisible((Boolean) (event.getNewValue()));
			needsRedraw = true;
		} else if (ScreenConstants.PREFERENCE_UTIL_VISIBLE.equals(event
				.getProperty()) && !isDisposed()) {
			configureUtilizationVisible((Boolean) (event.getNewValue()));
			needsRedraw = true;
		} else if (ScreenConstants.PREFERENCE_CAP_COLOR.equals(event
				.getProperty())) {
			final Color preferenceColor = ColorManager.getInstance().getColor(
					(RGB) event.getNewValue());
			getCapSeries().setLineColor(preferenceColor);
			needsRedraw = true;

		} else if (ScreenConstants.PREFERENCE_UTIL_COLOR.equals(event
				.getProperty())) {
			final Color preferenceColor = ColorManager.getInstance().getColor(
					(RGB) event.getNewValue());
			if (getUtilSeries() != null) {
				getUtilSeries().setBarColor(preferenceColor);
				needsRedraw = true;
			}

		} else if (event.getProperty().startsWith("metricColorPreference")) {

			String property = event.getProperty();
			Integer seriesIndex = new Integer(property.substring(
					property.length() - 1, property.length() - 0)) - 1;

			final Color preferenceColor = ColorManager.getInstance().getColor(
					(RGB) event.getNewValue());
			if (getMetricSeries().size() > seriesIndex) {
				ILineSeries iLineSeries = getMetricSeries().get(seriesIndex);
				if (iLineSeries != null) {
					iLineSeries.setLineColor(preferenceColor);
					needsRedraw = true;
				}
			}
		}

		if (needsRedraw) {
			redraw();
		}
	}

	public void paintControl(PaintEvent e) {
		selection.draw(e.gc);
	}

	/**
	 * Handles mouse wheel event.
	 * 
	 * @param event
	 *            the mouse wheel event
	 */
	private void handleMouseWheel(Event event) {
		for (IAxis axis : getAxes(SWT.HORIZONTAL)) {
			double coordinate = axis.getDataCoordinate(event.x);
			if (event.count > 0) {
				axis.zoomIn(coordinate);
			} else {
				axis.zoomOut(coordinate);
			}
		}

		for (IAxis axis : getAxes(SWT.VERTICAL)) {
			double coordinate = axis.getDataCoordinate(event.y);
			if (event.count > 0) {
				axis.zoomIn(coordinate);
			} else {
				axis.zoomOut(coordinate);
			}
		}
		redraw();
	}

	/**
	 * Handles the key down event. FIXME Doesn't work for MacOSX, as the
	 * CTRL-Arrow is already OS assigned.
	 * 
	 * 
	 * @param event
	 *            the key down event
	 */
	private void handleKeyDownEvent(Event event) {
		if (event.keyCode == SWT.ARROW_DOWN) {
			if (event.stateMask == SWT.CTRL) {
				getAxisSet().zoomOut();
			} else {
				for (IAxis axis : getAxes(SWT.VERTICAL)) {
					axis.scrollDown();
				}
			}
			redraw();
		} else if (event.keyCode == SWT.ARROW_UP) {
			if (event.stateMask == SWT.CTRL) {
				getAxisSet().zoomIn();
			} else {
				for (IAxis axis : getAxes(SWT.VERTICAL)) {
					axis.scrollUp();
				}
			}
			redraw();
		} else if (event.keyCode == SWT.ARROW_LEFT) {
			for (IAxis axis : getAxes(SWT.HORIZONTAL)) {
				axis.scrollDown();
			}
			redraw();
		} else if (event.keyCode == SWT.ARROW_RIGHT) {
			for (IAxis axis : getAxes(SWT.HORIZONTAL)) {
				axis.scrollUp();
			}
			redraw();
		}
	}

	/**
	 * Handles the selection event.
	 * 
	 * @param event
	 *            the event
	 */
	private void handleSelectionEvent(Event event) {

		if (!(event.widget instanceof MenuItem)) {
			return;
		}
		MenuItem menuItem = (MenuItem) event.widget;

		if (menuItem.getText().equals(Messages.ADJUST_AXIS_RANGE)) {
			getAxisSet().adjustRange();
		} else if (menuItem.getText().equals(Messages.ADJUST_X_AXIS_RANGE)) {
			for (IAxis axis : getAxisSet().getXAxes()) {
				axis.adjustRange();
			}
		} else if (menuItem.getText().equals(Messages.ADJUST_Y_AXIS_RANGE)) {
			for (IAxis axis : getAxisSet().getYAxes()) {
				axis.adjustRange();
			}
		} else if (menuItem.getText().equals(Messages.ZOOMIN)) {
			getAxisSet().zoomIn();
		} else if (menuItem.getText().equals(Messages.ZOOMIN_X)) {
			for (IAxis axis : getAxisSet().getXAxes()) {
				axis.zoomIn();
			}
		} else if (menuItem.getText().equals(Messages.ZOOMIN_Y)) {
			for (IAxis axis : getAxisSet().getYAxes()) {
				axis.zoomIn();
			}
		} else if (menuItem.getText().equals(Messages.ZOOMOUT)) {
			getAxisSet().zoomOut();
		} else if (menuItem.getText().equals(Messages.ZOOMOUT_X)) {
			for (IAxis axis : getAxisSet().getXAxes()) {
				axis.zoomOut();
			}
		} else if (menuItem.getText().equals(Messages.ZOOMOUT_Y)) {
			for (IAxis axis : getAxisSet().getYAxes()) {
				axis.zoomOut();
			}
		} else if (menuItem.getText().equals(Messages.SAVE_AS)) {
			openSaveAsDialog();
		}
		redraw();
	}

	/**
	 * Opens the Save As dialog.
	 */
	private void openSaveAsDialog() {
		FileDialog dialog = new FileDialog(getShell(), SWT.SAVE);
		dialog.setText(Messages.SAVE_AS_DIALOG_TITLE);
		dialog.setFilterExtensions(EXTENSIONS);

		String filename = dialog.open();
		if (filename == null) {
			return;
		}

		int format;
		if (filename.endsWith(".jpg") || filename.endsWith(".jpeg")) {
			format = SWT.IMAGE_JPEG;
		} else if (filename.endsWith(".png")) {
			format = SWT.IMAGE_PNG;
		} else {
			format = SWT.IMAGE_UNDEFINED;
		}

		if (format != SWT.IMAGE_UNDEFINED) {
			save(filename, format);
		}
	}

	public void showHover(Value v) {
		long timeInMillis = v.getTimeStamp().toGregorianCalendar()
				.getTimeInMillis();
		if (!marker.isDisposed()) {
			marker.dispose();

		}
		marker.setTime(timeInMillis);
		redraw();
	}

	public void showHover(ToleranceMarker firstElement) {
		showHover(firstElement.getValueRef());
	}

	public void hideHover() {
		marker.dispose();
		redraw();
	}

	public void updateSumStatus() {

		ISeries series = this.getSeries(SUM_SERIES);
		if (series != null) {
			series.setVisible(chartModel.shouldSum());
			series.setVisibleInLegend(chartModel.shouldSum());
			this.getAxisSet().adjustRange();
			redraw();
		}
	}
}
