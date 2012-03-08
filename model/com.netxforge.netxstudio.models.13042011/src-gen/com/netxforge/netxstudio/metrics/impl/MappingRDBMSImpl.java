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
import com.netxforge.netxstudio.metrics.MappingRDBMS;
import com.netxforge.netxstudio.metrics.MetricsPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping RDBMS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingRDBMSImpl#getDatabaseType <em>Database Type</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingRDBMSImpl#getDateFormat <em>Date Format</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingRDBMSImpl#getDateTimeFormat <em>Date Time Format</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingRDBMSImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingRDBMSImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingRDBMSImpl#getTimeFormat <em>Time Format</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingRDBMSImpl#getUser <em>User</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingRDBMSImpl extends MappingImpl implements MappingRDBMS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingRDBMSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.MAPPING_RDBMS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseTypeType getDatabaseType() {
		return (DatabaseTypeType)eGet(MetricsPackage.Literals.MAPPING_RDBMS__DATABASE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatabaseType(DatabaseTypeType newDatabaseType) {
		eSet(MetricsPackage.Literals.MAPPING_RDBMS__DATABASE_TYPE, newDatabaseType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDatabaseType() {
		eUnset(MetricsPackage.Literals.MAPPING_RDBMS__DATABASE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDatabaseType() {
		return eIsSet(MetricsPackage.Literals.MAPPING_RDBMS__DATABASE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDateFormat() {
		return (String)eGet(MetricsPackage.Literals.MAPPING_RDBMS__DATE_FORMAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateFormat(String newDateFormat) {
		eSet(MetricsPackage.Literals.MAPPING_RDBMS__DATE_FORMAT, newDateFormat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDateTimeFormat() {
		return (String)eGet(MetricsPackage.Literals.MAPPING_RDBMS__DATE_TIME_FORMAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateTimeFormat(String newDateTimeFormat) {
		eSet(MetricsPackage.Literals.MAPPING_RDBMS__DATE_TIME_FORMAT, newDateTimeFormat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return (String)eGet(MetricsPackage.Literals.MAPPING_RDBMS__PASSWORD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		eSet(MetricsPackage.Literals.MAPPING_RDBMS__PASSWORD, newPassword);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQuery() {
		return (String)eGet(MetricsPackage.Literals.MAPPING_RDBMS__QUERY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuery(String newQuery) {
		eSet(MetricsPackage.Literals.MAPPING_RDBMS__QUERY, newQuery);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTimeFormat() {
		return (String)eGet(MetricsPackage.Literals.MAPPING_RDBMS__TIME_FORMAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeFormat(String newTimeFormat) {
		eSet(MetricsPackage.Literals.MAPPING_RDBMS__TIME_FORMAT, newTimeFormat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUser() {
		return (String)eGet(MetricsPackage.Literals.MAPPING_RDBMS__USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(String newUser) {
		eSet(MetricsPackage.Literals.MAPPING_RDBMS__USER, newUser);
	}

} //MappingRDBMSImpl
