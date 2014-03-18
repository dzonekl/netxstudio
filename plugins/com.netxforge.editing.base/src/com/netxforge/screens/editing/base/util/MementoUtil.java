/*******************************************************************************
 * Copyright (c) Apr 6, 2012 NetXForge.
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
package com.netxforge.screens.editing.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.base.NonModelUtils;

/**
 * Various memento shortcut boilerplate busters!
 * 
 * @author Christophe Bouhier
 * 
 */
public class MementoUtil {

	// Date formatter for memento.
	static final SimpleDateFormat df = new SimpleDateFormat(
			"yyyyMMddHHmmssSSS-Z");

	public static final String MEM_KEY_SEARCH_PATTERN = "MEM_KEY_SEARCH_PATTERN";

	public static final String MEM_KEY_COLUMNS_TABLE = "MEM_KEY_COLUMNS_TABLE";

	public static final String MEM_KEY_SELECTION_TABLE = "MEM_KEY_SELECTION_TABLE";

	public static final String MEM_KEY_CURRENT_SCREEN = "MEM_KEY_CURRENT_SCREEN";

	public static final String MEM_KEY_SCREEN_PART = "MEM_KEY_SCREEN_PART";

	/**
	 * Remember an array of integers.
	 * 
	 * @param memento
	 * @param ints
	 */
	public static void rememberIntArray(IMemento memento, int[] ints, String key) {
		for (int i = 0; i < ints.length; i++) {
			memento.putInteger(key + i, ints[i]);
		}
	}

	/**
	 * Retrieve an array of Integers.
	 * 
	 * @param memento
	 * @param key
	 * @return
	 */
	public static int[] retrieveIntArray(IMemento memento, String key) {

		List<Integer> values = new ArrayList<Integer>();

		// we don't know the size so we continue while we get values.
		{
			int i = 0;
			while (true) {
				Integer integer = memento.getInteger(key + i++);
				if (integer != null) {
					values.add(integer);
				} else {
					break;
				}
			}
		}

		int[] array = new int[values.size()];

		{
			for (int i = 0; i < values.size(); i++) {
				array[i] = values.get(i);
			}
		}

		return array;
	}

	/**
	 * Remember a Combo viewer.
	 * 
	 * @param memento
	 * @param viewer
	 * @param key
	 */
	public static void rememberCDateTime(IMemento memento, CDateTime cdatetime,
			String key) {
		Date date = cdatetime.getSelection();
		rememberDate(memento, date, key);
	}

	/**
	 * Retrieve a Combo viewer.
	 * 
	 * @param memento
	 * @param viewer
	 * @param key
	 */
	public static void retrieveCDateTime(IMemento memento, CDateTime cdatetime,
			String key) {
		Date date = retrieveDate(memento, key);
		if (date != null) {
			cdatetime.setSelection(date);
		}
	}

	/**
	 * Remember a Combo viewer.
	 * 
	 * @param memento
	 * @param viewer
	 * @param key
	 */
	public static void rememberStructuredViewerColumns(IMemento memento,
			StructuredViewer viewer, String key) {

		if (viewer instanceof TableViewer) {
			TableColumn[] columns = ((TableViewer) viewer).getTable()
					.getColumns();
			int[] intArray = new int[columns.length];
			for (int i = 0; i < columns.length; i++) {
				TableColumn tc = columns[i];
				int width = tc.getWidth();
				intArray[i] = width;
			}
			rememberIntArray(memento, intArray, key);
		} else if (viewer instanceof TreeViewer) {
			TreeColumn[] columns = ((TreeViewer) viewer).getTree().getColumns();
			int[] intArray = new int[columns.length];
			for (int i = 0; i < columns.length; i++) {
				TreeColumn tc = columns[i];
				int width = tc.getWidth();
				intArray[i] = width;
			}
			rememberIntArray(memento, intArray, key);

		}
	}

	/**
	 * Retrieve a Combo viewer.
	 * 
	 * @param memento
	 * @param viewer
	 * @param key
	 */
	public static void retrieveStructuredViewerColumns(IMemento memento,
			StructuredViewer viewer, String key) {

		int[] columnWidths = retrieveIntArray(memento, key);
		if (columnWidths.length > 0) {
			if (viewer instanceof TableViewer) {

				// No check on the size of the array.
				TableColumn[] columns = ((TableViewer) viewer).getTable()
						.getColumns();
				for (int i = 0; i < columns.length; i++) {
					TableColumn tc = columns[i];
					tc.setWidth(columnWidths[i]);
				}
			} else if (viewer instanceof TreeViewer) {
				TreeColumn[] columns = ((TreeViewer) viewer).getTree()
						.getColumns();
				for (int i = 0; i < columns.length; i++) {
					TreeColumn tc = columns[i];
					tc.setWidth(columnWidths[i]);
				}
			}
		}

	}

	/**
	 * Remember a Sash Form
	 * 
	 * @param memento
	 * @param sashForm
	 * @param key
	 */
	public static void rememberSashForm(IMemento memento, SashForm sashForm,
			String key) {
		int[] weights = sashForm.getWeights();
		rememberIntArray(memento, weights, key);
	}

	/**
	 * Retrieve a SashForm
	 * 
	 * @param memento
	 * @param sashForm
	 * @param key
	 */
	public static void retrieveSashForm(IMemento memento, SashForm sashForm,
			String key) {
		int[] weights = retrieveIntArray(memento, key);
		if (weights.length > 0) {
			sashForm.setWeights(weights);
		}
	}

	public static void rememberDate(IMemento memento,
			XMLGregorianCalendar xmlDate, String key) {

		// Wrap as a String.
		Date date = NonModelUtils.fromXMLDate(xmlDate);
		memento.putString(key, df.format(date));
	}

	/**
	 * Remember a Date object.
	 * 
	 * @param memento
	 * @param date
	 * @param key
	 */
	public static void rememberDate(IMemento memento, Date date, String key) {
		// Wrap as a String.
		memento.putString(key, df.format(date));
	}

	/**
	 * Remember a Date object.
	 * 
	 * @param memento
	 * @param date
	 * @param key
	 */
	public static void rememberDate(IDialogSettings memento, Date date,
			String key) {

		// Wrap as a String.

		memento.put(key, df.format(date));
	}

	/**
	 * Retrieve a Date object.
	 * 
	 * @param memento
	 * @param key
	 * @return
	 */
	public static Date retrieveDate(IMemento memento, String key) {
		String string = memento.getString(key);
		if (string != null) {
			try {
				return df.parse(string);
			} catch (ParseException e) {
				// oops.
			}
		}
		return null;
	}

	public static XMLGregorianCalendar retrieveXMLDate(IMemento memento,
			String key) {
		String string = memento.getString(key);
		if (string != null) {
			try {
				Date parse = df.parse(string);
				return NonModelUtils.toXMLDate(parse);
			} catch (ParseException e) {
				// oops.
			}
		}
		return null;
	}

	/**
	 * Retrieve a Date object.
	 * 
	 * @param memento
	 * @param key
	 * @return
	 */
	public static Date retrieveDate(IDialogSettings memento, String key) {
		String string = memento.get(key);
		if (string != null) {
			try {
				return df.parse(string);
			} catch (ParseException e) {
				// oops.
			}
		}
		return null;
	}

	/**
	 * Remember the Section contols in a composite.
	 * 
	 * @param memento
	 * @param cmpDetails
	 * @param key
	 */
	public static void rememberSectionsInComposite(IMemento memento,
			Composite cmpDetails, String key) {

		Control[] controls = cmpDetails.getChildren();
		for (int i = 0; i < controls.length; i++) {
			Control c = controls[i];
			if (c instanceof Section) {
				// append the index of the key, to retrieve later.
				memento.putBoolean(key + i, ((Section) c).isExpanded());
			}
		}
	}

	/**
	 * Retrieve the expansion state.
	 * 
	 * @param memento
	 * @param cmpDetails
	 * @param key
	 */
	public static void retrieveSectionsInComposite(IMemento memento,
			Composite cmpDetails, String key) {

		Control[] controls = cmpDetails.getChildren();
		for (int i = 0; i < controls.length; i++) {
			Control c = controls[i];
			Boolean b = memento.getBoolean(key + i);
			if (c instanceof Section && b != null) {
				((Section) c).setExpanded(b);
			}
		}
	}

	public static void rememberString(IMemento memento, String string,
			String key) {
		memento.putString(key, string);
	}

	public static String retrieveString(IMemento memento, String key) {
		return memento.getString(key);
	}

}
