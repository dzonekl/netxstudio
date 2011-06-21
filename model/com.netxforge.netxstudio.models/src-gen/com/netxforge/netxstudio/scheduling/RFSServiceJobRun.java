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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>RFS Service Job Run</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A job run result with RFSService specific data.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.RFSServiceJobRun#getComponentRefs <em>Component Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getRFSServiceJobRun()
 * @model extendedMetaData="name='RFSServiceJobRun' kind='elementOnly'"
 * @generated
 */
public interface RFSServiceJobRun extends JobRun {
	/**
	 * Returns the value of the '<em><b>Component Refs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to the component for which the computation failed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Component Refs</em>' reference list.
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getRFSServiceJobRun_ComponentRefs()
	 * @model extendedMetaData="kind='element' name='ComponentRefs'"
	 * @generated
	 */
	EList<EObject> getComponentRefs();

} // RFSServiceJobRun
