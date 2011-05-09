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

import com.netxforge.netxstudio.metrics.MappingRecordXLS;
import com.netxforge.netxstudio.metrics.MetricsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Record XLS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingRecordXLSImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingRecordXLSImpl#getRow <em>Row</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingRecordXLSImpl extends MappingRecordImpl implements MappingRecordXLS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingRecordXLSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.MAPPING_RECORD_XLS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColumn() {
		return (Integer)eGet(MetricsPackage.Literals.MAPPING_RECORD_XLS__COLUMN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumn(int newColumn) {
		eSet(MetricsPackage.Literals.MAPPING_RECORD_XLS__COLUMN, newColumn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetColumn() {
		eUnset(MetricsPackage.Literals.MAPPING_RECORD_XLS__COLUMN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetColumn() {
		return eIsSet(MetricsPackage.Literals.MAPPING_RECORD_XLS__COLUMN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRow() {
		return (Integer)eGet(MetricsPackage.Literals.MAPPING_RECORD_XLS__ROW, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRow(int newRow) {
		eSet(MetricsPackage.Literals.MAPPING_RECORD_XLS__ROW, newRow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRow() {
		eUnset(MetricsPackage.Literals.MAPPING_RECORD_XLS__ROW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRow() {
		return eIsSet(MetricsPackage.Literals.MAPPING_RECORD_XLS__ROW);
	}

} //MappingRecordXLSImpl
