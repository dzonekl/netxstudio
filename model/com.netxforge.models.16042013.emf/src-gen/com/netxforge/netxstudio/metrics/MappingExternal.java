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
package com.netxforge.netxstudio.metrics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping External</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points
 * 				for mapping definitions which can be found in an external plugin. 
 * 				The Mapping service interacts with the external plugin through a 
 * 				defined API (IMappingExternal)
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingExternal#getClassURI <em>Class URI</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingExternal#getPluginID <em>Plugin ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingExternal()
 * @model extendedMetaData="name='MappingExternal' kind='elementOnly'"
 * @generated
 */
public interface MappingExternal extends Mapping {
	/**
	 * Returns the value of the '<em><b>Class URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The URI leading to the implementation of IMappingExternal.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class URI</em>' attribute.
	 * @see #setClassURI(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingExternal_ClassURI()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='ClassURI'"
	 * @generated
	 */
	String getClassURI();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingExternal#getClassURI <em>Class URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class URI</em>' attribute.
	 * @see #getClassURI()
	 * @generated
	 */
	void setClassURI(String value);

	/**
	 * Returns the value of the '<em><b>Plugin ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ID of the contributing plugin.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Plugin ID</em>' attribute.
	 * @see #setPluginID(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingExternal_PluginID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PluginID'"
	 * @generated
	 */
	String getPluginID();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingExternal#getPluginID <em>Plugin ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin ID</em>' attribute.
	 * @see #getPluginID()
	 * @generated
	 */
	void setPluginID(String value);

} // MappingExternal
