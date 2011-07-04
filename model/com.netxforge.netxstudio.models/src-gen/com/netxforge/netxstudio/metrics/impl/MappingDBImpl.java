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
package com.netxforge.netxstudio.metrics.impl;

import com.netxforge.netxstudio.metrics.DatabaseTypeType;
import com.netxforge.netxstudio.metrics.MappingDB;
import com.netxforge.netxstudio.metrics.MetricsPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping DB</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingDBImpl#getDatabaseType <em>Database Type</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingDBImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingDBImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingDBImpl#getSID <em>SID</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingDBImpl#getURL <em>URL</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingDBImpl#getUser <em>User</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingDBImpl extends MappingImpl implements MappingDB {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingDBImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.MAPPING_DB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseTypeType getDatabaseType() {
		return (DatabaseTypeType)eGet(MetricsPackage.Literals.MAPPING_DB__DATABASE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatabaseType(DatabaseTypeType newDatabaseType) {
		eSet(MetricsPackage.Literals.MAPPING_DB__DATABASE_TYPE, newDatabaseType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDatabaseType() {
		eUnset(MetricsPackage.Literals.MAPPING_DB__DATABASE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDatabaseType() {
		return eIsSet(MetricsPackage.Literals.MAPPING_DB__DATABASE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return (String)eGet(MetricsPackage.Literals.MAPPING_DB__PASSWORD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		eSet(MetricsPackage.Literals.MAPPING_DB__PASSWORD, newPassword);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQuery() {
		return (String)eGet(MetricsPackage.Literals.MAPPING_DB__QUERY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuery(String newQuery) {
		eSet(MetricsPackage.Literals.MAPPING_DB__QUERY, newQuery);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSID() {
		return (String)eGet(MetricsPackage.Literals.MAPPING_DB__SID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSID(String newSID) {
		eSet(MetricsPackage.Literals.MAPPING_DB__SID, newSID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getURL() {
		return (String)eGet(MetricsPackage.Literals.MAPPING_DB__URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setURL(String newURL) {
		eSet(MetricsPackage.Literals.MAPPING_DB__URL, newURL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUser() {
		return (String)eGet(MetricsPackage.Literals.MAPPING_DB__USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(String newUser) {
		eSet(MetricsPackage.Literals.MAPPING_DB__USER, newUser);
	}

} //MappingDBImpl
