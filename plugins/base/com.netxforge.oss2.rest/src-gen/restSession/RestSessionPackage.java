/**
 */
package restSession;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see restSession.RestSessionFactory
 * @model kind="package"
 * @generated
 */
public interface RestSessionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "restSession";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.netxforge.com/restsession";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "restSession";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RestSessionPackage eINSTANCE = restSession.impl.RestSessionPackageImpl.init();

	/**
	 * The meta object id for the '{@link restSession.impl.RestSessionImpl <em>Rest Session</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see restSession.impl.RestSessionImpl
	 * @see restSession.impl.RestSessionPackageImpl#getRestSession()
	 * @generated
	 */
	int REST_SESSION = 0;

	/**
	 * The feature id for the '<em><b>Userid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_SESSION__USERID = 0;

	/**
	 * The feature id for the '<em><b>Http Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_SESSION__HTTP_METHOD = 1;

	/**
	 * The feature id for the '<em><b>Base URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_SESSION__BASE_URI = 2;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_SESSION__PASSWORD = 3;

	/**
	 * The feature id for the '<em><b>Path Fragments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_SESSION__PATH_FRAGMENTS = 4;

	/**
	 * The feature id for the '<em><b>Media</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_SESSION__MEDIA = 5;

	/**
	 * The feature id for the '<em><b>Entity Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_SESSION__ENTITY_INFO = 6;

	/**
	 * The number of structural features of the '<em>Rest Session</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_SESSION_FEATURE_COUNT = 7;

	/**
	 * The operation id for the '<em>Compleet</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_SESSION___COMPLEET = 0;

	/**
	 * The operation id for the '<em>Construct URI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_SESSION___CONSTRUCT_URI = 1;

	/**
	 * The number of operations of the '<em>Rest Session</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_SESSION_OPERATION_COUNT = 2;


	/**
	 * The meta object id for the '{@link restSession.impl.PathFragmentImpl <em>Path Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see restSession.impl.PathFragmentImpl
	 * @see restSession.impl.RestSessionPackageImpl#getPathFragment()
	 * @generated
	 */
	int PATH_FRAGMENT = 1;

	/**
	 * The feature id for the '<em><b>Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_FRAGMENT__FRAGMENT = 0;

	/**
	 * The number of structural features of the '<em>Path Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_FRAGMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Path Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_FRAGMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link restSession.impl.EntityInfoImpl <em>Entity Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see restSession.impl.EntityInfoImpl
	 * @see restSession.impl.RestSessionPackageImpl#getEntityInfo()
	 * @generated
	 */
	int ENTITY_INFO = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_INFO__NAME = 0;

	/**
	 * The number of structural features of the '<em>Entity Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_INFO_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Entity Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_INFO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link restSession.HTTP_METHODS <em>HTTP METHODS</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see restSession.HTTP_METHODS
	 * @see restSession.impl.RestSessionPackageImpl#getHTTP_METHODS()
	 * @generated
	 */
	int HTTP_METHODS = 3;


	/**
	 * The meta object id for the '{@link restSession.MEDIA_TYPE <em>MEDIA TYPE</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see restSession.MEDIA_TYPE
	 * @see restSession.impl.RestSessionPackageImpl#getMEDIA_TYPE()
	 * @generated
	 */
	int MEDIA_TYPE = 4;


	/**
	 * Returns the meta object for class '{@link restSession.RestSession <em>Rest Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rest Session</em>'.
	 * @see restSession.RestSession
	 * @generated
	 */
	EClass getRestSession();

	/**
	 * Returns the meta object for the attribute '{@link restSession.RestSession#getUserid <em>Userid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Userid</em>'.
	 * @see restSession.RestSession#getUserid()
	 * @see #getRestSession()
	 * @generated
	 */
	EAttribute getRestSession_Userid();

	/**
	 * Returns the meta object for the attribute '{@link restSession.RestSession#getHttpMethod <em>Http Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Http Method</em>'.
	 * @see restSession.RestSession#getHttpMethod()
	 * @see #getRestSession()
	 * @generated
	 */
	EAttribute getRestSession_HttpMethod();

	/**
	 * Returns the meta object for the attribute '{@link restSession.RestSession#getBaseURI <em>Base URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base URI</em>'.
	 * @see restSession.RestSession#getBaseURI()
	 * @see #getRestSession()
	 * @generated
	 */
	EAttribute getRestSession_BaseURI();

	/**
	 * Returns the meta object for the attribute '{@link restSession.RestSession#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see restSession.RestSession#getPassword()
	 * @see #getRestSession()
	 * @generated
	 */
	EAttribute getRestSession_Password();

	/**
	 * Returns the meta object for the containment reference list '{@link restSession.RestSession#getPathFragments <em>Path Fragments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Path Fragments</em>'.
	 * @see restSession.RestSession#getPathFragments()
	 * @see #getRestSession()
	 * @generated
	 */
	EReference getRestSession_PathFragments();

	/**
	 * Returns the meta object for the attribute '{@link restSession.RestSession#getMedia <em>Media</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Media</em>'.
	 * @see restSession.RestSession#getMedia()
	 * @see #getRestSession()
	 * @generated
	 */
	EAttribute getRestSession_Media();

	/**
	 * Returns the meta object for the containment reference '{@link restSession.RestSession#getEntityInfo <em>Entity Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Entity Info</em>'.
	 * @see restSession.RestSession#getEntityInfo()
	 * @see #getRestSession()
	 * @generated
	 */
	EReference getRestSession_EntityInfo();

	/**
	 * Returns the meta object for the '{@link restSession.RestSession#compleet() <em>Compleet</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Compleet</em>' operation.
	 * @see restSession.RestSession#compleet()
	 * @generated
	 */
	EOperation getRestSession__Compleet();

	/**
	 * Returns the meta object for the '{@link restSession.RestSession#constructURI() <em>Construct URI</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Construct URI</em>' operation.
	 * @see restSession.RestSession#constructURI()
	 * @generated
	 */
	EOperation getRestSession__ConstructURI();

	/**
	 * Returns the meta object for class '{@link restSession.PathFragment <em>Path Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Fragment</em>'.
	 * @see restSession.PathFragment
	 * @generated
	 */
	EClass getPathFragment();

	/**
	 * Returns the meta object for the attribute '{@link restSession.PathFragment#getFragment <em>Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fragment</em>'.
	 * @see restSession.PathFragment#getFragment()
	 * @see #getPathFragment()
	 * @generated
	 */
	EAttribute getPathFragment_Fragment();

	/**
	 * Returns the meta object for class '{@link restSession.EntityInfo <em>Entity Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Info</em>'.
	 * @see restSession.EntityInfo
	 * @generated
	 */
	EClass getEntityInfo();

	/**
	 * Returns the meta object for the attribute '{@link restSession.EntityInfo#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see restSession.EntityInfo#getName()
	 * @see #getEntityInfo()
	 * @generated
	 */
	EAttribute getEntityInfo_Name();

	/**
	 * Returns the meta object for enum '{@link restSession.HTTP_METHODS <em>HTTP METHODS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>HTTP METHODS</em>'.
	 * @see restSession.HTTP_METHODS
	 * @generated
	 */
	EEnum getHTTP_METHODS();

	/**
	 * Returns the meta object for enum '{@link restSession.MEDIA_TYPE <em>MEDIA TYPE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>MEDIA TYPE</em>'.
	 * @see restSession.MEDIA_TYPE
	 * @generated
	 */
	EEnum getMEDIA_TYPE();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RestSessionFactory getRestSessionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link restSession.impl.RestSessionImpl <em>Rest Session</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see restSession.impl.RestSessionImpl
		 * @see restSession.impl.RestSessionPackageImpl#getRestSession()
		 * @generated
		 */
		EClass REST_SESSION = eINSTANCE.getRestSession();

		/**
		 * The meta object literal for the '<em><b>Userid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REST_SESSION__USERID = eINSTANCE.getRestSession_Userid();

		/**
		 * The meta object literal for the '<em><b>Http Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REST_SESSION__HTTP_METHOD = eINSTANCE.getRestSession_HttpMethod();

		/**
		 * The meta object literal for the '<em><b>Base URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REST_SESSION__BASE_URI = eINSTANCE.getRestSession_BaseURI();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REST_SESSION__PASSWORD = eINSTANCE.getRestSession_Password();

		/**
		 * The meta object literal for the '<em><b>Path Fragments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REST_SESSION__PATH_FRAGMENTS = eINSTANCE.getRestSession_PathFragments();

		/**
		 * The meta object literal for the '<em><b>Media</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REST_SESSION__MEDIA = eINSTANCE.getRestSession_Media();

		/**
		 * The meta object literal for the '<em><b>Entity Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REST_SESSION__ENTITY_INFO = eINSTANCE.getRestSession_EntityInfo();

		/**
		 * The meta object literal for the '<em><b>Compleet</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REST_SESSION___COMPLEET = eINSTANCE.getRestSession__Compleet();

		/**
		 * The meta object literal for the '<em><b>Construct URI</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REST_SESSION___CONSTRUCT_URI = eINSTANCE.getRestSession__ConstructURI();

		/**
		 * The meta object literal for the '{@link restSession.impl.PathFragmentImpl <em>Path Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see restSession.impl.PathFragmentImpl
		 * @see restSession.impl.RestSessionPackageImpl#getPathFragment()
		 * @generated
		 */
		EClass PATH_FRAGMENT = eINSTANCE.getPathFragment();

		/**
		 * The meta object literal for the '<em><b>Fragment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATH_FRAGMENT__FRAGMENT = eINSTANCE.getPathFragment_Fragment();

		/**
		 * The meta object literal for the '{@link restSession.impl.EntityInfoImpl <em>Entity Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see restSession.impl.EntityInfoImpl
		 * @see restSession.impl.RestSessionPackageImpl#getEntityInfo()
		 * @generated
		 */
		EClass ENTITY_INFO = eINSTANCE.getEntityInfo();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_INFO__NAME = eINSTANCE.getEntityInfo_Name();

		/**
		 * The meta object literal for the '{@link restSession.HTTP_METHODS <em>HTTP METHODS</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see restSession.HTTP_METHODS
		 * @see restSession.impl.RestSessionPackageImpl#getHTTP_METHODS()
		 * @generated
		 */
		EEnum HTTP_METHODS = eINSTANCE.getHTTP_METHODS();

		/**
		 * The meta object literal for the '{@link restSession.MEDIA_TYPE <em>MEDIA TYPE</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see restSession.MEDIA_TYPE
		 * @see restSession.impl.RestSessionPackageImpl#getMEDIA_TYPE()
		 * @generated
		 */
		EEnum MEDIA_TYPE = eINSTANCE.getMEDIA_TYPE();

	}

} //RestSessionPackage
