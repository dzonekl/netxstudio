/**
 */
package files.impl;

import files.FilesFactory;
import files.FilesPackage;
import files.FilesSession;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FilesPackageImpl extends EPackageImpl implements FilesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filesSessionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sessionsEEnum = null;

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
	 * @see files.FilesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FilesPackageImpl() {
		super(eNS_URI, FilesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FilesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FilesPackage init() {
		if (isInited) return (FilesPackage)EPackage.Registry.INSTANCE.getEPackage(FilesPackage.eNS_URI);

		// Obtain or create and register package
		FilesPackageImpl theFilesPackage = (FilesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FilesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FilesPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theFilesPackage.createPackageContents();

		// Initialize created meta-data
		theFilesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFilesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FilesPackage.eNS_URI, theFilesPackage);
		return theFilesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilesSession() {
		return filesSessionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilesSession_FolderURL() {
		return (EAttribute)filesSessionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilesSession_FilterPattern() {
		return (EAttribute)filesSessionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilesSession_FileExtension() {
		return (EAttribute)filesSessionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilesSession_Result() {
		return (EAttribute)filesSessionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilesSession_FileName() {
		return (EAttribute)filesSessionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFilesSession__CompleteFor__SESSIONS() {
		return filesSessionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSESSIONS() {
		return sessionsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilesFactory getFilesFactory() {
		return (FilesFactory)getEFactoryInstance();
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
		filesSessionEClass = createEClass(FILES_SESSION);
		createEAttribute(filesSessionEClass, FILES_SESSION__FOLDER_URL);
		createEAttribute(filesSessionEClass, FILES_SESSION__FILTER_PATTERN);
		createEAttribute(filesSessionEClass, FILES_SESSION__FILE_EXTENSION);
		createEAttribute(filesSessionEClass, FILES_SESSION__RESULT);
		createEAttribute(filesSessionEClass, FILES_SESSION__FILE_NAME);
		createEOperation(filesSessionEClass, FILES_SESSION___COMPLETE_FOR__SESSIONS);

		// Create enums
		sessionsEEnum = createEEnum(SESSIONS);
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
		initEClass(filesSessionEClass, FilesSession.class, "FilesSession", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFilesSession_FolderURL(), ecorePackage.getEString(), "folderURL", null, 0, 1, FilesSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilesSession_FilterPattern(), ecorePackage.getEString(), "filterPattern", null, 0, 1, FilesSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilesSession_FileExtension(), ecorePackage.getEString(), "fileExtension", null, 0, 1, FilesSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilesSession_Result(), ecorePackage.getEJavaObject(), "result", null, 0, 1, FilesSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilesSession_FileName(), ecorePackage.getEString(), "fileName", null, 0, 1, FilesSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getFilesSession__CompleteFor__SESSIONS(), ecorePackage.getEBoolean(), "completeFor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSESSIONS(), "sessions", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(sessionsEEnum, files.SESSIONS.class, "SESSIONS");
		addEEnumLiteral(sessionsEEnum, files.SESSIONS.LISTING);
		addEEnumLiteral(sessionsEEnum, files.SESSIONS.CREATE);

		// Create resource
		createResource(eNS_URI);
	}

} //FilesPackageImpl
