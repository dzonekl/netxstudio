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

import com.netxforge.netxstudio.generics.Meta;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.Parameter;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.library.Unit;
import com.netxforge.netxstudio.metrics.Metric;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getNodeTypes <em>Node Types</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getEquipments <em>Equipments</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getTolerances <em>Tolerances</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getUnits <em>Units</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.LibraryImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibraryImpl extends CDOObjectImpl implements Library {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.LIBRARY;
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
	@SuppressWarnings("unchecked")
	public EList<Function> getFunctions() {
		return (EList<Function>)eGet(LibraryPackage.Literals.LIBRARY__FUNCTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NodeType> getNodeTypes() {
		return (EList<NodeType>)eGet(LibraryPackage.Literals.LIBRARY__NODE_TYPES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Equipment> getEquipments() {
		return (EList<Equipment>)eGet(LibraryPackage.Literals.LIBRARY__EQUIPMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Metric> getMetrics() {
		return (EList<Metric>)eGet(LibraryPackage.Literals.LIBRARY__METRICS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Parameter> getParameters() {
		return (EList<Parameter>)eGet(LibraryPackage.Literals.LIBRARY__PARAMETERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getProtocols() {
		return (EList<String>)eGet(LibraryPackage.Literals.LIBRARY__PROTOCOLS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Tolerance> getTolerances() {
		return (EList<Tolerance>)eGet(LibraryPackage.Literals.LIBRARY__TOLERANCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Expression> getExpressions() {
		return (EList<Expression>)eGet(LibraryPackage.Literals.LIBRARY__EXPRESSIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Unit> getUnits() {
		return (EList<Unit>)eGet(LibraryPackage.Literals.LIBRARY__UNITS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Meta getVersion() {
		return (Meta)eGet(LibraryPackage.Literals.LIBRARY__VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(Meta newVersion) {
		eSet(LibraryPackage.Literals.LIBRARY__VERSION, newVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(LibraryPackage.Literals.LIBRARY__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(LibraryPackage.Literals.LIBRARY__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetName() {
		eUnset(LibraryPackage.Literals.LIBRARY__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName() {
		return eIsSet(LibraryPackage.Literals.LIBRARY__NAME);
	}

} //LibraryImpl
