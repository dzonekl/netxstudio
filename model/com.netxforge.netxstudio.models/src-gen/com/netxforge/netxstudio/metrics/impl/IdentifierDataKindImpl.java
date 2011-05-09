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
package com.netxforge.netxstudio.metrics.impl;

import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ObjectNameType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifier Data Kind</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.IdentifierDataKindImpl#getObjectAttribute <em>Object Attribute</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.IdentifierDataKindImpl#getObjectName <em>Object Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IdentifierDataKindImpl extends DataKindImpl implements IdentifierDataKind {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifierDataKindImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.IDENTIFIER_DATA_KIND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObjectAttribute() {
		return (String)eGet(MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_ATTRIBUTE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectAttribute(String newObjectAttribute) {
		eSet(MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_ATTRIBUTE, newObjectAttribute);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectNameType getObjectName() {
		return (ObjectNameType)eGet(MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectName(ObjectNameType newObjectName) {
		eSet(MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_NAME, newObjectName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetObjectName() {
		eUnset(MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetObjectName() {
		return eIsSet(MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_NAME);
	}

} //IdentifierDataKindImpl
