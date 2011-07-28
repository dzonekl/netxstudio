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

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.Base;
import com.netxforge.netxstudio.library.NetXResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Monitor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a resource monitoring run. The
 * 				resources in the Nodes will contain the monitoring values,
 * 				this
 * 				object however holds the time markers which result from the
 * 				monitoring.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.ResourceMonitor#getMarkers <em>Markers</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.ResourceMonitor#getNodeRef <em>Node Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.ResourceMonitor#getResourceRef <em>Resource Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.ResourceMonitor#getEnd <em>End</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.ResourceMonitor#getStart <em>Start</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getResourceMonitor()
 * @model extendedMetaData="name='ResourceMonitor' kind='elementOnly'"
 * @generated
 */
public interface ResourceMonitor extends Base {
	/**
	 * Returns the value of the '<em><b>Markers</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.operators.Marker}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Markers reference, contains 0 or more
	 * 								Marker
	 * 								types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Markers</em>' containment reference list.
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getResourceMonitor_Markers()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Markers'"
	 * @generated
	 */
	EList<Marker> getMarkers();

	/**
	 * Returns the value of the '<em><b>Node Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Node reference, references 1 Node
	 * 								type.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Node Ref</em>' reference.
	 * @see #setNodeRef(Node)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getResourceMonitor_NodeRef()
	 * @model extendedMetaData="kind='element' name='NodeRef'"
	 * @generated
	 */
	Node getNodeRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.ResourceMonitor#getNodeRef <em>Node Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Ref</em>' reference.
	 * @see #getNodeRef()
	 * @generated
	 */
	void setNodeRef(Node value);

	/**
	 * Returns the value of the '<em><b>Resource Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Resource reference, references 1
	 * 								Resource type.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resource Ref</em>' reference.
	 * @see #setResourceRef(NetXResource)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getResourceMonitor_ResourceRef()
	 * @model extendedMetaData="kind='element' name='ResourceRef'"
	 * @generated
	 */
	NetXResource getResourceRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.ResourceMonitor#getResourceRef <em>Resource Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Ref</em>' reference.
	 * @see #getResourceRef()
	 * @generated
	 */
	void setResourceRef(NetXResource value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The end of the period for this resource monitor.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getResourceMonitor_End()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='End'"
	 * @generated
	 */
	XMLGregorianCalendar getEnd();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.ResourceMonitor#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The start of the period for this resource monitor.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#getResourceMonitor_Start()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='Start'"
	 * @generated
	 */
	XMLGregorianCalendar getStart();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.operators.ResourceMonitor#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(XMLGregorianCalendar value);

} // ResourceMonitor
