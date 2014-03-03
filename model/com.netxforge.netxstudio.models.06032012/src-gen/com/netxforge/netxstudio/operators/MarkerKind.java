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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Marker Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * A type representing the kinds of possible markers
 * 				which could apply on a resource value
 * 			
 * <!-- end-model-doc -->
 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getMarkerKind()
 * @model extendedMetaData="name='MarkerKind'"
 * @generated
 */
public enum MarkerKind implements Enumerator {
	/**
	 * The '<em><b>Value</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUE_VALUE
	 * @generated
	 * @ordered
	 */
	VALUE(0, "value", "value"),

	/**
	 * The '<em><b>INTERNALEVENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTERNALEVENT_VALUE
	 * @generated
	 * @ordered
	 */
	INTERNALEVENT(1, "INTERNALEVENT", "INTERNAL_EVENT"),

	/**
	 * The '<em><b>EXTERNALEVENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXTERNALEVENT_VALUE
	 * @generated
	 * @ordered
	 */
	EXTERNALEVENT(2, "EXTERNALEVENT", "EXTERNAL_EVENT"),

	/**
	 * The '<em><b>ACTIONNEEDED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIONNEEDED_VALUE
	 * @generated
	 * @ordered
	 */
	ACTIONNEEDED(3, "ACTIONNEEDED", "ACTION_NEEDED"),

	/**
	 * The '<em><b>TOLERANCECROSSED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOLERANCECROSSED_VALUE
	 * @generated
	 * @ordered
	 */
	TOLERANCECROSSED(4, "TOLERANCECROSSED", "TOLERANCE_CROSSED");

	/**
	 * The '<em><b>Value</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Value</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VALUE
	 * @model name="value"
	 * @generated
	 * @ordered
	 */
	public static final int VALUE_VALUE = 0;

	/**
	 * The '<em><b>INTERNALEVENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INTERNALEVENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTERNALEVENT
	 * @model literal="INTERNAL_EVENT"
	 * @generated
	 * @ordered
	 */
	public static final int INTERNALEVENT_VALUE = 1;

	/**
	 * The '<em><b>EXTERNALEVENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXTERNALEVENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXTERNALEVENT
	 * @model literal="EXTERNAL_EVENT"
	 * @generated
	 * @ordered
	 */
	public static final int EXTERNALEVENT_VALUE = 2;

	/**
	 * The '<em><b>ACTIONNEEDED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACTIONNEEDED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTIONNEEDED
	 * @model literal="ACTION_NEEDED"
	 * @generated
	 * @ordered
	 */
	public static final int ACTIONNEEDED_VALUE = 3;

	/**
	 * The '<em><b>TOLERANCECROSSED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TOLERANCECROSSED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOLERANCECROSSED
	 * @model literal="TOLERANCE_CROSSED"
	 * @generated
	 * @ordered
	 */
	public static final int TOLERANCECROSSED_VALUE = 4;

	/**
	 * An array of all the '<em><b>Marker Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MarkerKind[] VALUES_ARRAY =
		new MarkerKind[] {
			VALUE,
			INTERNALEVENT,
			EXTERNALEVENT,
			ACTIONNEEDED,
			TOLERANCECROSSED,
		};

	/**
	 * A public read-only list of all the '<em><b>Marker Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MarkerKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Marker Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MarkerKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MarkerKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Marker Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MarkerKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MarkerKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Marker Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MarkerKind get(int value) {
		switch (value) {
			case VALUE_VALUE: return VALUE;
			case INTERNALEVENT_VALUE: return INTERNALEVENT;
			case EXTERNALEVENT_VALUE: return EXTERNALEVENT;
			case ACTIONNEEDED_VALUE: return ACTIONNEEDED;
			case TOLERANCECROSSED_VALUE: return TOLERANCECROSSED;
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
	private MarkerKind(int value, String name, String literal) {
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
	
} //MarkerKind
