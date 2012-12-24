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

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.netxforge.netxstudio.screens.internal.ScreensActivator;

/**
 * Chars preferences.
 * 
 * @see ScreenConstants
 * 
 */
public class ChartsPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	private ColorFieldEditor metricColorEditor;
	private ColorFieldEditor capacityColorEditor;
	private ColorFieldEditor markerColorEditor;
	private FieldEditor utilColorEditor;
	
	

	public ChartsPreferencePage() {
		super(GRID);
		setPreferenceStore(ScreensActivator.getDefault().getPreferenceStore());
		setDescription("Chart Settings");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {

		/* Legend on/off */
		addField(new BooleanFieldEditor(
				ScreenConstants.PREFERENCE_LEGEND_VISIBLE, "&Show Legend",
				getFieldEditorParent()));

		/* Legend on/off */
		addField(new BooleanFieldEditor(
				ScreenConstants.PREFERENCE_UTIL_VISIBLE, "&Show Utilization",
				getFieldEditorParent()));

		/* Metric values color editor */
		metricColorEditor = createColorFieldEditor(
				ScreenConstants.PREFERENCE_METRIC_COLOR, "Metric Values Color",
				getFieldEditorParent());
		addField(metricColorEditor);

		/* Capacity values color editor */
		capacityColorEditor = createColorFieldEditor(
				ScreenConstants.PREFERENCE_CAP_COLOR,
				"Capacity Values Color", getFieldEditorParent());
		addField(capacityColorEditor);

		/* Utilization values color editor */
		utilColorEditor = createColorFieldEditor(
				ScreenConstants.PREFERENCE_UTIL_COLOR,
				"Utilization Values Color", getFieldEditorParent());
		addField(utilColorEditor);
		
		/* Marker color editor */
		markerColorEditor = createColorFieldEditor(
				ScreenConstants.PREFERENCE_MARKER_COLOR,
				"Marker Tooltip Color", getFieldEditorParent());
		addField(markerColorEditor);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

	/**
	 * Creates a new color field editor.
	 */
	private ColorFieldEditor createColorFieldEditor(String preferenceName,
			String label, Composite parent) {
		ColorFieldEditor editor = new ColorFieldEditor(preferenceName, label,
				parent);
		editor.setPage(this);
		editor.setPreferenceStore(getPreferenceStore());
		return editor;
	}

}