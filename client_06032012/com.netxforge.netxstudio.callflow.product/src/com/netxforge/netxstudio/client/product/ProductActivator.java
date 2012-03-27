package com.netxforge.netxstudio.client.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

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

}
