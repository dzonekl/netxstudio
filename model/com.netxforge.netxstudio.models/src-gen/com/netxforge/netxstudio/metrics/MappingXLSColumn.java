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

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping XLS Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingXLSColumn#getDataType <em>Data Type</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingXLSColumn#getColumnHeaderName <em>Column Header Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingXLSColumn#getColumnHeaderRow <em>Column Header Row</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingXLSColumn()
 * @model extendedMetaData="name='MappingXLSColumn' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface MappingXLSColumn extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ColumnDataKind reference, contains 1 DataKind type. The DataKind is either an Identifer or a Value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Data Type</em>' containment reference.
	 * @see #setDataType(DataKind)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingXLSColumn_DataType()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='DataType'"
	 * @generated
	 */
	DataKind getDataType();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingXLSColumn#getDataType <em>Data Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' containment reference.
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(DataKind value);

	/**
	 * Returns the value of the '<em><b>Column Header Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ColumnHeaderName attribute, is a textual expected header names.
	 * Note: that if the corresponding ColumnDataKind is a Metric, the column header will be interpreted as the name of the Metric.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Column Header Name</em>' attribute.
	 * @see #setColumnHeaderName(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingXLSColumn_ColumnHeaderName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ColumnHeaderName'"
	 * @generated
	 */
	String getColumnHeaderName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingXLSColumn#getColumnHeaderName <em>Column Header Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column Header Name</em>' attribute.
	 * @see #getColumnHeaderName()
	 * @generated
	 */
	void setColumnHeaderName(String value);

	/**
	 * Returns the value of the '<em><b>Column Header Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ColumnHeaderRow attributes overrides (per column) the row number of the expected header row. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Column Header Row</em>' attribute.
	 * @see #isSetColumnHeaderRow()
	 * @see #unsetColumnHeaderRow()
	 * @see #setColumnHeaderRow(int)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingXLSColumn_ColumnHeaderRow()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='ColumnHeaderRow'"
	 * @generated
	 */
	int getColumnHeaderRow();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingXLSColumn#getColumnHeaderRow <em>Column Header Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column Header Row</em>' attribute.
	 * @see #isSetColumnHeaderRow()
	 * @see #unsetColumnHeaderRow()
	 * @see #getColumnHeaderRow()
	 * @generated
	 */
	void setColumnHeaderRow(int value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.MappingXLSColumn#getColumnHeaderRow <em>Column Header Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetColumnHeaderRow()
	 * @see #getColumnHeaderRow()
	 * @see #setColumnHeaderRow(int)
	 * @generated
	 */
	void unsetColumnHeaderRow();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.MappingXLSColumn#getColumnHeaderRow <em>Column Header Row</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Column Header Row</em>' attribute is set.
	 * @see #unsetColumnHeaderRow()
	 * @see #getColumnHeaderRow()
	 * @see #setColumnHeaderRow(int)
	 * @generated
	 */
	boolean isSetColumnHeaderRow();

} // MappingXLSColumn
