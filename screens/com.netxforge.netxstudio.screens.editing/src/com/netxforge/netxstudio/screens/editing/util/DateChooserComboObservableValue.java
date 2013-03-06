/*******************************************************************************
 * Copyright (c) Oct 9, 2012 NetXForge.
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

import java.util.Date;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.nebula.widgets.datechooser.DateChooserCombo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;


/**
 * 
 * @author Christophe Bouhier
 *
 */
public class DateChooserComboObservableValue extends AbstractObservableValue {
	/**
	 * {@link DateChooserCombo} widget that this is being observed.
	 */
	protected final DateChooserCombo combo;
	
	/**
	 * SWT event that on firing this observable will fire change events to its
	 * listeners.
	 */
	private final int updateEventType;

	/**
	 * Flag to track when the model is updating the widget. When
	 * <code>true</code> the handlers for the SWT events should not process
	 * the event as this would cause an infinite loop.
	 */
	private boolean updating = false;

	/**
	 * Previous value of the Date.
	 */
	private Date oldValue;

	private Listener updateListener = new Listener() {
		public void handleEvent(Event event) {
			if ( ! updating ) {
				Date newValue = combo.getValue();

				if ( (newValue == null && oldValue != null)
						 || (newValue != null && ! newValue.equals(oldValue)) ) {
					fireValueChange(Diffs.createValueDiff(oldValue, newValue));					
					oldValue = newValue;
				}
			}
		}
	};

	/**
	 * Valid types for the {@link #updateEventType}.
	 */
	private static final int[] validUpdateEventTypes = new int[] { SWT.Modify,
			SWT.FocusOut, SWT.None };

	private DisposeListener disposeListener = new DisposeListener() {
		public void widgetDisposed(DisposeEvent e) {
			DateChooserComboObservableValue.this.dispose();
		}
	};

	public DateChooserComboObservableValue(final DateChooserCombo combo, int updateEventType) {
		this(SWTObservables.getRealm(combo.getDisplay()), combo, updateEventType);
	}

	public DateChooserComboObservableValue(final Realm realm, final DateChooserCombo combo, int updateEventType) {
		super(realm);

		boolean eventValid = false;
		for (int i = 0; !eventValid && i < validUpdateEventTypes.length; i++) {
			eventValid = (updateEventType == validUpdateEventTypes[i]);
		}
		if ( ! eventValid ) {
			throw new IllegalArgumentException(
					"UpdateEventType [" + updateEventType + "] is not supported."); //$NON-NLS-1$//$NON-NLS-2$
		}

		this.combo = combo;
		this.updateEventType = updateEventType;
		if ( updateEventType != SWT.None ) {
			combo.addListener(updateEventType, updateListener);
		}

		combo.addDisposeListener(disposeListener);
	}

	public DateChooserCombo getDateChooserCombo(){
		return combo;
	}

	
	public void dispose() {
		if ( ! combo.isDisposed() ) {
			if ( updateEventType != SWT.None ) {
				combo.removeListener(updateEventType, updateListener);
			}
		}
		super.dispose();
	}

	protected Object doGetValue() {
		return oldValue = combo.getValue();
	}

	/**
	 * Sets the bound {@link DateChooserCombo} combo to the passed <code>value</code>.
	 * 
	 * @param value new value, Date expected
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doSetValue(java.lang.Object)
	 * @throws ClassCastException if the value is anything other than a Date
	 */
	protected void doSetValue(final Object value) {
		try {
			updating = true;
			combo.setValue((Date) value);
			oldValue = combo.getValue();
		} finally {
			updating = false;
		}
	}

	public Object getValueType() {
		return Date.class;
	}
}