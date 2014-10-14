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

import com.netxforge.netxstudio.metrics.DatabaseTypeType;
import com.netxforge.netxstudio.metrics.MappingRDBMS;
import com.netxforge.netxstudio.metrics.MetricsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

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
	 * The default value of the '{@link #getDatabaseType() <em>Database Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatabaseType()
	 * @generated
	 * @ordered
	 */
	protected static final DatabaseTypeType DATABASE_TYPE_EDEFAULT = DatabaseTypeType.ORACLE;

	/**
	 * The cached value of the '{@link #getDatabaseType() <em>Database Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatabaseType()
	 * @generated
	 * @ordered
	 */
	protected DatabaseTypeType databaseType = DATABASE_TYPE_EDEFAULT;

	/**
	 * This is true if the Database Type attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean databaseTypeESet;

	/**
	 * The default value of the '{@link #getDateFormat() <em>Date Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDateFormat() <em>Date Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateFormat()
	 * @generated
	 * @ordered
	 */
	protected String dateFormat = DATE_FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDateTimeFormat() <em>Date Time Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateTimeFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_TIME_FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDateTimeFormat() <em>Date Time Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateTimeFormat()
	 * @generated
	 * @ordered
	 */
	protected String dateTimeFormat = DATE_TIME_FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getQuery() <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected static final String QUERY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected String query = QUERY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeFormat() <em>Time Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String TIME_FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeFormat() <em>Time Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeFormat()
	 * @generated
	 * @ordered
	 */
	protected String timeFormat = TIME_FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getUser() <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUser()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUser() <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUser()
	 * @generated
	 * @ordered
	 */
	protected String user = USER_EDEFAULT;

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
		return databaseType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatabaseType(DatabaseTypeType newDatabaseType) {
		DatabaseTypeType oldDatabaseType = databaseType;
		databaseType = newDatabaseType == null ? DATABASE_TYPE_EDEFAULT : newDatabaseType;
		boolean oldDatabaseTypeESet = databaseTypeESet;
		databaseTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_RDBMS__DATABASE_TYPE, oldDatabaseType, databaseType, !oldDatabaseTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDatabaseType() {
		DatabaseTypeType oldDatabaseType = databaseType;
		boolean oldDatabaseTypeESet = databaseTypeESet;
		databaseType = DATABASE_TYPE_EDEFAULT;
		databaseTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.MAPPING_RDBMS__DATABASE_TYPE, oldDatabaseType, DATABASE_TYPE_EDEFAULT, oldDatabaseTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDatabaseType() {
		return databaseTypeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDateFormat() {
		return dateFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateFormat(String newDateFormat) {
		String oldDateFormat = dateFormat;
		dateFormat = newDateFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_RDBMS__DATE_FORMAT, oldDateFormat, dateFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDateTimeFormat() {
		return dateTimeFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateTimeFormat(String newDateTimeFormat) {
		String oldDateTimeFormat = dateTimeFormat;
		dateTimeFormat = newDateTimeFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_RDBMS__DATE_TIME_FORMAT, oldDateTimeFormat, dateTimeFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_RDBMS__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuery(String newQuery) {
		String oldQuery = query;
		query = newQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_RDBMS__QUERY, oldQuery, query));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTimeFormat() {
		return timeFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeFormat(String newTimeFormat) {
		String oldTimeFormat = timeFormat;
		timeFormat = newTimeFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_RDBMS__TIME_FORMAT, oldTimeFormat, timeFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUser() {
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(String newUser) {
		String oldUser = user;
		user = newUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_RDBMS__USER, oldUser, user));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetricsPackage.MAPPING_RDBMS__DATABASE_TYPE:
				return getDatabaseType();
			case MetricsPackage.MAPPING_RDBMS__DATE_FORMAT:
				return getDateFormat();
			case MetricsPackage.MAPPING_RDBMS__DATE_TIME_FORMAT:
				return getDateTimeFormat();
			case MetricsPackage.MAPPING_RDBMS__PASSWORD:
				return getPassword();
			case MetricsPackage.MAPPING_RDBMS__QUERY:
				return getQuery();
			case MetricsPackage.MAPPING_RDBMS__TIME_FORMAT:
				return getTimeFormat();
			case MetricsPackage.MAPPING_RDBMS__USER:
				return getUser();
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
			case MetricsPackage.MAPPING_RDBMS__DATABASE_TYPE:
				setDatabaseType((DatabaseTypeType)newValue);
				return;
			case MetricsPackage.MAPPING_RDBMS__DATE_FORMAT:
				setDateFormat((String)newValue);
				return;
			case MetricsPackage.MAPPING_RDBMS__DATE_TIME_FORMAT:
				setDateTimeFormat((String)newValue);
				return;
			case MetricsPackage.MAPPING_RDBMS__PASSWORD:
				setPassword((String)newValue);
				return;
			case MetricsPackage.MAPPING_RDBMS__QUERY:
				setQuery((String)newValue);
				return;
			case MetricsPackage.MAPPING_RDBMS__TIME_FORMAT:
				setTimeFormat((String)newValue);
				return;
			case MetricsPackage.MAPPING_RDBMS__USER:
				setUser((String)newValue);
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
			case MetricsPackage.MAPPING_RDBMS__DATABASE_TYPE:
				unsetDatabaseType();
				return;
			case MetricsPackage.MAPPING_RDBMS__DATE_FORMAT:
				setDateFormat(DATE_FORMAT_EDEFAULT);
				return;
			case MetricsPackage.MAPPING_RDBMS__DATE_TIME_FORMAT:
				setDateTimeFormat(DATE_TIME_FORMAT_EDEFAULT);
				return;
			case MetricsPackage.MAPPING_RDBMS__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case MetricsPackage.MAPPING_RDBMS__QUERY:
				setQuery(QUERY_EDEFAULT);
				return;
			case MetricsPackage.MAPPING_RDBMS__TIME_FORMAT:
				setTimeFormat(TIME_FORMAT_EDEFAULT);
				return;
			case MetricsPackage.MAPPING_RDBMS__USER:
				setUser(USER_EDEFAULT);
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
			case MetricsPackage.MAPPING_RDBMS__DATABASE_TYPE:
				return isSetDatabaseType();
			case MetricsPackage.MAPPING_RDBMS__DATE_FORMAT:
				return DATE_FORMAT_EDEFAULT == null ? dateFormat != null : !DATE_FORMAT_EDEFAULT.equals(dateFormat);
			case MetricsPackage.MAPPING_RDBMS__DATE_TIME_FORMAT:
				return DATE_TIME_FORMAT_EDEFAULT == null ? dateTimeFormat != null : !DATE_TIME_FORMAT_EDEFAULT.equals(dateTimeFormat);
			case MetricsPackage.MAPPING_RDBMS__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case MetricsPackage.MAPPING_RDBMS__QUERY:
				return QUERY_EDEFAULT == null ? query != null : !QUERY_EDEFAULT.equals(query);
			case MetricsPackage.MAPPING_RDBMS__TIME_FORMAT:
				return TIME_FORMAT_EDEFAULT == null ? timeFormat != null : !TIME_FORMAT_EDEFAULT.equals(timeFormat);
			case MetricsPackage.MAPPING_RDBMS__USER:
				return USER_EDEFAULT == null ? user != null : !USER_EDEFAULT.equals(user);
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
		result.append(" (databaseType: ");
		if (databaseTypeESet) result.append(databaseType); else result.append("<unset>");
		result.append(", dateFormat: ");
		result.append(dateFormat);
		result.append(", dateTimeFormat: ");
		result.append(dateTimeFormat);
		result.append(", password: ");
		result.append(password);
		result.append(", query: ");
		result.append(query);
		result.append(", timeFormat: ");
		result.append(timeFormat);
		result.append(", user: ");
		result.append(user);
		result.append(')');
		return result.toString();
	}

} //MappingRDBMSImpl
