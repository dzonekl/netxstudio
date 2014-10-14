/**
 */
package tbd.params.xml.ns.yang.network.topology;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Supporting Node Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.SupportingNodeType#getNodeRef <em>Node Ref</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.SupportingNodeType#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getSupportingNodeType()
 * @model extendedMetaData="name='supporting-node_._type' kind='elementOnly'"
 * @generated
 */
public interface SupportingNodeType extends EObject {
	/**
	 * Returns the value of the '<em><b>Node Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Ref</em>' attribute.
	 * @see #setNodeRef(String)
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getSupportingNodeType_NodeRef()
	 * @model dataType="tbd.params.xml.ns.yang.network.topology.NodeRef" required="true"
	 *        extendedMetaData="kind='element' name='node-ref' namespace='##targetNamespace'"
	 * @generated
	 */
	String getNodeRef();

	/**
	 * Sets the value of the '{@link tbd.params.xml.ns.yang.network.topology.SupportingNodeType#getNodeRef <em>Node Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Ref</em>' attribute.
	 * @see #getNodeRef()
	 * @generated
	 */
	void setNodeRef(String value);

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
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getSupportingNodeType_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':1' processing='lax'"
	 * @generated
	 */
	FeatureMap getAny();

} // SupportingNodeType
