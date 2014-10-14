/**
 */
package tbd.params.xml.ns.yang.network.topology;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Supporting Link Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.SupportingLinkType#getLinkRef <em>Link Ref</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.SupportingLinkType#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getSupportingLinkType()
 * @model extendedMetaData="name='supporting-link_._type' kind='elementOnly'"
 * @generated
 */
public interface SupportingLinkType extends EObject {
	/**
	 * Returns the value of the '<em><b>Link Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Ref</em>' attribute.
	 * @see #setLinkRef(String)
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getSupportingLinkType_LinkRef()
	 * @model dataType="tbd.params.xml.ns.yang.network.topology.LinkRef" required="true"
	 *        extendedMetaData="kind='element' name='link-ref' namespace='##targetNamespace'"
	 * @generated
	 */
	String getLinkRef();

	/**
	 * Sets the value of the '{@link tbd.params.xml.ns.yang.network.topology.SupportingLinkType#getLinkRef <em>Link Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Ref</em>' attribute.
	 * @see #getLinkRef()
	 * @generated
	 */
	void setLinkRef(String value);

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
	 * @see tbd.params.xml.ns.yang.network.topology.TopologyPackage#getSupportingLinkType_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':1' processing='lax'"
	 * @generated
	 */
	FeatureMap getAny();

} // SupportingLinkType
