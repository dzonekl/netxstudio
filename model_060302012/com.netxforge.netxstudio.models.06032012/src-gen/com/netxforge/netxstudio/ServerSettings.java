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
package com.netxforge.netxstudio;

import org.eclipse.emf.cdo.CDOObject;

import com.netxforge.netxstudio.generics.ExpansionDurationSetting;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Server Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Contains Settings on the server
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.ServerSettings#getExpansionDurationSettings <em>Expansion Duration Settings</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.ServerSettings#getExportPath <em>Export Path</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.ServerSettings#getImportPath <em>Import Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.NetxstudioPackage#getServerSettings()
 * @model extendedMetaData="name='ServerSettings' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface ServerSettings extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Expansion Duration Settings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expansion Duration Settings</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expansion Duration Settings</em>' containment reference.
	 * @see #setExpansionDurationSettings(ExpansionDurationSetting)
	 * @see com.netxforge.netxstudio.NetxstudioPackage#getServerSettings_ExpansionDurationSettings()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ExpansionDurationSettings'"
	 * @generated
	 */
	ExpansionDurationSetting getExpansionDurationSettings();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.ServerSettings#getExpansionDurationSettings <em>Expansion Duration Settings</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expansion Duration Settings</em>' containment reference.
	 * @see #getExpansionDurationSettings()
	 * @generated
	 */
	void setExpansionDurationSettings(ExpansionDurationSetting value);

	/**
	 * Returns the value of the '<em><b>Export Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export Path</em>' attribute.
	 * @see #setExportPath(String)
	 * @see com.netxforge.netxstudio.NetxstudioPackage#getServerSettings_ExportPath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ExportPath'"
	 * @generated
	 */
	String getExportPath();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.ServerSettings#getExportPath <em>Export Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Export Path</em>' attribute.
	 * @see #getExportPath()
	 * @generated
	 */
	void setExportPath(String value);

	/**
	 * Returns the value of the '<em><b>Import Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Path</em>' attribute.
	 * @see #setImportPath(String)
	 * @see com.netxforge.netxstudio.NetxstudioPackage#getServerSettings_ImportPath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ImportPath'"
	 * @generated
	 */
	String getImportPath();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.ServerSettings#getImportPath <em>Import Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import Path</em>' attribute.
	 * @see #getImportPath()
	 * @generated
	 */
	void setImportPath(String value);

} // ServerSettings
