/**
 */
package od_core_topology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Links</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link od_core_topology.TopologyUserLinks#getUserLinks <em>User Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see od_core_topology.TopologyPackage#getTopologyUserLinks()
 * @model extendedMetaData="name='topologyUserLinks' kind='elementOnly'"
 * @generated
 */
public interface TopologyUserLinks extends EObject {
	/**
	 * Returns the value of the '<em><b>User Links</b></em>' containment reference list.
	 * The list contents are of type {@link od_core_topology.TopologyUserLinkConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Links</em>' containment reference list.
	 * @see od_core_topology.TopologyPackage#getTopologyUserLinks_UserLinks()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='userLinks' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TopologyUserLinkConfig> getUserLinks();

} // TopologyUserLinks
