/*******************************************************************************
 * Copyright (c) Jun 14, 2011 NetXForge.
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
package com.netxforge.ui.internal.override;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.util.Modules.override;
import static org.ops4j.peaberry.Peaberry.osgiModule;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.ops4j.peaberry.Export;
import org.osgi.framework.BundleContext;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.netxstudio.common.guice.IInjectorProxy;
import com.netxforge.scoping.CDOScopeScheduler;

/**
 * Override from generated xtext activator. At bundle start initialize our
 * 'external' scope.
 */
public class OverrideNetxscriptActivator extends AbstractUIPlugin {

	private Map<String, Injector> injectors = new HashMap<String, Injector>();
	private static OverrideNetxscriptActivator INSTANCE;

	public Injector getInjector(String languageName) {
		return injectors.get(languageName);
	}

	@Inject
	Export<IInjectorProxy> injectorProxyService;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		try {
			registerInjectorFor(context, "com.netxforge.Netxscript");
			getInjector("com.netxforge.Netxscript").injectMembers(this);

			CDOScopeScheduler schedule = injectors.get(
					"com.netxforge.Netxscript").getInstance(
					CDOScopeScheduler.class);
			schedule.scheduleInitialLoading();

		} catch (Exception e) {
			Logger.getLogger(getClass()).error(e.getMessage(), e);
			throw e;
		}
	}

	protected void registerInjectorFor(BundleContext ctx, String language)
			throws Exception {

		Module om = getRuntimeModule(language);
		om = override(om).with(getSharedStateModule());
		om = override(om).with(getUiModule(language));
		om = override(om).with(new ScriptUIImportModule());
		om = override(om).with(new ScriptUIExportModule());
		injectors.put(language, createInjector(osgiModule(ctx), om));
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		injectors.clear();
		INSTANCE = null;
		super.stop(context);
	}

	public static OverrideNetxscriptActivator getInstance() {
		return INSTANCE;
	}

	protected Module getRuntimeModule(String grammar) {
		if ("com.netxforge.Netxscript".equals(grammar)) {
			return new com.netxforge.internal.NetxscriptRuntimeModule();
		}

		throw new IllegalArgumentException(grammar);
	}

	protected Module getUiModule(String grammar) {
		if ("com.netxforge.Netxscript".equals(grammar)) {
			return new com.netxforge.ui.NetxscriptUiModule(this);
		}

		throw new IllegalArgumentException(grammar);
	}

	protected Module getSharedStateModule() {
		return new org.eclipse.xtext.ui.shared.SharedStateModule();
	}
}
