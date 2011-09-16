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
package com.netxforge.netxstudio.scheduling;

import com.netxforge.netxstudio.operators.Operator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator Reporter Job</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A job producing external format reports for a
 * 				service.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.OperatorReporterJob#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getOperatorReporterJob()
 * @model extendedMetaData="name='OperatorReporterJob' kind='elementOnly'"
 * @generated
 */
public interface OperatorReporterJob extends Job {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to the Operator for which the job
	 * 								runs.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operator</em>' reference.
	 * @see #setOperator(Operator)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getOperatorReporterJob_Operator()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='Operator'"
	 * @generated
	 */
	Operator getOperator();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.OperatorReporterJob#getOperator <em>Operator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' reference.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(Operator value);

} // OperatorReporterJob
