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
package com.netxforge.netxstudio.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Service Flow Direction</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The service flow direction
 * 			
 * <!-- end-model-doc -->
 * @see com.netxforge.netxstudio.services.ServicesPackage#getServiceFlowDirection()
 * @model extendedMetaData="name='ServiceFlowDirection'"
 * @generated
 */
public enum ServiceFlowDirection implements Enumerator {
	/**
	 * The '<em><b>LEFTTORIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LEFTTORIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	LEFTTORIGHT(0, "LEFTTORIGHT", "LEFT_TO_RIGHT"),

	/**
	 * The '<em><b>RIGHTTOLEFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RIGHTTOLEFT_VALUE
	 * @generated
	 * @ordered
	 */
	RIGHTTOLEFT(1, "RIGHTTOLEFT", "RIGHT_TO_LEFT");

	/**
	 * The '<em><b>LEFTTORIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LEFTTORIGHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LEFTTORIGHT
	 * @model literal="LEFT_TO_RIGHT"
	 * @generated
	 * @ordered
	 */
	public static final int LEFTTORIGHT_VALUE = 0;

	/**
	 * The '<em><b>RIGHTTOLEFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RIGHTTOLEFT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RIGHTTOLEFT
	 * @model literal="RIGHT_TO_LEFT"
	 * @generated
	 * @ordered
	 */
	public static final int RIGHTTOLEFT_VALUE = 1;

	/**
	 * An array of all the '<em><b>Service Flow Direction</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ServiceFlowDirection[] VALUES_ARRAY =
		new ServiceFlowDirection[] {
			LEFTTORIGHT,
			RIGHTTOLEFT,
		};

	/**
	 * A public read-only list of all the '<em><b>Service Flow Direction</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ServiceFlowDirection> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Service Flow Direction</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ServiceFlowDirection get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServiceFlowDirection result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Service Flow Direction</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ServiceFlowDirection getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServiceFlowDirection result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Service Flow Direction</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ServiceFlowDirection get(int value) {
		switch (value) {
			case LEFTTORIGHT_VALUE: return LEFTTORIGHT;
			case RIGHTTOLEFT_VALUE: return RIGHTTOLEFT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ServiceFlowDirection(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ServiceFlowDirection
