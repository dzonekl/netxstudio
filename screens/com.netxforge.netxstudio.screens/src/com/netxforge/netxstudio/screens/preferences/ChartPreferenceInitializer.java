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
		store.setDefault(ScreenConstants.PREFERENCE_METRIC_COLOR,
				"90,90,90");
		store.setDefault(ScreenConstants.PREFERENCE_CAP_COLOR, "128,128,0");
		store.setDefault(ScreenConstants.PREFERENCE_UTIL_COLOR, "0,255,0");
		store.setDefault(ScreenConstants.PREFERENCE_MARKER_COLOR, "188,215,248");
	}

	private IPreferenceStore getPreferenceStore() {
		return ScreensActivator.getDefault().getPreferenceStore();
	}

}
