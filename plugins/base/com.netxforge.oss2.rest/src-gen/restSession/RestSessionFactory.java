/**
 */
package restSession;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see restSession.RestSessionPackage
 * @generated
 */
public interface RestSessionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RestSessionFactory eINSTANCE = restSession.impl.RestSessionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Rest Session</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rest Session</em>'.
	 * @generated
	 */
	RestSession createRestSession();

	/**
	 * Returns a new object of class '<em>Path Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Path Fragment</em>'.
	 * @generated
	 */
	PathFragment createPathFragment();

	/**
	 * Returns a new object of class '<em>Entity Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Info</em>'.
	 * @generated
	 */
	EntityInfo createEntityInfo();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RestSessionPackage getRestSessionPackage();

} //RestSessionFactory
