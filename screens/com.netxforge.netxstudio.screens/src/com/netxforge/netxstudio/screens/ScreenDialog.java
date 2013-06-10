/*******************************************************************************
 * Copyright (c) Jan 6, 2012 NetXForge.
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
package com.netxforge.netxstudio.screens;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.netxforge.netxstudio.screens.editing.IScreen;
import com.netxforge.netxstudio.screens.editing.ScreenUtil;

/**
 * Wraps an IScreen in a dialog. Don't forget to configure the screen.
 * 
 * FIXME, Delegate the editing action like save, dirtywarning etc... to the
 * editing service.
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public class ScreenDialog extends Dialog {

	private IScreen screen;
	private Composite container;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public ScreenDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.RESIZE | SWT.TITLE);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		container = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = (GridLayout) container.getLayout();
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "Save", true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(750, 600);
	}

	/**
	 * Initialize the screen from a class. Note: Important to further configure
	 * the screen with the screen service, operation etc...
	 * 
	 * 
	 * @param screenClass
	 */
	public void inializeScreenFor(Class<?> screenClass) {
		Constructor<?> screenConstructor = null;
		try {
			screenConstructor = screenClass.getConstructor(Composite.class,
					int.class);

			Composite target = (Composite) screenConstructor.newInstance(
					container, SWT.NONE);

			target.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			if (target instanceof IScreen) {
				screen = (IScreen) target;
			}
		} catch (NoSuchMethodException e) {
			System.out.println("TODO, Implement correct screen signature on :"
					+ screenClass.getClass().getSimpleName());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public IScreen screen() {
		return this.screen;
	}

	@Override
	protected void cancelPressed() {
		if (screen.isValid()) {
			dirtyWarning();
			super.cancelPressed();
		} else {
			if (screen.getScreenService().getEditingService().isDirty()) {
				boolean result = MessageDialog
						.openQuestion(this.getShell(),
								"Save needed, but entry not valid",
								"You have unsaved changes, which are not valid yet, discard?");
				if (result) {
					// clean the service.
					screen.getScreenService().undoAndFlush();
					super.cancelPressed();
				} else {
					// Stay on this screen.
				}
			} else {
				super.cancelPressed();
			}
		}
	}

	@Override
	protected void okPressed() {
		if (screen.isValid()) {
			if (ScreenUtil.isNewOperation(screen.getOperation())) {
				if (ScreenUtil.isDataScreenInjection(screen)) {
					ScreenUtil.dataScreenInjectionFor(screen).addData();
				} else {
					// TODO, dirty warning?
				}
			}
			super.okPressed();
		} else {
			// The screen is not valid, save is not allowed.

		}
	}

	public void dirtyWarning() {
		// Warn for unsaved changes.
		if (screen.getScreenService().getEditingService().isDirty()) {
			boolean result = MessageDialog
					.openQuestion(this.getShell(), "Save needed",
							"You have unsaved changes, which will be discarded when not saved, save?");
			if (result && ScreenUtil.isDataScreenInjection(screen)) {
				ScreenUtil.dataScreenInjectionFor(screen).addData();
			} else {
				screen.getScreenService().undoAndFlush();
			}
		} else {
			// Flush the stack anyway.
			screen.getScreenService().getEditingService().getEditingDomain()
					.getCommandStack().flush();
		}
	}
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		if (screen != null) {
			shell.setText(screen.getScreenName());
		}
	}
}
