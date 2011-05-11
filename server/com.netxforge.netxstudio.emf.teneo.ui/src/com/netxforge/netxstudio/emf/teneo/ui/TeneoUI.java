/**
 * <copyright>
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Springsite BV (The Netherlands) and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Martin Taal - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: StoreController.java,v 1.2 2009/06/28 20:18:42 mtaal Exp $
 */
package com.netxforge.netxstudio.emf.teneo.ui;

import java.util.Properties;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.PersistenceOptions;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
import org.hibernate.cfg.Environment;

import com.netxforge.netxstudio.emf.teneo.TeneoService;
import com.netxforge.netxstudio.emf.teneo.ui.internal.Activator;
import com.netxforge.netxstudio.emf.teneo.ui.preferences.TeneoPreferenceConstants;

/**
 * epackages and the properties in the teneo.properties. We also define a set,
 * which can be used to creat, load, unload and save a Hibernate resource.
 * 
 * 
 */
public class TeneoUI {

	public static final TeneoUI INSTANCE = new TeneoUI();

	// TODO, experimental with a shared domain and set.
	// private ResourceSet set = new ResourceSetImpl();
	// public ResourceSet getSet() {
	// return
	// SharedEditingService.INSTANCE.getSharedEditingDomain().getResourceSet();
	// }

	/**
	 * A context activation key.
	 */
	IContextActivation activation;

	public void closeDataStore() {

		// We should unload our resources. hour editor will deal with this as a
		// resource change.
		// for( Resource res : getSet().getResources()){
		// res.unload();
		// }

		TeneoService.getInstance().closeDataStore();
		// Activate the connected context.
		IContextService contextService = (IContextService) PlatformUI
				.getWorkbench().getService(IContextService.class);
		contextService.deactivateContext(activation);

	}

	/**
	 * Get the settings as defined in our Preference Defaults.
	 * 
	 * @param dbName
	 *            , provide null to use the default DB name.
	 * @return
	 */
	public Properties getPreferenceProperties(String dbName) {

		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		Properties props = new Properties();

		// We get the default DB name.
		if (dbName == null)
			dbName = store.getString(TeneoPreferenceConstants.P_DB_NAME);

		// Set the database information, Environment is
		props.setProperty(Environment.DRIVER,
				store.getString(TeneoPreferenceConstants.P_DB_DRIVER));

		String user = store.getString(TeneoPreferenceConstants.P_DB_USER);
		if (user != null && user.length() > 0) {
			props.setProperty(Environment.USER,
					store.getString(TeneoPreferenceConstants.P_DB_USER));
		}
		
		// TODO, The URL, is vendor/dialect specific, like appending the DB
		// name.
		// Currently the URL attribute is hardcoded for MySQL.
		props.setProperty(Environment.URL,
				store.getString(TeneoPreferenceConstants.P_DB_SERVER));
		
		props.setProperty(Environment.DIALECT,
				store.getString(TeneoPreferenceConstants.P_DB_DIALECT));
		
		// ************ NON-DB related settings. 
		
		// props.setProperty(Environment.PASS, "root"); Remove to omit the
		props.setProperty(Environment.HBM2DDL_AUTO, "update"); // Use when the //$NON-NLS-1$
		// database
		// changed?
		props.setProperty(Environment.SHOW_SQL, "false"); //$NON-NLS-1$


		// To get correct persistence on a large copy.
		props.setProperty(PersistenceOptions.CASCADE_POLICY_ON_CONTAINMENT,
				"REMOVE, REFRESH, PERSIST, MERGE"); //$NON-NLS-1$
		props.setProperty(PersistenceOptions.CASCADE_POLICY_ON_NON_CONTAINMENT,
				"REMOVE, REFRESH, PERSIST, MERGE"); //$NON-NLS-1$

		// props.setProperty(PersistenceOptions.SET_CASCADE_ALL_ON_CONTAINMENT,
		// "false");

		return props;
	}

	/**
	 * Initializes multiple packages in a data store.
	 * 
	 * @param packages
	 */
	public void initializeDataStore(EPackage[] ePackages) {

		if (TeneoService.getInstance().initialized()) {
			// TODO Actually, it could have been initialized with different
			// settings.
			return;
		} else {
			TeneoService.getInstance().initializeDataStore(ePackages,
					getPreferenceProperties(null), "netxstudio"); //$NON-NLS-1$
		}

		if (TeneoService.getInstance().initialized()) {

			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

				@Override
				public void run() {
					// Activate the connected context.
					IContextService contextService = (IContextService) PlatformUI
							.getWorkbench().getService(IContextService.class);

					activation = contextService
							.activateContext("com.netxforge.d.netxstudio.contexts.DBConnected"); //$NON-NLS-1$
				}
			});
			// Create a resource for our Library entry and add it to our set.
			// this.getSet().getResource(TeneoService.DATABASE_LIBRARY_URI,
			// true);
		} else {
			// Many things would go wrong, check console for exceptions.
		}
	}
}
