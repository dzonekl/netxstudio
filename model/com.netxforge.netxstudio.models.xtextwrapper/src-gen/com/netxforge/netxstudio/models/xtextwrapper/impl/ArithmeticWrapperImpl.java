/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.netxforge.netxstudio.models.xtextwrapper.impl;

import com.netxforge.netxstudio.models.xtextwrapper.ArithmeticWrapper;
import com.netxforge.netxstudio.models.xtextwrapper.XtextwrapperPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.xtext.example.arithmetics.arithmetics.Evaluation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Arithmetic Wrapper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.models.xtextwrapper.impl.ArithmeticWrapperImpl#getAsString <em>As String</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.models.xtextwrapper.impl.ArithmeticWrapperImpl#getEval <em>Eval</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArithmeticWrapperImpl extends EObjectImpl implements ArithmeticWrapper {
	/**
	 * The default value of the '{@link #getAsString() <em>As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsString()
	 * @generated
	 * @ordered
	 */
	protected static final String AS_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAsString() <em>As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsString()
	 * @generated
	 * @ordered
	 */
	protected String asString = AS_STRING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEval() <em>Eval</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEval()
	 * @generated
	 * @ordered
	 */
	protected Evaluation eval;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArithmeticWrapperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XtextwrapperPackage.Literals.ARITHMETIC_WRAPPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAsString() {
		return asString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsString(String newAsString) {
		String oldAsString = asString;
		asString = newAsString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextwrapperPackage.ARITHMETIC_WRAPPER__AS_STRING, oldAsString, asString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Evaluation getEval() {
		return eval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEval(Evaluation newEval, NotificationChain msgs) {
		Evaluation oldEval = eval;
		eval = newEval;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextwrapperPackage.ARITHMETIC_WRAPPER__EVAL, oldEval, newEval);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEval(Evaluation newEval) {
		if (newEval != eval) {
			NotificationChain msgs = null;
			if (eval != null)
				msgs = ((InternalEObject)eval).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextwrapperPackage.ARITHMETIC_WRAPPER__EVAL, null, msgs);
			if (newEval != null)
				msgs = ((InternalEObject)newEval).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextwrapperPackage.ARITHMETIC_WRAPPER__EVAL, null, msgs);
			msgs = basicSetEval(newEval, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextwrapperPackage.ARITHMETIC_WRAPPER__EVAL, newEval, newEval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XtextwrapperPackage.ARITHMETIC_WRAPPER__EVAL:
				return basicSetEval(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XtextwrapperPackage.ARITHMETIC_WRAPPER__AS_STRING:
				return getAsString();
			case XtextwrapperPackage.ARITHMETIC_WRAPPER__EVAL:
				return getEval();
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
			case XtextwrapperPackage.ARITHMETIC_WRAPPER__AS_STRING:
				setAsString((String)newValue);
				return;
			case XtextwrapperPackage.ARITHMETIC_WRAPPER__EVAL:
				setEval((Evaluation)newValue);
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
			case XtextwrapperPackage.ARITHMETIC_WRAPPER__AS_STRING:
				setAsString(AS_STRING_EDEFAULT);
				return;
			case XtextwrapperPackage.ARITHMETIC_WRAPPER__EVAL:
				setEval((Evaluation)null);
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
			case XtextwrapperPackage.ARITHMETIC_WRAPPER__AS_STRING:
				return AS_STRING_EDEFAULT == null ? asString != null : !AS_STRING_EDEFAULT.equals(asString);
			case XtextwrapperPackage.ARITHMETIC_WRAPPER__EVAL:
				return eval != null;
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
		result.append(" (asString: ");
		result.append(asString);
		result.append(')');
		return result.toString();
	}

} //ArithmeticWrapperImpl
