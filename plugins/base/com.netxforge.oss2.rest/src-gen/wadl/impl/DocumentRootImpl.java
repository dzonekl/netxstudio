/**
 */
package wadl.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import wadl.ApplicationType;
import wadl.DocType;
import wadl.DocumentRoot;
import wadl.GrammarsType;
import wadl.IncludeType;
import wadl.LinkType;
import wadl.MethodType;
import wadl.OptionType;
import wadl.ParamType;
import wadl.RepresentationType;
import wadl.RequestType;
import wadl.ResourceType;
import wadl.ResourceTypeType;
import wadl.ResourcesType;
import wadl.ResponseType;
import wadl.WadlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link wadl.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link wadl.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link wadl.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link wadl.impl.DocumentRootImpl#getApplication <em>Application</em>}</li>
 *   <li>{@link wadl.impl.DocumentRootImpl#getDoc <em>Doc</em>}</li>
 *   <li>{@link wadl.impl.DocumentRootImpl#getGrammars <em>Grammars</em>}</li>
 *   <li>{@link wadl.impl.DocumentRootImpl#getInclude <em>Include</em>}</li>
 *   <li>{@link wadl.impl.DocumentRootImpl#getLink <em>Link</em>}</li>
 *   <li>{@link wadl.impl.DocumentRootImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link wadl.impl.DocumentRootImpl#getOption <em>Option</em>}</li>
 *   <li>{@link wadl.impl.DocumentRootImpl#getParam <em>Param</em>}</li>
 *   <li>{@link wadl.impl.DocumentRootImpl#getRepresentation <em>Representation</em>}</li>
 *   <li>{@link wadl.impl.DocumentRootImpl#getRequest <em>Request</em>}</li>
 *   <li>{@link wadl.impl.DocumentRootImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link wadl.impl.DocumentRootImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link wadl.impl.DocumentRootImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link wadl.impl.DocumentRootImpl#getResponse <em>Response</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends MinimalEObjectImpl.Container implements DocumentRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WadlPackage.Literals.DOCUMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, WadlPackage.DOCUMENT_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, WadlPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, WadlPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationType getApplication() {
		return (ApplicationType)getMixed().get(WadlPackage.Literals.DOCUMENT_ROOT__APPLICATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetApplication(ApplicationType newApplication, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WadlPackage.Literals.DOCUMENT_ROOT__APPLICATION, newApplication, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplication(ApplicationType newApplication) {
		((FeatureMap.Internal)getMixed()).set(WadlPackage.Literals.DOCUMENT_ROOT__APPLICATION, newApplication);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocType getDoc() {
		return (DocType)getMixed().get(WadlPackage.Literals.DOCUMENT_ROOT__DOC, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDoc(DocType newDoc, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WadlPackage.Literals.DOCUMENT_ROOT__DOC, newDoc, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDoc(DocType newDoc) {
		((FeatureMap.Internal)getMixed()).set(WadlPackage.Literals.DOCUMENT_ROOT__DOC, newDoc);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarsType getGrammars() {
		return (GrammarsType)getMixed().get(WadlPackage.Literals.DOCUMENT_ROOT__GRAMMARS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGrammars(GrammarsType newGrammars, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WadlPackage.Literals.DOCUMENT_ROOT__GRAMMARS, newGrammars, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrammars(GrammarsType newGrammars) {
		((FeatureMap.Internal)getMixed()).set(WadlPackage.Literals.DOCUMENT_ROOT__GRAMMARS, newGrammars);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncludeType getInclude() {
		return (IncludeType)getMixed().get(WadlPackage.Literals.DOCUMENT_ROOT__INCLUDE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInclude(IncludeType newInclude, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WadlPackage.Literals.DOCUMENT_ROOT__INCLUDE, newInclude, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInclude(IncludeType newInclude) {
		((FeatureMap.Internal)getMixed()).set(WadlPackage.Literals.DOCUMENT_ROOT__INCLUDE, newInclude);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkType getLink() {
		return (LinkType)getMixed().get(WadlPackage.Literals.DOCUMENT_ROOT__LINK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLink(LinkType newLink, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WadlPackage.Literals.DOCUMENT_ROOT__LINK, newLink, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink(LinkType newLink) {
		((FeatureMap.Internal)getMixed()).set(WadlPackage.Literals.DOCUMENT_ROOT__LINK, newLink);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodType getMethod() {
		return (MethodType)getMixed().get(WadlPackage.Literals.DOCUMENT_ROOT__METHOD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMethod(MethodType newMethod, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WadlPackage.Literals.DOCUMENT_ROOT__METHOD, newMethod, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethod(MethodType newMethod) {
		((FeatureMap.Internal)getMixed()).set(WadlPackage.Literals.DOCUMENT_ROOT__METHOD, newMethod);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionType getOption() {
		return (OptionType)getMixed().get(WadlPackage.Literals.DOCUMENT_ROOT__OPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOption(OptionType newOption, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WadlPackage.Literals.DOCUMENT_ROOT__OPTION, newOption, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOption(OptionType newOption) {
		((FeatureMap.Internal)getMixed()).set(WadlPackage.Literals.DOCUMENT_ROOT__OPTION, newOption);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParamType getParam() {
		return (ParamType)getMixed().get(WadlPackage.Literals.DOCUMENT_ROOT__PARAM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParam(ParamType newParam, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WadlPackage.Literals.DOCUMENT_ROOT__PARAM, newParam, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParam(ParamType newParam) {
		((FeatureMap.Internal)getMixed()).set(WadlPackage.Literals.DOCUMENT_ROOT__PARAM, newParam);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepresentationType getRepresentation() {
		return (RepresentationType)getMixed().get(WadlPackage.Literals.DOCUMENT_ROOT__REPRESENTATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepresentation(RepresentationType newRepresentation, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WadlPackage.Literals.DOCUMENT_ROOT__REPRESENTATION, newRepresentation, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentation(RepresentationType newRepresentation) {
		((FeatureMap.Internal)getMixed()).set(WadlPackage.Literals.DOCUMENT_ROOT__REPRESENTATION, newRepresentation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequestType getRequest() {
		return (RequestType)getMixed().get(WadlPackage.Literals.DOCUMENT_ROOT__REQUEST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequest(RequestType newRequest, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WadlPackage.Literals.DOCUMENT_ROOT__REQUEST, newRequest, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequest(RequestType newRequest) {
		((FeatureMap.Internal)getMixed()).set(WadlPackage.Literals.DOCUMENT_ROOT__REQUEST, newRequest);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType getResource() {
		return (ResourceType)getMixed().get(WadlPackage.Literals.DOCUMENT_ROOT__RESOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResource(ResourceType newResource, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WadlPackage.Literals.DOCUMENT_ROOT__RESOURCE, newResource, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResource(ResourceType newResource) {
		((FeatureMap.Internal)getMixed()).set(WadlPackage.Literals.DOCUMENT_ROOT__RESOURCE, newResource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceTypeType getResourceType() {
		return (ResourceTypeType)getMixed().get(WadlPackage.Literals.DOCUMENT_ROOT__RESOURCE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceType(ResourceTypeType newResourceType, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WadlPackage.Literals.DOCUMENT_ROOT__RESOURCE_TYPE, newResourceType, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceType(ResourceTypeType newResourceType) {
		((FeatureMap.Internal)getMixed()).set(WadlPackage.Literals.DOCUMENT_ROOT__RESOURCE_TYPE, newResourceType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcesType getResources() {
		return (ResourcesType)getMixed().get(WadlPackage.Literals.DOCUMENT_ROOT__RESOURCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResources(ResourcesType newResources, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WadlPackage.Literals.DOCUMENT_ROOT__RESOURCES, newResources, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResources(ResourcesType newResources) {
		((FeatureMap.Internal)getMixed()).set(WadlPackage.Literals.DOCUMENT_ROOT__RESOURCES, newResources);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponseType getResponse() {
		return (ResponseType)getMixed().get(WadlPackage.Literals.DOCUMENT_ROOT__RESPONSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResponse(ResponseType newResponse, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WadlPackage.Literals.DOCUMENT_ROOT__RESPONSE, newResponse, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponse(ResponseType newResponse) {
		((FeatureMap.Internal)getMixed()).set(WadlPackage.Literals.DOCUMENT_ROOT__RESPONSE, newResponse);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WadlPackage.DOCUMENT_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case WadlPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case WadlPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case WadlPackage.DOCUMENT_ROOT__APPLICATION:
				return basicSetApplication(null, msgs);
			case WadlPackage.DOCUMENT_ROOT__DOC:
				return basicSetDoc(null, msgs);
			case WadlPackage.DOCUMENT_ROOT__GRAMMARS:
				return basicSetGrammars(null, msgs);
			case WadlPackage.DOCUMENT_ROOT__INCLUDE:
				return basicSetInclude(null, msgs);
			case WadlPackage.DOCUMENT_ROOT__LINK:
				return basicSetLink(null, msgs);
			case WadlPackage.DOCUMENT_ROOT__METHOD:
				return basicSetMethod(null, msgs);
			case WadlPackage.DOCUMENT_ROOT__OPTION:
				return basicSetOption(null, msgs);
			case WadlPackage.DOCUMENT_ROOT__PARAM:
				return basicSetParam(null, msgs);
			case WadlPackage.DOCUMENT_ROOT__REPRESENTATION:
				return basicSetRepresentation(null, msgs);
			case WadlPackage.DOCUMENT_ROOT__REQUEST:
				return basicSetRequest(null, msgs);
			case WadlPackage.DOCUMENT_ROOT__RESOURCE:
				return basicSetResource(null, msgs);
			case WadlPackage.DOCUMENT_ROOT__RESOURCE_TYPE:
				return basicSetResourceType(null, msgs);
			case WadlPackage.DOCUMENT_ROOT__RESOURCES:
				return basicSetResources(null, msgs);
			case WadlPackage.DOCUMENT_ROOT__RESPONSE:
				return basicSetResponse(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WadlPackage.DOCUMENT_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case WadlPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case WadlPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case WadlPackage.DOCUMENT_ROOT__APPLICATION:
				return getApplication();
			case WadlPackage.DOCUMENT_ROOT__DOC:
				return getDoc();
			case WadlPackage.DOCUMENT_ROOT__GRAMMARS:
				return getGrammars();
			case WadlPackage.DOCUMENT_ROOT__INCLUDE:
				return getInclude();
			case WadlPackage.DOCUMENT_ROOT__LINK:
				return getLink();
			case WadlPackage.DOCUMENT_ROOT__METHOD:
				return getMethod();
			case WadlPackage.DOCUMENT_ROOT__OPTION:
				return getOption();
			case WadlPackage.DOCUMENT_ROOT__PARAM:
				return getParam();
			case WadlPackage.DOCUMENT_ROOT__REPRESENTATION:
				return getRepresentation();
			case WadlPackage.DOCUMENT_ROOT__REQUEST:
				return getRequest();
			case WadlPackage.DOCUMENT_ROOT__RESOURCE:
				return getResource();
			case WadlPackage.DOCUMENT_ROOT__RESOURCE_TYPE:
				return getResourceType();
			case WadlPackage.DOCUMENT_ROOT__RESOURCES:
				return getResources();
			case WadlPackage.DOCUMENT_ROOT__RESPONSE:
				return getResponse();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WadlPackage.DOCUMENT_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case WadlPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case WadlPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case WadlPackage.DOCUMENT_ROOT__APPLICATION:
				setApplication((ApplicationType)newValue);
				return;
			case WadlPackage.DOCUMENT_ROOT__DOC:
				setDoc((DocType)newValue);
				return;
			case WadlPackage.DOCUMENT_ROOT__GRAMMARS:
				setGrammars((GrammarsType)newValue);
				return;
			case WadlPackage.DOCUMENT_ROOT__INCLUDE:
				setInclude((IncludeType)newValue);
				return;
			case WadlPackage.DOCUMENT_ROOT__LINK:
				setLink((LinkType)newValue);
				return;
			case WadlPackage.DOCUMENT_ROOT__METHOD:
				setMethod((MethodType)newValue);
				return;
			case WadlPackage.DOCUMENT_ROOT__OPTION:
				setOption((OptionType)newValue);
				return;
			case WadlPackage.DOCUMENT_ROOT__PARAM:
				setParam((ParamType)newValue);
				return;
			case WadlPackage.DOCUMENT_ROOT__REPRESENTATION:
				setRepresentation((RepresentationType)newValue);
				return;
			case WadlPackage.DOCUMENT_ROOT__REQUEST:
				setRequest((RequestType)newValue);
				return;
			case WadlPackage.DOCUMENT_ROOT__RESOURCE:
				setResource((ResourceType)newValue);
				return;
			case WadlPackage.DOCUMENT_ROOT__RESOURCE_TYPE:
				setResourceType((ResourceTypeType)newValue);
				return;
			case WadlPackage.DOCUMENT_ROOT__RESOURCES:
				setResources((ResourcesType)newValue);
				return;
			case WadlPackage.DOCUMENT_ROOT__RESPONSE:
				setResponse((ResponseType)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case WadlPackage.DOCUMENT_ROOT__MIXED:
				getMixed().clear();
				return;
			case WadlPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case WadlPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case WadlPackage.DOCUMENT_ROOT__APPLICATION:
				setApplication((ApplicationType)null);
				return;
			case WadlPackage.DOCUMENT_ROOT__DOC:
				setDoc((DocType)null);
				return;
			case WadlPackage.DOCUMENT_ROOT__GRAMMARS:
				setGrammars((GrammarsType)null);
				return;
			case WadlPackage.DOCUMENT_ROOT__INCLUDE:
				setInclude((IncludeType)null);
				return;
			case WadlPackage.DOCUMENT_ROOT__LINK:
				setLink((LinkType)null);
				return;
			case WadlPackage.DOCUMENT_ROOT__METHOD:
				setMethod((MethodType)null);
				return;
			case WadlPackage.DOCUMENT_ROOT__OPTION:
				setOption((OptionType)null);
				return;
			case WadlPackage.DOCUMENT_ROOT__PARAM:
				setParam((ParamType)null);
				return;
			case WadlPackage.DOCUMENT_ROOT__REPRESENTATION:
				setRepresentation((RepresentationType)null);
				return;
			case WadlPackage.DOCUMENT_ROOT__REQUEST:
				setRequest((RequestType)null);
				return;
			case WadlPackage.DOCUMENT_ROOT__RESOURCE:
				setResource((ResourceType)null);
				return;
			case WadlPackage.DOCUMENT_ROOT__RESOURCE_TYPE:
				setResourceType((ResourceTypeType)null);
				return;
			case WadlPackage.DOCUMENT_ROOT__RESOURCES:
				setResources((ResourcesType)null);
				return;
			case WadlPackage.DOCUMENT_ROOT__RESPONSE:
				setResponse((ResponseType)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WadlPackage.DOCUMENT_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case WadlPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case WadlPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case WadlPackage.DOCUMENT_ROOT__APPLICATION:
				return getApplication() != null;
			case WadlPackage.DOCUMENT_ROOT__DOC:
				return getDoc() != null;
			case WadlPackage.DOCUMENT_ROOT__GRAMMARS:
				return getGrammars() != null;
			case WadlPackage.DOCUMENT_ROOT__INCLUDE:
				return getInclude() != null;
			case WadlPackage.DOCUMENT_ROOT__LINK:
				return getLink() != null;
			case WadlPackage.DOCUMENT_ROOT__METHOD:
				return getMethod() != null;
			case WadlPackage.DOCUMENT_ROOT__OPTION:
				return getOption() != null;
			case WadlPackage.DOCUMENT_ROOT__PARAM:
				return getParam() != null;
			case WadlPackage.DOCUMENT_ROOT__REPRESENTATION:
				return getRepresentation() != null;
			case WadlPackage.DOCUMENT_ROOT__REQUEST:
				return getRequest() != null;
			case WadlPackage.DOCUMENT_ROOT__RESOURCE:
				return getResource() != null;
			case WadlPackage.DOCUMENT_ROOT__RESOURCE_TYPE:
				return getResourceType() != null;
			case WadlPackage.DOCUMENT_ROOT__RESOURCES:
				return getResources() != null;
			case WadlPackage.DOCUMENT_ROOT__RESPONSE:
				return getResponse() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //DocumentRootImpl
