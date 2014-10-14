/**
 */
package tbd.params.xml.ns.yang.network.topology.impl;

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

import tbd.params.xml.ns.yang.network.topology.NodeType;
import tbd.params.xml.ns.yang.network.topology.SupportingNodeType;
import tbd.params.xml.ns.yang.network.topology.TerminationPointType;
import tbd.params.xml.ns.yang.network.topology.TopologyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.NodeTypeImpl#getNodeId <em>Node Id</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.NodeTypeImpl#getSupportingNode <em>Supporting Node</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.NodeTypeImpl#getTerminationPoint <em>Termination Point</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.NodeTypeImpl#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeTypeImpl extends MinimalEObjectImpl.Container implements NodeType {
	/**
	 * The default value of the '{@link #getNodeId() <em>Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeId()
	 * @generated
	 * @ordered
	 */
	protected static final String NODE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNodeId() <em>Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeId()
	 * @generated
	 * @ordered
	 */
	protected String nodeId = NODE_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSupportingNode() <em>Supporting Node</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportingNode()
	 * @generated
	 * @ordered
	 */
	protected EList<SupportingNodeType> supportingNode;

	/**
	 * The cached value of the '{@link #getTerminationPoint() <em>Termination Point</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerminationPoint()
	 * @generated
	 * @ordered
	 */
	protected EList<TerminationPointType> terminationPoint;

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
	protected NodeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TopologyPackage.Literals.NODE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNodeId() {
		return nodeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeId(String newNodeId) {
		String oldNodeId = nodeId;
		nodeId = newNodeId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.NODE_TYPE__NODE_ID, oldNodeId, nodeId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SupportingNodeType> getSupportingNode() {
		if (supportingNode == null) {
			supportingNode = new EObjectContainmentEList<SupportingNodeType>(SupportingNodeType.class, this, TopologyPackage.NODE_TYPE__SUPPORTING_NODE);
		}
		return supportingNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TerminationPointType> getTerminationPoint() {
		if (terminationPoint == null) {
			terminationPoint = new EObjectContainmentEList<TerminationPointType>(TerminationPointType.class, this, TopologyPackage.NODE_TYPE__TERMINATION_POINT);
		}
		return terminationPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, TopologyPackage.NODE_TYPE__ANY);
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
			case TopologyPackage.NODE_TYPE__SUPPORTING_NODE:
				return ((InternalEList<?>)getSupportingNode()).basicRemove(otherEnd, msgs);
			case TopologyPackage.NODE_TYPE__TERMINATION_POINT:
				return ((InternalEList<?>)getTerminationPoint()).basicRemove(otherEnd, msgs);
			case TopologyPackage.NODE_TYPE__ANY:
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
			case TopologyPackage.NODE_TYPE__NODE_ID:
				return getNodeId();
			case TopologyPackage.NODE_TYPE__SUPPORTING_NODE:
				return getSupportingNode();
			case TopologyPackage.NODE_TYPE__TERMINATION_POINT:
				return getTerminationPoint();
			case TopologyPackage.NODE_TYPE__ANY:
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
			case TopologyPackage.NODE_TYPE__NODE_ID:
				setNodeId((String)newValue);
				return;
			case TopologyPackage.NODE_TYPE__SUPPORTING_NODE:
				getSupportingNode().clear();
				getSupportingNode().addAll((Collection<? extends SupportingNodeType>)newValue);
				return;
			case TopologyPackage.NODE_TYPE__TERMINATION_POINT:
				getTerminationPoint().clear();
				getTerminationPoint().addAll((Collection<? extends TerminationPointType>)newValue);
				return;
			case TopologyPackage.NODE_TYPE__ANY:
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
			case TopologyPackage.NODE_TYPE__NODE_ID:
				setNodeId(NODE_ID_EDEFAULT);
				return;
			case TopologyPackage.NODE_TYPE__SUPPORTING_NODE:
				getSupportingNode().clear();
				return;
			case TopologyPackage.NODE_TYPE__TERMINATION_POINT:
				getTerminationPoint().clear();
				return;
			case TopologyPackage.NODE_TYPE__ANY:
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
			case TopologyPackage.NODE_TYPE__NODE_ID:
				return NODE_ID_EDEFAULT == null ? nodeId != null : !NODE_ID_EDEFAULT.equals(nodeId);
			case TopologyPackage.NODE_TYPE__SUPPORTING_NODE:
				return supportingNode != null && !supportingNode.isEmpty();
			case TopologyPackage.NODE_TYPE__TERMINATION_POINT:
				return terminationPoint != null && !terminationPoint.isEmpty();
			case TopologyPackage.NODE_TYPE__ANY:
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
		result.append(" (nodeId: ");
		result.append(nodeId);
		result.append(", any: ");
		result.append(any);
		result.append(')');
		return result.toString();
	}

} //NodeTypeImpl
