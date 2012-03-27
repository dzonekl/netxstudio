/**
 * Copyright (c) 2011 NetXForge
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors:
 * Christophe Bouhier - initial API and implementation and/or initial documentation
 */
package com.netxforge.netxstudio.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.generics.ExpansionDurationSetting;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Server Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.impl.ServerSettingsImpl#getExpansionDurationSettings <em>Expansion Duration Settings</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.impl.ServerSettingsImpl#getExportPath <em>Export Path</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.impl.ServerSettingsImpl#getImportPath <em>Import Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServerSettingsImpl extends CDOObjectImpl implements ServerSettings {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServerSettingsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetxstudioPackage.Literals.SERVER_SETTINGS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionDurationSetting getExpansionDurationSettings() {
		return (ExpansionDurationSetting)eGet(NetxstudioPackage.Literals.SERVER_SETTINGS__EXPANSION_DURATION_SETTINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpansionDurationSettings(ExpansionDurationSetting newExpansionDurationSettings) {
		eSet(NetxstudioPackage.Literals.SERVER_SETTINGS__EXPANSION_DURATION_SETTINGS, newExpansionDurationSettings);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExportPath() {
		return (String)eGet(NetxstudioPackage.Literals.SERVER_SETTINGS__EXPORT_PATH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExportPath(String newExportPath) {
		eSet(NetxstudioPackage.Literals.SERVER_SETTINGS__EXPORT_PATH, newExportPath);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImportPath() {
		return (String)eGet(NetxstudioPackage.Literals.SERVER_SETTINGS__IMPORT_PATH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportPath(String newImportPath) {
		eSet(NetxstudioPackage.Literals.SERVER_SETTINGS__IMPORT_PATH, newImportPath);
	}

} //ServerSettingsImpl
