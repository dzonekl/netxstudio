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
package com.netxforge.netxstudio.scheduling;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Job Kinds</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * A type representing a type of Job. 
 * 			
 * <!-- end-model-doc -->
 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJobKinds()
 * @model extendedMetaData="name='JobKinds'"
 * @generated
 */
public enum JobKinds implements Enumerator {
	/**
	 * The '<em><b>Resource Monitoring</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESOURCE_MONITORING_VALUE
	 * @generated
	 * @ordered
	 */
	RESOURCE_MONITORING(0, "ResourceMonitoring", "Resource Monitoring"),

	/**
	 * The '<em><b>Service Monitoring</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SERVICE_MONITORING_VALUE
	 * @generated
	 * @ordered
	 */
	SERVICE_MONITORING(1, "ServiceMonitoring", "Service Monitoring"),

	/**
	 * The '<em><b>Metric Data Retention</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #METRIC_DATA_RETENTION_VALUE
	 * @generated
	 * @ordered
	 */
	METRIC_DATA_RETENTION(2, "MetricDataRetention", "Metric data retention");

	/**
	 * The '<em><b>Resource Monitoring</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Resource Monitoring</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESOURCE_MONITORING
	 * @model name="ResourceMonitoring" literal="Resource Monitoring"
	 * @generated
	 * @ordered
	 */
	public static final int RESOURCE_MONITORING_VALUE = 0;

	/**
	 * The '<em><b>Service Monitoring</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Service Monitoring</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SERVICE_MONITORING
	 * @model name="ServiceMonitoring" literal="Service Monitoring"
	 * @generated
	 * @ordered
	 */
	public static final int SERVICE_MONITORING_VALUE = 1;

	/**
	 * The '<em><b>Metric Data Retention</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Metric Data Retention</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #METRIC_DATA_RETENTION
	 * @model name="MetricDataRetention" literal="Metric data retention"
	 * @generated
	 * @ordered
	 */
	public static final int METRIC_DATA_RETENTION_VALUE = 2;

	/**
	 * An array of all the '<em><b>Job Kinds</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final JobKinds[] VALUES_ARRAY =
		new JobKinds[] {
			RESOURCE_MONITORING,
			SERVICE_MONITORING,
			METRIC_DATA_RETENTION,
		};

	/**
	 * A public read-only list of all the '<em><b>Job Kinds</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<JobKinds> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Job Kinds</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JobKinds get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JobKinds result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Job Kinds</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JobKinds getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JobKinds result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Job Kinds</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JobKinds get(int value) {
		switch (value) {
			case RESOURCE_MONITORING_VALUE: return RESOURCE_MONITORING;
			case SERVICE_MONITORING_VALUE: return SERVICE_MONITORING;
			case METRIC_DATA_RETENTION_VALUE: return METRIC_DATA_RETENTION;
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
	private JobKinds(int value, String name, String literal) {
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
	
} //JobKinds
