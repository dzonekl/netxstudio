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

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.netxforge.netxstudio.screens.internal.ScreensActivator;

/**
 * Chars preferences. TODO, define preference fields.
 * 
 * @see ScreenConstants
 * 
 */
public class ChartGeneralPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	public ChartGeneralPreferencePage() {
		super(GRID);
		setPreferenceStore(ScreensActivator.getInstance().getPreferenceStore());
		setDescription("Chart Settings");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {

		addField(new ColorFieldEditor("&Chart Background",
				ScreenConstants.PREFERENCE_CHART_BACKGROUND,
				getFieldEditorParent()));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

	public void apply() {
		// Color color = new Color(Display.getDefault(),
		// backgroundInPlotAreaButton.getColorValue());
		// chart.setBackgroundInPlotArea(color);
		//
		//
		// color = new Color(Display.getDefault(), backgroundButton
		// .getColorValue());
		// chart.setBackground(color);
		//
		// chart.setOrientation(orientationButton.getSelection() ? SWT.VERTICAL
		// : SWT.HORIZONTAL);
		//
		// ITitle title = chart.getTitle();
		// title.setVisible(showTitleButton.getSelection());
		// title.setText(titleText.getText());
		//
		// FontData fontData = title.getFont().getFontData()[0];
		// fontData.setHeight(fontSizeSpinner.getSelection());
		// Font font = new Font(Display.getDefault(), fontData);
		// title.setFont(font);
		//
		// color = new Color(Display.getDefault(), titleColorButton
		// .getColorValue());
		// title.setForeground(color);
	}

}