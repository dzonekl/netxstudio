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

import java.util.Set;

import org.eclipse.emf.cdo.CDOObject;
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
	
	// For both view invalidation and Transaction conflict, we 
	// refresh the editor. However in a form view, there is no editor to 
	// refresh, so we would need to provide another mechanism. 
	
	@Override
	public void handleTransactionConflictEvent(CDOTransactionConflictEvent event) {
		super.handleTransactionConflictEvent(event);
		System.out.println("transaction conflict");
		refreshEditor();
	}

	@Override
	public void handleViewInvalidationEvent(CDOViewInvalidationEvent event) {
		super.handleViewInvalidationEvent(event);
		
		Set<CDOObject> dos = event.getDirtyObjects();
		for(CDOObject o : dos){
			System.out.println(o);
		}
		refreshEditor();
	}

	private void refreshEditor() {

		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				Viewer v = ((IViewerProvider) editor).getViewer();
				System.out.println("Dawn: updating viewer");
				System.out.println(v);
				if (v != null) {
					v.refresh();
				}
				// No viewer to update, if we are in a form screen, 
				// this could be a conflict. 
			}
		});
	}
}
