/**
 */
package od_core_topology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Topology</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link od_core_topology.Topology#getEdgeProperties <em>Edge Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see od_core_topology.TopologyPackage#getTopology()
 * @model extendedMetaData="name='topology' kind='elementOnly'"
 * @generated
 */
public interface Topology extends EObject {
	/**
	 * Returns the value of the '<em><b>Edge Properties</b></em>' containment reference list.
	 * The list contents are of type {@link od_core_topology.EdgeProperties}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge Properties</em>' containment reference list.
	 * @see od_core_topology.TopologyPackage#getTopology_EdgeProperties()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='edgeProperties' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<EdgeProperties> getEdgeProperties();

} // Topology
