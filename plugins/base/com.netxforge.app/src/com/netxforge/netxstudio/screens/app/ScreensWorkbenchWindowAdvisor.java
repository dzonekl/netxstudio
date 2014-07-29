/*******************************************************************************
 * Copyright (c) Apr 26, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.app;

import java.util.List;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.google.common.collect.Lists;

/**
 * 
 * @author Christophe Bouhier
 */
public class ScreensWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	/**
	 * A collection of listeners, for which we fire events matching the
	 * WorkbenchWindowAdvisor events.
	 */
	private List<IWorkbenchWindowLifecycle> lifecycleListeners = Lists
			.newArrayList();

	/**
	 * Register a {@link IWorkbenchWindowLifecycle listener} which will be
	 * notified for each event.
	 * 
	 * @param lifecycleListener
	 */
	public void addLifecycleListener(IWorkbenchWindowLifecycle lifecycleListener) {
		if (!lifecycleListeners.contains(lifecycleListener)) {
			lifecycleListeners.add(lifecycleListener);
		}
	}

	/**
	 * Remove a register {@link IWorkbenchWindowLifecycle listener}
	 * 
	 * @param lifecycleListener
	 */
	public void removeLifecycleListner(
			IWorkbenchWindowLifecycle lifecycleListener) {
		if (lifecycleListeners.contains(lifecycleListener)) {
			lifecycleListeners.remove(lifecycleListener);
		}
	}

	public ScreensWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		
		// TODO Consider delegation to the product. 
		return new ScreensActionBarAdvisor(configurer);
	}

	public void preWindowOpen() {

		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		// Notify our product.
		for (IWorkbenchWindowLifecycle lc : lifecycleListeners) {
			lc.preWindowOpen(configurer);
		}

	}

	@Override
	public void postWindowOpen() {
		IWorkbenchPage activePage = getWindowConfigurer().getWindow()
				.getActivePage();

		// There won't be any if no pespective is defined.
		if (activePage != null) {
			this.hideActionSets(activePage);
		}

		// Notify our product.
		for (IWorkbenchWindowLifecycle lc : lifecycleListeners) {
			lc.postWindowOpen(getWindowConfigurer());
		}
	}

	protected void hideActionSets(IWorkbenchPage page) {
		page.hideActionSet("org.eclipse.ui.WorkingSetActionSet");
		page.hideActionSet("org.eclipse.ui.actionSet.openFiles");
		page.hideActionSet("org.eclipse.ui.edit.text.actionSet.annotationNavigation");
		page.hideActionSet("org.eclipse.ui.edit.text.actionSet.navigation");
		page.hideActionSet("org.eclipse.ui.edit.text.actionSet.convertLineDelimitersTo");
		page.hideActionSet("org.eclipse.ui.actionSet.keyBindings");
		// page.hideActionSet("org.eclipse.update.ui.softwareUpdates");
	}

	@Override
	public boolean preWindowShellClose() {
		boolean veto = super.preWindowShellClose();

		// Notify our product, any listener can veto.
		for (IWorkbenchWindowLifecycle lc : lifecycleListeners) {
			veto = lc.preWindowShellClose();
		}
		return veto;
	}

	@Override
	public void postWindowClose() {
		// Notify our product, any listener can veto.
		for (IWorkbenchWindowLifecycle lc : lifecycleListeners) {
			lc.postWindowClose(this.getWindowConfigurer());
		}
	}

	@Override
	public void postWindowRestore() throws WorkbenchException {
		// Notify our product, any listener can veto.
		for (IWorkbenchWindowLifecycle lc : lifecycleListeners) {
			lc.postWindowRestore();
		}
	}

	@Override
	public void openIntro() {

		// @FIXME Should not call the super, when calling the lifecycle
		// listeners.
		super.openIntro();

		for (IWorkbenchWindowLifecycle lc : lifecycleListeners) {
			lc.openIntro();
		}
	}

	@Override
	public void postWindowCreate() {
		for (IWorkbenchWindowLifecycle lc : lifecycleListeners) {
			lc.postWindowCreate();
		}
	}

}
