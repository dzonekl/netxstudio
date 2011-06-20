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

import com.netxforge.netxstudio.generics.DiagramInfo;
import com.netxforge.netxstudio.generics.MultiImage;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.Parameter;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.operators.FunctionRelationship;
import com.netxforge.netxstudio.protocols.Protocol;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getFunctionResources <em>Function Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getFunctionMetricRefs <em>Function Metric Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getFunctionRelationshipRefs <em>Function Relationship Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getUtilizationExpressionRef <em>Utilization Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getCapacityExpressionRef <em>Capacity Expression Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getToleranceRefs <em>Tolerance Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getProtocolRefs <em>Protocol Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getParameterRefs <em>Parameter Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getAllFunctionResources <em>All Function Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getAllFunctions <em>All Functions</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.FunctionImpl#getFunctionName <em>Function Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionImpl extends CDOObjectImpl implements Function {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.FUNCTION;
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
	public EList<DiagramInfo> getDiagrams() {
		return (EList<DiagramInfo>)eGet(LibraryPackage.Literals.FUNCTION__DIAGRAMS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiImage getIcons() {
		return (MultiImage)eGet(LibraryPackage.Literals.FUNCTION__ICONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcons(MultiImage newIcons) {
		eSet(LibraryPackage.Literals.FUNCTION__ICONS, newIcons);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Function> getFunctions() {
		return (EList<Function>)eGet(LibraryPackage.Literals.FUNCTION__FUNCTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NetXResource> getFunctionResources() {
		return (EList<NetXResource>)eGet(LibraryPackage.Literals.FUNCTION__FUNCTION_RESOURCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Metric> getFunctionMetricRefs() {
		return (EList<Metric>)eGet(LibraryPackage.Literals.FUNCTION__FUNCTION_METRIC_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FunctionRelationship> getFunctionRelationshipRefs() {
		return (EList<FunctionRelationship>)eGet(LibraryPackage.Literals.FUNCTION__FUNCTION_RELATIONSHIP_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getUtilizationExpressionRef() {
		return (Expression)eGet(LibraryPackage.Literals.FUNCTION__UTILIZATION_EXPRESSION_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilizationExpressionRef(Expression newUtilizationExpressionRef) {
		eSet(LibraryPackage.Literals.FUNCTION__UTILIZATION_EXPRESSION_REF, newUtilizationExpressionRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getCapacityExpressionRef() {
		return (Expression)eGet(LibraryPackage.Literals.FUNCTION__CAPACITY_EXPRESSION_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacityExpressionRef(Expression newCapacityExpressionRef) {
		eSet(LibraryPackage.Literals.FUNCTION__CAPACITY_EXPRESSION_REF, newCapacityExpressionRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Tolerance> getToleranceRefs() {
		return (EList<Tolerance>)eGet(LibraryPackage.Literals.FUNCTION__TOLERANCE_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Protocol> getProtocolRefs() {
		return (EList<Protocol>)eGet(LibraryPackage.Literals.FUNCTION__PROTOCOL_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Parameter> getParameterRefs() {
		return (EList<Parameter>)eGet(LibraryPackage.Literals.FUNCTION__PARAMETER_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NetXResource> getAllFunctionResources() {
		return (EList<NetXResource>)eGet(LibraryPackage.Literals.FUNCTION__ALL_FUNCTION_RESOURCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Function> getAllFunctions() {
		return (EList<Function>)eGet(LibraryPackage.Literals.FUNCTION__ALL_FUNCTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(LibraryPackage.Literals.FUNCTION__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(LibraryPackage.Literals.FUNCTION__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFunctionName() {
		return (String)eGet(LibraryPackage.Literals.FUNCTION__FUNCTION_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionName(String newFunctionName) {
		eSet(LibraryPackage.Literals.FUNCTION__FUNCTION_NAME, newFunctionName);
	}

} //FunctionImpl
