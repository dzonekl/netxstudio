/**
 */
package wadl;

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
 *   <li>{@link wadl.LinkType#getDoc <em>Doc</em>}</li>
 *   <li>{@link wadl.LinkType#getAny <em>Any</em>}</li>
 *   <li>{@link wadl.LinkType#getRel <em>Rel</em>}</li>
 *   <li>{@link wadl.LinkType#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link wadl.LinkType#getRev <em>Rev</em>}</li>
 *   <li>{@link wadl.LinkType#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see wadl.WadlPackage#getLinkType()
 * @model extendedMetaData="name='link_._type' kind='elementOnly'"
 * @generated
 */
public interface LinkType extends EObject {
	/**
	 * Returns the value of the '<em><b>Doc</b></em>' containment reference list.
	 * The list contents are of type {@link wadl.DocType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Doc</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Doc</em>' containment reference list.
	 * @see wadl.WadlPackage#getLinkType_Doc()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='doc' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<DocType> getDoc();

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
	 * @see wadl.WadlPackage#getLinkType_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':1' processing='lax'"
	 * @generated
	 */
	FeatureMap getAny();

	/**
	 * Returns the value of the '<em><b>Rel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rel</em>' attribute.
	 * @see #setRel(String)
	 * @see wadl.WadlPackage#getLinkType_Rel()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Token"
	 *        extendedMetaData="kind='attribute' name='rel'"
	 * @generated
	 */
	String getRel();

	/**
	 * Sets the value of the '{@link wadl.LinkType#getRel <em>Rel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rel</em>' attribute.
	 * @see #getRel()
	 * @generated
	 */
	void setRel(String value);

	/**
	 * Returns the value of the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Type</em>' attribute.
	 * @see #setResourceType(String)
	 * @see wadl.WadlPackage#getLinkType_ResourceType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='resource_type'"
	 * @generated
	 */
	String getResourceType();

	/**
	 * Sets the value of the '{@link wadl.LinkType#getResourceType <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Type</em>' attribute.
	 * @see #getResourceType()
	 * @generated
	 */
	void setResourceType(String value);

	/**
	 * Returns the value of the '<em><b>Rev</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rev</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rev</em>' attribute.
	 * @see #setRev(String)
	 * @see wadl.WadlPackage#getLinkType_Rev()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Token"
	 *        extendedMetaData="kind='attribute' name='rev'"
	 * @generated
	 */
	String getRev();

	/**
	 * Sets the value of the '{@link wadl.LinkType#getRev <em>Rev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rev</em>' attribute.
	 * @see #getRev()
	 * @generated
	 */
	void setRev(String value);

	/**
	 * Returns the value of the '<em><b>Any Attribute</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any Attribute</em>' attribute list.
	 * @see wadl.WadlPackage#getLinkType_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':5' processing='lax'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // LinkType
