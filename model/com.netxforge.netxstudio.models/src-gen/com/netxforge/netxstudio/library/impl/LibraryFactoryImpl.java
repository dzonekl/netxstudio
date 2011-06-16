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
package com.netxforge.netxstudio.library.impl;

import com.netxforge.netxstudio.library.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.EquipmentGroup;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.ExpressionResult;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LevelType;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.Parameter;
import com.netxforge.netxstudio.library.ProductInfo;
import com.netxforge.netxstudio.library.RedundancyType;
import com.netxforge.netxstudio.library.StateType;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.library.Unit;
import com.netxforge.netxstudio.library.Vendor;

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
			LibraryFactory theLibraryFactory = (LibraryFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.netxforge.com/13042011/library"); 
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
			case LibraryPackage.EQUIPMENT: return (EObject)createEquipment();
			case LibraryPackage.EQUIPMENT_GROUP: return (EObject)createEquipmentGroup();
			case LibraryPackage.EXPRESSION: return (EObject)createExpression();
			case LibraryPackage.EXPRESSION_RESULT: return (EObject)createExpressionResult();
			case LibraryPackage.FUNCTION: return (EObject)createFunction();
			case LibraryPackage.LIBRARY: return (EObject)createLibrary();
			case LibraryPackage.NET_XRESOURCE: return (EObject)createNetXResource();
			case LibraryPackage.NODE_TYPE: return (EObject)createNodeType();
			case LibraryPackage.PARAMETER: return (EObject)createParameter();
			case LibraryPackage.PRODUCT_INFO: return (EObject)createProductInfo();
			case LibraryPackage.TOLERANCE: return (EObject)createTolerance();
			case LibraryPackage.UNIT: return (EObject)createUnit();
			case LibraryPackage.VENDOR: return (EObject)createVendor();
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
			case LibraryPackage.LEVEL_TYPE:
				return createLevelTypeFromString(eDataType, initialValue);
			case LibraryPackage.REDUNDANCY_TYPE:
				return createRedundancyTypeFromString(eDataType, initialValue);
			case LibraryPackage.STATE_TYPE:
				return createStateTypeFromString(eDataType, initialValue);
			case LibraryPackage.LEVEL_TYPE_OBJECT:
				return createLevelTypeObjectFromString(eDataType, initialValue);
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
			case LibraryPackage.LEVEL_TYPE:
				return convertLevelTypeToString(eDataType, instanceValue);
			case LibraryPackage.REDUNDANCY_TYPE:
				return convertRedundancyTypeToString(eDataType, instanceValue);
			case LibraryPackage.STATE_TYPE:
				return convertStateTypeToString(eDataType, instanceValue);
			case LibraryPackage.LEVEL_TYPE_OBJECT:
				return convertLevelTypeObjectToString(eDataType, instanceValue);
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
	public LevelType createLevelTypeFromString(EDataType eDataType, String initialValue) {
		LevelType result = LevelType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLevelTypeToString(EDataType eDataType, Object instanceValue) {
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
	public LevelType createLevelTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createLevelTypeFromString(LibraryPackage.Literals.LEVEL_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLevelTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertLevelTypeToString(LibraryPackage.Literals.LEVEL_TYPE, instanceValue);
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
