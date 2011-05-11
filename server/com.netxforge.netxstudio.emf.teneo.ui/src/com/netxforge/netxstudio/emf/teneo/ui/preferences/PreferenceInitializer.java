package com.netxforge.netxstudio.emf.teneo.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.netxforge.netxstudio.emf.teneo.ui.internal.Activator;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		store.setDefault(TeneoPreferenceConstants.P_DB_DRIVER,
				"com.mysql.jdbc.Driver");
		store.setDefault(TeneoPreferenceConstants.P_DB_NAME,
		"netxstudio");
		store.setDefault(TeneoPreferenceConstants.P_DB_SERVER,
		"jdbc:mysql://127.0.0.1:3306");
		store.setDefault(TeneoPreferenceConstants.P_DB_DIALECT,
				"org.hibernate.dialect.MySQLInnoDBDialect");
		store.setDefault(TeneoPreferenceConstants.P_DB_USER,
		"root");
		store.setDefault(TeneoPreferenceConstants.P_DB_PASSWORD,
		"");
		
	}
}
