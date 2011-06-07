/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package library;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Period</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link library.Period#getApproxStart <em>Approx Start</em>}</li>
 *   <li>{@link library.Period#getApproxEnd <em>Approx End</em>}</li>
 * </ul>
 * </p>
 *
 * @see library.LibraryPackage#getPeriod()
 * @model
 * @generated
 */
public interface Period extends EObject {
	/**
	 * Returns the value of the '<em><b>Approx Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Approx Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Approx Start</em>' attribute.
	 * @see #setApproxStart(Date)
	 * @see library.LibraryPackage#getPeriod_ApproxStart()
	 * @model
	 * @generated
	 */
	Date getApproxStart();

	/**
	 * Sets the value of the '{@link library.Period#getApproxStart <em>Approx Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Approx Start</em>' attribute.
	 * @see #getApproxStart()
	 * @generated
	 */
	void setApproxStart(Date value);

	/**
	 * Returns the value of the '<em><b>Approx End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Approx End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Approx End</em>' attribute.
	 * @see #setApproxEnd(Date)
	 * @see library.LibraryPackage#getPeriod_ApproxEnd()
	 * @model
	 * @generated
	 */
	Date getApproxEnd();

	/**
	 * Sets the value of the '{@link library.Period#getApproxEnd <em>Approx End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Approx End</em>' attribute.
	 * @see #getApproxEnd()
	 * @generated
	 */
	void setApproxEnd(Date value);

} // Period
