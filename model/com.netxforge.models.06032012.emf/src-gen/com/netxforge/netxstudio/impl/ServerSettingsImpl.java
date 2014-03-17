/**
 * Copyright (c) 2014 NetXForge
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

import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;

import com.netxforge.netxstudio.generics.ExpansionDurationSetting;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

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
public class ServerSettingsImpl extends MinimalEObjectImpl.Container implements ServerSettings {
	/**
	 * The cached value of the '{@link #getExpansionDurationSettings() <em>Expansion Duration Settings</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpansionDurationSettings()
	 * @generated
	 * @ordered
	 */
	protected ExpansionDurationSetting expansionDurationSettings;

	/**
	 * The default value of the '{@link #getExportPath() <em>Export Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExportPath()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPORT_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExportPath() <em>Export Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExportPath()
	 * @generated
	 * @ordered
	 */
	protected String exportPath = EXPORT_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getImportPath() <em>Import Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportPath()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPORT_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImportPath() <em>Import Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportPath()
	 * @generated
	 * @ordered
	 */
	protected String importPath = IMPORT_PATH_EDEFAULT;

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
	public ExpansionDurationSetting getExpansionDurationSettings() {
		return expansionDurationSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpansionDurationSettings(ExpansionDurationSetting newExpansionDurationSettings, NotificationChain msgs) {
		ExpansionDurationSetting oldExpansionDurationSettings = expansionDurationSettings;
		expansionDurationSettings = newExpansionDurationSettings;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetxstudioPackage.SERVER_SETTINGS__EXPANSION_DURATION_SETTINGS, oldExpansionDurationSettings, newExpansionDurationSettings);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpansionDurationSettings(ExpansionDurationSetting newExpansionDurationSettings) {
		if (newExpansionDurationSettings != expansionDurationSettings) {
			NotificationChain msgs = null;
			if (expansionDurationSettings != null)
				msgs = ((InternalEObject)expansionDurationSettings).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetxstudioPackage.SERVER_SETTINGS__EXPANSION_DURATION_SETTINGS, null, msgs);
			if (newExpansionDurationSettings != null)
				msgs = ((InternalEObject)newExpansionDurationSettings).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetxstudioPackage.SERVER_SETTINGS__EXPANSION_DURATION_SETTINGS, null, msgs);
			msgs = basicSetExpansionDurationSettings(newExpansionDurationSettings, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetxstudioPackage.SERVER_SETTINGS__EXPANSION_DURATION_SETTINGS, newExpansionDurationSettings, newExpansionDurationSettings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExportPath() {
		return exportPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExportPath(String newExportPath) {
		String oldExportPath = exportPath;
		exportPath = newExportPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetxstudioPackage.SERVER_SETTINGS__EXPORT_PATH, oldExportPath, exportPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImportPath() {
		return importPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportPath(String newImportPath) {
		String oldImportPath = importPath;
		importPath = newImportPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetxstudioPackage.SERVER_SETTINGS__IMPORT_PATH, oldImportPath, importPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NetxstudioPackage.SERVER_SETTINGS__EXPANSION_DURATION_SETTINGS:
				return basicSetExpansionDurationSettings(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NetxstudioPackage.SERVER_SETTINGS__EXPANSION_DURATION_SETTINGS:
				return getExpansionDurationSettings();
			case NetxstudioPackage.SERVER_SETTINGS__EXPORT_PATH:
				return getExportPath();
			case NetxstudioPackage.SERVER_SETTINGS__IMPORT_PATH:
				return getImportPath();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NetxstudioPackage.SERVER_SETTINGS__EXPANSION_DURATION_SETTINGS:
				setExpansionDurationSettings((ExpansionDurationSetting)newValue);
				return;
			case NetxstudioPackage.SERVER_SETTINGS__EXPORT_PATH:
				setExportPath((String)newValue);
				return;
			case NetxstudioPackage.SERVER_SETTINGS__IMPORT_PATH:
				setImportPath((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case NetxstudioPackage.SERVER_SETTINGS__EXPANSION_DURATION_SETTINGS:
				setExpansionDurationSettings((ExpansionDurationSetting)null);
				return;
			case NetxstudioPackage.SERVER_SETTINGS__EXPORT_PATH:
				setExportPath(EXPORT_PATH_EDEFAULT);
				return;
			case NetxstudioPackage.SERVER_SETTINGS__IMPORT_PATH:
				setImportPath(IMPORT_PATH_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case NetxstudioPackage.SERVER_SETTINGS__EXPANSION_DURATION_SETTINGS:
				return expansionDurationSettings != null;
			case NetxstudioPackage.SERVER_SETTINGS__EXPORT_PATH:
				return EXPORT_PATH_EDEFAULT == null ? exportPath != null : !EXPORT_PATH_EDEFAULT.equals(exportPath);
			case NetxstudioPackage.SERVER_SETTINGS__IMPORT_PATH:
				return IMPORT_PATH_EDEFAULT == null ? importPath != null : !IMPORT_PATH_EDEFAULT.equals(importPath);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (exportPath: ");
		result.append(exportPath);
		result.append(", importPath: ");
		result.append(importPath);
		result.append(')');
		return result.toString();
	}

} //ServerSettingsImpl
