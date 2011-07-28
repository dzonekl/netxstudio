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
package com.netxforge.netxstudio.generics.util;

import com.netxforge.netxstudio.generics.*;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;

import com.netxforge.netxstudio.generics.ActionType;
import com.netxforge.netxstudio.generics.Base;
import com.netxforge.netxstudio.generics.CommitLogEntry;
import com.netxforge.netxstudio.generics.Company;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.DiagramInfo;
import com.netxforge.netxstudio.generics.DiagramKindType;
import com.netxforge.netxstudio.generics.ExpansionDuration;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.generics.Meta;
import com.netxforge.netxstudio.generics.MultiImage;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.generics.Value;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see com.netxforge.netxstudio.generics.GenericsPackage
 * @generated
 */
public class GenericsValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final GenericsValidator INSTANCE = new GenericsValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "com.netxforge.netxstudio.generics";

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
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMLTypeValidator xmlTypeValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericsValidator() {
		super();
		xmlTypeValidator = XMLTypeValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return GenericsPackage.eINSTANCE;
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
			case GenericsPackage.BASE:
				return validateBase((Base)value, diagnostics, context);
			case GenericsPackage.COMMIT_LOG_ENTRY:
				return validateCommitLogEntry((CommitLogEntry)value, diagnostics, context);
			case GenericsPackage.COMPANY:
				return validateCompany((Company)value, diagnostics, context);
			case GenericsPackage.DATE_TIME_RANGE:
				return validateDateTimeRange((DateTimeRange)value, diagnostics, context);
			case GenericsPackage.DIAGRAM_INFO:
				return validateDiagramInfo((DiagramInfo)value, diagnostics, context);
			case GenericsPackage.LIFECYCLE:
				return validateLifecycle((Lifecycle)value, diagnostics, context);
			case GenericsPackage.META:
				return validateMeta((Meta)value, diagnostics, context);
			case GenericsPackage.MULTI_IMAGE:
				return validateMultiImage((MultiImage)value, diagnostics, context);
			case GenericsPackage.PERSON:
				return validatePerson((Person)value, diagnostics, context);
			case GenericsPackage.ROLE:
				return validateRole((Role)value, diagnostics, context);
			case GenericsPackage.VALUE:
				return validateValue((Value)value, diagnostics, context);
			case GenericsPackage.ACTION_TYPE:
				return validateActionType((ActionType)value, diagnostics, context);
			case GenericsPackage.DIAGRAM_KIND_TYPE:
				return validateDiagramKindType((DiagramKindType)value, diagnostics, context);
			case GenericsPackage.EXPANSION_DURATION:
				return validateExpansionDuration((ExpansionDuration)value, diagnostics, context);
			case GenericsPackage.ACTION_TYPE_OBJECT:
				return validateActionTypeObject((ActionType)value, diagnostics, context);
			case GenericsPackage.DESCRIPTION2000:
				return validateDescription2000((String)value, diagnostics, context);
			case GenericsPackage.DIAGRAM_KIND_TYPE_OBJECT:
				return validateDiagramKindTypeObject((DiagramKindType)value, diagnostics, context);
			case GenericsPackage.EXPANSION_DURATION_OBJECT:
				return validateExpansionDurationObject((ExpansionDuration)value, diagnostics, context);
			case GenericsPackage.EXPRESSION_LINE:
				return validateExpressionLine((String)value, diagnostics, context);
			case GenericsPackage.LONG_TEXT:
				return validateLongText((String)value, diagnostics, context);
			case GenericsPackage.NAME255:
				return validateName255((String)value, diagnostics, context);
			case GenericsPackage.UNIT_CODE:
				return validateUnitCode((String)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBase(Base base, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)base, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCommitLogEntry(CommitLogEntry commitLogEntry, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)commitLogEntry, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompany(Company company, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)company, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDateTimeRange(DateTimeRange dateTimeRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)dateTimeRange, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDiagramInfo(DiagramInfo diagramInfo, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)diagramInfo, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLifecycle(Lifecycle lifecycle, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)lifecycle, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMeta(Meta meta, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)meta, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiImage(MultiImage multiImage, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)multiImage, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePerson(Person person, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)person, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRole(Role role, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)role, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValue(Value value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)value, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActionType(ActionType actionType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDiagramKindType(DiagramKindType diagramKindType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpansionDuration(ExpansionDuration expansionDuration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActionTypeObject(ActionType actionTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDescription2000(String description2000, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateDescription2000_MaxLength(description2000, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Description2000</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDescription2000_MaxLength(String description2000, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = description2000.length();
		boolean result = length <= 2000;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(GenericsPackage.Literals.DESCRIPTION2000, description2000, length, 2000, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDiagramKindTypeObject(DiagramKindType diagramKindTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpansionDurationObject(ExpansionDuration expansionDurationObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionLine(String expressionLine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateExpressionLine_MaxLength(expressionLine, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Expression Line</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionLine_MaxLength(String expressionLine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = expressionLine.length();
		boolean result = length <= 1000;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(GenericsPackage.Literals.EXPRESSION_LINE, expressionLine, length, 1000, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLongText(String longText, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateLongText_MaxLength(longText, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Long Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLongText_MaxLength(String longText, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = longText.length();
		boolean result = length <= 20000;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(GenericsPackage.Literals.LONG_TEXT, longText, length, 20000, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateName255(String name255, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateName255_MaxLength(name255, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Name255</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateName255_MaxLength(String name255, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = name255.length();
		boolean result = length <= 255;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(GenericsPackage.Literals.NAME255, name255, length, 255, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnitCode(String unitCode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateUnitCode_MaxLength(unitCode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Unit Code</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnitCode_MaxLength(String unitCode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = unitCode.length();
		boolean result = length <= 3;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(GenericsPackage.Literals.UNIT_CODE, unitCode, length, 3, diagnostics, context);
		return result;
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

} //GenericsValidator
