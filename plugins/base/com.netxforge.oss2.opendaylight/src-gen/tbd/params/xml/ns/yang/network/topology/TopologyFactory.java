/**
 */
package tbd.params.xml.ns.yang.network.topology;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage
 * @generated
 */
public interface TopologyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TopologyFactory eINSTANCE = tbd.params.xml.ns.yang.network.topology.impl.TopologyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Destination Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Destination Type</em>'.
	 * @generated
	 */
	DestinationType createDestinationType();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Link Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Type</em>'.
	 * @generated
	 */
	LinkType createLinkType();

	/**
	 * Returns a new object of class '<em>Network Topology Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Network Topology Type</em>'.
	 * @generated
	 */
	NetworkTopologyType createNetworkTopologyType();

	/**
	 * Returns a new object of class '<em>Node Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Type</em>'.
	 * @generated
	 */
	NodeType createNodeType();

	/**
	 * Returns a new object of class '<em>Source Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Type</em>'.
	 * @generated
	 */
	SourceType createSourceType();

	/**
	 * Returns a new object of class '<em>Supporting Link Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Supporting Link Type</em>'.
	 * @generated
	 */
	SupportingLinkType createSupportingLinkType();

	/**
	 * Returns a new object of class '<em>Supporting Node Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Supporting Node Type</em>'.
	 * @generated
	 */
	SupportingNodeType createSupportingNodeType();

	/**
	 * Returns a new object of class '<em>Termination Point Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Termination Point Type</em>'.
	 * @generated
	 */
	TerminationPointType createTerminationPointType();

	/**
	 * Returns a new object of class '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type</em>'.
	 * @generated
	 */
	TopologyType createTopologyType();

	/**
	 * Returns a new object of class '<em>Types Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Types Type</em>'.
	 * @generated
	 */
	TopologyTypesType createTopologyTypesType();

	/**
	 * Returns a new object of class '<em>Underlay Topology Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Underlay Topology Type</em>'.
	 * @generated
	 */
	UnderlayTopologyType createUnderlayTopologyType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TopologyPackage getTopologyPackage();

} //TopologyFactory
