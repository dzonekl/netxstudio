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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.generics.impl.BaseImpl;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.ResourceMonitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Monitor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.ResourceMonitorImpl#getMarkers <em>Markers</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.ResourceMonitorImpl#getNodeRef <em>Node Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.operators.impl.ResourceMonitorImpl#getResourceRef <em>Resource Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceMonitorImpl extends BaseImpl implements ResourceMonitor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceMonitorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorsPackage.Literals.RESOURCE_MONITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Marker> getMarkers() {
		return (EList<Marker>)eGet(OperatorsPackage.Literals.RESOURCE_MONITOR__MARKERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getNodeRef() {
		return (Node)eGet(OperatorsPackage.Literals.RESOURCE_MONITOR__NODE_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeRef(Node newNodeRef) {
		eSet(OperatorsPackage.Literals.RESOURCE_MONITOR__NODE_REF, newNodeRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetXResource getResourceRef() {
		return (NetXResource)eGet(OperatorsPackage.Literals.RESOURCE_MONITOR__RESOURCE_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceRef(NetXResource newResourceRef) {
		eSet(OperatorsPackage.Literals.RESOURCE_MONITOR__RESOURCE_REF, newResourceRef);
	}

} //ResourceMonitorImpl
