package com.netxforge.netxstudio.client.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.service.datalocation.Location;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ProductActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxstudio.ui.product"; //$NON-NLS-1$

	// The shared instance
	private static ProductActivator plugin;

	/**
	 * The constructor
	 */
	public ProductActivator() {
	}

	String propertiesFile = "netxstudio.properties";
	public static final String NETXSTUDIO_PROPS_COMMENT = "The NetXStudio client properties";
	public static final String NETXSTUDIO_SERVER = "netxstudio.server";
	public static final String NETXSTUDIO_LASTUSER = "netxstudio.lastuser";
	public static final String NETXSTUDIO_WORKSPACE = "netxstudio.workspace";

	// public static String serverValue="";
	// public static String lastuserValue="";
	// public static String workspaceValue="";

	private Properties properties;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		// As we auto start this plugin, and EMF requires a workspace, in it'c
		// core
		// plugin.
		setWorkspaceLocation();

		File f = this.getBundle().getDataFile(propertiesFile);
		setProperties(new Properties());
		if (f.exists()) {
			// Read properties file.
			try {
				getProperties().load(new FileInputStream(f));
				// lastuserValue =
				// this.getProperties().getProperty(NETXSTUDIO_LASTUSER);
				// serverValue =
				// this.getProperties().getProperty(NETXSTUDIO_SERVER);
				// workspaceValue =
				// this.getProperties().getProperty(NETXSTUDIO_WORKSPACE);
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println(getProperties().toString());
		} else {
			if (f.createNewFile()) {
				System.out.println("Create properties file: " + propertiesFile);
				this.getProperties().store(new FileOutputStream(f),
						NETXSTUDIO_PROPS_COMMENT);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;

		// Write the propeties file.
		// this.getProperties().setProperty(ProductActivator.NETXSTUDIO_SERVER,
		// serverValue);
		// this.getProperties().setProperty(ProductActivator.NETXSTUDIO_WORKSPACE,
		// workspaceValue);
		// this.getProperties().setProperty(ProductActivator.NETXSTUDIO_LASTUSER,
		// lastuserValue);

		File f = this.getBundle().getDataFile(propertiesFile);

		try {
			this.getProperties().store(new FileOutputStream(f),
					NETXSTUDIO_PROPS_COMMENT);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		super.stop(context);

	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static ProductActivator getDefault() {
		return plugin;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	private void setWorkspaceLocation() {
		// set location to c:\temp

		// fetch the Location that we will be modifying
		Location instanceLoc = Platform.getInstanceLocation();
		if (instanceLoc.isSet()) {
			return;
		}
		try {
			// // temp should always return a location.
			// String temp = System.getProperty("java.io.tmpdir");
			// if (temp != null) {
			// instanceLoc.set(new URL("file", null, temp), false);
			// }
			//

			// get what the user last said about remembering the workspace
			// location
			boolean remember = PickWorkspaceDialog.isRememberWorkspace();

			// get the last used workspace location
			String lastUsedWs = PickWorkspaceDialog
					.getLastSetWorkspaceDirectory();

			// if we have a "remember" but no last used workspace, it's not much
			// to
			// remember
			if (remember && (lastUsedWs == null || lastUsedWs.length() == 0)) {
				remember = false;
			}

			// check to ensure the workspace location is still OK
			if (remember) {
				// if there's any problem whatsoever with the workspace, force a
				// dialog which in its turn will tell them what's bad
				String ret = PickWorkspaceDialog.checkWorkspaceDirectory(
						Display.getDefault().getActiveShell(), lastUsedWs,
						false, false);
				if (ret != null) {
					remember = false;
				}

			}

			// if we don't remember the workspace, show the dialog
			if (!remember) {
				PickWorkspaceDialog pwd = new PickWorkspaceDialog(false);
				int pick = pwd.open();

				// if the user cancelled, we can't do anything as we need a
				// workspace, so in this case, we tell them and exit
				if (pick == Window.CANCEL) {
					if (pwd.getSelectedWorkspaceLocation() == null) {
						MessageDialog
								.openError(Display.getDefault()
										.getActiveShell(), "Error",
										"The application can not start without a workspace root and will now exit.");
						try {
							PlatformUI.getWorkbench().close();
						} catch (Exception err) {

						}
					}
				} else {
					// tell Eclipse what the selected location was and continue
					instanceLoc.set(
							new URL("file", null, pwd
									.getSelectedWorkspaceLocation()), false);
				}
			} else {
				// set the last used location and continue
				instanceLoc.set(new URL("file", null, lastUsedWs), false);
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
