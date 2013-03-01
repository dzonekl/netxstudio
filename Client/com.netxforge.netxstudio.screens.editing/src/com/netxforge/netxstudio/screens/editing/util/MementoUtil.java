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
package com.netxforge.netxstudio.screens.editing.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.spi.common.id.AbstractCDOIDLong;
import org.eclipse.emf.cdo.util.ObjectNotFoundException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.spi.cdo.FSMUtil;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
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

/**
 * Various memento shortcut boilerplate busters!
 * 
 * @author Christophe Bouhier
 * 
 */
public class MementoUtil {

	// Date formatter for memento.
	final SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS-Z");
	
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
	public void rememberIntArray(IMemento memento, int[] ints, String key) {
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
	public int[] retrieveIntArray(IMemento memento, String key) {

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
	public void rememberCDateTime(IMemento memento, CDateTime cdatetime,
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
	public void retrieveCDateTime(IMemento memento, CDateTime cdatetime,
			String key) {
		Date date = this.retrieveDate(memento, key);
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
	public void rememberStructuredViewerSelection(IMemento memento,
			StructuredViewer viewer, String key) {
		ISelection selection = viewer.getSelection();

		this.rememberSelection(memento, selection, key);
	}

	/**
	 * Remember a Combo viewer.
	 * 
	 * @param memento
	 * @param viewer
	 * @param key
	 */
	public void rememberStructuredViewerColumns(IMemento memento,
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
			this.rememberIntArray(memento, intArray, key);
		} else if (viewer instanceof TreeViewer) {
			TreeColumn[] columns = ((TreeViewer) viewer).getTree().getColumns();
			int[] intArray = new int[columns.length];
			for (int i = 0; i < columns.length; i++) {
				TreeColumn tc = columns[i];
				int width = tc.getWidth();
				intArray[i] = width;
			}
			this.rememberIntArray(memento, intArray, key);

		}
	}

	/**
	 * Retrieve a Combo viewer.
	 * 
	 * @param memento
	 * @param viewer
	 * @param key
	 */
	public void retrieveStructuredViewerSelection(IMemento memento,
			StructuredViewer viewer, String key, CDOView view) {
		IStructuredSelection retrieveSelection = this.retrieveSelection(
				memento, key, view);
		if (retrieveSelection != null) {
			viewer.setSelection(retrieveSelection, true);
		}
	}

	/**
	 * Retrieve a Combo viewer.
	 * 
	 * @param memento
	 * @param viewer
	 * @param key
	 */
	public void retrieveStructuredViewerColumns(IMemento memento,
			StructuredViewer viewer, String key) {

		int[] columnWidths = this.retrieveIntArray(memento, key);
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
	public void rememberSashForm(IMemento memento, SashForm sashForm, String key) {
		int[] weights = sashForm.getWeights();
		rememberIntArray(memento, weights, key);
	}

	/**
	 * Remember a sash form and it's children.
	 * 
	 * @param memento
	 * @param c
	 */
	public void rememberSashForm(IMemento memento, SashForm c) {
		// TODO Auto-generated method stub

	}

	/**
	 * Retrieve a SashForm
	 * 
	 * @param memento
	 * @param sashForm
	 * @param key
	 */
	public void retrieveSashForm(IMemento memento, SashForm sashForm, String key) {
		int[] weights = retrieveIntArray(memento, key);
		if (weights.length > 0) {
			sashForm.setWeights(weights);
		}
	}

	/**
	 * Remember a Date object.
	 * 
	 * @param memento
	 * @param date
	 * @param key
	 */
	public void rememberDate(IMemento memento, Date date, String key) {

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
	public void rememberDate(IDialogSettings memento, Date date, String key) {

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
	public Date retrieveDate(IMemento memento, String key) {
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

	/**
	 * Retrieve a Date object.
	 * 
	 * @param memento
	 * @param key
	 * @return
	 */
	public Date retrieveDate(IDialogSettings memento, String key) {
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
	 * Remember a Selection
	 * 
	 * @param memento
	 * @param selection
	 * @param key
	 */
	public void rememberSelection(IMemento memento, ISelection selection,
			String key) {
		if (selection instanceof IStructuredSelection) {
			rememberSelection(memento, (IStructuredSelection) selection, key);
		}
	}

	/**
	 * Remember a selection
	 * 
	 * @param memento
	 * @param selection
	 * @param key
	 */
	public void rememberSelection(IMemento memento,
			IStructuredSelection selection, String key) {

		Object firstElement = selection.getFirstElement();
		if (firstElement instanceof CDOObject) {
			this.rememberCDOObject(memento, (CDOObject) firstElement, key);
		}
	}

	/**
	 * Retrieve a selection which is expected to be a CDOObject.
	 * 
	 * @param memento
	 * @param key
	 * @param eClass
	 * @param view
	 * @return
	 */
	public IStructuredSelection retrieveSelection(IMemento memento, String key,
			CDOView view) {
		CDOObject retrieveCDOObject = this
				.retrieveCDOObject(memento, view, key);
		if (retrieveCDOObject == null) {
			return null;
		}
		IStructuredSelection ss = new StructuredSelection(retrieveCDOObject);
		return ss;

	}

	public CDOObject retrieveCDOObject(IMemento memento, CDOView view,
			String key) {
		String string = memento.getString(key);
		if (string != null) {
			CDOID cdoid = this.getCDOID(string);
			try {
				return view.getObject(cdoid);
			} catch (ObjectNotFoundException onfe) {
				// As we remember objects, we can sm
			}
		}
		return null;
	}

	public void rememberCDOObject(IMemento memento, CDOObject object, String key) {
		
		
		if( FSMUtil.isNew(object) || FSMUtil.isTransient(object)){
			return; // Can't remember this state. 
		}
		CDOID cdoID = object.cdoID();
		Long longValue = ((AbstractCDOIDLong) cdoID).getLongValue();
		memento.putString(key, longValue.toString());
	}

	private CDOID getCDOID(String idString) {
		return CDOIDUtil.createLong(Long.parseLong(idString));
	}

	/**
	 * Remember the Section contols in a composite.
	 * 
	 * @param memento
	 * @param cmpDetails
	 * @param key
	 */
	public void rememberSectionsInComposite(IMemento memento,
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
	public void retrieveSectionsInComposite(IMemento memento,
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

	public void rememberString(IMemento memento, String string,
			String key) {
		memento.putString(key, string);
	}

	public String retrieveString(IMemento memento,
			String key) {
		return memento.getString(key);
	}
	
}
