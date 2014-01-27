/*******************************************************************************
 * Copyright (c) 21 dec. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.preferences;

/**
 * Constant definitions for Screens preferences
 */
public class ScreenConstants {

	/** Show or hide the Chart legend */
	public static final String PREFERENCE_LEGEND_VISIBLE = "legendVisiblePreference";

	/** The color of the Metric series */

	public static final String PREFERENCE_METRIC_COLOR_1 = "metricColorPreference_1";
	public static final String PREFERENCE_METRIC_COLOR_2 = "metricColorPreference_2";
	public static final String PREFERENCE_METRIC_COLOR_3 = "metricColorPreference_3";
	public static final String PREFERENCE_METRIC_COLOR_4 = "metricColorPreference_4";
	public static final String PREFERENCE_METRIC_COLOR_5 = "metricColorPreference_5";
	public static final String PREFERENCE_METRIC_COLOR_6 = "metricColorPreference_6";
	public static final String PREFERENCE_METRIC_COLOR_7 = "metricColorPreference_7";
	public static final String PREFERENCE_METRIC_COLOR_8 = "metricColorPreference_8";
	public static final String PREFERENCE_METRIC_COLOR_9 = "metricColorPreference_9";
	public static final String PREFERENCE_METRIC_COLOR_10 = "metricColorPreference_10";

	public static final String[] PREFERENCE_METRIC_COLORS = new String[] {
			PREFERENCE_METRIC_COLOR_1, PREFERENCE_METRIC_COLOR_2,
			PREFERENCE_METRIC_COLOR_3, PREFERENCE_METRIC_COLOR_4,
			PREFERENCE_METRIC_COLOR_5, PREFERENCE_METRIC_COLOR_6,
			PREFERENCE_METRIC_COLOR_7, PREFERENCE_METRIC_COLOR_8,
			PREFERENCE_METRIC_COLOR_9, PREFERENCE_METRIC_COLOR_10 };

	public static final String[] PREFERENCE_METRIC_COLORS_VALUES = new String[] {
			"204,255,102", "102,255,204", "204,102,255", "255,204,102",
			"255,102,102", "255,255,102", "102, 102, 255", "255,102,255",
			"128,128,0", "128,0,0" };

	/** The metric value Symbol type */
	public static final String PREFERENCE_METRIC_SYMBOL = "metricSymbolPreference";

	/** The color of the Capacity series */
	public static final String PREFERENCE_CAP_COLOR = "capacityColorPreference";

	/** The color of the Utilization series */
	public static final String PREFERENCE_UTIL_COLOR = "utilizationColorPreference";

	/** Show or hide the Utilization series */
	public static final String PREFERENCE_UTIL_VISIBLE = "utilizationVisiblePreference";

	/** Show or hide the Utilization series */
	public static final String PREFERENCE_MARKER_COLOR = "markerColorPreference";

	/** Turn on dynamic monitoring */
	public static final String PREFERENCE_DYN_MONITORING = "dynamicMonitoringPreference";

	/** The color of the background of the chart */
	public static final String PREFERENCE_CHART_BACKGROUND = "chartBackgroundPreference";

}
