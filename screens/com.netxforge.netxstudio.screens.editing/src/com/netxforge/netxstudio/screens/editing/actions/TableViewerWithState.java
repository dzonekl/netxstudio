/*******************************************************************************
 * Copyright (c) 23 mei 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.editing.actions;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * The default StructuredViewer abstracts away the state of the selectionEvent.
 * Things like {@link SelectionEvent#stateMask } get lost.
 * 
 * @author Christophe Bouhier
 */
public class TableViewerWithState extends TableViewer {

	public TableViewerWithState(Composite parent) {
		super(parent);
	}

	public TableViewerWithState(Composite content, int i) {
		super(content, i);
	}

	@Override
	protected void handleSelect(SelectionEvent event) {

		int stateMask = event.stateMask;

		Control control = getControl();
		if (control != null && !control.isDisposed()) {
			updateSelection(stateMask, getSelection());
		}
	}

	protected void updateSelection(int stateMask, ISelection selection) {
		StateSelectionChangedEvent event = new StateSelectionChangedEvent(this,
				selection);
		event.setStateMask(stateMask);
		fireSelectionChanged(event);
	}

	public class StateSelectionChangedEvent extends SelectionChangedEvent {

		/**
		 * 
		 */
		private static final long serialVersionUID = -7778193660507880813L;

		private int stateMask = -1;

		public StateSelectionChangedEvent(ISelectionProvider source,
				ISelection selection) {
			super(source, selection);
		}

		public int getStateMask() {
			return stateMask;
		}

		public void setStateMask(int stateMask) {
			this.stateMask = stateMask;
		}

		public boolean isState_CTRL() {
			return (stateMask & SWT.CTRL) != 0;
		}

		public boolean isState_ALT() {
			return (stateMask & SWT.ALT) != 0;
		}

		public boolean isState_SHIFT() {
			return (stateMask & SWT.SHIFT) != 0;
		}

		public boolean isState_COMMAND() {
			return (stateMask & SWT.COMMAND) != 0;
		}
	}

}
