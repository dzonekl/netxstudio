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

import tbd.params.xml.ns.yang.network.topology.TopologyPackage;
import tbd.params.xml.ns.yang.network.topology.UnderlayTopologyType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Underlay Topology Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.UnderlayTopologyTypeImpl#getTopologyRef <em>Topology Ref</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.UnderlayTopologyTypeImpl#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnderlayTopologyTypeImpl extends MinimalEObjectImpl.Container implements UnderlayTopologyType {
	/**
	 * The default value of the '{@link #getTopologyRef() <em>Topology Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopologyRef()
	 * @generated
	 * @ordered
	 */
	protected static final String TOPOLOGY_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTopologyRef() <em>Topology Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopologyRef()
	 * @generated
	 * @ordered
	 */
	protected String topologyRef = TOPOLOGY_REF_EDEFAULT;

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
	protected UnderlayTopologyTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TopologyPackage.Literals.UNDERLAY_TOPOLOGY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopologyRef() {
		return topologyRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopologyRef(String newTopologyRef) {
		String oldTopologyRef = topologyRef;
		topologyRef = newTopologyRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.UNDERLAY_TOPOLOGY_TYPE__TOPOLOGY_REF, oldTopologyRef, topologyRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, TopologyPackage.UNDERLAY_TOPOLOGY_TYPE__ANY);
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
			case TopologyPackage.UNDERLAY_TOPOLOGY_TYPE__ANY:
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
			case TopologyPackage.UNDERLAY_TOPOLOGY_TYPE__TOPOLOGY_REF:
				return getTopologyRef();
			case TopologyPackage.UNDERLAY_TOPOLOGY_TYPE__ANY:
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
			case TopologyPackage.UNDERLAY_TOPOLOGY_TYPE__TOPOLOGY_REF:
				setTopologyRef((String)newValue);
				return;
			case TopologyPackage.UNDERLAY_TOPOLOGY_TYPE__ANY:
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
			case TopologyPackage.UNDERLAY_TOPOLOGY_TYPE__TOPOLOGY_REF:
				setTopologyRef(TOPOLOGY_REF_EDEFAULT);
				return;
			case TopologyPackage.UNDERLAY_TOPOLOGY_TYPE__ANY:
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
			case TopologyPackage.UNDERLAY_TOPOLOGY_TYPE__TOPOLOGY_REF:
				return TOPOLOGY_REF_EDEFAULT == null ? topologyRef != null : !TOPOLOGY_REF_EDEFAULT.equals(topologyRef);
			case TopologyPackage.UNDERLAY_TOPOLOGY_TYPE__ANY:
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
		result.append(" (topologyRef: ");
		result.append(topologyRef);
		result.append(", any: ");
		result.append(any);
		result.append(')');
		return result.toString();
	}

} //UnderlayTopologyTypeImpl
