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

import com.netxforge.netxstudio.generics.Meta;

import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricSource;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The Library is a container for most types. Types
 * 				can copy from the Library or reference from the Library.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.Library#getFunctions <em>Functions</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Library#getNodeTypes <em>Node Types</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Library#getEquipments <em>Equipments</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Library#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Library#getMetricSources <em>Metric Sources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Library#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Library#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Library#getTolerances <em>Tolerances</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Library#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Library#getUnits <em>Units</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Library#getVersion <em>Version</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Library#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getLibrary()
 * @model extendedMetaData="name='Library' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface Library extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Functions reference, contains 0 or more
	 * 						Function type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getLibrary_Functions()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Functions'"
	 * @generated
	 */
	EList<Function> getFunctions();

	/**
	 * Returns the value of the '<em><b>Node Types</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.NodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The NodeTypes reference, contains 0 or more
	 * 						NodeType type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Node Types</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getLibrary_NodeTypes()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='NodeTypes'"
	 * @generated
	 */
	EList<NodeType> getNodeTypes();

	/**
	 * Returns the value of the '<em><b>Equipments</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Equipment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Equipments reference, contains 0 or more
	 * 						Equipment type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipments</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getLibrary_Equipments()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Equipments'"
	 * @generated
	 */
	EList<Equipment> getEquipments();

	/**
	 * Returns the value of the '<em><b>Metrics</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.metrics.Metric}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Metrics reference, contains 0 or more Metric
	 * 						type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metrics</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getLibrary_Metrics()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Metrics'"
	 * @generated
	 */
	EList<Metric> getMetrics();

	/**
	 * Returns the value of the '<em><b>Metric Sources</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.metrics.MetricSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The MetricSources reference, contains 0 or more
	 * 						MetricSource type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metric Sources</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getLibrary_MetricSources()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='MetricSources'"
	 * @generated
	 */
	EList<MetricSource> getMetricSources();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Parameters reference, contains 0 or more
	 * 						Parameter type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getLibrary_Parameters()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Parameters'"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Protocols</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Protocols reference, contains 0 or more
	 * 						Protocol type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protocols</em>' attribute list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getLibrary_Protocols()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='Protocols'"
	 * @generated
	 */
	EList<String> getProtocols();

	/**
	 * Returns the value of the '<em><b>Tolerances</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Tolerance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Tolerance reference, contains 0 or more
	 * 						Tolerance type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tolerances</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getLibrary_Tolerances()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Tolerances'"
	 * @generated
	 */
	EList<Tolerance> getTolerances();

	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Expressions reference, contains 0 or more
	 * 						Expression type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getLibrary_Expressions()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Expressions'"
	 * @generated
	 */
	EList<Expression> getExpressions();

	/**
	 * Returns the value of the '<em><b>Units</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Unit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Units reference, contains 0 or more Unit
	 * 						type.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Units</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getLibrary_Units()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Units'"
	 * @generated
	 */
	EList<Unit> getUnits();

	/**
	 * Returns the value of the '<em><b>Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Versions reference, contains 0 or more Meta
	 * 						types.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Version</em>' containment reference.
	 * @see #setVersion(Meta)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getLibrary_Version()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Version'"
	 * @generated
	 */
	Meta getVersion();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Library#getVersion <em>Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' containment reference.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(Meta value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"Library name"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute holds the name of the Library.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getLibrary_Name()
	 * @model default="Library name" unsettable="true" dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Library#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.library.Library#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.library.Library#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	boolean isSetName();

} // Library
