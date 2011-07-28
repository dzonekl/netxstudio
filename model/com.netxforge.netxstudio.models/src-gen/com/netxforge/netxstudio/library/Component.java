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

import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.Base;
import com.netxforge.netxstudio.generics.DiagramInfo;
import com.netxforge.netxstudio.generics.MultiImage;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.protocols.Protocol;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The base type for Equipment and Function
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.Component#getResourceRefs <em>Resource Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Component#getMetricRefs <em>Metric Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Component#getCapacityExpressionRef <em>Capacity Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Component#getUtilizationExpressionRef <em>Utilization Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Component#getRetentionExpressionRef <em>Retention Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Component#getToleranceRefs <em>Tolerance Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Component#getProtocolRefs <em>Protocol Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Component#getParameterRefs <em>Parameter Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Component#getAllResources <em>All Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Component#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Component#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Component#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.Component#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getComponent()
 * @model extendedMetaData="name='Component' kind='elementOnly'"
 * @generated
 */
public interface Component extends Base {
	/**
	 * Returns the value of the '<em><b>Resource Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.NetXResource}.
	 * It is bidirectional and its opposite is '{@link com.netxforge.netxstudio.library.NetXResource#getComponentRef <em>Component Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The EquipmentResources reference, contains 0 or
	 * 								more EquipmentResource types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resource Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getComponent_ResourceRefs()
	 * @see com.netxforge.netxstudio.library.NetXResource#getComponentRef
	 * @model opposite="componentRef"
	 *        extendedMetaData="kind='element' name='ResourceRefs'"
	 * @generated
	 */
	EList<NetXResource> getResourceRefs();

	/**
	 * Returns the value of the '<em><b>Metric Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.metrics.Metric}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The EquipmentMetricRefs reference, refers to 0
	 * 								or
	 * 								more Metric types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metric Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getComponent_MetricRefs()
	 * @model extendedMetaData="kind='element' name='MetricRefs'"
	 * @generated
	 */
	EList<Metric> getMetricRefs();

	/**
	 * Returns the value of the '<em><b>Capacity Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The CapacityExpressionRef reference, used to
	 * 								compute the capacity values for the equipment.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Capacity Expression Ref</em>' reference.
	 * @see #setCapacityExpressionRef(Expression)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getComponent_CapacityExpressionRef()
	 * @model extendedMetaData="kind='element' name='CapacityExpressionRef'"
	 * @generated
	 */
	Expression getCapacityExpressionRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Component#getCapacityExpressionRef <em>Capacity Expression Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity Expression Ref</em>' reference.
	 * @see #getCapacityExpressionRef()
	 * @generated
	 */
	void setCapacityExpressionRef(Expression value);

	/**
	 * Returns the value of the '<em><b>Utilization Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The UtilizationExpressionRef reference, used to
	 * 								compute the utilization for the equipment.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Utilization Expression Ref</em>' reference.
	 * @see #setUtilizationExpressionRef(Expression)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getComponent_UtilizationExpressionRef()
	 * @model extendedMetaData="kind='element' name='UtilizationExpressionRef'"
	 * @generated
	 */
	Expression getUtilizationExpressionRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Component#getUtilizationExpressionRef <em>Utilization Expression Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Utilization Expression Ref</em>' reference.
	 * @see #getUtilizationExpressionRef()
	 * @generated
	 */
	void setUtilizationExpressionRef(Expression value);

	/**
	 * Returns the value of the '<em><b>Retention Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The RetentionExpressionRef reference, used to
	 * 								perform the retention computation.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Retention Expression Ref</em>' reference.
	 * @see #setRetentionExpressionRef(Expression)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getComponent_RetentionExpressionRef()
	 * @model extendedMetaData="kind='element' name='RetentionExpressionRef'"
	 * @generated
	 */
	Expression getRetentionExpressionRef();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Component#getRetentionExpressionRef <em>Retention Expression Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retention Expression Ref</em>' reference.
	 * @see #getRetentionExpressionRef()
	 * @generated
	 */
	void setRetentionExpressionRef(Expression value);

	/**
	 * Returns the value of the '<em><b>Tolerance Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Tolerance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ToleranceRefs reference, refers to 0 or
	 * 								more
	 * 								Tolerance types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tolerance Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getComponent_ToleranceRefs()
	 * @model extendedMetaData="kind='element' name='ToleranceRefs'"
	 * @generated
	 */
	EList<Tolerance> getToleranceRefs();

	/**
	 * Returns the value of the '<em><b>Protocol Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.protocols.Protocol}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ProtocolRefs reference, refers to 0 or more
	 * 								Protocol types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protocol Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getComponent_ProtocolRefs()
	 * @model extendedMetaData="kind='element' name='ProtocolRefs'"
	 * @generated
	 */
	EList<Protocol> getProtocolRefs();

	/**
	 * Returns the value of the '<em><b>Parameter Refs</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ParameterRefs reference, refers to 0 or
	 * 								more
	 * 								Parameter types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameter Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getComponent_ParameterRefs()
	 * @model extendedMetaData="kind='element' name='ParameterRefs'"
	 * @generated
	 */
	EList<Parameter> getParameterRefs();

	/**
	 * Returns the value of the '<em><b>All Resources</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.NetXResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * OCL derived feature: Retrieves all resources
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>All Resources</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getComponent_AllResources()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='self->closure(equipments).resources->asOrderedSet()'"
	 *        extendedMetaData="kind='element' name='AllResources'"
	 * @generated
	 */
	EList<NetXResource> getAllResources();

	/**
	 * Returns the value of the '<em><b>Diagrams</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.generics.DiagramInfo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Diagrams reference, contains 0 or more
	 * 								DiagramInfo types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Diagrams</em>' containment reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getComponent_Diagrams()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Diagrams'"
	 * @generated
	 */
	EList<DiagramInfo> getDiagrams();

	/**
	 * Returns the value of the '<em><b>Icons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Images reference, contains 0 or one
	 * 								MultiImage type.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Icons</em>' containment reference.
	 * @see #setIcons(MultiImage)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getComponent_Icons()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Icons'"
	 * @generated
	 */
	MultiImage getIcons();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Component#getIcons <em>Icons</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icons</em>' containment reference.
	 * @see #getIcons()
	 * @generated
	 */
	void setIcons(MultiImage value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Description attribute holds the description
	 * 							of
	 * 							the equipment
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getComponent_Description()
	 * @model dataType="com.netxforge.netxstudio.generics.Description2000"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Component#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The EquipmentName attribute holds the name of
	 * 							the
	 * 							equipment when the equipment is configured in a Node type.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getComponent_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.Component#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Component
