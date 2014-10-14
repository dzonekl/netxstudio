/**
 */
package wadl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link wadl.ApplicationType#getDoc <em>Doc</em>}</li>
 *   <li>{@link wadl.ApplicationType#getGrammars <em>Grammars</em>}</li>
 *   <li>{@link wadl.ApplicationType#getResources <em>Resources</em>}</li>
 *   <li>{@link wadl.ApplicationType#getGroup <em>Group</em>}</li>
 *   <li>{@link wadl.ApplicationType#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link wadl.ApplicationType#getMethod <em>Method</em>}</li>
 *   <li>{@link wadl.ApplicationType#getRepresentation <em>Representation</em>}</li>
 *   <li>{@link wadl.ApplicationType#getParam <em>Param</em>}</li>
 *   <li>{@link wadl.ApplicationType#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @see wadl.WadlPackage#getApplicationType()
 * @model extendedMetaData="name='application_._type' kind='elementOnly'"
 * @generated
 */
public interface ApplicationType extends EObject {
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
	 * @see wadl.WadlPackage#getApplicationType_Doc()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='doc' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<DocType> getDoc();

	/**
	 * Returns the value of the '<em><b>Grammars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grammars</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grammars</em>' containment reference.
	 * @see #setGrammars(GrammarsType)
	 * @see wadl.WadlPackage#getApplicationType_Grammars()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='grammars' namespace='##targetNamespace'"
	 * @generated
	 */
	GrammarsType getGrammars();

	/**
	 * Sets the value of the '{@link wadl.ApplicationType#getGrammars <em>Grammars</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grammars</em>' containment reference.
	 * @see #getGrammars()
	 * @generated
	 */
	void setGrammars(GrammarsType value);

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link wadl.ResourcesType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see wadl.WadlPackage#getApplicationType_Resources()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='resources' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ResourcesType> getResources();

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
	 * @see wadl.WadlPackage#getApplicationType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:3'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Resource Type</b></em>' containment reference list.
	 * The list contents are of type {@link wadl.ResourceTypeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Type</em>' containment reference list.
	 * @see wadl.WadlPackage#getApplicationType_ResourceType()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='resource_type' namespace='##targetNamespace' group='#group:3'"
	 * @generated
	 */
	EList<ResourceTypeType> getResourceType();

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
	 * @see wadl.WadlPackage#getApplicationType_Method()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='method' namespace='##targetNamespace' group='#group:3'"
	 * @generated
	 */
	EList<MethodType> getMethod();

	/**
	 * Returns the value of the '<em><b>Representation</b></em>' containment reference list.
	 * The list contents are of type {@link wadl.RepresentationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Representation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representation</em>' containment reference list.
	 * @see wadl.WadlPackage#getApplicationType_Representation()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='representation' namespace='##targetNamespace' group='#group:3'"
	 * @generated
	 */
	EList<RepresentationType> getRepresentation();

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
	 * @see wadl.WadlPackage#getApplicationType_Param()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='param' namespace='##targetNamespace' group='#group:3'"
	 * @generated
	 */
	EList<ParamType> getParam();

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
	 * @see wadl.WadlPackage#getApplicationType_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':8' processing='lax'"
	 * @generated
	 */
	FeatureMap getAny();

} // ApplicationType
