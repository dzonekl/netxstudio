/**
 */
package tbd.params.xml.ns.yang.network.topology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.NodeType#getNodeId <em>Node Id</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.NodeType#getSupportingNode <em>Supporting Node</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.NodeType#getTerminationPoint <em>Termination Point</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.NodeType#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getNodeType()
 * @model extendedMetaData="name='node_._type' kind='elementOnly'"
 * @generated
 */
public interface NodeType extends EObject {
	/**
	 * Returns the value of the '<em><b>Node Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                           The identifier of a node in the topology.
	 *                           A node is specific to a topology to which it belongs.
	 *                         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Node Id</em>' attribute.
	 * @see #setNodeId(String)
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getNodeType_NodeId()
	 * @model dataType="tbd.params.xml.ns.yang.network.topology.NodeId" required="true"
	 *        extendedMetaData="kind='element' name='node-id' namespace='##targetNamespace'"
	 * @generated
	 */
	String getNodeId();

	/**
	 * Sets the value of the '{@link tbd.params.xml.ns.yang.network.topology.NodeType#getNodeId <em>Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Id</em>' attribute.
	 * @see #getNodeId()
	 * @generated
	 */
	void setNodeId(String value);

	/**
	 * Returns the value of the '<em><b>Supporting Node</b></em>' containment reference list.
	 * The list contents are of type {@link tbd.params.xml.ns.yang.network.topology.SupportingNodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                           This list defines vertical layering information for nodes.
	 *                           It allows to capture for any given node, which node (or nodes)
	 *                           in the corresponding underlay topology it maps onto.
	 *                           A node can map to zero, one, or more nodes below it;
	 *                           accordingly there can be zero, one, or more elements in the list.
	 *                           If there are specific layering requirements, for example
	 *                           specific to a particular type of topology that only allows
	 *                           for certain layering relationships, the choice
	 *                           below can be augmented with additional cases.
	 *                           A list has been chosen rather than a leaf-list in order
	 *                           to provide room for augmentations, e.g. for
	 *                           statistics or priorization information associated with
	 *                           supporting nodes.
	 *                         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Supporting Node</em>' containment reference list.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getNodeType_SupportingNode()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='supporting-node' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SupportingNodeType> getSupportingNode();

	/**
	 * Returns the value of the '<em><b>Termination Point</b></em>' containment reference list.
	 * The list contents are of type {@link tbd.params.xml.ns.yang.network.topology.TerminationPointType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                           A termination point can terminate a link.
	 *                           Depending on the type of topology, a termination point could,
	 *                           for example, refer to a port or an interface.
	 *                         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Termination Point</em>' containment reference list.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getNodeType_TerminationPoint()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='termination-point' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TerminationPointType> getTerminationPoint();

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
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getNodeType_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':3' processing='lax'"
	 * @generated
	 */
	FeatureMap getAny();

} // NodeType
