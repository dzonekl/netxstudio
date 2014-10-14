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

import tbd.params.xml.ns.yang.network.topology.LinkType;
import tbd.params.xml.ns.yang.network.topology.NodeType;
import tbd.params.xml.ns.yang.network.topology.TopologyPackage;
import tbd.params.xml.ns.yang.network.topology.TopologyType;
import tbd.params.xml.ns.yang.network.topology.TopologyTypesType;
import tbd.params.xml.ns.yang.network.topology.UnderlayTopologyType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.TopologyTypeImpl#getTopologyId <em>Topology Id</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.TopologyTypeImpl#isServerProvided <em>Server Provided</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.TopologyTypeImpl#getTopologyTypes <em>Topology Types</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.TopologyTypeImpl#getUnderlayTopology <em>Underlay Topology</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.TopologyTypeImpl#getNode <em>Node</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.TopologyTypeImpl#getLink <em>Link</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.TopologyTypeImpl#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TopologyTypeImpl extends MinimalEObjectImpl.Container implements TopologyType {
	/**
	 * The default value of the '{@link #getTopologyId() <em>Topology Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopologyId()
	 * @generated
	 * @ordered
	 */
	protected static final String TOPOLOGY_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTopologyId() <em>Topology Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopologyId()
	 * @generated
	 * @ordered
	 */
	protected String topologyId = TOPOLOGY_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isServerProvided() <em>Server Provided</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isServerProvided()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SERVER_PROVIDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isServerProvided() <em>Server Provided</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isServerProvided()
	 * @generated
	 * @ordered
	 */
	protected boolean serverProvided = SERVER_PROVIDED_EDEFAULT;

	/**
	 * This is true if the Server Provided attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean serverProvidedESet;

	/**
	 * The cached value of the '{@link #getTopologyTypes() <em>Topology Types</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopologyTypes()
	 * @generated
	 * @ordered
	 */
	protected TopologyTypesType topologyTypes;

	/**
	 * The cached value of the '{@link #getUnderlayTopology() <em>Underlay Topology</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnderlayTopology()
	 * @generated
	 * @ordered
	 */
	protected EList<UnderlayTopologyType> underlayTopology;

	/**
	 * The cached value of the '{@link #getNode() <em>Node</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeType> node;

	/**
	 * The cached value of the '{@link #getLink() <em>Link</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink()
	 * @generated
	 * @ordered
	 */
	protected EList<LinkType> link;

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
	protected TopologyTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TopologyPackage.Literals.TOPOLOGY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopologyId() {
		return topologyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopologyId(String newTopologyId) {
		String oldTopologyId = topologyId;
		topologyId = newTopologyId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.TOPOLOGY_TYPE__TOPOLOGY_ID, oldTopologyId, topologyId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isServerProvided() {
		return serverProvided;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerProvided(boolean newServerProvided) {
		boolean oldServerProvided = serverProvided;
		serverProvided = newServerProvided;
		boolean oldServerProvidedESet = serverProvidedESet;
		serverProvidedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.TOPOLOGY_TYPE__SERVER_PROVIDED, oldServerProvided, serverProvided, !oldServerProvidedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetServerProvided() {
		boolean oldServerProvided = serverProvided;
		boolean oldServerProvidedESet = serverProvidedESet;
		serverProvided = SERVER_PROVIDED_EDEFAULT;
		serverProvidedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, TopologyPackage.TOPOLOGY_TYPE__SERVER_PROVIDED, oldServerProvided, SERVER_PROVIDED_EDEFAULT, oldServerProvidedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetServerProvided() {
		return serverProvidedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopologyTypesType getTopologyTypes() {
		return topologyTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTopologyTypes(TopologyTypesType newTopologyTypes, NotificationChain msgs) {
		TopologyTypesType oldTopologyTypes = topologyTypes;
		topologyTypes = newTopologyTypes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TopologyPackage.TOPOLOGY_TYPE__TOPOLOGY_TYPES, oldTopologyTypes, newTopologyTypes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopologyTypes(TopologyTypesType newTopologyTypes) {
		if (newTopologyTypes != topologyTypes) {
			NotificationChain msgs = null;
			if (topologyTypes != null)
				msgs = ((InternalEObject)topologyTypes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TopologyPackage.TOPOLOGY_TYPE__TOPOLOGY_TYPES, null, msgs);
			if (newTopologyTypes != null)
				msgs = ((InternalEObject)newTopologyTypes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TopologyPackage.TOPOLOGY_TYPE__TOPOLOGY_TYPES, null, msgs);
			msgs = basicSetTopologyTypes(newTopologyTypes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.TOPOLOGY_TYPE__TOPOLOGY_TYPES, newTopologyTypes, newTopologyTypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnderlayTopologyType> getUnderlayTopology() {
		if (underlayTopology == null) {
			underlayTopology = new EObjectContainmentEList<UnderlayTopologyType>(UnderlayTopologyType.class, this, TopologyPackage.TOPOLOGY_TYPE__UNDERLAY_TOPOLOGY);
		}
		return underlayTopology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NodeType> getNode() {
		if (node == null) {
			node = new EObjectContainmentEList<NodeType>(NodeType.class, this, TopologyPackage.TOPOLOGY_TYPE__NODE);
		}
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LinkType> getLink() {
		if (link == null) {
			link = new EObjectContainmentEList<LinkType>(LinkType.class, this, TopologyPackage.TOPOLOGY_TYPE__LINK);
		}
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, TopologyPackage.TOPOLOGY_TYPE__ANY);
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
			case TopologyPackage.TOPOLOGY_TYPE__TOPOLOGY_TYPES:
				return basicSetTopologyTypes(null, msgs);
			case TopologyPackage.TOPOLOGY_TYPE__UNDERLAY_TOPOLOGY:
				return ((InternalEList<?>)getUnderlayTopology()).basicRemove(otherEnd, msgs);
			case TopologyPackage.TOPOLOGY_TYPE__NODE:
				return ((InternalEList<?>)getNode()).basicRemove(otherEnd, msgs);
			case TopologyPackage.TOPOLOGY_TYPE__LINK:
				return ((InternalEList<?>)getLink()).basicRemove(otherEnd, msgs);
			case TopologyPackage.TOPOLOGY_TYPE__ANY:
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
			case TopologyPackage.TOPOLOGY_TYPE__TOPOLOGY_ID:
				return getTopologyId();
			case TopologyPackage.TOPOLOGY_TYPE__SERVER_PROVIDED:
				return isServerProvided();
			case TopologyPackage.TOPOLOGY_TYPE__TOPOLOGY_TYPES:
				return getTopologyTypes();
			case TopologyPackage.TOPOLOGY_TYPE__UNDERLAY_TOPOLOGY:
				return getUnderlayTopology();
			case TopologyPackage.TOPOLOGY_TYPE__NODE:
				return getNode();
			case TopologyPackage.TOPOLOGY_TYPE__LINK:
				return getLink();
			case TopologyPackage.TOPOLOGY_TYPE__ANY:
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
			case TopologyPackage.TOPOLOGY_TYPE__TOPOLOGY_ID:
				setTopologyId((String)newValue);
				return;
			case TopologyPackage.TOPOLOGY_TYPE__SERVER_PROVIDED:
				setServerProvided((Boolean)newValue);
				return;
			case TopologyPackage.TOPOLOGY_TYPE__TOPOLOGY_TYPES:
				setTopologyTypes((TopologyTypesType)newValue);
				return;
			case TopologyPackage.TOPOLOGY_TYPE__UNDERLAY_TOPOLOGY:
				getUnderlayTopology().clear();
				getUnderlayTopology().addAll((Collection<? extends UnderlayTopologyType>)newValue);
				return;
			case TopologyPackage.TOPOLOGY_TYPE__NODE:
				getNode().clear();
				getNode().addAll((Collection<? extends NodeType>)newValue);
				return;
			case TopologyPackage.TOPOLOGY_TYPE__LINK:
				getLink().clear();
				getLink().addAll((Collection<? extends LinkType>)newValue);
				return;
			case TopologyPackage.TOPOLOGY_TYPE__ANY:
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
			case TopologyPackage.TOPOLOGY_TYPE__TOPOLOGY_ID:
				setTopologyId(TOPOLOGY_ID_EDEFAULT);
				return;
			case TopologyPackage.TOPOLOGY_TYPE__SERVER_PROVIDED:
				unsetServerProvided();
				return;
			case TopologyPackage.TOPOLOGY_TYPE__TOPOLOGY_TYPES:
				setTopologyTypes((TopologyTypesType)null);
				return;
			case TopologyPackage.TOPOLOGY_TYPE__UNDERLAY_TOPOLOGY:
				getUnderlayTopology().clear();
				return;
			case TopologyPackage.TOPOLOGY_TYPE__NODE:
				getNode().clear();
				return;
			case TopologyPackage.TOPOLOGY_TYPE__LINK:
				getLink().clear();
				return;
			case TopologyPackage.TOPOLOGY_TYPE__ANY:
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
			case TopologyPackage.TOPOLOGY_TYPE__TOPOLOGY_ID:
				return TOPOLOGY_ID_EDEFAULT == null ? topologyId != null : !TOPOLOGY_ID_EDEFAULT.equals(topologyId);
			case TopologyPackage.TOPOLOGY_TYPE__SERVER_PROVIDED:
				return isSetServerProvided();
			case TopologyPackage.TOPOLOGY_TYPE__TOPOLOGY_TYPES:
				return topologyTypes != null;
			case TopologyPackage.TOPOLOGY_TYPE__UNDERLAY_TOPOLOGY:
				return underlayTopology != null && !underlayTopology.isEmpty();
			case TopologyPackage.TOPOLOGY_TYPE__NODE:
				return node != null && !node.isEmpty();
			case TopologyPackage.TOPOLOGY_TYPE__LINK:
				return link != null && !link.isEmpty();
			case TopologyPackage.TOPOLOGY_TYPE__ANY:
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
		result.append(" (topologyId: ");
		result.append(topologyId);
		result.append(", serverProvided: ");
		if (serverProvidedESet) result.append(serverProvided); else result.append("<unset>");
		result.append(", any: ");
		result.append(any);
		result.append(')');
		return result.toString();
	}

} //TopologyTypeImpl
