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
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.transaction.CDOTransactionConflictEvent;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent.Kind;
import org.eclipse.swt.widgets.Display;

import com.netxforge.netxstudio.screens.editing.IScreenProvider;
import com.netxforge.netxstudio.screens.editing.internal.EditingActivator;
import com.netxforge.netxstudio.screens.editing.selector.IDataInjection;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;

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

		// Map<CDOObject, CDORevisionDelta> revisionDeltas = event
		// .getRevisionDeltas();
		// for (CDOObject key = revisionDeltas.keySet().iterator().next();
		// revisionDeltas
		// .keySet().iterator().hasNext();) {
		// CDORevisionDelta cdoRevisionDelta = revisionDeltas.get(key);
		// if (cdoRevisionDelta != null) {
		// CDOID id = cdoRevisionDelta.getID();
		// System.out.println(" Revision delta for event, cdoID=" + id);
		// }
		//
		// }

		Set<CDOObject> dos = event.getDirtyObjects();
		if (EditingActivator.DEBUG) {
			String invalidBy = event.getSource().getSession().getUserID();
			EditingActivator.TRACE.trace(
					EditingActivator.TRACE_EDITING_DETAILS_OPTION, invalidBy
							+ " invalidated some objects remotely");
			for (CDOObject o : dos) {
				CDORevision rev = o.cdoRevision();
				EditingActivator.TRACE.trace(
						EditingActivator.TRACE_EDITING_DETAILS_OPTION,
						"Invalid object: " + o + " state=" + o.cdoState()
								+ " ,version="
								+ (rev != null ? rev.getVersion() : "?"));

				// CDOSession session = CDOUtil.getSession(o);
				// session.refresh();
				// Check the state after a refresh
				// rev = o.cdoRevision();
				// System.out.println("CDOEditingService: refresh object" + o
				// + " state=" + o.cdoState() + " ,version=" + (rev != null ?
				// rev.getVersion() : "?"));

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

				// IScreen screen = ((IScreenProvider) editor).getScreen();
				// if (screen == null) {
				// return;
				// }

				IScreen[] screens = ((IScreenProvider) editor).getScreens();

				for (IScreen screen : screens) {
					IDataInjection dataInjection = ScreenUtil
							.dataInjectionFor(screen);

					if (dataInjection.shouldInjectForObject(dos)) {
						// Inject here.... the screen can accept or not.
					}

					if (screen.shouldHandleRefresh()) {
						screen.handleReshresh(dos);
					} else {
						// Walk all the viewers for this screen.
						for (Viewer v : screen.getViewers()) {
							if (EditingActivator.DEBUG) {
								if (v == null) {
									EditingActivator.TRACE
											.trace(EditingActivator.TRACE_EDITING_DETAILS_OPTION,
													"No viewer registered for IScreen: "
															+ screen.getScreenName());
									continue;
								} else {
									EditingActivator.TRACE
											.trace(EditingActivator.TRACE_EDITING_DETAILS_OPTION,
													"Refreshing IScreen: "
															+ screen.getScreenName()
															+ " viewer type: "
															+ v.getClass()
																	.getName());
								}

							}
							if (v instanceof StructuredViewer
									&& !v.getControl().isDisposed()) {
								v.refresh();
								// Show the state of the objects after a
								// refresh.

								if (EditingActivator.DEBUG) {
									for (CDOObject cdoObject : dos) {
										EditingActivator.TRACE
												.trace(EditingActivator.TRACE_EDITING_DETAILS_OPTION,
														"object="
																+ cdoObject
																		.cdoID()
																+ " , state="
																+ cdoObject
																		.cdoState());
									}
								}
							}
						}
					}
					// in screen form service fire screen Invalid changed, this
					// comes after refreshing the view
					// , making sure the objects are never in state PROXY.
					screen.getScreenService().fireScreenInvalidExternal(screen);
				}
			}
		});
	}
}
