/**
 */
package files;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Session</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link files.FilesSession#getFolderURL <em>Folder URL</em>}</li>
 *   <li>{@link files.FilesSession#getFilterPattern <em>Filter Pattern</em>}</li>
 *   <li>{@link files.FilesSession#getFileExtension <em>File Extension</em>}</li>
 *   <li>{@link files.FilesSession#getResult <em>Result</em>}</li>
 *   <li>{@link files.FilesSession#getFileName <em>File Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see files.FilesPackage#getFilesSession()
 * @model
 * @generated
 */
public interface FilesSession extends EObject {
	/**
	 * Returns the value of the '<em><b>Folder URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Folder URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Folder URL</em>' attribute.
	 * @see #setFolderURL(String)
	 * @see files.FilesPackage#getFilesSession_FolderURL()
	 * @model
	 * @generated
	 */
	String getFolderURL();

	/**
	 * Sets the value of the '{@link files.FilesSession#getFolderURL <em>Folder URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Folder URL</em>' attribute.
	 * @see #getFolderURL()
	 * @generated
	 */
	void setFolderURL(String value);

	/**
	 * Returns the value of the '<em><b>Filter Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter Pattern</em>' attribute.
	 * @see #setFilterPattern(String)
	 * @see files.FilesPackage#getFilesSession_FilterPattern()
	 * @model
	 * @generated
	 */
	String getFilterPattern();

	/**
	 * Sets the value of the '{@link files.FilesSession#getFilterPattern <em>Filter Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter Pattern</em>' attribute.
	 * @see #getFilterPattern()
	 * @generated
	 */
	void setFilterPattern(String value);

	/**
	 * Returns the value of the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Extension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Extension</em>' attribute.
	 * @see #setFileExtension(String)
	 * @see files.FilesPackage#getFilesSession_FileExtension()
	 * @model
	 * @generated
	 */
	String getFileExtension();

	/**
	 * Sets the value of the '{@link files.FilesSession#getFileExtension <em>File Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Extension</em>' attribute.
	 * @see #getFileExtension()
	 * @generated
	 */
	void setFileExtension(String value);

	/**
	 * Returns the value of the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' attribute.
	 * @see #setResult(Object)
	 * @see files.FilesPackage#getFilesSession_Result()
	 * @model
	 * @generated
	 */
	Object getResult();

	/**
	 * Sets the value of the '{@link files.FilesSession#getResult <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' attribute.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(Object value);

	/**
	 * Returns the value of the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Name</em>' attribute.
	 * @see #setFileName(String)
	 * @see files.FilesPackage#getFilesSession_FileName()
	 * @model
	 * @generated
	 */
	String getFileName();

	/**
	 * Sets the value of the '{@link files.FilesSession#getFileName <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Name</em>' attribute.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean completeFor(SESSIONS sessions);

} // FilesSession
