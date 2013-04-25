package com.netxforge.netxstudio.callflow.product;

import java.util.Properties;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.netxforge.netxstudio.screens.app.IWorkbenchService;

/**
 * The activator class controls the plug-in life cycle
 */
public class ProductActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxstudio.callflow.product"; //$NON-NLS-1$

	// The shared instance
	private static ProductActivator plugin;

	/**
	 * The constructor
	 */
	public ProductActivator() {
	}

	private static final String propertiesFile = "netxstudio.properties";
	public static final String NETXSTUDIO_PROPS_COMMENT = "The NetXStudio client properties";
	public static final String NETXSTUDIO_SERVER = "netxstudio.server";
	public static final String NETXSTUDIO_LASTUSER = "netxstudio.lastuser";
	public static final String NETXSTUDIO_WORKSPACE = "netxstudio.workspace";

	private final PropertiesUtil pu = new PropertiesUtil();

	private Properties properties;

	private ServiceRegistration<IWorkbenchService> workbenchService;

	private Injector injector;
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

		// The EcorePlugin Activator tries to open the workspace, but the
				// workspace
				// is only set when the application inisitalized, if the plugin is
				// self-starting
				// this will thrown an exception that the data area is not set.
				System.getProperties()
						.setProperty(
								"org.eclipse.emf.ecore.plugin.EcorePlugin.doNotLoadResourcesPlugin",
								"false");

				// As we auto start this plugin, and EMF requires a workspace, in it'c
				// core
				// plugin.
				pu.readProperties(this.getBundle(), propertiesFile, getProperties());

				injector = Guice.createInjector(new ProductModule());

				final IWorkbenchService instance = injector
						.getInstance(IWorkbenchService.class);

				// Register our product workbench service to customize the application
				// at startup.
				workbenchService = context.registerService(IWorkbenchService.class,
						instance, null);
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
		pu.writeProperties(this.getBundle(), propertiesFile,
				this.getProperties());

		workbenchService.unregister();
		
//		super.stop(context);

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
		if (properties == null) {
			properties = new Properties();
		}
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}
