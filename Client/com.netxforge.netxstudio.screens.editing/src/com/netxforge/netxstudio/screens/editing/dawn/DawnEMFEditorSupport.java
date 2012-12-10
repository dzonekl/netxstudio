/**
 * Copyright (c) 2004 - 2011 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Martin Fluegge - initial API and implementation
 */
package com.netxforge.netxstudio.screens.editing.dawn;

import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.view.CDOAdapterPolicy;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.ILifecycle;
import org.eclipse.net4j.util.lifecycle.LifecycleEventAdapter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.netxforge.netxstudio.screens.editing.selector.AbstractScreenSelector;

/**
 * @author Martin Fluegge
 * @since 1.0
 */
public class DawnEMFEditorSupport extends DawnAbstractEditorSupport {

	private BasicDawnListener dawnEMFHandler;
	private SessionLifecycle sessionLifeCycleHandler;

	public DawnEMFEditorSupport(IDawnEditor editor) {
		super(editor);
		dawnEMFHandler = new DawnEMFHandler(getEditor());
		sessionLifeCycleHandler = new SessionLifecycle();
	}

	public void close() {
		CDOView view = getView();
		if (view != null && !view.isClosed()) {
			view.close();
		}
	}

	/**
	 * Registers a DawnEMFHandler as listener for various interfaces.
	 * 
	 * 
	 */
	public void registerListeners() {

		CDOView view = getView();
		IListener[] listeners = view.getListeners();

		// Always remove our listeners, even if we re-use a CDO view.
		// Proving that registration on the view, would not include additionally
		// loaded objects???
		if (listeners != null) {
			view.removeListener(dawnEMFHandler);
			view.getSession().removeListener(sessionLifeCycleHandler);

		}

		addChangeSubscription(view);
		view.addListener(dawnEMFHandler);
		CDOSession session = view.getSession();
		for (IListener l : session.getListeners()) {
			if (l == sessionLifeCycleHandler) {
				return;
			}
		}
		view.addListener(sessionLifeCycleHandler);
	}

	private void addChangeSubscription(CDOView view) {

		boolean doAdd = true;
		for (CDOAdapterPolicy cdoa : view.options()
				.getChangeSubscriptionPolicies()) {
			if (cdoa == CDOAdapterPolicy.CDO) {
				doAdd = false;
			}

		}
		if (doAdd) {
			view.options().addChangeSubscriptionPolicy(CDOAdapterPolicy.CDO);
		}

	}

	class SessionLifecycle extends LifecycleEventAdapter {

		@Override
		protected void onAboutToDeactivate(ILifecycle lifecycle) {
			// System.out.println("About to deactive lifecycle");
			super.onAboutToDeactivate(lifecycle);
			noConnection(lifecycle);
		}
	}

	/**
	 * Fires on all failing transactions.
	 * 
	 * @param lifecycle
	 */
	public void noConnection(ILifecycle lifecycle) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {

				// MessageDialog
				// .openError(
				// Display.getDefault().getActiveShell(),
				// "Connection lost",
				// "Connection (Transaction) is not valid anymore,\n this could be "
				// +
				// "to a network failure or the server being not responding (Down or failure).\n It is recommended to restart the application");

				// Experimental way to interrogate the platform and cast to our
				// known parts, to disable the screen selector.

				IWorkbenchWindow[] workbenchWindows = PlatformUI.getWorkbench()
						.getWorkbenchWindows();
				
				// Doesn't work for non-active perspectives. 
				// so need to maintain the state, and not allow restoring IScreens. 
				// also, when a job is running it should be cancelled. 
				
				
				for (IWorkbenchWindow wbw : workbenchWindows) {
					IWorkbenchPage[] pages = wbw.getPages();
					for (int i = 0; i < pages.length; i++) {
						IWorkbenchPage iWorkbenchPage = pages[i];
						IViewReference[] viewReferences = iWorkbenchPage
								.getViewReferences();
						for (int k = 0; k < viewReferences.length; k++) {
							IViewReference iViewReference = viewReferences[k];
							IViewPart viewPart = iViewReference.getView(false);
							if (viewPart instanceof AbstractScreenSelector) {
								((AbstractScreenSelector) viewPart)
										.getScreenService().disable();
							}
						}
					}
				}

			}

		});
	}

	@Override
	public void rollback() {
		super.rollback();

		Viewer viewer = ((IViewerProvider) getEditor()).getViewer();
		if (viewer != null) {
			viewer.refresh();
		}
	}

}
