package com.netxforge.netxstudio.screens.nf4;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class LoginDialog extends Dialog {
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text txtNewText;
	private Text text;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public LoginDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.PRIMARY_MODAL);
	}
	
	
	

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setBackground(SWTResourceManager.getColor(255, 255, 255));
		container.setLayout(new FormLayout());
		
		Composite composite = formToolkit.createComposite(container, SWT.NONE);
		FormData fd_composite = new FormData();
		fd_composite.right = new FormAttachment(100, -20);
		fd_composite.top = new FormAttachment(0, 20);
		fd_composite.left = new FormAttachment(0, 20);
		composite.setLayoutData(fd_composite);
		composite.setLayout(new GridLayout(2, false));
		formToolkit.paintBordersFor(composite);
		
		Label lblLogin = formToolkit.createLabel(composite, "Login:", SWT.NONE);
		GridData gd_lblLogin = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblLogin.widthHint = 70;
		lblLogin.setLayoutData(gd_lblLogin);
		lblLogin.setAlignment(SWT.RIGHT);
		
		txtNewText = formToolkit.createText(composite, "New Text", SWT.NONE);
		txtNewText.setText("");
		GridData gd_txtNewText = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_txtNewText.widthHint = 150;
		txtNewText.setLayoutData(gd_txtNewText);
		
		Label lblPassword = formToolkit.createLabel(composite, "Password:", SWT.NONE);
		lblPassword.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPassword.setAlignment(SWT.RIGHT);
		
		text = formToolkit.createText(composite, "New Text", SWT.PASSWORD);
		text.setText("");
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(300, 150);
	}
}
