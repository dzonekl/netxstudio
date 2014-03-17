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
package com.netxforge.netxstudio.operators.impl;

import com.netxforge.netxstudio.operators.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperatorsFactoryImpl extends EFactoryImpl implements OperatorsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OperatorsFactory init() {
		try {
			OperatorsFactory theOperatorsFactory = (OperatorsFactory)EPackage.Registry.INSTANCE.getEFactory(OperatorsPackage.eNS_URI);
			if (theOperatorsFactory != null) {
				return theOperatorsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OperatorsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OperatorsPackage.EQUIPMENT_RELATIONSHIP: return createEquipmentRelationship();
			case OperatorsPackage.FUNCTION_RELATIONSHIP: return createFunctionRelationship();
			case OperatorsPackage.MARKER: return createMarker();
			case OperatorsPackage.NETWORK: return createNetwork();
			case OperatorsPackage.NODE: return createNode();
			case OperatorsPackage.OPERATOR: return createOperator();
			case OperatorsPackage.RELATIONSHIP: return createRelationship();
			case OperatorsPackage.RESOURCE_EXPANSION: return createResourceExpansion();
			case OperatorsPackage.RESOURCE_FORECAST: return createResourceForecast();
			case OperatorsPackage.RESOURCE_MONITOR: return createResourceMonitor();
			case OperatorsPackage.TOLERANCE_MARKER: return createToleranceMarker();
			case OperatorsPackage.WAREHOUSE: return createWarehouse();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case OperatorsPackage.MARKER_KIND:
				return createMarkerKindFromString(eDataType, initialValue);
			case OperatorsPackage.TOLERANCE_MARKER_DIRECTION_KIND:
				return createToleranceMarkerDirectionKindFromString(eDataType, initialValue);
			case OperatorsPackage.MARKER_KIND_OBJECT:
				return createMarkerKindObjectFromString(eDataType, initialValue);
			case OperatorsPackage.TOLERANCE_MARKER_DIRECTION_KIND_OBJECT:
				return createToleranceMarkerDirectionKindObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case OperatorsPackage.MARKER_KIND:
				return convertMarkerKindToString(eDataType, instanceValue);
			case OperatorsPackage.TOLERANCE_MARKER_DIRECTION_KIND:
				return convertToleranceMarkerDirectionKindToString(eDataType, instanceValue);
			case OperatorsPackage.MARKER_KIND_OBJECT:
				return convertMarkerKindObjectToString(eDataType, instanceValue);
			case OperatorsPackage.TOLERANCE_MARKER_DIRECTION_KIND_OBJECT:
				return convertToleranceMarkerDirectionKindObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquipmentRelationship createEquipmentRelationship() {
		EquipmentRelationshipImpl equipmentRelationship = new EquipmentRelationshipImpl();
		return equipmentRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionRelationship createFunctionRelationship() {
		FunctionRelationshipImpl functionRelationship = new FunctionRelationshipImpl();
		return functionRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Marker createMarker() {
		MarkerImpl marker = new MarkerImpl();
		return marker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Network createNetwork() {
		NetworkImpl network = new NetworkImpl();
		return network;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator createOperator() {
		OperatorImpl operator = new OperatorImpl();
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relationship createRelationship() {
		RelationshipImpl relationship = new RelationshipImpl();
		return relationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceExpansion createResourceExpansion() {
		ResourceExpansionImpl resourceExpansion = new ResourceExpansionImpl();
		return resourceExpansion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceForecast createResourceForecast() {
		ResourceForecastImpl resourceForecast = new ResourceForecastImpl();
		return resourceForecast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceMonitor createResourceMonitor() {
		ResourceMonitorImpl resourceMonitor = new ResourceMonitorImpl();
		return resourceMonitor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToleranceMarker createToleranceMarker() {
		ToleranceMarkerImpl toleranceMarker = new ToleranceMarkerImpl();
		return toleranceMarker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Warehouse createWarehouse() {
		WarehouseImpl warehouse = new WarehouseImpl();
		return warehouse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkerKind createMarkerKindFromString(EDataType eDataType, String initialValue) {
		MarkerKind result = MarkerKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMarkerKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToleranceMarkerDirectionKind createToleranceMarkerDirectionKindFromString(EDataType eDataType, String initialValue) {
		ToleranceMarkerDirectionKind result = ToleranceMarkerDirectionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToleranceMarkerDirectionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkerKind createMarkerKindObjectFromString(EDataType eDataType, String initialValue) {
		return createMarkerKindFromString(OperatorsPackage.Literals.MARKER_KIND, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMarkerKindObjectToString(EDataType eDataType, Object instanceValue) {
		return convertMarkerKindToString(OperatorsPackage.Literals.MARKER_KIND, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToleranceMarkerDirectionKind createToleranceMarkerDirectionKindObjectFromString(EDataType eDataType, String initialValue) {
		return createToleranceMarkerDirectionKindFromString(OperatorsPackage.Literals.TOLERANCE_MARKER_DIRECTION_KIND, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToleranceMarkerDirectionKindObjectToString(EDataType eDataType, Object instanceValue) {
		return convertToleranceMarkerDirectionKindToString(OperatorsPackage.Literals.TOLERANCE_MARKER_DIRECTION_KIND, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorsPackage getOperatorsPackage() {
		return (OperatorsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OperatorsPackage getPackage() {
		return OperatorsPackage.eINSTANCE;
	}

} //OperatorsFactoryImpl
