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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage
 * @generated
 */
public interface SchedulingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchedulingFactory eINSTANCE = com.netxforge.netxstudio.scheduling.impl.SchedulingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Analyzer Job</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Analyzer Job</em>'.
	 * @generated
	 */
	AnalyzerJob createAnalyzerJob();

	/**
	 * Returns a new object of class '<em>Component Failure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Failure</em>'.
	 * @generated
	 */
	ComponentFailure createComponentFailure();

	/**
	 * Returns a new object of class '<em>Component Work Flow Run</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Work Flow Run</em>'.
	 * @generated
	 */
	ComponentWorkFlowRun createComponentWorkFlowRun();

	/**
	 * Returns a new object of class '<em>Expression Failure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Failure</em>'.
	 * @generated
	 */
	ExpressionFailure createExpressionFailure();

	/**
	 * Returns a new object of class '<em>Job</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Job</em>'.
	 * @generated
	 */
	Job createJob();

	/**
	 * Returns a new object of class '<em>Job Run Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Job Run Container</em>'.
	 * @generated
	 */
	JobRunContainer createJobRunContainer();

	/**
	 * Returns a new object of class '<em>Metric Source Job</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metric Source Job</em>'.
	 * @generated
	 */
	MetricSourceJob createMetricSourceJob();

	/**
	 * Returns a new object of class '<em>Reporter Job</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reporter Job</em>'.
	 * @generated
	 */
	ReporterJob createReporterJob();

	/**
	 * Returns a new object of class '<em>RFS Service Job</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>RFS Service Job</em>'.
	 * @generated
	 */
	RFSServiceJob createRFSServiceJob();

	/**
	 * Returns a new object of class '<em>RFS Service Retention Job</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>RFS Service Retention Job</em>'.
	 * @generated
	 */
	RFSServiceRetentionJob createRFSServiceRetentionJob();

	/**
	 * Returns a new object of class '<em>Work Flow Run</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Work Flow Run</em>'.
	 * @generated
	 */
	WorkFlowRun createWorkFlowRun();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SchedulingPackage getSchedulingPackage();

} //SchedulingFactory
