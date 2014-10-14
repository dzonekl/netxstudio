/**
 */
package od_core_topology;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link od_core_topology.Edge#getTailNodeConnector <em>Tail Node Connector</em>}</li>
 *   <li>{@link od_core_topology.Edge#getHeadNodeConnector <em>Head Node Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see od_core_topology.TopologyPackage#getEdge()
 * @model extendedMetaData="name='edge' kind='elementOnly'"
 * @generated
 */
public interface Edge extends EObject {
	/**
	 * Returns the value of the '<em><b>Tail Node Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tail Node Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tail Node Connector</em>' containment reference.
	 * @see #setTailNodeConnector(NodeConnector)
	 * @see od_core_topology.TopologyPackage#getEdge_TailNodeConnector()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='tailNodeConnector' namespace='##targetNamespace'"
	 * @generated
	 */
	NodeConnector getTailNodeConnector();

	/**
	 * Sets the value of the '{@link od_core_topology.Edge#getTailNodeConnector <em>Tail Node Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tail Node Connector</em>' containment reference.
	 * @see #getTailNodeConnector()
	 * @generated
	 */
	void setTailNodeConnector(NodeConnector value);

	/**
	 * Returns the value of the '<em><b>Head Node Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head Node Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head Node Connector</em>' containment reference.
	 * @see #setHeadNodeConnector(NodeConnector)
	 * @see od_core_topology.TopologyPackage#getEdge_HeadNodeConnector()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='headNodeConnector' namespace='##targetNamespace'"
	 * @generated
	 */
	NodeConnector getHeadNodeConnector();

	/**
	 * Sets the value of the '{@link od_core_topology.Edge#getHeadNodeConnector <em>Head Node Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head Node Connector</em>' containment reference.
	 * @see #getHeadNodeConnector()
	 * @generated
	 */
	void setHeadNodeConnector(NodeConnector value);

} // Edge
