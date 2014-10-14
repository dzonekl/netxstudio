/**
 */
package tbd.params.xml.ns.yang.network.topology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.LinkType#getLinkId <em>Link Id</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.LinkType#getSource <em>Source</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.LinkType#getDestination <em>Destination</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.LinkType#getSupportingLink <em>Supporting Link</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.LinkType#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getLinkType()
 * @model extendedMetaData="name='link_._type' kind='elementOnly'"
 * @generated
 */
public interface LinkType extends EObject {
	/**
	 * Returns the value of the '<em><b>Link Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *                           The identifier of a link in the topology.
	 *                           A link is specific to a topology to which it belongs.
	 *                         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Link Id</em>' attribute.
	 * @see #setLinkId(String)
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getLinkType_LinkId()
	 * @model dataType="tbd.params.xml.ns.yang.network.topology.LinkId" required="true"
	 *        extendedMetaData="kind='element' name='link-id' namespace='##targetNamespace'"
	 * @generated
	 */
	String getLinkId();

	/**
	 * Sets the value of the '{@link tbd.params.xml.ns.yang.network.topology.LinkType#getLinkId <em>Link Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Id</em>' attribute.
	 * @see #getLinkId()
	 * @generated
	 */
	void setLinkId(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(SourceType)
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getLinkType_Source()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='source' namespace='##targetNamespace'"
	 * @generated
	 */
	SourceType getSource();

	/**
	 * Sets the value of the '{@link tbd.params.xml.ns.yang.network.topology.LinkType#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(SourceType value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' containment reference.
	 * @see #setDestination(DestinationType)
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getLinkType_Destination()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='destination' namespace='##targetNamespace'"
	 * @generated
	 */
	DestinationType getDestination();

	/**
	 * Sets the value of the '{@link tbd.params.xml.ns.yang.network.topology.LinkType#getDestination <em>Destination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' containment reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(DestinationType value);

	/**
	 * Returns the value of the '<em><b>Supporting Link</b></em>' containment reference list.
	 * The list contents are of type {@link tbd.params.xml.ns.yang.network.topology.SupportingLinkType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supporting Link</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supporting Link</em>' containment reference list.
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getLinkType_SupportingLink()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='supporting-link' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SupportingLinkType> getSupportingLink();

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
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getLinkType_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':4' processing='lax'"
	 * @generated
	 */
	FeatureMap getAny();

} // LinkType
