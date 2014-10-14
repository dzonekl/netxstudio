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
package com.netxforge.netxstudio.library;

import com.netxforge.netxstudio.generics.Base;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of
 * 				a parameter.
 * 				A parameter is a container for a static value. It is
 * 				used in an
 * 				Expression.
 * 
 * 				Examples:
 * 				1. A Parameter STM-1_CHANNELS with
 * 				value of 63 is a static parameter
 * 				which can be used in an Expression.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.Parameter#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Parameter#getExpressionName <em>Expression Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Parameter#isModifiable <em>Modifiable</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Parameter#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Parameter#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getParameter()
 * @model extendedMetaData="name='Parameter' kind='empty'"
 * @generated
 */
public interface Parameter extends Base {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Description attribute holds the description
	 * 							of
	 * 							the equipment
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getParameter_Description()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Parameter#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

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
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getParameter_ExpressionName()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='ExpressionName'"
	 * @generated
	 */
	String getExpressionName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Parameter#getExpressionName <em>Expression Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression Name</em>' attribute.
	 * @see #getExpressionName()
	 * @generated
	 */
	void setExpressionName(String value);

	/**
	 * Returns the value of the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Modifiable flag tells if the parameter value
	 * 							can be modified by a planner, or if it's locked.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Modifiable</em>' attribute.
	 * @see #isSetModifiable()
	 * @see #unsetModifiable()
	 * @see #setModifiable(boolean)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getParameter_Modifiable()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='Modifiable'"
	 * @generated
	 */
	boolean isModifiable();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Parameter#isModifiable <em>Modifiable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modifiable</em>' attribute.
	 * @see #isSetModifiable()
	 * @see #unsetModifiable()
	 * @see #isModifiable()
	 * @generated
	 */
	void setModifiable(boolean value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.library.Parameter#isModifiable <em>Modifiable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetModifiable()
	 * @see #isModifiable()
	 * @see #setModifiable(boolean)
	 * @generated
	 */
	void unsetModifiable();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.library.Parameter#isModifiable <em>Modifiable</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Modifiable</em>' attribute is set.
	 * @see #unsetModifiable()
	 * @see #isModifiable()
	 * @see #setModifiable(boolean)
	 * @generated
	 */
	boolean isSetModifiable();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute holds a name used for
	 * 							presentation.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getParameter_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Parameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Value attribute holds a value for the
	 * 							Parameter.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #isSetValue()
	 * @see #unsetValue()
	 * @see #setValue(double)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getParameter_Value()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='Value'"
	 * @generated
	 */
	double getValue();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Parameter#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #isSetValue()
	 * @see #unsetValue()
	 * @see #getValue()
	 * @generated
	 */
	void setValue(double value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.library.Parameter#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetValue()
	 * @see #getValue()
	 * @see #setValue(double)
	 * @generated
	 */
	void unsetValue();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.library.Parameter#getValue <em>Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Value</em>' attribute is set.
	 * @see #unsetValue()
	 * @see #getValue()
	 * @see #setValue(double)
	 * @generated
	 */
	boolean isSetValue();

} // Parameter
