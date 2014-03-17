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
package com.netxforge.netxstudio.library.util;

import com.netxforge.netxstudio.library.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see com.netxforge.netxstudio.library.LibraryPackage
 * @generated
 */
public class LibraryValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final LibraryValidator INSTANCE = new LibraryValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "com.netxforge.netxstudio.library";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return LibraryPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case LibraryPackage.BASE_EXPRESSION_RESULT:
				return validateBaseExpressionResult((BaseExpressionResult)value, diagnostics, context);
			case LibraryPackage.BASE_RESOURCE:
				return validateBaseResource((BaseResource)value, diagnostics, context);
			case LibraryPackage.COMPONENT:
				return validateComponent((Component)value, diagnostics, context);
			case LibraryPackage.EQUIPMENT:
				return validateEquipment((Equipment)value, diagnostics, context);
			case LibraryPackage.EQUIPMENT_GROUP:
				return validateEquipmentGroup((EquipmentGroup)value, diagnostics, context);
			case LibraryPackage.EXPRESSION:
				return validateExpression((Expression)value, diagnostics, context);
			case LibraryPackage.EXPRESSION_RESULT:
				return validateExpressionResult((ExpressionResult)value, diagnostics, context);
			case LibraryPackage.FUNCTION:
				return validateFunction((Function)value, diagnostics, context);
			case LibraryPackage.LAST_EVALUATION_EXPRESSION_RESULT:
				return validateLastEvaluationExpressionResult((LastEvaluationExpressionResult)value, diagnostics, context);
			case LibraryPackage.LIBRARY:
				return validateLibrary((Library)value, diagnostics, context);
			case LibraryPackage.NET_XRESOURCE:
				return validateNetXResource((NetXResource)value, diagnostics, context);
			case LibraryPackage.NODE_TYPE:
				return validateNodeType((NodeType)value, diagnostics, context);
			case LibraryPackage.PARAMETER:
				return validateParameter((Parameter)value, diagnostics, context);
			case LibraryPackage.PRODUCT_INFO:
				return validateProductInfo((ProductInfo)value, diagnostics, context);
			case LibraryPackage.REFERENCE_NETWORK:
				return validateReferenceNetwork((ReferenceNetwork)value, diagnostics, context);
			case LibraryPackage.REFERENCE_RELATIONSHIP:
				return validateReferenceRelationship((ReferenceRelationship)value, diagnostics, context);
			case LibraryPackage.TOLERANCE:
				return validateTolerance((Tolerance)value, diagnostics, context);
			case LibraryPackage.UNIT:
				return validateUnit((Unit)value, diagnostics, context);
			case LibraryPackage.VENDOR:
				return validateVendor((Vendor)value, diagnostics, context);
			case LibraryPackage.LEVEL_KIND:
				return validateLevelKind((LevelKind)value, diagnostics, context);
			case LibraryPackage.RANGE_KIND:
				return validateRangeKind((RangeKind)value, diagnostics, context);
			case LibraryPackage.REDUNDANCY_TYPE:
				return validateRedundancyType((RedundancyType)value, diagnostics, context);
			case LibraryPackage.STATE_TYPE:
				return validateStateType((StateType)value, diagnostics, context);
			case LibraryPackage.LEVEL_KIND_OBJECT:
				return validateLevelKindObject((LevelKind)value, diagnostics, context);
			case LibraryPackage.RANGE_KIND_OBJECT:
				return validateRangeKindObject((RangeKind)value, diagnostics, context);
			case LibraryPackage.REDUNDANCY_TYPE_OBJECT:
				return validateRedundancyTypeObject((RedundancyType)value, diagnostics, context);
			case LibraryPackage.STATE_TYPE_OBJECT:
				return validateStateTypeObject((StateType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBaseExpressionResult(BaseExpressionResult baseExpressionResult, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(baseExpressionResult, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBaseResource(BaseResource baseResource, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(baseResource, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponent(Component component, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(component, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEquipment(Equipment equipment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(equipment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEquipmentGroup(EquipmentGroup equipmentGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(equipmentGroup, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpression(Expression expression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionResult(ExpressionResult expressionResult, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expressionResult, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(function, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(function, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunction_ValidFunctionName(function, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the ValidFunctionName constraint of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String FUNCTION__VALID_FUNCTION_NAME__EEXPRESSION = "\n" +
		"\t\t\t\tnot self.functionName.oclIsUndefined()\n" +
		"\t\t\t";

	/**
	 * Validates the ValidFunctionName constraint of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction_ValidFunctionName(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(LibraryPackage.Literals.FUNCTION,
				 function,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "ValidFunctionName",
				 FUNCTION__VALID_FUNCTION_NAME__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLastEvaluationExpressionResult(LastEvaluationExpressionResult lastEvaluationExpressionResult, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(lastEvaluationExpressionResult, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLibrary(Library library, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(library, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNetXResource(NetXResource netXResource, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(netXResource, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNodeType(NodeType nodeType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(nodeType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(nodeType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(nodeType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(nodeType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(nodeType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(nodeType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(nodeType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(nodeType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(nodeType, diagnostics, context);
		if (result || diagnostics != null) result &= validateNodeType_ValidNodeID(nodeType, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the ValidNodeID constraint of '<em>Node Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String NODE_TYPE__VALID_NODE_ID__EEXPRESSION = "\n" +
		"\t\t\t\tnot self.nodeID.oclIsUndefined()\n" +
		"\t\t\t";

	/**
	 * Validates the ValidNodeID constraint of '<em>Node Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNodeType_ValidNodeID(NodeType nodeType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(LibraryPackage.Literals.NODE_TYPE,
				 nodeType,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "ValidNodeID",
				 NODE_TYPE__VALID_NODE_ID__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProductInfo(ProductInfo productInfo, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(productInfo, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceNetwork(ReferenceNetwork referenceNetwork, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(referenceNetwork, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceRelationship(ReferenceRelationship referenceRelationship, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(referenceRelationship, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTolerance(Tolerance tolerance, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(tolerance, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnit(Unit unit, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(unit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVendor(Vendor vendor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(vendor, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLevelKind(LevelKind levelKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeKind(RangeKind rangeKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRedundancyType(RedundancyType redundancyType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateType(StateType stateType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLevelKindObject(LevelKind levelKindObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRangeKindObject(RangeKind rangeKindObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRedundancyTypeObject(RedundancyType redundancyTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateTypeObject(StateType stateTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //LibraryValidator
