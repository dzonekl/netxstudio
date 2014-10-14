/**
 */
package tbd.params.xml.ns.yang.network.topology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.TopologyType#getTopologyId <em>Topology Id</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.TopologyType#isServerProvided <em>Server Provided</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.TopologyType#getTopologyTypes <em>Topology Types</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.TopologyType#getUnderlayTopology <em>Underlay Topology</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.TopologyType#getNode <em>Node</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.TopologyType#getLink <em>Link</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.TopologyType#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getTopologyType()
 * @model extendedMetaData="name='topology_._type' kind='elementOnly'"
 * @generated
 */
public interface TopologyType extends EObject {
	/**
	 * Returns the value of the '<em><b>Topology Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 
	 *                     It is presumed that a datastore will contain many topologies. To
	 *                     distinguish between topologies it is vital to have UNIQUE
	 *                     topology identifiers.
	 * 
	 *                   
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Topology Id</em>' attribute.
	 * @see #setTopologyId(String)
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getTopologyType_TopologyId()
	 * @model dataType="tbd.params.xml.ns.yang.network.topology.TopologyId" required="true"
	 *        extendedMetaData="kind='element' name='topology-id' namespace='##targetNamespace'"
	 * @generated
	 */
	String getTopologyId();

	/**
	 * Sets the value of the '{@link tbd.params.xml.ns.yang.network.topology.TopologyType#getTopologyId <em>Topology Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topology Id</em>' attribute.
	 * @see #getTopologyId()
	 * @generated
	 */
	void setTopologyId(String value);

	/**
	 * Returns the value of the '<em><b>Server Provided</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 
	 *                     Indicates whether the topology is configurable by clients,
	 *                     or whether it is provided by the server.  This leaf is
	 * 
	 *                     populated by the server implementing the model.
	 *                     It is set to false for topologies that are created by a client;
	 *                     it is set to true otherwise.  If it is set to true, any
	 *                     attempt to edit the topology MUST be rejected.
	 * 
	 *                   
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Server Provided</em>' attribute.
	 * @see #isSetServerProvided()
	 * @see #unsetServerProvided()
	 * @see #setServerProvided(boolean)
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getTopologyType_ServerProvided()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='element' name='server-provided' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isServerProvided();

	/**
	 * Sets the value of the '{@link tbd.params.xml.ns.yang.network.topology.TopologyType#isServerProvided <em>Server Provided</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Provided</em>' attribute.
	 * @see #isSetServerProvided()
	 * @see #unsetServerProvided()
	 * @see #isServerProvided()
	 * @generated
	 */
	void setServerProvided(boolean value);

	/**
	 * Unsets the value of the '{@link tbd.params.xml.ns.yang.network.topology.TopologyType#isServerProvided <em>Server Provided</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetServerProvided()
	 * @see #isServerProvided()
	 * @see #setServerProvided(boolean)
	 * @generated
	 */
	void unsetServerProvided();

	/**
	 * Returns whether the value of the '{@link tbd.params.xml.ns.yang.network.topology.TopologyType#isServerProvided <em>Server Provided</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Server Provided</em>' attribute is set.
	 * @see #unsetServerProvided()
	 * @see #isServerProvided()
	 * @see #setServerProvided(boolean)
	 * @generated
	 */
	boolean isSetServerProvided();

	/**
	 * Returns the value of the '<em><b>Topology Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                     This container is used to identify the type, or types
	 *                     (as a topology can support several types simultaneously),
	 *                     of the topology.
	 *                     Topology types are the subject of several integrity constraints
	 *                     that an implementing server can validate in order to
	 *                     maintain integrity of the datastore.
	 *                     Topology types are indicated through separate data nodes;
	 *                     the set of topology types is expected to increase over time.
	 *                     To add support for a new topology, an augmenting module
	 *                     needs to augment this container with a new empty optional
	 *                     container to indicate the new topology type.
	 *                     The use of a container allows to indicate a subcategorization
	 *                     of topology types.
	 *                     The container SHALL NOT be augmented with any data nodes
	 *                     that serve a purpose other than identifying a particular
	 *                     topology type.
	 * 
	 *                   
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Topology Types</em>' containment reference.
	 * @see #setTopologyTypes(TopologyTypesType)
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getTopologyType_TopologyTypes()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='topology-types' namespace='##targetNamespace'"
	 * @generated
	 */
	TopologyTypesType getTopologyTypes();

	/**
	 * Sets the value of the '{@link tbd.params.xml.ns.yang.network.topology.TopologyType#getTopologyTypes <em>Topology Types</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topology Types</em>' containment reference.
	 * @see #getTopologyTypes()
	 * @generated
	 */
	void setTopologyTypes(TopologyTypesType value);

	/**
	 * Returns the value of the '<em><b>Underlay Topology</b></em>' containment reference list.
	 * The list contents are of type {@link tbd.params.xml.ns.yang.network.topology.UnderlayTopologyType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                     Identifies the topology, or topologies, that this topology
	 *                     is dependent on.
	 *                   
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Underlay Topology</em>' containment reference list.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getTopologyType_UnderlayTopology()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='underlay-topology' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<UnderlayTopologyType> getUnderlayTopology();

	/**
	 * Returns the value of the '<em><b>Node</b></em>' containment reference list.
	 * The list contents are of type {@link tbd.params.xml.ns.yang.network.topology.NodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                     The list of network nodes defined for the topology.
	 *                   
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Node</em>' containment reference list.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getTopologyType_Node()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='node' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<NodeType> getNode();

	/**
	 * Returns the value of the '<em><b>Link</b></em>' containment reference list.
	 * The list contents are of type {@link tbd.params.xml.ns.yang.network.topology.LinkType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 
	 *                     A Network Link connects a by Local (Source) node and
	 *                     a Remote (Destination) Network Nodes via a set of the
	 *                     nodes' termination points.
	 *                     As it is possible to have several links between the same
	 *                     source and destination nodes, and as a link could potentially
	 *                     be re-homed between termination points, to ensure that we
	 *                     would always know to distinguish between links, every link
	 *                     is identified by a dedicated link identifier.
	 *                     Note that a link models a point-to-point link, not a multipoint
	 *                     link.
	 *                     Layering dependencies on links in underlay topologies are
	 *                     not represented as the layering information of nodes and of
	 *                     termination points is sufficient.
	 * 
	 *                   
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Link</em>' containment reference list.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getTopologyType_Link()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='link' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<LinkType> getLink();

	/**
	 * Returns the value of the '<em><b>Any</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any</em>' attribute list.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getTopologyType_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':6' processing='lax'"
	 * @generated
	 */
	FeatureMap getAny();

} // TopologyType
