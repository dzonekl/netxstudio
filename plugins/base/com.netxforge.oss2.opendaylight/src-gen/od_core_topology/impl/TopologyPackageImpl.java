/**
 */
package od_core_topology.impl;

import od_core_topology.ConfigurationObject;
import od_core_topology.DocumentRoot;
import od_core_topology.Edge;
import od_core_topology.EdgeProperties;
import od_core_topology.Node;
import od_core_topology.NodeConnector;
import od_core_topology.PropertiesType;
import od_core_topology.Property;
import od_core_topology.Topology;
import od_core_topology.TopologyFactory;
import od_core_topology.TopologyPackage;
import od_core_topology.TopologyUserLinkConfig;
import od_core_topology.TopologyUserLinks;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

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
	private EClass configurationObjectEClass = null;

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
	private EClass edgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgePropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertiesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topologyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topologyUserLinkConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topologyUserLinksEClass = null;

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
	 * @see od_core_topology.TopologyPackage#eNS_URI
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

		// Create package meta-data objects
		theTopologyPackage.createPackageContents();

		// Initialize created meta-data
		theTopologyPackage.initializePackageContents();

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
	public EClass getConfigurationObject() {
		return configurationObjectEClass;
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
	public EReference getDocumentRoot_Edge() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_EdgeProperties() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_List() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Node() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_NodeConnector() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Property() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Topology() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_TopologyUserLinkConfig() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdge() {
		return edgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_TailNodeConnector() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_HeadNodeConnector() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdgeProperties() {
		return edgePropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgeProperties_Edge() {
		return (EReference)edgePropertiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgeProperties_Properties() {
		return (EReference)edgePropertiesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Id() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Type() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeConnector() {
		return nodeConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeConnector_Id() {
		return (EAttribute)nodeConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeConnector_Node() {
		return (EReference)nodeConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeConnector_Type() {
		return (EAttribute)nodeConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertiesType() {
		return propertiesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertiesType_Property() {
		return (EReference)propertiesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopology() {
		return topologyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopology_EdgeProperties() {
		return (EReference)topologyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopologyUserLinkConfig() {
		return topologyUserLinkConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopologyUserLinkConfig_SrcNodeConnector() {
		return (EAttribute)topologyUserLinkConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopologyUserLinkConfig_DstNodeConnector() {
		return (EAttribute)topologyUserLinkConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopologyUserLinkConfig_Status() {
		return (EAttribute)topologyUserLinkConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopologyUserLinkConfig_Name() {
		return (EAttribute)topologyUserLinkConfigEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopologyUserLinks() {
		return topologyUserLinksEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopologyUserLinks_UserLinks() {
		return (EReference)topologyUserLinksEClass.getEStructuralFeatures().get(0);
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
		configurationObjectEClass = createEClass(CONFIGURATION_OBJECT);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EDGE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EDGE_PROPERTIES);
		createEReference(documentRootEClass, DOCUMENT_ROOT__LIST);
		createEReference(documentRootEClass, DOCUMENT_ROOT__NODE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__NODE_CONNECTOR);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PROPERTY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TOPOLOGY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TOPOLOGY_USER_LINK_CONFIG);

		edgeEClass = createEClass(EDGE);
		createEReference(edgeEClass, EDGE__TAIL_NODE_CONNECTOR);
		createEReference(edgeEClass, EDGE__HEAD_NODE_CONNECTOR);

		edgePropertiesEClass = createEClass(EDGE_PROPERTIES);
		createEReference(edgePropertiesEClass, EDGE_PROPERTIES__EDGE);
		createEReference(edgePropertiesEClass, EDGE_PROPERTIES__PROPERTIES);

		nodeEClass = createEClass(NODE);
		createEAttribute(nodeEClass, NODE__ID);
		createEAttribute(nodeEClass, NODE__TYPE);

		nodeConnectorEClass = createEClass(NODE_CONNECTOR);
		createEAttribute(nodeConnectorEClass, NODE_CONNECTOR__ID);
		createEReference(nodeConnectorEClass, NODE_CONNECTOR__NODE);
		createEAttribute(nodeConnectorEClass, NODE_CONNECTOR__TYPE);

		propertiesTypeEClass = createEClass(PROPERTIES_TYPE);
		createEReference(propertiesTypeEClass, PROPERTIES_TYPE__PROPERTY);

		propertyEClass = createEClass(PROPERTY);

		topologyEClass = createEClass(TOPOLOGY);
		createEReference(topologyEClass, TOPOLOGY__EDGE_PROPERTIES);

		topologyUserLinkConfigEClass = createEClass(TOPOLOGY_USER_LINK_CONFIG);
		createEAttribute(topologyUserLinkConfigEClass, TOPOLOGY_USER_LINK_CONFIG__SRC_NODE_CONNECTOR);
		createEAttribute(topologyUserLinkConfigEClass, TOPOLOGY_USER_LINK_CONFIG__DST_NODE_CONNECTOR);
		createEAttribute(topologyUserLinkConfigEClass, TOPOLOGY_USER_LINK_CONFIG__STATUS);
		createEAttribute(topologyUserLinkConfigEClass, TOPOLOGY_USER_LINK_CONFIG__NAME);

		topologyUserLinksEClass = createEClass(TOPOLOGY_USER_LINKS);
		createEReference(topologyUserLinksEClass, TOPOLOGY_USER_LINKS__USER_LINKS);
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
		topologyUserLinkConfigEClass.getESuperTypes().add(this.getConfigurationObject());

		// Initialize classes, features, and operations; add parameters
		initEClass(configurationObjectEClass, ConfigurationObject.class, "ConfigurationObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Edge(), this.getEdge(), null, "edge", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_EdgeProperties(), this.getEdgeProperties(), null, "edgeProperties", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_List(), this.getTopologyUserLinks(), null, "list", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Node(), this.getNode(), null, "node", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_NodeConnector(), this.getNodeConnector(), null, "nodeConnector", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Property(), this.getProperty(), null, "property", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Topology(), this.getTopology(), null, "topology", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_TopologyUserLinkConfig(), this.getTopologyUserLinkConfig(), null, "topologyUserLinkConfig", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(edgeEClass, Edge.class, "Edge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdge_TailNodeConnector(), this.getNodeConnector(), null, "tailNodeConnector", null, 0, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdge_HeadNodeConnector(), this.getNodeConnector(), null, "headNodeConnector", null, 0, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(edgePropertiesEClass, EdgeProperties.class, "EdgeProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdgeProperties_Edge(), this.getEdge(), null, "edge", null, 0, 1, EdgeProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdgeProperties_Properties(), this.getPropertiesType(), null, "properties", null, 0, 1, EdgeProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNode_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeConnectorEClass, NodeConnector.class, "NodeConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNodeConnector_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, NodeConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeConnector_Node(), this.getNode(), null, "node", null, 0, 1, NodeConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNodeConnector_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, NodeConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertiesTypeEClass, PropertiesType.class, "PropertiesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertiesType_Property(), this.getProperty(), null, "property", null, 0, -1, PropertiesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(topologyEClass, Topology.class, "Topology", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopology_EdgeProperties(), this.getEdgeProperties(), null, "edgeProperties", null, 0, -1, Topology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(topologyUserLinkConfigEClass, TopologyUserLinkConfig.class, "TopologyUserLinkConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTopologyUserLinkConfig_SrcNodeConnector(), theXMLTypePackage.getString(), "srcNodeConnector", null, 0, 1, TopologyUserLinkConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTopologyUserLinkConfig_DstNodeConnector(), theXMLTypePackage.getString(), "dstNodeConnector", null, 0, 1, TopologyUserLinkConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTopologyUserLinkConfig_Status(), theXMLTypePackage.getString(), "status", null, 0, 1, TopologyUserLinkConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTopologyUserLinkConfig_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TopologyUserLinkConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(topologyUserLinksEClass, TopologyUserLinks.class, "TopologyUserLinks", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopologyUserLinks_UserLinks(), this.getTopologyUserLinkConfig(), null, "userLinks", null, 0, -1, TopologyUserLinks.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
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
		  (this, 
		   source, 
		   new String[] {
			 "qualified", "false"
		   });	
		addAnnotation
		  (configurationObjectEClass, 
		   source, 
		   new String[] {
			 "name", "configurationObject",
			 "kind", "empty"
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
		  (getDocumentRoot_Edge(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "edge",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_EdgeProperties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "edgeProperties",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_List(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "list",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Node(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "node",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_NodeConnector(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "nodeConnector",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Property(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "property",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Topology(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "topology",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_TopologyUserLinkConfig(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "topologyUserLinkConfig",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (edgeEClass, 
		   source, 
		   new String[] {
			 "name", "edge",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getEdge_TailNodeConnector(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "tailNodeConnector",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getEdge_HeadNodeConnector(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "headNodeConnector",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (edgePropertiesEClass, 
		   source, 
		   new String[] {
			 "name", "edgeProperties",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getEdgeProperties_Edge(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "edge",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getEdgeProperties_Properties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "properties",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (nodeEClass, 
		   source, 
		   new String[] {
			 "name", "node",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getNode_Id(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "id",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getNode_Type(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "type",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (nodeConnectorEClass, 
		   source, 
		   new String[] {
			 "name", "nodeConnector",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getNodeConnector_Id(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "id",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getNodeConnector_Node(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "node",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getNodeConnector_Type(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "type",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (propertiesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "properties_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getPropertiesType_Property(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "property",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (propertyEClass, 
		   source, 
		   new String[] {
			 "name", "property",
			 "kind", "empty"
		   });	
		addAnnotation
		  (topologyEClass, 
		   source, 
		   new String[] {
			 "name", "topology",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTopology_EdgeProperties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "edgeProperties",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (topologyUserLinkConfigEClass, 
		   source, 
		   new String[] {
			 "name", "topologyUserLinkConfig",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTopologyUserLinkConfig_SrcNodeConnector(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "srcNodeConnector",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTopologyUserLinkConfig_DstNodeConnector(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dstNodeConnector",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTopologyUserLinkConfig_Status(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "status",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTopologyUserLinkConfig_Name(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (topologyUserLinksEClass, 
		   source, 
		   new String[] {
			 "name", "topologyUserLinks",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTopologyUserLinks_UserLinks(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "userLinks",
			 "namespace", "##targetNamespace"
		   });
	}

} //TopologyPackageImpl
