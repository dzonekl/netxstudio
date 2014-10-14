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
import wadl.ParamType;
import wadl.ResourceType;
import wadl.ResourceTypeType;
import wadl.WadlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Type Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link wadl.impl.ResourceTypeTypeImpl#getDoc <em>Doc</em>}</li>
 *   <li>{@link wadl.impl.ResourceTypeTypeImpl#getParam <em>Param</em>}</li>
 *   <li>{@link wadl.impl.ResourceTypeTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link wadl.impl.ResourceTypeTypeImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link wadl.impl.ResourceTypeTypeImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link wadl.impl.ResourceTypeTypeImpl#getAny <em>Any</em>}</li>
 *   <li>{@link wadl.impl.ResourceTypeTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link wadl.impl.ResourceTypeTypeImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceTypeTypeImpl extends MinimalEObjectImpl.Container implements ResourceTypeType {
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
	 * The cached value of the '{@link #getParam() <em>Param</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParam()
	 * @generated
	 * @ordered
	 */
	protected EList<ParamType> param;

	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

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
	protected ResourceTypeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WadlPackage.Literals.RESOURCE_TYPE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DocType> getDoc() {
		if (doc == null) {
			doc = new EObjectContainmentEList<DocType>(DocType.class, this, WadlPackage.RESOURCE_TYPE_TYPE__DOC);
		}
		return doc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParamType> getParam() {
		if (param == null) {
			param = new EObjectContainmentEList<ParamType>(ParamType.class, this, WadlPackage.RESOURCE_TYPE_TYPE__PARAM);
		}
		return param;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, WadlPackage.RESOURCE_TYPE_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MethodType> getMethod() {
		return getGroup().list(WadlPackage.Literals.RESOURCE_TYPE_TYPE__METHOD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceType> getResource() {
		return getGroup().list(WadlPackage.Literals.RESOURCE_TYPE_TYPE__RESOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, WadlPackage.RESOURCE_TYPE_TYPE__ANY);
		}
		return any;
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
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.RESOURCE_TYPE_TYPE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, WadlPackage.RESOURCE_TYPE_TYPE__ANY_ATTRIBUTE);
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
			case WadlPackage.RESOURCE_TYPE_TYPE__DOC:
				return ((InternalEList<?>)getDoc()).basicRemove(otherEnd, msgs);
			case WadlPackage.RESOURCE_TYPE_TYPE__PARAM:
				return ((InternalEList<?>)getParam()).basicRemove(otherEnd, msgs);
			case WadlPackage.RESOURCE_TYPE_TYPE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case WadlPackage.RESOURCE_TYPE_TYPE__METHOD:
				return ((InternalEList<?>)getMethod()).basicRemove(otherEnd, msgs);
			case WadlPackage.RESOURCE_TYPE_TYPE__RESOURCE:
				return ((InternalEList<?>)getResource()).basicRemove(otherEnd, msgs);
			case WadlPackage.RESOURCE_TYPE_TYPE__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case WadlPackage.RESOURCE_TYPE_TYPE__ANY_ATTRIBUTE:
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
			case WadlPackage.RESOURCE_TYPE_TYPE__DOC:
				return getDoc();
			case WadlPackage.RESOURCE_TYPE_TYPE__PARAM:
				return getParam();
			case WadlPackage.RESOURCE_TYPE_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case WadlPackage.RESOURCE_TYPE_TYPE__METHOD:
				return getMethod();
			case WadlPackage.RESOURCE_TYPE_TYPE__RESOURCE:
				return getResource();
			case WadlPackage.RESOURCE_TYPE_TYPE__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case WadlPackage.RESOURCE_TYPE_TYPE__ID:
				return getId();
			case WadlPackage.RESOURCE_TYPE_TYPE__ANY_ATTRIBUTE:
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
			case WadlPackage.RESOURCE_TYPE_TYPE__DOC:
				getDoc().clear();
				getDoc().addAll((Collection<? extends DocType>)newValue);
				return;
			case WadlPackage.RESOURCE_TYPE_TYPE__PARAM:
				getParam().clear();
				getParam().addAll((Collection<? extends ParamType>)newValue);
				return;
			case WadlPackage.RESOURCE_TYPE_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case WadlPackage.RESOURCE_TYPE_TYPE__METHOD:
				getMethod().clear();
				getMethod().addAll((Collection<? extends MethodType>)newValue);
				return;
			case WadlPackage.RESOURCE_TYPE_TYPE__RESOURCE:
				getResource().clear();
				getResource().addAll((Collection<? extends ResourceType>)newValue);
				return;
			case WadlPackage.RESOURCE_TYPE_TYPE__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case WadlPackage.RESOURCE_TYPE_TYPE__ID:
				setId((String)newValue);
				return;
			case WadlPackage.RESOURCE_TYPE_TYPE__ANY_ATTRIBUTE:
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
			case WadlPackage.RESOURCE_TYPE_TYPE__DOC:
				getDoc().clear();
				return;
			case WadlPackage.RESOURCE_TYPE_TYPE__PARAM:
				getParam().clear();
				return;
			case WadlPackage.RESOURCE_TYPE_TYPE__GROUP:
				getGroup().clear();
				return;
			case WadlPackage.RESOURCE_TYPE_TYPE__METHOD:
				getMethod().clear();
				return;
			case WadlPackage.RESOURCE_TYPE_TYPE__RESOURCE:
				getResource().clear();
				return;
			case WadlPackage.RESOURCE_TYPE_TYPE__ANY:
				getAny().clear();
				return;
			case WadlPackage.RESOURCE_TYPE_TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case WadlPackage.RESOURCE_TYPE_TYPE__ANY_ATTRIBUTE:
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
			case WadlPackage.RESOURCE_TYPE_TYPE__DOC:
				return doc != null && !doc.isEmpty();
			case WadlPackage.RESOURCE_TYPE_TYPE__PARAM:
				return param != null && !param.isEmpty();
			case WadlPackage.RESOURCE_TYPE_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case WadlPackage.RESOURCE_TYPE_TYPE__METHOD:
				return !getMethod().isEmpty();
			case WadlPackage.RESOURCE_TYPE_TYPE__RESOURCE:
				return !getResource().isEmpty();
			case WadlPackage.RESOURCE_TYPE_TYPE__ANY:
				return any != null && !any.isEmpty();
			case WadlPackage.RESOURCE_TYPE_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case WadlPackage.RESOURCE_TYPE_TYPE__ANY_ATTRIBUTE:
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
		result.append(" (group: ");
		result.append(group);
		result.append(", any: ");
		result.append(any);
		result.append(", id: ");
		result.append(id);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //ResourceTypeTypeImpl
