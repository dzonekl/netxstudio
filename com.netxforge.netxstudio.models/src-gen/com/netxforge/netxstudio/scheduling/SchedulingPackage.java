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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 * 		
 * 
 * 
 * 			Network Data schema Copyright 2008 The schema uses
 * 			ecore
 * 			references syntax, but should easily map into an SQL schema.
 * 			The
 * 			ecore
 * 			references, are mapped into ORM specific DLL (See
 * 			Hibernate or
 * 			other
 * 			ORM. EMF/Hibernate
 * 			however uses a custom mechanism.
 * 
 * 			Don't use
 * 			the
 * 			word
 * 			"Item", as this is appended to the Object
 * 			name in the EMF
 * 			edit
 * 			model.
 * 			
 * 			Validation with pattern is not used, considering the limited capabilities of XSD patterns. 
 * 			
 * 		
 * 
 * 
 * 			Network Data schema Copyright 2008 The schema uses
 * 			ecore
 * 			references syntax, but should easily map into an SQL schema.
 * 			The
 * 			ecore
 * 			references, are mapped into ORM specific DLL (See
 * 			Hibernate or
 * 			other
 * 			ORM. EMF/Hibernate
 * 			however uses a custom mechanism.
 * 
 * 			Don't use
 * 			the
 * 			word
 * 			"Item", as this is appended to the Object
 * 			name in the EMF
 * 			edit
 * 			model.
 * 			
 * 			Validation with pattern is not used, considering the limited capabilities of XSD patterns. 
 * 			
 * 		
 * <!-- end-model-doc -->
 * @see com.netxforge.netxstudio.scheduling.SchedulingFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL' invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface SchedulingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scheduling";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.netxforge.com/13042011/scheduling";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "scheduling";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchedulingPackage eINSTANCE = com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.JobImpl <em>Job</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.JobImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJob()
	 * @generated
	 */
	int JOB = 0;

	/**
	 * The feature id for the '<em><b>Job Execution</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__JOB_EXECUTION = 0;

	/**
	 * The feature id for the '<em><b>Job Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__JOB_KIND = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__NAME = 2;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__START = 3;

	/**
	 * The number of structural features of the '<em>Job</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.impl.SchedulingImpl <em>Scheduling</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingImpl
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getScheduling()
	 * @generated
	 */
	int SCHEDULING = 1;

	/**
	 * The feature id for the '<em><b>Jobs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING__JOBS = 0;

	/**
	 * The number of structural features of the '<em>Scheduling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.scheduling.JobKinds <em>Job Kinds</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.JobKinds
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobKinds()
	 * @generated
	 */
	int JOB_KINDS = 2;

	/**
	 * The meta object id for the '<em>Job Kinds Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.scheduling.JobKinds
	 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobKindsObject()
	 * @generated
	 */
	int JOB_KINDS_OBJECT = 3;


	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.Job <em>Job</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Job</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Job
	 * @generated
	 */
	EClass getJob();

	/**
	 * Returns the meta object for the attribute list '{@link com.netxforge.netxstudio.scheduling.Job#getJobExecution <em>Job Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Job Execution</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Job#getJobExecution()
	 * @see #getJob()
	 * @generated
	 */
	EAttribute getJob_JobExecution();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.Job#getJobKind <em>Job Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Job Kind</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Job#getJobKind()
	 * @see #getJob()
	 * @generated
	 */
	EAttribute getJob_JobKind();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.Job#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Job#getName()
	 * @see #getJob()
	 * @generated
	 */
	EAttribute getJob_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.scheduling.Job#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Job#getStart()
	 * @see #getJob()
	 * @generated
	 */
	EAttribute getJob_Start();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.scheduling.Scheduling <em>Scheduling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Scheduling
	 * @generated
	 */
	EClass getScheduling();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.scheduling.Scheduling#getJobs <em>Jobs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Jobs</em>'.
	 * @see com.netxforge.netxstudio.scheduling.Scheduling#getJobs()
	 * @see #getScheduling()
	 * @generated
	 */
	EReference getScheduling_Jobs();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.scheduling.JobKinds <em>Job Kinds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Job Kinds</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobKinds
	 * @generated
	 */
	EEnum getJobKinds();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.scheduling.JobKinds <em>Job Kinds Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Job Kinds Object</em>'.
	 * @see com.netxforge.netxstudio.scheduling.JobKinds
	 * @model instanceClass="com.netxforge.netxstudio.scheduling.JobKinds"
	 *        extendedMetaData="name='JobKinds:Object' baseType='JobKinds'"
	 * @generated
	 */
	EDataType getJobKindsObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SchedulingFactory getSchedulingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.JobImpl <em>Job</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.JobImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJob()
		 * @generated
		 */
		EClass JOB = eINSTANCE.getJob();

		/**
		 * The meta object literal for the '<em><b>Job Execution</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__JOB_EXECUTION = eINSTANCE.getJob_JobExecution();

		/**
		 * The meta object literal for the '<em><b>Job Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__JOB_KIND = eINSTANCE.getJob_JobKind();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__NAME = eINSTANCE.getJob_Name();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__START = eINSTANCE.getJob_Start();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.impl.SchedulingImpl <em>Scheduling</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingImpl
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getScheduling()
		 * @generated
		 */
		EClass SCHEDULING = eINSTANCE.getScheduling();

		/**
		 * The meta object literal for the '<em><b>Jobs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULING__JOBS = eINSTANCE.getScheduling_Jobs();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.scheduling.JobKinds <em>Job Kinds</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.JobKinds
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobKinds()
		 * @generated
		 */
		EEnum JOB_KINDS = eINSTANCE.getJobKinds();

		/**
		 * The meta object literal for the '<em>Job Kinds Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.scheduling.JobKinds
		 * @see com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl#getJobKindsObject()
		 * @generated
		 */
		EDataType JOB_KINDS_OBJECT = eINSTANCE.getJobKindsObject();

	}

} //SchedulingPackage
