/**
 */
package tbd.params.xml.ns.yang.network.topology;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * <!-- begin-model-doc -->
 * 
 *       This schema was generated from the YANG module network-topology
 * 
 *       The schema describes an instance document consisting
 *       of the entire configuration data store, operational
 *       data, rpc operations, and notifications.
 *       This schema can thus NOT be used as-is to
 *       validate NETCONF PDUs.
 *     
 * 
 *       This module defines a model for the topology of a network.
 *       Key design decisions are as follows:
 *       A topology consists of a set of nodes and links.
 *       Links are point-to-point and unidirectional.
 *       Bidirectional connections need to be represented through
 *       two separate links.
 *       Multipoint connections, broadcast domains etc can be represented
 *       through a hierarchy of nodes, then connecting nodes at
 *       upper layers of the hierarchy.
 *     
 * 
 *       This schema was generated from the YANG module ietf-inet-types
 * 
 *       The schema describes an instance document consisting
 *       of the entire configuration data store, operational
 *       data, rpc operations, and notifications.
 *       This schema can thus NOT be used as-is to
 *       validate NETCONF PDUs.
 *     
 * 
 *       This module contains a collection of generally useful derived
 *       YANG data types for Internet addresses and related things.
 * 
 *       Copyright (c) 2010 IETF Trust and the persons identified as
 *       authors of the code.  All rights reserved.
 * 
 *       Redistribution and use in source and binary forms, with or without
 *       modification, is permitted pursuant to, and subject to the license
 *       terms contained in, the Simplified BSD License set forth in Section
 *       4.c of the IETF Trust's Legal Provisions Relating to IETF Documents
 *       (http://trustee.ietf.org/license-info).
 * 
 *       This version of this YANG module is part of RFC 6021; see
 *       the RFC itself for full legal notices.
 *     
 * <!-- end-model-doc -->
 * @see tbd.params.xml.ns.yang.network.topology.TopologyFactory
 * @model kind="package"
 *        annotation="http://www.w3.org/XML/1998/namespace lang='en'"
 * @generated
 */
public interface TopologyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "topology";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:TBD:params:xml:ns:yang:network-topology";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "topology";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TopologyPackage eINSTANCE = tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl.init();

	/**
	 * The meta object id for the '{@link tbd.params.xml.ns.yang.network.topology.impl.DestinationTypeImpl <em>Destination Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tbd.params.xml.ns.yang.network.topology.impl.DestinationTypeImpl
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getDestinationType()
	 * @generated
	 */
	int DESTINATION_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Dest Node</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_TYPE__DEST_NODE = 0;

	/**
	 * The feature id for the '<em><b>Dest Tp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_TYPE__DEST_TP = 1;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_TYPE__ANY = 2;

	/**
	 * The number of structural features of the '<em>Destination Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Destination Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tbd.params.xml.ns.yang.network.topology.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tbd.params.xml.ns.yang.network.topology.impl.DocumentRootImpl
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getDocumentRoot()
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
	 * The feature id for the '<em><b>Network Topology</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__NETWORK_TOPOLOGY = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tbd.params.xml.ns.yang.network.topology.impl.LinkTypeImpl <em>Link Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tbd.params.xml.ns.yang.network.topology.impl.LinkTypeImpl
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getLinkType()
	 * @generated
	 */
	int LINK_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Link Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__LINK_ID = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__DESTINATION = 2;

	/**
	 * The feature id for the '<em><b>Supporting Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__SUPPORTING_LINK = 3;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__ANY = 4;

	/**
	 * The number of structural features of the '<em>Link Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Link Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tbd.params.xml.ns.yang.network.topology.impl.NetworkTopologyTypeImpl <em>Network Topology Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tbd.params.xml.ns.yang.network.topology.impl.NetworkTopologyTypeImpl
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getNetworkTopologyType()
	 * @generated
	 */
	int NETWORK_TOPOLOGY_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Topology</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_TOPOLOGY_TYPE__TOPOLOGY = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_TOPOLOGY_TYPE__ANY = 1;

	/**
	 * The number of structural features of the '<em>Network Topology Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_TOPOLOGY_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Network Topology Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_TOPOLOGY_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tbd.params.xml.ns.yang.network.topology.impl.NodeTypeImpl <em>Node Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tbd.params.xml.ns.yang.network.topology.impl.NodeTypeImpl
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getNodeType()
	 * @generated
	 */
	int NODE_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Node Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__NODE_ID = 0;

	/**
	 * The feature id for the '<em><b>Supporting Node</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__SUPPORTING_NODE = 1;

	/**
	 * The feature id for the '<em><b>Termination Point</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__TERMINATION_POINT = 2;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__ANY = 3;

	/**
	 * The number of structural features of the '<em>Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tbd.params.xml.ns.yang.network.topology.impl.SourceTypeImpl <em>Source Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tbd.params.xml.ns.yang.network.topology.impl.SourceTypeImpl
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getSourceType()
	 * @generated
	 */
	int SOURCE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_TYPE__SOURCE_NODE = 0;

	/**
	 * The feature id for the '<em><b>Source Tp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_TYPE__SOURCE_TP = 1;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_TYPE__ANY = 2;

	/**
	 * The number of structural features of the '<em>Source Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Source Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tbd.params.xml.ns.yang.network.topology.impl.SupportingLinkTypeImpl <em>Supporting Link Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tbd.params.xml.ns.yang.network.topology.impl.SupportingLinkTypeImpl
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getSupportingLinkType()
	 * @generated
	 */
	int SUPPORTING_LINK_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Link Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_LINK_TYPE__LINK_REF = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_LINK_TYPE__ANY = 1;

	/**
	 * The number of structural features of the '<em>Supporting Link Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_LINK_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Supporting Link Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_LINK_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tbd.params.xml.ns.yang.network.topology.impl.SupportingNodeTypeImpl <em>Supporting Node Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tbd.params.xml.ns.yang.network.topology.impl.SupportingNodeTypeImpl
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getSupportingNodeType()
	 * @generated
	 */
	int SUPPORTING_NODE_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Node Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_NODE_TYPE__NODE_REF = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_NODE_TYPE__ANY = 1;

	/**
	 * The number of structural features of the '<em>Supporting Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_NODE_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Supporting Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_NODE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tbd.params.xml.ns.yang.network.topology.impl.TerminationPointTypeImpl <em>Termination Point Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TerminationPointTypeImpl
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getTerminationPointType()
	 * @generated
	 */
	int TERMINATION_POINT_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Tp Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATION_POINT_TYPE__TP_ID = 0;

	/**
	 * The feature id for the '<em><b>Tp Ref</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATION_POINT_TYPE__TP_REF = 1;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATION_POINT_TYPE__ANY = 2;

	/**
	 * The number of structural features of the '<em>Termination Point Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATION_POINT_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Termination Point Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATION_POINT_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tbd.params.xml.ns.yang.network.topology.impl.TopologyTypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyTypeImpl
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getTopologyType()
	 * @generated
	 */
	int TOPOLOGY_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Topology Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_TYPE__TOPOLOGY_ID = 0;

	/**
	 * The feature id for the '<em><b>Server Provided</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_TYPE__SERVER_PROVIDED = 1;

	/**
	 * The feature id for the '<em><b>Topology Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_TYPE__TOPOLOGY_TYPES = 2;

	/**
	 * The feature id for the '<em><b>Underlay Topology</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_TYPE__UNDERLAY_TOPOLOGY = 3;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_TYPE__NODE = 4;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_TYPE__LINK = 5;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_TYPE__ANY = 6;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_TYPE_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tbd.params.xml.ns.yang.network.topology.impl.TopologyTypesTypeImpl <em>Types Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyTypesTypeImpl
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getTopologyTypesType()
	 * @generated
	 */
	int TOPOLOGY_TYPES_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_TYPES_TYPE__ANY = 0;

	/**
	 * The number of structural features of the '<em>Types Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_TYPES_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Types Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_TYPES_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tbd.params.xml.ns.yang.network.topology.impl.UnderlayTopologyTypeImpl <em>Underlay Topology Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tbd.params.xml.ns.yang.network.topology.impl.UnderlayTopologyTypeImpl
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getUnderlayTopologyType()
	 * @generated
	 */
	int UNDERLAY_TOPOLOGY_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Topology Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDERLAY_TOPOLOGY_TYPE__TOPOLOGY_REF = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDERLAY_TOPOLOGY_TYPE__ANY = 1;

	/**
	 * The number of structural features of the '<em>Underlay Topology Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDERLAY_TOPOLOGY_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Underlay Topology Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDERLAY_TOPOLOGY_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>Link Id</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getLinkId()
	 * @generated
	 */
	int LINK_ID = 12;

	/**
	 * The meta object id for the '<em>Link Ref</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getLinkRef()
	 * @generated
	 */
	int LINK_REF = 13;

	/**
	 * The meta object id for the '<em>Node Id</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getNodeId()
	 * @generated
	 */
	int NODE_ID = 14;

	/**
	 * The meta object id for the '<em>Node Ref</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getNodeRef()
	 * @generated
	 */
	int NODE_REF = 15;

	/**
	 * The meta object id for the '<em>Id</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getTopologyId()
	 * @generated
	 */
	int TOPOLOGY_ID = 16;

	/**
	 * The meta object id for the '<em>Ref</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getTopologyRef()
	 * @generated
	 */
	int TOPOLOGY_REF = 17;

	/**
	 * The meta object id for the '<em>Tp Id</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getTpId()
	 * @generated
	 */
	int TP_ID = 18;

	/**
	 * The meta object id for the '<em>Tp Ref</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getTpRef()
	 * @generated
	 */
	int TP_REF = 19;


	/**
	 * Returns the meta object for class '{@link tbd.params.xml.ns.yang.network.topology.DestinationType <em>Destination Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Destination Type</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.DestinationType
	 * @generated
	 */
	EClass getDestinationType();

	/**
	 * Returns the meta object for the attribute '{@link tbd.params.xml.ns.yang.network.topology.DestinationType#getDestNode <em>Dest Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dest Node</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.DestinationType#getDestNode()
	 * @see #getDestinationType()
	 * @generated
	 */
	EAttribute getDestinationType_DestNode();

	/**
	 * Returns the meta object for the attribute '{@link tbd.params.xml.ns.yang.network.topology.DestinationType#getDestTp <em>Dest Tp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dest Tp</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.DestinationType#getDestTp()
	 * @see #getDestinationType()
	 * @generated
	 */
	EAttribute getDestinationType_DestTp();

	/**
	 * Returns the meta object for the attribute list '{@link tbd.params.xml.ns.yang.network.topology.DestinationType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.DestinationType#getAny()
	 * @see #getDestinationType()
	 * @generated
	 */
	EAttribute getDestinationType_Any();

	/**
	 * Returns the meta object for class '{@link tbd.params.xml.ns.yang.network.topology.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link tbd.params.xml.ns.yang.network.topology.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link tbd.params.xml.ns.yang.network.topology.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link tbd.params.xml.ns.yang.network.topology.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link tbd.params.xml.ns.yang.network.topology.DocumentRoot#getNetworkTopology <em>Network Topology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Network Topology</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.DocumentRoot#getNetworkTopology()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_NetworkTopology();

	/**
	 * Returns the meta object for class '{@link tbd.params.xml.ns.yang.network.topology.LinkType <em>Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Type</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.LinkType
	 * @generated
	 */
	EClass getLinkType();

	/**
	 * Returns the meta object for the attribute '{@link tbd.params.xml.ns.yang.network.topology.LinkType#getLinkId <em>Link Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link Id</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.LinkType#getLinkId()
	 * @see #getLinkType()
	 * @generated
	 */
	EAttribute getLinkType_LinkId();

	/**
	 * Returns the meta object for the containment reference '{@link tbd.params.xml.ns.yang.network.topology.LinkType#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.LinkType#getSource()
	 * @see #getLinkType()
	 * @generated
	 */
	EReference getLinkType_Source();

	/**
	 * Returns the meta object for the containment reference '{@link tbd.params.xml.ns.yang.network.topology.LinkType#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Destination</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.LinkType#getDestination()
	 * @see #getLinkType()
	 * @generated
	 */
	EReference getLinkType_Destination();

	/**
	 * Returns the meta object for the containment reference list '{@link tbd.params.xml.ns.yang.network.topology.LinkType#getSupportingLink <em>Supporting Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Supporting Link</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.LinkType#getSupportingLink()
	 * @see #getLinkType()
	 * @generated
	 */
	EReference getLinkType_SupportingLink();

	/**
	 * Returns the meta object for the attribute list '{@link tbd.params.xml.ns.yang.network.topology.LinkType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.LinkType#getAny()
	 * @see #getLinkType()
	 * @generated
	 */
	EAttribute getLinkType_Any();

	/**
	 * Returns the meta object for class '{@link tbd.params.xml.ns.yang.network.topology.NetworkTopologyType <em>Network Topology Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Network Topology Type</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.NetworkTopologyType
	 * @generated
	 */
	EClass getNetworkTopologyType();

	/**
	 * Returns the meta object for the containment reference list '{@link tbd.params.xml.ns.yang.network.topology.NetworkTopologyType#getTopology <em>Topology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Topology</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.NetworkTopologyType#getTopology()
	 * @see #getNetworkTopologyType()
	 * @generated
	 */
	EReference getNetworkTopologyType_Topology();

	/**
	 * Returns the meta object for the attribute list '{@link tbd.params.xml.ns.yang.network.topology.NetworkTopologyType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.NetworkTopologyType#getAny()
	 * @see #getNetworkTopologyType()
	 * @generated
	 */
	EAttribute getNetworkTopologyType_Any();

	/**
	 * Returns the meta object for class '{@link tbd.params.xml.ns.yang.network.topology.NodeType <em>Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Type</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.NodeType
	 * @generated
	 */
	EClass getNodeType();

	/**
	 * Returns the meta object for the attribute '{@link tbd.params.xml.ns.yang.network.topology.NodeType#getNodeId <em>Node Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Id</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.NodeType#getNodeId()
	 * @see #getNodeType()
	 * @generated
	 */
	EAttribute getNodeType_NodeId();

	/**
	 * Returns the meta object for the containment reference list '{@link tbd.params.xml.ns.yang.network.topology.NodeType#getSupportingNode <em>Supporting Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Supporting Node</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.NodeType#getSupportingNode()
	 * @see #getNodeType()
	 * @generated
	 */
	EReference getNodeType_SupportingNode();

	/**
	 * Returns the meta object for the containment reference list '{@link tbd.params.xml.ns.yang.network.topology.NodeType#getTerminationPoint <em>Termination Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Termination Point</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.NodeType#getTerminationPoint()
	 * @see #getNodeType()
	 * @generated
	 */
	EReference getNodeType_TerminationPoint();

	/**
	 * Returns the meta object for the attribute list '{@link tbd.params.xml.ns.yang.network.topology.NodeType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.NodeType#getAny()
	 * @see #getNodeType()
	 * @generated
	 */
	EAttribute getNodeType_Any();

	/**
	 * Returns the meta object for class '{@link tbd.params.xml.ns.yang.network.topology.SourceType <em>Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Type</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.SourceType
	 * @generated
	 */
	EClass getSourceType();

	/**
	 * Returns the meta object for the attribute '{@link tbd.params.xml.ns.yang.network.topology.SourceType#getSourceNode <em>Source Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Node</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.SourceType#getSourceNode()
	 * @see #getSourceType()
	 * @generated
	 */
	EAttribute getSourceType_SourceNode();

	/**
	 * Returns the meta object for the attribute '{@link tbd.params.xml.ns.yang.network.topology.SourceType#getSourceTp <em>Source Tp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Tp</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.SourceType#getSourceTp()
	 * @see #getSourceType()
	 * @generated
	 */
	EAttribute getSourceType_SourceTp();

	/**
	 * Returns the meta object for the attribute list '{@link tbd.params.xml.ns.yang.network.topology.SourceType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.SourceType#getAny()
	 * @see #getSourceType()
	 * @generated
	 */
	EAttribute getSourceType_Any();

	/**
	 * Returns the meta object for class '{@link tbd.params.xml.ns.yang.network.topology.SupportingLinkType <em>Supporting Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Supporting Link Type</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.SupportingLinkType
	 * @generated
	 */
	EClass getSupportingLinkType();

	/**
	 * Returns the meta object for the attribute '{@link tbd.params.xml.ns.yang.network.topology.SupportingLinkType#getLinkRef <em>Link Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link Ref</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.SupportingLinkType#getLinkRef()
	 * @see #getSupportingLinkType()
	 * @generated
	 */
	EAttribute getSupportingLinkType_LinkRef();

	/**
	 * Returns the meta object for the attribute list '{@link tbd.params.xml.ns.yang.network.topology.SupportingLinkType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.SupportingLinkType#getAny()
	 * @see #getSupportingLinkType()
	 * @generated
	 */
	EAttribute getSupportingLinkType_Any();

	/**
	 * Returns the meta object for class '{@link tbd.params.xml.ns.yang.network.topology.SupportingNodeType <em>Supporting Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Supporting Node Type</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.SupportingNodeType
	 * @generated
	 */
	EClass getSupportingNodeType();

	/**
	 * Returns the meta object for the attribute '{@link tbd.params.xml.ns.yang.network.topology.SupportingNodeType#getNodeRef <em>Node Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Ref</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.SupportingNodeType#getNodeRef()
	 * @see #getSupportingNodeType()
	 * @generated
	 */
	EAttribute getSupportingNodeType_NodeRef();

	/**
	 * Returns the meta object for the attribute list '{@link tbd.params.xml.ns.yang.network.topology.SupportingNodeType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.SupportingNodeType#getAny()
	 * @see #getSupportingNodeType()
	 * @generated
	 */
	EAttribute getSupportingNodeType_Any();

	/**
	 * Returns the meta object for class '{@link tbd.params.xml.ns.yang.network.topology.TerminationPointType <em>Termination Point Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Termination Point Type</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.TerminationPointType
	 * @generated
	 */
	EClass getTerminationPointType();

	/**
	 * Returns the meta object for the attribute '{@link tbd.params.xml.ns.yang.network.topology.TerminationPointType#getTpId <em>Tp Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tp Id</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.TerminationPointType#getTpId()
	 * @see #getTerminationPointType()
	 * @generated
	 */
	EAttribute getTerminationPointType_TpId();

	/**
	 * Returns the meta object for the attribute list '{@link tbd.params.xml.ns.yang.network.topology.TerminationPointType#getTpRef <em>Tp Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tp Ref</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.TerminationPointType#getTpRef()
	 * @see #getTerminationPointType()
	 * @generated
	 */
	EAttribute getTerminationPointType_TpRef();

	/**
	 * Returns the meta object for the attribute list '{@link tbd.params.xml.ns.yang.network.topology.TerminationPointType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.TerminationPointType#getAny()
	 * @see #getTerminationPointType()
	 * @generated
	 */
	EAttribute getTerminationPointType_Any();

	/**
	 * Returns the meta object for class '{@link tbd.params.xml.ns.yang.network.topology.TopologyType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyType
	 * @generated
	 */
	EClass getTopologyType();

	/**
	 * Returns the meta object for the attribute '{@link tbd.params.xml.ns.yang.network.topology.TopologyType#getTopologyId <em>Topology Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Topology Id</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyType#getTopologyId()
	 * @see #getTopologyType()
	 * @generated
	 */
	EAttribute getTopologyType_TopologyId();

	/**
	 * Returns the meta object for the attribute '{@link tbd.params.xml.ns.yang.network.topology.TopologyType#isServerProvided <em>Server Provided</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Provided</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyType#isServerProvided()
	 * @see #getTopologyType()
	 * @generated
	 */
	EAttribute getTopologyType_ServerProvided();

	/**
	 * Returns the meta object for the containment reference '{@link tbd.params.xml.ns.yang.network.topology.TopologyType#getTopologyTypes <em>Topology Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Topology Types</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyType#getTopologyTypes()
	 * @see #getTopologyType()
	 * @generated
	 */
	EReference getTopologyType_TopologyTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link tbd.params.xml.ns.yang.network.topology.TopologyType#getUnderlayTopology <em>Underlay Topology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Underlay Topology</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyType#getUnderlayTopology()
	 * @see #getTopologyType()
	 * @generated
	 */
	EReference getTopologyType_UnderlayTopology();

	/**
	 * Returns the meta object for the containment reference list '{@link tbd.params.xml.ns.yang.network.topology.TopologyType#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Node</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyType#getNode()
	 * @see #getTopologyType()
	 * @generated
	 */
	EReference getTopologyType_Node();

	/**
	 * Returns the meta object for the containment reference list '{@link tbd.params.xml.ns.yang.network.topology.TopologyType#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyType#getLink()
	 * @see #getTopologyType()
	 * @generated
	 */
	EReference getTopologyType_Link();

	/**
	 * Returns the meta object for the attribute list '{@link tbd.params.xml.ns.yang.network.topology.TopologyType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyType#getAny()
	 * @see #getTopologyType()
	 * @generated
	 */
	EAttribute getTopologyType_Any();

	/**
	 * Returns the meta object for class '{@link tbd.params.xml.ns.yang.network.topology.TopologyTypesType <em>Types Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Types Type</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyTypesType
	 * @generated
	 */
	EClass getTopologyTypesType();

	/**
	 * Returns the meta object for the attribute list '{@link tbd.params.xml.ns.yang.network.topology.TopologyTypesType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyTypesType#getAny()
	 * @see #getTopologyTypesType()
	 * @generated
	 */
	EAttribute getTopologyTypesType_Any();

	/**
	 * Returns the meta object for class '{@link tbd.params.xml.ns.yang.network.topology.UnderlayTopologyType <em>Underlay Topology Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Underlay Topology Type</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.UnderlayTopologyType
	 * @generated
	 */
	EClass getUnderlayTopologyType();

	/**
	 * Returns the meta object for the attribute '{@link tbd.params.xml.ns.yang.network.topology.UnderlayTopologyType#getTopologyRef <em>Topology Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Topology Ref</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.UnderlayTopologyType#getTopologyRef()
	 * @see #getUnderlayTopologyType()
	 * @generated
	 */
	EAttribute getUnderlayTopologyType_TopologyRef();

	/**
	 * Returns the meta object for the attribute list '{@link tbd.params.xml.ns.yang.network.topology.UnderlayTopologyType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see tbd.params.xml.ns.yang.network.topology.UnderlayTopologyType#getAny()
	 * @see #getUnderlayTopologyType()
	 * @generated
	 */
	EAttribute getUnderlayTopologyType_Any();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Link Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Link Id</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='link-id' baseType='urn:ietf:params:xml:ns:yang:ietf-inet-types#uri'"
	 * @generated
	 */
	EDataType getLinkId();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Link Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Link Ref</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='link-ref' baseType='link-id'"
	 * @generated
	 */
	EDataType getLinkRef();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Node Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Node Id</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='node-id' baseType='urn:ietf:params:xml:ns:yang:ietf-inet-types#uri'"
	 * @generated
	 */
	EDataType getNodeId();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Node Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Node Ref</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='node-ref' baseType='node-id'"
	 * @generated
	 */
	EDataType getNodeRef();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Id</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='topology-id' baseType='urn:ietf:params:xml:ns:yang:ietf-inet-types#uri'"
	 * @generated
	 */
	EDataType getTopologyId();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ref</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='topology-ref' baseType='topology-id'"
	 * @generated
	 */
	EDataType getTopologyRef();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Tp Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Tp Id</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='tp-id' baseType='urn:ietf:params:xml:ns:yang:ietf-inet-types#uri'"
	 * @generated
	 */
	EDataType getTpId();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Tp Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Tp Ref</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='tp-ref' baseType='tp-id'"
	 * @generated
	 */
	EDataType getTpRef();

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
		 * The meta object literal for the '{@link tbd.params.xml.ns.yang.network.topology.impl.DestinationTypeImpl <em>Destination Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tbd.params.xml.ns.yang.network.topology.impl.DestinationTypeImpl
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getDestinationType()
		 * @generated
		 */
		EClass DESTINATION_TYPE = eINSTANCE.getDestinationType();

		/**
		 * The meta object literal for the '<em><b>Dest Node</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESTINATION_TYPE__DEST_NODE = eINSTANCE.getDestinationType_DestNode();

		/**
		 * The meta object literal for the '<em><b>Dest Tp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESTINATION_TYPE__DEST_TP = eINSTANCE.getDestinationType_DestTp();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESTINATION_TYPE__ANY = eINSTANCE.getDestinationType_Any();

		/**
		 * The meta object literal for the '{@link tbd.params.xml.ns.yang.network.topology.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tbd.params.xml.ns.yang.network.topology.impl.DocumentRootImpl
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '<em><b>Network Topology</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__NETWORK_TOPOLOGY = eINSTANCE.getDocumentRoot_NetworkTopology();

		/**
		 * The meta object literal for the '{@link tbd.params.xml.ns.yang.network.topology.impl.LinkTypeImpl <em>Link Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tbd.params.xml.ns.yang.network.topology.impl.LinkTypeImpl
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getLinkType()
		 * @generated
		 */
		EClass LINK_TYPE = eINSTANCE.getLinkType();

		/**
		 * The meta object literal for the '<em><b>Link Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK_TYPE__LINK_ID = eINSTANCE.getLinkType_LinkId();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK_TYPE__SOURCE = eINSTANCE.getLinkType_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK_TYPE__DESTINATION = eINSTANCE.getLinkType_Destination();

		/**
		 * The meta object literal for the '<em><b>Supporting Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK_TYPE__SUPPORTING_LINK = eINSTANCE.getLinkType_SupportingLink();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK_TYPE__ANY = eINSTANCE.getLinkType_Any();

		/**
		 * The meta object literal for the '{@link tbd.params.xml.ns.yang.network.topology.impl.NetworkTopologyTypeImpl <em>Network Topology Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tbd.params.xml.ns.yang.network.topology.impl.NetworkTopologyTypeImpl
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getNetworkTopologyType()
		 * @generated
		 */
		EClass NETWORK_TOPOLOGY_TYPE = eINSTANCE.getNetworkTopologyType();

		/**
		 * The meta object literal for the '<em><b>Topology</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK_TOPOLOGY_TYPE__TOPOLOGY = eINSTANCE.getNetworkTopologyType_Topology();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NETWORK_TOPOLOGY_TYPE__ANY = eINSTANCE.getNetworkTopologyType_Any();

		/**
		 * The meta object literal for the '{@link tbd.params.xml.ns.yang.network.topology.impl.NodeTypeImpl <em>Node Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tbd.params.xml.ns.yang.network.topology.impl.NodeTypeImpl
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getNodeType()
		 * @generated
		 */
		EClass NODE_TYPE = eINSTANCE.getNodeType();

		/**
		 * The meta object literal for the '<em><b>Node Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_TYPE__NODE_ID = eINSTANCE.getNodeType_NodeId();

		/**
		 * The meta object literal for the '<em><b>Supporting Node</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TYPE__SUPPORTING_NODE = eINSTANCE.getNodeType_SupportingNode();

		/**
		 * The meta object literal for the '<em><b>Termination Point</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TYPE__TERMINATION_POINT = eINSTANCE.getNodeType_TerminationPoint();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_TYPE__ANY = eINSTANCE.getNodeType_Any();

		/**
		 * The meta object literal for the '{@link tbd.params.xml.ns.yang.network.topology.impl.SourceTypeImpl <em>Source Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tbd.params.xml.ns.yang.network.topology.impl.SourceTypeImpl
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getSourceType()
		 * @generated
		 */
		EClass SOURCE_TYPE = eINSTANCE.getSourceType();

		/**
		 * The meta object literal for the '<em><b>Source Node</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_TYPE__SOURCE_NODE = eINSTANCE.getSourceType_SourceNode();

		/**
		 * The meta object literal for the '<em><b>Source Tp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_TYPE__SOURCE_TP = eINSTANCE.getSourceType_SourceTp();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_TYPE__ANY = eINSTANCE.getSourceType_Any();

		/**
		 * The meta object literal for the '{@link tbd.params.xml.ns.yang.network.topology.impl.SupportingLinkTypeImpl <em>Supporting Link Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tbd.params.xml.ns.yang.network.topology.impl.SupportingLinkTypeImpl
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getSupportingLinkType()
		 * @generated
		 */
		EClass SUPPORTING_LINK_TYPE = eINSTANCE.getSupportingLinkType();

		/**
		 * The meta object literal for the '<em><b>Link Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPORTING_LINK_TYPE__LINK_REF = eINSTANCE.getSupportingLinkType_LinkRef();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPORTING_LINK_TYPE__ANY = eINSTANCE.getSupportingLinkType_Any();

		/**
		 * The meta object literal for the '{@link tbd.params.xml.ns.yang.network.topology.impl.SupportingNodeTypeImpl <em>Supporting Node Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tbd.params.xml.ns.yang.network.topology.impl.SupportingNodeTypeImpl
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getSupportingNodeType()
		 * @generated
		 */
		EClass SUPPORTING_NODE_TYPE = eINSTANCE.getSupportingNodeType();

		/**
		 * The meta object literal for the '<em><b>Node Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPORTING_NODE_TYPE__NODE_REF = eINSTANCE.getSupportingNodeType_NodeRef();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPORTING_NODE_TYPE__ANY = eINSTANCE.getSupportingNodeType_Any();

		/**
		 * The meta object literal for the '{@link tbd.params.xml.ns.yang.network.topology.impl.TerminationPointTypeImpl <em>Termination Point Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TerminationPointTypeImpl
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getTerminationPointType()
		 * @generated
		 */
		EClass TERMINATION_POINT_TYPE = eINSTANCE.getTerminationPointType();

		/**
		 * The meta object literal for the '<em><b>Tp Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERMINATION_POINT_TYPE__TP_ID = eINSTANCE.getTerminationPointType_TpId();

		/**
		 * The meta object literal for the '<em><b>Tp Ref</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERMINATION_POINT_TYPE__TP_REF = eINSTANCE.getTerminationPointType_TpRef();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERMINATION_POINT_TYPE__ANY = eINSTANCE.getTerminationPointType_Any();

		/**
		 * The meta object literal for the '{@link tbd.params.xml.ns.yang.network.topology.impl.TopologyTypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyTypeImpl
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getTopologyType()
		 * @generated
		 */
		EClass TOPOLOGY_TYPE = eINSTANCE.getTopologyType();

		/**
		 * The meta object literal for the '<em><b>Topology Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGY_TYPE__TOPOLOGY_ID = eINSTANCE.getTopologyType_TopologyId();

		/**
		 * The meta object literal for the '<em><b>Server Provided</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGY_TYPE__SERVER_PROVIDED = eINSTANCE.getTopologyType_ServerProvided();

		/**
		 * The meta object literal for the '<em><b>Topology Types</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGY_TYPE__TOPOLOGY_TYPES = eINSTANCE.getTopologyType_TopologyTypes();

		/**
		 * The meta object literal for the '<em><b>Underlay Topology</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGY_TYPE__UNDERLAY_TOPOLOGY = eINSTANCE.getTopologyType_UnderlayTopology();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGY_TYPE__NODE = eINSTANCE.getTopologyType_Node();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGY_TYPE__LINK = eINSTANCE.getTopologyType_Link();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGY_TYPE__ANY = eINSTANCE.getTopologyType_Any();

		/**
		 * The meta object literal for the '{@link tbd.params.xml.ns.yang.network.topology.impl.TopologyTypesTypeImpl <em>Types Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyTypesTypeImpl
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getTopologyTypesType()
		 * @generated
		 */
		EClass TOPOLOGY_TYPES_TYPE = eINSTANCE.getTopologyTypesType();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGY_TYPES_TYPE__ANY = eINSTANCE.getTopologyTypesType_Any();

		/**
		 * The meta object literal for the '{@link tbd.params.xml.ns.yang.network.topology.impl.UnderlayTopologyTypeImpl <em>Underlay Topology Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tbd.params.xml.ns.yang.network.topology.impl.UnderlayTopologyTypeImpl
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getUnderlayTopologyType()
		 * @generated
		 */
		EClass UNDERLAY_TOPOLOGY_TYPE = eINSTANCE.getUnderlayTopologyType();

		/**
		 * The meta object literal for the '<em><b>Topology Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNDERLAY_TOPOLOGY_TYPE__TOPOLOGY_REF = eINSTANCE.getUnderlayTopologyType_TopologyRef();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNDERLAY_TOPOLOGY_TYPE__ANY = eINSTANCE.getUnderlayTopologyType_Any();

		/**
		 * The meta object literal for the '<em>Link Id</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getLinkId()
		 * @generated
		 */
		EDataType LINK_ID = eINSTANCE.getLinkId();

		/**
		 * The meta object literal for the '<em>Link Ref</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getLinkRef()
		 * @generated
		 */
		EDataType LINK_REF = eINSTANCE.getLinkRef();

		/**
		 * The meta object literal for the '<em>Node Id</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getNodeId()
		 * @generated
		 */
		EDataType NODE_ID = eINSTANCE.getNodeId();

		/**
		 * The meta object literal for the '<em>Node Ref</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getNodeRef()
		 * @generated
		 */
		EDataType NODE_REF = eINSTANCE.getNodeRef();

		/**
		 * The meta object literal for the '<em>Id</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getTopologyId()
		 * @generated
		 */
		EDataType TOPOLOGY_ID = eINSTANCE.getTopologyId();

		/**
		 * The meta object literal for the '<em>Ref</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getTopologyRef()
		 * @generated
		 */
		EDataType TOPOLOGY_REF = eINSTANCE.getTopologyRef();

		/**
		 * The meta object literal for the '<em>Tp Id</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getTpId()
		 * @generated
		 */
		EDataType TP_ID = eINSTANCE.getTpId();

		/**
		 * The meta object literal for the '<em>Tp Ref</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl#getTpRef()
		 * @generated
		 */
		EDataType TP_REF = eINSTANCE.getTpRef();

	}

} //TopologyPackage
