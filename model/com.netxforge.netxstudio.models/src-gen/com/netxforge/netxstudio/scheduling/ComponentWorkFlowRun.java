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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Work Flow Run</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A job run result with RFSService specific data.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun#getFailureRefs <em>Failure Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getComponentWorkFlowRun()
 * @model extendedMetaData="name='ComponentWorkFlowRun' kind='elementOnly'"
 * @generated
 */
public interface ComponentWorkFlowRun extends WorkFlowRun {
	/**
	 * Returns the value of the '<em><b>Failure Refs</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.scheduling.Failure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to information about failed
	 * 								expressions
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Failure Refs</em>' containment reference list.
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getComponentWorkFlowRun_FailureRefs()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='FailureRefs'"
	 * @generated
	 */
	EList<Failure> getFailureRefs();

} // ComponentWorkFlowRun
