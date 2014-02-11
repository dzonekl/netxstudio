/*******************************************************************************
 * Copyright (c) 3 feb. 2014 NetXForge.
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

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.swtchart.IAxis;
import org.swtchart.ILineSeries;
import org.swtchart.ISeries;

import com.netxforge.netxstudio.screens.internal.ScreensActivator;
import com.netxforge.netxstudio.screens.preferences.ScreenConstants;

/**
 * The marker showing the rectangle symbols and tooltip on chart
 */
public class ChartMarker {

	/** The margin for text on hover. */
	private static final int MARGIN = 3;

	/** The offset of hover that is the size of hover arrow. */
	private static final int OFFSET = 25;

	/** The key for hover to show time. */
	private static final String TIME_KEY = "time"; //$NON-NLS-1$

	/** The hovers. */
	private Map<String, Shell> hovers;

	/** The hover texts. */
	Map<String, String> texts;

	/** The mouse position. */
	private int mouseXPosition;

	/** The chart */
	private ChartNetXResource chart;

	/** The moyse y position */
	private int mouseYPosition;

	/**
	 * The constructor.
	 * 
	 * @param chart
	 *            The chart
	 */
	public ChartMarker(ChartNetXResource chart) {
		this.chart = chart;
		hovers = new HashMap<String, Shell>();
		texts = new HashMap<String, String>();
	}

	/**
	 * Check if marker is disposed.
	 * 
	 * @return <tt>true</tt> if marker is disposed.
	 */
	protected boolean isDisposed() {
		return hovers.isEmpty();
	}

	/**
	 * Disposes the resource.
	 */
	protected void dispose() {
		disposeHovers();
	}

	/**
	 * Redraws the marker.
	 */
	protected void redraw() {
		if (!isDisposed()) {
			setPosition(mouseXPosition, mouseYPosition);
		}
	}

	/**
	 * Sets the position.
	 * 
	 * @param x
	 *            The x pixel coordinate
	 */
	protected void setPosition(int x, int y) {
		
		System.out.println(" marker: " + this.hashCode() + " with resource:" + chart.hashCode());
		
		mouseXPosition = x;
		mouseYPosition = y;

		long desiredTime = getDesiredTime(x);
		Integer[] invertedSeriesIndex = getInvertedSeriesIndex(desiredTime);
		createHovers();
		if (invertedSeriesIndex != null) {
			configureHovers(desiredTime, invertedSeriesIndex, mouseYPosition);
		}
	}

	protected void setTime(long time) {
		System.out
				.println("We don't know which metric series for this time...");
		// Integer invertedSeriesIndex = getInvertedSeriesIndex(time);
		//
		// createHovers();
		// if (invertedSeriesIndex != null) {
		// configureHovers(invertedSeriesIndex);
		// }
	}

	/**
	 * Creates the hovers.
	 */
	private void createHovers() {

		// create hover keys
		List<String> keys = new ArrayList<String>();
		keys.add(TIME_KEY);
		for (ISeries series : chart.getSeriesSet().getSeries()) {
			keys.add(series.getId());
		}

		// create or reuse hovers
		Map<String, Shell> newHovers = new HashMap<String, Shell>();
		for (final String key : keys) {
			Shell hover = hovers.get(key);
			if (hover == null) {
				hover = createHover(key);
			}
			newHovers.put(key, hover);
		}

		// dispose unused hovers
		for (Entry<String, Shell> entrySet : hovers.entrySet()) {
			if (!keys.contains(entrySet.getKey())) {
				Shell hover = entrySet.getValue();
				Region region = hover.getRegion();
				if (region != null) {
					region.dispose();
				}
				hover.dispose();
			}
		}

		hovers = newHovers;
	}

	/**
	 * Creates the hover.
	 * 
	 * @param key
	 *            The hover key
	 * @return The hover
	 */
	private Shell createHover(final String key) {
		Shell hover = new Shell(Display.getDefault().getActiveShell(),
				SWT.NO_TRIM | SWT.ON_TOP | SWT.NO_FOCUS | SWT.TOOL);

		hover.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				String text = texts.get(key);
				if (text != null) {
					e.gc.drawText(texts.get(key), OFFSET + MARGIN, OFFSET);
				}
			}
		});
		final Color preferenceColor = ScreensActivator.getInstance()
				.getPreferenceColor(ScreenConstants.PREFERENCE_MARKER_COLOR);
		hover.setBackground(preferenceColor);
		hover.setAlpha(220);

		return hover;
	}

	/**
	 * Creates the hovers assuming that the time is almost the same among series
	 * When zoomed the range will be either expanded or reduced. the coordinates
	 * returned for a timestamp and value, could be outside the plot area. When
	 * configuring the hover is tried to be placed with the plot area, if not
	 * it's not set as visible.
	 * 
	 * 
	 * @param invertedSeriesIndex
	 *            The inverted series index
	 */
	private void configureHovers(long time, Integer[] invertedSeriesIndex,
			int yPosition) {
		
		// ISeries[] seriesArray = chart.getSeriesSet().getSeries();

		// create hover for time
		// Date[] dates = seriesArray[0].getXDateSeries();
		// long time = dates[dates.length - invertedSeriesIndex].getTime();

		StringBuffer buffer = new StringBuffer();
		buffer.append(new SimpleDateFormat("MMM-dd HH:mm:ss") //$NON-NLS-1$
				.format(time));
		texts.put(TIME_KEY, buffer.toString());

		int timeInPixel = chart.getAxisSet().getXAxes()[0]
				.getPixelCoordinate(time);
		configureHover(hovers.get(TIME_KEY), buffer.toString(), timeInPixel,
				chart.getPlotArea().getSize().y, true);

		{
			
			List<ILineSeries> metricSeries = chart.getMetricSeries();
			for (int i = 0; i < metricSeries.size(); i++) {
				ILineSeries iLineSeries = metricSeries.get(i);
				int index = invertedSeriesIndex[i];
				// The metric series
				double[] ySeries = iLineSeries.getYSeries();
				int seriesIndex = ySeries.length - index;
				System.out.println("y-index for marker: " + seriesIndex);

				if (seriesIndex >= 0) {
					buffer = new StringBuffer();
					buffer.append(iLineSeries.getId()).append(": ") //$NON-NLS-1$
							.append(getFormattedValue(ySeries[seriesIndex]));
					texts.put(iLineSeries.getId(), buffer.toString());

					int valueInPixel = chart.getAxisSet().getYAxes()[0]
							.getPixelCoordinate(ySeries[seriesIndex]);

					// Show if the series y position is within 10 pixels of the
					// mouse pointer y position.
					int yPositionDelta = Math.abs(valueInPixel - yPosition);

					System.out
							.println("y-position for marker: " + valueInPixel);
					System.out.println("y-position delta (mouse-y): "
							+ yPositionDelta);

					if (yPositionDelta < 10) {

						configureHover(hovers.get(iLineSeries.getId()),
								buffer.toString(), timeInPixel, valueInPixel,
								false);
					}
				}
			}
		}

		// { // Only if these exist.
		// ILineSeries capSeries = chart.getCapSeries();
		// if (capSeries != null) {
		// double[] ySeries = capSeries.getYSeries();
		// int seriesIndex = ySeries.length - invertedSeriesIndex;
		// if (seriesIndex > 0) {
		// buffer = new StringBuffer();
		//					buffer.append(capSeries.getId()).append(": ") //$NON-NLS-1$
		// .append(getFormattedValue(ySeries[seriesIndex]));
		// texts.put(capSeries.getId(), buffer.toString());
		//
		// int valueInPixel = chart.getAxisSet().getYAxes()[0]
		// .getPixelCoordinate(ySeries[seriesIndex]);
		// configureHover(hovers.get(capSeries.getId()),
		// buffer.toString(), timeInPixel, valueInPixel, false);
		// }
		// }
		// }

	}

	/**
	 * Configures the hover.
	 * 
	 * @param hover
	 *            The hover
	 * @param text
	 *            The hover text
	 * @param x
	 *            The x coordinate in pixels
	 * @param y
	 *            The y coordinate in pixels
	 * @param showBelow
	 *            <tt>true</tt> to show hover below data point
	 */
	private void configureHover(Shell hover, String text, int x, int y,
			boolean showBelow) {

		Point textExtent = getExtent(hover, text);
		Point hoverSize = new Point(textExtent.x + MARGIN * 2 + OFFSET * 2,
				textExtent.y + OFFSET * 2);
		hover.setSize(hoverSize);

		// System.out.println(" COORDINATES FOR: " + text);
		// System.out.println("   Value coordinate: (" + x + "," + y + ")");
		Rectangle plotBounds = chart.getPlotArea().getBounds();
		// System.out.println("  Plot area bounds: " + plotBounds);

		Point point = new Point(x + hoverSize.x, y);

		// System.out.println("  FLIP HOVER?");
		// System.out.println("   Hover Size: (" + hoverSize.x + "," +
		// hoverSize.y
		// + ")");
		// System.out.println("   Target coordinate: (" + (x + hoverSize.x) +
		// ","
		// + y + ")");
		boolean showOnRight = point.x < plotBounds.width;

		// System.out.println("   Hover Extremes coordinate: (" + point.x + ","
		// + point.y + ") width delta: " + (point.x - plotX) + " flip="
		// + !showOnRight);

		int hoverX = showOnRight ? x : x - hoverSize.x;
		int hoverY = showBelow ? y : y - hoverSize.y;

		Point displayCoordinate = chart.getPlotArea().toDisplay(hoverX, hoverY);

		// System.out.println("  Chart coordinate: time: " + hoverX +
		// ", value: "
		// + hoverY);
		// System.out.println("  Display coordinate: time: " +
		// displayCoordinate.x
		// + ", value: " + displayCoordinate.y);

		Point p = Display.getDefault().map(chart.getPlotArea(), null,
				new Point(x, y));
		// System.out.println("  Display value: time: " + p.x
		// + ", value: " + p.y);
		Rectangle map = Display.getDefault()
				.map(chart, null, chart.getBounds());
		// System.out.println("  Chart area bounds: " + map);

		if (!map.contains(p)) {
			return;
		}

		hover.setLocation(displayCoordinate);

		// set region
		Region region = hover.getRegion();
		if (region != null) {
			region.dispose();
		}
		region = getHoverRegion(textExtent, showOnRight, showBelow);
		hover.setRegion(region);

		hover.redraw();
		hover.setVisible(true);
	}

	/**
	 * Gets the hover region. The direction of hover arrow can be changed so
	 * that hover is completely shown within screen.
	 * 
	 * @param textExtent
	 *            The text extent
	 * @param showOnRight
	 *            <tt>true</tt> to show hover on the right hand side of data
	 *            point
	 * @param showBelow
	 *            <tt>true</tt> to show hover below data point
	 * @return The hover region
	 */
	private static Region getHoverRegion(Point textExtent, boolean showOnRight,
			boolean showBelow) {
		Region region = new Region();
		int[] pointArray;
		if (showOnRight && showBelow) {
			pointArray = new int[] { 0, 0, OFFSET + 5, OFFSET,
					textExtent.x + MARGIN * 2 + OFFSET, OFFSET,
					textExtent.x + MARGIN * 2 + OFFSET, textExtent.y + OFFSET,
					OFFSET, textExtent.y + OFFSET, OFFSET, OFFSET + 5, 0, 0 };
		} else if (!showOnRight && showBelow) {
			pointArray = new int[] { OFFSET, OFFSET,
					textExtent.x + MARGIN * 2 + OFFSET - 5, OFFSET,
					textExtent.x + MARGIN * 2 + OFFSET * 2, 0,
					textExtent.x + MARGIN * 2 + OFFSET, OFFSET + 5,
					textExtent.x + MARGIN * 2 + OFFSET, textExtent.y + OFFSET,
					OFFSET, textExtent.y + OFFSET, OFFSET, OFFSET };
		} else if (showOnRight && !showBelow) {
			pointArray = new int[] { OFFSET, OFFSET,
					textExtent.x + MARGIN * 2 + OFFSET, OFFSET,
					textExtent.x + MARGIN * 2 + OFFSET, textExtent.y + OFFSET,
					OFFSET + 5, textExtent.y + OFFSET, 0,
					textExtent.y + OFFSET * 2, OFFSET,
					textExtent.y + OFFSET - 5, OFFSET, OFFSET };
		} else /* if (!showOnRight && !showBelow) */{
			pointArray = new int[] { OFFSET, OFFSET,
					textExtent.x + MARGIN * 2 + OFFSET, OFFSET,
					textExtent.x + MARGIN * 2 + OFFSET,
					textExtent.y + OFFSET - 5,
					textExtent.x + MARGIN * 2 + OFFSET * 2,
					textExtent.y + OFFSET * 2,
					textExtent.x + MARGIN * 2 + OFFSET - 5,
					textExtent.y + OFFSET, OFFSET, textExtent.y + OFFSET,
					OFFSET, OFFSET };
		}
		region.add(pointArray);
		return region;
	}

	/**
	 * Gets the text extent.
	 * 
	 * @param hover
	 *            The hover
	 * @param text
	 *            The text
	 * @return The text extent
	 */
	private static Point getExtent(Shell hover, String text) {
		GC gc = new GC(hover);
		Point textExtent = gc.textExtent(text);
		gc.dispose();
		return textExtent;
	}

	private long getDesiredTime(int desiredX) {

		// This is the X-Axis
		IAxis firstAxe = chart.getAxisSet().getAxes()[0];

		// The time.
		return (long) firstAxe.getDataCoordinate(desiredX);
	}

	/**
	 * Gets the inverted series index that is the nearest to mouse position.
	 * 
	 * @param desiredX
	 *            The desired x pixel coordinate
	 * @param metricSeries2
	 * @return The inverted series index, or <tt>null</tt> if not found
	 */
	private Integer[] getInvertedSeriesIndex(long desiredTime) {

		// find the time series index, biggest date comes first.

		List<ILineSeries> metricSeries = chart.getMetricSeries();
		Integer[] indices = new Integer[metricSeries.size()];
		for (int y = 0; y < metricSeries.size(); y++) {
			ILineSeries ls = metricSeries.get(y);
			Date[] dates = ls.getXDateSeries();
			for (int i = 0; i < dates.length; i++) {
				if (dates[i].getTime() < desiredTime && i != dates.length - 1) {
					continue;
				}
				int nearestIndex;
				if (i > 0
						&& dates[i].getTime() - desiredTime > desiredTime
								- dates[i - 1].getTime()) {
					nearestIndex = i - 1;
				} else {
					nearestIndex = i;
				}
				// System.out.println(" Date index = " + nearestIndex);
				indices[y] = dates.length - nearestIndex;
				break;
			}
		}
		return indices;
	}

	/**
	 * Shows the tool tip.
	 * 
	 * @param value
	 *            The value
	 * @return The formatted value
	 */
	private String getFormattedValue(Object value) {

		// TODO Derive the UNIT from the Resource.
		return new DecimalFormat("#,###,###.##").format(value);
	}

	/**
	 * Disposes the hovers.
	 */
	private void disposeHovers() {
		for (Shell hover : hovers.values()) {
			Region region = hover.getRegion();
			if (region != null) {
				region.dispose();
			}
			hover.dispose();
		}
		hovers.clear();
		texts.clear();
	}
}
