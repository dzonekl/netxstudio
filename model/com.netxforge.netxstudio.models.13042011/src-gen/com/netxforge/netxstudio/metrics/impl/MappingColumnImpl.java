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

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.metrics.DataKind;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.MetricsPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingColumnImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingColumnImpl#getColumn <em>Column</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingColumnImpl extends BaseImpl implements MappingColumn {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.MAPPING_COLUMN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataKind getDataType() {
		return (DataKind)eGet(MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataType(DataKind newDataType) {
		eSet(MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE, newDataType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColumn() {
		return (Integer)eGet(MetricsPackage.Literals.MAPPING_COLUMN__COLUMN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumn(int newColumn) {
		eSet(MetricsPackage.Literals.MAPPING_COLUMN__COLUMN, newColumn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetColumn() {
		eUnset(MetricsPackage.Literals.MAPPING_COLUMN__COLUMN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetColumn() {
		return eIsSet(MetricsPackage.Literals.MAPPING_COLUMN__COLUMN);
	}

} //MappingColumnImpl
