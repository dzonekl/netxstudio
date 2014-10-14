/**
 */
package tbd.params.xml.ns.yang.network.topology.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import tbd.params.xml.ns.yang.network.topology.NetworkTopologyType;
import tbd.params.xml.ns.yang.network.topology.TopologyPackage;
import tbd.params.xml.ns.yang.network.topology.TopologyType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Network Topology Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.NetworkTopologyTypeImpl#getTopology <em>Topology</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.NetworkTopologyTypeImpl#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NetworkTopologyTypeImpl extends MinimalEObjectImpl.Container implements NetworkTopologyType {
	/**
	 * The cached value of the '{@link #getTopology() <em>Topology</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopology()
	 * @generated
	 * @ordered
	 */
	protected EList<TopologyType> topology;

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
	protected NetworkTopologyTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TopologyPackage.Literals.NETWORK_TOPOLOGY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TopologyType> getTopology() {
		if (topology == null) {
			topology = new EObjectContainmentEList<TopologyType>(TopologyType.class, this, TopologyPackage.NETWORK_TOPOLOGY_TYPE__TOPOLOGY);
		}
		return topology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, TopologyPackage.NETWORK_TOPOLOGY_TYPE__ANY);
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
			case TopologyPackage.NETWORK_TOPOLOGY_TYPE__TOPOLOGY:
				return ((InternalEList<?>)getTopology()).basicRemove(otherEnd, msgs);
			case TopologyPackage.NETWORK_TOPOLOGY_TYPE__ANY:
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
			case TopologyPackage.NETWORK_TOPOLOGY_TYPE__TOPOLOGY:
				return getTopology();
			case TopologyPackage.NETWORK_TOPOLOGY_TYPE__ANY:
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
			case TopologyPackage.NETWORK_TOPOLOGY_TYPE__TOPOLOGY:
				getTopology().clear();
				getTopology().addAll((Collection<? extends TopologyType>)newValue);
				return;
			case TopologyPackage.NETWORK_TOPOLOGY_TYPE__ANY:
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
			case TopologyPackage.NETWORK_TOPOLOGY_TYPE__TOPOLOGY:
				getTopology().clear();
				return;
			case TopologyPackage.NETWORK_TOPOLOGY_TYPE__ANY:
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
			case TopologyPackage.NETWORK_TOPOLOGY_TYPE__TOPOLOGY:
				return topology != null && !topology.isEmpty();
			case TopologyPackage.NETWORK_TOPOLOGY_TYPE__ANY:
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
		result.append(" (any: ");
		result.append(any);
		result.append(')');
		return result.toString();
	}

} //NetworkTopologyTypeImpl
