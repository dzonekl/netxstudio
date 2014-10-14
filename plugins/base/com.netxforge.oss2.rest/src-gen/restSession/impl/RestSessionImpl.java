/**
 */
package restSession.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import restSession.EntityInfo;
import restSession.HTTP_METHODS;
import restSession.MEDIA_TYPE;
import restSession.PathFragment;
import restSession.RestSession;
import restSession.RestSessionPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Rest Session</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link restSession.impl.RestSessionImpl#getUserid <em>Userid</em>}</li>
 *   <li>{@link restSession.impl.RestSessionImpl#getHttpMethod <em>Http Method</em>}</li>
 *   <li>{@link restSession.impl.RestSessionImpl#getBaseURI <em>Base URI</em>}</li>
 *   <li>{@link restSession.impl.RestSessionImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link restSession.impl.RestSessionImpl#getPathFragments <em>Path Fragments</em>}</li>
 *   <li>{@link restSession.impl.RestSessionImpl#getMedia <em>Media</em>}</li>
 *   <li>{@link restSession.impl.RestSessionImpl#getEntityInfo <em>Entity Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RestSessionImpl extends MinimalEObjectImpl.Container implements
		RestSession {
	/**
	 * The default value of the '{@link #getUserid() <em>Userid</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUserid()
	 * @generated
	 * @ordered
	 */
	protected static final String USERID_EDEFAULT = "admin";

	/**
	 * The cached value of the '{@link #getUserid() <em>Userid</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUserid()
	 * @generated
	 * @ordered
	 */
	protected String userid = USERID_EDEFAULT;

	/**
	 * The default value of the '{@link #getHttpMethod() <em>Http Method</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHttpMethod()
	 * @generated
	 * @ordered
	 */
	protected static final HTTP_METHODS HTTP_METHOD_EDEFAULT = HTTP_METHODS.GET;

	/**
	 * The cached value of the '{@link #getHttpMethod() <em>Http Method</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHttpMethod()
	 * @generated
	 * @ordered
	 */
	protected HTTP_METHODS httpMethod = HTTP_METHOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getBaseURI() <em>Base URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBaseURI()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_URI_EDEFAULT = "http://localhost:8181";

	/**
	 * The cached value of the '{@link #getBaseURI() <em>Base URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBaseURI()
	 * @generated
	 * @ordered
	 */
	protected String baseURI = BASE_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPathFragments() <em>Path Fragments</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getPathFragments()
	 * @generated
	 * @ordered
	 */
	protected EList<PathFragment> pathFragments;

	/**
	 * The default value of the '{@link #getMedia() <em>Media</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMedia()
	 * @generated
	 * @ordered
	 */
	protected static final MEDIA_TYPE MEDIA_EDEFAULT = MEDIA_TYPE.XML;

	/**
	 * The cached value of the '{@link #getMedia() <em>Media</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMedia()
	 * @generated
	 * @ordered
	 */
	protected MEDIA_TYPE media = MEDIA_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEntityInfo() <em>Entity Info</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEntityInfo()
	 * @generated
	 * @ordered
	 */
	protected EntityInfo entityInfo;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RestSessionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RestSessionPackage.Literals.REST_SESSION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserid(String newUserid) {
		String oldUserid = userid;
		userid = newUserid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestSessionPackage.REST_SESSION__USERID, oldUserid, userid));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HTTP_METHODS getHttpMethod() {
		return httpMethod;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHttpMethod(HTTP_METHODS newHttpMethod) {
		HTTP_METHODS oldHttpMethod = httpMethod;
		httpMethod = newHttpMethod == null ? HTTP_METHOD_EDEFAULT : newHttpMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestSessionPackage.REST_SESSION__HTTP_METHOD, oldHttpMethod, httpMethod));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getBaseURI() {
		return baseURI;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseURI(String newBaseURI) {
		String oldBaseURI = baseURI;
		baseURI = newBaseURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestSessionPackage.REST_SESSION__BASE_URI, oldBaseURI, baseURI));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestSessionPackage.REST_SESSION__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PathFragment> getPathFragments() {
		if (pathFragments == null) {
			pathFragments = new EObjectContainmentEList<PathFragment>(PathFragment.class, this, RestSessionPackage.REST_SESSION__PATH_FRAGMENTS);
		}
		return pathFragments;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MEDIA_TYPE getMedia() {
		return media;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMedia(MEDIA_TYPE newMedia) {
		MEDIA_TYPE oldMedia = media;
		media = newMedia == null ? MEDIA_EDEFAULT : newMedia;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestSessionPackage.REST_SESSION__MEDIA, oldMedia, media));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EntityInfo getEntityInfo() {
		return entityInfo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEntityInfo(EntityInfo newEntityInfo,
			NotificationChain msgs) {
		EntityInfo oldEntityInfo = entityInfo;
		entityInfo = newEntityInfo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RestSessionPackage.REST_SESSION__ENTITY_INFO, oldEntityInfo, newEntityInfo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntityInfo(EntityInfo newEntityInfo) {
		if (newEntityInfo != entityInfo) {
			NotificationChain msgs = null;
			if (entityInfo != null)
				msgs = ((InternalEObject)entityInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RestSessionPackage.REST_SESSION__ENTITY_INFO, null, msgs);
			if (newEntityInfo != null)
				msgs = ((InternalEObject)newEntityInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RestSessionPackage.REST_SESSION__ENTITY_INFO, null, msgs);
			msgs = basicSetEntityInfo(newEntityInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestSessionPackage.REST_SESSION__ENTITY_INFO, newEntityInfo, newEntityInfo));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean compleet() {
		boolean passSet = eIsSet(RestSessionPackage.Literals.REST_SESSION__PASSWORD);
//		boolean entitySet = eIsSet(RestSessionPackage.Literals.REST_SESSION__ENTITY_INFO);
		return passSet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String constructURI() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getBaseURI());
		for (PathFragment pf : this.getPathFragments()) {
			sb.append("/" + pf.getFragment());
		}

		return sb.toString();

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RestSessionPackage.REST_SESSION__PATH_FRAGMENTS:
				return ((InternalEList<?>)getPathFragments()).basicRemove(otherEnd, msgs);
			case RestSessionPackage.REST_SESSION__ENTITY_INFO:
				return basicSetEntityInfo(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RestSessionPackage.REST_SESSION__USERID:
				return getUserid();
			case RestSessionPackage.REST_SESSION__HTTP_METHOD:
				return getHttpMethod();
			case RestSessionPackage.REST_SESSION__BASE_URI:
				return getBaseURI();
			case RestSessionPackage.REST_SESSION__PASSWORD:
				return getPassword();
			case RestSessionPackage.REST_SESSION__PATH_FRAGMENTS:
				return getPathFragments();
			case RestSessionPackage.REST_SESSION__MEDIA:
				return getMedia();
			case RestSessionPackage.REST_SESSION__ENTITY_INFO:
				return getEntityInfo();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RestSessionPackage.REST_SESSION__USERID:
				setUserid((String)newValue);
				return;
			case RestSessionPackage.REST_SESSION__HTTP_METHOD:
				setHttpMethod((HTTP_METHODS)newValue);
				return;
			case RestSessionPackage.REST_SESSION__BASE_URI:
				setBaseURI((String)newValue);
				return;
			case RestSessionPackage.REST_SESSION__PASSWORD:
				setPassword((String)newValue);
				return;
			case RestSessionPackage.REST_SESSION__PATH_FRAGMENTS:
				getPathFragments().clear();
				getPathFragments().addAll((Collection<? extends PathFragment>)newValue);
				return;
			case RestSessionPackage.REST_SESSION__MEDIA:
				setMedia((MEDIA_TYPE)newValue);
				return;
			case RestSessionPackage.REST_SESSION__ENTITY_INFO:
				setEntityInfo((EntityInfo)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case RestSessionPackage.REST_SESSION__USERID:
				setUserid(USERID_EDEFAULT);
				return;
			case RestSessionPackage.REST_SESSION__HTTP_METHOD:
				setHttpMethod(HTTP_METHOD_EDEFAULT);
				return;
			case RestSessionPackage.REST_SESSION__BASE_URI:
				setBaseURI(BASE_URI_EDEFAULT);
				return;
			case RestSessionPackage.REST_SESSION__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case RestSessionPackage.REST_SESSION__PATH_FRAGMENTS:
				getPathFragments().clear();
				return;
			case RestSessionPackage.REST_SESSION__MEDIA:
				setMedia(MEDIA_EDEFAULT);
				return;
			case RestSessionPackage.REST_SESSION__ENTITY_INFO:
				setEntityInfo((EntityInfo)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RestSessionPackage.REST_SESSION__USERID:
				return USERID_EDEFAULT == null ? userid != null : !USERID_EDEFAULT.equals(userid);
			case RestSessionPackage.REST_SESSION__HTTP_METHOD:
				return httpMethod != HTTP_METHOD_EDEFAULT;
			case RestSessionPackage.REST_SESSION__BASE_URI:
				return BASE_URI_EDEFAULT == null ? baseURI != null : !BASE_URI_EDEFAULT.equals(baseURI);
			case RestSessionPackage.REST_SESSION__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case RestSessionPackage.REST_SESSION__PATH_FRAGMENTS:
				return pathFragments != null && !pathFragments.isEmpty();
			case RestSessionPackage.REST_SESSION__MEDIA:
				return media != MEDIA_EDEFAULT;
			case RestSessionPackage.REST_SESSION__ENTITY_INFO:
				return entityInfo != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID) {
			case RestSessionPackage.REST_SESSION___COMPLEET:
				return compleet();
			case RestSessionPackage.REST_SESSION___CONSTRUCT_URI:
				return constructURI();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (userid: ");
		result.append(userid);
		result.append(", httpMethod: ");
		result.append(httpMethod);
		result.append(", baseURI: ");
		result.append(baseURI);
		result.append(", password: ");
		result.append(password);
		result.append(", media: ");
		result.append(media);
		result.append(')');
		return result.toString();
	}

} // RestSessionImpl
