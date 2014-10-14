/**
 */
package wadl;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link wadl.ResourceType#getDoc <em>Doc</em>}</li>
 *   <li>{@link wadl.ResourceType#getParam <em>Param</em>}</li>
 *   <li>{@link wadl.ResourceType#getGroup <em>Group</em>}</li>
 *   <li>{@link wadl.ResourceType#getMethod <em>Method</em>}</li>
 *   <li>{@link wadl.ResourceType#getResource <em>Resource</em>}</li>
 *   <li>{@link wadl.ResourceType#getAny <em>Any</em>}</li>
 *   <li>{@link wadl.ResourceType#getId <em>Id</em>}</li>
 *   <li>{@link wadl.ResourceType#getPath <em>Path</em>}</li>
 *   <li>{@link wadl.ResourceType#getQueryType <em>Query Type</em>}</li>
 *   <li>{@link wadl.ResourceType#getType <em>Type</em>}</li>
 *   <li>{@link wadl.ResourceType#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see wadl.WadlPackage#getResourceType()
 * @model extendedMetaData="name='resource_._type' kind='elementOnly'"
 * @generated
 */
public interface ResourceType extends EObject {
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
	 * @see wadl.WadlPackage#getResourceType_Doc()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='doc' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<DocType> getDoc();

	/**
	 * Returns the value of the '<em><b>Param</b></em>' containment reference list.
	 * The list contents are of type {@link wadl.ParamType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param</em>' containment reference list.
	 * @see wadl.WadlPackage#getResourceType_Param()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='param' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ParamType> getParam();

	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see wadl.WadlPackage#getResourceType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:2'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Method</b></em>' containment reference list.
	 * The list contents are of type {@link wadl.MethodType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' containment reference list.
	 * @see wadl.WadlPackage#getResourceType_Method()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='method' namespace='##targetNamespace' group='#group:2'"
	 * @generated
	 */
	EList<MethodType> getMethod();

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' containment reference list.
	 * The list contents are of type {@link wadl.ResourceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' containment reference list.
	 * @see wadl.WadlPackage#getResourceType_Resource()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='resource' namespace='##targetNamespace' group='#group:2'"
	 * @generated
	 */
	EList<ResourceType> getResource();

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
	 * @see wadl.WadlPackage#getResourceType_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':5' processing='lax'"
	 * @generated
	 */
	FeatureMap getAny();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see wadl.WadlPackage#getResourceType_Id()
	 * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link wadl.ResourceType#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see wadl.WadlPackage#getResourceType_Path()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='path'"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link wadl.ResourceType#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Query Type</b></em>' attribute.
	 * The default value is <code>"application/x-www-form-urlencoded"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Type</em>' attribute.
	 * @see #isSetQueryType()
	 * @see #unsetQueryType()
	 * @see #setQueryType(String)
	 * @see wadl.WadlPackage#getResourceType_QueryType()
	 * @model default="application/x-www-form-urlencoded" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='queryType'"
	 * @generated
	 */
	String getQueryType();

	/**
	 * Sets the value of the '{@link wadl.ResourceType#getQueryType <em>Query Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Type</em>' attribute.
	 * @see #isSetQueryType()
	 * @see #unsetQueryType()
	 * @see #getQueryType()
	 * @generated
	 */
	void setQueryType(String value);

	/**
	 * Unsets the value of the '{@link wadl.ResourceType#getQueryType <em>Query Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQueryType()
	 * @see #getQueryType()
	 * @see #setQueryType(String)
	 * @generated
	 */
	void unsetQueryType();

	/**
	 * Returns whether the value of the '{@link wadl.ResourceType#getQueryType <em>Query Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Query Type</em>' attribute is set.
	 * @see #unsetQueryType()
	 * @see #getQueryType()
	 * @see #setQueryType(String)
	 * @generated
	 */
	boolean isSetQueryType();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(List)
	 * @see wadl.WadlPackage#getResourceType_Type()
	 * @model dataType="wadl.ResourceTypeList" many="false"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	List<String> getType();

	/**
	 * Sets the value of the '{@link wadl.ResourceType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(List<String> value);

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
	 * @see wadl.WadlPackage#getResourceType_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':10' processing='lax'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // ResourceType
