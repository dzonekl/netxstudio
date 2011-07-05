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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Range Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.netxforge.netxstudio.library.LibraryPackage#getRangeKind()
 * @model extendedMetaData="name='RangeKind'"
 * @generated
 */
public enum RangeKind implements Enumerator {
	/**
	 * The '<em><b>METRIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #METRIC_VALUE
	 * @generated
	 * @ordered
	 */
	METRIC(0, "METRIC", "METRIC"), /**
	 * The '<em><b>METRICREMOVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #METRICREMOVE_VALUE
	 * @generated
	 * @ordered
	 */
	METRICREMOVE(1, "METRICREMOVE", "METRIC_REMOVE"), /**
	 * The '<em><b>CAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CAP_VALUE
	 * @generated
	 * @ordered
	 */
	CAP(2, "CAP", "CAP"),

	/**
	 * The '<em><b>FORECAST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORECAST_VALUE
	 * @generated
	 * @ordered
	 */
	FORECAST(3, "FORECAST", "FORECAST"),

	/**
	 * The '<em><b>FORECASTCAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORECASTCAP_VALUE
	 * @generated
	 * @ordered
	 */
	FORECASTCAP(4, "FORECASTCAP", "FORECAST_CAP"),

	/**
	 * The '<em><b>TRENDED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRENDED_VALUE
	 * @generated
	 * @ordered
	 */
	TRENDED(5, "TRENDED", "TRENDED"),

	/**
	 * The '<em><b>UTILIZATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UTILIZATION_VALUE
	 * @generated
	 * @ordered
	 */
	UTILIZATION(6, "UTILIZATION", "UTILIZATION"), /**
	 * The '<em><b>TOLERANCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOLERANCE_VALUE
	 * @generated
	 * @ordered
	 */
	TOLERANCE(7, "TOLERANCE", "TOLERANCE");

	/**
	 * The '<em><b>METRIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>METRIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #METRIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int METRIC_VALUE = 0;

	/**
	 * The '<em><b>METRICREMOVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>METRICREMOVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #METRICREMOVE
	 * @model literal="METRIC_REMOVE"
	 * @generated
	 * @ordered
	 */
	public static final int METRICREMOVE_VALUE = 1;

	/**
	 * The '<em><b>CAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CAP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CAP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CAP_VALUE = 2;

	/**
	 * The '<em><b>FORECAST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FORECAST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FORECAST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FORECAST_VALUE = 3;

	/**
	 * The '<em><b>FORECASTCAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FORECASTCAP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FORECASTCAP
	 * @model literal="FORECAST_CAP"
	 * @generated
	 * @ordered
	 */
	public static final int FORECASTCAP_VALUE = 4;

	/**
	 * The '<em><b>TRENDED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRENDED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRENDED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRENDED_VALUE = 5;

	/**
	 * The '<em><b>UTILIZATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UTILIZATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UTILIZATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UTILIZATION_VALUE = 6;

	/**
	 * The '<em><b>TOLERANCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TOLERANCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOLERANCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TOLERANCE_VALUE = 7;

	/**
	 * An array of all the '<em><b>Range Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RangeKind[] VALUES_ARRAY =
		new RangeKind[] {
			METRIC,
			METRICREMOVE,
			CAP,
			FORECAST,
			FORECASTCAP,
			TRENDED,
			UTILIZATION,
			TOLERANCE,
		};

	/**
	 * A public read-only list of all the '<em><b>Range Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RangeKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Range Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RangeKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RangeKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Range Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RangeKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RangeKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Range Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RangeKind get(int value) {
		switch (value) {
			case METRIC_VALUE: return METRIC;
			case METRICREMOVE_VALUE: return METRICREMOVE;
			case CAP_VALUE: return CAP;
			case FORECAST_VALUE: return FORECAST;
			case FORECASTCAP_VALUE: return FORECASTCAP;
			case TRENDED_VALUE: return TRENDED;
			case UTILIZATION_VALUE: return UTILIZATION;
			case TOLERANCE_VALUE: return TOLERANCE;
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
	private RangeKind(int value, String name, String literal) {
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
	
} //RangeKind
