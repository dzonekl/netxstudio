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
package com.netxforge.netxstudio.metrics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping RDBMS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points
 * 				for mapping an DB to the NetXStudio model.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getDatabaseType <em>Database Type</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getPassword <em>Password</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getQuery <em>Query</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getSID <em>SID</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getURL <em>URL</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getUser <em>User</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingRDBMS()
 * @model extendedMetaData="name='MappingRDBMS' kind='elementOnly'"
 * @generated
 */
public interface MappingRDBMS extends Mapping {

	/**
	 * Returns the value of the '<em><b>Database Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.metrics.DatabaseTypeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The database type.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Database Type</em>' attribute.
	 * @see com.netxforge.netxstudio.metrics.DatabaseTypeType
	 * @see #isSetDatabaseType()
	 * @see #unsetDatabaseType()
	 * @see #setDatabaseType(DatabaseTypeType)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingRDBMS_DatabaseType()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='DatabaseType'"
	 * @generated
	 */
	DatabaseTypeType getDatabaseType();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getDatabaseType <em>Database Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Database Type</em>' attribute.
	 * @see com.netxforge.netxstudio.metrics.DatabaseTypeType
	 * @see #isSetDatabaseType()
	 * @see #unsetDatabaseType()
	 * @see #getDatabaseType()
	 * @generated
	 */
	void setDatabaseType(DatabaseTypeType value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getDatabaseType <em>Database Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDatabaseType()
	 * @see #getDatabaseType()
	 * @see #setDatabaseType(DatabaseTypeType)
	 * @generated
	 */
	void unsetDatabaseType();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getDatabaseType <em>Database Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Database Type</em>' attribute is set.
	 * @see #unsetDatabaseType()
	 * @see #getDatabaseType()
	 * @see #setDatabaseType(DatabaseTypeType)
	 * @generated
	 */
	boolean isSetDatabaseType();

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The password.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingRDBMS_Password()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Password'"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query to execute.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Query</em>' attribute.
	 * @see #setQuery(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingRDBMS_Query()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Query'"
	 * @generated
	 */
	String getQuery();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getQuery <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' attribute.
	 * @see #getQuery()
	 * @generated
	 */
	void setQuery(String value);

	/**
	 * Returns the value of the '<em><b>SID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The database name.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>SID</em>' attribute.
	 * @see #setSID(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingRDBMS_SID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='SID'"
	 * @generated
	 */
	String getSID();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getSID <em>SID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SID</em>' attribute.
	 * @see #getSID()
	 * @generated
	 */
	void setSID(String value);

	/**
	 * Returns the value of the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The url to the database.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>URL</em>' attribute.
	 * @see #setURL(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingRDBMS_URL()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='URL'"
	 * @generated
	 */
	String getURL();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getURL <em>URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URL</em>' attribute.
	 * @see #getURL()
	 * @generated
	 */
	void setURL(String value);

	/**
	 * Returns the value of the '<em><b>User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The user name.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>User</em>' attribute.
	 * @see #setUser(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingRDBMS_User()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='User'"
	 * @generated
	 */
	String getUser();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getUser <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' attribute.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(String value);
} // MappingRDBMS
