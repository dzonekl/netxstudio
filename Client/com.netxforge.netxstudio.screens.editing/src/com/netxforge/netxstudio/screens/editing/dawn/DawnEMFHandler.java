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
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent.Kind;
import org.eclipse.swt.widgets.Display;

import com.netxforge.netxstudio.screens.editing.internal.EditingActivator;

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

		if (EditingActivator.DEBUG) {
			System.out.println("CDOEditingService: transaction conflict");
		}

		refreshEditor(null);
	}

	@Override
	public void handleViewInvalidationEvent(CDOViewInvalidationEvent event) {
		super.handleViewInvalidationEvent(event);

		Set<CDOObject> dos = event.getDirtyObjects();
		if (EditingActivator.DEBUG) {
			String invalidBy = event.getSource().getSession().getUserID();
			System.out.println("CDOEditingService: Invalid objects by="
					+ invalidBy);
			for (CDOObject o : dos) {
				System.out.println("CDOEditingService: Invalid object" + o
						+ " state=" + o.cdoState());

			}
		}

		refreshEditor(dos);
	}

	@Override
	protected void handleLifeCycleEvent(ILifecycleEvent event) {
		Kind kind = event.getKind();
		if (EditingActivator.DEBUG) {
			System.out.println("CDOEditingService: Lifecycle event "
					+ kind.name());
		}
	}

	private void refreshEditor(final Set<CDOObject> dos) {

		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				Viewer v = ((IViewerProvider) editor).getViewer();
				if (EditingActivator.DEBUG) {
					if (v == null) {
						System.out
								.println("CDOEditingService: No viewer registered for this screen");
					} else {
						System.out
								.println("CDOEditingService: updating viewer");
					}

				}
				if (v != null) {
					if (v instanceof StructuredViewer) {
						v.refresh();
						// Show the state of the objects after a refresh.

						if (EditingActivator.DEBUG) {
							for (CDOObject cdoObject : dos) {
								System.out.println("CDOEditingService: root: object="
										+ cdoObject.cdoID() + " , state="
										+ cdoObject.cdoState());
								
								// Print the state of the children.
								TreeIterator<EObject> eAllContents = cdoObject.eAllContents();
								while(eAllContents.hasNext()){
									CDOObject next = (CDOObject) eAllContents.next();
									System.out.println("CDOEditingService: child: object="
											+ next.cdoID() + " , state="
											+ next.cdoState());
								}
							}
						}

					}
				}
				// No viewer to update, if we are in a form screen,
				// this could be a conflict.
			}
		});
	}
}
