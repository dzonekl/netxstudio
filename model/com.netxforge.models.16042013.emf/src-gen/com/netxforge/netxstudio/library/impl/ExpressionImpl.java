/**
 * Copyright (c) 2014 NetXForge
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors:
 * Christophe Bouhier - initial API and implementation and/or initial documentation
 */
package com.netxforge.netxstudio.library.impl;

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionImpl#getExpressionLines <em>Expression Lines</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionImpl#getEvaluationObject <em>Evaluation Object</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ExpressionImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionImpl extends BaseImpl implements Expression {
	/**
	 * The cached value of the '{@link #getExpressionLines() <em>Expression Lines</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionLines()
	 * @generated
	 * @ordered
	 */
	protected EList<String> expressionLines;

	/**
	 * The cached value of the '{@link #getEvaluationObject() <em>Evaluation Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluationObject()
	 * @generated
	 * @ordered
	 */
	protected EObject evaluationObject;

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
	protected ExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getExpressionLines() {
		if (expressionLines == null) {
			expressionLines = new EDataTypeEList<String>(String.class, this, LibraryPackage.EXPRESSION__EXPRESSION_LINES);
		}
		return expressionLines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getEvaluationObject() {
		if (evaluationObject != null && evaluationObject.eIsProxy()) {
			InternalEObject oldEvaluationObject = (InternalEObject)evaluationObject;
			evaluationObject = eResolveProxy(oldEvaluationObject);
			if (evaluationObject != oldEvaluationObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryPackage.EXPRESSION__EVALUATION_OBJECT, oldEvaluationObject, evaluationObject));
			}
		}
		return evaluationObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetEvaluationObject() {
		return evaluationObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvaluationObject(EObject newEvaluationObject) {
		EObject oldEvaluationObject = evaluationObject;
		evaluationObject = newEvaluationObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EXPRESSION__EVALUATION_OBJECT, oldEvaluationObject, evaluationObject));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EXPRESSION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LibraryPackage.EXPRESSION__EXPRESSION_LINES:
				return getExpressionLines();
			case LibraryPackage.EXPRESSION__EVALUATION_OBJECT:
				if (resolve) return getEvaluationObject();
				return basicGetEvaluationObject();
			case LibraryPackage.EXPRESSION__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LibraryPackage.EXPRESSION__EXPRESSION_LINES:
				getExpressionLines().clear();
				getExpressionLines().addAll((Collection<? extends String>)newValue);
				return;
			case LibraryPackage.EXPRESSION__EVALUATION_OBJECT:
				setEvaluationObject((EObject)newValue);
				return;
			case LibraryPackage.EXPRESSION__NAME:
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
			case LibraryPackage.EXPRESSION__EXPRESSION_LINES:
				getExpressionLines().clear();
				return;
			case LibraryPackage.EXPRESSION__EVALUATION_OBJECT:
				setEvaluationObject((EObject)null);
				return;
			case LibraryPackage.EXPRESSION__NAME:
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
			case LibraryPackage.EXPRESSION__EXPRESSION_LINES:
				return expressionLines != null && !expressionLines.isEmpty();
			case LibraryPackage.EXPRESSION__EVALUATION_OBJECT:
				return evaluationObject != null;
			case LibraryPackage.EXPRESSION__NAME:
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
		result.append(" (expressionLines: ");
		result.append(expressionLines);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ExpressionImpl
