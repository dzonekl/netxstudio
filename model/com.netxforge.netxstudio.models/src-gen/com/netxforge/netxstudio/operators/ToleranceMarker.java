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
package com.netxforge.netxstudio.operators;

import com.netxforge.netxstudio.library.LevelKind;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tolerance Marker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A marker which specifically marks tolerance
 * 				treshold crossings.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.ToleranceMarker#getDirection <em>Direction</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.ToleranceMarker#getLevel <em>Level</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getToleranceMarker()
 * @model extendedMetaData="name='ToleranceMarker' kind='elementOnly'"
 * @generated
 */
public interface ToleranceMarker extends Marker {
	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.operators.ToleranceMarkerDirectionKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In which direction the marker is crossed,
	 * 							up or down.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see com.netxforge.netxstudio.operators.ToleranceMarkerDirectionKind
	 * @see #isSetDirection()
	 * @see #unsetDirection()
	 * @see #setDirection(ToleranceMarkerDirectionKind)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getToleranceMarker_Direction()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='Direction'"
	 * @generated
	 */
	ToleranceMarkerDirectionKind getDirection();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.ToleranceMarker#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see com.netxforge.netxstudio.operators.ToleranceMarkerDirectionKind
	 * @see #isSetDirection()
	 * @see #unsetDirection()
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(ToleranceMarkerDirectionKind value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.operators.ToleranceMarker#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDirection()
	 * @see #getDirection()
	 * @see #setDirection(ToleranceMarkerDirectionKind)
	 * @generated
	 */
	void unsetDirection();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.operators.ToleranceMarker#getDirection <em>Direction</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Direction</em>' attribute is set.
	 * @see #unsetDirection()
	 * @see #getDirection()
	 * @see #setDirection(ToleranceMarkerDirectionKind)
	 * @generated
	 */
	boolean isSetDirection();

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.library.LevelKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The level of the treshold which is crossed.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see com.netxforge.netxstudio.library.LevelKind
	 * @see #isSetLevel()
	 * @see #unsetLevel()
	 * @see #setLevel(LevelKind)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getToleranceMarker_Level()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='Level'"
	 * @generated
	 */
	LevelKind getLevel();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.ToleranceMarker#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see com.netxforge.netxstudio.library.LevelKind
	 * @see #isSetLevel()
	 * @see #unsetLevel()
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(LevelKind value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.operators.ToleranceMarker#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLevel()
	 * @see #getLevel()
	 * @see #setLevel(LevelKind)
	 * @generated
	 */
	void unsetLevel();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.operators.ToleranceMarker#getLevel <em>Level</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Level</em>' attribute is set.
	 * @see #unsetLevel()
	 * @see #getLevel()
	 * @see #setLevel(LevelKind)
	 * @generated
	 */
	boolean isSetLevel();

} // ToleranceMarker
