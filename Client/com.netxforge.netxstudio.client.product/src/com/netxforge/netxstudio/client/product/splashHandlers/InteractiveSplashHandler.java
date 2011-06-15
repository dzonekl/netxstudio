package com.netxforge.netxstudio.client.product.splashHandlers;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.splash.AbstractSplashHandler;
import org.eclipse.wb.swt.SWTResourceManager;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.CommonService;
import com.netxforge.netxstudio.common.jca.JCAService;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.internal.DataActivator;

/**
 * @since 3.3
 * 
 * TODO, use an extensionfactory, to instantiate this class and have the bindings 
 * done automaticly. 
 * 
 */
public class InteractiveSplashHandler extends AbstractSplashHandler {

	private final static int F_LABEL_HORIZONTAL_INDENT = 175;

	private final static int F_BUTTON_WIDTH_HINT = 80;

	private final static int F_TEXT_WIDTH_HINT = 175;

	private final static int F_COLUMN_COUNT = 3;

	private Composite fCompositeLogin;

	private Text fTextUsername;

	private Text fTextPassword;

	private Button fButtonOK;

	private Button fButtonCancel;

	private boolean fAuthenticated;

	@Inject
	private IDataService dataService;

	CommonService commonService = new CommonService(new JCAService());

	/**
	 * 
	 */
	public InteractiveSplashHandler() {
		fCompositeLogin = null;
		fTextUsername = null;
		fTextPassword = null;
		fButtonOK = null;
		fButtonCancel = null;
		fAuthenticated = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.splash.AbstractSplashHandler#init(org.eclipse.swt.widgets
	 * .Shell)
	 */
	public void init(final Shell splash) {
		// Store the shell
		super.init(splash);
		// Configure the shell layout
		configureUISplash();
		// Create UI
		createUI();
		// Create UI listeners
		createUIListeners();
		// Force the splash screen to layout
		splash.layout(true);
		// Keep the splash screen visible and prevent the RCP application from
		// loading until the close button is clicked.
		doEventLoop();
	}

	/**
	 * 
	 */
	private void doEventLoop() {
		Shell splash = getSplash();
		while (fAuthenticated == false) {
			if (splash.getDisplay().readAndDispatch() == false) {
				splash.getDisplay().sleep();
			}
		}
	}

	/**
	 * 
	 */
	private void createUIListeners() {
		// Create the OK button listeners
		createUIListenersButtonOK();
		// Create the cancel button listeners
		createUIListenersButtonCancel();
	}

	/**
	 * 
	 */
	private void createUIListenersButtonCancel() {
		fButtonCancel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleButtonCancelWidgetSelected();
			}
		});
	}

	/**
	 * 
	 */
	private void handleButtonCancelWidgetSelected() {
		// Abort the loading of the RCP application
		getSplash().getDisplay().close();
		System.exit(0);
	}

	/**
	 * 
	 */
	private void createUIListenersButtonOK() {
		fButtonOK.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleButtonOKWidgetSelected();
			}
		});
	}

	/**
	 * 
	 */
	private void handleButtonOKWidgetSelected() {
		String username = fTextUsername.getText();
		String password = fTextPassword.getText();
		// Aunthentication is successful if a user provides any username and
		// any password
		if ((username.length() > 0) && (password.length() > 0)) {

			// THis would create a new instanceof.
			DataActivator.getInjector().injectMembers(this);

			// We will open a session here, this will be along running
			// operation.

			try {
				if (!"admin".equals(username)) {
					String digest = commonService.getJcasService().digest(
							password);
					if (digest != null && digest.length() > 0) {
						password = digest;
					} else {
						throw new java.lang.IllegalAccessException();
					}
				}
				dataService.getProvider().openSession(username, password);
				fAuthenticated = true;
			} catch (SecurityException se) {
				fAuthenticated = false;
				MessageDialog.openError(getSplash(), "Authentication Failed",
						"The user ID and/or password is wrong");
			} catch (Exception se) {
				fAuthenticated = false;
				MessageDialog
						.openError(getSplash(), "Error", //$NON-NLS-1$
								"The service is not available, contact the service admin"); //$NON-NLS-1$
			}

		} else {

			fAuthenticated = false;
			MessageDialog.openError(getSplash(), "Authentication Failed", //$NON-NLS-1$
					"A username and password must be specified to login."); //$NON-NLS-1$
		}
	}

	/**
	 * 
	 */
	private void createUI() {
		// Create the login panel
		createUICompositeLogin();
		// Create the blank spanner
		createUICompositeBlank();
		// Create the user name label
		createUILabelUserName();
		// Create the user name text widget
		createUITextUserName();
		// Create the password label
		createUILabelPassword();
		// Create the password text widget
		createUITextPassword();
		// Create the blank label
		createUILabelBlank();
		// Create the OK button
		createUIButtonOK();
		// Create the cancel button
		createUIButtonCancel();
	}

	/**
	 * 
	 */
	private void createUIButtonCancel() {
		// Create the button
		fButtonCancel = new Button(fCompositeLogin, SWT.PUSH);
		fButtonCancel.setText("Cancel"); //$NON-NLS-1$
		// Configure layout data
		GridData data = new GridData(SWT.NONE, SWT.NONE, false, false);
		data.widthHint = F_BUTTON_WIDTH_HINT;
		data.verticalIndent = 10;
		fButtonCancel.setLayoutData(data);
	}

	/**
	 * 
	 */
	private void createUIButtonOK() {
		// Create the button
		fButtonOK = new Button(fCompositeLogin, SWT.PUSH);
		fButtonOK.setText("OK"); //$NON-NLS-1$
		// Configure layout data
		GridData data = new GridData(SWT.NONE, SWT.NONE, false, false);
		data.widthHint = F_BUTTON_WIDTH_HINT;
		data.verticalIndent = 10;
		fButtonOK.setLayoutData(data);
		// We explicity request focus.
		fButtonOK.setFocus();
	}

	/**
	 * 
	 */
	private void createUILabelBlank() {
		Label label = new Label(fCompositeLogin, SWT.NONE);
		label.setVisible(false);
	}

	/**
	 * 
	 */
	private void createUITextPassword() {
		// Create the text widget
		int style = SWT.PASSWORD | SWT.BORDER;
		fTextPassword = new Text(fCompositeLogin, style);
		// Configure layout data
		GridData data = new GridData(SWT.NONE, SWT.NONE, false, false);
		data.widthHint = F_TEXT_WIDTH_HINT;
		data.horizontalSpan = 2;
		fTextPassword.setLayoutData(data);
	}

	/**
	 * 
	 */
	private void createUILabelPassword() {
		// Create the label
		Label label = new Label(fCompositeLogin, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setText("&Password:"); //$NON-NLS-1$
		// Configure layout data
		GridData data = new GridData();
		data.horizontalIndent = F_LABEL_HORIZONTAL_INDENT;
		label.setLayoutData(data);
	}

	/**
	 * 
	 */
	private void createUITextUserName() {
		// Create the text widget
		fTextUsername = new Text(fCompositeLogin, SWT.BORDER);
		// Configure layout data
		GridData data = new GridData(SWT.NONE, SWT.NONE, false, false);
		data.widthHint = F_TEXT_WIDTH_HINT;
		data.horizontalSpan = 2;
		fTextUsername.setLayoutData(data);
	}

	/**
	 * 
	 */
	private void createUILabelUserName() {
		// Create the label
		Label label = new Label(fCompositeLogin, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setText("&User Name:"); //$NON-NLS-1$
		// Configure layout data
		GridData data = new GridData();
		data.horizontalIndent = F_LABEL_HORIZONTAL_INDENT;
		label.setLayoutData(data);
	}

	/**
	 * 
	 */
	private void createUICompositeBlank() {
		Composite spanner = new Composite(fCompositeLogin, SWT.NONE);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.horizontalSpan = F_COLUMN_COUNT;
		spanner.setLayoutData(data);
	}

	/**
	 * 
	 */
	private void createUICompositeLogin() {
		// Create the composite
		fCompositeLogin = new Composite(getSplash(), SWT.BORDER);
		GridLayout layout = new GridLayout(F_COLUMN_COUNT, false);
		fCompositeLogin.setLayout(layout);
	}

	/**
	 * 
	 */
	private void configureUISplash() {
		// Configure layout
		FillLayout layout = new FillLayout();
		getSplash().setLayout(layout);
		// Force shell to inherit the splash background
		getSplash().setBackgroundMode(SWT.INHERIT_DEFAULT);
	}

}
