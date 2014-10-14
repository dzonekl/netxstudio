/**
 */
package tbd.params.xml.ns.yang.network.topology.impl;

import ietf.params.xml.ns.yang.ietf.inet.types.TypesFactory;
import ietf.params.xml.ns.yang.ietf.inet.types.TypesPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tbd.params.xml.ns.yang.network.topology.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TopologyFactoryImpl extends EFactoryImpl implements TopologyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TopologyFactory init() {
		try {
			TopologyFactory theTopologyFactory = (TopologyFactory)EPackage.Registry.INSTANCE.getEFactory(TopologyPackage.eNS_URI);
			if (theTopologyFactory != null) {
				return theTopologyFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TopologyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopologyFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TopologyPackage.DESTINATION_TYPE: return createDestinationType();
			case TopologyPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case TopologyPackage.LINK_TYPE: return createLinkType();
			case TopologyPackage.NETWORK_TOPOLOGY_TYPE: return createNetworkTopologyType();
			case TopologyPackage.NODE_TYPE: return createNodeType();
			case TopologyPackage.SOURCE_TYPE: return createSourceType();
			case TopologyPackage.SUPPORTING_LINK_TYPE: return createSupportingLinkType();
			case TopologyPackage.SUPPORTING_NODE_TYPE: return createSupportingNodeType();
			case TopologyPackage.TERMINATION_POINT_TYPE: return createTerminationPointType();
			case TopologyPackage.TOPOLOGY_TYPE: return createTopologyType();
			case TopologyPackage.TOPOLOGY_TYPES_TYPE: return createTopologyTypesType();
			case TopologyPackage.UNDERLAY_TOPOLOGY_TYPE: return createUnderlayTopologyType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TopologyPackage.LINK_ID:
				return createLinkIdFromString(eDataType, initialValue);
			case TopologyPackage.LINK_REF:
				return createLinkRefFromString(eDataType, initialValue);
			case TopologyPackage.NODE_ID:
				return createNodeIdFromString(eDataType, initialValue);
			case TopologyPackage.NODE_REF:
				return createNodeRefFromString(eDataType, initialValue);
			case TopologyPackage.TOPOLOGY_ID:
				return createTopologyIdFromString(eDataType, initialValue);
			case TopologyPackage.TOPOLOGY_REF:
				return createTopologyRefFromString(eDataType, initialValue);
			case TopologyPackage.TP_ID:
				return createTpIdFromString(eDataType, initialValue);
			case TopologyPackage.TP_REF:
				return createTpRefFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TopologyPackage.LINK_ID:
				return convertLinkIdToString(eDataType, instanceValue);
			case TopologyPackage.LINK_REF:
				return convertLinkRefToString(eDataType, instanceValue);
			case TopologyPackage.NODE_ID:
				return convertNodeIdToString(eDataType, instanceValue);
			case TopologyPackage.NODE_REF:
				return convertNodeRefToString(eDataType, instanceValue);
			case TopologyPackage.TOPOLOGY_ID:
				return convertTopologyIdToString(eDataType, instanceValue);
			case TopologyPackage.TOPOLOGY_REF:
				return convertTopologyRefToString(eDataType, instanceValue);
			case TopologyPackage.TP_ID:
				return convertTpIdToString(eDataType, instanceValue);
			case TopologyPackage.TP_REF:
				return convertTpRefToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DestinationType createDestinationType() {
		DestinationTypeImpl destinationType = new DestinationTypeImpl();
		return destinationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkType createLinkType() {
		LinkTypeImpl linkType = new LinkTypeImpl();
		return linkType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetworkTopologyType createNetworkTopologyType() {
		NetworkTopologyTypeImpl networkTopologyType = new NetworkTopologyTypeImpl();
		return networkTopologyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType createNodeType() {
		NodeTypeImpl nodeType = new NodeTypeImpl();
		return nodeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceType createSourceType() {
		SourceTypeImpl sourceType = new SourceTypeImpl();
		return sourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SupportingLinkType createSupportingLinkType() {
		SupportingLinkTypeImpl supportingLinkType = new SupportingLinkTypeImpl();
		return supportingLinkType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SupportingNodeType createSupportingNodeType() {
		SupportingNodeTypeImpl supportingNodeType = new SupportingNodeTypeImpl();
		return supportingNodeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminationPointType createTerminationPointType() {
		TerminationPointTypeImpl terminationPointType = new TerminationPointTypeImpl();
		return terminationPointType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopologyType createTopologyType() {
		TopologyTypeImpl topologyType = new TopologyTypeImpl();
		return topologyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopologyTypesType createTopologyTypesType() {
		TopologyTypesTypeImpl topologyTypesType = new TopologyTypesTypeImpl();
		return topologyTypesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnderlayTopologyType createUnderlayTopologyType() {
		UnderlayTopologyTypeImpl underlayTopologyType = new UnderlayTopologyTypeImpl();
		return underlayTopologyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createLinkIdFromString(EDataType eDataType, String initialValue) {
		return (String)TypesFactory.eINSTANCE.createFromString(TypesPackage.Literals.URI, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLinkIdToString(EDataType eDataType, Object instanceValue) {
		return TypesFactory.eINSTANCE.convertToString(TypesPackage.Literals.URI, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createLinkRefFromString(EDataType eDataType, String initialValue) {
		return createLinkIdFromString(TopologyPackage.Literals.LINK_ID, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLinkRefToString(EDataType eDataType, Object instanceValue) {
		return convertLinkIdToString(TopologyPackage.Literals.LINK_ID, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNodeIdFromString(EDataType eDataType, String initialValue) {
		return (String)TypesFactory.eINSTANCE.createFromString(TypesPackage.Literals.URI, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNodeIdToString(EDataType eDataType, Object instanceValue) {
		return TypesFactory.eINSTANCE.convertToString(TypesPackage.Literals.URI, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNodeRefFromString(EDataType eDataType, String initialValue) {
		return createNodeIdFromString(TopologyPackage.Literals.NODE_ID, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNodeRefToString(EDataType eDataType, Object instanceValue) {
		return convertNodeIdToString(TopologyPackage.Literals.NODE_ID, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createTopologyIdFromString(EDataType eDataType, String initialValue) {
		return (String)TypesFactory.eINSTANCE.createFromString(TypesPackage.Literals.URI, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTopologyIdToString(EDataType eDataType, Object instanceValue) {
		return TypesFactory.eINSTANCE.convertToString(TypesPackage.Literals.URI, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createTopologyRefFromString(EDataType eDataType, String initialValue) {
		return createTopologyIdFromString(TopologyPackage.Literals.TOPOLOGY_ID, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTopologyRefToString(EDataType eDataType, Object instanceValue) {
		return convertTopologyIdToString(TopologyPackage.Literals.TOPOLOGY_ID, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createTpIdFromString(EDataType eDataType, String initialValue) {
		return (String)TypesFactory.eINSTANCE.createFromString(TypesPackage.Literals.URI, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTpIdToString(EDataType eDataType, Object instanceValue) {
		return TypesFactory.eINSTANCE.convertToString(TypesPackage.Literals.URI, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createTpRefFromString(EDataType eDataType, String initialValue) {
		return createTpIdFromString(TopologyPackage.Literals.TP_ID, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTpRefToString(EDataType eDataType, Object instanceValue) {
		return convertTpIdToString(TopologyPackage.Literals.TP_ID, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopologyPackage getTopologyPackage() {
		return (TopologyPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TopologyPackage getPackage() {
		return TopologyPackage.eINSTANCE;
	}

} //TopologyFactoryImpl
