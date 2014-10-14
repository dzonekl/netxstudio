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
package com.netxforge.netxstudio.generics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information point
 * 				Diagram.
 * 				It consists of a location (Where the diagram is stored), and
 * 				the type
 * 				of diagram.
 * 				Diagrams can be attached to various objects, to
 * 				visual the object relations.
 * 
 * 				The Diagram model is expected to be a
 * 				Notation model, which refers
 * 				to the NetXStudio model.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.generics.DiagramInfo#getDiagramKind <em>Diagram Kind</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.DiagramInfo#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.generics.GenericsPackage#getDiagramInfo()
 * @model extendedMetaData="name='DiagramInfo' kind='empty'"
 * @generated
 */
public interface DiagramInfo extends Base {
	/**
	 * Returns the value of the '<em><b>Diagram Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.generics.DiagramKindType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The DiagramKind attribute holds a reference to
	 * 							the
	 * 							kind of diagram, to open the correct editor.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Diagram Kind</em>' attribute.
	 * @see com.netxforge.netxstudio.generics.DiagramKindType
	 * @see #isSetDiagramKind()
	 * @see #unsetDiagramKind()
	 * @see #setDiagramKind(DiagramKindType)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getDiagramInfo_DiagramKind()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='DiagramKind'"
	 * @generated
	 */
	DiagramKindType getDiagramKind();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.DiagramInfo#getDiagramKind <em>Diagram Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram Kind</em>' attribute.
	 * @see com.netxforge.netxstudio.generics.DiagramKindType
	 * @see #isSetDiagramKind()
	 * @see #unsetDiagramKind()
	 * @see #getDiagramKind()
	 * @generated
	 */
	void setDiagramKind(DiagramKindType value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.generics.DiagramInfo#getDiagramKind <em>Diagram Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDiagramKind()
	 * @see #getDiagramKind()
	 * @see #setDiagramKind(DiagramKindType)
	 * @generated
	 */
	void unsetDiagramKind();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.generics.DiagramInfo#getDiagramKind <em>Diagram Kind</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Diagram Kind</em>' attribute is set.
	 * @see #unsetDiagramKind()
	 * @see #getDiagramKind()
	 * @see #setDiagramKind(DiagramKindType)
	 * @generated
	 */
	boolean isSetDiagramKind();

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Location attribute holds a reference to the
	 * 							location where the diagram is stored.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getDiagramInfo_Location()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='Location'"
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.DiagramInfo#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

} // DiagramInfo
