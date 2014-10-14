/**
 */
package tbd.params.xml.ns.yang.network.topology.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import tbd.params.xml.ns.yang.network.topology.SupportingLinkType;
import tbd.params.xml.ns.yang.network.topology.TopologyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Supporting Link Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.SupportingLinkTypeImpl#getLinkRef <em>Link Ref</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.SupportingLinkTypeImpl#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SupportingLinkTypeImpl extends MinimalEObjectImpl.Container implements SupportingLinkType {
	/**
	 * The default value of the '{@link #getLinkRef() <em>Link Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkRef()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkRef() <em>Link Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkRef()
	 * @generated
	 * @ordered
	 */
	protected String linkRef = LINK_REF_EDEFAULT;

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
	protected SupportingLinkTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TopologyPackage.Literals.SUPPORTING_LINK_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkRef() {
		return linkRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkRef(String newLinkRef) {
		String oldLinkRef = linkRef;
		linkRef = newLinkRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.SUPPORTING_LINK_TYPE__LINK_REF, oldLinkRef, linkRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, TopologyPackage.SUPPORTING_LINK_TYPE__ANY);
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
			case TopologyPackage.SUPPORTING_LINK_TYPE__ANY:
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
			case TopologyPackage.SUPPORTING_LINK_TYPE__LINK_REF:
				return getLinkRef();
			case TopologyPackage.SUPPORTING_LINK_TYPE__ANY:
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TopologyPackage.SUPPORTING_LINK_TYPE__LINK_REF:
				setLinkRef((String)newValue);
				return;
			case TopologyPackage.SUPPORTING_LINK_TYPE__ANY:
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
			case TopologyPackage.SUPPORTING_LINK_TYPE__LINK_REF:
				setLinkRef(LINK_REF_EDEFAULT);
				return;
			case TopologyPackage.SUPPORTING_LINK_TYPE__ANY:
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
			case TopologyPackage.SUPPORTING_LINK_TYPE__LINK_REF:
				return LINK_REF_EDEFAULT == null ? linkRef != null : !LINK_REF_EDEFAULT.equals(linkRef);
			case TopologyPackage.SUPPORTING_LINK_TYPE__ANY:
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
		result.append(" (linkRef: ");
		result.append(linkRef);
		result.append(", any: ");
		result.append(any);
		result.append(')');
		return result.toString();
	}

} //SupportingLinkTypeImpl
