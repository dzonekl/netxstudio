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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.metrics.MappingXLS;
import com.netxforge.netxstudio.metrics.MappingXLSColumn;
import com.netxforge.netxstudio.metrics.MetricsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping XLS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingXLSImpl#getMappingColumns <em>Mapping Columns</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingXLSImpl#getFirstDataRow <em>First Data Row</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingXLSImpl#getHeaderRow <em>Header Row</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingXLSImpl#getSheetNumber <em>Sheet Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingXLSImpl extends MappingImpl implements MappingXLS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingXLSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.MAPPING_XLS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<MappingXLSColumn> getMappingColumns() {
		return (EList<MappingXLSColumn>)eGet(MetricsPackage.Literals.MAPPING_XLS__MAPPING_COLUMNS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFirstDataRow() {
		return (Integer)eGet(MetricsPackage.Literals.MAPPING_XLS__FIRST_DATA_ROW, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstDataRow(int newFirstDataRow) {
		eSet(MetricsPackage.Literals.MAPPING_XLS__FIRST_DATA_ROW, newFirstDataRow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFirstDataRow() {
		eUnset(MetricsPackage.Literals.MAPPING_XLS__FIRST_DATA_ROW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFirstDataRow() {
		return eIsSet(MetricsPackage.Literals.MAPPING_XLS__FIRST_DATA_ROW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHeaderRow() {
		return (Integer)eGet(MetricsPackage.Literals.MAPPING_XLS__HEADER_ROW, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderRow(int newHeaderRow) {
		eSet(MetricsPackage.Literals.MAPPING_XLS__HEADER_ROW, newHeaderRow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHeaderRow() {
		eUnset(MetricsPackage.Literals.MAPPING_XLS__HEADER_ROW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHeaderRow() {
		return eIsSet(MetricsPackage.Literals.MAPPING_XLS__HEADER_ROW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSheetNumber() {
		return (Integer)eGet(MetricsPackage.Literals.MAPPING_XLS__SHEET_NUMBER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSheetNumber(int newSheetNumber) {
		eSet(MetricsPackage.Literals.MAPPING_XLS__SHEET_NUMBER, newSheetNumber);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSheetNumber() {
		eUnset(MetricsPackage.Literals.MAPPING_XLS__SHEET_NUMBER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSheetNumber() {
		return eIsSet(MetricsPackage.Literals.MAPPING_XLS__SHEET_NUMBER);
	}

} //MappingXLSImpl
