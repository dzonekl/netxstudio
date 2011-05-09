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
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import com.netxforge.netxstudio.metrics.DataKind;
import com.netxforge.netxstudio.metrics.MappingXLSColumn;
import com.netxforge.netxstudio.metrics.MetricsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping XLS Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingXLSColumnImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingXLSColumnImpl#getColumnName <em>Column Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingXLSColumnImpl#getColumnRow <em>Column Row</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingXLSColumnImpl extends CDOObjectImpl implements MappingXLSColumn {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingXLSColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.MAPPING_XLS_COLUMN;
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
	public DataKind getDataType() {
		return (DataKind)eGet(MetricsPackage.Literals.MAPPING_XLS_COLUMN__DATA_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataType(DataKind newDataType) {
		eSet(MetricsPackage.Literals.MAPPING_XLS_COLUMN__DATA_TYPE, newDataType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getColumnName() {
		return (String)eGet(MetricsPackage.Literals.MAPPING_XLS_COLUMN__COLUMN_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumnName(String newColumnName) {
		eSet(MetricsPackage.Literals.MAPPING_XLS_COLUMN__COLUMN_NAME, newColumnName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColumnRow() {
		return (Integer)eGet(MetricsPackage.Literals.MAPPING_XLS_COLUMN__COLUMN_ROW, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumnRow(int newColumnRow) {
		eSet(MetricsPackage.Literals.MAPPING_XLS_COLUMN__COLUMN_ROW, newColumnRow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetColumnRow() {
		eUnset(MetricsPackage.Literals.MAPPING_XLS_COLUMN__COLUMN_ROW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetColumnRow() {
		return eIsSet(MetricsPackage.Literals.MAPPING_XLS_COLUMN__COLUMN_ROW);
	}

} //MappingXLSColumnImpl
