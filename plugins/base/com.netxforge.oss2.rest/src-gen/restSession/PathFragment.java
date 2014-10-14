/**
 */
package restSession;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link restSession.PathFragment#getFragment <em>Fragment</em>}</li>
 * </ul>
 * </p>
 *
 * @see restSession.RestSessionPackage#getPathFragment()
 * @model
 * @generated
 */
public interface PathFragment extends EObject {
	/**
	 * Returns the value of the '<em><b>Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragment</em>' attribute.
	 * @see #setFragment(String)
	 * @see restSession.RestSessionPackage#getPathFragment_Fragment()
	 * @model
	 * @generated
	 */
	String getFragment();

	/**
	 * Sets the value of the '{@link restSession.PathFragment#getFragment <em>Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fragment</em>' attribute.
	 * @see #getFragment()
	 * @generated
	 */
	void setFragment(String value);

} // PathFragment
