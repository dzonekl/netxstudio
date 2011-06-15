package com.netxforge.netxstudio.server.logic;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.util.Modules.override;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.netxstudio.data.cdo.CDODataServiceModule;

public class LogicActivator implements BundleActivator {

	private static BundleContext context;
	private Map<String, Injector> injectors = new HashMap<String, Injector>();

	private static LogicActivator INSTANCE;

	static BundleContext getContext() {
		return context;
	}

	public static LogicActivator getInstance() {
		return INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		INSTANCE = this;
		LogicActivator.context = bundleContext;

		try {
			registerInjectorFor("com.netxforge.Netxscript");

		} catch (Exception e) {
			Logger.getLogger(getClass()).error(e.getMessage(), e);
			throw e;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		LogicActivator.context = null;
	}
	
	public Injector getDefaultInjector(){
		return getInjector("com.netxforge.Netxscript");
	}

	public Injector getInjector(String languageName) {
		return injectors.get(languageName);
	}
	
	protected void registerInjectorFor(String language) throws Exception {

		Module om = this.getLogicModule();
		om = override(om).with(getRuntimeModule(language));
		// om = override(om).with(getSharedStateModule()); // Is this needed
		// server side?
		// om = override(om).with(getUiModule(language)); // Is this needed
		// server side?
		om = override(om).with(this.getDataProviderModule());
		// ... add next module here.
		injectors.put(language, createInjector(om));
	}

	protected Module getLogicModule() {
		return new LogicModule();
	}

	protected Module getRuntimeModule(String grammar) {
		if ("com.netxforge.Netxscript".equals(grammar)) {
			return new com.netxforge.NetxscriptRuntimeModule();
		}

		throw new IllegalArgumentException(grammar);
	}

	protected Module getDataProviderModule() {
		return new CDODataServiceModule();
	}

}
