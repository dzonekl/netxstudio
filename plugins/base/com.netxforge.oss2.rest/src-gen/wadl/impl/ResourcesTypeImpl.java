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
import wadl.ResourceType;
import wadl.ResourcesType;
import wadl.WadlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resources Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link wadl.impl.ResourcesTypeImpl#getDoc <em>Doc</em>}</li>
 *   <li>{@link wadl.impl.ResourcesTypeImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link wadl.impl.ResourcesTypeImpl#getAny <em>Any</em>}</li>
 *   <li>{@link wadl.impl.ResourcesTypeImpl#getBase <em>Base</em>}</li>
 *   <li>{@link wadl.impl.ResourcesTypeImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourcesTypeImpl extends MinimalEObjectImpl.Container implements ResourcesType {
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
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceType> resource;

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
	 * The default value of the '{@link #getBase() <em>Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBase() <em>Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase()
	 * @generated
	 * @ordered
	 */
	protected String base = BASE_EDEFAULT;

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
	protected ResourcesTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WadlPackage.Literals.RESOURCES_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DocType> getDoc() {
		if (doc == null) {
			doc = new EObjectContainmentEList<DocType>(DocType.class, this, WadlPackage.RESOURCES_TYPE__DOC);
		}
		return doc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceType> getResource() {
		if (resource == null) {
			resource = new EObjectContainmentEList<ResourceType>(ResourceType.class, this, WadlPackage.RESOURCES_TYPE__RESOURCE);
		}
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, WadlPackage.RESOURCES_TYPE__ANY);
		}
		return any;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBase() {
		return base;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase(String newBase) {
		String oldBase = base;
		base = newBase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.RESOURCES_TYPE__BASE, oldBase, base));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, WadlPackage.RESOURCES_TYPE__ANY_ATTRIBUTE);
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
			case WadlPackage.RESOURCES_TYPE__DOC:
				return ((InternalEList<?>)getDoc()).basicRemove(otherEnd, msgs);
			case WadlPackage.RESOURCES_TYPE__RESOURCE:
				return ((InternalEList<?>)getResource()).basicRemove(otherEnd, msgs);
			case WadlPackage.RESOURCES_TYPE__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case WadlPackage.RESOURCES_TYPE__ANY_ATTRIBUTE:
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
			case WadlPackage.RESOURCES_TYPE__DOC:
				return getDoc();
			case WadlPackage.RESOURCES_TYPE__RESOURCE:
				return getResource();
			case WadlPackage.RESOURCES_TYPE__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case WadlPackage.RESOURCES_TYPE__BASE:
				return getBase();
			case WadlPackage.RESOURCES_TYPE__ANY_ATTRIBUTE:
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
			case WadlPackage.RESOURCES_TYPE__DOC:
				getDoc().clear();
				getDoc().addAll((Collection<? extends DocType>)newValue);
				return;
			case WadlPackage.RESOURCES_TYPE__RESOURCE:
				getResource().clear();
				getResource().addAll((Collection<? extends ResourceType>)newValue);
				return;
			case WadlPackage.RESOURCES_TYPE__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case WadlPackage.RESOURCES_TYPE__BASE:
				setBase((String)newValue);
				return;
			case WadlPackage.RESOURCES_TYPE__ANY_ATTRIBUTE:
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
			case WadlPackage.RESOURCES_TYPE__DOC:
				getDoc().clear();
				return;
			case WadlPackage.RESOURCES_TYPE__RESOURCE:
				getResource().clear();
				return;
			case WadlPackage.RESOURCES_TYPE__ANY:
				getAny().clear();
				return;
			case WadlPackage.RESOURCES_TYPE__BASE:
				setBase(BASE_EDEFAULT);
				return;
			case WadlPackage.RESOURCES_TYPE__ANY_ATTRIBUTE:
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
			case WadlPackage.RESOURCES_TYPE__DOC:
				return doc != null && !doc.isEmpty();
			case WadlPackage.RESOURCES_TYPE__RESOURCE:
				return resource != null && !resource.isEmpty();
			case WadlPackage.RESOURCES_TYPE__ANY:
				return any != null && !any.isEmpty();
			case WadlPackage.RESOURCES_TYPE__BASE:
				return BASE_EDEFAULT == null ? base != null : !BASE_EDEFAULT.equals(base);
			case WadlPackage.RESOURCES_TYPE__ANY_ATTRIBUTE:
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
		result.append(", base: ");
		result.append(base);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //ResourcesTypeImpl
