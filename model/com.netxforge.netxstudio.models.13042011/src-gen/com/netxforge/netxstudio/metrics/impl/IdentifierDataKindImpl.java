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

import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ObjectKindType;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifier Data Kind</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.IdentifierDataKindImpl#getObjectKind <em>Object Kind</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.IdentifierDataKindImpl#getObjectProperty <em>Object Property</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.IdentifierDataKindImpl#getPattern <em>Pattern</em>}</li>
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
	public ObjectKindType getObjectKind() {
		return (ObjectKindType)eGet(MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_KIND, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectKind(ObjectKindType newObjectKind) {
		eSet(MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_KIND, newObjectKind);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetObjectKind() {
		eUnset(MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetObjectKind() {
		return eIsSet(MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObjectProperty() {
		return (String)eGet(MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_PROPERTY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectProperty(String newObjectProperty) {
		eSet(MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_PROPERTY, newObjectProperty);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPattern() {
		return (String)eGet(MetricsPackage.Literals.IDENTIFIER_DATA_KIND__PATTERN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(String newPattern) {
		eSet(MetricsPackage.Literals.IDENTIFIER_DATA_KIND__PATTERN, newPattern);
	}

} //IdentifierDataKindImpl
