/*******************************************************************************
 * Copyright (c) 21 nov. 2013 NetXForge.
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

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.netxforge.netxstudio.screens.internal.ScreensActivator;

/**
 * Class used to initialize default preference values.
 */
public class ChartPreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
	 * initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = this.getPreferenceStore();
		store.setDefault(ScreenConstants.PREFERENCE_LEGEND_VISIBLE, true);
		store.setDefault(ScreenConstants.PREFERENCE_UTIL_VISIBLE, false);

		initializeMetricColors(store);

		store.setDefault(ScreenConstants.PREFERENCE_CAP_COLOR, "128,128,0");
		store.setDefault(ScreenConstants.PREFERENCE_UTIL_COLOR, "0,255,0");
		store.setDefault(ScreenConstants.PREFERENCE_MARKER_COLOR, "188,215,248");
	}

	private IPreferenceStore getPreferenceStore() {
		return ScreensActivator.getInstance().getPreferenceStore();
	}

	public void initializeMetricColors(IPreferenceStore store) {
		for (int i = 0; i <= 9; i++) {
			store.setDefault(ScreenConstants.PREFERENCE_METRIC_COLORS[i],
					ScreenConstants.PREFERENCE_METRIC_COLORS_VALUES[i]);
		}

	}

}
