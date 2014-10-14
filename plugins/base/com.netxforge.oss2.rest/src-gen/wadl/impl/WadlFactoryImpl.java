/**
 */
package wadl.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.Diagnostician;

import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import wadl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WadlFactoryImpl extends EFactoryImpl implements WadlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WadlFactory init() {
		try {
			WadlFactory theWadlFactory = (WadlFactory)EPackage.Registry.INSTANCE.getEFactory(WadlPackage.eNS_URI);
			if (theWadlFactory != null) {
				return theWadlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WadlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WadlFactoryImpl() {
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
			case WadlPackage.APPLICATION_TYPE: return createApplicationType();
			case WadlPackage.DOC_TYPE: return createDocType();
			case WadlPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case WadlPackage.GRAMMARS_TYPE: return createGrammarsType();
			case WadlPackage.INCLUDE_TYPE: return createIncludeType();
			case WadlPackage.LINK_TYPE: return createLinkType();
			case WadlPackage.METHOD_TYPE: return createMethodType();
			case WadlPackage.OPTION_TYPE: return createOptionType();
			case WadlPackage.PARAM_TYPE: return createParamType();
			case WadlPackage.REPRESENTATION_TYPE: return createRepresentationType();
			case WadlPackage.REQUEST_TYPE: return createRequestType();
			case WadlPackage.RESOURCES_TYPE: return createResourcesType();
			case WadlPackage.RESOURCE_TYPE: return createResourceType();
			case WadlPackage.RESOURCE_TYPE_TYPE: return createResourceTypeType();
			case WadlPackage.RESPONSE_TYPE: return createResponseType();
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
			case WadlPackage.HTTP_METHODS:
				return createHTTPMethodsFromString(eDataType, initialValue);
			case WadlPackage.PARAM_STYLE:
				return createParamStyleFromString(eDataType, initialValue);
			case WadlPackage.HTTP_METHODS_OBJECT:
				return createHTTPMethodsObjectFromString(eDataType, initialValue);
			case WadlPackage.METHOD:
				return createMethodFromString(eDataType, initialValue);
			case WadlPackage.PARAM_STYLE_OBJECT:
				return createParamStyleObjectFromString(eDataType, initialValue);
			case WadlPackage.RESOURCE_TYPE_LIST:
				return createResourceTypeListFromString(eDataType, initialValue);
			case WadlPackage.STATUS_CODE_LIST:
				return createStatusCodeListFromString(eDataType, initialValue);
			case WadlPackage.URI_LIST:
				return createUriListFromString(eDataType, initialValue);
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
			case WadlPackage.HTTP_METHODS:
				return convertHTTPMethodsToString(eDataType, instanceValue);
			case WadlPackage.PARAM_STYLE:
				return convertParamStyleToString(eDataType, instanceValue);
			case WadlPackage.HTTP_METHODS_OBJECT:
				return convertHTTPMethodsObjectToString(eDataType, instanceValue);
			case WadlPackage.METHOD:
				return convertMethodToString(eDataType, instanceValue);
			case WadlPackage.PARAM_STYLE_OBJECT:
				return convertParamStyleObjectToString(eDataType, instanceValue);
			case WadlPackage.RESOURCE_TYPE_LIST:
				return convertResourceTypeListToString(eDataType, instanceValue);
			case WadlPackage.STATUS_CODE_LIST:
				return convertStatusCodeListToString(eDataType, instanceValue);
			case WadlPackage.URI_LIST:
				return convertUriListToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationType createApplicationType() {
		ApplicationTypeImpl applicationType = new ApplicationTypeImpl();
		return applicationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocType createDocType() {
		DocTypeImpl docType = new DocTypeImpl();
		return docType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarsType createGrammarsType() {
		GrammarsTypeImpl grammarsType = new GrammarsTypeImpl();
		return grammarsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncludeType createIncludeType() {
		IncludeTypeImpl includeType = new IncludeTypeImpl();
		return includeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkType createLinkType() {
		LinkTypeImpl linkType = new LinkTypeImpl();
		return linkType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodType createMethodType() {
		MethodTypeImpl methodType = new MethodTypeImpl();
		return methodType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionType createOptionType() {
		OptionTypeImpl optionType = new OptionTypeImpl();
		return optionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParamType createParamType() {
		ParamTypeImpl paramType = new ParamTypeImpl();
		return paramType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepresentationType createRepresentationType() {
		RepresentationTypeImpl representationType = new RepresentationTypeImpl();
		return representationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequestType createRequestType() {
		RequestTypeImpl requestType = new RequestTypeImpl();
		return requestType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcesType createResourcesType() {
		ResourcesTypeImpl resourcesType = new ResourcesTypeImpl();
		return resourcesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType createResourceType() {
		ResourceTypeImpl resourceType = new ResourceTypeImpl();
		return resourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceTypeType createResourceTypeType() {
		ResourceTypeTypeImpl resourceTypeType = new ResourceTypeTypeImpl();
		return resourceTypeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponseType createResponseType() {
		ResponseTypeImpl responseType = new ResponseTypeImpl();
		return responseType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HTTPMethods createHTTPMethodsFromString(EDataType eDataType, String initialValue) {
		HTTPMethods result = HTTPMethods.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHTTPMethodsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParamStyle createParamStyleFromString(EDataType eDataType, String initialValue) {
		ParamStyle result = ParamStyle.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertParamStyleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HTTPMethods createHTTPMethodsObjectFromString(EDataType eDataType, String initialValue) {
		return createHTTPMethodsFromString(WadlPackage.Literals.HTTP_METHODS, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHTTPMethodsObjectToString(EDataType eDataType, Object instanceValue) {
		return convertHTTPMethodsToString(WadlPackage.Literals.HTTP_METHODS, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createMethodFromString(EDataType eDataType, String initialValue) {
		if (initialValue == null) return null;
		Object result = null;
		RuntimeException exception = null;
		try {
			result = createHTTPMethodsFromString(WadlPackage.Literals.HTTP_METHODS, initialValue);
			if (result != null && Diagnostician.INSTANCE.validate(eDataType, result, null, null)) {
				return result;
			}
		}
		catch (RuntimeException e) {
			exception = e;
		}
		try {
			result = XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.NMTOKEN, initialValue);
			if (result != null && Diagnostician.INSTANCE.validate(eDataType, result, null, null)) {
				return result;
			}
		}
		catch (RuntimeException e) {
			exception = e;
		}
		if (result != null || exception == null) return result;
    
		throw exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMethodToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) return null;
		if (WadlPackage.Literals.HTTP_METHODS.isInstance(instanceValue)) {
			try {
				String value = convertHTTPMethodsToString(WadlPackage.Literals.HTTP_METHODS, instanceValue);
				if (value != null) return value;
			}
			catch (Exception e) {
				// Keep trying other member types until all have failed.
			}
		}
		if (XMLTypePackage.Literals.NMTOKEN.isInstance(instanceValue)) {
			try {
				String value = XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.NMTOKEN, instanceValue);
				if (value != null) return value;
			}
			catch (Exception e) {
				// Keep trying other member types until all have failed.
			}
		}
		throw new IllegalArgumentException("Invalid value: '"+instanceValue+"' for datatype :"+eDataType.getName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParamStyle createParamStyleObjectFromString(EDataType eDataType, String initialValue) {
		return createParamStyleFromString(WadlPackage.Literals.PARAM_STYLE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertParamStyleObjectToString(EDataType eDataType, Object instanceValue) {
		return convertParamStyleToString(WadlPackage.Literals.PARAM_STYLE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<String> createResourceTypeListFromString(EDataType eDataType, String initialValue) {
		if (initialValue == null) return null;
		List<String> result = new ArrayList<String>();
		for (String item : split(initialValue)) {
			result.add((String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.ANY_URI, item));
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResourceTypeListToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) return null;
		List<?> list = (List<?>)instanceValue;
		if (list.isEmpty()) return "";
		StringBuffer result = new StringBuffer();
		for (Object item : list) {
			result.append(XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.ANY_URI, item));
			result.append(' ');
		}
		return result.substring(0, result.length() - 1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Long> createStatusCodeListFromString(EDataType eDataType, String initialValue) {
		if (initialValue == null) return null;
		List<Long> result = new ArrayList<Long>();
		for (String item : split(initialValue)) {
			result.add((Long)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.UNSIGNED_INT, item));
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStatusCodeListToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) return null;
		List<?> list = (List<?>)instanceValue;
		if (list.isEmpty()) return "";
		StringBuffer result = new StringBuffer();
		for (Object item : list) {
			result.append(XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.UNSIGNED_INT, item));
			result.append(' ');
		}
		return result.substring(0, result.length() - 1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<String> createUriListFromString(EDataType eDataType, String initialValue) {
		if (initialValue == null) return null;
		List<String> result = new ArrayList<String>();
		for (String item : split(initialValue)) {
			result.add((String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.ANY_URI, item));
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUriListToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) return null;
		List<?> list = (List<?>)instanceValue;
		if (list.isEmpty()) return "";
		StringBuffer result = new StringBuffer();
		for (Object item : list) {
			result.append(XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.ANY_URI, item));
			result.append(' ');
		}
		return result.substring(0, result.length() - 1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WadlPackage getWadlPackage() {
		return (WadlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static WadlPackage getPackage() {
		return WadlPackage.eINSTANCE;
	}

} //WadlFactoryImpl
