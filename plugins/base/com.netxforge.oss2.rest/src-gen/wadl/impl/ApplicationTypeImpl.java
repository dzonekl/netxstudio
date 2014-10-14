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

import wadl.ApplicationType;
import wadl.DocType;
import wadl.GrammarsType;
import wadl.MethodType;
import wadl.ParamType;
import wadl.RepresentationType;
import wadl.ResourceTypeType;
import wadl.ResourcesType;
import wadl.WadlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link wadl.impl.ApplicationTypeImpl#getDoc <em>Doc</em>}</li>
 *   <li>{@link wadl.impl.ApplicationTypeImpl#getGrammars <em>Grammars</em>}</li>
 *   <li>{@link wadl.impl.ApplicationTypeImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link wadl.impl.ApplicationTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link wadl.impl.ApplicationTypeImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link wadl.impl.ApplicationTypeImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link wadl.impl.ApplicationTypeImpl#getRepresentation <em>Representation</em>}</li>
 *   <li>{@link wadl.impl.ApplicationTypeImpl#getParam <em>Param</em>}</li>
 *   <li>{@link wadl.impl.ApplicationTypeImpl#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplicationTypeImpl extends MinimalEObjectImpl.Container implements ApplicationType {
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
	 * The cached value of the '{@link #getGrammars() <em>Grammars</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrammars()
	 * @generated
	 * @ordered
	 */
	protected GrammarsType grammars;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourcesType> resources;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WadlPackage.Literals.APPLICATION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DocType> getDoc() {
		if (doc == null) {
			doc = new EObjectContainmentEList<DocType>(DocType.class, this, WadlPackage.APPLICATION_TYPE__DOC);
		}
		return doc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarsType getGrammars() {
		return grammars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGrammars(GrammarsType newGrammars, NotificationChain msgs) {
		GrammarsType oldGrammars = grammars;
		grammars = newGrammars;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WadlPackage.APPLICATION_TYPE__GRAMMARS, oldGrammars, newGrammars);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrammars(GrammarsType newGrammars) {
		if (newGrammars != grammars) {
			NotificationChain msgs = null;
			if (grammars != null)
				msgs = ((InternalEObject)grammars).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WadlPackage.APPLICATION_TYPE__GRAMMARS, null, msgs);
			if (newGrammars != null)
				msgs = ((InternalEObject)newGrammars).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WadlPackage.APPLICATION_TYPE__GRAMMARS, null, msgs);
			msgs = basicSetGrammars(newGrammars, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.APPLICATION_TYPE__GRAMMARS, newGrammars, newGrammars));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourcesType> getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList<ResourcesType>(ResourcesType.class, this, WadlPackage.APPLICATION_TYPE__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, WadlPackage.APPLICATION_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceTypeType> getResourceType() {
		return getGroup().list(WadlPackage.Literals.APPLICATION_TYPE__RESOURCE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MethodType> getMethod() {
		return getGroup().list(WadlPackage.Literals.APPLICATION_TYPE__METHOD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RepresentationType> getRepresentation() {
		return getGroup().list(WadlPackage.Literals.APPLICATION_TYPE__REPRESENTATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParamType> getParam() {
		return getGroup().list(WadlPackage.Literals.APPLICATION_TYPE__PARAM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, WadlPackage.APPLICATION_TYPE__ANY);
		}
		return any;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WadlPackage.APPLICATION_TYPE__DOC:
				return ((InternalEList<?>)getDoc()).basicRemove(otherEnd, msgs);
			case WadlPackage.APPLICATION_TYPE__GRAMMARS:
				return basicSetGrammars(null, msgs);
			case WadlPackage.APPLICATION_TYPE__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
			case WadlPackage.APPLICATION_TYPE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case WadlPackage.APPLICATION_TYPE__RESOURCE_TYPE:
				return ((InternalEList<?>)getResourceType()).basicRemove(otherEnd, msgs);
			case WadlPackage.APPLICATION_TYPE__METHOD:
				return ((InternalEList<?>)getMethod()).basicRemove(otherEnd, msgs);
			case WadlPackage.APPLICATION_TYPE__REPRESENTATION:
				return ((InternalEList<?>)getRepresentation()).basicRemove(otherEnd, msgs);
			case WadlPackage.APPLICATION_TYPE__PARAM:
				return ((InternalEList<?>)getParam()).basicRemove(otherEnd, msgs);
			case WadlPackage.APPLICATION_TYPE__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
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
			case WadlPackage.APPLICATION_TYPE__DOC:
				return getDoc();
			case WadlPackage.APPLICATION_TYPE__GRAMMARS:
				return getGrammars();
			case WadlPackage.APPLICATION_TYPE__RESOURCES:
				return getResources();
			case WadlPackage.APPLICATION_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case WadlPackage.APPLICATION_TYPE__RESOURCE_TYPE:
				return getResourceType();
			case WadlPackage.APPLICATION_TYPE__METHOD:
				return getMethod();
			case WadlPackage.APPLICATION_TYPE__REPRESENTATION:
				return getRepresentation();
			case WadlPackage.APPLICATION_TYPE__PARAM:
				return getParam();
			case WadlPackage.APPLICATION_TYPE__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
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
			case WadlPackage.APPLICATION_TYPE__DOC:
				getDoc().clear();
				getDoc().addAll((Collection<? extends DocType>)newValue);
				return;
			case WadlPackage.APPLICATION_TYPE__GRAMMARS:
				setGrammars((GrammarsType)newValue);
				return;
			case WadlPackage.APPLICATION_TYPE__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends ResourcesType>)newValue);
				return;
			case WadlPackage.APPLICATION_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case WadlPackage.APPLICATION_TYPE__RESOURCE_TYPE:
				getResourceType().clear();
				getResourceType().addAll((Collection<? extends ResourceTypeType>)newValue);
				return;
			case WadlPackage.APPLICATION_TYPE__METHOD:
				getMethod().clear();
				getMethod().addAll((Collection<? extends MethodType>)newValue);
				return;
			case WadlPackage.APPLICATION_TYPE__REPRESENTATION:
				getRepresentation().clear();
				getRepresentation().addAll((Collection<? extends RepresentationType>)newValue);
				return;
			case WadlPackage.APPLICATION_TYPE__PARAM:
				getParam().clear();
				getParam().addAll((Collection<? extends ParamType>)newValue);
				return;
			case WadlPackage.APPLICATION_TYPE__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
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
			case WadlPackage.APPLICATION_TYPE__DOC:
				getDoc().clear();
				return;
			case WadlPackage.APPLICATION_TYPE__GRAMMARS:
				setGrammars((GrammarsType)null);
				return;
			case WadlPackage.APPLICATION_TYPE__RESOURCES:
				getResources().clear();
				return;
			case WadlPackage.APPLICATION_TYPE__GROUP:
				getGroup().clear();
				return;
			case WadlPackage.APPLICATION_TYPE__RESOURCE_TYPE:
				getResourceType().clear();
				return;
			case WadlPackage.APPLICATION_TYPE__METHOD:
				getMethod().clear();
				return;
			case WadlPackage.APPLICATION_TYPE__REPRESENTATION:
				getRepresentation().clear();
				return;
			case WadlPackage.APPLICATION_TYPE__PARAM:
				getParam().clear();
				return;
			case WadlPackage.APPLICATION_TYPE__ANY:
				getAny().clear();
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
			case WadlPackage.APPLICATION_TYPE__DOC:
				return doc != null && !doc.isEmpty();
			case WadlPackage.APPLICATION_TYPE__GRAMMARS:
				return grammars != null;
			case WadlPackage.APPLICATION_TYPE__RESOURCES:
				return resources != null && !resources.isEmpty();
			case WadlPackage.APPLICATION_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case WadlPackage.APPLICATION_TYPE__RESOURCE_TYPE:
				return !getResourceType().isEmpty();
			case WadlPackage.APPLICATION_TYPE__METHOD:
				return !getMethod().isEmpty();
			case WadlPackage.APPLICATION_TYPE__REPRESENTATION:
				return !getRepresentation().isEmpty();
			case WadlPackage.APPLICATION_TYPE__PARAM:
				return !getParam().isEmpty();
			case WadlPackage.APPLICATION_TYPE__ANY:
				return any != null && !any.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //ApplicationTypeImpl
