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

import com.netxforge.netxstudio.generics.DiagramInfo;
import com.netxforge.netxstudio.generics.MultiImage;
import com.netxforge.netxstudio.generics.impl.BaseImpl;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.Parameter;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.protocols.Protocol;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getResourceRefs <em>Resource Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getMetricRefs <em>Metric Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getCapacityExpressionRef <em>Capacity Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getUtilizationExpressionRef <em>Utilization Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getToleranceRefs <em>Tolerance Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getProtocolRefs <em>Protocol Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getParameterRefs <em>Parameter Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getAllResources <em>All Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ComponentImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentImpl extends BaseImpl implements Component {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NetXResource> getResourceRefs() {
		return (EList<NetXResource>)eGet(LibraryPackage.Literals.COMPONENT__RESOURCE_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Metric> getMetricRefs() {
		return (EList<Metric>)eGet(LibraryPackage.Literals.COMPONENT__METRIC_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getCapacityExpressionRef() {
		return (Expression)eGet(LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacityExpressionRef(Expression newCapacityExpressionRef) {
		eSet(LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF, newCapacityExpressionRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getUtilizationExpressionRef() {
		return (Expression)eGet(LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilizationExpressionRef(Expression newUtilizationExpressionRef) {
		eSet(LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF, newUtilizationExpressionRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Tolerance> getToleranceRefs() {
		return (EList<Tolerance>)eGet(LibraryPackage.Literals.COMPONENT__TOLERANCE_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Protocol> getProtocolRefs() {
		return (EList<Protocol>)eGet(LibraryPackage.Literals.COMPONENT__PROTOCOL_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Parameter> getParameterRefs() {
		return (EList<Parameter>)eGet(LibraryPackage.Literals.COMPONENT__PARAMETER_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NetXResource> getAllResources() {
		return (EList<NetXResource>)eGet(LibraryPackage.Literals.COMPONENT__ALL_RESOURCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<DiagramInfo> getDiagrams() {
		return (EList<DiagramInfo>)eGet(LibraryPackage.Literals.COMPONENT__DIAGRAMS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiImage getIcons() {
		return (MultiImage)eGet(LibraryPackage.Literals.COMPONENT__ICONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcons(MultiImage newIcons) {
		eSet(LibraryPackage.Literals.COMPONENT__ICONS, newIcons);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(LibraryPackage.Literals.COMPONENT__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(LibraryPackage.Literals.COMPONENT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(LibraryPackage.Literals.COMPONENT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(LibraryPackage.Literals.COMPONENT__NAME, newName);
	}

} //ComponentImpl
