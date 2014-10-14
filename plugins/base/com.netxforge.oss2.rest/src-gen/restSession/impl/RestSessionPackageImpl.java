/**
 */
package restSession.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import restSession.EntityInfo;
import restSession.PathFragment;
import restSession.RestSession;
import restSession.RestSessionFactory;
import restSession.RestSessionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RestSessionPackageImpl extends EPackageImpl implements RestSessionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass restSessionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum httP_METHODSEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mediA_TYPEEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see restSession.RestSessionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RestSessionPackageImpl() {
		super(eNS_URI, RestSessionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link RestSessionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RestSessionPackage init() {
		if (isInited) return (RestSessionPackage)EPackage.Registry.INSTANCE.getEPackage(RestSessionPackage.eNS_URI);

		// Obtain or create and register package
		RestSessionPackageImpl theRestSessionPackage = (RestSessionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RestSessionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RestSessionPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theRestSessionPackage.createPackageContents();

		// Initialize created meta-data
		theRestSessionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRestSessionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RestSessionPackage.eNS_URI, theRestSessionPackage);
		return theRestSessionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRestSession() {
		return restSessionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRestSession_Userid() {
		return (EAttribute)restSessionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRestSession_HttpMethod() {
		return (EAttribute)restSessionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRestSession_BaseURI() {
		return (EAttribute)restSessionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRestSession_Password() {
		return (EAttribute)restSessionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRestSession_PathFragments() {
		return (EReference)restSessionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRestSession_Media() {
		return (EAttribute)restSessionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRestSession_EntityInfo() {
		return (EReference)restSessionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRestSession__Compleet() {
		return restSessionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRestSession__ConstructURI() {
		return restSessionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPathFragment() {
		return pathFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPathFragment_Fragment() {
		return (EAttribute)pathFragmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityInfo() {
		return entityInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityInfo_Name() {
		return (EAttribute)entityInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHTTP_METHODS() {
		return httP_METHODSEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMEDIA_TYPE() {
		return mediA_TYPEEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RestSessionFactory getRestSessionFactory() {
		return (RestSessionFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		restSessionEClass = createEClass(REST_SESSION);
		createEAttribute(restSessionEClass, REST_SESSION__USERID);
		createEAttribute(restSessionEClass, REST_SESSION__HTTP_METHOD);
		createEAttribute(restSessionEClass, REST_SESSION__BASE_URI);
		createEAttribute(restSessionEClass, REST_SESSION__PASSWORD);
		createEReference(restSessionEClass, REST_SESSION__PATH_FRAGMENTS);
		createEAttribute(restSessionEClass, REST_SESSION__MEDIA);
		createEReference(restSessionEClass, REST_SESSION__ENTITY_INFO);
		createEOperation(restSessionEClass, REST_SESSION___COMPLEET);
		createEOperation(restSessionEClass, REST_SESSION___CONSTRUCT_URI);

		pathFragmentEClass = createEClass(PATH_FRAGMENT);
		createEAttribute(pathFragmentEClass, PATH_FRAGMENT__FRAGMENT);

		entityInfoEClass = createEClass(ENTITY_INFO);
		createEAttribute(entityInfoEClass, ENTITY_INFO__NAME);

		// Create enums
		httP_METHODSEEnum = createEEnum(HTTP_METHODS);
		mediA_TYPEEEnum = createEEnum(MEDIA_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(restSessionEClass, RestSession.class, "RestSession", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRestSession_Userid(), ecorePackage.getEString(), "userid", "admin", 0, 1, RestSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRestSession_HttpMethod(), this.getHTTP_METHODS(), "httpMethod", null, 0, 1, RestSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRestSession_BaseURI(), ecorePackage.getEString(), "baseURI", "http://localhost:8181", 0, 1, RestSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRestSession_Password(), ecorePackage.getEString(), "password", null, 0, 1, RestSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRestSession_PathFragments(), this.getPathFragment(), null, "pathFragments", null, 0, -1, RestSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRestSession_Media(), this.getMEDIA_TYPE(), "media", null, 0, 1, RestSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRestSession_EntityInfo(), this.getEntityInfo(), null, "entityInfo", null, 0, 1, RestSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getRestSession__Compleet(), ecorePackage.getEBoolean(), "compleet", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getRestSession__ConstructURI(), ecorePackage.getEString(), "constructURI", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(pathFragmentEClass, PathFragment.class, "PathFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPathFragment_Fragment(), ecorePackage.getEString(), "fragment", null, 0, 1, PathFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityInfoEClass, EntityInfo.class, "EntityInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntityInfo_Name(), ecorePackage.getEString(), "name", null, 0, 1, EntityInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(httP_METHODSEEnum, restSession.HTTP_METHODS.class, "HTTP_METHODS");
		addEEnumLiteral(httP_METHODSEEnum, restSession.HTTP_METHODS.GET);
		addEEnumLiteral(httP_METHODSEEnum, restSession.HTTP_METHODS.POST);
		addEEnumLiteral(httP_METHODSEEnum, restSession.HTTP_METHODS.DELETE);

		initEEnum(mediA_TYPEEEnum, restSession.MEDIA_TYPE.class, "MEDIA_TYPE");
		addEEnumLiteral(mediA_TYPEEEnum, restSession.MEDIA_TYPE.XML);
		addEEnumLiteral(mediA_TYPEEEnum, restSession.MEDIA_TYPE.JSON);

		// Create resource
		createResource(eNS_URI);
	}

} //RestSessionPackageImpl
