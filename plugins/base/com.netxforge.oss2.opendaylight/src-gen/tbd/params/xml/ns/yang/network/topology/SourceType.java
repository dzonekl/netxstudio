/**
 */
package tbd.params.xml.ns.yang.network.topology;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.SourceType#getSourceNode <em>Source Node</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.SourceType#getSourceTp <em>Source Tp</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.SourceType#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getSourceType()
 * @model extendedMetaData="name='source_._type' kind='elementOnly'"
 * @generated
 */
public interface SourceType extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Node</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                                 Source node identifier, must be in same topology.
	 *                               
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Node</em>' attribute.
	 * @see #setSourceNode(String)
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getSourceType_SourceNode()
	 * @model dataType="tbd.params.xml.ns.yang.network.topology.NodeRef" required="true"
	 *        extendedMetaData="kind='element' name='source-node' namespace='##targetNamespace'"
	 * @generated
	 */
	String getSourceNode();

	/**
	 * Sets the value of the '{@link tbd.params.xml.ns.yang.network.topology.SourceType#getSourceNode <em>Source Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Node</em>' attribute.
	 * @see #getSourceNode()
	 * @generated
	 */
	void setSourceNode(String value);

	/**
	 * Returns the value of the '<em><b>Source Tp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                                 Termination point within source node that terminates the link.
	 *                               
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Tp</em>' attribute.
	 * @see #setSourceTp(String)
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getSourceType_SourceTp()
	 * @model dataType="tbd.params.xml.ns.yang.network.topology.TpRef"
	 *        extendedMetaData="kind='element' name='source-tp' namespace='##targetNamespace'"
	 * @generated
	 */
	String getSourceTp();

	/**
	 * Sets the value of the '{@link tbd.params.xml.ns.yang.network.topology.SourceType#getSourceTp <em>Source Tp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Tp</em>' attribute.
	 * @see #getSourceTp()
	 * @generated
	 */
	void setSourceTp(String value);

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
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getSourceType_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':2' processing='lax'"
	 * @generated
	 */
	FeatureMap getAny();

} // SourceType
