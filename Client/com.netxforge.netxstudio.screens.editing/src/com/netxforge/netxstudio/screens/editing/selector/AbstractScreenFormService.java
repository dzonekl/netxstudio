/*******************************************************************************
 * Copyright (c) May 9, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.editing.selector;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.screens.editing.IEditingService;

/**
 * Tabbed Version.
 * 
 * This service is capable to place a composite in a dedicated section (The
 * container), of a layout structure. The layout is a Selector pane, a Container
 * pane and a Toolbar pane.
 * 
 * </p>The container can be updated by placing selectors calling
 * <code>addScreenSelector(...)</code>. When the active screen in the container
 * is replaced by another screen, the previous screen is remembered and can be
 * retrieved by calling: <code>restorePreviousScreen()</code>
 * 
 * The screen (Which should be a form composite) should have a constructor with
 * arguments for <code>IEditingService</code> and
 * <code>IScreenFormService</code>. </p>The service also automatically shows a
 * toolbar with Hyperlinks to navigate and invoke actions, between the screens,
 * depending on the implemented interfaces: <uL <li>{@link IScreen}, for New,
 * Edit and Table type screens</li> <li>{@link IDataServiceInjection}, for
 * screens which get their data injected from {@link IDataService}</li> <li>
 * {@link IDataScreenInjection}, for screens which get their data injected from
 * another screen, will show the <b>Save</b> action</li> </ul>
 * 
 * First time users of the service should call <code>initialize()</code> to set
 * the parent composite. Also it's a good idea to call
 * <code>setEditingService</code>.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public abstract class AbstractScreenFormService implements IScreenFormService {

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	private SashForm sashForm;
	private Form selectorForm;
	private Composite rootComposite;
	
	// Notification of screen changing.

		List<ScreenChangeListener> screenChangedListeners = new ArrayList<ScreenChangeListener>();

	@Inject
	IEditingService editingService;

	public Composite getActiveScreen() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isActiveScreen(Class<?> proposedScreen) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setActiveScreen(Composite control) {
		// TODO Auto-generated method stub

	}

	public void activateInObservable(Runnable rn) {
		// TODO Auto-generated method stub

	}

	public void initalize(Composite parent) {
		rootComposite = new Composite(parent, SWT.NONE);
		rootComposite.setLayout(new FillLayout(SWT.HORIZONTAL));
		{
			sashForm = new SashForm(rootComposite, SWT.SMOOTH);
			sashForm.setSashWidth(5);
			{
				Composite selectorComposite = formToolkit.createComposite(
						sashForm, SWT.NONE);
				formToolkit.paintBordersFor(selectorComposite);
				selectorComposite.setLayout(new FillLayout(SWT.HORIZONTAL));
				{
					selectorForm = formToolkit.createForm(selectorComposite);
					selectorForm.setSeparatorVisible(true);
					formToolkit.paintBordersFor(selectorForm);
					selectorForm.setText("M");
					selectorForm.getBody().setLayout(new FormLayout());
				}
			}
			// {
			// screenBody = new ScreenBody(sashForm, SWT.NONE);
			//
			// // Install all the links on the screen bar.
			// this.createBackLink(screenBody.getScreenBar());
			// this.createSaveLink(screenBody.getScreenBar());
			// screenBody.setScreenBarOff();
			// screenBody.setScreenPathOff();
			// }
			sashForm.setWeights(new int[] { 70, 491 });
		}

	}

	public Composite addScreenSelector(String name, String iconPath,
			Class<?> screen, int position, int operation) {
		// TODO Auto-generated method stub
		return null;
	}

	public Composite addScreenSelector(Composite above, String name,
			String iconPath, Class<?> screen, int operation) {
		// TODO Auto-generated method stub
		return null;
	}

	public Composite addScreenSelector(Composite above, String name,
			String iconPath, Class<?> screen, int position, int operation) {
		// TODO Auto-generated method stub
		return null;
	}

	public Form getSelectorForm() {
		// TODO Auto-generated method stub
		return null;
	}

	public Composite getScreenContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	public Composite getScreenActionBar() {
		// TODO Auto-generated method stub
		return null;
	}


	public void addScreenChangeListener(
			ScreenChangeListener screenChangedListener) {
		if (!screenChangedListeners.contains(screenChangedListener)) {
			screenChangedListeners.add(screenChangedListener);
		}
	}

	public void removeScreenChangeListener(
			ScreenChangeListener screenChangedListener) {
		if (screenChangedListeners.contains(screenChangedListener)) {
			screenChangedListeners.remove(screenChangedListener);
		}
	}

	public void fireScreenChangedExternal(IScreen screen) {
		this.fireScreenChanged(screen);
	}

	private void fireScreenChanged(IScreen screen) {
		for (ScreenChangeListener l : screenChangedListeners) {
			l.screenChanged(screen);
		}
	}

	/**
	 * Warns if the current screen is dirty, if not saving, flush the command
	 * stack. If saving, save depending on the screen type.
	 */
	protected void dirtyWarning() {
		// Warn for unsaved changes.
		if (editingService.isDirty()) {
			boolean result = MessageDialog
					.openQuestion(Display.getCurrent().getActiveShell(),
							"Save needed",
							"You have unsaved changes, which will be discarded when not saved, save?");
			if (result) {

				if (getActiveScreen() instanceof IDataScreenInjection) {
					((IDataScreenInjection) getActiveScreen()).addData();
				} else {
					editingService.doSave(new NullProgressMonitor());
				}

			} else {
				undoAndFlush();
			}
		} else {
			// Flush the stack anyway.
			editingService.getEditingDomain().getCommandStack().flush();
		}
	}

	public IEditingService getEditingService() {
		return editingService;
	}

	private void undoAndFlush() {
		// This will flush the stack, but not undo all the commands.
		// We need to undo the executed editing commands.
		while (editingService.getEditingDomain().getCommandStack().canUndo()) {
			editingService.getEditingDomain().getCommandStack().undo();
		}
		editingService.getEditingDomain().getCommandStack().flush();
		// The data should have been disposed by now.
	}
}
