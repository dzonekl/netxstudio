/*******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Peter Centgraf - initial API and implementation - bug #177013
 *     Jeremy Dowdall - updating
 *     Christophe Bouhier - fixed, selection listener 
 *******************************************************************************/
package com.netxforge.netxstudio.screens;

import java.util.Date;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

/**
 * An implementation of the DataBindings IObservableValue interface for the Nebula
 * CDateTime control.
 * 
 * @author pcentgraf
 * @since Mar 8, 2007
 */
public class CDateTimeObservableValue extends AbstractObservableValue {
	
	/**
	 * The Control being observed here.
	 */
	protected final CDateTime dateTime;
	
	/**
	 * Flag to prevent infinite recursion in {@link #doSetValue(Object)}.
	 */
	protected boolean updating = false;
		
	/**
	 * The "old" selection before a selection event is fired.
	 */
	protected Date currentSelection;

	private SelectionListener listener = new SelectionListener() {
		public void widgetDefaultSelected(SelectionEvent e) {
			
		}
		public void widgetSelected(SelectionEvent e) {
			if (!updating) {
				Date newSelection = CDateTimeObservableValue.this.dateTime.getSelection();
				fireValueChange(Diffs.createValueDiff(currentSelection, newSelection));
				currentSelection = newSelection;
			}		}
	};
	
	/**
	 * Observe the selection property of the provided CDateTime control.
	 * @param dateTime the control to observe
	 */
	public CDateTimeObservableValue(CDateTime dateTime) {
		this.dateTime = dateTime;
		currentSelection = dateTime.getSelection();
		this.dateTime.addSelectionListener(listener);
	}

	@Override
	public synchronized void dispose() {
		dateTime.removeSelectionListener(listener);
		super.dispose();
	}

	protected Object doGetValue() {
		// CB 07122011 removed dispose check.
		if(!dateTime.isDisposed()) {
			return dateTime.getSelection();
		}
		return null;
	}
	
	protected void doSetValue(Object value) {
		
		// CB 07122011 removed dispose check. 
		if(value instanceof Date && !dateTime.isDisposed()) {
//		if(value instanceof Date ) {
			Date oldValue;
			Date newValue;
			try {
				updating = true;
				oldValue = dateTime.getSelection();
				newValue = (Date) value;
				dateTime.setSelection(newValue);
				currentSelection = newValue;
				fireValueChange(Diffs.createValueDiff(oldValue, newValue));
			} finally {
				updating = false;
			}
		}
	}

	public Object getValueType() {
		return Date.class;
	}
	
	public CDateTime getDateTime() {
		return dateTime;
	}
	
}
