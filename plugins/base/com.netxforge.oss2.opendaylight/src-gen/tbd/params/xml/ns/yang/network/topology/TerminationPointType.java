/**
 */
package tbd.params.xml.ns.yang.network.topology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Termination Point Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.TerminationPointType#getTpId <em>Tp Id</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.TerminationPointType#getTpRef <em>Tp Ref</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.TerminationPointType#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getTerminationPointType()
 * @model extendedMetaData="name='termination-point_._type' kind='elementOnly'"
 * @generated
 */
public interface TerminationPointType extends EObject {
	/**
	 * Returns the value of the '<em><b>Tp Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tp Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tp Id</em>' attribute.
	 * @see #setTpId(String)
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getTerminationPointType_TpId()
	 * @model dataType="tbd.params.xml.ns.yang.network.topology.TpId" required="true"
	 *        extendedMetaData="kind='element' name='tp-id' namespace='##targetNamespace'"
	 * @generated
	 */
	String getTpId();

	/**
	 * Sets the value of the '{@link tbd.params.xml.ns.yang.network.topology.TerminationPointType#getTpId <em>Tp Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tp Id</em>' attribute.
	 * @see #getTpId()
	 * @generated
	 */
	void setTpId(String value);

	/**
	 * Returns the value of the '<em><b>Tp Ref</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                                 The leaf list identifies any termination points that the
	 *                                 termination point is dependent on, or maps onto.
	 *                                 Those termination points will themselves be contained
	 *                                 in a supporting node.
	 *                                 This dependency information can be inferred from
	 *                                 the dependencies between links.  For this reason,
	 *                                 this item is not separately configurable.  Hence no
	 *                                 corresponding constraint needs to be articulated.
	 *                                 The corresponding information is simply provided by the
	 *                                 implementing system.
	 *                               
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tp Ref</em>' attribute list.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getTerminationPointType_TpRef()
	 * @model unique="false" dataType="tbd.params.xml.ns.yang.network.topology.TpRef"
	 *        extendedMetaData="kind='element' name='tp-ref' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getTpRef();

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
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getTerminationPointType_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':2' processing='lax'"
	 * @generated
	 */
	FeatureMap getAny();

} // TerminationPointType
