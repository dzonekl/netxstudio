/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package library.impl;

import java.util.Date;

import library.LibraryPackage;
import library.Period;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Period</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link library.impl.PeriodImpl#getApproxStart <em>Approx Start</em>}</li>
 *   <li>{@link library.impl.PeriodImpl#getApproxEnd <em>Approx End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PeriodImpl extends EObjectImpl implements Period {
	/**
	 * The default value of the '{@link #getApproxStart() <em>Approx Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApproxStart()
	 * @generated
	 * @ordered
	 */
	protected static final Date APPROX_START_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getApproxStart() <em>Approx Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApproxStart()
	 * @generated
	 * @ordered
	 */
	protected Date approxStart = APPROX_START_EDEFAULT;

	/**
	 * The default value of the '{@link #getApproxEnd() <em>Approx End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApproxEnd()
	 * @generated
	 * @ordered
	 */
	protected static final Date APPROX_END_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getApproxEnd() <em>Approx End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApproxEnd()
	 * @generated
	 * @ordered
	 */
	protected Date approxEnd = APPROX_END_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PeriodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.PERIOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getApproxStart() {
		return approxStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApproxStart(Date newApproxStart) {
		Date oldApproxStart = approxStart;
		approxStart = newApproxStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.PERIOD__APPROX_START, oldApproxStart, approxStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getApproxEnd() {
		return approxEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApproxEnd(Date newApproxEnd) {
		Date oldApproxEnd = approxEnd;
		approxEnd = newApproxEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.PERIOD__APPROX_END, oldApproxEnd, approxEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LibraryPackage.PERIOD__APPROX_START:
				return getApproxStart();
			case LibraryPackage.PERIOD__APPROX_END:
				return getApproxEnd();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LibraryPackage.PERIOD__APPROX_START:
				setApproxStart((Date)newValue);
				return;
			case LibraryPackage.PERIOD__APPROX_END:
				setApproxEnd((Date)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LibraryPackage.PERIOD__APPROX_START:
				setApproxStart(APPROX_START_EDEFAULT);
				return;
			case LibraryPackage.PERIOD__APPROX_END:
				setApproxEnd(APPROX_END_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LibraryPackage.PERIOD__APPROX_START:
				return APPROX_START_EDEFAULT == null ? approxStart != null : !APPROX_START_EDEFAULT.equals(approxStart);
			case LibraryPackage.PERIOD__APPROX_END:
				return APPROX_END_EDEFAULT == null ? approxEnd != null : !APPROX_END_EDEFAULT.equals(approxEnd);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (approxStart: ");
		result.append(approxStart);
		result.append(", approxEnd: ");
		result.append(approxEnd);
		result.append(')');
		return result.toString();
	}

} //PeriodImpl
