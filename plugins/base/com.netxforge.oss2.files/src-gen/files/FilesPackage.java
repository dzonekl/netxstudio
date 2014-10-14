/**
 */
package files;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

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
 * @see files.FilesFactory
 * @model kind="package"
 * @generated
 */
public interface FilesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "files";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.netxforge.com/files";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "files";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FilesPackage eINSTANCE = files.impl.FilesPackageImpl.init();

	/**
	 * The meta object id for the '{@link files.impl.FilesSessionImpl <em>Session</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see files.impl.FilesSessionImpl
	 * @see files.impl.FilesPackageImpl#getFilesSession()
	 * @generated
	 */
	int FILES_SESSION = 0;

	/**
	 * The feature id for the '<em><b>Folder URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILES_SESSION__FOLDER_URL = 0;

	/**
	 * The feature id for the '<em><b>Filter Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILES_SESSION__FILTER_PATTERN = 1;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILES_SESSION__FILE_EXTENSION = 2;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILES_SESSION__RESULT = 3;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILES_SESSION__FILE_NAME = 4;

	/**
	 * The number of structural features of the '<em>Session</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILES_SESSION_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Complete For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILES_SESSION___COMPLETE_FOR__SESSIONS = 0;

	/**
	 * The number of operations of the '<em>Session</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILES_SESSION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link files.SESSIONS <em>SESSIONS</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see files.SESSIONS
	 * @see files.impl.FilesPackageImpl#getSESSIONS()
	 * @generated
	 */
	int SESSIONS = 1;


	/**
	 * Returns the meta object for class '{@link files.FilesSession <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Session</em>'.
	 * @see files.FilesSession
	 * @generated
	 */
	EClass getFilesSession();

	/**
	 * Returns the meta object for the attribute '{@link files.FilesSession#getFolderURL <em>Folder URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Folder URL</em>'.
	 * @see files.FilesSession#getFolderURL()
	 * @see #getFilesSession()
	 * @generated
	 */
	EAttribute getFilesSession_FolderURL();

	/**
	 * Returns the meta object for the attribute '{@link files.FilesSession#getFilterPattern <em>Filter Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter Pattern</em>'.
	 * @see files.FilesSession#getFilterPattern()
	 * @see #getFilesSession()
	 * @generated
	 */
	EAttribute getFilesSession_FilterPattern();

	/**
	 * Returns the meta object for the attribute '{@link files.FilesSession#getFileExtension <em>File Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Extension</em>'.
	 * @see files.FilesSession#getFileExtension()
	 * @see #getFilesSession()
	 * @generated
	 */
	EAttribute getFilesSession_FileExtension();

	/**
	 * Returns the meta object for the attribute '{@link files.FilesSession#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see files.FilesSession#getResult()
	 * @see #getFilesSession()
	 * @generated
	 */
	EAttribute getFilesSession_Result();

	/**
	 * Returns the meta object for the attribute '{@link files.FilesSession#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see files.FilesSession#getFileName()
	 * @see #getFilesSession()
	 * @generated
	 */
	EAttribute getFilesSession_FileName();

	/**
	 * Returns the meta object for the '{@link files.FilesSession#completeFor(files.SESSIONS) <em>Complete For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Complete For</em>' operation.
	 * @see files.FilesSession#completeFor(files.SESSIONS)
	 * @generated
	 */
	EOperation getFilesSession__CompleteFor__SESSIONS();

	/**
	 * Returns the meta object for enum '{@link files.SESSIONS <em>SESSIONS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>SESSIONS</em>'.
	 * @see files.SESSIONS
	 * @generated
	 */
	EEnum getSESSIONS();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FilesFactory getFilesFactory();

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
		 * The meta object literal for the '{@link files.impl.FilesSessionImpl <em>Session</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see files.impl.FilesSessionImpl
		 * @see files.impl.FilesPackageImpl#getFilesSession()
		 * @generated
		 */
		EClass FILES_SESSION = eINSTANCE.getFilesSession();

		/**
		 * The meta object literal for the '<em><b>Folder URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILES_SESSION__FOLDER_URL = eINSTANCE.getFilesSession_FolderURL();

		/**
		 * The meta object literal for the '<em><b>Filter Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILES_SESSION__FILTER_PATTERN = eINSTANCE.getFilesSession_FilterPattern();

		/**
		 * The meta object literal for the '<em><b>File Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILES_SESSION__FILE_EXTENSION = eINSTANCE.getFilesSession_FileExtension();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILES_SESSION__RESULT = eINSTANCE.getFilesSession_Result();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILES_SESSION__FILE_NAME = eINSTANCE.getFilesSession_FileName();

		/**
		 * The meta object literal for the '<em><b>Complete For</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FILES_SESSION___COMPLETE_FOR__SESSIONS = eINSTANCE.getFilesSession__CompleteFor__SESSIONS();

		/**
		 * The meta object literal for the '{@link files.SESSIONS <em>SESSIONS</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see files.SESSIONS
		 * @see files.impl.FilesPackageImpl#getSESSIONS()
		 * @generated
		 */
		EEnum SESSIONS = eINSTANCE.getSESSIONS();

	}

} //FilesPackage
