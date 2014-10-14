/**
 */
package wadl;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link wadl.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link wadl.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link wadl.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link wadl.DocumentRoot#getApplication <em>Application</em>}</li>
 *   <li>{@link wadl.DocumentRoot#getDoc <em>Doc</em>}</li>
 *   <li>{@link wadl.DocumentRoot#getGrammars <em>Grammars</em>}</li>
 *   <li>{@link wadl.DocumentRoot#getInclude <em>Include</em>}</li>
 *   <li>{@link wadl.DocumentRoot#getLink <em>Link</em>}</li>
 *   <li>{@link wadl.DocumentRoot#getMethod <em>Method</em>}</li>
 *   <li>{@link wadl.DocumentRoot#getOption <em>Option</em>}</li>
 *   <li>{@link wadl.DocumentRoot#getParam <em>Param</em>}</li>
 *   <li>{@link wadl.DocumentRoot#getRepresentation <em>Representation</em>}</li>
 *   <li>{@link wadl.DocumentRoot#getRequest <em>Request</em>}</li>
 *   <li>{@link wadl.DocumentRoot#getResource <em>Resource</em>}</li>
 *   <li>{@link wadl.DocumentRoot#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link wadl.DocumentRoot#getResources <em>Resources</em>}</li>
 *   <li>{@link wadl.DocumentRoot#getResponse <em>Response</em>}</li>
 * </ul>
 * </p>
 *
 * @see wadl.WadlPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see wadl.WadlPackage#getDocumentRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see wadl.WadlPackage#getDocumentRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap<String, String> getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see wadl.WadlPackage#getDocumentRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap<String, String> getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Application</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application</em>' containment reference.
	 * @see #setApplication(ApplicationType)
	 * @see wadl.WadlPackage#getDocumentRoot_Application()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='application' namespace='##targetNamespace'"
	 * @generated
	 */
	ApplicationType getApplication();

	/**
	 * Sets the value of the '{@link wadl.DocumentRoot#getApplication <em>Application</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application</em>' containment reference.
	 * @see #getApplication()
	 * @generated
	 */
	void setApplication(ApplicationType value);

	/**
	 * Returns the value of the '<em><b>Doc</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Doc</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Doc</em>' containment reference.
	 * @see #setDoc(DocType)
	 * @see wadl.WadlPackage#getDocumentRoot_Doc()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='doc' namespace='##targetNamespace'"
	 * @generated
	 */
	DocType getDoc();

	/**
	 * Sets the value of the '{@link wadl.DocumentRoot#getDoc <em>Doc</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Doc</em>' containment reference.
	 * @see #getDoc()
	 * @generated
	 */
	void setDoc(DocType value);

	/**
	 * Returns the value of the '<em><b>Grammars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grammars</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grammars</em>' containment reference.
	 * @see #setGrammars(GrammarsType)
	 * @see wadl.WadlPackage#getDocumentRoot_Grammars()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='grammars' namespace='##targetNamespace'"
	 * @generated
	 */
	GrammarsType getGrammars();

	/**
	 * Sets the value of the '{@link wadl.DocumentRoot#getGrammars <em>Grammars</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grammars</em>' containment reference.
	 * @see #getGrammars()
	 * @generated
	 */
	void setGrammars(GrammarsType value);

	/**
	 * Returns the value of the '<em><b>Include</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include</em>' containment reference.
	 * @see #setInclude(IncludeType)
	 * @see wadl.WadlPackage#getDocumentRoot_Include()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='include' namespace='##targetNamespace'"
	 * @generated
	 */
	IncludeType getInclude();

	/**
	 * Sets the value of the '{@link wadl.DocumentRoot#getInclude <em>Include</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include</em>' containment reference.
	 * @see #getInclude()
	 * @generated
	 */
	void setInclude(IncludeType value);

	/**
	 * Returns the value of the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link</em>' containment reference.
	 * @see #setLink(LinkType)
	 * @see wadl.WadlPackage#getDocumentRoot_Link()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='link' namespace='##targetNamespace'"
	 * @generated
	 */
	LinkType getLink();

	/**
	 * Sets the value of the '{@link wadl.DocumentRoot#getLink <em>Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link</em>' containment reference.
	 * @see #getLink()
	 * @generated
	 */
	void setLink(LinkType value);

	/**
	 * Returns the value of the '<em><b>Method</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' containment reference.
	 * @see #setMethod(MethodType)
	 * @see wadl.WadlPackage#getDocumentRoot_Method()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='method' namespace='##targetNamespace'"
	 * @generated
	 */
	MethodType getMethod();

	/**
	 * Sets the value of the '{@link wadl.DocumentRoot#getMethod <em>Method</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' containment reference.
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(MethodType value);

	/**
	 * Returns the value of the '<em><b>Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Option</em>' containment reference.
	 * @see #setOption(OptionType)
	 * @see wadl.WadlPackage#getDocumentRoot_Option()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='option' namespace='##targetNamespace'"
	 * @generated
	 */
	OptionType getOption();

	/**
	 * Sets the value of the '{@link wadl.DocumentRoot#getOption <em>Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Option</em>' containment reference.
	 * @see #getOption()
	 * @generated
	 */
	void setOption(OptionType value);

	/**
	 * Returns the value of the '<em><b>Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param</em>' containment reference.
	 * @see #setParam(ParamType)
	 * @see wadl.WadlPackage#getDocumentRoot_Param()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='param' namespace='##targetNamespace'"
	 * @generated
	 */
	ParamType getParam();

	/**
	 * Sets the value of the '{@link wadl.DocumentRoot#getParam <em>Param</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Param</em>' containment reference.
	 * @see #getParam()
	 * @generated
	 */
	void setParam(ParamType value);

	/**
	 * Returns the value of the '<em><b>Representation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Representation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representation</em>' containment reference.
	 * @see #setRepresentation(RepresentationType)
	 * @see wadl.WadlPackage#getDocumentRoot_Representation()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='representation' namespace='##targetNamespace'"
	 * @generated
	 */
	RepresentationType getRepresentation();

	/**
	 * Sets the value of the '{@link wadl.DocumentRoot#getRepresentation <em>Representation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Representation</em>' containment reference.
	 * @see #getRepresentation()
	 * @generated
	 */
	void setRepresentation(RepresentationType value);

	/**
	 * Returns the value of the '<em><b>Request</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Request</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Request</em>' containment reference.
	 * @see #setRequest(RequestType)
	 * @see wadl.WadlPackage#getDocumentRoot_Request()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='request' namespace='##targetNamespace'"
	 * @generated
	 */
	RequestType getRequest();

	/**
	 * Sets the value of the '{@link wadl.DocumentRoot#getRequest <em>Request</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Request</em>' containment reference.
	 * @see #getRequest()
	 * @generated
	 */
	void setRequest(RequestType value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' containment reference.
	 * @see #setResource(ResourceType)
	 * @see wadl.WadlPackage#getDocumentRoot_Resource()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='resource' namespace='##targetNamespace'"
	 * @generated
	 */
	ResourceType getResource();

	/**
	 * Sets the value of the '{@link wadl.DocumentRoot#getResource <em>Resource</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' containment reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(ResourceType value);

	/**
	 * Returns the value of the '<em><b>Resource Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Type</em>' containment reference.
	 * @see #setResourceType(ResourceTypeType)
	 * @see wadl.WadlPackage#getDocumentRoot_ResourceType()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='resource_type' namespace='##targetNamespace'"
	 * @generated
	 */
	ResourceTypeType getResourceType();

	/**
	 * Sets the value of the '{@link wadl.DocumentRoot#getResourceType <em>Resource Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Type</em>' containment reference.
	 * @see #getResourceType()
	 * @generated
	 */
	void setResourceType(ResourceTypeType value);

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference.
	 * @see #setResources(ResourcesType)
	 * @see wadl.WadlPackage#getDocumentRoot_Resources()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='resources' namespace='##targetNamespace'"
	 * @generated
	 */
	ResourcesType getResources();

	/**
	 * Sets the value of the '{@link wadl.DocumentRoot#getResources <em>Resources</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resources</em>' containment reference.
	 * @see #getResources()
	 * @generated
	 */
	void setResources(ResourcesType value);

	/**
	 * Returns the value of the '<em><b>Response</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response</em>' containment reference.
	 * @see #setResponse(ResponseType)
	 * @see wadl.WadlPackage#getDocumentRoot_Response()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='response' namespace='##targetNamespace'"
	 * @generated
	 */
	ResponseType getResponse();

	/**
	 * Sets the value of the '{@link wadl.DocumentRoot#getResponse <em>Response</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response</em>' containment reference.
	 * @see #getResponse()
	 * @generated
	 */
	void setResponse(ResponseType value);

} // DocumentRoot
