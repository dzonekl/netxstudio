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

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.util.ObjectNotFoundException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.spi.cdo.FSMUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IMemento;

import com.netxforge.base.cdo.CDO;
import com.netxforge.screens.editing.base.util.MementoUtil;

/**
 * Various memento shortcut boilerplate busters! The utility is specific for
 * {@link CDOObject} as the {@link CDOID ID} of the object is stored in the
 * {@link IMemento}
 * 
 * @author Christophe Bouhier
 * 
 */
public class CDOMementoUtil {

	/**
	 * Remember a {@link StructuredViewer} {@link ISelection}
	 * 
	 * @param memento
	 * @param viewer
	 * @param key
	 */
	public static void rememberStructuredViewerSelection(IMemento memento,
			StructuredViewer viewer, String key) {
		ISelection selection = viewer.getSelection();

		rememberSelection(memento, (IStructuredSelection) selection, key);
	}

	/**
	 * Retrieve a Combo viewer.
	 * 
	 * @param memento
	 * @param viewer
	 * @param key
	 */
	public static void retrieveStructuredViewerSelection(IMemento memento,
			StructuredViewer viewer, String key, CDOView view) {
		IStructuredSelection retrieveSelection = retrieveSelection(memento,
				key, view);
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

		int[] columnWidths = MementoUtil.retrieveIntArray(memento, key);
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
	 * Remember a selection
	 * 
	 * @param memento
	 * @param selection
	 * @param key
	 */
	public static void rememberSelection(IMemento memento,
			IStructuredSelection selection, String key) {

		Object firstElement = selection.getFirstElement();
		if (firstElement instanceof CDOObject) {
			rememberCDOObject(memento, (CDOObject) firstElement, key);
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
	public static IStructuredSelection retrieveSelection(IMemento memento,
			String key, CDOView view) {
		CDOObject retrieveCDOObject = retrieveCDOObject(memento, view, key);
		if (retrieveCDOObject == null) {
			return null;
		}
		IStructuredSelection ss = new StructuredSelection(retrieveCDOObject);
		return ss;

	}

	public static CDOObject retrieveCDOObject(IMemento memento, CDOView view,
			String key) {
		String string = memento.getString(key);
		if (string != null) {
			CDOID cdoid = CDO.cdoLongIDFromString(string);
			try {
				return view.getObject(cdoid);
			} catch (ObjectNotFoundException onfe) {
				// As we remember objects, we can sm
			}
		}
		return null;
	}

	public static void rememberCDOObject(IMemento memento, CDOObject object,
			String key) {

		if (FSMUtil.isNew(object) || FSMUtil.isTransient(object)) {
			return; // Can't remember this state.
		}

		String cdoLongIDAsString = CDO.cdoLongIDAsString(object);
		memento.putString(key, cdoLongIDAsString);
	}

}
