/**
 */
package od_core_topology.impl;

import od_core_topology.Edge;
import od_core_topology.NodeConnector;
import od_core_topology.TopologyPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link od_core_topology.impl.EdgeImpl#getTailNodeConnector <em>Tail Node Connector</em>}</li>
 *   <li>{@link od_core_topology.impl.EdgeImpl#getHeadNodeConnector <em>Head Node Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeImpl extends MinimalEObjectImpl.Container implements Edge {
	/**
	 * The cached value of the '{@link #getTailNodeConnector() <em>Tail Node Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTailNodeConnector()
	 * @generated
	 * @ordered
	 */
	protected NodeConnector tailNodeConnector;

	/**
	 * The cached value of the '{@link #getHeadNodeConnector() <em>Head Node Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeadNodeConnector()
	 * @generated
	 * @ordered
	 */
	protected NodeConnector headNodeConnector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TopologyPackage.Literals.EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeConnector getTailNodeConnector() {
		return tailNodeConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTailNodeConnector(NodeConnector newTailNodeConnector, NotificationChain msgs) {
		NodeConnector oldTailNodeConnector = tailNodeConnector;
		tailNodeConnector = newTailNodeConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TopologyPackage.EDGE__TAIL_NODE_CONNECTOR, oldTailNodeConnector, newTailNodeConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTailNodeConnector(NodeConnector newTailNodeConnector) {
		if (newTailNodeConnector != tailNodeConnector) {
			NotificationChain msgs = null;
			if (tailNodeConnector != null)
				msgs = ((InternalEObject)tailNodeConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TopologyPackage.EDGE__TAIL_NODE_CONNECTOR, null, msgs);
			if (newTailNodeConnector != null)
				msgs = ((InternalEObject)newTailNodeConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TopologyPackage.EDGE__TAIL_NODE_CONNECTOR, null, msgs);
			msgs = basicSetTailNodeConnector(newTailNodeConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.EDGE__TAIL_NODE_CONNECTOR, newTailNodeConnector, newTailNodeConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeConnector getHeadNodeConnector() {
		return headNodeConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeadNodeConnector(NodeConnector newHeadNodeConnector, NotificationChain msgs) {
		NodeConnector oldHeadNodeConnector = headNodeConnector;
		headNodeConnector = newHeadNodeConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TopologyPackage.EDGE__HEAD_NODE_CONNECTOR, oldHeadNodeConnector, newHeadNodeConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeadNodeConnector(NodeConnector newHeadNodeConnector) {
		if (newHeadNodeConnector != headNodeConnector) {
			NotificationChain msgs = null;
			if (headNodeConnector != null)
				msgs = ((InternalEObject)headNodeConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TopologyPackage.EDGE__HEAD_NODE_CONNECTOR, null, msgs);
			if (newHeadNodeConnector != null)
				msgs = ((InternalEObject)newHeadNodeConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TopologyPackage.EDGE__HEAD_NODE_CONNECTOR, null, msgs);
			msgs = basicSetHeadNodeConnector(newHeadNodeConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.EDGE__HEAD_NODE_CONNECTOR, newHeadNodeConnector, newHeadNodeConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TopologyPackage.EDGE__TAIL_NODE_CONNECTOR:
				return basicSetTailNodeConnector(null, msgs);
			case TopologyPackage.EDGE__HEAD_NODE_CONNECTOR:
				return basicSetHeadNodeConnector(null, msgs);
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
			case TopologyPackage.EDGE__TAIL_NODE_CONNECTOR:
				return getTailNodeConnector();
			case TopologyPackage.EDGE__HEAD_NODE_CONNECTOR:
				return getHeadNodeConnector();
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
			case TopologyPackage.EDGE__TAIL_NODE_CONNECTOR:
				setTailNodeConnector((NodeConnector)newValue);
				return;
			case TopologyPackage.EDGE__HEAD_NODE_CONNECTOR:
				setHeadNodeConnector((NodeConnector)newValue);
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
			case TopologyPackage.EDGE__TAIL_NODE_CONNECTOR:
				setTailNodeConnector((NodeConnector)null);
				return;
			case TopologyPackage.EDGE__HEAD_NODE_CONNECTOR:
				setHeadNodeConnector((NodeConnector)null);
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
			case TopologyPackage.EDGE__TAIL_NODE_CONNECTOR:
				return tailNodeConnector != null;
			case TopologyPackage.EDGE__HEAD_NODE_CONNECTOR:
				return headNodeConnector != null;
		}
		return super.eIsSet(featureID);
	}

} //EdgeImpl
