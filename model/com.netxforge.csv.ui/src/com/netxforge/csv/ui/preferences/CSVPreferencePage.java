package com.netxforge.csv.ui.preferences;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.netxforge.csv.Activator;
import com.netxforge.csv.preference.PreferenceConstants;

/**
 */

public class CSVPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public CSVPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Set the CSV delimiter used when exporting templates");
	}

	/**
	 * Adds a combofield editor to set the .CSV output preference.
	 * 
	 */
	public void createFieldEditors() {

		String[][] prefs = {
				{ "Standard", PreferenceConstants.STANDARD_PREFERENCE },
				{ "Excel Northern Europe",
						PreferenceConstants.EXCEL_NORTH_EUROPE_PREFERENCE },
				{ "Excel", PreferenceConstants.EXCEL_PREFERENCE },
				{ "No Comment", PreferenceConstants.NO_COMMENT_PREFERENCE } };
		addField(new ComboFieldEditor(PreferenceConstants.P_DELIMETER,
				"Set the delimiter", prefs, getFieldEditorParent()));
	}

	public void init(IWorkbench workbench) {
	}

}