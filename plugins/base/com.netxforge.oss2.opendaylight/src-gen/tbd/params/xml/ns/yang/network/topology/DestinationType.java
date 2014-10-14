/**
 */
package tbd.params.xml.ns.yang.network.topology;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Destination Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.DestinationType#getDestNode <em>Dest Node</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.DestinationType#getDestTp <em>Dest Tp</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.DestinationType#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getDestinationType()
 * @model extendedMetaData="name='destination_._type' kind='elementOnly'"
 * @generated
 */
public interface DestinationType extends EObject {
	/**
	 * Returns the value of the '<em><b>Dest Node</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                                 Destination node identifier, must be in same topology.
	 *                               
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Dest Node</em>' attribute.
	 * @see #setDestNode(String)
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getDestinationType_DestNode()
	 * @model dataType="tbd.params.xml.ns.yang.network.topology.NodeRef" required="true"
	 *        extendedMetaData="kind='element' name='dest-node' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDestNode();

	/**
	 * Sets the value of the '{@link tbd.params.xml.ns.yang.network.topology.DestinationType#getDestNode <em>Dest Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dest Node</em>' attribute.
	 * @see #getDestNode()
	 * @generated
	 */
	void setDestNode(String value);

	/**
	 * Returns the value of the '<em><b>Dest Tp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                                 Termination point within destination node that terminates the link.
	 *                               
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Dest Tp</em>' attribute.
	 * @see #setDestTp(String)
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getDestinationType_DestTp()
	 * @model dataType="tbd.params.xml.ns.yang.network.topology.TpRef"
	 *        extendedMetaData="kind='element' name='dest-tp' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDestTp();

	/**
	 * Sets the value of the '{@link tbd.params.xml.ns.yang.network.topology.DestinationType#getDestTp <em>Dest Tp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dest Tp</em>' attribute.
	 * @see #getDestTp()
	 * @generated
	 */
	void setDestTp(String value);

	/**
	 * Returns the value of the '<em><b>Any</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any</em>' attribute list.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getDestinationType_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':2' processing='lax'"
	 * @generated
	 */
	FeatureMap getAny();

} // DestinationType
