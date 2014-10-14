/**
 */
package wadl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see wadl.WadlPackage
 * @generated
 */
public interface WadlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WadlFactory eINSTANCE = wadl.impl.WadlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Application Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application Type</em>'.
	 * @generated
	 */
	ApplicationType createApplicationType();

	/**
	 * Returns a new object of class '<em>Doc Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Doc Type</em>'.
	 * @generated
	 */
	DocType createDocType();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Grammars Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grammars Type</em>'.
	 * @generated
	 */
	GrammarsType createGrammarsType();

	/**
	 * Returns a new object of class '<em>Include Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Include Type</em>'.
	 * @generated
	 */
	IncludeType createIncludeType();

	/**
	 * Returns a new object of class '<em>Link Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Type</em>'.
	 * @generated
	 */
	LinkType createLinkType();

	/**
	 * Returns a new object of class '<em>Method Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Type</em>'.
	 * @generated
	 */
	MethodType createMethodType();

	/**
	 * Returns a new object of class '<em>Option Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Option Type</em>'.
	 * @generated
	 */
	OptionType createOptionType();

	/**
	 * Returns a new object of class '<em>Param Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Param Type</em>'.
	 * @generated
	 */
	ParamType createParamType();

	/**
	 * Returns a new object of class '<em>Representation Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Representation Type</em>'.
	 * @generated
	 */
	RepresentationType createRepresentationType();

	/**
	 * Returns a new object of class '<em>Request Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Request Type</em>'.
	 * @generated
	 */
	RequestType createRequestType();

	/**
	 * Returns a new object of class '<em>Resources Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resources Type</em>'.
	 * @generated
	 */
	ResourcesType createResourcesType();

	/**
	 * Returns a new object of class '<em>Resource Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Type</em>'.
	 * @generated
	 */
	ResourceType createResourceType();

	/**
	 * Returns a new object of class '<em>Resource Type Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Type Type</em>'.
	 * @generated
	 */
	ResourceTypeType createResourceTypeType();

	/**
	 * Returns a new object of class '<em>Response Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Response Type</em>'.
	 * @generated
	 */
	ResponseType createResponseType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	WadlPackage getWadlPackage();

} //WadlFactory
