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
 * A representation of the model object '<em><b>Mapping Record XLS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A specialized type representing the information
 * 				points of a XLS mapping record.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingRecordXLS#getColumn <em>Column</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingRecordXLS#getRow <em>Row</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingRecordXLS()
 * @model extendedMetaData="name='MappingRecordXLS' kind='empty'"
 * @generated
 */
public interface MappingRecordXLS extends MappingRecord {
	/**
	 * Returns the value of the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Column attribute holds the column number.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Column</em>' attribute.
	 * @see #isSetColumn()
	 * @see #unsetColumn()
	 * @see #setColumn(int)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingRecordXLS_Column()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='Column'"
	 * @generated
	 */
	int getColumn();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingRecordXLS#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' attribute.
	 * @see #isSetColumn()
	 * @see #unsetColumn()
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(int value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.MappingRecordXLS#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetColumn()
	 * @see #getColumn()
	 * @see #setColumn(int)
	 * @generated
	 */
	void unsetColumn();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.MappingRecordXLS#getColumn <em>Column</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Column</em>' attribute is set.
	 * @see #unsetColumn()
	 * @see #getColumn()
	 * @see #setColumn(int)
	 * @generated
	 */
	boolean isSetColumn();

	/**
	 * Returns the value of the '<em><b>Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Row attribute holds the row number.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Row</em>' attribute.
	 * @see #isSetRow()
	 * @see #unsetRow()
	 * @see #setRow(int)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingRecordXLS_Row()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='Row'"
	 * @generated
	 */
	int getRow();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingRecordXLS#getRow <em>Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Row</em>' attribute.
	 * @see #isSetRow()
	 * @see #unsetRow()
	 * @see #getRow()
	 * @generated
	 */
	void setRow(int value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.MappingRecordXLS#getRow <em>Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRow()
	 * @see #getRow()
	 * @see #setRow(int)
	 * @generated
	 */
	void unsetRow();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.MappingRecordXLS#getRow <em>Row</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Row</em>' attribute is set.
	 * @see #unsetRow()
	 * @see #getRow()
	 * @see #setRow(int)
	 * @generated
	 */
	boolean isSetRow();

} // MappingRecordXLS
