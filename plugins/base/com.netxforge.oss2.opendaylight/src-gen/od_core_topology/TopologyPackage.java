/**
 */
package od_core_topology;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see od_core_topology.TopologyFactory
 * @model kind="package"
 *        extendedMetaData="qualified='false'"
 * @generated
 */
public interface TopologyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "od_core_topology";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/resource/com.netxforge.oss2.opendaylight/model/xsd/topology.xsd";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "od_core_topology";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TopologyPackage eINSTANCE = od_core_topology.impl.TopologyPackageImpl.init();

	/**
	 * The meta object id for the '{@link od_core_topology.impl.ConfigurationObjectImpl <em>Configuration Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see od_core_topology.impl.ConfigurationObjectImpl
	 * @see od_core_topology.impl.TopologyPackageImpl#getConfigurationObject()
	 * @generated
	 */
	int CONFIGURATION_OBJECT = 0;

	/**
	 * The number of structural features of the '<em>Configuration Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OBJECT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Configuration Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link od_core_topology.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see od_core_topology.impl.DocumentRootImpl
	 * @see od_core_topology.impl.TopologyPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__EDGE = 3;

	/**
	 * The feature id for the '<em><b>Edge Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__EDGE_PROPERTIES = 4;

	/**
	 * The feature id for the '<em><b>List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__LIST = 5;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__NODE = 6;

	/**
	 * The feature id for the '<em><b>Node Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__NODE_CONNECTOR = 7;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PROPERTY = 8;

	/**
	 * The feature id for the '<em><b>Topology</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TOPOLOGY = 9;

	/**
	 * The feature id for the '<em><b>Topology User Link Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TOPOLOGY_USER_LINK_CONFIG = 10;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link od_core_topology.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see od_core_topology.impl.EdgeImpl
	 * @see od_core_topology.impl.TopologyPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 2;

	/**
	 * The feature id for the '<em><b>Tail Node Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TAIL_NODE_CONNECTOR = 0;

	/**
	 * The feature id for the '<em><b>Head Node Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__HEAD_NODE_CONNECTOR = 1;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link od_core_topology.impl.EdgePropertiesImpl <em>Edge Properties</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see od_core_topology.impl.EdgePropertiesImpl
	 * @see od_core_topology.impl.TopologyPackageImpl#getEdgeProperties()
	 * @generated
	 */
	int EDGE_PROPERTIES = 3;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PROPERTIES__EDGE = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PROPERTIES__PROPERTIES = 1;

	/**
	 * The number of structural features of the '<em>Edge Properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PROPERTIES_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Edge Properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_PROPERTIES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link od_core_topology.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see od_core_topology.impl.NodeImpl
	 * @see od_core_topology.impl.TopologyPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ID = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link od_core_topology.impl.NodeConnectorImpl <em>Node Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see od_core_topology.impl.NodeConnectorImpl
	 * @see od_core_topology.impl.TopologyPackageImpl#getNodeConnector()
	 * @generated
	 */
	int NODE_CONNECTOR = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTOR__ID = 0;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTOR__NODE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTOR__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Node Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTOR_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Node Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link od_core_topology.impl.PropertiesTypeImpl <em>Properties Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see od_core_topology.impl.PropertiesTypeImpl
	 * @see od_core_topology.impl.TopologyPackageImpl#getPropertiesType()
	 * @generated
	 */
	int PROPERTIES_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_TYPE__PROPERTY = 0;

	/**
	 * The number of structural features of the '<em>Properties Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Properties Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link od_core_topology.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see od_core_topology.impl.PropertyImpl
	 * @see od_core_topology.impl.TopologyPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 7;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link od_core_topology.impl.TopologyImpl <em>Topology</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see od_core_topology.impl.TopologyImpl
	 * @see od_core_topology.impl.TopologyPackageImpl#getTopology()
	 * @generated
	 */
	int TOPOLOGY = 8;

	/**
	 * The feature id for the '<em><b>Edge Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__EDGE_PROPERTIES = 0;

	/**
	 * The number of structural features of the '<em>Topology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Topology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link od_core_topology.impl.TopologyUserLinkConfigImpl <em>User Link Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see od_core_topology.impl.TopologyUserLinkConfigImpl
	 * @see od_core_topology.impl.TopologyPackageImpl#getTopologyUserLinkConfig()
	 * @generated
	 */
	int TOPOLOGY_USER_LINK_CONFIG = 9;

	/**
	 * The feature id for the '<em><b>Src Node Connector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_USER_LINK_CONFIG__SRC_NODE_CONNECTOR = CONFIGURATION_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dst Node Connector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_USER_LINK_CONFIG__DST_NODE_CONNECTOR = CONFIGURATION_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_USER_LINK_CONFIG__STATUS = CONFIGURATION_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_USER_LINK_CONFIG__NAME = CONFIGURATION_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>User Link Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_USER_LINK_CONFIG_FEATURE_COUNT = CONFIGURATION_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>User Link Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_USER_LINK_CONFIG_OPERATION_COUNT = CONFIGURATION_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link od_core_topology.impl.TopologyUserLinksImpl <em>User Links</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see od_core_topology.impl.TopologyUserLinksImpl
	 * @see od_core_topology.impl.TopologyPackageImpl#getTopologyUserLinks()
	 * @generated
	 */
	int TOPOLOGY_USER_LINKS = 10;

	/**
	 * The feature id for the '<em><b>User Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_USER_LINKS__USER_LINKS = 0;

	/**
	 * The number of structural features of the '<em>User Links</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_USER_LINKS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>User Links</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_USER_LINKS_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link od_core_topology.ConfigurationObject <em>Configuration Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration Object</em>'.
	 * @see od_core_topology.ConfigurationObject
	 * @generated
	 */
	EClass getConfigurationObject();

	/**
	 * Returns the meta object for class '{@link od_core_topology.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see od_core_topology.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link od_core_topology.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see od_core_topology.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link od_core_topology.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see od_core_topology.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link od_core_topology.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see od_core_topology.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link od_core_topology.DocumentRoot#getEdge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Edge</em>'.
	 * @see od_core_topology.DocumentRoot#getEdge()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Edge();

	/**
	 * Returns the meta object for the containment reference '{@link od_core_topology.DocumentRoot#getEdgeProperties <em>Edge Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Edge Properties</em>'.
	 * @see od_core_topology.DocumentRoot#getEdgeProperties()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_EdgeProperties();

	/**
	 * Returns the meta object for the containment reference '{@link od_core_topology.DocumentRoot#getList <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>List</em>'.
	 * @see od_core_topology.DocumentRoot#getList()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_List();

	/**
	 * Returns the meta object for the containment reference '{@link od_core_topology.DocumentRoot#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Node</em>'.
	 * @see od_core_topology.DocumentRoot#getNode()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Node();

	/**
	 * Returns the meta object for the containment reference '{@link od_core_topology.DocumentRoot#getNodeConnector <em>Node Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Node Connector</em>'.
	 * @see od_core_topology.DocumentRoot#getNodeConnector()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_NodeConnector();

	/**
	 * Returns the meta object for the containment reference '{@link od_core_topology.DocumentRoot#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Property</em>'.
	 * @see od_core_topology.DocumentRoot#getProperty()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Property();

	/**
	 * Returns the meta object for the containment reference '{@link od_core_topology.DocumentRoot#getTopology <em>Topology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Topology</em>'.
	 * @see od_core_topology.DocumentRoot#getTopology()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Topology();

	/**
	 * Returns the meta object for the containment reference '{@link od_core_topology.DocumentRoot#getTopologyUserLinkConfig <em>Topology User Link Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Topology User Link Config</em>'.
	 * @see od_core_topology.DocumentRoot#getTopologyUserLinkConfig()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_TopologyUserLinkConfig();

	/**
	 * Returns the meta object for class '{@link od_core_topology.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see od_core_topology.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the containment reference '{@link od_core_topology.Edge#getTailNodeConnector <em>Tail Node Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tail Node Connector</em>'.
	 * @see od_core_topology.Edge#getTailNodeConnector()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_TailNodeConnector();

	/**
	 * Returns the meta object for the containment reference '{@link od_core_topology.Edge#getHeadNodeConnector <em>Head Node Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Head Node Connector</em>'.
	 * @see od_core_topology.Edge#getHeadNodeConnector()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_HeadNodeConnector();

	/**
	 * Returns the meta object for class '{@link od_core_topology.EdgeProperties <em>Edge Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Properties</em>'.
	 * @see od_core_topology.EdgeProperties
	 * @generated
	 */
	EClass getEdgeProperties();

	/**
	 * Returns the meta object for the containment reference '{@link od_core_topology.EdgeProperties#getEdge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Edge</em>'.
	 * @see od_core_topology.EdgeProperties#getEdge()
	 * @see #getEdgeProperties()
	 * @generated
	 */
	EReference getEdgeProperties_Edge();

	/**
	 * Returns the meta object for the containment reference '{@link od_core_topology.EdgeProperties#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Properties</em>'.
	 * @see od_core_topology.EdgeProperties#getProperties()
	 * @see #getEdgeProperties()
	 * @generated
	 */
	EReference getEdgeProperties_Properties();

	/**
	 * Returns the meta object for class '{@link od_core_topology.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see od_core_topology.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link od_core_topology.Node#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see od_core_topology.Node#getId()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Id();

	/**
	 * Returns the meta object for the attribute '{@link od_core_topology.Node#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see od_core_topology.Node#getType()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Type();

	/**
	 * Returns the meta object for class '{@link od_core_topology.NodeConnector <em>Node Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Connector</em>'.
	 * @see od_core_topology.NodeConnector
	 * @generated
	 */
	EClass getNodeConnector();

	/**
	 * Returns the meta object for the attribute '{@link od_core_topology.NodeConnector#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see od_core_topology.NodeConnector#getId()
	 * @see #getNodeConnector()
	 * @generated
	 */
	EAttribute getNodeConnector_Id();

	/**
	 * Returns the meta object for the containment reference '{@link od_core_topology.NodeConnector#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Node</em>'.
	 * @see od_core_topology.NodeConnector#getNode()
	 * @see #getNodeConnector()
	 * @generated
	 */
	EReference getNodeConnector_Node();

	/**
	 * Returns the meta object for the attribute '{@link od_core_topology.NodeConnector#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see od_core_topology.NodeConnector#getType()
	 * @see #getNodeConnector()
	 * @generated
	 */
	EAttribute getNodeConnector_Type();

	/**
	 * Returns the meta object for class '{@link od_core_topology.PropertiesType <em>Properties Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Properties Type</em>'.
	 * @see od_core_topology.PropertiesType
	 * @generated
	 */
	EClass getPropertiesType();

	/**
	 * Returns the meta object for the containment reference list '{@link od_core_topology.PropertiesType#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property</em>'.
	 * @see od_core_topology.PropertiesType#getProperty()
	 * @see #getPropertiesType()
	 * @generated
	 */
	EReference getPropertiesType_Property();

	/**
	 * Returns the meta object for class '{@link od_core_topology.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see od_core_topology.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for class '{@link od_core_topology.Topology <em>Topology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Topology</em>'.
	 * @see od_core_topology.Topology
	 * @generated
	 */
	EClass getTopology();

	/**
	 * Returns the meta object for the containment reference list '{@link od_core_topology.Topology#getEdgeProperties <em>Edge Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edge Properties</em>'.
	 * @see od_core_topology.Topology#getEdgeProperties()
	 * @see #getTopology()
	 * @generated
	 */
	EReference getTopology_EdgeProperties();

	/**
	 * Returns the meta object for class '{@link od_core_topology.TopologyUserLinkConfig <em>User Link Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Link Config</em>'.
	 * @see od_core_topology.TopologyUserLinkConfig
	 * @generated
	 */
	EClass getTopologyUserLinkConfig();

	/**
	 * Returns the meta object for the attribute '{@link od_core_topology.TopologyUserLinkConfig#getSrcNodeConnector <em>Src Node Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Node Connector</em>'.
	 * @see od_core_topology.TopologyUserLinkConfig#getSrcNodeConnector()
	 * @see #getTopologyUserLinkConfig()
	 * @generated
	 */
	EAttribute getTopologyUserLinkConfig_SrcNodeConnector();

	/**
	 * Returns the meta object for the attribute '{@link od_core_topology.TopologyUserLinkConfig#getDstNodeConnector <em>Dst Node Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Node Connector</em>'.
	 * @see od_core_topology.TopologyUserLinkConfig#getDstNodeConnector()
	 * @see #getTopologyUserLinkConfig()
	 * @generated
	 */
	EAttribute getTopologyUserLinkConfig_DstNodeConnector();

	/**
	 * Returns the meta object for the attribute '{@link od_core_topology.TopologyUserLinkConfig#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see od_core_topology.TopologyUserLinkConfig#getStatus()
	 * @see #getTopologyUserLinkConfig()
	 * @generated
	 */
	EAttribute getTopologyUserLinkConfig_Status();

	/**
	 * Returns the meta object for the attribute '{@link od_core_topology.TopologyUserLinkConfig#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see od_core_topology.TopologyUserLinkConfig#getName()
	 * @see #getTopologyUserLinkConfig()
	 * @generated
	 */
	EAttribute getTopologyUserLinkConfig_Name();

	/**
	 * Returns the meta object for class '{@link od_core_topology.TopologyUserLinks <em>User Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Links</em>'.
	 * @see od_core_topology.TopologyUserLinks
	 * @generated
	 */
	EClass getTopologyUserLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link od_core_topology.TopologyUserLinks#getUserLinks <em>User Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>User Links</em>'.
	 * @see od_core_topology.TopologyUserLinks#getUserLinks()
	 * @see #getTopologyUserLinks()
	 * @generated
	 */
	EReference getTopologyUserLinks_UserLinks();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TopologyFactory getTopologyFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link od_core_topology.impl.ConfigurationObjectImpl <em>Configuration Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see od_core_topology.impl.ConfigurationObjectImpl
		 * @see od_core_topology.impl.TopologyPackageImpl#getConfigurationObject()
		 * @generated
		 */
		EClass CONFIGURATION_OBJECT = eINSTANCE.getConfigurationObject();

		/**
		 * The meta object literal for the '{@link od_core_topology.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see od_core_topology.impl.DocumentRootImpl
		 * @see od_core_topology.impl.TopologyPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Edge</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__EDGE = eINSTANCE.getDocumentRoot_Edge();

		/**
		 * The meta object literal for the '<em><b>Edge Properties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__EDGE_PROPERTIES = eINSTANCE.getDocumentRoot_EdgeProperties();

		/**
		 * The meta object literal for the '<em><b>List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__LIST = eINSTANCE.getDocumentRoot_List();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__NODE = eINSTANCE.getDocumentRoot_Node();

		/**
		 * The meta object literal for the '<em><b>Node Connector</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__NODE_CONNECTOR = eINSTANCE.getDocumentRoot_NodeConnector();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PROPERTY = eINSTANCE.getDocumentRoot_Property();

		/**
		 * The meta object literal for the '<em><b>Topology</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TOPOLOGY = eINSTANCE.getDocumentRoot_Topology();

		/**
		 * The meta object literal for the '<em><b>Topology User Link Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TOPOLOGY_USER_LINK_CONFIG = eINSTANCE.getDocumentRoot_TopologyUserLinkConfig();

		/**
		 * The meta object literal for the '{@link od_core_topology.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see od_core_topology.impl.EdgeImpl
		 * @see od_core_topology.impl.TopologyPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Tail Node Connector</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__TAIL_NODE_CONNECTOR = eINSTANCE.getEdge_TailNodeConnector();

		/**
		 * The meta object literal for the '<em><b>Head Node Connector</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__HEAD_NODE_CONNECTOR = eINSTANCE.getEdge_HeadNodeConnector();

		/**
		 * The meta object literal for the '{@link od_core_topology.impl.EdgePropertiesImpl <em>Edge Properties</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see od_core_topology.impl.EdgePropertiesImpl
		 * @see od_core_topology.impl.TopologyPackageImpl#getEdgeProperties()
		 * @generated
		 */
		EClass EDGE_PROPERTIES = eINSTANCE.getEdgeProperties();

		/**
		 * The meta object literal for the '<em><b>Edge</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_PROPERTIES__EDGE = eINSTANCE.getEdgeProperties_Edge();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_PROPERTIES__PROPERTIES = eINSTANCE.getEdgeProperties_Properties();

		/**
		 * The meta object literal for the '{@link od_core_topology.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see od_core_topology.impl.NodeImpl
		 * @see od_core_topology.impl.TopologyPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__ID = eINSTANCE.getNode_Id();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__TYPE = eINSTANCE.getNode_Type();

		/**
		 * The meta object literal for the '{@link od_core_topology.impl.NodeConnectorImpl <em>Node Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see od_core_topology.impl.NodeConnectorImpl
		 * @see od_core_topology.impl.TopologyPackageImpl#getNodeConnector()
		 * @generated
		 */
		EClass NODE_CONNECTOR = eINSTANCE.getNodeConnector();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_CONNECTOR__ID = eINSTANCE.getNodeConnector_Id();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_CONNECTOR__NODE = eINSTANCE.getNodeConnector_Node();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_CONNECTOR__TYPE = eINSTANCE.getNodeConnector_Type();

		/**
		 * The meta object literal for the '{@link od_core_topology.impl.PropertiesTypeImpl <em>Properties Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see od_core_topology.impl.PropertiesTypeImpl
		 * @see od_core_topology.impl.TopologyPackageImpl#getPropertiesType()
		 * @generated
		 */
		EClass PROPERTIES_TYPE = eINSTANCE.getPropertiesType();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTIES_TYPE__PROPERTY = eINSTANCE.getPropertiesType_Property();

		/**
		 * The meta object literal for the '{@link od_core_topology.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see od_core_topology.impl.PropertyImpl
		 * @see od_core_topology.impl.TopologyPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '{@link od_core_topology.impl.TopologyImpl <em>Topology</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see od_core_topology.impl.TopologyImpl
		 * @see od_core_topology.impl.TopologyPackageImpl#getTopology()
		 * @generated
		 */
		EClass TOPOLOGY = eINSTANCE.getTopology();

		/**
		 * The meta object literal for the '<em><b>Edge Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGY__EDGE_PROPERTIES = eINSTANCE.getTopology_EdgeProperties();

		/**
		 * The meta object literal for the '{@link od_core_topology.impl.TopologyUserLinkConfigImpl <em>User Link Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see od_core_topology.impl.TopologyUserLinkConfigImpl
		 * @see od_core_topology.impl.TopologyPackageImpl#getTopologyUserLinkConfig()
		 * @generated
		 */
		EClass TOPOLOGY_USER_LINK_CONFIG = eINSTANCE.getTopologyUserLinkConfig();

		/**
		 * The meta object literal for the '<em><b>Src Node Connector</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGY_USER_LINK_CONFIG__SRC_NODE_CONNECTOR = eINSTANCE.getTopologyUserLinkConfig_SrcNodeConnector();

		/**
		 * The meta object literal for the '<em><b>Dst Node Connector</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGY_USER_LINK_CONFIG__DST_NODE_CONNECTOR = eINSTANCE.getTopologyUserLinkConfig_DstNodeConnector();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGY_USER_LINK_CONFIG__STATUS = eINSTANCE.getTopologyUserLinkConfig_Status();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGY_USER_LINK_CONFIG__NAME = eINSTANCE.getTopologyUserLinkConfig_Name();

		/**
		 * The meta object literal for the '{@link od_core_topology.impl.TopologyUserLinksImpl <em>User Links</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see od_core_topology.impl.TopologyUserLinksImpl
		 * @see od_core_topology.impl.TopologyPackageImpl#getTopologyUserLinks()
		 * @generated
		 */
		EClass TOPOLOGY_USER_LINKS = eINSTANCE.getTopologyUserLinks();

		/**
		 * The meta object literal for the '<em><b>User Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGY_USER_LINKS__USER_LINKS = eINSTANCE.getTopologyUserLinks_UserLinks();

	}

} //TopologyPackage
