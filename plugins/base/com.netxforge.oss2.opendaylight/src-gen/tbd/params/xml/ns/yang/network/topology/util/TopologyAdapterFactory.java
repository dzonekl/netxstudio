/**
 */
package tbd.params.xml.ns.yang.network.topology.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import tbd.params.xml.ns.yang.network.topology.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage
 * @generated
 */
public class TopologyAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TopologyPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopologyAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TopologyPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopologySwitch<Adapter> modelSwitch =
		new TopologySwitch<Adapter>() {
			@Override
			public Adapter caseDestinationType(DestinationType object) {
				return createDestinationTypeAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseLinkType(LinkType object) {
				return createLinkTypeAdapter();
			}
			@Override
			public Adapter caseNetworkTopologyType(NetworkTopologyType object) {
				return createNetworkTopologyTypeAdapter();
			}
			@Override
			public Adapter caseNodeType(NodeType object) {
				return createNodeTypeAdapter();
			}
			@Override
			public Adapter caseSourceType(SourceType object) {
				return createSourceTypeAdapter();
			}
			@Override
			public Adapter caseSupportingLinkType(SupportingLinkType object) {
				return createSupportingLinkTypeAdapter();
			}
			@Override
			public Adapter caseSupportingNodeType(SupportingNodeType object) {
				return createSupportingNodeTypeAdapter();
			}
			@Override
			public Adapter caseTerminationPointType(TerminationPointType object) {
				return createTerminationPointTypeAdapter();
			}
			@Override
			public Adapter caseTopologyType(TopologyType object) {
				return createTopologyTypeAdapter();
			}
			@Override
			public Adapter caseTopologyTypesType(TopologyTypesType object) {
				return createTopologyTypesTypeAdapter();
			}
			@Override
			public Adapter caseUnderlayTopologyType(UnderlayTopologyType object) {
				return createUnderlayTopologyTypeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link tbd.params.xml.ns.yang.network.topology.DestinationType <em>Destination Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tbd.params.xml.ns.yang.network.topology.DestinationType
	 * @generated
	 */
	public Adapter createDestinationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tbd.params.xml.ns.yang.network.topology.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tbd.params.xml.ns.yang.network.topology.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tbd.params.xml.ns.yang.network.topology.LinkType <em>Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tbd.params.xml.ns.yang.network.topology.LinkType
	 * @generated
	 */
	public Adapter createLinkTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tbd.params.xml.ns.yang.network.topology.NetworkTopologyType <em>Network Topology Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tbd.params.xml.ns.yang.network.topology.NetworkTopologyType
	 * @generated
	 */
	public Adapter createNetworkTopologyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tbd.params.xml.ns.yang.network.topology.NodeType <em>Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tbd.params.xml.ns.yang.network.topology.NodeType
	 * @generated
	 */
	public Adapter createNodeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tbd.params.xml.ns.yang.network.topology.SourceType <em>Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tbd.params.xml.ns.yang.network.topology.SourceType
	 * @generated
	 */
	public Adapter createSourceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tbd.params.xml.ns.yang.network.topology.SupportingLinkType <em>Supporting Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tbd.params.xml.ns.yang.network.topology.SupportingLinkType
	 * @generated
	 */
	public Adapter createSupportingLinkTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tbd.params.xml.ns.yang.network.topology.SupportingNodeType <em>Supporting Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tbd.params.xml.ns.yang.network.topology.SupportingNodeType
	 * @generated
	 */
	public Adapter createSupportingNodeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tbd.params.xml.ns.yang.network.topology.TerminationPointType <em>Termination Point Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tbd.params.xml.ns.yang.network.topology.TerminationPointType
	 * @generated
	 */
	public Adapter createTerminationPointTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tbd.params.xml.ns.yang.network.topology.TopologyType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyType
	 * @generated
	 */
	public Adapter createTopologyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tbd.params.xml.ns.yang.network.topology.TopologyTypesType <em>Types Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyTypesType
	 * @generated
	 */
	public Adapter createTopologyTypesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tbd.params.xml.ns.yang.network.topology.UnderlayTopologyType <em>Underlay Topology Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tbd.params.xml.ns.yang.network.topology.UnderlayTopologyType
	 * @generated
	 */
	public Adapter createUnderlayTopologyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TopologyAdapterFactory
