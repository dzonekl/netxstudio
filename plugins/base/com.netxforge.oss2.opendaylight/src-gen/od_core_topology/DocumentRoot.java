/**
 */
package od_core_topology;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link od_core_topology.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link od_core_topology.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link od_core_topology.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link od_core_topology.DocumentRoot#getEdge <em>Edge</em>}</li>
 *   <li>{@link od_core_topology.DocumentRoot#getEdgeProperties <em>Edge Properties</em>}</li>
 *   <li>{@link od_core_topology.DocumentRoot#getList <em>List</em>}</li>
 *   <li>{@link od_core_topology.DocumentRoot#getNode <em>Node</em>}</li>
 *   <li>{@link od_core_topology.DocumentRoot#getNodeConnector <em>Node Connector</em>}</li>
 *   <li>{@link od_core_topology.DocumentRoot#getProperty <em>Property</em>}</li>
 *   <li>{@link od_core_topology.DocumentRoot#getTopology <em>Topology</em>}</li>
 *   <li>{@link od_core_topology.DocumentRoot#getTopologyUserLinkConfig <em>Topology User Link Config</em>}</li>
 * </ul>
 * </p>
 *
 * @see od_core_topology.TopologyPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see od_core_topology.TopologyPackage#getDocumentRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see od_core_topology.TopologyPackage#getDocumentRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap<String, String> getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see od_core_topology.TopologyPackage#getDocumentRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap<String, String> getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Edge</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge</em>' containment reference.
	 * @see #setEdge(Edge)
	 * @see od_core_topology.TopologyPackage#getDocumentRoot_Edge()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='edge' namespace='##targetNamespace'"
	 * @generated
	 */
	Edge getEdge();

	/**
	 * Sets the value of the '{@link od_core_topology.DocumentRoot#getEdge <em>Edge</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge</em>' containment reference.
	 * @see #getEdge()
	 * @generated
	 */
	void setEdge(Edge value);

	/**
	 * Returns the value of the '<em><b>Edge Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge Properties</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge Properties</em>' containment reference.
	 * @see #setEdgeProperties(EdgeProperties)
	 * @see od_core_topology.TopologyPackage#getDocumentRoot_EdgeProperties()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='edgeProperties' namespace='##targetNamespace'"
	 * @generated
	 */
	EdgeProperties getEdgeProperties();

	/**
	 * Sets the value of the '{@link od_core_topology.DocumentRoot#getEdgeProperties <em>Edge Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge Properties</em>' containment reference.
	 * @see #getEdgeProperties()
	 * @generated
	 */
	void setEdgeProperties(EdgeProperties value);

	/**
	 * Returns the value of the '<em><b>List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List</em>' containment reference.
	 * @see #setList(TopologyUserLinks)
	 * @see od_core_topology.TopologyPackage#getDocumentRoot_List()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='list' namespace='##targetNamespace'"
	 * @generated
	 */
	TopologyUserLinks getList();

	/**
	 * Sets the value of the '{@link od_core_topology.DocumentRoot#getList <em>List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List</em>' containment reference.
	 * @see #getList()
	 * @generated
	 */
	void setList(TopologyUserLinks value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' containment reference.
	 * @see #setNode(Node)
	 * @see od_core_topology.TopologyPackage#getDocumentRoot_Node()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='node' namespace='##targetNamespace'"
	 * @generated
	 */
	Node getNode();

	/**
	 * Sets the value of the '{@link od_core_topology.DocumentRoot#getNode <em>Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' containment reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(Node value);

	/**
	 * Returns the value of the '<em><b>Node Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Connector</em>' containment reference.
	 * @see #setNodeConnector(NodeConnector)
	 * @see od_core_topology.TopologyPackage#getDocumentRoot_NodeConnector()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='nodeConnector' namespace='##targetNamespace'"
	 * @generated
	 */
	NodeConnector getNodeConnector();

	/**
	 * Sets the value of the '{@link od_core_topology.DocumentRoot#getNodeConnector <em>Node Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Connector</em>' containment reference.
	 * @see #getNodeConnector()
	 * @generated
	 */
	void setNodeConnector(NodeConnector value);

	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' containment reference.
	 * @see #setProperty(Property)
	 * @see od_core_topology.TopologyPackage#getDocumentRoot_Property()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace'"
	 * @generated
	 */
	Property getProperty();

	/**
	 * Sets the value of the '{@link od_core_topology.DocumentRoot#getProperty <em>Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' containment reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Topology</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Topology</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Topology</em>' containment reference.
	 * @see #setTopology(Topology)
	 * @see od_core_topology.TopologyPackage#getDocumentRoot_Topology()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='topology' namespace='##targetNamespace'"
	 * @generated
	 */
	Topology getTopology();

	/**
	 * Sets the value of the '{@link od_core_topology.DocumentRoot#getTopology <em>Topology</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topology</em>' containment reference.
	 * @see #getTopology()
	 * @generated
	 */
	void setTopology(Topology value);

	/**
	 * Returns the value of the '<em><b>Topology User Link Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Topology User Link Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Topology User Link Config</em>' containment reference.
	 * @see #setTopologyUserLinkConfig(TopologyUserLinkConfig)
	 * @see od_core_topology.TopologyPackage#getDocumentRoot_TopologyUserLinkConfig()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='topologyUserLinkConfig' namespace='##targetNamespace'"
	 * @generated
	 */
	TopologyUserLinkConfig getTopologyUserLinkConfig();

	/**
	 * Sets the value of the '{@link od_core_topology.DocumentRoot#getTopologyUserLinkConfig <em>Topology User Link Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topology User Link Config</em>' containment reference.
	 * @see #getTopologyUserLinkConfig()
	 * @generated
	 */
	void setTopologyUserLinkConfig(TopologyUserLinkConfig value);

} // DocumentRoot
