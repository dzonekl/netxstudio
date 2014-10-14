/**
 */
package od_core_topology.impl;

import java.util.Collection;

import od_core_topology.EdgeProperties;
import od_core_topology.Topology;
import od_core_topology.TopologyPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Topology</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link od_core_topology.impl.TopologyImpl#getEdgeProperties <em>Edge Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TopologyImpl extends MinimalEObjectImpl.Container implements Topology {
	/**
	 * The cached value of the '{@link #getEdgeProperties() <em>Edge Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<EdgeProperties> edgeProperties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopologyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TopologyPackage.Literals.TOPOLOGY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EdgeProperties> getEdgeProperties() {
		if (edgeProperties == null) {
			edgeProperties = new EObjectContainmentEList<EdgeProperties>(EdgeProperties.class, this, TopologyPackage.TOPOLOGY__EDGE_PROPERTIES);
		}
		return edgeProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TopologyPackage.TOPOLOGY__EDGE_PROPERTIES:
				return ((InternalEList<?>)getEdgeProperties()).basicRemove(otherEnd, msgs);
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
			case TopologyPackage.TOPOLOGY__EDGE_PROPERTIES:
				return getEdgeProperties();
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
			case TopologyPackage.TOPOLOGY__EDGE_PROPERTIES:
				getEdgeProperties().clear();
				getEdgeProperties().addAll((Collection<? extends EdgeProperties>)newValue);
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
			case TopologyPackage.TOPOLOGY__EDGE_PROPERTIES:
				getEdgeProperties().clear();
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
			case TopologyPackage.TOPOLOGY__EDGE_PROPERTIES:
				return edgeProperties != null && !edgeProperties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TopologyImpl
