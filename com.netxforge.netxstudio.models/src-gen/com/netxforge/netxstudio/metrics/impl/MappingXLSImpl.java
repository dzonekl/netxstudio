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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.netxforge.netxstudio.metrics.DataKind;
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
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingXLSImpl#getColumnDataKind <em>Column Data Kind</em>}</li>
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
	 * The cached value of the '{@link #getMappingColumns() <em>Mapping Columns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingColumns()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingXLSColumn> mappingColumns;

	/**
	 * The cached value of the '{@link #getColumnDataKind() <em>Column Data Kind</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnDataKind()
	 * @generated
	 * @ordered
	 */
	protected EList<DataKind> columnDataKind;

	/**
	 * The default value of the '{@link #getFirstDataRow() <em>First Data Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstDataRow()
	 * @generated
	 * @ordered
	 */
	protected static final int FIRST_DATA_ROW_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFirstDataRow() <em>First Data Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstDataRow()
	 * @generated
	 * @ordered
	 */
	protected int firstDataRow = FIRST_DATA_ROW_EDEFAULT;

	/**
	 * This is true if the First Data Row attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean firstDataRowESet;

	/**
	 * The default value of the '{@link #getHeaderRow() <em>Header Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderRow()
	 * @generated
	 * @ordered
	 */
	protected static final int HEADER_ROW_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHeaderRow() <em>Header Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderRow()
	 * @generated
	 * @ordered
	 */
	protected int headerRow = HEADER_ROW_EDEFAULT;

	/**
	 * This is true if the Header Row attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean headerRowESet;

	/**
	 * The default value of the '{@link #getSheetNumber() <em>Sheet Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSheetNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int SHEET_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSheetNumber() <em>Sheet Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSheetNumber()
	 * @generated
	 * @ordered
	 */
	protected int sheetNumber = SHEET_NUMBER_EDEFAULT;

	/**
	 * This is true if the Sheet Number attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean sheetNumberESet;

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
	public EList<MappingXLSColumn> getMappingColumns() {
		if (mappingColumns == null) {
			mappingColumns = new EObjectContainmentEList<MappingXLSColumn>(MappingXLSColumn.class, this, MetricsPackage.MAPPING_XLS__MAPPING_COLUMNS);
		}
		return mappingColumns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataKind> getColumnDataKind() {
		if (columnDataKind == null) {
			columnDataKind = new EObjectContainmentEList<DataKind>(DataKind.class, this, MetricsPackage.MAPPING_XLS__COLUMN_DATA_KIND);
		}
		return columnDataKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFirstDataRow() {
		return firstDataRow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstDataRow(int newFirstDataRow) {
		int oldFirstDataRow = firstDataRow;
		firstDataRow = newFirstDataRow;
		boolean oldFirstDataRowESet = firstDataRowESet;
		firstDataRowESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_XLS__FIRST_DATA_ROW, oldFirstDataRow, firstDataRow, !oldFirstDataRowESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFirstDataRow() {
		int oldFirstDataRow = firstDataRow;
		boolean oldFirstDataRowESet = firstDataRowESet;
		firstDataRow = FIRST_DATA_ROW_EDEFAULT;
		firstDataRowESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.MAPPING_XLS__FIRST_DATA_ROW, oldFirstDataRow, FIRST_DATA_ROW_EDEFAULT, oldFirstDataRowESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFirstDataRow() {
		return firstDataRowESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHeaderRow() {
		return headerRow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderRow(int newHeaderRow) {
		int oldHeaderRow = headerRow;
		headerRow = newHeaderRow;
		boolean oldHeaderRowESet = headerRowESet;
		headerRowESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_XLS__HEADER_ROW, oldHeaderRow, headerRow, !oldHeaderRowESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHeaderRow() {
		int oldHeaderRow = headerRow;
		boolean oldHeaderRowESet = headerRowESet;
		headerRow = HEADER_ROW_EDEFAULT;
		headerRowESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.MAPPING_XLS__HEADER_ROW, oldHeaderRow, HEADER_ROW_EDEFAULT, oldHeaderRowESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHeaderRow() {
		return headerRowESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSheetNumber() {
		return sheetNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSheetNumber(int newSheetNumber) {
		int oldSheetNumber = sheetNumber;
		sheetNumber = newSheetNumber;
		boolean oldSheetNumberESet = sheetNumberESet;
		sheetNumberESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_XLS__SHEET_NUMBER, oldSheetNumber, sheetNumber, !oldSheetNumberESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSheetNumber() {
		int oldSheetNumber = sheetNumber;
		boolean oldSheetNumberESet = sheetNumberESet;
		sheetNumber = SHEET_NUMBER_EDEFAULT;
		sheetNumberESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.MAPPING_XLS__SHEET_NUMBER, oldSheetNumber, SHEET_NUMBER_EDEFAULT, oldSheetNumberESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSheetNumber() {
		return sheetNumberESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetricsPackage.MAPPING_XLS__MAPPING_COLUMNS:
				return ((InternalEList<?>)getMappingColumns()).basicRemove(otherEnd, msgs);
			case MetricsPackage.MAPPING_XLS__COLUMN_DATA_KIND:
				return ((InternalEList<?>)getColumnDataKind()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetricsPackage.MAPPING_XLS__MAPPING_COLUMNS:
				return getMappingColumns();
			case MetricsPackage.MAPPING_XLS__COLUMN_DATA_KIND:
				return getColumnDataKind();
			case MetricsPackage.MAPPING_XLS__FIRST_DATA_ROW:
				return getFirstDataRow();
			case MetricsPackage.MAPPING_XLS__HEADER_ROW:
				return getHeaderRow();
			case MetricsPackage.MAPPING_XLS__SHEET_NUMBER:
				return getSheetNumber();
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
			case MetricsPackage.MAPPING_XLS__MAPPING_COLUMNS:
				getMappingColumns().clear();
				getMappingColumns().addAll((Collection<? extends MappingXLSColumn>)newValue);
				return;
			case MetricsPackage.MAPPING_XLS__COLUMN_DATA_KIND:
				getColumnDataKind().clear();
				getColumnDataKind().addAll((Collection<? extends DataKind>)newValue);
				return;
			case MetricsPackage.MAPPING_XLS__FIRST_DATA_ROW:
				setFirstDataRow((Integer)newValue);
				return;
			case MetricsPackage.MAPPING_XLS__HEADER_ROW:
				setHeaderRow((Integer)newValue);
				return;
			case MetricsPackage.MAPPING_XLS__SHEET_NUMBER:
				setSheetNumber((Integer)newValue);
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
			case MetricsPackage.MAPPING_XLS__MAPPING_COLUMNS:
				getMappingColumns().clear();
				return;
			case MetricsPackage.MAPPING_XLS__COLUMN_DATA_KIND:
				getColumnDataKind().clear();
				return;
			case MetricsPackage.MAPPING_XLS__FIRST_DATA_ROW:
				unsetFirstDataRow();
				return;
			case MetricsPackage.MAPPING_XLS__HEADER_ROW:
				unsetHeaderRow();
				return;
			case MetricsPackage.MAPPING_XLS__SHEET_NUMBER:
				unsetSheetNumber();
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
			case MetricsPackage.MAPPING_XLS__MAPPING_COLUMNS:
				return mappingColumns != null && !mappingColumns.isEmpty();
			case MetricsPackage.MAPPING_XLS__COLUMN_DATA_KIND:
				return columnDataKind != null && !columnDataKind.isEmpty();
			case MetricsPackage.MAPPING_XLS__FIRST_DATA_ROW:
				return isSetFirstDataRow();
			case MetricsPackage.MAPPING_XLS__HEADER_ROW:
				return isSetHeaderRow();
			case MetricsPackage.MAPPING_XLS__SHEET_NUMBER:
				return isSetSheetNumber();
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
		result.append(" (firstDataRow: ");
		if (firstDataRowESet) result.append(firstDataRow); else result.append("<unset>");
		result.append(", headerRow: ");
		if (headerRowESet) result.append(headerRow); else result.append("<unset>");
		result.append(", sheetNumber: ");
		if (sheetNumberESet) result.append(sheetNumber); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //MappingXLSImpl
