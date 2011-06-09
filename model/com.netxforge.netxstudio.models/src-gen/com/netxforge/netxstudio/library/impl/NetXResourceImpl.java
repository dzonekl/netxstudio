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
package com.netxforge.netxstudio.library.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.Unit;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricValueRange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Net XResource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getMetricRef <em>Metric Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getMetricValueRanges <em>Metric Value Ranges</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getCapacityValues <em>Capacity Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getUtilizationValues <em>Utilization Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getForecastCapacityValues <em>Forecast Capacity Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getForecastValues <em>Forecast Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getTrendedValues <em>Trended Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#isDetailDisplay <em>Detail Display</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getExpressionName <em>Expression Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getLongName <em>Long Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getShortName <em>Short Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#isSummaryDisplay <em>Summary Display</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.NetXResourceImpl#getUnitRef <em>Unit Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NetXResourceImpl extends CDOObjectImpl implements NetXResource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NetXResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.NET_XRESOURCE;
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
	public Metric getMetricRef() {
		return (Metric)eGet(LibraryPackage.Literals.NET_XRESOURCE__METRIC_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetricRef(Metric newMetricRef) {
		eSet(LibraryPackage.Literals.NET_XRESOURCE__METRIC_REF, newMetricRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<MetricValueRange> getMetricValueRanges() {
		return (EList<MetricValueRange>)eGet(LibraryPackage.Literals.NET_XRESOURCE__METRIC_VALUE_RANGES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Value> getCapacityValues() {
		return (EList<Value>)eGet(LibraryPackage.Literals.NET_XRESOURCE__CAPACITY_VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Value> getUtilizationValues() {
		return (EList<Value>)eGet(LibraryPackage.Literals.NET_XRESOURCE__UTILIZATION_VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Value> getForecastCapacityValues() {
		return (EList<Value>)eGet(LibraryPackage.Literals.NET_XRESOURCE__FORECAST_CAPACITY_VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Value> getForecastValues() {
		return (EList<Value>)eGet(LibraryPackage.Literals.NET_XRESOURCE__FORECAST_VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Value> getTrendedValues() {
		return (EList<Value>)eGet(LibraryPackage.Literals.NET_XRESOURCE__TRENDED_VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDetailDisplay() {
		return (Boolean)eGet(LibraryPackage.Literals.NET_XRESOURCE__DETAIL_DISPLAY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDetailDisplay(boolean newDetailDisplay) {
		eSet(LibraryPackage.Literals.NET_XRESOURCE__DETAIL_DISPLAY, newDetailDisplay);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDetailDisplay() {
		eUnset(LibraryPackage.Literals.NET_XRESOURCE__DETAIL_DISPLAY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDetailDisplay() {
		return eIsSet(LibraryPackage.Literals.NET_XRESOURCE__DETAIL_DISPLAY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpressionName() {
		return (String)eGet(LibraryPackage.Literals.NET_XRESOURCE__EXPRESSION_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionName(String newExpressionName) {
		eSet(LibraryPackage.Literals.NET_XRESOURCE__EXPRESSION_NAME, newExpressionName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongName() {
		return (String)eGet(LibraryPackage.Literals.NET_XRESOURCE__LONG_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongName(String newLongName) {
		eSet(LibraryPackage.Literals.NET_XRESOURCE__LONG_NAME, newLongName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShortName() {
		return (String)eGet(LibraryPackage.Literals.NET_XRESOURCE__SHORT_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShortName(String newShortName) {
		eSet(LibraryPackage.Literals.NET_XRESOURCE__SHORT_NAME, newShortName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSummaryDisplay() {
		return (Boolean)eGet(LibraryPackage.Literals.NET_XRESOURCE__SUMMARY_DISPLAY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSummaryDisplay(boolean newSummaryDisplay) {
		eSet(LibraryPackage.Literals.NET_XRESOURCE__SUMMARY_DISPLAY, newSummaryDisplay);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSummaryDisplay() {
		eUnset(LibraryPackage.Literals.NET_XRESOURCE__SUMMARY_DISPLAY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSummaryDisplay() {
		return eIsSet(LibraryPackage.Literals.NET_XRESOURCE__SUMMARY_DISPLAY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit getUnitRef() {
		return (Unit)eGet(LibraryPackage.Literals.NET_XRESOURCE__UNIT_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitRef(Unit newUnitRef) {
		eSet(LibraryPackage.Literals.NET_XRESOURCE__UNIT_REF, newUnitRef);
	}

} //NetXResourceImpl
