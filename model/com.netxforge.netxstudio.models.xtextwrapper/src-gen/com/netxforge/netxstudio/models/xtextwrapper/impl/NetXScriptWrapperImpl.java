/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.netxforge.netxstudio.models.xtextwrapper.impl;

import com.netxforge.netxstudio.models.xtextwrapper.NetXScriptWrapper;
import com.netxforge.netxstudio.models.xtextwrapper.XtextwrapperPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.xtext.xbase.XBlockExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Net XScript Wrapper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.models.xtextwrapper.impl.NetXScriptWrapperImpl#getAsString <em>As String</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.models.xtextwrapper.impl.NetXScriptWrapperImpl#getXblock <em>Xblock</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NetXScriptWrapperImpl extends EObjectImpl implements NetXScriptWrapper {
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
	 * The cached value of the '{@link #getXblock() <em>Xblock</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXblock()
	 * @generated
	 * @ordered
	 */
	protected XBlockExpression xblock;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NetXScriptWrapperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XtextwrapperPackage.Literals.NET_XSCRIPT_WRAPPER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, XtextwrapperPackage.NET_XSCRIPT_WRAPPER__AS_STRING, oldAsString, asString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XBlockExpression getXblock() {
		return xblock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetXblock(XBlockExpression newXblock, NotificationChain msgs) {
		XBlockExpression oldXblock = xblock;
		xblock = newXblock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextwrapperPackage.NET_XSCRIPT_WRAPPER__XBLOCK, oldXblock, newXblock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXblock(XBlockExpression newXblock) {
		if (newXblock != xblock) {
			NotificationChain msgs = null;
			if (xblock != null)
				msgs = ((InternalEObject)xblock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextwrapperPackage.NET_XSCRIPT_WRAPPER__XBLOCK, null, msgs);
			if (newXblock != null)
				msgs = ((InternalEObject)newXblock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextwrapperPackage.NET_XSCRIPT_WRAPPER__XBLOCK, null, msgs);
			msgs = basicSetXblock(newXblock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextwrapperPackage.NET_XSCRIPT_WRAPPER__XBLOCK, newXblock, newXblock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XtextwrapperPackage.NET_XSCRIPT_WRAPPER__XBLOCK:
				return basicSetXblock(null, msgs);
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
			case XtextwrapperPackage.NET_XSCRIPT_WRAPPER__AS_STRING:
				return getAsString();
			case XtextwrapperPackage.NET_XSCRIPT_WRAPPER__XBLOCK:
				return getXblock();
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
			case XtextwrapperPackage.NET_XSCRIPT_WRAPPER__AS_STRING:
				setAsString((String)newValue);
				return;
			case XtextwrapperPackage.NET_XSCRIPT_WRAPPER__XBLOCK:
				setXblock((XBlockExpression)newValue);
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
			case XtextwrapperPackage.NET_XSCRIPT_WRAPPER__AS_STRING:
				setAsString(AS_STRING_EDEFAULT);
				return;
			case XtextwrapperPackage.NET_XSCRIPT_WRAPPER__XBLOCK:
				setXblock((XBlockExpression)null);
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
			case XtextwrapperPackage.NET_XSCRIPT_WRAPPER__AS_STRING:
				return AS_STRING_EDEFAULT == null ? asString != null : !AS_STRING_EDEFAULT.equals(asString);
			case XtextwrapperPackage.NET_XSCRIPT_WRAPPER__XBLOCK:
				return xblock != null;
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

} //NetXScriptWrapperImpl
