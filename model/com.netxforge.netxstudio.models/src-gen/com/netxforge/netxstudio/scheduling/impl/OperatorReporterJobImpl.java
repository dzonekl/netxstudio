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
package com.netxforge.netxstudio.scheduling.impl;

import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.scheduling.OperatorReporterJob;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator Reporter Job</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.OperatorReporterJobImpl#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorReporterJobImpl extends JobImpl implements OperatorReporterJob {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorReporterJobImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.OPERATOR_REPORTER_JOB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator getOperator() {
		return (Operator)eGet(SchedulingPackage.Literals.OPERATOR_REPORTER_JOB__OPERATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(Operator newOperator) {
		eSet(SchedulingPackage.Literals.OPERATOR_REPORTER_JOB__OPERATOR, newOperator);
	}

} //OperatorReporterJobImpl
