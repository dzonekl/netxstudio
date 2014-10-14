/**
 */
package od_core_topology;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Link Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link od_core_topology.TopologyUserLinkConfig#getSrcNodeConnector <em>Src Node Connector</em>}</li>
 *   <li>{@link od_core_topology.TopologyUserLinkConfig#getDstNodeConnector <em>Dst Node Connector</em>}</li>
 *   <li>{@link od_core_topology.TopologyUserLinkConfig#getStatus <em>Status</em>}</li>
 *   <li>{@link od_core_topology.TopologyUserLinkConfig#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see od_core_topology.TopologyPackage#getTopologyUserLinkConfig()
 * @model extendedMetaData="name='topologyUserLinkConfig' kind='elementOnly'"
 * @generated
 */
public interface TopologyUserLinkConfig extends ConfigurationObject {
	/**
	 * Returns the value of the '<em><b>Src Node Connector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Node Connector</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Node Connector</em>' attribute.
	 * @see #setSrcNodeConnector(String)
	 * @see od_core_topology.TopologyPackage#getTopologyUserLinkConfig_SrcNodeConnector()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='srcNodeConnector' namespace='##targetNamespace'"
	 * @generated
	 */
	String getSrcNodeConnector();

	/**
	 * Sets the value of the '{@link od_core_topology.TopologyUserLinkConfig#getSrcNodeConnector <em>Src Node Connector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Node Connector</em>' attribute.
	 * @see #getSrcNodeConnector()
	 * @generated
	 */
	void setSrcNodeConnector(String value);

	/**
	 * Returns the value of the '<em><b>Dst Node Connector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dst Node Connector</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Node Connector</em>' attribute.
	 * @see #setDstNodeConnector(String)
	 * @see od_core_topology.TopologyPackage#getTopologyUserLinkConfig_DstNodeConnector()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='dstNodeConnector' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDstNodeConnector();

	/**
	 * Sets the value of the '{@link od_core_topology.TopologyUserLinkConfig#getDstNodeConnector <em>Dst Node Connector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Node Connector</em>' attribute.
	 * @see #getDstNodeConnector()
	 * @generated
	 */
	void setDstNodeConnector(String value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see #setStatus(String)
	 * @see od_core_topology.TopologyPackage#getTopologyUserLinkConfig_Status()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='status' namespace='##targetNamespace'"
	 * @generated
	 */
	String getStatus();

	/**
	 * Sets the value of the '{@link od_core_topology.TopologyUserLinkConfig#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see od_core_topology.TopologyPackage#getTopologyUserLinkConfig_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link od_core_topology.TopologyUserLinkConfig#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // TopologyUserLinkConfig
