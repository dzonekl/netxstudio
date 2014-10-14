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
package com.netxforge.netxstudio.metrics.impl;

import com.netxforge.netxstudio.metrics.MappingExternal;
import com.netxforge.netxstudio.metrics.MetricsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping External</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingExternalImpl#getClassURI <em>Class URI</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingExternalImpl#getPluginID <em>Plugin ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingExternalImpl extends MappingImpl implements MappingExternal {
	/**
	 * The default value of the '{@link #getClassURI() <em>Class URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassURI()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassURI() <em>Class URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassURI()
	 * @generated
	 * @ordered
	 */
	protected String classURI = CLASS_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getPluginID() <em>Plugin ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluginID()
	 * @generated
	 * @ordered
	 */
	protected static final String PLUGIN_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPluginID() <em>Plugin ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluginID()
	 * @generated
	 * @ordered
	 */
	protected String pluginID = PLUGIN_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingExternalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.MAPPING_EXTERNAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassURI() {
		return classURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassURI(String newClassURI) {
		String oldClassURI = classURI;
		classURI = newClassURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_EXTERNAL__CLASS_URI, oldClassURI, classURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPluginID() {
		return pluginID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPluginID(String newPluginID) {
		String oldPluginID = pluginID;
		pluginID = newPluginID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_EXTERNAL__PLUGIN_ID, oldPluginID, pluginID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetricsPackage.MAPPING_EXTERNAL__CLASS_URI:
				return getClassURI();
			case MetricsPackage.MAPPING_EXTERNAL__PLUGIN_ID:
				return getPluginID();
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
			case MetricsPackage.MAPPING_EXTERNAL__CLASS_URI:
				setClassURI((String)newValue);
				return;
			case MetricsPackage.MAPPING_EXTERNAL__PLUGIN_ID:
				setPluginID((String)newValue);
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
			case MetricsPackage.MAPPING_EXTERNAL__CLASS_URI:
				setClassURI(CLASS_URI_EDEFAULT);
				return;
			case MetricsPackage.MAPPING_EXTERNAL__PLUGIN_ID:
				setPluginID(PLUGIN_ID_EDEFAULT);
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
			case MetricsPackage.MAPPING_EXTERNAL__CLASS_URI:
				return CLASS_URI_EDEFAULT == null ? classURI != null : !CLASS_URI_EDEFAULT.equals(classURI);
			case MetricsPackage.MAPPING_EXTERNAL__PLUGIN_ID:
				return PLUGIN_ID_EDEFAULT == null ? pluginID != null : !PLUGIN_ID_EDEFAULT.equals(pluginID);
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
		result.append(" (classURI: ");
		result.append(classURI);
		result.append(", pluginID: ");
		result.append(pluginID);
		result.append(')');
		return result.toString();
	}

} //MappingExternalImpl
