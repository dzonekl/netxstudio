/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package library;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link library.Link#getFirstLeg <em>First Leg</em>}</li>
 *   <li>{@link library.Link#getSecondLeg <em>Second Leg</em>}</li>
 *   <li>{@link library.Link#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see library.LibraryPackage#getLink()
 * @model
 * @generated
 */
public interface Link extends EObject {
	/**
	 * Returns the value of the '<em><b>First Leg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Leg</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Leg</em>' reference.
	 * @see #setFirstLeg(Node)
	 * @see library.LibraryPackage#getLink_FirstLeg()
	 * @model
	 * @generated
	 */
	Node getFirstLeg();

	/**
	 * Sets the value of the '{@link library.Link#getFirstLeg <em>First Leg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Leg</em>' reference.
	 * @see #getFirstLeg()
	 * @generated
	 */
	void setFirstLeg(Node value);

	/**
	 * Returns the value of the '<em><b>Second Leg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Leg</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Leg</em>' reference.
	 * @see #setSecondLeg(Node)
	 * @see library.LibraryPackage#getLink_SecondLeg()
	 * @model
	 * @generated
	 */
	Node getSecondLeg();

	/**
	 * Sets the value of the '{@link library.Link#getSecondLeg <em>Second Leg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Leg</em>' reference.
	 * @see #getSecondLeg()
	 * @generated
	 */
	void setSecondLeg(Node value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see library.LibraryPackage#getLink_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link library.Link#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Link
