/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package library.impl;

import library.LibraryPackage;
import library.Link;
import library.Node;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link library.impl.LinkImpl#getFirstLeg <em>First Leg</em>}</li>
 *   <li>{@link library.impl.LinkImpl#getSecondLeg <em>Second Leg</em>}</li>
 *   <li>{@link library.impl.LinkImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkImpl extends EObjectImpl implements Link {
	/**
	 * The cached value of the '{@link #getFirstLeg() <em>First Leg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstLeg()
	 * @generated
	 * @ordered
	 */
	protected Node firstLeg;

	/**
	 * The cached value of the '{@link #getSecondLeg() <em>Second Leg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondLeg()
	 * @generated
	 * @ordered
	 */
	protected Node secondLeg;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getFirstLeg() {
		if (firstLeg != null && firstLeg.eIsProxy()) {
			InternalEObject oldFirstLeg = (InternalEObject)firstLeg;
			firstLeg = (Node)eResolveProxy(oldFirstLeg);
			if (firstLeg != oldFirstLeg) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryPackage.LINK__FIRST_LEG, oldFirstLeg, firstLeg));
			}
		}
		return firstLeg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetFirstLeg() {
		return firstLeg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstLeg(Node newFirstLeg) {
		Node oldFirstLeg = firstLeg;
		firstLeg = newFirstLeg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.LINK__FIRST_LEG, oldFirstLeg, firstLeg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getSecondLeg() {
		if (secondLeg != null && secondLeg.eIsProxy()) {
			InternalEObject oldSecondLeg = (InternalEObject)secondLeg;
			secondLeg = (Node)eResolveProxy(oldSecondLeg);
			if (secondLeg != oldSecondLeg) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryPackage.LINK__SECOND_LEG, oldSecondLeg, secondLeg));
			}
		}
		return secondLeg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetSecondLeg() {
		return secondLeg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondLeg(Node newSecondLeg) {
		Node oldSecondLeg = secondLeg;
		secondLeg = newSecondLeg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.LINK__SECOND_LEG, oldSecondLeg, secondLeg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.LINK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LibraryPackage.LINK__FIRST_LEG:
				if (resolve) return getFirstLeg();
				return basicGetFirstLeg();
			case LibraryPackage.LINK__SECOND_LEG:
				if (resolve) return getSecondLeg();
				return basicGetSecondLeg();
			case LibraryPackage.LINK__NAME:
				return getName();
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
			case LibraryPackage.LINK__FIRST_LEG:
				setFirstLeg((Node)newValue);
				return;
			case LibraryPackage.LINK__SECOND_LEG:
				setSecondLeg((Node)newValue);
				return;
			case LibraryPackage.LINK__NAME:
				setName((String)newValue);
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
			case LibraryPackage.LINK__FIRST_LEG:
				setFirstLeg((Node)null);
				return;
			case LibraryPackage.LINK__SECOND_LEG:
				setSecondLeg((Node)null);
				return;
			case LibraryPackage.LINK__NAME:
				setName(NAME_EDEFAULT);
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
			case LibraryPackage.LINK__FIRST_LEG:
				return firstLeg != null;
			case LibraryPackage.LINK__SECOND_LEG:
				return secondLeg != null;
			case LibraryPackage.LINK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //LinkImpl
