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
package com.netxforge.netxstudio.library;

import com.netxforge.netxstudio.generics.Base;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.BaseResource#isDetailDisplay <em>Detail Display</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.BaseResource#getExpressionName <em>Expression Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.BaseResource#getLongName <em>Long Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.BaseResource#getShortName <em>Short Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.BaseResource#isSummaryDisplay <em>Summary Display</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.BaseResource#getUnitRef <em>Unit Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getBaseResource()
 * @model extendedMetaData="name='BaseResource' kind='empty'"
 * @generated
 */
public interface BaseResource extends Base {
	/**
	 * Returns the value of the '<em><b>Detail Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The DetailDisplay attribute is a flag specifiy
	 * 							if
	 * 							the resource should be displayed in a detailed presentation.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Detail Display</em>' attribute.
	 * @see #isSetDetailDisplay()
	 * @see #unsetDetailDisplay()
	 * @see #setDetailDisplay(boolean)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getBaseResource_DetailDisplay()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='DetailDisplay'"
	 * @generated
	 */
	boolean isDetailDisplay();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.BaseResource#isDetailDisplay <em>Detail Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Detail Display</em>' attribute.
	 * @see #isSetDetailDisplay()
	 * @see #unsetDetailDisplay()
	 * @see #isDetailDisplay()
	 * @generated
	 */
	void setDetailDisplay(boolean value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.library.BaseResource#isDetailDisplay <em>Detail Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDetailDisplay()
	 * @see #isDetailDisplay()
	 * @see #setDetailDisplay(boolean)
	 * @generated
	 */
	void unsetDetailDisplay();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.library.BaseResource#isDetailDisplay <em>Detail Display</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Detail Display</em>' attribute is set.
	 * @see #unsetDetailDisplay()
	 * @see #isDetailDisplay()
	 * @see #setDetailDisplay(boolean)
	 * @generated
	 */
	boolean isSetDetailDisplay();

	/**
	 * Returns the value of the '<em><b>Expression Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ExpressionName attribute holds a name which
	 * 							is
	 * 							used in the expressions referencing
	 * 							the resource.
	 * 
	 * 							See: The
	 * 							NetXScript
	 * 							specification.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression Name</em>' attribute.
	 * @see #setExpressionName(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getBaseResource_ExpressionName()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='ExpressionName'"
	 * @generated
	 */
	String getExpressionName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.BaseResource#getExpressionName <em>Expression Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression Name</em>' attribute.
	 * @see #getExpressionName()
	 * @generated
	 */
	void setExpressionName(String value);

	/**
	 * Returns the value of the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The LongName attribute holds a long name which
	 * 							is
	 * 							used for presentation of the resource.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Long Name</em>' attribute.
	 * @see #setLongName(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getBaseResource_LongName()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='LongName'"
	 * @generated
	 */
	String getLongName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.BaseResource#getLongName <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Long Name</em>' attribute.
	 * @see #getLongName()
	 * @generated
	 */
	void setLongName(String value);

	/**
	 * Returns the value of the '<em><b>Short Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ShortName attribute holds a short name which
	 * 							is used for presentation of the resource.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Short Name</em>' attribute.
	 * @see #setShortName(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getBaseResource_ShortName()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='ShortName'"
	 * @generated
	 */
	String getShortName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.BaseResource#getShortName <em>Short Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Short Name</em>' attribute.
	 * @see #getShortName()
	 * @generated
	 */
	void setShortName(String value);

	/**
	 * Returns the value of the '<em><b>Summary Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The SummaryDisplay attribute is a flag specifiy
	 * 							if
	 * 							the resource should be displayed in a summary presentation.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Summary Display</em>' attribute.
	 * @see #isSetSummaryDisplay()
	 * @see #unsetSummaryDisplay()
	 * @see #setSummaryDisplay(boolean)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getBaseResource_SummaryDisplay()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='SummaryDisplay'"
	 * @generated
	 */
	boolean isSummaryDisplay();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.BaseResource#isSummaryDisplay <em>Summary Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Summary Display</em>' attribute.
	 * @see #isSetSummaryDisplay()
	 * @see #unsetSummaryDisplay()
	 * @see #isSummaryDisplay()
	 * @generated
	 */
	void setSummaryDisplay(boolean value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.library.BaseResource#isSummaryDisplay <em>Summary Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSummaryDisplay()
	 * @see #isSummaryDisplay()
	 * @see #setSummaryDisplay(boolean)
	 * @generated
	 */
	void unsetSummaryDisplay();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.library.BaseResource#isSummaryDisplay <em>Summary Display</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Summary Display</em>' attribute is set.
	 * @see #unsetSummaryDisplay()
	 * @see #isSummaryDisplay()
	 * @see #setSummaryDisplay(boolean)
	 * @generated
	 */
	boolean isSetSummaryDisplay();

	/**
	 * Returns the value of the '<em><b>Unit Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The UnitRef reference, refers to 0 or 1 Unit
	 * 							type.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unit Ref</em>' reference.
	 * @see #setUnitRef(Unit)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getBaseResource_UnitRef()
	 * @model extendedMetaData="kind='attribute' name='UnitRef'"
	 * @generated
	 */
	Unit getUnitRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.BaseResource#getUnitRef <em>Unit Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Ref</em>' reference.
	 * @see #getUnitRef()
	 * @generated
	 */
	void setUnitRef(Unit value);

} // BaseResource
