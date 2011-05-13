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
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingXLSColumnImpl#getColumnHeaderName <em>Column Header Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingXLSColumnImpl#getColumnHeaderRow <em>Column Header Row</em>}</li>
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
	public String getColumnHeaderName() {
		return (String)eGet(MetricsPackage.Literals.MAPPING_XLS_COLUMN__COLUMN_HEADER_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumnHeaderName(String newColumnHeaderName) {
		eSet(MetricsPackage.Literals.MAPPING_XLS_COLUMN__COLUMN_HEADER_NAME, newColumnHeaderName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColumnHeaderRow() {
		return (Integer)eGet(MetricsPackage.Literals.MAPPING_XLS_COLUMN__COLUMN_HEADER_ROW, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumnHeaderRow(int newColumnHeaderRow) {
		eSet(MetricsPackage.Literals.MAPPING_XLS_COLUMN__COLUMN_HEADER_ROW, newColumnHeaderRow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetColumnHeaderRow() {
		eUnset(MetricsPackage.Literals.MAPPING_XLS_COLUMN__COLUMN_HEADER_ROW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetColumnHeaderRow() {
		return eIsSet(MetricsPackage.Literals.MAPPING_XLS_COLUMN__COLUMN_HEADER_ROW);
	}

} //MappingXLSColumnImpl
