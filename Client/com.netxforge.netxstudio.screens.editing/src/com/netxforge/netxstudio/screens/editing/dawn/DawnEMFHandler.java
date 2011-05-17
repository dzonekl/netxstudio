/*******************************************************************************
 * Copyright (c) 2004 - 2011 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fluegge - initial API and implementation
 ******************************************************************************/
package com.netxforge.netxstudio.screens.editing.dawn;

import org.eclipse.emf.cdo.transaction.CDOTransactionConflictEvent;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;

/**
 * @author Martin Fluegge
 */
public class DawnEMFHandler extends BasicDawnListener {
	/**
	 * @since 1.0
	 */
	public DawnEMFHandler(IDawnEditor editor) {
		super(editor);
	}

	@Override
	public void handleTransactionConflictEvent(CDOTransactionConflictEvent event) {
		super.handleTransactionConflictEvent(event);
		refreshEditor();
	}

	@Override
	public void handleViewInvalidationEvent(CDOViewInvalidationEvent event) {
		super.handleViewInvalidationEvent(event);
		refreshEditor();
	}

	private void refreshEditor() {

		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				Viewer v = ((IViewerProvider) editor).getViewer();
				if (v != null) {
					v.refresh();
				}
				// No viewer to update. 
			}
		});
	}
}
