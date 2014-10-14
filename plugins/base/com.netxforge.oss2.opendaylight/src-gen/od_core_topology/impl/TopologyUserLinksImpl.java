/**
 */
package od_core_topology.impl;

import java.util.Collection;

import od_core_topology.TopologyPackage;
import od_core_topology.TopologyUserLinkConfig;
import od_core_topology.TopologyUserLinks;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Links</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link od_core_topology.impl.TopologyUserLinksImpl#getUserLinks <em>User Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TopologyUserLinksImpl extends MinimalEObjectImpl.Container implements TopologyUserLinks {
	/**
	 * The cached value of the '{@link #getUserLinks() <em>User Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<TopologyUserLinkConfig> userLinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopologyUserLinksImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TopologyPackage.Literals.TOPOLOGY_USER_LINKS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TopologyUserLinkConfig> getUserLinks() {
		if (userLinks == null) {
			userLinks = new EObjectContainmentEList<TopologyUserLinkConfig>(TopologyUserLinkConfig.class, this, TopologyPackage.TOPOLOGY_USER_LINKS__USER_LINKS);
		}
		return userLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TopologyPackage.TOPOLOGY_USER_LINKS__USER_LINKS:
				return ((InternalEList<?>)getUserLinks()).basicRemove(otherEnd, msgs);
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
			case TopologyPackage.TOPOLOGY_USER_LINKS__USER_LINKS:
				return getUserLinks();
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
			case TopologyPackage.TOPOLOGY_USER_LINKS__USER_LINKS:
				getUserLinks().clear();
				getUserLinks().addAll((Collection<? extends TopologyUserLinkConfig>)newValue);
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
			case TopologyPackage.TOPOLOGY_USER_LINKS__USER_LINKS:
				getUserLinks().clear();
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
			case TopologyPackage.TOPOLOGY_USER_LINKS__USER_LINKS:
				return userLinks != null && !userLinks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TopologyUserLinksImpl
