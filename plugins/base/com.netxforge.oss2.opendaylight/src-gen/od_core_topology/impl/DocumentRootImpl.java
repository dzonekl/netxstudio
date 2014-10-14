/**
 */
package od_core_topology.impl;

import od_core_topology.DocumentRoot;
import od_core_topology.Edge;
import od_core_topology.EdgeProperties;
import od_core_topology.Node;
import od_core_topology.NodeConnector;
import od_core_topology.Property;
import od_core_topology.Topology;
import od_core_topology.TopologyPackage;
import od_core_topology.TopologyUserLinkConfig;
import od_core_topology.TopologyUserLinks;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link od_core_topology.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link od_core_topology.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link od_core_topology.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link od_core_topology.impl.DocumentRootImpl#getEdge <em>Edge</em>}</li>
 *   <li>{@link od_core_topology.impl.DocumentRootImpl#getEdgeProperties <em>Edge Properties</em>}</li>
 *   <li>{@link od_core_topology.impl.DocumentRootImpl#getList <em>List</em>}</li>
 *   <li>{@link od_core_topology.impl.DocumentRootImpl#getNode <em>Node</em>}</li>
 *   <li>{@link od_core_topology.impl.DocumentRootImpl#getNodeConnector <em>Node Connector</em>}</li>
 *   <li>{@link od_core_topology.impl.DocumentRootImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link od_core_topology.impl.DocumentRootImpl#getTopology <em>Topology</em>}</li>
 *   <li>{@link od_core_topology.impl.DocumentRootImpl#getTopologyUserLinkConfig <em>Topology User Link Config</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends MinimalEObjectImpl.Container implements DocumentRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TopologyPackage.Literals.DOCUMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, TopologyPackage.DOCUMENT_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, TopologyPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, TopologyPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge getEdge() {
		return (Edge)getMixed().get(TopologyPackage.Literals.DOCUMENT_ROOT__EDGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEdge(Edge newEdge, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(TopologyPackage.Literals.DOCUMENT_ROOT__EDGE, newEdge, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdge(Edge newEdge) {
		((FeatureMap.Internal)getMixed()).set(TopologyPackage.Literals.DOCUMENT_ROOT__EDGE, newEdge);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdgeProperties getEdgeProperties() {
		return (EdgeProperties)getMixed().get(TopologyPackage.Literals.DOCUMENT_ROOT__EDGE_PROPERTIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEdgeProperties(EdgeProperties newEdgeProperties, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(TopologyPackage.Literals.DOCUMENT_ROOT__EDGE_PROPERTIES, newEdgeProperties, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeProperties(EdgeProperties newEdgeProperties) {
		((FeatureMap.Internal)getMixed()).set(TopologyPackage.Literals.DOCUMENT_ROOT__EDGE_PROPERTIES, newEdgeProperties);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopologyUserLinks getList() {
		return (TopologyUserLinks)getMixed().get(TopologyPackage.Literals.DOCUMENT_ROOT__LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetList(TopologyUserLinks newList, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(TopologyPackage.Literals.DOCUMENT_ROOT__LIST, newList, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setList(TopologyUserLinks newList) {
		((FeatureMap.Internal)getMixed()).set(TopologyPackage.Literals.DOCUMENT_ROOT__LIST, newList);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getNode() {
		return (Node)getMixed().get(TopologyPackage.Literals.DOCUMENT_ROOT__NODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode(Node newNode, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(TopologyPackage.Literals.DOCUMENT_ROOT__NODE, newNode, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode(Node newNode) {
		((FeatureMap.Internal)getMixed()).set(TopologyPackage.Literals.DOCUMENT_ROOT__NODE, newNode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeConnector getNodeConnector() {
		return (NodeConnector)getMixed().get(TopologyPackage.Literals.DOCUMENT_ROOT__NODE_CONNECTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNodeConnector(NodeConnector newNodeConnector, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(TopologyPackage.Literals.DOCUMENT_ROOT__NODE_CONNECTOR, newNodeConnector, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeConnector(NodeConnector newNodeConnector) {
		((FeatureMap.Internal)getMixed()).set(TopologyPackage.Literals.DOCUMENT_ROOT__NODE_CONNECTOR, newNodeConnector);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getProperty() {
		return (Property)getMixed().get(TopologyPackage.Literals.DOCUMENT_ROOT__PROPERTY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperty(Property newProperty, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(TopologyPackage.Literals.DOCUMENT_ROOT__PROPERTY, newProperty, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(Property newProperty) {
		((FeatureMap.Internal)getMixed()).set(TopologyPackage.Literals.DOCUMENT_ROOT__PROPERTY, newProperty);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Topology getTopology() {
		return (Topology)getMixed().get(TopologyPackage.Literals.DOCUMENT_ROOT__TOPOLOGY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTopology(Topology newTopology, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(TopologyPackage.Literals.DOCUMENT_ROOT__TOPOLOGY, newTopology, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopology(Topology newTopology) {
		((FeatureMap.Internal)getMixed()).set(TopologyPackage.Literals.DOCUMENT_ROOT__TOPOLOGY, newTopology);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopologyUserLinkConfig getTopologyUserLinkConfig() {
		return (TopologyUserLinkConfig)getMixed().get(TopologyPackage.Literals.DOCUMENT_ROOT__TOPOLOGY_USER_LINK_CONFIG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTopologyUserLinkConfig(TopologyUserLinkConfig newTopologyUserLinkConfig, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(TopologyPackage.Literals.DOCUMENT_ROOT__TOPOLOGY_USER_LINK_CONFIG, newTopologyUserLinkConfig, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopologyUserLinkConfig(TopologyUserLinkConfig newTopologyUserLinkConfig) {
		((FeatureMap.Internal)getMixed()).set(TopologyPackage.Literals.DOCUMENT_ROOT__TOPOLOGY_USER_LINK_CONFIG, newTopologyUserLinkConfig);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TopologyPackage.DOCUMENT_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case TopologyPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case TopologyPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case TopologyPackage.DOCUMENT_ROOT__EDGE:
				return basicSetEdge(null, msgs);
			case TopologyPackage.DOCUMENT_ROOT__EDGE_PROPERTIES:
				return basicSetEdgeProperties(null, msgs);
			case TopologyPackage.DOCUMENT_ROOT__LIST:
				return basicSetList(null, msgs);
			case TopologyPackage.DOCUMENT_ROOT__NODE:
				return basicSetNode(null, msgs);
			case TopologyPackage.DOCUMENT_ROOT__NODE_CONNECTOR:
				return basicSetNodeConnector(null, msgs);
			case TopologyPackage.DOCUMENT_ROOT__PROPERTY:
				return basicSetProperty(null, msgs);
			case TopologyPackage.DOCUMENT_ROOT__TOPOLOGY:
				return basicSetTopology(null, msgs);
			case TopologyPackage.DOCUMENT_ROOT__TOPOLOGY_USER_LINK_CONFIG:
				return basicSetTopologyUserLinkConfig(null, msgs);
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
			case TopologyPackage.DOCUMENT_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case TopologyPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case TopologyPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case TopologyPackage.DOCUMENT_ROOT__EDGE:
				return getEdge();
			case TopologyPackage.DOCUMENT_ROOT__EDGE_PROPERTIES:
				return getEdgeProperties();
			case TopologyPackage.DOCUMENT_ROOT__LIST:
				return getList();
			case TopologyPackage.DOCUMENT_ROOT__NODE:
				return getNode();
			case TopologyPackage.DOCUMENT_ROOT__NODE_CONNECTOR:
				return getNodeConnector();
			case TopologyPackage.DOCUMENT_ROOT__PROPERTY:
				return getProperty();
			case TopologyPackage.DOCUMENT_ROOT__TOPOLOGY:
				return getTopology();
			case TopologyPackage.DOCUMENT_ROOT__TOPOLOGY_USER_LINK_CONFIG:
				return getTopologyUserLinkConfig();
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
			case TopologyPackage.DOCUMENT_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case TopologyPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case TopologyPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case TopologyPackage.DOCUMENT_ROOT__EDGE:
				setEdge((Edge)newValue);
				return;
			case TopologyPackage.DOCUMENT_ROOT__EDGE_PROPERTIES:
				setEdgeProperties((EdgeProperties)newValue);
				return;
			case TopologyPackage.DOCUMENT_ROOT__LIST:
				setList((TopologyUserLinks)newValue);
				return;
			case TopologyPackage.DOCUMENT_ROOT__NODE:
				setNode((Node)newValue);
				return;
			case TopologyPackage.DOCUMENT_ROOT__NODE_CONNECTOR:
				setNodeConnector((NodeConnector)newValue);
				return;
			case TopologyPackage.DOCUMENT_ROOT__PROPERTY:
				setProperty((Property)newValue);
				return;
			case TopologyPackage.DOCUMENT_ROOT__TOPOLOGY:
				setTopology((Topology)newValue);
				return;
			case TopologyPackage.DOCUMENT_ROOT__TOPOLOGY_USER_LINK_CONFIG:
				setTopologyUserLinkConfig((TopologyUserLinkConfig)newValue);
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
			case TopologyPackage.DOCUMENT_ROOT__MIXED:
				getMixed().clear();
				return;
			case TopologyPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case TopologyPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case TopologyPackage.DOCUMENT_ROOT__EDGE:
				setEdge((Edge)null);
				return;
			case TopologyPackage.DOCUMENT_ROOT__EDGE_PROPERTIES:
				setEdgeProperties((EdgeProperties)null);
				return;
			case TopologyPackage.DOCUMENT_ROOT__LIST:
				setList((TopologyUserLinks)null);
				return;
			case TopologyPackage.DOCUMENT_ROOT__NODE:
				setNode((Node)null);
				return;
			case TopologyPackage.DOCUMENT_ROOT__NODE_CONNECTOR:
				setNodeConnector((NodeConnector)null);
				return;
			case TopologyPackage.DOCUMENT_ROOT__PROPERTY:
				setProperty((Property)null);
				return;
			case TopologyPackage.DOCUMENT_ROOT__TOPOLOGY:
				setTopology((Topology)null);
				return;
			case TopologyPackage.DOCUMENT_ROOT__TOPOLOGY_USER_LINK_CONFIG:
				setTopologyUserLinkConfig((TopologyUserLinkConfig)null);
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
			case TopologyPackage.DOCUMENT_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case TopologyPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case TopologyPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case TopologyPackage.DOCUMENT_ROOT__EDGE:
				return getEdge() != null;
			case TopologyPackage.DOCUMENT_ROOT__EDGE_PROPERTIES:
				return getEdgeProperties() != null;
			case TopologyPackage.DOCUMENT_ROOT__LIST:
				return getList() != null;
			case TopologyPackage.DOCUMENT_ROOT__NODE:
				return getNode() != null;
			case TopologyPackage.DOCUMENT_ROOT__NODE_CONNECTOR:
				return getNodeConnector() != null;
			case TopologyPackage.DOCUMENT_ROOT__PROPERTY:
				return getProperty() != null;
			case TopologyPackage.DOCUMENT_ROOT__TOPOLOGY:
				return getTopology() != null;
			case TopologyPackage.DOCUMENT_ROOT__TOPOLOGY_USER_LINK_CONFIG:
				return getTopologyUserLinkConfig() != null;
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //DocumentRootImpl
