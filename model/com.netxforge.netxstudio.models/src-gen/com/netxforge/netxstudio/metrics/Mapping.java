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

import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.Base;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points
 * 				for a mapping specification.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.Mapping#getHeaderMappingColumns <em>Header Mapping Columns</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.Mapping#getMappingColumns <em>Mapping Columns</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.Mapping#getFirstDataRow <em>First Data Row</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.Mapping#getHeaderRow <em>Header Row</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.Mapping#getIntervalHint <em>Interval Hint</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMapping()
 * @model extendedMetaData="name='Mapping' kind='elementOnly'"
 * @generated
 */
public interface Mapping extends Base {

	/**
	 * Returns the value of the '<em><b>Header Mapping Columns</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.metrics.MappingColumn}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header Mapping Columns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header Mapping Columns</em>' containment reference list.
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMapping_HeaderMappingColumns()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='HeaderMappingColumns'"
	 * @generated
	 */
	EList<MappingColumn> getHeaderMappingColumns();

	/**
	 * Returns the value of the '<em><b>Mapping Columns</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.metrics.MappingColumn}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Columns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Columns</em>' containment reference list.
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMapping_MappingColumns()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='MappingColumns'"
	 * @generated
	 */
	EList<MappingColumn> getMappingColumns();

	/**
	 * Returns the value of the '<em><b>First Data Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The FirstDataRow attribute holds the row number
	 * 							of the first row containing data.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>First Data Row</em>' attribute.
	 * @see #isSetFirstDataRow()
	 * @see #unsetFirstDataRow()
	 * @see #setFirstDataRow(int)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMapping_FirstDataRow()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='FirstDataRow'"
	 * @generated
	 */
	int getFirstDataRow();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.Mapping#getFirstDataRow <em>First Data Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Data Row</em>' attribute.
	 * @see #isSetFirstDataRow()
	 * @see #unsetFirstDataRow()
	 * @see #getFirstDataRow()
	 * @generated
	 */
	void setFirstDataRow(int value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.Mapping#getFirstDataRow <em>First Data Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFirstDataRow()
	 * @see #getFirstDataRow()
	 * @see #setFirstDataRow(int)
	 * @generated
	 */
	void unsetFirstDataRow();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.Mapping#getFirstDataRow <em>First Data Row</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>First Data Row</em>' attribute is set.
	 * @see #unsetFirstDataRow()
	 * @see #getFirstDataRow()
	 * @see #setFirstDataRow(int)
	 * @generated
	 */
	boolean isSetFirstDataRow();

	/**
	 * Returns the value of the '<em><b>Header Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The HeaderRow attribute holds the row number
	 * 							which contains the header.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Header Row</em>' attribute.
	 * @see #isSetHeaderRow()
	 * @see #unsetHeaderRow()
	 * @see #setHeaderRow(int)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMapping_HeaderRow()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='HeaderRow'"
	 * @generated
	 */
	int getHeaderRow();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.Mapping#getHeaderRow <em>Header Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header Row</em>' attribute.
	 * @see #isSetHeaderRow()
	 * @see #unsetHeaderRow()
	 * @see #getHeaderRow()
	 * @generated
	 */
	void setHeaderRow(int value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.Mapping#getHeaderRow <em>Header Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHeaderRow()
	 * @see #getHeaderRow()
	 * @see #setHeaderRow(int)
	 * @generated
	 */
	void unsetHeaderRow();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.Mapping#getHeaderRow <em>Header Row</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Header Row</em>' attribute is set.
	 * @see #unsetHeaderRow()
	 * @see #getHeaderRow()
	 * @see #setHeaderRow(int)
	 * @generated
	 */
	boolean isSetHeaderRow();

	/**
	 * Returns the value of the '<em><b>Interval Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The IntervalHint attribute, holds a hint for the
	 * 							metric interval between each metric value in minutes.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interval Hint</em>' attribute.
	 * @see #isSetIntervalHint()
	 * @see #unsetIntervalHint()
	 * @see #setIntervalHint(int)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMapping_IntervalHint()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='IntervalHint'"
	 * @generated
	 */
	int getIntervalHint();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.Mapping#getIntervalHint <em>Interval Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interval Hint</em>' attribute.
	 * @see #isSetIntervalHint()
	 * @see #unsetIntervalHint()
	 * @see #getIntervalHint()
	 * @generated
	 */
	void setIntervalHint(int value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.Mapping#getIntervalHint <em>Interval Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIntervalHint()
	 * @see #getIntervalHint()
	 * @see #setIntervalHint(int)
	 * @generated
	 */
	void unsetIntervalHint();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.Mapping#getIntervalHint <em>Interval Hint</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Interval Hint</em>' attribute is set.
	 * @see #unsetIntervalHint()
	 * @see #getIntervalHint()
	 * @see #setIntervalHint(int)
	 * @generated
	 */
	boolean isSetIntervalHint();
} // Mapping
