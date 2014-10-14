/**
 */
package wadl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import wadl.DocType;
import wadl.MethodType;
import wadl.RequestType;
import wadl.ResponseType;
import wadl.WadlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link wadl.impl.MethodTypeImpl#getDoc <em>Doc</em>}</li>
 *   <li>{@link wadl.impl.MethodTypeImpl#getRequest <em>Request</em>}</li>
 *   <li>{@link wadl.impl.MethodTypeImpl#getResponse <em>Response</em>}</li>
 *   <li>{@link wadl.impl.MethodTypeImpl#getAny <em>Any</em>}</li>
 *   <li>{@link wadl.impl.MethodTypeImpl#getHref <em>Href</em>}</li>
 *   <li>{@link wadl.impl.MethodTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link wadl.impl.MethodTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link wadl.impl.MethodTypeImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodTypeImpl extends MinimalEObjectImpl.Container implements MethodType {
	/**
	 * The cached value of the '{@link #getDoc() <em>Doc</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoc()
	 * @generated
	 * @ordered
	 */
	protected EList<DocType> doc;

	/**
	 * The cached value of the '{@link #getRequest() <em>Request</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequest()
	 * @generated
	 * @ordered
	 */
	protected RequestType request;

	/**
	 * The cached value of the '{@link #getResponse() <em>Response</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponse()
	 * @generated
	 * @ordered
	 */
	protected EList<ResponseType> response;

	/**
	 * The cached value of the '{@link #getAny() <em>Any</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAny()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap any;

	/**
	 * The default value of the '{@link #getHref() <em>Href</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHref()
	 * @generated
	 * @ordered
	 */
	protected static final String HREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHref() <em>Href</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHref()
	 * @generated
	 * @ordered
	 */
	protected String href = HREF_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final Object NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected Object name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnyAttribute()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap anyAttribute;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WadlPackage.Literals.METHOD_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DocType> getDoc() {
		if (doc == null) {
			doc = new EObjectContainmentEList<DocType>(DocType.class, this, WadlPackage.METHOD_TYPE__DOC);
		}
		return doc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequestType getRequest() {
		return request;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequest(RequestType newRequest, NotificationChain msgs) {
		RequestType oldRequest = request;
		request = newRequest;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WadlPackage.METHOD_TYPE__REQUEST, oldRequest, newRequest);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequest(RequestType newRequest) {
		if (newRequest != request) {
			NotificationChain msgs = null;
			if (request != null)
				msgs = ((InternalEObject)request).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WadlPackage.METHOD_TYPE__REQUEST, null, msgs);
			if (newRequest != null)
				msgs = ((InternalEObject)newRequest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WadlPackage.METHOD_TYPE__REQUEST, null, msgs);
			msgs = basicSetRequest(newRequest, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.METHOD_TYPE__REQUEST, newRequest, newRequest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResponseType> getResponse() {
		if (response == null) {
			response = new EObjectContainmentEList<ResponseType>(ResponseType.class, this, WadlPackage.METHOD_TYPE__RESPONSE);
		}
		return response;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, WadlPackage.METHOD_TYPE__ANY);
		}
		return any;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHref() {
		return href;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHref(String newHref) {
		String oldHref = href;
		href = newHref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.METHOD_TYPE__HREF, oldHref, href));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.METHOD_TYPE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(Object newName) {
		Object oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.METHOD_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, WadlPackage.METHOD_TYPE__ANY_ATTRIBUTE);
		}
		return anyAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WadlPackage.METHOD_TYPE__DOC:
				return ((InternalEList<?>)getDoc()).basicRemove(otherEnd, msgs);
			case WadlPackage.METHOD_TYPE__REQUEST:
				return basicSetRequest(null, msgs);
			case WadlPackage.METHOD_TYPE__RESPONSE:
				return ((InternalEList<?>)getResponse()).basicRemove(otherEnd, msgs);
			case WadlPackage.METHOD_TYPE__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case WadlPackage.METHOD_TYPE__ANY_ATTRIBUTE:
				return ((InternalEList<?>)getAnyAttribute()).basicRemove(otherEnd, msgs);
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
			case WadlPackage.METHOD_TYPE__DOC:
				return getDoc();
			case WadlPackage.METHOD_TYPE__REQUEST:
				return getRequest();
			case WadlPackage.METHOD_TYPE__RESPONSE:
				return getResponse();
			case WadlPackage.METHOD_TYPE__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case WadlPackage.METHOD_TYPE__HREF:
				return getHref();
			case WadlPackage.METHOD_TYPE__ID:
				return getId();
			case WadlPackage.METHOD_TYPE__NAME:
				return getName();
			case WadlPackage.METHOD_TYPE__ANY_ATTRIBUTE:
				if (coreType) return getAnyAttribute();
				return ((FeatureMap.Internal)getAnyAttribute()).getWrapper();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WadlPackage.METHOD_TYPE__DOC:
				getDoc().clear();
				getDoc().addAll((Collection<? extends DocType>)newValue);
				return;
			case WadlPackage.METHOD_TYPE__REQUEST:
				setRequest((RequestType)newValue);
				return;
			case WadlPackage.METHOD_TYPE__RESPONSE:
				getResponse().clear();
				getResponse().addAll((Collection<? extends ResponseType>)newValue);
				return;
			case WadlPackage.METHOD_TYPE__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case WadlPackage.METHOD_TYPE__HREF:
				setHref((String)newValue);
				return;
			case WadlPackage.METHOD_TYPE__ID:
				setId((String)newValue);
				return;
			case WadlPackage.METHOD_TYPE__NAME:
				setName(newValue);
				return;
			case WadlPackage.METHOD_TYPE__ANY_ATTRIBUTE:
				((FeatureMap.Internal)getAnyAttribute()).set(newValue);
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
			case WadlPackage.METHOD_TYPE__DOC:
				getDoc().clear();
				return;
			case WadlPackage.METHOD_TYPE__REQUEST:
				setRequest((RequestType)null);
				return;
			case WadlPackage.METHOD_TYPE__RESPONSE:
				getResponse().clear();
				return;
			case WadlPackage.METHOD_TYPE__ANY:
				getAny().clear();
				return;
			case WadlPackage.METHOD_TYPE__HREF:
				setHref(HREF_EDEFAULT);
				return;
			case WadlPackage.METHOD_TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case WadlPackage.METHOD_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WadlPackage.METHOD_TYPE__ANY_ATTRIBUTE:
				getAnyAttribute().clear();
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
			case WadlPackage.METHOD_TYPE__DOC:
				return doc != null && !doc.isEmpty();
			case WadlPackage.METHOD_TYPE__REQUEST:
				return request != null;
			case WadlPackage.METHOD_TYPE__RESPONSE:
				return response != null && !response.isEmpty();
			case WadlPackage.METHOD_TYPE__ANY:
				return any != null && !any.isEmpty();
			case WadlPackage.METHOD_TYPE__HREF:
				return HREF_EDEFAULT == null ? href != null : !HREF_EDEFAULT.equals(href);
			case WadlPackage.METHOD_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case WadlPackage.METHOD_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WadlPackage.METHOD_TYPE__ANY_ATTRIBUTE:
				return anyAttribute != null && !anyAttribute.isEmpty();
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
		result.append(" (any: ");
		result.append(any);
		result.append(", href: ");
		result.append(href);
		result.append(", id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //MethodTypeImpl
