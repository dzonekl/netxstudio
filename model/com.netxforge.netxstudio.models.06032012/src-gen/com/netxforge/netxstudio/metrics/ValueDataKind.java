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
 * A representation of the model object '<em><b>Value Data Kind</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A specialized type, for representing a value in the
 * 				mapping. The valuekind can be either a datetime or a metric.
 * 				To
 * 				ignore a column, provide the "null" type as the valuekind, for that
 * 				for that column.
 * 
 * 				Examples:
 * 				1. If the valueKind is metric, the mapping
 * 				will store the value as a
 * 				numeric value in a new Value object.
 * 				2. if
 * 				the valueKind is datetime, the mapping will store the value as a
 * 				timestamp in a new Value object
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.ValueDataKind#getMetricRef <em>Metric Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.ValueDataKind#getFormat <em>Format</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.ValueDataKind#getKindHint <em>Kind Hint</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.ValueDataKind#getValueKind <em>Value Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getValueDataKind()
 * @model extendedMetaData="name='ValueDataKind' kind='elementOnly'"
 * @generated
 */
public interface ValueDataKind extends DataKind {
	/**
	 * Returns the value of the '<em><b>Metric Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The MetricRef reference, refers to zero or one
	 * 								Metric for which this data kind applies.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metric Ref</em>' reference.
	 * @see #setMetricRef(Metric)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getValueDataKind_MetricRef()
	 * @model extendedMetaData="kind='element' name='MetricRef'"
	 * @generated
	 */
	Metric getMetricRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.ValueDataKind#getMetricRef <em>Metric Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric Ref</em>' reference.
	 * @see #getMetricRef()
	 * @generated
	 */
	void setMetricRef(Metric value);

	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Defines the format to parse the date, time or
	 * 							datetime values
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see #setFormat(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getValueDataKind_Format()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Format'"
	 * @generated
	 */
	String getFormat();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.ValueDataKind#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(String value);

	/**
	 * Returns the value of the '<em><b>Kind Hint</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.metrics.KindHintType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind Hint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind Hint</em>' attribute.
	 * @see com.netxforge.netxstudio.metrics.KindHintType
	 * @see #isSetKindHint()
	 * @see #unsetKindHint()
	 * @see #setKindHint(KindHintType)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getValueDataKind_KindHint()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='KindHint'"
	 * @generated
	 */
	KindHintType getKindHint();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.ValueDataKind#getKindHint <em>Kind Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind Hint</em>' attribute.
	 * @see com.netxforge.netxstudio.metrics.KindHintType
	 * @see #isSetKindHint()
	 * @see #unsetKindHint()
	 * @see #getKindHint()
	 * @generated
	 */
	void setKindHint(KindHintType value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.ValueDataKind#getKindHint <em>Kind Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetKindHint()
	 * @see #getKindHint()
	 * @see #setKindHint(KindHintType)
	 * @generated
	 */
	void unsetKindHint();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.ValueDataKind#getKindHint <em>Kind Hint</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Kind Hint</em>' attribute is set.
	 * @see #unsetKindHint()
	 * @see #getKindHint()
	 * @see #setKindHint(KindHintType)
	 * @generated
	 */
	boolean isSetKindHint();

	/**
	 * Returns the value of the '<em><b>Value Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.metrics.ValueKindType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ValueKind attribute holds the target value
	 * 							type we expect.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value Kind</em>' attribute.
	 * @see com.netxforge.netxstudio.metrics.ValueKindType
	 * @see #isSetValueKind()
	 * @see #unsetValueKind()
	 * @see #setValueKind(ValueKindType)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getValueDataKind_ValueKind()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='ValueKind'"
	 * @generated
	 */
	ValueKindType getValueKind();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.ValueDataKind#getValueKind <em>Value Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Kind</em>' attribute.
	 * @see com.netxforge.netxstudio.metrics.ValueKindType
	 * @see #isSetValueKind()
	 * @see #unsetValueKind()
	 * @see #getValueKind()
	 * @generated
	 */
	void setValueKind(ValueKindType value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.ValueDataKind#getValueKind <em>Value Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetValueKind()
	 * @see #getValueKind()
	 * @see #setValueKind(ValueKindType)
	 * @generated
	 */
	void unsetValueKind();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.ValueDataKind#getValueKind <em>Value Kind</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Value Kind</em>' attribute is set.
	 * @see #unsetValueKind()
	 * @see #getValueKind()
	 * @see #setValueKind(ValueKindType)
	 * @generated
	 */
	boolean isSetValueKind();

} // ValueDataKind
