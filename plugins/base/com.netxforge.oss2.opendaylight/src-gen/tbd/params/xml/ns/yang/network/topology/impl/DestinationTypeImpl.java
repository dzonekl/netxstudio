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

import tbd.params.xml.ns.yang.network.topology.DestinationType;
import tbd.params.xml.ns.yang.network.topology.TopologyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Destination Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.DestinationTypeImpl#getDestNode <em>Dest Node</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.DestinationTypeImpl#getDestTp <em>Dest Tp</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.DestinationTypeImpl#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DestinationTypeImpl extends MinimalEObjectImpl.Container implements DestinationType {
	/**
	 * The default value of the '{@link #getDestNode() <em>Dest Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestNode()
	 * @generated
	 * @ordered
	 */
	protected static final String DEST_NODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDestNode() <em>Dest Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestNode()
	 * @generated
	 * @ordered
	 */
	protected String destNode = DEST_NODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDestTp() <em>Dest Tp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestTp()
	 * @generated
	 * @ordered
	 */
	protected static final String DEST_TP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDestTp() <em>Dest Tp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestTp()
	 * @generated
	 * @ordered
	 */
	protected String destTp = DEST_TP_EDEFAULT;

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
	protected DestinationTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TopologyPackage.Literals.DESTINATION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDestNode() {
		return destNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestNode(String newDestNode) {
		String oldDestNode = destNode;
		destNode = newDestNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.DESTINATION_TYPE__DEST_NODE, oldDestNode, destNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDestTp() {
		return destTp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestTp(String newDestTp) {
		String oldDestTp = destTp;
		destTp = newDestTp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.DESTINATION_TYPE__DEST_TP, oldDestTp, destTp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, TopologyPackage.DESTINATION_TYPE__ANY);
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
			case TopologyPackage.DESTINATION_TYPE__ANY:
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
			case TopologyPackage.DESTINATION_TYPE__DEST_NODE:
				return getDestNode();
			case TopologyPackage.DESTINATION_TYPE__DEST_TP:
				return getDestTp();
			case TopologyPackage.DESTINATION_TYPE__ANY:
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
			case TopologyPackage.DESTINATION_TYPE__DEST_NODE:
				setDestNode((String)newValue);
				return;
			case TopologyPackage.DESTINATION_TYPE__DEST_TP:
				setDestTp((String)newValue);
				return;
			case TopologyPackage.DESTINATION_TYPE__ANY:
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
			case TopologyPackage.DESTINATION_TYPE__DEST_NODE:
				setDestNode(DEST_NODE_EDEFAULT);
				return;
			case TopologyPackage.DESTINATION_TYPE__DEST_TP:
				setDestTp(DEST_TP_EDEFAULT);
				return;
			case TopologyPackage.DESTINATION_TYPE__ANY:
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
			case TopologyPackage.DESTINATION_TYPE__DEST_NODE:
				return DEST_NODE_EDEFAULT == null ? destNode != null : !DEST_NODE_EDEFAULT.equals(destNode);
			case TopologyPackage.DESTINATION_TYPE__DEST_TP:
				return DEST_TP_EDEFAULT == null ? destTp != null : !DEST_TP_EDEFAULT.equals(destTp);
			case TopologyPackage.DESTINATION_TYPE__ANY:
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
		result.append(" (destNode: ");
		result.append(destNode);
		result.append(", destTp: ");
		result.append(destTp);
		result.append(", any: ");
		result.append(any);
		result.append(')');
		return result.toString();
	}

} //DestinationTypeImpl
