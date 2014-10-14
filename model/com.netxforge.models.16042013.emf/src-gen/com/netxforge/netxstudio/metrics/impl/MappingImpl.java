/**
 * Copyright (c) 2014 NetXForge
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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

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
	 * The cached value of the '{@link #getHeaderMappingColumns() <em>Header Mapping Columns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderMappingColumns()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingColumn> headerMappingColumns;

	/**
	 * The cached value of the '{@link #getDataMappingColumns() <em>Data Mapping Columns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataMappingColumns()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingColumn> dataMappingColumns;

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
	 * The default value of the '{@link #getIntervalHint() <em>Interval Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntervalHint()
	 * @generated
	 * @ordered
	 */
	protected static final int INTERVAL_HINT_EDEFAULT = 60;

	/**
	 * The cached value of the '{@link #getIntervalHint() <em>Interval Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntervalHint()
	 * @generated
	 * @ordered
	 */
	protected int intervalHint = INTERVAL_HINT_EDEFAULT;

	/**
	 * This is true if the Interval Hint attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean intervalHintESet;

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
	public EList<MappingColumn> getHeaderMappingColumns() {
		if (headerMappingColumns == null) {
			headerMappingColumns = new EObjectContainmentEList<MappingColumn>(MappingColumn.class, this, MetricsPackage.MAPPING__HEADER_MAPPING_COLUMNS);
		}
		return headerMappingColumns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingColumn> getDataMappingColumns() {
		if (dataMappingColumns == null) {
			dataMappingColumns = new EObjectContainmentEList<MappingColumn>(MappingColumn.class, this, MetricsPackage.MAPPING__DATA_MAPPING_COLUMNS);
		}
		return dataMappingColumns;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING__FIRST_DATA_ROW, oldFirstDataRow, firstDataRow, !oldFirstDataRowESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.MAPPING__FIRST_DATA_ROW, oldFirstDataRow, FIRST_DATA_ROW_EDEFAULT, oldFirstDataRowESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING__HEADER_ROW, oldHeaderRow, headerRow, !oldHeaderRowESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.MAPPING__HEADER_ROW, oldHeaderRow, HEADER_ROW_EDEFAULT, oldHeaderRowESet));
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
	public int getIntervalHint() {
		return intervalHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntervalHint(int newIntervalHint) {
		int oldIntervalHint = intervalHint;
		intervalHint = newIntervalHint;
		boolean oldIntervalHintESet = intervalHintESet;
		intervalHintESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING__INTERVAL_HINT, oldIntervalHint, intervalHint, !oldIntervalHintESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIntervalHint() {
		int oldIntervalHint = intervalHint;
		boolean oldIntervalHintESet = intervalHintESet;
		intervalHint = INTERVAL_HINT_EDEFAULT;
		intervalHintESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.MAPPING__INTERVAL_HINT, oldIntervalHint, INTERVAL_HINT_EDEFAULT, oldIntervalHintESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIntervalHint() {
		return intervalHintESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetricsPackage.MAPPING__HEADER_MAPPING_COLUMNS:
				return ((InternalEList<?>)getHeaderMappingColumns()).basicRemove(otherEnd, msgs);
			case MetricsPackage.MAPPING__DATA_MAPPING_COLUMNS:
				return ((InternalEList<?>)getDataMappingColumns()).basicRemove(otherEnd, msgs);
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
			case MetricsPackage.MAPPING__HEADER_MAPPING_COLUMNS:
				return getHeaderMappingColumns();
			case MetricsPackage.MAPPING__DATA_MAPPING_COLUMNS:
				return getDataMappingColumns();
			case MetricsPackage.MAPPING__FIRST_DATA_ROW:
				return getFirstDataRow();
			case MetricsPackage.MAPPING__HEADER_ROW:
				return getHeaderRow();
			case MetricsPackage.MAPPING__INTERVAL_HINT:
				return getIntervalHint();
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
			case MetricsPackage.MAPPING__HEADER_MAPPING_COLUMNS:
				getHeaderMappingColumns().clear();
				getHeaderMappingColumns().addAll((Collection<? extends MappingColumn>)newValue);
				return;
			case MetricsPackage.MAPPING__DATA_MAPPING_COLUMNS:
				getDataMappingColumns().clear();
				getDataMappingColumns().addAll((Collection<? extends MappingColumn>)newValue);
				return;
			case MetricsPackage.MAPPING__FIRST_DATA_ROW:
				setFirstDataRow((Integer)newValue);
				return;
			case MetricsPackage.MAPPING__HEADER_ROW:
				setHeaderRow((Integer)newValue);
				return;
			case MetricsPackage.MAPPING__INTERVAL_HINT:
				setIntervalHint((Integer)newValue);
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
			case MetricsPackage.MAPPING__HEADER_MAPPING_COLUMNS:
				getHeaderMappingColumns().clear();
				return;
			case MetricsPackage.MAPPING__DATA_MAPPING_COLUMNS:
				getDataMappingColumns().clear();
				return;
			case MetricsPackage.MAPPING__FIRST_DATA_ROW:
				unsetFirstDataRow();
				return;
			case MetricsPackage.MAPPING__HEADER_ROW:
				unsetHeaderRow();
				return;
			case MetricsPackage.MAPPING__INTERVAL_HINT:
				unsetIntervalHint();
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
			case MetricsPackage.MAPPING__HEADER_MAPPING_COLUMNS:
				return headerMappingColumns != null && !headerMappingColumns.isEmpty();
			case MetricsPackage.MAPPING__DATA_MAPPING_COLUMNS:
				return dataMappingColumns != null && !dataMappingColumns.isEmpty();
			case MetricsPackage.MAPPING__FIRST_DATA_ROW:
				return isSetFirstDataRow();
			case MetricsPackage.MAPPING__HEADER_ROW:
				return isSetHeaderRow();
			case MetricsPackage.MAPPING__INTERVAL_HINT:
				return isSetIntervalHint();
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
		result.append(", intervalHint: ");
		if (intervalHintESet) result.append(intervalHint); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //MappingImpl
