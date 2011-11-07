package com.netxforge.netxstudio.screens.f4;

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

public class NewEditMappingColumnDialogII extends Dialog {

	private NewEditMappingColumn mappingColumnScreen;
	private Composite container;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public NewEditMappingColumnDialogII(Shell parentShell) {
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
		return new Point(750, 420);
	}

	public NewEditMappingColumn getMappingColumnScreen() {
		if (mappingColumnScreen == null) {
			setMappingColumnScreen(new NewEditMappingColumn(container, SWT.NONE));
			mappingColumnScreen.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
					true, true));
		}
		return mappingColumnScreen;
	}

	public void setMappingColumnScreen(NewEditMappingColumn mappingColumnScreen) {
		this.mappingColumnScreen = mappingColumnScreen;
	}

	@Override
	protected void cancelPressed() {
		if (mappingColumnScreen.isValid()) {
			dirtyWarning();
			super.cancelPressed();
		} else {
			if (mappingColumnScreen.getScreenService().getEditingService()
					.isDirty()) {
				boolean result = MessageDialog
						.openQuestion(this.getShell(),
								"Save needed, but entry not valid",
								"You have unsaved changes, which are not valid yet, discard?");
				if (result) {
					// clean the service.
					mappingColumnScreen.getScreenService().undoAndFlush();
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
		if (mappingColumnScreen.isValid()) {
			mappingColumnScreen.addData();
			super.okPressed();
		} else {
			// The screen is not valid, save is not allowed.
		}
	}

	public void dirtyWarning() {
		// Warn for unsaved changes.
		if (mappingColumnScreen.getScreenService().getEditingService()
				.isDirty()) {
			boolean result = MessageDialog
					.openQuestion(this.getShell(), "Save needed",
							"You have unsaved changes, which will be discarded when not saved, save?");
			if (result) {
				mappingColumnScreen.addData();

			} else {
				mappingColumnScreen.getScreenService().undoAndFlush();
			}
		} else {
			// Flush the stack anyway.
			mappingColumnScreen.getScreenService().getEditingService()
					.getEditingDomain().getCommandStack().flush();
		}
	}
}
