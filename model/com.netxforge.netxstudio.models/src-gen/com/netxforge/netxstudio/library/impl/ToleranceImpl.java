/**
 * Copyright (c) 2011 NetXForge
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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import com.netxforge.netxstudio.library.LevelType;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.Tolerance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tolerance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ToleranceImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ToleranceImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ToleranceImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ToleranceImpl extends CDOObjectImpl implements Tolerance {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToleranceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.TOLERANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpression() {
		return (String)eGet(LibraryPackage.Literals.TOLERANCE__EXPRESSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(String newExpression) {
		eSet(LibraryPackage.Literals.TOLERANCE__EXPRESSION, newExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LevelType getLevel() {
		return (LevelType)eGet(LibraryPackage.Literals.TOLERANCE__LEVEL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevel(LevelType newLevel) {
		eSet(LibraryPackage.Literals.TOLERANCE__LEVEL, newLevel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLevel() {
		eUnset(LibraryPackage.Literals.TOLERANCE__LEVEL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLevel() {
		return eIsSet(LibraryPackage.Literals.TOLERANCE__LEVEL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(LibraryPackage.Literals.TOLERANCE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(LibraryPackage.Literals.TOLERANCE__NAME, newName);
	}

} //ToleranceImpl
