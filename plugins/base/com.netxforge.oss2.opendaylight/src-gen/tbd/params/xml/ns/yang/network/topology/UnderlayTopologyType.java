/**
 */
package tbd.params.xml.ns.yang.network.topology;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Underlay Topology Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.UnderlayTopologyType#getTopologyRef <em>Topology Ref</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.UnderlayTopologyType#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getUnderlayTopologyType()
 * @model extendedMetaData="name='underlay-topology_._type' kind='elementOnly'"
 * @generated
 */
public interface UnderlayTopologyType extends EObject {
	/**
	 * Returns the value of the '<em><b>Topology Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Topology Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Topology Ref</em>' attribute.
	 * @see #setTopologyRef(String)
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getUnderlayTopologyType_TopologyRef()
	 * @model dataType="tbd.params.xml.ns.yang.network.topology.TopologyRef" required="true"
	 *        extendedMetaData="kind='element' name='topology-ref' namespace='##targetNamespace'"
	 * @generated
	 */
	String getTopologyRef();

	/**
	 * Sets the value of the '{@link tbd.params.xml.ns.yang.network.topology.UnderlayTopologyType#getTopologyRef <em>Topology Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topology Ref</em>' attribute.
	 * @see #getTopologyRef()
	 * @generated
	 */
	void setTopologyRef(String value);

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
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getUnderlayTopologyType_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':1' processing='lax'"
	 * @generated
	 */
	FeatureMap getAny();

} // UnderlayTopologyType
