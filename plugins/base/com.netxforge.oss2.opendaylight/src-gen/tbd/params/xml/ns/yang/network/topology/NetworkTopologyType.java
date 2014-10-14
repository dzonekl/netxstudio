/**
 */
package tbd.params.xml.ns.yang.network.topology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Network Topology Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.NetworkTopologyType#getTopology <em>Topology</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.NetworkTopologyType#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getNetworkTopologyType()
 * @model extendedMetaData="name='network-topology_._type' kind='elementOnly'"
 * @generated
 */
public interface NetworkTopologyType extends EObject {
	/**
	 * Returns the value of the '<em><b>Topology</b></em>' containment reference list.
	 * The list contents are of type {@link tbd.params.xml.ns.yang.network.topology.TopologyType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 
	 *               This is the model of an abstract topology.
	 *               A topology contains nodes and links.
	 *               Each topology MUST be identified by
	 *               unique topology-id for reason that a network could contain many
	 *               topologies.
	 * 
	 *             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Topology</em>' containment reference list.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getNetworkTopologyType_Topology()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='topology' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TopologyType> getTopology();

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
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getNetworkTopologyType_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':1' processing='lax'"
	 * @generated
	 */
	FeatureMap getAny();

} // NetworkTopologyType
