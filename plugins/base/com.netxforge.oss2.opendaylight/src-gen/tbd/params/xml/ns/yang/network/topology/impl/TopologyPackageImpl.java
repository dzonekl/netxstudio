/**
 */
package tbd.params.xml.ns.yang.network.topology.impl;

import ietf.params.xml.ns.yang.ietf.inet.types.TypesPackage;

import ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import tbd.params.xml.ns.yang.network.topology.DestinationType;
import tbd.params.xml.ns.yang.network.topology.DocumentRoot;
import tbd.params.xml.ns.yang.network.topology.LinkType;
import tbd.params.xml.ns.yang.network.topology.NetworkTopologyType;
import tbd.params.xml.ns.yang.network.topology.NodeType;
import tbd.params.xml.ns.yang.network.topology.SourceType;
import tbd.params.xml.ns.yang.network.topology.SupportingLinkType;
import tbd.params.xml.ns.yang.network.topology.SupportingNodeType;
import tbd.params.xml.ns.yang.network.topology.TerminationPointType;
import tbd.params.xml.ns.yang.network.topology.TopologyFactory;
import tbd.params.xml.ns.yang.network.topology.TopologyPackage;
import tbd.params.xml.ns.yang.network.topology.TopologyType;
import tbd.params.xml.ns.yang.network.topology.TopologyTypesType;
import tbd.params.xml.ns.yang.network.topology.UnderlayTopologyType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TopologyPackageImpl extends EPackageImpl implements TopologyPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass destinationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass networkTopologyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass supportingLinkTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass supportingNodeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminationPointTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topologyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topologyTypesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass underlayTopologyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType linkIdEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType linkRefEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType nodeIdEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType nodeRefEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType topologyIdEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType topologyRefEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType tpIdEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType tpRefEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TopologyPackageImpl() {
		super(eNS_URI, TopologyFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TopologyPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TopologyPackage init() {
		if (isInited) return (TopologyPackage)EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI);

		// Obtain or create and register package
		TopologyPackageImpl theTopologyPackage = (TopologyPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TopologyPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TopologyPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);

		// Create package meta-data objects
		theTopologyPackage.createPackageContents();
		theTypesPackage.createPackageContents();

		// Initialize created meta-data
		theTopologyPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTopologyPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TopologyPackage.eNS_URI, theTopologyPackage);
		return theTopologyPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDestinationType() {
		return destinationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDestinationType_DestNode() {
		return (EAttribute)destinationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDestinationType_DestTp() {
		return (EAttribute)destinationTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDestinationType_Any() {
		return (EAttribute)destinationTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_NetworkTopology() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkType() {
		return linkTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkType_LinkId() {
		return (EAttribute)linkTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkType_Source() {
		return (EReference)linkTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkType_Destination() {
		return (EReference)linkTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkType_SupportingLink() {
		return (EReference)linkTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkType_Any() {
		return (EAttribute)linkTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNetworkTopologyType() {
		return networkTopologyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetworkTopologyType_Topology() {
		return (EReference)networkTopologyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNetworkTopologyType_Any() {
		return (EAttribute)networkTopologyTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeType() {
		return nodeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeType_NodeId() {
		return (EAttribute)nodeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeType_SupportingNode() {
		return (EReference)nodeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeType_TerminationPoint() {
		return (EReference)nodeTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeType_Any() {
		return (EAttribute)nodeTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceType() {
		return sourceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceType_SourceNode() {
		return (EAttribute)sourceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceType_SourceTp() {
		return (EAttribute)sourceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceType_Any() {
		return (EAttribute)sourceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSupportingLinkType() {
		return supportingLinkTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupportingLinkType_LinkRef() {
		return (EAttribute)supportingLinkTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupportingLinkType_Any() {
		return (EAttribute)supportingLinkTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSupportingNodeType() {
		return supportingNodeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupportingNodeType_NodeRef() {
		return (EAttribute)supportingNodeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupportingNodeType_Any() {
		return (EAttribute)supportingNodeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminationPointType() {
		return terminationPointTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTerminationPointType_TpId() {
		return (EAttribute)terminationPointTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTerminationPointType_TpRef() {
		return (EAttribute)terminationPointTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTerminationPointType_Any() {
		return (EAttribute)terminationPointTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopologyType() {
		return topologyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopologyType_TopologyId() {
		return (EAttribute)topologyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopologyType_ServerProvided() {
		return (EAttribute)topologyTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopologyType_TopologyTypes() {
		return (EReference)topologyTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopologyType_UnderlayTopology() {
		return (EReference)topologyTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopologyType_Node() {
		return (EReference)topologyTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopologyType_Link() {
		return (EReference)topologyTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopologyType_Any() {
		return (EAttribute)topologyTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopologyTypesType() {
		return topologyTypesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopologyTypesType_Any() {
		return (EAttribute)topologyTypesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnderlayTopologyType() {
		return underlayTopologyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnderlayTopologyType_TopologyRef() {
		return (EAttribute)underlayTopologyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnderlayTopologyType_Any() {
		return (EAttribute)underlayTopologyTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLinkId() {
		return linkIdEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLinkRef() {
		return linkRefEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNodeId() {
		return nodeIdEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNodeRef() {
		return nodeRefEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTopologyId() {
		return topologyIdEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTopologyRef() {
		return topologyRefEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTpId() {
		return tpIdEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTpRef() {
		return tpRefEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopologyFactory getTopologyFactory() {
		return (TopologyFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		destinationTypeEClass = createEClass(DESTINATION_TYPE);
		createEAttribute(destinationTypeEClass, DESTINATION_TYPE__DEST_NODE);
		createEAttribute(destinationTypeEClass, DESTINATION_TYPE__DEST_TP);
		createEAttribute(destinationTypeEClass, DESTINATION_TYPE__ANY);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__NETWORK_TOPOLOGY);

		linkTypeEClass = createEClass(LINK_TYPE);
		createEAttribute(linkTypeEClass, LINK_TYPE__LINK_ID);
		createEReference(linkTypeEClass, LINK_TYPE__SOURCE);
		createEReference(linkTypeEClass, LINK_TYPE__DESTINATION);
		createEReference(linkTypeEClass, LINK_TYPE__SUPPORTING_LINK);
		createEAttribute(linkTypeEClass, LINK_TYPE__ANY);

		networkTopologyTypeEClass = createEClass(NETWORK_TOPOLOGY_TYPE);
		createEReference(networkTopologyTypeEClass, NETWORK_TOPOLOGY_TYPE__TOPOLOGY);
		createEAttribute(networkTopologyTypeEClass, NETWORK_TOPOLOGY_TYPE__ANY);

		nodeTypeEClass = createEClass(NODE_TYPE);
		createEAttribute(nodeTypeEClass, NODE_TYPE__NODE_ID);
		createEReference(nodeTypeEClass, NODE_TYPE__SUPPORTING_NODE);
		createEReference(nodeTypeEClass, NODE_TYPE__TERMINATION_POINT);
		createEAttribute(nodeTypeEClass, NODE_TYPE__ANY);

		sourceTypeEClass = createEClass(SOURCE_TYPE);
		createEAttribute(sourceTypeEClass, SOURCE_TYPE__SOURCE_NODE);
		createEAttribute(sourceTypeEClass, SOURCE_TYPE__SOURCE_TP);
		createEAttribute(sourceTypeEClass, SOURCE_TYPE__ANY);

		supportingLinkTypeEClass = createEClass(SUPPORTING_LINK_TYPE);
		createEAttribute(supportingLinkTypeEClass, SUPPORTING_LINK_TYPE__LINK_REF);
		createEAttribute(supportingLinkTypeEClass, SUPPORTING_LINK_TYPE__ANY);

		supportingNodeTypeEClass = createEClass(SUPPORTING_NODE_TYPE);
		createEAttribute(supportingNodeTypeEClass, SUPPORTING_NODE_TYPE__NODE_REF);
		createEAttribute(supportingNodeTypeEClass, SUPPORTING_NODE_TYPE__ANY);

		terminationPointTypeEClass = createEClass(TERMINATION_POINT_TYPE);
		createEAttribute(terminationPointTypeEClass, TERMINATION_POINT_TYPE__TP_ID);
		createEAttribute(terminationPointTypeEClass, TERMINATION_POINT_TYPE__TP_REF);
		createEAttribute(terminationPointTypeEClass, TERMINATION_POINT_TYPE__ANY);

		topologyTypeEClass = createEClass(TOPOLOGY_TYPE);
		createEAttribute(topologyTypeEClass, TOPOLOGY_TYPE__TOPOLOGY_ID);
		createEAttribute(topologyTypeEClass, TOPOLOGY_TYPE__SERVER_PROVIDED);
		createEReference(topologyTypeEClass, TOPOLOGY_TYPE__TOPOLOGY_TYPES);
		createEReference(topologyTypeEClass, TOPOLOGY_TYPE__UNDERLAY_TOPOLOGY);
		createEReference(topologyTypeEClass, TOPOLOGY_TYPE__NODE);
		createEReference(topologyTypeEClass, TOPOLOGY_TYPE__LINK);
		createEAttribute(topologyTypeEClass, TOPOLOGY_TYPE__ANY);

		topologyTypesTypeEClass = createEClass(TOPOLOGY_TYPES_TYPE);
		createEAttribute(topologyTypesTypeEClass, TOPOLOGY_TYPES_TYPE__ANY);

		underlayTopologyTypeEClass = createEClass(UNDERLAY_TOPOLOGY_TYPE);
		createEAttribute(underlayTopologyTypeEClass, UNDERLAY_TOPOLOGY_TYPE__TOPOLOGY_REF);
		createEAttribute(underlayTopologyTypeEClass, UNDERLAY_TOPOLOGY_TYPE__ANY);

		// Create data types
		linkIdEDataType = createEDataType(LINK_ID);
		linkRefEDataType = createEDataType(LINK_REF);
		nodeIdEDataType = createEDataType(NODE_ID);
		nodeRefEDataType = createEDataType(NODE_REF);
		topologyIdEDataType = createEDataType(TOPOLOGY_ID);
		topologyRefEDataType = createEDataType(TOPOLOGY_REF);
		tpIdEDataType = createEDataType(TP_ID);
		tpRefEDataType = createEDataType(TP_REF);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(destinationTypeEClass, DestinationType.class, "DestinationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDestinationType_DestNode(), this.getNodeRef(), "destNode", null, 1, 1, DestinationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDestinationType_DestTp(), this.getTpRef(), "destTp", null, 0, 1, DestinationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDestinationType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, DestinationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_NetworkTopology(), this.getNetworkTopologyType(), null, "networkTopology", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(linkTypeEClass, LinkType.class, "LinkType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLinkType_LinkId(), this.getLinkId(), "linkId", null, 1, 1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLinkType_Source(), this.getSourceType(), null, "source", null, 0, 1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLinkType_Destination(), this.getDestinationType(), null, "destination", null, 0, 1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLinkType_SupportingLink(), this.getSupportingLinkType(), null, "supportingLink", null, 0, -1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinkType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(networkTopologyTypeEClass, NetworkTopologyType.class, "NetworkTopologyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNetworkTopologyType_Topology(), this.getTopologyType(), null, "topology", null, 0, -1, NetworkTopologyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNetworkTopologyType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, NetworkTopologyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeTypeEClass, NodeType.class, "NodeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNodeType_NodeId(), this.getNodeId(), "nodeId", null, 1, 1, NodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeType_SupportingNode(), this.getSupportingNodeType(), null, "supportingNode", null, 0, -1, NodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeType_TerminationPoint(), this.getTerminationPointType(), null, "terminationPoint", null, 0, -1, NodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNodeType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, NodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceTypeEClass, SourceType.class, "SourceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSourceType_SourceNode(), this.getNodeRef(), "sourceNode", null, 1, 1, SourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSourceType_SourceTp(), this.getTpRef(), "sourceTp", null, 0, 1, SourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSourceType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, SourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(supportingLinkTypeEClass, SupportingLinkType.class, "SupportingLinkType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSupportingLinkType_LinkRef(), this.getLinkRef(), "linkRef", null, 1, 1, SupportingLinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSupportingLinkType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, SupportingLinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(supportingNodeTypeEClass, SupportingNodeType.class, "SupportingNodeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSupportingNodeType_NodeRef(), this.getNodeRef(), "nodeRef", null, 1, 1, SupportingNodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSupportingNodeType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, SupportingNodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(terminationPointTypeEClass, TerminationPointType.class, "TerminationPointType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTerminationPointType_TpId(), this.getTpId(), "tpId", null, 1, 1, TerminationPointType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTerminationPointType_TpRef(), this.getTpRef(), "tpRef", null, 0, -1, TerminationPointType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTerminationPointType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, TerminationPointType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(topologyTypeEClass, TopologyType.class, "TopologyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTopologyType_TopologyId(), this.getTopologyId(), "topologyId", null, 1, 1, TopologyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTopologyType_ServerProvided(), theXMLTypePackage.getBoolean(), "serverProvided", null, 0, 1, TopologyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopologyType_TopologyTypes(), this.getTopologyTypesType(), null, "topologyTypes", null, 0, 1, TopologyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopologyType_UnderlayTopology(), this.getUnderlayTopologyType(), null, "underlayTopology", null, 0, -1, TopologyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopologyType_Node(), this.getNodeType(), null, "node", null, 0, -1, TopologyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopologyType_Link(), this.getLinkType(), null, "link", null, 0, -1, TopologyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTopologyType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, TopologyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(topologyTypesTypeEClass, TopologyTypesType.class, "TopologyTypesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTopologyTypesType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, TopologyTypesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(underlayTopologyTypeEClass, UnderlayTopologyType.class, "UnderlayTopologyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnderlayTopologyType_TopologyRef(), this.getTopologyRef(), "topologyRef", null, 1, 1, UnderlayTopologyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnderlayTopologyType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, UnderlayTopologyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(linkIdEDataType, String.class, "LinkId", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(linkRefEDataType, String.class, "LinkRef", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(nodeIdEDataType, String.class, "NodeId", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(nodeRefEDataType, String.class, "NodeRef", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(topologyIdEDataType, String.class, "TopologyId", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(topologyRefEDataType, String.class, "TopologyRef", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(tpIdEDataType, String.class, "TpId", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(tpRefEDataType, String.class, "TpRef", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.w3.org/XML/1998/namespace
		createNamespaceAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.w3.org/XML/1998/namespace</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createNamespaceAnnotations() {
		String source = "http://www.w3.org/XML/1998/namespace";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "lang", "en"
		   });
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
		addAnnotation
		  (destinationTypeEClass, 
		   source, 
		   new String[] {
			 "name", "destination_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getDestinationType_DestNode(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dest-node",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDestinationType_DestTp(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dest-tp",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDestinationType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":2",
			 "processing", "lax"
		   });	
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });	
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });	
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });	
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });	
		addAnnotation
		  (getDocumentRoot_NetworkTopology(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "network-topology",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (linkIdEDataType, 
		   source, 
		   new String[] {
			 "name", "link-id",
			 "baseType", "urn:ietf:params:xml:ns:yang:ietf-inet-types#uri"
		   });	
		addAnnotation
		  (linkRefEDataType, 
		   source, 
		   new String[] {
			 "name", "link-ref",
			 "baseType", "link-id"
		   });	
		addAnnotation
		  (linkTypeEClass, 
		   source, 
		   new String[] {
			 "name", "link_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getLinkType_LinkId(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "link-id",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getLinkType_Source(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "source",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getLinkType_Destination(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "destination",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getLinkType_SupportingLink(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "supporting-link",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getLinkType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":4",
			 "processing", "lax"
		   });	
		addAnnotation
		  (networkTopologyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "network-topology_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getNetworkTopologyType_Topology(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "topology",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getNetworkTopologyType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":1",
			 "processing", "lax"
		   });	
		addAnnotation
		  (nodeIdEDataType, 
		   source, 
		   new String[] {
			 "name", "node-id",
			 "baseType", "urn:ietf:params:xml:ns:yang:ietf-inet-types#uri"
		   });	
		addAnnotation
		  (nodeRefEDataType, 
		   source, 
		   new String[] {
			 "name", "node-ref",
			 "baseType", "node-id"
		   });	
		addAnnotation
		  (nodeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "node_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getNodeType_NodeId(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "node-id",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getNodeType_SupportingNode(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "supporting-node",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getNodeType_TerminationPoint(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "termination-point",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getNodeType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":3",
			 "processing", "lax"
		   });	
		addAnnotation
		  (sourceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "source_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getSourceType_SourceNode(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "source-node",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getSourceType_SourceTp(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "source-tp",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getSourceType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":2",
			 "processing", "lax"
		   });	
		addAnnotation
		  (supportingLinkTypeEClass, 
		   source, 
		   new String[] {
			 "name", "supporting-link_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getSupportingLinkType_LinkRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "link-ref",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getSupportingLinkType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":1",
			 "processing", "lax"
		   });	
		addAnnotation
		  (supportingNodeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "supporting-node_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getSupportingNodeType_NodeRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "node-ref",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getSupportingNodeType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":1",
			 "processing", "lax"
		   });	
		addAnnotation
		  (terminationPointTypeEClass, 
		   source, 
		   new String[] {
			 "name", "termination-point_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTerminationPointType_TpId(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "tp-id",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTerminationPointType_TpRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "tp-ref",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTerminationPointType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":2",
			 "processing", "lax"
		   });	
		addAnnotation
		  (topologyIdEDataType, 
		   source, 
		   new String[] {
			 "name", "topology-id",
			 "baseType", "urn:ietf:params:xml:ns:yang:ietf-inet-types#uri"
		   });	
		addAnnotation
		  (topologyRefEDataType, 
		   source, 
		   new String[] {
			 "name", "topology-ref",
			 "baseType", "topology-id"
		   });	
		addAnnotation
		  (topologyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "topology_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTopologyType_TopologyId(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "topology-id",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTopologyType_ServerProvided(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "server-provided",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTopologyType_TopologyTypes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "topology-types",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTopologyType_UnderlayTopology(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "underlay-topology",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTopologyType_Node(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "node",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTopologyType_Link(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "link",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTopologyType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":6",
			 "processing", "lax"
		   });	
		addAnnotation
		  (topologyTypesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "topology-types_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTopologyTypesType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":0",
			 "processing", "lax"
		   });	
		addAnnotation
		  (tpIdEDataType, 
		   source, 
		   new String[] {
			 "name", "tp-id",
			 "baseType", "urn:ietf:params:xml:ns:yang:ietf-inet-types#uri"
		   });	
		addAnnotation
		  (tpRefEDataType, 
		   source, 
		   new String[] {
			 "name", "tp-ref",
			 "baseType", "tp-id"
		   });	
		addAnnotation
		  (underlayTopologyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "underlay-topology_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getUnderlayTopologyType_TopologyRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "topology-ref",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getUnderlayTopologyType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":1",
			 "processing", "lax"
		   });
	}

} //TopologyPackageImpl
