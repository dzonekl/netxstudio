/**
 */
package od_core_topology.impl;

import od_core_topology.TopologyPackage;
import od_core_topology.TopologyUserLinkConfig;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Link Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link od_core_topology.impl.TopologyUserLinkConfigImpl#getSrcNodeConnector <em>Src Node Connector</em>}</li>
 *   <li>{@link od_core_topology.impl.TopologyUserLinkConfigImpl#getDstNodeConnector <em>Dst Node Connector</em>}</li>
 *   <li>{@link od_core_topology.impl.TopologyUserLinkConfigImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link od_core_topology.impl.TopologyUserLinkConfigImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TopologyUserLinkConfigImpl extends ConfigurationObjectImpl implements TopologyUserLinkConfig {
	/**
	 * The default value of the '{@link #getSrcNodeConnector() <em>Src Node Connector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcNodeConnector()
	 * @generated
	 * @ordered
	 */
	protected static final String SRC_NODE_CONNECTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSrcNodeConnector() <em>Src Node Connector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcNodeConnector()
	 * @generated
	 * @ordered
	 */
	protected String srcNodeConnector = SRC_NODE_CONNECTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getDstNodeConnector() <em>Dst Node Connector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstNodeConnector()
	 * @generated
	 * @ordered
	 */
	protected static final String DST_NODE_CONNECTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDstNodeConnector() <em>Dst Node Connector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstNodeConnector()
	 * @generated
	 * @ordered
	 */
	protected String dstNodeConnector = DST_NODE_CONNECTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final String STATUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected String status = STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopologyUserLinkConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TopologyPackage.Literals.TOPOLOGY_USER_LINK_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSrcNodeConnector() {
		return srcNodeConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrcNodeConnector(String newSrcNodeConnector) {
		String oldSrcNodeConnector = srcNodeConnector;
		srcNodeConnector = newSrcNodeConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__SRC_NODE_CONNECTOR, oldSrcNodeConnector, srcNodeConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDstNodeConnector() {
		return dstNodeConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDstNodeConnector(String newDstNodeConnector) {
		String oldDstNodeConnector = dstNodeConnector;
		dstNodeConnector = newDstNodeConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__DST_NODE_CONNECTOR, oldDstNodeConnector, dstNodeConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(String newStatus) {
		String oldStatus = status;
		status = newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__SRC_NODE_CONNECTOR:
				return getSrcNodeConnector();
			case TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__DST_NODE_CONNECTOR:
				return getDstNodeConnector();
			case TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__STATUS:
				return getStatus();
			case TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__NAME:
				return getName();
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
			case TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__SRC_NODE_CONNECTOR:
				setSrcNodeConnector((String)newValue);
				return;
			case TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__DST_NODE_CONNECTOR:
				setDstNodeConnector((String)newValue);
				return;
			case TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__STATUS:
				setStatus((String)newValue);
				return;
			case TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__NAME:
				setName((String)newValue);
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
			case TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__SRC_NODE_CONNECTOR:
				setSrcNodeConnector(SRC_NODE_CONNECTOR_EDEFAULT);
				return;
			case TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__DST_NODE_CONNECTOR:
				setDstNodeConnector(DST_NODE_CONNECTOR_EDEFAULT);
				return;
			case TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__NAME:
				setName(NAME_EDEFAULT);
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
			case TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__SRC_NODE_CONNECTOR:
				return SRC_NODE_CONNECTOR_EDEFAULT == null ? srcNodeConnector != null : !SRC_NODE_CONNECTOR_EDEFAULT.equals(srcNodeConnector);
			case TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__DST_NODE_CONNECTOR:
				return DST_NODE_CONNECTOR_EDEFAULT == null ? dstNodeConnector != null : !DST_NODE_CONNECTOR_EDEFAULT.equals(dstNodeConnector);
			case TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
			case TopologyPackage.TOPOLOGY_USER_LINK_CONFIG__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (srcNodeConnector: ");
		result.append(srcNodeConnector);
		result.append(", dstNodeConnector: ");
		result.append(dstNodeConnector);
		result.append(", status: ");
		result.append(status);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //TopologyUserLinkConfigImpl
