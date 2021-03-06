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
package com.netxforge.netxstudio.library.impl;

import com.netxforge.netxstudio.library.*;

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
public class LibraryFactoryImpl extends EFactoryImpl implements LibraryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LibraryFactory init() {
		try {
			LibraryFactory theLibraryFactory = (LibraryFactory)EPackage.Registry.INSTANCE.getEFactory(LibraryPackage.eNS_URI);
			if (theLibraryFactory != null) {
				return theLibraryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LibraryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryFactoryImpl() {
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
			case LibraryPackage.BASE_EXPRESSION_RESULT: return createBaseExpressionResult();
			case LibraryPackage.BASE_RESOURCE: return createBaseResource();
			case LibraryPackage.COMPONENT: return createComponent();
			case LibraryPackage.EQUIPMENT: return createEquipment();
			case LibraryPackage.EQUIPMENT_GROUP: return createEquipmentGroup();
			case LibraryPackage.EXPRESSION: return createExpression();
			case LibraryPackage.EXPRESSION_RESULT: return createExpressionResult();
			case LibraryPackage.FUNCTION: return createFunction();
			case LibraryPackage.LAST_EVALUATION_EXPRESSION_RESULT: return createLastEvaluationExpressionResult();
			case LibraryPackage.LIBRARY: return createLibrary();
			case LibraryPackage.NET_XRESOURCE: return createNetXResource();
			case LibraryPackage.NODE_TYPE: return createNodeType();
			case LibraryPackage.PARAMETER: return createParameter();
			case LibraryPackage.PRODUCT_INFO: return createProductInfo();
			case LibraryPackage.REFERENCE_NETWORK: return createReferenceNetwork();
			case LibraryPackage.REFERENCE_RELATIONSHIP: return createReferenceRelationship();
			case LibraryPackage.TOLERANCE: return createTolerance();
			case LibraryPackage.UNIT: return createUnit();
			case LibraryPackage.VENDOR: return createVendor();
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
			case LibraryPackage.LEVEL_KIND:
				return createLevelKindFromString(eDataType, initialValue);
			case LibraryPackage.RANGE_KIND:
				return createRangeKindFromString(eDataType, initialValue);
			case LibraryPackage.REDUNDANCY_TYPE:
				return createRedundancyTypeFromString(eDataType, initialValue);
			case LibraryPackage.STATE_TYPE:
				return createStateTypeFromString(eDataType, initialValue);
			case LibraryPackage.LEVEL_KIND_OBJECT:
				return createLevelKindObjectFromString(eDataType, initialValue);
			case LibraryPackage.RANGE_KIND_OBJECT:
				return createRangeKindObjectFromString(eDataType, initialValue);
			case LibraryPackage.REDUNDANCY_TYPE_OBJECT:
				return createRedundancyTypeObjectFromString(eDataType, initialValue);
			case LibraryPackage.STATE_TYPE_OBJECT:
				return createStateTypeObjectFromString(eDataType, initialValue);
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
			case LibraryPackage.LEVEL_KIND:
				return convertLevelKindToString(eDataType, instanceValue);
			case LibraryPackage.RANGE_KIND:
				return convertRangeKindToString(eDataType, instanceValue);
			case LibraryPackage.REDUNDANCY_TYPE:
				return convertRedundancyTypeToString(eDataType, instanceValue);
			case LibraryPackage.STATE_TYPE:
				return convertStateTypeToString(eDataType, instanceValue);
			case LibraryPackage.LEVEL_KIND_OBJECT:
				return convertLevelKindObjectToString(eDataType, instanceValue);
			case LibraryPackage.RANGE_KIND_OBJECT:
				return convertRangeKindObjectToString(eDataType, instanceValue);
			case LibraryPackage.REDUNDANCY_TYPE_OBJECT:
				return convertRedundancyTypeObjectToString(eDataType, instanceValue);
			case LibraryPackage.STATE_TYPE_OBJECT:
				return convertStateTypeObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseExpressionResult createBaseExpressionResult() {
		BaseExpressionResultImpl baseExpressionResult = new BaseExpressionResultImpl();
		return baseExpressionResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseResource createBaseResource() {
		BaseResourceImpl baseResource = new BaseResourceImpl();
		return baseResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component createComponent() {
		ComponentImpl component = new ComponentImpl();
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equipment createEquipment() {
		EquipmentImpl equipment = new EquipmentImpl();
		return equipment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquipmentGroup createEquipmentGroup() {
		EquipmentGroupImpl equipmentGroup = new EquipmentGroupImpl();
		return equipmentGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression createExpression() {
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionResult createExpressionResult() {
		ExpressionResultImpl expressionResult = new ExpressionResultImpl();
		return expressionResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function createFunction() {
		FunctionImpl function = new FunctionImpl();
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LastEvaluationExpressionResult createLastEvaluationExpressionResult() {
		LastEvaluationExpressionResultImpl lastEvaluationExpressionResult = new LastEvaluationExpressionResultImpl();
		return lastEvaluationExpressionResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Library createLibrary() {
		LibraryImpl library = new LibraryImpl();
		return library;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetXResource createNetXResource() {
		NetXResourceImpl netXResource = new NetXResourceImpl();
		return netXResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType createNodeType() {
		NodeTypeImpl nodeType = new NodeTypeImpl();
		return nodeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProductInfo createProductInfo() {
		ProductInfoImpl productInfo = new ProductInfoImpl();
		return productInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceNetwork createReferenceNetwork() {
		ReferenceNetworkImpl referenceNetwork = new ReferenceNetworkImpl();
		return referenceNetwork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceRelationship createReferenceRelationship() {
		ReferenceRelationshipImpl referenceRelationship = new ReferenceRelationshipImpl();
		return referenceRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tolerance createTolerance() {
		ToleranceImpl tolerance = new ToleranceImpl();
		return tolerance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit createUnit() {
		UnitImpl unit = new UnitImpl();
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vendor createVendor() {
		VendorImpl vendor = new VendorImpl();
		return vendor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LevelKind createLevelKindFromString(EDataType eDataType, String initialValue) {
		LevelKind result = LevelKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLevelKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeKind createRangeKindFromString(EDataType eDataType, String initialValue) {
		RangeKind result = RangeKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRangeKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedundancyType createRedundancyTypeFromString(EDataType eDataType, String initialValue) {
		RedundancyType result = RedundancyType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRedundancyTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateType createStateTypeFromString(EDataType eDataType, String initialValue) {
		StateType result = StateType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStateTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LevelKind createLevelKindObjectFromString(EDataType eDataType, String initialValue) {
		return createLevelKindFromString(LibraryPackage.Literals.LEVEL_KIND, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLevelKindObjectToString(EDataType eDataType, Object instanceValue) {
		return convertLevelKindToString(LibraryPackage.Literals.LEVEL_KIND, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeKind createRangeKindObjectFromString(EDataType eDataType, String initialValue) {
		return createRangeKindFromString(LibraryPackage.Literals.RANGE_KIND, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRangeKindObjectToString(EDataType eDataType, Object instanceValue) {
		return convertRangeKindToString(LibraryPackage.Literals.RANGE_KIND, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedundancyType createRedundancyTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createRedundancyTypeFromString(LibraryPackage.Literals.REDUNDANCY_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRedundancyTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertRedundancyTypeToString(LibraryPackage.Literals.REDUNDANCY_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateType createStateTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createStateTypeFromString(LibraryPackage.Literals.STATE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStateTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertStateTypeToString(LibraryPackage.Literals.STATE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryPackage getLibraryPackage() {
		return (LibraryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LibraryPackage getPackage() {
		return LibraryPackage.eINSTANCE;
	}

} //LibraryFactoryImpl
