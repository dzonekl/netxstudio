/**
 */
package files.impl;

import files.FilesPackage;
import files.FilesSession;
import files.SESSIONS;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Session</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link files.impl.FilesSessionImpl#getFolderURL <em>Folder URL</em>}</li>
 * <li>{@link files.impl.FilesSessionImpl#getFilterPattern <em>Filter Pattern
 * </em>}</li>
 * <li>{@link files.impl.FilesSessionImpl#getFileExtension <em>File Extension
 * </em>}</li>
 * <li>{@link files.impl.FilesSessionImpl#getResult <em>Result</em>}</li>
 * <li>{@link files.impl.FilesSessionImpl#getFileName <em>File Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FilesSessionImpl extends MinimalEObjectImpl.Container implements
		FilesSession {
	/**
	 * The default value of the '{@link #getFolderURL() <em>Folder URL</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFolderURL()
	 * @generated
	 * @ordered
	 */
	protected static final String FOLDER_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFolderURL() <em>Folder URL</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFolderURL()
	 * @generated
	 * @ordered
	 */
	protected String folderURL = FOLDER_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getFilterPattern()
	 * <em>Filter Pattern</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFilterPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String FILTER_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFilterPattern()
	 * <em>Filter Pattern</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFilterPattern()
	 * @generated
	 * @ordered
	 */
	protected String filterPattern = FILTER_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getFileExtension()
	 * <em>File Extension</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFileExtension()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_EXTENSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileExtension()
	 * <em>File Extension</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFileExtension()
	 * @generated
	 * @ordered
	 */
	protected String fileExtension = FILE_EXTENSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getResult() <em>Result</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected static final Object RESULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected Object result = RESULT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFileName() <em>File Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileName() <em>File Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected String fileName = FILE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FilesSessionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FilesPackage.Literals.FILES_SESSION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getFolderURL() {
		return folderURL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFolderURL(String newFolderURL) {
		String oldFolderURL = folderURL;
		folderURL = newFolderURL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					FilesPackage.FILES_SESSION__FOLDER_URL, oldFolderURL,
					folderURL));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getFilterPattern() {
		return filterPattern;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFilterPattern(String newFilterPattern) {
		String oldFilterPattern = filterPattern;
		filterPattern = newFilterPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					FilesPackage.FILES_SESSION__FILTER_PATTERN,
					oldFilterPattern, filterPattern));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getFileExtension() {
		return fileExtension;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFileExtension(String newFileExtension) {
		String oldFileExtension = fileExtension;
		fileExtension = newFileExtension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					FilesPackage.FILES_SESSION__FILE_EXTENSION,
					oldFileExtension, fileExtension));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setResult(Object newResult) {
		Object oldResult = result;
		result = newResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					FilesPackage.FILES_SESSION__RESULT, oldResult, result));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFileName(String newFileName) {
		String oldFileName = fileName;
		fileName = newFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					FilesPackage.FILES_SESSION__FILE_NAME, oldFileName,
					fileName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean completeFor(SESSIONS sessions) {
		boolean result = false;

		switch (sessions) {
		case CREATE:
			break;
		case LISTING:
			result = eIsSet(FilesPackage.Literals.FILES_SESSION__FOLDER_URL);
			break;
		default:
			break;

		}

		return result;

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case FilesPackage.FILES_SESSION__FOLDER_URL:
			return getFolderURL();
		case FilesPackage.FILES_SESSION__FILTER_PATTERN:
			return getFilterPattern();
		case FilesPackage.FILES_SESSION__FILE_EXTENSION:
			return getFileExtension();
		case FilesPackage.FILES_SESSION__RESULT:
			return getResult();
		case FilesPackage.FILES_SESSION__FILE_NAME:
			return getFileName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case FilesPackage.FILES_SESSION__FOLDER_URL:
			setFolderURL((String) newValue);
			return;
		case FilesPackage.FILES_SESSION__FILTER_PATTERN:
			setFilterPattern((String) newValue);
			return;
		case FilesPackage.FILES_SESSION__FILE_EXTENSION:
			setFileExtension((String) newValue);
			return;
		case FilesPackage.FILES_SESSION__RESULT:
			setResult(newValue);
			return;
		case FilesPackage.FILES_SESSION__FILE_NAME:
			setFileName((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case FilesPackage.FILES_SESSION__FOLDER_URL:
			setFolderURL(FOLDER_URL_EDEFAULT);
			return;
		case FilesPackage.FILES_SESSION__FILTER_PATTERN:
			setFilterPattern(FILTER_PATTERN_EDEFAULT);
			return;
		case FilesPackage.FILES_SESSION__FILE_EXTENSION:
			setFileExtension(FILE_EXTENSION_EDEFAULT);
			return;
		case FilesPackage.FILES_SESSION__RESULT:
			setResult(RESULT_EDEFAULT);
			return;
		case FilesPackage.FILES_SESSION__FILE_NAME:
			setFileName(FILE_NAME_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case FilesPackage.FILES_SESSION__FOLDER_URL:
			return FOLDER_URL_EDEFAULT == null ? folderURL != null
					: !FOLDER_URL_EDEFAULT.equals(folderURL);
		case FilesPackage.FILES_SESSION__FILTER_PATTERN:
			return FILTER_PATTERN_EDEFAULT == null ? filterPattern != null
					: !FILTER_PATTERN_EDEFAULT.equals(filterPattern);
		case FilesPackage.FILES_SESSION__FILE_EXTENSION:
			return FILE_EXTENSION_EDEFAULT == null ? fileExtension != null
					: !FILE_EXTENSION_EDEFAULT.equals(fileExtension);
		case FilesPackage.FILES_SESSION__RESULT:
			return RESULT_EDEFAULT == null ? result != null : !RESULT_EDEFAULT
					.equals(result);
		case FilesPackage.FILES_SESSION__FILE_NAME:
			return FILE_NAME_EDEFAULT == null ? fileName != null
					: !FILE_NAME_EDEFAULT.equals(fileName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID) {
		case FilesPackage.FILES_SESSION___COMPLETE_FOR__SESSIONS:
			return completeFor((SESSIONS) arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (folderURL: ");
		result.append(folderURL);
		result.append(", filterPattern: ");
		result.append(filterPattern);
		result.append(", fileExtension: ");
		result.append(fileExtension);
		result.append(", result: ");
		result.append(result);
		result.append(", fileName: ");
		result.append(fileName);
		result.append(')');
		return result.toString();
	}

} // FilesSessionImpl
