/**
 */
package od_core_topology;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link od_core_topology.EdgeProperties#getEdge <em>Edge</em>}</li>
 *   <li>{@link od_core_topology.EdgeProperties#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see od_core_topology.TopologyPackage#getEdgeProperties()
 * @model extendedMetaData="name='edgeProperties' kind='elementOnly'"
 * @generated
 */
public interface EdgeProperties extends EObject {
	/**
	 * Returns the value of the '<em><b>Edge</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge</em>' containment reference.
	 * @see #setEdge(Edge)
	 * @see od_core_topology.TopologyPackage#getEdgeProperties_Edge()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='edge' namespace='##targetNamespace'"
	 * @generated
	 */
	Edge getEdge();

	/**
	 * Sets the value of the '{@link od_core_topology.EdgeProperties#getEdge <em>Edge</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge</em>' containment reference.
	 * @see #getEdge()
	 * @generated
	 */
	void setEdge(Edge value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference.
	 * @see #setProperties(PropertiesType)
	 * @see od_core_topology.TopologyPackage#getEdgeProperties_Properties()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='properties' namespace='##targetNamespace'"
	 * @generated
	 */
	PropertiesType getProperties();

	/**
	 * Sets the value of the '{@link od_core_topology.EdgeProperties#getProperties <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' containment reference.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(PropertiesType value);

} // EdgeProperties
