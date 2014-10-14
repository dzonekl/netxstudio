/**
 */
package wadl.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;

import wadl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see wadl.WadlPackage
 * @generated
 */
public class WadlValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final WadlValidator INSTANCE = new WadlValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "wadl";

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
	public WadlValidator() {
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
	  return WadlPackage.eINSTANCE;
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
			case WadlPackage.APPLICATION_TYPE:
				return validateApplicationType((ApplicationType)value, diagnostics, context);
			case WadlPackage.DOC_TYPE:
				return validateDocType((DocType)value, diagnostics, context);
			case WadlPackage.DOCUMENT_ROOT:
				return validateDocumentRoot((DocumentRoot)value, diagnostics, context);
			case WadlPackage.GRAMMARS_TYPE:
				return validateGrammarsType((GrammarsType)value, diagnostics, context);
			case WadlPackage.INCLUDE_TYPE:
				return validateIncludeType((IncludeType)value, diagnostics, context);
			case WadlPackage.LINK_TYPE:
				return validateLinkType((LinkType)value, diagnostics, context);
			case WadlPackage.METHOD_TYPE:
				return validateMethodType((MethodType)value, diagnostics, context);
			case WadlPackage.OPTION_TYPE:
				return validateOptionType((OptionType)value, diagnostics, context);
			case WadlPackage.PARAM_TYPE:
				return validateParamType((ParamType)value, diagnostics, context);
			case WadlPackage.REPRESENTATION_TYPE:
				return validateRepresentationType((RepresentationType)value, diagnostics, context);
			case WadlPackage.REQUEST_TYPE:
				return validateRequestType((RequestType)value, diagnostics, context);
			case WadlPackage.RESOURCES_TYPE:
				return validateResourcesType((ResourcesType)value, diagnostics, context);
			case WadlPackage.RESOURCE_TYPE:
				return validateResourceType((ResourceType)value, diagnostics, context);
			case WadlPackage.RESOURCE_TYPE_TYPE:
				return validateResourceTypeType((ResourceTypeType)value, diagnostics, context);
			case WadlPackage.RESPONSE_TYPE:
				return validateResponseType((ResponseType)value, diagnostics, context);
			case WadlPackage.HTTP_METHODS:
				return validateHTTPMethods((HTTPMethods)value, diagnostics, context);
			case WadlPackage.PARAM_STYLE:
				return validateParamStyle((ParamStyle)value, diagnostics, context);
			case WadlPackage.HTTP_METHODS_OBJECT:
				return validateHTTPMethodsObject((HTTPMethods)value, diagnostics, context);
			case WadlPackage.METHOD:
				return validateMethod(value, diagnostics, context);
			case WadlPackage.PARAM_STYLE_OBJECT:
				return validateParamStyleObject((ParamStyle)value, diagnostics, context);
			case WadlPackage.RESOURCE_TYPE_LIST:
				return validateResourceTypeList((List<?>)value, diagnostics, context);
			case WadlPackage.STATUS_CODE_LIST:
				return validateStatusCodeList((List<?>)value, diagnostics, context);
			case WadlPackage.URI_LIST:
				return validateUriList((List<?>)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateApplicationType(ApplicationType applicationType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(applicationType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDocType(DocType docType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(docType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDocumentRoot(DocumentRoot documentRoot, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(documentRoot, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGrammarsType(GrammarsType grammarsType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(grammarsType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIncludeType(IncludeType includeType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(includeType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkType(LinkType linkType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(linkType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMethodType(MethodType methodType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(methodType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOptionType(OptionType optionType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(optionType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParamType(ParamType paramType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(paramType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRepresentationType(RepresentationType representationType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(representationType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequestType(RequestType requestType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(requestType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourcesType(ResourcesType resourcesType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(resourcesType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceType(ResourceType resourceType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(resourceType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceTypeType(ResourceTypeType resourceTypeType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(resourceTypeType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResponseType(ResponseType responseType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(responseType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHTTPMethods(HTTPMethods httpMethods, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParamStyle(ParamStyle paramStyle, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHTTPMethodsObject(HTTPMethods httpMethodsObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMethod(Object method, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateMethod_MemberTypes(method, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MemberTypes constraint of '<em>Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMethod_MemberTypes(Object method, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (diagnostics != null) {
			BasicDiagnostic tempDiagnostics = new BasicDiagnostic();
			if (WadlPackage.Literals.HTTP_METHODS.isInstance(method)) {
				if (validateHTTPMethods((HTTPMethods)method, tempDiagnostics, context)) return true;
			}
			if (XMLTypePackage.Literals.NMTOKEN.isInstance(method)) {
				if (xmlTypeValidator.validateNMTOKEN((String)method, tempDiagnostics, context)) return true;
			}
			for (Diagnostic diagnostic : tempDiagnostics.getChildren()) {
				diagnostics.add(diagnostic);
			}
		}
		else {
			if (WadlPackage.Literals.HTTP_METHODS.isInstance(method)) {
				if (validateHTTPMethods((HTTPMethods)method, null, context)) return true;
			}
			if (XMLTypePackage.Literals.NMTOKEN.isInstance(method)) {
				if (xmlTypeValidator.validateNMTOKEN((String)method, null, context)) return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParamStyleObject(ParamStyle paramStyleObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceTypeList(List<?> resourceTypeList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateResourceTypeList_ItemType(resourceTypeList, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ItemType constraint of '<em>Resource Type List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResourceTypeList_ItemType(List<?> resourceTypeList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (Iterator<?> i = resourceTypeList.iterator(); i.hasNext() && (result || diagnostics != null); ) {
			Object item = i.next();
			if (XMLTypePackage.Literals.ANY_URI.isInstance(item)) {
				result &= xmlTypeValidator.validateAnyURI((String)item, diagnostics, context);
			}
			else {
				result = false;
				reportDataValueTypeViolation(XMLTypePackage.Literals.ANY_URI, item, diagnostics, context);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStatusCodeList(List<?> statusCodeList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateStatusCodeList_ItemType(statusCodeList, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ItemType constraint of '<em>Status Code List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStatusCodeList_ItemType(List<?> statusCodeList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (Iterator<?> i = statusCodeList.iterator(); i.hasNext() && (result || diagnostics != null); ) {
			Object item = i.next();
			if (XMLTypePackage.Literals.UNSIGNED_INT.isInstance(item)) {
				result &= xmlTypeValidator.validateUnsignedInt((Long)item, diagnostics, context);
			}
			else {
				result = false;
				reportDataValueTypeViolation(XMLTypePackage.Literals.UNSIGNED_INT, item, diagnostics, context);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUriList(List<?> uriList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateUriList_ItemType(uriList, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ItemType constraint of '<em>Uri List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUriList_ItemType(List<?> uriList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (Iterator<?> i = uriList.iterator(); i.hasNext() && (result || diagnostics != null); ) {
			Object item = i.next();
			if (XMLTypePackage.Literals.ANY_URI.isInstance(item)) {
				result &= xmlTypeValidator.validateAnyURI((String)item, diagnostics, context);
			}
			else {
				result = false;
				reportDataValueTypeViolation(XMLTypePackage.Literals.ANY_URI, item, diagnostics, context);
			}
		}
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

} //WadlValidator
