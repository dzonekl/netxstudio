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
package com.netxforge.netxstudio.operators.impl;

import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.generics.impl.BaseImpl;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.MarkerKind;
import com.netxforge.netxstudio.operators.OperatorsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Marker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.MarkerImpl#getEquipmentRef <em>Equipment Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.MarkerImpl#getFunctionRef <em>Function Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.MarkerImpl#getMarkerResourceRef <em>Marker Resource Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.MarkerImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.MarkerImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MarkerImpl extends BaseImpl implements Marker {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MarkerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorsPackage.Literals.MARKER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equipment getEquipmentRef() {
		return (Equipment)eGet(OperatorsPackage.Literals.MARKER__EQUIPMENT_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquipmentRef(Equipment newEquipmentRef) {
		eSet(OperatorsPackage.Literals.MARKER__EQUIPMENT_REF, newEquipmentRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunctionRef() {
		return (Function)eGet(OperatorsPackage.Literals.MARKER__FUNCTION_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionRef(Function newFunctionRef) {
		eSet(OperatorsPackage.Literals.MARKER__FUNCTION_REF, newFunctionRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetXResource getMarkerResourceRef() {
		return (NetXResource)eGet(OperatorsPackage.Literals.MARKER__MARKER_RESOURCE_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMarkerResourceRef(NetXResource newMarkerResourceRef) {
		eSet(OperatorsPackage.Literals.MARKER__MARKER_RESOURCE_REF, newMarkerResourceRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(OperatorsPackage.Literals.MARKER__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(OperatorsPackage.Literals.MARKER__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkerKind getKind() {
		return (MarkerKind)eGet(OperatorsPackage.Literals.MARKER__KIND, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(MarkerKind newKind) {
		eSet(OperatorsPackage.Literals.MARKER__KIND, newKind);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetKind() {
		eUnset(OperatorsPackage.Literals.MARKER__KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetKind() {
		return eIsSet(OperatorsPackage.Literals.MARKER__KIND);
	}

} //MarkerImpl
