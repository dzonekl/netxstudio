/**
 */
package restSession;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rest Session</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link restSession.RestSession#getUserid <em>Userid</em>}</li>
 *   <li>{@link restSession.RestSession#getHttpMethod <em>Http Method</em>}</li>
 *   <li>{@link restSession.RestSession#getBaseURI <em>Base URI</em>}</li>
 *   <li>{@link restSession.RestSession#getPassword <em>Password</em>}</li>
 *   <li>{@link restSession.RestSession#getPathFragments <em>Path Fragments</em>}</li>
 *   <li>{@link restSession.RestSession#getMedia <em>Media</em>}</li>
 *   <li>{@link restSession.RestSession#getEntityInfo <em>Entity Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see restSession.RestSessionPackage#getRestSession()
 * @model
 * @generated
 */
public interface RestSession extends EObject {
	/**
	 * Returns the value of the '<em><b>Userid</b></em>' attribute.
	 * The default value is <code>"admin"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Userid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Userid</em>' attribute.
	 * @see #setUserid(String)
	 * @see restSession.RestSessionPackage#getRestSession_Userid()
	 * @model default="admin"
	 * @generated
	 */
	String getUserid();

	/**
	 * Sets the value of the '{@link restSession.RestSession#getUserid <em>Userid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Userid</em>' attribute.
	 * @see #getUserid()
	 * @generated
	 */
	void setUserid(String value);

	/**
	 * Returns the value of the '<em><b>Http Method</b></em>' attribute.
	 * The literals are from the enumeration {@link restSession.HTTP_METHODS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Http Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Http Method</em>' attribute.
	 * @see restSession.HTTP_METHODS
	 * @see #setHttpMethod(HTTP_METHODS)
	 * @see restSession.RestSessionPackage#getRestSession_HttpMethod()
	 * @model
	 * @generated
	 */
	HTTP_METHODS getHttpMethod();

	/**
	 * Sets the value of the '{@link restSession.RestSession#getHttpMethod <em>Http Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Http Method</em>' attribute.
	 * @see restSession.HTTP_METHODS
	 * @see #getHttpMethod()
	 * @generated
	 */
	void setHttpMethod(HTTP_METHODS value);

	/**
	 * Returns the value of the '<em><b>Base URI</b></em>' attribute.
	 * The default value is <code>"http://localhost:8181"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base URI</em>' attribute.
	 * @see #setBaseURI(String)
	 * @see restSession.RestSessionPackage#getRestSession_BaseURI()
	 * @model default="http://localhost:8181"
	 * @generated
	 */
	String getBaseURI();

	/**
	 * Sets the value of the '{@link restSession.RestSession#getBaseURI <em>Base URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base URI</em>' attribute.
	 * @see #getBaseURI()
	 * @generated
	 */
	void setBaseURI(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see restSession.RestSessionPackage#getRestSession_Password()
	 * @model
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link restSession.RestSession#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Path Fragments</b></em>' containment reference list.
	 * The list contents are of type {@link restSession.PathFragment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Fragments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Fragments</em>' containment reference list.
	 * @see restSession.RestSessionPackage#getRestSession_PathFragments()
	 * @model containment="true"
	 * @generated
	 */
	EList<PathFragment> getPathFragments();

	/**
	 * Returns the value of the '<em><b>Media</b></em>' attribute.
	 * The literals are from the enumeration {@link restSession.MEDIA_TYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Media</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Media</em>' attribute.
	 * @see restSession.MEDIA_TYPE
	 * @see #setMedia(MEDIA_TYPE)
	 * @see restSession.RestSessionPackage#getRestSession_Media()
	 * @model
	 * @generated
	 */
	MEDIA_TYPE getMedia();

	/**
	 * Sets the value of the '{@link restSession.RestSession#getMedia <em>Media</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Media</em>' attribute.
	 * @see restSession.MEDIA_TYPE
	 * @see #getMedia()
	 * @generated
	 */
	void setMedia(MEDIA_TYPE value);

	/**
	 * Returns the value of the '<em><b>Entity Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entity Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity Info</em>' containment reference.
	 * @see #setEntityInfo(EntityInfo)
	 * @see restSession.RestSessionPackage#getRestSession_EntityInfo()
	 * @model containment="true"
	 * @generated
	 */
	EntityInfo getEntityInfo();

	/**
	 * Sets the value of the '{@link restSession.RestSession#getEntityInfo <em>Entity Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity Info</em>' containment reference.
	 * @see #getEntityInfo()
	 * @generated
	 */
	void setEntityInfo(EntityInfo value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean compleet();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String constructURI();

} // RestSession
