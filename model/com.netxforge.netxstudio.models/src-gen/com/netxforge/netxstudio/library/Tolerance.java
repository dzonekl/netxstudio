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
 * A representation of the model object '<em><b>Tolerance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of
 * 				a tolerance. This is also known as a threshold.
 * 				A tolerance has a
 * 				name, an expression to determine if the tolerance
 * 				is applicable and a
 * 				an Action.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.Tolerance#getExpressionRef <em>Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Tolerance#getLevel <em>Level</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Tolerance#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getTolerance()
 * @model extendedMetaData="name='Tolerance' kind='empty'"
 * @generated
 */
public interface Tolerance extends Base {
	/**
	 * Returns the value of the '<em><b>Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ExpressionRef reference, used to compute the
	 * 							tolerance.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression Ref</em>' reference.
	 * @see #setExpressionRef(Expression)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getTolerance_ExpressionRef()
	 * @model extendedMetaData="kind='attribute' name='ExpressionRef'"
	 * @generated
	 */
	Expression getExpressionRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Tolerance#getExpressionRef <em>Expression Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression Ref</em>' reference.
	 * @see #getExpressionRef()
	 * @generated
	 */
	void setExpressionRef(Expression value);

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.library.LevelType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Level attribute holds the level of this
	 * 							tolerance.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see com.netxforge.netxstudio.library.LevelType
	 * @see #isSetLevel()
	 * @see #unsetLevel()
	 * @see #setLevel(LevelType)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getTolerance_Level()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='Level'"
	 * @generated
	 */
	LevelType getLevel();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Tolerance#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see com.netxforge.netxstudio.library.LevelType
	 * @see #isSetLevel()
	 * @see #unsetLevel()
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(LevelType value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.library.Tolerance#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLevel()
	 * @see #getLevel()
	 * @see #setLevel(LevelType)
	 * @generated
	 */
	void unsetLevel();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.library.Tolerance#getLevel <em>Level</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Level</em>' attribute is set.
	 * @see #unsetLevel()
	 * @see #getLevel()
	 * @see #setLevel(LevelType)
	 * @generated
	 */
	boolean isSetLevel();

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
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getTolerance_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Tolerance#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Tolerance
