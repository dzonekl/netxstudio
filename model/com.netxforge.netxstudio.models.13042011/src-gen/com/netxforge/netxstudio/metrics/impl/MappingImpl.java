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

import com.netxforge.netxstudio.metrics.Mapping;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.MetricsPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingImpl#getHeaderMappingColumns <em>Header Mapping Columns</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingImpl#getDataMappingColumns <em>Data Mapping Columns</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingImpl#getFirstDataRow <em>First Data Row</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingImpl#getHeaderRow <em>Header Row</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingImpl#getIntervalHint <em>Interval Hint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingImpl extends BaseImpl implements Mapping {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<MappingColumn> getHeaderMappingColumns() {
		return (EList<MappingColumn>)eGet(MetricsPackage.Literals.MAPPING__HEADER_MAPPING_COLUMNS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<MappingColumn> getDataMappingColumns() {
		return (EList<MappingColumn>)eGet(MetricsPackage.Literals.MAPPING__DATA_MAPPING_COLUMNS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFirstDataRow() {
		return (Integer)eGet(MetricsPackage.Literals.MAPPING__FIRST_DATA_ROW, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstDataRow(int newFirstDataRow) {
		eSet(MetricsPackage.Literals.MAPPING__FIRST_DATA_ROW, newFirstDataRow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFirstDataRow() {
		eUnset(MetricsPackage.Literals.MAPPING__FIRST_DATA_ROW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFirstDataRow() {
		return eIsSet(MetricsPackage.Literals.MAPPING__FIRST_DATA_ROW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHeaderRow() {
		return (Integer)eGet(MetricsPackage.Literals.MAPPING__HEADER_ROW, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderRow(int newHeaderRow) {
		eSet(MetricsPackage.Literals.MAPPING__HEADER_ROW, newHeaderRow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHeaderRow() {
		eUnset(MetricsPackage.Literals.MAPPING__HEADER_ROW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHeaderRow() {
		return eIsSet(MetricsPackage.Literals.MAPPING__HEADER_ROW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIntervalHint() {
		return (Integer)eGet(MetricsPackage.Literals.MAPPING__INTERVAL_HINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntervalHint(int newIntervalHint) {
		eSet(MetricsPackage.Literals.MAPPING__INTERVAL_HINT, newIntervalHint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIntervalHint() {
		eUnset(MetricsPackage.Literals.MAPPING__INTERVAL_HINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIntervalHint() {
		return eIsSet(MetricsPackage.Literals.MAPPING__INTERVAL_HINT);
	}

} //MappingImpl
